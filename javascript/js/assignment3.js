//@ts-check
import { capitalizeFirstLetter, checkString, getElementByIdOrThrow } from "./helper.js";

// Create a function that prompts the user for Firstname and Lastname,
// Output the combined result into a div layer with the id "content"
// with lastname first and firstname last - ie - Jeff McGee would be McGee, Jeff.
// Assign the function to a button.


try {
	/** @type {HTMLButtonElement}*/
	const button = getElementByIdOrThrow("getNames");
	/** @type {HTMLDivElement}*/
	const divElement = getElementByIdOrThrow("content");

	/**
	 * @summary Get first & last name and display them.
	 */

	function GetNAssignNames() {
		const firstname = prompt("Enter First Name:");
		const lastname = prompt("Enter Last Name:");
		const minLen = 4;

		const validateFN = checkString(firstname, minLen);
		const validateLN = checkString(lastname, minLen);

        /** @type {boolean} checks value is not null*/
		const isTrueNnotNull = 
        (validateFN.success && validateFN.value !== null)  &&
        (validateLN.success && validateLN.value !== null);

		// like the object.null can be of type null I need to assert that it is a string
        // IDE yells at me if I don't assert its value to be a string
		if (isTrueNnotNull) {
            validateFN.value = capitalizeFirstLetter(/**@type {string}*/(validateFN.value));
            validateLN.value = capitalizeFirstLetter(/**@type {string}*/(validateLN.value));

			divElement.innerText = `${validateLN.value}, ${validateFN.value}.`;
		} else {
            divElement.innerText = "Please re-enter your first and last name";
		}
	}

	button.addEventListener("click", GetNAssignNames);
} catch (error) {
	console.error(error);
}
