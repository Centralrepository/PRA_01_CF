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
 * The Blob model class for lazy loading the IMAGE column in BenificiaryRegistration.
 *
 * @author Brian Wing Shun Chan
 * @see BenificiaryRegistration
 * @generated
 */
@ProviderType
public class BenificiaryRegistrationIMAGEBlobModel {
	public BenificiaryRegistrationIMAGEBlobModel() {
	}

	public BenificiaryRegistrationIMAGEBlobModel(long BENIFICIARY_ID) {
		_BENIFICIARY_ID = BENIFICIARY_ID;
	}

	public BenificiaryRegistrationIMAGEBlobModel(long BENIFICIARY_ID,
		Blob IMAGEBlob) {
		_BENIFICIARY_ID = BENIFICIARY_ID;
		_IMAGEBlob = IMAGEBlob;
	}

	public long getBENIFICIARY_ID() {
		return _BENIFICIARY_ID;
	}

	public void setBENIFICIARY_ID(long BENIFICIARY_ID) {
		_BENIFICIARY_ID = BENIFICIARY_ID;
	}

	public Blob getIMAGEBlob() {
		return _IMAGEBlob;
	}

	public void setIMAGEBlob(Blob IMAGEBlob) {
		_IMAGEBlob = IMAGEBlob;
	}

	private long _BENIFICIARY_ID;
	private Blob _IMAGEBlob;
}