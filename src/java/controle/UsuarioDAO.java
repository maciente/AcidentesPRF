package controle;

import java.util.ArrayList;
import mapeamento.Usuario;
import mapeamento.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    private Session sessao;

    public UsuarioDAO() {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();
    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public void fecharSessao() {
        sessao.close();
    }

    public Usuario login(String cpf, String senha) {
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sessao.createQuery("from "
                + "Usuario where cpf = '" + cpf + "' and senha = '" + senha + "'").list();
        Usuario usuario = new Usuario();
        for (Usuario u : usuarios) {
            usuario = u;
        }
        return usuario;
    }

    public void salvar(Usuario usuario) {
        sessao.save(usuario);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }

    public void alterar(Usuario usuario) {
        Transaction tr = sessao.beginTransaction();
        sessao.update(usuario);
        tr.commit();
    }

    public ArrayList<Usuario> listarTodos() {
        return (ArrayList<Usuario>) sessao.createQuery("from Usuario").list();
    }

    public ArrayList<Usuario> buscarPorCpf(String cpf) {
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sessao.createQuery("from Usuario where cpf like '%" + cpf + "%'").list();
        return usuarios;
    }
    
    public ArrayList<Usuario> buscarPorNome(String nome) {
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sessao.createQuery("from Usuario where nome like '%" + nome + "%'").list();
        return usuarios;
    }

    public void excluir(String cpf) {
        Usuario usuario = new Usuario();
        sessao.load(usuario, cpf);
        sessao.delete(usuario);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }
}
