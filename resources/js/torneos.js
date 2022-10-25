if(localStorage.getItem("torneoSele") == null){
  localStorage.setItem("torneoSele", torneo);
}

if(localStorage.getItem("tJuegoTor") == null){
  localStorage.setItem("tJuegoTor", "");
}



function crearAllTorneos(torneo){
  let nodoPrincipal = document.getElementsByClassName("containerIntemsTorneosDestacados")[0];

  let div1 = document.createElement('div');
  div1.className = "item-torneoDestacado";
  nodoPrincipal.appendChild(div1);

  let div2 = document.createElement('div');
  div2.className = "item-torneoDestacado-img";
  div1.appendChild(div2);
  let img = document.createElement('img');
  img.className = "item-img-size";
  img.src = torneo.img;
  img.alt = torneo.nombre;
  div2.appendChild(img);

  let h4 = document.createElement("h4");
  h4.innerHTML = "Torneo " + torneo.tipoJuego.videojuego;
  div1.appendChild(h4);

  let h6 = document.createElement("h6");
  h6.innerHTML = torneo.nombre;
  div1.appendChild(h6);

  let p = document.createElement("p");
  p.innerHTML = torneo.descripcion;
  div1.appendChild(p);

  let div3 = document.createElement("div");
  div3.className = "item-torneoDestacado-precioBtn";
  div1.appendChild(div3);

  let span = document.createElement("span");
  span.className = "item-torneoDestacado-precio";
  span.innerHTML = "Precio: " + torneo.precio + "&#8364";
  div3.appendChild(span);

  let button = document.createElement("button");
  button.className = "item-torneoDestacado-btn";
  button.innerHTML = "Torneo";
  button.addEventListener("click", function(){infoGeneralTorneo(torneo);});
  div3.appendChild(button);
}


function recibirAllTorneosBbdd(){
  let request = new XMLHttpRequest();

  request.open("GET","http://localhost:4000/rest/torneo/todos",true);
  request.setRequestHeader("content-type","application/json;charset=utf-8");
  request.send();

  request.onreadystatechange = function() {
      if(this.readyState == 4 && this.status == 200){
          let response = JSON.parse(this.response);
          // console.log(response);
          
          if(response != ""){
              for(let i = 0; i<response.length ; i++){
                crearAllTorneos(response[i]);
              }
          }
          
      }
      
  }
}

function torDesta6(){
  let request = new XMLHttpRequest();

  request.open("GET","http://localhost:4000/rest/torneo/todos",true);
  request.setRequestHeader("content-type","application/json;charset=utf-8");
  request.send();

  request.onreadystatechange = function() {
      if(this.readyState == 4 && this.status == 200){
          let response = JSON.parse(this.response);
          // console.log(response);
          
          if(response != ""){
            crearAllTorneos(response[0]);
            let cont = 0;
            while(cont<5){
              crearAllTorneos(response[cont+1]);
              cont++;
            }
              // for(let i = 0; i<response.length ; i++){
              //   crearAllTorneos(response[i]);
              // }
          }
          
      }
      
  }
}

function infoGeneralTorneo(torneo){
  location.href = "../html/infoTorneo.html";
  localStorage.setItem("torneoSele", JSON.stringify(torneo));
}

function crearInfoTor(){
  let torneo = JSON.parse(localStorage.getItem("torneoSele"));
  let section = document.getElementsByClassName('containerInfoDeTorneo')[0];

  let div1 = document.createElement('div');
  div1.className = "itemInfoTorneo-left";
  section.appendChild(div1);

  let div11 = document.createElement('div');
  div1.appendChild(div11);
  let img = document.createElement('img');
  img.src = torneo.img;
  div11.appendChild(img);

  let div2 = document.createElement('div');
  div2.className = "itemInfoTorneo-right";
  section.appendChild(div2);
  let div21 = document.createElement('div');
  div21.className ="itemInfoTorneo-right-elementos";
  div2.appendChild(div21);
  let h1 = document.createElement('h1');
  h1.innerHTML = "Torneo " + torneo.tipoJuego.videojuego;
  div21.appendChild(h1);
  let h5 = document.createElement('h5');
  h5.innerHTML = torneo.nombre;
  div21.appendChild(h5);
  let p = document.createElement('p');
  p.innerHTML = torneo.descripcion;
  div21.appendChild(p);
  let div211 = document.createElement('div');
  div211.className = "itemInfoTorneo-right-div";
  div21.appendChild(div211);
  let span = document.createElement('span');
  span.innerHTML = "Estado: " + torneo.estado;
  div211.appendChild(span);
  let div2111 = document.createElement('div');
  div2111.className = disponibilidad(torneo);
  div211.appendChild(div2111);

  let div212 = document.createElement('div');
  div212.className = "itemInfoTorneo-right-div";
  div21.appendChild(div212);
  let span2 = document.createElement('span');
  span2.innerHTML = "Inicio: " + torneo.fechInic;
  div212.appendChild(span2);
  let span3 = document.createElement('span');
  span3.innerHTML = torneo.hora;
  div212.appendChild(span3);
  let span4 = document.createElement('span');
  span4.innerHTML = "Fin: " + torneo.fechFin;
  div212.appendChild(span4);

  let div214 = document.createElement('div');
  div214.className = "itemInfoTorneo-right-div";
  div21.appendChild(div214);
  let span5 = document.createElement('span');
  span5.innerHTML = "Plazas Restantes: " + torneo.plazas;
  div214.appendChild(span5);

  let div215 = document.createElement('div');
  div215.className = "itemInfoTorneo-right-div";
  div21.appendChild(div215);
  let span6 = document.createElement('span');
  span6.innerHTML = "Precio: " + torneo.precio + "&#8364";
  div215.appendChild(span6);

  let div213 = document.createElement('div');
  div213.className = "btnParticipar";
  div21.appendChild(div213);
  let button = document.createElement('button');
  button.innerHTML = "Participar";
  button.disabled = disabBtnInfo(torneo);
  button.addEventListener('click', function(){pagoParti(torneo)})
  div213.appendChild(button);

  let pE = document.createElement('h3');
  pE.className = 'avisoInfoTor';
  section.appendChild(pE);

}

