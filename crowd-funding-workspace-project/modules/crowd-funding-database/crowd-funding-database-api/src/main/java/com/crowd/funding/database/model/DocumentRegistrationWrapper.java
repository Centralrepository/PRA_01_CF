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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link DocumentRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentRegistration
 * @generated
 */
@ProviderType
public class DocumentRegistrationWrapper implements DocumentRegistration,
	ModelWrapper<DocumentRegistration> {
	public DocumentRegistrationWrapper(
		DocumentRegistration documentRegistration) {
		_documentRegistration = documentRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return DocumentRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return DocumentRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_DOCUMENT_ID", getPROJECT_DOCUMENT_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("DOCUMENT_NAME", getDOCUMENT_NAME());
		attributes.put("DOCUMENT_TYPE", getDOCUMENT_TYPE());
		attributes.put("DOCUMENT", getDOCUMENT());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_DOCUMENT_ID = (Long)attributes.get("PROJECT_DOCUMENT_ID");

		if (PROJECT_DOCUMENT_ID != null) {
			setPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
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
	}

	@Override
	public Object clone() {
		return new DocumentRegistrationWrapper((DocumentRegistration)_documentRegistration.clone());
	}

	@Override
	public int compareTo(DocumentRegistration documentRegistration) {
		return _documentRegistration.compareTo(documentRegistration);
	}

	/**
	* Returns the document of this document registration.
	*
	* @return the document of this document registration
	*/
	@Override
	public Blob getDOCUMENT() {
		return _documentRegistration.getDOCUMENT();
	}

	/**
	* Returns the document_name of this document registration.
	*
	* @return the document_name of this document registration
	*/
	@Override
	public String getDOCUMENT_NAME() {
		return _documentRegistration.getDOCUMENT_NAME();
	}

	/**
	* Returns the document_type of this document registration.
	*
	* @return the document_type of this document registration
	*/
	@Override
	public String getDOCUMENT_TYPE() {
		return _documentRegistration.getDOCUMENT_TYPE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _documentRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this document registration.
	*
	* @return the primary key of this document registration
	*/
	@Override
	public long getPrimaryKey() {
		return _documentRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _documentRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_document_id of this document registration.
	*
	* @return the project_document_id of this document registration
	*/
	@Override
	public long getPROJECT_DOCUMENT_ID() {
		return _documentRegistration.getPROJECT_DOCUMENT_ID();
	}

	/**
	* Returns the project_id of this document registration.
	*
	* @return the project_id of this document registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _documentRegistration.getPROJECT_ID();
	}

	/**
	* Returns the uuid of this document registration.
	*
	* @return the uuid of this document registration
	*/
	@Override
	public String getUuid() {
		return _documentRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _documentRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _documentRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _documentRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _documentRegistration.isNew();
	}

	@Override
	public void persist() {
		_documentRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_documentRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the document of this document registration.
	*
	* @param DOCUMENT the document of this document registration
	*/
	@Override
	public void setDOCUMENT(Blob DOCUMENT) {
		_documentRegistration.setDOCUMENT(DOCUMENT);
	}

	/**
	* Sets the document_name of this document registration.
	*
	* @param DOCUMENT_NAME the document_name of this document registration
	*/
	@Override
	public void setDOCUMENT_NAME(String DOCUMENT_NAME) {
		_documentRegistration.setDOCUMENT_NAME(DOCUMENT_NAME);
	}

	/**
	* Sets the document_type of this document registration.
	*
	* @param DOCUMENT_TYPE the document_type of this document registration
	*/
	@Override
	public void setDOCUMENT_TYPE(String DOCUMENT_TYPE) {
		_documentRegistration.setDOCUMENT_TYPE(DOCUMENT_TYPE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_documentRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_documentRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_documentRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_documentRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this document registration.
	*
	* @param primaryKey the primary key of this document registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_documentRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_documentRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_document_id of this document registration.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id of this document registration
	*/
	@Override
	public void setPROJECT_DOCUMENT_ID(long PROJECT_DOCUMENT_ID) {
		_documentRegistration.setPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);
	}

	/**
	* Sets the project_id of this document registration.
	*
	* @param PROJECT_ID the project_id of this document registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_documentRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the uuid of this document registration.
	*
	* @param uuid the uuid of this document registration
	*/
	@Override
	public void setUuid(String uuid) {
		_documentRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DocumentRegistration> toCacheModel() {
		return _documentRegistration.toCacheModel();
	}

	@Override
	public DocumentRegistration toEscapedModel() {
		return new DocumentRegistrationWrapper(_documentRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _documentRegistration.toString();
	}

	@Override
	public DocumentRegistration toUnescapedModel() {
		return new DocumentRegistrationWrapper(_documentRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _documentRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentRegistrationWrapper)) {
			return false;
		}

		DocumentRegistrationWrapper documentRegistrationWrapper = (DocumentRegistrationWrapper)obj;

		if (Objects.equals(_documentRegistration,
					documentRegistrationWrapper._documentRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public DocumentRegistration getWrappedModel() {
		return _documentRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _documentRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _documentRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_documentRegistration.resetOriginalValues();
	}

	private final DocumentRegistration _documentRegistration;
}