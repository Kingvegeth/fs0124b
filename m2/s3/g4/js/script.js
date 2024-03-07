let loadButton = document.querySelector('.load-button')
let loadButton2 = document.querySelector('.load-button2')
async function chiamata(query){

    const apiKey = 'y6gxROOF6jIPAv0253dTzJQjwwjagsPTTMoCTQFUQDIKT0wNDXIwm4l5';
    
    return await fetch(`https://api.pexels.com/v1/search?query=${query}`, {
        method: 'GET',
        headers: {
            Authorization: apiKey
        }
    }).then(dati => dati.json())
}

loadButton.addEventListener('click', function(){
    chiamata('pasta').then((dati) =>{
        let image = document.querySelectorAll('.card-img-top')
        dati.photos.forEach((foto, i) => {
        
                image[i].src = foto.src.medium
            
        })
    })
})

loadButton2.addEventListener('click', function(){
    chiamata('pizza').then((dati) =>{
        let image = document.querySelectorAll('.card-img-top')
        dati.photos.forEach((foto, i) => {
        
                image[i].src = foto.src.medium
            
        })
    })
})