function buscadorPrinc(){
    let nombre = document.getElementById('buscador').value;
    let contTor = document.getElementsByClassName('containerIntemsTorneosDestacados')[0];
    let listTor = document.getElementsByClassName("item-torneoDestacado");

    if(nombre != ""){
    for(let i = listTor.length -1; i>=0; i--){
      contTor.removeChild(listTor[i]);
  }



  let request = new XMLHttpRequest();

            request.open("GET","http://localhost:4000/rest/torneo/buscador/"+nombre,true);
            request.setRequestHeader("content-type","application/json;charset=utf-8");
            request.send();

            request.onreadystatechange = function() {
                if(this.readyState == 4 && this.status == 200){

                    let response = JSON.parse(this.response);
                    console.log(response);

                    for(let i = 0; i<response.length; i++){
                      crearAllTorneos(response[i]);
                    }
             
                }
                
            }
          }
          else
          location.href = "../html/torneos.html";

}

function addParticipacion(torneo){
   let aux = JSON.parse(localStorage.getItem("logeado"));

   let numero = document.getElementsByClassName("inputTar")[0].value;
   let propietario = document.getElementsByClassName("inputTar")[1].value;
    let fechCaducidad = document.getElementsByClassName("inputTar")[2].value;
    let cvv = document.getElementsByClassName("inputTar")[3].value;

   if(numero == "" ||  propietario == "" || fechCaducidad == "" || cvv == ""){
    location.href = "../html/perfil.html";
   }
   else{
        if(aux){
              let fechReserva = new Date(Date.now());
              let precio = torneo.precio;
              let idUsuario = localStorage.getItem("idUsuarioActual");

              let aux2=
              {
                "fechReserva": fechReserva,
                "precio" : precio,
                "torneo": torneo
              }

              let request = new XMLHttpRequest();

              request.open("POST","http://localhost:4000/rest/reserva/reTor/"+idUsuario,true);
              request.setRequestHeader("content-type","application/json;charset=utf-8");
              request.send(JSON.stringify(aux2));

              request.onreadystatechange = function() {
                  if(this.readyState == 4 && this.status == 200){
                      let response = this.response;
                      // console.log(response);
                    if(response == 1){
                      location.href = "../index.html";
                    }
                    else{
                      document.getElementsByClassName('avisoInfoTor')[0].innerHTML = "Ya has reservado plaza en el Torneo";
                    }

                  }
                
              }
            
          }  
          else
              location.href = "../html/iniciarSesion.html";
  }
}

function pagoParti(torneo){
  let aux = JSON.parse(localStorage.getItem("logeado"));
  let precio = torneo.precio;
  if(aux){

    if(precio >0 ){
      document.getElementsByClassName('containerPasarelaDePago2')[0].style.display = "block";
      document.getElementsByClassName('containerPasarelaDePago2')[0].style.height = '0';    
      document.getElementsByClassName('subTipoUsu')[0].addEventListener('click', function(){addParticipacion(torneo)});
    }
    else{
      addParticipacion(torneo);
    }

  }else
      location.href = "../html/iniciarSesion.html";
}

function cancelarPago2(){
  document.getElementsByClassName('containerPasarelaDePago2')[0].style.display = "none";
}

// Funciones auxiliares
function irTorneoTj(videojuego){
  location.href = "../html/torneos.html";
  localStorage.setItem('tJuegoTor', videojuego);
 
}

