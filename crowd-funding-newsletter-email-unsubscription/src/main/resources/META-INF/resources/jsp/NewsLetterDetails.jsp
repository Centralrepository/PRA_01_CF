<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.crowd.funding.database.service.NewsLetterRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.NewsLetterRegistration"%>
<%@ include file="/jsp/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="cancelUrl" windowState="normal">
 	<portlet:param name="jspPage" value="/jsp/NewsLetterList.jsp"/>
</portlet:renderURL>

<%
long NewsLetterId = ParamUtil.getLong(renderRequest, "NewsLetterId");
NewsLetterRegistration newsLetterObj = NewsLetterRegistrationLocalServiceUtil.findByNEWS_LETTER_ID(NewsLetterId);
%>

<portlet:resourceURL  var="NewsLetterResourceURL">
	<portlet:param name="NewsLetterId" value="<%= String.valueOf(NewsLetterId)  %>"/>
</portlet:resourceURL>

<table style="width:100%">
		<thead>
			<tr>
				<th>New Letter Title</th>
				<td><%= newsLetterObj.getTITLE() %></td>
				
				
				
			</tr>
			<tr>
				<th>News Letter Details</th>
			 	<td><%= newsLetterObj.getDETAILS() %></td>
			</tr>
			<tr>
				<th>Published Date</th>
				<td><%= newsLetterObj.getDATE() %></td>
			</tr>
			<tr>
				<th>Document</th>
				<td><a href="${NewsLetterResourceURL}" alt="Document" target="_blank" download/>Download NewsLetter</a> <br></td>
			</tr>
		</thead>
			
</table>

<aui:button name="cancel" onClick="${cancelUrl}" value="Cancel" />