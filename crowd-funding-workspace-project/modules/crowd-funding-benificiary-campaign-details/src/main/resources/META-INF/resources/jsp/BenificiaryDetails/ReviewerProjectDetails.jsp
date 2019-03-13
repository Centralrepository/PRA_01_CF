<%-- <%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
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
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
%>

<portlet:actionURL name="editProjectContent" var="editProjectContentURL" />
<aui:form action="${editProjectContentURL}" method="post">

<aui:input name="projectID" value="<%= projectID %>" type="hidden"></aui:input>
<aui:input name="title" label="Title" value="<%= projectRegistration.getTITLE() %>"></aui:input>

<label><B>CAMPAIGN STORY</B></label>	<BR>

<liferay-ui:input-editor name="description" contents="<%= projectRegistration.getDESCRIPTION() %>" initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor>

<BR>
<BR>
<CENTER>
<aui:button type="submit" value="Submit"></aui:button>
<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</CENTER>
</aui:form>

 --%>
 
 
 
 <%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<style>
.a {
box-shadow: 5px 5px 5px 0px #000000, inset 4px 4px 15px 0px #000000;
 border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 678px;
    margin-left: 108px;
 }
 
 .form-control {
  
    border-color: black;
    }
    
   h1, .h1 {
    font-size: 1.625rem;
    margin-left: 220px;
     color:#9c3353;
     text-shadow: 0px 1px 2px #000;
    }
    
     .text-dark {
    color: #272834 !important;
    margin-left: -11px;
}
    
</style>

<%
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
%>

<portlet:actionURL name="editProjectContent" var="editProjectContentURL" />
<aui:form action="${editProjectContentURL}" method="post">
<div class="a">
<h1>Project Details</h1>
<br>
<aui:input name="projectID" value="<%= projectID %>" type="hidden"></aui:input>
<aui:input name="title" label="Title:"  style="border-radius: 14px; background-color: white;width: 409px;margin-left: 93px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " value="<%= projectRegistration.getTITLE() %>"><aui:validator name="required" /></aui:input>

<strong>User Story: </strong>
<br>
<liferay-ui:input-editor name="description" contents="<%= projectRegistration.getDESCRIPTION() %>" initMethod="initEditor" width="100" height="400"   resizable="true" ></liferay-ui:input-editor>
<br>
	
<aui:input name="requiredAmt" disabled="disabled" label="Required Fund Amount:"  style="border-radius: 14px; background-color: white; width: 409px;margin-left: 194px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " value="<%= projectRegistration.getREQUIRED_FUND_AMOUNT() %>"><aui:validator name="required" /></aui:input>
<aui:button type="submit" value="Submit" style="color:black; background-color:green"></aui:button>
<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form>
</div>


<!-- border-color= "black" -->
 