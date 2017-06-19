package controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Acidente;

public class AlterarAcidente extends HttpServlet {

    private String opcao;
    private int id;
    private Acidente acidente;
    private AcidenteDAO dao;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            opcao = request.getParameter("opcao");
            id = Integer.parseInt(request.getParameter("id"));
            dao = new AcidenteDAO();
            acidente = dao.buscarPorId(id);
            if (opcao.equals("editar")) {
                session.setAttribute("acidente", acidente);
                RequestDispatcher r = request.getRequestDispatcher("/editarAcidente.jsp");
                r.forward(request, response);
            } else if (opcao.equals("excluir")) {
                session.setAttribute("acidente", acidente);
                RequestDispatcher r = request.getRequestDispatcher("/excluirAcidente.jsp");
                r.forward(request, response);
            }

        } catch (Exception ex) {
            session.setAttribute("erro", ex);
            RequestDispatcher r = request.getRequestDispatcher("/erro.jsp");
            r.forward(request, response);
        }
    }

}
