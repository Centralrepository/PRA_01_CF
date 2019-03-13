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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.BenificiaryRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.BenificiaryRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class BenificiaryRegistrationSoap implements Serializable {
	public static BenificiaryRegistrationSoap toSoapModel(
		BenificiaryRegistration model) {
		BenificiaryRegistrationSoap soapModel = new BenificiaryRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBENIFICIARY_ID(model.getBENIFICIARY_ID());
		soapModel.setBENIFICIARY_CATEGORY(model.getBENIFICIARY_CATEGORY());
		soapModel.setBENIFICIARY_TYPE(model.getBENIFICIARY_TYPE());
		soapModel.setBENIFICIARY_NAME(model.getBENIFICIARY_NAME());
		soapModel.setAGE(model.getAGE());
		soapModel.setGENDER(model.getGENDER());
		soapModel.setLOCATION(model.getLOCATION());
		soapModel.setRELATIONSHIP(model.getRELATIONSHIP());
		soapModel.setRELATIONSHIP_DETAILS(model.getRELATIONSHIP_DETAILS());
		soapModel.setMEMBERS_NO(model.getMEMBERS_NO());
		soapModel.setCAUSE_DETAILS(model.getCAUSE_DETAILS());
		soapModel.setADDRESS_LINE1(model.getADDRESS_LINE1());
		soapModel.setADDRESS_LINE2(model.getADDRESS_LINE2());
		soapModel.setCITY(model.getCITY());
		soapModel.setSTATE(model.getSTATE());
		soapModel.setPINCODE(model.getPINCODE());
		soapModel.setCOUNTRY(model.getCOUNTRY());
		soapModel.setCONTACT_NAME(model.getCONTACT_NAME());
		soapModel.setCONTACT_NO(model.getCONTACT_NO());
		soapModel.setALTERNATE_CONTACT_NO(model.getALTERNATE_CONTACT_NO());
		soapModel.setEMERGENCY_CONTACT_DETAILS(model.getEMERGENCY_CONTACT_DETAILS());
		soapModel.setIMAGE_TYPE(model.getIMAGE_TYPE());
		soapModel.setIMAGE(model.getIMAGE());

		return soapModel;
	}

	public static BenificiaryRegistrationSoap[] toSoapModels(
		BenificiaryRegistration[] models) {
		BenificiaryRegistrationSoap[] soapModels = new BenificiaryRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BenificiaryRegistrationSoap[][] toSoapModels(
		BenificiaryRegistration[][] models) {
		BenificiaryRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BenificiaryRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BenificiaryRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BenificiaryRegistrationSoap[] toSoapModels(
		List<BenificiaryRegistration> models) {
		List<BenificiaryRegistrationSoap> soapModels = new ArrayList<BenificiaryRegistrationSoap>(models.size());

		for (BenificiaryRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BenificiaryRegistrationSoap[soapModels.size()]);
	}

	public BenificiaryRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _BENIFICIARY_ID;
	}

	public void setPrimaryKey(long pk) {
		setBENIFICIARY_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBENIFICIARY_ID() {
		return _BENIFICIARY_ID;
	}

	public void setBENIFICIARY_ID(long BENIFICIARY_ID) {
		_BENIFICIARY_ID = BENIFICIARY_ID;
	}

	public String getBENIFICIARY_CATEGORY() {
		return _BENIFICIARY_CATEGORY;
	}

	public void setBENIFICIARY_CATEGORY(String BENIFICIARY_CATEGORY) {
		_BENIFICIARY_CATEGORY = BENIFICIARY_CATEGORY;
	}

	public String getBENIFICIARY_TYPE() {
		return _BENIFICIARY_TYPE;
	}

	public void setBENIFICIARY_TYPE(String BENIFICIARY_TYPE) {
		_BENIFICIARY_TYPE = BENIFICIARY_TYPE;
	}

	public String getBENIFICIARY_NAME() {
		return _BENIFICIARY_NAME;
	}

	public void setBENIFICIARY_NAME(String BENIFICIARY_NAME) {
		_BENIFICIARY_NAME = BENIFICIARY_NAME;
	}

	public int getAGE() {
		return _AGE;
	}

	public void setAGE(int AGE) {
		_AGE = AGE;
	}

	public String getGENDER() {
		return _GENDER;
	}

	public void setGENDER(String GENDER) {
		_GENDER = GENDER;
	}

	public String getLOCATION() {
		return _LOCATION;
	}

	public void setLOCATION(String LOCATION) {
		_LOCATION = LOCATION;
	}

	public String getRELATIONSHIP() {
		return _RELATIONSHIP;
	}

	public void setRELATIONSHIP(String RELATIONSHIP) {
		_RELATIONSHIP = RELATIONSHIP;
	}

	public String getRELATIONSHIP_DETAILS() {
		return _RELATIONSHIP_DETAILS;
	}

	public void setRELATIONSHIP_DETAILS(String RELATIONSHIP_DETAILS) {
		_RELATIONSHIP_DETAILS = RELATIONSHIP_DETAILS;
	}

	public int getMEMBERS_NO() {
		return _MEMBERS_NO;
	}

	public void setMEMBERS_NO(int MEMBERS_NO) {
		_MEMBERS_NO = MEMBERS_NO;
	}

	public String getCAUSE_DETAILS() {
		return _CAUSE_DETAILS;
	}

	public void setCAUSE_DETAILS(String CAUSE_DETAILS) {
		_CAUSE_DETAILS = CAUSE_DETAILS;
	}

	public String getADDRESS_LINE1() {
		return _ADDRESS_LINE1;
	}

	public void setADDRESS_LINE1(String ADDRESS_LINE1) {
		_ADDRESS_LINE1 = ADDRESS_LINE1;
	}

	public String getADDRESS_LINE2() {
		return _ADDRESS_LINE2;
	}

	public void setADDRESS_LINE2(String ADDRESS_LINE2) {
		_ADDRESS_LINE2 = ADDRESS_LINE2;
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

	public int getPINCODE() {
		return _PINCODE;
	}

	public void setPINCODE(int PINCODE) {
		_PINCODE = PINCODE;
	}

	public String getCOUNTRY() {
		return _COUNTRY;
	}

	public void setCOUNTRY(String COUNTRY) {
		_COUNTRY = COUNTRY;
	}

	public String getCONTACT_NAME() {
		return _CONTACT_NAME;
	}

	public void setCONTACT_NAME(String CONTACT_NAME) {
		_CONTACT_NAME = CONTACT_NAME;
	}

	public long getCONTACT_NO() {
		return _CONTACT_NO;
	}

	public void setCONTACT_NO(long CONTACT_NO) {
		_CONTACT_NO = CONTACT_NO;
	}

	public long getALTERNATE_CONTACT_NO() {
		return _ALTERNATE_CONTACT_NO;
	}

	public void setALTERNATE_CONTACT_NO(long ALTERNATE_CONTACT_NO) {
		_ALTERNATE_CONTACT_NO = ALTERNATE_CONTACT_NO;
	}

	public String getEMERGENCY_CONTACT_DETAILS() {
		return _EMERGENCY_CONTACT_DETAILS;
	}

	public void setEMERGENCY_CONTACT_DETAILS(String EMERGENCY_CONTACT_DETAILS) {
		_EMERGENCY_CONTACT_DETAILS = EMERGENCY_CONTACT_DETAILS;
	}

	public String getIMAGE_TYPE() {
		return _IMAGE_TYPE;
	}

	public void setIMAGE_TYPE(String IMAGE_TYPE) {
		_IMAGE_TYPE = IMAGE_TYPE;
	}

	public Blob getIMAGE() {
		return _IMAGE;
	}

	public void setIMAGE(Blob IMAGE) {
		_IMAGE = IMAGE;
	}

	private String _uuid;
	private long _BENIFICIARY_ID;
	private String _BENIFICIARY_CATEGORY;
	private String _BENIFICIARY_TYPE;
	private String _BENIFICIARY_NAME;
	private int _AGE;
	private String _GENDER;
	private String _LOCATION;
	private String _RELATIONSHIP;
	private String _RELATIONSHIP_DETAILS;
	private int _MEMBERS_NO;
	private String _CAUSE_DETAILS;
	private String _ADDRESS_LINE1;
	private String _ADDRESS_LINE2;
	private String _CITY;
	private String _STATE;
	private int _PINCODE;
	private String _COUNTRY;
	private String _CONTACT_NAME;
	private long _CONTACT_NO;
	private long _ALTERNATE_CONTACT_NO;
	private String _EMERGENCY_CONTACT_DETAILS;
	private String _IMAGE_TYPE;
	private Blob _IMAGE;
}