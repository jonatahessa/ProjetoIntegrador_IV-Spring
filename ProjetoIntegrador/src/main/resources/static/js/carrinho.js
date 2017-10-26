$(document).ready(function () {

    $(mascara = function (t, mask) {
        var i = t.value.length;
        var saida = mask.substring(1, 0);
        var texto = mask.substring(i)
        if (texto.substring(0, 1) != saida) {
            t.value += texto.substring(0, 1);
        }
    });
});

$('.btnCalcularCep').click(function () {
    $('.linhaInfoCep').html('');
    $('.linhaInfoCep').append('<div class="col-xs-12 col-sm-1 col-md-1 col-lg-1"></div>\n\
                                <div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">\n\
                                    <p class="pFrete">Prazo de entrega: 5-7 dias úteis </br>Valor: R$ 12,00</p>\n\
                                </div>');
});