<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

   <head>
        <title>Claims</title>
        <link rel="stylesheet" type="text/css" href="styles/styles.css">
    </head>
<body>
<table>
    <tr>
        <td><bean:message key="claimForm.name"/></td>
        <td><bean:message key="claimForm.email"/></td>
        <td><bean:message key="claimForm.policy"/></td>
        <td><bean:message key="claimForm.claimType"/></td>
        <td><bean:message key="claimForm.claimAmount"/></td>
        <td><bean:message key="claimForm.dateOccurred"/></td>
        <td><bean:message key="claimForm.status"/></td>

    </tr>
    <logic:iterate name="claims" id="claimId">
        <tr>
            <td><bean:write name="claimId" property="name"/></td>
            <td><bean:write name="claimId" property="email"/></td>
            <td><bean:write name="claimId" property="policy"/></td>
            <td><bean:write name="claimId" property="claimType"/></td>
            <td><bean:write name="claimId" property="claimAmount"/></td>
            <td><bean:write name="claimId" property="dateOccurred" /></td>
            <td><bean:write name="claimId" property="status" /></td>
        <tr/>
    </logic:iterate>
</table>
</body>
</html>
