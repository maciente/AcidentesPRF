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
                        <label class="control-label col-md-3">Pesquisar por</label>
                        <div class="input-group col-md-8">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-filter" aria-hidden="true"></span></span>
                            <select class="form-control" name="busca" aria-describedby="basic-addon1">
                                <option value="data">Data</option> 
                                <option value="local">Local</option> 
                                <option value="rodovia">Rodovia</option>
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
                        <label class="col-md-3 control-label">Local</label>
                        <div class="input-group col-md-8">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
                            <select class="form-control" name="estado" aria-describedby="basic-addon1">
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
                            <input type="text" class="form-control" name="municipio" placeholder="Município" aria-describedby="basic-addon1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Rodovia</label>
                        <div class="input-group col-md-8">
                            <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
                            <input type="number" class="form-control" name="br" placeholder="Rodovia" aria-describedby="basic-addon1">
                            <input type="number" class="form-control" name="km_inicial" placeholder="Km Inicial" aria-describedby="basic-addon1">
                            <input type="number" class="form-control" name="km_final" placeholder="Km Final" aria-describedby="basic-addon1">
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
    <%@include file="/footer.jsp" %>
