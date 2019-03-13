<%@page import="java.util.LinkedList"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectPriorityRegistration"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<liferay-ui:error key="error-key" message="Sequence Number is already in Used."/>

<%
List<ProjectPriorityRegistration> priorityList = ProjectPriorityRegistrationLocalServiceUtil.getProjectPriorityRegistrations(0, ProjectPriorityRegistrationLocalServiceUtil.getProjectPriorityRegistrationsCount());
int counter = 1;
LinkedList<ProjectPriorityRegistration> reverse = new LinkedList<ProjectPriorityRegistration>();
for(int i=priorityList.size()-1;i>=0;i--){
	reverse.add(priorityList.get(i));
}
SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
%>

<table class="table marginTopsmall">
		<tbody>
			<tr style="background-color: #c0c0c038; border:1px solid #ddd">
				<th>Project No.</th>
				<th>Title</th>
				<th>Project Type</th>
				<th>Feature Priority Sequence</th>
				<th>Action</th>
			</tr>
			<%
			for(ProjectPriorityRegistration priorityObj : reverse){
				ProjectRegistration projectData = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(priorityObj.getPROJECT_ID());
			%>
				<portlet:renderURL var="setPriorityData" windowState="normal" >
					<portlet:param name="projectID" value="<%= String.valueOf(priorityObj.getPROJECT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/PrioritySequence/PrioritySequenceDetails.jsp" />
				</portlet:renderURL>
				
				<portlet:renderURL var="editPriorityData" windowState="normal" >
					<portlet:param name="projectID" value="<%= String.valueOf(priorityObj.getPROJECT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/PrioritySequence/EditPriority.jsp" />
				</portlet:renderURL>
				
				<tr>
					<th><%= counter %></th>
					<th><%= projectData.getTITLE() %></th>
					<%if(priorityObj.getPRIORITY()==0){%>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Priority_0_Normal %></th>
					<% }if(priorityObj.getPRIORITY()==1){ %>
						<th><%= CrowdFundingBenificiaryDetailsPortletKeys.Priority_1_Featured %></th>
					<% } %>
					<th><%= priorityObj.getPRIORITY_SEQUANCE()  %></th>
					<th>
						<%if(priorityObj.getPRIORITY()==0){%>
							<aui:button type="SetPriority" value="Set Priority" onClick="${setPriorityData}"/>
						<% }if(priorityObj.getPRIORITY()==1){%>
							<aui:button type="editPriority" value="Edit Priority" onClick="${editPriorityData}"/>
						<%} %>
					</th>
				</tr>
			<%
			counter++;
			}
			%>
		</tbody>
	</table>