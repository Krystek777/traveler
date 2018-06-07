<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<%--<html:link target="add"   titleKey="menu.addClaim">--%>
    <%--<bean:message key="menu.addClaim"/>--%>
<%--</html:link>--%>
    <a href="Link.do?method=addClaim"><bean:message key="add.claim.text"/></a><br/>

    <a href="Link.do?method=login"><bean:message key="all.claims"/></a>



