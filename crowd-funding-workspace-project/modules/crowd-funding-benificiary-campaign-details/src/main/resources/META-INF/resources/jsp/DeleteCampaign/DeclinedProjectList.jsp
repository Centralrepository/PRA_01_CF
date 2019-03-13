<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
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

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
int counter = 1;
List<ProjectRegistration> projectList = ProjectRegistrationLocalServiceUtil.findBySTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5);
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>
<%-- 
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

<form >
<table id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>No.</th>
				<th>Campaign Title</th>
				<th >Required Fund</th>
				<th>Total Received Fund</th>
				<th>Action</th>
			</tr>
		</thead>
			<tbody>
			  <% for(ProjectRegistration projectObj: projectList){ 
			  
				  float donatedAmount = 0;
				  List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());

				  for(FundRegistration fundAmtObj : fundAmtList){
				  	donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
				  }
			  %>
			 
			  <portlet:renderURL var="ProjectDetailURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/FundRequestWithdraw/AdminCampaignDetails.jsp" />
			  </portlet:renderURL>
			  
			<tr>
				<td><%= counter %></td>
				 <td><%= projectObj.getTITLE() %></td>
				 <td ><%=projectObj.getREQUIRED_FUND_AMOUNT() %></td>
				 <td><%= donatedAmount %></td>
				 
				 <td>
					 <liferay-ui:icon image="view" message="Details" url="${ProjectDetailURL}" />
				 </td>
				 
			</tr>
			<%
			counter++;
			%>
		<% } %>
	</tbody>
</table>
</form> --%>


 
 <liferay-ui:search-container delta="4" deltaConfigurable="<%= true %>" emptyResultsMessage="NO RECORDS FOUND" iteratorURL="<%= renderResponse.createRenderURL() %>" total="<%= projectList.size() %>">
		<liferay-ui:search-container-results results="<%=ListUtil.subList(projectList,searchContainer.getStart(),searchContainer.getEnd()) %>"/> 
 		<liferay-ui:search-container-row   className="com.crowd.funding.database.model.ProjectRegistration"  modelVar="projectObj">
         <liferay-ui:search-container-column-text name="No" value="<%= String.valueOf(counter) %>" />
         <liferay-ui:search-container-column-text name="Campaign Title" property="TITLE" />
         <liferay-ui:search-container-column-text name="Required Fund" property="REQUIRED_FUND_AMOUNT" />
       
         <% 		  
				  float donatedAmount = 0;
				  List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());

				  for(FundRegistration fundAmtObj : fundAmtList){
				  	donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
				  }
			  %>
           <liferay-ui:search-container-column-text name="Total Received Fund" value="<%= String.valueOf(donatedAmount) %>" />
           
         	<portlet:renderURL var="ProjectDetailURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/DeleteCampaign/AdminDeleteCampaignDetails.jsp" />
			</portlet:renderURL>
         <liferay-ui:search-container-column-text name="Action" >
         			<aui:button value="Details" onClick="${ProjectDetailURL}" /></th>			
         </liferay-ui:search-container-column-text> 
         
         <% counter++ ; %>
   </liferay-ui:search-container-row>
<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container> 



	<%-- <table class="table marginTopsmall">
		<tbody>
			<tr style="background-color: #c0c0c038; border:1px solid #ddd">
				<th>Campaign  No.</th>
				<th>Campaign Title</th>
				<th>Fund Amount</th>
				<th>Action</th>
			</tr>
<%
for(ProjectRegistration projectObj : projectList){
%>
			<portlet:renderURL var="ProjectDetailURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/CampaignDetails.jsp" />
			</portlet:renderURL>
			<portlet:renderURL var="ProjectUpdateURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/ProjectUpdate.jsp" />
			</portlet:renderURL>
				<tr>
					<th><%= counter %></th>
					<th><%= projectObj.getTITLE() %></th>
					<th><%= projectObj.getREQUIRED_FUND_AMOUNT() %></th>
					<th><aui:button value="Details" onClick="${ProjectDetailURL}" /></th>			
					<th><aui:button value="Project Update" onClick="${ProjectUpdateURL}" /></th>			
				</tr>
				<%
				counter++;
				%>

<%
	}%>
 --%>