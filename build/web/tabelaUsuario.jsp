<%@include file="/header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Dados dos Usuários</h3>
            </div>
            <table class="table table-striped">
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
</div>
<%@include file="/footer.jsp" %>
