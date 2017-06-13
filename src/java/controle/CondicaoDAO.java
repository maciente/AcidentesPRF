package controle;

import java.util.ArrayList;
import mapeamento.Condicao;
import mapeamento.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CondicaoDAO {

    private Session sessao;

    public CondicaoDAO() {
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

    public void salvar(Condicao condicao){
        sessao.save(condicao);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }
    
    public void alterar(Condicao condicao) {
        Transaction tr = sessao.beginTransaction();
        Condicao old = (Condicao) sessao.load(Condicao.class, condicao.getId());
        if (!condicao.getCausaAcidente().equals(old.getCausaAcidente()) && condicao.getCausaAcidente()!= null) {
            old.setCausaAcidente(condicao.getCausaAcidente());
        }
        if (!condicao.getTipoAcidente().equals(old.getTipoAcidente()) && condicao.getTipoAcidente() != null) {
            old.setTipoAcidente(condicao.getTipoAcidente());
        }
        if (!condicao.getClassificacaoAcidente().equals(old.getClassificacaoAcidente()) && condicao.getClassificacaoAcidente() != null) {
            old.setClassificacaoAcidente(condicao.getClassificacaoAcidente());
        }
        if (!condicao.getFaseDia().equals(old.getFaseDia()) && condicao.getFaseDia() != null) {
            old.setFaseDia(condicao.getFaseDia());
        }
        if (!condicao.getSentidoVia().equals(old.getSentidoVia()) && condicao.getSentidoVia() != null) {
            old.setSentidoVia(condicao.getSentidoVia());
        }
        if (!condicao.getCondMetereologica().equals(old.getCondMetereologica()) && condicao.getCondMetereologica() != null) {
            old.setCondMetereologica(condicao.getCondMetereologica());
        }
        if (!condicao.getTipoPista().equals(old.getTipoPista()) && condicao.getTipoPista() != null) {
            old.setTipoPista(condicao.getTipoPista());
        }
        if (!condicao.getTracadoVia().equals(old.getTracadoVia()) && condicao.getTracadoVia() != null) {
            old.setTracadoVia(condicao.getTracadoVia());
        }
        if (!condicao.getUsoSolo().equals(old.getUsoSolo()) && condicao.getUsoSolo() != null) {
            old.setUsoSolo(condicao.getUsoSolo());
        }
        sessao.update(old);
        tr.commit();
    }

    public ArrayList<Condicao> listarTodos() {
        return (ArrayList<Condicao>) sessao.createQuery("from Condicao").list();
    }

    public Condicao buscar(int id) {
        ArrayList<Condicao> condicoes = (ArrayList<Condicao>) sessao.createQuery("from Condicao where id = " + id).list();
        Condicao condicao = new Condicao();
        for(Condicao c : condicoes){
            condicao = c;
        }
        return condicao;
    }

    public void excluir(int id) {
        Condicao condicao = new Condicao();
        sessao.load(condicao, id);
        sessao.delete(condicao);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }
}
