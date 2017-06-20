<%@include file="/header.jsp" %>
<div class="mensagme text-center col-md-15">
    <c:if test="${flag eq true}">
        <p class="bg-success" style="color:green">Acidente excluido com sucesso</p>
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
    <form class="form-horizontal"method="POST" action="/AcidentesPRF/ExcluirAcidente">
        <input type="hidden" name="id" value="${acidente.id}">
        <div class="panel panel-primary">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Números do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Mortos</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="mortos" value="${acidente.mortos}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Feridos Leves</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="feridos_leves" value="${acidente.feridosLeves}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Feridos Graves</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="feridos_graves" value="${acidente.feridosGraves}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Ilesos</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="ilesos" value="${acidente.ilesos}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Ignorados</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="ignorados" value="${acidente.ignorados}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Veículos Envolvidos</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="veiculos" value="${acidente.veiculos}" readonly="readonly">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Data do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Data</label>
                        <div class="col-md-8">
                            <input type="date" class="form-control" name="data" value="${acidente.data.dataAcidente}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Dia da Semana</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="semana" value="${acidente.data.diaSemana}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Horário</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="horario" value="${acidente.data.horario}" readonly="readonly">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Local do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Estado</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="estado" value="${acidente.local.uf}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Município</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="municipio" value="${acidente.local.municipio}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Rodovia</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="br" value="${acidente.local.br}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Km</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="km" value="${acidente.local.km}" readonly="readonly">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Condições do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Causa</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="causa" value="${acidente.condicao.causaAcidente}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Tipo de Acidente</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="tipo_acidente" value="${acidente.condicao.tipoAcidente}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Classificação</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="classificacao" value="${acidente.condicao.classificacaoAcidente}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Fase do Dia</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="fase" value="${acidente.condicao.faseDia}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Sentido da Via</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="sentido" value="${acidente.condicao.sentidoVia}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Condições Meteorologicas</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="cond_metereologica" value="${acidente.condicao.condMetereologica}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Tipo de Pista</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="tipo_pista" value="${acidente.condicao.tipoPista}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Traçado da Via</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="tracado" value="${acidente.condicao.tracadoVia}" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Uso do Solo</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="uso_solo" value="${acidente.condicao.usoSolo}" readonly="readonly">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-8 col-md-offset-3">
                    <p class="text-danger">Ao presionar o botão o acidente será apagado!</p>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-4 col-md-offset-5">
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Excluir
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
</div>
<%@include file="/footer.jsp" %>
