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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.FundRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.FundRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class FundRegistrationSoap implements Serializable {
	public static FundRegistrationSoap toSoapModel(FundRegistration model) {
		FundRegistrationSoap soapModel = new FundRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_FUND_ID(model.getPROJECT_FUND_ID());
		soapModel.setDONOR_ID(model.getDONOR_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setCURRENCY(model.getCURRENCY());
		soapModel.setDONATED_AMOUNT(model.getDONATED_AMOUNT());
		soapModel.setDONOR_USER_ID(model.getDONOR_USER_ID());
		soapModel.setDONOR_STATUS(model.getDONOR_STATUS());
		soapModel.setCOMMENT(model.getCOMMENT());
		soapModel.setDONATED_DATE(model.getDONATED_DATE());

		return soapModel;
	}

	public static FundRegistrationSoap[] toSoapModels(FundRegistration[] models) {
		FundRegistrationSoap[] soapModels = new FundRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FundRegistrationSoap[][] toSoapModels(
		FundRegistration[][] models) {
		FundRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FundRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FundRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FundRegistrationSoap[] toSoapModels(
		List<FundRegistration> models) {
		List<FundRegistrationSoap> soapModels = new ArrayList<FundRegistrationSoap>(models.size());

		for (FundRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FundRegistrationSoap[soapModels.size()]);
	}

	public FundRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_FUND_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_FUND_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_FUND_ID() {
		return _PROJECT_FUND_ID;
	}

	public void setPROJECT_FUND_ID(long PROJECT_FUND_ID) {
		_PROJECT_FUND_ID = PROJECT_FUND_ID;
	}

	public long getDONOR_ID() {
		return _DONOR_ID;
	}

	public void setDONOR_ID(long DONOR_ID) {
		_DONOR_ID = DONOR_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public String getCURRENCY() {
		return _CURRENCY;
	}

	public void setCURRENCY(String CURRENCY) {
		_CURRENCY = CURRENCY;
	}

	public float getDONATED_AMOUNT() {
		return _DONATED_AMOUNT;
	}

	public void setDONATED_AMOUNT(float DONATED_AMOUNT) {
		_DONATED_AMOUNT = DONATED_AMOUNT;
	}

	public long getDONOR_USER_ID() {
		return _DONOR_USER_ID;
	}

	public void setDONOR_USER_ID(long DONOR_USER_ID) {
		_DONOR_USER_ID = DONOR_USER_ID;
	}

	public int getDONOR_STATUS() {
		return _DONOR_STATUS;
	}

	public void setDONOR_STATUS(int DONOR_STATUS) {
		_DONOR_STATUS = DONOR_STATUS;
	}

	public String getCOMMENT() {
		return _COMMENT;
	}

	public void setCOMMENT(String COMMENT) {
		_COMMENT = COMMENT;
	}

	public Date getDONATED_DATE() {
		return _DONATED_DATE;
	}

	public void setDONATED_DATE(Date DONATED_DATE) {
		_DONATED_DATE = DONATED_DATE;
	}

	private String _uuid;
	private long _PROJECT_FUND_ID;
	private long _DONOR_ID;
	private long _PROJECT_ID;
	private String _CURRENCY;
	private float _DONATED_AMOUNT;
	private long _DONOR_USER_ID;
	private int _DONOR_STATUS;
	private String _COMMENT;
	private Date _DONATED_DATE;
}