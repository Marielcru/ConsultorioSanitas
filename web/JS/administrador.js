$( document ).ready(function() {
   
  });

function buscarPaciente() {
    $.ajax({
        type: "POST",
        url: "Spaciente",
        data: {
          "dni": $("#inputDNi").val()
        },
        success: function (result) {
            console.log("OK");
           console.log(result);
           $("#inputNombre").val(result);
           //$(location).attr('href',url);
           
         },
        error: function (result, status) {
            console.log("Error");
            console.log(result);
          },
        dataType: "text"
  });
}

