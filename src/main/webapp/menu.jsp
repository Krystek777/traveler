<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<a href="Link.do?method=addClaim"><bean:message key="add.claim.text"/></a><br>

<c:choose>
    <c:when test="${loggedUser != null}">
        <a href="Link.do?method=allClaims"><bean:message key="all.claims"/></a>
    </c:when>
    <c:otherwise>
        <a href="Link.do?method=login"><bean:message key="all.claims"/></a>
    </c:otherwise>
</c:choose>

