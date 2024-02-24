window.addEventListener("scroll", function () {
  let scrollThreshold = 310;
  let scrollH = window.scrollY;
  let navBar = document.getElementById("nav-bar");
  let button = this.document.getElementsByClassName("btn");
  if (scrollH >= scrollThreshold) {
    navBar.style.backgroundColor = "#fff";
    button[0].style.backgroundColor = "#1a8917";
  } else if (scrollH < scrollThreshold) {
    navBar.style.backgroundColor = "#ffc017";
    button[0].style.backgroundColor = "#000";
  }
});

let author =  document.getElementsByClassName("author");
let tooltip = document.getElementsByClassName("tooltip");

for (let i = 0; i < author.length; i++) {
  let followerNumber = Math.ceil(Math.random() * 20);
  let firstName = document.getElementsByClassName('first-name');
  let authorName = firstName[i].outerText;

  let imgTag = author[i].querySelector("img");
  let imgSrc = imgTag.getAttribute("src");

  let tooltipCode = `
<div class="author-tooltip">    
    <img src="${imgSrc}" alt="author thumb">
    <span>${authorName}</span>
</div>
<p>Author</p>
<p class="followers">${followerNumber}k Followers <button class="btn dyn-btn">Follow</button></p>`;


  tooltip[i].innerHTML = tooltipCode;
}
