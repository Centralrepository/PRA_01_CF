package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.FundRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.crowd.funding.module.controller.constants.CrowdFundingMail;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	        "javax.portlet.display-name=Fund Request",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/FundRequestWithdraw/AdminFundRequestTab.jsp",
	        "javax.portlet.name=Fund Request",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class FundRequestModuleController extends MVCPortlet {
	
	
	public void approveFundRequestWithdraw(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			long ProjectId = Long.parseLong(actionRequest.getParameter("ProjectId"));
			
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
			BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
			 User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_7);
			
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			double totalDonatedAmt = 0;
			double remainingAmt = 0;
			double processingFees = 0;
			double paymentCharges = 0;
			double totalAmt = 0;
			List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
			for(FundRegistration fundAmtObj : fundAmtList){
				double donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
				totalDonatedAmt = totalDonatedAmt + donatedAmt;
				remainingAmt = donatedAmt - totalDonatedAmt;
			}
			
			processingFees = (6*totalDonatedAmt)/100;
			paymentCharges = (2*totalDonatedAmt)/100;
			totalAmt = totalDonatedAmt - (processingFees + paymentCharges);
			
			/*--------------------------------------------------Price In words convert-----------------------------------------------------------*/
			
			PriceConversion priceConversion= new PriceConversion();
			String str= Double.toString(totalAmt);

			String [] strArr= str.split("\\.");

			String strBeforeDec= strArr[0];
			String strAfterDec= strArr[1];
			String strUpto2Decimal="";

			if (strAfterDec.length()>2) {
				strUpto2Decimal=strAfterDec.substring(0,2);
			}else{
				strUpto2Decimal=strAfterDec.substring(0,1);
			}

			int beforeDecimal= Integer.parseInt(strBeforeDec);
			String outBeforeDec= priceConversion.convertNumberToWords(beforeDecimal);

			 String outAfterDec= "";
			 int afterDecimal=0;
			 
			 if (strUpto2Decimal.length()>1) {
				   afterDecimal= Integer.parseInt(strUpto2Decimal);
				   outAfterDec= " and "+priceConversion.convertNumberToWords(afterDecimal)+ " Paise";;
			   }else {
				   String output= priceConversion.getAfterDec(Integer.parseInt(strUpto2Decimal));
				   if (output.length()>0) {
					   outAfterDec= " and "+ output+ " Paise";
				   }else {
					   outAfterDec="";
				   }
			   }
			 String doubleToStr=outBeforeDec.toUpperCase()+" Rupees ".toUpperCase()+ outAfterDec.toUpperCase()+" Only".toUpperCase();
			
			/*--------------------------------------------------Document Creation-----------------------------------------------------------*/
			/* 
			Document document = new Document();
			document.addTitle("CrowdFundingInvoice");
	        document.setPageSize(PageSize.A4);
			
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("CrowdFunding_Receipt.pdf"));
			document.open();
			
			String benificiaryAddress = "Name : "+benificiaryObj.getBENIFICIARY_NAME()+"\n Address: "+benificiaryObj.getADDRESS_LINE1()+", \n "+benificiaryObj.getADDRESS_LINE2()+", \n"+benificiaryObj.getCITY()+",\n"+benificiaryObj.getSTATE()+" - "+benificiaryObj.getPINCODE();
			 
			PdfPTable table = new PdfPTable(2); // 2 columns.
	        table.setWidthPercentage(100); //Width 100%
	        table.setSpacingBefore(10f); //Space before table
	        table.setSpacingAfter(10f); //Space after table 
	        
	        Font fontTitle = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
            fontTitle.setColor(0, 0, 155);
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font fontDetails = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
            
            --------------------------------------------------Adddress And Logo-----------------------------------------------------------
	       
            Paragraph benificiaryAddressParagraph = new Paragraph(benificiaryAddress,boldFont);
	        benificiaryAddressParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(benificiaryAddressParagraph);
	        
            --------------------------------------------------Invoice No. And Booking Date and id----------------------------------------- 
           
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date currentDate = new Date();
            String invoiceData = "Invoice Number: "+ProjectId+"\n Required Fund Amount: "+projectRegistration.getREQUIRED_FUND_AMOUNT()+"\n Mob: "+benificiaryObj.getCONTACT_NO()+"\n Email: "+userData.getEmailAddress()+"\n Date: "+formatter.format(currentDate);
           
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));
            Paragraph invoiceNo=new Paragraph(invoiceData,boldFont);
            invoiceNo.setAlignment(Element.ALIGN_LEFT);
            
            document.add(invoiceNo);
            
            --------------------------------------------------------Project Title----------------------------------------------------- 
            
            document.add(new Paragraph("\n"));
	        document.add(new Paragraph("\n"));
	        
	        PdfPTable prodTitle = new PdfPTable(2);
            PdfPCell prodTitleCell;
            // first row
            // column 1
            prodTitleCell = new PdfPCell(new Phrase("Title",boldFont));
            prodTitle.addCell(prodTitleCell);
            // column 2
            prodTitleCell = new PdfPCell(new Phrase("Amount",boldFont));
            prodTitle.addCell(prodTitleCell);
            
            document.add(prodTitle);
            
            --------------------------------------------------------Project Detail Data-----------------------------------------------
            
            PdfPTable prodData = new PdfPTable(2);
            PdfPCell prodDataCell;
            // first row
            // column 1
            prodDataCell = new PdfPCell(new Phrase(projectRegistration.getTITLE(),fontDetails));
            prodData.addCell(prodDataCell);
            // column 2
            prodDataCell = new PdfPCell(new Phrase(String.valueOf(Math.floor(totalAmt)),fontDetails));
            prodData.addCell(prodDataCell);
            
            document.add(prodData);
            
            --------------------------------------------------------Total Amount Detail-----------------------------------------------
            
            PdfPTable prodAmt = new PdfPTable(2);
            PdfPCell prodAmtCell;
            // first row
            // column 1
            prodAmtCell = new PdfPCell(new Phrase("Total Amount",fontDetails));
            prodAmt.addCell(prodAmtCell);
            // column 2
            prodAmtCell = new PdfPCell(new Phrase(String.valueOf(Math.floor(totalAmt)),fontDetails));
            prodAmt.addCell(prodAmtCell);
            
            document.add(prodAmt);
            
            --------------------------------------------------------Total Amount(In words)-----------------------------------------------
            
            PdfPTable prodAmtInwords = new PdfPTable(1);
            PdfPCell prodAmtInwordsCell;
            // first row
            // column 1
            prodAmtInwordsCell = new PdfPCell(new Phrase("Total Amount",fontDetails));
            prodAmtInwords.addCell(prodAmtInwordsCell);
            // column 2
            prodAmtInwordsCell = new PdfPCell(new Phrase(String.valueOf(Math.floor(totalAmt)),fontDetails));
            prodAmtInwords.addCell(prodAmtInwordsCell);
            
            document.add(prodAmtInwords);
            
            ------------------------------------------------------------Signature----------------------------------------------------------
            PdfPTable prodSignature = new PdfPTable(1);
            PdfPCell prodSignatureCell;
            // first row
            // column 1
            prodSignatureCell = new PdfPCell(new Phrase("Customer's Signature:",fontDetails));
            prodSignature.addCell(prodSignatureCell);
            // column 2
            prodSignatureCell = new PdfPCell(new Phrase("Authorised Signatory:",fontDetails));
            prodSignature.addCell(prodSignatureCell);
            
            document.add(prodSignature);
            
            ------------------------------------------------------------Close Document----------------------------------------------------------
           
            document.close();*/
            
			 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			 String mailSubject = "Crowd Funding - Withdrawn Fund";
			    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYou have withdrawn " +
			    		totalDonatedAmt +" sucessfully on your "+ projectRegistration.getTITLE() +"crowd funding portal." +"\n\n\nThank You For Visiting Crowd Funding.";

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL_ADDRESS());
			
		} catch (Exception e) {
		}
	}
	
	
	

}
