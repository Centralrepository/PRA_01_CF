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
 * This class is a wrapper for {@link UserOTPRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOTPRegistration
 * @generated
 */
@ProviderType
public class UserOTPRegistrationWrapper implements UserOTPRegistration,
	ModelWrapper<UserOTPRegistration> {
	public UserOTPRegistrationWrapper(UserOTPRegistration userOTPRegistration) {
		_userOTPRegistration = userOTPRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return UserOTPRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return UserOTPRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("USER_OTP_ID", getUSER_OTP_ID());
		attributes.put("MOBILE_NO", getMOBILE_NO());
		attributes.put("MAIL_ADDRESS", getMAIL_ADDRESS());
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

		Long USER_OTP_ID = (Long)attributes.get("USER_OTP_ID");

		if (USER_OTP_ID != null) {
			setUSER_OTP_ID(USER_OTP_ID);
		}

		Long MOBILE_NO = (Long)attributes.get("MOBILE_NO");

		if (MOBILE_NO != null) {
			setMOBILE_NO(MOBILE_NO);
		}

		String MAIL_ADDRESS = (String)attributes.get("MAIL_ADDRESS");

		if (MAIL_ADDRESS != null) {
			setMAIL_ADDRESS(MAIL_ADDRESS);
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
		return new UserOTPRegistrationWrapper((UserOTPRegistration)_userOTPRegistration.clone());
	}

	@Override
	public int compareTo(UserOTPRegistration userOTPRegistration) {
		return _userOTPRegistration.compareTo(userOTPRegistration);
	}

	/**
	* Returns the creation_date_time of this user otp registration.
	*
	* @return the creation_date_time of this user otp registration
	*/
	@Override
	public Date getCREATION_DATE_TIME() {
		return _userOTPRegistration.getCREATION_DATE_TIME();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userOTPRegistration.getExpandoBridge();
	}

	/**
	* Returns the mail_address of this user otp registration.
	*
	* @return the mail_address of this user otp registration
	*/
	@Override
	public String getMAIL_ADDRESS() {
		return _userOTPRegistration.getMAIL_ADDRESS();
	}

	/**
	* Returns the mail_verification of this user otp registration.
	*
	* @return the mail_verification of this user otp registration
	*/
	@Override
	public int getMAIL_VERIFICATION() {
		return _userOTPRegistration.getMAIL_VERIFICATION();
	}

	/**
	* Returns the mobile_no of this user otp registration.
	*
	* @return the mobile_no of this user otp registration
	*/
	@Override
	public long getMOBILE_NO() {
		return _userOTPRegistration.getMOBILE_NO();
	}

	/**
	* Returns the otp of this user otp registration.
	*
	* @return the otp of this user otp registration
	*/
	@Override
	public int getOTP() {
		return _userOTPRegistration.getOTP();
	}

	/**
	* Returns the primary key of this user otp registration.
	*
	* @return the primary key of this user otp registration
	*/
	@Override
	public long getPrimaryKey() {
		return _userOTPRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userOTPRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the sms_verification of this user otp registration.
	*
	* @return the sms_verification of this user otp registration
	*/
	@Override
	public int getSMS_VERIFICATION() {
		return _userOTPRegistration.getSMS_VERIFICATION();
	}

	/**
	* Returns the user_otp_id of this user otp registration.
	*
	* @return the user_otp_id of this user otp registration
	*/
	@Override
	public long getUSER_OTP_ID() {
		return _userOTPRegistration.getUSER_OTP_ID();
	}

	/**
	* Returns the uuid of this user otp registration.
	*
	* @return the uuid of this user otp registration
	*/
	@Override
	public String getUuid() {
		return _userOTPRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _userOTPRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _userOTPRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userOTPRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userOTPRegistration.isNew();
	}

	@Override
	public void persist() {
		_userOTPRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userOTPRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the creation_date_time of this user otp registration.
	*
	* @param CREATION_DATE_TIME the creation_date_time of this user otp registration
	*/
	@Override
	public void setCREATION_DATE_TIME(Date CREATION_DATE_TIME) {
		_userOTPRegistration.setCREATION_DATE_TIME(CREATION_DATE_TIME);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userOTPRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userOTPRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userOTPRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the mail_address of this user otp registration.
	*
	* @param MAIL_ADDRESS the mail_address of this user otp registration
	*/
	@Override
	public void setMAIL_ADDRESS(String MAIL_ADDRESS) {
		_userOTPRegistration.setMAIL_ADDRESS(MAIL_ADDRESS);
	}

	/**
	* Sets the mail_verification of this user otp registration.
	*
	* @param MAIL_VERIFICATION the mail_verification of this user otp registration
	*/
	@Override
	public void setMAIL_VERIFICATION(int MAIL_VERIFICATION) {
		_userOTPRegistration.setMAIL_VERIFICATION(MAIL_VERIFICATION);
	}

	/**
	* Sets the mobile_no of this user otp registration.
	*
	* @param MOBILE_NO the mobile_no of this user otp registration
	*/
	@Override
	public void setMOBILE_NO(long MOBILE_NO) {
		_userOTPRegistration.setMOBILE_NO(MOBILE_NO);
	}

	@Override
	public void setNew(boolean n) {
		_userOTPRegistration.setNew(n);
	}

	/**
	* Sets the otp of this user otp registration.
	*
	* @param OTP the otp of this user otp registration
	*/
	@Override
	public void setOTP(int OTP) {
		_userOTPRegistration.setOTP(OTP);
	}

	/**
	* Sets the primary key of this user otp registration.
	*
	* @param primaryKey the primary key of this user otp registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userOTPRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userOTPRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sms_verification of this user otp registration.
	*
	* @param SMS_VERIFICATION the sms_verification of this user otp registration
	*/
	@Override
	public void setSMS_VERIFICATION(int SMS_VERIFICATION) {
		_userOTPRegistration.setSMS_VERIFICATION(SMS_VERIFICATION);
	}

	/**
	* Sets the user_otp_id of this user otp registration.
	*
	* @param USER_OTP_ID the user_otp_id of this user otp registration
	*/
	@Override
	public void setUSER_OTP_ID(long USER_OTP_ID) {
		_userOTPRegistration.setUSER_OTP_ID(USER_OTP_ID);
	}

	/**
	* Sets the uuid of this user otp registration.
	*
	* @param uuid the uuid of this user otp registration
	*/
	@Override
	public void setUuid(String uuid) {
		_userOTPRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserOTPRegistration> toCacheModel() {
		return _userOTPRegistration.toCacheModel();
	}

	@Override
	public UserOTPRegistration toEscapedModel() {
		return new UserOTPRegistrationWrapper(_userOTPRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _userOTPRegistration.toString();
	}

	@Override
	public UserOTPRegistration toUnescapedModel() {
		return new UserOTPRegistrationWrapper(_userOTPRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _userOTPRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserOTPRegistrationWrapper)) {
			return false;
		}

		UserOTPRegistrationWrapper userOTPRegistrationWrapper = (UserOTPRegistrationWrapper)obj;

		if (Objects.equals(_userOTPRegistration,
					userOTPRegistrationWrapper._userOTPRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public UserOTPRegistration getWrappedModel() {
		return _userOTPRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userOTPRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userOTPRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userOTPRegistration.resetOriginalValues();
	}

	private final UserOTPRegistration _userOTPRegistration;
}