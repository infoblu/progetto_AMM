<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <nav>
            <ol>
                <li><a href="descrizione.jsp">Descrizione di Nerdbook</a></li>
                <c:if test="${loggedIn == false}">
                    <li><a href="Profilo">Iscriviti</a></li>
                    <li><a href="Login">Accedi</a></li>
                </c:if>
                <c:if test="${loggedIn == true}">
                    <li><a href="Bacheca">Bacheca</a></li>                    
                    <li><a href="Profilo">Profilo</a></li>
                    <li><a href="Login?logout">Logout</a></li>
                </c:if>
            </ol>
        </nav>
