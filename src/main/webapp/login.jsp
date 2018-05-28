<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="/baseLayout.jsp" flush="true">
    <tiles:put name="title" value="Claim Manager" />
    <tiles:put name="header" value="/header.jsp" />
    <tiles:put name="menu" value="/menu.jsp" />
    <tiles:put name="body" value="/loginTile.jsp" />
    <tiles:put name="footer" value="/footer.jsp" />
</tiles:insert>
