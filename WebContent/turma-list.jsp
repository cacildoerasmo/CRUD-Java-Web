<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CADASTRO DE TURMA</title>

<style type="text/css">

hr{

border-bottom:1px #606060 solid;

}
h1{
color: green;

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
body{
background-color: lightskyblue;
}
</style>
 <script>
    	  function confirmar(){
    		  var res = confirm("Deseja eliminar realmente a turma?");
    		  if(res == true){
    			  return true;
    		  }else{
    			  return false;
    		  }
    		  
    	  }
    	  </script>
</head>
<body>

 	<center>
		
	
        <h3>
        	<a href="new1">Nova Turma</a>
        	&nbsp;&nbsp;&nbsp;
        	<!-- <a href="list">Todos Estudantes</a> -->
        	
        </h3>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Turmas</h2></caption>
            <tr>
                <th>Identificacao</th>
                <th>Descricao</th>

            </tr>
            <c:forEach var="turma" items="${listTurma}">
                <tr>
                
                    <td><c:out value="${turma.identificacao}" /></td>
                    <td><c:out value="${turma.descricao}" /></td>

                    <td>
                    	<a href="edit1?identificacao=<c:out value='${turma.identificacao}' />">Editar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete1?identificacao=<c:out value='${turma.identificacao}' />"onclick="{return confirmar();}">Apagar</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
    <!-- <img alt="Imgagem" src="caermat2.jpg" id="imagem1">
    <img alt="ImgagemISCIM" src="iscim.jpg" id="imagem2">  -->
   

</body>
</html>