<%@include file="/header.jsp" %>
<div>
    <form method="POST" action="/AcidentesPRF/InserirAcidente">
        <div align="center">
            <h3>Dados do Acidente</h3>
            <p>N�mero de mortos: <input type="text" name="mortos" size="3"></p>
            <p>N�mero de feridos leves: <input type="text" name="feridos_leves" size="3"></p>
            <p>N�mero de feridos graves: <input type="text" name="feridos_graves" size="3"></p>
            <p>N�mero de pessoas ilesas: <input type="text" name="ilesos" size="3"></p>
            <p>N�mero de pessoas ignoradas (n�o solicitaram atendimento): <input type="text" name="ignorados" size="3"></p>
            <p>N�mero de ve�culos envolvidos: <input type="text" name="veiculos" size="3"></p>
        </div>
        <div align="center">
            <h3>Data do Acidente</h3>
            <p>Data do acidente: 
                <input type="text" name="dia" size="2">/
                <input type="text" name="mes" size="2">/
                <input type="text" name="ano" size="4">
            </p>
            <p>Dia da semana:<select name="semana">
                    <option value="Domingo">Domingo</option>
                    <option value="Segunda">Segunda</option>
                    <option value="Ter�a">Ter�a</option>
                    <option value="Quarta">Quarta</option>
                    <option value="Quinta">Quinta</option>
                    <option value="Sexta">Sexta</option>
                    <option value="S�bado">S�bado</option>
                </select>
            </p>
            <p>Hor�rio do acidente:<select name="horario">
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
            </p>
        </div>
        <div align="center">
            <h3>Local do Acidente</h3>
            <p>Estado: <input type="text" name="estado" size="2"></p>
            <p>Munic�pio: <input type="text" name="municipio" size="40"></p>
            <p>Rodovia: BR <input type="text" name="br" size="3"></p>
            <p>Km: <input type="text" name="km" size="5"></p>
        </div>
        <div align="center">
            <h3>Condi��es do Acidente</h3>
            <p>Causa do acidente: 
                <select name="causa">
                    <option value="Animais na Pista">Animais na Pista</option>
                    <option value="Defeito mec�nico em ve�culo">Defeito mec�nico em ve�culo</option>
                    <option value="Defeito na via">Defeito na via</option>
                    <option value="Desobedi�ncia � sinaliza��o">Desobedi�ncia � sinaliza��o</option>
                    <option value="Dormindo">Dormindo</option>
                    <option value="Falta de aten��o">Falta de aten��o</option>
                    <option value="Ingest�o de �lcool">Ingest�o de �lcool</option>
                    <option value="N�o guardar dist�ncia de seguran�a">N�o guardar dist�ncia de seguran�a</option>
                    <option value="Ultrapassagem indevida">Ultrapassagem indevida</option>
                    <option value="Velocidade incompat�vel">Velocidade incompat�vel</option>
                    <option value="Outras">Outras</option>
                </select>
            </p>
            <p>Tipo de acidente:
                <select name="tipo_acidente">
                    <option value="Atropelamento de animal">Atropelamento de animal</option>
                    <option value="Atropelamento de pessoa">Atropelamento de pessoa</option>
                    <option value="Capotamento">Capotamento</option>
                    <option value="Colis�o com bicicleta">Colis�o com bicicleta</option>
                    <option value="Colis�o com objeto fixo">Colis�o com objeto fixo</option>
                    <option value="Colis�o com objeto m�vel">Colis�o com objeto m�vel</option>
                    <option value="Colis�o frontal">Colis�o frontal</option>
                    <option value="Colis�o lateral">Colis�o lateral</option>
                    <option value="Colis�o Transversal">Colis�o Transversal</option>
                    <option value="Colis�o traseira">Colis�o traseira</option>
                    <option value="Danos Eventuais">Danos Eventuais</option>
                    <option value="Derramamento de Carga">Derramamento de Carga</option>
                    <option value="Inc�ndio">Inc�ndio</option>
                    <option value="Queda de motocicleta / bicicleta / ve�culo">Queda de motocicleta / bicicleta / ve�culo</option>
                    <option value="Sa�da de Pista">Sa�da de Pista</option>
                    <option value="Tombamento">Tombamento</option>
                </select>
            </p>
            <p>Classifica��o do acidente:
                <select name="classificacao">
                    <option value="Com V�timas Fatais">Com V�timas Fatais</option>
                    <option value="Com V�timas Feridas">Com V�timas Feridas</option>
                    <option value="Ignorado">Ignorado</option>
                    <option value="Sem V�timas">Sem V�timas</option>
                </select>
            </p>
            <p>Fase do dia:
                <select name="fase">
                    <option value="Amanhecer">Amanhecer</option>
                    <option value="Anoitecer">Anoitecer</option>
                    <option value="Plena noite">Plena noite</option>
                    <option value="Pleno dia">Pleno dia</option>
                </select>
            </p>
            <p>Sentido da via:
                <select name="sentido">
                    <option value="Crescente">Crescente</option>
                    <option value="Decrescente">Decrescente</option>
                </select>
            </p>
            <p>Condi��es metereol�gicas:
                <select name="cond_metereologica">
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
            </p>
            <p>Tipo de pista:
                <select name="tipo_pista">
                    <option value="Dupla">Dupla</option>
                    <option value="M�ltipla">M�ltipla</option>
                    <option value="Simples">Simples</option>
                </select>
            </p>
            <p>Tra�ado da via:
                <select name="tracado">
                    <option value="Cruzamento">Cruzamento</option>
                    <option value="Curva">Curva</option>
                    <option value="Reta">Reta</option>
                </select>
            </p>
            <p>Uso do solo:
                <select name="uso_solo">
                    <option value="Rural">Rural</option>
                    <option value="Urbano">Urbano</option>
                </select>
            </p>
        </div>
        <div align="center">
            <p>
                <input type="submit" value="Salvar">
                <input type="reset" value="Resetar">
            </p> 
        </div>
    </form>
</div>
<%@include file="/footer.jsp" %>
