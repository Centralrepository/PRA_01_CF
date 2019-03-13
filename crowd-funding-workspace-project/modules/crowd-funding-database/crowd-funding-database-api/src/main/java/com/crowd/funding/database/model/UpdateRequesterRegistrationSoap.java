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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.UpdateRequesterRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.UpdateRequesterRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class UpdateRequesterRegistrationSoap implements Serializable {
	public static UpdateRequesterRegistrationSoap toSoapModel(
		UpdateRequesterRegistration model) {
		UpdateRequesterRegistrationSoap soapModel = new UpdateRequesterRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_UPDATE_REQUEST_ID(model.getPROJECT_UPDATE_REQUEST_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setUPDATE_REQUESTER_USER_ID(model.getUPDATE_REQUESTER_USER_ID());
		soapModel.setUPDATE_REQUEST_DATE(model.getUPDATE_REQUEST_DATE());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static UpdateRequesterRegistrationSoap[] toSoapModels(
		UpdateRequesterRegistration[] models) {
		UpdateRequesterRegistrationSoap[] soapModels = new UpdateRequesterRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UpdateRequesterRegistrationSoap[][] toSoapModels(
		UpdateRequesterRegistration[][] models) {
		UpdateRequesterRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UpdateRequesterRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UpdateRequesterRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UpdateRequesterRegistrationSoap[] toSoapModels(
		List<UpdateRequesterRegistration> models) {
		List<UpdateRequesterRegistrationSoap> soapModels = new ArrayList<UpdateRequesterRegistrationSoap>(models.size());

		for (UpdateRequesterRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UpdateRequesterRegistrationSoap[soapModels.size()]);
	}

	public UpdateRequesterRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_UPDATE_REQUEST_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_UPDATE_REQUEST_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_UPDATE_REQUEST_ID() {
		return _PROJECT_UPDATE_REQUEST_ID;
	}

	public void setPROJECT_UPDATE_REQUEST_ID(long PROJECT_UPDATE_REQUEST_ID) {
		_PROJECT_UPDATE_REQUEST_ID = PROJECT_UPDATE_REQUEST_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public long getUPDATE_REQUESTER_USER_ID() {
		return _UPDATE_REQUESTER_USER_ID;
	}

	public void setUPDATE_REQUESTER_USER_ID(long UPDATE_REQUESTER_USER_ID) {
		_UPDATE_REQUESTER_USER_ID = UPDATE_REQUESTER_USER_ID;
	}

	public Date getUPDATE_REQUEST_DATE() {
		return _UPDATE_REQUEST_DATE;
	}

	public void setUPDATE_REQUEST_DATE(Date UPDATE_REQUEST_DATE) {
		_UPDATE_REQUEST_DATE = UPDATE_REQUEST_DATE;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _PROJECT_UPDATE_REQUEST_ID;
	private long _PROJECT_ID;
	private long _UPDATE_REQUESTER_USER_ID;
	private Date _UPDATE_REQUEST_DATE;
	private int _STATUS;
}