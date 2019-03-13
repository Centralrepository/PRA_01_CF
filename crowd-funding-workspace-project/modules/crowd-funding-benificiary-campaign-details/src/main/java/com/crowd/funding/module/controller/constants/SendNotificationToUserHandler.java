package com.crowd.funding.module.controller.constants;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;

import org.osgi.service.component.annotations.Component;

@Component(service=UserNotificationHandler.class)
public class SendNotificationToUserHandler extends BaseUserNotificationHandler{

	public static final String PORTLET_ID= "CampaignApproval"; 
	
	public SendNotificationToUserHandler() {
		setPortletId(SendNotificationToUserHandler.PORTLET_ID);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String notificationText = jsonObject.getString("notificationText");
		String senderName = jsonObject.getString("senderName");
		String body = StringUtil.replace(getBodyTemplate(), new String[] {"[$SENDERNAME$]","[$BODY_TEXT$]"}, 
				new String[] {senderName, notificationText});

		
		return body;
	}
	
	@Override
	protected String getBodyTemplate() throws Exception {
		StringBuilder stringBuilder = new StringBuilder(5);
		stringBuilder.append("<div class=\"body\">[$SENDERNAME$] [$BODY_TEXT$]</div>");
		
		return stringBuilder.toString();
	}
	
}


