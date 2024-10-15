//@ts-check


import { checkString, getElementByIdOrThrow } from "./helper";


/**
 * Validates the form
 * @param {HTMLInputElement} username
 * @param {HTMLInputElement} name
 * @param {HTMLInputElement} password
 * @param {HTMLInputElement} confirmPassword
 * @param {HTMLInputElement} email
 * @param {HTMLSelectElement} province
 * @param {HTMLInputElement} tos
 * @param {HTMLDivElement} div
 */
function formValidation (username, name, password, confirmPassword, email, province, tos, div) {

    const minPasswordLen = 5;
    const minLen = 4; 

    const usernameObj = checkString(username.value, minLen);
    const nameObj = checkString(name.value, minLen)
    const passwordObj = checkPassword(password.value, confirmPassword.value, minPasswordLen)
    const emailObj = checkEmail(email.value, minLen);
    const isProvinceSelected = province.selectedIndex != 0;

    
    
    const inputObjects = [usernameObj, nameObj, passwordObj, emailObj];
    const allInputsValid = inputObjects.every(obj => obj.success && obj.value !== null) && tos.checked && isProvinceSelected;

    if(allInputsValid){
        // subject to change
        const selectedIndex = province.selectedIndex;
        const selectedItem = province[selectedIndex].textContent; 
        div.insertAdjacentHTML( "afterend" , displaySuccessOutput(usernameObj.value, nameObj.value, emailObj.value, selectedItem));
    } else {
        
        if(!usernameObj.success){
            username.parentElement.classList.add("input-group-Error");
        }
        if (!nameObj.success){
            name.parentElement.classList.add("input-group-Error");
        } 
        if (!passwordObj.success){
            password.parentElement.classList.add("input-group-Error");
            confirmPassword.parentElement.classList.add("input-group-Error")
        } 
        if (!emailObj.success) {
            email.parentElement.classList.add("input-group-Error");
        } 
        if (!isProvinceSelected) {
            province.parentElement.classList.add("input-group-Error");
        } 
        if (!tos.checked) {
            tos.parentElement.classList.add("input-group-Error");
        }
    }
    



}


try {


    /** @type {HTMLFormElement} */
    const form = getElementByIdOrThrow("submitBTN");

    /** @type {HTMLInputElement}*/
    const userName = getElementByIdOrThrow('username');
    
    /** @type {HTMLInputElement}*/
    const name = getElementByIdOrThrow("name");

    /** @type {HTMLInputElement}*/
    const password = getElementByIdOrThrow("password");

    /** @type {HTMLInputElement}*/
    const confirmPassword = getElementByIdOrThrow("confirmPassword");

    /** @type {HTMLInputElement}*/
    const email = getElementByIdOrThrow("email");

    /** @type {HTMLSelectElement}*/
    const province = getElementByIdOrThrow("province");

    /** @type {HTMLInputElement}*/
    const tos =  getElementByIdOrThrow("tos");


    /** @type {HTMLInputElement} */
    const reset = getElementByIdOrThrow("resetBTN");

    /** @type {HTMLDivElement} */
    const resultOutput = getElementByIdOrThrow("result");

    form.addEventListener("click", () => formValidation(userName, name, password, confirmPassword, email, province, tos, resultOutput))
    // sumbit.addEventListener("submit", (event) => {
    //     event.preventDefault();
    //     formValidation(userName, name, password, confirmPassword, email, province, tos, div)
    // })
    reset.addEventListener("click", () => resetForm(userName, name, password, confirmPassword, email, province, tos))


    // INPUT EVENTS
    userName.addEventListener("input", () => {
        if (userName.parentElement.classList.contains("input-group-Error")) {
            userName.parentElement.classList.remove("input-group-Error");
        }
    });
    name.addEventListener("input", () => {
        if (name.parentElement.classList.contains("input-group-Error")) {
            name.parentElement.classList.remove("input-group-Error");
        }
    });
    password.addEventListener("input", () => {
        if (password.parentElement.classList.contains("input-group-Error")) {
            password.parentElement.classList.remove("input-group-Error");
  
        }
    });
    confirmPassword.addEventListener("input", () => {
        if (
            password.parentElement.classList.contains("input-group-Error") || 
            confirmPassword.parentElement.classList.contains("input-group-Error")
        ) {
            password.parentElement.classList.remove("input-group-Error");
            confirmPassword.parentElement.classList.remove("input-group-Error");
        }
    });
    email.addEventListener("input", () => {
        if (email.parentElement.classList.contains("input-group-Error")) {
            email.parentElement.classList.remove("input-group-Error");
        }
    });
    province.addEventListener("input", () => {
        if (province.parentElement.classList.contains("input-group-Error")) {
            province.parentElement.classList.remove("input-group-Error");
        }
    });
    tos.addEventListener("input", () => {
        if (tos.parentElement.classList.contains("input-group-Error")) {
            tos.parentElement.classList.remove("input-group-Error");
        }
    });
    

    
} catch (error) {
    console.error(error);
    
}


