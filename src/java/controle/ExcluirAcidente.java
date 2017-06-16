package controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ExcluirAcidente extends HttpServlet {

    private AcidenteDAO aDao;
    private LocalDAO lDao;
    private CondicaoDAO cDao;
    private DataDAO dDao;
    private int id;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        try {
            id = Integer.parseInt(request.getParameter("id"));
            lDao = new LocalDAO();
            lDao.excluir(id);
            cDao = new CondicaoDAO();
            cDao.excluir(id);
            dDao = new DataDAO();
            dDao.excluir(id);
            aDao = new AcidenteDAO();
            aDao.excluir(id);
            session.setAttribute("flag", true);
            RequestDispatcher r = request.getRequestDispatcher("/excluirAcidente.jsp");
            r.forward(request, response);
        } catch (Exception ex) {
            session.setAttribute("flag", false);
            RequestDispatcher r = request.getRequestDispatcher("/excluirAcidente.jsp");
            r.forward(request, response);
        }
    }

}
