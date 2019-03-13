<%@page import="java.util.LinkedList"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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
ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
List<ProjectRegistration> projectList = ProjectRegistrationLocalServiceUtil.findByUSER_ID(td.getUserId());
LinkedList<ProjectRegistration> reverse = new LinkedList<ProjectRegistration>();
for(int i=projectList.size()-1;i>=0;i--){
	reverse.add(projectList.get(i));
}

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
long projectId = 0;
%>



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
				<th>Creation Date</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
			<tbody>
			  <% for(ProjectRegistration projectObj: reverse){ %>
			  
			  <% projectId = projectObj.getPROJECT_ID();
			  %>
			  
			  <portlet:renderURL var="ProjectDetailURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/CampaignDetails.jsp" />
			  </portlet:renderURL>
			  <portlet:renderURL var="ProjectUpdateURL" windowState="normal" >
					<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/MyCampaign/ProjectUpdate.jsp" />
			  </portlet:renderURL>
			  
			  <portlet:renderURL var="UploadAcknowledgementURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/ProjectUploadAcknowledgement.jsp" />
			 </portlet:renderURL>
			 
			  <portlet:renderURL var="popupUrl" windowState="normal">
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/MyCampaign/RequestFundAmt.jsp"/>
			  </portlet:renderURL>
			
		  
			<tr>
				<td><%= counter %></td>
				 <td><%= projectObj.getTITLE() %></td>
				 <td ><%=projectObj.getREQUIRED_FUND_AMOUNT() %></td>
				 <td><%= formatter.format(projectObj.getCREATION_DATE()) %></td>
				 
				  
				 <% if(projectObj.getSTATUS()==0){ %>
				 
					 <td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==1){ %>
				 
				 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==2){ %>
				 
				 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==3){ %>
					
					<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==4){ %>
				 
				 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==5){ %>
				 
				 <td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==6){ %>
				 
				 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_6_TEXT %></td>
					 
				<% }if(projectObj.getSTATUS()==7){ %>
					
					<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_7_TEXT %></td>
				
				<% }if(projectObj.getSTATUS()==8){ %>
					
					<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_8_TEXT %></td>
				
				 <% } %>
				 <th>
				 	<liferay-ui:icon-menu>
					 	<liferay-ui:icon image="view" message="Details" url="${ProjectDetailURL}" />
					 	<% if(projectObj.getSTATUS()==2 || projectObj.getSTATUS()==4 || projectObj.getSTATUS()==6){ %>
					 		<liferay-ui:icon image="edit" message="Project Update" url="${ProjectUpdateURL}" /> 
					 	<% } %>		
					    <% if(projectObj.getSTATUS()==7){ %>
					    	<liferay-ui:icon image="edit" message="Upload Acknowledgement" url="${UploadAcknowledgementURL}" />
					    <% } %>
					    <% if(projectObj.getSTATUS() == 4 || projectObj.getSTATUS() == 2){ %>
					 	   
							<liferay-ui:icon image="edit" message="Request for Fund Withdraw" url="${popupUrl}" />
						<%-- 	<aui:script use="liferay-util-window">
								A.one('#popup_id').on('click', function(event) {
								 Liferay.Util.openWindow({ dialog: { 
									 centered: true, 
									 height: 400, 
									 modal: true, 
									 width: 400 
									 }, 
									 id: '<portlet:namespace />dialog',
									 title: '<%= projectObj.getTITLE() %>', 
									 uri: '<%= popupUrl %>' 
									 }); 
								 });  
							</aui:script> --%>
					    	
					    	<%-- <div id="popup_id">
					    		<liferay-ui:icon image="edit"  message="Request for Fund Withdraw"   />
					    	</div> --%>
					    	
					    <% } %>
				    </liferay-ui:icon-menu>
				 </th>
				 
			</tr>
			<%
			projectId = 0;
			   counter++;
			%>
		<% } %>
	</tbody>
</table>
</form>




<%-- 
 
 <liferay-ui:search-container delta="4" deltaConfigurable="<%= true %>" emptyResultsMessage="NO RECORDS FOUND" iteratorURL="<%= renderResponse.createRenderURL() %>" total="<%= projectList.size() %>">
		<liferay-ui:search-container-results results="<%=ListUtil.subList(projectList,searchContainer.getStart(),searchContainer.getEnd()) %>"/> 
 		<liferay-ui:search-container-row   className="com.crowd.funding.database.model.ProjectRegistration"  modelVar="projectObj">
         <liferay-ui:search-container-column-text name="No" value="<%= String.valueOf(counter) %>" />
         <liferay-ui:search-container-column-text name="Campaign Title" property="TITLE" />
         <liferay-ui:search-container-column-text name="Required Fund" property="REQUIRED_FUND_AMOUNT" />
         <liferay-ui:search-container-column-text name="Creation Date" property="CREATION_DATE" />
         
         <liferay-ui:search-container-column-text name="Status" property="STATUS" />
         
         	<portlet:renderURL var="ProjectDetailURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/CampaignDetails.jsp" />
			</portlet:renderURL>
			<portlet:renderURL var="ProjectUpdateURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/ProjectUpdate.jsp" />
			</portlet:renderURL>
         <liferay-ui:search-container-column-text name="Action" >
         			<aui:button value="Details" onClick="${ProjectDetailURL}" /></th>			
					<aui:button value="Project Update" onClick="${ProjectUpdateURL}" />
         </liferay-ui:search-container-column-text> 
         
         <% counter++ ; %>
   </liferay-ui:search-container-row>
<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>  --%>



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