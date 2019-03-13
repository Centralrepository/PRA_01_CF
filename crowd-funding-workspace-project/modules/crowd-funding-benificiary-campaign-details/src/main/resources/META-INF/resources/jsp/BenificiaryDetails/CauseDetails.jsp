<%-- <%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@ include file="/init.jsp" %>

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

<style>


</style>

<script type="text/javascript">
$(function() {
	  $('#blank').click(function(){
	    $('#textValue').show();
	    $('#blank').hide();
	  });
	});
	
function myFunction() {
	document.getElementById("btn").style.color = "red";
	  document.getElementById("textValue").value = document.getElementById("btn").value;
	}
</script>

<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="causeData" var="causeDataURL" />

<aui:form action="${causeDataURL}" method="post">

<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<h1>I am raising funds for a/an <u><div id="textValue"> __________<img src="/portal_content/arrow.png" alt="img"/></div></u> cause</h1>

<div>
<aui:input name="btn" label="Medical" type="radio" value="Medical" onclick="myFunction()"></aui:input>
<aui:input name="btn" label="Education" type="radio" value="Education" onclick="myFunction()"></aui:input><br>
<aui:input name="btn" label="Memorial" type="radio" value="Memorial" onclick="myFunction()"></aui:input>
<aui:input name="btn" label="Others" type="radio" value="Others" onclick="myFunction()"></aui:input>
</div>

<aui:button type="submit" value="Next"/>

</aui:form>


 --%>
 
 <%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@ include file="/init.jsp" %>

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

<style>

.a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
     width: 572px;
    margin-left: 163px;
}
   h1{
         color:#9c3353;
        margin-left: 40px;
        text-shadow: 0px 1px 2px #000;
        }
        
        .text-dark {
    color: #272834 !important;
    margin-left: -13px;
}
  
  .b{
  
  display:inline-block;
  margin-left: 41px;
  }
  
  .c{
  display:inline-block;
  margin-left: 41px;
   
  }
  
    .d{
  display:inline-block;
  margin-left: 41px;
  
  }
   .e{
  display:inline-block;
    margin-left: 41px;
  }
   .f{
  display:inline-block;
    margin-left: 41px;
  }
   .g{
     margin-left: 41px;
  display:inline-block;
  }
  .h{
    margin-left: 41px;
  }
</style>

<script type="text/javascript">
$(function() {
	  $('#blank').click(function(){
	    $('#textValue').show();
	    $('#blank').hide();
	  });
	});
	
function myFunction() {
	document.getElementById("btn").style.color = "red";
	  document.getElementById("textValue").value = document.getElementById("btn").value;
	}
</script>

<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="causeData" var="causeDataURL" />

<aui:form action="${causeDataURL}" method="post">

<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>
<div class ="a" >
<h1>Cause Details :</h1>
<hr>
<div>
 <aui:option selected="true" value=""></aui:option>
 <div class="b"><aui:input name="btn" label="Medical" type="radio" value="Medical" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="b"><aui:input name="btn" label="Education"  type="radio" value="Education"  onclick="myFunction()"></aui:input></div>
<br>
 <div class="c"><aui:input name="btn" label="Community Development" type="radio" value="CommunityDevelopment" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="c"><aui:input name="btn" label="Women Empowerment" type="radio" value="WomenEmpowerment" onclick="myFunction()"></aui:input></div>
<br>
<div class="d"><aui:input name="btn" label="Health and Hygiene" type="radio" value="HealthandHygiene" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="d"><aui:input name="btn" label="Senior Citizens" type="radio" value="SeniorCitizens" onclick="myFunction()"></aui:input></div>
<br>
<div class="e"><aui:input name="btn" label="Disabilities" type="radio" value="Disabilities" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="e"><aui:input name="btn" label="Food" type="radio" value="Food" onclick="myFunction()"></aui:input></div>
<br>
<div class="f"><aui:input name="btn" label="Rural works " type="radio" value="Ruralworks" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="f"><aui:input name="btn" label="Orphans" type="radio" value="Orphans" onclick="myFunction()"></aui:input></div>
<br>
<div class="g"><aui:input name="btn" label="Sanitation" type="radio" value="Sanitation" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="g"><aui:input name="btn" label="Tutions" type="radio" value="Tutions" onclick="myFunction()"></aui:input></div>
<br>
<div class="h"><aui:input name="btn" label="Enterprise Development" type="radio" value="EnterpriseDevelopment" onclick="myFunction()"></aui:input></div>
<br>
<aui:button type="submit" value="Next" style="color:black; background-color:green;"/>
</div>
</div>
</div>
</div>
</aui:form>
<aui:script use="aui-base" >

    var rules = {
        <portlet:namespace/> contactMethode: {
         required: true
        }
    };
    
    var fieldStrings = {
        <portlet:namespace/> contactMethode: {
            required: '<liferay-ui:message key="com.liferay.content.error" />'
        }
    };
    
    var validator1 = new A.FormValidator({
        boundingBox: document.<portlet:namespace />fm,
        fieldStrings: fieldStrings,
        rules: rules
    });
    
</aui:script>

 