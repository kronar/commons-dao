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
 
package com.epam.ta.reportportal.exception;

/**
 * Exceptions related to data storage
 * 
 * @author Andrei Varabyeu
 * 
 */
// TODO add binding to this exception
public class DataStorageException extends ReportPortalException {

	private static final long serialVersionUID = -6822780391660931103L;

	public DataStorageException(String message) {
		super(message);

	}

	public DataStorageException(String message, Throwable e) {
		super(message, e);
	}

}