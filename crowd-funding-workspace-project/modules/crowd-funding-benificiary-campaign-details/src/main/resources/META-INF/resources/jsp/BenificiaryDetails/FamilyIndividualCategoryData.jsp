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

<script type="text/javascript">
var country_arr = new Array("Parents", "Sibling", "GrandParent","GrandChild","Child","Spouse" );

var s_a = new Array();
s_a[0]="";
s_a[1]="Father|Mother|Parent";
s_a[2]="Brother|Sister|Cousin";
s_a[3]="GrandFather|GrandMother";
s_a[4]="GrandSon|GrandDaughter";
s_a[5]="Son|Daughter";
s_a[6]="";

function print_country(country){
    //given the id of the <select> tag as function argument, it inserts <option> tags
    var option_str = document.getElementById(country);
    option_str.length=0;
    option_str.options[0] = new Option('Select Category','');
    option_str.selectedIndex = 0;
    for (var i=0; i<country_arr.length; i++) {
    option_str.options[option_str.length] = new Option(country_arr[i],country_arr[i]);
    }
}

function print_state(state, selectedIndex){
    var option_str = document.getElementById(state);
    option_str.length=0;    // Fixed by Julian Woods
    option_str.options[0] = new Option('Select Relation','');
    option_str.selectedIndex = 0;
    var state_arr = s_a[selectedIndex].split("|");
    for (var i=0; i<state_arr.length; i++) {
    option_str.options[option_str.length] = new Option(state_arr[i],state_arr[i]);
    }
}
</script>

<script type="text/javascript">
$(function() {
	  $('#colors').click(function(){
	    $('#' + $(this).val()).show();
	  });
	});
	
</script>

<%
String Individual = renderRequest.getParameter("Individual");
%>


<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>


<portlet:actionURL name="BenificiaryRelationIndividualFamily" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">


	
	<center><h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}">Individual Family<img src="/portal_content/arrow.png" alt="img" /></a></div></h3></center>
	<hr>
	
	<h1><center> Individual Family</center></h1>
	
	
	<aui:input name="Individual" type="hidden" value="<%= Individual %>"></aui:input>
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
	<input name="<portlet:namespace/>image" type="file" label="Display Photo : "></input>
	<hr>
	
	<aui:input name="name" label="Name : " placeholder="Name" ></aui:input><br/>
	
	Select the Relation Category :
	<select onchange="print_state('state',this.selectedIndex);" id="country" name ="<portlet:namespace/>Relationship"></select>
	<br/><br/>
	Relation : 
	<select name="<portlet:namespace/>RelationshipDetails" id ="state"></select><br/><br/>
		
	<script language="javascript">print_country("country");</script>

	<aui:input name="age" label="Age : " placeholder="Age"></aui:input>
	 <aui:select name="Gender">
		<aui:option value="Male" >Male</aui:option>
		<aui:option value="Female">Female</aui:option>
		<aui:option value="other">Others</aui:option>
	</aui:select>
	<aui:input name="location" label="Location : " placeholder="Ex.Bangaluru"></aui:input>
	
	<hr><div>Contact details</div><br>
	<aui:input name="contectName" label="Name : "></aui:input>
	<aui:input name="number" label="Mobile Number : "></aui:input>
	
	<aui:button type="submit" value="Next"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	
</aui:form> --%>

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
    width: 550px;
    margin-left: 193px;
    padding: 11px;
        }
        
       
    h1{
         color:#9c3353;
        }
        .text-dark {
    color: #272834 !important;
    margin-left: -12px;
}
</style>

<script type="text/javascript">
var country_arr = new Array("Parents", "Sibling", "GrandParent","GrandChild","Child","Spouse" );

var s_a = new Array();
s_a[0]="";
s_a[1]="Father|Mother|Parent";
s_a[2]="Brother|Sister|Cousin";
s_a[3]="GrandFather|GrandMother";
s_a[4]="GrandSon|GrandDaughter";
s_a[5]="Son|Daughter";
s_a[6]="";

function print_country(country){
    //given the id of the <select> tag as function argument, it inserts <option> tags
    var option_str = document.getElementById(country);
    option_str.length=0;
    option_str.options[0] = new Option('Select Category','');
    option_str.selectedIndex = 0;
    for (var i=0; i<country_arr.length; i++) {
    option_str.options[option_str.length] = new Option(country_arr[i],country_arr[i]);
    }
}

function print_state(state, selectedIndex){
    var option_str = document.getElementById(state);
    option_str.length=0;    // Fixed by Julian Woods
    option_str.options[0] = new Option('Select Relation','');
    option_str.selectedIndex = 0;
    var state_arr = s_a[selectedIndex].split("|");
    for (var i=0; i<state_arr.length; i++) {
    option_str.options[option_str.length] = new Option(state_arr[i],state_arr[i]);
    }
}
</script>

<script type="text/javascript">
$(function() {
	  $('#colors').click(function(){
	    $('#' + $(this).val()).show();
	  });
	});
	
</script>

<%
String Individual = renderRequest.getParameter("Individual");
%>


<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>


<portlet:actionURL name="BenificiaryRelationIndividualFamily" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">


	
	<center><h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><U>Individual Family</U></a></div></h3></center>
	<hr>

<div class ="a">
	<h1><center>Individual Family</center></h1>
	
	<aui:input name="Individual"  type="hidden" value="<%= Individual %>"></aui:input>
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
	<input name="<portlet:namespace/>image" type="file" label="Display Photo : "></input>
	<hr>
	<aui:input name="name" label="Name : " style="border-radius: 14px; background-color: white;width: 349px;margin-left: 146px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " placeholder="Name" ><aui:validator name="required" /></aui:input>
	<aui:select onchange="print_state('state',this.selectedIndex);" id="country" 
	style="border-radius: 14px; background-color: white;width: 354px;  margin-top: -32px; margin-left: 8px;	height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549);"  name ="Relation Category:"><aui:validator name="required" /><aui:validator name="required" /></aui:select>
	<br/><br/>
	
	
	<aui:select name="RelationshipDetails:" id ="state" style="margin-left: 8%; height: 39px; border-radius: 14px; box-shadow: 0 0 7px rgba(31,156,51,.32549); width: 67%;"></aui:select><br/><br/>
	<script language="javascript">print_country("country");</script>
	
	<aui:input name="age" label="Age : "  style="border-radius: 14px; background-color: white;width: 349px;margin-left: 146px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " placeholder="Age"><aui:validator name="required" /><aui:validator name="number" /><aui:validator name="max">140</aui:validator></aui:input>
	 <aui:select name="Gender"  style="border-radius: 14px; background-color: white;width: 349px; margin-left: 146px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " >
		<aui:option value="Male" >Male</aui:option>
		<aui:option value="Female">Female</aui:option>
		<aui:option value="other">Others</aui:option>
	</aui:select>
	<aui:input name="location" label="Location : "  style="border-radius: 14px; background-color: white;width: 349px;margin-left: 146px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " placeholder="Ex.Bangaluru"><aui:validator name="required" /></aui:input>
	
	<hr><div><strong>Contact details</strong></div><br>
	<aui:input name="contectName" label="Name : "   style="border-radius: 14px; background-color: white;width: 349px;margin-left: 146px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input>
	<aui:input name="number" label="Mobile Number : "  style="border-radius: 14px; background-color: white;width: 349px;margin-left: 146px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="minLength">10</aui:validator></aui:input>
	
	<aui:button type="submit" onsubmit="return validateForm()" value="Next" style="color:black; background-color:green"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	</div>
</aui:form>
