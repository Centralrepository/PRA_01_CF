<%@page import="java.util.Collections"%>
<%@page import="com.crowd.funding.database.service.ProjectUpdateRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectUpdateRegistration"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/jsp/MyCampaign/init.jsp" %>
<portlet:defineObjects />

<% 
long ProjectId = Long.parseLong(renderRequest.getParameter("ProjectId"));
List<ProjectUpdateRegistration> projectUpdateList = ProjectUpdateRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);

Collections.reverse(projectUpdateList);
int counter = 1;
%>

 <liferay-ui:search-container delta="10" deltaConfigurable="<%= true %>" emptyResultsMessage="NO RECORDS FOUND" iteratorURL="<%= renderResponse.createRenderURL() %>" total="<%= projectUpdateList.size() %>">
		<liferay-ui:search-container-results results="<%=ListUtil.subList(projectUpdateList,searchContainer.getStart(),searchContainer.getEnd()) %>"/> 
 			<liferay-ui:search-container-row   className="com.crowd.funding.database.model.ProjectUpdateRegistration"   modelVar="projectUpdateObj">
         <liferay-ui:search-container-column-text name="No" value="<%= String.valueOf(counter) %>" />
         <liferay-ui:search-container-column-text name="Update Details" property="UPDATE_DETAILS" />
         <liferay-ui:search-container-column-text name="Date" property="UPDATE_DATE" />
         <% counter++ ; %>
   </liferay-ui:search-container-row>
<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>


<br><label> <H3> Add More Update </H3></label><br>

<portlet:actionURL name="projectUpdateRegistration" var="projectUpdateRegistrationURL" />

<aui:form action="${projectUpdateRegistrationURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	<aui:input name="projectUpdate" type="textarea"  label="Project Update"></aui:input>
	
	<aui:button name="submit" type="submit" value="Submit Update" />
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form>
