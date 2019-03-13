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

import com.crowd.funding.database.model.QuestionRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QuestionRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRegistration
 * @generated
 */
@ProviderType
public class QuestionRegistrationCacheModel implements CacheModel<QuestionRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionRegistrationCacheModel)) {
			return false;
		}

		QuestionRegistrationCacheModel questionRegistrationCacheModel = (QuestionRegistrationCacheModel)obj;

		if (PROJECT_QUESTION_ID == questionRegistrationCacheModel.PROJECT_QUESTION_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_QUESTION_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_QUESTION_ID=");
		sb.append(PROJECT_QUESTION_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", QUESTION=");
		sb.append(QUESTION);
		sb.append(", QUESTION_REQUESTER_USER_ID=");
		sb.append(QUESTION_REQUESTER_USER_ID);
		sb.append(", QUESTION_DATE=");
		sb.append(QUESTION_DATE);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuestionRegistration toEntityModel() {
		QuestionRegistrationImpl questionRegistrationImpl = new QuestionRegistrationImpl();

		if (uuid == null) {
			questionRegistrationImpl.setUuid("");
		}
		else {
			questionRegistrationImpl.setUuid(uuid);
		}

		questionRegistrationImpl.setPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);
		questionRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (QUESTION == null) {
			questionRegistrationImpl.setQUESTION("");
		}
		else {
			questionRegistrationImpl.setQUESTION(QUESTION);
		}

		questionRegistrationImpl.setQUESTION_REQUESTER_USER_ID(QUESTION_REQUESTER_USER_ID);

		if (QUESTION_DATE == Long.MIN_VALUE) {
			questionRegistrationImpl.setQUESTION_DATE(null);
		}
		else {
			questionRegistrationImpl.setQUESTION_DATE(new Date(QUESTION_DATE));
		}

		questionRegistrationImpl.setSTATUS(STATUS);

		questionRegistrationImpl.resetOriginalValues();

		return questionRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_QUESTION_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		QUESTION = objectInput.readUTF();

		QUESTION_REQUESTER_USER_ID = objectInput.readLong();
		QUESTION_DATE = objectInput.readLong();

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

		objectOutput.writeLong(PROJECT_QUESTION_ID);

		objectOutput.writeLong(PROJECT_ID);

		if (QUESTION == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(QUESTION);
		}

		objectOutput.writeLong(QUESTION_REQUESTER_USER_ID);
		objectOutput.writeLong(QUESTION_DATE);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long PROJECT_QUESTION_ID;
	public long PROJECT_ID;
	public String QUESTION;
	public long QUESTION_REQUESTER_USER_ID;
	public long QUESTION_DATE;
	public int STATUS;
}