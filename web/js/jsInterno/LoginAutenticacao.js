  function validarLogin(){
        if(document.formAutenticacao.user.value===""){
                alert("Campo Usuário/Email Não Informado");  
                return false;
        } 
        if(document.formAutenticacao.senha.value===""){ 
                alert("Campo Password/Senha Não Informado");
                return false;
        } 
        document.formAutenticacao.submit();
        
    }
    
    //onclick="validarLogin()

