/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.RetiradaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Id;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Retirada;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "RetiradaWS", urlPatterns = {"/controle/RetiradaWS"})
public class RetiradaWS extends HttpServlet {

   @Id
 private RetiradaDAO dao;
    private Retirada obj;
    private String pagina;
    private String acao;
    
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
       acao = request.getParameter("acao");
        List<Retirada> lista = null;
        String id;
        switch(String.valueOf(acao)){
            case "del":
                id = request.getParameter("id");
                dao = new RetiradaDAO();
                pagina = "index.jsp";
                obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                Boolean deucerto = dao.excluir(obj);
                if(deucerto){   
                    lista = dao.listar();
                    request.setAttribute("lista", lista);
                    request.setAttribute("msg", "Excluído com sucesso");
                }
    
   else{
                    request.setAttribute("msg", "Erro ao excluir");
                }
        break;
            case "edit":
                id = request.getParameter("id");
                dao = new RetiradaDAO();
                Retirada obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("obj", obj);
                pagina = "edita.jsp";
                break;
            default:
                dao = new RetiradaDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(RetiradaWS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    } else {
                    lista = dao.listar();
                }
                //pra onde deve ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a página
                request.setAttribute("lista", lista);
                break;
                
        }
    }
}