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

import com.crowd.funding.database.model.FundRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FundRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FundRegistration
 * @generated
 */
@ProviderType
public class FundRegistrationCacheModel implements CacheModel<FundRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundRegistrationCacheModel)) {
			return false;
		}

		FundRegistrationCacheModel fundRegistrationCacheModel = (FundRegistrationCacheModel)obj;

		if (PROJECT_FUND_ID == fundRegistrationCacheModel.PROJECT_FUND_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_FUND_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_FUND_ID=");
		sb.append(PROJECT_FUND_ID);
		sb.append(", DONOR_ID=");
		sb.append(DONOR_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", CURRENCY=");
		sb.append(CURRENCY);
		sb.append(", DONATED_AMOUNT=");
		sb.append(DONATED_AMOUNT);
		sb.append(", DONOR_USER_ID=");
		sb.append(DONOR_USER_ID);
		sb.append(", DONOR_STATUS=");
		sb.append(DONOR_STATUS);
		sb.append(", COMMENT=");
		sb.append(COMMENT);
		sb.append(", DONATED_DATE=");
		sb.append(DONATED_DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FundRegistration toEntityModel() {
		FundRegistrationImpl fundRegistrationImpl = new FundRegistrationImpl();

		if (uuid == null) {
			fundRegistrationImpl.setUuid("");
		}
		else {
			fundRegistrationImpl.setUuid(uuid);
		}

		fundRegistrationImpl.setPROJECT_FUND_ID(PROJECT_FUND_ID);
		fundRegistrationImpl.setDONOR_ID(DONOR_ID);
		fundRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (CURRENCY == null) {
			fundRegistrationImpl.setCURRENCY("");
		}
		else {
			fundRegistrationImpl.setCURRENCY(CURRENCY);
		}

		fundRegistrationImpl.setDONATED_AMOUNT(DONATED_AMOUNT);
		fundRegistrationImpl.setDONOR_USER_ID(DONOR_USER_ID);
		fundRegistrationImpl.setDONOR_STATUS(DONOR_STATUS);

		if (COMMENT == null) {
			fundRegistrationImpl.setCOMMENT("");
		}
		else {
			fundRegistrationImpl.setCOMMENT(COMMENT);
		}

		if (DONATED_DATE == Long.MIN_VALUE) {
			fundRegistrationImpl.setDONATED_DATE(null);
		}
		else {
			fundRegistrationImpl.setDONATED_DATE(new Date(DONATED_DATE));
		}

		fundRegistrationImpl.resetOriginalValues();

		return fundRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_FUND_ID = objectInput.readLong();

		DONOR_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		CURRENCY = objectInput.readUTF();

		DONATED_AMOUNT = objectInput.readFloat();

		DONOR_USER_ID = objectInput.readLong();

		DONOR_STATUS = objectInput.readInt();
		COMMENT = objectInput.readUTF();
		DONATED_DATE = objectInput.readLong();
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

		objectOutput.writeLong(PROJECT_FUND_ID);

		objectOutput.writeLong(DONOR_ID);

		objectOutput.writeLong(PROJECT_ID);

		if (CURRENCY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CURRENCY);
		}

		objectOutput.writeFloat(DONATED_AMOUNT);

		objectOutput.writeLong(DONOR_USER_ID);

		objectOutput.writeInt(DONOR_STATUS);

		if (COMMENT == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(COMMENT);
		}

		objectOutput.writeLong(DONATED_DATE);
	}

	public String uuid;
	public long PROJECT_FUND_ID;
	public long DONOR_ID;
	public long PROJECT_ID;
	public String CURRENCY;
	public float DONATED_AMOUNT;
	public long DONOR_USER_ID;
	public int DONOR_STATUS;
	public String COMMENT;
	public long DONATED_DATE;
}