<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

 
 <!-- Jsp Page Start --->
 
 <div class="main_body">
 <div class="gif" id="giffy" style="display :none">
 		<img alt="" src="static/img/preloader.gif">
  </div>
	<div class="container-fluid">
	<div class="conent_wrapper">
		
		 		
				
		<div class="main_content" id="form_area">
			<div class=" ">

		<!--Tab Form Start-->



	<!--progress bar-->
	
	<!--form panels-->
	<div class="row">
	  <div class="col-12 m-auto">
	
		  <!--single form panel-->
		  <div class="multisteps-form__panel shadow p-4 rounded bg-white js-active" data-animation="scaleIn">
			<h3 class="multisteps-form__title">Click on file to see</h3>
			<div class="multisteps-form__content">
				<div class="row">
					<div class="col-md-12">
						<div class="table-responsive-lg table-responsive-md">
				
							<table id="contact_tab" class="table  table-bordered">
							   <thead  class="thead-dark">
								 <tr class="info tb-hd" >
								   <th>S.No.</th>
								   <th>File</th>
								   
								 </tr>
							   </thead>
							   <tbody>
							   <c:set var="counter" value = "1"  scope ="page"></c:set>
							   <c:forEach var="name" items="${fileNames}">
							   <tr><td>${counter}</td><td><a href="viewdoc?fileName=${name}&inputId=${inputId}&threatFolder=${threatFolder}" target="_blank">${name}</a></td></tr>
							    <c:set var="counter" value = "${counter+1}" ></c:set> 
                                   </c:forEach> 
	                          
							   </tbody>
							   
							 </table>
		  				 </div>
				</div>
		    </div>
		 </div>  <!-- Cont Box End -->				 	
   </div>  <!-- Main Content End --> 
  </div><!--conent_wrapper End-->
  </div><!--container-fluid End-->
</div>
</div>

</div>
</div>
</div>

<!-- Jsp Page End --->



<!--All Modal Section Start-->
 


  
  

 	
<script type="text/javascript">

$(function () { 
			

	$('#contact_tab').DataTable({
		 "bPaginate": false,
		  "bLengthChange": false,
		  "ordering" : false,
		   "orderCellsTop" : true,
	} );
	
	


} );

</script>	

