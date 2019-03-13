<%-- <%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
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
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="BenificiaryDetails" var="BenificiaryDetailsURL" />

<aui:form action="${BenificiaryDetailsURL}" method="post" enctype="multipart/form-data">
<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<aui:input name="addressline1" label="AddressLine1 : "></aui:input>
<aui:input name="addressline2" label="AddressLine2 : "></aui:input>

 <aui:input name="city" label="City : "></aui:input>
  <aui:input name="state" label="State : "></aui:input>
  <aui:input name="pincode" label="Pincode : "></aui:input>
 <aui:input name="Country" label="Country : "></aui:input>
 
<aui:input type="textarea" name="emergencyContact" label="Emergency Contact Details : "></aui:input>
<aui:input name="emergencyContactNumber" label="Alternet Contact Number : "></aui:input>

<aui:button type="submit" value="Next"></aui:button>
<aui:button type="cancel" value="cancel" onClick="window.history.back();" />

</aui:form> --%>


<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
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
    background-color:white;
    margin-left: 29px;
        width: 812px;
      
}

.form-control {
   border-color:green;
   }
   
 
 h1{
         color:#9c3353;
         margin-left: -3px;
        font-size: 17px;
        
        }
        
        .text-dark {
           margin-left: -12px;
}
.line{
	display: inline-block;
}

.city{
  display:inline-block;
}

      .contact{
  display:inline-block;
}

.pin{
  display:inline-block;
}
input[type="radio"], input[type="checkbox"] {
    box-sizing: border-box;
    padding: 0;
    margin-left: 237px;
}
</style>
<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="BenificiaryDetails" var="BenificiaryDetailsURL" />

<aui:form action="${BenificiaryDetailsURL}" method="post" enctype="multipart/form-data">
<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<div class ="a">
       <h1>Benificiary Details</h1>
       <br>
       
<div class="line" ><aui:input name="addressline1" placeholder="AddressLine1"label="AddressLine1 : " style=" background-color: white;width: 228px; margin-left: 107px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " ><aui:validator name="required" /></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="line"> <aui:input name="addressline2" placeholder="AddressLine2"label="AddressLine2 : "style=" background-color: white;width: 228px; margin-left: 107px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input></div>

 <div class="city"><aui:input name="city" placeholder="city" label="City : " style=" background-color: white;width: 228px; margin-left: 107px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <div class="city"><aui:select name="state" placeholder= "State"label="State : " style=" background-color: white;width: 228px; margin-left: 107px;font-size: 13px; padding: 5px;height: 33px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); ">
  
 <aui:option value="Select option">Select Option</aui:option>
 <aui:option value="Karnataka">Karnataka</aui:option>
  <aui:option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</aui:option>
<aui:option value="Andhra Pradesh">Andhra Pradesh</aui:option>
<aui:option value="Arunachal Pradesh">Arunachal Pradesh</aui:option>
<aui:option value="Assam">Assam</aui:option>
<aui:option value="Bihar">Bihar</aui:option>
<aui:option value="Chandigarh">Chandigarh</aui:option>
<aui:option value="Chhattisgarh">Chhattisgarh</aui:option>
<aui:option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</aui:option>
<aui:option value="Daman and Diu">Daman and Diu</aui:option>
<aui:option value="Delhi">Delhi</aui:option>
<aui:option value="Goa">Goa</aui:option>
<aui:option value="Gujarat">Gujarat</aui:option>
<aui:option value="Haryana">Haryana</aui:option>
<aui:option value="Himachal Pradesh">Himachal Pradesh</aui:option>
<aui:option value="Jammu and Kashmir">Jammu and Kashmir</aui:option>
<aui:option value="Jharkhand">Jharkhand</aui:option>
<aui:option value="Karnataka">Karnataka</aui:option>
<aui:option value="Kerala">Kerala</aui:option>
<aui:option value="Lakshadweep">Lakshadweep</aui:option>
<aui:option value="Madhya Pradesh">Madhya Pradesh</aui:option>
<aui:option value="Maharashtra">Maharashtra</aui:option>
<aui:option value="Manipur">Manipur</aui:option>
<aui:option value="Meghalaya">Meghalaya</aui:option>
<aui:option value="Mizoram">Mizoram</aui:option>
<aui:option value="Nagaland">Nagaland</aui:option>
<aui:option value="Orissa">Orissa</aui:option>
<aui:option value="Pondicherry">Pondicherry</aui:option>
<aui:option value="Punjab">Punjab</aui:option>
<aui:option value="Rajasthan">Rajasthan</aui:option>
<aui:option value="Sikkim">Sikkim</aui:option>
<aui:option value="Tamil Nadu">Tamil Nadu</aui:option>
<aui:validator name="required" /></aui:select></div>
 </select>
 <div class ="pin"> <aui:input name="pincode" placeholder="Pincode"label="Pincode : " style=" background-color: white;width: 228px; margin-left: 107px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <div class ="pin"><aui:select name="Country" placeholder="Country"label="Country : " style=" background-color: white;width: 228px; margin-left: 107px; margin-top: -32px; height: 29px; padding: 5px; font-size: 13px;color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); ">
  <aui:option value="Select option">Select Option</aui:option>
    <aui:option value="Afghanistan">Afghanistan</aui:option>
    <aui:option value="Albania">Albania</aui:option>
    <aui:option value="Algeria">Algeria</aui:option>
    <aui:option value="American Samoa">American Samoa</aui:option>
    <aui:option value="Andorra">Andorra</aui:option>
    <aui:option value="Angola">Angola</aui:option>
    <aui:option value="Anguilla">Anguilla</aui:option>
    <aui:option value="Antartica">Antarctica</aui:option>
    <aui:option value="Antigua and Barbuda">Antigua and Barbuda</aui:option>
    <aui:option value="Argentina">Argentina</aui:option>
    <aui:option value="Armenia">Armenia</aui:option>
    <aui:option value="Aruba">Aruba</aui:option>
    <aui:option value="Australia">Australia</aui:option>
    <aui:option value="Austria">Austria</aui:option>
    <aui:validator name="required" /></aui:select></div>
    </select>
 <br>
 <br>
 <div style="margin-left: 96px;">
 <aui:input type="textarea" name="emergencyContact" placeholder="Emergency Contact Details"label="Emergency Contact Details : " style=" background-color: white;width: 228px; margin-left: 202px; margin-top: -32px; height: 97px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input>
 <aui:input name="emergencyContactNumber" placeholder="Alternet Contact Number"label="Alternet Contact Number : " style=" background-color: white;width: 228px;margin-left: 202px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /><aui:validator name="minLength">10</aui:validator></aui:input>
 </div>
 
 <input type="checkbox" name="terms" id="terms" onchange="activateButton(this)">  <strong>I Agree Terms & Coditions</strong>
<br>
<br>
<aui:button type="submit" value="Submit" style="color:white; background-color:#0077A2  ;margin-left:290px ;border-radius: 49%;"></aui:button>

</div>
</aui:form>