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

import com.crowd.funding.database.model.ProjectRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectRegistration
 * @generated
 */
@ProviderType
public class ProjectRegistrationCacheModel implements CacheModel<ProjectRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectRegistrationCacheModel)) {
			return false;
		}

		ProjectRegistrationCacheModel projectRegistrationCacheModel = (ProjectRegistrationCacheModel)obj;

		if (PROJECT_ID == projectRegistrationCacheModel.PROJECT_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", USER_ID=");
		sb.append(USER_ID);
		sb.append(", BENIFICIARY_ID=");
		sb.append(BENIFICIARY_ID);
		sb.append(", TITLE=");
		sb.append(TITLE);
		sb.append(", DESCRIPTION=");
		sb.append(DESCRIPTION);
		sb.append(", REQUIRED_FUND_AMOUNT=");
		sb.append(REQUIRED_FUND_AMOUNT);
		sb.append(", CREATION_DATE=");
		sb.append(CREATION_DATE);
		sb.append(", END_DATE=");
		sb.append(END_DATE);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectRegistration toEntityModel() {
		ProjectRegistrationImpl projectRegistrationImpl = new ProjectRegistrationImpl();

		if (uuid == null) {
			projectRegistrationImpl.setUuid("");
		}
		else {
			projectRegistrationImpl.setUuid(uuid);
		}

		projectRegistrationImpl.setPROJECT_ID(PROJECT_ID);
		projectRegistrationImpl.setUSER_ID(USER_ID);
		projectRegistrationImpl.setBENIFICIARY_ID(BENIFICIARY_ID);

		if (TITLE == null) {
			projectRegistrationImpl.setTITLE("");
		}
		else {
			projectRegistrationImpl.setTITLE(TITLE);
		}

		if (DESCRIPTION == null) {
			projectRegistrationImpl.setDESCRIPTION("");
		}
		else {
			projectRegistrationImpl.setDESCRIPTION(DESCRIPTION);
		}

		projectRegistrationImpl.setREQUIRED_FUND_AMOUNT(REQUIRED_FUND_AMOUNT);

		if (CREATION_DATE == Long.MIN_VALUE) {
			projectRegistrationImpl.setCREATION_DATE(null);
		}
		else {
			projectRegistrationImpl.setCREATION_DATE(new Date(CREATION_DATE));
		}

		if (END_DATE == Long.MIN_VALUE) {
			projectRegistrationImpl.setEND_DATE(null);
		}
		else {
			projectRegistrationImpl.setEND_DATE(new Date(END_DATE));
		}

		projectRegistrationImpl.setSTATUS(STATUS);

		projectRegistrationImpl.resetOriginalValues();

		return projectRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_ID = objectInput.readLong();

		USER_ID = objectInput.readLong();

		BENIFICIARY_ID = objectInput.readLong();
		TITLE = objectInput.readUTF();
		DESCRIPTION = objectInput.readUTF();

		REQUIRED_FUND_AMOUNT = objectInput.readFloat();
		CREATION_DATE = objectInput.readLong();
		END_DATE = objectInput.readLong();

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

		objectOutput.writeLong(PROJECT_ID);

		objectOutput.writeLong(USER_ID);

		objectOutput.writeLong(BENIFICIARY_ID);

		if (TITLE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TITLE);
		}

		if (DESCRIPTION == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DESCRIPTION);
		}

		objectOutput.writeFloat(REQUIRED_FUND_AMOUNT);
		objectOutput.writeLong(CREATION_DATE);
		objectOutput.writeLong(END_DATE);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long PROJECT_ID;
	public long USER_ID;
	public long BENIFICIARY_ID;
	public String TITLE;
	public String DESCRIPTION;
	public float REQUIRED_FUND_AMOUNT;
	public long CREATION_DATE;
	public long END_DATE;
	public int STATUS;
}