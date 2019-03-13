<%@page import="com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectAcknowledgementRegistration"%>
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
long projectId = 1;
ProjectAcknowledgementRegistration acknowledgementRegistration = ProjectAcknowledgementRegistrationLocalServiceUtil.findByPROJECT_ID(projectId);
%>



<video autoplay id="myVideo" controls style="max-width: 50%;">
  <source src="/portal_content/TomJerry.mp4" type="video/mp4">
</video>

<iframe width="420" height="345" src="https://youtu.be/8jv8oxGiodE?autoplay=1">
</iframe>