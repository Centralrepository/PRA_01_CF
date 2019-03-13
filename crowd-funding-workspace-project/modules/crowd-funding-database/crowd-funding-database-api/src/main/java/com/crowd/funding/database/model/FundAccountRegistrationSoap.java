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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.FundAccountRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.FundAccountRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class FundAccountRegistrationSoap implements Serializable {
	public static FundAccountRegistrationSoap toSoapModel(
		FundAccountRegistration model) {
		FundAccountRegistrationSoap soapModel = new FundAccountRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setACCOUNT_ID(model.getACCOUNT_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setACCOUNT_NO(model.getACCOUNT_NO());
		soapModel.setACCOUNT_HOLDER_NAME(model.getACCOUNT_HOLDER_NAME());
		soapModel.setIFSC_CODE(model.getIFSC_CODE());
		soapModel.setUPI_NO(model.getUPI_NO());

		return soapModel;
	}

	public static FundAccountRegistrationSoap[] toSoapModels(
		FundAccountRegistration[] models) {
		FundAccountRegistrationSoap[] soapModels = new FundAccountRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FundAccountRegistrationSoap[][] toSoapModels(
		FundAccountRegistration[][] models) {
		FundAccountRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FundAccountRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FundAccountRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FundAccountRegistrationSoap[] toSoapModels(
		List<FundAccountRegistration> models) {
		List<FundAccountRegistrationSoap> soapModels = new ArrayList<FundAccountRegistrationSoap>(models.size());

		for (FundAccountRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FundAccountRegistrationSoap[soapModels.size()]);
	}

	public FundAccountRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _ACCOUNT_ID;
	}

	public void setPrimaryKey(long pk) {
		setACCOUNT_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getACCOUNT_ID() {
		return _ACCOUNT_ID;
	}

	public void setACCOUNT_ID(long ACCOUNT_ID) {
		_ACCOUNT_ID = ACCOUNT_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public long getACCOUNT_NO() {
		return _ACCOUNT_NO;
	}

	public void setACCOUNT_NO(long ACCOUNT_NO) {
		_ACCOUNT_NO = ACCOUNT_NO;
	}

	public String getACCOUNT_HOLDER_NAME() {
		return _ACCOUNT_HOLDER_NAME;
	}

	public void setACCOUNT_HOLDER_NAME(String ACCOUNT_HOLDER_NAME) {
		_ACCOUNT_HOLDER_NAME = ACCOUNT_HOLDER_NAME;
	}

	public String getIFSC_CODE() {
		return _IFSC_CODE;
	}

	public void setIFSC_CODE(String IFSC_CODE) {
		_IFSC_CODE = IFSC_CODE;
	}

	public String getUPI_NO() {
		return _UPI_NO;
	}

	public void setUPI_NO(String UPI_NO) {
		_UPI_NO = UPI_NO;
	}

	private String _uuid;
	private long _ACCOUNT_ID;
	private long _PROJECT_ID;
	private long _ACCOUNT_NO;
	private String _ACCOUNT_HOLDER_NAME;
	private String _IFSC_CODE;
	private String _UPI_NO;
}