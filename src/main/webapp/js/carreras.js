document.addEventListener('DOMContentLoaded', () => {
  cargarOptionsCarreras('api/carreras');
  document.querySelector('#ordenar').addEventListener('click', () => {
    cargarOptionsCarreras('api/carreras/OrdyByInscriptos');
  });
});

function cargarOptionsCarreras(url){ 
// console.log(url);
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
    console.log(carreras);
    let lista = document.querySelector("#listaCarreras");
    lista.innerHTML = "";
    carreras.forEach(function(carrera){ 
        let li = document.createElement('li');
        li.innerHTML= carrera.nombre;
        // li.setAttribute('data-value', carrera.id);
        lista.appendChild(li);
    });
})
.catch(function(error) {
    console.log("Hubo un problema con la petición Fetch:" + error.message);
  });    
}