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

import com.crowd.funding.database.model.ProjectFollowerRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProjectFollowerRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFollowerRegistration
 * @generated
 */
@ProviderType
public class ProjectFollowerRegistrationCacheModel implements CacheModel<ProjectFollowerRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectFollowerRegistrationCacheModel)) {
			return false;
		}

		ProjectFollowerRegistrationCacheModel projectFollowerRegistrationCacheModel =
			(ProjectFollowerRegistrationCacheModel)obj;

		if (PROJECT_FOLLOWER_ID == projectFollowerRegistrationCacheModel.PROJECT_FOLLOWER_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_FOLLOWER_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_FOLLOWER_ID=");
		sb.append(PROJECT_FOLLOWER_ID);
		sb.append(", USER_ID=");
		sb.append(USER_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectFollowerRegistration toEntityModel() {
		ProjectFollowerRegistrationImpl projectFollowerRegistrationImpl = new ProjectFollowerRegistrationImpl();

		if (uuid == null) {
			projectFollowerRegistrationImpl.setUuid("");
		}
		else {
			projectFollowerRegistrationImpl.setUuid(uuid);
		}

		projectFollowerRegistrationImpl.setPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);
		projectFollowerRegistrationImpl.setUSER_ID(USER_ID);
		projectFollowerRegistrationImpl.setPROJECT_ID(PROJECT_ID);
		projectFollowerRegistrationImpl.setSTATUS(STATUS);

		projectFollowerRegistrationImpl.resetOriginalValues();

		return projectFollowerRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_FOLLOWER_ID = objectInput.readLong();

		USER_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();

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

		objectOutput.writeLong(PROJECT_FOLLOWER_ID);

		objectOutput.writeLong(USER_ID);

		objectOutput.writeLong(PROJECT_ID);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long PROJECT_FOLLOWER_ID;
	public long USER_ID;
	public long PROJECT_ID;
	public int STATUS;
}