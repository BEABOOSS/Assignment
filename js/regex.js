import { checkString, getElementByIdOrThrow } from "./helper";

/**
 
 */
function replaceWordFunc(){
    
    const paragraph = checkString(/** @type {HTMLTextAreaElement} */(getElementByIdOrThrow("paragraph")).value, 3);
    const findWord = checkString(/** @type {HTMLInputElement} */(getElementByIdOrThrow("findWord")).value);
    const replaceWord = checkString(/** @type {HTMLInputElement} */(getElementByIdOrThrow("replaceWord")).value);

    if(!findWord.success){
        alert("Please Enter a word to find.")        
        return;
    }
    
    if(!replaceWord.success){
        alert("Please Enter a word to replace with.")        
        return;
    }


    if(!paragraph.success){
        alert("Please enter a sentence.")        
        return;
    }
    
    // @ts-expect-error
    if(paragraph.value.includes(`${findWord.value} `)){
        // @ts-expect-error
        let newStr = paragraph.value.replaceAll(`${findWord.value} `, `'${replaceWord.value}'`);
        console.log(paragraph.value);
        
        alert(`${findWord.value} has been replaced with ${replaceWord.value}. \n${newStr}`)
    } else {
        alert("It appears that '" + findWord.value + "' was not found in the sentence.")
    }
    
};


/** @type {HTMLInputElement} */
const btn = getElementByIdOrThrow("btnReplace");

btn.addEventListener("click", () => replaceWordFunc());
