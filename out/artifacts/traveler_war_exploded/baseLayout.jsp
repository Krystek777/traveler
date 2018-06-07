

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title" ignore="true" /></title>
        <link rel="stylesheet" type="text/css" href="styles/globalStyles.css">
    </head>
    <body>
        <div class="loginPanel">
            <tiles:insert attribute="loginPanel"/>
        </div>
        <div class="header">
            <tiles:insert attribute="header"/>
        </div>
        <div class="sidebar">
            <tiles:insert attribute="menu" />
        </div>
        <div class="content">
            <tiles:insert attribute="body" />
        </div>
        <div class="footer">
            <tiles:insert attribute="footer" />
        </div>
    </body>
</html>