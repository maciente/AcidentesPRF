package controle;

import java.util.ArrayList;
import mapeamento.Data;
import mapeamento.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DataDAO {

    private Session sessao;

    public DataDAO() {
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

    public void salvar(Data data) {
        sessao.save(data);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }

    public void alterar(Data data) {
        Transaction tr = sessao.beginTransaction();
        Data old = (Data) sessao.load(Data.class, data.getId());
        if (!data.getDiaSemana().equals(old.getDiaSemana()) && data.getDiaSemana() != null) {
            old.setDiaSemana(data.getDiaSemana());
        }
        if (!data.getDataAcidente().equals(old.getDataAcidente()) && data.getDataAcidente() != null) {
            old.setDataAcidente(data.getDataAcidente());
        }
        if (!data.getHorario().equals(old.getHorario()) && data.getHorario() != null) {
            old.setHorario(data.getHorario());
        }
        sessao.update(old);
        tr.commit();
    }

    public ArrayList<Data> listarTodos() {
        return (ArrayList<Data>) sessao.createQuery("from Data").list();
    }

    public Data buscar(int id) {
        ArrayList<Data> datas = (ArrayList<Data>) sessao.createQuery("from Data where id = " + id).list();
        Data data = new Data();
        for(Data d : datas){
            data = d;
        }
        return data;
    }

    public void excluir(int id) {
        Data data = new Data();
        sessao.load(data, id);
        sessao.delete(data);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }
}
