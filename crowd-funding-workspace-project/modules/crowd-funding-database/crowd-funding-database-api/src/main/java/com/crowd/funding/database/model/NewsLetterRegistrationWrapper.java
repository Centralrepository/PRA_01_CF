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
 * This class is a wrapper for {@link NewsLetterRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterRegistration
 * @generated
 */
@ProviderType
public class NewsLetterRegistrationWrapper implements NewsLetterRegistration,
	ModelWrapper<NewsLetterRegistration> {
	public NewsLetterRegistrationWrapper(
		NewsLetterRegistration newsLetterRegistration) {
		_newsLetterRegistration = newsLetterRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return NewsLetterRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return NewsLetterRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("NEWS_LETTER_ID", getNEWS_LETTER_ID());
		attributes.put("TITLE", getTITLE());
		attributes.put("DETAILS", getDETAILS());
		attributes.put("DOCUMENT_TYPE", getDOCUMENT_TYPE());
		attributes.put("DOCUMENT", getDOCUMENT());
		attributes.put("DATE", getDATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long NEWS_LETTER_ID = (Long)attributes.get("NEWS_LETTER_ID");

		if (NEWS_LETTER_ID != null) {
			setNEWS_LETTER_ID(NEWS_LETTER_ID);
		}

		String TITLE = (String)attributes.get("TITLE");

		if (TITLE != null) {
			setTITLE(TITLE);
		}

		String DETAILS = (String)attributes.get("DETAILS");

		if (DETAILS != null) {
			setDETAILS(DETAILS);
		}

		String DOCUMENT_TYPE = (String)attributes.get("DOCUMENT_TYPE");

		if (DOCUMENT_TYPE != null) {
			setDOCUMENT_TYPE(DOCUMENT_TYPE);
		}

		Blob DOCUMENT = (Blob)attributes.get("DOCUMENT");

		if (DOCUMENT != null) {
			setDOCUMENT(DOCUMENT);
		}

		Date DATE = (Date)attributes.get("DATE");

		if (DATE != null) {
			setDATE(DATE);
		}
	}

	@Override
	public Object clone() {
		return new NewsLetterRegistrationWrapper((NewsLetterRegistration)_newsLetterRegistration.clone());
	}

	@Override
	public int compareTo(NewsLetterRegistration newsLetterRegistration) {
		return _newsLetterRegistration.compareTo(newsLetterRegistration);
	}

	/**
	* Returns the date of this news letter registration.
	*
	* @return the date of this news letter registration
	*/
	@Override
	public Date getDATE() {
		return _newsLetterRegistration.getDATE();
	}

	/**
	* Returns the details of this news letter registration.
	*
	* @return the details of this news letter registration
	*/
	@Override
	public String getDETAILS() {
		return _newsLetterRegistration.getDETAILS();
	}

	/**
	* Returns the document of this news letter registration.
	*
	* @return the document of this news letter registration
	*/
	@Override
	public Blob getDOCUMENT() {
		return _newsLetterRegistration.getDOCUMENT();
	}

	/**
	* Returns the document_type of this news letter registration.
	*
	* @return the document_type of this news letter registration
	*/
	@Override
	public String getDOCUMENT_TYPE() {
		return _newsLetterRegistration.getDOCUMENT_TYPE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _newsLetterRegistration.getExpandoBridge();
	}

	/**
	* Returns the news_letter_id of this news letter registration.
	*
	* @return the news_letter_id of this news letter registration
	*/
	@Override
	public long getNEWS_LETTER_ID() {
		return _newsLetterRegistration.getNEWS_LETTER_ID();
	}

	/**
	* Returns the primary key of this news letter registration.
	*
	* @return the primary key of this news letter registration
	*/
	@Override
	public long getPrimaryKey() {
		return _newsLetterRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newsLetterRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the title of this news letter registration.
	*
	* @return the title of this news letter registration
	*/
	@Override
	public String getTITLE() {
		return _newsLetterRegistration.getTITLE();
	}

	/**
	* Returns the uuid of this news letter registration.
	*
	* @return the uuid of this news letter registration
	*/
	@Override
	public String getUuid() {
		return _newsLetterRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _newsLetterRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _newsLetterRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _newsLetterRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _newsLetterRegistration.isNew();
	}

	@Override
	public void persist() {
		_newsLetterRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_newsLetterRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this news letter registration.
	*
	* @param DATE the date of this news letter registration
	*/
	@Override
	public void setDATE(Date DATE) {
		_newsLetterRegistration.setDATE(DATE);
	}

	/**
	* Sets the details of this news letter registration.
	*
	* @param DETAILS the details of this news letter registration
	*/
	@Override
	public void setDETAILS(String DETAILS) {
		_newsLetterRegistration.setDETAILS(DETAILS);
	}

	/**
	* Sets the document of this news letter registration.
	*
	* @param DOCUMENT the document of this news letter registration
	*/
	@Override
	public void setDOCUMENT(Blob DOCUMENT) {
		_newsLetterRegistration.setDOCUMENT(DOCUMENT);
	}

	/**
	* Sets the document_type of this news letter registration.
	*
	* @param DOCUMENT_TYPE the document_type of this news letter registration
	*/
	@Override
	public void setDOCUMENT_TYPE(String DOCUMENT_TYPE) {
		_newsLetterRegistration.setDOCUMENT_TYPE(DOCUMENT_TYPE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_newsLetterRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_newsLetterRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_newsLetterRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_newsLetterRegistration.setNew(n);
	}

	/**
	* Sets the news_letter_id of this news letter registration.
	*
	* @param NEWS_LETTER_ID the news_letter_id of this news letter registration
	*/
	@Override
	public void setNEWS_LETTER_ID(long NEWS_LETTER_ID) {
		_newsLetterRegistration.setNEWS_LETTER_ID(NEWS_LETTER_ID);
	}

	/**
	* Sets the primary key of this news letter registration.
	*
	* @param primaryKey the primary key of this news letter registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_newsLetterRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_newsLetterRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the title of this news letter registration.
	*
	* @param TITLE the title of this news letter registration
	*/
	@Override
	public void setTITLE(String TITLE) {
		_newsLetterRegistration.setTITLE(TITLE);
	}

	/**
	* Sets the uuid of this news letter registration.
	*
	* @param uuid the uuid of this news letter registration
	*/
	@Override
	public void setUuid(String uuid) {
		_newsLetterRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<NewsLetterRegistration> toCacheModel() {
		return _newsLetterRegistration.toCacheModel();
	}

	@Override
	public NewsLetterRegistration toEscapedModel() {
		return new NewsLetterRegistrationWrapper(_newsLetterRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _newsLetterRegistration.toString();
	}

	@Override
	public NewsLetterRegistration toUnescapedModel() {
		return new NewsLetterRegistrationWrapper(_newsLetterRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _newsLetterRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsLetterRegistrationWrapper)) {
			return false;
		}

		NewsLetterRegistrationWrapper newsLetterRegistrationWrapper = (NewsLetterRegistrationWrapper)obj;

		if (Objects.equals(_newsLetterRegistration,
					newsLetterRegistrationWrapper._newsLetterRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public NewsLetterRegistration getWrappedModel() {
		return _newsLetterRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _newsLetterRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _newsLetterRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_newsLetterRegistration.resetOriginalValues();
	}

	private final NewsLetterRegistration _newsLetterRegistration;
}