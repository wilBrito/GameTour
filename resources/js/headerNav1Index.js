
if(localStorage.getItem("logeado") == null){
    localStorage.setItem("logeado", JSON.stringify(false));
}


// Navegador logeado y sin logear
function logueadoTrueFalse(){
    let loginF = document.getElementsByClassName("login-f");
    let loginT = document.getElementsByClassName("login-t");
    
    if(JSON.parse(localStorage.getItem("logeado"))){
        for(let i = 0; i < loginF.length; i++){
            loginF[i].style.display = "none";
        }
        for(let j = 0; j < loginT.length; j++){
            loginT[j].style.display = "block";
        }
    }
    else{
        for(let i = 0; i < loginF.length; i++){
            loginF[i].style.display = "block";
        }
        for(let j = 0; j < loginT.length; j++){
            loginT[j].style.display = "none";
        }
    }
}


// Responsive
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
         x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}

// Barra nav fija
window.onscroll = function() {
    var y = window.scrollY;

    let nav = document.getElementsByClassName('containerNav')[0];
    let ajuste = document.getElementsByClassName('conteinerTxtImgPrincipal')[0];

    if(y >= 40){
        nav.style.position = 'fixed';
        nav.style.top = '0';

        ajuste.style.marginTop = '5rem';
    }
    else{
        nav.style.position = '';
        ajuste.style.marginTop = '0';
    }
  };


  // Arreglo bug barra
  window.onresize = function(){
    var x = screen.width;
    console.log(x);
    if(x<=900){

      let loginF = document.getElementsByClassName("login-f");
      let loginT = document.getElementsByClassName("login-t");

      for(let i = 0; i < loginF.length; i++){
          loginF[i].style.display = "none";
      }
      for(let j = 0; j < loginT.length; j++){
          loginT[j].style.display = "none";
      }
  }
}
