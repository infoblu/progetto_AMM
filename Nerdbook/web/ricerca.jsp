<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<div id="ricerca">
        <div id="formRicerca">
                <form action="" method="post">
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
                <ol id="olUtenti">
                    <c:forEach var="utenti" items="${listaUtenti}">
                        <li><a href="Bacheca?user=${utenti.id}">${utenti.nome} ${utenti.cognome}</a></li>
                    </c:forEach>    
                </ol>										
        </div>
        <div id="divGruppi">
                <h3>Gruppi</h3>
                <ol id="olGruppi">
                    <c:forEach var="gruppi" items="${listaGruppi}">
                        <li><a href="#">${gruppi.nomeGruppo}</a></li>
                    </c:forEach> 
                </ol>										
        </div>

</div>

