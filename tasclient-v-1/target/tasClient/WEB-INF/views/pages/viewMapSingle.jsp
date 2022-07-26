<!DOCTYPE html>
<html>

  <head>
    <link href="static/leaflet/leaflet.css" rel="stylesheet">
    <link rel="stylesheet" href="static/fonts/font-open/stylesheet.css">
      <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet"  href="static/components/myalert/css/jquery-confirm.css"/>
    
    
    <link href="static/leaflet/style_map.css" rel="stylesheet">
	
	 <script src="static/js/jquery-v3.3.1.min.js"></script>
    <script src="static/leaflet/leaflet.js"></script>
    <script src="static/leaflet/leaflet.geometryutil.js"></script>
    <script src="static/leaflet/leaflet.textpath.min.js"></script>
	<script type="text/javascript" src="static/components/myalert/js/jquery-confirm.js"></script>
	<style>
	 /* .main-body { max-wdith:1000px; margin-left:20%;} */
	
	</style>
	
	
  </head>

  <body>
    
    
<div class="main-body">
<div class="leaf_head">
		<button type="button" id="show_dist" title="Calculate Distance" class="btn-circle"><i class="fa fa-th"></i></button> 
	</div>
	
	<div class="print_page">
		<a  class="printPage" href="#"><i class="fa fa-print"></i> Print</a>
	</div>
	
<div class="laefmymap_det" >
	
		<div class="leaf_body">
	


<div class="form_map">
	 
		<div class="form-group">
		<label>Threat Point</label>
			  <input type="text" id="first_cod" class="form-control" autocomplete="off" readonly>
		</div>
		
		<div class="form-group">
		<label>Clicked Point</label>
			<input type="text" class="form-control" id="sect_cod" autocomplete="off" readonly/>
		</div>
		<div class="form-group">
			<button id="get_dist" type="button" class="btn btn-primary">Get Distance</button>
		</div>
	
	<div class="val_show">
	<p>
   <b> Distance (in KMs):</b> <span id="distance"></span>
</p>

<p>
    <b>Distance (in NMs):</b> <span id="naut"></span>
</p>
	
	</div>
	
	
	
</div>
	</div>

</div>

<div id="map"></div>

</div>
  
</body>

<!-- Below Script starts -->
  
  <script type="text/javascript">
  
  $('a.printPage').click(function(){
      window.print();
      return false;
});
  
  $('#show_dist').click(function(){
	  
	  $('.laefmymap_det').slideToggle();
	  
  });
  
  var
  _firstLatLng,
  _firstPoint,
  _secondLatLng,
  _secondPoint,
  _distance,
  _length,
  fetchList=[],
  _polyline
mymap = L.map('map').setView([17.3850, 78.4867], 5);

  L.tileLayer('http://192.168.99.100:32769/styles/osm-bright/{z}/{x}/{y}.png', {
		minZoom:"2",
		zoomControl: false,
		useCache: true,
		crossOrigin: true
		  
		}).addTo(mymap);
  
  L.control.zoom({
	    position: 'bottomright'
	}).addTo(mymap);

// add listeners to click, for recording two points
var i=1;
var firstCheck="";
var secondCheck="";

var marker;
mymap.on('click', function(e) {
	_firstLatLng=e.latlng;
	marker=L.marker(_firstLatLng).addTo(mymap).bindPopup('Point '+i+'<br/>' + e.latlng).openPopup();
	
    var ftltlo=_firstLatLng.toString();
    ftltlo=ftltlo.replace(/[LatLng() ]/g,'');
    $('#sect_cod').val(ftltlo);
    i++;
    
  });
  
$('#get_dist').click(function(){
	var scndlo=$('#first_cod').val();
	firstCheck=scndlo.split(",");
	
	var flttt=$('#sect_cod').val();
	secondCheck=flttt.split(",");
	if(firstCheck!='' && secondCheck!=''){
		getDistanceFromLatLonInKm(firstCheck[0], firstCheck[1], secondCheck[0], secondCheck[1]);
		
	}
	else if(firstCheck=='' && secondCheck!=''){
		$.confirm({
		    title: 'Alert!',
		    content: 'No Value received from application to map',
		    theme: 'material',
		    type: 'orange',
		    columnClass: 'col-md-3 offset-md-4',
		    buttons: {
		        Ok: function () {
		        	
		        }
		   
		    }
		});
		
	}
	else if(firstCheck!='' && secondCheck==''){
		$.confirm({
		    title: 'Alert!',
		    content: 'please click on map',
		    theme: 'material',
		    type: 'orange',
		    columnClass: 'col-md-3 offset-md-4',
		    buttons: {
		        Ok: function () {
		        	
		        }
		   
		    }
		});
		
	}
	
	else if(firstCheck=='' && secondCheck==''){
		$.confirm({
		    title: 'Alert!',
		    content: 'No Value received from application to map',
		    theme: 'material',
		    type: 'orange',
		    columnClass: 'col-md-3 offset-md-4',
		    buttons: {
		        Ok: function () {
		        	
		        }
		   
		    }
		});
		
	}
	
});

