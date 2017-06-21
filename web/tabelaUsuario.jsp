<%@include file="/buscarUsuario.jsp" %>
<div class="container">
    <div class="col-md-10 col-md-offset-1" style="background-color:white">
        <c:if test="${flag eq true}">
            <div class="row">
                <div class="col-md-15">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Dados dos Usuários</h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" method="POST" action="/AcidentesPRF/AlterarUsuario">
                                <table class="table table-striped">
                                    <tr>
                                        <th></th>
                                        <th>CPF</th>
                                        <th>Nome</th>
                                        <th>Função</th>
                                    </tr>
                                    <c:forEach var="item" items="${lista}">
                                        <tr>
                                            <td><input type="radio" name="cpf" value="${item.cpf}" checked></td>
                                            <td>${item.cpf}</td>
                                            <td>${item.nome}</td>
                                            <td>${item.funcao}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                                <div class="form-group">
                                    <div class="col-md-2 col-md-offset-4">
                                        <button type="submit" name="opcao" value="editar" class="btn btn-default">
                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Editar
                                        </button>
                                    </div>
                                    <div class="col-md-3">
                                        <button type="submit" name="opcao" value="excluir" class="btn btn-default">
                                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Excluir
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%        session.setAttribute("flag", null);
            %>
        </c:if>
        <%@include file="/footer.jsp" %>
