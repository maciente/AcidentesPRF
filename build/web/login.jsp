<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-color:white">
        <div class="navbar navbar-default">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="/AcidentesPRF/login.jsp">
                                <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Login 
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="col-md-10 col-md-offset-1" style="background-color:white">
                <div class="mensagme text-center col-md-15">
                    <c:if test="${flag eq true}">
                        <p class="bg-success" style="color:green">Usuário inserido com sucesso</p>
                        <%
                            session.setAttribute("flag", null);
                        %>
                    </c:if>
                    <c:if test="${flag eq false}">
                        <p class="bg-danger" style="color:red">cpf e/ou senha incorretos ou inexistentes</p>
                        <%
                            session.setAttribute("flag", null);
                        %>
                    </c:if>
                </div>
                <div class="row col-md-6 col-md-offset-3">
                    <div align="center" class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Login</h3>
                        </div>	        
                        <div class="panel-body">
                            <form class="form-horizontal" method="POST" action="/AcidentesPRF/LoginAuthentication">
                                <div class="form-group">
                                    <label class="col-md-2 col-md-offset-1 control-label">CPF</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="cpf" placeholder="Números do CPF" required="required">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2 col-md-offset-1 control-label">Senha</label>
                                    <div class="col-md-8">
                                        <input type="password" class="form-control" name="senha" placeholder="Senha" required="required">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-3 col-md-offset-3">
                                        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Entrar</button>
                                    </div>
                                    <div class="col-md-3">					    	
                                        <a class="btn btn-default" href="/AcidentesPRF/cadastrarUsuario.jsp" role="button"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> Cadastrar</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <script src="resources/js/bootstrap.js" type="text/javascript"></script>
                <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
                <script src="resources/js/jquery.min.js" type="text/javascript"></script>
            </div>
        </div>
    </body>
</html>

