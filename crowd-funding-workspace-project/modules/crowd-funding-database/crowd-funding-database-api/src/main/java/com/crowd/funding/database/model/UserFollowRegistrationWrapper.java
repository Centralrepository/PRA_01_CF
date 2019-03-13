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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link UserFollowRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFollowRegistration
 * @generated
 */
@ProviderType
public class UserFollowRegistrationWrapper implements UserFollowRegistration,
	ModelWrapper<UserFollowRegistration> {
	public UserFollowRegistrationWrapper(
		UserFollowRegistration userFollowRegistration) {
		_userFollowRegistration = userFollowRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return UserFollowRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return UserFollowRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("USER_FOLLOW_ID", getUSER_FOLLOW_ID());
		attributes.put("USER_ID", getUSER_ID());
		attributes.put("FOLLOWER_USER_ID", getFOLLOWER_USER_ID());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long USER_FOLLOW_ID = (Long)attributes.get("USER_FOLLOW_ID");

		if (USER_FOLLOW_ID != null) {
			setUSER_FOLLOW_ID(USER_FOLLOW_ID);
		}

		Long USER_ID = (Long)attributes.get("USER_ID");

		if (USER_ID != null) {
			setUSER_ID(USER_ID);
		}

		Long FOLLOWER_USER_ID = (Long)attributes.get("FOLLOWER_USER_ID");

		if (FOLLOWER_USER_ID != null) {
			setFOLLOWER_USER_ID(FOLLOWER_USER_ID);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new UserFollowRegistrationWrapper((UserFollowRegistration)_userFollowRegistration.clone());
	}

	@Override
	public int compareTo(UserFollowRegistration userFollowRegistration) {
		return _userFollowRegistration.compareTo(userFollowRegistration);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userFollowRegistration.getExpandoBridge();
	}

	/**
	* Returns the follower_user_id of this user follow registration.
	*
	* @return the follower_user_id of this user follow registration
	*/
	@Override
	public long getFOLLOWER_USER_ID() {
		return _userFollowRegistration.getFOLLOWER_USER_ID();
	}

	/**
	* Returns the primary key of this user follow registration.
	*
	* @return the primary key of this user follow registration
	*/
	@Override
	public long getPrimaryKey() {
		return _userFollowRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userFollowRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this user follow registration.
	*
	* @return the status of this user follow registration
	*/
	@Override
	public int getSTATUS() {
		return _userFollowRegistration.getSTATUS();
	}

	/**
	* Returns the user_follow_id of this user follow registration.
	*
	* @return the user_follow_id of this user follow registration
	*/
	@Override
	public long getUSER_FOLLOW_ID() {
		return _userFollowRegistration.getUSER_FOLLOW_ID();
	}

	/**
	* Returns the user_id of this user follow registration.
	*
	* @return the user_id of this user follow registration
	*/
	@Override
	public long getUSER_ID() {
		return _userFollowRegistration.getUSER_ID();
	}

	/**
	* Returns the uuid of this user follow registration.
	*
	* @return the uuid of this user follow registration
	*/
	@Override
	public String getUuid() {
		return _userFollowRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _userFollowRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _userFollowRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userFollowRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userFollowRegistration.isNew();
	}

	@Override
	public void persist() {
		_userFollowRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userFollowRegistration.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userFollowRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userFollowRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userFollowRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the follower_user_id of this user follow registration.
	*
	* @param FOLLOWER_USER_ID the follower_user_id of this user follow registration
	*/
	@Override
	public void setFOLLOWER_USER_ID(long FOLLOWER_USER_ID) {
		_userFollowRegistration.setFOLLOWER_USER_ID(FOLLOWER_USER_ID);
	}

	@Override
	public void setNew(boolean n) {
		_userFollowRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this user follow registration.
	*
	* @param primaryKey the primary key of this user follow registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userFollowRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userFollowRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this user follow registration.
	*
	* @param STATUS the status of this user follow registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_userFollowRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the user_follow_id of this user follow registration.
	*
	* @param USER_FOLLOW_ID the user_follow_id of this user follow registration
	*/
	@Override
	public void setUSER_FOLLOW_ID(long USER_FOLLOW_ID) {
		_userFollowRegistration.setUSER_FOLLOW_ID(USER_FOLLOW_ID);
	}

	/**
	* Sets the user_id of this user follow registration.
	*
	* @param USER_ID the user_id of this user follow registration
	*/
	@Override
	public void setUSER_ID(long USER_ID) {
		_userFollowRegistration.setUSER_ID(USER_ID);
	}

	/**
	* Sets the uuid of this user follow registration.
	*
	* @param uuid the uuid of this user follow registration
	*/
	@Override
	public void setUuid(String uuid) {
		_userFollowRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserFollowRegistration> toCacheModel() {
		return _userFollowRegistration.toCacheModel();
	}

	@Override
	public UserFollowRegistration toEscapedModel() {
		return new UserFollowRegistrationWrapper(_userFollowRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _userFollowRegistration.toString();
	}

	@Override
	public UserFollowRegistration toUnescapedModel() {
		return new UserFollowRegistrationWrapper(_userFollowRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _userFollowRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserFollowRegistrationWrapper)) {
			return false;
		}

		UserFollowRegistrationWrapper userFollowRegistrationWrapper = (UserFollowRegistrationWrapper)obj;

		if (Objects.equals(_userFollowRegistration,
					userFollowRegistrationWrapper._userFollowRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public UserFollowRegistration getWrappedModel() {
		return _userFollowRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userFollowRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userFollowRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userFollowRegistration.resetOriginalValues();
	}

	private final UserFollowRegistration _userFollowRegistration;
}