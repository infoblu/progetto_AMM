<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title>Nerdbook Bacheca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Riccardo Vacca (Matricola 49313)">
        <meta name="keywords" content="social network amici incontri messaggi condividere bacheca"> 
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>

			<div id="intestazione">
				<header>
					<div id="title">
						<h1>Bacheca</h1>
						<h2>Benvenuto nella mia bacheca</h2>
					</div>
				</header>				                                    
				<%@include file="nav.jsp" %>
			</div>
			

            <div id="divBody">
                <%@include file="ricerca.jsp" %>
                <div id="divPosts">

                    <div id="divPresentazione">
                        <c:if test="${utente.id!=null}">
                            <div id="divNewPost">
                                <a href="nuovopost.jsp?usr=${utente.id}">Nuovo Post</a>                                
                            </div>
                            <h3>${utente.nome} ${utente.cognome}</h3>

                            <c:if test="${utente.id!=-1}"> 
                                <c:if test="${utente.urlFotoProfilo!=null}"> 
                                    <img class="fotoProfilo" alt="Foto del profilo" src="${utente.urlFotoProfilo}" />
                                </c:if>                                               
                                <c:if test="${utente.presentazione!=''}"> 
                                    <p>"${utente.presentazione}"</p>
                                </c:if>
                            </c:if>

                        </c:if>
                        <c:if test="${utente.id==null}">
                            <p>Attenzione: Questi contenuti sono visibili solo dagli utenti registrati.</p>
                            <p> Se sei un utente registrato <a href="Login">Accedi</a>, altrimenti <a href="Profilo">Iscriviti</a>
                        </c:if>
                    </div>

                    <!--lista dei post-->
                    <div id="posts">
                        <c:forEach var="post" items="${posts}">
                            <div class="post">
                                <p>${post.messaggio}</p>
                                <c:if test="${post.tipoPost == 2}">
                                    <img alt="Post con foto" src="${post.url}">
                                </c:if>
                                <c:if test="${post.tipoPost == 3}">
                                    <a href="${post.url}">${post.url}</a>
                                </c:if>
                            </div>
                        </c:forEach>
                    </div>   
                </div>
            </div>
    </body>
</html>
