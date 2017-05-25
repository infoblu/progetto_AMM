<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title>Nerdbook Nuovo Post</title>
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
            <div id="formPost">
                <form action="NuovoPost?review=true&usr=${param.usr}" method="post">
                    <div>
                        <h1>Nuovo Post</h1>
                        <!-- Utente non Loggato -->
                        <c:if test="${loggedIn == false or loggedIn== null}">
                            <div><p>Attenzione, per inserire nuovi Post devi essere Iscritto</p>
                                <p><a href="Profilo">Iscriviti</a> o effettua il <a href="Login">Login</a></p>
                            </div>
                        </c:if>
                        <!-- Utente Loggato - Inserimento Post -->
                        <c:if test="${loggedIn == true and review==null}">

                            <div id="divTipoPost">                                
                                <p>Tipo di Post</p>
                                <div><input type="radio" name="postType" value="1" id="textType" class="radio"  checked="checked">
                                    <label for="1">Solo Testo ${usr}</label>
                                </div>
                                <div><input type="radio" name="postType" value="2" id="imgType" class="radio">
                                    <label for="2">Testo + Immagine</label>

                                </div>
                                <div><input type="radio" name="postType" value="3" id="urlType" class="radio">
                                    <label for="3">Testo + Url</label>                                
                                </div>
                            </div>
                            <div id="divPostData">
                                <div>
                                    <label for="textPost">Testo</label>
                                    <textarea name="textPost" id="textPost"></textarea>
                                </div>
                                <div>
                                    <label for="imgPost">File d'immagine</label>
                                    <input type="text" name="imgPost" id="imgPost">
                                </div>
                                <div>
                                    <label for="urlPost">URL</label>
                                    <input type="text" name="urlPost" id="urlPost">
                                </div>
                            </div>
                            <div class="pulsanti">
                                    <c:if test="${loggedIn == true}">
                                        <button type="submit">Invia</button>
                                    </c:if>
                                    <button type="reset">Reset</button>
                            </div>
                        
                        </c:if>
                    </div>
                </form>

                <!-- Utente Loggato - Review Post -->
                <c:if test="${loggedIn == true and review==false}">
                    <div>
                        <form action="NuovoPost?review=false" method="post">
                            <input type="hidden" name="idAutore" id="idAutore" value="${utenteBacheca.id}">
                            <input type="hidden" name="idDestinatario" id="idDestinatario" value="${utenteLoggato.id}">
                            <input type="hidden" name="idTipoPost" id="idTipoPost" value="${idTipoPost}">
                            <input type="hidden" name="textPost" id="textPost" value="${textPost}">
                            <input type="hidden" name="url" id="url" value="${url}">
                            
                            <p>Utente: ${utenteLoggato.nome} ${utenteLoggato.cognome}</p>
                            <p>Tipo di Post: ${tipopost}</p>
                            <p>Testo: ${textPost}</p>
                            <c:if test="${idTipoPost >1}">
                                <c:if test="${idTipoPost == 2}">
                                    <p>Immagine: ${urlText}</p>
                                </c:if>
                                <c:if test="${idTipoPost == 3}">
                                    <p>Url: ${urlText}</p>
                                </c:if>
                            </c:if>
                            <p>Scrivi Post nella Bacheca di: ${utenteBacheca.nome} ${utenteBacheca.cognome}</p>
                            <div class="pulsanti">
                                <button type="submit">Conferma</button>
                            </div> 
                        </form>
                    </div>
                </c:if>

                <!-- Utente Loggato - Post Confermato -->
                <c:if test="${loggedIn == true and review==true}">
                    <div>                            
                            <c:if test="${recordsAffected==1}">
                                <p>Il tuo Post è stato scritto correttamente</p>
                            </c:if>
                            <c:if test="${recordsAffected==0}">
                                <p>A causa di un problema durante la registrazione, il tuo Post NON è stato scritto</p>
                            </c:if>                        
                            <p>Torna alla tua <a href="Bacheca">Bacheca</a>,</p>
                            
                        </form>
                    </div>
                </c:if>

            </div>
        </div>    
    </body>
</html>

