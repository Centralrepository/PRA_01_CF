package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.exception.NoSuchCommentRegistrationException;
import com.crowd.funding.database.model.CommentRegistration;
import com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

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
		"javax.portlet.display-name=Comment Approval",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/Comment Details/AdminApproval.jsp",
		"javax.portlet.name=Comment Approval",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class CommentApproval extends MVCPortlet {

	
	public void commentAnswer(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NoSuchCommentRegistrationException {
		
		long commentID = Long.parseLong(actionRequest.getParameter("commentID"));
		String answer = actionRequest.getParameter("answer");
		
		CommentRegistration answerData = CommentRegistrationLocalServiceUtil.findByPROJECT_COMMENT_ID(commentID);
		
		answerData.setANSWER(answer);
		answerData.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_1);
		
		CommentRegistrationLocalServiceUtil.updateCommentRegistration(answerData);
		
	}
	
	public void commentReject(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NoSuchCommentRegistrationException {
		
		long commentID = Long.parseLong(actionRequest.getParameter("commentID"));
		
		CommentRegistration answerData = CommentRegistrationLocalServiceUtil.findByPROJECT_COMMENT_ID(commentID);
		
		answerData.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_2);
		
		CommentRegistrationLocalServiceUtil.updateCommentRegistration(answerData);
		
	}

}
