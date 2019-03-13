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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.UserRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.UserRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class UserRegistrationSoap implements Serializable {
	public static UserRegistrationSoap toSoapModel(UserRegistration model) {
		UserRegistrationSoap soapModel = new UserRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUSER_ID(model.getUSER_ID());
		soapModel.setUSER_OTP_ID(model.getUSER_OTP_ID());
		soapModel.setFULL_NAME(model.getFULL_NAME());
		soapModel.setPASSWORD(model.getPASSWORD());
		soapModel.setGENDER(model.getGENDER());
		soapModel.setCREATION_DATE(model.getCREATION_DATE());

		return soapModel;
	}

	public static UserRegistrationSoap[] toSoapModels(UserRegistration[] models) {
		UserRegistrationSoap[] soapModels = new UserRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationSoap[][] toSoapModels(
		UserRegistration[][] models) {
		UserRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserRegistrationSoap[] toSoapModels(
		List<UserRegistration> models) {
		List<UserRegistrationSoap> soapModels = new ArrayList<UserRegistrationSoap>(models.size());

		for (UserRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserRegistrationSoap[soapModels.size()]);
	}

	public UserRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _USER_ID;
	}

	public void setPrimaryKey(long pk) {
		setUSER_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUSER_ID() {
		return _USER_ID;
	}

	public void setUSER_ID(long USER_ID) {
		_USER_ID = USER_ID;
	}

	public long getUSER_OTP_ID() {
		return _USER_OTP_ID;
	}

	public void setUSER_OTP_ID(long USER_OTP_ID) {
		_USER_OTP_ID = USER_OTP_ID;
	}

	public String getFULL_NAME() {
		return _FULL_NAME;
	}

	public void setFULL_NAME(String FULL_NAME) {
		_FULL_NAME = FULL_NAME;
	}

	public String getPASSWORD() {
		return _PASSWORD;
	}

	public void setPASSWORD(String PASSWORD) {
		_PASSWORD = PASSWORD;
	}

	public String getGENDER() {
		return _GENDER;
	}

	public void setGENDER(String GENDER) {
		_GENDER = GENDER;
	}

	public Date getCREATION_DATE() {
		return _CREATION_DATE;
	}

	public void setCREATION_DATE(Date CREATION_DATE) {
		_CREATION_DATE = CREATION_DATE;
	}

	private String _uuid;
	private long _USER_ID;
	private long _USER_OTP_ID;
	private String _FULL_NAME;
	private String _PASSWORD;
	private String _GENDER;
	private Date _CREATION_DATE;
}