<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CADASTRO DE ESTUDANTE</title>

<style type="text/css">

hr{

border-bottom:1px #606060 solid;

}
h1{
color: green;

}
body{
background-color: lightskyblue;
}
/*
img#imagem1{
position: relative;
top: -560px;
width: 100px;

}
img#imagem2{
position: relative;
top: -555px;
width: 90px;
}*/
table{
border-collapse: collapse;
background-color: #fff;
width: 650px;
position: relative;
left: 30px;
height: 370px;
    padding: 30px;
   
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
}
h2{
position: absolute;
top: -60px;
}
</style>

</head>
<body>

    <script>
    	  function confirmar(){
    		  var res = confirm("Deseja eliminar realmente o estudante?");
    		  if(res == true){
    			  return true;
    		  }else{
    			  return false;
    		  }
    		  
    	  }
    	  </script>

 	<center>
		<!-- <h1>CADASTRO ESTUDANTE</h1> -->

        <h3>
        	<a href="new">Novo Estudante</a>
        	
        	<!-- <a href="list">Todos Estudantes</a> -->
        	
        </h3>
	</center>
    <div id="ola"align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Estudantes</h2></caption>
            <tr>
                <th>NMatricula</th>
                <th>IDTurma</th>
                <th>Nome</th>
                <th>Apelido</th>
                <th>Telefone</th>
                <th>Endereco</th>
            </tr>
            <c:forEach var="estudante" items="${listEstudante}">
                <tr>
                
                    <td><c:out value="${estudante.numero_matricula}" /></td>
                    <td><c:out value="${estudante.fk_identificacao_turma}" /></td>
                    <td><c:out value="${estudante.nome}" /></td>
                    <td><c:out value="${estudante.apelido}" /></td>
                    <td><c:out value="${estudante.telefone}" /></td>
                    <td><c:out value="${estudante.endereco}" /></td>
                    <td>
                    	<a href="edit?numero_matricula=<c:out value='${estudante.numero_matricula}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?numero_matricula=<c:out value='${estudante.numero_matricula}' />" onclick="{return confirmar();}">Apagar</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    <!-- <img alt="Imgagem" src="caermat2.jpg" id="imagem1">
    <img alt="ImgagemISCIM" src="iscim.jpg" id="imagem2">  -->
   

</body>
</html>