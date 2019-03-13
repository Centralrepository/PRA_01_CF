<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.NewsLetterRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.NewsLetterRegistration"%>
<%@ include file="/jsp/init.jsp" %>
<%@page import="java.util.List"%>

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
List<NewsLetterRegistration> letterRegistrationList = NewsLetterRegistrationLocalServiceUtil.getNewsLetterRegistrations(0, CounterLocalServiceUtil.getCountersCount());

%>



<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>



<table id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>No.</th>
				<th>NewsLetterTitle</th>
				<th>Creation Date</th>
				<th>Action</th>
				
			</tr>
		</thead>
			<tbody>
			
			
			<% for(NewsLetterRegistration letterRegistrationObj : letterRegistrationList ) {%>
			<tr>
			<portlet:renderURL var="popupUrl" windowState="normal">
				<portlet:param name="NewsLetterId" value="<%= String.valueOf(letterRegistrationObj.getNEWS_LETTER_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/NewsLetterDetails.jsp"/>
			  </portlet:renderURL>
				<td><%= counter %></td>
				 <td><%= letterRegistrationObj.getTITLE() %></td>
				 <td><%= letterRegistrationObj.getDATE() %></td>
				 <td><aui:button name="submit" onClick="${popupUrl}" value="Details" /></td>
				 </tr>
			<%
			   counter++;
			%>
		<% } %>
	</tbody>
</table>
