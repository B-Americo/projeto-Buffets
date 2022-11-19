<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    
    <meta charset="utf-8">
    <title>Projeto Buffets</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-dark bg-warning">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Cia de eventos Buffets</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Início</a>
                </li>         
                <li class="nav-item">
                    <a class="nav-link" href="fatura.jsp">Fatura</a>
                </li>
               
            </ul>
        </div>
    </div>
</nav>

<br></br>

<!-- Modal -->
<div class="container">
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            	
                <h1 class="modal-title fs-5" id="staticBackdropLabel">Cadastro de Clientes</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <!--Formulário-->
            <div class="container-sm">
            <form action="CreateAndFind" method="POST">
    
				<div class="row g-3">
				  <div class="col">
				  	<label for="formGroupExampleInput1" class="form-label">Digite seu nome</label>
				    <input name="nome" type="text" class="form-control" id="formGroupExampleInput1" placeholder="....." aria-label="First name">
				  </div>
				  <div class="col">
				  	<label for="formGroupExampleInput2" class="form-label">CPF</label>
				    <input name="cpf" type="text" class="form-control" id="formGroupExampleInput2" placeholder="....." aria-label="Last name">
				  </div>
				</div>
                
                <div class="form-check form-switch">
                <label for="formGroupExampleInput1" class="form-label">Deseja sobremesa?</label>
                <select name="sobremesa" class="form-select mb-3" aria-label="Default select example" id="formGroupExampleInput1">
						<option value="Sim">Sim</option>
						<option value="Não" selected>Não</option>
					</select>			
				</div>	
               	
					<div for="formGroupExampleInput1" class="form-label">
						<label>Quantidades de pessoas?</label>
						<input name="qtdConvidados" maxlength="11" type="text" class="form-control" onkeypress="return event.charCode >= 48 && event.charCode <= 57"> 
						
					</div>
                
                <div class="form-check form-switch" style="visibility:hidden">
                <label for="formGroupExampleInput1" class="form-label">Deseja sobremesa?</label>
                <select name="status" class="form-select mb-3" aria-label="Default select example" id="formGroupExampleInput1">
						<option value="Pendenteee">Pendente</option>
					</select>			
				</div>	
                
                
                
                
                <button type="submit" class="btn btn-primary">Salvar</button>
                <button type="reset" class="btn btn-secondary">Reset</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                
            </form>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
</div>
<!-- Fim do modal -->

    <div class="container-fluid">
        <form action="CreateAndFind" method="GET" class="d-flex" role="search">
            <input name="pesquisa" class="form-control me-2" type="search" placeholder="Buscar" style="margin: 10px" aria-label="Search">
            <button  class="btn btn-outline-success" style="margin: 10px" type="submit">Buscar Cliente...</button>
            <br></br>
           
            <button class="btn btn-outline-success" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop" style="margin: 10px">Cadastrar novo cliente...</button>
        </form>
    </div>

<br></br>

<h2>Lista de Clientes</h2>
<br></br>
<table class="table" >
    <thead>
    <tr>
        
     
        <th scope="col">Id</th>
        <th scope="col">Nome</th>
        <th scope="col">CPF</th>
        <th scope="col">Qtd Convidados</th>
        <th scope="col">Sobremesa</th>
    </tr>
    </thead>
    <tbody>
		<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td>${cliente.id}</td>
								<td>${cliente.nome}</td>
								<td>${cliente.cpf}</td>
								<td>${cliente.qtdConvidados}</td>
								<td>${cliente.sobremesa}</td>
								
								<td>
									<c:choose>
    								<c:when test="${cliente.status=='Pendente'}">
        							<a href="clienteAtualizar?clienteId=${cliente.id}">
        							<i class="bi bi-person-lines-fill"></i>			
        							</a>
        							
        							 |
									<a href="clienteDeletar?clienteId=${cliente.id}">
									<i class="bi bi-trash3"></i>	
									</a>
										
        							<br />
    								</c:when>    
    								<c:otherwise>
    							
    									<a href="faturaVisualizar?clienteId=${cliente.id}">
    									<i class="bi bi-eye-fill" >    									</i>
    									</a>
  							
        							<br />
    								</c:otherwise>
									</c:choose>
									
									
								</td>
							</tr>
		</c:forEach>
    </tbody>
   
</table>
</div>







</body>
</html>