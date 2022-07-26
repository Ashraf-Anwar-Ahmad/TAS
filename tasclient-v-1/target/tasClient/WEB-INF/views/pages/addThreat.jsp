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
										title="Details" disabled="disabled">Other Information</button>
									<!--   <button class="multisteps-form__progress-btn" type="button" title="Details" disabled="disabled">Details</button> -->
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
														<!-- <label>Input Id<span class="mandatory-field">*</span></label>
							<input type="text" class="form-control allownumericwithoutdecimal" name="inputId" id="inputId" /> -->
														<label>Input Id</label> <input type="text"
															class="form-control allownumericwithoutdecimal"
															name="inputId" id="inputId"/>
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
														<label>Location</label> <select
															class="form-control select2" name="location"
															id="location">
															<!-- (0406) -->
															<option value="">Select</option>
															<c:forEach items="${locList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
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
														<!-- <label>IMEI No.</label>
						<input type="text" class="form-control allownumericwithoutdecimal" name="imeiNo" id="imeiNo" maxlength="12"/> -->
														<label>IMEI No.</label> <input type="text"
															class="form-control " name="imeiNo" id="imeiNo"
															maxlength="20" />
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
														<label>Name of Suspects</label> <input type="text"
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
															<c:forEach items="${shrdwtList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="col-md-3 shrdWithOtherCl" style="display: none;">
													<div class="form-group">
														<label>Other Originator</label> <input type="text"
															class="form-control" name="sharedWithOther"
															id="sharedWithOther" />
													</div>
												</div>

											</div>







											<div class="button-row d-flex mt-4">
												<button class="btn btn-primary2 ml-auto js-btn-next"
													type="button" title="Next">Next</button>
											</div>
										</div>
									</div>
									<!--single form panel-->
									<div class="multisteps-form__panel shadow p-4 rounded bg-white"
										data-animation="scaleIn">
										<h3 class="multisteps-form__title">Contraband Smuggling
											Details</h3>
										<div class="multisteps-form__content">

											<!--Narcotics Smuggling details form strat-->

											<div class="row">



												<div class="col-md-3">
													<div class="form-group">
														<label>Icg Units Involved</label> <select
															class="form-control select2" name="icgUnitsName"
															id="icgUnitsName" multiple>
															<option value="">Select</option>
															<c:forEach items="${unitList}" var="ListItem">
																<option value="${ListItem.id}">${ListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Type of Contraband Seized</label> <input
															type="text" class="form-control" name="typeOfContra"
															id="typeOfContra" />
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Quantity(In Number)</label>
														<!-- 2905, add (In Number) -->
														<input type="number" class="form-control"
															onkeydown="return true" name="quantity" id="quantity"
															min="0" step="any" />
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Units</label>
														<!--	<input type="text" class="form-control allownumericwithoutdecimal" name="weight" id="weight" /> -->
														<select class="form-control select2 vesselcl"
															name="weight" id="weight">
															<option value="">Select</option>
															<c:forEach items="${weightUnitList}" var="weightListItem">
															<option value="${weightListItem.id}">${weightListItem.name}</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-3">
													<div class="form-group">
														<label>Value</label> <input type="text"
															class="form-control" name="worth" id="worth" />
													</div>
												</div>


												<div class="col-md-3">
													<div class="form-group">
														<label>Case handed over to</label> <input type="text"
															class="form-control" name="caseHandedTo"
															id="caseHandedTo" />
													</div>
												</div>

												<div class="col-md-3">
													<div class="form-group">
														<label>Joint operation with</label>
														<!-- 2905, spelling change -->
														<input type="text" class="form-control"
															name="jointOperWith" id="jointOperWith" />
													</div>
												</div>


											</div>
											<div class="row">
												<div class="col-12 col-md-6">
													<div class="inner_legd">
														<fieldset class="scheduler-border">
															<legend class="scheduler-border">Position of
																Apprehension</legend>
															<!-- 2905, remove : -->
															<div class="row">
																<div class="col-md-6">
																	<div class="form-group">
																		<label>Latitude <small>(Decimal
																				Degrees)</small></label> <input type="text"
																			class="form-control allow-float"
																			name="applattitudeDec" id="applattitudeDec" />
																	</div>
																	<div class="form-group">
																		<label>Latitude <small>(Deg, Min, Sec)</small></label>
																		<input type="text" class="form-control"
																			name="applattitudeDeg" id="applattitudeDeg" readonly
																			style="background-color: #ffff" />
																	</div>

																</div>

																<div class="col-md-6 mpdw">
																	<div class="form-group">
																		<label>Longitude <small>(Decimal
																				Degrees)</small></label> <input type="text"
																			class="form-control allow-float"
																			name="applongitudeDec" id="applongitudeDec" />
																	</div>
																	<div class="form-group">
																		<label>Longitude <small>(Deg, Min,
																				Sec)</small></label> <input type="text" class="form-control"
																			name="applongitudeDeg" id="applongitudeDeg" readonly
																			style="background-color: #ffff" />
																	</div>

																</div>
																<div class="col-md-12">
																	<!--1006 -->
																	<button type="button" id="mapv"
																		onClick="viewMapSecTapVal()" class="btn btn-mp-view">
																		<i class="fa  fa-map-marker"></i> View Map
																	</button>
																</div>
																<!--1006 -->

															</div>
														</fieldset>


													</div>
												</div>

											</div>

											<!--boats/vessels details form start-->

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


												</div>

												<div class="row">

													<div class="col-md-3">
														<div class="form-group">
															<label>Port of Reg.</label> <input type="text"
																class="form-control boatcl" name="portReg" id="portReg"
																disabled />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>Number of Crew</label> <input type="number"
																class="form-control boatcl" onkeydown="return false"
																name="noOfCrew" id="noOfCrew" min="1" />
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


												</div>
												<div class="row">

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
															<label>License for Fishing</label> <input type="text"
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


												</div>
												<div class="row">

													<div class="col-md-3">
														<div class="form-group">
															<label>Owner Contact Details</label> <input type="text"
																class="form-control boatcl allownumericwithoutdecimal"
																name="ownerContDts" id="ownerContDts" maxlength="15" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Boat Confirming to Colour Code</label>
															<!--   <input
																type="text" class="form-control boatcl"
																name="boatColrcd" id="boatColrcd" />-->
																<select class="form-control select2 vesselcl"
															name="boatColour" id="boatColour">
															<option value="">Select</option>
															<option value="yes">Yes</option>
															<option value="yes">No</option>
														</select>
														</div>
													</div>

													<div class="col-md-4">
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

												</div>

												<div class="row">
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

												</div>

												<div class="row">

													<div class="col-md-3">
														<div class="form-group">
															<label>IMO No.</label> <input type="text"
																class="form-control vesselcl" name="imoNo" id="imoNo" />
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


												</div>
												<div class="row">
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
																class="form-control vesselcl" onkeydown="return false;"
																name="totCrew" id="totCrew" min="1" />
														</div>
													</div>

													<div class="col-md-3">
														<div class="form-group">
															<label>Flag or Port of Reg.</label> <input type="text"
																class="form-control vesselcl" name="flgPrtReg"
																id="flgPrtReg" />
														</div>
													</div>

												</div>
												<div class="row">

													<div class="col-md-3">
														<div class="form-group">
															<label>Inmarsat No.</label> <input type="text"
																class="form-control vesselcl" name="inmarsatNo"
																id="inmarsatNo" />
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label>Other Comm. Eqpt.</label> <input type="text"
																class="form-control vesselcl" name="otherCommEqpt"
																id="otherCommEqpt" />
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
					<div class="col-md-4">
						<label style="font-weight: 600;">Contacted Number</label> <input
							type="text" class="form-control allownumericwithoutdecimal"
							id="contactNo" name="contactNo" maxlength="10">
					</div>
					<div class="col-md-4">
						<label style="font-weight: 600;">Country</label> <input
							type="text" class="form-control" id="country" name="country">
					</div>
					<div class="col-md-4">
						<div class="form-group mt-4">
							<button type="button" id="addCntctButton"
								onclick="fnClickAddContact()" class="btn btn-primary">Add</button>
							<button type="button" style="display: none;"
								id="updateCntctButton" onclick="fnClickAddContact()"
								class="btn btn-primary">Update</button>
						</div>

					</div>
				</div>


				<div class="table-responsive-lg table-responsive-md">
					<table id="contact_tab" class="table  table-bordered">
						<thead class="thead-dark">
							<tr class="info tb-hd">
								<th>Contacted Number</th>
								<th>Country</th>
								<th class="btntd">Edit</th>
								<th class="btntd">Delete</th>

							</tr>
						</thead>

					</table>
				</div>
			</div>

		</div>
	</div>
</div>

<script type="text/javascript">
  
$(function () { 

			$('#contact_tab').DataTable({
				dom: 'Bfrtip',
				bSort: false,
				buttons: [
					 
				]
			} );



// Date Time Picker Js

$('#dateRecpt, #timeOfPos, #timeOfActivation, #boateta, #boatetd, #vesseleta, #vesseletd').datetimepicker({
	ignoreReadonly: true,
	widgetPositioning:{
        horizontal: 'auto',
        vertical: 'bottom',
        startDate:  boateta
        
    },
               
				  format: 'DD/MM/YYYY HH:mm:ss',
				  useCurrent: false
				  
				 
	});
				 
});
		
</script>


<script>
	
	//below for contacted details
	
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
			alert("repeat contact value");
  		}
		else{
		$('#addCntctButton').show();
		$('#updateCntctButton').hide();
		var cntNum=$('#contactNo').val();
		var cntry=$('#country').val();
		if(cntNum!='' || cntry!=''){
				 $('#contact_tab').dataTable().fnAddData( [
					 cntNum,
					 cntry,
						'<button type="button" onclick="dataTableUpdateContact(\''+cntNum+'\',\''+cntry+'\',this)" class="btn btn-blue btn-sm1"><i class="fa fa-edit"></i></button>',
						'<button type="button" onclick="dataTableDeleteContact(\''+cntNum+'\',\''+cntry+'\',this)" class="btn btn-danger btn-sm1"><i class="fa fa-remove"></i></button>'] );
				 var dataCntct = {};
				 dataCntct["contactNo"] = cntNum;
				 dataCntct["country"] = cntry;
				 contactDtlsList.push(dataCntct);
				 
				 $('#contactNo, #country').val('');
				 
				 //alert("data=="+JSON.stringify(contactDtlsList));
				 $("#sizeCont").text(contactDtlsList.length+' records added');
				 $(".btCont").show();
				 
		}
		else{
			alert("please select atleast one field");
		}
		}
}

