package crowd.funding.newsletter.email.portlet;


import crowd.funding.newsletter.email.constants.NewsLetterEmailControllerPortletKeys;
import crowd.funding.newsletter.send.email.SendAttachmentInEmail;

import com.crowd.funding.database.model.NewsLetterRegistration;
import com.crowd.funding.database.model.SubscriptionRegistration;
import com.crowd.funding.database.service.NewsLetterRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.SubscriptionRegistrationLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-Intern
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AddContentNewsletter",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/NewsLetterRegistration.jsp",
		//"javax.portlet.init-param.view-template=/jsp/NewsLetterSubscription.jsp",
		"javax.portlet.name=AddContentNewsletter",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NewsLetterEmailControllerPortlet extends MVCPortlet {
	
	public void NewsletterSubscription(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			String email = actionRequest.getParameter("newsletter");
			
			long subscriptionId = 0;
			SubscriptionRegistration subscriptionRegistration = null;
			subscriptionId = CounterLocalServiceUtil.increment(SubscriptionRegistration.class.getName());
			subscriptionRegistration = SubscriptionRegistrationLocalServiceUtil.createSubscriptionRegistration(subscriptionId);
			
			subscriptionRegistration.setEMAIL(email);
			subscriptionRegistration.setSTATUS(NewsLetterEmailControllerPortletKeys.NEWS_LETTER_SUBSCRIPTION_STATUS_1);
			
			SubscriptionRegistrationLocalServiceUtil.addSubscriptionRegistration(subscriptionRegistration);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	
	public void NewsletterRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		UploadPortletRequest portletRequest = null;
		portletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		
		String fromemail = "crowdfundasia@gmail.com";
		String subject = actionRequest.getParameter("newslettertitle");
		String body = actionRequest.getParameter("newsletterdetail");
		
		//String fileName = "C://LR//liferay-ce-portal-7.1.1-ga2//tomcat-9.0.10//temp//upload_00000092.jpg";
		
		//CrowdFundingMailSendingWithAttachment.sendMailWithAttachment("Hello Nirav", "Hello Nirav", fileName, "prajapatinrv13@gmail.com");
		
		
			File file =  portletRequest.getFile("file");
		//File file = new File("C:\\button css.txt");
		
		String fileName = file.getName();
		System.out.println(fileName);
		
		InputStream inputStream = new FileInputStream(file);
		OutputBlob blobData = new OutputBlob(inputStream, file.length());
		
	
		
		long newsletterId = 0;
		NewsLetterRegistration letterRegistration = null;
		newsletterId = CounterLocalServiceUtil.increment(NewsLetterRegistration.class.getName());
		letterRegistration = NewsLetterRegistrationLocalServiceUtil.createNewsLetterRegistration(newsletterId);
		
		letterRegistration.setTITLE(subject);
		letterRegistration.setDETAILS(body);
		letterRegistration.setDATE(new Date());
		letterRegistration.setDOCUMENT(blobData);
		letterRegistration.setDOCUMENT_TYPE(MimeTypesUtil.getContentType(file));
		NewsLetterRegistrationLocalServiceUtil.addNewsLetterRegistration(letterRegistration);
		String path = file.getPath();
		String filepath = path.replace('\\', '/');
		System.out.println("Nirav  ::::: " + path.replace('\\', '/'));
		
		System.out.println("1");
		
				
		
		
		
		List<SubscriptionRegistration>  subcriptionlist = SubscriptionRegistrationLocalServiceUtil.findBySTATUS(1);
		for(SubscriptionRegistration subscriptionObj : subcriptionlist)
		{
			String toemail = subscriptionObj.getEMAIL();
			
			SendAttachmentInEmail email = new SendAttachmentInEmail();
			email.sendEmail(fromemail, toemail, subject, body, filepath);
			
			
			/*InternetAddress fromAddress = null;
			InternetAddress toAddress = null;

			try {
				
		    		fromAddress = new InternetAddress(fromemail);
		    		toAddress = new InternetAddress(toemail);
		    		MailMessage mailMessage = new MailMessage();
		    		mailMessage.setTo(toAddress);
		    		mailMessage.setFrom(fromAddress);
		    		mailMessage.setSubject(subject);
		    		mailMessage.setBody(body); 
		    		mailMessage.addFileAttachment(file, fileName);
		    		MailServiceUtil.sendEmail(mailMessage);
		    		System.out.println("Send mail with Plain Text");
		} catch (AddressException e) {
			    	e.printStackTrace();
			}*/
		
		}
	}
	
}