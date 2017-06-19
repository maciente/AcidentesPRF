package controle;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Acidente;
import mapeamento.Condicao;
import mapeamento.Data;
import mapeamento.Local;

public class EditarAcidente extends HttpServlet {

    private Acidente acidente;
    private AcidenteDAO aDao;
    private Data data;
    private DataDAO dDao;
    private Local local;
    private LocalDAO lDao;
    private Condicao condicao;
    private CondicaoDAO cDao;
    private int id;
    private int mortos;
    private int feridosLeves;
    private int feridosGraves;
    private int ilesos;
    private int ignorados;
    private int veiculos;
    private int dia;
    private int mes;
    private int ano;
    private String dataAcid;
    private String[] aux;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        // pega parâmetros do request
        id = Integer.parseInt(request.getParameter("id"));
        mortos = Integer.parseInt(request.getParameter("mortos"));
        feridosLeves = Integer.parseInt(request.getParameter("feridos_leves"));
        feridosGraves = Integer.parseInt(request.getParameter("feridos_graves"));
        ilesos = Integer.parseInt(request.getParameter("ilesos"));
        ignorados = Integer.parseInt(request.getParameter("ignorados"));
        veiculos = Integer.parseInt(request.getParameter("veiculos"));
        dataAcid = request.getParameter("data");
        aux = dataAcid.split("-");
        dia = Integer.parseInt(aux[2]);
        mes = Integer.parseInt(aux[1]) - 1;
        ano = Integer.parseInt(aux[0]) - 1900;
        dataAcidente = new Date(ano, mes, dia);
        diaSemana = request.getParameter("semana");
        horario = Integer.parseInt(request.getParameter("horario"));
        estado = request.getParameter("estado");
        municipio = request.getParameter("municipio").toUpperCase();
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
        acidente.setId(id);
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

        HttpSession session = request.getSession();
        try {
            aDao.alterar(acidente);
            dDao.alterar(data);
            lDao.alterar(local);
            cDao.alterar(condicao);
            session.setAttribute("flag", true);
            session.setAttribute("acidente", acidente);
            RequestDispatcher r = request.getRequestDispatcher("/editarAcidente.jsp");
            r.forward(request, response);
        } catch (Exception ex) {
            session.setAttribute("flag", false);
            RequestDispatcher r = request.getRequestDispatcher("/editarAcidente.jsp");
            r.forward(request, response);
        }
    }

}
