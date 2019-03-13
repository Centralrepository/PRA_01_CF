<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="java.util.Collections"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CommentRegistration"%>
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

<%
String commentID = renderRequest.getParameter("commentID");
CommentRegistration commentRegistration = CommentRegistrationLocalServiceUtil.findByPROJECT_COMMENT_ID(Long.parseLong(commentID));
%>

<portlet:actionURL var="commentAnswerURL" name="commentAnswer"></portlet:actionURL>

<portlet:actionURL var="commentRejectURL" name="commentReject">
	<portlet:param name="commentID" value="<%= String.valueOf(commentRegistration.getPROJECT_COMMENT_ID()) %>" />
	</portlet:actionURL>
	
<th>Comment Details : <%= commentRegistration.getCOMMENT() %></th> </br>

<% if(commentRegistration.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_0){ %>
<aui:form action="${commentAnswerURL}" method="post">
	<aui:input type="hidden" name="commentID" value="<%= commentRegistration.getPROJECT_COMMENT_ID() %>" />
			<aui:input name="answer" label="Comment Answer : " type="text"></aui:input> 
			<aui:button type="submit" value="Approve"  />
			<aui:button type="submit" value="Reject" onClick="${commentRejectURL}" />
			
</aui:form>
<% }if(commentRegistration.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_1){ %>
<th>Comment Replay : <%= commentRegistration.getANSWER() %></th></br>
<% }%>

<aui:button type="cancel" value="cancel" onClick="window.history.back();" />