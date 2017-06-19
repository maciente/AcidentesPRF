package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Condicao;

public class GerarRelatorio extends HttpServlet {

    private Condicao condicao;
    private CondicaoDAO dao;
    private int id;
    private String busca;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            busca = request.getParameter("busca");
            if (busca.equals("ID")) {
                id = Integer.parseInt(request.getParameter("id"));
                dao = new CondicaoDAO();
                condicao = dao.buscarPorId(id);
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
