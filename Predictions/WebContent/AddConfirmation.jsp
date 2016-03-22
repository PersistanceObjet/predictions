<%@page
	import="fr.dauphine.lamsade.hib.predictions.objects.Confirmation"%>
<%@page import="fr.dauphine.lamsade.hib.predictions.dao.ConfirmationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<jsp:directive.page
	import="fr.dauphine.lamsade.hib.predictions.dao.ConfirmationDAO" />
<jsp:directive.page
	import="fr.dauphine.lamsade.hib.predictions.objects.Confirmation" />
<jsp:directive.page import="java.util.List" />
<html>
<head>
<title>addConfirmation</title>
</head>
<body>
	<form action="/TrainDatabase/servlet/InsertTrainAction" method="post">
		<table border="1" bordercolor="#12A0F5" align=center>
			<tr>
				<td>confirmation_ID:</td>
				<td><input type="text" id="confirmation_id"
					name="confirmation_id" style='font-size: 18px' width=200 /></td>
				<td><input type="checkbox" id="confirmation_flag"
					name="confirmation_flag" style='font-size: 18px' width=200></td>
			</tr>

			<tr>
				<td colspan=5 align=center><input type="submit" name="Submit"
					value="submit" style='font-size: 18px' width=200 /></td>
			</tr>
		</table>
	</form>
</body>
</html>
