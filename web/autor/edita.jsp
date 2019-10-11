<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>
<div class="card">
    <div class="card-header">
        <h5 class="title">Edita Autor</h5>
    </div>
    <div class="card-body">
        <!--MODIFICAR PARA ADD-->
        <form action="AutorWS" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="urldestino" value="AutorWS">
            <div class="row">
                <div class="col-md-6 pr-md-1">
                    <div class="col-md-3 pr-md-1">
                    <div class="form-group">
                        <label>Id</label>
                        <input type="text" class="form-control" name="txtId" placeholder="Id" value="${obj.id}" readonly="true">
                    </div> 
                </div>
            </div>
                    <div class="row">
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Nome</label>
                        <input type="text" name="txtNome" required class="form-control" placeholder="Nome" value="${obj.nome}">
                    </div>
                </div>
            </div>
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
                </div>
                <div class="col-md-6 pr-md-1">
                    <div class="form-group">
                          
                        </select> 
                    </div>
                </div>
            </div>

            <button class="btn btn-primary btn-round text-center" type="submit">
                <i class="tim-icons icon-cloud-upload-94"></i> Salvar
            </button>
            <a class="btn btn-primary btn-round text-center" href="AutorWS?acao=list">
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