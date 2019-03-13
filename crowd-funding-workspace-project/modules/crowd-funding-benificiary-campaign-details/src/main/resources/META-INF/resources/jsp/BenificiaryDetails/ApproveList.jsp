<%-- <%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
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

<%
List<ProjectRegistration> projectRegistrationList = ProjectRegistrationLocalServiceUtil.getProjectRegistrations(0,ProjectRegistrationLocalServiceUtil.getProjectRegistrationsCount());
LinkedList<ProjectRegistration> reverse = new LinkedList<ProjectRegistration>();
for(int i=projectRegistrationList.size()-1;i>=0;i--){
	reverse.add(projectRegistrationList.get(i));
}

int counter = 1;
%>

	<table class="table marginTopsmall">
		<tbody>
			<tr style="background-color: #c0c0c038; border:1px solid #ddd">
				<th>Project No.</th>
				<th>Title</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			<%
			for(ProjectRegistration projectObj : reverse){
			%>
				<portlet:renderURL var="EndDateDetails" windowState="normal" >
					<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/ApprovalDetails.jsp" />
				</portlet:renderURL>
				<tr>
					<th><%= counter %></th>
					<th><%= projectObj.getTITLE() %></th>
					<% if(projectObj.getSTATUS()==1){%>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1_TEXT %></th>
					<%}if(projectObj.getSTATUS()==0){%>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0_TEXT %></th>
					<% }if(projectObj.getSTATUS()==2){%>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2_TEXT %></th>
					<% }if(projectObj.getSTATUS()==3){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3_TEXT %></th>
					<% }if(projectObj.getSTATUS()==4){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4_TEXT %></th>
					<% }if(projectObj.getSTATUS()==5){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5_TEXT %></th>
					<% }if(projectObj.getSTATUS()==6){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_6_TEXT %></th>
					<% }if(projectObj.getSTATUS()==7){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_7_TEXT %></th>
					<% }if(projectObj.getSTATUS()==8){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_8_TEXT %></th>
					<% } %>
					<th>
						<aui:button type="Details" value="Details" onClick="${EndDateDetails}"/>
					</th>
				</tr>
			<%
			counter++;
			}
			%>
		</tbody>
	</table>
	
 --%>
 
 
 <%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
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
.Header{
box-shadow: 5px 5px 5px 0px #000000, inset 4px 4px 15px 0px #000000;
 border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 678px;
    margin-left: 119px;
 }
 
 h1, .h1 {
    font-size: 1.625rem;
    margin-left: 220px;
     color:#9c3353;
     text-shadow: 0px 1px 2px #000;
    margin-top: -22px;
    }
    
  .text-dark {
    color: #272834 !important;
    margin-left: -11px;
}
.btn-default {
    color: black;
    background-color:green;
    }

</style>
<%
List<ProjectRegistration> projectRegistrationList = ProjectRegistrationLocalServiceUtil.getProjectRegistrations(0,ProjectRegistrationLocalServiceUtil.getProjectRegistrationsCount());
LinkedList<ProjectRegistration> reverse = new LinkedList<ProjectRegistration>();
for(int i=projectRegistrationList.size()-1;i>=0;i--){
	reverse.add(projectRegistrationList.get(i));
}

int counter = 1;
%>
<div class="Header">
<h1>Approve List</h1>
	<table class="table marginTopsmall">
		<tbody>
		<br>
			<tr style="background-color: #c0c0c038; border:1px solid #ddd">
				<th>Project No.</th>
				<th>Title</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			</div>
			<%
			for(ProjectRegistration projectObj : reverse){
			%>
				<portlet:renderURL var="EndDateDetails" windowState="normal" >
					<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/ApprovalDetails.jsp" />
				</portlet:renderURL>
				<tr>
					<th><%= counter %></th>
					<th><%= projectObj.getTITLE() %></th>
					<% if(projectObj.getSTATUS()==1){%>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1_TEXT %></th>
					<%}if(projectObj.getSTATUS()==0){%>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0_TEXT %></th>
					<% }if(projectObj.getSTATUS()==2){%>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2_TEXT %></th>
					<% }if(projectObj.getSTATUS()==3){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3_TEXT %></th>
					<% }if(projectObj.getSTATUS()==4){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4_TEXT %></th>
					<% }if(projectObj.getSTATUS()==5){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5_TEXT %></th>
					<% }if(projectObj.getSTATUS()==6){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_6_TEXT %></th>
					<% }if(projectObj.getSTATUS()==7){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_7_TEXT %></th>
					<% }if(projectObj.getSTATUS()==8){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_8_TEXT %></th>
					<% } %>
					<th>
						<aui:button type="Details" value="Details" onClick="${EndDateDetails}"/>
					</th>
				</tr>
			<%
			counter++;
			}
			%>
		</tbody>
	</table>
	
 