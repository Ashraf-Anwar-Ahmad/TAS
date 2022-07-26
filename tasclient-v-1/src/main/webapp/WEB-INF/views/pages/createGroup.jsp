<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<meta charset="utf-8">
    <div class="clearfix"></div>
    
  <!-- Jsp Page Start --->
  
  <div class="main_body">
  <div class="gif" id="giffy" style="display :none">
 		<img alt="" src="static/img/preloader.gif">
  </div>	
	 <div class="container-fluid">
	 <div class="conent_wrapper">
		 <div class="top_head_area">
			 <div class="eqdiv">
			 <div class="page_head">
				 <h2>Create Group</h2>
			 </div>
			 <div class="page_breadcrumb">
				<nav aria-label="breadcrumb">
				  <ol class="breadcrumb">
					<li class="breadcrumb-item"><a>Manage Group</a></li>
					<li class="breadcrumb-item active" aria-current="page">Create Group</li>
				  </ol>
				</nav>  
			 </div>
			 </div>
			 <!-- Message Area --->
				 <div class="eqdiv">
					<c:if test="${not empty success}">
						<span class="alert alert-success msg-show"><i class="fa  fa-check-circle"></i> ${success} </span>
					</c:if>
				
					<c:if test="${not empty error}">
						<span class="alert alert-error msg-show"><i class="fa  fa-close"></i> ${error}</span>
					</c:if>
					
					<c:if test="${not empty successUpdate}">
						<span class="alert alert-success msg-show"><i class="fa  fa-check-circle"></i> ${successUpdate}</span>
					</c:if>
				
					<c:if test="${not empty errorUpdate}">
						<span class="alert alert-error msg-show"><i class="fa  fa-close"></i> ${errorUpdate}</span>
					</c:if>
					<span class="alert alert-warning msg-sh" style="display:none;" id="msgg" ><i class="fa fa-info-circle"></i><span id="addMessage"></span></span>
				</div>
				 <!-- Message Area End--->
		  </div>
				  <div class="clear-20"></div>
				  
			<form id="GroupForm" name="GroupForm" modelAttribute="add" method="POST">	 
		 <div class="main_content" id="form_area">
			 <div class="cont_box"> 
			 
							  <div class="row"> 
								 <div class="col-md-3 col-6">
									 <div class="form-group">
										 <label>Select Domain <span style="color: red;">*</span> </label>
										 <!-- <input type="text" class="form-control  mr-sm-2" id="groupName"> -->
										 <select class="form-control select2 testclass" id="groupName" name="groupName" autocomplete="off"  title="Select Domain">
                                                	<option value="">Select</option>
                                    				<option value="23456">Num12</option>
                                    				<option value="23457">Num13</option>
                                    				<option value="23458">Num14</option>
                                    				<option value="23459">Num15</option>
                                    				<option value="23450">Num16</option>
                                    				<option value="23451">Num17</option>
                                    				<option value="23452">Num18</option>
                                  		</select> 
									 </div>
								 </div>
								 
								 <div class="col-md-3 col-6">
									 <div class="form-group">
										 <label>Select </label>
										 <input type="text" class="form-control  mr-sm-2 testclass" id="groupId">
										 <input type="hidden" class="form-control" id="contctList" name="contctList">
									 </div>
								 </div>
								  
								 <div class="col-md-3 col-sm-6">
									<div class="mt-13">
								 <button type="button" id="addButton" onclick="fnClickAddRow()" class="btn btn-primary">Add</button>
								 <button type="button" style="display:none;" id="updateButton" onclick="fnClickAddRow()" class="btn btn-primary">Update</button>
								</div>
								</div>
							  
							 </div>
							 
							 <div class="row">
							 <div class="col-3">
							 <div class="bthd" style="display:none">
							 <button type="button" id = "modalBtn" data-toggle="modal" data-target="#myModal"><i class="fa fa-eye"> </i><span id = "sizeModal"></span></button>
                             </div>
							 </div>
							 </div>
							 
							 <div class="clear-10"></div>
							 
			 </div>  	 <!-- Cont Box End -->	

 
 
		 </div>  <!-- Main Content End -->
						   
	 			
			  <!-- Table Start -->
			 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog unitocr" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        
      </div>
      <div class="modal-body">
       	<!-- Table of unit start -->
														
					<div class="table-responsive-lg table-responsive-md">
						 <div class="table-responsive-lg table-responsive-md">
					 <table id="searchtb" class="table table-striped table-bordered">
						<thead  class="thead-dark">
						  <tr class="info tb-hd" >
							
							<th>groupname</th>
							<th>id</th>
							<th width="80">Action</th>							
						  </tr>
						</thead>
					  </table>
				</div>
					</div>
			    <div class="clear-30"></div>
		
	<!-- Table of unit end -->
      </div>
      
    </div>
  </div>
