<%@page import="com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserOTPRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.crowd.funding.database.service.QuestionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.QuestionRegistration"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/post_donations/init.jsp" %>
<portlet:defineObjects />

<%
long questionId = Long.parseLong(renderRequest.getParameter("QuestionId"));

QuestionRegistration questionObj = QuestionRegistrationLocalServiceUtil.findByPROJECT_QUESTION_ID(questionId);
ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(questionObj.getPROJECT_ID());
UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(questionObj.getQUESTION_REQUESTER_USER_ID());
UserOTPRegistration otpObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userObj.getUSER_OTP_ID());
%> 


				<table class="table table-striped table-bordered table-hover marginTopsmall">
					<tbody>
						<tr>
							<th>Campaign Title </th>
							<td><%= projectObj.getTITLE() %></td>
						</tr>
						<tr>
							<th>Asked Question </th>
							<td><%= questionObj.getQUESTION() %></td>
						</tr>
						<tr>
							<th>Date of Question </th>
							<td><%= questionObj.getQUESTION_DATE() %></td>
						</tr>
						<tr>
							<th>Requester Mail Id </th>
							<td><%= otpObj.getMAIL_ADDRESS() %></td>
						</tr>
					</tbody>
				</table>
				<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
