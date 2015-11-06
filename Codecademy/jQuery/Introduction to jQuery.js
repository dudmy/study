// See It to Believe It
$(document).ready(function() {
   $('div').mouseenter(function() {
       $(this).animate({
           height: '+=10px'
       });
   });
   $('div').mouseleave(function() {
       $(this).animate({
           height: '-=10px'
       }); 
   });
   $('div').click(function() {
       $(this).toggle(1000);
   }); 
});


// The Documnet Object Model
$(document).ready(function() {
    $("div").fadeOut(1000);
});


// Changing Targets
$(document).ready(function() {
    $('#green').fadeOut(1000);
});


// What is jQuery?
$(document).ready(function() {
    $("#notready").fadeOut(1000);
});


// Linking Your HTML and JavaScript Files
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <!--Add your script tag here.-->
        <script type="text/javascript" src="script.js"></script>
    </head>
    <body>
        <div></div>
    </body>
</html>


// The Functional Approach
$(document).ready(function(){

});


// Electr(on)ic Slide
$(document).ready(function(){
    $('div').slideDown('slow');
});


// At the Ready!
$(document).ready();


// Get Yourself In...
$(document).ready(function() {
    $('div').mouseenter(function() {
       $('div').fadeTo('fast', 1); 
    });
});


// ...and Get Yourself Out!
$(document).ready(function() {
   $('div').mouseleave(function() {
      $('div').fadeTo('fast', 0.5); 
   });
});