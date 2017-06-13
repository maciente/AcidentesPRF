<%@include file="/header.jsp" %>
<div>
    <h3>Dados dos Usuários</h3>
    <div align="center">
        <table border:1>
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Função</th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.cpf}</td>
                    <td>${item.nome}</td>
                    <td>${item.funcao}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="/footer.jsp" %>
