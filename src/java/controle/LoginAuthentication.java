package controle;

import java.io.IOException;
import java.io.PrintWriter;
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); //obtem a sessao do usuario, caso exista

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        dao = new UsuarioDAO();
        usuario = new Usuario();
        cpf = request.getParameter("cpf");
        senha = request.getParameter("senha");
        try {
            usuario = dao.login(cpf, senha);
            if (cpf.equals(usuario.getCpf())) {
                session.setAttribute("usuario", usuario);
                RequestDispatcher r = request.getRequestDispatcher("/insereAcidente.jsp");
                r.forward(request, response);
                
            } else {
                session.invalidate();
                out.println("Não existe usuário com o cpf <b>" + cpf + "</b> ou a senha está incorreta ");
                out.println("<a href='login.jsp'><br>Tente Novamente</a>");
            }
        } catch (Exception ex) {
            out.println("Usuário e/ou senha inválidos" + ex);
            out.println("<input type=\"button\" value=\"Voltar\" onClick=\"history.go(-1)\">");
        }
    }
}
