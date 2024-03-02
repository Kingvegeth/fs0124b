let elms = document.getElementsByClassName("splide");

for (let i = 0; i < elms.length; i++) {
  new Splide(elms[i], {
    height: 200,
    fixedWidth: 290,
    gap: 5,
    rewind: true,
    pagination: false,
    isNavigation: true,
    focus: "center",
  }).mount();
}
