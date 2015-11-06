// You Know This!
$(document).ready(function() {
    $('div').hide(); 
});


// More Practice with .animate()
$(document).ready(function(){

    // Fill in the blanks!
    $('img').animate({ top: '+=100px' }, 1000);
});


// Introducing: jQuery UI
$(document).ready(function() {
    $('div').click(function() {
        $(this).effect('explode'); 
    });
});


// .bounce()
$(document).ready(function() {
    $('div').click(function() {
        $(this).effect('bounce', {times:3}, 500); 
    });
});


// .slide()
$(document).ready(function() {
    $('div').click(function() {
        $(this).effect('slide');
    });
});


// Drag Racing
$(document).ready(function() {
    $('#car').draggable(); 
});


// One Resize Fits All
$(document).ready(function() {
    $('div').resizable(); 
});


// A Greater Selection
$(document).ready(function() {
    $('ol').selectable(); 
});


// Let's Sort Things Out
$(document).ready(function() {
    $('ol').sortable(); 
});


// jQuery UI, is There Anything You Can't Do?
<div id="menu">
    <h3>Section 1</h3>
    <div>
    	<p>Im the first section!</p>
	</div>
	<!--Add two more sections below!-->
	<h3>Section 2</h3>
	<div>
		<p>Im the second section!</p>
	</div>
	<h3>Section 3</h3>
	<div>
		<p>Im the third section!</p>
	</div>
</div>


// At the Ready
$(document).ready();


// Break Out Your .accordion()!
$(document).ready(function() {
    $('#menu').accordion();    
});