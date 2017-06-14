package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Usuario;

public class BuscarUsuario extends HttpServlet {

    private String fonte;
    private String cpf;
    private String nome;
    private List<Usuario> usuarios;
    private UsuarioDAO dao;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        try {
            fonte = request.getParameter("fonte");
            if (fonte.equals("CPF")) {
                cpf = request.getParameter("valor");
                dao = new UsuarioDAO();
                usuarios = dao.buscarPorCpf(cpf);
                session.setAttribute("lista", usuarios);
                RequestDispatcher r = request.getRequestDispatcher("/tabelaUsuario.jsp");
                r.forward(request, response);
            } else if (fonte.equals("Nome")) {
                nome = request.getParameter("valor");
                dao = new UsuarioDAO();
                usuarios = dao.buscarPorNome(nome);
                session.setAttribute("lista", usuarios);
                RequestDispatcher r = request.getRequestDispatcher("/tabelaUsuario.jsp");
                r.forward(request, response);
            } else if (fonte.equals("Todos")) {
                dao = new UsuarioDAO();
                usuarios = dao.listarTodos();
                session.setAttribute("lista", usuarios);
                RequestDispatcher r = request.getRequestDispatcher("/tabelaUsuario.jsp");
                r.forward(request, response);
            }

        } catch (Exception ex) {
            session.setAttribute("erro", ex);
            RequestDispatcher r = request.getRequestDispatcher("/erro.jsp");
            r.forward(request, response);
        }
    }

}
