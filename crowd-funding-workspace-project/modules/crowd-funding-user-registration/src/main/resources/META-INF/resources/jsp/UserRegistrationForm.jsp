<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ include file="/jsp/init.jsp" %>
<portlet:defineObjects />
<style>
.a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:gainsboro;
    width: 550px;
    margin-left: 298px;
    padding: 11px;
   
}
        
               h1, .h1 {
    font-size: 106%;
    margin-left: 200px;
    }
    
    .form-control {
    border-color: black;
    }
    
     .text-dark {
    color: #272834 !important;
 
    margin-left: -4px;
}
    
        </style>
        
<%
long UserOtpId = Long.parseLong(renderRequest.getParameter("UserOtpId"));
%> 
<div class="a">
<portlet:actionURL name="userRegistration" var="userRegistrationURL">
</portlet:actionURL>

<aui:form action="${userRegistrationURL}" method="post" >

	<h1>User Registration</h1>
	<br>
	<aui:input name="UserOtpId" type="hidden" value="<%= UserOtpId %>" />
	<aui:input name="firstName" label="First Name" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " />
	<aui:input name="lastName" label="Last Name" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " />
	<aui:input type="password" name="password" label="Password" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " />
	<aui:select label="Gender" name="gender" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " >
		<aui:option label="Male" value="Male" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "/>
		<aui:option label="Female" value="Female" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 111px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "/>
	</aui:select>
	
	<aui:button name="submit" type="submit" value="submit" style="color:white; background-color:#9c3353" />
	</div>
	
</aui:form>