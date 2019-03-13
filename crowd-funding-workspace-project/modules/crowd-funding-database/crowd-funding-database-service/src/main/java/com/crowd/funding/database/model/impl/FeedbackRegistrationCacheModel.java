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

import com.crowd.funding.database.model.FeedbackRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FeedbackRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackRegistration
 * @generated
 */
@ProviderType
public class FeedbackRegistrationCacheModel implements CacheModel<FeedbackRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackRegistrationCacheModel)) {
			return false;
		}

		FeedbackRegistrationCacheModel feedbackRegistrationCacheModel = (FeedbackRegistrationCacheModel)obj;

		if (PROJECT_FEEDBACK_ID == feedbackRegistrationCacheModel.PROJECT_FEEDBACK_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_FEEDBACK_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_FEEDBACK_ID=");
		sb.append(PROJECT_FEEDBACK_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", FEEDBACK=");
		sb.append(FEEDBACK);
		sb.append(", DONOR_USER_ID=");
		sb.append(DONOR_USER_ID);
		sb.append(", FEEDBACK_DATE=");
		sb.append(FEEDBACK_DATE);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FeedbackRegistration toEntityModel() {
		FeedbackRegistrationImpl feedbackRegistrationImpl = new FeedbackRegistrationImpl();

		if (uuid == null) {
			feedbackRegistrationImpl.setUuid("");
		}
		else {
			feedbackRegistrationImpl.setUuid(uuid);
		}

		feedbackRegistrationImpl.setPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);
		feedbackRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (FEEDBACK == null) {
			feedbackRegistrationImpl.setFEEDBACK("");
		}
		else {
			feedbackRegistrationImpl.setFEEDBACK(FEEDBACK);
		}

		feedbackRegistrationImpl.setDONOR_USER_ID(DONOR_USER_ID);

		if (FEEDBACK_DATE == Long.MIN_VALUE) {
			feedbackRegistrationImpl.setFEEDBACK_DATE(null);
		}
		else {
			feedbackRegistrationImpl.setFEEDBACK_DATE(new Date(FEEDBACK_DATE));
		}

		feedbackRegistrationImpl.setSTATUS(STATUS);

		feedbackRegistrationImpl.resetOriginalValues();

		return feedbackRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_FEEDBACK_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		FEEDBACK = objectInput.readUTF();

		DONOR_USER_ID = objectInput.readLong();
		FEEDBACK_DATE = objectInput.readLong();

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

		objectOutput.writeLong(PROJECT_FEEDBACK_ID);

		objectOutput.writeLong(PROJECT_ID);

		if (FEEDBACK == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FEEDBACK);
		}

		objectOutput.writeLong(DONOR_USER_ID);
		objectOutput.writeLong(FEEDBACK_DATE);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long PROJECT_FEEDBACK_ID;
	public long PROJECT_ID;
	public String FEEDBACK;
	public long DONOR_USER_ID;
	public long FEEDBACK_DATE;
	public int STATUS;
}