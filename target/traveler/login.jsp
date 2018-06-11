<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

if
<h3 class="red-text"><bean:message key="failure.content"/></h3>
end
<html:form action="/loginSubmit" focus="username">
    <bean:message key="login.username"/>
    <html:text property="username"/><br>
    <bean:message key="login.password"/>
    <html:password property="password"/><br>
    <html:submit value="Submit"/>
</html:form>
