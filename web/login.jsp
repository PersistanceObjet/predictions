<%-- 
    Document   : index
    Created on : 7 avr. 2016, 23:17:14
    Author     : Shitai
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">    
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>
        <div class="container">    
            <div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Se connecter</div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <form class="form-horizontal" role="form" action="<c:url value="/login" />" method="post" >

                            <div style="margin-bottom: 25px" class="input-group" >
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i><span class="required">*</span></span>
                                <input type="text" class="form-control" name="userLogin" value="<c:out value="${user.userLogin}"/>" placeholder="Identifiant"> 
                                <span class="error">${errors['userLoginError']}</span>
                            </div>

                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i><span class="required">*</span></span>
                                <input type="password" class="form-control" name="password" placeholder="Mot de passe">
                                <span class="error">${errors['passwordError']}</span>
                            </div>

                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls">
                                  <input type="submit" value="Se connecter" class="btn btn-success" />
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-md-12 control">
                                    <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                        Vous n'avez pas encore de compte ?
                                    <a href="<c:url value="/create-user" />">
                                        Inscrivez-vous ici
                                    </a>
                                    </div>
                                </div>
                            </div>    
                        </form>     
                   </div>                     
                </div>  
            </div>
            <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        </div>
    </body>
</html>
