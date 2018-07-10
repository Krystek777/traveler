<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://struts.apache.org/tags-html" %>


<html:form action="/addClaimSubmit" focus="name">

    <div class="text-danger">
        <html:messages id="errors">
            <bean:write name="errors"/><br/>
        </html:messages>
    </div>



    <div class="p-3">

    <div class="m-1">
    <bean:message key="claimForm.name"/><br/>
    <html:text property="name" value="someClaim"/><br/>
    </div>

    <div class="m-1">
    <bean:message key="claimForm.email"/><br/>
    <html:text property="email" value="john@opitz.com"/><br/>
    </div>

    <div class="m-1">
    <bean:message key="claimForm.policy"/><br />
    <html:text property="policy" value="123"/><br /><br/>
    </div>

    <div class="m-1">
    <bean:message key="claimForm.claimType"/><br />
    </div>

    <%--<html:select multiple="true" property="claimType">--%>
        <%--<logic:iterate name="claimForm" property="typeOptions" id="option">--%>

            <%--<html:option value="{claimForm.typeOptions.key}">--%>
                <%--<bean:define id="label" toScope="page" type="java.lang.String">--%>
                    <%--<bean:message key="claimForm.types.prefix"/><bean:write name="option" property="claimType"/>--%>
                <%--</bean:define>--%>
                <%--<bean:message name="label"/>--%>
            <%--</html:option>--%>
        <%--</logic:iterate>--%>

    <%--</html:select><br/><br/>--%>

    <div class="m-1">
    <html:select property="claimType">
        <html:optionsCollection property="typeOptions" label="label"  value="key" />
    </html:select>
    </div>

    <div class="m-1">
    <bean:message key="claimForm.claimAmount"/><br />
    <html:text property="claimAmount" value="1"/><br />
    </div>

    <div class="m-1">
    <bean:message key="claimForm.dateOccurred"/>
    <bean:message key="date.format"/><br />
    <html:text property="dateOccurred" value="2008/07/10"/><br />
    </div>

    <div class="m-2">
    <html:submit styleClass="btn btn-outline-light" value="Submit"/><br /><br />
    </div>

</html:form>
</div>