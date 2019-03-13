<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/init.jsp" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
 <script>
  $(function() {
    $( "#datepicker" ).datepicker({
    	dateFormat:'dd/mm/yy',
    	changeMonth: true,
		changeYear: true,
		yearRange: "1970:2070",
		minDate: new Date()
    });
  });
 </script>
<style>
.a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 685px;
    margin-left: 90px;
 }
      h1{
      color:#9c3353;
     margin-left: 187px;
     text-shadow: 0px 1px 2px #000;
     }
     
     .text-dark {
   
    margin-left: -14px;
}
 </style>
 
 <aui:script use="liferay-auto-fields">
 var counting=1;
 		 var autoFields= new Liferay.AutoFields(
 	        {
 	            contentBox: '#document-fields',
 	            fieldIndexes: '<portlet:namespace />documentIndex'
 	           
 	        });
 		 autoFields.on("clone", function(newField) {
 			 counting = counting+1;
 			 clearFieldData(counting);
 				
         });
 		 autoFields.render();
</aui:script>
  
<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
ThemeDisplay themeDisplayUser = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
User  userDetail = themeDisplayUser.getUser();
%>

<portlet:actionURL name="ProjectRegistrationDetails" var="ProjectRegistrationDetailsURL" />

<aui:form action="${ProjectRegistrationDetailsURL}" method="post" enctype="multipart/form-data">
	<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>
	<aui:input name="userID" value="<%= userDetail.getUserId() %>" type="hidden"></aui:input>
	<div class="a">
	<h1>Project Registration</h1>
	<br>
	
	<aui:input name="title" label="Title : " style="border-radius: 14px; background-color: white;width: 548px; margin-left: 52px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " type="text"><aui:validator name="required" /></aui:input>
	
	<strong>User Story</strong><br>
	<liferay-ui:input-editor name="description" placeholder="Write you story here..." initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor>
	<br>
	<hr>
	
	<strong>Campaign Document:</strong>

	<div id="document-fields">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				<input fieldParam='documentName0' id='<portlet:namespace/>documentName0' placeholder="Document Name" name="<portlet:namespace/>documentName0" type="text"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<input fieldParam='documentFile0' id='<portlet:namespace/>documentFile0' name="<portlet:namespace/>documentFile0" type="file" />
			</div>
		</div>
	</div>
	
     <strong>End Date : </strong>
	<input type="text" id="datepicker" name="<portlet:namespace/>enddate" label="Campaign End Date :" style="border-radius: 14px; background-color: white; width: 31%;  margin-left: 101px; margin-top: -29px; height: 30px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "></input>
	<hr>
			
	<aui:input name="requiredFundAmt" label="Required Fund Amount : " style="border-radius: 14px; background-color: white; width: 30%; margin-left: 180px; margin-top: -29px; height: 30px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " type="text"><aui:validator name="required" /></aui:input>
					
	<aui:button type="submit" value="Next"  style="color:black; background-color:green"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	</div>
</aui:form>


	