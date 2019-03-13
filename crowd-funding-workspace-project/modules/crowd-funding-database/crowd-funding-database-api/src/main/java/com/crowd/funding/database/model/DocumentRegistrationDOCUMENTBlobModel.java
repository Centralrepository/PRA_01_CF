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
 * The Blob model class for lazy loading the DOCUMENT column in DocumentRegistration.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentRegistration
 * @generated
 */
@ProviderType
public class DocumentRegistrationDOCUMENTBlobModel {
	public DocumentRegistrationDOCUMENTBlobModel() {
	}

	public DocumentRegistrationDOCUMENTBlobModel(long PROJECT_DOCUMENT_ID) {
		_PROJECT_DOCUMENT_ID = PROJECT_DOCUMENT_ID;
	}

	public DocumentRegistrationDOCUMENTBlobModel(long PROJECT_DOCUMENT_ID,
		Blob DOCUMENTBlob) {
		_PROJECT_DOCUMENT_ID = PROJECT_DOCUMENT_ID;
		_DOCUMENTBlob = DOCUMENTBlob;
	}

	public long getPROJECT_DOCUMENT_ID() {
		return _PROJECT_DOCUMENT_ID;
	}

	public void setPROJECT_DOCUMENT_ID(long PROJECT_DOCUMENT_ID) {
		_PROJECT_DOCUMENT_ID = PROJECT_DOCUMENT_ID;
	}

	public Blob getDOCUMENTBlob() {
		return _DOCUMENTBlob;
	}

	public void setDOCUMENTBlob(Blob DOCUMENTBlob) {
		_DOCUMENTBlob = DOCUMENTBlob;
	}

	private long _PROJECT_DOCUMENT_ID;
	private Blob _DOCUMENTBlob;
}