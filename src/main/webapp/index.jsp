<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:import url="WEB-INF/jsp/componentesHTML/inicioHTML.jsp" />
<c:import url="WEB-INF/jsp/componentesHTML/navBar-Iniciado.jsp" />
<c:import url="WEB-INF/jsp/componentesHTML/ul-BarraDeportes.jsp" />

<style>
@import url('https://fonts.googleapis.com/css2?family=Nunito&family=Oswald:wght@600&display=swap');
</style>


<h2 id = "bets" >BETS DESTACADAS</h2>
        <div id="carouselExample" class="carousel slide">


      <div class="carousel-inner">
        <div class="carousel-item active">
            <a href="Index?action=inicioSesion">
          <img src="img/Boca-Racing-ESPN.jpg" class="d-block " alt="...">
          </a>
        </div>
        <div class="carousel-item">
            <a href="Index?action=inicioSesion">
          <img src="img/Barcelona-Madrid-Aguero.jpg" class="d-block " alt="...">
          </a>
        </div>
        <div class="carousel-item">
            <a href="Index?action=inicioSesion">
          <img src="img/espn-Final.jpg" class="d-block " alt="...">
          </a>
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>

<div class="contenedor">
 
    <div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
    
    <div class="card" style="width: 18rem; ">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Card title</h5>
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      <a href="#" class="btn btn-primary">Go somewhere</a>
    </div>
  </div>
    
    <div class="card" style="width: 18rem; ">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Card title</h5>
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      <a href="#" class="btn btn-primary">Go somewhere</a>
    </div>
  </div>
    
</div>   






        
   <c:import url="WEB-INF/jsp/componentesHTML/footer.jsp" /> 
   
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>


</html>