<%@ include file="/jsp/init.jsp" %>

<portlet:actionURL name="NewsletterRegistration" var="NewsletterRegistrationURL">
</portlet:actionURL>

<aui:form action="${NewsletterRegistrationURL}" method="post" enctype="multipart/form-data">

    
	<aui:input name="newslettertitle" label="Title:" placeholder="enter title" type="text"></aui:input>
	<aui:input name="newsletterdetail" label="Detail:" type="textarea"></aui:input>
	<aui:input name="file" label="Attachment" type="file"></aui:input> 
	
	<aui:button name="submit" type="submit" value="Submit" />
	
</aui:form>