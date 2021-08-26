<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CADASTRO ESTUDANTE</title>

<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

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
   top: 346px;
   left: 10px;
   
}
input{
  background-color:1px #606060 solid;
   font-size:12pt;
   color: black;
   
}
input#idturma{
height: 30px;

}
input#nome{
height: 30px;

}
input#apelido{
height: 30px;

}
input#telefone{
height: 30px;

}
input#endereco{
height: 30px;

}
hr{
    border-color: lightskyblue;
}
h3{
color: lightseagreen;
text-align: center;

}
.bg{
  background-color: lightskyblue;
  width: 200%;
  height: 600vh;
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
height: 370px;
    padding: 30px;
   
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
}
</style>

</head>
<body>
   

   
   <!--<center>
		<h1>CADASTRO ESTUDANTE</h1>
		<hr>
		
        <h2>
        	<a href="new">Adicionar Estudante</a>
        	&nbsp;&nbsp;&nbsp; 
        	
        </h2>
        
	</center>-->
	   
    <div id="ola" align="center">
    <a href="list"><input type="submit" id="listar" value="Listar" name="listar"></a>
        	
		<c:if test="${estudante != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${estudante == null}">
			<form action="insert" method="post">
        </c:if>
        <table cellpadding="5"> 
            <caption>
            	<h2>
            		<c:if test="${estudante != null}">
            			<h3>EDITAR ESTUDANTE</h3>
            			<hr>
            		</c:if>
            		<c:if test="${estudante == null}">
            			<h3>ADICIONAR ESTUDANTE</h3>
            			<hr>
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${estudante != null}">
        			<input type="hidden" name="numero_matricula" value="<c:out value='${estudante.numero_matricula}' />" />
        		</c:if>            
            <tr>
                <th>IDTurma: </th>
                <td>
                	<input type="text" id="idturma"name="fk_identificacao_turma" size="60" required
                			value="<c:out value='${estudante.fk_identificacao_turma}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Nome: </th>
                <td>
                	<input type="text" id="nome"name="nome" size="60" required
                			value="<c:out value='${estudante.nome}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Apelido: </th>
                <td>
                	<input type="text" id="apelido"name="apelido" size="60" required
                			value="<c:out value='${estudante.apelido}' />"
                	/>
                </td>
            </tr>
              <tr>
                <th>Telefone: </th>
                <td>
                	<input type="text" id="telefone"name="telefone" size="60" required
                			value="<c:out value='${estudante.telefone}' />"
                	/>
                </td>
            </tr>
              <tr>
                <th>Endereco: </th>
                <td>
                	<input type="text" id="endereco"name="endereco" size="60" required
                			value="<c:out value='${estudante.endereco}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Salvar" id="salvar"/>
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