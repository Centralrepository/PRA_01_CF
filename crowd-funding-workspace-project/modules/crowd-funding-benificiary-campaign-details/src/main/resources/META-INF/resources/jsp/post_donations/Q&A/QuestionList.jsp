<%@page import="com.crowd.funding.database.service.QuestionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.QuestionRegistration"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/post_donations/init.jsp" %>

<portlet:defineObjects />

<%
ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<ProjectRegistration> projectList = ProjectRegistrationLocalServiceUtil.findByUSER_ID(themeDisplayObj.getUserId());
int counter = 1;
%>

<table class="table marginTopsmall">
		<tbody>
			<tr style="background-color: #c0c0c038; border:1px solid #ddd">
				<th>Campaign  No.</th>
				<th>Campaign Title</th>
				<th>Question</th>
				<th>Action</th>
			</tr>
<%
for(ProjectRegistration projectObj : projectList){
	List<QuestionRegistration> questionList = QuestionRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
	for(QuestionRegistration questionObj : questionList){
%>
			<portlet:renderURL var="QuestionDetailURL" windowState="normal" >
				<portlet:param name="QuestionId" value="<%= String.valueOf(questionObj.getPROJECT_QUESTION_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/post_donations/Q&A/QuestionDetails.jsp" />
			</portlet:renderURL>
				<tr>
					<th><%= counter %></th>
					<th><%= projectObj.getTITLE() %></th>
					<th><%= questionObj.getQUESTION() %></th>
					<th><aui:button type="Reviewer" value="Details" onClick="${QuestionDetailURL}" /></th>			
				</tr>
				<%
				counter++;
				%>

<%}
	}%>
