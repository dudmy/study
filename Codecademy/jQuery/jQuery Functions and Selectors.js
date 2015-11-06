// Functions, Part Ⅰ: $(document).ready
$(document).ready(function() {
   $('div').hide(); 
});


 // Fcuntions, Part Ⅱ: Functions Explained
 $(document).ready(function() {
    $('div').click(function() {
        $('div').fadeOut('slow');
    });
});


 // Variables
 $(document).ready(function() {
    $target = $('#target');
    $target.fadeOut('fast');
});


 // Write your jQuery code below!
 var $div = $('div');


 // Using Functions to Select HTML Elements
 $(document).ready(function() {
    $('div').fadeIn('slow');
});


 // Selecting by Class
 $(document).ready(function() {
    $('button').click(function() {
        $('.vanish').fadeOut('slow');
    });
});


 // Selecting by ID
 $(document).ready(function() {
    $('button').click(function() {
        $('#blue').fadeOut('slow');
    });
});


 // Flexible Selections
 $(document).ready(function() {
   $('.pink').fadeTo('slow', 0);
   $('.red').fadeTo('slow', 0);
});


 // 'this' is Important!
 $(document).ready(function() {
    $('div').click(function() {
        $(this).fadeOut('slow');
    });
});


 // Ready?
 $(document).ready();


// Click and Pull
$(document).ready(function() {
    $('.pull-me').click();
});


// Toggling Our Panel
$(document).ready(function() {
    $('.pull-me').click(function() {
        $('.panel').slideToggle('slow');    
    });
});