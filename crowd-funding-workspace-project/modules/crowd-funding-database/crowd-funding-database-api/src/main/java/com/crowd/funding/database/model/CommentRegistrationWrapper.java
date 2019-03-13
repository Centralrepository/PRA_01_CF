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
 * This class is a wrapper for {@link CommentRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentRegistration
 * @generated
 */
@ProviderType
public class CommentRegistrationWrapper implements CommentRegistration,
	ModelWrapper<CommentRegistration> {
	public CommentRegistrationWrapper(CommentRegistration commentRegistration) {
		_commentRegistration = commentRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return CommentRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return CommentRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_COMMENT_ID", getPROJECT_COMMENT_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("COMMENT", getCOMMENT());
		attributes.put("ANSWER", getANSWER());
		attributes.put("DONOR_USER_ID", getDONOR_USER_ID());
		attributes.put("COMMENT_DATE", getCOMMENT_DATE());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_COMMENT_ID = (Long)attributes.get("PROJECT_COMMENT_ID");

		if (PROJECT_COMMENT_ID != null) {
			setPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		String COMMENT = (String)attributes.get("COMMENT");

		if (COMMENT != null) {
			setCOMMENT(COMMENT);
		}

		String ANSWER = (String)attributes.get("ANSWER");

		if (ANSWER != null) {
			setANSWER(ANSWER);
		}

		Long DONOR_USER_ID = (Long)attributes.get("DONOR_USER_ID");

		if (DONOR_USER_ID != null) {
			setDONOR_USER_ID(DONOR_USER_ID);
		}

		Date COMMENT_DATE = (Date)attributes.get("COMMENT_DATE");

		if (COMMENT_DATE != null) {
			setCOMMENT_DATE(COMMENT_DATE);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new CommentRegistrationWrapper((CommentRegistration)_commentRegistration.clone());
	}

	@Override
	public int compareTo(CommentRegistration commentRegistration) {
		return _commentRegistration.compareTo(commentRegistration);
	}

	/**
	* Returns the answer of this comment registration.
	*
	* @return the answer of this comment registration
	*/
	@Override
	public String getANSWER() {
		return _commentRegistration.getANSWER();
	}

	/**
	* Returns the comment of this comment registration.
	*
	* @return the comment of this comment registration
	*/
	@Override
	public String getCOMMENT() {
		return _commentRegistration.getCOMMENT();
	}

	/**
	* Returns the comment_date of this comment registration.
	*
	* @return the comment_date of this comment registration
	*/
	@Override
	public Date getCOMMENT_DATE() {
		return _commentRegistration.getCOMMENT_DATE();
	}

	/**
	* Returns the donor_user_id of this comment registration.
	*
	* @return the donor_user_id of this comment registration
	*/
	@Override
	public long getDONOR_USER_ID() {
		return _commentRegistration.getDONOR_USER_ID();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _commentRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this comment registration.
	*
	* @return the primary key of this comment registration
	*/
	@Override
	public long getPrimaryKey() {
		return _commentRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commentRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_comment_id of this comment registration.
	*
	* @return the project_comment_id of this comment registration
	*/
	@Override
	public long getPROJECT_COMMENT_ID() {
		return _commentRegistration.getPROJECT_COMMENT_ID();
	}

	/**
	* Returns the project_id of this comment registration.
	*
	* @return the project_id of this comment registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _commentRegistration.getPROJECT_ID();
	}

	/**
	* Returns the status of this comment registration.
	*
	* @return the status of this comment registration
	*/
	@Override
	public int getSTATUS() {
		return _commentRegistration.getSTATUS();
	}

	/**
	* Returns the uuid of this comment registration.
	*
	* @return the uuid of this comment registration
	*/
	@Override
	public String getUuid() {
		return _commentRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _commentRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _commentRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _commentRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _commentRegistration.isNew();
	}

	@Override
	public void persist() {
		_commentRegistration.persist();
	}

	/**
	* Sets the answer of this comment registration.
	*
	* @param ANSWER the answer of this comment registration
	*/
	@Override
	public void setANSWER(String ANSWER) {
		_commentRegistration.setANSWER(ANSWER);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_commentRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the comment of this comment registration.
	*
	* @param COMMENT the comment of this comment registration
	*/
	@Override
	public void setCOMMENT(String COMMENT) {
		_commentRegistration.setCOMMENT(COMMENT);
	}

	/**
	* Sets the comment_date of this comment registration.
	*
	* @param COMMENT_DATE the comment_date of this comment registration
	*/
	@Override
	public void setCOMMENT_DATE(Date COMMENT_DATE) {
		_commentRegistration.setCOMMENT_DATE(COMMENT_DATE);
	}

	/**
	* Sets the donor_user_id of this comment registration.
	*
	* @param DONOR_USER_ID the donor_user_id of this comment registration
	*/
	@Override
	public void setDONOR_USER_ID(long DONOR_USER_ID) {
		_commentRegistration.setDONOR_USER_ID(DONOR_USER_ID);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_commentRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_commentRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_commentRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_commentRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this comment registration.
	*
	* @param primaryKey the primary key of this comment registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_commentRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_commentRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_comment_id of this comment registration.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id of this comment registration
	*/
	@Override
	public void setPROJECT_COMMENT_ID(long PROJECT_COMMENT_ID) {
		_commentRegistration.setPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);
	}

	/**
	* Sets the project_id of this comment registration.
	*
	* @param PROJECT_ID the project_id of this comment registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_commentRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the status of this comment registration.
	*
	* @param STATUS the status of this comment registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_commentRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the uuid of this comment registration.
	*
	* @param uuid the uuid of this comment registration
	*/
	@Override
	public void setUuid(String uuid) {
		_commentRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CommentRegistration> toCacheModel() {
		return _commentRegistration.toCacheModel();
	}

	@Override
	public CommentRegistration toEscapedModel() {
		return new CommentRegistrationWrapper(_commentRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _commentRegistration.toString();
	}

	@Override
	public CommentRegistration toUnescapedModel() {
		return new CommentRegistrationWrapper(_commentRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _commentRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommentRegistrationWrapper)) {
			return false;
		}

		CommentRegistrationWrapper commentRegistrationWrapper = (CommentRegistrationWrapper)obj;

		if (Objects.equals(_commentRegistration,
					commentRegistrationWrapper._commentRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public CommentRegistration getWrappedModel() {
		return _commentRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _commentRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _commentRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_commentRegistration.resetOriginalValues();
	}

	private final CommentRegistration _commentRegistration;
}