
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:import url="componentesHTML/inicioHTML.jsp" />
<c:import url="componentesHTML/navBar-Iniciado.jsp" />
<c:import url="componentesHTML/ul-BarraDeportes.jsp" />
<section class="h-100 ">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card card-registration my-4">
          <div class="row g-0">
              <div id="fondoNewPartido" class="col-xl-6 d-none d-xl-block">
            </div>
            <div class="col-xl-6">
              <div class="card-body p-md-5 text-black">
                  <div>
                      <h3 class="mb-5 text-uppercase">Crear Nuevo Partido</h3> 
                       <c:if test="${hayError}">
                                        <div class="container mt-3 p-3 bg-danger text-light">
                                            <h2>${mensajeError}</h2>
                                        </div>
                        </c:if>
                  </div>
                  <form action="NuevoPartido" method="POST">
                             
                      <div class="form-outline mb-4">
                          <input type="text" id="form2Example11" class="form-control" style="font-size: 12px"
                             placeholder="Ingrese el Equipo Local" name="local"/>
                             <label class="form-label" for="form2Example11">Equipo Local</label>
                             </div>
                      
                            <div class="form-outline mb-4">
                            <input type="text" name="visitante" id="form2Example22" class="form-control" style="font-size: 12px" placeholder="Ingrese el Equipo Visitante"/>
                            <label class="form-label" for="form2Example22">Equipo Visitante</label>
                            </div>
                            
                            <div class="form-outline mb-4">
                            <input type="text" name="fecha" id="form2Example22" class="form-control" style="font-size: 12px" placeholder="Ingrese fecha del partido (AAAA/MM/DD)"/>
                            <label class="form-label" for="form2Example22">Fecha</label>
                            </div>

                            <div class="d-flex justify-content-end pt-3">
                            <input class="btn btn-success btn-block fa-lg gradient-custom-2" type="submit" name="Enviar datos" value="Guardar Partido">
                            </div>                 
                  </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    <c:import url="componentesHTML/footer.jsp" /> 
</section>
