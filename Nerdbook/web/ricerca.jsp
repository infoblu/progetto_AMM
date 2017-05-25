<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="ricerca">
        <div id="formRicerca">
                <form action="servlet.java" method="post">
                        <div>
                                <h3><label for="nomeUtente">Ricerca</label></h3>
                                <input type="text" name="nomeUtente" id="nomeUtente"><br/>
                                <div class="pulsanti">
                                        <button type="submit">Cerca</button>
                                </div>
                        </div>
                </form>
        </div>
        <div id="divUtenti">
                <h3>Persone</h3>
                <!--lista degli Utenti -->
                <ol>
                    <c:forEach var="utenti" items="${listaUtenti}">
                        <li><a href="Bacheca?user=${utenti.id}">${utenti.nome}</a></li>
                    </c:forEach>    
                </ol>										
        </div>
        <div id="divGruppi">
                <h3>Gruppi</h3>
                <ol>
                    <c:forEach var="gruppi" items="${listaGruppi}">
                        <li><a href="#">${gruppi.nomeGruppo}</a></li>
                    </c:forEach> 
                </ol>										
        </div>

</div>

