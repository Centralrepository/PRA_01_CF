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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.DonorRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.DonorRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class DonorRegistrationSoap implements Serializable {
	public static DonorRegistrationSoap toSoapModel(DonorRegistration model) {
		DonorRegistrationSoap soapModel = new DonorRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDONOR_ID(model.getDONOR_ID());
		soapModel.setNAME(model.getNAME());
		soapModel.setADDRESS(model.getADDRESS());
		soapModel.setCITY(model.getCITY());
		soapModel.setSTATE(model.getSTATE());
		soapModel.setCOUNTRY(model.getCOUNTRY());
		soapModel.setPINCODE(model.getPINCODE());
		soapModel.setMAIL_ADDRESS(model.getMAIL_ADDRESS());
		soapModel.setMOBILE_NO(model.getMOBILE_NO());
		soapModel.setOTP(model.getOTP());
		soapModel.setMAIL_VERIFICATION(model.getMAIL_VERIFICATION());
		soapModel.setSMS_VERIFICATION(model.getSMS_VERIFICATION());
		soapModel.setCREATION_DATE_TIME(model.getCREATION_DATE_TIME());

		return soapModel;
	}

	public static DonorRegistrationSoap[] toSoapModels(
		DonorRegistration[] models) {
		DonorRegistrationSoap[] soapModels = new DonorRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DonorRegistrationSoap[][] toSoapModels(
		DonorRegistration[][] models) {
		DonorRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DonorRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DonorRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DonorRegistrationSoap[] toSoapModels(
		List<DonorRegistration> models) {
		List<DonorRegistrationSoap> soapModels = new ArrayList<DonorRegistrationSoap>(models.size());

		for (DonorRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DonorRegistrationSoap[soapModels.size()]);
	}

	public DonorRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _DONOR_ID;
	}

	public void setPrimaryKey(long pk) {
		setDONOR_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDONOR_ID() {
		return _DONOR_ID;
	}

	public void setDONOR_ID(long DONOR_ID) {
		_DONOR_ID = DONOR_ID;
	}

	public String getNAME() {
		return _NAME;
	}

	public void setNAME(String NAME) {
		_NAME = NAME;
	}

	public String getADDRESS() {
		return _ADDRESS;
	}

	public void setADDRESS(String ADDRESS) {
		_ADDRESS = ADDRESS;
	}

	public String getCITY() {
		return _CITY;
	}

	public void setCITY(String CITY) {
		_CITY = CITY;
	}

	public String getSTATE() {
		return _STATE;
	}

	public void setSTATE(String STATE) {
		_STATE = STATE;
	}

	public String getCOUNTRY() {
		return _COUNTRY;
	}

	public void setCOUNTRY(String COUNTRY) {
		_COUNTRY = COUNTRY;
	}

	public String getPINCODE() {
		return _PINCODE;
	}

	public void setPINCODE(String PINCODE) {
		_PINCODE = PINCODE;
	}

	public String getMAIL_ADDRESS() {
		return _MAIL_ADDRESS;
	}

	public void setMAIL_ADDRESS(String MAIL_ADDRESS) {
		_MAIL_ADDRESS = MAIL_ADDRESS;
	}

	public long getMOBILE_NO() {
		return _MOBILE_NO;
	}

	public void setMOBILE_NO(long MOBILE_NO) {
		_MOBILE_NO = MOBILE_NO;
	}

	public int getOTP() {
		return _OTP;
	}

	public void setOTP(int OTP) {
		_OTP = OTP;
	}

	public int getMAIL_VERIFICATION() {
		return _MAIL_VERIFICATION;
	}

	public void setMAIL_VERIFICATION(int MAIL_VERIFICATION) {
		_MAIL_VERIFICATION = MAIL_VERIFICATION;
	}

	public int getSMS_VERIFICATION() {
		return _SMS_VERIFICATION;
	}

	public void setSMS_VERIFICATION(int SMS_VERIFICATION) {
		_SMS_VERIFICATION = SMS_VERIFICATION;
	}

	public Date getCREATION_DATE_TIME() {
		return _CREATION_DATE_TIME;
	}

	public void setCREATION_DATE_TIME(Date CREATION_DATE_TIME) {
		_CREATION_DATE_TIME = CREATION_DATE_TIME;
	}

	private String _uuid;
	private long _DONOR_ID;
	private String _NAME;
	private String _ADDRESS;
	private String _CITY;
	private String _STATE;
	private String _COUNTRY;
	private String _PINCODE;
	private String _MAIL_ADDRESS;
	private long _MOBILE_NO;
	private int _OTP;
	private int _MAIL_VERIFICATION;
	private int _SMS_VERIFICATION;
	private Date _CREATION_DATE_TIME;
}