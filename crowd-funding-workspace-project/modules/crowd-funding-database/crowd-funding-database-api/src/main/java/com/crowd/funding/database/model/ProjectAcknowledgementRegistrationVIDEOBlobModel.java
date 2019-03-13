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
 * The Blob model class for lazy loading the VIDEO column in ProjectAcknowledgementRegistration.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectAcknowledgementRegistration
 * @generated
 */
@ProviderType
public class ProjectAcknowledgementRegistrationVIDEOBlobModel {
	public ProjectAcknowledgementRegistrationVIDEOBlobModel() {
	}

	public ProjectAcknowledgementRegistrationVIDEOBlobModel(
		long ACKNOWLEDGMENT_ID) {
		_ACKNOWLEDGMENT_ID = ACKNOWLEDGMENT_ID;
	}

	public ProjectAcknowledgementRegistrationVIDEOBlobModel(
		long ACKNOWLEDGMENT_ID, Blob VIDEOBlob) {
		_ACKNOWLEDGMENT_ID = ACKNOWLEDGMENT_ID;
		_VIDEOBlob = VIDEOBlob;
	}

	public long getACKNOWLEDGMENT_ID() {
		return _ACKNOWLEDGMENT_ID;
	}

	public void setACKNOWLEDGMENT_ID(long ACKNOWLEDGMENT_ID) {
		_ACKNOWLEDGMENT_ID = ACKNOWLEDGMENT_ID;
	}

	public Blob getVIDEOBlob() {
		return _VIDEOBlob;
	}

	public void setVIDEOBlob(Blob VIDEOBlob) {
		_VIDEOBlob = VIDEOBlob;
	}

	private long _ACKNOWLEDGMENT_ID;
	private Blob _VIDEOBlob;
}