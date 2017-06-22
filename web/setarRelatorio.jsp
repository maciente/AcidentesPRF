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
                        <label class="control-label col-md-3">Relatório de</label>
                        <div class="input-group col-md-8">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-filter" aria-hidden="true"></span></span>
                            <select class="form-control" name="busca" aria-describedby="basic-addon1">
                                <option value="causa">Causa do Acidente</option> 
                                <option value="tipoAcidente">Tipo de Acidente</option> 
                                <option value="classificacao">Classificação do Acidente</option> 
                                <option value="fase">Fase do Dia</option> 
                                <option value="cond">Condições Meteorológicas</option> 
                                <option value="tipoPista">Tipo de Pista</option> 
                                <option value="tracado">Traçado da Via</option> 
                                <option value="solo">Uso Solo</option> 
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Data</label>
                        <div class="input-group col-md-8">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
                            <input type="date" class="form-control" name="dataInicial" aria-describedby="basic-addon1">
                            <input type="date" class="form-control" name="dataFinal" aria-describedby="basic-addon1">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2 col-md-offset-6">
                            <button type="submit" name="opcao" value="grafico" class="btn btn-default">
                                <span class="glyphicon glyphicon-stats" aria-hidden="true"></span> Gerar Gráfico
                            </button>
                        </div>
                        <div class="col-md-3">
                            <button type="submit" name="opcao" value="tabela" class="btn btn-default">
                                <span class="glyphicon glyphicon-list" aria-hidden="true"></span> Ver Números
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@include file="/footer.jsp" %>
