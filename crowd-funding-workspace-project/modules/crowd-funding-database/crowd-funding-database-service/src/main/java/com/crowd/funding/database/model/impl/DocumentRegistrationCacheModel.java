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

import com.crowd.funding.database.model.DocumentRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DocumentRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentRegistration
 * @generated
 */
@ProviderType
public class DocumentRegistrationCacheModel implements CacheModel<DocumentRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentRegistrationCacheModel)) {
			return false;
		}

		DocumentRegistrationCacheModel documentRegistrationCacheModel = (DocumentRegistrationCacheModel)obj;

		if (PROJECT_DOCUMENT_ID == documentRegistrationCacheModel.PROJECT_DOCUMENT_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_DOCUMENT_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_DOCUMENT_ID=");
		sb.append(PROJECT_DOCUMENT_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", DOCUMENT_NAME=");
		sb.append(DOCUMENT_NAME);
		sb.append(", DOCUMENT_TYPE=");
		sb.append(DOCUMENT_TYPE);

		return sb.toString();
	}

	@Override
	public DocumentRegistration toEntityModel() {
		DocumentRegistrationImpl documentRegistrationImpl = new DocumentRegistrationImpl();

		if (uuid == null) {
			documentRegistrationImpl.setUuid("");
		}
		else {
			documentRegistrationImpl.setUuid(uuid);
		}

		documentRegistrationImpl.setPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);
		documentRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (DOCUMENT_NAME == null) {
			documentRegistrationImpl.setDOCUMENT_NAME("");
		}
		else {
			documentRegistrationImpl.setDOCUMENT_NAME(DOCUMENT_NAME);
		}

		if (DOCUMENT_TYPE == null) {
			documentRegistrationImpl.setDOCUMENT_TYPE("");
		}
		else {
			documentRegistrationImpl.setDOCUMENT_TYPE(DOCUMENT_TYPE);
		}

		documentRegistrationImpl.resetOriginalValues();

		return documentRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_DOCUMENT_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		DOCUMENT_NAME = objectInput.readUTF();
		DOCUMENT_TYPE = objectInput.readUTF();
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

		objectOutput.writeLong(PROJECT_DOCUMENT_ID);

		objectOutput.writeLong(PROJECT_ID);

		if (DOCUMENT_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DOCUMENT_NAME);
		}

		if (DOCUMENT_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DOCUMENT_TYPE);
		}
	}

	public String uuid;
	public long PROJECT_DOCUMENT_ID;
	public long PROJECT_ID;
	public String DOCUMENT_NAME;
	public String DOCUMENT_TYPE;
}