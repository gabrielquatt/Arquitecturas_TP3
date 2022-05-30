document.addEventListener('DOMContentLoaded', () => {
  cargarTablaEstados('api/estados');
});

/**
 * 
 * @param {*} url 
 * Obtiene los datos de la url y la carga en la tabla de estados
 */
function cargarTablaEstados(url){
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
  .then(function(estados){
      let tabla = document.getElementById("tablaEstados");
      while ((tabla.rows.length - 1) > 0)
      {
          tabla.deleteRow(-1);
      }
      estados.forEach(function(estado){ 
          cargarEstado(estado);
      });
  })
  .catch(function(error) {
      console.log("Hubo un problema con la peticiÃ³n Fetch:" + error.message);
    });    
}

/**
 * 
 * @param {*} estado
 * Crea una nueva fila en la tabla de estados 
 */
function cargarEstado(estado) {
    // Recibe la direccion de la tabla y crea una fila siempre al final    
    let tabla = document.getElementById("tablaEstados");
    let fila = tabla.insertRow(-1);
    //TD NRO.LIBRETA
    let libreta= document.createElement("td");
    let estudiante = document.createElement("a");
    estudiante.href = "estudiante.html?LU="+estado.estudiante.num_Libreta; 
    estudiante.appendChild(document.createTextNode(estado.estudiante.num_Libreta));
    libreta.appendChild(estudiante);
    fila.appendChild(libreta);
    //TD CARRERA
    let carrera = document.createElement("td");
    carrera.textContent = estado.carrera.nombre; 
    fila.appendChild(carrera);
    //TD ANIO INGRESO
    let anioIngreso = document.createElement("td");
    anioIngreso.textContent =  (estado.anioIngreso !== null) ? estado.anioIngreso: " - ";
    fila.appendChild(anioIngreso);
    //TD ANIO EGRESO
    let anioEgreso = document.createElement("td");
    anioEgreso.textContent = (estado.anioEgreso !== null) ? estado.anioEgreso : " - ";
    fila.appendChild(anioEgreso);
}