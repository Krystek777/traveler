
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://struts.apache.org/tags-html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Claim</title>
</head>
<body>
<p>
<html:form action="/addClaim" focus="name">

    <div style="color:red">
        <html:messages id="errors">
        <bean:write name="errors"/><br/>
        </html:messages>
    </div>

    <bean:message key="claimForm.name"/><br/>
    <html:text property="name"/><br/>

    <bean:message key="claimForm.email"/><br/>
    <html:text property="email"/><br/>

    <bean:message key="claimForm.policy"/><br/>
    <html:text property="policy"/><br/><br/>

    <bean:message key="claimForm.claimType"/><br/>
    <html:select multiple="true" property="claimType">
        <html:option value="Lost baggage"/>
        <html:option value="Theft"/>
        <html:option value="illness"/>
        <html:option value="Accident"/>
    </html:select><br/><br/>

    <bean:message key="claimForm.claimAmount"/><br/>
    <html:text property="claimAmount"/><br/>

    <bean:message key="claimForm.dateOccurred"/>
    <bean:message key="date.format"/>
    <br/><html:text property="dateOccurred"/><br/>
    <html:submit value="Submit"/><br/><br/>

    <br><br><a href="./login.jsp">Log in</a>
</html:form>
</p>
</body>
</html>

