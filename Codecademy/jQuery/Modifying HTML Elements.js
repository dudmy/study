// Creating HTML Elements
$h1 = $("<h1>Hello</h1>");


// Inserting Elements
$(document).ready(function() {
    $('body').append("<p>I\'m a paragraph!</p>");
});


// Before and After
$(document).ready(function() {
   $('#one').after("<p>Add after #one!</p>");
});


// Moving Elements Around
$(document).ready(function() {
    $('#one').after("<p>Add after #one!</p>");
    var $paragraph = $('p');
    $('#two').after($paragraph);
});


// Removing Elements
$(document).ready(function() {
    $('#one').after("<p>Add after #one!</p>");
    var $paragraph = $('p');
    $('#two').after($paragraph);
    
    $('p').remove();
});


// Adding and Removing Classes
$(document).ready(function() {
    $('#text').addClass('highlighted');
});


// Toggling Classes
$(document).ready(function() {
    $('#text').toggleClass('highlighted');
});


// Changing Your Style
$(document).ready(function() {
   $('div').height("200px");
   $('div').width("200px");
   $('div').css("border-radius", "10px");
});


// Modifying Content
$(document).ready(function() {
    $('p').html("jQuery magic in action!"); 
});


// Set up
$(document).ready(function() {
    
});


// Click Da Button! Do It Naoughw!
$(document).ready(function() {
    $('#button').click(function() {
        var toAdd = $('input[name=checkListItem]').val();
    });
});


// Append to Body
$(document).ready(function() {
    $('#button').click(function() {
        var toAdd = $('input[name=checkListItem]').val();
        $('.list').append('<div class="item">' + toAdd + '</div>');
    });
});


// Remove What's Been Clicked
$(document).ready(function() {
    
    $(document).on('click', '.item', function() {
        $(this).remove();    
    });
    
    $('#button').click(function() {
        var toAdd = $('input[name=checkListItem]').val();
        $('.list').append('<div class="item">' + toAdd + '</div>');
    });
});