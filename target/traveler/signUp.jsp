<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<div class="red-text">
    <h4><c:out value="${param['message']}"/></h4>
</div>

<html:form action="/saveUser" focus="username">

    <div class="text-danger">
        <html:messages id="errors">
            <bean:write name="errors"/><br>
        </html:messages>
    </div>

    <div class="m-1">
        <bean:message key="signUpForm.username"/><br>
        <html:text property="username" value="mark"/><br>
    </div>

    <div class="m-1">
        <bean:message key="signUpForm.email"/><br>
        <html:text property="email" value="john@tr.pl"/><br>
    </div>

    <div class="m-1">
        <bean:message key="signUpForm.password"/><br>
        <html:password property="password" value="1234"/><br>
    </div>

    <div class="m-1">
        <bean:message key="signUpForm.confirm.password"/><br>
        <html:password property="confirmPassword" value="1234"/><br>
    </div>

    <div class="m-1">
        <html:submit styleClass="btn btn-outline-light" value="Submit"/><br>
    </div>

</html:form>
