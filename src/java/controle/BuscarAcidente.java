package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Data;
import mapeamento.Local;

public class BuscarAcidente extends HttpServlet {

    private List<Data> datas;
    private DataDAO dDao;
    private ArrayList<Local> locais;
    private LocalDAO lDao;
    private String dataI;
    private Date dataInicial;
    private String dataF;
    private Date dataFinal;
    private String estado;
    private String municipio;
    private int rodovia;
    private float kmInicial;
    private float kmFinal;
    private String busca;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            busca = request.getParameter("busca");
            if (busca.equals("data")) {
                dataI = request.getParameter("data_inicial");
                dataInicial = new Date(dataI);
                dataF = request.getParameter("data_final");
                dataInicial = new Date(dataF);
                dDao = new DataDAO();
                datas = dDao.buscar(dataInicial, dataFinal);
                if (!datas.isEmpty()) {
                    session.setAttribute("datas", datas);
                    session.setAttribute("flag", true);
                    RequestDispatcher r = request.getRequestDispatcher("/tabelaAcidente.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/buscarAcidente.jsp");
                    r.forward(request, response);
                }
            } else if (busca.equals("local")) {
                estado = request.getParameter("estado");
                municipio = request.getParameter("municipio").toUpperCase();
                lDao = new LocalDAO();
                locais = lDao.buscarPorLocal(estado, municipio);
                if (!locais.isEmpty()) {
                    session.setAttribute("locais", locais);
                    session.setAttribute("flag", true);
                    RequestDispatcher r = request.getRequestDispatcher("/tabelaAcidente.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/buscarAcidente.jsp");
                    r.forward(request, response);
                }
            } else if (busca.equals("rodovia")) {
                rodovia = Integer.parseInt(request.getParameter("br"));
                kmInicial = Float.parseFloat(request.getParameter("km_inicial"));
                kmFinal = Float.parseFloat(request.getParameter("km_final"));
                lDao = new LocalDAO();
                locais = lDao.buscarPorRodovia(rodovia, kmInicial, kmFinal);
                if (!locais.isEmpty()) {
                    session.setAttribute("locais", locais);
                    session.setAttribute("flag", true);
                    RequestDispatcher r = request.getRequestDispatcher("/tabelaAcidente.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/buscarAcidente.jsp");
                    r.forward(request, response);
                }
            }
        } catch (Exception ex) {
            System.out.println("erro " + ex.getMessage());
        }
    }

}
