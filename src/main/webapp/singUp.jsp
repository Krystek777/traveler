<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html:form action="/singUp" focus="username">

    <p style="color:red">
        <%
            String m = request.getParameter("message");
            if (m == null)
                m = "";
            out.print(m);
        %>
    </p>


    <div style="color:red">
        <html:messages id="errors">
            <bean:write name="errors"/><br>
        </html:messages>
    </div>


    <bean:message key="singUpForm.username"/><br>
    <html:text property="username" value="mark"/><br>

    <bean:message key="singUpForm.email"/><br>
    <html:text property="email" value="john@tr.pl"/><br>

    <bean:message key="singUpForm.password"/><br>
    <html:password property="password" value="1234"/><br>

    <bean:message key="singUpForm.confirm.password"/><br>
    <html:password property="confirmPassword" value="1234"/><br>

    <html:submit value="Submit"/><br><br>

</html:form>
