$(document).ready(function(){
	var slideImages = [ {src: 'img/caroussel/20180819_192313.jpg'},
	              		{src: 'img/caroussel/20180823_152652.jpg'},
	              		{src: 'img/caroussel/20180823_161359.jpg'},
	              		{src: 'img/caroussel/20180823_171107.jpg'} ]
	//var jR3DCarousel;
	
	jR3DCarousel = $('.jR3DCarouselGallery').jR3DCarousel({
		width: 1200, 		/* largest allowed width */
		height: 800, 		/* largest allowed height */
		slides: slideImages /* array of images source */
	});
	function slideShownCallback($slide){
		console.log("Slide shown: ", $slide.find('img').attr('src'))
	}

	jR3DCarouselCustomeTemplate = $('.jR3DCarouselGalleryCustomeTemplate').jR3DCarousel(carouselCustomeTemplateProps);

  })