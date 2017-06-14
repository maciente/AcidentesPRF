<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Acidentes PRF</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background-color:white">
        <c:choose>
            <c:when test="${ usuario eq null }">
                <jsp:forward page="login.jsp" />
            </c:when>
            <c:otherwise>
                <div class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-left">
                                <li>
                                    <a class="navbar-brand" href="/AcidentesPRF/index.jsp">
                                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Página Inicial
                                    </a>
                                </li>
                                <c:choose>
                                    <c:when test="${ usuario.funcao eq 'administrador' }">
                                        <li><a href="/AcidentesPRF/inserirAcidente.jsp">Inserir Acidente</a></li>
                                        <li><a href="/AcidentesPRF/buscarAcidente.jsp">Buscar Acidente</a></li>
                                        <li><a href="/AcidentesPRF/inserirUsuario.jsp">Inserir Usuário</a></li>
                                        <li><a href="/AcidentesPRF/buscarUsuario.jsp">Buscar Usuário</a></li>
                                        <li><a href="/AcidentesPRF/gerarRelatorio.jsp">Gerar Relatórios</a></li>
                                        </c:when>
                                        <c:when test="${ usuario.funcao eq 'operador' }">
                                        <li><a href="/AcidentesPRF/inserirAcidente.jsp">Inserir Acidente</a></li>
                                        <li><a href="/AcidentesPRF/buscarAcidente.jsp">Buscar Acidente</a></li>
                                        <li><a href="/AcidentesPRF/gerarRelatorio.jsp">Gerar Relatórios</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li><a href="/AcidentesPRF/buscarAcidente.jsp">Buscar Acidente</a></li>
                                        <li><a href="/AcidentesPRF/gerarRelatorio.jsp">Gerar Relatórios</a></li>
                                        </c:otherwise>
                                    </c:choose>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="/AcidentesPRF/logout.jsp">
                                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Sair 
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
        <div class="container">
            <div class="col-md-10 col-md-offset-1" style="background-color:white">