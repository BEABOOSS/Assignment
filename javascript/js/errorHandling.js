//@ts-check

export class ReadError extends Error {
	/**
	 * @param {string} message
	 * @param {Error} cause
	 */
	constructor(message, cause) {
		super(message);
		this.cause = cause;
		this.name = "ReadError";
	}
}


export class ValidationError extends Error {
	/**
	 * @param {string} message
	 */
	constructor(message) {
		super(message);
		this.name = "ValidationError";
	}
}

export class PropertyRequiredError extends ValidationError {
	/**
	 * @param {string} property
	 */
	constructor(property) {
		super("No property: " + property);
		this.name = "PropertyRequireError";
		this.property = property;
	}
}
