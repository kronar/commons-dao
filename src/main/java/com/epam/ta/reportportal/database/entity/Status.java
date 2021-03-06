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

package com.epam.ta.reportportal.database.entity;

import java.util.Optional;

public enum Status implements StatisticsAwareness {

	//@formatter:off
	IN_PROGRESS(""),
	PASSED("passed"),
	FAILED("failed"),
	STOPPED("stopped"), //status for manually stopped launches
	SKIPPED("skipped"),
	INTERRUPTED("failed"),
	RESETED("reseted"), //status for items with deleted descendants
	CANCELLED("cancelled"); //soupUI specific status
	//@formatter:on

	private final String executionCounterField;

	Status(String executionCounterField) {
		this.executionCounterField = executionCounterField;
	}

	public static Optional<Status> fromValue(String value) {
		Status[] values = Status.values();
		for (Status status : values) {
			if (status.name().equalsIgnoreCase(value)) {
				return Optional.of(status);
			}
		}
		return Optional.empty();
	}

	@Override
	public String awareStatisticsField() {
		return executionCounterField;
	}

}