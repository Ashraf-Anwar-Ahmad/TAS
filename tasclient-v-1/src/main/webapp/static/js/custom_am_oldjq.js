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

/*----Footer Bottom------*/

/*  $(document).ready(function() {

   var docHeight = $(window).height();
   var footerHeight = $('.foot_ver').height();
   var footerTop = $('.foot_ver').position().top + footerHeight;
   if (footerTop < docHeight) {
    $('.foot_ver').css('margin-top', -15+ (docHeight - footerTop) + 'px');
   }
});


$(window).bind("load", function() { 
       
       var footerHeight = 0,
           footerTop = 0,
           $footer = $(".foot_ver");          
       positionFooter();       
       function positionFooter() {
                 footerHeight = $footer.height()+10;
                 footerTop = ($(window).scrollTop()+$(window).height()-footerHeight)+"px";
       
               if ( ($(document.body).height()+footerHeight) < $(window).height()) {
                   $footer.css({
                        position: "absolute"
                    }).animate({
                        top: footerTop
                   })
               } else {
                   $footer.css({
                        position: "static"
                   })
               }
        }

       $(window)
               .scroll(positionFooter)
               .resize(positionFooter)
               
}); */