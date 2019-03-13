<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL name="NewsletterSubscription" var="NewsletterSubscriptionURL">
</portlet:actionURL>



<aui:form action="${NewsletterSubscriptionURL}" method="post" >

    
	<aui:input name="newsletter" label="Newsletter" placeholder="enter your email" type="text"></aui:input>
	<aui:button name="submit" type="submit" value="Subscribe" />
	
</aui:form>