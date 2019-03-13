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

import com.crowd.funding.database.model.ProjectUpdateRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectUpdateRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUpdateRegistration
 * @generated
 */
@ProviderType
public class ProjectUpdateRegistrationCacheModel implements CacheModel<ProjectUpdateRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectUpdateRegistrationCacheModel)) {
			return false;
		}

		ProjectUpdateRegistrationCacheModel projectUpdateRegistrationCacheModel = (ProjectUpdateRegistrationCacheModel)obj;

		if (PROJECT_UPDATE_ID == projectUpdateRegistrationCacheModel.PROJECT_UPDATE_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_UPDATE_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_UPDATE_ID=");
		sb.append(PROJECT_UPDATE_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", UPDATE_DETAILS=");
		sb.append(UPDATE_DETAILS);
		sb.append(", UPDATE_DATE=");
		sb.append(UPDATE_DATE);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectUpdateRegistration toEntityModel() {
		ProjectUpdateRegistrationImpl projectUpdateRegistrationImpl = new ProjectUpdateRegistrationImpl();

		if (uuid == null) {
			projectUpdateRegistrationImpl.setUuid("");
		}
		else {
			projectUpdateRegistrationImpl.setUuid(uuid);
		}

		projectUpdateRegistrationImpl.setPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);
		projectUpdateRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (UPDATE_DETAILS == null) {
			projectUpdateRegistrationImpl.setUPDATE_DETAILS("");
		}
		else {
			projectUpdateRegistrationImpl.setUPDATE_DETAILS(UPDATE_DETAILS);
		}

		if (UPDATE_DATE == Long.MIN_VALUE) {
			projectUpdateRegistrationImpl.setUPDATE_DATE(null);
		}
		else {
			projectUpdateRegistrationImpl.setUPDATE_DATE(new Date(UPDATE_DATE));
		}

		projectUpdateRegistrationImpl.setSTATUS(STATUS);

		projectUpdateRegistrationImpl.resetOriginalValues();

		return projectUpdateRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_UPDATE_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		UPDATE_DETAILS = objectInput.readUTF();
		UPDATE_DATE = objectInput.readLong();

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

		objectOutput.writeLong(PROJECT_UPDATE_ID);

		objectOutput.writeLong(PROJECT_ID);

		if (UPDATE_DETAILS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(UPDATE_DETAILS);
		}

		objectOutput.writeLong(UPDATE_DATE);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long PROJECT_UPDATE_ID;
	public long PROJECT_ID;
	public String UPDATE_DETAILS;
	public long UPDATE_DATE;
	public int STATUS;
}