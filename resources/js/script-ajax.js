if(localStorage.getItem("idUsuarioActual") == null){
    localStorage.setItem("idUsuarioActual", "");
}





// Registramos usuario
function registro(){
    let nick = document.getElementById('nickRe').value.trim();
    let clave = document.getElementById('passwordRe').value.trim();
    let nombre = document.getElementById('nombreRe').value.trim();
    let apellidos = document.getElementById('apellidosRe').value.trim();
    let direccion = document.getElementById('direccionRe').value.trim();
    let email = document.getElementById('correoRe').value.trim();
    let fechNac = document.getElementById('fechaNacRe').value;

    
    if( (nick && clave && nombre && apellidos && direccion && email) != ""){
        if(new Date().getTime() > new Date(fechNac).getTime()){
            let aux =
            {
                "apellidos" : apellidos,
                "clave" : clave,
                "direccion" : direccion,
                "email" : email,
                "fechNac" : fechNac,
                "nick" : nick,
                "nombre" : nombre
            }

            let request = new XMLHttpRequest();

            request.open("POST","http://localhost:4000/rest/usuario/alta",true);
            request.setRequestHeader("content-type","application/json;charset=utf-8");
            request.send(JSON.stringify(aux));

            request.onreadystatechange = function() {
                if(this.readyState == 4 && this.status == 200){
                    let response = this.response;
                    
                    if(response == 1){
                        location.href= "../index.html";
                    }
                    else
                        document.getElementById("mensajeRegistro").innerHTML = "El usuario ya existe!!!";
                } 
            }


        }
        else
         alert("Fecha incorrecta");
    }
    else
        alert("Faltan rellenar campos");
    

}

// Iniciamos Sesión
function iniciarSesion(){
    let nick = document.getElementById("nickIs").value.trim();
    let clave = document.getElementById("passwordIs").value.trim();

    let request = new XMLHttpRequest();

        request.open("POST","http://localhost:4000/rest/usuario/iniciar/"+nick+"/"+clave,true);
        request.setRequestHeader("content-type","application/json;charset=utf-8");
        request.send();

        request.onreadystatechange = function() {
            if(this.readyState == 4 && this.status == 200){
                let response = JSON.parse(this.response);
                // console.log(response);
                
                if(response != ""){
                    localStorage.setItem("logeado",JSON.stringify(true));
                    localStorage.setItem("idUsuarioActual",response.idUsuario);
                    location.href = "../index.html"
                }
                
            }
            
        }
}

// Creación de Torneos
function crearTorneo(){
    let tJuego = document.getElementById('tipoJuego').value;
    let descripcion = document.getElementById('descripcionCt').value.trim();
    let fechFin = document.getElementById('fechFinCt').value;
    let fechInic = document.getElementById('fechIniCt').value;
    let img = document.getElementsByClassName('imgCrearTorneoPrin')[0].src;
    let nombre = document.getElementById('nombreCt').value.trim();
    let plazas = document.getElementById('plazas').value;
    let precio = document.getElementById('precio').value;
    let moda = document.getElementById('modalidad').value;
    let idUsuario = localStorage.getItem("idUsuarioActual");
    let timeCt = document.getElementById('timeCt').value;

    if((descripcion && fechFin && fechInic && img && nombre && moda) != "" && img != "http://192.168.1.17:5501/html/crearTorneo.html"
    && tJuego != "Selecciona un tipo de juego" && moda != "Modalidad"){
        img = ".." + img.substring(24,img.length);
        if(descripcion.length >= 171 && descripcion.length <= 220){
            if( plazas%2 == 0 && plazas > 0){

                if(precio == ""){
                    precio = 0;
                }

                if(new Date(fechFin).getTime() >= new Date(fechInic).getTime()){
                    // Empezamos con el envio de datos
                    let aux =
                    {
                        "descripcion" : descripcion,
                        "fechFin" : fechFin,
                        "fechInic" : fechInic,
                        "img" : img,
                        "nombre" : nombre,
                        "plazas" : plazas,
                        "precio" : precio,
                        "moda" : moda,
                        "hora" : timeCt
                    }

                    console.log(aux);

                    let request = new XMLHttpRequest();

                    request.open("POST","http://localhost:4000/rest/torneo/crearTorneo/"+idUsuario+"/"+tJuego,true);
                    request.setRequestHeader("content-type","application/json;charset=utf-8");
                    request.send(JSON.stringify(aux));

                    request.onreadystatechange = function() {
                        if(this.readyState == 4 && this.status == 200){
                            let response = this.response;
                        
                            if(response == 1){
                                location.href = location.href = "../index.html";
                            }
                            // else
                                // document.getElementById("mensajeRegistro").innerHTML = "El usuario ya existe!!!";
                        } 
                    }

                }
                else
                    document.getElementById("errorCtMensaje").innerHTML =  "Error en las fechas del Torneo";
                

            }
            else
                document.getElementById("errorCtMensaje").innerHTML =  "Error en el número de plazas";
        }
        else
            document.getElementById("errorCtMensaje").innerHTML =  "Hay más de 220 carácteres en la descripción o menos de 171";
    }
    else
        document.getElementById("errorCtMensaje").innerHTML =  "Faltan campos por completar";
}

