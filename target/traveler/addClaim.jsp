<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://struts.apache.org/tags-html" %>


<html:form action="/addClaimSubmit" focus="name">

    <div class="red-text">
        <html:messages id="errors">
            <bean:write name="errors"/><br/>
        </html:messages>
    </div>

    <logic:messagesPresent message="true">
        <html:messages id="claimAdded" message="true">
            <logic:present name="claimAdded">
                <div class="green-text">
                    <bean:write name="claimAdded" filter="false" />
                </div>
            </logic:present>
        </html:messages>
    </logic:messagesPresent>


    <div>

    <bean:message key="claimForm.name"/><br/>
    <html:text property="name" value="someClaim"/><br/>

    <bean:message key="claimForm.email"/><br/>
    <html:text property="email" value="john@opitz.com"/><br/>

    <bean:message key="claimForm.policy"/><br />
    <html:text property="policy" value="123"/><br /><br/>

    <bean:message key="claimForm.claimType"/><br />

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

    <html:select property="claimType">
        <html:optionsCollection property="typeOptions" label="label"  value="key" />
    </html:select>



    <bean:message key="claimForm.claimAmount"/><br />
    <html:text property="claimAmount" value="1"/><br />

    <bean:message key="claimForm.dateOccurred"/>
    <bean:message key="date.format"/><br />
    <html:text property="dateOccurred" value="2008/07/10"/><br />
    <html:submit value="Submit"/><br /><br />

</html:form>
</div>