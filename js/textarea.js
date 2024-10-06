import { getElementByIdOrThrow } from "./helper";

/**
 * @param {HTMLTextAreaElement} limitField field to limit
 * @param {number} limitCount current count of characters present in limitField
 * @param {number} [limitNum=30] max amount of characters allowed (defaults is 30)
 */
function limitText(limitField, limitCount, limitNum=30){    
    /** @type {HTMLInputElement} */
    let counter = getElementByIdOrThrow("counter");

    if(limitCount > limitNum){
        limitField.value = limitField.value.substring(0, limitNum);
        counter.innerHTML = "You have _0_ characters left."
    }

    counter.value = `You have _${limitNum - limitCount}_ characters left.`;
}



/** @type {HTMLTextAreaElement} */
const textarea = getElementByIdOrThrow("limitedTA");

textarea.addEventListener("keydown",() => limitText(textarea, textarea.value.length))
textarea.addEventListener("keyup",() => limitText(textarea, textarea.value.length))