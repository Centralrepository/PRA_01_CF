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
 * This class is a wrapper for {@link ProjectFollowerRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFollowerRegistration
 * @generated
 */
@ProviderType
public class ProjectFollowerRegistrationWrapper
	implements ProjectFollowerRegistration,
		ModelWrapper<ProjectFollowerRegistration> {
	public ProjectFollowerRegistrationWrapper(
		ProjectFollowerRegistration projectFollowerRegistration) {
		_projectFollowerRegistration = projectFollowerRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectFollowerRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectFollowerRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_FOLLOWER_ID", getPROJECT_FOLLOWER_ID());
		attributes.put("USER_ID", getUSER_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_FOLLOWER_ID = (Long)attributes.get("PROJECT_FOLLOWER_ID");

		if (PROJECT_FOLLOWER_ID != null) {
			setPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);
		}

		Long USER_ID = (Long)attributes.get("USER_ID");

		if (USER_ID != null) {
			setUSER_ID(USER_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new ProjectFollowerRegistrationWrapper((ProjectFollowerRegistration)_projectFollowerRegistration.clone());
	}

	@Override
	public int compareTo(
		ProjectFollowerRegistration projectFollowerRegistration) {
		return _projectFollowerRegistration.compareTo(projectFollowerRegistration);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectFollowerRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this project follower registration.
	*
	* @return the primary key of this project follower registration
	*/
	@Override
	public long getPrimaryKey() {
		return _projectFollowerRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectFollowerRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_follower_id of this project follower registration.
	*
	* @return the project_follower_id of this project follower registration
	*/
	@Override
	public long getPROJECT_FOLLOWER_ID() {
		return _projectFollowerRegistration.getPROJECT_FOLLOWER_ID();
	}

	/**
	* Returns the project_id of this project follower registration.
	*
	* @return the project_id of this project follower registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _projectFollowerRegistration.getPROJECT_ID();
	}

	/**
	* Returns the status of this project follower registration.
	*
	* @return the status of this project follower registration
	*/
	@Override
	public int getSTATUS() {
		return _projectFollowerRegistration.getSTATUS();
	}

	/**
	* Returns the user_id of this project follower registration.
	*
	* @return the user_id of this project follower registration
	*/
	@Override
	public long getUSER_ID() {
		return _projectFollowerRegistration.getUSER_ID();
	}

	/**
	* Returns the uuid of this project follower registration.
	*
	* @return the uuid of this project follower registration
	*/
	@Override
	public String getUuid() {
		return _projectFollowerRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _projectFollowerRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectFollowerRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectFollowerRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectFollowerRegistration.isNew();
	}

	@Override
	public void persist() {
		_projectFollowerRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectFollowerRegistration.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectFollowerRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectFollowerRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectFollowerRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_projectFollowerRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this project follower registration.
	*
	* @param primaryKey the primary key of this project follower registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectFollowerRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectFollowerRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_follower_id of this project follower registration.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id of this project follower registration
	*/
	@Override
	public void setPROJECT_FOLLOWER_ID(long PROJECT_FOLLOWER_ID) {
		_projectFollowerRegistration.setPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);
	}

	/**
	* Sets the project_id of this project follower registration.
	*
	* @param PROJECT_ID the project_id of this project follower registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_projectFollowerRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the status of this project follower registration.
	*
	* @param STATUS the status of this project follower registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_projectFollowerRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the user_id of this project follower registration.
	*
	* @param USER_ID the user_id of this project follower registration
	*/
	@Override
	public void setUSER_ID(long USER_ID) {
		_projectFollowerRegistration.setUSER_ID(USER_ID);
	}

	/**
	* Sets the uuid of this project follower registration.
	*
	* @param uuid the uuid of this project follower registration
	*/
	@Override
	public void setUuid(String uuid) {
		_projectFollowerRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectFollowerRegistration> toCacheModel() {
		return _projectFollowerRegistration.toCacheModel();
	}

	@Override
	public ProjectFollowerRegistration toEscapedModel() {
		return new ProjectFollowerRegistrationWrapper(_projectFollowerRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectFollowerRegistration.toString();
	}

	@Override
	public ProjectFollowerRegistration toUnescapedModel() {
		return new ProjectFollowerRegistrationWrapper(_projectFollowerRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectFollowerRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectFollowerRegistrationWrapper)) {
			return false;
		}

		ProjectFollowerRegistrationWrapper projectFollowerRegistrationWrapper = (ProjectFollowerRegistrationWrapper)obj;

		if (Objects.equals(_projectFollowerRegistration,
					projectFollowerRegistrationWrapper._projectFollowerRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectFollowerRegistration getWrappedModel() {
		return _projectFollowerRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectFollowerRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectFollowerRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectFollowerRegistration.resetOriginalValues();
	}

	private final ProjectFollowerRegistration _projectFollowerRegistration;
}