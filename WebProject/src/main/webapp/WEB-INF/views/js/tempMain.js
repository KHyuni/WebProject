$(document).ready(function(){ 
    $("ul#navigation li a").click(function() {
		$("ul#navigation li").removeClass("selected");
		$(this).parents().addClass("selected");
		return false;
	});
});