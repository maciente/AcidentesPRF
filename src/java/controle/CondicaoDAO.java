package controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    public void salvar(Condicao condicao) {
        sessao.save(condicao);
        Transaction tr = sessao.beginTransaction();
        tr.commit();
    }

    public void alterar(Condicao condicao) {
        Transaction tr = sessao.beginTransaction();
        sessao.update(condicao);
        tr.commit();
    }

    public ArrayList<Condicao> listarTodos() {
        return (ArrayList<Condicao>) sessao.createQuery("from Condicao").list();
    }

    public long causaPorData(Date dataInicial, Date dataFinal, String causa) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.causaAcidente = '" + causa + "' and d.dataAcidente between '" + dataInicial + "' and '" + dataFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long tipoAcidPorData(Date dataInicial, Date dataFinal, String tipoAcid) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.tipoAcidente = '" + tipoAcid + "' and d.dataAcidente between '" + dataInicial + "' and '" + dataFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }

    public long classificacaoPorData(Date dataInicial, Date dataFinal, String classificacao) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.classificacaoAcidente = '" + classificacao + "' and d.dataAcidente between '" + dataInicial + "' and '" + dataFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long fasePorData(Date dataInicial, Date dataFinal, String fase) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.faseDia = '" + fase + "' and d.dataAcidente between '" + dataInicial + "' and '" + dataFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long condPorData(Date dataInicial, Date dataFinal, String cond) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.condMetereologica = '" + cond + "' and d.dataAcidente between '" + dataInicial + "' and '" + dataFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long tipoPistaPorData(Date dataInicial, Date dataFinal, String tipoPista) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.tipoPista = '" + tipoPista + "' and d.dataAcidente between '" + dataInicial + "' and '" + dataFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long tracadoPorData(Date dataInicial, Date dataFinal, String tracado) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.tracadoVia = '" + tracado + "' and d.dataAcidente between '" + dataInicial + "' and '" + dataFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public long usoSoloPorData(Date dataInicial, Date dataFinal, String usoSolo) {
        List result = sessao.createQuery("select count(c.id) from Condicao c, Data d where c.id=d.id and c.usoSolo = '" + usoSolo + "' and d.dataAcidente between '" + dataInicial + "' and '" + dataFinal + "'").list();
        long valor = 0;
        if(!result.isEmpty()){
            valor = (Long)result.get(0);
        }
        return valor;
    }
    
    public Condicao buscarPorId(int id) {
        ArrayList<Condicao> condicoes = (ArrayList<Condicao>) sessao.createQuery("from Condicao where id = " + id).list();
        Condicao condicao = new Condicao();
        for (Condicao c : condicoes) {
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
