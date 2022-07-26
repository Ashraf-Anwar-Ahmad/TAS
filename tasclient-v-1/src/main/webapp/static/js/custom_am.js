/* Custom Theme Js All */

/* Menu Start */
jQuery(function ($) {

    $(".sidebar-dropdown > a").click(function() {
	  $(".sidebar-submenu").slideUp(200);
	  if (
		$(this)
		  .parent()
		  .hasClass("active")
	  ) {
		$(".sidebar-dropdown").removeClass("active");
		$(this)
		  .parent()
		  .removeClass("active");
	  } else {
		$(".sidebar-dropdown").removeClass("active");
		$(this)
		  .next(".sidebar-submenu")
		  .slideDown(200);
		$(this)
		  .parent()
		  .addClass("active");
	  }
	});
	
	$(".sidebar-dropdown li.sidebar-dropdown1 > a").click(function() {
	  $(".sidebar-submenu1").slideUp(200);
	  if (
		$(this)
		  .parent()
		  .hasClass("active")
	  ) {
		$(".sidebar-dropdown1").removeClass("active");
		$(this)
		  .parent()
		  .removeClass("active");
	  } else {
		$(".sidebar-dropdown1").removeClass("active");
		$(this)
		  .next(".sidebar-submenu1")
		  .slideDown(200);
		$(this)
		  .parent()
		  .addClass("active");
	  }
	});
	
	
	

	$("#close-sidebar").click(function() {
	  $(".sidemenu").toggleClass("toggled");
		$(".header-blue").toggleClass("hed-clp");
	  $(".main_body").toggleClass("bdclp");
	});
  
});
 
/*------ Select2 Js Start ----*/
 

  $(function () {
	  $('select').each(function () {                                            
		$(this).select2({                                                        
		  theme: 'bootstrap4',
		  width: 'style',
		  placeholder: $(this).attr('placeholder'),
		  allowClear: Boolean($(this).data('allow-clear')),
		});
	  });
   });

/*------Select2 Js End----*/   
 
/* Form view and Table view accorion */
// Acordion Type of Add and Show
	
$('#add_deta_area').click(function() {
	$(this).addClass('grid_lab_act');
	$(".hdr_acd p").not(this).removeClass("grid_lab_act"); 
	   $('#table_view').hide( );
	   $('#form_area').show( );
   });                                                    
   $('#view_deta_area').click(function() { 
	$(this).addClass('grid_lab_act');
	 $(".hdr_acd p").not(this).removeClass("grid_lab_act");
   $('#table_view').show( );
	   $('#form_area').hide( );
   });
   
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   