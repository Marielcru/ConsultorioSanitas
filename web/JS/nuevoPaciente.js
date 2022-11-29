$( document ).ready(function() {
   
  });

function generarMedico() {
    $.ajax({
        type: "POST",
        url: "Smedico",
        data: {
            "nmbre": $("#inputNombre").val(),
            "apellido": $("#inputApellido").val(),
             "fechanac": $("#inputFecha").val(),
          "dni": $("#inputDNi").val(),
          "direccion": $("#inputDireccion").val(),
            "telefono": $("#inputTelefono").val(),
            "email": $("#inputEmail").val(),
            "matricula": $("#inputObraSocial").val()
          
        },
        success: function (result) {
            alert("Paciente ingresado exitosamente");
           console.log(result);
           //$("#inputNombre").val(result);
           //$(location).attr('href',url);
           
         },
        error: function (result, status) {
            console.log("Error");
            console.log(result);
          },
        dataType: "text"
  });
}



