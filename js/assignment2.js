// @ts-check

import { tryParseInt } from "./helper";

/**
 * @param {Number} number
 * @returns {string}
 */

function getOrdinal(number) {
	const ordinals = ["first", "second", "third", "fourth", "fifth"];
	return ordinals[number] || ordinals[0];
}

/**
 * @summary Gets user input and display the highest number.
 * @returns {void}
 */

function getUserInputPrompt() {
	const numberList = [];
	let validNumberEntered = true;
	let result;
	let message;

	while (true) {
		let arrayLength = getOrdinal(numberList.length);
		message = `Please enter your ${arrayLength} number`;

		if (!validNumberEntered) {
			message = "Please enter a valid number!!";
		}

		let userInput = prompt(message);
		result = tryParseInt(userInput);
		if (result.success) {
			validNumberEntered = true;
			numberList.push(/** @type {Number}*/ (result.value));
		} else {
			validNumberEntered = false;
		}

		if (numberList.length > 4) {
			break;
		}
	}

	const hasZero = numberList.includes(0);
	const largestNumber = Math.max.apply(Math, numberList);

	if (hasZero && largestNumber === 0) {
		message = "The largest number entered: 0.";
	} else {
		message = `The numbers you entered were ${numberList.join(
			", "
		)} \nThe largest number entered: ${largestNumber}.`;
	}

	alert(message);
}

getUserInputPrompt();
