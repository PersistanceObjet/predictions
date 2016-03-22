<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Créer une indication</title>
</head>
<body>
	<form method="post" action="#">
	<fieldset>
        <label for="temp">Temp</label>
        <input type="text" name="temp" value="${indication.temp}" />
        <span>${erreurs['date']}</span>
        <br />
       
        
        
        <p class="${empty erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
    </fieldset>
</form>
</body>
</html>