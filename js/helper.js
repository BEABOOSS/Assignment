//@ts-check

/**
 * Attempts to parse a string into an integer.
 * @param {string | null} value - The string to parse.
 * @returns {{ success: boolean, value: number | null }} An object containing:
 *   - success: true if parsing was successful, false otherwise.
 *   - value: the parsed integer if successful, null otherwise.
 */
export function tryParseInt(value) {
	if (typeof value !== "string") {
		return { success: false, value: null };
	}

	const trimmedValue = value.trim();
	if (trimmedValue === "") {
		return { success: false, value: null };
	}

	const parsedValue = Number(trimmedValue);
	// @ts-expect-error
	if (Number.isInteger(parsedValue)) {
		return { success: true, value: parsedValue };
	} else {
		return { success: false, value: null };
	}
}

/**
 * @param {string | null} value
 * @param {number} [minLen = 0]
 * @returns {{success: boolean, value: string | null}}  An object containing:
 *   - success: true if regex was successful, false otherwise
 *   - value: the value after regex if successful, null otherwise.
 */
export function checkString(value, minLen = 0) {
	const regExp = new RegExp("^[a-zA-zs]+$");
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
 * Generic version of getElementByIdOrThrow.
 * @template {HTMLElement} T
 * @param {string} id - The ID of the element to find.
 * @returns {T} The found element.
 * @throws {Error} If the element is not found.
 */
export function getElementByIdOrThrow(id) {
    const element = /** @type {T | null} */ (document.getElementById(id));
    if (!element) {
        throw new Error(`Element doesn't exist: "${id}"`);
    }
    return element;
}



/**
 * Capitalize first letter and concats the rest of the string
 * @param {string} string input string
 * @returns {string} returns the string with the first capitelized
 */
export function capitalizeFirstLetter(string){
	return string.charAt(0).toUpperCase() + string.slice(1);
 }


/**
 * Takes any union type and excludes `null`
 * @template T
 * @param {T} thing
 * @returns {Exclude<T, null>}
 */
export function assertNonNull(thing){
	return /** @type {Exclude<T, null>} */ (thing);
}


/**
 * check string if it corresponds with the regex pattern
 * @param {string | null} value
 * @param {number} [minLen = 0]
 * @returns {{success: boolean, value: string | null}}  An object containing:
 *   - success: true if regex was successful, false otherwise
 *   - value: the value after regex if successful, null otherwise.
 */
export function checkEmail(value, minLen = 0){
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