<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>
        <bean:define  id="title" toScope="request" type="java.lang.String">
            <tiles:getAsString name="titleKey" ignore="true"/>
        </bean:define>
        <bean:message name="title"/>

    </title>
    <link rel="stylesheet" type="text/css" href="styles.css" />
</head>
    <body>
        <div class="loginPanel">
            <tiles:insert attribute="loginPanel"/>
        </div>
        <div class="header">
            <tiles:insert attribute="header"/>
        </div>
        <div class="sidebar">
            <tiles:insert attribute="menu"/>
        </div>
        <div class="content">
            <tiles:insert attribute="body"/>
        </div>
        <div class="footer">
            <tiles:insert attribute="footer"/>
        </div>
    </body>
</html>