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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.UserFollowRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.UserFollowRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class UserFollowRegistrationSoap implements Serializable {
	public static UserFollowRegistrationSoap toSoapModel(
		UserFollowRegistration model) {
		UserFollowRegistrationSoap soapModel = new UserFollowRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUSER_FOLLOW_ID(model.getUSER_FOLLOW_ID());
		soapModel.setUSER_ID(model.getUSER_ID());
		soapModel.setFOLLOWER_USER_ID(model.getFOLLOWER_USER_ID());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static UserFollowRegistrationSoap[] toSoapModels(
		UserFollowRegistration[] models) {
		UserFollowRegistrationSoap[] soapModels = new UserFollowRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserFollowRegistrationSoap[][] toSoapModels(
		UserFollowRegistration[][] models) {
		UserFollowRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserFollowRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserFollowRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserFollowRegistrationSoap[] toSoapModels(
		List<UserFollowRegistration> models) {
		List<UserFollowRegistrationSoap> soapModels = new ArrayList<UserFollowRegistrationSoap>(models.size());

		for (UserFollowRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserFollowRegistrationSoap[soapModels.size()]);
	}

	public UserFollowRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _USER_FOLLOW_ID;
	}

	public void setPrimaryKey(long pk) {
		setUSER_FOLLOW_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUSER_FOLLOW_ID() {
		return _USER_FOLLOW_ID;
	}

	public void setUSER_FOLLOW_ID(long USER_FOLLOW_ID) {
		_USER_FOLLOW_ID = USER_FOLLOW_ID;
	}

	public long getUSER_ID() {
		return _USER_ID;
	}

	public void setUSER_ID(long USER_ID) {
		_USER_ID = USER_ID;
	}

	public long getFOLLOWER_USER_ID() {
		return _FOLLOWER_USER_ID;
	}

	public void setFOLLOWER_USER_ID(long FOLLOWER_USER_ID) {
		_FOLLOWER_USER_ID = FOLLOWER_USER_ID;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _USER_FOLLOW_ID;
	private long _USER_ID;
	private long _FOLLOWER_USER_ID;
	private int _STATUS;
}