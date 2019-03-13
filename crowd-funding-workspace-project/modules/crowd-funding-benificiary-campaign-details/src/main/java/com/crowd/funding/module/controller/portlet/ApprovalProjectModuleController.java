package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.ProjectPriorityRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.UserFollowRegistration;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserFollowRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.crowd.funding.module.controller.constants.CrowdFundingMail;
import com.crowd.funding.module.controller.constants.SendNotificationToUserHandler;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

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
		"javax.portlet.display-name=Campaign Approval",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/BenificiaryDetails/ApproveList.jsp",
		"javax.portlet.name=Campaign Approval",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class ApprovalProjectModuleController extends MVCPortlet {
	
	public void adminProjectContent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
							/*CAMPAIGN APPROVAL*/
			long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
			/*try {
				
				String enddate = actionRequest.getParameter("enddate");
			
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date date =  formatter.parse(enddate);
				projectRegistration.setEND_DATE(date);
			
			} catch (Exception e) {
				
			}*/
			
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			String mailSubject = "Crowd Funding - Campaign Approved";
			String mailBody = "Dear User," + "\n\nYour Campaign " +
					projectRegistration.getTITLE() +" is Approved. You can check your Campaign in the site.";

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL_ADDRESS());	
			
								/*CAMPAIGN PRIORITY*/
			
			ProjectPriorityRegistration priorityRegistration = null;
			long priorityID = 0;
			priorityID = CounterLocalServiceUtil.increment(ProjectPriorityRegistration.class.getName());
			priorityRegistration = ProjectPriorityRegistrationLocalServiceUtil.createProjectPriorityRegistration(priorityID);
			
			priorityRegistration.setPROJECT_ID(projectRegistration.getPROJECT_ID());
			priorityRegistration.setPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_0);
			
			ProjectPriorityRegistrationLocalServiceUtil.addProjectPriorityRegistration(priorityRegistration);
			
								/*USER FOLLOWER*/
			
			List<UserFollowRegistration> followerUserList = UserFollowRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			
			for(UserFollowRegistration followerObj : followerUserList) {
				
				try {
				
				ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
				
				
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("userId", followerObj.getFOLLOWER_USER_ID());
					jsonObject.put("senderName", userObj.getFULL_NAME());
					jsonObject.put("notificationText", " has started new Compaign, " + projectRegistration.getTITLE() + ".");
					
					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(followerObj.getFOLLOWER_USER_ID(), SendNotificationToUserHandler.PORTLET_ID,
							(new java.util.Date()).getTime(), 10002, followerObj.getFOLLOWER_USER_ID(), jsonObject.toString(), false, serviceContext);
			
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public void RejectDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
		
			long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			String mailSubject = "Crowd Funding - Campaign Rejection";
			String mailBody = "Dear User," + "\n\nYour Campaign " +
					projectRegistration.getTITLE() +" is Rejected.";

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL_ADDRESS());	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
