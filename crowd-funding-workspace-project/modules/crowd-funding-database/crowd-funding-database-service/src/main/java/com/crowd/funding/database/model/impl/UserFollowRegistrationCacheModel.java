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

import com.crowd.funding.database.model.UserFollowRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserFollowRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserFollowRegistration
 * @generated
 */
@ProviderType
public class UserFollowRegistrationCacheModel implements CacheModel<UserFollowRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserFollowRegistrationCacheModel)) {
			return false;
		}

		UserFollowRegistrationCacheModel userFollowRegistrationCacheModel = (UserFollowRegistrationCacheModel)obj;

		if (USER_FOLLOW_ID == userFollowRegistrationCacheModel.USER_FOLLOW_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, USER_FOLLOW_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", USER_FOLLOW_ID=");
		sb.append(USER_FOLLOW_ID);
		sb.append(", USER_ID=");
		sb.append(USER_ID);
		sb.append(", FOLLOWER_USER_ID=");
		sb.append(FOLLOWER_USER_ID);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserFollowRegistration toEntityModel() {
		UserFollowRegistrationImpl userFollowRegistrationImpl = new UserFollowRegistrationImpl();

		if (uuid == null) {
			userFollowRegistrationImpl.setUuid("");
		}
		else {
			userFollowRegistrationImpl.setUuid(uuid);
		}

		userFollowRegistrationImpl.setUSER_FOLLOW_ID(USER_FOLLOW_ID);
		userFollowRegistrationImpl.setUSER_ID(USER_ID);
		userFollowRegistrationImpl.setFOLLOWER_USER_ID(FOLLOWER_USER_ID);
		userFollowRegistrationImpl.setSTATUS(STATUS);

		userFollowRegistrationImpl.resetOriginalValues();

		return userFollowRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		USER_FOLLOW_ID = objectInput.readLong();

		USER_ID = objectInput.readLong();

		FOLLOWER_USER_ID = objectInput.readLong();

		STATUS = objectInput.readInt();
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

		objectOutput.writeLong(USER_FOLLOW_ID);

		objectOutput.writeLong(USER_ID);

		objectOutput.writeLong(FOLLOWER_USER_ID);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long USER_FOLLOW_ID;
	public long USER_ID;
	public long FOLLOWER_USER_ID;
	public int STATUS;
}