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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.ProjectFollowerRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.ProjectFollowerRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class ProjectFollowerRegistrationSoap implements Serializable {
	public static ProjectFollowerRegistrationSoap toSoapModel(
		ProjectFollowerRegistration model) {
		ProjectFollowerRegistrationSoap soapModel = new ProjectFollowerRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_FOLLOWER_ID(model.getPROJECT_FOLLOWER_ID());
		soapModel.setUSER_ID(model.getUSER_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static ProjectFollowerRegistrationSoap[] toSoapModels(
		ProjectFollowerRegistration[] models) {
		ProjectFollowerRegistrationSoap[] soapModels = new ProjectFollowerRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectFollowerRegistrationSoap[][] toSoapModels(
		ProjectFollowerRegistration[][] models) {
		ProjectFollowerRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectFollowerRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectFollowerRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectFollowerRegistrationSoap[] toSoapModels(
		List<ProjectFollowerRegistration> models) {
		List<ProjectFollowerRegistrationSoap> soapModels = new ArrayList<ProjectFollowerRegistrationSoap>(models.size());

		for (ProjectFollowerRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectFollowerRegistrationSoap[soapModels.size()]);
	}

	public ProjectFollowerRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_FOLLOWER_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_FOLLOWER_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_FOLLOWER_ID() {
		return _PROJECT_FOLLOWER_ID;
	}

	public void setPROJECT_FOLLOWER_ID(long PROJECT_FOLLOWER_ID) {
		_PROJECT_FOLLOWER_ID = PROJECT_FOLLOWER_ID;
	}

	public long getUSER_ID() {
		return _USER_ID;
	}

	public void setUSER_ID(long USER_ID) {
		_USER_ID = USER_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _PROJECT_FOLLOWER_ID;
	private long _USER_ID;
	private long _PROJECT_ID;
	private int _STATUS;
}