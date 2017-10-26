/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function calcularTotal(){
    var quantidade = document.forms['formVenda']['quantidade'].value;
    var precounitario = document.forms['formVenda']['precounitario'].value;
    var valorfinal = (quantidade * precounitario).value;
    
    document.forms['formVenda']['valortotal'].value = valorfinal;
    window.onload = function (){
         document.forms['formVenda']['precounitario'].oninput = calcularTotal;
    };
};


