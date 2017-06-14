<%@include file="/header.jsp" %>
<div class="mensagme text-center col-md-15">
    <c:if test="${flag eq true}">
        <p class="bg-success" style="color:green">Usuário inserido com sucesso</p>
        <%
            session.setAttribute("flag", null);
        %>
    </c:if>
    <c:if test="${flag eq false}">
        <p class="bg-danger" style="color:red">Todos os campos são obrigatórios</p>
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
            <form class="form-horizontal" method="POST" action="/AcidentesPRF/InserirUsuario">
                <div class="form-group">
                    <label class="col-md-2 control-label">*Nome</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="nome">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">*CPF</label>
                    <div class="col-md-9">
                        <input type="text" class="form-control" name="cpf">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">*Função</label>
                    <div class="col-md-9">
                        <select class="form-control" name="funcao"> 
                            <option value="administrador" >Administrador</option> 
                            <option value="operador">Operador</option> 
                            <option value="usuario">Usuário Comum</option> 
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">*Senha</label>
                    <div class="col-md-9">
                        <input type="password" class="form-control" name="senha">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-8 col-md-offset-3">
                        <p class="text-danger">(*) campos de preenchimento obrigatório</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 col-md-offset-8">
                        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> Cadastrar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="/footer.jsp" %>
