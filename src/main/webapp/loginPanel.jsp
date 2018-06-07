<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<div style="background-color: mediumseagreen;">

    <c:choose>
        <c:when test="${loggedUser != null}">
            <div style="display: inline-block;padding:10px;">
                <bean:message key="hello.text"/>
                <bean:write name="loggedUser" property="username"/>
            </div>

            <div style="display: inline-block;padding:10px;">
                <a href="Link.do?method=singOut">Sing Out</a>
            </div>

        </c:when>
        <c:otherwise>
            <div style="display: inline-block;padding:10px;">
                <a href="Link.do?method=login">Log in</a>
            </div>

            <div style="display: inline-block;padding:10px;">
                <a href="Link.do?method=singUp">Sing Up</a>
            </div>

        </c:otherwise>
    </c:choose>



</div>

