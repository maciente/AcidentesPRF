package controle;

import java.util.ArrayList;
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
        Local old = (Local) sessao.load(Local.class, local.getId());
        if (!local.getUf().equals(old.getUf()) && local.getUf() != null) {
            old.setUf(local.getUf());
        }
        if (!local.getBr().equals(old.getBr()) && local.getBr() != null) {
            old.setBr(local.getBr());
        }
        if (!local.getKm().equals(old.getKm()) && local.getKm() != null) {
            old.setKm(local.getKm());
        }
        if (!local.getMunicipio().equals(old.getMunicipio()) && local.getMunicipio()!= null) {
            old.setMunicipio(local.getMunicipio());
        }
        sessao.update(old);
        tr.commit();
    }

    public ArrayList<Local> listarTodos() {
        return (ArrayList<Local>) sessao.createQuery("from Local").list();
    }

    public Local buscar(int id) {
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
