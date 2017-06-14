<%@include file="/header.jsp" %>
<div class="row">
    <div class="col-md-15 col-md-offset-0">    	
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Consultar Usuários</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method = "post" action = "/AcidentesPRF/BuscarUsuario">
                    <div class="form-group">
                        <label class="row control-label col-md-3">Pesquisar por: </label>
                        <div class="col-md-9">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-filter" aria-hidden="true"></span></span>
                                <select class="form-control" name="fonte" aria-describedby="basic-addon1">
                                    <option value="Todos">Todos os Usuários</option> 
                                    <option value="CPF">CPF</option> 
                                    <option value="Nome">Nome</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="row col-md-3 control-label">Busca</label>
                        <div class="col-md-9">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
                                <input type="text" class="form-control" name="valor" placeholder="CPF ou Nome" aria-describedby="basic-addon1">
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
</div>
<%@include file="/footer.jsp" %>
