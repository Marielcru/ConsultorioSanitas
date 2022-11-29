$( document ).ready(function() {
   
  });

function buscarUsuario() {
    $.ajax({
        type: "POST",
        url: "LogueoUsuario",
        data: {
          "usser": $("#inputUsuario").val(),
          "pass": $("#inputContraseña").val()
        },
        success: function (result) {
            console.log("Bienvenido");
           console.log(result);
           //$(location).attr('href',url);
           
         },
        error: function (result, status) {
            console.log("Usuario y/o contraseña inválidos");
            console.log(result);
          },
        dataType: "text"
  });
}



