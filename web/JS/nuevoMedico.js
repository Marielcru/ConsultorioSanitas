$( document ).ready(function() {
   
  });

function generarMedico() {
    $.ajax({
        type: "POST",
        url: "SnuevoMedico",
        data: {
            "nombre": $("#inputNombre").val(),
            "apellido": $("#inputApellido").val(),
             "fechanac": $("#inputFecha").val(),
          "dni": $("#inputDNi").val(),
          "direccion": $("#inputDireccion").val(),
            "telefono": $("#inputTelefono").val(),
            "email": $("#inputEmail").val(),
            "matricula": $("#inputMatricula").val(),
          "especialidad": $("#inputEspecialidad").val()
          
        },
        success: function (result) {
            alert("Médico ingresado exitosamente");
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

