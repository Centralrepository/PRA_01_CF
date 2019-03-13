<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Collection"%>
<%@page import="com.crowd.funding.database.service.DonorRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DonorRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectFollowerRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectFollowerRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectUpdateRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectUpdateRegistration"%>
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
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());

float donatedAmount = 0;
List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());

for(FundRegistration fundAmtObj : fundAmtList){
	donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
}
double donatedAmountInPercentage = (donatedAmount*100)/projectRegistration.getREQUIRED_FUND_AMOUNT();

%>
								<!-- ---------CSS Start--------- -->

<style>
	
	h1{
		text-align: center;
		font-size: 1.6em;
        font-weight: 600;
    color: #5d5d5d;
   
}

.container{
	width: 100%;

}

.card-body {
    box-shadow: 1px 2px 10px 0 #d8d8d8;
    border-radius: 2px;
   
}
.card-body-new {
    box-shadow: 1px 2px 10px 0 #d8d8d8;
    border-radius: 2px;
    padding: 5%;
   
}

.payment-options {
    font-size: 12px;
    color: #999999;
    margin-top: 5px;
    margin-bottom: 0px;
}

.seperater {
    margin: 10px 0px;
    font-size: 10px;
}

.seperater span {
    display: inline-block;
    width: 60px;
    border: 1px solid #d0d0d0;
    height: 1px;
    margin: 3px 10px;
}

.btn-primary {
    color: #fff;
    background-color: #b91141;
    border-color: #b91141;
}



  .btn-success:hover, .btn-success:active, .btn-success:focus {
  color: #fff !important;
  background-color: #a20f39 !important;
  border-color: #a20f39 !important;
}

.well{
	
	box-shadow: 0px 1px 5px #888888;
	height: 68px;
}

.well-lg{
box-shadow: 0px 1px 5px #888888;
	height: auto;
	padding: 2%;
}

.btn-facebook {
	color: #fff;
	background-color: #4C67A1;
  }
.btn-facebook:hover {
	color: #fff;
	background-color: #405D9B;
}
.btn-facebook:focus {
	color: #fff;
}

.btn-twitter{
	font-size:24px;background: #55ACEE;display: inline-block;
    margin-bottom: 0;
    font-weight: normal;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    background-image: none;
    border: 1px solid transparent;
    white-space: nowrap;
    padding: 6px 12px;
    font-size: 20px;
    line-height: 1.7;
    border-radius: 4px;
    color: white;
        height: 48px;
    margin-top: 9px;
}

