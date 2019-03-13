<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.FundAccountRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundAccountRegistration"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
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

<script src="//code.jquery.com/jquery-3.3.1.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<liferay-theme:defineObjects />

<portlet:defineObjects />


<style>


.container {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
  
}

.container::after {
  content: "";
  clear: both;
  display: table;
}

.container img {
  float: left;
  max-width: 60px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

.container img.right {
  float: right;
  margin-left: 20px;
  margin-right:0;
}



.time-left {
  float: left;
  color: #999;
}

.time-right {
  float: right;
  color: #999;
}
</style>

<%
long projectID = 501;




List<FundAccountRegistration> fundData = FundAccountRegistrationLocalServiceUtil.findByPROJECT_ID(projectID); 
List<CommentRegistration> commentList = CommentRegistrationLocalServiceUtil.findBySTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_1);
%>


<% 
for(CommentRegistration commentObj : commentList){
	ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(commentObj.getPROJECT_ID());
	User userData = UserLocalServiceUtil.fetchUser(commentObj.getDONOR_USER_ID());
%>
<div class="container darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= commentObj.getCOMMENT() %></p>
 	 <span class="time-left"><%= commentObj.getCOMMENT_DATE() %> | <%= userData.getFullName() %></span>
</div>
<div class="container darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= commentObj.getANSWER() %></p>
 	 <span class="time-right"><%= commentObj.getCOMMENT_DATE() %> | <%= userData.getFullName() %></span>
</div>
<% } %>

<portlet:actionURL var="commentDetailsURL" name="commentDetails"></portlet:actionURL>

<aui:form action="${commentDetailsURL}" method="post" >
	<aui:input type="hidden" name="projectID" value="<%= projectID %>"></aui:input>
	<aui:input name="commentData" type="textarea" label="Comments :"/>
	<aui:button type="submit" value="Submit"  />
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form>
