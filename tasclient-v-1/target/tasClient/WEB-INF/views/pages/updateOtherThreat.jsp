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
						<h2>Manage Threat</h2>
					</div>

				</div>
				<!-- Message Area --->
				<div class="eqdiv">
					<span style="display: none;" class="alert alert-success"><i
						class="fa  fa-check-circle"></i> Data Submitted Successfully</span> <span
						style="display: none;" class="alert alert-error"><i
						class="fa  fa-close"></i> Data Not Submitted</span> <span
						style="display: none;" class="alert alert-warning"><i
						class="fa  fa-info-circle"></i>Total Post Not exceed</span> <span
						class="alert alert-warning msg-sh" style="display: none;"
						id="msgg"><i class="fa fa-info-circle"></i><span
						id="addMessage"></span></span>
				</div>
				<!-- Message Area End--->
			</div>



			<div class="main_content" id="form_area">
				<div class=" ">

					<!--Tab Form Start-->


					<!--multisteps-form-->
					<div class="multisteps-form">
						<!--progress bar-->
						<div class="row">
							<div class="col-12   ml-auto mr-auto mb-4">
								<div class="multisteps-form__progress">
									<button class="multisteps-form__progress-btn js-active"
										type="button" title="General Details" disabled="disabled">General
										Details</button>
									<button class="multisteps-form__progress-btn" type="button"
										title="Boat/Vessels Details" disabled="disabled">Boat/Vessels
										Details</button>
									<button class="multisteps-form__progress-btn" type="button"
										title="Crew Details" disabled="disabled">CrewDetails
									</button>
									<button class="multisteps-form__progress-btn" type="button"
										title="Other Information" disabled="disabled">Other
										Information</button>
								</div>
							</div>
						</div>
						<!--form panels-->
						<div class="row">
							<div class="col-12 m-auto">
								<form class="multisteps-form__form">
									<!--single form panel-->
									<div
										class="multisteps-form__panel shadow p-4 rounded bg-white js-active"
										data-animation="scaleIn">
										<h3 class="multisteps-form__title">General Details</h3>
										<div class="multisteps-form__content">
											<div class="row">
												<div class="col-md-3">
													<div class="form-group">
														<label>Type of Threat<span class="mandatory-field">*</span></label>
														<select class="form-control select2" name="threatTypeName"
															id="threatTypeName">
															<option value="">Select</option>
															<c:forEach items="${threatList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Input Id<span class="mandatory-field">*</span></label>
														<input type="text"
															class="form-control allownumericwithoutdecimal"
															name="inputId" id="inputId" />
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Date of receipt<span
															class="mandatory-field">*</span></label> <input type='text'
															class="form-control" id='dateRecpt' name="dateRecpt"
															readonly style="background-color: #ffff" />
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Originator<span class="mandatory-field">*</span></label>
														<select class="form-control select2" name="origntrName"
															id="origntrName">
															<option value="">Select</option>
															<c:forEach items="${orgnList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</div>
											<div class="row">

												<div class="col-md-3">
													<div class="form-group">
														<label>Time of Position</label> <input type='text'
															class="form-control" id='timeOfPos' name="timeOfPos"
															onkeydown="return false" readonly
															style="background-color: #ffff" />
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Time of Activation</label> <input type="text"
															class="form-control" name="timeOfActivation"
															id="timeOfActivation" onkeydown="return false" readonly
															style="background-color: #ffff" />
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Grading</label> <select
															class="form-control select2" name="gradingName"
															id="gradingName">
															<option value="">Select</option>
															<c:forEach items="${grdList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="col-md-3 orgnOtherCl" style="display: none;">
													<div class="form-group">
														<label>Other Originator</label> <input type="text"
															class="form-control" name="origntrOther"
															id="origntrOther" />
													</div>
												</div>

											</div>
											<div class="row">
												<!-- (0406) -->
												<div class="col-12 col-md-6">
													<div class="inner_legd">
														<fieldset class="scheduler-border">
															<legend class="scheduler-border">GPS Position:</legend>
															<div class="row">
																<div class="col-md-6">
																	<div class="form-group">
																		<label>Latitude <small>(Decimal
																				Degrees)</small></label> <input type="text"
																			class="form-control allow-float"
																			name="gpslattitudeDec" id="gpslattitudeDec" />
																	</div>
																	<div class="form-group">
																		<label>Latitude <small>(Deg, Min, Sec)</small></label>
																		<input type="text" class="form-control"
																			name="gpslattitudeDeg" id="gpslattitudeDeg" readonly
																			style="background-color: #ffff" />
																	</div>

																</div>

																<div class="col-md-6 mpdw">
																	<div class="form-group">
																		<label>Longitude <small>(Decimal
																				Degrees)</small></label> <input type="text"
																			class="form-control allow-float"
																			name="gpslongitudeDec" id="gpslongitudeDec" />
																	</div>
																	<div class="form-group">
																		<label>Longitude <small>(Deg, Min,
																				Sec)</small></label> <input type="text" class="form-control"
																			name="gpslongitudeDeg" id="gpslongitudeDeg" readonly
																			style="background-color: #ffff" />
																	</div>

																</div>
																<div class="col-md-12">
																	<!--1006 -->
																	<button type="button" id="mapv"
																		onClick="viewMapFormValidation()"
																		class="btn btn-mp-view">
																		<i class="fa  fa-map-marker"></i> View Map
																	</button>
																</div>
																<!--1006 -->
															</div>
														</fieldset>
													</div>
												</div>
												<div class="col-12 col-md-6">

													<div class="inner_legd">
														<fieldset class="scheduler-border">
															<legend class="scheduler-border">Distance from
																Land:</legend>
															<div class="row">
																<div class="col-md-6">
																	<div class="form-group">
																		<label>Kilometers (Km)</label> <input type="text"
																			class="form-control allow-float" name="distanceKmLnd"
																			id="distanceKmLnd" />
																	</div>
																</div>
																<div class="col-md-6">
																	<div class="form-group">
																		<label>Nautical Miles</label> <input type="text"
																			class="form-control allow-float"
																			name="distanceMileLnd" id="distanceMileLnd" />
																	</div>
																</div>
																<div class="col-md-6">
																	<div class="form-group">
																		<label>From Where</label> <input type="text"
																			class="form-control" name="fromWhere" id="fromWhere" />
																	</div>
																</div>


															</div>
														</fieldset>


													</div>

												</div>
											</div>
											<!-- /(0406) -->

											<div class="row">

												<div class="col-md-3">
													<div class="form-group">
														<label>Location</label>
														<!-- (0406) -->
														<!-- <input type="text" class="form-control" name="location" id="location" /> -->
														<select class="form-control select2" name="location"
															id="location">
															<option value="">Select</option>
															<c:forEach items="${locList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
														<!-- /(0406) -->
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">

														<label>Region</label> <select class="form-control select2"
															name="regionName" id="regionName">
															<option value="">Select</option>
															<c:forEach items="${rgnList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Coastal State</label> <select
															class="form-control select2" name="coastStatName"
															id="coastStatName">
															<option value="">Select</option>
															<%-- <c:forEach items="${cstlstList}" var="ListItem">
	                               					<option value="${ListItem.id}">${ListItem.name}</option>
	                               				</c:forEach> --%>
														</select>
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<!-- 3006 -->
														<label>IMEI No. Details</label> <br />
														<button type="button" data-toggle="modal"
															data-target="#imei_det" class="btn btn-default">
															<i class="fa fa-plus"></i> Add IMEI
														</button>
														<div class="btImei" style="display: none">
															<!-- <span class="badge badge-success" id="sizeImei"></span> -->
														</div>
														<div class="btImei" style="display: none">
															<span class="badge badge-success" id="sizeImei"></span>
														</div>
													</div>
												</div>
											</div>

											<div class="row">

												<div class="col-md-3">
													<div class="form-group">
														<label>Contacted No. Details</label><br />
														<button type="button" data-toggle="modal"
															data-target="#contact_det" class="btn btn-default">
															<i class="fa fa-plus"></i> Add Details
														</button>
														<div class="btCont" style="display: none">
															<span class="badge badge-success" id="sizeCont"></span>
														</div>
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Name of Suspect</label> <input type="text"
															class="form-control" name="nameSuspects"
															id="nameSuspects" />
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Shared With</label> <select
															class="form-control select2" name="sharedWithName"
															id="sharedWithName" multiple>
															<option value="">Select</option>
															<c:forEach items="${shrdwtList}" var="sharedListItem">
																<option value="${sharedListItem.id}">${sharedListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="col-md-3 shrdWithOtherCl" style="display: none;">
													<div class="form-group">
														<label>Shared With Other</label> <input type="text"
															class="form-control" name="sharedWithOther"
															id="sharedWithOther" />
													</div>
												</div>
											</div>
											<div class="row">
												<div class="button-row d-flex mt-4 col-12">
													<button class="btn btn-primary2 ml-auto js-btn-next"
														type="button" title="Next">Next</button>
												</div>
											</div>
										</div>
									</div>






									<!--single form panel-->
									<div class="multisteps-form__panel shadow p-4 rounded bg-white"
										data-animation="scaleIn">
										<h3 class="multisteps-form__title">Boat/Vessels Details</h3>
										<div class="multisteps-form__content">


											<!--Boat Vessel form area start-->
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<div class="form-check form-check-inline">
															<input class="form-check-input" type="radio"
																name="boat_vessel_det" id="boattype" value="boat_opt"
																checked>

															<!-- 0206 -->
															<label class="form-check-label" for="boattype">Boat</label>
														</div>
														<div class="form-check form-check-inline">
															<input class="form-check-input" type="radio"
																name="boat_vessel_det" id="vesseltype"
																value="vessel_opt"> <label
																class="form-check-label" for="vesseltype">Vessel</label>
														</div>


													</div>
												</div>

											</div>


											<div class="input_bt_area">
												<div class="row">

													<div class="col-md-3">
														<div class="form-group">
															<label>Type of boat</label> <select
																class="form-control select2 boatcl" name="typeOfBoat"
																id="typeOfBoat">
																<option value="">Select</option>
																<c:forEach items="${boatTypeList}" var="boatListItem">
																	<option value="${boatListItem.id}">${boatListItem.name}</option>
																</c:forEach>
															</select>
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Name of Boat</label> <input type="text"
																class="form-control boatcl" name="boatName"
																id="boatName" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Reg. No.</label> <input type="text"
																class="form-control boatcl" name="regNum" id="regNum" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>Name of Owner</label> <input type="text"
																class="form-control boatcl" name="ownerName"
																id="ownerName" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>State of Reg.</label> <input type="text"
																class="form-control boatcl" name="stateReg"
																id="stateReg" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Port of Reg.</label> <input type="text"
																class="form-control boatcl" name="portReg" id="portReg" />
														</div>
													</div>


													<div class="col-md-3">
														<div class="form-group">
															<label>Number of Crew</label> <input type="number"
																class="form-control boatcl allownumericwithoutdecimal"
																onkeydown="return false" name="noOfCrew" id="noOfCrew"
																min="1" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Documents Held</label> <input type="text"
																class="form-control boatcl" name="docHeld" id="docHeld" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>NAV Eqpt Fitted</label> <input type="text"
																class="form-control boatcl" name="navEqpt" id="navEqpt" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>Common Eqpt Fitted</label> <input type="text"
																class="form-control boatcl" name="commEqpt"
																id="commEqpt" />
														</div>
													</div>


													<div class="col-md-3">
														<div class="form-group">
															<label>Life Saving Eqpt Fitted</label> <input type="text"
																class="form-control boatcl" name="lifeEqpt"
																id="lifeEqpt" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>LPC</label> <input type="text"
																class="form-control boatcl" name="boatlpc" id="boatlpc" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>ETD</label> <input type="text"
																class="form-control boatcl" name="boatetd" id="boatetd"
																readonly style="background-color: #ffff" />
														</div>
													</div>


													<div class="col-md-3">
														<div class="form-group">
															<label>NPC</label> <input type="text"
																class="form-control boatcl" name="boatnpc" id="boatnpc" />
														</div>
													</div>


													<div class="col-md-3">
														<div class="form-group">
															<label>ETA</label> <input type="text"
																class="form-control boatcl" name="boateta" id="boateta"
																readonly style="background-color: #ffff" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>License/Permit</label> <input type="text"
																class="form-control boatcl" name="licenseFish"
																id="licenseFish" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Country Code</label> <input type="text"
																class="form-control boatcl allownumericwithoutdecimal"
																name="ownerContCode" id="ownerContCode" maxlength="15" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Owner Contact Details</label> <input type="text"
																class="form-control boatcl allownumericwithoutdecimal"
																name="ownerContDts" id="ownerContDts" maxlength="15" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Boat Confirming to Colour Code</label> <select
																class="form-control select2 boatcl" name="boatColrcd"
																id="boatColrcd">
																<option value="">Select</option>
																<option value="yes">Yes</option>
																<option value="yes">No</option>
															</select>
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>Remarks</label> <input type="text"
																class="form-control boatcl" name="remarks" id="remarks" />
														</div>
													</div>
													<div class="col-md-2">
														<div class="form-group mt-4">
															<button type="button" id="addBoatButton"
																onclick="fnClickAddBoat()" class="btn btn-primary">Add</button>
															<button type="button" style="display: none;"
																id="updateBoatButton" onclick="fnClickAddBoat()"
																class="btn btn-primary">Update</button>
														</div>
													</div>
													<div class="col-md-12">
														<div class="btBoat" style="display: none">
															<button class="btn btn-default" id="boatEye"
																type="button" data-toggle="modal"
																data-target="#boat_det">
																<i class="fa fa-eye"></i> <span id="sizeBoat"></span>
															</button>
														</div>
													</div>
												</div>

											</div>
											<!--input_bt_area end-->

											<!--Vessel form area start-->
											<div class="input_vs_area" style="display: none;">
												<div class="row">

													<div class="col-md-3">
														<div class="form-group">
															<label>Name of Vessel</label> <input type="text"
																class="form-control vesselcl" name="vesselName"
																id="vesselName" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Vessel Type</label> <select
																class="form-control select2 vesselcl"
																name="vesselTypeName" id="vesselTypeName">
																<option value="">Select</option>
																<c:forEach items="${vsltpList}" var="ListItem">
																	<option value="${ListItem.id}">${ListItem.name}</option>
																</c:forEach>
															</select>
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>International Call Sign</label> <input type="text"
																class="form-control vesselcl" name="intCallSign"
																id="intCallSign" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>MMSI</label> <input type="text"
																class="form-control vesselcl" name="mmsi" id="mmsi" />
														</div>
													</div>



													<div class="col-md-3">
														<div class="form-group">
															<label>IMO No.</label> <input type="text"
																class="form-control vesselcl" name="imoNo" id="imoNo" />
														</div>
													</div>


													<div class="col-md-3">
														<div class="form-group">
															<label>Inmarsat No.</label> <input type="text"
																class="form-control vesselcl" name="inmarsatNo"
																id="inmarsatNo" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>Cargo</label> <input type="text"
																class="form-control vesselcl" name="cargo" id="cargo" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>LPC</label> <input type="text"
																class="form-control vesselcl" name="vessellpc"
																id="vessellpc" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>ETD</label> <input type="text"
																class="form-control vesselcl" name="vesseletd"
																id="vesseletd" readonly style="background-color: #ffff" />
														</div>
													</div>


													<div class="col-md-3">
														<div class="form-group">
															<label>NPC</label> <input type="text"
																class="form-control vesselcl" name="vesselnpc"
																id="vesselnpc" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>ETA</label> <input type="text"
																class="form-control vesselcl" name="vesseleta"
																id="vesseleta" readonly style="background-color: #ffff" />
														</div>
													</div>


													<div class="col-md-3">
														<div class="form-group">
															<label>Total Crew</label> <input type="number"
																class="form-control vesselcl allownumericwithoutdecimal"
																onkeydown="return false;" name="totCrew" id="totCrew"
																min="1" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Flag or Port of Reg.</label> <input type="text"
																class="form-control vesselcl" name="flgPrtReg"
																id="flgPrtReg" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>Other Communication Equipment</label> <input
																type="text" class="form-control vesselcl"
																name="otherCommEqpt" id="otherCommEqpt" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>Agent</label> <input type="text"
																class="form-control vesselcl" name="agent" id="agent" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>PANS</label> <select
																class="form-control select2 vesselcl" name="pans"
																id="pans">
																<option value="">Select</option>
																<option value="Yes">Yes</option>
																<option value="No">No</option>
															</select>
														</div>
													</div>



												</div>
												<div class="row">
													<div class="col-md-2">
														<div class="form-group mt-4">
															<button type="button" id="addVesselButton"
																onclick="fnClickAddVessel()" class="btn btn-primary">Add</button>
															<button type="button" style="display: none;"
																id="updateVesselButton" onclick="fnClickAddVessel()"
																class="btn btn-primary">Update</button>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="btVessel" style="display: none">
															<button class="btn btn-default" id="vesselEye"
																type="button" data-toggle="modal"
																data-target="#vess_det">
																<i class="fa fa-eye"></i> <span id="sizeVessel"></span>
															</button>
														</div>
													</div>
												</div>

											</div>
											<!--input_vs_area end-->


											<!--Boat Vessel form area End-->


											<!-- crew details area start -->
											<div class="row">
												<div class="button-row d-flex mt-4 col-12">
													<button class="btn btn-secondary js-btn-prev" type="button"
														title="Prev">Prev</button>
													<button class="btn btn-primary2 ml-auto js-btn-next"
														type="button" title="Next">Next</button>
												</div>
											</div>
										</div>
									</div>
									<!-- crew details area start -->
									<!--single form panel-->
									<div class="multisteps-form__panel shadow p-4 rounded bg-white"
										data-animation="scaleIn">
										<h3 class="multisteps-form__title">Crew Details</h3>
										<div class="multisteps-form__content">

											<!--Crew details input start-->
											<div class="row">
												<div class="col-md-3">
													<div class="form-group">
														<label>Name</label> <input type="text"
															class="form-control crewcl" name="crName" id="crName" />
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Age</label> <input type="number" min="10"
															class="form-control crewcl allownumericwithoutdecimal"
															id="crAge" name="crAge" onkeydown="return false;">
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Nationality</label> <input type="text"
															class="form-control crewcl" id="crNationality"
															name="crNationality">
													</div>
												</div>



												<div class="col-md-3">
													<div class="form-group">
														<label>Address</label> <input type="text"
															class="form-control crewcl" id="crAddress"
															name="crAddress">
													</div>
												</div>
											</div>


											<div class="row">
												<div class="col-md-3">
													<div class="form-group">
														<label>Country Code</label> <input type="text"
															class="form-control crewcl allownumericwithoutdecimal"
															name="crCountCode" id="crCountCode" maxlength="15" />
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Telephone Number</label> <input type="tel"
															class="form-control crewcl allownumericwithoutdecimal"
															id="crTelNo" name="crTelNo" maxlength="15">
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Marital Status</label> <select
															class="form-control crewcl" id="crMartSts"
															name="crMartSts">
															<option value="">Select</option>
															<c:forEach items="${marrstList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Profession</label> <input type="text"
															class="form-control crewcl" id="crProfession"
															name="crProfession" placeholder="">
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Identification Marks</label> <input type="text"
															class="form-control crewcl" name="crIdenMrks"
															id="crIdenMrks" />
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Religion</label> <select
															class="form-control select2 crewcl" name="crRelgn"
															id="crRelgn">
															<option value="">Select</option>
															<c:forEach items="${rlgnList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Type of Id Proof</label> <select
															class="form-control select2 crewcl" name="crDtlsIdType"
															id="crDtlsIdType">
															<option value="">Select</option>
															<c:forEach items="${idProofList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>


												<div class="col-md-3">
													<div class="form-group">
														<label>ID Proof Number</label> <input type="text"
															class="form-control crewcl" name="crDtlsIdPf"
															id="crDtlsIdPf" />
													</div>
												</div>


												<div class="col-md-3">
													<div class="form-group mt-4">
														<button type="button" id="addCrewButton"
															onclick="fnClickAddCrew()" class="btn btn-primary">Add</button>
														<button type="button" style="display: none;"
															id="updateCrewButton" onclick="fnClickAddCrew()"
															class="btn btn-primary">Update</button>
													</div>
												</div>

												<div class="col-md-12">
													<div class="btCrew" style="display: none">
														<button class="btn btn-default" id="crewEye" type="button"
															data-toggle="modal" data-target="#crew_det">
															<i class="fa fa-eye"></i> <span id="sizeCrew"></span>
														</button>
													</div>
												</div>
											</div>




											<!--Crew details input End-->

											<div class="button-row d-flex mt-4">
												<button class="btn btn-secondary js-btn-prev" type="button"
													title="Prev">Prev</button>
												<button class="btn btn-primary2 ml-auto js-btn-next"
													type="button" title="Next">Next</button>
											</div>
										</div>
									</div>


									<!--single form panel-->
									<div class="multisteps-form__panel shadow p-4 rounded bg-white"
										data-animation="scaleIn">
										<h3 class="multisteps-form__title">Other Information</h3>
										<div class="multisteps-form__content">

											<!--Crew details input start-->
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label>Other Information</label>
														<textarea class="form-control" id="otherInfo"
															name="otherInfo" placeholder="Other Information"></textarea>
													</div>
												</div>

												<div class="col-md-6">
													<div class="form-group">
														<label>Follow Up</label>
														<textarea class="form-control" id="followUp"
															name="followUp" placeholder="Follow Up"></textarea>
													</div>
												</div>


											</div>


											<!-- <div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label>Upload Documents</label>
					<div class="custom-file" id="customFile" lang="es">
						
						<input type="file" class="custom-file-input" id="uploadDocs" aria-describedby="fileHelp">
						<label class="custom-file-label" for="exampleInputFile">
						   Select file...
						</label>
				</div>
				</div>
			</div> 
			
			 </div>
		 <div class="row">
			<div class="col-md-12">
			<button class="btn btn-default" type="button" data-toggle="modal" data-target=""><i class="fa fa-eye"></i> 1 Row Added</button>
		</div>
		 </div>
			
			-->

											<!-- Code added by Rakesh to upload multiple file     start -->
											<!--   <div class="row files" id="files1">
                <h4>Files </h4>
                <span class="btn btn-default btn-file">Browse
                   <input type="file" name="files1" multiple />
                </span>
                <br /> <br />
                <ul class="fileList"></ul>
            </div> -->

											<div class="row files fileupdt" id="files1">
												<div class="col-md-12">
													<label><b>Select Files to upload</b></label><br /> <span
														class="btn btn-default btn-file">Browse File.. <input
														type="file" name="files1" multiple />
													</span>

													<button type="button"
														class="btn btn-warning btn-sm1 btncout"
														title="Show/Hide File List">
														<span id="cout"></span> New Files Selected
													</button>
													<button class="btn btn-info ml-auto" type="button"
														id="uploadBtn">Update Upload</button>
												</div>

												<!-- check fileNames > 0 -->
												<ul class="ufile" id="existHideUl">
													<c:forEach var="name" items="${fileNames}">
														<li><a
															href="viewdoc?fileName=${name}&inputId=${inputId}&threatFolder=contrabandsmuggle"
															target="_blank"> <strong class="t">${name} </strong></a><a
															class="hideData"><i class='fa fa-trash'></i></a></li>
													</c:forEach>

												</ul>

												<ul id="hideUl" class="fileList"></ul>


											</div>

											<div style="clear: both;"></div>

											<!-- Code added by Rakesh to upload multiple file     end -->





											<!--Crew details input End-->

											<div class="button-row d-flex mt-4">
												<button class="btn btn-secondary js-btn-prev" type="button"
													title="Prev">Prev</button>
												<button class="btn btn-success ml-auto" type="button"
													onclick="threatCheckDetails()" title="Send">Submit</button>
											</div>
										</div>
									</div>




								</form>
							</div>
						</div>
					</div>


					<!--Tab Form End-->



				</div>
				<!-- Cont Box End -->
			</div>
			<!-- Main Content End -->



		</div>
		<!--conent_wrapper End-->
	</div>
	<!--container-fluid End-->

</div>
<!--main body End-->
<!-- Jsp Page End --->



<!--All Modal Section Start-->


<!--Boat modal start-->

<div class="modal fade pdr0" id="boat_det" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-xl-free" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Boat Details</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="table-responsive-lg table-responsive-md">
					<table id="boat_table" class="table table-striped table-bordered">
						<thead class="thead-dark">
							<tr class="info tb-hd">
								<th>Type of Boat</th>
								<th>Name of Boat</th>
								<th>Reg. No.</th>
								<th>Name of Owner</th>
								<th>State of Reg</th>
								<th>Port of Reg.</th>
								<th>Number of Crew</th>
								<th>Documents Held</th>
								<th>NAV Eqpt Fitted</th>
								<th>Common Eqpt Fitted</th>
								<th>Life Saving Eqpt Fitted</th>
								<th>LPC</th>
								<th>ETD</th>
								<th>NPC</th>
								<th>ETA</th>
								<th>License/Permit for Fishing</th>
								<th>Country Code</th>
								<th>Owner Contact Details</th>
								<th>Boat Confirming to Colour Code</th>
								<th>Remarks</th>
								<th>Action</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>

		</div>
	</div>
</div>

<!--Vessel Modal Start-->


<div class="modal fade pdr0" id="vess_det" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-xl-free" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Vessels Details</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="table-responsive-lg table-responsive-md">
					<table id="vessel_table" class="table table-striped table-bordered">
						<thead class="thead-dark">
							<tr class="info tb-hd">
								<th>Name of Vessel</th>
								<th>Vessel Type</th>
								<th>International Call Sign</th>
								<th>MMSI</th>
								<th>IMO No.</th>
								<th>Inmarsat No.</th>
								<th>Cargo</th>
								<th>LPC</th>
								<th>ETD</th>
								<th>NPC</th>
								<th>ETA</th>
								<th>Total Crew</th>
								<th>Flag or Port of Reg.</th>
								<th>Other Communication Equipment</th>
								<th>Agent</th>
								<th>PANS</th>
								<th>Action</th>
							</tr>
						</thead>

					</table>
				</div>
			</div>

		</div>
	</div>
</div>


<!--Crew Detail Modal Start-->


<div class="modal fade pdr0" id="crew_det" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-xl-free" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Crew Details</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="table-responsive-lg table-responsive-md">
					<table id="crew_table" class="table table-striped table-bordered">
						<thead class="thead-dark">
							<tr class="info tb-hd">
								<th>Name</th>
								<th>Age</th>
								<th>Nationality</th>
								<th>Address</th>
								<th>Country Code</th>
								<th>Telephone Number</th>
								<th>Marital Status</th>
								<th>Profession</th>
								<th>Identification Marks</th>
								<th>Religion</th>
								<th>Type of Id Proof</th>
								<th>ID Proof Number</th>

								<th>Action</th>

							</tr>
						</thead>
					</table>
				</div>
			</div>

		</div>
	</div>
</div>


<!-- Modal Contact  Details View -->
<div class="modal fade " id="contact_det" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Contacted No.
					Details</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<div class="form-row cont_dt">
					<div class="col-md-3">
						<label style="font-weight: 600;">Country Code</label> <input
							type="text" class="form-control allownumericwithoutdecimal"
							id="gnCountryCode" name="gnCountryCode">
					</div>
					<div class="col-md-3">
						<label style="font-weight: 600;">Contacted Number</label> <input
							type="text" class="form-control allownumericwithoutdecimal"
							id="contactNo" name="contactNo" maxlength="15">
					</div>
					<div class="col-md-3">
						<label style="font-weight: 600;">Country</label> <input
							type="text" class="form-control allowOnlyText" id="country"
							name="country">
					</div>
					<div class="col-md-3">
						<div class="form-group mt-4">
							<button type="button" id="addCntctButton"
								onclick="fnClickAddContact()" class="btn btn-primary">Add</button>
							<button type="button" style="display: none;"
								id="updateCntctButton" onclick="fnClickAddContact()"
								class="btn btn-primary">Update</button>
						</div>
					</div>
				</div>
				<div class="contactShd">
					<!-- start tag(0206) -->
					<div class="table-responsive-lg table-responsive-md">
						<table id="contact_tab" class="table  table-bordered">
							<thead class="thead-dark">
								<tr class="info tb-hd">
									<th>Country Code</th>
									<th>Contacted Number</th>
									<th>Country</th>
									<th class="btntd">Edit</th>
									<th class="btntd">Delete</th>

								</tr>
							</thead>

						</table>
					</div>
				</div>
				<!-- end tag(0206) -->
			</div>
		</div>
	</div>
</div>

<!-- Modal IMEI  Details View  3006-->
<div class="modal fade " id="imei_det" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">IMEI Details</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<div class="form-row cont_dt">
					<div class="col-md-9">
						<label style="font-weight: 600;">IMEI Number</label> <input
							type="text" class="form-control" id="imei" name="imei">
					</div>
					<div class="col-md-3">
						<div class="form-group mt-4">
							<button type="button" id="addImeiButton"
								onclick="fnClickAddImei()" class="btn btn-primary">Add</button>
							<button type="button" style="display: none;"
								id="updateImeiButton" onclick="fnClickAddImei()"
								class="btn btn-primary">Update</button>
						</div>

					</div>
				</div>

				<div class="imeiShd">
					<!-- start tag(0206) -->
					<div class="table-responsive-lg table-responsive-md">
						<table id="imei_tab" class="table table-bordered">
							<thead class="thead-dark">
								<tr class="info tb-hd">
									<th>IMEI Number</th>
									<th class="btntd">Edit</th>
									<th class="btntd">Delete</th>

								</tr>
							</thead>

						</table>
					</div>
				</div>
				<!-- end tag(0206) -->
			</div>

		</div>
	</div>
</div>
<!-- end 3006 -->

<!-- below for threat alert modal -->

<div class="modal fade pdr0" id="alert_det" data-backdrop="static"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-xl" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Threat Alert</h5>
				<button type="button" onclick="alertCheckBox()" class="close"
					data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="table-responsive-lg table-responsive-md">
					<table id="alert_table" class="table table-striped table-bordered">
						<thead class="thead-dark">
							<tr class="info tb-hd">
								<th>Input Id</th>
								<th>Type Of threat</th>
								<th>Originator</th>
								<th>GPS Longitude</th>
								<th>GPS Latitude</th>
								<th>IMEI No.</th>
								<th>Country Of contacted No.</th>
								<th>Distance From Land</th>
								<th>Location</th>
								<th>Region</th>
								<th>Suspect Name</th>

							</tr>
						</thead>
					</table>
				</div>
			</div>

		</div>
	</div>
</div>

<!--All Modal Section End-->



<script type="text/javascript">
var uploadTime = ""; 
var uploadedInputId = "" ;
var delImage = new Array();
$(function () { 
		
	$("#uploadBtn").hide();
 	$("#hideUl").hide();
 	$(".btncout").hide();
	uploadTime = "f1"; 
//Added by Rakesh 
			 $(".ufile").each(function(){ // Check every "nested" class 
           if($(this).children().length == 0){ // If this nested class has no children
              $('.ufile').hide(); // This will hide it, but not alter the layout
         
           } else{
           $('.ufile').show();

           }
        });
<!--Rakesh end- ---->
 
	$('#vessel_table').DataTable({
				dom: 'Bfrtip',
				bSort: false,
				buttons: [
					 
				]
			} );
			$('#boat_table').DataTable({
				dom: 'Bfrtip',
				bSort: false,
				buttons: [
					 
				]
			} ); 

			$('#crew_table').DataTable({
				dom: 'Bfrtip',
				bSort: false,
				buttons: [
					 
				]
			} );

			$('#contact_tab').DataTable({
				dom: 'Bfrtip',
				bSort: false,
				buttons: [
					 
				]
			} );
			$('#imei_tab').DataTable({
				dom: 'Bfrtip',
				bSort: false,
				buttons: [				 
				]
			} );
//3006


// Date Time Picker Js

$('#dateRecpt, #timeOfPos, #timeOfActivation, #boatetd, #boateta, #vesseleta, #vesseletd').datetimepicker({
	ignoreReadonly: true,
	widgetPositioning:{
        horizontal: 'auto',
        vertical: 'bottom'
    },
               
				  format: 'DD/MM/YYYY HH:mm:ss',
				  useCurrent: false
				  
				 
	});
				 
$('#datepicker2').datetimepicker({
					widgetPositioning:{
        				horizontal: 'auto',
        				vertical: 'bottom'
    },
				  format: 'DD/MM/YYYY',
				  useCurrent: false
	});
	
			
$('#PositionTime').datetimepicker({
				 
				  format: 'HH:mm:ss',
				  
				  widgetPositioning:{
        				horizontal: 'auto',
       					vertical: 'bottom'
    }, useCurrent: false
	});
				  
$('#activationTime').datetimepicker({
				  
	format: 'HH:mm:ss',
	widgetPositioning:{
        horizontal: 'auto',
        vertical: 'bottom'
    }, useCurrent: false
    //debug:true
			}); 

  
		});
		
</script>

<script>
var contactDtlsList=[];
var boatDataList=[];
var vesselDataList=[];
var crewDataList=[];
var imeiDataList=[];
var threatId;
$(document).ready(function() {
	$.fn.dataTable.ext.errMode = 'none';
	var test=${list};
	threatId=test.threatId;
	contactDtlsList=test.contactList;
	boatDataList=test.boatList;
	vesselDataList=test.vesselList;
	crewDataList=test.crewList;
	imeiDataList=test.imeiList;
	
console.log(JSON.stringify(test) + " >>test");
	//alert("show=="+JSON.stringify(crewDataList));
	//alert("show=="+JSON.stringify(boatDataList));
	for(i in contactDtlsList){
	$('#contact_tab').dataTable().fnAddData( [
		contactDtlsList[i].gnCountryCode,
		contactDtlsList[i].contactNo,
		contactDtlsList[i].country,
			'<button type="button" onclick="dataTableUpdateContact(\''+contactDtlsList[i].gnCountryCode+'\',\''+contactDtlsList[i].contactNo+'\',\''+contactDtlsList[i].country+'\',\''+contactDtlsList[i].cntctId+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button>',
			'<button type="button" onclick="dataTableDeleteContact(\''+contactDtlsList[i].gnCountryCode+'\',\''+contactDtlsList[i].contactNo+'\',\''+contactDtlsList[i].country+'\',\''+contactDtlsList[i].cntctId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
	}
	
	for(i in imeiDataList){
		$('#imei_tab').dataTable().fnAddData( [
			imeiDataList[i].imei,
			'<button type="button" onclick="dataTableUpdateImei(\''+imeiDataList[i].imei+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button>',
			'<button type="button" onclick="dataTableDeleteImei(\''+imeiDataList[i].imei+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
	}
	
/* 	for(i in boatDataList){
		var arr_boat=test.boatStrList[i];
		//alert("show=="+JSON.stringify(arr_boat));
	$('#boat_table').dataTable().fnAddData( [
		boatDataList[i].boatName,boatDataList[i].regNum,boatDataList[i].ownerName,boatDataList[i].portReg,boatDataList[i].noOfCrew,boatDataList[i].docHeld,boatDataList[i].navEqpt,boatDataList[i].commEqpt,
		boatDataList[i].lifeEqpt,boatDataList[i].boatlpc,boatDataList[i].boatetd,boatDataList[i].boatnpc,boatDataList[i].boateta,boatDataList[i].licenseFish,boatDataList[i].ownerContDts,boatDataList[i].boatColrcd,boatDataList[i].remarks,
		 '<button type="button" onclick="dataTableUpdateBoat(\''+arr_boat+'\',\''+boatDataList[i].boatId+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button> <button type="button" onclick="dataTableDeleteBoat(\''+arr_boat[0]+'\',\''+boatDataList[i].boatId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
	
	} */
	for(i in boatDataList){
		//var arr_boat=test.boatStrList[i];
		var arr_boat =[];
		arr_boat.push(boatDataList[i].typeOfBoat);
		arr_boat.push(boatDataList[i].boatName);
		arr_boat.push(boatDataList[i].regNum);
		arr_boat.push(boatDataList[i].ownerName);
		arr_boat.push(boatDataList[i].stateReg);
		arr_boat.push(boatDataList[i].portReg);
		arr_boat.push(boatDataList[i].noOfCrew);
		arr_boat.push(boatDataList[i].docHeld);
		arr_boat.push(boatDataList[i].navEqpt);
		arr_boat.push(boatDataList[i].commEqpt);
		arr_boat.push(boatDataList[i].lifeEqpt);
		arr_boat.push(boatDataList[i].boatlpc);
		arr_boat.push(boatDataList[i].boatetd);
		arr_boat.push(boatDataList[i].boatnpc);
		arr_boat.push(boatDataList[i].boateta);
		arr_boat.push(boatDataList[i].licenseFish);
		arr_boat.push(boatDataList[i].ownerContCode);
		arr_boat.push(boatDataList[i].ownerContDts);
		arr_boat.push(boatDataList[i].boatColrcd);
		arr_boat.push(boatDataList[i].remarks);
		console.log(JSON.stringify(arr_boat)+"  >>arr_boat");
		$('#boat_table').dataTable().fnAddData( [
		boatDataList[i].typeOfBoatName,
		boatDataList[i].boatName,
		boatDataList[i].regNum,
		boatDataList[i].ownerName,
		boatDataList[i].stateReg,
		boatDataList[i].portReg,
		boatDataList[i].noOfCrew,
		boatDataList[i].docHeld,
		boatDataList[i].navEqpt,
		boatDataList[i].commEqpt,
		boatDataList[i].lifeEqpt,
		boatDataList[i].boatlpc,
		boatDataList[i].boatetd,
		boatDataList[i].boatnpc,
		boatDataList[i].boateta,
		boatDataList[i].licenseFish,
		boatDataList[i].ownerContCode,
		boatDataList[i].ownerContDts,
		boatDataList[i].boatColrcd,
		boatDataList[i].remarks,
		 '<button type="button" onclick="dataTableUpdateBoat(\''+arr_boat+'\',\''+boatDataList[i].boatId+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button> <button type="button" onclick="dataTableDeleteBoat(\''+arr_boat[1]+'\',\''+boatDataList[i].boatId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
	
	}
	
	for(i in vesselDataList){
		//var arr_vessel=test.vesselStrList[i];
		// alert("show=="+JSON.stringify(arr_vessel));
		var arr_vessel=[]
		arr_vessel.push(vesselDataList[i].vesselName);
		arr_vessel.push(vesselDataList[i].vesselTypeId);
		arr_vessel.push(vesselDataList[i].intCallSign);
		arr_vessel.push(vesselDataList[i].mmsi);
		arr_vessel.push(vesselDataList[i].imoNo);
		arr_vessel.push(vesselDataList[i].inmarsatNo);
		arr_vessel.push(vesselDataList[i].cargo);
		arr_vessel.push(vesselDataList[i].vessellpc);
		arr_vessel.push(vesselDataList[i].vesseletd);
		arr_vessel.push(vesselDataList[i].vesselnpc);
		arr_vessel.push(vesselDataList[i].vesseleta);
		arr_vessel.push(vesselDataList[i].totCrew);
		arr_vessel.push(vesselDataList[i].flgPrtReg);
		arr_vessel.push(vesselDataList[i].otherCommEqpt);
		arr_vessel.push(vesselDataList[i].agent);
		arr_vessel.push(vesselDataList[i].pans);
		$('#vessel_table').dataTable().fnAddData( [
			vesselDataList[i].vesselName,
			vesselDataList[i].vesselTypeName,
			vesselDataList[i].intCallSign,
			vesselDataList[i].mmsi,
			vesselDataList[i].imoNo,
			vesselDataList[i].inmarsatNo,
			vesselDataList[i].cargo,
			vesselDataList[i].vessellpc,
			vesselDataList[i].vesseletd,
			vesselDataList[i].vesselnpc,
			vesselDataList[i].vesseleta,
			vesselDataList[i].totCrew,
			vesselDataList[i].flgPrtReg,
			vesselDataList[i].otherCommEqpt,
			vesselDataList[i].agent,
			vesselDataList[i].pans,
		
		 '<button type="button" onclick="dataTableUpdateVessel(\''+arr_vessel+'\',\''+vesselDataList[i].vesselId+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button> <button type="button" onclick="dataTableDeleteVessel(\''+arr_vessel[0]+'\',\''+vesselDataList[i].vesselId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );	
	}
	
	
	for(i in crewDataList){
		//var arr_crew=test.crewStrList[i];
				var arr_crew =[];
		arr_crew.push(crewDataList[i].crName);
		arr_crew.push(crewDataList[i].crAge);
		arr_crew.push(crewDataList[i].crNationality);
		arr_crew.push(crewDataList[i].crAddress);
		arr_crew.push(crewDataList[i].crCountCode);
		arr_crew.push( crewDataList[i].crTelNo);
		arr_crew.push(crewDataList[i].crMartStsId);
		arr_crew.push(crewDataList[i].crProfession);
		arr_crew.push(crewDataList[i].crIdenMrks);
		arr_crew.push(crewDataList[i].crRelgnId);
		arr_crew.push(crewDataList[i].crDtlsIdType);
		arr_crew.push(crewDataList[i].crDtlsIdPf); 
		$('#crew_table').dataTable().fnAddData( [
			 crewDataList[i].crName,
			 crewDataList[i].crAge,
			 crewDataList[i].crNationality,
			 crewDataList[i].crAddress,
			 crewDataList[i].crCountCode,
			 crewDataList[i].crTelNo,
			 crewDataList[i].crMartSts,
			 crewDataList[i].crProfession,
			 crewDataList[i].crIdenMrks,
			 crewDataList[i].crRelgn,
			 crewDataList[i].crDtlsIdTypeName,
			 crewDataList[i].crDtlsIdPf,
			 '<button type="button" onclick="dataTableUpdateCrew(\''+arr_crew+'\',\''+crewDataList[i].crId+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button> <button type="button" onclick="dataTableDeleteCrew(\''+arr_crew[0]+'\',\''+crewDataList[i].crId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'
			 ] );
	}
	
	//alert("check");
	$("#sizeCont").text(contactDtlsList.length+' records added');
	$("#sizeBoat").text(boatDataList.length+' records added');
	$("#sizeVessel").text(vesselDataList.length+' records added');
	$("#sizeCrew").text(crewDataList.length+' records added');
	$("#sizeImei").text(imeiDataList.length+' records added');

	boatDataList.length>0?$(".btBoat").show():$(".btBoat").hide();
	contactDtlsList.length>0?$(".btCont").show():$(".btCont").hide();
	vesselDataList.length>0?$(".btVessel").show():$(".btVessel").hide();
	crewDataList.length>0?$(".btCrew").show():$(".btCrew").hide();
	imeiDataList.length>0?$(".btImei").show():$(".btImei").hide();
	//below for text box
	$('#inputId').val(test.inputId);
	$('#dateRecpt').val(test.dateRecpt);
	$('#timeOfPos').val(test.timeOfPos);
	$('#timeOfActivation').val(test.timeOfActivation);
	$('#gpslattitudeDec').val(test.gpslattitudeDec);
	$('#gpslongitudeDec').val(test.gpslongitudeDec);
	$('#gpslattitudeDeg').val(test.gpslattitudeDeg);
	$('#gpslongitudeDeg').val(test.gpslongitudeDeg);
	$('#distanceKmLnd').val(test.distanceKmLnd);
	$('#distanceMileLnd').val(test.distanceMileLnd);
	$('#fromWhere').val(test.fromWhere);//(0406)
	$('#location').val(test.location);
	//$('#imeiNo').val(test.imeiNo);
	$('#nameSuspects').val(test.nameSuspects);
	$('#typeOfContra').val(test.typeOfContra);
	$('#otherInfo').val(test.otherInfo);
	$('#followUp').val(test.followUp);
	
	
	//below for dropdown auto-select
	
	$('#threatTypeName').val(test.threatTypeId).trigger("change");
	$('#origntrName').val(test.origntrId).trigger("change");
	$('#gradingName').val(test.gradingId).trigger("change");
	//$('#regionName').val(test.regionId).trigger("change");//rajkumar
	$('#regionName').val(test.regionId);
	$('#coastStatName').val(test.coastStatId).trigger("change");
	$('#sharedWithName').val(test.sharedWithName).trigger("change");
	
	//for multiple units
	$('#icgUnitsName').val(test.icgUnitsName).trigger("change");
	$('#threatTypeName').prop("disabled", true);
	if(boatDataList.length>0){
		$('#boattype').prop('checked', true);
		$('#vesseltype').prop('checked', false);
		$('.input_bt_area').show();
		$('.input_vs_area').hide();
	}
	else if(vesselDataList.length>0){
		$('#vesseltype').prop('checked', true);
		$('#boattype').prop('checked', false);
		$('.input_bt_area').hide();
		$('.input_vs_area').show();
	}
	
	if(test.regionId != null){
		setTimeout(function(){ 
			$.ajax({
				url : 'getList?=' + test.regionId,
				type : 'get',
				data : {
					param : test.regionId
				},
				success : function(response) {
				//	alert(" response :: "+response)
					var len = response.length;
					var html = '<option value="">Select</option>';
					$('#coastStatName').empty();
					//alert("res=="+response);
					 for(i in response){
			                //alert("val=="+response[i].name);
			                 html +="<option value =\""+response[i].id+"\">"+response[i].name+"</option>"; 
			            }
					html += '</option>';
					$('#coastStatName').html("");
					$('#coastStatName').html(html);
					$('#coastStatName').val(test.coastStatId);
					
				},
				complete: function(){
					//$('#giffy').hide();
			      }
			});
		}, 2000);
		}
	
});


</script>

<script>
//start (0206)
var ctUpd=0;
var btUpd=0;
var vslUpd=0;
var crwUpd=0;
var imUpd = 0;
//end (0206)

//below for contacted details
var cntId;	
var contctDelList=[];
var contctDelChk=[];
var contactDtlsList=[];
function fnClickAddContact() {
		//$('#giffy').show();
		var boolCheck=false;
		var filteredFamily = contactDtlsList.filter(function(x) {
  		if (x.contactNo==$("#contactNo").val()) {
   			//alert("check1");
   			boolCheck=true;
  		}
		});
		if(boolCheck)
  		{
			$.confirm({
			    title: 'Alert!',
			    content: 'You have already added the same Contact Number',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
  		}
		else{
		
		var cntNum=$('#contactNo').val();
		var cntry=$('#country').val();
		var gnCnCo=$('#gnCountryCode').val();
		cntId==null || cntId=='' ? cntId='' : cntId=cntId+'-U';
		// alert("cntNum=="+cntNum);
		if(cntNum!=''){//below (2905)
			
			if(cntNum.length <10){
				$.confirm({
				    title: 'Alert!',
				    content: 'Please enter 10 to 15 digit Contact number',
				    theme: 'material',
				    type: 'orange',
				    buttons: {
				        Ok: function () {
				        	
				        }
				   
				    }
				});
			}
			else{//partial end 2905
				$('#addCntctButton').show();
				$('#updateCntctButton').hide();
				$('.contactShd').show();//(0206)
				ctUpd=0;//(0206)
				 $('#contact_tab').dataTable().fnAddData( [
					 gnCnCo,
					 cntNum,
					 cntry,
						'<button type="button" onclick="dataTableUpdateContact(\''+gnCnCo+'\',\''+cntNum+'\',\''+cntry+'\',\''+cntId+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button>',
						'<button type="button" onclick="dataTableDeleteContact(\''+gnCnCo+'\',\''+cntNum+'\',\''+cntry+'\',\''+cntId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
				 var dataCntct = {};
				 dataCntct["contactNo"] = cntNum;
				 dataCntct["gnCountryCode"] = gnCnCo;
				 dataCntct["country"] = cntry;
				 dataCntct["cntctId"] = cntId;
				 contactDtlsList.push(dataCntct);
				 $('#contactNo, #country , #gnCountryCode').val('');
				 cntId='';
				 
				 //alert("data=="+JSON.stringify(contactDtlsList));
				 $("#sizeCont").text((contactDtlsList.length)-(contctDelChk.length)+' records added');
				 $(".btCont").show();
			} //end (2905)
		}
		else{
			$.confirm({
			    title: 'Alert!',
			    content: 'Please add atleast contact number',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
		}
		}
}
function dataTableUpdateContact(value,text,text2,obj){
		$("#addCntctButton").hide();
		$("#updateCntctButton").show();
		ctUpd=1;//(0206)
		if(text2!='' && text2!=null){ 	
		var chnCrId=text2.split('-');	
		cntId=chnCrId[0];}
			contactDtlsList = $.grep(
			contactDtlsList, 
			function(el, idx) {
			return el.contactNo == value;
		}, 
		true
		);
		$('#gnCountryCode').val(value);
		$("#contactNo").val(text);
		$("#country").val(text2);

		$(".contactShd").hide();//(0206)
		//$('#contact_det').modal('toggle'); 
		$("#contact_tab")
		.DataTable()
		.row($(obj).parents("tr"))
		.remove()
		.draw(false);
}

function dataTableDeleteContact(value,text,text2,obj)
{
	//alert("check=="+text2);
		if(text2!='' && text2!=null){
			var dataCntctDel = {};
			var delrcd=text2.split('-');
			dataCntctDel["cntctId"] = delrcd[0]+'-D';
			contctDelList.push(dataCntctDel);
			contctDelChk.push(dataCntctDel);
		}
		contactDtlsList = $.grep(contactDtlsList, function(el, idx) {return el.contactNo == value}, true);
	//	alert("data=="+JSON.stringify(contactDtlsList));
		$('#contact_tab').DataTable().row($(obj).parents('tr')).remove().draw(false);
		Array.prototype.push.apply(contactDtlsList,contctDelList);
		$("#sizeCont").text((contactDtlsList.length)-(contctDelChk.length)+' records added');
		contctDelList=[];
		//var len=(contactDtlsList.length)-(contctDelChk.length);
		//alert(len);
		if((contactDtlsList.length)-(contctDelChk.length)==0){
			$(".btCont").hide();
		}
		//alert("data merged=="+JSON.stringify(contactDtlsList));
} 



//below for IMEI Number 3006

var imeiDtlsList=[];
function fnClickAddImei() {
		//$('#giffy').show();
		var boolCheck=false;
		var filteredFamily = imeiDtlsList.filter(function(x) {
 		if (x.imei==$("#imei").val()) {
  			//alert("check1");
  			boolCheck=true;
 		}
		});
		if(boolCheck)
 		{
			$.confirm({
			    title: 'Alert!',
			    content: 'You have already added the same IMEI Number',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
 		}
		else{
		
		var imeiNo=$('#imei').val();
		if(imeiNo!=''){
			 if(!(/^[a-zA-Z0-9]*$/.test(imeiNo))){
					$.confirm({
					title: 'Alert!',
					content: 'IMEI should be alphanumeric only.',
				    theme: 'material',
				    type: 'orange',
				    buttons: {
				        Ok: function () {
				        	
				        }
				   
				    }
				});
			}
			else{ 
				$('#addImeiButton').show();
				$('#updateImeiButton').hide();
				$('.imeiShd').show();
				imUpd=0;
				 $('#imei_tab').dataTable().fnAddData( [
					 imeiNo,
						'<button type="button" onclick="dataTableUpdateImei(\''+imeiNo+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button>',
						'<button type="button" onclick="dataTableDeleteImei(\''+imeiNo+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
				 var dataImei = {};
				 dataImei["imei"] = imeiNo;
				 imeiDtlsList.push(dataImei);
				 
				 $('#imei').val('');
				 
				 //alert("data=="+JSON.stringify(contactDtlsList));
				 $("#sizeImei").text(imeiDtlsList.length+' records added');
				 $(".btImei").show();
			}
		}
		else{
			$.confirm({
			    title: 'Alert!',
			    content: 'Please add IMEI number',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
		}
		}
}
function dataTableUpdateImei(value,obj)
{
	$('#addImeiButton').hide();
		$('#updateImeiButton').show();
		imUpd=1;
		imeiDtlsList = $.grep(imeiDtlsList, function(el, idx) {return el.imei == value}, true)
		//alert("data=="+JSON.stringify(contactDtlsList));
		$('#imei').val(value);


		//$('#contact_det').modal('toggle'); 
		$('.imeiShd').hide();
		$('#imei_tab').DataTable().row($(obj).parents('tr')).remove().draw(false);
}

function dataTableDeleteImei(value,obj)
{
		imeiDtlsList = $.grep(imeiDtlsList, function(el, idx) {return el.imei == value}, true)
		//alert("data=="+JSON.stringify(contactDtlsList));
		$('#imei_tab').DataTable().row($(obj).parents('tr')).remove().draw(false);
		$("#sizeImei").text(imeiDtlsList.length+' records added');
		if(imeiDtlsList.length==0){
			$(".btImei").hide();
		}
} 

//end 3006 IMEI Button Functionality END




//below for boat details

var botId;	
var boatDelList=[];
var boatDelChk=[];
function fnClickAddBoat() {
		//$('#giffy').show();
		var boolCheck=false;
//below logic is to check if same name entered again
		var filteredFamily = boatDataList.filter(function(x) {
		if (x.boatName==$("#boatName").val()) {
   			// alert("check1");
   			boolCheck=true;
  		}
		});
		if(boolCheck)//if same name exists

  		{
			$.confirm({
			    title: 'Alert!',
			    content: 'You have already added the same Boat Name',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
  		}
		else{
		
		var arr_boat=[];//for making an array of String of all form values
		
		var myFormInputs = document.getElementsByClassName("boatcl") ;
		var boolBoat=true;
		var myFormData = Array.prototype.filter.call(myFormInputs, function(anElement) {
			//alert("myFormInputs=="+anElement.value);
			if(anElement.value==''){
				//anElement.value='N/A';
			}
			arr_boat.push(anElement.value);//adding all form values
		})
		botId==null || botId=='' ? botId='' : botId=botId+'-U';
		//alert("myFormInputs=="+JSON.stringify(arr_boat));
		
		var etdDate = document.getElementById("boatetd").value;
	      var etaDate = document.getElementById("boateta").value;
		  var etddatearray = etdDate.split("/");
	      var etdselectedDate = etddatearray[1] + '/' + etddatearray[0] + '/' + etddatearray[2];
		  var etadatearray = etaDate.split("/");
	      var etaselectedDate = etadatearray[1] + '/' + etadatearray[0] + '/' + etadatearray[2];
		   const date1 = Date.parse(etdselectedDate);
		   const date2 = Date.parse(etaselectedDate);  
		   
		if($('#boatName').val()!=''){//below 2905
			var botConLen=$('#ownerContDts').val()
			if(botConLen.length<10 && botConLen!=''){
				$.confirm({
				    title: 'Alert!',
				    content: 'Please enter 10 to 15 digit Owner Contact Details',
				    theme: 'material',
				    type: 'orange',
				    buttons: {
				        Ok: function () {
				        	
				        }
				   
				    }
				});
			}
			else if (date1 > date2) {
		           $.confirm({
						title: 'Alert!',
						content: 'ETA should be greater than ETD.',
					    theme: 'material',
					    type: 'orange',
					    buttons: {
					        Ok: function () {
					        	
					        }
					   
					    }
					});
		     }	
			
				else{//partial end(2905)
				//below to add values to datatable
				
				$('#addBoatButton').show();
				$('#updateBoatButton').hide();
				$('#boatEye').attr('disabled',false);
				btUpd=0;//(0206)
				var boatType;
				$('#typeOfBoat option:selected').text()=='Select'?boatType='':boatType=$('#typeOfBoat option:selected').text();
				
				 $('#boat_table').dataTable().fnAddData( [
					 						 boatType,
											 arr_boat[1],
											 arr_boat[2],
											 arr_boat[3],
											 arr_boat[4],
											 arr_boat[5],
											 arr_boat[6],
											 arr_boat[7],
											 arr_boat[8],
											 arr_boat[9],
											 arr_boat[10],
											 arr_boat[11],
											 arr_boat[12],
											 arr_boat[13],
											 arr_boat[14],
											 arr_boat[15],
											 arr_boat[16],
											 arr_boat[17],
											 arr_boat[18],
											 arr_boat[19],
					 '<button type="button" onclick="dataTableUpdateBoat(\''+arr_boat+'\',\''+botId+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button> <button type="button" onclick="dataTableDeleteBoat(\''+arr_boat[0]+'\',\''+botId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
				 var dataBoat = {};
					 console.log(JSON.stringify(arr_boat)+">>arr_boat");
				 //below for maintaining an array of object boatDataList
				 dataBoat["typeOfBoat"] = arr_boat[0];dataBoat["boatName"]=  arr_boat[1];dataBoat["regNum"] = arr_boat[2];
				 dataBoat["ownerName"] = arr_boat[3];dataBoat["stateReg"] = arr_boat[4];dataBoat["portReg"] = arr_boat[5]; dataBoat["noOfCrew"] = arr_boat[6];
				 dataBoat["docHeld"] = arr_boat[7];dataBoat["navEqpt"] = arr_boat[8];dataBoat["commEqpt"] = arr_boat[9];
				 dataBoat["lifeEqpt"] = arr_boat[10];dataBoat["boatlpc"] = arr_boat[11];dataBoat["boatetd"] = arr_boat[12];dataBoat["boatnpc"] = arr_boat[13];
				 dataBoat["boateta"] = arr_boat[14];dataBoat["licenseFish"] = arr_boat[15];dataBoat["ownerContCode"] = arr_boat[16];
				 dataBoat["ownerContDts"] = arr_boat[17];dataBoat["boatColrcd"] = arr_boat[18];dataBoat["remarks"] = arr_boat[19];
				 
				 boatDataList.push(dataBoat);
				 //below for emptying the values
				 $('#boatName, #regNum, #ownerName, #stateReg, #portReg, #noOfCrew, #docHeld, #navEqpt, #commEqpt, #lifeEqpt').val('');
				 $('#boatlpc, #boatnpc, #licenseFish, #ownerContDts, #remarks,#ownerContCode').val('');
				 $('#boatetd, #boateta').val('');
				 $('#boatetd, #boateta').datepicker('setDate', null);
				 $('#typeOfBoat,#boatColour').val('').trigger('change');
				 
				 console.log("data=="+JSON.stringify(boatDataList));
				 $("#sizeBoat").text(boatDataList.length+' records added');
				 $(".btBoat").show();//to show no of records added
			} //end 2905
		}
		else{
			$.confirm({
			    title: 'Alert!',
			    content: 'Please add atleast boat name',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
		}
		}
}

function dataTableUpdateBoat(botArr,text2,obj)
{
	btUpd=1;
	$('#addBoatButton').hide();
		$('#updateBoatButton').show();
		if(text2!='' && text2!=null){
		var chnCrId=text2.split('-');	
		botId=chnCrId[0];
		}
		$('#boatEye').attr('disabled',true);
		var botArray = botArr.split(",");
	
		boatDataList = $.grep(boatDataList, function(el, idx) {return el.boatName == botArray[1]}, true);//for deleting repeat value on the basis of name
		console.log(JSON.stringify(botArray)+ " ??botArray");
						//below for assigning values back to form
		$('#typeOfBoat').val(botArray[0]).trigger("change");
		$('#boatName').val(botArray[1]);
		$('#regNum').val(botArray[2]);
		$('#ownerName').val(botArray[3]);
		$('#stateReg').val(botArray[4]);
		$('#portReg').val(botArray[5]);
		$('#noOfCrew').val(botArray[6]);
		$('#docHeld').val(botArray[7]);
		$('#navEqpt').val(botArray[8]);
		$('#commEqpt').val(botArray[9]);
		$('#lifeEqpt').val(botArray[10]);
		$('#boatlpc').val(botArray[11]);
		$('#boatetd').val(botArray[12]);
		$('#boatnpc').val(botArray[13]);
		$('#boateta').val(botArray[14]);
		$('#licenseFish').val(botArray[15]);
		$('#ownerContCode').val(botArray[16]);
		$('#ownerContDts').val(botArray[17]);
		$('#boatColrcd').val(botArray[18]).trigger("change");
		$('#remarks').val(botArray[19]);
		$('#boat_det').modal('toggle'); 
		$('#boat_table').DataTable().row($(obj).parents('tr')).remove().draw(false);
}

function dataTableDeleteBoat(value,text2,obj)
{
	if(text2!='' && text2!=null){
		var databotDel = {};
		var delrcd=text2.split('-');
		databotDel["boatId"] = delrcd[0]+'-D';
		boatDelList.push(databotDel);
		boatDelChk.push(databotDel);
	}
		boatDataList = $.grep(boatDataList, function(el, idx) {return el.boatName == value}, true);
		// alert("data=="+JSON.stringify(boatDataList));
		$('#boat_table').DataTable().row($(obj).parents('tr')).remove().draw(false);
		Array.prototype.push.apply(boatDataList,boatDelList);
		boatDelList=[];
		$("#sizeBoat").text((boatDataList.length)-(boatDelChk.length)+' records added');
		if((boatDataList.length)-(boatDelChk.length)==0){
			$(".btBoat").hide();
			$('#boat_det').modal('toggle'); 
		}
		// alert("data merged=="+JSON.stringify(boatDataList));
} 
		
	

//below for vessel details
	
var vslId;
var vesselDelList=[];
var vesselDataList=[];
var vesselDelChk=[];
function fnClickAddVessel() {
//$('#giffy').show();
var boolCheck=false;
var filteredFamily = vesselDataList.filter(function(x) {
if (x.vesselName==$("#vesselName").val()) {
//alert("check1");
boolCheck=true;
}
});

var etdDate = document.getElementById("vesseletd").value;
var etaDate = document.getElementById("vesseleta").value;
var etddatearray = etdDate.split("/");
var etdselectedDate = etddatearray[1] + '/' + etddatearray[0] + '/' + etddatearray[2];
var etadatearray = etaDate.split("/");
var etaselectedDate = etadatearray[1] + '/' + etadatearray[0] + '/' + etadatearray[2];
 const date1 = Date.parse(etdselectedDate);
 const date2 = Date.parse(etaselectedDate);  
		if(boolCheck)
  		{
			$.confirm({
			    title: 'Alert!',
			    content: 'You have already added the same Vessel Name',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
  		}
else  if (date1 > date2) {
	   $.confirm({
		   title: 'Alert!',
		   content: 'ETA should be greater than ETD',
		   theme: 'material',
		   type: 'orange',
		   buttons: {
		   Ok: function () {

		   }

		   }
		   });
}
else{

var arr_vessel=[];

var myFormInputs = document.getElementsByClassName("vesselcl") ;
var boolVessel=true;
var myFormData = Array.prototype.filter.call(myFormInputs, function(anElement) {
//alert("myFormInputs=="+anElement.value);
if(anElement.value==''){
boolVessel=false;
}
arr_vessel.push(anElement.value);
})
vslId==null || vslId=='' ? vslId='' : vslId=vslId+'-U';
//alert("myFormInputs=="+JSON.stringify(arr_boat));

if($("#vesselName").val()!=''){

$('#addVesselButton').show();
$('#updateVesselButton').hide();
$('#vesselEye').attr('disabled',false);	
vslUpd=0;//(0206)

var vsltnm;
var pnsnm;
$('#vesselTypeName option:selected').text()=='Select'?vsltnm='':vsltnm=$('#vesselTypeName option:selected').text();
$('#pans option:selected').text()=='Select'?pnsnm='':pnsnm=$('#pans option:selected').text();


console.log(JSON.stringify(arr_vessel)+">>>arr_vessel");
 $('#vessel_table').dataTable().fnAddData( [
 arr_vessel[0],
	 vsltnm,//[1]
	 arr_vessel[2],
	 arr_vessel[3],
	 arr_vessel[4],
	 arr_vessel[5],
	 arr_vessel[6],
	 arr_vessel[7],
	 arr_vessel[8],
	 arr_vessel[9],
	 arr_vessel[10],
	 arr_vessel[11],
	 arr_vessel[12],
	 arr_vessel[13],
	 arr_vessel[14],
	 pnsnm,//[15]
	'<button type="button" onclick="dataTableUpdateVessel(\''+arr_vessel+'\',\''+vslId+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button> <button type="button" onclick="dataTableDeleteVessel(\''+arr_vessel[0]+'\',\''+vslId+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
	var dataVessel = {};
	 
		dataVessel["vesselName"] = arr_vessel[0];
		dataVessel["vesselTypeName"] = arr_vessel[1];
		dataVessel["intCallSign"] = arr_vessel[2];
		dataVessel["mmsi"] = arr_vessel[3];
		dataVessel["imoNo"] = arr_vessel[4];
		dataVessel["inmarsatNo"] = arr_vessel[5];
		dataVessel["cargo"] = arr_vessel[6];
		dataVessel["vessellpc"] = arr_vessel[7];
		dataVessel["vesseletd"] = arr_vessel[8]; 
		dataVessel["vesselnpc"] = arr_vessel[9];
		dataVessel["vesseleta"] = arr_vessel[10];
		dataVessel["totCrew"] = arr_vessel[11];
		dataVessel["flgPrtReg"] = arr_vessel[12];
		dataVessel["otherCommEqpt"] = arr_vessel[13];
		dataVessel["agent"] = arr_vessel[14];
		dataVessel["pans"] = arr_vessel[15];
		dataVessel["vesselId"] = vslId;
 		vesselDataList.push(dataVessel);

$('#vesselName, #intCallSign, #mmsi, #imoNo, #cargo, #vessellpc, #vesselnpc, #totCrew, #flgPrtReg').val('');
$('#inmarsatNo, #otherCommEqpt, #agent').val('');
$('#vesselTypeName, #pans').val('').trigger('change');
$('#vesseletd, #vesseleta').val('');
$('#vesseletd, #vesseleta').datepicker('setDate', null);
vslId='';
$("#sizeVessel").text((vesselDataList.length)-(vesselDelChk.length)+' records added');
$(".btVessel").show();

}
else{
$.confirm({
title: 'Alert!',
content: 'Please select atleast vessel name',
theme: 'material',
type: 'orange',
buttons: {
Ok: function () {
	
}

}
});
}
}
}

function dataTableUpdateVessel(vslArr,text2,obj)
{
	
	console.log(JSON.stringify(vslArr)+">>vslArr");
	vslUpd=1;
	$('#addVesselButton').hide();
		$('#updateVesselButton').show();
		if(text2!='' && text2!=null){
			var chnCrId=text2.split('-');
			vslId=chnCrId[0];
		}
		$('#vesselEye').attr('disabled',true);
		var vslArray = vslArr.split(",");
		// alert("ch=="+vslArray[1]);
		vesselDataList = $.grep(vesselDataList, function(el, idx) {return el.vesselName == vslArray[0]}, true)
		// alert("data=="+JSON.stringify(vesselDataList));
			$('#vesselName').val(vslArray[0]);
			$('#vesselTypeName').val(vslArray[1]).trigger("change");
			$('#intCallSign').val(vslArray[2]);
			$('#mmsi').val(vslArray[3]);
			$('#imoNo').val(vslArray[4]);
			$('#inmarsatNo').val(vslArray[5]);
			$('#cargo').val(vslArray[6]);
			$('#vessellpc').val(vslArray[7]);
			$('#vesseletd').val(vslArray[8]);
			$('#vesselnpc').val(vslArray[9]);
			$('#vesseleta').val(vslArray[10]);
			$('#totCrew').val(vslArray[11]);
			$('#flgPrtReg').val(vslArray[12]);
			$('#otherCommEqpt').val(vslArray[13]);
			$('#agent').val(vslArray[14]);
			$('#pans').val(vslArray[15]).trigger("change");

		$('#agent').val(vslArray[16]);$('#pans').val(vslArray[17]).trigger("change");


		$('#vess_det').modal('toggle');
		$('#vessel_table').DataTable().row($(obj).parents('tr')).remove().draw(false);
}

function dataTableDeleteVessel(value,text2,obj)
{
	if(text2!='' && text2!=null){
		var dataVesselDel = {};
		var delrcd=text2.split('-');
		dataVesselDel["vesselId"] = delrcd[0]+'-D';
		vesselDelList.push(dataVesselDel);
		vesselDelChk.push(dataVesselDel);
	}
		vesselDataList = $.grep(vesselDataList, function(el, idx) {return el.vesselName == value}, true)
		// alert("data=="+JSON.stringify(vesselDataList));
		$('#vessel_table').DataTable().row($(obj).parents('tr')).remove().draw(false);
		Array.prototype.push.apply(vesselDataList,vesselDelList);
		vesselDelList=[];
		$("#sizeVessel").text((vesselDataList.length)-(vesselDelChk.length)+' records added');
		if((vesselDataList.length)-(vesselDelChk.length)==0){
			$(".btVessel").hide();
			$('#vess_det').modal('toggle'); 
		}
		
		// alert("data merged=="+JSON.stringify(vesselDataList));
} 
		
		
//below for crew details

var crwwId;	
var crewDelList=[];
var crewDelChk=[];
var crewDataList=[];
function fnClickAddCrew() {
		//$('#giffy').show();
		
		var boolCheck=false;
		var filteredFamily = crewDataList.filter(function(x) {
		if (x.crName==$("#crName").val()) {
   			
   			boolCheck=true;
   			alert("boolCheck===" +boolCheck);
  		}
		});
		if(boolCheck)
  		{
			$.confirm({
			    title: 'Alert!',
			    content: 'You have already added the same Crew Name',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
  		}
		else{
		
		var arr_crew=[];
		
		var myFormInputs = document.getElementsByClassName("crewcl") ;
		var boolCrew=true;
		var myFormData = Array.prototype.filter.call(myFormInputs, function(anElement) {
			//alert("myFormInputs=="+anElement.value);
			if(anElement.value==''){
				boolCrew=false;
			}
			arr_crew.push(anElement.value);
		});
		
		crwwId==null || crwwId=='' ? crwwId='' : crwwId=crwwId+'-U';
		//alert("myFormInputs=="+JSON.stringify(arr_boat));
		
				if($("#crName").val()!=''){// under this added for phone number(2905)
				var crwConLen=$('#crTelNo').val();//start (2905)
				if(crwConLen.length <10 && crwConLen!=''){
					$.confirm({
					    title: 'Alert!',
					    content: 'Please enter 10 to 15 digit Telephone Number',
					    theme: 'material',
					    type: 'orange',
					    buttons: {
					        Ok: function () {
					        	
					        }
					   
					    }
					});
				}
				
				else{//partial end(2905)
					$('#addCrewButton').show();
					$('#updateCrewButton').hide();
					$('#crewEye').attr('disabled',false);
					crwUpd=0;//(0206)
					var crwmrt;
				    var crwrlg;
				    var crwIdType;
				    $('#crMartSts option:selected').text()=='Select'?crwmrt='':crwmrt=$('#crMartSts option:selected').text();
				    $('#crRelgn option:selected').text()=='Select'?crwrlg='':crwrlg=$('#crRelgn option:selected').text();
				
				    $('#crDtlsIdType option:selected').text()=='Select'?crwIdType='':crwIdType=$('#crDtlsIdType option:selected').text();
				    
				    
					 $('#crew_table').dataTable().fnAddData( [
						 arr_crew[0],arr_crew[1],arr_crew[2],arr_crew[3],arr_crew[4],
						 arr_crew[5],crwmrt,
						 /* arr_crew[6], */
						 arr_crew[7],
						 arr_crew[8],
						 crwrlg,crwIdType,arr_crew[11],
						 '<button type="button" onclick="dataTableUpdateCrew(\''+arr_crew+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button> <button type="button" onclick="dataTableDeleteCrew(\''+arr_crew[0]+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
					
					 var dataCrew = {};
					 dataCrew["crName"] = arr_crew[0];
					 dataCrew["crAge"] = arr_crew[1];
					 dataCrew["crNationality"] = arr_crew[2];
					 dataCrew["crAddress"] = arr_crew[3];
					 dataCrew["crCountCode"] = arr_crew[4];
					 dataCrew["crTelNo"] = arr_crew[5];
					 dataCrew["crMartSts"] = arr_crew[6];
					 dataCrew["crProfession"] = arr_crew[7];
					 dataCrew["crIdenMrks"] = arr_crew[8];
					 dataCrew["crRelgn"] = arr_crew[9];
					//sequence change krna hai
 
										 dataCrew["crDtlsIdType"] = arr_crew[10];
										 dataCrew["crDtlsIdPf"] = arr_crew[11];    
				 crewDataList.push(dataCrew);
				 
				$('#crName, #crAge, #crNationality, #crAddress,#crCountCode, #crTelNo, #crProfession, #crIdenMrks,#crDtlsIdPf').val('');
				 $('#crDtlsIdType').val('').trigger('change');$
				 ('#crRelgn, #crMartSts').val('').trigger('change');
				 
				 //alert("data=="+JSON.stringify(crewDataList));
				 $("#sizeCrew").text(crewDataList.length+' records added');
				 $(".btCrew").show();
				 crwwId='';
			}//complete end (2905)
		}
		else{
			$.confirm({
			    title: 'Alert!',
			    content: 'Please enter atleast crew name',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	
			        }
			   
			    }
			});
		}
		}
}

function dataTableUpdateCrew(crArr,text2,obj)
{
	$('#addCrewButton').hide();
		$('#updateCrewButton').show();
		crwUpd=1;//(0206)
	/* 	if(text2!='' && text2!=null){
			var chnCrId=text2.split('-');
			crwwId=chnCrId[0];
		} */
		$('#crewEye').attr('disabled',true);
		var crwArray = crArr.split(",");
		
		crewDataList = $.grep(crewDataList, function(el, idx) {return el.crName == crwArray[0]}, true);
		$('#crName').val(crwArray[0]);
		$('#crAge').val(crwArray[1]);
		$('#crNationality').val(crwArray[2]);
		$('#crAddress').val(crwArray[3]);
		//$('#crCountCode').val(crwArray[12]);
		$('#crCountCode').val(crwArray[4])
		$('#crTelNo').val(crwArray[5]);
		$('#crMartSts').val(crwArray[6]).trigger("change");
		$('#crProfession').val(crwArray[7]);
		$('#crIdenMrks').val(crwArray[8]);
		$('#crRelgn').val(crwArray[9]).trigger("change");
		$('#crDtlsIdType').val(crwArray[10]).trigger("change");$('#crDtlsIdPf').val(crwArray[11]);
		
		$('#crew_det').modal('toggle'); 
		$('#crew_table').DataTable().row($(obj).parents('tr')).remove().draw(false);
}

function dataTableDeleteCrew(value,text2,obj)
{
	if(text2!='' && text2!=null){
		var dataCrewDel = {};
		var delcww=text2.split('-');
		dataCrewDel["crId"] = delcww[0]+'-D';
		crewDelList.push(dataCrewDel);
		crewDelChk.push(dataCrewDel);
	}
		crewDataList = $.grep(crewDataList, function(el, idx) {return el.crName == value}, true);
		// alert("data=="+JSON.stringify(crewDataList));
		$('#crew_table').DataTable().row($(obj).parents('tr')).remove().draw(false);
		Array.prototype.push.apply(crewDataList,crewDelList);
		crewDelList=[];
		$("#sizeCrew").text((crewDataList.length)-(crewDelChk.length)+' records added');
		if((crewDataList.length)-(crewDelChk.length)==0){
			$(".btCrew").hide();
			$('#crew_det').modal('toggle'); 
		}
	
} 
		
		
//Added By rakesh kumar  update file-----------------------------------------------Start

$.fn.fileUploader = function (filesToUpload) {
    this.closest(".files").change(function (evt) {

        for (var i = 0; i < evt.target.files.length; i++) {
            filesToUpload.push(evt.target.files[i]);
        };
        var output = [];

        for (var i = 0, f; f = evt.target.files[i]; i++) {
            var removeLink = "<a class=\"removeFile\" href=\"#\" data-fileid=\"" + i + "\"><i class='fa fa-trash'></i></a>";

            output.push("<li><strong>", escape(f.name), "</strong> - ",
                f.size, " bytes. &nbsp; &nbsp; ", removeLink, "</li> ");
        }

        $(this).children(".fileList")
            .append(output.join(""));
        
        if(evt.target.files.length >0){
          	// alert("show===");
          	 $("#uploadBtn").show();
          	$(".btncout").show();
          	var count  = $("#cout").text();
          	var total = Number(count)+evt.target.files.length;
          	$("#cout").text(total);
          	 $("#hideUl").show();
           }else{
          //	alert("hide===");
           }
           
    });
};


var filesToUpload = [];

$(document).on("click",".removeFile", function(e){
     e.preventDefault();
      var fileName = $(this).parent().children("strong").text();
      // loop through the files array and check if the name of that file matches FileName
     // and get the index of the match
       for(i = 0; i < filesToUpload.length; ++ i){
            if(filesToUpload[i].name == fileName){
            //console.log("match at: " + i);
            // remove the one element at the index where we get a match
            filesToUpload.splice(i, 1);
        }	
	  }
       //console.log(filesToUpload);
        // remove the <li> element of the removed file from the page DOM
      $(this).parent().remove();
    //hide upload button 
      // var count  = $("#cout").text();
        	var total = filesToUpload.length ;
        	$("#cout").text(total);
       if(filesToUpload.length==0){
      	// alert("yes==="+filesToUpload.length);
      	 $("#uploadBtn").hide();
      	 $("#hideUl").hide();
      	 $(".btncout").hide();
       }else{
      	// alert("no==="+filesToUpload.length);
       }
       
       //hide upload end
   });
   
   $('.btncout').click(function(){
  	 
  	 $("#hideUl").toggle();
   });



    $("#files1").fileUploader(filesToUpload);
   // to takes uploaded file names
   var filesNames = [];
   // upload function
    $("#uploadBtn").click(function (e) {
    //alert("uploadTime==="+uploadTime);
        var threatFolder = "counterTerrorist" ;
        var inputId = $('#inputId').val();	
        var id = inputId.toString();
	// to get last uploaded inputId
	uploadedInputId = id ;
       	e.preventDefault();
        var data = new FormData();
        data.append('threatFolder', threatFolder);
        data.append('id', id);
        data.append('noOfFileToDel', delImage.length);
        
            //append file to delete in  FormData
             for (var j = 0; j < delImage.length; j++) {
            //	console.log("to Delete=="+delImage[j] ); 
            	data.append('filetoDel_'+j, delImage[j]);
            
               } 
         
            //append files to upload in  FormData
            for (var i = 0; i < filesToUpload.length; i++) {
            	data.append('file['+i+']', filesToUpload[i]);
               }
            
            
            if(delImage.length > 0 || filesToUpload.length >0){
            	
            	// start ajax call
            	$.ajax({
               		url:'fileUpdate',
               		data: data,
               	    cache: false,
               	    contentType: false,
               	    processData: false,
               		type:'POST',
               		success: function(response){
               			if(response.Status == 200){
               				
               		    	// to remove all selected file  	
    	           			 filesToUpload.splice(0, filesToUpload.length);
    	           		    
               		    	// to remove all selected file  
    	           			  $('.fileList').empty();
    	           		     
    	           		     //to empty uploaded file   ufile
    	           			  $('.ufile').empty();
    	           			
    	           		     var ts= "";
    	           			
    	           		     var obj = response.fileNames;

    	           			 for (i = 0; i < obj.length; i++) { 
    	           			     ts+= "<li><a   href=\"viewdoc?fileName="+obj[i]+"&inputId=${inputId}&threatFolder=otherThreat\" target=\"_blank\"> <strong class=\"t\">"+obj[i]+"</strong>  </a>"
    	           			    		+" <a  class =\"hideData\"> <i class='fa fa-trash'></i> </a></li>"
    	           			   
    	           			     }
    	           			 
    	           		 $(".ufile").append(ts);  
    	           		 $('.fileList').empty();
    	           		
    	           		 delImage.length = 0 ;  //to make empty after delete the fie
               			
    	           		var total = 0 ;
	           			$("#cout").text(total);
				    	 $("#uploadBtn").hide();
				    	 $("#hideUl").hide();
				    	 $(".btncout").hide();
    	           			$.confirm({
    						    title: 'Alert!',
    						    content: 'File updated Successfully!',
    						    theme: 'material',
    						    type: 'orange',
    						    buttons: {
    						        Ok: function () {
    						        	
    						        }
    						   
    						    }
    						});
               			}else{
               				//alert('Error');
               			}
               		}// End of Success Function
            	
            	
               	
		});             //end of ajax call
            	
            }else{
	            	$.confirm({
					    title: 'Alert!',
					    content: 'NO file upload  or update !',
					    theme: 'material',
					    type: 'orange',
					    buttons: {
					        Ok: function () {
					        	
					        }
					   
					    }
					});
	}	            

            
   	
    });

/* 		
	}//end of else
}); */
//Remove from Already updated file
 $(document).on("click", "a.hideData" , function() {
    	  var filetodel = $(this).parent().find("strong.t").text() ;
		    //alert("filetodel==="+filetodel);
		    delImage.push(filetodel);
		    $(this).parent().hide();
		    $("#uploadBtn").show();
       }); 

	//code Added by rakesh--------------------------------------------------------------------------End 	

//below for final submit button

function submitThreatDetails(){
	
	$('#threatTypeName').prop("disabled", false);
	var data = {};
	data["threatId"]=threatId;
	data["threatTypeName"]=$('#threatTypeName').val();
	data["inputId"]=$('#inputId').val();
	data["dateRecpt"]=$('#dateRecpt').val();
	data["origntrName"]=$('#origntrName').val();
	data["origntrOther"]=$('#origntrOther').val();//added last
	data["timeOfPos"]=$('#timeOfPos').val();
	data["timeOfActivation"]=$('#timeOfActivation').val();
	data["gradingName"]=$('#gradingName').val();
	data["gpslattitudeDec"]=$('#gpslattitudeDec').val();
	data["gpslongitudeDec"]=$('#gpslongitudeDec').val();
	data["gpslattitudeDeg"]=$('#gpslattitudeDeg').val();
	data["gpslongitudeDeg"]=$('#gpslongitudeDeg').val();
	data["distanceKmLnd"]=$('#distanceKmLnd').val();
	data["distanceMileLnd"]=$('#distanceMileLnd').val();
	data["fromWhere"]=$('#fromWhere').val();//(0406)
	data["location"]=$('#location').val();
	data["regionName"]=$('#regionName').val();
	data["coastStatName"]=$('#coastStatName').val();
	data["imeiList"]=imeiDtlsList;//3006
	data["contactList"]=contactDtlsList;
	data["nameSuspects"]=$('#nameSuspects').val();
	data["sharedWithName"]=$('#sharedWithName').val();    
 	data["sharedWithOther"]=$('#sharedWithOther').val();//added last
	data["boatList"]=boatDataList;
	data["vesselList"]=vesselDataList;
	data["crewList"]=crewDataList;
	data["otherInfo"]=$('#otherInfo').val();
	data["followUp"]=$('#followUp').val();
	data["otherUnit"]=$('#otherUnit').val();
	/* 
	console.log(JSON.stringify(data) +"Data"); */

 $.ajax({
		url : 'updateOther',
		contentType: "application/json",
		type : 'post',
		beforeSend : function() {
			$('#giffy').show();
		},
		complete : function() {
			$('#giffy').hide();
		},
		data: JSON.stringify(data),
		success : function(response)
        { 
			if(response=='Success'){
				window.location.href="successPage";
			}
			else{
				window.location.href="errorSubmission";
				
			}
        }
         
     }); 
}
		
/* Radio boat vessel */


$('input[name="boat_vessel_det"]').click(function(){
		var inputValue = $(this).attr("value");
		//alert("check=="+vesselDataList.length);
		if(inputValue==="boat_opt" && (vesselDataList.length)-(vesselDelChk.length)==0){
			//alert("check bbbb");
			$('.input_bt_area').show();
			$('.input_vs_area').hide();
		} 
		else if(inputValue==="boat_opt" && (vesselDataList.length)-(vesselDelChk.length)>0){
			//alert("in boat change with vesselDataList");
			$.confirm({
			    title: 'Alert!',
			    content: 'Please remove Vessel Data to add Boat data',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	$('.input_bt_area').hide();
						$('.input_vs_area').show();
						$('#boattype').prop('checked', false);
						$('#vesseltype').prop('checked', true);
			        }
			   
			    }
			});
		}
		else if(inputValue==="vessel_opt" && (boatDataList.length)-(boatDelChk.length)>0){
			//alert("in vessel change with boatDataList");
				$.confirm({
			    title: 'Alert!',
			    content: 'Please remove Boat Data to add Vessel data',
			    theme: 'material',
			    type: 'orange',
			    buttons: {
			        Ok: function () {
			        	$('.input_vs_area').hide();
						$('.input_bt_area').show();
						$('#vesseltype').prop('checked', false);
						$('#boattype').prop('checked', true);
			        }
			   
			    }
			});
			
		}
		
		else if(inputValue==="vessel_opt" && (boatDataList.length)-(boatDelChk.length)==0){
			//alert("check");
			$('.input_bt_area').hide();
			$('.input_vs_area').show();
		}

		});
//below for others in originator and shared with

$('#sharedWithName').change(function(){
	var sharedother = $('#sharedWithName').val();
    if(this.value == '0008' || sharedother.includes("0008")){
		$('.shrdWithOtherCl').show();
	}
	else{
		$('#sharedWithOther').val('');
		$('.shrdWithOtherCl').hide();
	}
});


$('#origntrName').change(function(){
	//if($('#origntrName option:selected').text()=='Others'){
		if(this.value == "0010"){
		$('.orgnOtherCl').show();
	}
	else{
		$('#origntrOther').val('');
		$('.orgnOtherCl').hide();
	}
});


$('#icgUnitsName').change(function(){
	var othersUnit = $('#icgUnitsName').val();
	if(othersUnit.includes("000876")){
		$('.otherUnitInvolved').show();
	}
	else{
		$('#otherUnit').val('');
		$('.otherUnitInvolved').hide();
	} 
}); 

//below for kms to mile and mile to kms

$('#distanceKmLnd').keyup(function(){
	var km=Number($('#distanceKmLnd').val())/1.852;
	var lockm=Number($('#distanceKmLnd').val());
	$('#distanceMileLnd').val(km.toFixed(2));
	if(lockm<23){
		$('#location').val("Within territorial waters");
	}
	else if(lockm>=23 && lockm<370){
		$('#location').val("Within EEZ");
	}
	else if(lockm>=370){
		$('#location').val("Out Of EEZ");
	}
	
	if($('#distanceKmLnd').val()==''){
		$('#distanceMileLnd').val('');
		$('#location').val("");
	}
});
$('#distanceMileLnd').keyup(function(){

	var mk=Number($('#distanceMileLnd').val())*1.852;
	$('#distanceKmLnd').val(mk.toFixed(2));
	var lockm=Number($('#distanceKmLnd').val());
	if(lockm<23){
		$('#location').val("Within territorial waters");
	}
	else if(lockm>=23 && lockm<370){
		$('#location').val("Within EEZ");
	}
	else if(lockm>=370){
		$('#location').val("Out Of EEZ");
	}
	
	if($('#distanceMileLnd').val()==''){
		$('#distanceKmLnd').val('');
		$('#location').val("");
	}
});
</script>

<script>
        
// below for decimal to degree, min, sec conversion
        
$('#gpslattitudeDec').keyup(function(){
        	var dd=$('#gpslattitudeDec').val();
        	var deg = dd | 0; // truncate dd to get degrees
            var frac = Math.abs(dd - deg); // get fractional part
            var min = (frac * 60) | 0; // multiply fraction by 60 and truncate
            var sec = frac * 3600 - min * 60;
            var show=deg + "\u00B0" + min + " ' " + sec.toFixed(2) + " '' " ;
            if(dd==''){
            	 $('#gpslattitudeDeg').val('');
            }
            else{
            	 $('#gpslattitudeDeg').val(show);
            }
           
        })
        
 $('#gpslongitudeDec').keyup(function(){
        	var dd=$('#gpslongitudeDec').val();
        	var deg = dd | 0; // truncate dd to get degrees
            var frac = Math.abs(dd - deg); // get fractional part
            var min = (frac * 60) | 0; // multiply fraction by 60 and truncate
            var sec = frac * 3600 - min * 60;
            var show=deg + "\u00B0" + min + " ' " + sec.toFixed(2) + " '' " ;
            if(dd==''){
            	 $('#gpslongitudeDeg').val('');
            }
            else{
            	 $('#gpslongitudeDeg').val(show);
            }
           
        })
        
        
 $('#applattitudeDec').keyup(function(){
        	var dd=$('#applattitudeDec').val();
        	var deg = dd | 0; // truncate dd to get degrees
            var frac = Math.abs(dd - deg); // get fractional part
            var min = (frac * 60) | 0; // multiply fraction by 60 and truncate
            var sec = frac * 3600 - min * 60;
            var show=deg + "\u00B0" + min + " ' " + sec.toFixed(2) + " '' " ;
            if(dd==''){
            	 $('#applattitudeDeg').val('');
            }
            else{
            	 $('#applattitudeDeg').val(show);
            }
           
        })
        
 $('#applongitudeDec').keyup(function(){
        	var dd=$('#applongitudeDec').val();
        	var deg = dd | 0; // truncate dd to get degrees
            var frac = Math.abs(dd - deg); // get fractional part
            var min = (frac * 60) | 0; // multiply fraction by 60 and truncate
            var sec = frac * 3600 - min * 60;
            var show=deg + "\u00B0" + min + " ' " + sec.toFixed(2) + " '' " ;
            if(dd==''){
            	 $('#applongitudeDeg').val('');
            }
            else{
            	 $('#applongitudeDeg').val(show);
            }
           
        })
        
        
</script>



<script type="text/javascript">

//gncheck functions--------------------
function gncheck(){ 
	var date = document.getElementById("dateRecpt").value;
		var datearray = date.split("/");
		    var selectedDate = datearray[1] + '/' + datearray[0] + '/' + datearray[2];
		        const receiptDate = Date.parse(selectedDate);
			    var d = new Date();
			        var month = d.getMonth() + 1;
				    var day = d.getDate();
				        var currentDate =
					      (("" + month).length < 2 ? "0" : "") +
					            month + "/" + (("" + day).length < 2 ? "0" : "") + day + "/" + d.getFullYear();
						        var Hours = d.getHours();
							    var Min = d.getMinutes();
    var seconds = d.getSeconds();
    const datetime = currentDate + " " + Hours + ":" + Min + ":" + seconds;
    const currentdatetime = Date.parse(datetime);
    
    var sharedother = $('#sharedWithName').val();
	if($('#threatTypeName').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please select Threat Type');
		callCheck();
	}
	else if($('#inputId').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please enter Input Id');
		callCheck();
	} 
	else if(receiptDate == "" || receiptDate >= currentdatetime){
		$('#msgg').show();
		$('#addMessage').text('Receipt date should not be future date');
		callCheck();
		}
	else if($('#origntrName').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please select Originator');
		callCheck();
	}
	else if($('#origntrName option:selected').text()=='Others' && $('#origntrOther').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please enter Other Originator as you have selected Others');
		callCheck();
	}
	else if($('#regionName').val()!='' && $('#coastStatName').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please select coastal state also as you have selected region');
		callCheck();
	}
	else if($('#sharedWithName option:selected').text()=='Others' || sharedother.includes("0008") && $('#sharedWithOther').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please enter Other Shared With as you have selected Others');
		callCheck();
	}

	 else if(ctUpd==1){
		$('#msgg').show();
		$('#addMessage').text(' You have unsaved changes in contact details, please click on update buttoninside Add Details');//3006
		callCheck();
	} 
 	else if(imUpd==1){//(3006) start
		$('#msgg').show();
		$('#addMessage').text(' You have unsaved changes in IMEI details, please click on update button inside Add IMEI');
		callCheck();
	} 
	else{
		return true;
	 }
}
//end 2905
function gncheck2(){
		return true;
}
// for Boat/Vessel
function gncheck3(){
	
	if(btUpd==1 || vslUpd==1){//(0206) start
		$('#msgg').show();
		$('#addMessage').text(' You have unsaved changes in boat/vessel details, please click on update button');
		callCheck();
	}//end
	else{
		return true;
	 }
	
}
// for crew 
function gncheck4(){
	
	if(crwUpd==1){//(0206) start
		$('#msgg').show();
		$('#addMessage').text(' You have unsaved changes in Crew Details, please click on update button');
		callCheck();
	}//end
	else{
		return true;
	 } 
	
	}

function gncheck5(){
	
		return true;
}

function callCheck(){
	 setTimeout(function() {					
	        $('.msg-sh').fadeOut(2000);
	      
	       
	    },2000);
}
/* function gncheck6(){
	
	if(amtUpd==1){ //(0206) start
		$('#msgg').show();
		$('#addMessage').text(' You have unsaved changes in Ammunition details, please click on update button');
		callCheck();
	}//end
	else{
		return true;
	 }
} */



//changes can be made:
	
	//below for only numbers
	$(".allownumericwithoutdecimal").on("keypress keyup blur",function (event) {    
           $(this).val($(this).val().replace(/[^\d].+/, ""));
            if ((event.which < 48 || event.which > 57)) {
                event.preventDefault();
            }
        });
	//below for only float
	$('.allow-float').keypress(function(event) {
		
	        if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
	            event.preventDefault();
	        }
	        

		});
	//below for only characters (2905)
    $('.allowOnlyText').keydown(function (e) {
          if (e.shiftKey || e.ctrlKey || e.altKey) {
              e.preventDefault();
          } else {
              var key = e.keyCode;
              if (!((key == 8) || (key == 32) || (key == 46) || (key >= 35 && key <= 40) || (key >= 65 && key <= 90))) {
                  e.preventDefault();
              }
          }
      });
	
	//end (2905)

    //below for input id check  
    
    $('#inputId').focusout(function(){
    	var param=$('#inputId').val();
    	//alert("check");
    	$.ajax({
			url : 'getCheckInput?=' + param,
			type : 'get',
			data : {
				param : param
			},
			success : function(response) {
				//alert(" response :: "+response);
				if(response=='F'){
					$.confirm({
					    title: 'Alert!',
					    content: 'Same Input Id already exists!',
					    theme: 'material',
					    type: 'orange',
					    buttons: {
					        Ok: function () {
					        	
					        }
					   
					    }
					});
					$('#inputId').val('');
				}
				
				
			},
			complete: function(){
				//$('#giffy').hide();
			}
			
		});
    	
    });
    
    
    //below for region name to coastal state dependency
    
    
    $('#regionName').change(function(){
    	var param=$(this).val();
	if(param!='' && param!=null){
    	$.ajax({
			url : 'getList?=' + param,
			type : 'get',
			data : {
				param : param
			},
			success : function(response) {
				//alert(" response :: "+response)
				var len = response.length;
				var html = '<option value="">Select</option>';
				$('#coastStatName').empty();
				//alert("res=="+response);
				 for(i in response){
		                //alert("val=="+response[i].name);
		                 html +="<option value =\""+response[i].id+"\">"+response[i].name+"</option>"; 
		            }
				html += '</option>';
				$('#coastStatName').html("");
				$('#coastStatName').html(html);
				
			},
			complete: function(){
				//$('#giffy').hide();
			}
		});
    	}
    });
    
    
//below for alert notfication
    
    function alertCheckBox(){
    	$.confirm({
		    title: 'Alert!',
		    content: 'Are you sure you want to submit?',
		    theme: 'material',
		    type: 'orange',
		    buttons: {
		        Yes: function () {
		        	submitThreatDetails();
		        },
		        
		        Cancel: function(){
		        	
		        }
		   
		    }
		});
    }
    
  //below for submit threat check
    function threatCheckDetails(){
    	$('#alert_table').DataTable().destroy();
		$('#alert_table tbody').empty();
    	var data = {}

    	data["thrtgpsLat"]=$('#gpslattitudeDec').val();
    	data["thrtgpsLong"]=$('#gpslongitudeDec').val();
    	data["imeiList"]=imeiDtlsList;//0107
    	data["thrtimeiNo"]=$('#imeiNo').val();
    	data["contactList"]=contactDtlsList;
    	data["thrtSusNam"]=$('#nameSuspects').val();
    	data["boatList"]=boatDataList;
    	data["vesselList"]=vesselDataList;//(0306)
    	
    	console.log(JSON.stringify(data) + " >>data");
    	
    	if(delImage.length > 0 || filesToUpload.length >0){  
  		  
  		  $.confirm({
  			    title: 'Alert!',
  			    content: 'Please Upload the selected file',
  			    theme: 'material',
  			    type: 'orange',
  			    buttons: {
  			        Ok: function () {
  			        	
  			        }
  			   
  			    }
  			});
  	  }else{ 
     $.ajax({
    		url : 'threatAlert',
    		contentType: "application/json",
    		type : 'post',
    		data: JSON.stringify(data),
    		beforeSend : function() {
				$('#giffy').show();
			},
			complete : function() {
				$('#giffy').hide();
			},
    		success : function(response)
            { 
    			//var dataobj = JSON.parse(response);
    			$("#alert_det").modal("show");
    			viewDetailDataTableView(response);
            }
             
         }); 
  	  }//../02062020
    }

    //below for displaying threat check grid values

    function viewDetailDataTableView(dataobj) {
    		$("#alert_table").dataTable().fnDestroy();
    		if (dataobj == "") {
    			$('#alert_table').DataTable({
    				dom : 'Bfrtip',
    				"bSort":false,
    				"ordering" : false,
    				buttons : []

    			});

    		} else {
    			$('#alert_table')
    					.DataTable(
    							{
    								dom : 'Bfrtip',
    								buttons : [],
    								"bSortable" : false,
    								"ordering" : false,
    								buttons : [
										{
											extend : 'excelHtml5',
											title : 'Threat Alert',
											exportOptions : {
												columns : [ 0,1, 2, 3, 4, 5, 6,
														7, 8, 9,10 ]
											},
											autoPrint : false
											},
										{
												extend : 'pdfHtml5',
											customize : function(doc) {
												doc.content[1].margin = [ 10,
														0, 80, 0 ]; //left, top, right, bottom
												doc.styles.tableBodyEven.alignment = 'center';
												doc.styles.tableBodyOdd.alignment = 'center';
											},
											title : 'Threat Alert',
											exportOptions : {
												columns : [0, 1, 2, 3, 4, 5, 6,
														7, 8, 9,10]
											},
											orientation : 'landscape',
											pageSize : 'LEGAL',
											autoPrint : false,
										} ],
    								data : dataobj,
    								columns : [
    //inputId,typeOfThreat,originator,latitute,longitute,imeiNo,countryOfContactedNo,distanceFromLand,location,region,nameOfSuspect					 
    										{
    											data : 'recInptId',

    										},
    										{
    											data : 'recThrtTyp',

    										},
    										{
    											data : 'recOrgntr',

    										},
    										{
    											data : 'recgpsLong',

    										},
    										{
    								
    											data :	'recgpsLat',

    										},
    										{
    											data : 'recimeiNo',

    										},{
    											data : 'recCntry',

    										},{
    											data : 'recDstncKm',

    										},{
    											data : 'recLoc',

    										},
    										{
    											data : 'recReg',

    										},{
    											data : 'recSuspctNm',

    										},

    								]
    							});//close datatable
    		}//close else

    	}//close viewDetailDataTable

</script>
