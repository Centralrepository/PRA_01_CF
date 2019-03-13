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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link DonorRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DonorRegistration
 * @generated
 */
@ProviderType
public class DonorRegistrationWrapper implements DonorRegistration,
	ModelWrapper<DonorRegistration> {
	public DonorRegistrationWrapper(DonorRegistration donorRegistration) {
		_donorRegistration = donorRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return DonorRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return DonorRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("DONOR_ID", getDONOR_ID());
		attributes.put("NAME", getNAME());
		attributes.put("ADDRESS", getADDRESS());
		attributes.put("CITY", getCITY());
		attributes.put("STATE", getSTATE());
		attributes.put("COUNTRY", getCOUNTRY());
		attributes.put("PINCODE", getPINCODE());
		attributes.put("MAIL_ADDRESS", getMAIL_ADDRESS());
		attributes.put("MOBILE_NO", getMOBILE_NO());
		attributes.put("OTP", getOTP());
		attributes.put("MAIL_VERIFICATION", getMAIL_VERIFICATION());
		attributes.put("SMS_VERIFICATION", getSMS_VERIFICATION());
		attributes.put("CREATION_DATE_TIME", getCREATION_DATE_TIME());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long DONOR_ID = (Long)attributes.get("DONOR_ID");

		if (DONOR_ID != null) {
			setDONOR_ID(DONOR_ID);
		}

		String NAME = (String)attributes.get("NAME");

		if (NAME != null) {
			setNAME(NAME);
		}

		String ADDRESS = (String)attributes.get("ADDRESS");

		if (ADDRESS != null) {
			setADDRESS(ADDRESS);
		}

		String CITY = (String)attributes.get("CITY");

		if (CITY != null) {
			setCITY(CITY);
		}

		String STATE = (String)attributes.get("STATE");

		if (STATE != null) {
			setSTATE(STATE);
		}

		String COUNTRY = (String)attributes.get("COUNTRY");

		if (COUNTRY != null) {
			setCOUNTRY(COUNTRY);
		}

		String PINCODE = (String)attributes.get("PINCODE");

		if (PINCODE != null) {
			setPINCODE(PINCODE);
		}

		String MAIL_ADDRESS = (String)attributes.get("MAIL_ADDRESS");

		if (MAIL_ADDRESS != null) {
			setMAIL_ADDRESS(MAIL_ADDRESS);
		}

		Long MOBILE_NO = (Long)attributes.get("MOBILE_NO");

		if (MOBILE_NO != null) {
			setMOBILE_NO(MOBILE_NO);
		}

		Integer OTP = (Integer)attributes.get("OTP");

		if (OTP != null) {
			setOTP(OTP);
		}

		Integer MAIL_VERIFICATION = (Integer)attributes.get("MAIL_VERIFICATION");

		if (MAIL_VERIFICATION != null) {
			setMAIL_VERIFICATION(MAIL_VERIFICATION);
		}

		Integer SMS_VERIFICATION = (Integer)attributes.get("SMS_VERIFICATION");

		if (SMS_VERIFICATION != null) {
			setSMS_VERIFICATION(SMS_VERIFICATION);
		}

		Date CREATION_DATE_TIME = (Date)attributes.get("CREATION_DATE_TIME");

		if (CREATION_DATE_TIME != null) {
			setCREATION_DATE_TIME(CREATION_DATE_TIME);
		}
	}

	@Override
	public Object clone() {
		return new DonorRegistrationWrapper((DonorRegistration)_donorRegistration.clone());
	}

	@Override
	public int compareTo(DonorRegistration donorRegistration) {
		return _donorRegistration.compareTo(donorRegistration);
	}

	/**
	* Returns the address of this donor registration.
	*
	* @return the address of this donor registration
	*/
	@Override
	public String getADDRESS() {
		return _donorRegistration.getADDRESS();
	}

	/**
	* Returns the city of this donor registration.
	*
	* @return the city of this donor registration
	*/
	@Override
	public String getCITY() {
		return _donorRegistration.getCITY();
	}

	/**
	* Returns the country of this donor registration.
	*
	* @return the country of this donor registration
	*/
	@Override
	public String getCOUNTRY() {
		return _donorRegistration.getCOUNTRY();
	}

	/**
	* Returns the creation_date_time of this donor registration.
	*
	* @return the creation_date_time of this donor registration
	*/
	@Override
	public Date getCREATION_DATE_TIME() {
		return _donorRegistration.getCREATION_DATE_TIME();
	}

	/**
	* Returns the donor_id of this donor registration.
	*
	* @return the donor_id of this donor registration
	*/
	@Override
	public long getDONOR_ID() {
		return _donorRegistration.getDONOR_ID();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _donorRegistration.getExpandoBridge();
	}

	/**
	* Returns the mail_address of this donor registration.
	*
	* @return the mail_address of this donor registration
	*/
	@Override
	public String getMAIL_ADDRESS() {
		return _donorRegistration.getMAIL_ADDRESS();
	}

	/**
	* Returns the mail_verification of this donor registration.
	*
	* @return the mail_verification of this donor registration
	*/
	@Override
	public int getMAIL_VERIFICATION() {
		return _donorRegistration.getMAIL_VERIFICATION();
	}

	/**
	* Returns the mobile_no of this donor registration.
	*
	* @return the mobile_no of this donor registration
	*/
	@Override
	public long getMOBILE_NO() {
		return _donorRegistration.getMOBILE_NO();
	}

	/**
	* Returns the name of this donor registration.
	*
	* @return the name of this donor registration
	*/
	@Override
	public String getNAME() {
		return _donorRegistration.getNAME();
	}

	/**
	* Returns the otp of this donor registration.
	*
	* @return the otp of this donor registration
	*/
	@Override
	public int getOTP() {
		return _donorRegistration.getOTP();
	}

	/**
	* Returns the pincode of this donor registration.
	*
	* @return the pincode of this donor registration
	*/
	@Override
	public String getPINCODE() {
		return _donorRegistration.getPINCODE();
	}

	/**
	* Returns the primary key of this donor registration.
	*
	* @return the primary key of this donor registration
	*/
	@Override
	public long getPrimaryKey() {
		return _donorRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _donorRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the sms_verification of this donor registration.
	*
	* @return the sms_verification of this donor registration
	*/
	@Override
	public int getSMS_VERIFICATION() {
		return _donorRegistration.getSMS_VERIFICATION();
	}

	/**
	* Returns the state of this donor registration.
	*
	* @return the state of this donor registration
	*/
	@Override
	public String getSTATE() {
		return _donorRegistration.getSTATE();
	}

	/**
	* Returns the uuid of this donor registration.
	*
	* @return the uuid of this donor registration
	*/
	@Override
	public String getUuid() {
		return _donorRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _donorRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _donorRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _donorRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _donorRegistration.isNew();
	}

	@Override
	public void persist() {
		_donorRegistration.persist();
	}

	/**
	* Sets the address of this donor registration.
	*
	* @param ADDRESS the address of this donor registration
	*/
	@Override
	public void setADDRESS(String ADDRESS) {
		_donorRegistration.setADDRESS(ADDRESS);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_donorRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this donor registration.
	*
	* @param CITY the city of this donor registration
	*/
	@Override
	public void setCITY(String CITY) {
		_donorRegistration.setCITY(CITY);
	}

	/**
	* Sets the country of this donor registration.
	*
	* @param COUNTRY the country of this donor registration
	*/
	@Override
	public void setCOUNTRY(String COUNTRY) {
		_donorRegistration.setCOUNTRY(COUNTRY);
	}

	/**
	* Sets the creation_date_time of this donor registration.
	*
	* @param CREATION_DATE_TIME the creation_date_time of this donor registration
	*/
	@Override
	public void setCREATION_DATE_TIME(Date CREATION_DATE_TIME) {
		_donorRegistration.setCREATION_DATE_TIME(CREATION_DATE_TIME);
	}

	/**
	* Sets the donor_id of this donor registration.
	*
	* @param DONOR_ID the donor_id of this donor registration
	*/
	@Override
	public void setDONOR_ID(long DONOR_ID) {
		_donorRegistration.setDONOR_ID(DONOR_ID);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_donorRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_donorRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_donorRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the mail_address of this donor registration.
	*
	* @param MAIL_ADDRESS the mail_address of this donor registration
	*/
	@Override
	public void setMAIL_ADDRESS(String MAIL_ADDRESS) {
		_donorRegistration.setMAIL_ADDRESS(MAIL_ADDRESS);
	}

	/**
	* Sets the mail_verification of this donor registration.
	*
	* @param MAIL_VERIFICATION the mail_verification of this donor registration
	*/
	@Override
	public void setMAIL_VERIFICATION(int MAIL_VERIFICATION) {
		_donorRegistration.setMAIL_VERIFICATION(MAIL_VERIFICATION);
	}

	/**
	* Sets the mobile_no of this donor registration.
	*
	* @param MOBILE_NO the mobile_no of this donor registration
	*/
	@Override
	public void setMOBILE_NO(long MOBILE_NO) {
		_donorRegistration.setMOBILE_NO(MOBILE_NO);
	}

	/**
	* Sets the name of this donor registration.
	*
	* @param NAME the name of this donor registration
	*/
	@Override
	public void setNAME(String NAME) {
		_donorRegistration.setNAME(NAME);
	}

	@Override
	public void setNew(boolean n) {
		_donorRegistration.setNew(n);
	}

	/**
	* Sets the otp of this donor registration.
	*
	* @param OTP the otp of this donor registration
	*/
	@Override
	public void setOTP(int OTP) {
		_donorRegistration.setOTP(OTP);
	}

	/**
	* Sets the pincode of this donor registration.
	*
	* @param PINCODE the pincode of this donor registration
	*/
	@Override
	public void setPINCODE(String PINCODE) {
		_donorRegistration.setPINCODE(PINCODE);
	}

	/**
	* Sets the primary key of this donor registration.
	*
	* @param primaryKey the primary key of this donor registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_donorRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_donorRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sms_verification of this donor registration.
	*
	* @param SMS_VERIFICATION the sms_verification of this donor registration
	*/
	@Override
	public void setSMS_VERIFICATION(int SMS_VERIFICATION) {
		_donorRegistration.setSMS_VERIFICATION(SMS_VERIFICATION);
	}

	/**
	* Sets the state of this donor registration.
	*
	* @param STATE the state of this donor registration
	*/
	@Override
	public void setSTATE(String STATE) {
		_donorRegistration.setSTATE(STATE);
	}

	/**
	* Sets the uuid of this donor registration.
	*
	* @param uuid the uuid of this donor registration
	*/
	@Override
	public void setUuid(String uuid) {
		_donorRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DonorRegistration> toCacheModel() {
		return _donorRegistration.toCacheModel();
	}

	@Override
	public DonorRegistration toEscapedModel() {
		return new DonorRegistrationWrapper(_donorRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _donorRegistration.toString();
	}

	@Override
	public DonorRegistration toUnescapedModel() {
		return new DonorRegistrationWrapper(_donorRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _donorRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DonorRegistrationWrapper)) {
			return false;
		}

		DonorRegistrationWrapper donorRegistrationWrapper = (DonorRegistrationWrapper)obj;

		if (Objects.equals(_donorRegistration,
					donorRegistrationWrapper._donorRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public DonorRegistration getWrappedModel() {
		return _donorRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _donorRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _donorRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_donorRegistration.resetOriginalValues();
	}

	private final DonorRegistration _donorRegistration;
}