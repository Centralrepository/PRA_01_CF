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
 * This class is a wrapper for {@link ProjectPriorityRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPriorityRegistration
 * @generated
 */
@ProviderType
public class ProjectPriorityRegistrationWrapper
	implements ProjectPriorityRegistration,
		ModelWrapper<ProjectPriorityRegistration> {
	public ProjectPriorityRegistrationWrapper(
		ProjectPriorityRegistration projectPriorityRegistration) {
		_projectPriorityRegistration = projectPriorityRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectPriorityRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectPriorityRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_PRIORITY_ID", getPROJECT_PRIORITY_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("PRIORITY", getPRIORITY());
		attributes.put("PRIORITY_SEQUANCE", getPRIORITY_SEQUANCE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_PRIORITY_ID = (Long)attributes.get("PROJECT_PRIORITY_ID");

		if (PROJECT_PRIORITY_ID != null) {
			setPROJECT_PRIORITY_ID(PROJECT_PRIORITY_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		Integer PRIORITY = (Integer)attributes.get("PRIORITY");

		if (PRIORITY != null) {
			setPRIORITY(PRIORITY);
		}

		Integer PRIORITY_SEQUANCE = (Integer)attributes.get("PRIORITY_SEQUANCE");

		if (PRIORITY_SEQUANCE != null) {
			setPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);
		}
	}

	@Override
	public Object clone() {
		return new ProjectPriorityRegistrationWrapper((ProjectPriorityRegistration)_projectPriorityRegistration.clone());
	}

	@Override
	public int compareTo(
		ProjectPriorityRegistration projectPriorityRegistration) {
		return _projectPriorityRegistration.compareTo(projectPriorityRegistration);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectPriorityRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this project priority registration.
	*
	* @return the primary key of this project priority registration
	*/
	@Override
	public long getPrimaryKey() {
		return _projectPriorityRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectPriorityRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the priority of this project priority registration.
	*
	* @return the priority of this project priority registration
	*/
	@Override
	public int getPRIORITY() {
		return _projectPriorityRegistration.getPRIORITY();
	}

	/**
	* Returns the priority_sequance of this project priority registration.
	*
	* @return the priority_sequance of this project priority registration
	*/
	@Override
	public int getPRIORITY_SEQUANCE() {
		return _projectPriorityRegistration.getPRIORITY_SEQUANCE();
	}

	/**
	* Returns the project_id of this project priority registration.
	*
	* @return the project_id of this project priority registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _projectPriorityRegistration.getPROJECT_ID();
	}

	/**
	* Returns the project_priority_id of this project priority registration.
	*
	* @return the project_priority_id of this project priority registration
	*/
	@Override
	public long getPROJECT_PRIORITY_ID() {
		return _projectPriorityRegistration.getPROJECT_PRIORITY_ID();
	}

	/**
	* Returns the uuid of this project priority registration.
	*
	* @return the uuid of this project priority registration
	*/
	@Override
	public String getUuid() {
		return _projectPriorityRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _projectPriorityRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectPriorityRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectPriorityRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectPriorityRegistration.isNew();
	}

	@Override
	public void persist() {
		_projectPriorityRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectPriorityRegistration.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectPriorityRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectPriorityRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectPriorityRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_projectPriorityRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this project priority registration.
	*
	* @param primaryKey the primary key of this project priority registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectPriorityRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectPriorityRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the priority of this project priority registration.
	*
	* @param PRIORITY the priority of this project priority registration
	*/
	@Override
	public void setPRIORITY(int PRIORITY) {
		_projectPriorityRegistration.setPRIORITY(PRIORITY);
	}

	/**
	* Sets the priority_sequance of this project priority registration.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance of this project priority registration
	*/
	@Override
	public void setPRIORITY_SEQUANCE(int PRIORITY_SEQUANCE) {
		_projectPriorityRegistration.setPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);
	}

	/**
	* Sets the project_id of this project priority registration.
	*
	* @param PROJECT_ID the project_id of this project priority registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_projectPriorityRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the project_priority_id of this project priority registration.
	*
	* @param PROJECT_PRIORITY_ID the project_priority_id of this project priority registration
	*/
	@Override
	public void setPROJECT_PRIORITY_ID(long PROJECT_PRIORITY_ID) {
		_projectPriorityRegistration.setPROJECT_PRIORITY_ID(PROJECT_PRIORITY_ID);
	}

	/**
	* Sets the uuid of this project priority registration.
	*
	* @param uuid the uuid of this project priority registration
	*/
	@Override
	public void setUuid(String uuid) {
		_projectPriorityRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectPriorityRegistration> toCacheModel() {
		return _projectPriorityRegistration.toCacheModel();
	}

	@Override
	public ProjectPriorityRegistration toEscapedModel() {
		return new ProjectPriorityRegistrationWrapper(_projectPriorityRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectPriorityRegistration.toString();
	}

	@Override
	public ProjectPriorityRegistration toUnescapedModel() {
		return new ProjectPriorityRegistrationWrapper(_projectPriorityRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectPriorityRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectPriorityRegistrationWrapper)) {
			return false;
		}

		ProjectPriorityRegistrationWrapper projectPriorityRegistrationWrapper = (ProjectPriorityRegistrationWrapper)obj;

		if (Objects.equals(_projectPriorityRegistration,
					projectPriorityRegistrationWrapper._projectPriorityRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectPriorityRegistration getWrappedModel() {
		return _projectPriorityRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectPriorityRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectPriorityRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectPriorityRegistration.resetOriginalValues();
	}

	private final ProjectPriorityRegistration _projectPriorityRegistration;
}