function getDistanceFromLatLonInKm(lat1,lon1,lat2,lon2) {
	 
  var R = 6371; // Radius of the earth in km
  var dLat = deg2rad(lat2-lat1);  // deg2rad below
  var dLon = deg2rad(lon2-lon1); 
  var a = 
    Math.sin(dLat/2) * Math.sin(dLat/2) +
    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
    Math.sin(dLon/2) * Math.sin(dLon/2)
    ; 
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
  var d = R * c; // Distance in km
  //alert(d+'Km');
  document.getElementById('distance').innerHTML = d.toFixed(2) + ' KMs';
  var naut=Number(d)/1.852;
  document.getElementById('naut').innerHTML = naut.toFixed(2) + ' NMs';
  
  //**************below for text***************
  
  var p1 = new L.LatLng(lat1, lon1);
    var p2 = new L.LatLng(lat2, lon2);
    fetchList.push(p1);
    fetchList.push(p2);
    
    var routepolyline = new L.Polyline(fetchList, {
  	    color: 'black',
  	    weight: 2,
  	    opacity: 0.5,
  	    smoothFactor: 1
  	});
  	routepolyline.addTo(mymap);
  	
  	routepolyline.setText(naut.toFixed(2)+' NM', {center: true,
        offset: -3,
        orientation: 0,
        attributes: {fill: 'black','font-weight': 'bold','font-size': '15'}});
  	
  	fetchList=[];
  	
}
  
function deg2rad(deg) {
	  return deg * (Math.PI/180)
	}
	
  </script>
  
  <script>

var latdd="${lattitude}";
var logtd="${longitude}";
$('#first_cod').val(latdd+","+logtd);
//alert(JSON.stringify(test));

var LeafIcon = L.Icon.extend({
	options: {
		iconSize:     [30, 45], 
		//shadowSize:   [50, 64],
		iconAnchor:   [14.5, 44],
		//shadowAnchor: [4, 62],
		popupAnchor:  [-3, -43]
	}
});

var IndianIcon = L.Icon.extend({
	options: {
		iconSize:     [18, 18], 
		//shadowSize:   [50, 64],
		iconAnchor:   [7.8, 15],
		//shadowAnchor: [4, 62],
		popupAnchor:  [1, -8]
	}
});
var  redIcon = new LeafIcon({iconUrl: 'static/img/mapicon/contra.png'}),
customIcon = new LeafIcon({iconUrl: 'static/img/mapicon/narcotics.png'});

var indian = new IndianIcon({iconUrl: 'static/img/mapicon/loct.png'}); 
	
var myIcon=redIcon;

//below require customization




L.marker([latdd, logtd], {icon: myIcon}).bindPopup("("+latdd+","+logtd+")").addTo(mymap);
	
</script>

<script>
var pointList=[];

var p = new L.LatLng(23.46667,67.76667);
pointList.push(p);
L.marker([23.46667,67.76667], {icon: indian}).bindPopup("23° 28 N <br> 67° 46 E").addTo(mymap);
var p = new L.LatLng(20.98333,65.78333);
pointList.push(p);
L.marker([20.98333,65.78333], {icon: indian}).bindPopup("20° 59 N <br> 65° 47 E").addTo(mymap);
var p = new L.LatLng(16.01667,69.86667);
pointList.push(p);
L.marker([16.01667,69.86667], {icon: indian}).bindPopup("16° 01 N <br> 69° 52 E").addTo(mymap);

var p = new L.LatLng(12.7,68.45);
pointList.push(p);
L.marker([12.7,68.45], {icon: indian}).bindPopup("12° 42 N <br> 68° 27 E").addTo(mymap);
var p = new L.LatLng(7.966667,69.61667);
pointList.push(p);
L.marker([7.966667,69.61667], {icon: indian}).bindPopup("07° 58 N <br> 69° 37 E").addTo(mymap);
var p = new L.LatLng(7.933333,74.91667);
pointList.push(p);
L.marker([7.933333,74.91667], {icon: indian}).bindPopup("07° 56 N <br> 74° 55 E").addTo(mymap);


var p = new L.LatLng(4.916667,77.01667);
pointList.push(p);
L.marker([4.916667,77.01667], {icon: indian}).bindPopup("04° 55 N <br> 77° 01 E").addTo(mymap);
var p = new L.LatLng(10.26667,80.38333);
pointList.push(p);
L.marker([10.26667,80.38333], {icon: indian}).bindPopup("10° 16 N <br> 80° 23 E").addTo(mymap);
var p = new L.LatLng(13.15,83.56667);
pointList.push(p);
L.marker([13.15,83.56667], {icon: indian}).bindPopup("13° 09 N <br> 83° 34 E").addTo(mymap);

//BELOW CHANGE
var p = new L.LatLng(18.96667,89.66667);
pointList.push(p);
L.marker([18.96667,89.66667], {icon: indian}).bindPopup("18° 58 N <br> 89° 40 E").addTo(mymap);
//ABOVE CHANGE

var p = new L.LatLng(15.65,90.08333);
pointList.push(p);
L.marker([15.65,90.08333], {icon: indian}).bindPopup("15° 39 N <br> 90° 05 E").addTo(mymap);
var p = new L.LatLng(10.76667,89.05);
pointList.push(p);
L.marker([10.76667,89.05], {icon: indian}).bindPopup("10° 46 N <br> 89° 03 E").addTo(mymap);


var p = new L.LatLng(4.95,90.91667);
pointList.push(p);
L.marker([4.95,90.91667], {icon: indian}).bindPopup("04° 57 N <br> 90° 55 E").addTo(mymap);
var p = new L.LatLng(5,93.38333);
pointList.push(p);
L.marker([5,93.38333], {icon: indian}).bindPopup("05° 00 N <br> 93° 23 E").addTo(mymap);
var p = new L.LatLng(8.016667,95.68333);
pointList.push(p);
L.marker([8.016667,95.68333], {icon: indian}).bindPopup("08° 01 N <br> 95° 41 E").addTo(mymap);

var p = new L.LatLng(13.88333,95.91667);
pointList.push(p);
L.marker([13.88333,95.91667], {icon: indian}).bindPopup("13° 53 N <br> 95° 55 E").addTo(mymap);




var pointLocate = new L.Polyline(pointList, {
    color: '#575757',
    weight: 3,
    opacity: 0.5,
    smoothFactor: 1
});
pointLocate.addTo(mymap);
</script>
 
</html>
