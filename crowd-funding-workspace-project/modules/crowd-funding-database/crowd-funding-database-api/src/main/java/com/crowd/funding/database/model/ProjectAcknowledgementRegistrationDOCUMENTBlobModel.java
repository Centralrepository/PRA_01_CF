/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.crowd.funding.database.model;

import aQute.bnd.annotation.ProviderType;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the DOCUMENT column in ProjectAcknowledgementRegistration.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectAcknowledgementRegistration
 * @generated
 */
@ProviderType
public class ProjectAcknowledgementRegistrationDOCUMENTBlobModel {
	public ProjectAcknowledgementRegistrationDOCUMENTBlobModel() {
	}

	public ProjectAcknowledgementRegistrationDOCUMENTBlobModel(
		long ACKNOWLEDGMENT_ID) {
		_ACKNOWLEDGMENT_ID = ACKNOWLEDGMENT_ID;
	}

	public ProjectAcknowledgementRegistrationDOCUMENTBlobModel(
		long ACKNOWLEDGMENT_ID, Blob DOCUMENTBlob) {
		_ACKNOWLEDGMENT_ID = ACKNOWLEDGMENT_ID;
		_DOCUMENTBlob = DOCUMENTBlob;
	}

	public long getACKNOWLEDGMENT_ID() {
		return _ACKNOWLEDGMENT_ID;
	}

	public void setACKNOWLEDGMENT_ID(long ACKNOWLEDGMENT_ID) {
		_ACKNOWLEDGMENT_ID = ACKNOWLEDGMENT_ID;
	}

	public Blob getDOCUMENTBlob() {
		return _DOCUMENTBlob;
	}

	public void setDOCUMENTBlob(Blob DOCUMENTBlob) {
		_DOCUMENTBlob = DOCUMENTBlob;
	}

	private long _ACKNOWLEDGMENT_ID;
	private Blob _DOCUMENTBlob;
}