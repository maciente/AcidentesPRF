<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="row col-md-6 col-md-offset-3">
            <div align="center" class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title"> Entrar no UNIFunda </h3>
                </div>	        
                <div class="panel-body">
                    <form class="form-horizontal" method="POST" action="/AcidentesPRF/LoginAuthentication">
                        <div class="form-group">
                            <label class="col-md-2 col-md-offset-1 control-label">CPF</label>
                            <div class="col-md-7">
                                <input type="text" class="form-control" name="cpf" placeholder="Números do CPF">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 col-md-offset-1 control-label">Senha</label>
                            <div class="col-md-7">
                                <input type="password" class="form-control" name="senha" placeholder="Senha">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-3">
                                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Entrar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="resources/js/bootstrap.js" type="text/javascript"></script>
        <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="resources/js/jquery.min.js" type="text/javascript"></script>
    </body>
</html>

