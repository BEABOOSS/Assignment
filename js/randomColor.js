// @ts-check

import { getElementByIdOrThrow } from "./helper";
// arstarstarsoteinarosietn~


/**
 * Gets a random color
 * @return {String} color
 */
function getRandomColor() {
    // const color = ['teal', 'brown', 'red', 'yellow', 'orange', 'green', 'blue', 'white', 'purple', 'pink'];
    const colorRGBA = [
        'rgba(0, 128, 128, 0.6)',    // teal
        'rgba(165, 42, 42, 0.6)',    // brown
        'rgba(255, 0, 0, 0.6)',      // red
        'rgba(255, 255, 0, 0.6)',    // yellow
        'rgba(255, 165, 0, 0.6)',    // orange
        'rgba(0, 128, 0, 0.6)',      // green
        'rgba(0, 0, 255, 0.6)',      // blue
        'rgba(255, 255, 255, 0.6)',  // white
        'rgba(128, 0, 128, 0.6)',    // purple
        'rgba(255, 192, 203, 0.6)'   // pink
      ];
    const rndNum = Math.floor(Math.random() * colorRGBA.length);

    return colorRGBA[rndNum];
}

/**
 * Get random color and sets the backgroud color 
 * @param {HTMLDivElement} element
 */
function changeBackground(element){
    const color = getRandomColor()
    if(element.style.backgroundColor !== "black"){
        element.style.color = "black";
    }
    element.style.backgroundColor = color;
    console.log(`Color: ${color}`);
}


/** @type {HTMLDivElement} */
const divElement = getElementByIdOrThrow("click");

divElement.addEventListener("click", () => changeBackground(divElement))
