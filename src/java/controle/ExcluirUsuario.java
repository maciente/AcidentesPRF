package controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExcluirUsuario extends HttpServlet {

    private UsuarioDAO dao;
    private String cpf;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        try {
            cpf = request.getParameter("cpf");
            dao = new UsuarioDAO();
            dao.excluir(cpf);
            session.setAttribute("flag", true);
            RequestDispatcher r = request.getRequestDispatcher("/excluirUsuario.jsp");
            r.forward(request, response);
        } catch (Exception ex) {
            session.setAttribute("flag", false);
            RequestDispatcher r = request.getRequestDispatcher("/excluirUsuario.jsp");
            r.forward(request, response);
        }
    }

}
