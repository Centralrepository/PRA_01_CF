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
   background-color:honeydew;
    background-image: -webkit-linear-gradient(45deg,#efefef 25%,transparent 25%,transparent 75%,#efefef 75%,#efefef),-webkit-linear-gradient(45deg,#efefef 25%,transparent 25%,transparent 75%,#efefef 75%,#efefef);
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
<portlet:actionURL name="otpAuthentication" var="otpAuthenticationURL" />

<liferay-ui:error key="error-key" message="Please Enter Correct OTP." />
<liferay-ui:error key="otp-expired-error-key" message="Entered OTP is Expired. Please Generate New OTP." />

<%
long mobileNo = Long.parseLong(renderRequest.getParameter("mobileNo"));
%>  
     <div class="a">
     <h1>OTP Validation</h1>
     <br>
   <aui:form action="${otpAuthenticationURL}" method="post" >
	
	  <aui:input type="hidden" name="mobileNo" value="<%= mobileNo  %>" />
	  <aui:input type="text" name="emailOtp" label="Enter Your Email OTP" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 148px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "/>
	  <aui:input type="text" name="mobileOtp" label="Enter Your Phone OTP" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 148px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " />
	
	   <aui:button type="submit" name="Submit OTP" value="Submit OTP" style="color:white; background-color:#9c3353" />

   </aui:form>
   <br>
<portlet:actionURL name="reSemdOtpRegistration" var="reSemdOtpRegistrationURL" >
	<portlet:param name="mobileNo" value="<%= String.valueOf(mobileNo) %>" />
</portlet:actionURL>

<aui:button type="button" onClick="${reSemdOtpRegistrationURL}"  value="Resend OTP" style="color:white; background-color:#9c3353"/>

<portlet:renderURL var="ReEnterURL" windowState="normal">
			<portlet:param name="jspPage" value="/jsp/OTPAuthenticationForm.jsp" />
		</portlet:renderURL>
<aui:button type="button" onClick="${ReEnterURL}"  value="Change Email/Mobile No" style="color:white; background-color:#9c3353" />
</div>


<script>
 function OTPLost() {
	  alert("Your OTP is Expired. Please Generate New OTP.");
	// Sets the new location of the current window.
	  window.location = "http://localhost:8080/web/crowd-funding";
	}
	setTimeout(OTPLost, 300000);
 </script>
 
