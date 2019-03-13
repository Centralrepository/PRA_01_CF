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

import com.crowd.funding.database.model.UserRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistration
 * @generated
 */
@ProviderType
public class UserRegistrationCacheModel implements CacheModel<UserRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserRegistrationCacheModel)) {
			return false;
		}

		UserRegistrationCacheModel userRegistrationCacheModel = (UserRegistrationCacheModel)obj;

		if (USER_ID == userRegistrationCacheModel.USER_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, USER_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", USER_ID=");
		sb.append(USER_ID);
		sb.append(", USER_OTP_ID=");
		sb.append(USER_OTP_ID);
		sb.append(", FULL_NAME=");
		sb.append(FULL_NAME);
		sb.append(", PASSWORD=");
		sb.append(PASSWORD);
		sb.append(", GENDER=");
		sb.append(GENDER);
		sb.append(", CREATION_DATE=");
		sb.append(CREATION_DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserRegistration toEntityModel() {
		UserRegistrationImpl userRegistrationImpl = new UserRegistrationImpl();

		if (uuid == null) {
			userRegistrationImpl.setUuid("");
		}
		else {
			userRegistrationImpl.setUuid(uuid);
		}

		userRegistrationImpl.setUSER_ID(USER_ID);
		userRegistrationImpl.setUSER_OTP_ID(USER_OTP_ID);

		if (FULL_NAME == null) {
			userRegistrationImpl.setFULL_NAME("");
		}
		else {
			userRegistrationImpl.setFULL_NAME(FULL_NAME);
		}

		if (PASSWORD == null) {
			userRegistrationImpl.setPASSWORD("");
		}
		else {
			userRegistrationImpl.setPASSWORD(PASSWORD);
		}

		if (GENDER == null) {
			userRegistrationImpl.setGENDER("");
		}
		else {
			userRegistrationImpl.setGENDER(GENDER);
		}

		if (CREATION_DATE == Long.MIN_VALUE) {
			userRegistrationImpl.setCREATION_DATE(null);
		}
		else {
			userRegistrationImpl.setCREATION_DATE(new Date(CREATION_DATE));
		}

		userRegistrationImpl.resetOriginalValues();

		return userRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		USER_ID = objectInput.readLong();

		USER_OTP_ID = objectInput.readLong();
		FULL_NAME = objectInput.readUTF();
		PASSWORD = objectInput.readUTF();
		GENDER = objectInput.readUTF();
		CREATION_DATE = objectInput.readLong();
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

		objectOutput.writeLong(USER_ID);

		objectOutput.writeLong(USER_OTP_ID);

		if (FULL_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FULL_NAME);
		}

		if (PASSWORD == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(PASSWORD);
		}

		if (GENDER == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(GENDER);
		}

		objectOutput.writeLong(CREATION_DATE);
	}

	public String uuid;
	public long USER_ID;
	public long USER_OTP_ID;
	public String FULL_NAME;
	public String PASSWORD;
	public String GENDER;
	public long CREATION_DATE;
}