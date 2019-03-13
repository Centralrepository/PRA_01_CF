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

<style>
.avatar {
  vertical-align: middle;
  width: 200px;
  height: 200px;
  border-radius: 50%;
}
.addimage {
  width: 50px;
  height: 50px;
  margin-left: -88px;
  margin-top: 50px;
  
}
</style>

<script type="text/javascript">
$(function() {
	  $('#colors').click(function(){
	    $('#' + $(this).val()).show();
	  });
	});
</script>

<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>

<portlet:actionURL name="BenificiaryRelationIndividual" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">

	<% String Individual = renderRequest.getParameter("Individual"); %>

	<center><h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><%= Individual %><img src="/portal_content/arrow.png" alt="img" /></a></div></h3></center>
	<hr>
	
	<%
	
	if(Individual.equalsIgnoreCase("FriendIndividual")){
	%>
		<h1><center>Individual Friend</center></h1>
	<%
	}else if(Individual.equalsIgnoreCase("OtherIndividual")){
	%>
		<h1><center>Individual Other</center></h1>
	<%
	}
	%>
	
	
	<aui:input name="Individual" type="hidden" value="<%= Individual %>"></aui:input>
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
	<input name="<portlet:namespace/>image" type="file" label="Display Photo : "></input>
	<hr>
	
	<aui:input name="name" label="Name : " placeholder="Name" ></aui:input>
	<aui:input name="age" label="Age : " placeholder="Age"></aui:input>
	 <aui:select name="Gender">
		<aui:option value="Male" >Male</aui:option>
		<aui:option value="Female">Female</aui:option>
		<aui:option value="other">Others</aui:option>
	</aui:select>
	<aui:input name="number" label="Mobile Number : "></aui:input>
	<aui:input name="location" label="Location : " placeholder="Ex.Bangaluru"></aui:input>
	
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
.avatar {
  vertical-align: middle;
  width: 200px;
  height: 200px;
  border-radius: 50%;
}
.addimage {
  width: 50px;
  height: 50px;
  margin-left: -88px;
  margin-top: 50px;
  
}
 .a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 550px;
    margin-left: 298px;
    padding: 11px;
}

.b{
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 550px;
    margin-left: 298px;
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
$(function() {
	  $('#colors').click(function(){
	    $('#' + $(this).val()).show();
	  });
	});
</script>

<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>

<portlet:actionURL name="BenificiaryRelationIndividual" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">

	<% String Individual = renderRequest.getParameter("Individual"); %>
	<center><h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><U><%= Individual %></U></a></div></h3></center>
	<hr>
	
	<%
	
	if(Individual.equalsIgnoreCase("FriendIndividual")){
	%>
	<div>
    <div class="a">
		<h1><center>Individual Friend </center></h1>
	<%
	}else if(Individual.equalsIgnoreCase("OtherIndividual")){
	%>
	<div class="b">
		<h1><center>Individual Other</center></h1>
	<%
	}
	%>
	
	<aui:input name="Individual" type="hidden" value="<%= Individual %>"></aui:input>
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
	<input name="<portlet:namespace/>image" type="file" label="Display Photo : "></input>
	<hr>
	
	<aui:input name="name" label="Name : "  style="border-radius: 14px; background-color: white;width: 349px; margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "  placeholder="Name" ><aui:validator name="required" /></aui:input>
	<aui:input name="age" label="Age : "  style="border-radius: 14px; background-color: white;width: 349px; margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "placeholder="Age" ><aui:validator name="number" /><aui:validator name="max">140</aui:validator></aui:input>
	 <aui:select name="Gender"  style="border-radius: 14px; background-color: white;width: 349px; margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " ><aui:validator name="required" />
		<aui:option value="Male" >Male</aui:option>
		<aui:option value="Female">Female</aui:option>
		<aui:option value="other">Others</aui:option>
	</aui:select>
	<aui:input name="number" label="Mobile Number : " style="border-radius: 14px; background-color: white;width: 344px; margin-left: 118px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " ><aui:validator name="minLength">10</aui:validator></aui:input>
	<aui:input name="location" label="Location : "  style="border-radius: 14px; background-color: white;width: 349px; margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " placeholder="Ex.Bangaluru"><aui:validator name="required" /></aui:input>
	
	<aui:button type="submit" value="Next"  style="color:black; background-color:green"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	</div>
	</div>
</aui:form>