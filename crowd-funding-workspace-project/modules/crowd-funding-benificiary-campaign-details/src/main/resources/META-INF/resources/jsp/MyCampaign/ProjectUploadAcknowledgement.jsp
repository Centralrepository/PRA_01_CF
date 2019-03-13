<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
long projectID = Long.parseLong(renderRequest.getParameter("ProjectId"));
%>

<portlet:actionURL name="ProjectAcknowlegementDetails" var="ProjectAcknowlegementDetailsURL" />
<aui:form action="${ProjectAcknowlegementDetailsURL}" method="post" >

	<aui:input name="ProjectID" type="hidden" value="<%= projectID %>"></aui:input>

	User Story : 
	<liferay-ui:input-editor name="description" placeholder="Write you story here..." initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor>
	
	Acknowlegement Video :
	<input name="<portlet:namespace/>videoFile" type="file" />
	
	Document name :
	<input placeholder="Document Name" name="<portlet:namespace/>documentName" type="text"/>
	Document File :
	<input name="<portlet:namespace/>documentFile" type="file" />

	<aui:button type="submit" value="submit"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form>