function dataTableUpdateContact(value,text,obj)
{
	$('#addCntctButton').hide();
		$('#updateCntctButton').show();
		contactDtlsList = $.grep(contactDtlsList, function(el, idx) {return el.contactNo == value}, true)
		//alert("data=="+JSON.stringify(contactDtlsList));
		$('#contactNo').val(value);
		$('#country').val(text);


		//$('#contact_det').modal('toggle'); 
		$('#contact_tab').DataTable().row($(obj).parents('tr')).remove().draw(false);
}

function dataTableDeleteContact(value,text,obj)
{
		contactDtlsList = $.grep(contactDtlsList, function(el, idx) {return el.contactNo == value}, true)
		//alert("data=="+JSON.stringify(contactDtlsList));
		$('#contact_tab').DataTable().row($(obj).parents('tr')).remove().draw(false);
		$("#sizeCont").text(contactDtlsList.length+' records added');
		if(contactDtlsList.length==0){
			$(".btCont").hide();
		}
} 





		
//below for others in originator and shared with

$('#sharedWithName').change(function(){
	//if($('#sharedWithName option:selected').text()=='Others'){
		if(this.value == '0008'){
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

function gncheck(){
	var imcheck=$('#imeiNo').val();
	
	if($('#threatTypeName').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please select Threat Type');
		callCheck();
	}/* 
	else if($('#inputId').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please enter Input Id');
		callCheck();
	} */
	else if($('#dateRecpt').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please provide Date of Receipt');
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
	else if($('#sharedWithName option:selected').text()=='Others' && $('#sharedWithOther').val()==''){
		$('#msgg').show();
		$('#addMessage').text(' Please enter Other Shared With as you have selected Others');
		callCheck();
	}
	else if(imcheck.length!=12 && imcheck!=''){
		$('#msgg').show();
		$('#addMessage').text(' Please enter 12 digit IMEI Number');
		callCheck();
	}
	else{
		return true;
	 }
}

function gncheck2(){
	
		return true;
	
}

function gncheck3(){
	
		return true;
	
}

function gncheck4(){
	
		return true;
}

function gncheck5(){
	
		return true;
}

function callCheck(){
	 setTimeout(function() {					
	        $('.msg-sh').fadeOut(2000);
	      
	       
	    },2000);
}


//changes can be made:
	
	//below for only numbers
	$(".allownumericwithoutdecimal").on("keypress keyup blur",function (event) {    
           $(this).val($(this).val().replace(/[^\d].+/, ""));
            if ((event.which < 48 || event.which > 57)) {
                event.preventDefault();
            }
        });
        
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
	
    //below for input id check  
    
$('#inputId').focusout(function(){
    	var param=$('#inputId').val();
    	//alert("check=="+param);
    	$.ajax({
			url : 'getCheckInput?=' + param,
			type : 'get',
			data : {
				param : param
			},
			beforeSend : function() {
				$('#giffy').show();
			},
			complete : function() {
				$('#giffy').hide();
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
				
				
			}
		});
    	
    	
    });
    
    //below for region name to coastal state dependency
    
    
    $('#regionName').change(function(){
    	var param=$(this).val();
    	$.ajax({
			url : 'getList?=' + param,
			type : 'get',
			data : {
				param : param
			},
			beforeSend : function() {
				$('#giffy').show();
			},
			complete : function() {
				$('#giffy').hide();
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
				
			}
		});
    })
    
    
    //BELOW TEST
    $("#threatTypeName").on("select2:select", function(ev) {
			var val=$(this).val();
	        	if(val==='0001'){
	        		window.location.href="satelliteInterception?id="+val;
	        	}
	        	else if(val==='0002'){
	        		window.location.href="counterTerrorism?id="+val;
	        	}
	        	else if(val==='0003'){
	        		window.location.href="narcotics?id="+val;
	        	}
	        	else if(val==='0004'){
	        		window.location.href="contrabandSmuggle?id="+val;
	        	}
	        	else if(val==='0005'){
	        		window.location.href="humanTrafficking?id="+val;
	        	}
	        	else if(val==='0006'){
	        		window.location.href="others?id="+val;
	        	}
	        
	   
	    });
    
    
    
</script>