function checkEmpty(data,chkLength)
	{
		var flage=true;
		var dataArr=data.split("#~#");
		for(var i=0;i<chkLength;i++)
		{
			if(dataArr[i]=='' || typeof dataArr[i] == 'undefined' || dataArr[i] =='null')
				{
				flage=false;
				break;
				}
		}
		
		return flage;
	}


function viewMapValidation(inData,dataLen) {
	if(!checkEmpty(inData,dataLen))
		{
		
		$.alert({
			content : "This threat doesn't have GPS coordinates.",
			theme : 'material',
			type : 'orange',
			title : 'Alert!'
		});		
		
	
	return false;
		}
	return true;
		
}


//$(".mapViewClick").on("click", function(){


function viewMapFormValidation()
{
	//gpslattitudeDec,gpslongitudeDec
var lattitude =$("#gpslattitudeDec").val();
var longitude =$("#gpslongitudeDec").val();
if(!checkEmpty(lattitude,1))
{
	$.alert({
		content : 'Please Enter Latitude (Decimal Degrees)',
		theme : 'material',
		type : 'orange',
		title : 'Alert!'
	});	
	//$("input[id='gpslattitudeDec']").focus(); 
	//$("input[id=gpslattitudeDec]").get(0).focus();
	
	return false;
}
else if(!checkEmpty(longitude,1))
{
	$.alert({
		content : 'Please Enter Longitude (Decimal Degrees)',
		theme : 'material',
		type : 'orange',
		title : 'Alert!'
	});	
	//$("input[id=gpslongitudeDec]").get(0).focus();
	
	return false;
}
else
	{
	var encData = window.btoa(lattitude+"#~#"+longitude);
	window.open("viewMapSingle?encData="+encData, '_blank');
	// window.open("viewMapSingle?lattitude="+lattitude+"&longitude="+longitude, '_blank');
	   
	//window.location.href="viewMap?lattitude="+lattitude+"&longitude="+longitude;
	return false;
	}
}
function viewMapSecTapVal()
{
var lattitude =$("#applattitudeDec").val();
var longitude =$("#applongitudeDec").val();
if(!checkEmpty(lattitude,1))
{
	$.alert({
		content : 'Please Enter Latitude (Decimal Degrees)',
		theme : 'material',
		type : 'orange',
		title : 'Alert!'
	});	
	//$("input[id='gpslattitudeDec']").focus(); 
	//$("input[id=gpslattitudeDec]").get(0).focus();
	
	return false;
}
else if(!checkEmpty(longitude,1))
{
	$.alert({
		content : 'Please Enter Longitude (Decimal Degrees)',
		theme : 'material',
		type : 'orange',
		title : 'Alert!'
	});	
	//$("input[id=gpslongitudeDec]").get(0).focus();
	
	return false;
}
else
	{
	var encData = window.btoa(lattitude+"#~#"+longitude);
	window.open("viewMapSingle?encData="+encData, '_blank');

	// window.open("viewMapSingle?lattitude="+lattitude+"&longitude="+longitude, '_blank');
	   
	//window.location.href="viewMap?lattitude="+lattitude+"&longitude="+longitude;
	return false;
	}



}

