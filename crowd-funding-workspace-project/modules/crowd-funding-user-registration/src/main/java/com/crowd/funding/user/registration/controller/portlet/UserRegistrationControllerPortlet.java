package com.crowd.funding.user.registration.controller.portlet;

import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.user.registration.controller.constants.CrowdFundingMail;
import com.crowd.funding.user.registration.controller.constants.UserRegistrationControllerPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
/*import com.crowd.funding.db.service.controller.model.UserRegistration;
import com.crowd.funding.db.service.controller.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.user.registration.controller.constants.UserRegistrationControllerPortletKeys;*/
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-016
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=Crowd Funding",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.display-name=User Registration",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/OTPAuthenticationForm.jsp",
	        "javax.portlet.name=User Registration",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)


public class UserRegistrationControllerPortlet extends MVCPortlet {
	
	public void emailMobileRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			String email = actionRequest.getParameter("email");
			String mobileNo = actionRequest.getParameter("mobileNo");
			
			Date date = new Date();
			
			long otpId = 0;
			UserOTPRegistration otpRegistration = null;
			otpId = CounterLocalServiceUtil.increment(UserOTPRegistration.class.getName());
			otpRegistration = UserOTPRegistrationLocalServiceUtil.createUserOTPRegistration(otpId);
			
			Random rnd = new Random();
		    int otpNumber = rnd.nextInt(999999);
		    
		    otpRegistration.setMAIL_ADDRESS(email);
		    otpRegistration.setMOBILE_NO(Long.parseLong(mobileNo));
		    otpRegistration.setOTP(otpNumber);
		    otpRegistration.setCREATION_DATE_TIME(date);
		    
		    UserOTPRegistrationLocalServiceUtil.addUserOTPRegistration(otpRegistration);
		    
		    String mailSubject = "Crowd Funding - Registration OTP";
		    String mailBody = "Dear User," + "\n\nYour One Time Password is " +
		    		otpNumber +". It is valid for 5 minutes for Crowd Funding login for your account associated with Mobile Number "+ mobileNo +"\n\n\nThank You For Visiting Crowd Funding.";
		    
		    CrowdFundingMail.sendMail(mailSubject, mailBody, email);
		    
		    actionResponse.setRenderParameter("mobileNo", mobileNo);
		    actionResponse.setRenderParameter("jspPage", "/jsp/OTPValidation.jsp");
		    
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public void otpAuthentication(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			String mobileNo = actionRequest.getParameter("mobileNo");
			String emailOtp = actionRequest.getParameter("emailOtp");
			String mobileOtp = actionRequest.getParameter("mobileOtp");
			
			int emailOtpStatus = 0, mobileOtpStatus = 0;
			
			UserOTPRegistration otpObj = UserOTPRegistrationLocalServiceUtil.findByMOBILE_NO(Long.parseLong(mobileNo));
			
			if(otpObj.getOTP() == 0) {
				SessionErrors.add(actionRequest, "otp-expired-error-key");
			}
			
			if(otpObj.getOTP() == Integer.parseInt(emailOtp)) {
				emailOtpStatus = 1;
			}else {
				emailOtpStatus = 0;
			}
			
			if(otpObj.getOTP() == Integer.parseInt(mobileOtp)) {
				mobileOtpStatus = 1;
			}else {
				mobileOtpStatus = 0;
			}
			
			if(emailOtpStatus == 1 && mobileOtpStatus == 1) {
				otpObj.setMAIL_VERIFICATION(emailOtpStatus);
				otpObj.setSMS_VERIFICATION(mobileOtpStatus);
				
				UserOTPRegistrationLocalServiceUtil.updateUserOTPRegistration(otpObj);
				
				actionResponse.setRenderParameter("UserOtpId", String.valueOf(otpObj.getUSER_OTP_ID()));
			    actionResponse.setRenderParameter("jspPage", "/jsp/UserRegistrationForm.jsp");
			}else {
				SessionErrors.add(actionRequest, "error-key");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public void reSemdOtpRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			String mobileNo = ParamUtil.getString(actionRequest, "mobileNo");
			UserOTPRegistration otpObj = UserOTPRegistrationLocalServiceUtil.findByMOBILE_NO(Long.parseLong(mobileNo));
			
			Random rnd = new Random();
		    int otpNumber = rnd.nextInt(999999);
		    
		    otpObj.setOTP(otpNumber);
		    UserOTPRegistrationLocalServiceUtil.updateUserOTPRegistration(otpObj);
		    
		    String mailSubject = "Crowd Funding - Registration OTP";
		    String mailBody = "Dear User," + "\n\nYour One Time Password is " +
		    		otpNumber +". It is valid for 5 minutes for Crowd Funding login for your account associated with Mobile Number "+ mobileNo +"\n\n\nThank You For Visiting Crowd Funding.";
		    
		    CrowdFundingMail.sendMail(mailSubject, mailBody, otpObj.getMAIL_ADDRESS());
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void userRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			String firstName = actionRequest.getParameter("firstName");
			String lastName = actionRequest.getParameter("lastName");
			String UserOtpId = actionRequest.getParameter("UserOtpId");
			
			String fullname = null;
			fullname = firstName + " " + lastName;
			String password = actionRequest.getParameter("password");
			String gender = actionRequest.getParameter("gender");
			Date creationDate=java.util.Calendar.getInstance().getTime();
			
			UserOTPRegistration otpObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(Long.parseLong(UserOtpId));
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User farmerUser = UserLocalServiceUtil.addUser(0, PortalUtil.getDefaultCompanyId(), false, password, password, false, 
					firstName+"User", otpObj.getMAIL_ADDRESS(), 0L, "", themeDisplay.getLocale(), firstName, "", lastName, 0, 0, false,
					10, 1, 1970, "", null, null, null, null, false, new ServiceContext());
			
			
			long UserId = farmerUser.getUserId();
			UserRegistration userRegistration = null;
			userRegistration = UserRegistrationLocalServiceUtil.createUserRegistration(UserId);
			
			userRegistration.setUSER_OTP_ID(Long.parseLong(UserOtpId));
			userRegistration.setFULL_NAME(fullname);
			userRegistration.setGENDER(gender);
			userRegistration.setCREATION_DATE(creationDate);
			
			UserRegistrationLocalServiceUtil.addUserRegistration(userRegistration);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}