var listaLol = ["../assets/lol/loltor1.webp", "../assets/lol/loltor2.jpg", "../assets/lol/loltor3.jpg", "../assets/lol/loltor4.webp", "../assets/lol/loltor5.jpg", "../assets/lol/loltor6.jpg"];

var listPoke = ["../assets/pokemon/poketor1.jpg", "../assets/pokemon/poketor2.jpg", "../assets/pokemon/poketor3.jpg", "../assets/pokemon/poketor4.jpg", "../assets/pokemon/poketor5.jpg", "../assets/pokemon/poketor6.jpg"];

var listFifa = ["../assets/fifa/fifator1.jpg", "../assets/fifa/fifator2.jpg",  "../assets/fifa/fifator3.jpg", "../assets/fifa/fifator4.png", "../assets/fifa/fifator5.jpg", "../assets/fifa/fifator6.jpg"];

var listClash = ["../assets/royal/royaltor1.jpg" , "../assets/royal/royaltor2.jpg", "../assets/royal/royaltor3.jpg", "../assets/royal/royaltor4.jpg", "../assets/royal/royaltor5.jpg", "../assets/royal/royaltor6.jpg"];


function seleccionarImgTorneo(){
    let aux = document.getElementsByClassName('selectTipoJuego')[0].value;

    if(aux != "Selecciona un tipo de juego"){
        document.getElementsByClassName('selectorDeImgFlotante')[0].style.display = 'grid';
    }
}

function imgCrearTorneo(event){
    let url = "../assets/" +event.target.src.split('/')[4]+"/"+ event.target.src.split('/')[5];
    console.log(url);
    document.getElementsByClassName('imgCrearTorneoPrin')[0].style.display = 'block'; 
    document.getElementsByClassName('imagenFoto')[0].style.display = 'none';

    document.getElementsByClassName('imgCrearTorneoPrin')[0].src = url;

    document.getElementsByClassName('selectorDeImgFlotante')[0].style.display = 'none';

}

function cambioJuego(event){
    document.getElementsByClassName('imgCrearTorneoPrin')[0].style.display = 'none'; 
    document.getElementsByClassName('imagenFoto')[0].style.display = 'block';

    let juego = event.target.value;

    console.log(event.target.value);
    // Rellenar las imagenes del flotante con el array de imagenes correspondientes

    let listImgHtml = document.getElementsByClassName('listaImgCrearTorneo');

    switch(juego){
        case "League of Legends":
            mixImg(listImgHtml,listaLol);
            break;
        case "Pokemón":
            mixImg(listImgHtml, listPoke);
            break;
        case "Fifa 22":
            mixImg(listImgHtml,listFifa);
            break;
        case "Clash Royale":
            mixImg(listImgHtml, listClash);
            break;
        // Completar con más juegos
    }


}

function subsPagoTor(){
    let idUsuario = localStorage.getItem("idUsuarioActual");

    let request = new XMLHttpRequest();

    request.open("GET","http://localhost:4000/rest/usuario/tipoUsu/"+idUsuario,true);
    request.setRequestHeader("content-type","application/json;charset=utf-8");
    request.send();

    request.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200){
            let response = JSON.parse(this.response);
            if(response.descripcion != "Normal")
                document.getElementById("precio").disabled = false;
            else
                document.getElementById("precio").disabled = true;
            
        }
        
    }
}



// Función auxiliar
function mixImg(list1, list2){
    for(let i = 0; i<6;i++){
        list1[i].src = list2[i];
    }
}