@import url(https://fonts.googleapis.com/css?family=Open+Sans:400italic);
blockquote{
  font-size: 1.1em;
  margin:50px auto;
  font-family:Open Sans;
  font-style:italic;
  color: #555555;
  padding:1.2em 30px 1.2em 75px;
  border-left:8px solid #b91141 ;
  line-height:1.6;
  position: relative;
  background:#EDEDED;
  width: 100%;
}

blockquote::before{
  font-family:Arial;
  content: "\201C";
  color:#78C0A8;
  font-size:4em;
  position: absolute;
  left: 10px;
  top:-10px;
}

blockquote::after{
  content: '';
}

blockquote span{
  display:block;
  color:#333333;
  font-style: normal;
  font-weight: bold;
  margin-top:1em;
}

</style>

<style>
	.tab {
		border: 0px;
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
  width: 100%;
      border-bottom: 2px solid #b91141;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
  width: 50%

}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {

  display: ;
  padding: 6px 12px;
  -webkit-animation: fadeEffect 1s;
  animation: fadeEffect 1s;
  width: 100%;
}

/* Fade in tabs */
@-webkit-keyframes fadeEffect {
  from {opacity: 0;}
  to {opacity: 1;}
}

@keyframes fadeEffect {
  from {opacity: 0;}
  to {opacity: 1;}
}


.progress-bar1 {
  position: relative;
  height: 100px;
  width: 100px;
  margin:0 auto;
}
 
.progress-bar1 div {
  position: absolute;
  height: 100px;
  width: 100px;
  border-radius: 50%;
}
 
.progress-bar1 div span {
  position: absolute;
  font-family: Arial;
  font-size: 22px;
  line-height: 75px;
  height: 75px;
  width: 75px;
  left: 12.5px;
  top: 12.5px;
  text-align: center;
  border-radius: 50%;
  background-color: white;
}
 
.progress-bar1 .background { background-color: #b3cef6; }
 
.progress-bar1 .rotate {
  clip: rect(0 50px 100px 0);
  background-color: #4b86db;
}
 
.progress-bar1 .left {
  clip: rect(0 50px 100px 0);
  opacity: 1;
  background-color: #b3cef6;
}
 
.progress-bar1 .right {
  clip: rect(0 50px 100px 0);
  transform: rotate(180deg);
  opacity: 0;
  background-color: #4b86db;
}
 
@keyframes
toggle {  0% {
 opacity: 0;
}
 100% {
 opacity: 1;
}
}  


.campaign-no-overlay .campaign-owner-details {
    padding: 10px;
    background-color: #ecedee;
    margin-top: 30px;
    font-size: 10px;
    border-radius: 2px;
}
/* forms */

.customPagination, .paginacaoCursor{
    
      padding: 5px 8px;
      color: #fff;
      background: #b91141;
      cursor: pointer;
    }
</style>

<style>
.container1 {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
  
}

.container1::after {
  content: "";
  clear: both;
  display: table;
}

.container1 img {
  float: left;
  max-width: 60px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

.container1 img.right {
  float: right;
  margin-left: 20px;
  margin-right:0;
}

.time-left {
  float: left;
  color: #999;
}

.time-right {
  float: right;
  color: #999;
}
</style>

									<!-- ---------End of CSS--------- -->

										<!-- CAMPAIGN TITLE -->

<div class="container">
<h1 class="campaign-title"><%= projectRegistration.getTITLE() %></h1>
<br><br>
											<!-- Slideshow -->

	<div style="box-shadow: 1px 2px 65px 0 #d8d8d8;border-radius: 2px;width: 64%; margin-left: 18%;">
	<div style="max-width:400px; margin-left:3%;padding: 1em;">
	<div class="mySlides" style="height:452px;width:603px;">
   <portlet:resourceURL  var="imageResourceURL">
							<portlet:param name="serverResourceCall" value="ProjectIDForProjectImage"/>
							<portlet:param name="ProjectIDForProjectImage" value="<%= String.valueOf(projectRegistration.getPROJECT_ID())  %>"/>
						</portlet:resourceURL>
				<img src="${imageResourceURL}" alt="Image" />
	</div>
	<div class="mySlides" style="height: 452px;width: 603px;">
    <h4 style="text-align: center;">Update</h4>
	</div>

	<div class="mySlides" style="height: 452px;width: 603px;">
    <h3 style="color: #b91141">Rs.<%= donatedAmount %>  </h3>
   
  										 <!--  progress bar -->
   
    <div class="progress">
	</div><br>
    <p style="color:#5d5d5d">raised of Rs.<%= projectRegistration.getREQUIRED_FUND_AMOUNT() %>  goal</p>
 	</div>
	<br>
	</div>
	</div>
	<br>
										<!-- end of slideshow -->

<div class="well">&nbsp&nbsp<a href="https://www.facebook.com/sharer/sharer.php?s=100&p[url]=http://127.0.0.1:8080/web/crowd-funding/campaing-details?p_p_id=CampaignDetails_INSTANCE_VPb8QZWCoDrF&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_jspPage=%2Fjsp%2FCampaign%20Details%2FCampaignDetails.jsp&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_projectID=101&p[images][0]=&p[title]=8-Year-Old With 100% Damaged Liver Has Few Hours Left For A Transplant&p[summary]=dzcdvsdvsddssdsdfsdfsdfsdf!" target="_blank" onclick="window.open(this.href,'targetWindow','toolbar=no,location=0,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=250'); return false"><button style="width:33%; margin-top:10px;" type="button" class="btn btn-facebook btn-lg"><i class="fa fa-facebook fa-2"></i> Share on Facebook</button></a>&nbsp&nbsp<a href="http://twitter.com/share?&url=http://127.0.0.1:8080/web/crowd-funding/campaing-details?p_p_id=CampaignDetails_INSTANCE_VPb8QZWCoDrF&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_jspPage=%2Fjsp%2FCampaign%20Details%2FCampaignDetails.jsp&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_projectID=101" class="twitter-share-button" data-show-count="false" onclick="window.open(this.href,'targetWindow','toolbar=no,location=0,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=250'); return false"><button class="btn-twitter"style="width:33%;">Share on Twitter<i class="fa fa-twitter"></i></button></a></div>
 <br><br>
 
 											<!-- CAMPAIGN DETAILS -->

<div class="row">
<div class="col-md-8" >
<div class="tab">
<button class="tablinks" onclick="openCity(event, 'Story')">Story</button>
<button class="tablinks" onclick="openCity(event, 'Update')">Update</button>
</div>

<div id="Story" class="tabcontent">
  <h3>Story</h3><br>
  <p><%= projectRegistration.getDESCRIPTION() %></p>
  <br>
  <div>
  <h4>Supporting documents: </h4>
    <%
					  List<DocumentRegistration> documentList = DocumentRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
					  for(DocumentRegistration documentObj : documentList){
					  %>
						 <portlet:resourceURL  var="ProjectDocumentResourceURL">
							<portlet:param name="serverResourceCall" value="ProjectIDForDocument"/>
							<portlet:param name="ProjectDocumentID" value="<%= String.valueOf(documentObj.getPROJECT_DOCUMENT_ID())  %>"/>
						 </portlet:resourceURL>
				    <a href="${ProjectDocumentResourceURL}" alt="Document" />Document</a>
		
				  	<% } %>
  
 </div><br>
 <div>
<p class="bank-account__title voffset-down2">You can also do a bank transfer to the below mentioned account setup for this fundraising campaign:</p>
	<p>Account number: 8080811062668</p>
	<p>Account name: Nagarjan</p>
	<p>IFSC code: YESB0CMSNOC</p>
</div>
<br>
											<!--  campaign owner details -->

<div class="campaign-owner-details campaign-section clearfix">
<p>Posted By : <%= userData.getFullName() %></p>
</div>


<div class="card-body-new">		
				
				
							<!-- AFTER DONATE OPTIONS -->
<%
long ProjectId = Long.parseLong(projectID);
ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<FundRegistration> fundList = FundRegistrationLocalServiceUtil.findByPROJECT_DONOR_USER_ID(projectRegistration.getPROJECT_ID(), themeDisplayObj.getUserId());
if(fundList.size() > 0){
%>

			<portlet:renderURL var="AskAQuestionURL" windowState="normal">
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
				<portlet:param name="jspPage" value="/jsp/post_donations/Q&A/AskQuestion.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${AskAQuestionURL}"  value="Ask Question?"/>
			
			 <portlet:renderURL var="FeedbackURL" windowState="normal">
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
				<portlet:param name="jspPage" value="/jsp/post_donations/feedback/Feedback.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${FeedbackURL}"  value="Feedback"/>
			
			<portlet:actionURL name="updateRequestRegistration" var="updateRequestRegistrationURL" >
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
			</portlet:actionURL>
			<aui:button type="button" onClick="${updateRequestRegistrationURL}"  value="Ask for an Update"/>
			
<%} %>
							
							<!-- DONATE OPTION FOR USER -->
							
<%
boolean signedIn = themeDisplayObj.isSignedIn();
String FundOtpId = renderRequest.getParameter("FundOtpId");
	if(signedIn == false){
%>
			<portlet:renderURL var="DonateRegistrationURL" windowState="normal">
				<portlet:param name="ProjectId" value="<%=String.valueOf(ProjectId) %>" />
				<portlet:param name="jspPage" value="/jsp/payment/DonorRegistrationForm.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${DonateRegistrationURL}"  value="I Want to Contribute"/>
			

		<%}else{ %>

			<portlet:actionURL name="donationAmount" var="donationAmountURL" />
			
		<form action="${donationAmountURL}" method="post" >

          <input name="<portlet:namespace/>projectId" type="hidden" value="<%= projectID %>">
          <input  name="<portlet:namespace/>FundOtpId" type="hidden" value="<%= FundOtpId %>">
        
            <%if(signedIn == true){ %>
            <aui:input label="Donate Anonymously" name="donateAnonymously" type="radio" value="Yes" />
            <% } %>
            <br>
            <div class="row" style="margin-left: .1em;">
              		<select class="form-control" name="<portlet:namespace/>currency" style="padding-right:0; padding-left:12px; width:6em; ">
                            <option value="USD">USD $</option>
                            <option selected value="INR">INR &#8377;</option>
                    </select>
                        
              		&nbsp<input name="<portlet:namespace/>amount" type="text" class="form-control manual-payment payment-amt"  style="width:179px;"> 
            </div>
              <br>
              <aui:input name="message" label="Message for Benificiary"></aui:input><br>
              <input type="submit" name="commit" value="Donate now" style="width: 45%;margin-left: 10em" class="btn btn-primary btn-block text-bold btn-success" >
        
      </form>
	<%} %>
</div>
</div>
		
		<!--  CAMPAIGN UPDATE TAB -->



<div id="Update" class="tabcontent">
<% 
List<ProjectUpdateRegistration> projectUpdateList = ProjectUpdateRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
int counter = 1;
for(ProjectUpdateRegistration projectUpdateObj : projectUpdateList){
%>
<div class="container1 darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= projectUpdateObj.getUPDATE_DETAILS() %></p>
 	 <span class="time-left"><%= projectUpdateObj.getUPDATE_DATE() %></span>
</div>

<% } %>
</div>
<hr>
</div>

										<!-- side column start -->

	<div class="col-md-4" style="border-left: 1px solid #5d5d5d; solid" >
	<h4 style="color: #5d5d5d;">Donate</h4>
	<hr>
	
              <br>
  <p class="payment-options" data-for-currency="inr" style="margin-left: 3em;" >Payment options: Online, cheque pickups</p>
  <div class="seperater col-sm-12 text-center"><span></span>OR<span></span></div>
  <img style="margin-left:1.5em;" src="/portal_content/c.png">
  <br><br>
  <div class="progress-bar1" data-percent="<%= Math.floor(donatedAmountInPercentage) %>" data-duration="1000" data-color="#ccc,#b91141"></div>
  <br>
  <div> <p style="color:#5d5d5d; margin-left: 1em; " >Raised From Total Goal of INR. <%= projectRegistration.getREQUIRED_FUND_AMOUNT() %></p></div>
  <br><hr>
  <h5 style="color: #5d5d5d;"><i class="fa fa-group" style="color: #01bfbd; font-size: 25px;"></i>&nbsp&nbspSupporters</h5><hr>
				<%
					String donorName = null;
					List<FundRegistration> donatedFundList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
					
					for(FundRegistration fundObj : donatedFundList){
						if(fundObj.getDONOR_STATUS() == 0){
							donorName = "Anonymous Donor";
						}else{
							if(fundObj.getDONOR_USER_ID() == 0){
								DonorRegistration donorObj = DonorRegistrationLocalServiceUtil.findByDONOR_ID(fundObj.getDONOR_ID());
								donorName = donorObj.getNAME();
							}else{
								UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(fundObj.getDONOR_USER_ID());
								donorName = userObj.getFULL_NAME();
							}
						} %>
						<ul class="paginationList list-group">
					 <li class="listItem list-group-item" style="border: none;">	<label style="color: #01bfbd" ><%= donorName %></label> has donated <i class="fa fa-inr" style="color:#b91141 "></i> <label style="color:#b91141 "><%= fundObj.getDONATED_AMOUNT() %> &#8377; </label><br>
						<label style="font-size: small;"><%= fundObj.getCOMMENT() %></label><hr style="width: 65%"></li> </ul>
						<%
					}
				%>
				<div style="margin-left: 6em;" id="pagination-container1"> 
				 <p class='paginacaoCursor' id="beforePagination"><</p>
            <p class='paginacaoCursor' id="afterPagination">></p> </div>    
				<br>
				<hr>
				</div>	
				</div>
				</div>
				</div>
				<br><br>


												<!--------JS------- -->

										<!-- script for circular progress bar -->

<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script>
;
(function ($) {
	$.fn.loading = function () {
		var DEFAULTS = {
			backgroundColor: '#b3cef6',
			progressColor: '#4b86db',
			percent: 75,
			duration: 2000
		};	
		
		$(this).each(function () {
			var $target  = $(this);

			var opts = {
			backgroundColor: $target.data('color') ? $target.data('color').split(',')[0] : DEFAULTS.backgroundColor,
			progressColor: $target.data('color') ? $target.data('color').split(',')[1] : DEFAULTS.progressColor,
			percent: $target.data('percent') ? $target.data('percent') : DEFAULTS.percent,
			duration: $target.data('duration') ? $target.data('duration') : DEFAULTS.duration
			};
			// console.log(opts);
	
			$target.append('<div class="background"></div><div class="rotate"></div><div class="left"></div><div class="right"></div><div class=""><span>' + opts.percent + '%</span></div>');
	
			$target.find('.background').css('background-color', opts.backgroundColor);
			$target.find('.left').css('background-color', opts.backgroundColor);
			$target.find('.rotate').css('background-color', opts.progressColor);
			$target.find('.right').css('background-color', opts.progressColor);
	
			var $rotate = $target.find('.rotate');
			setTimeout(function () {	
				$rotate.css({
					'transition': 'transform ' + opts.duration + 'ms linear',
					'transform': 'rotate(' + opts.percent * 3.6 + 'deg)'
				});
			},1);		

			if (opts.percent > 50) {
				var animationRight = 'toggle ' + (opts.duration / opts.percent * 50) + 'ms step-end';
				var animationLeft = 'toggle ' + (opts.duration / opts.percent * 50) + 'ms step-start';  
				$target.find('.right').css({
					animation: animationRight,
					opacity: 1
				});
				$target.find('.left').css({
					animation: animationLeft,
					opacity: 0
				});
			} 
		});
	}
})(jQuery);

</script>

<script>
$(".progress-bar1").loading();
     
</script>
											<!-- script for tab  -->
<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>
											<!-- script for carousel -->
<script>
var slideIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none"; 
  }
  slideIndex++;
  if (slideIndex > x.length) {slideIndex = 1} 
  x[slideIndex-1].style.display = "block"; 
  setTimeout(carousel, 5000); 
}
</script>
 <div id="fb-root"></div>
 												<!-- script for fb -->
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v3.2&appId=1990258291089302&autoLogAppEvents=1';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

												<!-- Script for pagination -->
<script>
$(document).ready(function(){

	  var HZperPage = 3,//number of results per page
	     HZwrapper = 'paginationList',//wrapper class
	     HZlines   = 'listItem',//items class
	     HZpaginationId ='pagination-container1',//id of pagination container
	     HZpaginationArrowsClass = 'paginacaoCursor',//set the class of pagi
	     HZpaginationColorDefault =  '#b91141',//default color for the pagination numbers
	     HZpaginationColorActive = '#01bfbd', //color when page is clicked
	     HZpaginationCustomClass = 'customPagination'; //custom class for styling the pagination (css)

	  function paginationShow(){if($("#"+HZpaginationId).children().length>8){var a=$(".activePagination").attr("data-valor");if(a>=4){var i=parseInt(a)-3,o=parseInt(a)+2;$(".paginacaoValor").hide(),exibir2=$(".paginacaoValor").slice(i,o).show()}else $(".paginacaoValor").hide(),exibir2=$(".paginacaoValor").slice(0,5).show()}}paginationShow(),$("#beforePagination").hide(),$("."+HZlines).hide();for(var tamanhotabela=$("."+HZwrapper).children().length,porPagina=HZperPage,paginas=Math.ceil(tamanhotabela/porPagina),i=1;i<=paginas;)$("#"+HZpaginationId).append("<p class='paginacaoValor "+HZpaginationCustomClass+"' data-valor="+i+">"+i+"</p>"),i++,$(".paginacaoValor").hide(),exibir2=$(".paginacaoValor").slice(0,5).show();$(".paginacaoValor:eq(0)").css("background",""+HZpaginationColorActive).addClass("activePagination");var exibir=$("."+HZlines).slice(0,porPagina).show();$(".paginacaoValor").on("click",function(){$(".paginacaoValor").css("background",""+HZpaginationColorDefault).removeClass("activePagination"),$(this).css("background",""+HZpaginationColorActive).addClass("activePagination");var a=$(this).attr("data-valor"),i=a*porPagina,o=i-porPagina;$("."+HZlines).hide(),exibir=$("."+HZlines).slice(o,i).show(),"1"===a?$("#beforePagination").hide():$("#beforePagination").show(),a===""+$(".paginacaoValor:last").attr("data-valor")?$("#afterPagination").hide():$("#afterPagination").show(),paginationShow()}),$(".paginacaoValor").last().after($("#afterPagination")),$("#beforePagination").on("click",function(){var a=$(".activePagination").attr("data-valor"),i=parseInt(a)-1;$("[data-valor="+i+"]").click(),paginationShow()}),$("#afterPagination").on("click",function(){var a=$(".activePagination").attr("data-valor"),i=parseInt(a)+1;$("[data-valor="+i+"]").click(),paginationShow()}),$(".paginacaoValor").css("float","left"),$("."+HZpaginationArrowsClass).css("float","left");
	})
</script>

										<!-- ---------End of JS------------ -->





												<!-- CAMPAIGN COMMENT -->

<label><B>CAMPAIGN COMMENT</B></label>	<BR>
<%
List<CommentRegistration> commentList = CommentRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(ProjectId, CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_1);
for(CommentRegistration commentObj : commentList){
	User CurrentUserData = UserLocalServiceUtil.fetchUser(commentObj.getDONOR_USER_ID());
%>
<div class="container1 darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= commentObj.getCOMMENT() %></p>
 	 <span class="time-left"><%= commentObj.getCOMMENT_DATE() %> | <%= CurrentUserData.getFullName() %></span>
</div>
<div class="container1 darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= commentObj.getANSWER() %></p>
 	 <span class="time-right"><%= commentObj.getCOMMENT_DATE() %> | <%= CurrentUserData.getFullName() %></span>
</div>
<% } %>

<portlet:actionURL var="commentDetailsURL" name="commentDetails"></portlet:actionURL>

<aui:form action="${commentDetailsURL}" method="post" >
	<aui:input type="hidden" name="projectID" value="<%= ProjectId %>"></aui:input>
	<aui:input name="commentData" type="textarea" label="Comments :"/>
	<aui:button type="submit" value="Submit"  />
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form>

					<!-- CAMPAIGN FOLLOWER -->
<portlet:actionURL name="projectFollowerRegistration" var="projectFollowerRegistrationURL" />					
<portlet:actionURL name="projectUnFollowRegistration" var="projectUnFollowRegistrationURL" />	
				
<%
if(signedIn == true){ 
List<ProjectFollowerRegistration> projectfollwerList = ProjectFollowerRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
boolean userFollowerStatus = false;

		for(ProjectFollowerRegistration followerObj : projectfollwerList){
			if(followerObj.getUSER_ID() == themeDisplayObj.getUserId() && followerObj.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_FOLLOWER_STATUS_1 )
				userFollowerStatus = true;
		}
		
			if(userFollowerStatus == false){ %>
				<aui:form action="${projectFollowerRegistrationURL}" method="post" >
					<aui:input name="projectId" type="hidden" value="<%= projectID %>"></aui:input>
						<aui:button name="submit" type="submit" value="Follow Campaign" />
				</aui:form> 

		<% }else{%>
				<aui:form action="${projectUnFollowRegistrationURL}" method="post" >
						<aui:input name="projectId" type="hidden" value="<%= projectID %>"></aui:input>
						<aui:input name="userId" type="hidden" value="<%= themeDisplayObj.getUserId() %>"></aui:input>
							<aui:button name="submit" type="submit" value="Unfollow Campaign" />
				</aui:form> 
	
		<% 		
			}
		} %>
