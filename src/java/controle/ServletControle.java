package controle;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mapeamento.Usuario;

public class ServletControle extends HttpServlet {

    private Usuario usuario;
    private String opcao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        usuario = new Usuario();
        usuario = (Usuario) session.getAttribute("usuario");

        opcao = request.getParameter("opcao");
        out.println(opcao);
        if (opcao.equals("inserirAcidente")) {
            RequestDispatcher r = request.getRequestDispatcher("/inserirAcidente.jsp");
            r.forward(request, response);

        } else if (opcao.equals("buscarAcidente")) {
            RequestDispatcher r = request.getRequestDispatcher("/buscarAcidente.jsp");
            r.forward(request, response);

        } else if (opcao.equals("inserirUsuario")) {
            RequestDispatcher r = request.getRequestDispatcher("/inserirUsuario.jsp");
            r.forward(request, response);

        } else if (opcao.equals("buscarUsuario")) {
            RequestDispatcher r = request.getRequestDispatcher("/buscarUsuario.jsp");
            r.forward(request, response);

        } else if (opcao.equals("relatorio")) {
            RequestDispatcher r = request.getRequestDispatcher("/gerarRelatorio.jsp");
            r.forward(request, response);
        }
    }

}
