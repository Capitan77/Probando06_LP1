<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!--Habilitamos un pequeño form que servirá para poder cerrar la sesion-->
<!--a través del action login hacia ValidarSesionServlet y serpa tipo GET-->

<form action="login" method="GET">
    <button type="submit" class="btn btn-danger">Cerrar Sesion</button>
</form>


<!--Inicializamos un div que contendra la tabla con los datos del SQL que recuperamos-->
     <div class="container mt-5">

     <table class="table table-bordered table-hover">

     <!--cabecera de nuestra tabla-->

             <thead>
                  <tr>
                      <th>ID</th>
                      <th>Nombre</th>
                      <th>Apellido</th>
                      <th>Correo</th>
                  </tr>
             </thead>

     <!--Cuerpo que comformará la tabla-->
     <!--Donde aplicaremos un taglib = etiqueta personalizada. forEach, con este recorreremos el atributo usuarios-->
     <!--con una variale global llamada usu y con eso retornaremos los datos de usuarios-->

             <tbody>
             <c:forEach var="usu" items="${usuarios}">
             <tr>
             <td>${usu.id}</td>
             <td>${usu.nombre}</td>
             <td>${usu.apellido}</td>
             <td>${usu.correo}</td>
             </tr>
             </c:forEach>
             </tbody>
     </table>

     </div>


</body>
</html>