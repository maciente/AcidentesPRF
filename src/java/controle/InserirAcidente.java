package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mapeamento.Acidente;
import mapeamento.Condicao;
import mapeamento.Data;
import mapeamento.Local;

public class InserirAcidente extends HttpServlet {

    private Acidente acidente;
    private AcidenteDAO aDao;
    private Data data;
    private DataDAO dDao;
    private Local local;
    private LocalDAO lDao;
    private Condicao condicao;
    private CondicaoDAO cDao;
    private int mortos;
    private int feridosLeves;
    private int feridosGraves;
    private int ilesos;
    private int ignorados;
    private int veiculos;
    private int dia;
    private int mes;
    private int ano;
    private Date dataAcidente;
    private String diaSemana;
    private int horario;
    private String estado;
    private String municipio;
    private int rodovia;
    private float km;
    private String causa;
    private String tipoAcidente;
    private String classificacaoAcidente;
    private String faseDia;
    private String sentidoVia;
    private String condMetereologica;
    private String tipoPista;
    private String tracadoVia;
    private String usoSolo;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // pega parâmetros do request
        mortos = Integer.parseInt(request.getParameter("mortos"));
        feridosLeves = Integer.parseInt(request.getParameter("feridos_leves"));
        feridosGraves = Integer.parseInt(request.getParameter("feridos_graves"));
        ilesos = Integer.parseInt(request.getParameter("ilesos"));
        ignorados = Integer.parseInt(request.getParameter("ignorados"));
        veiculos = Integer.parseInt(request.getParameter("veiculos"));
        dia = Integer.parseInt(request.getParameter("dia"));
        mes = Integer.parseInt(request.getParameter("mes"));
        ano = Integer.parseInt(request.getParameter("ano"));
        dataAcidente = new Date(ano, mes, dia);
        diaSemana = request.getParameter("semana");
        horario = Integer.parseInt(request.getParameter("horario"));
        estado = request.getParameter("estado");
        municipio = request.getParameter("municipio");
        rodovia = Integer.parseInt(request.getParameter("br"));
        km = Float.parseFloat(request.getParameter("km"));
        causa = request.getParameter("causa");
        tipoAcidente = request.getParameter("tipo_acidente");
        classificacaoAcidente = request.getParameter("classificacao");
        faseDia = request.getParameter("fase");
        sentidoVia = request.getParameter("sentido");
        condMetereologica = request.getParameter("cond_metereologica");
        tipoPista = request.getParameter("tipo_pista");
        tracadoVia = request.getParameter("tracado");
        usoSolo = request.getParameter("uso_solo");

        //Cria objeto acidente
        acidente = new Acidente();
        aDao = new AcidenteDAO();
        acidente.setId(aDao.proximoId());
        acidente.setPessoas(mortos + feridosLeves + feridosGraves + ilesos + ignorados);
        acidente.setMortos(mortos);
        acidente.setFeridosLeves(feridosLeves);
        acidente.setFeridosGraves(feridosGraves);
        acidente.setIlesos(ilesos);
        acidente.setIgnorados(ignorados);
        acidente.setFeridos(feridosLeves + feridosGraves);
        acidente.setVeiculos(veiculos);

        //Cria objeto data
        data = new Data();
        dDao = new DataDAO();
        data.setAcidente(acidente);
        data.setId(acidente.getId());
        data.setDiaSemana(diaSemana);
        data.setDataAcidente(dataAcidente);
        data.setHorario(horario);

        //Cria objeto local
        local = new Local();
        lDao = new LocalDAO();
        local.setAcidente(acidente);
        local.setId(acidente.getId());
        local.setUf(estado);
        local.setBr(rodovia);
        local.setKm(km);
        local.setMunicipio(municipio);

        //Cria objeto condição
        condicao = new Condicao();
        cDao = new CondicaoDAO();
        condicao.setAcidente(acidente);
        condicao.setId(acidente.getId());
        condicao.setCausaAcidente(causa);
        condicao.setTipoAcidente(tipoAcidente);
        condicao.setClassificacaoAcidente(classificacaoAcidente);
        condicao.setFaseDia(faseDia);
        condicao.setSentidoVia(sentidoVia);
        condicao.setCondMetereologica(condMetereologica);
        condicao.setTipoPista(tipoPista);
        condicao.setTracadoVia(tracadoVia);
        condicao.setUsoSolo(usoSolo);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            aDao.salvar(acidente);
            dDao.salvar(data);
            lDao.salvar(local);
            cDao.salvar(condicao);
            out.println("Acidente " + acidente.getId() + " salvo");
            out.println("<input type=\"button\" value=\"Voltar\" onClick=\"history.go(-2)\">");
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
            out.println("<input type=\"button\" value=\"Voltar\" onClick=\"history.go(-1)\">");
        }
        out.close();
    }

}
