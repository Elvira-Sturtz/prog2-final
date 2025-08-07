<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<c:if test="${sessionScope.tipoUsuario == 'admin'}"> 
    
    <ul class="nav justify-content-center d-flex align-items-center mi-lista">
        <li class="nav-item mx-2">
          <a class="navlink mi-link-barra"  href="${pageContext.request.contextPath}/crearPartido">Nuevo </a>
        </li>
        <li class="nav-item mx-2">
          <a class="navlink mi-link-barra"  href="${pageContext.request.contextPath}/Partidos">Eliminar </a>
        </li>
        <li class="nav-item mx-2">
          <a class="navlink mi-link-barra"  href="${pageContext.request.contextPath}/Partidos">Modificar </a>
        </li>
      </ul>
        <hr id="lineadebajo-navbar"> 
</c:if>