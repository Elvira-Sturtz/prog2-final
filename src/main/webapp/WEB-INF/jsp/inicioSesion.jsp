<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:import url="componentesHTML/inicioHTML.jsp" />
<c:import url="componentesHTML/navBar-No-Iniciado.jsp" />

<section id="Formulario-InicioSesion" class="h-100 gradient-form" >
                  <div class="container py-5 h-100">
                    <div class="row d-flex justify-content-center align-items-center h-100">
                      <div class="col-xl-10">
                        <div class="card rounded-3 text-black">
                          <div class="row g-0">
                            <div class="col-lg-6">
                              <div class="card-body p-md-5 mx-md-4">

                                <div class="text-center">
                                    <img src="img/logoAP.jpg"
                                    style="width: 70px;" alt="logo">
                                  <h4 class="mt-1 mb-5 pb-1">Inicio de sesion</h4>
                                </div>

                                  <form action="SvIngresoUsuario" method="POST" style="color:#000000;">
                                  <p>Please login to your account</p>

                                  <div class="form-outline mb-4">
                                    <input type="text" id="form2Example11" class="form-control"
                                      placeholder="Phone number or email address" name="usuario"/>
                                    <label class="form-label" for="form2Example11">Username</label>
                                  </div>

                                  <div class="form-outline mb-4">
                                    <input type="password" name="password" id="form2Example22" class="form-control" />
                                    <label class="form-label" for="form2Example22">Password</label>
                                  </div>

                                  <div class="text-center pt-1 mb-5 pb-1">
                                      <button class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3" type="submit">Log
                                      in</button>
                                    <a class="text-muted" href="#!">Olvido Contraseña?</a>
                                  </div>

                                  <div class="d-flex align-items-center justify-content-center pb-4">
                                    <p class="mb-0 me-2">No tienes Cuenta?</p>
                                    <a href="Index?action=newUsuarios" class="btn btn-success">Crea una Nueva</a>
                                    
                                  </div>

                                </form>

                              </div>
                            </div>
                            <div class="col-lg-6 d-flex align-items-center gradient-custom-2">
                              <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                                <h4 class="mb-4">Hola devuelta!</h4>
                                <p class="small mb-0">Somos Apuesta Todo.com la pagina de apuestas digitales
                                mas confiable del pais. Agradecemos que confies en nosotros una vez mas.</p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </section>
    
                
 <c:import url="componentesHTML/footer.jsp" /> 
                
</html>