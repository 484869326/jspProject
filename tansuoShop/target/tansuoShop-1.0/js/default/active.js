(function ($) {
    'use strict';

    var newWindow = $(window);
    var sideNavWrapper = $("#sidenavWrapper");
    var footerNav = $("#footerNav");
    var isShow=false;
    // :: 1.0 Preloader
    newWindow.on('load', function () {
        $('#preloader').fadeOut('1000', function () {
            $(this).remove();
        });
    });
    // :: 2.0 Navbar
    $("#NavbarToggler").on("click", function () {
        if(isShow){
            $(".AdminController").css({"height":"0px"});
            $(".navbar-toggler>span:nth-child(2)").css({
                "flex": "0 0 12px",
                "min-width": "12px",
                "width": "12px"
            })

        }else{
            $(".AdminController").css({"height":"250px"});
            $(".navbar-toggler>span:nth-child(2)").css({
                "flex": "0 0 22px",
                "min-width": "22px",
                "width": "22px"
            })
        }
        isShow=!isShow;
    });

    // 3.0 Size Selection
    $(".choose-size-radio li").on("click", function () {
        $(".choose-size-radio li").removeClass("active");
        $(this).addClass("active");
    });

    // :: 5.0 Hero Slides
    if ($.fn.owlCarousel) {
        var welcomeSlider = $('.hero-slides');
        welcomeSlider.owlCarousel({
            items: 1,
            loop: true,
            autoplay: true,
            dots: true,
            center: true,
            margin: 0,
            nav: true,
            navText: [('<i class="lni lni-chevron-left"></i>'), ('<i class="lni lni-chevron-right"></i>')]
        })

        welcomeSlider.on('translate.owl.carousel', function () {
            var layer = $("[data-animation]");
            layer.each(function () {
                var anim_name = $(this).data('animation');
                $(this).removeClass('animated ' + anim_name).css('opacity', '0');
            });
        });

        $("[data-delay]").each(function () {
            var anim_del = $(this).data('delay');
            $(this).css('animation-delay', anim_del);
        });

        $("[data-duration]").each(function () {
            var anim_dur = $(this).data('duration');
            $(this).css('animation-duration', anim_dur);
        });

        welcomeSlider.on('translated.owl.carousel', function () {
            var layer = welcomeSlider.find('.owl-item.active').find("[data-animation]");
            layer.each(function () {
                var anim_name = $(this).data('animation');
                $(this).addClass('animated ' + anim_name).css('opacity', '1');
            });
        });
    }

    // :: 6.0 Flash Sale Slides
    if ($.fn.owlCarousel) {
        var flashSlide = $('.flash-sale-slide');
        flashSlide.owlCarousel({
            items: 3,
            margin: 16,
            loop: true,
            autoplay: true,
            smartSpeed: 800,
            dots: false,
            nav: false,
            responsive: {
                1500: {
                    items: 7,
                },
                992: {
                    items: 6,
                },
                768: {
                    items: 4,
                },
                480: {
                    items: 4,
                },
            },
        })
    }

    // :: 7.0 Products Slides
    if ($.fn.owlCarousel) {
        var productslides = $('.product-slides');
        productslides.owlCarousel({
            items: 1,
            margin: 0,
            loop: false,
            autoplay: true,
            autoplayTimeout: 5000,
            dots: true,
            nav: true,
            navText: [('<i class="lni lni-chevron-left"></i>'), ('<i class="lni lni-chevron-right"></i>')]
        })
    }

    // :: 8.0 Tooltip
    if ($.fn.tooltip) {
        $('[data-toggle="tooltip"]').tooltip();
    }

    // :: 9.0 Jarallax
    if ($.fn.jarallax) {
        $('.jarallax').jarallax({
            speed: 0.5
        });
    }

    // 修改金额由小变大的速度
    if ($.fn.counterUp) {
        $('.counter').counterUp({
            delay: 100,
            time: 500
        });
    }

    // :: 11.0 Prevent Default 'a' Click
    $('a[href="#"]').on('click', function ($) {
        $.preventDefault();
    });

    // :: 12.0 Password Strength Active Code
    if ($.fn.passwordStrength) {
        $('#registerPassword').passwordStrength({
            minimumChars: 8
        });
    }

})(jQuery);