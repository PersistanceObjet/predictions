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
        <title>Inscription</title>
    </head>
    <body>
        <div class="container">    
            <div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
                <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Inscription</div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <form class="form-horizontal" role="form" action="<c:url value="/create-user" />" method="post" >

                            <div class="form-group">

                                <label for="userLogin" class="col-md-3 control-label">Email<span class="required">*</span></label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="userLogin" value="<c:out value="${user.userLogin}"/>"  placeholder="Email">
                                    <span class="error">${errors['userLoginError']}</span>
                                </div>
                                
                            </div>
                            
                            <div class="form-group">

                                <label for="firstName" class="col-md-3 control-label">Prénom<span class="required">*</span></label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="firstName" value="<c:out value="${user.firstName}"/>"  placeholder="Prénom"> 
                                     <span class="error">${errors['firstNameError']}</span>
                                </div>
                               
                            </div>
                            
                            <div class="form-group">

                                <label for="lastName" class="col-md-3 control-label">Nom<span class="required">*</span></label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="lastName" value="<c:out value="${user.lastName}"/>"  placeholder="Nom"> 
                                    <span class="error">${errors['lastNameError']}</span>
                                </div>
                                
                            </div>

                             <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Mot de passe<span class="required">*</span></label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="password" placeholder="Mot de passe"><br>
                                    <span class="error">${errors['passwordError']}</span>
                                </div>

                            </div>
                                
                            <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Confirmer le MDP<span class="required">*</span></label>
                                <div class="col-md-9">
                                    <input type="password" class="form-control" name="confirmation" placeholder="Mot de passe" >
                                </div>
                            </div>

                            <div style="margin-top:10px" class="form-group">
                                <!-- Button -->

                                <div class="col-sm-12 controls">
                                  <input type="submit" value="Créer" class="btn btn-success pull-right" />
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
