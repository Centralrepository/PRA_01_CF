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
 * The Blob model class for lazy loading the IMAGE column in ImageRegistration.
 *
 * @author Brian Wing Shun Chan
 * @see ImageRegistration
 * @generated
 */
@ProviderType
public class ImageRegistrationIMAGEBlobModel {
	public ImageRegistrationIMAGEBlobModel() {
	}

	public ImageRegistrationIMAGEBlobModel(long PROJECT_IMAGE_ID) {
		_PROJECT_IMAGE_ID = PROJECT_IMAGE_ID;
	}

	public ImageRegistrationIMAGEBlobModel(long PROJECT_IMAGE_ID, Blob IMAGEBlob) {
		_PROJECT_IMAGE_ID = PROJECT_IMAGE_ID;
		_IMAGEBlob = IMAGEBlob;
	}

	public long getPROJECT_IMAGE_ID() {
		return _PROJECT_IMAGE_ID;
	}

	public void setPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID) {
		_PROJECT_IMAGE_ID = PROJECT_IMAGE_ID;
	}

	public Blob getIMAGEBlob() {
		return _IMAGEBlob;
	}

	public void setIMAGEBlob(Blob IMAGEBlob) {
		_IMAGEBlob = IMAGEBlob;
	}

	private long _PROJECT_IMAGE_ID;
	private Blob _IMAGEBlob;
}