function lanzadera(){
  let videojuego = localStorage.getItem("tJuegoTor");
            console.log(videojuego);
            if(videojuego != ""){
                console.log("hola");
                let contTor = document.getElementsByClassName('containerIntemsTorneosDestacados')[0];
                let listTor = document.getElementsByClassName("item-torneoDestacado");


                for(let i = listTor.length -1; i>=0; i--){
                contTor.removeChild(listTor[i]);
                }



                        let request = new XMLHttpRequest();

                        request.open("GET","http://localhost:4000/rest/torneo/buscadorTj/"+videojuego,true);
                        request.setRequestHeader("content-type","application/json;charset=utf-8");
                        request.send();

                        request.onreadystatechange = function() {
                            if(this.readyState == 4 && this.status == 200){

                                let response = JSON.parse(this.response);
                                console.log(response);

                                for(let i = 0; i<response.length; i++){
                                crearAllTorneos(response[i]);
                                }
                        
                            }
                            
                        }
                        localStorage.setItem("tJuegoTor", "");
              }
              else
              recibirAllTorneosBbdd()
}

function disponibilidad(torneo){
 let dis = "nodisponible";

 if(new Date(torneo.fechInic) > new Date(Date.now()) || torneo.plazas <= 0){
    dis = "disponible";
 }
 return dis;
}

function disabBtnInfo(torneo){
  let aux = true;
  if(new Date(torneo.fechInic) > new Date(Date.now()) || torneo.plazas <= 0){
    aux = false;
 }

  return aux;
}

function createHistorialTorneosPerfil(reserva){
    let nodoPrincipal = document.getElementsByClassName('infoHistoTor')[0];

    let div = document.createElement('div');
    div.className = "accordion-body";
    nodoPrincipal.appendChild(div);

    let span1 = document.createElement('span');
    span1.innerHTML = reserva.torneo.idTorneo;
    div.appendChild(span1);

    let span2 = document.createElement('span');
    span2.innerHTML = reserva.torneo.nombre;
    div.appendChild(span2);

    let span3 = document.createElement('span');
    if(reserva.posi == null)
      span3.innerHTML = "--------";
    else
      span3.innerHTML = reserva.posi;
    div.appendChild(span3);

    let span4 = document.createElement('span');
    span4.innerHTML = reserva.precio;
    div.appendChild(span4);

    let span5 = document.createElement('span');
    span5.innerHTML = "Detalles";
    span5.style.cursor = "pointer";
    span5.addEventListener("click", function(){infoGeneralTorneo(reserva.torneo)})
    div.appendChild(span5);
    
}

function createHistorialTorneosCreadosPerfil(torneo){
  let nodoPrincipal = document.getElementsByClassName('infoHistoTorCreados')[0];

  let div = document.createElement('div');
  div.className = "accordion-body";
  nodoPrincipal.appendChild(div);

  let span1 = document.createElement('span');
  span1.innerHTML = torneo.idTorneo;
  div.appendChild(span1);

  let span2 = document.createElement('span');
  span2.innerHTML = torneo.nombre;
  div.appendChild(span2);

  let span3 = document.createElement('span');
  span3.innerHTML = torneo.tipoJuego.videojuego;
  div.appendChild(span3);

  let span4 = document.createElement('span');
  span4.innerHTML = torneo.precio;
  div.appendChild(span4);

  let span5 = document.createElement('span');
  span5.innerHTML = "Detalles";
  span5.style.cursor = "pointer";
  span5.addEventListener("click", function(){infoGeneralTorneo(torneo)})
  div.appendChild(span5);
  
}

function historialTorneos(){
  let idUsuario = localStorage.getItem("idUsuarioActual");

  let request = new XMLHttpRequest();

  request.open("GET","http://localhost:4000/rest/reserva/todos/"+idUsuario,true);
  request.setRequestHeader("content-type","application/json;charset=utf-8");
  request.send();

  request.onreadystatechange = function() {
      if(this.readyState == 4 && this.status == 200){
          let response = JSON.parse(this.response);
          console.log(response);
          
          if(response != ""){
              for(let i = 0; i<response.length ; i++){
                createHistorialTorneosPerfil(response[i]);
      
              }
          }
          
      }
      
  }
}

function historialTorneosCreados(){
  let idUsuario = localStorage.getItem("idUsuarioActual");

  let request = new XMLHttpRequest();

  request.open("GET","http://localhost:4000/rest/torneo/todosCreados/"+idUsuario,true);
  request.setRequestHeader("content-type","application/json;charset=utf-8");
  request.send();

  request.onreadystatechange = function() {
      if(this.readyState == 4 && this.status == 200){
          let response = JSON.parse(this.response);
          console.log(response);
          
          if(response != ""){
              for(let i = 0; i<response.length ; i++){
                createHistorialTorneosCreadosPerfil(response[i]);
      
              }
          }
          
      }
      
  }
}




