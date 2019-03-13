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
 * This class is a wrapper for {@link UserRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistration
 * @generated
 */
@ProviderType
public class UserRegistrationWrapper implements UserRegistration,
	ModelWrapper<UserRegistration> {
	public UserRegistrationWrapper(UserRegistration userRegistration) {
		_userRegistration = userRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return UserRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return UserRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("USER_ID", getUSER_ID());
		attributes.put("USER_OTP_ID", getUSER_OTP_ID());
		attributes.put("FULL_NAME", getFULL_NAME());
		attributes.put("PASSWORD", getPASSWORD());
		attributes.put("GENDER", getGENDER());
		attributes.put("CREATION_DATE", getCREATION_DATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long USER_ID = (Long)attributes.get("USER_ID");

		if (USER_ID != null) {
			setUSER_ID(USER_ID);
		}

		Long USER_OTP_ID = (Long)attributes.get("USER_OTP_ID");

		if (USER_OTP_ID != null) {
			setUSER_OTP_ID(USER_OTP_ID);
		}

		String FULL_NAME = (String)attributes.get("FULL_NAME");

		if (FULL_NAME != null) {
			setFULL_NAME(FULL_NAME);
		}

		String PASSWORD = (String)attributes.get("PASSWORD");

		if (PASSWORD != null) {
			setPASSWORD(PASSWORD);
		}

		String GENDER = (String)attributes.get("GENDER");

		if (GENDER != null) {
			setGENDER(GENDER);
		}

		Date CREATION_DATE = (Date)attributes.get("CREATION_DATE");

		if (CREATION_DATE != null) {
			setCREATION_DATE(CREATION_DATE);
		}
	}

	@Override
	public Object clone() {
		return new UserRegistrationWrapper((UserRegistration)_userRegistration.clone());
	}

	@Override
	public int compareTo(UserRegistration userRegistration) {
		return _userRegistration.compareTo(userRegistration);
	}

	/**
	* Returns the creation_date of this user registration.
	*
	* @return the creation_date of this user registration
	*/
	@Override
	public Date getCREATION_DATE() {
		return _userRegistration.getCREATION_DATE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userRegistration.getExpandoBridge();
	}

	/**
	* Returns the full_name of this user registration.
	*
	* @return the full_name of this user registration
	*/
	@Override
	public String getFULL_NAME() {
		return _userRegistration.getFULL_NAME();
	}

	/**
	* Returns the gender of this user registration.
	*
	* @return the gender of this user registration
	*/
	@Override
	public String getGENDER() {
		return _userRegistration.getGENDER();
	}

	/**
	* Returns the password of this user registration.
	*
	* @return the password of this user registration
	*/
	@Override
	public String getPASSWORD() {
		return _userRegistration.getPASSWORD();
	}

	/**
	* Returns the primary key of this user registration.
	*
	* @return the primary key of this user registration
	*/
	@Override
	public long getPrimaryKey() {
		return _userRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the user_id of this user registration.
	*
	* @return the user_id of this user registration
	*/
	@Override
	public long getUSER_ID() {
		return _userRegistration.getUSER_ID();
	}

	/**
	* Returns the user_otp_id of this user registration.
	*
	* @return the user_otp_id of this user registration
	*/
	@Override
	public long getUSER_OTP_ID() {
		return _userRegistration.getUSER_OTP_ID();
	}

	/**
	* Returns the uuid of this user registration.
	*
	* @return the uuid of this user registration
	*/
	@Override
	public String getUuid() {
		return _userRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _userRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _userRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userRegistration.isNew();
	}

	@Override
	public void persist() {
		_userRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the creation_date of this user registration.
	*
	* @param CREATION_DATE the creation_date of this user registration
	*/
	@Override
	public void setCREATION_DATE(Date CREATION_DATE) {
		_userRegistration.setCREATION_DATE(CREATION_DATE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the full_name of this user registration.
	*
	* @param FULL_NAME the full_name of this user registration
	*/
	@Override
	public void setFULL_NAME(String FULL_NAME) {
		_userRegistration.setFULL_NAME(FULL_NAME);
	}

	/**
	* Sets the gender of this user registration.
	*
	* @param GENDER the gender of this user registration
	*/
	@Override
	public void setGENDER(String GENDER) {
		_userRegistration.setGENDER(GENDER);
	}

	@Override
	public void setNew(boolean n) {
		_userRegistration.setNew(n);
	}

	/**
	* Sets the password of this user registration.
	*
	* @param PASSWORD the password of this user registration
	*/
	@Override
	public void setPASSWORD(String PASSWORD) {
		_userRegistration.setPASSWORD(PASSWORD);
	}

	/**
	* Sets the primary key of this user registration.
	*
	* @param primaryKey the primary key of this user registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user_id of this user registration.
	*
	* @param USER_ID the user_id of this user registration
	*/
	@Override
	public void setUSER_ID(long USER_ID) {
		_userRegistration.setUSER_ID(USER_ID);
	}

	/**
	* Sets the user_otp_id of this user registration.
	*
	* @param USER_OTP_ID the user_otp_id of this user registration
	*/
	@Override
	public void setUSER_OTP_ID(long USER_OTP_ID) {
		_userRegistration.setUSER_OTP_ID(USER_OTP_ID);
	}

	/**
	* Sets the uuid of this user registration.
	*
	* @param uuid the uuid of this user registration
	*/
	@Override
	public void setUuid(String uuid) {
		_userRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserRegistration> toCacheModel() {
		return _userRegistration.toCacheModel();
	}

	@Override
	public UserRegistration toEscapedModel() {
		return new UserRegistrationWrapper(_userRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _userRegistration.toString();
	}

	@Override
	public UserRegistration toUnescapedModel() {
		return new UserRegistrationWrapper(_userRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _userRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserRegistrationWrapper)) {
			return false;
		}

		UserRegistrationWrapper userRegistrationWrapper = (UserRegistrationWrapper)obj;

		if (Objects.equals(_userRegistration,
					userRegistrationWrapper._userRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public UserRegistration getWrappedModel() {
		return _userRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userRegistration.resetOriginalValues();
	}

	private final UserRegistration _userRegistration;
}