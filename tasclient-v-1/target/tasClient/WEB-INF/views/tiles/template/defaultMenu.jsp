<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


  <!-- Sidebar Start -->
 <aside class="sidemenu">
 <div class="logo_area">
	<a href="#">
		<img src="static/img/icg-logo.png" alt="logo" />
		
	</a>
 
  </div>
 
 
 <div class="sidebar-sticky">
 <div class="page-wrapper am-nav">
         <nav id="sidebar" class="sidebar-wrapper">
    <div class="sidebar-content">
     
      
      <!-- sidebar-Menu  -->
      <div class="sidebar-menu">
        <ul>
         <!--  <li>
            <a href="#">
              <i class="fa fa-home"></i>
              <span>Home</span>
            </a>
          </li> -->
         
		     
		 <li class="sidebar-dropdown hvr-sweep-to-right">
            <a>
              <i class="fa fa-edit"></i>
              <span>Manage Threat</span>
            </a>
            <div class="sidebar-submenu">
              <ul>
                <li class="hvr-sweep-to-right">
                  <a href="${pageContext.request.contextPath}/addThreat">Add</a>
                </li>
                <li class="hvr-sweep-to-right">
                  <a href="${pageContext.request.contextPath}/view">View & Update</a>
                </li>         
              </ul>
            </div>
          </li>
		   
		  <li class="hvr-sweep-to-right">
			  <!-- <a href="${pageContext.request.contextPath}/search"> -->
          <a href="${pageContext.request.contextPath}/search">
				<i class="fa  fa-search"></i>
				<span>Search Threat</span>
			  </a>
			  
		  </li>
		  <li class="hvr-sweep-to-right">
            <a href="${pageContext.request.contextPath}/threatHistory">
               <i class="fa fa-server"></i>
               <span>Threat History</span>
            </a>
          </li>
		  
		   <li class="sidebar-dropdown hvr-sweep-to-right">
            <a>
              <i class="fa fa-gear"></i>
              <span>Setting</span>
            </a>
            <div class="sidebar-submenu">
              <ul>
                <li class="hvr-sweep-to-right"><a href="${pageContext.request.contextPath}/version" >Version History</a></li>   
              </ul>
            </div>
          </li>
		 
     
        </ul>
      </div>
      <!-- sidebar-menu  -->
    </div>
    </nav>
</div>
      </div>
	  
  <div class="foot_ver" data-position="fixed">
   <p>Version: 1.0.0</p>
   <p>Build: 200615</p>
  </div>
	  
	  
	  
  </aside> <!-- Side Menu Page -->
        
        <script>
        
        	$(document).ready(function ($) {
    var url = window.location.href;
    var activePage = url;
    $('.sidebar-menu a').each(function () {
        var linkPage = this.href;

        if (activePage == linkPage) {
            $(this).closest("li").addClass("active");
        }
    });
});
        
        </script>