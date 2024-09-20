//@ts-check
import { getElementByIdOrThrow, tryParseInt } from "./helper";

/**
 *
 * @param {Number} age - driver's age needs to be a number
 * @param {Number} numberOfAccidents - number of accidents they had
 * @return {String} returns a string formatted with the totalCost
 */
const totalCostAutoInsurance = (age, numberOfAccidents) => {
	let totalCost = 500;

	if(age < 18){
		return "The driver needs to be at least 18 years old."
	}

	if (age < 25) {
		totalCost += 100;
	}

	if (numberOfAccidents <= 2 && numberOfAccidents >= 1) {
		totalCost += 25;
	} else if (numberOfAccidents == 3) {
		totalCost += 75;
	} else if (numberOfAccidents == 4) {
		totalCost += 75;
	} else if (numberOfAccidents == 5) {
		totalCost += 100;
	} else if (numberOfAccidents > 5) {
		totalCost = 0;
		return `Due to having ${numberOfAccidents} accidents the insurance will not be covering.`;
	}
	return `Total cost will be ${totalCost}$`;
};

try {
	/** @type {HTMLInputElement} */
	const numberAccidentsIn = getElementByIdOrThrow("numberOfAccident");

	/** @type {HTMLInputElement} */
	const ageIn = getElementByIdOrThrow("age");

	/** @type {HTMLButtonElement}*/
	const button = getElementByIdOrThrow("calBTN");

	/** @type {HTMLParagraphElement}*/
	const outputText = getElementByIdOrThrow("output");

	/** @type {HTMLDivElement} */
	const igAge = getElementByIdOrThrow("igAge");

	/** @type {HTMLDivElement} */
	const igNumberAccident = getElementByIdOrThrow("igNumberAccident");

	/**
	 * @summary converts inputs to number and calls {@link totalCostAutoInsurance}
	 * also uses {@link tryParseInt} to check if the value is indeed a Number and null
	 *
	 */
	function costAutoInsurance() {
		const age = tryParseInt(ageIn.value);
		const numberAccidents = tryParseInt(numberAccidentsIn.value);
		if (age.success && numberAccidents.success) {
			const output = totalCostAutoInsurance(
				/** @type {Number}*/ (age.value),
				/** @type {Number}*/ (numberAccidents.value)
			);
			outputText.innerHTML = output;
		} else {
			if (!age.success) {
				// do something
				igAge.classList.add("input-group-Error");
			}
			if (!numberAccidents.success) {
				// do something
				igNumberAccident.classList.add("input-group-Error");
			}
		}

		// show a message showing that they need to enter a number
	}

	button.addEventListener("click", costAutoInsurance);

	ageIn.addEventListener("keypress", function () {
		igAge.classList.remove("input-group-Error");
	});

	numberAccidentsIn.addEventListener("keypress", function () {
		igNumberAccident.classList.remove("input-group-Error");
	});
} catch (err) {
	console.error(err);
}

console.log(totalCostAutoInsurance(21, 2)); //625$
console.log(totalCostAutoInsurance(15, 4)); // needs to be of 18+.
console.log(totalCostAutoInsurance(54, 1)); //525$
console.log(totalCostAutoInsurance(31, 0)); //500$
console.log(totalCostAutoInsurance(23, 7)); //  0$
