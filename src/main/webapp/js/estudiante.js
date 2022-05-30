window.addEventListener('load', () => {
  let lu = get('LU');
  estudianteLU('api/estudiantes/LU/'+lu);
  cargarOptionsCarreras('api/carreras');
  document.querySelector('#matricular').addEventListener('click', (event) => {
    event.preventDefault();
    matricularEstudiante('/'+NOMBRE_PROYECTO+'/api/estados');
    // JARCODEADO PORQUE SI USAMOS LA CONSTANTE LA INCLUYE DOS VECES
    // Qué lindo es JavaScript 🙃
  });
});

/**
 * 
 * @param {*} url
 * Obtiene los datos de la url y la carga en los parrafos
 */
function estudianteLU(url){ 
  fetch(url, {
    method: 'GET',
    mode: 'cors'
  })
  .then(function(respuesta){
      if(respuesta.ok) {
           return respuesta.json();
      }
      else {
          alert("Error");
      }
  })
  .then(function(estudiante){
      document.querySelector('#num_Libreta').innerHTML = estudiante[0].num_Libreta;
      document.querySelector('#num_doc').innerHTML = estudiante[0].num_doc;
      document.querySelector('#apellido').innerHTML = estudiante[0].apellido;
      document.querySelector('#nombres').innerHTML = estudiante[0].nombres;
      document.querySelector('#edad').innerHTML = estudiante[0].edad;
      document.querySelector('#genero').innerHTML = estudiante[0].genero;
      document.querySelector('#residencia').innerHTML = estudiante[0].residencia;
  })
  .catch(function(error) {
      console.log("Hubo un problema con la petición Fetch:" + error.message);
    });    
}

/**
 * 
 * @param {*} name 
 * @returns String
 * Devuelve el valor del atribuito a buscar
 */
function get(name){
  if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
     return decodeURIComponent(name[1]);
}

function matricularEstudiante (url){
  let anioIngreso = new Date();
  let anioEgreso = new Date();
  anioIngreso = document.querySelector('#estudiantes-anioIngreso').value;
  anioEgreso = document.querySelector('#estudiantes-anioEgreso').value;
  let estadoNuevo = {
      'carrera': {
        'id': document.querySelector('#estudiantes-select_carrera').value,
        'nombre': document.querySelector('#estudiantes-select_carrera').options[document.querySelector('#estudiantes-select_carrera').selectedIndex].text
      },
      'estudiante': {
        "num_Libreta": document.querySelector('#num_Libreta').innerHTML,
        "num_doc": document.querySelector('#num_doc').innerHTML,
        "apellido": document.querySelector('#apellido').innerHTML,
        "edad": document.querySelector('#edad').innerHTML,
        "genero": document.querySelector('#genero').innerHTML,
        "residencia": document.querySelector('#residencia').innerHTML,
        "nombres": document.querySelector('#nombres').innerHTML
      },
      'anioIngreso': null,
      'anioEgreso': null
  };

  console.log(estadoNuevo);

  // Escribe el objeto en el JSON del servidor
  fetch((url), {
      'method': 'POST',
      'headers': {
          'content-type': 'application/JSON'
      },
      'mode': 'cors',
      'body': JSON.stringify(estadoNuevo)
  })
  .then(function (respuesta) {
      if (respuesta.ok) {         
          alert('¡Estudiante ha sido matricul@ con éxito!');
      }
      else {
          alert("La solicitud al servidor falló.");            
      }
  })
  .catch(exception => console.log(exception));
}

/**
 * 
 * @param {*} url 
 * Obtiene los datos de la url y la carga en las opciones del selector de carreras
 */
function cargarOptionsCarreras(url){ 
  fetch(url, {
    method: 'GET',
    mode: 'cors'
  })
  .then(function(respuesta){
      if(respuesta.ok) {
           return respuesta.json();
      }
      else {
          alert("Error");
      }
  })
  .then(function(carreras){
      let selector = document.querySelector("#estudiantes-select_carrera");
      selector.innerHTML = "";
      carreras.forEach(function(carrera){ 
          let option= document.createElement('option');
          option.innerHTML= carrera.nombre;
          option.value = carrera.id;
          selector.appendChild(option);
      });
  })
  .catch(function(error) {
      console.log("Hubo un problema con la petición Fetch:" + error.message);
    });    
  }