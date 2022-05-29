window.addEventListener('load', () => {
  console.log('SASARASA');
  let lu = get('LU');
  console.log(lu);
  estudianteLU('api/estudiantes/LU/'+lu);
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