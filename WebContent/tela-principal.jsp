<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TELA PRINCIPAL</title>

<style>
h1{
color: green;

}
hr{

border-bottom:1px #606060 solid;

}
input#estudante{
   
   width: 250px;
   height: 40px;
   background-color:#dddddd;
   font-size:12pt;
   color: black;
   position: relative;
   top: 50px;
   left: 10px;
   
}
input#turma{
   
   width: 250px;
   height: 40px;
   background-color:#dddddd;
   font-size:12pt;
   color: black;
   position: relative;
   top: 50px;
   left: 10px;
   
}
body{
background-color: gree;
}
#imagem1{
position: relative;
top: -200px;
width: 100px;
}
#imagem2{
position: relative;
top: -198px;
width: 90px;
}
footer#rodape{
  position: relative;
	top: 110px;
	clear: both;
	border-top: 1px solid #606060;
	}
	footer#rodape p{
		text-align: center;
	}
	#imagem3{
	width: 40px;
	}
	#imagem4{
	width: 40px;
	}
</style>
</head>

<body>

    <center>
		<h1>MENU PRINCIPAL</h1>
		<hr>
		<a href="estudante-form.jsp"><input type="submit" value="CADASTRO ESTUDANTE" id="estudante" name="estudante"/></br></br></a>
        <a href="turma-form.jsp"><input type="submit" value="CADASTRO TURMA" id="turma"  name="turma"/></a>
       
	</center>
<img alt="Imgagem" src="caermat2.jpg" id="imagem1">
<img alt="ImgagemISCIM" src="iscim.jpg" id="imagem2">

<footer id="rodape">
<p> &copy; 2021 - by Cacildo Mabunda</br>
<a href="https://facebook.com/cacildomabunda.mabunda" target="_blank"><img src="facebook2.png" id="imagem3"></a> | <a href="https://github.com/cacildoerasmo" target="_blank"><img src="transferir.png" id="imagem4"></a></p>

</footer>





</body>
</html>