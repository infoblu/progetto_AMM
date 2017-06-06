<%-- 
    Document   : listaUtentiJson
    Created on : 5-giu-2017, 11.15.52
    Author     : VCCRCR72A28B354P
--%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="usr" items="${listaUtenti}">
        <json:object>
            <json:property name="id" value="${usr.id}"/>
            <json:property name="nome" value="${usr.nome}"/>
            <json:property name="cognome" value="${usr.cognome}"/>
        </json:object>
    </c:forEach>
</json:array>