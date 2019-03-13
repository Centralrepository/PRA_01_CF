package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
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
		"javax.portlet.display-name=Review Posted Campaign",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/BenificiaryDetails/ContentWriter.jsp",
		"javax.portlet.name=Review Posted Campaign",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class ContentWriterModuleController extends MVCPortlet {
	
	public void editProjectContent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
			String title = actionRequest.getParameter("title");
			String description = actionRequest.getParameter("description");
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
			projectRegistration.setTITLE(title);
			projectRegistration.setDESCRIPTION(description);
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
