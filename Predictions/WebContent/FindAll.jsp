<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%  
        UserDAO userDAO = DAOFactory.getUserDAOInstance();  
        List<User> all = userDAO.queryAll();  
        Iterator<User> iter = all.iterator();  
        while(iter.hasNext()) {  
            User user = iter.next();  
            out.println(":" + user.getUsername());  
            out.println(":" + user.getPassword() + "<br>");  
        }  
    %> 
</body>
</html>