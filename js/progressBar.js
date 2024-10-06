import { getElementByIdOrThrow } from "./helper";


let interval = false; // keep track of the state of animation


/**
 * Update progress bar until 
 * @param {HTMLDivElement} div element to update
 * @param {number} maxWidth parent div max width
 * @param {number} delay in miliseconds
 * @param {number} increment number
 * @param {string} color
 */
function update(div, maxWidth, delay, increment, color) {
    if (interval){
        return
    }
    let id = setInterval(() => {
        frame(id, div, maxWidth, increment);
        // console.log(`${id}, ${frame(id, div, maxWidth, increment)}`);
    }, delay);
    div.style.backgroundColor = color;
    
}

/**
 * Update progress bar until
 * @param {number} id id of the setInterval 
 * @param {HTMLDivElement} div element to update
 * @param {number} maxWidth parent div max width
 * @param {number} increment number
 */
function frame(id, div, maxWidth, increment) {
    // like (maxWidth % increment === 0) this won't always be true      
    // we need more logic to calculate the progress  
    let isStatusBarFilled = (maxWidth - div.offsetWidth) === (maxWidth % increment);
    if (isStatusBarFilled){
        div.style.width = (div.offsetWidth + (maxWidth % increment)) + "px";
        div.innerHTML = div.offsetWidth + "/500";
        clearInterval(id);
        interval = false;
    } else {
        div.style.width = (div.offsetWidth + increment) + "px";
        div.innerHTML = div.offsetWidth + "/500";
    }
}

/**
 * needs to update all 5 pbs
 * need a check to see who won the race
 * then checks if the user was right`
 * 
 */
function race() { 
    /** @type {HTMLDivElement}*/
    const vehicleA = getElementByIdOrThrow("statusA");
    /** @type {HTMLDivElement}*/
    const vehicleB = getElementByIdOrThrow("statusB");
    /** @type {HTMLDivElement}*/
    const vehicleC = getElementByIdOrThrow("statusC");
    /** @type {HTMLDivElement}*/
    const vehicleD = getElementByIdOrThrow("statusD");
    /** @type {HTMLDivElement}*/
    const vehicleE = getElementByIdOrThrow("statusE");
   
    // generate random numbers
    let intarvalDelay = 500; // 0.5sec
    console.log(
        update(vehicleA, 500, intarvalDelay, randomNum(), "green")

    );
    
    update(vehicleB, 500, intarvalDelay, randomNum(), "blue");
    update(vehicleC, 500, intarvalDelay, randomNum(), "yellow");
    update(vehicleD, 500, intarvalDelay, randomNum(), "purple");
    update(vehicleE, 500, intarvalDelay, randomNum(), "red");
}


/**
 * @return {number} 
*/
function randomNum() {
    return Math.floor(Math.random() * 50);
}





/** @type {HTMLInputElement} */
const button = getElementByIdOrThrow("startRace");

button.addEventListener("click", () => {
    race();
})
// TESTING

function trigger() {
    /** @type {HTMLDivElement} */
    const bar = getElementByIdOrThrow("statusA");

    if (interval){
        return;
    }

    if (bar.offsetWidth >= 500){
        bar.style.width = "0";
        return;
    }
}