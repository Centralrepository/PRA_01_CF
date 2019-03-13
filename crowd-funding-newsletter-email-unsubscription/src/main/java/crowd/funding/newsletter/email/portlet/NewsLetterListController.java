package crowd.funding.newsletter.email.portlet;



import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.NewsLetterRegistration;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.NewsLetterRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;




@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=NewsLetterList",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/NewsLetterList.jsp",
			//"javax.portlet.init-param.view-template=/jsp/NewsLetterSubscription.jsp",
			"javax.portlet.name=NewsLetterList",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class NewsLetterListController extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
	        long newsLetterId = ParamUtil.getLong(resourceRequest, "NewsLetterId");
	        String fileName = "Document";
		    NewsLetterRegistration documentObj = NewsLetterRegistrationLocalServiceUtil.findByNEWS_LETTER_ID(newsLetterId);
        	    /*java.sql.Blob document = documentObj.getDOCUMENT();
                byte[ ] documentData = document.getBytes(1,(int)document.length());
				resourceResponse.setContentType(documentObj.getDOCUMENT_TYPE());
				resourceResponse.setProperty("Content-disposition","attachement; filename=" +fileName );
				OutputStream o = resourceResponse.getPortletOutputStream();
				o.write(documentData);
				o.flush();
				o.close();*/
				
				
				 java.sql.Blob document = documentObj.getDOCUMENT();
	                byte[ ] documentData = document.getBytes(1,(int)document.length());
					resourceResponse.setContentType(documentObj.getDOCUMENT_TYPE());
					OutputStream o = resourceResponse.getPortletOutputStream();
					o.write(documentData);
					o.flush();
					o.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
