

import { checkString, getElementByIdOrThrow, tryParseInt } from "./helper";

class SurveyResult {
    
    constructor(email, age, color){
        this.email = email;
        this.age = age;
        this.color = color;
    }

    sayResult(){
        return `
            Success!\n
            Thank you for taking the survey.\n
            Here are your results:\n
            Email: ${this.email}\n
            Age: ${this.age}\n
            Choice: ${this.color}\n
        `
    }

    
}





function validateForm() {

    let errormsg = [];
    //get fields from myform by the name attribute
    

	const email = getElementByIdOrThrow("email");
    

	const age = getElementByIdOrThrow("age");
    

    const outputDiv = getElementByIdOrThrow("usermsg");
	
    var radiogroup = document.forms["myform"]["choices"];
    var selected = "none selected";

    const results = new SurveyResult();

    if(outputDiv.innerText !== ""){
        outputDiv.innerText = "";
    }


    //do validation
    if (email.value == null || email.value == "") {
        errormsg.push("Email must be filled out")
    }
    results.email = checkString(email.value).value;



    if (age.value == null || age.value == "") { 
        errormsg.push("Age must be filled out")

    } else if (isNaN(age.value)) {
        errormsg.push("Age must be numeric")
		document.forms["myform"]["age"].value = '';
    }
    results.age = tryParseInt(age.value).value;



    // checks if any of the radio btns are checked

    for (var i = 0; i < radiogroup.length; i++) {
        if (radiogroup[i].checked) {
            selected = radiogroup[i].value;
        }
    }
   

	if (selected != "none selected" && errormsg.length == 0){ 
		outputDiv.innerText = results.sayResult();
	}else if (selected == "none selected"){
		errormsg.push("Choose a color");
	}

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
})