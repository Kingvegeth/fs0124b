
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


let author = document.getElementsByClassName ('author')
let authorName = author[0].innerText

let imgTag = author[0].querySelector('img')
let imgSrc = imgTag.getAttribute('src')


console.log(author[0].innerText);
console.log(author[0].innerHTML);
console.log(imgSrc);