<%@ include file="/jsp/init.jsp" %>

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


<meta name="viewport" content="width=device-width, initial-scale=1.0">

<portlet:actionURL name="emailMobileRegistration" var="emailMobileRegistrationURL" />

      <div class ="a">
      <h1>Log In</h1>
       <br>
    <aui:form action="${emailMobileRegistrationURL}" method="post" >
	
	<aui:input name="email" label="Email ID&nbsp;&nbsp;&nbsp;&nbsp; :" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 83px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "/>

    <aui:input name="mobileNo" label="Mobile No :" style="border-radius: 14px; background-color: white;width: 349px;margin-left: 83px; margin-top: -32px; height: 38px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "/>
	
	<button type="submit"  style="color:white; background-color:#9c3353" >Send OTP</button>
</aui:form>
</div>


