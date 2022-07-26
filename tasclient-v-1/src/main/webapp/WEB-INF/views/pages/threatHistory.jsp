<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="static/js/validation/mapDataValidation.js"></script>

<!-- Jsp Page Start --->

<div class="main_body">
	<div class="gif" id="giffy" style="display: none">
		<img alt="" src="static/img/preloader.gif">
	</div>
	<div class="container-fluid">
		<div class="conent_wrapper">
			<div class="top_head_area">
				<div class="eqdiv">
					<div class="page_head">
						<h2>Threat History</h2>
					</div>

				</div>
				<!-- Message Area --->
				<div class="eqdiv">
					<span style="display: none;" class="alert alert-success"><i
						class="fa  fa-check-circle"></i> Data Submitted Successfully</span> <span
						style="display: none;" class="alert alert-error"><i
						class="fa  fa-close"></i> Data Not Submitted</span> <span
						style="display: none;" class="alert alert-warning"><i
						class="fa  fa-info-circle"></i>Total Post Not exceed</span>
				</div>
				<!-- Message Area End--->
			</div>


			<!-- /form area close -->
			<!-- Head Accrd area start -->
			<div class="hdr_acd">
				<p id="view_deta_area">
					<!-- <span><i class="fa fa-chevron-right"></i></span> View Report -->
				</p>
			</div>
			<!-- Head Accrd area End -->
			<div id="data_table_view" style="display: none;">
				<!-- Table Start -->
				<div id="table_view">

					<div class="table-responsive-lg table-responsive-md">

						<table id="search_tab" class="table table-striped table-bordered"
							style="width: 100%;">
							<thead class="thead-dark">
								<tr class="info tb-hd">
									<!-- //Input Id,Originator,GPS Position,Time of activation,IMEI No.,Distance from land(In kms),Region,View Map,View Details(View)-->

									<th>Input id</th>
									<th>Originator</th>
									<th>GPS position</th>
									<th>Time of activation</th>
									<th>IMEI no.</th>
									<th>Distance from land(in kms)</th>
									<th>Region</th>
									<th style="min-width: 110px !important;">View map</th>
									<th style="min-width: 110px !important;">View details</th>
									<th style="min-width: 110px !important;">Update</th>
									<th style="min-width: 92px !important;">View docs</th>
								</tr>
							</thead>
							<tbody class="tbd1">

							</tbody>
						</table>
					</div>

					<!-- Table Start End -->

				</div>
				<!-- /Table end -->
			</div>
		</div>
	</div>

</div>

<!-- Jsp Page End --->

<!-- Script Links End--->

