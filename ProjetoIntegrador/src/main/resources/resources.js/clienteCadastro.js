$(document).ready(function () {

    $('#option1').click(function () {
        $('#juridico').removeClass('mostrarForm');
        $('#juridico').addClass('esconderForm');
        $('#fisica').removeClass('esconderForm');
        $('#fisica').addClass('mostrarForm');
    });

    $('#option2').click(function () {
        $('#fisica').removeClass('mostrarForm');
        $('#fisica').addClass('esconderForm');
        $('#juridico').removeClass('esconderForm');
        $('#juridico').addClass('mostrarForm');
    });

});