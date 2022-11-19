<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Proposta Comercial</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
<br>

 		
   
	
	<div class="container">

      
      	<figure>
                    <img src="https://www.pngkey.com/png/full/952-9523467_cia-de-eventos-buffet-sign.png" style="width: 30%; height: 30%; margin: auto; display: block;" alt="Minha Figura">
                   
                </figure>
      
      
      
      
        <div class= "informacoes-empresa">
        <a>Nome: Cia de eventos Buffets</a><br></br>
        <a>CNPJ: 164897498198/9</a><br></br>
        <a>Local: A Confirmar</a><br></br>
        <a>Data: A Confirmar</a><br></br>
        <a>Tipo de evento: formatura</a><br></br>
       	</div>

<hr>
	<form action=FaturaAndFind method="GET" class="d-flex">
        <input name="consulta" class="form-control me-2" type="search" placeholder="Digite o Nome ou CPF" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
        </form>

<hr>

	<div class="row">
		<div class="cold-md-7">
			<hr>
			<h2>Proposta Comercial</h2>
			<hr>
			<form action="FaturaAndFind" method="POST">
		
		
					<input value="${cliente.id}" name="id" type="number" style="visibility:hidden">
					
				
					<div class="form-floating mb-3">
						<input value="${cliente.nome}" name="nome" maxlength="40" type="text" class="form-control" id="floatingInput1" readonly> 
						<label>Nome completo</label>
						
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.cpf}" name="cpf" maxlength="11" type="text" class="form-control" readonly> 
						<label>CPF (apenas números)</label>
					</div>		
					
				
				
				
				
				<div class="form-check form-switch">
                	<label for="formGroupExampleInput1" class="form-label" >Deseja sobremesa?</label>
                		<select name="sobremesa" class="form-select mb-3" aria-label="Default select example" id="formGroupExampleInput1">
							<option value="${cliente.sobremesa}" selected>${cliente.sobremesa}</option>
					</select>
				</div>
				
				
				<div class="form-floating mb-3">
						
						<input name="qtdConvidados" value="${cliente.qtdConvidados}" maxlength="11" type="number" class="form-control" onkeypress="return event.charCode >= 48 && event.charCode <= 57" readonly> 
						<label>Quantidades de pessoas?</label>
				</div>
				
				
				
				<h3>Detalhes da proposta</h3>
				
				
				
				<div class="form-floating mb-3">
						<input value="${cliente.vrConvidados}" name="vrConvidados" maxlength="11" type="text" class="form-control" readonly> 
						<label>Valor por convidado</label>
					</div>
					
				
				<div class="form-floating mb-3">
						<input value="${cliente.qtdGarcoes}" name="qtdGarcoes" maxlength="11" type="number" class="form-control" readonly> 
						<label>Quantidade de garções</label>
					</div>
				
				<div class="form-floating mb-3">
						<input value="${cliente.txGarcoes}" name="txGarcoes" maxlength="11" type="text" class="form-control" readonly> 
						<label>Taxa de garções</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.txSobremesa}" name="txSobremesa" maxlength="11" type="text" class="form-control" readonly> 
						<label>Taxa de sobremesa</label>
					</div>
					
					<div class="form-floating mb-3">
						<input value="${cliente.vrTotal}" name="vrTotal" maxlength="11" type="text" class="form-control" readonly> 
						<label>Valor Total</label>
					</div>
					
						
					<button class="btn btn-success"  type="submit">Aceitar proposta</button>
					<br></br>
					
					
			</form>
			
					<a href="index.jsp">
					<button class="btn btn-secondary">Rejeitar proposta</button>
					</a>
					<br></br>
		</div>
		
	</div>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>