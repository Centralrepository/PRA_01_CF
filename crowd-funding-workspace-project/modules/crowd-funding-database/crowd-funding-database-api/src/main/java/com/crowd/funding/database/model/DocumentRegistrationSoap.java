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

package com.crowd.funding.database.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.DocumentRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.DocumentRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class DocumentRegistrationSoap implements Serializable {
	public static DocumentRegistrationSoap toSoapModel(
		DocumentRegistration model) {
		DocumentRegistrationSoap soapModel = new DocumentRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_DOCUMENT_ID(model.getPROJECT_DOCUMENT_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setDOCUMENT_NAME(model.getDOCUMENT_NAME());
		soapModel.setDOCUMENT_TYPE(model.getDOCUMENT_TYPE());
		soapModel.setDOCUMENT(model.getDOCUMENT());

		return soapModel;
	}

	public static DocumentRegistrationSoap[] toSoapModels(
		DocumentRegistration[] models) {
		DocumentRegistrationSoap[] soapModels = new DocumentRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocumentRegistrationSoap[][] toSoapModels(
		DocumentRegistration[][] models) {
		DocumentRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DocumentRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocumentRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocumentRegistrationSoap[] toSoapModels(
		List<DocumentRegistration> models) {
		List<DocumentRegistrationSoap> soapModels = new ArrayList<DocumentRegistrationSoap>(models.size());

		for (DocumentRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DocumentRegistrationSoap[soapModels.size()]);
	}

	public DocumentRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_DOCUMENT_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_DOCUMENT_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_DOCUMENT_ID() {
		return _PROJECT_DOCUMENT_ID;
	}

	public void setPROJECT_DOCUMENT_ID(long PROJECT_DOCUMENT_ID) {
		_PROJECT_DOCUMENT_ID = PROJECT_DOCUMENT_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public String getDOCUMENT_NAME() {
		return _DOCUMENT_NAME;
	}

	public void setDOCUMENT_NAME(String DOCUMENT_NAME) {
		_DOCUMENT_NAME = DOCUMENT_NAME;
	}

	public String getDOCUMENT_TYPE() {
		return _DOCUMENT_TYPE;
	}

	public void setDOCUMENT_TYPE(String DOCUMENT_TYPE) {
		_DOCUMENT_TYPE = DOCUMENT_TYPE;
	}

	public Blob getDOCUMENT() {
		return _DOCUMENT;
	}

	public void setDOCUMENT(Blob DOCUMENT) {
		_DOCUMENT = DOCUMENT;
	}

	private String _uuid;
	private long _PROJECT_DOCUMENT_ID;
	private long _PROJECT_ID;
	private String _DOCUMENT_NAME;
	private String _DOCUMENT_TYPE;
	private Blob _DOCUMENT;
}