<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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
				  
			<form id="GroupForm" name="GroupForm" modelAttribute="addGroup" method="POST">	 
		 <div class="main_content" id="form_area">
			 <div class="cont_box"> 
			 
							  <div class="row"> 
								 <div class="col-md-3 col-6">
									 <div class="form-group">
										 <label>Select Domain <span style="color: red;">*</span> </label>
										 <input type="text" class="form-control  mr-sm-2" id="groupName" name="groupName">
									 </div>
								 </div>
								 
								 <div class="col-md-3 col-6">
									 <div class="form-group">
										 <label>Select </label>
										 <input type="text" class="form-control  mr-sm-2" id="groupId" name="groupId">
									 </div>
								 </div>
								  
								 <div class="col-md-3 col-sm-6">
									<div class="mt-13">
								 <button type="button" onclick="fnClickAddRow()" class="btn btn-primary">Add</button>
								</div>
								</div>
							  
							 </div>
							 
							 <div class="clear-10"></div>
							 
			 </div>  	 <!-- Cont Box End -->	

 
 
		 </div>  <!-- Main Content End -->
						   
	 			
			  <!-- Table Start -->
			 <div class="cont_box" id="tbShow" style="display:none;">
				<div class="table-responsive-lg table-responsive-md">
					 <table id="searchtb" class="table table-striped table-bordered">
						<thead  class="thead-dark">
						  <tr class="info tb-hd" >
							
							<th>groupname</th>
							<th>id</th>
							<th width="80">Delete</th>							
						  </tr>
						</thead>
					  </table>
				</div>
				
			  <!-- Table Start End -->
		  
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
		   
</div>  	 <!-- Cont Box End -->	


</form>




	</div>
	</div>
 
 </div>
<!-- Jsp Page End --->




<script>
var data = {}

var data2=[];


$(document).ready(function() {
	
	var table = $('#searchtb').DataTable({

        processing: true,
        language: {
            emptyTable: 'no result found.'
        },
        columnDefs: [

            {//date
                visible: true,
                targets: 0,
                className: 'text-center',
                render: function (data, type, full, meta) {
                    return  data;
                }
            },
            {//name
                visible: true,
                targets: 1,
                className: 'text-center',
                render: function (data, type, full, meta) {
                    return  data;
                }
            },
            {//action
                visible: true,
                targets: 2,
                className: "text-center",
                render: function (data, type, full, meta) {
                      
                  return '<button id="editBtn" class="btn btn-wrang btn-flat edit" name="editBtn" type="button">Edit</button>' +
                        '&nbsp;&nbsp;<button id="deleteBtn" class="btn btn-danger btn-flat delete" name="deleteBtn" type="button" >Delete</button>';
                    
                }
            }
        ]
	
	
	
	});
	
	
});
 
function fnClickAddRow() {
	//var member_val= $('#member').val();
	/* var choic = member_val;
	
	if(choic!=='' && choic!==null){ */
		//$('#giffy').show();
		$("#tbShow").show();
		var gnme=$('#groupName').val();
		var grId=$('#groupId').val();
				 $('#searchtb').dataTable().fnAddData( [
					 	$('#groupName').val(),
					 	$('#groupId').val(),
						'<button type="button" onclick="dataTableUpdateBtn(\''+gnme+'\',\''+grId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-edit"></i></button>'] );
				 
				 data["groupName"] =$("#groupName").val(); 
				 data["groupId"] = $("#groupId").val();
				 data2.push(data);
				 
				 $('#groupName').val('');
				 $('#groupId').val('');
				 
				 alert("data=="+JSON.stringify(data2));
				 //$('#member option:selected').remove();
				 
				// p_no_array.push(member_val);
					
	/* }
	else{
		 $.confirm({
			    title: 'Alert!',
			    content: 'Please select the member from the list',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
	} */
 	   
}

function dataTableUpdateBtn(value,text,obj)
{
	//console.log("p_no_array 1--"+p_no_array.toString());
		$('#groupName').val(value);
		$('#groupId').val(text);
		$('#searchtb').DataTable().row($(obj).parents('tr')).remove().draw(false);
}
/*
 function submitGroupDetails(){
	 if($('#domain').val()===''){
			$('#msgg').show();
			$('#addMessage').text(' Please select Domain');
			callCheck();
		}
		else if($('#selectType').val()===''){
			$('#msgg').show();
			$('#addMessage').text(' Please select '+$('#appOug').text());
			callCheck();
		}
		else if($('#searchtb').dataTable().fnGetData().length===0){
			$('#msgg').show();
			$('#addMessage').text(' Please add Members');
			callCheck();
		}
		else if($('#groupName').val()===''){
			$('#msgg').show();
			$('#addMessage').text(' Please provide Group Name');
			callCheck();
		}
		else{
			$('#giffy').show();
	    $('#memberList').val(p_no_array);
	    $("#domain").prop("disabled", false);
		$("#selectType").prop("disabled", false);
	    document.GroupForm.action="createGroup";
   		document.GroupForm.method="POST";
   		document.GroupForm.submit(); 
		}
 }
 

 //time out for messages
 setTimeout(function() {					
        $('.msg-show').fadeOut(2000);
      
       
    },2000);
 
 
 function callCheck(){
	 setTimeout(function() {					
	        $('.msg-sh').fadeOut(2000);
	      
	       
	    },2000);
 }
 
 //Reset function in javascript
  function Reset(){
	$("#domain").prop("disabled", false);
	$("#selectType").prop("disabled", false);
	$("#groupName").val("");
 	$("#domain").val("").trigger('change');	
 	$("#member").val("").trigger('change');
 	$('#searchtb').DataTable().destroy();
 	$('#searchtb tbody').empty();
 	$('#searchtb').DataTable({
		dom: 'Bfrtip',
		"bSort" : false,
		buttons: []
	}); 
 } 
  */

</script>