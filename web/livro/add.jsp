<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>
<div class="card">
    <div class="card-header">
        <h5 class="title">Adiciona Livro</h5>
    </div>
    <div class="card-body">
        <!--MODIFICAR PARA ADD-->
        <form action="../controle/LivroWS" method="POST" 
            <input type="hidden" name="urldestino" value="LivroWS">
        
            <div class="row">
                <div class="col-md-6 pr-md-1">
                    <div class="form-group">
                        <label>Título</label>
                        <input type="text" name="txtTitulo" required class="form-control" placeholder="Nome" >
                    </div>
                </div>
                <div class="col-md-6 pr-md-1">
                    <div class="form-group">
                        <label>Editora</label>
                        <select class="form-control" name="txtEditora">
                            <c:forEach items="${editora}" var="obj">
                                <option value="${obj.id}">${obj.nome}</option>
                            </c:forEach>
                        </select> 
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 pr-md-1">
                    <div class="form-group">
                        <label>Autor</label>
                        <select class="form-control" name="txtAutor">
                            <c:forEach items="${autor}" var="obj">
                                <option value="${obj.id}">${obj.nome}</option>
                            </c:forEach>
                        </select>                        
                    </div>
                </div>
                <div class="col-md-6 pr-md-1">
                    
            <div class="row">
                <div class="col-md-6 pr-md-1">
                    <div class="form-group">
                        <label>Genero</label>
                        <select class="form-control" name="txtGenero">
                            <c:forEach items="${genero}" var="obj">
                                <option value="${obj.id}">${obj.genero}</option>
                            </c:forEach>
                        </select> 
                    </div>
                </div>
                          


            <button class="btn btn-primary btn-round text-center" type="submit">
                <i class="tim-icons icon-cloud-upload-94"></i> Salvar
            </button>
            <a class="btn btn-primary btn-round text-center" href="../LivroWS?acao=list">
                <i class="tim-icons icon-bullet-list-67"></i> Listar
            </a>
        </form>
    </div>

    <div class="card-footer">
        <c:if test = "${not empty msg}">
            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                ${msg}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <i class="tim-icons icon-simple-remove"></i>
                </button>
            </div>
        </c:if>
    </div>
</div>
</div>
<%@include file="../rodape.jsp" %>