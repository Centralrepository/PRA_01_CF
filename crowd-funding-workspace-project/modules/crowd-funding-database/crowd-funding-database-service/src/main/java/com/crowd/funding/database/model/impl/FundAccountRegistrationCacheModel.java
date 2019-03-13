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

import com.crowd.funding.database.model.FundAccountRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FundAccountRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FundAccountRegistration
 * @generated
 */
@ProviderType
public class FundAccountRegistrationCacheModel implements CacheModel<FundAccountRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundAccountRegistrationCacheModel)) {
			return false;
		}

		FundAccountRegistrationCacheModel fundAccountRegistrationCacheModel = (FundAccountRegistrationCacheModel)obj;

		if (ACCOUNT_ID == fundAccountRegistrationCacheModel.ACCOUNT_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ACCOUNT_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ACCOUNT_ID=");
		sb.append(ACCOUNT_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", ACCOUNT_NO=");
		sb.append(ACCOUNT_NO);
		sb.append(", ACCOUNT_HOLDER_NAME=");
		sb.append(ACCOUNT_HOLDER_NAME);
		sb.append(", IFSC_CODE=");
		sb.append(IFSC_CODE);
		sb.append(", UPI_NO=");
		sb.append(UPI_NO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FundAccountRegistration toEntityModel() {
		FundAccountRegistrationImpl fundAccountRegistrationImpl = new FundAccountRegistrationImpl();

		if (uuid == null) {
			fundAccountRegistrationImpl.setUuid("");
		}
		else {
			fundAccountRegistrationImpl.setUuid(uuid);
		}

		fundAccountRegistrationImpl.setACCOUNT_ID(ACCOUNT_ID);
		fundAccountRegistrationImpl.setPROJECT_ID(PROJECT_ID);
		fundAccountRegistrationImpl.setACCOUNT_NO(ACCOUNT_NO);

		if (ACCOUNT_HOLDER_NAME == null) {
			fundAccountRegistrationImpl.setACCOUNT_HOLDER_NAME("");
		}
		else {
			fundAccountRegistrationImpl.setACCOUNT_HOLDER_NAME(ACCOUNT_HOLDER_NAME);
		}

		if (IFSC_CODE == null) {
			fundAccountRegistrationImpl.setIFSC_CODE("");
		}
		else {
			fundAccountRegistrationImpl.setIFSC_CODE(IFSC_CODE);
		}

		if (UPI_NO == null) {
			fundAccountRegistrationImpl.setUPI_NO("");
		}
		else {
			fundAccountRegistrationImpl.setUPI_NO(UPI_NO);
		}

		fundAccountRegistrationImpl.resetOriginalValues();

		return fundAccountRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ACCOUNT_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();

		ACCOUNT_NO = objectInput.readLong();
		ACCOUNT_HOLDER_NAME = objectInput.readUTF();
		IFSC_CODE = objectInput.readUTF();
		UPI_NO = objectInput.readUTF();
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

		objectOutput.writeLong(ACCOUNT_ID);

		objectOutput.writeLong(PROJECT_ID);

		objectOutput.writeLong(ACCOUNT_NO);

		if (ACCOUNT_HOLDER_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ACCOUNT_HOLDER_NAME);
		}

		if (IFSC_CODE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(IFSC_CODE);
		}

		if (UPI_NO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(UPI_NO);
		}
	}

	public String uuid;
	public long ACCOUNT_ID;
	public long PROJECT_ID;
	public long ACCOUNT_NO;
	public String ACCOUNT_HOLDER_NAME;
	public String IFSC_CODE;
	public String UPI_NO;
}