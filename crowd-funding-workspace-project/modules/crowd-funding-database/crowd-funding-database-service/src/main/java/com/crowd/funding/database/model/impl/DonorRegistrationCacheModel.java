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

import com.crowd.funding.database.model.DonorRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DonorRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DonorRegistration
 * @generated
 */
@ProviderType
public class DonorRegistrationCacheModel implements CacheModel<DonorRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DonorRegistrationCacheModel)) {
			return false;
		}

		DonorRegistrationCacheModel donorRegistrationCacheModel = (DonorRegistrationCacheModel)obj;

		if (DONOR_ID == donorRegistrationCacheModel.DONOR_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, DONOR_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", DONOR_ID=");
		sb.append(DONOR_ID);
		sb.append(", NAME=");
		sb.append(NAME);
		sb.append(", ADDRESS=");
		sb.append(ADDRESS);
		sb.append(", CITY=");
		sb.append(CITY);
		sb.append(", STATE=");
		sb.append(STATE);
		sb.append(", COUNTRY=");
		sb.append(COUNTRY);
		sb.append(", PINCODE=");
		sb.append(PINCODE);
		sb.append(", MAIL_ADDRESS=");
		sb.append(MAIL_ADDRESS);
		sb.append(", MOBILE_NO=");
		sb.append(MOBILE_NO);
		sb.append(", OTP=");
		sb.append(OTP);
		sb.append(", MAIL_VERIFICATION=");
		sb.append(MAIL_VERIFICATION);
		sb.append(", SMS_VERIFICATION=");
		sb.append(SMS_VERIFICATION);
		sb.append(", CREATION_DATE_TIME=");
		sb.append(CREATION_DATE_TIME);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DonorRegistration toEntityModel() {
		DonorRegistrationImpl donorRegistrationImpl = new DonorRegistrationImpl();

		if (uuid == null) {
			donorRegistrationImpl.setUuid("");
		}
		else {
			donorRegistrationImpl.setUuid(uuid);
		}

		donorRegistrationImpl.setDONOR_ID(DONOR_ID);

		if (NAME == null) {
			donorRegistrationImpl.setNAME("");
		}
		else {
			donorRegistrationImpl.setNAME(NAME);
		}

		if (ADDRESS == null) {
			donorRegistrationImpl.setADDRESS("");
		}
		else {
			donorRegistrationImpl.setADDRESS(ADDRESS);
		}

		if (CITY == null) {
			donorRegistrationImpl.setCITY("");
		}
		else {
			donorRegistrationImpl.setCITY(CITY);
		}

		if (STATE == null) {
			donorRegistrationImpl.setSTATE("");
		}
		else {
			donorRegistrationImpl.setSTATE(STATE);
		}

		if (COUNTRY == null) {
			donorRegistrationImpl.setCOUNTRY("");
		}
		else {
			donorRegistrationImpl.setCOUNTRY(COUNTRY);
		}

		if (PINCODE == null) {
			donorRegistrationImpl.setPINCODE("");
		}
		else {
			donorRegistrationImpl.setPINCODE(PINCODE);
		}

		if (MAIL_ADDRESS == null) {
			donorRegistrationImpl.setMAIL_ADDRESS("");
		}
		else {
			donorRegistrationImpl.setMAIL_ADDRESS(MAIL_ADDRESS);
		}

		donorRegistrationImpl.setMOBILE_NO(MOBILE_NO);
		donorRegistrationImpl.setOTP(OTP);
		donorRegistrationImpl.setMAIL_VERIFICATION(MAIL_VERIFICATION);
		donorRegistrationImpl.setSMS_VERIFICATION(SMS_VERIFICATION);

		if (CREATION_DATE_TIME == Long.MIN_VALUE) {
			donorRegistrationImpl.setCREATION_DATE_TIME(null);
		}
		else {
			donorRegistrationImpl.setCREATION_DATE_TIME(new Date(
					CREATION_DATE_TIME));
		}

		donorRegistrationImpl.resetOriginalValues();

		return donorRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		DONOR_ID = objectInput.readLong();
		NAME = objectInput.readUTF();
		ADDRESS = objectInput.readUTF();
		CITY = objectInput.readUTF();
		STATE = objectInput.readUTF();
		COUNTRY = objectInput.readUTF();
		PINCODE = objectInput.readUTF();
		MAIL_ADDRESS = objectInput.readUTF();

		MOBILE_NO = objectInput.readLong();

		OTP = objectInput.readInt();

		MAIL_VERIFICATION = objectInput.readInt();

		SMS_VERIFICATION = objectInput.readInt();
		CREATION_DATE_TIME = objectInput.readLong();
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

		objectOutput.writeLong(DONOR_ID);

		if (NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NAME);
		}

		if (ADDRESS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ADDRESS);
		}

		if (CITY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CITY);
		}

		if (STATE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(STATE);
		}

		if (COUNTRY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(COUNTRY);
		}

		if (PINCODE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PINCODE);
		}

		if (MAIL_ADDRESS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(MAIL_ADDRESS);
		}

		objectOutput.writeLong(MOBILE_NO);

		objectOutput.writeInt(OTP);

		objectOutput.writeInt(MAIL_VERIFICATION);

		objectOutput.writeInt(SMS_VERIFICATION);
		objectOutput.writeLong(CREATION_DATE_TIME);
	}

	public String uuid;
	public long DONOR_ID;
	public String NAME;
	public String ADDRESS;
	public String CITY;
	public String STATE;
	public String COUNTRY;
	public String PINCODE;
	public String MAIL_ADDRESS;
	public long MOBILE_NO;
	public int OTP;
	public int MAIL_VERIFICATION;
	public int SMS_VERIFICATION;
	public long CREATION_DATE_TIME;
}