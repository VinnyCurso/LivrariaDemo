
$(document).ready(function () {
    $('.date').mask('00/00/0000');
    $('.phone_with_ddd').mask('(00)0000-0000');
    $('.cpf').mask('000.000.000-00', {reverse: true});
});

$(function () {
    $('input[name=dataCadastro]').datepicker();
});

$(document).ready(function () {
    $('[data-toggle="tooltip"]').tooltip();
});

function validacao() {
    var formulario = document.forms["formCliente"];

    var nome = formulario.nome.value;
    var cpf = formulario.cpf.value;
  
    var erro = false;

    if (nome.indexOf(" ") == -1) {
        alert("Preencha o nome corretamente");
        erro = true;
    }
    if (cpf.length != 14) {
        alert("Preencha o CPF corretamente");
        erro = true;
    }
   
    if (erro) {
        erroconfirmacao();
        return false;
    } else {
        confirmacao();
        return true;
    }
    
    function atualizarFoto(){
    var fotoDigitadata = document.forms['formCliente']['clifoto'].value;

    document.forms['formCliente']['pegafoto'].src = fotoDigitadata;
    window.onload = function (){
         document.forms['formCliente']['clifoto'].oninput = atualizarFoto;
    };
};
