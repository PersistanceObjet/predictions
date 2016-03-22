<%@page import="fr.dauphine.lamsade.hib.predictions.objects.Confirmation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="fr.dauphine.lamsade.hib.predictions.dao.ConfirmationDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  
    <%  
        
        ConfirmationDAO conDao =new ConfirmationDAO();  
        Confirmation con = new Confirmation();  
        con.setConfirmation_id(0);  
        con.isConfirmation_flag();
        conDao.update(con);  
    %>  
</body>  
</html>