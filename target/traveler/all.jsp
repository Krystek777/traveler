<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Claims</title>
</head>
<body>
<table>
    <logic:iterate name="claims" id="claimId">
        <tr>
            <td><bean:write name="claimId" property="name"/></td>
            <td><bean:write name="claimId" property="email"/></td>
            <td><bean:write name="claimId" property="policy"/></td>
            <td><bean:write name="claimId" property="claimType"/></td>
            <%--<td><bean:write name="claimId" property="claimAmount"/></td>--%>
            <%--<td><bean:write name="claimId" property="dateOccurred" /></td>--%>
        <tr/>
    </logic:iterate>
</table>
</body>
</html>
