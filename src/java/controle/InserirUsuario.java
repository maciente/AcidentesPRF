package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mapeamento.Usuario;

public class InserirUsuario extends HttpServlet {

    private Usuario usuario;
    private UsuarioDAO dao;
    private String cpf;
    private String nome;
    private String funcao;
    private String senha;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // pega parâmetros do request
        cpf = request.getParameter("cpf");
        nome = request.getParameter("nome");
        funcao = request.getParameter("funcao");
        senha = request.getParameter("senha");

        //Cria objeto acidente
        usuario = new Usuario();
        dao = new UsuarioDAO();
        usuario.setCpf(cpf);
        usuario.setNome(nome);
        usuario.setFuncao(funcao);
        usuario.setSenha(senha);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            dao.salvar(usuario);
            out.println("usuario " + usuario.getNome() + " salvo");
            out.println("<input type=\"button\" value=\"Voltar\" onClick=\"history.go(-2)\">");
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
            out.println("<input type=\"button\" value=\"Voltar\" onClick=\"history.go(-1)\">");
        }
        out.close();
    }

}
