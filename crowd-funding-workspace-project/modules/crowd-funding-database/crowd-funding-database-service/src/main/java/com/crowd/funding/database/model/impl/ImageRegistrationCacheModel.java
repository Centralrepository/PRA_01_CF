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

import com.crowd.funding.database.model.ImageRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ImageRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ImageRegistration
 * @generated
 */
@ProviderType
public class ImageRegistrationCacheModel implements CacheModel<ImageRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImageRegistrationCacheModel)) {
			return false;
		}

		ImageRegistrationCacheModel imageRegistrationCacheModel = (ImageRegistrationCacheModel)obj;

		if (PROJECT_IMAGE_ID == imageRegistrationCacheModel.PROJECT_IMAGE_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_IMAGE_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_IMAGE_ID=");
		sb.append(PROJECT_IMAGE_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", IMAGE_NAME=");
		sb.append(IMAGE_NAME);
		sb.append(", IMAGE_TYPE=");
		sb.append(IMAGE_TYPE);

		return sb.toString();
	}

	@Override
	public ImageRegistration toEntityModel() {
		ImageRegistrationImpl imageRegistrationImpl = new ImageRegistrationImpl();

		if (uuid == null) {
			imageRegistrationImpl.setUuid("");
		}
		else {
			imageRegistrationImpl.setUuid(uuid);
		}

		imageRegistrationImpl.setPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);
		imageRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (IMAGE_NAME == null) {
			imageRegistrationImpl.setIMAGE_NAME("");
		}
		else {
			imageRegistrationImpl.setIMAGE_NAME(IMAGE_NAME);
		}

		if (IMAGE_TYPE == null) {
			imageRegistrationImpl.setIMAGE_TYPE("");
		}
		else {
			imageRegistrationImpl.setIMAGE_TYPE(IMAGE_TYPE);
		}

		imageRegistrationImpl.resetOriginalValues();

		return imageRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_IMAGE_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		IMAGE_NAME = objectInput.readUTF();
		IMAGE_TYPE = objectInput.readUTF();
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

		objectOutput.writeLong(PROJECT_IMAGE_ID);

		objectOutput.writeLong(PROJECT_ID);

		if (IMAGE_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(IMAGE_NAME);
		}

		if (IMAGE_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(IMAGE_TYPE);
		}
	}

	public String uuid;
	public long PROJECT_IMAGE_ID;
	public long PROJECT_ID;
	public String IMAGE_NAME;
	public String IMAGE_TYPE;
}