package controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Usuario;

public class LoginAuthentication extends HttpServlet {

    private String senha;
    private String cpf;
    private Usuario usuario;
    private UsuarioDAO dao;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        dao = new UsuarioDAO();
        usuario = new Usuario();
        cpf = request.getParameter("cpf");
        senha = request.getParameter("senha");
        try {
            usuario = dao.login(cpf, senha);
            if (cpf.equals(usuario.getCpf())) {
                session.setAttribute("usuario", usuario);
                RequestDispatcher r = request.getRequestDispatcher("/index.jsp");
                r.forward(request, response);

            } else {
                session.setAttribute("flag", false);
                RequestDispatcher r = request.getRequestDispatcher("/login.jsp");
                r.forward(request, response);
            }
        } catch (Exception ex) {
            session.setAttribute("erro", ex);
            RequestDispatcher r = request.getRequestDispatcher("/erro.jsp");
            r.forward(request, response);
        }
    }
}
