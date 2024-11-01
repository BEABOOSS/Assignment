
let slideIndex = 0;
/** @type {any} */
let intervalId = null;
const slides = /** @type {HTMLCollectionOf<HTMLDivElement>} */(document.getElementsByClassName("slide")); 

showSlides();

/**
 * Sets display to non
 */

function showSlides() {
    // hide all images
    for(let i = 0; i < slides.length; i++){
        slides[i].style.display = "none";
    }
    slideIndex++;
    if(slideIndex > slides.length) {
        slideIndex = 1;
    }
    slides[slideIndex - 1].style.display = "block";

    if(intervalId) {
        clearInterval(intervalId);
    }
    intervalId = setInterval(showSlides, 5000)
}

