
jQuery(document).ready(function() {
	var Random;
    /*
        Fullscreen background
    */
    $.backstretch("assets/img/backgrounds/1.jpg");
    
    $('#top-navbar-1').on('shown.bs.collapse', function(){
    	$.backstretch("resize");
    });
    $('#top-navbar-1').on('hidden.bs.collapse', function(){
    	$.backstretch("resize");
    });
    
    /*
        Form
    */
    $('.registration-form fieldset:first-child').fadeIn('slow');
    
    $('.registration-form input[type="text"], .registration-form input[type="password"], .registration-form textarea, .registration-form input[type="date"], .registration-form input[type="email"] .registration-form input[type="number"]').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    // next step
    $('.registration-form .btn-next').on('click', function() {
    	var parent_fieldset = $(this).parents('fieldset');
    	var next_step = true;
        var password;
  
    	parent_fieldset.find('input[type="number"],input[type="text"], input[type="password"], textarea , input[type="date"], input[type="email"]').each(function() {
    		if( $(this).val() == "" ) {
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
                });
      parent_fieldset.find(' input[type="email"]').each(function() {
          if(IsEmail($(this).val())==false){
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			$(this).removeClass('input-error');
    		}});
    	parent_fieldset.find(' #form-Phone-num').each(function() {
          if(IsPhone($(this).val())==false){
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			$(this).removeClass('input-error');
                        var dataForm ="phone="+$(this).val();
                        var request = $.ajax({                                                      
                        url: "/ECommerce/VerifyPhoneNumber",
                        type: "GET",
                        processData: false,
                        contentType: "text",
                        cache: false,
                        data:  dataForm
                       });
                   request.done(function(msg) {
                  Random= msg ;
                  alert( "Request success msg: " + Random );
                     });

                request.fail(function(jqXHR, textStatus) {
                      alert( "Request failed: " + textStatus );
                      });
                    
                        
    		}});
        parent_fieldset.find(' #form-password').each(function() {
          if($(this).val().length <= 8){
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			$(this).removeClass('input-error');
                        password =$(this).val();
    		}});
            parent_fieldset.find(' #form-repeat-password').each(function() {
          if($(this).val()!= password){
    			$(this).addClass('input-error');
    			next_step = false;
    		}
    		else {
    			$(this).removeClass('input-error');
    		}});
    	if( next_step ) {
    		parent_fieldset.fadeOut(400, function() {
	    		$(this).next().fadeIn();
	    	});
    	}
    	
    });
    
    // previous step
    $('.registration-form .btn-previous').on('click', function() {
    	$(this).parents('fieldset').fadeOut(400, function() {
    		$(this).prev().fadeIn();
    	});
    });
    
    // submit
    $('.registration-form').on('submit', function(e) {
    	
    	$(this).find('input[type="number"],input[type="text"], input[type="password"], textarea,input[type="date"], input[type="email"]').each(function() {
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
                    
    			$(this).removeClass('input-error');

    		}
    	});
    	
    });
   
    
});
 function IsEmail(email) {
  var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  if(!regex.test(email)) {
    return false;
  }else{
    return true;
  }
}
 function IsPhone(phone) {
  var regex = /^01[0125][0-9]{8}$/;
  if(!regex.test(phone)) {
    return false;
  }else{
    return true;
  }
}
