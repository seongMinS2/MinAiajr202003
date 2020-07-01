
var menus = [];




//메뉴 클릭 이벤트
$('row.menu1').click(function (e) {

    
})



//커피 클릭 이벤트
$('#1').click(function (e) {

    $('.swiper-container.center-block.1').show();
    $('.swiper-container.center-block.2').hide();
    $('.swiper-container.center-block.3').hide();
    $('.swiper-container.center-block.4').hide();

});

//음료 클릭 이벤트
$('#2').click(function (e) {

    $('.swiper-container.center-block.1').hide();
    $('.swiper-container.center-block.2').show();
    $('.swiper-container.center-block.3').hide();
    $('.swiper-container.center-block.4').hide();


});

//디저트 클릭 이벤트
$('#3').click(function (e) {

    $('.swiper-container.center-block.1').hide();
    $('.swiper-container.center-block.2').hide();
    $('.swiper-container.center-block.3').show();
    $('.swiper-container.center-block.4').hide();

});


//기타메뉴 클릭 이벤트
$('#4').click(function (e) {

    $('.swiper-container.center-block.1').hide();
    $('.swiper-container.center-block.2').hide();
    $('.swiper-container.center-block.3').hide();
    $('.swiper-container.center-block.4').show();

});



// JSON 파일 로드
function jsonParse() {
    $.getJSON('../json/data.json', function (data) { 
        menus = data;
        console.log(menus);
    });
};

function init() {

    $('.swiper-container.center-block.2').css('display', "none");
    $('.swiper-container.center-block.3').css('display', "none");
    $('.swiper-container.center-block.4').css('display', "none");

    jsonParse();



    $('swiper-container.center-block.1').scrollLeft(value);
};

init();