<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CADASTRO TURMA</title>

<style type="text/css">
h1{
color: green;

}
body{
background-color: lightskyblue;
}
hr{

border-bottom:1px #606060 solid;

}
input#salvar{
   
   width: 100px;
   height: 40px;
   background-color:#dddddd;
   font-size:12pt;
   color: black;
   position: relative;
   left: -50px;
   
}
input#limpar{
   
   width: 100px;
   height: 40px;
   background-color:#dddddd;
   font-size:12pt;
   color: black;
   position: relative;
   left: 70px;

}
input#listar{
   
   width: 100px;
   height: 40px;
   background-color:#dddddd;
   font-size:12pt;
   color: black;
   position: relative;
   top: 162px;
   left: 10px;
   
}
input{
  background-color:1px #606060 solid;
   font-size:12pt;
   color: black;
   
}

input#descricao{
height: 30px;

}

/*
img#imagem1{
position: relative;
top: -530px;
width: 100px;

}
img#imagem2{
position: relative;
top: -524px;
width: 90px;

}*/
table{
border-collapse: collapse;
}
#ola{
background-color: #fff;
width: 650px;
position: relative;
left: 150px;
top: 70px;
height: 200px;
    padding: 30px;
   
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
}
hr{
    border-color: lightskyblue;
}
h3{
color: lightseagreen;
text-align: center;

}
</style>


</head>
<body>
   
 
   
   <!--<center>
		<h1>CADASTRO TURMA</h1>
		<hr>
        <h2>
        	<a href="new">Adicionar Estudante</a>
        	 &nbsp;&nbsp;&nbsp; 
       
        </h2>
        
	</center>-->
	   
    <div id="ola"align="center">
     	<a href="list1"><input type="submit" id="listar" value="Listar" name="listar"></a>
        	
		<c:if test="${turma != null}">
			<form action="update1" method="post">
        </c:if>
        <c:if test="${turma == null}">
			<form action="insert1" method="post">
        </c:if>
        <table cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${turma != null}">
            			<h3>EDITAR TURMA</h3>
            			<hr>
            		</c:if>
            		<c:if test="${turma == null}">
            			<h3>ADICIONAR TURMA</h3>
            			<hr>
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${turma != null}">
        			<input type="hidden" name="identificacao" value="<c:out value='${turma.identificacao}' />" />
        		</c:if>            
 
            <tr>
                <th>Descricao: </th>
                <td>
                	<input type="text" id="descricao"name="descricao" size="45" required
                			value="<c:out value='${turma.descricao}' />"
                	/>
                </td>
            </tr>
                 <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Salvar" id="salvar" />
            	    <input type="reset" id="limpar" value="Limpar" name="limpar">
            	
            	</td>
            </tr>
  
            
        </table>
        </form>
        
    </div>	
    <!-- <img alt="Imgagem" src="caermat2.jpg" id="imagem1">
<img alt="ImgagemISCIM" src="iscim.jpg" id="imagem2"> -->

</body>
</html>