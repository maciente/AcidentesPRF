
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Login</title>
    </head>
    <body>
        <div align="center">
        <h3>Login</h3>
        <form method = "post" action = "/AcidentesPRF/LoginAuthentication">
            <p>cpf: <input type = "text" name = "cpf" size = "11"></p>
            <p>Senha: <input type = "password" name = "senha" size = "12"></p>
            <p>
                <input type = "submit" name = "Submit" value = "Submit">
                <input type = "reset" value = "Reset">
            </p>
        </form>
        </div>
        
        <script src="js/bootstrap.min.js"></script>
        </body>
</html>

