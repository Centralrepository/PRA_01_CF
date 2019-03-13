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
 * The Blob model class for lazy loading the IMAGE column in UserRegistration.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistration
 * @generated
 */
@ProviderType
public class UserRegistrationIMAGEBlobModel {
	public UserRegistrationIMAGEBlobModel() {
	}

	public UserRegistrationIMAGEBlobModel(long USER_ID) {
		_USER_ID = USER_ID;
	}

	public UserRegistrationIMAGEBlobModel(long USER_ID, Blob IMAGEBlob) {
		_USER_ID = USER_ID;
		_IMAGEBlob = IMAGEBlob;
	}

	public long getUSER_ID() {
		return _USER_ID;
	}

	public void setUSER_ID(long USER_ID) {
		_USER_ID = USER_ID;
	}

	public Blob getIMAGEBlob() {
		return _IMAGEBlob;
	}

	public void setIMAGEBlob(Blob IMAGEBlob) {
		_IMAGEBlob = IMAGEBlob;
	}

	private long _USER_ID;
	private Blob _IMAGEBlob;
}