package controle;

import java.util.ArrayList;
import java.util.List;
import mapeamento.Local;
import mapeamento.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LocalDAO {

    private Session sessao;

    public LocalDAO() {
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

    public void salvar(Local local) {
        sessao.save(local);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }

    public void alterar(Local local) {
        Transaction tr = sessao.beginTransaction();
        sessao.update(local);
        tr.commit();
    }

    public ArrayList<Local> listarTodos() {
        return (ArrayList<Local>) sessao.createQuery("from Local").list();
    }

    public ArrayList<Local> buscar(String estado, String municipio, int rodovia, float kmInicial, float kmFinal) {
        return (ArrayList<Local>) sessao.createQuery("from Local where uf = '" + estado + "' "
                + "and municipio like '%" + municipio + "%' and br = " + rodovia + " and km >= "
                + kmInicial + " and km <= " + kmFinal).list();
    }
    
    public List<Local> buscarPorRodovia(int rodovia) {
        return (ArrayList<Local>) sessao.createQuery("from Local where br = " + rodovia).list();
    }
    
    public Local buscarPorId(int id) {
        ArrayList<Local> locais = (ArrayList<Local>) sessao.createQuery("from Local where id = " + id).list();
        Local local = new Local();
        for(Local l : locais){
            local = l;
        }
        return local;
    }

    public void excluir(int id) {
        Local local = new Local();
        sessao.load(local, id);
        sessao.delete(local);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }
}
