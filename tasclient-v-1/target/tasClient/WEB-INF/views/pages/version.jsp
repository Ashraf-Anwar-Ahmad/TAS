<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Jsp Page Start --->

    <div class="main_body">
        <div class="container-fluid">
            <div class="conent_wrapper">
                <div class="top_head_area">
                    <div class="eqdiv">
                        <div class="page_head">
                            <h2>Version / Build History</h2>
                        </div>
                        <!-- <div class="page_breadcrumb">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item active" aria-current="page">Version/Build History</li>
                                </ol>
                            </nav>
                        </div> -->
                    </div>
                    <!-- Message Area --->
                    <div class="eqdiv">
                        <span style="display:none;" class="alert alert-success"><i class="fa  fa-check-circle"></i> Data Submitted Successfully</span>
                        <span style="display:none;" class="alert alert-error"><i class="fa  fa-close"></i> Data Not Submitted</span>
                        <span style="display:none;" class="alert alert-warning"><i class="fa  fa-info-circle"></i>Total Post Not exceed</span>
                    </div>
                    <!-- Message Area End--->
                </div>

                <div class="main_content" id="form_area">
                   
                            <div class="cont_box_ver">
                               <div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link active" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Version : 1.0.0 | Build Number : 200615
        </button>
      </h2>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body">
        <div class="row">
			<div class="col-md-12">
			<div class="dev_info">
				<h3>Version : 1.0.0</h3>
				<ul class="verul">
					<li>Manage Threat</li> 
					<li>Search and View Threat Data</li>
					<li>View Threat History</li>
					<li>View Coordinates on Map</li>
					<li>View Threats on Map</li>
				</ul>
				<!-- <br/>
				<p style="font-size:15px;line-height:20px;">The application has been developed by Software Development Overseeing Team of Directorate of IT, Indian Coast Guard Headquarters.</p>
				 --></div>
			</div>
			
		</div>
      </div>
    </div>
  </div> <!--accord 1 end-->
 

  
 
  
</div>
                            </div>
                        
                </div>
                <!-- Main Content End -->

            </div>
        </div>

    </div>
    <!-- Jsp Page End --->
    
    <script type="text/javascript">
	 
$(document).ready(function () {
    $('.card-header .btn-link').click(function( ) {
 
        $('.card-header .btn-link').removeClass('active');

        var $this = $(this);
        if (!$this.hasClass('active')) {
            $this.addClass('active');
        }
        //e.preventDefault();
    });
});
  
	 
	</script>
