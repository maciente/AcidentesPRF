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
                <h3 class="panel-title">Consultar Acidentes</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method = "post" action = "/AcidentesPRF/BuscarAcidente">
                    <div class="form-group">
<!--                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <input type="radio" name="busca" value="data"> Buscar Por Data
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Data Inicial</label>
                                    <div class="col-md-8">
                                        <input type="date" class="form-control" name="data_inicial">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Data Final</label>
                                    <div class="col-md-8">
                                        <input type="date" class="form-control" name="data_final">
                                    </div>
                                </div>
                            </div>
                        </div>-->
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <input type="radio" name="busca" value="local" checked> Buscar Por Local
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Estado</label>
                                    <div class="col-md-8">
                                        <select class="form-control" name="estado">
                                            <option value="AC">Acre</option> 
                                            <option value="AL">Alagoas</option> 
                                            <option value="AM">Amazonas</option> 
                                            <option value="AP">Amapá</option> 
                                            <option value="BA">Bahia</option> 
                                            <option value="CE">Ceará</option> 
                                            <option value="DF">Distrito Federal</option> 
                                            <option value="ES">Espírito Santo</option> 
                                            <option value="GO">Goiás</option> 
                                            <option value="MA">Maranhão</option> 
                                            <option value="MT">Mato Grosso</option> 
                                            <option value="MS">Mato Grosso do Sul</option> 
                                            <option value="MG">Minas Gerais</option> 
                                            <option value="PA">Pará</option> 
                                            <option value="PB">Paraíba</option> 
                                            <option value="PR">Paraná</option> 
                                            <option value="PE">Pernambuco</option> 
                                            <option value="PI">Piauí</option> 
                                            <option value="RJ">Rio de Janeiro</option> 
                                            <option value="RN">Rio Grande do Norte</option> 
                                            <option value="RO">Rondônia</option> 
                                            <option value="RS">Rio Grande do Sul</option> 
                                            <option value="RR">Roraima</option> 
                                            <option value="SC">Santa Catarina</option> 
                                            <option value="SE">Sergipe</option> 
                                            <option value="SP">São Paulo</option> 
                                            <option value="TO">Tocantins</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Município</label>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="municipio">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Rodovia BR</label>
                                    <div class="col-md-8">
                                        <input type="number" class="form-control" name="br">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Km Inicial</label>
                                    <div class="col-md-8">
                                        <input type="number" class="form-control" name="km_inicial">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Km Final</label>
                                    <div class="col-md-8">
                                        <input type="number" class="form-control" name="km_final">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <input type="radio" name="busca" value="todos"> Buscar Todos
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <div class="col-md-8 col-md-offset-3">
                                        <p class="text-danger">Selecione essa opção para buscar todas as ocorrências</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2 col-md-offset-9">
                                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Buscar</button>
                            </div>
                        </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="/footer.jsp" %>
