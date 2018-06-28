<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
            <logic:messagesPresent message="true">
                <html:messages id="message" message="true">
                    <div class="green-text"><bean:write name="message"/><br/></div>
                </html:messages>
            </logic:messagesPresent>

            <tiles:insert attribute="body"/>
        </div>
        <div class="footer">
            <tiles:insert attribute="footer"/>
        </div>
    </body>
</html>