document.addEventListener('DOMContentLoaded', () => {
  document.querySelector('#form_agregar_estudiante-boton_agregar').addEventListener('click', (event) => {
    event.preventDefault();
    agregarEstudiante('/'+NOMBRE_PROYECTO+'/api/estudiantes');
    // JARCODEADO PORQUE SI USAMOS LA CONSTANTE LA INCLUYE DOS VECES
  });
});

/**
 * 
 * @param {*} url 
 * Obtiene del formulario y los envia hacia la url
 */
function agregarEstudiante (url){

  let nL = document.querySelector('#form_agregar_estudiante-num_Libreta').value;
  let ndoc =  document.querySelector('#form_agregar_estudiante-num_doc').value;
  let apellido =  document.querySelector('#form_agregar_estudiante-apellido').value;
  let nombre = document.querySelector('#form_agregar_estudiante-nombres').value;
  let edad = document.querySelector('#form_agregar_estudiante-edad').value;
  let genero= document.querySelector('#form_agregar_estudiante-genero').value;
  let residencia = document.querySelector('#form_agregar_estudiante-residencia').value;

  if(nL == '' || ndoc == '' || apellido == '' || nombre == '' || edad == '' || genero == '' || residencia== ''){
    alert("todos los campos deben estar completos");
  }else{
    let estudianteNuevo = {
        'num_Libreta': document.querySelector('#form_agregar_estudiante-num_Libreta').value,
        'num_doc': document.querySelector('#form_agregar_estudiante-num_doc').value,
        'apellido': document.querySelector('#form_agregar_estudiante-apellido').value,
        'nombres': document.querySelector('#form_agregar_estudiante-nombres').value,
        'edad': document.querySelector('#form_agregar_estudiante-edad').value,
        'genero': document.querySelector('#form_agregar_estudiante-genero').value,
        'residencia': document.querySelector('#form_agregar_estudiante-residencia').value
    };
    // Escribe el objeto en el JSON del servidor
    fetch((url), {
        'method': 'POST',
        'headers': {
            'content-type': 'application/JSON'
        },
        'mode': 'cors',
        'body': JSON.stringify(estudianteNuevo)
    })
    .then(function (respuesta) {
        if (respuesta.ok) {         
            alert('¡Estudiante agregad@ con éxito!');
        }
        else {
            alert("La solicitud al servidor falló.");            
        }
    })
    .catch(exception => console.log(exception));
  }

}