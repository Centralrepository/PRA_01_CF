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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ProjectAcknowledgementRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectAcknowledgementRegistration
 * @generated
 */
@ProviderType
public class ProjectAcknowledgementRegistrationWrapper
	implements ProjectAcknowledgementRegistration,
		ModelWrapper<ProjectAcknowledgementRegistration> {
	public ProjectAcknowledgementRegistrationWrapper(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		_projectAcknowledgementRegistration = projectAcknowledgementRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectAcknowledgementRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectAcknowledgementRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ACKNOWLEDGMENT_ID", getACKNOWLEDGMENT_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("DETAILS", getDETAILS());
		attributes.put("DOCUMENT_NAME", getDOCUMENT_NAME());
		attributes.put("DOCUMENT_TYPE", getDOCUMENT_TYPE());
		attributes.put("DOCUMENT", getDOCUMENT());
		attributes.put("VIDEO_TYPE", getVIDEO_TYPE());
		attributes.put("VIDEO", getVIDEO());
		attributes.put("DATE", getDATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ACKNOWLEDGMENT_ID = (Long)attributes.get("ACKNOWLEDGMENT_ID");

		if (ACKNOWLEDGMENT_ID != null) {
			setACKNOWLEDGMENT_ID(ACKNOWLEDGMENT_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		String DETAILS = (String)attributes.get("DETAILS");

		if (DETAILS != null) {
			setDETAILS(DETAILS);
		}

		String DOCUMENT_NAME = (String)attributes.get("DOCUMENT_NAME");

		if (DOCUMENT_NAME != null) {
			setDOCUMENT_NAME(DOCUMENT_NAME);
		}

		String DOCUMENT_TYPE = (String)attributes.get("DOCUMENT_TYPE");

		if (DOCUMENT_TYPE != null) {
			setDOCUMENT_TYPE(DOCUMENT_TYPE);
		}

		Blob DOCUMENT = (Blob)attributes.get("DOCUMENT");

		if (DOCUMENT != null) {
			setDOCUMENT(DOCUMENT);
		}

		String VIDEO_TYPE = (String)attributes.get("VIDEO_TYPE");

		if (VIDEO_TYPE != null) {
			setVIDEO_TYPE(VIDEO_TYPE);
		}

		Blob VIDEO = (Blob)attributes.get("VIDEO");

		if (VIDEO != null) {
			setVIDEO(VIDEO);
		}

		Date DATE = (Date)attributes.get("DATE");

		if (DATE != null) {
			setDATE(DATE);
		}
	}

	@Override
	public Object clone() {
		return new ProjectAcknowledgementRegistrationWrapper((ProjectAcknowledgementRegistration)_projectAcknowledgementRegistration.clone());
	}

	@Override
	public int compareTo(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		return _projectAcknowledgementRegistration.compareTo(projectAcknowledgementRegistration);
	}

	/**
	* Returns the acknowledgment_id of this project acknowledgement registration.
	*
	* @return the acknowledgment_id of this project acknowledgement registration
	*/
	@Override
	public long getACKNOWLEDGMENT_ID() {
		return _projectAcknowledgementRegistration.getACKNOWLEDGMENT_ID();
	}

	/**
	* Returns the date of this project acknowledgement registration.
	*
	* @return the date of this project acknowledgement registration
	*/
	@Override
	public Date getDATE() {
		return _projectAcknowledgementRegistration.getDATE();
	}

	/**
	* Returns the details of this project acknowledgement registration.
	*
	* @return the details of this project acknowledgement registration
	*/
	@Override
	public String getDETAILS() {
		return _projectAcknowledgementRegistration.getDETAILS();
	}

	/**
	* Returns the document of this project acknowledgement registration.
	*
	* @return the document of this project acknowledgement registration
	*/
	@Override
	public Blob getDOCUMENT() {
		return _projectAcknowledgementRegistration.getDOCUMENT();
	}

	/**
	* Returns the document_name of this project acknowledgement registration.
	*
	* @return the document_name of this project acknowledgement registration
	*/
	@Override
	public String getDOCUMENT_NAME() {
		return _projectAcknowledgementRegistration.getDOCUMENT_NAME();
	}

	/**
	* Returns the document_type of this project acknowledgement registration.
	*
	* @return the document_type of this project acknowledgement registration
	*/
	@Override
	public String getDOCUMENT_TYPE() {
		return _projectAcknowledgementRegistration.getDOCUMENT_TYPE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectAcknowledgementRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this project acknowledgement registration.
	*
	* @return the primary key of this project acknowledgement registration
	*/
	@Override
	public long getPrimaryKey() {
		return _projectAcknowledgementRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectAcknowledgementRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_id of this project acknowledgement registration.
	*
	* @return the project_id of this project acknowledgement registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _projectAcknowledgementRegistration.getPROJECT_ID();
	}

	/**
	* Returns the uuid of this project acknowledgement registration.
	*
	* @return the uuid of this project acknowledgement registration
	*/
	@Override
	public String getUuid() {
		return _projectAcknowledgementRegistration.getUuid();
	}

	/**
	* Returns the video of this project acknowledgement registration.
	*
	* @return the video of this project acknowledgement registration
	*/
	@Override
	public Blob getVIDEO() {
		return _projectAcknowledgementRegistration.getVIDEO();
	}

	/**
	* Returns the video_type of this project acknowledgement registration.
	*
	* @return the video_type of this project acknowledgement registration
	*/
	@Override
	public String getVIDEO_TYPE() {
		return _projectAcknowledgementRegistration.getVIDEO_TYPE();
	}

	@Override
	public int hashCode() {
		return _projectAcknowledgementRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectAcknowledgementRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectAcknowledgementRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectAcknowledgementRegistration.isNew();
	}

	@Override
	public void persist() {
		_projectAcknowledgementRegistration.persist();
	}

	/**
	* Sets the acknowledgment_id of this project acknowledgement registration.
	*
	* @param ACKNOWLEDGMENT_ID the acknowledgment_id of this project acknowledgement registration
	*/
	@Override
	public void setACKNOWLEDGMENT_ID(long ACKNOWLEDGMENT_ID) {
		_projectAcknowledgementRegistration.setACKNOWLEDGMENT_ID(ACKNOWLEDGMENT_ID);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectAcknowledgementRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this project acknowledgement registration.
	*
	* @param DATE the date of this project acknowledgement registration
	*/
	@Override
	public void setDATE(Date DATE) {
		_projectAcknowledgementRegistration.setDATE(DATE);
	}

	/**
	* Sets the details of this project acknowledgement registration.
	*
	* @param DETAILS the details of this project acknowledgement registration
	*/
	@Override
	public void setDETAILS(String DETAILS) {
		_projectAcknowledgementRegistration.setDETAILS(DETAILS);
	}

	/**
	* Sets the document of this project acknowledgement registration.
	*
	* @param DOCUMENT the document of this project acknowledgement registration
	*/
	@Override
	public void setDOCUMENT(Blob DOCUMENT) {
		_projectAcknowledgementRegistration.setDOCUMENT(DOCUMENT);
	}

	/**
	* Sets the document_name of this project acknowledgement registration.
	*
	* @param DOCUMENT_NAME the document_name of this project acknowledgement registration
	*/
	@Override
	public void setDOCUMENT_NAME(String DOCUMENT_NAME) {
		_projectAcknowledgementRegistration.setDOCUMENT_NAME(DOCUMENT_NAME);
	}

	/**
	* Sets the document_type of this project acknowledgement registration.
	*
	* @param DOCUMENT_TYPE the document_type of this project acknowledgement registration
	*/
	@Override
	public void setDOCUMENT_TYPE(String DOCUMENT_TYPE) {
		_projectAcknowledgementRegistration.setDOCUMENT_TYPE(DOCUMENT_TYPE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectAcknowledgementRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectAcknowledgementRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectAcknowledgementRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_projectAcknowledgementRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this project acknowledgement registration.
	*
	* @param primaryKey the primary key of this project acknowledgement registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectAcknowledgementRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectAcknowledgementRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_id of this project acknowledgement registration.
	*
	* @param PROJECT_ID the project_id of this project acknowledgement registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_projectAcknowledgementRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the uuid of this project acknowledgement registration.
	*
	* @param uuid the uuid of this project acknowledgement registration
	*/
	@Override
	public void setUuid(String uuid) {
		_projectAcknowledgementRegistration.setUuid(uuid);
	}

	/**
	* Sets the video of this project acknowledgement registration.
	*
	* @param VIDEO the video of this project acknowledgement registration
	*/
	@Override
	public void setVIDEO(Blob VIDEO) {
		_projectAcknowledgementRegistration.setVIDEO(VIDEO);
	}

	/**
	* Sets the video_type of this project acknowledgement registration.
	*
	* @param VIDEO_TYPE the video_type of this project acknowledgement registration
	*/
	@Override
	public void setVIDEO_TYPE(String VIDEO_TYPE) {
		_projectAcknowledgementRegistration.setVIDEO_TYPE(VIDEO_TYPE);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectAcknowledgementRegistration> toCacheModel() {
		return _projectAcknowledgementRegistration.toCacheModel();
	}

	@Override
	public ProjectAcknowledgementRegistration toEscapedModel() {
		return new ProjectAcknowledgementRegistrationWrapper(_projectAcknowledgementRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectAcknowledgementRegistration.toString();
	}

	@Override
	public ProjectAcknowledgementRegistration toUnescapedModel() {
		return new ProjectAcknowledgementRegistrationWrapper(_projectAcknowledgementRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectAcknowledgementRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectAcknowledgementRegistrationWrapper)) {
			return false;
		}

		ProjectAcknowledgementRegistrationWrapper projectAcknowledgementRegistrationWrapper =
			(ProjectAcknowledgementRegistrationWrapper)obj;

		if (Objects.equals(_projectAcknowledgementRegistration,
					projectAcknowledgementRegistrationWrapper._projectAcknowledgementRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectAcknowledgementRegistration getWrappedModel() {
		return _projectAcknowledgementRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectAcknowledgementRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectAcknowledgementRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectAcknowledgementRegistration.resetOriginalValues();
	}

	private final ProjectAcknowledgementRegistration _projectAcknowledgementRegistration;
}