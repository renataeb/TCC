/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AutorDAO;
import dao.EditoraDAO;
import dao.GeneroDAO;
import dao.LivroDAO;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Autor;
import modelo.Editora;
import modelo.Genero;
import modelo.Livro;


/**
 *
 * @author dappo
 */
@WebServlet(name = "LivroWS", urlPatterns = {"/controle/LivroWS"})
public class LivroWS extends HttpServlet {
    private LivroDAO dao;
    private Livro obj;
    private String pagina;
    private String acao;
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        acao = request.getParameter("acao");
        List<Livro> lista = null;
        String id;
        switch(String.valueOf(acao)){
            case "add":
                GeneroDAO gdao = new GeneroDAO();
                AutorDAO adao = new AutorDAO();
                EditoraDAO edao = new EditoraDAO();
                List<Genero> genero = gdao.listar();
                List<Autor> autor = adao.listar();
                List<Editora> editora = edao.listar();
                request.setAttribute("genero", genero);
             
                request.setAttribute("autor", autor);
                request.setAttribute("editora", editora);
                pagina = "add.jsp";
                break;
            case "del":
                id = request.getParameter("id");
                dao = new LivroDAO();
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
                dao = new LivroDAO();
                Livro obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("obj", obj);
                pagina = "edita.jsp";
                break;
            default:
                dao = new LivroDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(LivroWS.class.getName()).log(Level.SEVERE, null, ex);
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
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            GeneroDAO gdao = new GeneroDAO();
            AutorDAO adao = new AutorDAO();
            EditoraDAO edao = new EditoraDAO();
            Genero genero;
            Autor autor;
            Editora editora;
            String msg;
            request.setCharacterEncoding("UTF-8");
            String titulo = request.getParameter("txtTitulo");
            Long id_autor = Long.parseLong(request.getParameter("txtAutor"));
            Long id_genero = Long.parseLong(request.getParameter("txtGenero"));
            Long id_editora = Long.parseLong(request.getParameter("txtEditora"));
            String endFoto1 =request.getParameter("txtFoto1");
            String endFoto2 =request.getParameter("txtFoto1");
            int paginas = Integer.parseInt(request.getParameter("txtPaginas"));
            double valor = Double.parseDouble(request.getParameter("txtValor"));
            //verificar campos obrigatórios
            if(request.getParameter("txtTitulo") == null){
                msg = "Campos obrigatórios não informados";
            }
            else{
                dao = new LivroDAO();
                obj = new Livro();
                genero = gdao.buscarPorChavePrimaria(id_genero);
                autor = adao.buscarPorChavePrimaria(id_autor);
                editora = edao.buscarPorChavePrimaria(id_editora);
                
                //preencho o objeto com o que vem do post
                
                Boolean deucerto;
                
                //se veio com a chave primaria então tem q alterar
                if(request.getParameter("txtId")!= null){
                    obj = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
                    obj.setTitulo(titulo);
                    obj.setAutor(autor);
                    obj.setGenero(genero);
                    obj.setEditora(editora);
                    obj.setEndFoto1(endFoto1);
                    obj.setEndFoto2(endFoto2);
                    deucerto = dao.alterar(obj);
                    pagina="edita.jsp";
                }
                else{
                    obj.setTitulo(titulo);
                    obj.setAutor(autor);
                    obj.setGenero(genero);
                    obj.setEditora(editora);
                    obj.setEndFoto1(endFoto1);
                    obj.setEndFoto2(endFoto2);
                    deucerto = dao.incluir(obj);
                    pagina="../livro/add.jsp";   
                }
                if(deucerto){
                    msg = "Operação realizada com sucesso";    
                }
                else{
                    msg = "Erro ao realizar a operação";
                }
            }
            dao.fecharConexao();
            request.setAttribute("msg", msg);
            RequestDispatcher destino = request.getRequestDispatcher(pagina);
            destino.forward(request, response);
    }


}
