const apiKey =
  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWViMjgzYzJkN2IxMTAwMTkwZTc4NzYiLCJpYXQiOjE3MDk5MTAwNzYsImV4cCI6MTcxMTExOTY3Nn0.HqcexqGNSl7i4qmZa0KoaCqgrH1usfWNQ8ZKO-8DIsQ";
const auth = "Bearer " + apiKey;

let currentUrl = window.location.pathname.split("?")[0];
console.log("La pagina corrente è:", currentUrl);

let urlParams = new URLSearchParams(location.search);
let productId = urlParams.get("_id");

//CREAZIONE DELLA PAGINA CON LE CARD DEI PRODOTTI
if (currentUrl === "/index.html") {
  fetch("https://striveschool-api.herokuapp.com/api/product/", {
    headers: {
      "Content-type": "application/json",
      Authorization: auth,
    },
  })
    .then((res) => res.json())
    .then((phones) => {
      displayCards(phones);
    });

  function displayCards(phones) {
    let shelf = document.getElementById("shelf");

    phones.forEach((product) => {
      let card = generaClone();

      card.querySelector(".card-img-top").src = product.imageUrl;
      card.querySelector(".card-title").textContent = product.name;
      card.querySelector(".description").textContent = product.description;
      card.querySelector(".price").textContent =
        "Prezzo: " + product.price + "€";
      card.querySelector(".badge").textContent = product.brand;
      card.querySelector(
        ".card-edit"
      ).href = `./edit_product.html?_id=${product._id}`;
      card.querySelector(
        ".card-more-info"
      ).href = `./view_product.html?_id=${product._id}`;
      shelf.appendChild(card);
    });
  }

  function generaClone() {
    let template = document.querySelector("#card-template");
    let clone = template.content.cloneNode(true);
    return clone;
  }
} else if (
  currentUrl === "/edit_product.html" ||
  currentUrl === "/add_product.html"
) {
  //PAGINE DI AGGIUNTA E MODIFICA PRODOTTO

  let saveBtn = document.querySelector(".save-btn");

  let fetchUrl = "https://striveschool-api.herokuapp.com/api/product/";
  let fetchMethod = "POST";

  if (productId) {
    fetchUrl =
      "https://striveschool-api.herokuapp.com/api/product/" + productId;
    fetchMethod = "PUT";
  }

  saveBtn.addEventListener("click", function (e) {
    e.preventDefault();

    let name = document.querySelector("#product-name").value;
    let price = document.querySelector("#product-price").value;
    let brand = document.querySelector("#product-brand").value;
    let imageUrl = document.querySelector("#product-image").value;
    let description = document.querySelector("#product-description").value;

    let smartphone = {
      name,
      price,
      brand,
      imageUrl,
      description,
    };

    let alert = document.querySelector(".alert");
    if (!name || !price || !brand || !imageUrl) {
      alert.classList.remove('d-none')
    } else {
      fetch(fetchUrl, {
        method: fetchMethod,
        headers: {
          "Content-type": "application/json",
          Authorization: auth,
        },
        body: JSON.stringify(smartphone),
      })
        .then((res) => res.json())
        .then((res) => {
          console.log(res);
          window.location.href = "index.html";
        });
    }
  });

  if (currentUrl === "/edit_product.html") {
    
    
    //Riempie automaticamente le value degli input all'apertura della pagina

      fetch(`https://striveschool-api.herokuapp.com/api/product/${productId}`, {
        method: "GET",
        headers: {
          "Content-type": "application/json",
          Authorization: auth,
        },
      })
        .then((response) => response.json())
        .then((product) => {
          document.getElementById("product-name").value = product.name;
          document.getElementById("product-brand").value = product.brand;
          document.getElementById("product-price").value = product.price;
          document.getElementById("product-image").value = product.imageUrl;
          document.getElementById("product-description").value =
            product.description;
        })
        .catch((error) =>
          console.error("Error fetching product details:", error)
        );
    

    //gestione del pulsante delete

    let deleteBtn = document.querySelector(".delete-btn");

    deleteBtn.addEventListener("click", function () {
      fetch(fetchUrl, {
        method: "DELETE",
        headers: {
          "Content-type": "application/json",
          Authorization: auth,
        },
      })
        .then((res) => res.json())
        .then((res) => {
          console.log(res);
          window.location.href = "index.html";
        });
    });
  }
} else if (currentUrl = '/view_product.html') {

    fetch(`https://striveschool-api.herokuapp.com/api/product/${productId}`, {
        headers: {
            'Content-type': 'application/json',
            'Authorization': auth
        }
    })
    .then(res => res.json())
    .then(phone => {
        
        displayProduct(phone);
    })
        
    

    function displayProduct(product) {

        let details = document.getElementById('product-details');
        let cardImage = details.querySelector('.card-img-top');
        let badge = details.querySelector('.badge');
        let cardTitle = details.querySelector('.card-title');
        let description = details.querySelector('.description');
        let price = details.querySelector('.price');

        cardImage.src = product.imageUrl;
        badge.textContent = product.brand;
        cardTitle.textContent = product.name;
        description.textContent = product.description;
        price.textContent = product.price + "€";
    }

}
