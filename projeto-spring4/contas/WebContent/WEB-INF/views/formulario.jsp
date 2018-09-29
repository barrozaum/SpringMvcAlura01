<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Adcionar contas</title>
</head>
<body>

	<h3>Adicionar contas</h3>
	<form action="adicionaConta" method="post">
		
		Descricao<br />
		<textarea rows="5" cols="100" name="descricao"></textarea>
		<form:errors path="conta.descricao"></form:errors>
		<br />
		
		Valor <br />
		<input type="text" name="valor" />
		<br />
		
		Tipo :
		<select name="tipo">
			<option value="ENTRADA">Entrada</option>
			<option value="SAIDA">Saida</option>
		</select>
		
		<br /><br />
		
		<input type="submit" value="Adicionar" /> 
	</form>
	

</body>
</html>