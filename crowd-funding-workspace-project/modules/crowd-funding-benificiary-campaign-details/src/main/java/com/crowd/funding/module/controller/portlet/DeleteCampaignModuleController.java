package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.crowd.funding.module.controller.constants.CrowdFundingMail;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-016
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=CrowdFundingDetails",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.display-name=Delete Request",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/DeleteCampaign/AdminDeleteCampaignTab.jsp",
	        "javax.portlet.name=Delete Request",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class DeleteCampaignModuleController extends MVCPortlet {
	
	
	public void deleteCampaign(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			long ProjectId = Long.parseLong(actionRequest.getParameter("ProjectId"));
			
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
			
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5);
			
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			 String mailSubject = "Crowd Funding - Delete Campaign";
			    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYour campaign for " +
			    		projectRegistration.getTITLE() +" is deleted on crowd funding portal." +"\n\n\nThank You For Visiting Crowd Funding.";

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL_ADDRESS());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
