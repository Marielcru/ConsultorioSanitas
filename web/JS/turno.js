$( document ).ready(function() {
   
  });

function generarTurno() {
    $.ajax({
        type: "POST",
        url: "Sturno",
        data: {
          "dni": $("#inputDNi").val(),
          "especialidad": $("#inputEspecialidad").val(),
          "medico": $("#inputMedico").val(),
          "fecha": $("#inputFecha").val(),
          "hora": $("#inputHora").val()
        },
        success: function (result) {
            alert("Turno generado");
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


