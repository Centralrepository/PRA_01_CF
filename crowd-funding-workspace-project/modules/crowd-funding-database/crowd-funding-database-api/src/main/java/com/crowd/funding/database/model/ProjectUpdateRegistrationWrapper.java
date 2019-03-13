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
 * This class is a wrapper for {@link ProjectUpdateRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUpdateRegistration
 * @generated
 */
@ProviderType
public class ProjectUpdateRegistrationWrapper
	implements ProjectUpdateRegistration,
		ModelWrapper<ProjectUpdateRegistration> {
	public ProjectUpdateRegistrationWrapper(
		ProjectUpdateRegistration projectUpdateRegistration) {
		_projectUpdateRegistration = projectUpdateRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectUpdateRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectUpdateRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_UPDATE_ID", getPROJECT_UPDATE_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("UPDATE_DETAILS", getUPDATE_DETAILS());
		attributes.put("UPDATE_DATE", getUPDATE_DATE());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_UPDATE_ID = (Long)attributes.get("PROJECT_UPDATE_ID");

		if (PROJECT_UPDATE_ID != null) {
			setPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		String UPDATE_DETAILS = (String)attributes.get("UPDATE_DETAILS");

		if (UPDATE_DETAILS != null) {
			setUPDATE_DETAILS(UPDATE_DETAILS);
		}

		Date UPDATE_DATE = (Date)attributes.get("UPDATE_DATE");

		if (UPDATE_DATE != null) {
			setUPDATE_DATE(UPDATE_DATE);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new ProjectUpdateRegistrationWrapper((ProjectUpdateRegistration)_projectUpdateRegistration.clone());
	}

	@Override
	public int compareTo(ProjectUpdateRegistration projectUpdateRegistration) {
		return _projectUpdateRegistration.compareTo(projectUpdateRegistration);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectUpdateRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this project update registration.
	*
	* @return the primary key of this project update registration
	*/
	@Override
	public long getPrimaryKey() {
		return _projectUpdateRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectUpdateRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_id of this project update registration.
	*
	* @return the project_id of this project update registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _projectUpdateRegistration.getPROJECT_ID();
	}

	/**
	* Returns the project_update_id of this project update registration.
	*
	* @return the project_update_id of this project update registration
	*/
	@Override
	public long getPROJECT_UPDATE_ID() {
		return _projectUpdateRegistration.getPROJECT_UPDATE_ID();
	}

	/**
	* Returns the status of this project update registration.
	*
	* @return the status of this project update registration
	*/
	@Override
	public int getSTATUS() {
		return _projectUpdateRegistration.getSTATUS();
	}

	/**
	* Returns the update_date of this project update registration.
	*
	* @return the update_date of this project update registration
	*/
	@Override
	public Date getUPDATE_DATE() {
		return _projectUpdateRegistration.getUPDATE_DATE();
	}

	/**
	* Returns the update_details of this project update registration.
	*
	* @return the update_details of this project update registration
	*/
	@Override
	public String getUPDATE_DETAILS() {
		return _projectUpdateRegistration.getUPDATE_DETAILS();
	}

	/**
	* Returns the uuid of this project update registration.
	*
	* @return the uuid of this project update registration
	*/
	@Override
	public String getUuid() {
		return _projectUpdateRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _projectUpdateRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectUpdateRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectUpdateRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectUpdateRegistration.isNew();
	}

	@Override
	public void persist() {
		_projectUpdateRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectUpdateRegistration.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectUpdateRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectUpdateRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectUpdateRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_projectUpdateRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this project update registration.
	*
	* @param primaryKey the primary key of this project update registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectUpdateRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectUpdateRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_id of this project update registration.
	*
	* @param PROJECT_ID the project_id of this project update registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_projectUpdateRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the project_update_id of this project update registration.
	*
	* @param PROJECT_UPDATE_ID the project_update_id of this project update registration
	*/
	@Override
	public void setPROJECT_UPDATE_ID(long PROJECT_UPDATE_ID) {
		_projectUpdateRegistration.setPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);
	}

	/**
	* Sets the status of this project update registration.
	*
	* @param STATUS the status of this project update registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_projectUpdateRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the update_date of this project update registration.
	*
	* @param UPDATE_DATE the update_date of this project update registration
	*/
	@Override
	public void setUPDATE_DATE(Date UPDATE_DATE) {
		_projectUpdateRegistration.setUPDATE_DATE(UPDATE_DATE);
	}

	/**
	* Sets the update_details of this project update registration.
	*
	* @param UPDATE_DETAILS the update_details of this project update registration
	*/
	@Override
	public void setUPDATE_DETAILS(String UPDATE_DETAILS) {
		_projectUpdateRegistration.setUPDATE_DETAILS(UPDATE_DETAILS);
	}

	/**
	* Sets the uuid of this project update registration.
	*
	* @param uuid the uuid of this project update registration
	*/
	@Override
	public void setUuid(String uuid) {
		_projectUpdateRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectUpdateRegistration> toCacheModel() {
		return _projectUpdateRegistration.toCacheModel();
	}

	@Override
	public ProjectUpdateRegistration toEscapedModel() {
		return new ProjectUpdateRegistrationWrapper(_projectUpdateRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectUpdateRegistration.toString();
	}

	@Override
	public ProjectUpdateRegistration toUnescapedModel() {
		return new ProjectUpdateRegistrationWrapper(_projectUpdateRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectUpdateRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectUpdateRegistrationWrapper)) {
			return false;
		}

		ProjectUpdateRegistrationWrapper projectUpdateRegistrationWrapper = (ProjectUpdateRegistrationWrapper)obj;

		if (Objects.equals(_projectUpdateRegistration,
					projectUpdateRegistrationWrapper._projectUpdateRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectUpdateRegistration getWrappedModel() {
		return _projectUpdateRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectUpdateRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectUpdateRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectUpdateRegistration.resetOriginalValues();
	}

	private final ProjectUpdateRegistration _projectUpdateRegistration;
}