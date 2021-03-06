/*
 * Copyright 2016 EPAM Systems
 * 
 * 
 * This file is part of EPAM Report Portal.
 * https://github.com/epam/ReportPortal
 * 
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 */ 

package com.epam.ta.reportportal.database.search;

import com.google.common.base.Preconditions;

import java.io.Serializable;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Filter condition class for filters specifics
 */
public class FilterCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	public FilterCondition(Condition condition, boolean negative, String value, String searchCriteria) {
		super();
		this.condition = condition;
		this.value = value;
		this.searchCriteria = searchCriteria;
		this.negative = negative;
	}

	/**
	 * Filter Condition
	 */
	private Condition condition;

	/**
	 * Value to be filtered
	 */
	private String value;

	/**
	 * API Model Search Criteria
	 */
	private String searchCriteria;

	/**
	 * Whether this is 'NOT' filter
	 */
	private boolean negative;

	public Condition getCondition() {
		return condition;
	}

	public String getSearchCriteria() {
		return searchCriteria;
	}

	public String getValue() {
		return value;
	}

	public boolean isNegative() {
		return negative;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + (negative ? 1231 : 1237);
		result = prime * result + ((searchCriteria == null) ? 0 : searchCriteria.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilterCondition other = (FilterCondition) obj;
		if (condition != other.condition)
			return false;
		if (negative != other.negative)
			return false;
		if (searchCriteria == null) {
			if (other.searchCriteria != null)
				return false;
		} else if (!searchCriteria.equals(other.searchCriteria))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("FilterCondition {").append("condition = ").append(condition).append(", value = ")
				.append(value).append(", searchCriteria = ").append(searchCriteria).append(", negative = ").append(negative).append("}");
		return sb.toString();
	}

	public static ConditionBuilder builder(){
		return new ConditionBuilder();
	}

	/**
	 * Builder for {@link FilterCondition}
	 */
	public static class ConditionBuilder {
		private Condition condition;
		private boolean negative;
		private String value;
		private String searchCriteria;

		private ConditionBuilder() {

		}

		public FilterCondition.ConditionBuilder withCondition(Condition condition) {
			this.condition = condition;
			return this;
		}

		public FilterCondition.ConditionBuilder withNegative(boolean negative) {
			this.negative = negative;
			return this;
		}

		public FilterCondition.ConditionBuilder withValue(String value) {
			this.value = value;
			return this;
		}

		public FilterCondition.ConditionBuilder withSearchCriteria(String searchCriteria) {
			this.searchCriteria = searchCriteria;
			return this;
		}

		public FilterCondition.ConditionBuilder eq(String searchCriteria, String value) {
			return withCondition(Condition.EQUALS)
					.withSearchCriteria(searchCriteria)
					.withValue(value);
		}


		public FilterCondition build() {
			Preconditions.checkArgument(null != condition, "Condition should not be null");
			Preconditions.checkArgument(!isNullOrEmpty(value), "Value should not be empty");
			Preconditions.checkArgument(!isNullOrEmpty(searchCriteria), "Search criteria should not be empty");
			return new FilterCondition(condition, negative, value, searchCriteria);
		}
	}
}