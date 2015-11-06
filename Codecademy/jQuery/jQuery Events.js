// Cutting to the Chase
$(document).ready(function() {
   $('div').fadeOut('fast'); 
});


// Adding an Event Handler
$(document).ready(function() {
   $('div').click(function() {
      $(this).fadeOut('fast'); 
   });
});


// Combing .click() and .hover()
$(document).ready(function() {
    $('div').click(function() {
        $(this).fadeOut('fast'); 
    });
    
    $('div').hover(function() {
        $(this).addClass('red');    
    });
});


// The .dblclick() Event
$(document).ready(function() {
    $('div').dblclick(function() {
        $(this).fadeOut('fast');
    });
});


// Hover
$(document).ready(function(){

  $('div').hover(
    function(){
        $(this).addClass('active');
    },
    function(){
        $(this).removeClass('active');
    }
  );

});


// Let's .focus()!
$(document).ready(function() {
    $('input[name=name]').focus(function() {
        $(this).css('outline-color', '#FF0000');
    });
});


// The .keydown() Event
$(document).ready(function() {
    $(document).keydown(function() {
        $('div').animate({left:'+=10px'}, 500);   
    });
});


// Getting Ready
$(document).ready(function() {
    
});


// Using .keydown()
$(document).ready(function() {
    $(document).keydown(function(key) {
         
    });
});


// Filling Out the Cases
$(document).ready(function() {
    $(document).keydown(function(key) {
        switch(parseInt(key.which,10)) {
			// Left arrow key pressed
			case 37:
				$('img').animate({left: "-=10px"}, 'fast');
				break;
			// Up Arrow Pressed
			case 38:
				// Put our code here
				$('img').animate({top: "-=10px"}, 'fast');
				break;
			// Right Arrow Pressed
			case 39:
				// Put our code here
				$('img').animate({left: "+=10px"}, 'fast');
				break;
			// Down Arrow Pressed
			case 40:
				// Put our code here
				$('img').animate({top: "+=10px"}, 'fast');
				break;
		}
	});
});