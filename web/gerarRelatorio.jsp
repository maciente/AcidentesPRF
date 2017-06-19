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
                    <h3 class="panel-title">Números do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <p:pieChart value="${lista}" var="condicao"
                        categoryField="${lista.causaAcidente}" dataField="${lista.causaAcidente}"/>
                    </div>    
            </div>
            <div class="form-group">
                <div class="col-md-4 col-md-offset-5">
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> Cadastrar</button>
                </div>
            </div>
</div>
<%@include file="/footer.jsp" %>
