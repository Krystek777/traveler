<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<html:link action="/addClaim" >Add Claim</html:link><br>
<c:choose>
    <c:when test="${loggedUser != null}">
        <html:link action="/allClaims" >All Claims</html:link><br>
    </c:when>
    <c:otherwise>
        <html:link action="/login" >All Claims</html:link>
    </c:otherwise>
</c:choose>

