package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
//            data = request.getParameter("dataFinal");
//            aux = data.split("-");
//            dia = Integer.parseInt(aux[2]);
//            mes = Integer.parseInt(aux[1]) - 1;
//            ano = Integer.parseInt(aux[0]) - 1900;
            dataFinal = new Date(ano, mes, dia);
            dDao = new DataDAO();
            datas = dDao.buscar(dataInicial, dataFinal);
            if (busca.equals("causa")) {
                long[] cont = new long[11];
                for (int i = 0; i < 11; i++) {
                    cont[i] = (long) 0;
                }
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
//                    cont[0] = cDao.causaPorData(dataInicial, dataFinal, "Animais na Pista");
//                    cont[1] = cDao.causaPorData(dataInicial, dataFinal, "Defeito mecânico em veículo");
//                    cont[2] = cDao.causaPorData(dataInicial, dataFinal, "Defeito na via");
//                    cont[3] = cDao.causaPorData(dataInicial, dataFinal, "Desobediência à sinalização");
//                    cont[4] = cDao.causaPorData(dataInicial, dataFinal, "Dormindo");
//                    cont[5] = cDao.causaPorData(dataInicial, dataFinal, "Falta de atenção");
//                    cont[6] = cDao.causaPorData(dataInicial, dataFinal, "Ingestão de álcool");
//                    cont[7] = cDao.causaPorData(dataInicial, dataFinal, "Não guardar distância de segurança");
//                    cont[8] = cDao.causaPorData(dataInicial, dataFinal, "Ultrapassagem indevida");
//                    cont[9] = cDao.causaPorData(dataInicial, dataFinal, "Velocidade incompatível");
//                    cont[10] = cDao.causaPorData(dataInicial, dataFinal, "Outras");

                    for (Data d : datas) {
                        condicao = cDao.buscarPorId(d.getId());
                        switch (condicao.getCausaAcidente()) {
                            case "Animais na Pista":
                                cont[0]++;
                                break;
                            case "Defeito mecânico em veículo":
                                cont[1]++;
                                break;
                            case "Defeito na via":
                                cont[2]++;
                                break;
                            case "Desobediência à sinalização":
                                cont[3]++;
                                break;
                            case "Dormindo":
                                cont[4]++;
                                break;
                            case "Falta de atenção":
                                cont[5]++;
                                break;
                            case "Ingestão de álcool":
                                cont[6]++;
                                break;
                            case "Não guardar distância de segurança":
                                cont[7]++;
                                break;
                            case "Ultrapassagem indevida":
                                cont[8]++;
                                break;
                            case "Velocidade incompatível":
                                cont[9]++;
                                break;
                            case "Outras":
                                cont[10]++;
                                break;
                        }
                    }
                    mapa = new HashMap<>();
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
                for (int i = 0; i < 16; i++) {
                    cont[i] = 0;
                }
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    for (Data d : datas) {
                        condicao = cDao.buscarPorId(d.getId());
                        switch (condicao.getTipoAcidente()) {
                            case "Atropelamento de animal":
                                cont[0]++;
                                break;
                            case "Atropelamento de pessoa":
                                cont[1]++;
                                break;
                            case "Capotamento":
                                cont[2]++;
                                break;
                            case "Colisão com bicicleta":
                                cont[3]++;
                                break;
                            case "Colisão com objeto fixo":
                                cont[4]++;
                                break;
                            case "Colisão com objeto móvel":
                                cont[5]++;
                                break;
                            case "Colisão frontal":
                                cont[6]++;
                                break;
                            case "Colisão lateral":
                                cont[7]++;
                                break;
                            case "Colisão Transversal":
                                cont[8]++;
                                break;
                            case "Colisão traseira":
                                cont[9]++;
                                break;
                            case "Danos Eventuais":
                                cont[10]++;
                                break;
                            case "Derramamento de Carga":
                                cont[11]++;
                                break;
                            case "Incêndio":
                                cont[12]++;
                                break;
                            case "Queda de motocicleta / bicicleta / veículo":
                                cont[13]++;
                                break;
                            case "Saída de Pista":
                                cont[14]++;
                                break;
                            case "Tombamento":
                                cont[15]++;
                                break;
                        }
                    }

                    mapa = new HashMap<>();
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
                for (int i = 0; i < 4; i++) {
                    cont[i] = 0;
                }
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    for (Data d : datas) {
                        condicao = cDao.buscarPorId(d.getId());
                        switch (condicao.getClassificacaoAcidente()) {
                            case "Com Vítimas Fatais":
                                cont[0]++;
                                break;
                            case "Com Vítimas Feridas":
                                cont[1]++;
                                break;
                            case "Ignorado":
                                cont[2]++;
                                break;
                            case "Sem Vítimas":
                                cont[3]++;
                                break;
                        }
                    }

                    mapa = new HashMap<>();
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
                for (int i = 0; i < 4; i++) {
                    cont[i] = 0;
                }
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    for (Data d : datas) {
                        condicao = cDao.buscarPorId(d.getId());
                        switch (condicao.getFaseDia()) {
                            case "Amanhecer":
                                cont[0]++;
                                break;
                            case "Anoitecer":
                                cont[1]++;
                                break;
                            case "Plena noite":
                                cont[2]++;
                                break;
                            case "Pleno dia":
                                cont[3]++;
                                break;
                        }
                    }

                    mapa = new HashMap<>();
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
                for (int i = 0; i < 9; i++) {
                    cont[i] = 0;
                }
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    for (Data d : datas) {
                        condicao = cDao.buscarPorId(d.getId());
                        switch (condicao.getCondMetereologica()) {
                            case "Ceu Claro":
                                cont[0]++;
                                break;
                            case "Chuva":
                                cont[1]++;
                                break;
                            case "Granizo":
                                cont[2]++;
                                break;
                            case "Ignorada":
                                cont[3]++;
                                break;
                            case "Neve":
                                cont[4]++;
                                break;
                            case "Nevoeiro/neblina":
                                cont[5]++;
                                break;
                            case "Nublado":
                                cont[6]++;
                                break;
                            case "Sol":
                                cont[7]++;
                                break;
                            case "Vento":
                                cont[8]++;
                                break;
                        }
                    }

                    mapa = new HashMap<>();
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
                for (int i = 0; i < 3; i++) {
                    cont[i] = 0;
                }
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    for (Data d : datas) {
                        condicao = cDao.buscarPorId(d.getId());
                        switch (condicao.getTipoPista()) {
                            case "Dupla":
                                cont[0]++;
                                break;
                            case "Múltipla":
                                cont[1]++;
                                break;
                            case "Simples":
                                cont[2]++;
                                break;
                        }
                    }

                    mapa = new HashMap<>();
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
                for (int i = 0; i < 3; i++) {
                    cont[i] = 0;
                }
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    for (Data d : datas) {
                        condicao = cDao.buscarPorId(d.getId());
                        switch (condicao.getTracadoVia()) {
                            case "Cruzamento":
                                cont[0]++;
                                break;
                            case "Curva":
                                cont[1]++;
                                break;
                            case "Reta":
                                cont[2]++;
                                break;
                        }
                    }

                    mapa = new HashMap<>();
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
                for (int i = 0; i < 2; i++) {
                    cont[i] = 0;
                }
                cDao = new CondicaoDAO();
                if (!datas.isEmpty()) {
                    for (Data d : datas) {
                        condicao = cDao.buscarPorId(d.getId());
                        switch (condicao.getUsoSolo()) {
                            case "Urbano":
                                cont[0]++;
                                break;
                            case "Rural":
                                cont[1]++;
                                break;
                        }
                    }

                    mapa = new HashMap<>();
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
