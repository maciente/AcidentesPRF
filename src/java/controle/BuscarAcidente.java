package controle;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Acidente;

public class BuscarAcidente extends HttpServlet {

    private String fonte;
    private int id;
    private List<Acidente> acidentes;
    private AcidenteDAO dao;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        try {
            fonte = request.getParameter("fonte");
            if (fonte.equals("id")) {
                id = Integer.parseInt(request.getParameter("valor"));
                dao = new AcidenteDAO();
                acidentes = dao.buscarPorId(id);
                if (!acidentes.isEmpty()) {
                    session.setAttribute("lista", acidentes);
                    session.setAttribute("flag", true);
                    RequestDispatcher r = request.getRequestDispatcher("/tabelaAcidente.jsp");
                    r.forward(request, response);
                } else {
                    session.setAttribute("flag", false);
                    RequestDispatcher r = request.getRequestDispatcher("/buscarAcidente.jsp");
                    r.forward(request, response);
                }
            } else {
                session.setAttribute("flag", false);
                RequestDispatcher r = request.getRequestDispatcher("/buscarAcidente.jsp");
                r.forward(request, response);
            }

        } catch (Exception e) {
            session.setAttribute("erro", e);
            System.out.println(e.getLocalizedMessage());
//            RequestDispatcher r = request.getRequestDispatcher("/erro.jsp");
//            r.forward(request, response);
        }
    }

}
