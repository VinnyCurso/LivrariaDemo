/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
  $('.date').mask('00/00/0000');
  $('.phone_with_ddd').mask('(00)0000-0000');
  $('.cpf').mask('000.000.000-00', {reverse: true});
  });


