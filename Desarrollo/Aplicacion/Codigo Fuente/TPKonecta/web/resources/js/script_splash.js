$(document).ready(function() {
	
	// Calling our splashScreen plugin and
	// passing an array with images to be shown
	
	$('#promoIMG').splashScreen({
		textLayers : [
			'../resources/images/thinner.png',
			'../resources/images/more_elegant.png',
			'../resources/images/our_new.png'
		]
	});
	
});
