<%@include file="/header.jsp" %>
<div>
    <h3>Dados da Publicação</h3>
    <form method = "post" action = "/AcidentesPRF/BuscarUsuario">
        <p>Pesquisar por: </p>
        <p>
            <input type="radio" name="fonte" value="Todos"> Todos<br>
            <input type="radio" name="fonte" value="CPF" checked> CPF: 
            <input type = "text" name = "cpf" size = "15"><br>
            <input type="radio" name="fonte" value="Nome"> Nome: 
            <input type = "text" name = "nome" size = "40"><br>
        </p>
        <p>
            <input type = "submit" name = "Submit" value = "Buscar">
        </p>
    </form>
</div>
<%@include file="/footer.jsp" %>
