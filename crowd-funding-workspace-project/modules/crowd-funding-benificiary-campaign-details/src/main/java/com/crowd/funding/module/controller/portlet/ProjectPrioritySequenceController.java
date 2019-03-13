package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException;
import com.crowd.funding.database.model.ProjectPriorityRegistration;
import com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=CrowdFundingDetails",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Featured Campaign Priority",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/PrioritySequence/ProjectPriorityList.jsp",
			"javax.portlet.name=Featured Campaign Priority",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class ProjectPrioritySequenceController extends MVCPortlet {

	public void prioritySequenceData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NoSuchProjectPriorityRegistrationException {
		
		int prioritySequence = Integer.parseInt(actionRequest.getParameter("prioritySequence"));
		long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
		int priority = 0;
		long projectIDEdit = 0;
		
		List<ProjectPriorityRegistration> priorityList = ProjectPriorityRegistrationLocalServiceUtil.getProjectPriorityRegistrations(0, ProjectPriorityRegistrationLocalServiceUtil.getProjectPriorityRegistrationsCount());
		for(ProjectPriorityRegistration priorityObj : priorityList) {
			if(prioritySequence == priorityObj.getPRIORITY_SEQUANCE()) {
				projectIDEdit = priorityObj.getPROJECT_ID();
				priority = 1;
				break;
			}
			else {
				priority = 0;
			}
		}
		
		if(priority==1) {
			 /*actionResponse.setRenderParameter("projectID", String.valueOf(projectID));
			 actionResponse.setRenderParameter("jspPage", "/jsp/PrioritySequence/PrioritySequenceDetails.jsp");*/
			 
			SessionErrors.add(actionRequest, "error-key");
			 PortletConfig portletConfig =  (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			 SessionMessages.add(actionRequest, ((LiferayPortletConfig)portletConfig).getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			 
		}if(priority==0) {
			ProjectPriorityRegistration priorityRegistration = ProjectPriorityRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
			priorityRegistration.setPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_1);
			priorityRegistration.setPRIORITY_SEQUANCE(prioritySequence);
			
			ProjectPriorityRegistrationLocalServiceUtil.updateProjectPriorityRegistration(priorityRegistration);
		}
		
		
		
	}

	public void editPrioritySequence(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NoSuchProjectPriorityRegistrationException {
		
		long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
		int prioritySequence = Integer.parseInt(actionRequest.getParameter("prioritySequence"));
		
		int priority = 0;
		long projectIDEdit = 0;
		
		if(prioritySequence==0) {
			ProjectPriorityRegistration priorityRegistration = ProjectPriorityRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
			priorityRegistration.setPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_0);
			priorityRegistration.setPRIORITY_SEQUANCE(CrowdFundingBenificiaryDetailsPortletKeys.Priority_Sequence_0);
			
			ProjectPriorityRegistrationLocalServiceUtil.updateProjectPriorityRegistration(priorityRegistration);
		}else {
			List<ProjectPriorityRegistration> priorityList = ProjectPriorityRegistrationLocalServiceUtil.getProjectPriorityRegistrations(0, ProjectPriorityRegistrationLocalServiceUtil.getProjectPriorityRegistrationsCount());
			for(ProjectPriorityRegistration priorityObj : priorityList) {
				if(prioritySequence == priorityObj.getPRIORITY_SEQUANCE()) {
					projectIDEdit = priorityObj.getPROJECT_ID();
					priority = 1;
					break;
				}
				else {
					priority = 0;
				}
			}
			
			if(priority==1) {
				SessionErrors.add(actionRequest, "error-key");
				 PortletConfig portletConfig =  (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
				 SessionMessages.add(actionRequest, ((LiferayPortletConfig)portletConfig).getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				 
			}if(priority==0) {
				ProjectPriorityRegistration priorityRegistration = ProjectPriorityRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
				priorityRegistration.setPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_1);
				priorityRegistration.setPRIORITY_SEQUANCE(prioritySequence);
				
				ProjectPriorityRegistrationLocalServiceUtil.updateProjectPriorityRegistration(priorityRegistration);
			}
		}
		
	}

}
