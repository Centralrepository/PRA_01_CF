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

import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectAcknowledgementRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectAcknowledgementRegistration
 * @generated
 */
@ProviderType
public class ProjectAcknowledgementRegistrationCacheModel implements CacheModel<ProjectAcknowledgementRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectAcknowledgementRegistrationCacheModel)) {
			return false;
		}

		ProjectAcknowledgementRegistrationCacheModel projectAcknowledgementRegistrationCacheModel =
			(ProjectAcknowledgementRegistrationCacheModel)obj;

		if (ACKNOWLEDGMENT_ID == projectAcknowledgementRegistrationCacheModel.ACKNOWLEDGMENT_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ACKNOWLEDGMENT_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ACKNOWLEDGMENT_ID=");
		sb.append(ACKNOWLEDGMENT_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", DETAILS=");
		sb.append(DETAILS);
		sb.append(", DOCUMENT_NAME=");
		sb.append(DOCUMENT_NAME);
		sb.append(", DOCUMENT_TYPE=");
		sb.append(DOCUMENT_TYPE);
		sb.append(", VIDEO_TYPE=");
		sb.append(VIDEO_TYPE);
		sb.append(", DATE=");
		sb.append(DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectAcknowledgementRegistration toEntityModel() {
		ProjectAcknowledgementRegistrationImpl projectAcknowledgementRegistrationImpl =
			new ProjectAcknowledgementRegistrationImpl();

		if (uuid == null) {
			projectAcknowledgementRegistrationImpl.setUuid("");
		}
		else {
			projectAcknowledgementRegistrationImpl.setUuid(uuid);
		}

		projectAcknowledgementRegistrationImpl.setACKNOWLEDGMENT_ID(ACKNOWLEDGMENT_ID);
		projectAcknowledgementRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (DETAILS == null) {
			projectAcknowledgementRegistrationImpl.setDETAILS("");
		}
		else {
			projectAcknowledgementRegistrationImpl.setDETAILS(DETAILS);
		}

		if (DOCUMENT_NAME == null) {
			projectAcknowledgementRegistrationImpl.setDOCUMENT_NAME("");
		}
		else {
			projectAcknowledgementRegistrationImpl.setDOCUMENT_NAME(DOCUMENT_NAME);
		}

		if (DOCUMENT_TYPE == null) {
			projectAcknowledgementRegistrationImpl.setDOCUMENT_TYPE("");
		}
		else {
			projectAcknowledgementRegistrationImpl.setDOCUMENT_TYPE(DOCUMENT_TYPE);
		}

		if (VIDEO_TYPE == null) {
			projectAcknowledgementRegistrationImpl.setVIDEO_TYPE("");
		}
		else {
			projectAcknowledgementRegistrationImpl.setVIDEO_TYPE(VIDEO_TYPE);
		}

		if (DATE == Long.MIN_VALUE) {
			projectAcknowledgementRegistrationImpl.setDATE(null);
		}
		else {
			projectAcknowledgementRegistrationImpl.setDATE(new Date(DATE));
		}

		projectAcknowledgementRegistrationImpl.resetOriginalValues();

		return projectAcknowledgementRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ACKNOWLEDGMENT_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		DETAILS = objectInput.readUTF();
		DOCUMENT_NAME = objectInput.readUTF();
		DOCUMENT_TYPE = objectInput.readUTF();
		VIDEO_TYPE = objectInput.readUTF();
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

		objectOutput.writeLong(ACKNOWLEDGMENT_ID);

		objectOutput.writeLong(PROJECT_ID);

		if (DETAILS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DETAILS);
		}

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

		if (VIDEO_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(VIDEO_TYPE);
		}

		objectOutput.writeLong(DATE);
	}

	public String uuid;
	public long ACKNOWLEDGMENT_ID;
	public long PROJECT_ID;
	public String DETAILS;
	public String DOCUMENT_NAME;
	public String DOCUMENT_TYPE;
	public String VIDEO_TYPE;
	public long DATE;
}