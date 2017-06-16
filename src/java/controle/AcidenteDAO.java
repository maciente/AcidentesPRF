package controle;

import java.util.ArrayList;
import java.util.List;
import mapeamento.Acidente;
import mapeamento.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AcidenteDAO {

    private Session sessao;

    public AcidenteDAO() {
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

    public int proximoId() {
        List valor = sessao.createQuery("Select max(id) from Acidente").list();
        int id = (int) valor.get(0);
        return id + 1;
    }

    public void salvar(Acidente acidente) {
        sessao.save(acidente);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }

    public void alterar(Acidente acidente) {
        Transaction tr = sessao.beginTransaction();
        sessao.update(acidente);
        tr.commit();
    }

    public ArrayList<Acidente> listarTodos() {
        return (ArrayList<Acidente>) sessao.createQuery("from Acidente where id < 20").list();
    }

    public Acidente buscarPorId(int id) {
        ArrayList<Acidente> acidentes = (ArrayList<Acidente>) sessao.createQuery("from Acidente where id = " + id).list();
        Acidente acidente = new Acidente();
        for(Acidente a : acidentes){
            acidente = a;
        }
        return acidente;
    }

    public void excluir(int id) {
        Acidente acidente = new Acidente();
        sessao.load(acidente, id);
        sessao.delete(acidente);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }
}
