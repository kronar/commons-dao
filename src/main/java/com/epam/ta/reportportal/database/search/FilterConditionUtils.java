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

import com.epam.ta.reportportal.database.entity.Launch;
import com.epam.ta.reportportal.database.entity.Status;
import com.epam.ta.reportportal.ws.model.launch.Mode;

/**
 * @author Dzmitry_Kavalets
 */
public class FilterConditionUtils {

	private FilterConditionUtils() {}

	public static FilterCondition LAUNCH_NOT_IN_PROGRESS() {
		final String value = Status.INTERRUPTED.toString() + "," + Status.CANCELLED.toString() + "," + Status.FAILED.toString() + ","
				+ Status.PASSED.toString() + "," + Status.RESETED.toString() + "," + Status.SKIPPED.toString() + ","
				+ Status.STOPPED.toString();
		return new FilterCondition(Condition.IN, false, value, Launch.STATUS);
	}

	public static FilterCondition LAUNCH_IN_DEFAULT_MODE() {
		return new FilterCondition(Condition.EQUALS, false, Mode.DEFAULT.toString(), Launch.MODE_CRITERIA);
	}
}