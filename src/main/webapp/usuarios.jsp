<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<form action="login" method="GET">
    <button type="submit" class="btn btn-danger">Cerrar Sesion</button>
</form>

     <div class="container mt-5">

     <table class="table table-bordered table-hover">
             <thead>
                  <tr>
                      <th>ID</th>
                      <th>Nombre</th>
                      <th>Apellido</th>
                      <th>Correo</th>
                  </tr>
             </thead>
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