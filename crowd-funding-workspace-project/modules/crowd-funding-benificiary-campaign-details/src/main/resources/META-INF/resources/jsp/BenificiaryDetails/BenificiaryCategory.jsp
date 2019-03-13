<%-- <%@ include file="/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<liferay-theme:defineObjects />

<portlet:defineObjects />

<h1> This fundraiser will benefit for</h1>
<aui:form>

	<portlet:renderURL var="MyselfURL" windowState="normal">
		<portlet:param name="Myself" value="Myself" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/MyselfCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${MyselfURL}"  value="Myself"/>
	
	
	<br><br>My Family, <br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="Individual" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/FamilyIndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${IndividualURL}"  value="Individual"/>
	
	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="FamilyGroup" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${GroupURL}"  value="Group"/>
	
	<br><br>My Friend, <br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="FriendIndividual" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/IndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${IndividualURL}"  value="Individual"/>
	
	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="FriendGroup" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${GroupURL}"  value="Group"/>
	
	<br><br>Other, <br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="OtherIndividual" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/IndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${IndividualURL}"  value="Individual"/>
	
	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="OtherGroup" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${GroupURL}"  value="Group"/>

</aui:form>
 --%>
 
 
 <%@ include file="/init.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


<style>
 .a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 550px;
    margin-left: 163px;
}
 h1, .h1 {
 font-size: 120%;
    margin-left: 312px;
    
     text-shadow: 0px 1px 2px #000;
      color:black;
    }
    .text-dark {
    
    margin-left: -12px;
}


</style>

 <link rel="stylesheet"
	href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<liferay-theme:defineObjects />

<portlet:defineObjects />

<div>
<h1>This fundraiser will benefit for</h1>
<br>
<aui:form>
<div class="a">
        <portlet:renderURL var="MyselfURL" windowState="normal">
		<portlet:param name="Myself" value="myself" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/MyselfCategoryData.jsp" />
	</portlet:renderURL>
	
	<aui:button type="button"  onClick="${MyselfURL}" value="Myself" style="width:97%;border-radius: 25px; box-shadow: 0 0 7px rgba(31,156,51,.32549);border-color: black; color: #b91141; background: #f8f8f8;" /> 
	
	<br>

	<br><strong>My Family, </strong> <small>family and closest relatives</small><br>
	
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="Individual" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/FamilyIndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${IndividualURL}" value="Individual" style=  "width:48%; border-radius: 25px; box-shadow: 0 0 7px rgba(31,156,51,.32549); border-color:black;color: #b91141; background: #f8f8f8;"/>

	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="FamilyGroup" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${GroupURL}" value="Group" style="width:48%; border-radius: 25px; box-shadow: 0 0 7px rgba(31,156,51,.32549);color: #b91141;border-color: black; background: #f8f8f8;"/>

	<br>
	<br><strong>My Friends, </strong><small>classmates, colleagues and people I know </small><br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="FriendIndividual" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/IndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${IndividualURL}" value="Individual" style="width:48%;border-radius: 25px; box-shadow: 0 0 7px rgba(31,156,51,.32549); border-color: black;color: #b91141;background: #f8f8f8;" />

	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="FriendGroup" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${GroupURL}" value="Group" style="width:48%; border-radius: 25px; box-shadow: 0 0 7px rgba(31,156,51,.32549);border-color: black; color: #b91141; background: #f8f8f8;"/>

	<br>
	<br><strong>Other, </strong><small>(anyone/anything)</small> <br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="OtherIndividual" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/IndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${IndividualURL}" value="Individual" style="width:48%; border-radius: 25px; box-shadow: 0 0 7px rgba(31,156,51,.32549);color: #b91141;border-color: black; background: #f8f8f8;"/>

	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="OtherGroup" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${GroupURL}" value="Group" style="width:48%; border-radius: 25px; box-shadow: 0 0 7px rgba(31,156,51,.32549); color: #b91141;border-color: black; background: #f8f8f8;"/>

</aui:form>

</div>
 