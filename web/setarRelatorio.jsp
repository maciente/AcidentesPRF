<%@include file="/header.jsp" %>
<div class="mensagme text-center col-md-15">
    <c:if test="${flag eq false}">
        <p class="bg-danger" style="color:red">A consulta não obteve resultados</p>
        <%
            session.setAttribute("flag", null);
        %>
    </c:if>
</div>
<div class="row">
    <div class="col-md-15 col-md-offset-0">    	
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Gerar Relatórios</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method = "post" action = "/AcidentesPRF/GerarRelatorio">
                    <div class="form-group">
                        <label class="control-label col-md-3">Pesquisar por</label>
                        <div class="input-group col-md-8">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-filter" aria-hidden="true"></span></span>
                            <select class="form-control" name="busca" aria-describedby="basic-addon1">
                                <option value="ID">Id</option> 
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Id</label>
                        <div class="input-group col-md-8">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
                            <input type="number" class="form-control" name="id" placeholder="Rodovia" aria-describedby="basic-addon1">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2 col-md-offset-9">
                            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Gerar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@include file="/footer.jsp" %>
