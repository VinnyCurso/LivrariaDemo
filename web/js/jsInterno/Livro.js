function uploadFile() {

    //var target = document.querySelector("img");
    //var file = document.querySelector("input[type=file]").file[0];
    //var reader = new FileReader();

    //reader.onloadend = function () {
       // target.src = reader.result;

    //};
   // if (file) {
      //  reader.readAsDataURL(file);
    //} else {
       // target.src = "";
   // }
}  

function atualizarFoto(){
      
    var capa = document.forms['formLivro']['file'].value;

    document.forms['formLivro']['file'].src = capa;
    window.onload = function (){
         document.forms['formLivro']['file'].oninput = atualizarFoto;
    };
};
