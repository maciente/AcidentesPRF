<%@include file="/header.jsp" %>
<div class="mensagme text-center col-md-15">
    <c:if test="${flag eq true}">
        <p class="bg-success" style="color:green">Usuário excluido com sucesso</p>
        <%
            session.setAttribute("flag", null);
        %>
    </c:if>
    <c:if test="${flag eq false}">
        <p class="bg-danger" style="color:red">Ocorreu algo de errado</p>
        <%
            session.setAttribute("flag", null);
        %>
    </c:if>
</div>
<div class="col-md-15 col-md-offset-0">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Dados do Usuário</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" method="POST" action="/AcidentesPRF/ExcluirUsuario">
                <div class="form-group">
                    <label class="col-md-2 control-label">Nome</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="nome" value="${user.nome}" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">CPF</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="cpf" value="${user.cpf}" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Função</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="funcao" value="${user.funcao}" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">Senha</label>
                    <div class="col-md-9">
                        <input type="password" class="form-control" name="senha" value="${user.senha}" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-8 col-md-offset-3">
                        <p class="text-danger">Ao presionar o botão o usuário será apagado!</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 col-md-offset-8">
                        <button type="submit" class="btn btn-default">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Excluir
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="/footer.jsp" %>
