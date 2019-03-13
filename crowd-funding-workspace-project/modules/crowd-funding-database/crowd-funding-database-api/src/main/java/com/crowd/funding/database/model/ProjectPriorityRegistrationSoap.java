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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.ProjectPriorityRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.ProjectPriorityRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class ProjectPriorityRegistrationSoap implements Serializable {
	public static ProjectPriorityRegistrationSoap toSoapModel(
		ProjectPriorityRegistration model) {
		ProjectPriorityRegistrationSoap soapModel = new ProjectPriorityRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_PRIORITY_ID(model.getPROJECT_PRIORITY_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setPRIORITY(model.getPRIORITY());
		soapModel.setPRIORITY_SEQUANCE(model.getPRIORITY_SEQUANCE());

		return soapModel;
	}

	public static ProjectPriorityRegistrationSoap[] toSoapModels(
		ProjectPriorityRegistration[] models) {
		ProjectPriorityRegistrationSoap[] soapModels = new ProjectPriorityRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectPriorityRegistrationSoap[][] toSoapModels(
		ProjectPriorityRegistration[][] models) {
		ProjectPriorityRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectPriorityRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectPriorityRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectPriorityRegistrationSoap[] toSoapModels(
		List<ProjectPriorityRegistration> models) {
		List<ProjectPriorityRegistrationSoap> soapModels = new ArrayList<ProjectPriorityRegistrationSoap>(models.size());

		for (ProjectPriorityRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectPriorityRegistrationSoap[soapModels.size()]);
	}

	public ProjectPriorityRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_PRIORITY_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_PRIORITY_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_PRIORITY_ID() {
		return _PROJECT_PRIORITY_ID;
	}

	public void setPROJECT_PRIORITY_ID(long PROJECT_PRIORITY_ID) {
		_PROJECT_PRIORITY_ID = PROJECT_PRIORITY_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public int getPRIORITY() {
		return _PRIORITY;
	}

	public void setPRIORITY(int PRIORITY) {
		_PRIORITY = PRIORITY;
	}

	public int getPRIORITY_SEQUANCE() {
		return _PRIORITY_SEQUANCE;
	}

	public void setPRIORITY_SEQUANCE(int PRIORITY_SEQUANCE) {
		_PRIORITY_SEQUANCE = PRIORITY_SEQUANCE;
	}

	private String _uuid;
	private long _PROJECT_PRIORITY_ID;
	private long _PROJECT_ID;
	private int _PRIORITY;
	private int _PRIORITY_SEQUANCE;
}