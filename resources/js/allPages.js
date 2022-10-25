

function irIndex(){
    location.href = "../index.html";
}

function irTorneos(){
    location.href = "../html/torneos.html";
}

function irCrearTorneo(){
    let aux = JSON.parse(localStorage.getItem("logeado"));
    if(aux)
        location.href = "../html/crearTorneo.html";
    else
        location.href = "../html/iniciarSesion.html";
}


// función cerrar Sesión
function cerrarSesion(){
    localStorage.setItem("logeado", JSON.stringify(false));
    localStorage.setItem("idUsuarioActual", "");
}