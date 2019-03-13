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
 * The Blob model class for lazy loading the DOCUMENT column in NewsLetterRegistration.
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterRegistration
 * @generated
 */
@ProviderType
public class NewsLetterRegistrationDOCUMENTBlobModel {
	public NewsLetterRegistrationDOCUMENTBlobModel() {
	}

	public NewsLetterRegistrationDOCUMENTBlobModel(long NEWS_LETTER_ID) {
		_NEWS_LETTER_ID = NEWS_LETTER_ID;
	}

	public NewsLetterRegistrationDOCUMENTBlobModel(long NEWS_LETTER_ID,
		Blob DOCUMENTBlob) {
		_NEWS_LETTER_ID = NEWS_LETTER_ID;
		_DOCUMENTBlob = DOCUMENTBlob;
	}

	public long getNEWS_LETTER_ID() {
		return _NEWS_LETTER_ID;
	}

	public void setNEWS_LETTER_ID(long NEWS_LETTER_ID) {
		_NEWS_LETTER_ID = NEWS_LETTER_ID;
	}

	public Blob getDOCUMENTBlob() {
		return _DOCUMENTBlob;
	}

	public void setDOCUMENTBlob(Blob DOCUMENTBlob) {
		_DOCUMENTBlob = DOCUMENTBlob;
	}

	private long _NEWS_LETTER_ID;
	private Blob _DOCUMENTBlob;
}