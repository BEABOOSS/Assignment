import { getElementByIdOrThrow } from "./helper";




/**
 * Update progress bar until 
 * @param {HTMLDivElement} div 
 * @param {number} maxWidth parent div max width
 * @param {number} delay in miliseconds
 * @param {number} increment 
 * @returns {boolean}
 */
function update(div, maxWidth, delay, increment) {
    let id = setInterval(frame, delay);
    function frame() {
        if (div.offsetWidth <= (maxWidth - increment)){
            div.style.width = (div.offsetWidth + increment) + "px";
        } else {
            clearInterval(id);
        }
    }


    // let id = setInterval(() => update(div, maxWidth, delay, increment), delay);

    // if(div.offsetWidth < (maxWidth - increment)){
    //     console.log(div.offsetWidth);
    //     div.style.width = (div.offsetWidth + increment) + "px";
    //     clearInterval(id);
    //     return false;
    // } else {
    //     div.style.width = "100%"; 
    //     return true;
    // }
}
/**
 * needs to update all 5 pbs
 * need a check to see who won the race
 * then checks if the user was right`
 * 
 */
function race() { 
    /** @type {HTMLDivElement}*/
    const vehicleA = getElementByIdOrThrow("statusbarA");
    /** @type {HTMLDivElement}*/
    const vehicleB = getElementByIdOrThrow("statusB");

    
    /** @type {HTMLDivElement}*/
    const vehicleC = getElementByIdOrThrow("statusbarC");
    /** @type {HTMLDivElement}*/
    const vehicleD = getElementByIdOrThrow("statusbarD");
    /** @type {HTMLDivElement}*/
    const vehicleE = getElementByIdOrThrow("statusbarE");
    // const vehicleList = [vehicleA, vehicleB, vehicleC, vehicleD, vehicleE];  

    // generate random numbers


    update(vehicleB, 500, 1000, 10);
    

}





/** @type {HTMLInputElement} */
const button = getElementByIdOrThrow("startRace");

button.addEventListener("click", () => {
    race();
})



// const parentdiv = getElementByIdOrThrow("statusbar");
// const childDiv = getElementByIdOrThrow("status");
// parentdiv.addEventListener("click", () => update(childDiv, 500, 100, 15));