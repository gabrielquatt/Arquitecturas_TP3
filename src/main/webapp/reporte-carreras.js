document.addEventListener('DOMContentLoaded', () => {
  cargarTablaCarreras('api/carreras/reporte-carreras');
});

function cargarTablaCarreras(url){ 
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
.then(function(carreras){
    console.log(carreras);
    let tabla = document.getElementById("tablaCarreras");
    while ((tabla.rows.length - 1) > 0)
    {
        tabla.deleteRow(-1);
    }
    
    carreras.forEach(function(carrera){ 
        cargarCarrera(carrera);
    });
})
.catch(function(error) {
    console.log("Hubo un problema con la petición Fetch:" + error.message);
  });    
}

function cargarCarrera(carrera) {
// Recibe la direccion de la tabla y crea una fila siempre al final    
let tabla = document.getElementById("tablaCarreras");
let fila = tabla.insertRow(-1);
//TD NOMBRE CARRERA
let nombre= document.createElement("td");
nombre.textContent = carrera.nombre_Carrera; 
fila.appendChild(nombre);
//TD ANIO
let anio = document.createElement("td");
anio.textContent =carrera.anio; 
fila.appendChild(anio);
//TD CANTIDAD INGRESADOS
let cantIngresados = document.createElement("td");
cantIngresados.textContent =carrera.incriptos; 
fila.appendChild(cantIngresados);
//TD CANTIDAD EGRESADOS
let cantEgresados= document.createElement("td");
cantEgresados.textContent =carrera.egresados;
fila.appendChild(cantEgresados);
}