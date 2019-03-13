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

import com.crowd.funding.database.model.UpdateRequesterRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UpdateRequesterRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UpdateRequesterRegistration
 * @generated
 */
@ProviderType
public class UpdateRequesterRegistrationCacheModel implements CacheModel<UpdateRequesterRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UpdateRequesterRegistrationCacheModel)) {
			return false;
		}

		UpdateRequesterRegistrationCacheModel updateRequesterRegistrationCacheModel =
			(UpdateRequesterRegistrationCacheModel)obj;

		if (PROJECT_UPDATE_REQUEST_ID == updateRequesterRegistrationCacheModel.PROJECT_UPDATE_REQUEST_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_UPDATE_REQUEST_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_UPDATE_REQUEST_ID=");
		sb.append(PROJECT_UPDATE_REQUEST_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", UPDATE_REQUESTER_USER_ID=");
		sb.append(UPDATE_REQUESTER_USER_ID);
		sb.append(", UPDATE_REQUEST_DATE=");
		sb.append(UPDATE_REQUEST_DATE);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UpdateRequesterRegistration toEntityModel() {
		UpdateRequesterRegistrationImpl updateRequesterRegistrationImpl = new UpdateRequesterRegistrationImpl();

		if (uuid == null) {
			updateRequesterRegistrationImpl.setUuid("");
		}
		else {
			updateRequesterRegistrationImpl.setUuid(uuid);
		}

		updateRequesterRegistrationImpl.setPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);
		updateRequesterRegistrationImpl.setPROJECT_ID(PROJECT_ID);
		updateRequesterRegistrationImpl.setUPDATE_REQUESTER_USER_ID(UPDATE_REQUESTER_USER_ID);

		if (UPDATE_REQUEST_DATE == Long.MIN_VALUE) {
			updateRequesterRegistrationImpl.setUPDATE_REQUEST_DATE(null);
		}
		else {
			updateRequesterRegistrationImpl.setUPDATE_REQUEST_DATE(new Date(
					UPDATE_REQUEST_DATE));
		}

		updateRequesterRegistrationImpl.setSTATUS(STATUS);

		updateRequesterRegistrationImpl.resetOriginalValues();

		return updateRequesterRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_UPDATE_REQUEST_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();

		UPDATE_REQUESTER_USER_ID = objectInput.readLong();
		UPDATE_REQUEST_DATE = objectInput.readLong();

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

		objectOutput.writeLong(PROJECT_UPDATE_REQUEST_ID);

		objectOutput.writeLong(PROJECT_ID);

		objectOutput.writeLong(UPDATE_REQUESTER_USER_ID);
		objectOutput.writeLong(UPDATE_REQUEST_DATE);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long PROJECT_UPDATE_REQUEST_ID;
	public long PROJECT_ID;
	public long UPDATE_REQUESTER_USER_ID;
	public long UPDATE_REQUEST_DATE;
	public int STATUS;
}