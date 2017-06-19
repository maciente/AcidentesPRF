<%@include file="/buscarAcidente.jsp" %>
<div class="container">
    <div class="col-md-12 col-md-offset-0" style="background-color:white">
        <c:if test="${flag eq true}">
            <div class="row">
                <div class="col-md-20">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Dados dos Acidentes</h3>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" method="POST" action="/AcidentesPRF/AlterarAcidente">
                                <table class="table table-striped">
                                    <tr>
                                        <th></th>
                                        <th>id</th>
                                        <th>NP</th>
                                        <th>NM</th>
                                        <th>FL</th>
                                        <th>FG</th>
                                        <th>IL</th>
                                        <th>IG</th>
                                        <th>TF</th>
                                        <th>NV</th>
                                        <th>UF</th>
                                        <th>Municipio</th>
                                        <th>BR</th>
                                        <th>KM</th>
                                        <th>DS</th>
                                        <th>Data</th>
                                        <th>HR</th>
                                    </tr>
                                    <c:if test="${locais eq null}">
                                        <c:forEach var="item" items="${datas}">
                                            <tr>
                                                <td><input type="radio" name="id" value="${item.id}" checked></td>
                                                <td>${item.id}</td>
                                                <td>${item.acidente.pessoas}</td>
                                                <td>${item.acidente.mortos}</td>
                                                <td>${item.acidente.feridosLeves}</td>
                                                <td>${item.acidente.feridosGraves}</td>
                                                <td>${item.acidente.ilesos}</td>                                            
                                                <td>${item.acidente.ignorados}</td>
                                                <td>${item.acidente.feridos}</td>
                                                <td>${item.acidente.veiculos}</td>
                                                <td>${item.acidente.local.uf}</td>
                                                <td>${item.acidente.local.municipio}</td>
                                                <td>${item.acidente.local.br}</td>
                                                <td>${item.acidente.local.km}</td>
                                                <td>${item.diaSemana}</td>
                                                <td>${item.dataAcidente}</td>
                                                <td>${item.horario}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${datas eq null}">
                                        <c:forEach var="item" items="${locais}">
                                            <tr>
                                                <td><input type="radio" name="id" value="${item.id}" checked></td>
                                                <td>${item.id}</td>
                                                <td>${item.acidente.pessoas}</td>
                                                <td>${item.acidente.mortos}</td>
                                                <td>${item.acidente.feridosLeves}</td>
                                                <td>${item.acidente.feridosGraves}</td>
                                                <td>${item.acidente.ilesos}</td>                                            
                                                <td>${item.acidente.ignorados}</td>
                                                <td>${item.acidente.feridos}</td>
                                                <td>${item.acidente.veiculos}</td>
                                                <td>${item.uf}</td>
                                                <td>${item.municipio}</td>
                                                <td>${item.br}</td>
                                                <td>${item.km}</td>
                                                <td>${item.acidente.data.diaSemana}</td>
                                                <td>${item.acidente.data.dataAcidente}</td>
                                                <td>${item.acidente.data.horario}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                </table>
                                <c:choose>
                                    <c:when test="${usuario.funcao eq 'administrador'}">
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
                                    </c:when>
                                    <c:when test="${usuario.funcao eq 'operador'}">
                                        <div class="form-group">
                                            <div class="col-md-2 col-md-offset-4">
                                                <button type="submit" name="opcao" value="editar" class="btn btn-default">
                                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Editar
                                                </button>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-20">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Legenda</h3>
                        </div>
                        <div class="panel-body">
                            <p><strong>id: </strong> Identificador único do acidente</p>
                            <p><strong>NP: </strong> Número de pessoas envolvidas</p>
                            <p><strong>NM: </strong> Número de pessoas mortas no acidente</p>
                            <p><strong>FL: </strong> Número de feridos leves do acidente</p>
                            <p><strong>FG: </strong> Número de feridos graves do acidente</p>
                            <p><strong>IL: </strong> Número de ilesos do acidente</p>
                            <p><strong>IG: </strong> Número de pessoas que não solicitaram atendimento</p>
                            <p><strong>TF: </strong> Total de feridos do acidente</p>
                            <p><strong>NV: </strong> Número de veículos envolvidos</p>
                            <p><strong>UF: </strong> Estado em que ocorreu o acidente</p>
                            <p><strong>Município: </strong> Município em que ocorreu o acidente</p> 
                            <p><strong>BR: </strong> Rodovia em que ocorreu o acidente</p>
                            <p><strong>KM: </strong> Km da rodovia em que ocorreu o acidente</p>                            
                            <p><strong>DS: </strong> Dia da Semana em que ocorreu o acidente</p>
                            <p><strong>Data: </strong> Data em que ocorreu o acidente (AAAA-mm-DD)</p>
                            <p><strong>HR: </strong> Horário em que ocorreu o acidente</p>
                        </div>
                    </div>
                </div>
            </div>
            <% session.setAttribute("flag", null); %>
            <% session.setAttribute("datas", null); %>
            <% session.setAttribute("locais", null);%>
        </c:if>

        <%@include file="/footer.jsp" %>
