
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Claim Form</title>
</head>
<body>

<html:form action="/addClaim" focus="name">
    claim.name : <html:text property="claimType"/><br/>
    Email : <html:text property="email"/><br/>
    Policy : <html:text property="policy"/><br/><br/>
    Claim Type:
    <html:select multiple="true" property="claimType">
        <html:option value="Lost baggage"/>
        <html:option value="Theft"/>
        <html:option value="illness"/>
        <html:option value="Accident"/>
    </html:select><br/><br/>
    ClaimAmount : <html:text property="claimAmount"/><br/>
    DateOccured (yyyy-mm-dd): <html:text property="dateOccurred"/><br/>
    <html:submit value="Submit"/>

    <br><br><a href="./login.jsp">Log in</a>
</html:form>
</body>
</html>

