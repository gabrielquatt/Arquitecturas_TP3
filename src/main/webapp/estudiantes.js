document.addEventListener('DOMContentLoaded', () => {
  cargarOptionsCarreras('api/carreras');
  cargarTablaEstudiantes('api/estudiantes');
  document.querySelector('#ordenar').addEventListener('click', () => {
    cargarTablaEstudiantes('api/estudiantes/orderByNumLibreta');
  });
  
  document.querySelector('#filtrar').addEventListener('click', () => {
    let filtroUrl;
    let tipoFiltro = document.querySelector('#estudiantes-select_filtrarpor').value;
    switch(tipoFiltro){
        case 'GENERO':
            filtroUrl = 'api/estudiantes/'+document.querySelector('#estudiantes-select_genero').value;
        break;
        case 'CARRERA_Y_RESIDENCIA':
            filtroUrl = 'api/estudiantes/'+document.querySelector('#estudiantes-select_carrera').value+'/'+document.querySelector('#estudiantes-input_nombre_residencia').value; 
        break;
        default:
            filtroUrl = 'api/estudiantes';

    }
    console.log(filtroUrl);
    cargarTablaEstudiantes(filtroUrl);
  });
});

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

function cargarTablaEstudiantes(url){
  fetch(url, {
      method: 'GET',
      mode: 'cors',
  })
  .then(function(respuesta){
      if(respuesta.ok) {
           return respuesta.json();
      }
      else {
          alert("Error");
      }
  })
  .then(function(estudiantes){
      let tabla = document.getElementById("tablaEstudiantes");
      while ((tabla.rows.length - 1) > 0)
      {
          tabla.deleteRow(-1);
      }
      
      estudiantes.forEach(function(estudiante){ 
          cargarEstudiante(estudiante);
      });
  })
  .catch(function(error) {
      console.log("Hubo un problema con la petición Fetch:" + error.message);
    });    
}

function cargarEstudiante(estudiante) {
  // Recibe la direccion de la tabla y crea una fila siempre al final    
  let tabla = document.getElementById("tablaEstudiantes");
  let fila = tabla.insertRow(-1);
  //TD NRO.LIBRETA
  let libreta= document.createElement("td");
  libreta.textContent = estudiante.num_Libreta; 
  fila.appendChild(libreta);
  //TD NOMBRE
  let nombres = document.createElement("td");
  nombres.textContent =estudiante.nombres ; 
  fila.appendChild(nombres);
  //TD APELLIDO
  let apellido = document.createElement("td");
  apellido.textContent =estudiante.apellido; 
  fila.appendChild( apellido);
  //TD EDAD
  let edad = document.createElement("td");
  edad.textContent =estudiante.edad;
  fila.appendChild(edad);
  //TD GENERO
  let genero = document.createElement("td");
  genero.textContent =estudiante.genero;
  fila.appendChild(genero);
  //TD EDAD
  let ver_columna = document.createElement("td");
  let ver_a = document.createElement("a");
  ver_a.href = "estudiante.html?LU="+estudiante.num_Libreta;
  ver_a.appendChild(document.createTextNode("Ver Más"));
  ver_columna.appendChild(ver_a);
  fila.appendChild(ver_columna);
}