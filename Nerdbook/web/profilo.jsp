<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title>Nerdbook Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Riccardo Vacca (Matricola 49313)">
        <meta name="keywords" content="social network amici incontri messaggi condividere profilo"> 
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <header>
            <div id="title">
                <h1>Profilo</h1>
				<h2>Racconta qualcosa di te</h2>
			</div>
            
        </header>
        <%@include file="nav.jsp" %>
        <div id="divBody">
            <%@include file="ricerca.jsp" %>
            <div id="formProfilo">
                
                <form action="Iscrizione" method="post">
                    <c:if test="${messaggio != null}"><div id="invalidDataWarning"><p>${messaggio}</p></div></c:if>
                    <div>
                        <h3>Profilo</h3>
                        <input type="hidden" name="id" id="id" value="${utente.id}">
                        <input type="hidden" name="amministratore" id="amministratore" value="${utente.amministratore}">
                        <label for="nome">Nome</label>
                        <input type="text" name="nome" id="nome" value="${utente.nome}"><br/>
                        <label for="cognome">Cognome</label>                        
                        <input type="text" name="cognome" id="cognome" value="${utente.cognome}"><br/>
                        <label for="immagine">Immagine del profilo</label>
                        <input type="url" name="immagine" id="immagine" value="${utente.urlFotoProfilo}"><br/>
                        <label for="frase">Frase di presentazione</label>
                        <textarea name="frase" id="frase">${utente.presentazione}</textarea> <br/>
                        <label for="dataNascita">Data di nascita</label>
                        <input type="date" name="dataNascita" id="dataNascita" value="${utente.dataNascita}"><br/>
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" value="${utente.password}"><br/>
                        <label for="ripetiPassword">Ripeti password</label>
                        <input type="password" name="ripetiPassword" id="ripetiPassword" value="${utente.password}">
                        <div class="pulsanti">
                                <c:if test="${loggedIn == true}">
                                    <button type="submit">Aggiorna</button>
                                </c:if>
                                <c:if test="${loggedIn == false}">
                                    <button type="submit">Iscriviti</button>
                                </c:if>
                                <c:if test="${loggedIn == null}">
                                    <button type="submit">Iscriviti</button>
                                </c:if>
                                <button type="reset">Reset</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </body>
</html>

