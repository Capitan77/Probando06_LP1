<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
     <div class="container mt-5">

     <!--Establecemos un form, tipo POST, que será enviado a través del action login hacia ValidarSesionServlet-->

           <form action="login" method="POST" class="card p-4 shadow-lg">

           <!--Establecemos el label tipo correo-->
           <!--Junto con el input tipo email, id= correo y name= correo-->

              <div class="mb-3">
                    <label for="correo" class="form-label">Correo</label>
                    <input type="email" class="form-control" id="correo" name="correo">
              </div>

           <!--Establecemos el label tipo contrasenia-->
           <!--Junto con el input tipo password, id= correo y name= correo-->

              <div class="mb-3">
                    <label for="contrasenia" class="form-label">Correo</label>
                    <input type="password" class="form-control" id="contrasenia" name="contrasenia">
              </div>

           <!--finalmente lo terminamos enviando por un boton submit hacia el ValidarSesionServlet-->

              <button type="submit" class="btn btn-primary">Ingresar</button>
           </form>


     </div>


</body>
</html>