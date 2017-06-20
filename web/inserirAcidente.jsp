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
    <form class="form-horizontal"method="POST" action="/AcidentesPRF/InserirAcidente">
        <div class="panel panel-primary">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Números do Acidente</h3>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">Mortos</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="mortos" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Feridos Leves</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="feridos_leves" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Feridos Graves</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="feridos_graves" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Ilesos</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="ilesos" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Ignorados</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="ignorados" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Veículos Envolvidos</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="veiculos" required="required">
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
                            <input type="date" class="form-control" name="data" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Dia da Semana</label>
                        <div class="col-md-8">
                            <select class="form-control" name="semana"> 
                                <option value="Domingo">Domingo</option>
                                <option value="Segunda">Segunda</option>
                                <option value="Terça">Terça</option>
                                <option value="Quarta">Quarta</option>
                                <option value="Quinta">Quinta</option>
                                <option value="Sexta">Sexta</option>
                                <option value="Sábado">Sábado</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Horário</label>
                        <div class="col-md-8">
                            <select class="form-control" name="horario"> 
                                <option value="0">Entre 00:00 e 00:59</option>
                                <option value="1">Entre 01:00 e 01:59</option>
                                <option value="2">Entre 02:00 e 02:59</option>
                                <option value="3">Entre 03:00 e 03:59</option>
                                <option value="4">Entre 04:00 e 04:59</option>
                                <option value="5">Entre 05:00 e 05:59</option>
                                <option value="6">Entre 06:00 e 06:59</option>
                                <option value="7">Entre 07:00 e 07:59</option>
                                <option value="8">Entre 08:00 e 08:59</option>
                                <option value="9">Entre 09:00 e 09:59</option>
                                <option value="10">Entre 10:00 e 10:59</option>
                                <option value="11">Entre 11:00 e 11:59</option>
                                <option value="12">Entre 12:00 e 12:59</option>
                                <option value="13">Entre 13:00 e 13:59</option>
                                <option value="14">Entre 14:00 e 14:59</option>
                                <option value="15">Entre 15:00 e 15:59</option>
                                <option value="16">Entre 16:00 e 16:59</option>
                                <option value="17">Entre 17:00 e 17:59</option>
                                <option value="18">Entre 18:00 e 18:59</option>
                                <option value="19">Entre 19:00 e 19:59</option>
                                <option value="20">Entre 20:00 e 20:59</option>
                                <option value="21">Entre 21:00 e 21:59</option>
                                <option value="22">Entre 22:00 e 22:59</option>
                                <option value="23">Entre 23:00 e 23:59</option>
                            </select>
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
                            <input type="text" class="form-control" name="municipio" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Rodovia</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="br" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Km</label>
                        <div class="col-md-8">
                            <input type="number" class="form-control" name="km" required="required">
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
                            <select class="form-control" name="causa">
                                <option value="Animais na Pista">Animais na Pista</option>
                                <option value="Defeito mecânico em veículo">Defeito mecânico em veículo</option>
                                <option value="Defeito na via">Defeito na via</option>
                                <option value="Desobediência à sinalização">Desobediência à sinalização</option>
                                <option value="Dormindo">Dormindo</option>
                                <option value="Falta de atenção">Falta de atenção</option>
                                <option value="Ingestão de álcool">Ingestão de álcool</option>
                                <option value="Não guardar distância de segurança">Não guardar distância de segurança</option>
                                <option value="Ultrapassagem indevida">Ultrapassagem indevida</option>
                                <option value="Velocidade incompatível">Velocidade incompatível</option>
                                <option value="Outras">Outras</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Tipo de Acidente</label>
                        <div class="col-md-8">
                            <select class="form-control" name="tipo_acidente">
                                <option value="Atropelamento de animal">Atropelamento de animal</option>
                                <option value="Atropelamento de pessoa">Atropelamento de pessoa</option>
                                <option value="Capotamento">Capotamento</option>
                                <option value="Colisão com bicicleta">Colisão com bicicleta</option>
                                <option value="Colisão com objeto fixo">Colisão com objeto fixo</option>
                                <option value="Colisão com objeto móvel">Colisão com objeto móvel</option>
                                <option value="Colisão frontal">Colisão frontal</option>
                                <option value="Colisão lateral">Colisão lateral</option>
                                <option value="Colisão Transversal">Colisão Transversal</option>
                                <option value="Colisão traseira">Colisão traseira</option>
                                <option value="Danos Eventuais">Danos Eventuais</option>
                                <option value="Derramamento de Carga">Derramamento de Carga</option>
                                <option value="Incêndio">Incêndio</option>
                                <option value="Queda de motocicleta / bicicleta / veículo">Queda de motocicleta / bicicleta / veículo</option>
                                <option value="Saída de Pista">Saída de Pista</option>
                                <option value="Tombamento">Tombamento</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Classificação</label>
                        <div class="col-md-8">
                            <select class="form-control" name="classificacao">
                                <option value="Com Vítimas Fatais">Com Vítimas Fatais</option>
                                <option value="Com Vítimas Feridas">Com Vítimas Feridas</option>
                                <option value="Ignorado">Ignorado</option>
                                <option value="Sem Vítimas">Sem Vítimas</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Fase do Dia</label>
                        <div class="col-md-8">
                            <select class="form-control" name="fase">
                                <option value="Amanhecer">Amanhecer</option>
                                <option value="Anoitecer">Anoitecer</option>
                                <option value="Plena noite">Plena noite</option>
                                <option value="Pleno dia">Pleno dia</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Sentido da Via</label>
                        <div class="col-md-8">
                            <select class="form-control" name="sentido">
                                <option value="Crescente">Crescente</option>
                                <option value="Decrescente">Decrescente</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Cond. Meteorológicas</label>
                        <div class="col-md-8">
                            <select class="form-control" name="cond_metereologica">
                                <option value="Ceu Claro">Ceu Claro</option>
                                <option value="Chuva">Chuva</option>
                                <option value="Granizo">Granizo</option>
                                <option value="Ignorada">Ignorada</option>
                                <option value="Neve">Neve</option>
                                <option value="Nevoeiro/neblina">Nevoeiro/neblina</option>
                                <option value="Nublado">Nublado</option>
                                <option value="Sol">Sol</option>
                                <option value="Vento">Vento</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Tipo de Pista</label>
                        <div class="col-md-8">
                            <select class="form-control" name="tipo_pista">
                                <option value="Dupla">Dupla</option>
                                <option value="Múltipla">Múltipla</option>
                                <option value="Simples">Simples</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Traçado da Via</label>
                        <div class="col-md-8">
                            <select class="form-control" name="tracado">
                                <option value="Cruzamento">Cruzamento</option>
                                <option value="Curva">Curva</option>
                                <option value="Reta">Reta</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Uso do Solo</label>
                        <div class="col-md-8">
                            <select class="form-control" name="uso_solo">
                                <option value="Rural">Perímetro Rural</option>
                                <option value="Urbano">Perímetro Urbano</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-8 col-md-offset-3">
                    <p class="text-danger">Todos os campos são de preenchimento obrigatório</p>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-4 col-md-offset-5">
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-floppy-save" aria-hidden="true"></span> Cadastrar</button>
                </div>
            </div>
        </div>
    </form>
</div>
<%@include file="/footer.jsp" %>
