package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    private Map<String, Integer> mapa;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            busca = request.getParameter("busca");
            if (busca.equals("causa")) {
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
                int[] cont = new int[11];
                for(int i=0; i<11; i++){
                    cont[i] = 0;
                }
                if (!datas.isEmpty()) {
                    for (Data d : datas) {
                        cDao = new CondicaoDAO();
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
                            case "Ultrapassagem Indevida":
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
                    RequestDispatcher r = request.getRequestDispatcher("/tabelaAcidente.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/buscarAcidente.jsp");
                    r.forward(request, response);
                }
                session.setAttribute("lista", condicao);
                session.setAttribute("flag", true);
                RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
                r.forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("erro " + ex.getMessage());
        }
    }

}
