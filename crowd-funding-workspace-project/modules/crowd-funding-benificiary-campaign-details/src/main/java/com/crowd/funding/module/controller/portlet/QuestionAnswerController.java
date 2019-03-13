package com.crowd.funding.module.controller.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-016
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=CrowdFundingDetails",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.display-name=Question Answer",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/post_donations/Q&A/QuestionList.jsp",
	        "javax.portlet.name=Question Answer",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class QuestionAnswerController extends MVCPortlet {

}
