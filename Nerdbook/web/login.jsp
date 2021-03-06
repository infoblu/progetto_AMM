<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title>Nerdbook Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Riccardo Vacca (Matricola 49313)">
        <meta name="keywords" content="social network amici incontri messaggi condividere login"> 
        <link href="style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <header>
            <div id="title">
                <h1>Login</h1>
				<h2>Accedi per inserire nuovi post!</h2>
			</div>
            
        </header>
        <%@include file="nav.jsp" %>

        <div id="divBody">
            <div id="formLogin">
                <form action="Login" method="post">
                    <div>
                        <div id="titoloLogin"><h3>Nerdbook</h3></div>                        
                        <c:if test="${loggedIn == true}">
                            <div ><p>Attenzione: Utente già Loggato...</p>
                                Effettua il <a href="Login?logout=true">Logout</a>, oppure vai alla <a href="Bacheca">Bacheca</a>
                            </div>
                            
                        </c:if>
                        <c:if test="${loggedIn == false or loggedIn==null}">
                            <c:if test="${invalidData == true}">
                                <div id="invalidDataWarning">Attenzione: Nome utente o password errati.</div>
                            </c:if>
                            <label for="nomeUtente">Nome utente</label>
                            <input type="text" name="nomeUtente" id="nomeUtente"><br/>
                            <label for="password">Password</label>
                            <input type="password" name="password" id="password">
                                                    <div class="pulsanti">
                                                            <button type="submit">Login</button>
                                                            <button type="reset">Reset</button>
                                                    </div>
                        </c:if>
                        </div>
                </form>
            </div>
        </div>    
    </body>
</html>
