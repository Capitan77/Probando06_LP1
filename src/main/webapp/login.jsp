<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
     <div class="container mt-5">

           <form action="login" method="POST" class="card p-4 shadow-lg">
              <div class="mb-3">
                    <label for="correo" class="form-label">Correo</label>
                    <input type="email" class="form-control" id="correo" name="correo">
              </div>

              <div class="mb-3">
                    <label for="contrasenia" class="form-label">Correo</label>
                    <input type="password" class="form-control" id="contrasenia" name="contrasenia">
              </div>

              <button type="submit" class="btn btn-primary">Ingresar</button>
           </form>


     </div>


</body>
</html>