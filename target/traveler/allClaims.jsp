<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:choose>
    <c:when test="${loggedUser == null}">
        <jsp:forward page="/login.do"/>
    </c:when>
    <c:otherwise>

        <div>
            <table>
                <tr>
                    <th><bean:message key="claimForm.id"/></th>
                    <th><bean:message key="claimForm.name"/></th>
                    <th><bean:message key="claimForm.email"/></th>
                    <th><bean:message key="claimForm.policy"/></th>
                    <th><bean:message key="claimForm.claimType"/></th>
                    <th><bean:message key="claimForm.claimAmount"/></th>
                    <th><bean:message key="claimForm.dateOccurred"/></th>
                    <th><bean:message key="claimForm.status"/></th>
                    <th><bean:message key="claimForm.changeStatus"/></th>

                </tr>
                <logic:iterate name="claims" id="claimItem">
                    <tr>
                        <td><bean:write name="claimItem" property="id"/></td>
                        <td><bean:write name="claimItem" property="name"/></td>
                        <td><bean:write name="claimItem" property="email"/></td>
                        <td><bean:write name="claimItem" property="policy"/></td>

                        <td>
                            <bean:define id="label" toScope="page" type="java.lang.String">
                                <bean:message key="claimForm.types.prefix"/><bean:write name="claimItem" property="claimType"/>
                            </bean:define>
                            <bean:message name="label"/>
                        </td>


                        <td><bean:write name="claimItem" property="claimAmount"/></td>
                        <td><bean:write name="claimItem" property="dateOccurred"/></td>
                        <td>

                                <bean:define id="statusLabel" toScope="page" type="java.lang.String">
                                    <bean:message key="claimForm.statuses.prefix"/><bean:write name="claimItem" property="status"/>
                                </bean:define>
                                <bean:message name="statusLabel"/>

                        </td>
                        <td>
                            <html:link action="/approveClaim" titleKey="claimForm.approve">
                                <html:param name="id"><c:out value="${claimItem.id}"/></html:param>
                                <bean:message key="claimForm.approve"/>
                            </html:link>

                            <html:link action="/rejectClaim" titleKey="claimForm.reject">
                                <html:param name="id"><c:out value="${claimItem.id}"/></html:param>
                                <bean:message key="claimForm.reject"/>
                            </html:link>

                        </td>
                    </tr>
                </logic:iterate>
            </table>

        </div>

    </c:otherwise>
</c:choose>