<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<c:import url="componentesHTML/inicioHTML.jsp" />
<c:import url="componentesHTML/navBar-Iniciado.jsp" />
<c:import url="componentesHTML/ul-BarraDeportes.jsp" />

<style>
@import url('https://fonts.googleapis.com/css2?family=Nunito&family=Oswald:wght@600&display=swap');
</style>
        

<div class="row">
    <div class="col-md-12">
        <h1 id = "bets">PARTIDOS DISPONIBLES</h1>     
    
        <ul class="nav justify-content-center d-flex align-items-center mi-lista">
            <li class="nav-item mx-2">
              <a class="navlink mi-link-barra"  href="${pageContext.request.contextPath}/crearPartido">Nuevo Partido</a>
            </li>
        <ul>
    </div>
 </div>
<div class="row">
    <div class="col-md-12">
        <div class="partidos-container">
            <c:forEach items="${listaDePartidos}" var="partido" varStatus="loop">
                <div class="partido-burbuja">
                    <div class="equipo-local">${partido.local}</div>
                    <div class="fw-bold">vs</div>
                    <div class="equipo-visitante">${partido.visitante}</div>
                    <div class="fecha fw-bold">${partido.fecha}</div>
                    
                    <!-- Mostrar los botones solo si el partido aún no se jugó -->
                    <c:if test="${partido.fecha >= fechaHoy}"> 
                        <c:choose> 
                            <c:when test="${esAdmin}"> 
                                <%--Elementos si este when es true --%>
                                <h1 id="bets">${mensajeAdmin}</h1> 
                               
                                <a class="btn btn-success mt-3 me-2" href="/ApuestaTodook/EliminarPartido?id=${partido.idPartido}">Eliminar</a>
                                <a class="btn btn-success mt-3 me-2" href="/ApuestaTodook/ModificarPartido?id=${partido.idPartido}">Modificar</a>
                            </c:when>        
                        
                            <c:otherwise> 
                                <%--Elementos si todos los when fueron false --%> 
                                <a class="btn btn-success" href="/ApuestaTodook/Apuesta?id=${partido.idPartido}">Apostar</a> 
                            </c:otherwise> 
                        </c:choose> 
                    </c:if>

                </div>
            </c:forEach>
        </div>
    </div>
</div>
        <c:import url="componentesHTML/footer.jsp" /> 
    </body>
</html>

