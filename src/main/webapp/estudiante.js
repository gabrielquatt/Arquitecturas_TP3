window.addEventListener('load', () => {
  let lu = get('LU');
  console.log(lu);
  estudianteLU('api/estudiantes/LU/'+lu);
  cargarOptionsCarreras('api/carreras');
  document.querySelector('#matricular').addEventListener('click', (event) => {
    event.preventDefault();
    matricularEstudiante('/'+NOMBRE_PROYECTO+'/api/estados');
    // JARCODEADO PORQUE SI USAMOS LA CONSTANTE LA INCLUYE DOS VECES
    // Qué lindo es JavaScript 🙃
  });
});

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

function get(name){
  if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
     return decodeURIComponent(name[1]);
}

function matricularEstudiante (url){
  let today = new Date();
  let estadoNuevo = {
      'carrera': document.querySelector('#form_agregar_estudiante-num_Libreta').value,
      'estudiante': get('LU'),
      'anioIngreso': String(today.getDate()).padStart(2, '0') + '/' + String(today.getMonth() + 1).padStart(2, '0') + '/' + today.getFullYear(),
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
          option.value = carrera.nombre;
          selector.appendChild(option);
      });
  })
  .catch(function(error) {
      console.log("Hubo un problema con la petición Fetch:" + error.message);
    });    
  }