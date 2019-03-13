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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.ProjectUpdateRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.ProjectUpdateRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class ProjectUpdateRegistrationSoap implements Serializable {
	public static ProjectUpdateRegistrationSoap toSoapModel(
		ProjectUpdateRegistration model) {
		ProjectUpdateRegistrationSoap soapModel = new ProjectUpdateRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_UPDATE_ID(model.getPROJECT_UPDATE_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setUPDATE_DETAILS(model.getUPDATE_DETAILS());
		soapModel.setUPDATE_DATE(model.getUPDATE_DATE());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static ProjectUpdateRegistrationSoap[] toSoapModels(
		ProjectUpdateRegistration[] models) {
		ProjectUpdateRegistrationSoap[] soapModels = new ProjectUpdateRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectUpdateRegistrationSoap[][] toSoapModels(
		ProjectUpdateRegistration[][] models) {
		ProjectUpdateRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectUpdateRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectUpdateRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectUpdateRegistrationSoap[] toSoapModels(
		List<ProjectUpdateRegistration> models) {
		List<ProjectUpdateRegistrationSoap> soapModels = new ArrayList<ProjectUpdateRegistrationSoap>(models.size());

		for (ProjectUpdateRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectUpdateRegistrationSoap[soapModels.size()]);
	}

	public ProjectUpdateRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_UPDATE_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_UPDATE_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_UPDATE_ID() {
		return _PROJECT_UPDATE_ID;
	}

	public void setPROJECT_UPDATE_ID(long PROJECT_UPDATE_ID) {
		_PROJECT_UPDATE_ID = PROJECT_UPDATE_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public String getUPDATE_DETAILS() {
		return _UPDATE_DETAILS;
	}

	public void setUPDATE_DETAILS(String UPDATE_DETAILS) {
		_UPDATE_DETAILS = UPDATE_DETAILS;
	}

	public Date getUPDATE_DATE() {
		return _UPDATE_DATE;
	}

	public void setUPDATE_DATE(Date UPDATE_DATE) {
		_UPDATE_DATE = UPDATE_DATE;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _PROJECT_UPDATE_ID;
	private long _PROJECT_ID;
	private String _UPDATE_DETAILS;
	private Date _UPDATE_DATE;
	private int _STATUS;
}