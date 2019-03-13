<%@page import="com.crowd.funding.module.controller.portlet.PriceConversion"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.FundAccountRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CommentRegistration"%>
<%@page import="com.crowd.funding.database.model.FundAccountRegistration"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DocumentRegistration"%>
<%@page import="com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ImageRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService"%>
<%@page import="com.crowd.funding.database.model.ProjectPriorityRegistration"%>
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


<% 
String projectID = renderRequest.getParameter("ProjectId");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());

double totalDonatedAmt = 0;
double remainingAmt = 0;
double processingFees = 0;
double paymentCharges = 0;
double totalAmt = 0;

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
for(FundRegistration fundAmtObj : fundAmtList){
	double donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
	totalDonatedAmt = totalDonatedAmt + donatedAmt;
	remainingAmt = donatedAmt - totalDonatedAmt;
}

processingFees = (6*totalDonatedAmt)/100;
paymentCharges = (2*totalDonatedAmt)/100;
totalAmt = totalDonatedAmt - (processingFees + paymentCharges);

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date currentDate = new Date();

/* int daysLeft = (int) ((projectRegistration.getEND_DATE().getTime() - projectRegistration.getCREATION_DATE().getTime())/(1000*60*60*24)); */

/*---------------------------------------------------------------Amount In Words-------------------------------------------------------------------------  */

PriceConversion priceConversion= new PriceConversion();
String str= Double.toString(totalAmt);

String [] strArr= str.split("\\.");

String strBeforeDec= strArr[0];
String strAfterDec= strArr[1];
String strUpto2Decimal="";

if (strAfterDec.length()>2) {
	strUpto2Decimal=strAfterDec.substring(0,2);
}else{
	strUpto2Decimal=strAfterDec.substring(0,1);
}

int beforeDecimal= Integer.parseInt(strBeforeDec);
String outBeforeDec= priceConversion.convertNumberToWords(beforeDecimal);

 String outAfterDec= "";
 int afterDecimal=0;
 
 if (strUpto2Decimal.length()>1) {
	   afterDecimal= Integer.parseInt(strUpto2Decimal);
	   outAfterDec= " and "+priceConversion.convertNumberToWords(afterDecimal)+ " Paise";;
   }else {
	   String output= priceConversion.getAfterDec(Integer.parseInt(strUpto2Decimal));
	   if (output.length()>0) {
		   outAfterDec= " and "+ output+ " Paise";
	   }else {
		   outAfterDec="";
	   }
   }
 String doubleToStr=outBeforeDec.toUpperCase()+" Rupees ".toUpperCase()+ outAfterDec.toUpperCase()+" Only".toUpperCase();

%>
<%-- <portlet:actionURL var="deleteCampaignURL" name="deleteCampaign">
	<portlet:param name="ProjectId" value="<%= String.valueOf(projectRegistration.getPROJECT_ID()) %>" />
</portlet:actionURL> --%>
	
<%-- 	
	
	
	<h1><center> <%= projectRegistration.getTITLE() %></center></h1>

<center>
<table cellpadding="15" border="1" style="background-color: #cccccc29;">
  <tr>
    <td colspan="2">Requested Fund Amount :</td>
    <td><%= projectRegistration.getREQUIRED_FUND_AMOUNT() %></td>
  </tr>
  <tr>
    <td colspan="2">Received Fund Amount :</td>
    <td><%= totalDonatedAmt %></td>
  </tr>
   <tr>
    <td colspan="2">Pre Withdrawn Amount :</td>
    <td><%= totalDonatedAmt %></td>
  </tr>
   <tr>
    <td colspan="2">Processing Fees(6%):</td>
    <td><%= Math.floor(processingFees) %></td>
  </tr>
   <tr>
    <td colspan="2">Payment Getway Charges(2%):</td>
    <td><%= Math.floor(paymentCharges) %></td>
  </tr>
   <tr>
   	 <td style="border-style: inherit;">   </td>
    <td>Total Amount :</td>
    <td><%= Math.floor(totalAmt) %></td>
  </tr>
</table>
<br>
<br>

<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
<aui:button type="cancel" value="cancel" onClick="window.history.back();" />	
	
</center> --%>



<script>
function printDiv(elementId) {
		var a = document.getElementById('printing-css').value;
		var b = document.getElementById(elementId).innerHTML;
		window.frames["print_frame"].document.title = document.title;
		window.frames["print_frame"].document.body.innerHTML = '<style>' + a + '</style>' + b;
		window.frames["print_frame"].window.focus();
		window.frames["print_frame"].window.print();
	}
</script>
		
<style>
	body {padding:30px}
	.print-area {padding:0.5em;}
</style>


