<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 


<script type="text/javascript">
          function login() {
        	  document.loginProcess.action="loginProcess";
			
		}
</script>





 <div class="login_div">
  <div class="login">
    
    <div class="pg_hd">
    <h2> <img src="static/img/logo.png"></h2>
         <h1> Threat Analysis System </h1>
          <p class="error1 msg-sh">${error}</p>
         <p class="mess_succes msg-sh">${loggedout}</p>
    </div>
    
    
    
     
     <form class="login-form" method="post" name="loginProcess" modelAttribute="user" autocomplete="off">
      <div class="uname">
        <input name="userId" type="text" required placeholder="userId"/>
        </div>
         <div class="passd">
        <input name="password" type="password" value="" size="20" placeholder="password" required maxlength="48" />
        </div>
        <div class="submit">
          <input type="submit" value="Login" onclick="login()">
        </div>
        <div class="clearfix"></div>
        
      </form>
    </div>
  </div>


<div class="copy_rg">
 <div class="container-fluid">
	 
	
	<p>&copy; 2022 Indian Coast Guard. All Rights Reserved</p>
	<p style="line-height:20px;">Designed and Developed by Software Development Overseeing Team of Directorate of IT, Indian Coast Guard Headquarters.</p>
	<!-- <p class="site_view">Site best viewed in Mozilla Firefox, Chrome, Safari, 1280X720 Screen Resolution</p> -->
 
</div>
</div>
<script>
  $(document).ready(function(){
 
    setTimeout(function() {					
        $('.msg-sh').fadeOut(4000);
      
       
    },2000);
  });
    </script>