// 
/**
 * check string if it corresponds with the regex pattern
 * @param {string | null} value
 * @param {number} [minLen = 0]
 * @returns {{success: boolean, value: string | null}}  An object containing:
 *   - success: true if regex was successful, false otherwise
 *   - value: the value after regex if successful, null otherwise.
 */
function checkEmail(value, minLen = 0){
	const regExp = new RegExp("((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])");
	if (typeof value !== "string") {
		return { success: false, value: null };
	}

	const trimmedValue = value.trim();
	if (trimmedValue === "") {
		return { success: false, value: null };
	}

	const valueLength = value.length;
	if (valueLength < minLen) {
		return { success: false, value: null };
	}

	if (regExp.test(value)) {
		return { success: true, value: value };
	} else {
		return { success: false, value: null };
	}
}

/**
 * check string if it corresponds with the regex pattern
 * @param {string | null} password
 * @param {string | null} confirmPassword
 * @param {number} [minLen = 0]
 * @returns {{success: boolean, value: string | null}}  An object containing:
 *   - success: true if regex was successful, false otherwise
 *   - value: the value after regex if successful, null otherwise.
 */
function checkPassword(password, confirmPassword, minLen = 0) {
    const isStrPwd = typeof password !== "string";
    const isStrConfPwd = typeof confirmPassword !== "string";

    const pwdLen = password.length;
    const confPwdLen = confirmPassword.length;

    if(isStrPwd || isStrConfPwd) {
        return { success: false, value: null };
    }

    if(pwdLen < minLen || confPwdLen < minLen) {
        return { success: false, value: null };
    }

    if(password == confirmPassword) {
        return { success: true, value: password};
	} else {
		return { success: false, value: null };
    }


}

// return a div with a formatted list need to add all of the input information ie(username, name, pwd, ETC)
/**
 * returns div and a list of the userInputed information
 * @param {string} username
 * @param {string} name
 * @param {string} email
 * @param {string} province
 * @returns {string} return a list to display the inputed information
 */
function displaySuccessOutput (username, name, email, province) {
    return `
    <div>
        <ul>
            <li>${username}</li>
            <li>${name}</li>
            <li>${email}</li>
            <li>${province}</li>
        </ul>
    </div>`
}


/**
 * Reset the form
 * @param {HTMLInputElement} username
 * @param {HTMLInputElement} name
 * @param {HTMLInputElement} password
 * @param {HTMLInputElement} confirmPassword
 * @param {HTMLInputElement} email
 * @param {HTMLSelectElement} province
 * @param {HTMLInputElement} tos
 */
function resetForm(username, name, password, confirmPassword, email, province, tos) {
    username.value = "";
    username.parentElement.classList.remove("input-group-Error")
    
    name.value = "";
    name.parentElement.classList.remove("input-group-Error");
    
    password.value = "";
    password.parentElement.classList.remove("input-group-Error");
    
    confirmPassword.value = "";
    confirmPassword.parentElement.classList.remove("input-group-Error");
    
    email.value = "";
    email.parentElement.classList.remove("input-group-Error");
    
    province.selectedIndex = 0;
    province.parentElement.classList.remove("input-group-Error");

    tos.checked = false;
    tos.parentElement.classList.remove("input-group-Error");
}