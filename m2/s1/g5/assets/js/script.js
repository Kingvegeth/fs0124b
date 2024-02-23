//Cambio colore allo scroll
window.addEventListener('scroll',function(){
    
    let scrollThreshold=310 
    let scrollH = window.scrollY;

    let navBar = document.getElementById('nav-bar')
    let button = this.document.getElementsByClassName('btn')
    
    if (scrollH>= scrollThreshold) {
        navBar.style.backgroundColor='#fff'
        button[0].style.backgroundColor='#1a8917'
    }else if (scrollH<scrollThreshold){
        navBar.style.backgroundColor='#ffc017'
        button[0].style.backgroundColor='#000'
    }

})