</div>

		<div class="cont_box"> 
			<div class="row"> 
			   <div class="col-md-12 col-6">
				
				<div class="form-inline">
					
				   
				   	<button type="button" class="btn btn-danger my-1" onclick="Reset()" style="margin-right:10px">Reset</button>
					<button type="button" onclick="submitGroupDetails()" class="btn btn-primary my-1">Submit</button>
				  </div>
				

			   </div>
			   
		   </div>
		   
		   <div class="clear-10"></div>
		   
</div>  	 


</form>




	</div>
	</div>
 
 </div>
<!-- Jsp Page End --->




<script>


var data2=[];


$(document).ready(function() {
	$('#searchtb').DataTable({
		dom: 'Bfrtip',
		"bSort" : false,
		buttons: []
	}); 
});
 
function fnClickAddRow() {
		//$('#giffy').show();
		var boolCheck=false;
		var filteredFamily = data2.filter(function(x) {
  if (x.country==$("#groupId").val()) {
   	alert("check1");
   	boolCheck=true;
  }
});
		if(boolCheck)
  		{
			alert("check2");
  		}
		else{
		$('#addButton').show();
		$('#updateButton').hide();
		var gnme=$('#groupName').val();
		var grId=$('#groupId').val();
		var myFormInputs = document.getElementsByClassName("testclass") ;
		var test_arr=[];
		var bloo=true;
		var myFormData = Array.prototype.filter.call(myFormInputs, function(anElement) {
			alert("myFormInputs=="+anElement.value);
			if(anElement.value==''){
				bloo=false;
			}
			test_arr.push(anElement.value);
		})
		alert("myFormInputs=="+JSON.stringify(test_arr));
		var gnmeName=$('#groupName option:selected').text();
		if(bloo==true){
				 $('#searchtb').dataTable().fnAddData( [
					 	$('#groupName').val(),
					 	$('#groupId').val(),
						'<button type="button" onclick="dataTableUpdateBtn(\''+gnme+'\',\''+gnmeName+'\',\''+grId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-edit"></i></button>  <button type="button" onclick="dataTableDeleteBtn(\''+gnme+'\',\''+grId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
				 var data = {};
				 data["contactNo"] =$("#groupName").val(); 
				 data["country"] = $("#groupId").val();
				 data2.push(data);
				 
				 $('#groupName').val('').trigger('change');
				 $('#groupId').val('');
				 
				 alert("data=="+JSON.stringify(data2));
				 $("#sizeModal").text(data2.length+' records added');
				 $(".bthd").show();
				 
		}
		else{
			alert("please select the field");
		}
		}
}

function dataTableUpdateBtn(value,valuetext,text,obj)
{
	$('#addButton').hide();
		$('#updateButton').show();
				 data2 = $.grep(data2, function(el, idx) {return el.country == text}, true)
				 //alert("data=="+JSON.stringify(data2));
				 $('#groupName').val(value).trigger("change");
		$('#groupId').val(text);


		$('#myModal').modal('toggle'); 
		$('#searchtb').DataTable().row($(obj).parents('tr')).remove().draw(false);
		if(data2.length==0){
			$(".bthd").hide();
		}
}

function dataTableDeleteBtn(value,text,obj)
{
				 data2 = $.grep(data2, function(el, idx) {return el.country == text}, true)
				 //alert("data=="+JSON.stringify(data2));
		$('#searchtb').DataTable().row($(obj).parents('tr')).remove().draw(false);
		$("#sizeModal").text(data2.length+' records added');
		if(data2.length==0){
			$(".bthd").hide();
			$('#myModal').modal('toggle');
		}
} 

function submitGroupDetails(){

	var data = {}
	data["contctList"]=data2;
	
 alert("data--"+JSON.stringify(data));
 $.ajax({
		url : 'saveGroupDetails',
		contentType: "application/json",
		type : 'post',
		data: JSON.stringify(data),
		success : function(response)
        { 
			if(response=='success'){
				window.location.href="successSubmission";
			}
			else{
				alert("error submission");
				
			}
        }
         
     }); 
}
 
 

</script>