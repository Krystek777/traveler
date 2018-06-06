<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="bean" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
<h3 style="color:red"><bean:message key="failure.text"/></h3>
    <jsp:include page="loginTile.jsp"/>

</div>