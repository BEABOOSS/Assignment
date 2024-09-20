// @ts-check

import { checkString, getElementByIdOrThrow } from "./helper";

// Daily Assignment 4

// Create a function that takes an array of names, 
// and reverses the contents by copying it into another array, 
// then returns the result, then output the result to a div with 
// the id "results". create a button to activate the function. 
// Give the button a value of "Reverse Names" 

/**
 * @summary takes an array of strings and returns the content reversed
 * @param {string[]} arrayString array of strings
 * @returns {string[]} 
 */

function reverseString(arrayString){

    let reverseArray = [];
    arrayString.map(x => {
        reverseArray.push(x.split("").reverse().join(""));
    });

    return reverseArray;
}


try {


    /** @type {HTMLButtonElement}*/
    const button = getElementByIdOrThrow("reverseNames");

    /** @type {HTMLDivElement}*/
    const resultDiv = getElementByIdOrThrow("results");

    /** @type {HTMLInputElement}*/
    const nameOne = getElementByIdOrThrow("nameOne");

    /** @type {HTMLInputElement}*/
    const nameTwo = getElementByIdOrThrow("nameTwo");

    /** @type {HTMLInputElement}*/
    const nameThree = getElementByIdOrThrow("nameThree");

    /** @type {HTMLInputElement}*/
    const nameFour = getElementByIdOrThrow("nameFour");

    /**
     *  Assigns and processes input string
     */
    function assignString() {

        const inputElement = [nameOne, nameTwo, nameThree, nameFour];
        const nameObject = inputElement.map(element => checkString(element.value));

        const allNamesValid = nameObject.every(obj => obj.success && obj.value !== null);

        
        if(allNamesValid) {

            // asserting that reversed is an array of strings
            const reversed = reverseString(nameObject.map(obj => /** @type {string}*/(obj.value)))
            const outputString = reversed.join(", ");

            resultDiv.innerText = outputString;
            
        } else {
            resultDiv.innerText = "Please make sure that all fields are filled out."
        }

    }

    button.addEventListener("click", assignString)
} catch (error) {
    console.error(error);
}


// output: orginal array: Warren,Emely,alex,Megan
// output: reversing every element : nerraW,ylemE,xela,nageM