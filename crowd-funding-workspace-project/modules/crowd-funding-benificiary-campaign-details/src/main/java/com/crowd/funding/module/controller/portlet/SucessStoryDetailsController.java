package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=CrowdFundingDetails",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Sucess Story",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/SuccessStory Details/SuccessStoryDetails.jsp",
			"javax.portlet.name=Sucess Story",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)


public class SucessStoryDetailsController extends MVCPortlet {
	
	/*@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			
			String serverResourceCall = ParamUtil.getString(resourceRequest, "serverResourceCall");
			
					
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForVideo")){
				
	        	 long projectId = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectIDForProjectVideo"));
		            ProjectAcknowledgementRegistration videoObj = ProjectAcknowledgementRegistrationLocalServiceUtil.findByPROJECT_ID(projectId);
	           			 //Photo photo=PhotoLocalServiceUtil.getPhoto(imageId);
			        	   java.sql.Blob video = videoObj.getDOCUMENT();
			                byte[ ] imgData = video.getBytes(1,(int)video.length());
							resourceResponse.setContentType(videoObj.getDOCUMENT_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(imgData);
							o.flush();
							o.close();
							
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
}