// Obtener datos de la base de datos Editar
function traerDatosEditar(){
    let idUsuario = localStorage.getItem("idUsuarioActual");

    let request = new XMLHttpRequest();

    request.open("GET","http://localhost:4000/rest/usuario/mostrarUsu/"+idUsuario,true);
    request.setRequestHeader("content-type","application/json;charset=utf-8");
    request.send();

    request.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            let response = JSON.parse(this.response);
        
            document.getElementById('nickEd').value = response.nick;
            document.getElementById('passwordEd').value = response.clave;
            document.getElementById('nombreEd').value = response.nombre;
            document.getElementById('apellidosEd').value = response.apellidos;
            document.getElementById('direccionEd').value = response.direccion;
            document.getElementById('correoEd').value = response.email;
            document.getElementById('fechaNacEd').value = response.fechNac;  
        }
        
    }
}

// Editar los datos
function editarDatos(){
    let idUsuario = localStorage.getItem("idUsuarioActual");

    let nick = document.getElementById('nickEd').value.trim();
    let clave = document.getElementById('passwordEd').value.trim();
    let nombre = document.getElementById('nombreEd').value.trim();
    let apellidos = document.getElementById('apellidosEd').value.trim();
    let direccion = document.getElementById('direccionEd').value.trim();
    let email = document.getElementById('correoEd').value.trim();
    let fechNac = document.getElementById('fechaNacEd').value;

    let aux =
            {
                "idUsuario" : idUsuario,
                "apellidos" : apellidos,
                "clave" : clave,
                "direccion" : direccion,
                "email" : email,
                "fechNac" : fechNac,
                "nick" : nick,
                "nombre" : nombre
            }

            let request = new XMLHttpRequest();

            request.open("PUT","http://localhost:4000/rest/usuario/editarUsu",true);
            request.setRequestHeader("content-type","application/json;charset=utf-8");
            request.send(JSON.stringify(aux));

            request.onreadystatechange = function() {
                if(this.readyState == 4 && this.status == 200){
                    let response = this.response;
                    
                    if(response == 1){
                        location.href = "../index.html";
                    }
                    else
                        document.getElementById("mensajeErrorEd").innerHTML = "El nick ya existe ya existe!!!";
                } 
            }

}

// Crear Torneo textarea
function descriSize(){
    let descripcionCt = document.getElementById("descripcionCt");
    if(descripcionCt.value.length >= 171 && descripcionCt.value.length <=220)
        descripcionCt.style.border = "2px green solid";
    else
        descripcionCt.style.border = "2px red solid";

}

// Obtener tarjetas de un idUsuario
function traerTarjetasByUsu(){
    let idUsuario = localStorage.getItem("idUsuarioActual");

    let request = new XMLHttpRequest();

    request.open("GET","http://localhost:4000/rest/tarjeta/all/"+idUsuario,true);
    request.setRequestHeader("content-type","application/json;charset=utf-8");
    request.send();

    request.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            let response = JSON.parse(this.response);
          
            if(response != null){
                document.getElementsByClassName("inputTar")[0].value = response[0].numero;
                document.getElementsByClassName("inputTar")[1].value = response[0].propietario;
                document.getElementsByClassName("inputTar")[2].value = response[0].fechCaducidad;
                document.getElementsByClassName("inputTar")[3].value = response[0].cvv;

                for(let i = 0; i<response.length; i++){
                    let nodoPrincipal = document.getElementById('containerPadreParaTarjetas');

                    let li = document.createElement('li');
                    nodoPrincipal.appendChild(li);
                    let a = document.createElement('a');
                    a.className = "dropdown-item";
                    a.href = "#";
                    a.innerHTML = "XXXXXXXXXXXX" + response[i].numero.substring(response[i].numero.length - 4, response[i].numero.length);
                    a.addEventListener("click", function(){cambioInfoTarPerf(event,response[i].numero)})
                    li.appendChild(a);
                }
            }
        }   
        
    }
}

