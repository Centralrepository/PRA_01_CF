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

import com.crowd.funding.database.model.CommentRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommentRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CommentRegistration
 * @generated
 */
@ProviderType
public class CommentRegistrationCacheModel implements CacheModel<CommentRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommentRegistrationCacheModel)) {
			return false;
		}

		CommentRegistrationCacheModel commentRegistrationCacheModel = (CommentRegistrationCacheModel)obj;

		if (PROJECT_COMMENT_ID == commentRegistrationCacheModel.PROJECT_COMMENT_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_COMMENT_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_COMMENT_ID=");
		sb.append(PROJECT_COMMENT_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", COMMENT=");
		sb.append(COMMENT);
		sb.append(", ANSWER=");
		sb.append(ANSWER);
		sb.append(", DONOR_USER_ID=");
		sb.append(DONOR_USER_ID);
		sb.append(", COMMENT_DATE=");
		sb.append(COMMENT_DATE);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommentRegistration toEntityModel() {
		CommentRegistrationImpl commentRegistrationImpl = new CommentRegistrationImpl();

		if (uuid == null) {
			commentRegistrationImpl.setUuid("");
		}
		else {
			commentRegistrationImpl.setUuid(uuid);
		}

		commentRegistrationImpl.setPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);
		commentRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (COMMENT == null) {
			commentRegistrationImpl.setCOMMENT("");
		}
		else {
			commentRegistrationImpl.setCOMMENT(COMMENT);
		}

		if (ANSWER == null) {
			commentRegistrationImpl.setANSWER("");
		}
		else {
			commentRegistrationImpl.setANSWER(ANSWER);
		}

		commentRegistrationImpl.setDONOR_USER_ID(DONOR_USER_ID);

		if (COMMENT_DATE == Long.MIN_VALUE) {
			commentRegistrationImpl.setCOMMENT_DATE(null);
		}
		else {
			commentRegistrationImpl.setCOMMENT_DATE(new Date(COMMENT_DATE));
		}

		commentRegistrationImpl.setSTATUS(STATUS);

		commentRegistrationImpl.resetOriginalValues();

		return commentRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_COMMENT_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		COMMENT = objectInput.readUTF();
		ANSWER = objectInput.readUTF();

		DONOR_USER_ID = objectInput.readLong();
		COMMENT_DATE = objectInput.readLong();

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

		objectOutput.writeLong(PROJECT_COMMENT_ID);

		objectOutput.writeLong(PROJECT_ID);

		if (COMMENT == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(COMMENT);
		}

		if (ANSWER == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ANSWER);
		}

		objectOutput.writeLong(DONOR_USER_ID);
		objectOutput.writeLong(COMMENT_DATE);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long PROJECT_COMMENT_ID;
	public long PROJECT_ID;
	public String COMMENT;
	public String ANSWER;
	public long DONOR_USER_ID;
	public long COMMENT_DATE;
	public int STATUS;
}