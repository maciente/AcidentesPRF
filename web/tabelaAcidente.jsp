<%@include file="/buscarAcidente.jsp" %>
<div class="container">
    <div class="col-md-10 col-md-offset-1" style="background-color:white">
        <c:if test="${flag eq true}">
            <div class="row">
                <div class="col-md-15">
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
                                    </tr>
                                    <c:forEach var="item" items="${lista}">
                                        <tr>
                                            <td><input type="radio" name="id" value="${item.id}" checked></td>
                                            <td>${item.id}</td>
                                            <td>${item.pessoas}</td>
                                            <td>${item.mortos}</td>
                                            <td>${item.feridosLeves}</td>
                                            <td>${item.feridosGraves}</td>
                                            <td>${item.ilesos}</td>                                            
                                            <td>${item.ignorados}</td>
                                            <td>${item.feridos}</td>
                                            <td>${item.veiculos}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
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
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%        session.setAttribute("flag", null);
            %>
        </c:if>

        <%@include file="/footer.jsp" %>
