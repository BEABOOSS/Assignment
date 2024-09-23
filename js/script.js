

import { checkString, getElementByIdOrThrow, tryParseInt } from "./helper";

class SurveyResult {
    
    constructor(email, age, color){
        this.email = email;
        this.age = age;
        this.color = color;
    }

    sayResult(){
        console.log("first");
        let clr = getCookie("color");
        
        return `
            Success!\n
            Thank you for taking the survey.\n
            Here are your results:\n
            Email: ${this.email}\n
            Age: ${this.age}\n
            Choice: ${this.color}\n
            Color Selected: ${clr}\n
        `
    }

    
}


function validateForm() {

    let errormsg = [];
    //get fields from myform by the name attribute
    

	const email = checkString(getElementByIdOrThrow("email").value);
	const age = tryParseInt(getElementByIdOrThrow("age").value);
    const outputDiv = getElementByIdOrThrow("usermsg");
    const colorSelect = getElementByIdOrThrow("colorSelect").value;
    let radiogroup = document.forms["myform"]["choices"];
    let selected = "none selected";
    const results = new SurveyResult();

    // clears previous message
    if(outputDiv.innerText !== ""){
        outputDiv.innerText = "";
    }

    //email check
    if (!email.success) {
        errormsg.push("Email must be filled out")
    }
    results.email = email.value;

    // age check
    if (!age.success) { 
        errormsg.push("Age must be filled out And A Number");
		document.forms["myform"]["age"].value = '';
    }
    results.age = age.value;

    // Radio button check
    for (let i = 0; i < radiogroup.length; i++) {
        if (radiogroup[i].checked) {
            selected = radiogroup[i].value;
        }
    }
    results.color = selected;

    // checks if color has been selected 
    if(colorSelect == "#000000"){
        errormsg.push("Please a different color");
    }

    // Chece if any error message exist currently
	if (selected != "none selected" && errormsg.length == 0){ 
        setCookie("color", colorSelect, 24);
		outputDiv.innerText = results.sayResult();
        checkCookie(results.color)
	}else if (selected == "none selected"){
		errormsg.push("Choose a color");
	}

    // display error message(s)
    for (const err of errormsg) {
        outputDiv.innerText += `${err}\n`;
    }

}



const outputDiv = getElementByIdOrThrow("usermsg");
const submitBTN = getElementByIdOrThrow("submitform");
const resetBTN = getElementByIdOrThrow("resetForm");

submitBTN.addEventListener("click", () => validateForm());
resetBTN.addEventListener("click", () => {
    outputDiv.innerText = "";
    // Will remove the cookie
    // setCookie("color", "", -1)
})


/**
 * Checks the cookie. 
 * (to see if it can be dipped in milk)
 * @param {string} c_value value of cookie
*/
function checkCookie(c_value) {
    console.log("Second ");
    let color = checkString(getCookie(c_value));
    
    if(!color.success){
        // alert(`Color ${color.value}`)
        console.log("mmmhh tasty");
        
    } else {
        // 
        let color = prompt("Choose a color");
        if(color != null && color != ""){
            setCookie("color", color, 3600);
        }
    }
}

/**
 * Sets the cookie to the page
 * @param {string} c_name name of the cookie
 * @param {string} value value of the cookie
 * @param {number} c_time  (24hr format)expiration date for cookie 
*/
function setCookie(c_name, value, c_time){
    const exdate = new Date();
    exdate.setTime(exdate.getTime() + c_time*60*60*1000)
    const c_value = value + ((c_time == null) ? "" : "; expires=" + exdate.toUTCString())
    document.cookie = c_name + "=" + c_value;
}


/**
 * Gets the cookies from the page
 * @param {string} c_name
*/
function getCookie(c_name) {
    let c_value = document.cookie;
    let c_start = c_value.indexOf(" " + c_name + "=");
    if (c_start == -1) {
        c_start = c_value.indexOf(c_name + "=");
    }
    if (c_start == -1) {
        c_value = null;
    }
    else {
        c_start = c_value.indexOf("=", c_start) + 1;
        let c_end = c_value.indexOf(";", c_start);
        if (c_end == -1) {
            c_end = c_value.length;
        }
        c_value = c_value.substring(c_start, c_end);
    }
    return c_value;
}


// function getCookie(c_name){
//     const name = c_name + "=";
//     // cookie split by ";"
//     let ca = document.cookie.split(";");
//     // loops over the split string
//     for(let i =0; i < ca.length; i++){
//         // characters at index of i
//         let c = ca[i];
//         // sets the character 0 to 1 if whitespace
//         while (c.charAt(0) == " ") c = c.substring(1, c.length);
//         // if c[0] = name then it returns the string without the name and "="
//         if(c.indexOf(name) == 0) return c.substring(name.length, c.length);
//     }
//     return null;
// }

