package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.exception.NoSuchCommentRegistrationException;
import com.crowd.funding.database.model.CommentRegistration;
import com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;


/**
 * @author Prakat-D-008
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CrowdFundingDetails",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Comment2",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/Comment Details/CommentDetails.jsp",
		"javax.portlet.name=Comment2",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class CommentDetailsController extends MVCPortlet {
	
	public void commentDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
		String commentData = actionRequest.getParameter("commentData");
		SimpleDateFormat sd = new SimpleDateFormat(
	            "yyyy.MM.dd G HH:mm:ss z");
	    Date date = new Date();
	    
	    ThemeDisplay td  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    User currentuserData = td.getUser();
	    System.out.println("currentuserData : "+currentuserData);
	    CommentRegistration commentRegistration = null;
	    long commentID = 0;
	    
	    commentID = CounterLocalServiceUtil.increment(CommentRegistration.class.getName());
	    commentRegistration = CommentRegistrationLocalServiceUtil.createCommentRegistration(commentID);
	    
	    commentRegistration.setCOMMENT(commentData);
	    commentRegistration.setCOMMENT_DATE(date);
	    commentRegistration.setPROJECT_ID(projectID);
	    commentRegistration.setDONOR_USER_ID(currentuserData.getUserId());
	    commentRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_0);
	    
	    CommentRegistrationLocalServiceUtil.addCommentRegistration(commentRegistration);
		
	}
	
	
}