<script type="text/javascript">
	$(function() {
		genrateReport();
	});

	function genrateReport() {
		//alert("genrateReport")
		$("#data_table_view").hide();
		$('#search_tab').DataTable().destroy();
		$('#search_tab tbody').empty();

		$.ajax({
			type : 'GET',
			url : "getThreatHistoryList",
			data : {},
			beforeSend : function() {
				$('#giffy').show();
			},
			complete : function() {
				$('#giffy').hide();
			},
			success : function(data) {
				$("#data_table_view").show();
				$("#view_deta_area").trigger('click');
				var dataobj = JSON.parse(data);
				viewDetailDataTable(dataobj)
			},
			error : function() {
				$.alert({
					content : 'Error',
					theme : 'material',
					type : 'orange',
					title : 'Error'
				});
				return false;
			}

		}); //end of ajax call

	}//close function genrateReport

	//Display datatable at viewdetail model page
	function viewDetailDataTable(dataobj) {
		$("#search_tab").dataTable().fnDestroy();
		if (dataobj == "") {
			$('#search_tab').DataTable({
				dom : 'Bfrtip',
				"bSortable" : false,
				"ordering" : false,
				buttons : []

			});

		} else {
			$('#search_tab')
					.DataTable(
							{
								dom : 'Bfrtip',
								buttons : [],
								"bSortable" : false,
								"ordering" : false,
								buttons : [
										{
											extend : 'excelHtml5',
											title : 'Threat History',
											exportOptions : {
												columns : [ 0, 1, 2, 3, 4, 5, 6 ]
											},
											autoPrint : false

										},
										{
											extend : 'pdfHtml5',
											customize : function(doc) {
												// console.dir(doc);
												doc.content[1].margin = [ 30,
														0, 100, 0 ]; //left, top, right, bottom
												doc.styles.tableBodyEven.alignment = 'center';
												doc.styles.tableBodyOdd.alignment = 'center';
											},
											title : 'Threat History',
											exportOptions : {
												columns : [ 0, 1, 2, 3, 4, 5, 6 ]
											},
											autoPrint : false,
										} ],

								data : dataobj,
								columns : [
										{
											data : 'inputId',

										},

										{
											data : 'originator',

										},
										{

											mRender : function(data, type, row) {
												return "Lat:" + row.latitute
														+ "<br/>Long:"
														+ row.longitute;

											}

										},
										{
											data : 'timeOfActivation',

										},
										{
											data : 'imeiNo',

										},
										{
											data : 'distanceFromLand',

										},
										{
											data : 'region',

										},
										{
											mRender : function(data, type, row) {
												var valpass = "'"
														+ row.latitute + "#~#"
														+ row.longitute + "'";
												var encData = window
														.btoa(row.latitute
																+ "#~#"
																+ row.longitute);
												return '<a href="viewMapSingle?encData='
														+ encData
														+ '" onclick="return viewMapValidation('
														+ valpass
														+ ',2);" target="_blank"><button type="button" value="'
														+ valpass
														+ '"  class="btn btn-success btn-sm1" title="View map"><i class="fa fa-map-marker "></i></button></a>';

											}
										},
										{
											mRender : function(data, type, row) {
												var valpass = row.genDtlsId;
												var threatId = [ "0001",
														"0002", "0003", "0004",
														"0005", "0006" ];//threat id
												if (threatId
														.indexOf(row.typeOfThreatId) !== -1)
													return '<a href="viewPDF?id='
															+ valpass
															+ '" target="_blank"><button type="button"  class="btn btn-primary btn-sm1" title="View details"><i class="fa fa-eye"></i></button></a>';
												else
													return '<a target="_blank"><button type="button"  class="btn btn-primary btn-sm1">N/A</button></a>';

											}
										},
										{
											mRender : function(data, type, row) {
												//"0001","Satellite interception","0002","Counter terrorism","0003","Narcotics smuggling","0004","Contraband smuggling","0005","Human trafficking","0006","Others"		
												var updateUrl = {
													"0001" : "updateSatelliteInterceptionPage?id=",
													"0002" : "updateCounter?id=",
													"0003" : "updateNarcotic?id=",
													"0004" : "updateContraband?id=",
													"0005" : "updateHumanTrafficking?id=",
													"0006" : "updateOtherPage?id="
												};
												//	var valpass = row.genDtlsId+"#"+row.typeOfThreatId;
												var valpass = row.genDtlsId;
												var threatId = [ "0001",
														"0002", "0003", "0004",
														"0005", "0006" ];//threat id
												if (threatId
														.indexOf(row.typeOfThreatId) !== -1)
													return '<a href="'+updateUrl[row.typeOfThreatId]+valpass+'" ><button type="button"  class="btn btn-info btn-sm1" title="Update"><i class="fa fa-edit"></i></button></a>';
												else
													return '<a href="" ><button type="button"  class="btn btn-primary btn-sm1">N/A</button></a>';

											}
										},
										{
											mRender : function(data, type, row) {
												//"0001","Satellite interception","0002","Counter terrorism","0003","Narcotics smuggling","0004","Contraband smuggling","0005","Human trafficking","0006","Others"		

												//	var updateUrl={"0001":"updateSatelliteInterceptionPage?id=","0002":"updateCounter?id=","0003":"updateNarcotic?id=","0004":"updateContraband?id=","0005":"updateHumanTrafficking?id=","0006":"updateOtherPage?id="};
												//	var valpass = row.genDtlsId+"#"+row.typeOfThreatId;
												var valpass = row.inputId;
												var threatId = [ "0001",
														"0002", "0003", "0004",
														"0005", "0006" ];//threat id
												if (threatId
														.indexOf(row.typeOfThreatId) !== -1)
													return '<a href="viewDocPage?inputId='
															+ valpass
															+ '&threadId='
															+ row.typeOfThreatId
															+ '" target="_blank"><button type="button"  class="btn btn-viewdoc btn-sm1" title="View docs"><img src="static/img/view_doc.png" alt="view" style="width:19px;"></button></a>';
												else
													return '<a target="_blank"><button type="button"  class="btn btn-primary btn-sm1">N/A</button></a>';

											}
										}

								]
							});//close datatable
		}//close else

	}//close viewDetailDataTable
</script>




<!-- Script Links End--->
