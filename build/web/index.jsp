<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <title>Acidentes PRF</title>
    </head>
    <body>
        <div align="center">
            <c:choose>
                <c:when test="${ usuario eq null }">
                    <jsp:forward page="login.jsp" />
                </c:when>
                <c:otherwise>
                    <h2>Bem-vindo ${ usuario.nome }</h2>  
                </c:otherwise>
            </c:choose>
            <form method = "post" action = "/AcidentesPRF/ServletControle">
                <h3>Operações</h3>
                <p>
                    <c:choose>
                        <c:when test="${ usuario.funcao eq 'administrador' }">
                            <input type="radio" name="opcao" value="inserirAcidente">Inserir Acidente<br>
                            <input type="radio" name="opcao" value="buscarAcidente">Buscar Acidente<br>
                            <input type="radio" name="opcao" value="inserirUsuario">Inserir Usuário<br>
                            <input type="radio" name="opcao" value="buscarUsuario">Buscar Usuário<br>
                            <input type="radio" name="opcao" value="relatorio">Gerar Relatórios<br>
                        </c:when>
                        <c:when test="${ usuario.funcao eq 'operador' }">
                            <input type="radio" name="opcao" value="inserirAcidente">Inserir Acidente<br>
                            <input type="radio" name="opcao" value="buscarAcidente">Buscar Acidente<br>
                            <input type="radio" name="opcao" value="relatorio">Gerar Relatórios<br>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="opcao" value="buscarAcidente">Buscar Acidente<br>
                            <input type="radio" name="opcao" value="relatorio">Gerar Relatórios<br>
                        </c:otherwise>
                    </c:choose>  


                </p>
                <p>
                    <input type = "submit" value = "Ok">
                    <input type="button" value="Voltar" onClick="history.go(-1)">
                </p>
            </form>
            <script src="js/bootstrap.min.js"></script>
        </div>
    </body>
</html>
