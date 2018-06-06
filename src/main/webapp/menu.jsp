<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<%--<html:link target="add"   titleKey="menu.addClaim">--%>
    <%--<bean:message key="menu.addClaim"/>--%>
<%--</html:link>--%>
    <a href="Link.do?method=addClaim"><bean:message key="add.claim.text"/></a><br>

    <a href="Link.do?method=login"><bean:message key="admin.panel.text"/></a>



