<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.FundAccountRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CommentRegistration"%>
<%@page import="com.crowd.funding.database.model.FundAccountRegistration"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DocumentRegistration"%>
<%@page import="com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ImageRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService"%>
<%@page import="com.crowd.funding.database.model.ProjectPriorityRegistration"%>
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
String projectID = renderRequest.getParameter("ProjectId");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());

double totalDonatedAmt = 0;
double remainingAmt = 0;
double processingFees = 0;
double paymentCharges = 0;
double totalAmt = 0;

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
for(FundRegistration fundAmtObj : fundAmtList){
	double donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
	totalDonatedAmt = totalDonatedAmt + donatedAmt;
	remainingAmt = donatedAmt - totalDonatedAmt;
}

processingFees = (6*totalDonatedAmt)/100;
paymentCharges = (2*totalDonatedAmt)/100;
totalAmt = totalDonatedAmt - (processingFees + paymentCharges);

/* int daysLeft = (int) ((projectRegistration.getEND_DATE().getTime() - projectRegistration.getCREATION_DATE().getTime())/(1000*60*60*24)); */

%>
<portlet:actionURL var="deleteCampaignURL" name="deleteCampaign">
	<portlet:param name="ProjectId" value="<%= String.valueOf(projectRegistration.getPROJECT_ID()) %>" />
</portlet:actionURL>
	
	<h1><center> <%= projectRegistration.getTITLE() %></center></h1>
<br><br>
<center>
<table cellpadding="15" border="1" style="background-color: #cccccc29;">
  <tr>
    <td colspan="2">Requested Fund Amount :</td>
    <td><%= projectRegistration.getREQUIRED_FUND_AMOUNT() %></td>
  </tr>
  <tr>
    <td colspan="2">Received Fund Amount :</td>
    <td><%= totalDonatedAmt %></td>
  </tr>
   <tr>
    <td colspan="2">Pre Withdrawn Amount :</td>
    <td><%= totalDonatedAmt %></td>
  </tr>
   <tr>
    <td colspan="2">Processing Fees(6%):</td>
    <td><%= Math.floor(processingFees) %></td>
  </tr>
   <tr>
    <td colspan="2">Payment Getway Charges(2%):</td>
    <td><%= Math.floor(paymentCharges) %></td>
  </tr>
   <tr>
   	 <td style="border-style: inherit;">   </td>
    <td>Total Amount :</td>
    <td><%= Math.floor(totalAmt) %></td>
  </tr>
</table>
<br>
<br>

<% if(projectRegistration.getSTATUS()==CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_8){ %>
	<aui:button type="delete" value="Delete" onClick="${deleteCampaignURL}" />
<% } %>
<aui:button type="cancel" value="cancel" onClick="window.history.back();" />	
	
</center>