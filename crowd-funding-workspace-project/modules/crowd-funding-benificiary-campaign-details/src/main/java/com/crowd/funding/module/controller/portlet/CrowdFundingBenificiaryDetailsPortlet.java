package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException;
import com.crowd.funding.database.exception.NoSuchUserRegistrationException;
import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.crowd.funding.module.controller.constants.CrowdFundingMail;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
		"javax.portlet.display-name=Fundraiser",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/BenificiaryDetails/BenificiaryCategory.jsp",
		"javax.portlet.name=Fundraiser",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CrowdFundingBenificiaryDetailsPortlet extends MVCPortlet {
	
	public void BenificiaryRelationMyself(ActionRequest actionRequest, ActionResponse actionResponse)
			 {
		try {
		ThemeDisplay td  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		UserRegistration userData = UserRegistrationLocalServiceUtil.findByUSER_ID(td.getUserId());
		
		UserOTPRegistration userOtpObj = UserOTPRegistrationLocalServiceUtil.fetchUserOTPRegistration(userData.getUSER_OTP_ID());
		
		
		int age = Integer.parseInt(actionRequest.getParameter("age"));
		String location = actionRequest.getParameter("location");
		String name = actionRequest.getParameter("name");
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("image");
		OutputBlob outputBlobDocuments=null;
		InputStream inputStream = new FileInputStream(file);
		outputBlobDocuments = new OutputBlob(inputStream, file.length());
		
		BenificiaryRegistration benificiaryRegistration = null;
		long b_id = 0;
		b_id = CounterLocalServiceUtil.increment(BenificiaryRegistration.class.getName());
		benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.createBenificiaryRegistration(b_id);
		
		benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself);
		benificiaryRegistration.setLOCATION(location);
		benificiaryRegistration.setBENIFICIARY_NAME(name);
		benificiaryRegistration.setIMAGE(outputBlobDocuments);
		benificiaryRegistration.setIMAGE_TYPE(MimeTypesUtil.getContentType(file));
		benificiaryRegistration.setAGE(age);
		benificiaryRegistration.setGENDER(userData.getGENDER());
		benificiaryRegistration.setCONTACT_NAME(userData.getFULL_NAME());
		benificiaryRegistration.setCONTACT_NO(userOtpObj.getMOBILE_NO());
		
		BenificiaryRegistrationLocalServiceUtil.addBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/CauseDetails.jsp");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void BenificiaryRelationGroup(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
	
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("image");
		OutputBlob outputBlobDocuments=null;
		InputStream inputStream = new FileInputStream(file);
		outputBlobDocuments = new OutputBlob(inputStream, file.length());
		
		String Group = actionRequest.getParameter("Group");
		
		String groupName = actionRequest.getParameter("groupName");
		int member = Integer.parseInt(actionRequest.getParameter("member"));
		String location = actionRequest.getParameter("location");
		String name = actionRequest.getParameter("name");
		long number = Long.parseLong(actionRequest.getParameter("number"));

		BenificiaryRegistration benificiaryRegistration = null;
		long b_id = 0;
		
		b_id = CounterLocalServiceUtil.increment(BenificiaryRegistration.class.getName());
		benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.createBenificiaryRegistration(b_id);
		
		if(Group.equalsIgnoreCase("FriendGroup")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Friend);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Group);
			
		}else if(Group.equalsIgnoreCase("OtherGroup")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Other);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Group);
			
		}if(Group.equalsIgnoreCase("FamilyGroup")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Family);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Group);
			
		}
		benificiaryRegistration.setBENIFICIARY_NAME(groupName);
		benificiaryRegistration.setMEMBERS_NO(member);
		benificiaryRegistration.setCONTACT_NAME(name);
		benificiaryRegistration.setCONTACT_NO(number);
		benificiaryRegistration.setLOCATION(location);
		benificiaryRegistration.setIMAGE(outputBlobDocuments);
		benificiaryRegistration.setIMAGE_TYPE(MimeTypesUtil.getContentType(file));
		
		BenificiaryRegistrationLocalServiceUtil.addBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/CauseDetails.jsp");
	}
	
	public void BenificiaryRelationIndividual(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("image");
		OutputBlob outputBlobDocuments=null;
		InputStream inputStream = new FileInputStream(file);
		outputBlobDocuments = new OutputBlob(inputStream, file.length());
		
		String Individual = actionRequest.getParameter("Individual");
		
		int age = Integer.parseInt(actionRequest.getParameter("age"));
		String Gender = actionRequest.getParameter("Gender");
		String location = actionRequest.getParameter("location");
		String name = actionRequest.getParameter("name");
		long number = Long.parseLong(actionRequest.getParameter("number"));

		BenificiaryRegistration benificiaryRegistration = null;
		long b_id = 0;
		
		b_id = CounterLocalServiceUtil.increment(BenificiaryRegistration.class.getName());
		benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.createBenificiaryRegistration(b_id);
		
		if(Individual.equalsIgnoreCase("FriendIndividual")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Friend);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual);
			
		}else if(Individual.equalsIgnoreCase("OtherIndividual")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Other);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual);
			
		}
		benificiaryRegistration.setAGE(age);
		benificiaryRegistration.setGENDER(Gender);
		benificiaryRegistration.setBENIFICIARY_NAME(name);
		benificiaryRegistration.setCONTACT_NO(number);
		benificiaryRegistration.setLOCATION(location);
		benificiaryRegistration.setIMAGE(outputBlobDocuments);
		benificiaryRegistration.setIMAGE_TYPE(MimeTypesUtil.getContentType(file));
		
		BenificiaryRegistrationLocalServiceUtil.addBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/CauseDetails.jsp");
	}
	
	public void BenificiaryRelationIndividualFamily(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("image");
		OutputBlob outputBlobDocuments=null;
		InputStream inputStream = new FileInputStream(file);
		outputBlobDocuments = new OutputBlob(inputStream, file.length());
		
		String location = actionRequest.getParameter("location");
		String Relationship = actionRequest.getParameter("Relationship");
		String RelationshipDetails = actionRequest.getParameter("RelationshipDetails");
		int age = Integer.parseInt(actionRequest.getParameter("age"));
		String Gender = actionRequest.getParameter("Gender");
		String name = actionRequest.getParameter("name");
		String contectName = actionRequest.getParameter("contectName");
		long number = Long.parseLong(actionRequest.getParameter("number"));
		
		BenificiaryRegistration benificiaryRegistration = null;
		long b_id = 0;
		
		b_id = CounterLocalServiceUtil.increment(BenificiaryRegistration.class.getName());
		benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.createBenificiaryRegistration(b_id);
		
		benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Family);
		benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual);
		benificiaryRegistration.setAGE(age);
		benificiaryRegistration.setRELATIONSHIP(Relationship);
		benificiaryRegistration.setRELATIONSHIP_DETAILS(RelationshipDetails);
		benificiaryRegistration.setGENDER(Gender);
		benificiaryRegistration.setBENIFICIARY_NAME(name);
		benificiaryRegistration.setCONTACT_NAME(contectName);
		benificiaryRegistration.setCONTACT_NO(number);
		benificiaryRegistration.setLOCATION(location);
		benificiaryRegistration.setIMAGE(outputBlobDocuments);
		benificiaryRegistration.setIMAGE_TYPE(MimeTypesUtil.getContentType(file));
		
		BenificiaryRegistrationLocalServiceUtil.addBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/CauseDetails.jsp");
	}
	
	public void causeData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
		long benificiaryID = Long.parseLong(actionRequest.getParameter("benificiaryID"));
		String btn = actionRequest.getParameter("btn");
		
		BenificiaryRegistration benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(benificiaryID);
		
		benificiaryRegistration.setCAUSE_DETAILS(btn);
		
		BenificiaryRegistrationLocalServiceUtil.updateBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/BenificiaryDetails.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void BenificiaryDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NoSuchBenificiaryRegistrationException {
		
		String addressline1 = actionRequest.getParameter("addressline1");
		String addressline2 = actionRequest.getParameter("addressline2");
		String Country = actionRequest.getParameter("Country");
		String state = actionRequest.getParameter("state");
		String city = actionRequest.getParameter("city");
		String emergencyContact = actionRequest.getParameter("emergencyContact");
		int pincode = Integer.parseInt(actionRequest.getParameter("pincode"));
		long emergencyContactNumber = Long.parseLong(actionRequest.getParameter("emergencyContactNumber"));
		long benificiaryID = Long.parseLong(actionRequest.getParameter("benificiaryID"));
		
		BenificiaryRegistration benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(benificiaryID);
		
		benificiaryRegistration.setADDRESS_LINE1(addressline1);
		benificiaryRegistration.setADDRESS_LINE2(addressline2);
		benificiaryRegistration.setCOUNTRY(Country);
		benificiaryRegistration.setSTATE(state);
		benificiaryRegistration.setCITY(city);
		benificiaryRegistration.setPINCODE(pincode);
		benificiaryRegistration.setEMERGENCY_CONTACT_DETAILS(emergencyContact);
		benificiaryRegistration.setALTERNATE_CONTACT_NO(emergencyContactNumber);
		
		BenificiaryRegistrationLocalServiceUtil.updateBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/ProjectRegistration.jsp");
	}
	
	public void ProjectRegistrationDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		try {
			
			long userID = Long.parseLong(actionRequest.getParameter("userID"));
			long benificiaryID = Long.parseLong(actionRequest.getParameter("benificiaryID"));
			String title = actionRequest.getParameter("title");
			String description = actionRequest.getParameter("description");
			String requiredFundAmt = actionRequest.getParameter("requiredFundAmt");
			
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			String enddate = actionRequest.getParameter("enddate");
			java.util.Date closeDate =  sd.parse(enddate);
		        Date date = new Date();
			
			/*------------------------------------------------- Project Registration --------------------------------------------------------------------------------------*/
			
			ProjectRegistration projectRegistration = null;
			long projectID = 0;
			
			projectID = CounterLocalServiceUtil.increment(ProjectRegistration.class.getName());
			projectRegistration = ProjectRegistrationLocalServiceUtil.createProjectRegistration(projectID);
			
			projectRegistration.setUSER_ID(userID);
			projectRegistration.setBENIFICIARY_ID(benificiaryID);
			projectRegistration.setTITLE(title);
			projectRegistration.setDESCRIPTION(description);
			projectRegistration.setREQUIRED_FUND_AMOUNT(Long.parseLong(requiredFundAmt));
			projectRegistration.setCREATION_DATE(date);
			projectRegistration.setEND_DATE(closeDate);
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0);
			
			ProjectRegistrationLocalServiceUtil.addProjectRegistration(projectRegistration);
			
			String documentRowlevelIndexes = actionRequest.getParameter("documentIndex");
	        String[] indexOfRowsDocument = documentRowlevelIndexes.split(",");
	        
			UploadPortletRequest uploadRequestDocument = PortalUtil.getUploadPortletRequest(actionRequest);
			File documentFile;
			OutputBlob outputBlobDocuments=null;
			InputStream inputStreamDocument;
			DocumentRegistration documentRegistration = null;
			long document_id=0;
			String documentName;
			
			 for(int i=0;i<indexOfRowsDocument.length;i++){
				 	documentName = actionRequest.getParameter("documentName"+indexOfRowsDocument[i].trim());
		        	documentFile = uploadRequestDocument.getFile("documentFile"+indexOfRowsDocument[i].trim());
		        	if(documentFile.exists()==true){
		        		inputStreamDocument = new FileInputStream(documentFile);
		        		outputBlobDocuments = new OutputBlob(inputStreamDocument, documentFile.length());
			    		
		        		document_id=CounterLocalServiceUtil.increment(DocumentRegistration.class.getName());
			    		documentRegistration=DocumentRegistrationLocalServiceUtil.createDocumentRegistration(document_id);
			    		
			    		documentRegistration.setPROJECT_ID(projectRegistration.getPROJECT_ID());
			    		documentRegistration.setDOCUMENT(outputBlobDocuments);
			    		documentRegistration.setDOCUMENT_TYPE(MimeTypesUtil.getContentType(documentFile));
			    		documentRegistration.setDOCUMENT_NAME(documentName);
			    		
			    		DocumentRegistrationLocalServiceUtil.addDocumentRegistration(documentRegistration);
		        	} 
		        }
			
			 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(userID);
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			 String mailSubject = "Crowd Funding - Campaign Registaration";
			    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYour campaign for " +
			    		title +" sucessfully posted on crowd funding portal." +"\n\n\nThank You For Visiting Crowd Funding.";

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL_ADDRESS());
			
			
			actionResponse.setRenderParameter("projectID", String.valueOf(projectRegistration.getPROJECT_ID()));
			actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/ProjectSucessfully.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}