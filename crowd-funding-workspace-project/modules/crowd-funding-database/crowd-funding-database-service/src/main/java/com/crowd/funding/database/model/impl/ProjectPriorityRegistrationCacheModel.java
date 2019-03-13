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

import com.crowd.funding.database.model.ProjectPriorityRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProjectPriorityRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPriorityRegistration
 * @generated
 */
@ProviderType
public class ProjectPriorityRegistrationCacheModel implements CacheModel<ProjectPriorityRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectPriorityRegistrationCacheModel)) {
			return false;
		}

		ProjectPriorityRegistrationCacheModel projectPriorityRegistrationCacheModel =
			(ProjectPriorityRegistrationCacheModel)obj;

		if (PROJECT_PRIORITY_ID == projectPriorityRegistrationCacheModel.PROJECT_PRIORITY_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_PRIORITY_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_PRIORITY_ID=");
		sb.append(PROJECT_PRIORITY_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", PRIORITY=");
		sb.append(PRIORITY);
		sb.append(", PRIORITY_SEQUANCE=");
		sb.append(PRIORITY_SEQUANCE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectPriorityRegistration toEntityModel() {
		ProjectPriorityRegistrationImpl projectPriorityRegistrationImpl = new ProjectPriorityRegistrationImpl();

		if (uuid == null) {
			projectPriorityRegistrationImpl.setUuid("");
		}
		else {
			projectPriorityRegistrationImpl.setUuid(uuid);
		}

		projectPriorityRegistrationImpl.setPROJECT_PRIORITY_ID(PROJECT_PRIORITY_ID);
		projectPriorityRegistrationImpl.setPROJECT_ID(PROJECT_ID);
		projectPriorityRegistrationImpl.setPRIORITY(PRIORITY);
		projectPriorityRegistrationImpl.setPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);

		projectPriorityRegistrationImpl.resetOriginalValues();

		return projectPriorityRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_PRIORITY_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();

		PRIORITY = objectInput.readInt();

		PRIORITY_SEQUANCE = objectInput.readInt();
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

		objectOutput.writeLong(PROJECT_PRIORITY_ID);

		objectOutput.writeLong(PROJECT_ID);

		objectOutput.writeInt(PRIORITY);

		objectOutput.writeInt(PRIORITY_SEQUANCE);
	}

	public String uuid;
	public long PROJECT_PRIORITY_ID;
	public long PROJECT_ID;
	public int PRIORITY;
	public int PRIORITY_SEQUANCE;
}