// Cambiar info de las tarjetas en perfil
function cambioInfoTarPerf(event,numero){

    let request = new XMLHttpRequest();

    request.open("GET","http://localhost:4000/rest/tarjeta/num/"+numero,true);
    request.setRequestHeader("content-type","application/json;charset=utf-8");
    request.send();

    request.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            let response = JSON.parse(this.response); 

            document.getElementsByClassName("inputTar")[0].value = response.numero;
            document.getElementsByClassName("inputTar")[1].value = response.propietario;
            document.getElementsByClassName("inputTar")[2].value = response.fechCaducidad;
            document.getElementsByClassName("inputTar")[3].value = response.cvv;
            
            
        }
        
    }
    event.preventDefault();
}

// informacion de usuario en perfil
function traerInfoUsuPerf(){
    let idUsuario = localStorage.getItem("idUsuarioActual");

    let request = new XMLHttpRequest();

    request.open("GET","http://localhost:4000/rest/usuario/mostrarUsu/"+idUsuario,true);
    request.setRequestHeader("content-type","application/json;charset=utf-8");
    request.send();

    request.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            let response = JSON.parse(this.response);
            // console.log(response);
        
            document.getElementById('nickP').innerHTML += response.nick;

            if(response.club == null){
                document.getElementById('clubP').innerHTML += "-"; 
            }else
                document.getElementById('clubP').innerHTML += response.club;

            document.getElementById('subP').innerHTML += response.tipoUsuario.descripcion;
            document.getElementById('nombreP').innerHTML += response.nombre;
            document.getElementById('apellidosP').innerHTML += response.apellidos; 
        }
        
    }
}

// Eliminar tarjeta en perfil
function eliminarTarjeta(){
    let numero = document.getElementsByClassName('inputTar')[0].value;
    let idUsuario = localStorage.getItem("idUsuarioActual");

    let request = new XMLHttpRequest();

            request.open("DELETE","http://localhost:4000/rest/tarjeta/deleteTar/"+numero+"/"+idUsuario,true);
            request.setRequestHeader("content-type","application/json;charset=utf-8");
            request.send();

            request.onreadystatechange = function() {
                if(this.readyState == 4 && this.status == 200){
                    let response = this.response;
                    console.log(response);
                    if(response == 1){
                        window.location.href = "../html/perfil.html";
                    }
                    
                        
                } 
            }
}

// Añadir Tarjeta
function addTarjeta(){
    let idUsuario = localStorage.getItem("idUsuarioActual");

    let numero = document.getElementsByClassName("inputTar")[0].value;
    let propietario = document.getElementsByClassName("inputTar")[1].value;
    let fechCaducidad = document.getElementsByClassName("inputTar")[2].value;
    let cvv = document.getElementsByClassName("inputTar")[3].value;


    if(numero.length == 16 && new Date(Date.now()) < new Date(fechCaducidad) && cvv.length <= 4){
        let aux = 
        {
            "numero": numero,
            "propietario": propietario,
            "fechCaducidad": fechCaducidad,
            "cvv": cvv
        }

        let request = new XMLHttpRequest();

            request.open("POST","http://localhost:4000/rest/tarjeta/addTar/"+idUsuario,true);
            request.setRequestHeader("content-type","application/json;charset=utf-8");
            request.send(JSON.stringify(aux));

            request.onreadystatechange = function() {
                if(this.readyState == 4 && this.status == 200){
                    let response = this.response;
                    
                    if(response == 1){
                        window.location.href = "../html/perfil.html";
                    }
                    
                } 
            }
    }
}

// Pagar Sub
function pagoSub(idTipoUsuDes){
    let aux = JSON.parse(localStorage.getItem("logeado"));

    if(aux){
        document.getElementsByClassName('containerPasarelaDePago')[0].style.display = "block";

        document.getElementsByClassName('containerPasarelaDePago')[0].style.height = '0';
        
        document.getElementsByClassName('subTipoUsu')[0].addEventListener('click', function(){suscribirse(idTipoUsuDes)});
    }else
        location.href = "../html/iniciarSesion.html";
}

function cancelarPago(){
    document.getElementsByClassName('containerPasarelaDePago')[0].style.display = "none";
}

function suscribirse(idTusu){
    let idUsuario = localStorage.getItem("idUsuarioActual");
    let numero = document.getElementsByClassName("inputTar")[0].value;

    let request = new XMLHttpRequest();

            request.open("PUT","http://localhost:4000/rest/usuario/suscribirseTusu/"+idUsuario+"/"+idTusu+"/"+numero,true);
            request.setRequestHeader("content-type","application/json;charset=utf-8");
            request.send();

            request.onreadystatechange = function() {
                if(this.readyState == 4 && this.status == 200){
                    let response = this.response;
                    
                    if(response == 1){
                        location.href = "../index.html";
                    }else
                        addTarjeta();
                        suscribirse(idTusu);
                }
            }

}

window.onbeforeunload = function(e) {
    document.getElementById('tipoJuego').value = "Selecciona un tipo de juego";
};



