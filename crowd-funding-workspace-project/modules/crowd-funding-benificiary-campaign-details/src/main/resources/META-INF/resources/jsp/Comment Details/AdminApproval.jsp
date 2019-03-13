<%@page import="com.liferay.portal.kernel.model.User"%>
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
List<CommentRegistration> commentList = CommentRegistrationLocalServiceUtil.getCommentRegistrations(0, CommentRegistrationLocalServiceUtil.getCommentRegistrationsCount());

int counter = 1;
%>

	<table class="table marginTopsmall">
		<tbody>
			<tr style="background-color: #c0c0c038; border:1px solid #ddd">
				<th>Comment No.</th>
				<th>Comment</th>
				<th>Action</th>
			</tr>
			<%
			for(CommentRegistration commentObj : commentList){
			%>
				<portlet:renderURL var="answerData" windowState="normal" >
					<portlet:param name="commentID" value="<%= String.valueOf(commentObj.getPROJECT_COMMENT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/Comment Details/commentAnswer.jsp" />
				</portlet:renderURL>
				
				<tr>
					<th><%= counter %></th>
					<th><%= commentObj.getCOMMENT() %></th>
					<th>
						<%if(commentObj.getSTATUS()==0){%>
							<aui:button type="Details" value="Details" onClick="${answerData}"/>
						<% }if(commentObj.getSTATUS()==1){} %>
					</th>
				</tr>
			<%
			counter++;
			}
			%>
		</tbody>
	</table>