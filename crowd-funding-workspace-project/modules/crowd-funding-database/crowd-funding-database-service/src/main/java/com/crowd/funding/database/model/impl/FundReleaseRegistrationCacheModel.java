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

package com.crowd.funding.database.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.FundReleaseRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FundReleaseRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FundReleaseRegistration
 * @generated
 */
@ProviderType
public class FundReleaseRegistrationCacheModel implements CacheModel<FundReleaseRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundReleaseRegistrationCacheModel)) {
			return false;
		}

		FundReleaseRegistrationCacheModel fundReleaseRegistrationCacheModel = (FundReleaseRegistrationCacheModel)obj;

		if (FUND_RELEASE_ID == fundReleaseRegistrationCacheModel.FUND_RELEASE_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, FUND_RELEASE_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", FUND_RELEASE_ID=");
		sb.append(FUND_RELEASE_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", CURRENCY=");
		sb.append(CURRENCY);
		sb.append(", AMOUNT=");
		sb.append(AMOUNT);
		sb.append(", RELEASE_DATE=");
		sb.append(RELEASE_DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FundReleaseRegistration toEntityModel() {
		FundReleaseRegistrationImpl fundReleaseRegistrationImpl = new FundReleaseRegistrationImpl();

		if (uuid == null) {
			fundReleaseRegistrationImpl.setUuid("");
		}
		else {
			fundReleaseRegistrationImpl.setUuid(uuid);
		}

		fundReleaseRegistrationImpl.setFUND_RELEASE_ID(FUND_RELEASE_ID);
		fundReleaseRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (CURRENCY == null) {
			fundReleaseRegistrationImpl.setCURRENCY("");
		}
		else {
			fundReleaseRegistrationImpl.setCURRENCY(CURRENCY);
		}

		fundReleaseRegistrationImpl.setAMOUNT(AMOUNT);

		if (RELEASE_DATE == Long.MIN_VALUE) {
			fundReleaseRegistrationImpl.setRELEASE_DATE(null);
		}
		else {
			fundReleaseRegistrationImpl.setRELEASE_DATE(new Date(RELEASE_DATE));
		}

		fundReleaseRegistrationImpl.resetOriginalValues();

		return fundReleaseRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		FUND_RELEASE_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		CURRENCY = objectInput.readUTF();

		AMOUNT = objectInput.readFloat();
		RELEASE_DATE = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(FUND_RELEASE_ID);

		objectOutput.writeLong(PROJECT_ID);

		if (CURRENCY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CURRENCY);
		}

		objectOutput.writeFloat(AMOUNT);
		objectOutput.writeLong(RELEASE_DATE);
	}

	public String uuid;
	public long FUND_RELEASE_ID;
	public long PROJECT_ID;
	public String CURRENCY;
	public float AMOUNT;
	public long RELEASE_DATE;
}