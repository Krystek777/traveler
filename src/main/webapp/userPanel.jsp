<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<div class="default">

    <c:choose>
        <c:when test="${loggedUser != null}">
            <div class="panel-block">
                <bean:message key="hello.text"/>
                <bean:write name="loggedUser" property="username"/>
            </div>
            <div class="panel-block">
                <html:link action="Link.do?method=singOut">
                    <bean:message key="sing.out.text"/>
                </html:link><br>
            </div>
        </c:when>
        <c:otherwise>
            <div class="panel-block">
                <html:link action="Link.do?method=login">
                    <bean:message key="sign.in.text"/>
                </html:link><br>
            </div>

            <div class="panel-block">
                <html:link action="Link.do?method=signUp">
                    <bean:message key="sign.up.text"/>
                </html:link><br>
            </div>

        </c:otherwise>
    </c:choose>
</div>

