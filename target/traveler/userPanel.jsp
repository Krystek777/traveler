<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <h5><html:link styleClass="nav-link" action="/addClaim">Add Claim</html:link></h5>
            </li>
            <c:choose>
                <c:when test="${loggedUser != null}">
                    <li class="nav-item">
                        <h5> <html:link styleClass="nav-link" action="/allClaims">All Claims</html:link></h5>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <h5> <html:link styleClass="nav-link" action="/login">All Claims</html:link></h5>
                    </li>
                </c:otherwise>
            </c:choose>

        </ul>


        <ul class="navbar-nav ml-auto">

            <c:choose>
                <c:when test="${loggedUser != null}">
                    <li class="nav-item text-white nav-link disabled">
                        <h5><bean:message key="hello.text"/>
                            <bean:write name="loggedUser" property="username"/></h5>
                    </li>
                    <li class="nav-item">
                        <h5>
                            <html:link styleClass="nav-link" action="/signOut">
                                <bean:message key="sing.out.text"/>
                            </html:link>
                        </h5>
                    </li>
                </c:when>
                <c:otherwise>
                    <h5>
                        <li class="nav-item">
                            <html:link styleClass="nav-link" action="/login">
                                <bean:message key="sign.in.text"/>
                            </html:link>
                        </li class="nav-item">
                    </h5>

                    <h5>
                        <li class="nav-item">
                            <html:link styleClass="nav-link" action="/signUp">
                                <bean:message key="sign.up.text"/>
                            </html:link>
                        </li>
                    </h5>

                </c:otherwise>
            </c:choose>

        </ul>
    </div>
</nav>




