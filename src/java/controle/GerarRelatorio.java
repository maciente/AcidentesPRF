package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Condicao;
import mapeamento.Data;

public class GerarRelatorio extends HttpServlet {

    private Condicao condicao;
    private CondicaoDAO cDao;
    private ArrayList<Data> datas;
    private DataDAO dDao;
    private int dia;
    private int mes;
    private int ano;
    private String[] aux;
    private String data;
    private Date dataInicial;
    private Date dataFinal;
    private String busca;
    private Map<String, Long> mapa;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            busca = request.getParameter("busca");
            data = request.getParameter("dataInicial");
            aux = data.split("-");
            dia = Integer.parseInt(aux[2]);
            mes = Integer.parseInt(aux[1]) - 1;
            ano = Integer.parseInt(aux[0]) - 1900;
            dataInicial = new Date(ano, mes, dia);
            data = request.getParameter("dataFinal");
            aux = data.split("-");
            dia = Integer.parseInt(aux[2]);
            mes = Integer.parseInt(aux[1]) - 1;
            ano = Integer.parseInt(aux[0]) - 1900;
            dataFinal = new Date(ano, mes, dia);
            dDao = new DataDAO();
            datas = dDao.buscar(dataInicial, dataFinal);
            if (busca.equals("causa")) {
                long[] cont = new long[11];
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    cont[0] = cDao.causaPorData(dataInicial, dataFinal, "Animais na Pista");
                    cont[1] = cDao.causaPorData(dataInicial, dataFinal, "Defeito mecânico em veículo");
                    cont[2] = cDao.causaPorData(dataInicial, dataFinal, "Defeito na via");
                    cont[3] = cDao.causaPorData(dataInicial, dataFinal, "Desobediência à sinalização");
                    cont[4] = cDao.causaPorData(dataInicial, dataFinal, "Dormindo");
                    cont[5] = cDao.causaPorData(dataInicial, dataFinal, "Falta de atenção");
                    cont[6] = cDao.causaPorData(dataInicial, dataFinal, "Ingestão de álcool");
                    cont[7] = cDao.causaPorData(dataInicial, dataFinal, "Não guardar distância de segurança");
                    cont[8] = cDao.causaPorData(dataInicial, dataFinal, "Ultrapassagem indevida");
                    cont[9] = cDao.causaPorData(dataInicial, dataFinal, "Velocidade incompatível");
                    cont[10] = cDao.causaPorData(dataInicial, dataFinal, "Outras");
                    mapa = new LinkedHashMap<>();
                    mapa.put("Animais na Pista", cont[0]);
                    mapa.put("Defeito mecânico em veículo", cont[1]);
                    mapa.put("Defeito na via", cont[2]);
                    mapa.put("Desobediência à sinalização", cont[3]);
                    mapa.put("Dormindo", cont[4]);
                    mapa.put("Falta de atenção", cont[5]);
                    mapa.put("Ingestão de álcool", cont[6]);
                    mapa.put("Não guardar distância de segurança", cont[7]);
                    mapa.put("Ultrapassagem Indevida", cont[8]);
                    mapa.put("Velocidade incompatível", cont[9]);
                    mapa.put("Outras", cont[10]);
                    session.setAttribute("flag", true);
                    session.setAttribute("mapa", mapa);
                    RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                    r.forward(request, response);
                }
            } else if (busca.equals("tipoAcidente")) {
                long[] cont = new long[16];
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    cont[0] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Atropelamento de animal");
                    cont[1] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Atropelamento de pessoa");
                    cont[2] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Capotamento");
                    cont[3] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Colisão com bicicleta");
                    cont[4] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Colisão com objeto fixo");
                    cont[5] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Colisão com objeto móvel");
                    cont[6] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Colisão frontal");
                    cont[7] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Colisão lateral");
                    cont[8] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Colisão Transversal");
                    cont[9] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Colisão traseira");
                    cont[10] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Danos Eventuais");
                    cont[11] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Derramamento de Carga");
                    cont[12] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Incêndio");
                    cont[13] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Queda de motocicleta / bicicleta / veículo");
                    cont[14] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Saída de Pista");
                    cont[15] = cDao.tipoAcidPorData(dataInicial, dataFinal, "Tombamento");
                    mapa = new LinkedHashMap<>();
                    mapa.put("Atropelamento de animal", cont[0]);
                    mapa.put("Atropelamento de pessoa", cont[1]);
                    mapa.put("Capotamento", cont[2]);
                    mapa.put("Colisão com bicicleta", cont[3]);
                    mapa.put("Colisão com objeto fixo", cont[4]);
                    mapa.put("Colisão com objeto móvel", cont[5]);
                    mapa.put("Colisão frontal", cont[6]);
                    mapa.put("Colisão lateral", cont[7]);
                    mapa.put("Colisão Transversal", cont[8]);
                    mapa.put("Colisão traseira", cont[9]);
                    mapa.put("Danos Eventuais", cont[10]);
                    mapa.put("Derramamento de Carga", cont[11]);
                    mapa.put("Incêndio", cont[12]);
                    mapa.put("Queda de motocicleta / bicicleta / veículo", cont[13]);
                    mapa.put("Saída de Pista", cont[14]);
                    mapa.put("Tombamento", cont[15]);
                    session.setAttribute("flag", true);
                    session.setAttribute("mapa", mapa);
                    RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                    r.forward(request, response);
                }
            } else if (busca.equals("classificacao")) {
                long[] cont = new long[4];
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    cont[0] = cDao.classificacaoPorData(dataInicial, dataFinal, "Com Vítimas Fatais");
                    cont[1] = cDao.classificacaoPorData(dataInicial, dataFinal, "Com Vítimas Feridas");
                    cont[2] = cDao.classificacaoPorData(dataInicial, dataFinal, "Ignorado");
                    cont[3] = cDao.classificacaoPorData(dataInicial, dataFinal, "Sem Vítimas");
                    mapa = new LinkedHashMap<>();
                    mapa.put("Com Vítimas Fatais", cont[0]);
                    mapa.put("Com Vítimas Feridas", cont[1]);
                    mapa.put("Ignorado", cont[2]);
                    mapa.put("Sem Vítimas", cont[3]);
                    session.setAttribute("flag", true);
                    session.setAttribute("mapa", mapa);
                    RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                    r.forward(request, response);
                }
            } else if (busca.equals("fase")) {
                long[] cont = new long[4];
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    cont[0] = cDao.fasePorData(dataInicial, dataFinal, "Amanhecer");
                    cont[1] = cDao.fasePorData(dataInicial, dataFinal, "Anoitecer");
                    cont[2] = cDao.fasePorData(dataInicial, dataFinal, "Plena noite");
                    cont[3] = cDao.fasePorData(dataInicial, dataFinal, "Pleno dia");
                    mapa = new LinkedHashMap<>();
                    mapa.put("Amanhecer", cont[0]);
                    mapa.put("Anoitecer", cont[1]);
                    mapa.put("Plena noite", cont[2]);
                    mapa.put("Pleno dia", cont[3]);
                    session.setAttribute("flag", true);
                    session.setAttribute("mapa", mapa);
                    RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                    r.forward(request, response);
                }
            } else if (busca.equals("cond")) {
                long[] cont = new long[9];
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    cont[0] = cDao.condPorData(dataInicial, dataFinal, "Ceu Claro");
                    cont[1] = cDao.condPorData(dataInicial, dataFinal, "Chuva");
                    cont[2] = cDao.condPorData(dataInicial, dataFinal, "Granizo");
                    cont[3] = cDao.condPorData(dataInicial, dataFinal, "Ignorada");
                    cont[4] = cDao.condPorData(dataInicial, dataFinal, "Neve");
                    cont[5] = cDao.condPorData(dataInicial, dataFinal, "Nevoeiro/neblina");
                    cont[6] = cDao.condPorData(dataInicial, dataFinal, "Nublado");
                    cont[7] = cDao.condPorData(dataInicial, dataFinal, "Sol");
                    cont[8] = cDao.condPorData(dataInicial, dataFinal, "Vento");
                    mapa = new LinkedHashMap<>();
                    mapa.put("Ceu Claro", cont[0]);
                    mapa.put("Chuva", cont[1]);
                    mapa.put("Granizo", cont[2]);
                    mapa.put("Ignorada", cont[3]);
                    mapa.put("Neve", cont[4]);
                    mapa.put("Nevoeiro/neblina", cont[5]);
                    mapa.put("Nublado", cont[6]);
                    mapa.put("Sol", cont[7]);
                    mapa.put("Vento", cont[8]);
                    session.setAttribute("flag", true);
                    session.setAttribute("mapa", mapa);
                    RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                    r.forward(request, response);
                }
            } else if (busca.equals("tipoPista")) {
                long[] cont = new long[3];
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    cont[0] = cDao.tipoPistaPorData(dataInicial, dataFinal, "Dupla");
                    cont[1] = cDao.tipoPistaPorData(dataInicial, dataFinal, "Múltipla");
                    cont[2] = cDao.tipoPistaPorData(dataInicial, dataFinal, "Simples");
                    mapa = new LinkedHashMap<>();
                    mapa.put("Dupla", cont[0]);
                    mapa.put("Múltipla", cont[1]);
                    mapa.put("Simples", cont[2]);
                    session.setAttribute("flag", true);
                    session.setAttribute("mapa", mapa);
                    RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                    r.forward(request, response);
                }
            } else if (busca.equals("tracado")) {
                long[] cont = new long[3];
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    cont[0] = cDao.tracadoPorData(dataInicial, dataFinal, "Cruzamento");
                    cont[1] = cDao.tracadoPorData(dataInicial, dataFinal, "Curva");
                    cont[2] = cDao.tracadoPorData(dataInicial, dataFinal, "Reta");
                    mapa = new LinkedHashMap<>();
                    mapa.put("Cruzamento", cont[0]);
                    mapa.put("Curva", cont[1]);
                    mapa.put("Reta", cont[2]);
                    session.setAttribute("flag", true);
                    session.setAttribute("mapa", mapa);
                    RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                    r.forward(request, response);
                }
            } else if (busca.equals("solo")) {
                long[] cont = new long[2];
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    cont[0] = cDao.usoSoloPorData(dataInicial, dataFinal, "Urbano");
                    cont[1] = cDao.usoSoloPorData(dataInicial, dataFinal, "Rural");
                    mapa = new LinkedHashMap<>();
                    mapa.put("Perímetro Urbano", cont[0]);
                    mapa.put("Perímetro Rural", cont[1]);
                    session.setAttribute("flag", true);
                    session.setAttribute("mapa", mapa);
                    RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/setarRelatorio.jsp");
                    r.forward(request, response);
                }
            }
        } catch (Exception ex) {
            System.out.println("erro " + ex.getMessage());
        }
    }

}
