<%@include file="/setarRelatorio.jsp" %>
<div class="container">
    <div class="col-md-10 col-md-offset-1" style="background-color:white">
        <c:if test="${flag eq true}">
        <div class="row">
            <div class="col-md-15">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Dados do Relatório</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped">
                            <tr>
                                <th>Item</th>
                                <th>Quantidade</th>
                            </tr>
                            <c:forEach var="item" items="${mapa}">
                                <tr>
                                    <td>${item.key}</td>
                                    <td>${item.value}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <% session.setAttribute("flag", null);%>
        </c:if>
        <%@include file="/footer.jsp" %>
