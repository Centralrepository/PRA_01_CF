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

import com.crowd.funding.database.model.NewsLetterRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NewsLetterRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterRegistration
 * @generated
 */
@ProviderType
public class NewsLetterRegistrationCacheModel implements CacheModel<NewsLetterRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsLetterRegistrationCacheModel)) {
			return false;
		}

		NewsLetterRegistrationCacheModel newsLetterRegistrationCacheModel = (NewsLetterRegistrationCacheModel)obj;

		if (NEWS_LETTER_ID == newsLetterRegistrationCacheModel.NEWS_LETTER_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, NEWS_LETTER_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", NEWS_LETTER_ID=");
		sb.append(NEWS_LETTER_ID);
		sb.append(", TITLE=");
		sb.append(TITLE);
		sb.append(", DETAILS=");
		sb.append(DETAILS);
		sb.append(", DOCUMENT_TYPE=");
		sb.append(DOCUMENT_TYPE);
		sb.append(", DATE=");
		sb.append(DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NewsLetterRegistration toEntityModel() {
		NewsLetterRegistrationImpl newsLetterRegistrationImpl = new NewsLetterRegistrationImpl();

		if (uuid == null) {
			newsLetterRegistrationImpl.setUuid("");
		}
		else {
			newsLetterRegistrationImpl.setUuid(uuid);
		}

		newsLetterRegistrationImpl.setNEWS_LETTER_ID(NEWS_LETTER_ID);

		if (TITLE == null) {
			newsLetterRegistrationImpl.setTITLE("");
		}
		else {
			newsLetterRegistrationImpl.setTITLE(TITLE);
		}

		if (DETAILS == null) {
			newsLetterRegistrationImpl.setDETAILS("");
		}
		else {
			newsLetterRegistrationImpl.setDETAILS(DETAILS);
		}

		if (DOCUMENT_TYPE == null) {
			newsLetterRegistrationImpl.setDOCUMENT_TYPE("");
		}
		else {
			newsLetterRegistrationImpl.setDOCUMENT_TYPE(DOCUMENT_TYPE);
		}

		if (DATE == Long.MIN_VALUE) {
			newsLetterRegistrationImpl.setDATE(null);
		}
		else {
			newsLetterRegistrationImpl.setDATE(new Date(DATE));
		}

		newsLetterRegistrationImpl.resetOriginalValues();

		return newsLetterRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		NEWS_LETTER_ID = objectInput.readLong();
		TITLE = objectInput.readUTF();
		DETAILS = objectInput.readUTF();
		DOCUMENT_TYPE = objectInput.readUTF();
		DATE = objectInput.readLong();
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

		objectOutput.writeLong(NEWS_LETTER_ID);

		if (TITLE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TITLE);
		}

		if (DETAILS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DETAILS);
		}

		if (DOCUMENT_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DOCUMENT_TYPE);
		}

		objectOutput.writeLong(DATE);
	}

	public String uuid;
	public long NEWS_LETTER_ID;
	public String TITLE;
	public String DETAILS;
	public String DOCUMENT_TYPE;
	public long DATE;
}