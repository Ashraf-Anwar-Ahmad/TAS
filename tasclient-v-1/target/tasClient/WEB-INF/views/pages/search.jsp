<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
      <!-- Jsp Page Start --->
      <script src="static/js/validation/mapDataValidation.js"></script>
      <style>
        .hide {
          display: none;
        }
      </style>
      <div class="main_body">
        <div class="gif" id="giffy" style="display: none">
          <img alt="" src="static/img/preloader.gif" />
        </div>
        <div class="container-fluid">
          <div class="conent_wrapper">
            <div class="top_head_area">
              <div class="eqdiv">
                <div class="page_head">
                  <h2>Search Threat</h2>
                </div>
              </div>
              <!-- Message Area --->
              <div class="eqdiv">
                <span style="display: none" class="alert alert-success"><i class="fa fa-check-circle"></i> Data
                  Submitted
                  Successfully</span>
                <span style="display: none" class="alert alert-error"><i class="fa fa-close"></i> Data Not
                  Submitted</span>
                <span style="display: none" class="alert alert-warning"><i class="fa fa-info-circle"></i>Total Post Not
                  exceed</span>
              </div>
              <!-- Message Area End--->
            </div>

            <!-- Head Accrd area start -->
            <div class="hdr_acd">
              <p id="add_deta_area" class="grid_lab_act" onclick="hideViewArea();">
                <span><i class="fa fa-chevron-right"></i></span> Input Detail
              </p>
            </div>
            <!-- Head Accrd area End -->

            <div class="main_content" id="form_area">
              <div class="cont_box">
                <div class="row">
                  <div class="col-md-3">
                    <div class="form-group">
                      <label>Type of Threat</label>
                      <select class="form-control select2" name="threatTypeName" id="threatTypeName">
                        <option value="">Select</option>
                        <c:forEach items="${threatList}" var="ListItem">
                          <option value="${ListItem.id}">${ListItem.name}</option>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-3 hide" id="smugglingcol">
                    <div class="form-group">
                      <label>Smuggling Type</label>
                      <select class="form-control select2" name="smugglingItem" id="smugglingItem">
                        <option value="0">Select</option>
                        <option value="1">Charas</option>
                        <option value="2">Ganja</option>
                        <option value="3">others</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-3 hide" id="contrabandtypecol">
                    <div class="form-group">
                      <label>Contraband Type</label>
                      <select class="form-control select2" name="smugglingItem" id="contraband_smugglingItem">
                        <option value="0">Select</option>
                        <option value="1">Gold</option>
                        <option value="2">Silver</option>
                        <option value="3">Brass</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-group">
                      <label>Search By</label>
                      <select class="form-control select2" id="search_by" name="search_by" required="required"
                        autocomplete="off" title="Search By">
                        <option value="">Select</option>
                        <c:forEach items="${searchByList}" var="ListItem">
                          <!-- to change -->
                          <option value="${ListItem.id}">${ListItem.name}</option>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-3 hide" id="lattitude">
                    <div class="form-group">
                      <label>Lattitude</label>
                      <input type="text" class="form-control" value="" name="lattitude_input" id="lattitude_input" />
                    </div>
                  </div>
                  <div class="col-md-3 hide" id="longitude">
                    <div class="form-group">
                      <label>Longitude</label>
                      <input type="text" class="form-control" value="" name="longitude_input" id="longitude_input" />
                    </div>
                  </div>
                  <div class="col-md-3 hide" id="registration-search">
                    <div class="form-group">
                      <label>Reg. No.</label>
                      <input type="text" class="form-control" value="" name="registration-input"
                        id="registration-input" />
                    </div>
                  </div>
                  <div class="col-md-3 hide" id="portreg-search">
                    <div class="form-group">
                      <label>Port. Reg.</label>
                      <input type="text" class="form-control" value="" name="port-input" id="port-input" />
                    </div>
                  </div>
                  <div class="col-md-3 hide" id="lpc-search">
                    <div class="form-group">
                      <label>LPC</label>
                      <input type="text" class="form-control" value="" name="lpc-input" id="lpc-input" />
                    </div>
                  </div>
                  <div class="col-md-3 hide" id="npc-search">
                    <div class="form-group">
                      <label>NPC</label>
                      <input type="text" class="form-control" value="" name="npc-input" id="npc-input" />
                    </div>
                  </div>

                  <div class="col-md-3 searchother" id="search_term_div" style="display: none">
                    <div class="form-group" id="search_term_input_div" style="display: none">
                      <label><span id="input_label">Search Term</span></label>
                      <input type="text" class="form-control" value="" name="search_term" id="search_term" />
                    </div>
                    <div class="form-group" id="search_term_date_div" style="display: none">
                      <label><span id="cal_label">Search Term</span></label>
                      <input type="text" class="form-control dat" name="search_term_date" id="search_term_date"
                        onkeydown="return false" readonly style="background-color: #ffff" />
                    </div>

                    <div class="form-group" id="search_term_select_div" style="display: none">
                      <label><span id="select_label">Search Term</span></label>
                      <select class="form-control select2" name="search_type_select" required id="search_type_select">
                        <option value="">Select</option>
                      </select>
                    </div>
                  </div>
                  <div class="col-md-3 hide" id="todate-search">
                    <div class="form-group">
                      <label><span id="cal_label">Select To Date</span></label>
                      <input type="text" class="form-control dat" name="todate-input" id="todate-input"
                        onkeydown="return false" readonly style="background-color: #ffff" />
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div style="margin-top: 1.4rem">
                      <input type="button" id="btn_search" class="btn btn-info" value="Search Details" />
                    </div>
                  </div>
                </div>

                <div class="clear-10"></div>
              </div>
              <!-- Cont Box End -->
            </div>
            <!-- Main Content End -->

            <!-- Head Accrd area start -->
            <div class="hdr_acd">
              <p id="view_data_area" onclick="hideFormArea();">
                <span><i class="fa fa-chevron-right"></i></span> View Report
              </p>
            </div>
            <!-- Head Accrd area End -->
            <div id="data_table_view" style="display: none">
              <!-- Table Start -->
              <div id="table_view">
                <div class="table-responsive-lg table-responsive-md">
                  <table id="search_tab" class="table table-striped table-bordered" style="width: 100%">
                    <thead class="thead-dark">
                      <tr class="info tb-hd">
                        <th><input name="select_all" value="1" type="checkbox" /></th>
                        <th>Input id</th>
                        <th>Date of receipt</th>
                        <th>Originator</th>
                        <th>GPS position</th>
                        <th>Time of activation</th>
                        <th>IMEI no</th>
                        <th>Country of contacted no.</th>
                        <th>Contacted telephone number</th>
                        <th>Distance from land (nautical)</th>
                        <!-- <th>Operating area</th> -->

                        <th style="min-width: 60px !important">View form</th>
                        <th style="min-width: 92px !important">View docs</th>
                      </tr>
                      <tr id="header_search_row">
                        <th></th>
                        <th class="hdr_search"></th>
                        <th class="hdr_search"></th>
                        <th class="hdr_search"></th>
                        <th class="hdr_search"></th>
                        <th class="hdr_search"></th>
                        <th class="hdr_search"></th>
                        <th class="hdr_search"></th>
                        <th class="hdr_search"></th>
                        <th class="hdr_search"></th>
                        <!-- <th class="hdr_search"></th> -->
                        <th></th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody class="tbd1"></tbody>
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
      <script type="text/javascript">
        $(document).ready(function () {






          // threat type conditions start

          $("#threatTypeName").on("change", function () {
            if (this.value == "0003") {
              console.log('asdasd1.......!' + this.value);
              $("#smugglingcol").show();
	       $("#contrabandtypecol").hide();
              var refData = this.value;
              $.ajax({
                url: "getSearchCombo?refData=" + refData,
                type: "get",
                data: {
                  refData: refData,
                },
                beforeSend: function () {
                  $("#giffy").show();
                },
                complete: function () {
                  $("#giffy").hide();
                },
                success: function (response) {
                  var len = response.length;
                  console.log("response    " + response)
                  var html = '<option value="">Select</option>';

                  $("#smugglingItem").empty();
                  for (var i = 0; i < len; i++) {
                    var name1 = response[i];
                    var id2 = response[i].id;
                    var desc2 = response[i].desc;

                    html += '<option value ="' + id2 + '">' + desc2 + "</option>";
                  }
                  html += "</option>";
                  $("#smugglingItem").html("");
                  $("#smugglingItem").html(html);
                },
              });


            } else if (this.value == "0004") {
	    
                             $("#smugglingcol").hide();
              $("#contrabandtypecol").show();
              var refData = '';
              if (this.value == '0004') {
                refData = '0002';
              }
              
              $.ajax({
                url: "getSearchCombo?refData=" + refData,
                type: "get",
                data: {
                  refData: refData,
                },
                beforeSend: function () {
                  $("#giffy").show();
                },
                complete: function () {
                  $("#giffy").hide();
                },
                success: function (response) {
                  var len = response.length;
                  console.log("response    " + response)
                  var html = '<option value="">Select</option>';

                  $("#contraband_smugglingItem").empty();
                  for (var i = 0; i < len; i++) {
                    var name1 = response[i];
                    var id2 = response[i].id;
                    var desc2 = response[i].desc;

                    html += '<option value ="' + id2 + '">' + desc2 + "</option>";
                  }
                  html += "</option>";
                  $("#contraband_smugglingItem").html("");
                  $("#contraband_smugglingItem").html(html);
                },
              });
            } else {
              $("#smugglingcol").hide();
              $("#contrabandtypecol").hide();
            }
          });

          $("#search_term_date").datetimepicker({
            widgetPositioning: {
              horizontal: "auto",
              vertical: "bottom",
            },
            ignoreReadonly: true,
            // format: 'DD/MM/YYYY hh:mm:ss A',
            format: "DD/MM/YYYY",
            useCurrent: false,
          });


          $("#todate-input").datetimepicker({
            widgetPositioning: {
              horizontal: "auto",
              vertical: "bottom",
            },
            ignoreReadonly: true,
            // format: 'DD/MM/YYYY hh:mm:ss A',
            format: "DD/MM/YYYY",
            useCurrent: false,
          });

          // DataTable
          var table = $("#search_tab").DataTable({
            dom: "Bfrtip",
            bSortable: false,
            ordering: false,
            orderCellsTop: true,
            fixedHeader: true,
            button: [],
          });
          // .............Handle click on "Select all" control...............
          $('thead input[name="select_all"]', table.table().container()).on(
            "click",
            function (e) {
              if (this.checked) {
                $('#search_tab tbody input[type="checkbox"]:not(:checked)').trigger(
                  "click"
                );
              } else {
                $('#search_tab tbody input[type="checkbox"]:checked').trigger(
                  "click"
                );
              }
            }
          );
          // ............./Handle click on "Select all" control...............
          $("#search_by").change(function () {
            //0001,IMEI No.,0002,Contact No.,0003,Position,0004,Region,0005,State,0006,Location,0007,From Date,0008,To Date
            $("#data_table_view").hide();
            $("#search_term_div").show();

            var input_option_select = ["0004", "0005","0006", "0010", "0018", "0019",]; //region,state
            var input_option_date = ["0007", "0008"]; //from date ,to date
            var search_type_input_text_arry = {
              "0001": "Search IMEI No.",
              "0002": "Search Contact No.",
              "0003": "Search Position",
              "0004": "Select Region",
              "0005": "Select State",
              "0006": "Search Location",
              "0007": "Select From Date",
              "0008": "Select To Date",
              "0009": "Search Boat",
              "0010": "Select Vessel",
              "0011": "Search Crew",
              "0018": "Select Originator",
              "0019": "Select Grading",

            }; ////Boat,Vessel,Crew Name
            //input_label,cal_label,select_label,
            //search_term_input_div,search_term_date_div,search_term_select_div
            console.log(this.value + "............................");
            if (input_option_select.indexOf(this.value) !== -1) {
              //select box
              console.log("diwakar1");
              $("#search_term_select_div").show();
              $("#search_term_date_div").hide();
              $("#search_term_input_div").hide();
              $("#registration-search").hide();
              $("#portreg-search").hide();
              $("#lpc-search").hide();
              $("#npc-search").hide();
              $("#lattitude").hide();
              $("#longitude").hide();
              $("#todate-search").hide();
              $("#select_label").text(search_type_input_text_arry[this.value]);
              getSelectOption();
            } else if (input_option_date.indexOf(this.value) !== -1) {
              // date picker
              console.log("diwakar2");
              $("#search_term_select_div").hide();
              $("#search_term_date_div").show();
              $("#todate-search").show();
              $("#search_term_input_div").hide();
              $("#registration-search").hide();
              $("#portreg-search").hide();
              $("#lpc-search").hide();
              $("#npc-search").hide();
              $("#lattitude").hide();
              $("#longitude").hide();
              $("#search_term_date").val("");
              $("#cal_label").text(search_type_input_text_arry[this.value]);
            } else {
              if (this.value == "0003") {
                $("#lattitude").show();
                $("#longitude").show();
                $("#search_term_div").hide();
              } else if (this.value == "0009") {
                $("#registration-search").show();
                $("#portreg-search").show();
                $("#lpc-search").show();
                $("#npc-search").show();
                $("#search_term_div").hide();
                $("#lattitude").hide();
                $("#longitude").hide();
              } else {
                $("#registration-search").hide();
                $("#portreg-search").hide();
                $("#lpc-search").hide();
                $("#npc-search").hide();
                $("#lattitude").hide();
                $("#longitude").hide();
              }

              $("#search_term").val("");
              $("#search_term_select_div").hide();
              $("#search_term_date_div").hide();
              $("#todate-search").hide();
              $("#search_term_input_div").show();
              $("#input_label").text(search_type_input_text_arry[this.value]);
            }
          }); //close search_by on change

          $("#btn_search").click(function () {
            $("#data_table_view").hide();
            $("#search_tab").DataTable().destroy();
            $("#search_tab tbody").empty();


            var imeiNo = "";
            var contactNo = "";
            var latitude = "";
            var longitude = "";
            var region = "";
            var state = "";
            var location = "";
            var fromDate = "";
            var toDate = "";
            var boatName = "";
            var vesselName = "";
            var crewName = "";
            var inputId = "";
            var threatType = "";
            var narcoticType = "";
            var contrabandType = "";
            var boatRegNo = "";
            var boatPortOfReg = "";
            var boatLPC = "";
            var boatNPC = "";
            var originator = "";
            var grading = "";
            var vesselFlagAndPortOfReg = "";





            var threatType = $("#threatTypeName").val();

            //can be narcotics or contraband
            if (threatType == "0003") {
              narcoticType = $("#smugglingItem").val();
            } else if (threatType == "0004") {
              contrabandType = $("#contraband_smugglingItem").val();
              console.log('inside-after.....asdas......!' + contrabandType);
            } else {

            }


            var search_by = $("#search_by").val();

            console.log('imei-no-before-outside = ' + search_by);

            if (search_by == "0001") {
              //search by IMEI No.
              console.log('search by IEMI NO ');
              imeiNo = $("#search_term").val();
            } else if (search_by == "0002") {
              //search by Contact No.
              console.log('search by Contact No ');
              contactNo = $("#search_term").val();
              console.log('contact no. = ' + contactNo);
            } else if (search_by == "0003") {
              //search by Position
              console.log('search by Position');
              latitude = $("#lattitude_input").val();
              longitude = $("#longitude_input").val();
            } else if (search_by == "0004") {
              //search by Region
              console.log('search by Region');
              region = $("#search_type_select").val();
            } else if (search_by == "0005") {
              //search by State
              console.log('search by State');
              state = $("#search_type_select").val();
            } else if (search_by == "0006") {
              //search by Location
              console.log('search by Location');
              location = $("#search_term").val();
            } else if (search_by == "0007") {
              //search by From-Date
              console.log('search by From-Date');
              fromDate = $("#search_term_date").val();
              toDate = $("#todate-input").val();
            } else if (search_by == "0008") {
              //search by To-Date
              console.log('search by To-Date');
            } else if (search_by == "0009") {
              //search by Boat
              console.log('search by Boat');
              boatRegNo = $("#registration-input").val();
              boatPortOfReg = $("#port-input").val();
              boatLPC = $("#lpc-input").val();
              boatNPC = $("#npc-input").val();
            } else if (search_by == "0010") {
              //search by Vessel
              console.log('search by Vessel');
              vesselName = $("#search_type_select").val();
            } else if (search_by == "0011") {
              //search by Crew Name
              console.log('search by Crew Name.');
              crewName = $("#search_term").val();
            } else if (search_by == "0012") {
              //search by Input Id
              console.log('search by Input Id.');
              inputId = $("#search_term").val();
            } else if (search_by == "0013") {
              //search by Narcotic Type
              console.log('search by Narcotic Type.');
            } else if (search_by == "0014") {
              //search by Registration Number
              console.log('search by Registration Number.');
            } else if (search_by == "0015") {
              //search by Port of Registration
              console.log('search by Port of Registration.');
            } else if (search_by == "0016") {
              //search by LPC
              console.log('search by LPC.');
            } else if (search_by == "0017") {
              //search by NPC
              console.log('search by NPC.');
            } else if (search_by == "0018") {
              //search by Originator
              console.log('search by Originator.');
              originator = $("#search_type_select").val();
            } else if (search_by == "0019") {
              //search by Grading
              console.log('search by Grading.');
              grading = $("#search_type_select").val();
            } else {
              //search by 
            }

            // var searchTerm = "";
            // var searchTypeValue = $("#search_by").val();
            // //	var searchId= $("#search_type_select").val();
            // if (searchTypeValue) {
            //   var input_option_select = ["0004", "0005", "0010", "0018", "0019"]; //region,state
            //   var input_option_date = ["0007", "0008"]; //from date ,to date

            //   if (input_option_date.indexOf(searchTypeValue) !== -1) {
            //     searchTerm = $("#search_term_date").val();
            //   } else if (input_option_select.indexOf(searchTypeValue) !== -1) {
            //     searchTerm = $("#search_type_select").val();
            //   } else {
            //     searchTerm = $("#search_term").val();
            //   }
            //   var search_type_input_text_arry = {
            //     "0001": " Enter Search IMEI No.!",
            //     "0002": "Enter Search Contact No.!",
            //     "0003": "Enter Search Position!",
            //     "0004": "Select Region!",
            //     "0005": "Select State!",
            //     "0006": "Enter Search Location!",
            //     "0007": "Select From Date!",
            //     "0008": "Select To Date!",
            //     "0010": "Select Vessel",
            //     "0018": "Select Originator",
            //     "0019": "Select Grading",

            //   };
            //   if (searchTerm == "") {
            //     $.alert({
            //       content: "Please " + search_type_input_text_arry[searchTypeValue],
            //       theme: "material",
            //       type: "orange",
            //       title: "Warning",
            //     });
            //     return false;
            //   }
            // } else {
            //   $.alert({
            //     content: "Please select search by!",
            //     theme: "material",
            //     type: "orange",
            //     title: "Warning",
            //   });
            //   return false;
            // }

            /* $('#search_tab').DataTable().destroy();
                    $('#search_tab tbody').empty(); */

            $.ajax({
              type: "GET",
              url: "getSearchThreatList",
              data: {
                imeiNo: imeiNo,
                contactNo: contactNo,
                latitude: latitude,
                longitude: longitude,
                region: region,
                state: state,
                location: location,
                fromDate: fromDate,
                toDate: toDate,
                boatName: boatName,
                vesselName: vesselName,
                crewName: crewName,
                inputId: inputId,
                threatType: threatType,
                narcoticType: narcoticType,
                contrabandType: contrabandType,
                boatRegNo: boatRegNo,
                boatPortOfReg: boatPortOfReg,
                boatLPC: boatLPC,
                boatNPC: boatNPC,
                originator: originator,
                grading: grading,
                vesselFlagAndPortOfReg: vesselFlagAndPortOfReg,
              },
              beforeSend: function () {
                $("#giffy").show();
              },
              complete: function () {
                $("#giffy").hide();
              },
              success: function (data) {
                $("#data_table_view").show();
                $("#view_data_area").trigger("click");
                var dataobj = JSON.parse(data);
                viewDetailDataTable(dataobj);
              },
              error: function () {
                $.alert({
                  content: "Error",
                  theme: "material",
                  type: "orange",
                  title: "Error",
                });
                return false;
              },
            }); //end of ajax call
          }); //close btn_search click
        }); // close document ready

        function getSelectOption() {
          var refData = document.getElementById("search_by").value;
          
          console.log("aasdadadassdavxcbvzvxc" + refData + "asdas");

          $.ajax({
            url: "getSearchCombo?refData=" + refData,
            type: "get",
            data: {
              refData: refData,
            },
            beforeSend: function () {
              $("#giffy").show();
            },
            complete: function () {
              $("#giffy").hide();
            },
            success: function (response) {
              var len = response.length;
              //console.log("response    "+response.length)
              var html = '<option value="">Select</option>';

              $("#search_type_select").empty();
              for (var i = 0; i < len; i++) {
                var name1 = response[i];
                var id2 = response[i].id;
                var desc2 = response[i].desc;

                html += '<option value ="' + id2 + '">' + desc2 + "</option>";
              }
              html += "</option>";
              $("#search_type_select").html("");
              $("#search_type_select").html(html);
            },
          });
        } // clase function getSelectOption

        function hideViewArea() {
          //	$(this).addClass('grid_lab_act');
          //$(".hdr_acd p").not(this).removeClass("grid_lab_act");
          $("#add_deta_area").addClass("grid_lab_act");
          $("#view_data_area").removeClass("grid_lab_act");
          $("#table_view").hide();
          $("#form_area").show();
        } //.........close hideViewArea function ...........

        function hideFormArea() {
          $("#view_data_area").addClass("grid_lab_act");
          $("#add_deta_area").removeClass("grid_lab_act");
          //$(this).addClass('grid_lab_act');
          //$(".hdr_acd p").not(this).removeClass("grid_lab_act");
          $("#table_view").show();
          $("#form_area").hide();
        } //.........close hideFormArea function ...........

        //Display on search datatable
        function viewDetailDataTable(dataobj) {
          $("#search_tab").dataTable().fnDestroy();
          if (dataobj == "") {
            $("#header_search_row").hide();
            $("#search_tab").DataTable({
              dom: "Bfrtip",
              bSortable: false,
              ordering: false,
              //"orderCellsTop" : true,
              fixedHeader: true,
              columnDefs: [
                {
                  targets: 0,
                  sortable: false,
                },
              ],
              buttons: [],
            });
          } else {
            $("#header_search_row").show();
            var table = $("#search_tab").DataTable({
              orderCellsTop: true,
              fixedHeader: true,
              //	"orderCellsTop" : true,
              //"fixedHeader" : true,
              dom: "Bfrtip",
              bSortable: false,
              ordering: false,
              columnDefs: [
                {
                  orderable: false,
                  targets: 0,
                },
              ],
              buttons: [
                {
                  extend: "excelHtml5",
                  title: "Search Threat",
                  exportOptions: {
                    columns: [1, 2, 3, 4, 5, 6, 7, 8, 9],
                  },
                  autoPrint: false,
                },
                {
                  extend: "pdfHtml5",
                  // footer: true,
                  // header: true,
                  customize: function (doc) {
                    // console.dir(doc);
                    doc.content[1].margin = [10, 0, 80, 0]; //left, top, right, bottom
                    doc.styles.tableBodyEven.alignment = "center";
                    doc.styles.tableBodyOdd.alignment = "center";
                  },
                  title: "Search Threat",
                  exportOptions: {
                    columns: [1, 2, 3, 4, 5, 6, 7, 8, 9],
                  },
                  orientation: "landscape",
                  pageSize: "LEGAL",
                  autoPrint: false,
                },
              ],

              data: dataobj,
              columns: [
                {
                  mRender: function (data, type, row) {
                    //var valpass = row.inputId;
                    var valpass =
                      row.latitute +
                      "#~#" +
                      row.longitute +
                      "#~#" +
                      row.typeOfThreatId;
                    return (
                      '<input type="checkbox" name="row_chk" value="' +
                      valpass +
                      '"></input>'
                    );
                  },
                },
                {
                  data: "inputId",
                },
                {
                  data: "dateOfReceipt",
                },
                {
                  data: "originator",
                },
                {
                  //data : 'gpsPosition'
                  mRender: function (data, type, row) {
                    //var valpass = row.inputId
                    return "Lat:" + row.latitute + "<br/>Long:" + row.longitute;
                  },
                },
                {
                  data: "timeOfActivation",
                },
                {
                  data: "imeiNo",
                },
                {
                  data: "countryOfContactedNo",
                },
                {
                  data: "contactedTelephoneNumber",
                },
                {
                  data: "distanceFromLand",
                },
                {
                  mRender: function (data, type, row) {
                    var valpass = row.genDetlsId;
                    var threatId = ["0001", "0002", "0003", "0004", "0005", "0006"]; //threat id
                    if (threatId.indexOf(row.typeOfThreatId) !== -1)
                      return (
                        '<a href="viewPDF?id=' +
                        valpass +
                        '" target="_blank"><button type="button"  class="btn btn-primary btn-sm1"  title="View form"><i class="fa fa-eye"></i></button></a>'
                      );
                    else
                      return '<a target="_blank"><button type="button"  class="btn btn-primary btn-sm1">N/A</button></a>';
                  },
                },
                {
                  mRender: function (data, type, row) {
                    //"0001","Satellite interception","0002","Counter terrorism","0003","Narcotics smuggling","0004","Contraband smuggling","0005","Human trafficking","0006","Others"

                    //	var updateUrl={"0001":"updateSatelliteInterceptionPage?id=","0002":"updateCounter?id=","0003":"updateNarcotic?id=","0004":"updateContraband?id=","0005":"updateHumanTrafficking?id=","0006":"updateOtherPage?id="};
                    //	var valpass = row.genDtlsId+"#"+row.typeOfThreatId;
                    var valpass = row.inputId;
                    var threatId = ["0001", "0002", "0003", "0004", "0005", "0006"]; //threat id
                    if (threatId.indexOf(row.typeOfThreatId) !== -1)
                      return (
                        '<a href="viewDocPage?inputId=' +
                        valpass +
                        "&threadId=" +
                        row.typeOfThreatId +
                        '" target="_blank"><button type="button"  class="btn btn-viewdoc btn-sm1" title="View docs"><img src="static/img/view_doc.png" alt="view" style="width:19px;"></button></a>'
                      );
                    else
                      return '<a target="_blank"><button type="button"  class="btn btn-primary btn-sm1">N/A</button></a>';
                  },
                },
              ],
            }); //close datatable

            $("#search_tab thead tr:eq(1) .hdr_search").each(function (i) {
              var title = $(this).text();
              $(this).html(
                '<input type="text" class="form-control" placeholder="Search ' +
                title +
                '" />'
              );
            });

            //............/Setup - add a text input to each header cell..............
            $("#search_tab thead tr:eq(1) th").each(function (i) {
              var title = $(this).text();
              $('input[type="text"]', this).on("keyup change", function () {
                if (table.column(i).search() !== this.value) {
                  table.column(i).search(this.value).draw();
                }
              });
            });
            // ........./Apply the search footer...........
            $("#search_tab_filter").before(
              '<button onclick="viewMap()" type="button"  class="btn btn-primary btn-sm1 cu_datbtn">View Map</button>'
            );
          } //close else
        } //close viewDetailDataTable

        //Display datatable at viewdetail model page

        function viewMap() {
          //......get all checked checkbox.........
          var numberOfChecked = $("input[name='row_chk']:checked").length;
          if (numberOfChecked > 0) {
            var lattitudeList = [];
            var longitudeList = [];
            var threatType = {
              "0001": "Satellite",
              "0002": "Counter Terrorism",
              "0003": "Narcotics",
              "0004": "Contraband",
              "0005": "Human Traffic",
              "0006": "others",
            }; // threat name
            var threatTypeList = [];
            var dataList = [];
            $.each($("input[name='row_chk']:checked"), function () {
              if (checkEmpty($(this).val(), 3)) {
                var positionArr = $(this).val().split("#~#");
                var data = {};
                data["lattitude"] = positionArr[0];
                data["longitude"] = positionArr[1];
                data["locationName"] = "";
                data["threatType"] = threatType[positionArr[2]];
                dataList.push(data);
              }
            });

            if (dataList.length > 0) {
              //alert("JSON.stringify(data)--"+JSON.stringify(dataList));

              var encData = window.btoa(JSON.stringify(dataList));
              //window.location.href="viewMap?encData="+encData;
              window.open("viewMap?encData=" + encData, "_blank");
            } else {
              $.alert({
                content: "These check option doesn't have GPS coordinates!",
                theme: "material",
                type: "orange",
                title: "Alert!",
              });
            }
          } //close first if
          else {
            $.alert({
              content: "Please check option! ",
              theme: "material",
              type: "orange",
              title: "Alert!",
            });
          }
          //....../get all checked checkbox.........
        } //close viewMap
      </script>

      <!-- Script Links End--->
