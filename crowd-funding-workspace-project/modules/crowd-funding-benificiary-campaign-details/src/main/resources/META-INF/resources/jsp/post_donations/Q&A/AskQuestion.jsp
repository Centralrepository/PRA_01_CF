<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/post_donations/init.jsp" %>
<portlet:defineObjects />

<%
String ProjectId = renderRequest.getParameter("projectId");
%>

<portlet:actionURL name="askQuestionRegistration" var="askQuestionRegistrationURL" />
	
<aui:form action="${askQuestionRegistrationURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>

	<aui:input name="askQuestion" label="Question"></aui:input>
	<aui:button name="submit" type="submit" value="Submit" />
	
</aui:form>