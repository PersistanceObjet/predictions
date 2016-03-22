<%@page import="fr.dauphine.lamsade.hib.predictions.objects.Confirmation"%>
<%@page import="fr.dauphine.lamsade.hib.predictions.dao.ConfirmationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>  
<head>  
    <title>addConfirmation</title>  
</head>  
<body>  
    <%  
        ConfirmationDAO conDao = new ConfirmationDAO();
        Confirmation con = new Confirmation();  
        con.setConfirmation_id(0);  
        con.setConfirmation_flag(true);  
        conDao.inser(con);  
    %>  
</body>  
</html>  