<div id="print-area-1" class="print-area">
	<div class="container-fluid">
		<table id="ca-booking-details" class="table table-striped table-bordered table-hover"  border="1">
			<tbody>
				<tr>
					<td  colspan="10" >
						<center><h3>QUICKDAAN</h3></center>
					</td>
				</tr>
				<tr>
					<td  colspan="2" width="2" style="width: 12%;">
						<img alt="Logo" src=""	style="margin: 22px;width: 88px;height: 75px;">
					</td>
					<td colspan="8">
						<h5 align="right">
						184 & 185 EPIP Zone,<br>
						Whitefield, Bengaluru,<br>
						Karnataka-560066,<br>
						Phone No.: +91 8081880033, <br>
						E- mail : mayuri.prajapati@prakat.in</h5>
					</td>
				</tr>
				<tr>
					<td  colspan="5" >
						<h5 align="left">
						Name: <%= benificiaryObj.getBENIFICIARY_NAME() %><br>
						Address:<%= benificiaryObj.getADDRESS_LINE1() %> , <br>
						 <%= benificiaryObj.getADDRESS_LINE2() %> ,
						 <%= benificiaryObj.getCITY() %>,<br>
						<%= benificiaryObj.getSTATE() %> - <%= benificiaryObj.getPINCODE() %><br>
						<!-- State Code: 02 <br> -->
						</h5>
					</td>
					<td  colspan="5" >
						<h5 align="right">
						Required Fund Amount: <%= projectRegistration.getREQUIRED_FUND_AMOUNT() %><br>
						Mob: <%= benificiaryObj.getCONTACT_NO() %> <br> 
						Email: <%= userData.getEmailAddress() %> <br>
						Date: <%= formatter.format(currentDate)  %>
						</h5>
					</td>
				</tr>
				<tr>
					<td  colspan="8" style="width: 84%;">
						<center><b>Title</b></center>
					</td>
					<td  colspan="2" width="5" >
						<center><b>Amount</b></center>
					</td>
				</tr>
				<tr rowspan="6">
					<th  colspan="8" style="width: 84%;height: 300px;">
						<%= projectRegistration.getTITLE() %>
					</th>
					<th  colspan="2"  style="height: 300px;">
						<%= Math.floor(totalAmt) %>
					</th>
				</tr>
				<tr>
					<td  colspan="6" style="border-style: inherit;">
					</td>
					<td  colspan="2" >
						<center><b>Total Amount</b></center>
					</td>
					<td  colspan="2" >
						<%= Math.floor(totalAmt) %>
					</td>
				</tr>
				<tr>
					<td  colspan="10" >
						<b>Total Amount(In Words): </b> <%= doubleToStr %>
					</td>
				</tr>
				<tr>
				<td colspan="5">Customer's Signature:</td>
				<td colspan="5">Authorised Signatory:</td>
			</tr>
			</tbody>
		</table>
	</div>
</div>



<aui:row style="margin-top:15px;">
	<aui:col span="4"></aui:col>
	<aui:col span="2">
			<a class="no-print" href="javascript:printDiv('print-area-1');"><button>Print</button></a>
	</aui:col>	
	<aui:col span="2">	
			<a class="no-print"><button onClick="window.history.back();">Cancel</button></a> 
	</aui:col>	
	<aui:col span="4"></aui:col>	
</aui:row>


<textarea id="printing-css" style="display:none;">html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,embed,figure,figcaption,footer,header,hgroup,menu,nav,output,ruby,section,summary,time,mark,audio,video{margin:0;padding:0;border:0;font-size:100%;font:inherit;vertical-align:baseline}article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section{display:block}body{line-height:1}ol,ul{list-style:none}blockquote,q{quotes:none}blockquote:before,blockquote:after,q:before,q:after{content:'';content:none}table{border-collapse:collapse;border-spacing:0}body{font:normal normal .8125em/1.4 Arial,Sans-Serif;background-color:white;color:#333}strong,b{font-weight:bold}cite,em,i{font-style:italic}a{text-decoration:none}a:hover{text-decoration:underline}a img{border:none}abbr,acronym{border-bottom:1px dotted;cursor:help}sup,sub{vertical-align:baseline;position:relative;top:-.4em;font-size:86%}sub{top:.4em}small{font-size:86%}kbd{font-size:80%;border:1px solid #999;padding:2px 5px;border-bottom-width:2px;border-radius:3px}mark{background-color:#ffce00;color:black}p,blockquote,pre,table,figure,hr,form,ol,ul,dl{margin:1.5em 0}hr{height:1px;border:none;background-color:#666}h1,h2,h3,h4,h5,h6{font-weight:normal;line-height:normal;margin:1.5em 0 0}h1{font-size:200%}h2{font-size:180%}h3{font-size:160%}h4{font-size:140%}h5{font-size:120%}h6{font-size:100%}ol,ul,dl{margin-left:3em}ol{list-style:decimal outside}ul{list-style:disc outside}li{margin:.5em 0}dt{font-weight:bold}dd{margin:0 0 .5em 2em}input,button,select,textarea{font:inherit;font-size:100%;line-height:normal;vertical-align:baseline}textarea{display:block;-webkit-box-sizing:border-box;-moz-box-sizing:border-box;box-sizing:border-box}pre,code{font-family:"Courier New",Courier,Monospace;color:inherit}pre{white-space:pre;word-wrap:normal;overflow:auto}blockquote{margin-left:2em;margin-right:2em;border-left:4px solid #ccc;padding-left:1em;font-style:italic}table[border="1"] th,table[border="1"] td,table[border="1"] caption{border:1px solid;padding:.5em 1em;text-align:left;vertical-align:top}th{font-weight:bold}table[border="1"] caption{border:none;font-style:italic}.no-print{display:none}</textarea>
<iframe id="printing-frame" name="print_frame" src="about:blank" style="display:none;"></iframe>