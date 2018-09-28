package com.agenarisk.api.model.dataset;

import com.agenarisk.api.model.CalculationResult;

/**
 * ResultEntry represents a state or range with probability mass allocated to it.
 * 
 * @author Eugene Dementiev
 */
public class ResultEntry {

	/**
	 * The CalculationResult containing the data set
	 */
	private final CalculationResult result;
	
	/**
	 * Label (state or range)
	 */
	private final String label;
	
	/**
	 * Probability mass value
	 */
	private final double value;

	/**
	 * Constructor for ResultEntry.
	 * 
	 * @param result CalculationResult containing the entries
	 * @param label entry label (state or range)
	 * @param value probability mass value
	 */
	public ResultEntry(CalculationResult result, String label, double value) {
		this.result = result;
		this.label = label;
		this.value = value;
	}

	/**
	 * Gets the CalculationResult.
	 * 
	 * @return the CalculationResult
	 */
	public CalculationResult getCalculationResult() {
		return result;
	}

	/**
	 * Gets the entry label.
	 * 
	 * @return the entry label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Gets the probability mass value.
	 * 
	 * @return the probability mass value
	 */
	public double getValue() {
		return value;
	}
	
}