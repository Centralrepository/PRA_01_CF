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
<style>
.a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
  background-color: #FFA;
    width: 806px;
    margin-left: 37px;
    
 }
 
 h1, h2, h3, h4, h5, h6, .h1, .h2, .h3, .h4, .h5, .h6 {
    margin-bottom: 0.5rem;
    font-family: inherit;
    font-weight: 600;
    line-height: 1.2;
   color: #82302F;
   text-shadow: 0px 1px 2px #000;

 }
</style>
<portlet:renderURL var="sucess" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>

<%
/* String projectID = renderRequest.getParameter("projectID");
 */String projectID = "701";
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
%>
<div class="a">
<h1>
Your campaign name  <u><%= projectRegistration.getTITLE() %></u> for fund Amount INR. <u> <%= projectRegistration.getREQUIRED_FUND_AMOUNT() %></u>/- is successfully registered on Quick Daan.</h1>
<br>
<br>
<br>
<div class ="c" style = "color: green; margin-left: 20%;  font-size: 26px;"> We will review details. Wait till Approval.</div>
<br>
<br>
<br>
<br>

<h6>
Note : Your Project is registered under normal project service fees(Processing fees 6%, project fees 0%, gateway charges 2%) on your campaign required fund amount.
You can change your category from MyCampaign page. After approval from Quick Daan team.  
</h6>

<center><aui:button type="submit" value="Finish"  style="color:black; background-color:green"  onClick="${sucess}" /></center>
</div>