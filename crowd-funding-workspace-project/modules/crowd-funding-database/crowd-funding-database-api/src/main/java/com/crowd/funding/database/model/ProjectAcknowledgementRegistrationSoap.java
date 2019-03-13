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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.ProjectAcknowledgementRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.ProjectAcknowledgementRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class ProjectAcknowledgementRegistrationSoap implements Serializable {
	public static ProjectAcknowledgementRegistrationSoap toSoapModel(
		ProjectAcknowledgementRegistration model) {
		ProjectAcknowledgementRegistrationSoap soapModel = new ProjectAcknowledgementRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setACKNOWLEDGMENT_ID(model.getACKNOWLEDGMENT_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setDETAILS(model.getDETAILS());
		soapModel.setDOCUMENT_NAME(model.getDOCUMENT_NAME());
		soapModel.setDOCUMENT_TYPE(model.getDOCUMENT_TYPE());
		soapModel.setDOCUMENT(model.getDOCUMENT());
		soapModel.setVIDEO_TYPE(model.getVIDEO_TYPE());
		soapModel.setVIDEO(model.getVIDEO());
		soapModel.setDATE(model.getDATE());

		return soapModel;
	}

	public static ProjectAcknowledgementRegistrationSoap[] toSoapModels(
		ProjectAcknowledgementRegistration[] models) {
		ProjectAcknowledgementRegistrationSoap[] soapModels = new ProjectAcknowledgementRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectAcknowledgementRegistrationSoap[][] toSoapModels(
		ProjectAcknowledgementRegistration[][] models) {
		ProjectAcknowledgementRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectAcknowledgementRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectAcknowledgementRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectAcknowledgementRegistrationSoap[] toSoapModels(
		List<ProjectAcknowledgementRegistration> models) {
		List<ProjectAcknowledgementRegistrationSoap> soapModels = new ArrayList<ProjectAcknowledgementRegistrationSoap>(models.size());

		for (ProjectAcknowledgementRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectAcknowledgementRegistrationSoap[soapModels.size()]);
	}

	public ProjectAcknowledgementRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _ACKNOWLEDGMENT_ID;
	}

	public void setPrimaryKey(long pk) {
		setACKNOWLEDGMENT_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getACKNOWLEDGMENT_ID() {
		return _ACKNOWLEDGMENT_ID;
	}

	public void setACKNOWLEDGMENT_ID(long ACKNOWLEDGMENT_ID) {
		_ACKNOWLEDGMENT_ID = ACKNOWLEDGMENT_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public String getDETAILS() {
		return _DETAILS;
	}

	public void setDETAILS(String DETAILS) {
		_DETAILS = DETAILS;
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

	public String getVIDEO_TYPE() {
		return _VIDEO_TYPE;
	}

	public void setVIDEO_TYPE(String VIDEO_TYPE) {
		_VIDEO_TYPE = VIDEO_TYPE;
	}

	public Blob getVIDEO() {
		return _VIDEO;
	}

	public void setVIDEO(Blob VIDEO) {
		_VIDEO = VIDEO;
	}

	public Date getDATE() {
		return _DATE;
	}

	public void setDATE(Date DATE) {
		_DATE = DATE;
	}

	private String _uuid;
	private long _ACKNOWLEDGMENT_ID;
	private long _PROJECT_ID;
	private String _DETAILS;
	private String _DOCUMENT_NAME;
	private String _DOCUMENT_TYPE;
	private Blob _DOCUMENT;
	private String _VIDEO_TYPE;
	private Blob _VIDEO;
	private Date _DATE;
}