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
        Acidente old = (Acidente) sessao.load(Acidente.class, acidente.getId());
        if (!acidente.getPessoas().equals(old.getPessoas()) && acidente.getPessoas() != null) {
            old.setPessoas(acidente.getPessoas());
        }
        if (!acidente.getMortos().equals(old.getMortos()) && acidente.getMortos() != null) {
            old.setMortos(acidente.getMortos());
        }
        if (!acidente.getFeridosLeves().equals(old.getFeridosLeves()) && acidente.getFeridosLeves() != null) {
            old.setFeridosLeves(acidente.getFeridosLeves());
        }
        if (!acidente.getFeridosGraves().equals(old.getFeridosGraves()) && acidente.getFeridosGraves() != null) {
            old.setFeridosGraves(acidente.getFeridosGraves());
        }
        if (!acidente.getIlesos().equals(old.getIlesos()) && acidente.getIlesos() != null) {
            old.setIlesos(acidente.getIlesos());
        }
        if (!acidente.getIgnorados().equals(old.getIgnorados()) && acidente.getIgnorados() != null) {
            old.setIgnorados(acidente.getIgnorados());
        }
        if (!acidente.getFeridos().equals(old.getFeridos()) && acidente.getFeridos() != null) {
            old.setFeridos(acidente.getFeridos());
        }
        if (!acidente.getVeiculos().equals(old.getVeiculos()) && acidente.getVeiculos() != null) {
            old.setVeiculos(acidente.getVeiculos());
        }
        sessao.update(old);
        tr.commit();
    }

    public ArrayList<Acidente> listarTodos() {
        return (ArrayList<Acidente>) sessao.createQuery("from Acidente").list();
    }

    public Acidente buscar(int id) {
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
