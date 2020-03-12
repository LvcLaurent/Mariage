(function($) {
	"use strict";

	$(document).ready(function() {
		
		// ====================================================================

		// Smooth Scroll on Menu Click

		$('.navbar a[href^=#]').on("click",function(){
			var t= $(this.hash);
			var t=t.length&&t||$('[name='+this.hash.slice(1)+']');
			if(t.length){
				var tOffset=(t.offset().top - 90);
				$('html,body').animate({scrollTop:tOffset},'slow');
				return false;
			}
		});

		$(".navbar a[href*='#']").not('.navbar a[href="#"]').on("click",function(){
		    $('.navbar-toggle').click();
		});

		// ====================================================================

		// Banner

		$(".slides-container").owlCarousel({
			animateOut: 'slideOutDown',
			animateIn: 'flipInX',
			autoplay: true,
			loop: true,
			margin: 0,
			nav: false,
			dots: false,
			items: 1
		});

		// ====================================================================

		// Countdown

		var weddingDate = new Date('2020-09-26T14:30:00');
		//var weddingDate = new Date(weddingDate.getFullYear() + 1, 1 - 1, 1);
		$(".countdown").countdown({
			until: weddingDate,
			format: 'ODHMS'
		});

		// ====================================================================

		// Owl Carousel

		$("#registry .owl-carousel").owlCarousel({
			autoplay: true,
			loop: true,
			margin: 0,
			nav: false,
			dots: false,
			items: 5,
			responsive:{
				0:{
					items:1
				},
				480:{
					items:2
				},
				768:{
					items:3
				},
				992:{
					items:4
				},
				1200:{
					items:5
				}
			}
		});

		// ====================================================================

		// Parallax

		$('.parallax').scrolly({bgParallax: true});

		// ====================================================================

		// Fun Facts Counter

		var flag = 0;

	    $(window).scroll(function() {
	        if (flag == 1){
	           return false;
	        }
	        else{
	           var bh = $(window).height();
	           var st = $(window).scrollTop();
	           var el = $('.timer');
	           var eh = el.height();
	           if ( st >= (100 + eh) - bh ) {
	               el.countTo({
	                   speed: 2000,
	                   refreshInterval: 20
	               });
	           }
	           flag = 1;
	        }
	    });

		// ====================================================================

		// Fancybox

		$('.fancybox').fancybox({
			openEffect: 'none'
		});

		// ====================================================================

		// Scroll Reveal

		if ($(window).width() > 767) {

			// The starting defaults.
			var config = {
				after: '0s',
				enter: 'top',
				move: '50px',
				over: '0.66s',
				easing: 'ease-in-out',
				viewportFactor: 0.33,
				reset: false,
				init: true
			};

			window.scrollReveal = new scrollReveal({reset: true});
		}

	})

})(jQuery);