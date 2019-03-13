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
 * This class is a wrapper for {@link QuestionRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRegistration
 * @generated
 */
@ProviderType
public class QuestionRegistrationWrapper implements QuestionRegistration,
	ModelWrapper<QuestionRegistration> {
	public QuestionRegistrationWrapper(
		QuestionRegistration questionRegistration) {
		_questionRegistration = questionRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return QuestionRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return QuestionRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_QUESTION_ID", getPROJECT_QUESTION_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("QUESTION", getQUESTION());
		attributes.put("QUESTION_REQUESTER_USER_ID",
			getQUESTION_REQUESTER_USER_ID());
		attributes.put("QUESTION_DATE", getQUESTION_DATE());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_QUESTION_ID = (Long)attributes.get("PROJECT_QUESTION_ID");

		if (PROJECT_QUESTION_ID != null) {
			setPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		String QUESTION = (String)attributes.get("QUESTION");

		if (QUESTION != null) {
			setQUESTION(QUESTION);
		}

		Long QUESTION_REQUESTER_USER_ID = (Long)attributes.get(
				"QUESTION_REQUESTER_USER_ID");

		if (QUESTION_REQUESTER_USER_ID != null) {
			setQUESTION_REQUESTER_USER_ID(QUESTION_REQUESTER_USER_ID);
		}

		Date QUESTION_DATE = (Date)attributes.get("QUESTION_DATE");

		if (QUESTION_DATE != null) {
			setQUESTION_DATE(QUESTION_DATE);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new QuestionRegistrationWrapper((QuestionRegistration)_questionRegistration.clone());
	}

	@Override
	public int compareTo(QuestionRegistration questionRegistration) {
		return _questionRegistration.compareTo(questionRegistration);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _questionRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this question registration.
	*
	* @return the primary key of this question registration
	*/
	@Override
	public long getPrimaryKey() {
		return _questionRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _questionRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_id of this question registration.
	*
	* @return the project_id of this question registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _questionRegistration.getPROJECT_ID();
	}

	/**
	* Returns the project_question_id of this question registration.
	*
	* @return the project_question_id of this question registration
	*/
	@Override
	public long getPROJECT_QUESTION_ID() {
		return _questionRegistration.getPROJECT_QUESTION_ID();
	}

	/**
	* Returns the question of this question registration.
	*
	* @return the question of this question registration
	*/
	@Override
	public String getQUESTION() {
		return _questionRegistration.getQUESTION();
	}

	/**
	* Returns the question_date of this question registration.
	*
	* @return the question_date of this question registration
	*/
	@Override
	public Date getQUESTION_DATE() {
		return _questionRegistration.getQUESTION_DATE();
	}

	/**
	* Returns the question_requester_user_id of this question registration.
	*
	* @return the question_requester_user_id of this question registration
	*/
	@Override
	public long getQUESTION_REQUESTER_USER_ID() {
		return _questionRegistration.getQUESTION_REQUESTER_USER_ID();
	}

	/**
	* Returns the status of this question registration.
	*
	* @return the status of this question registration
	*/
	@Override
	public int getSTATUS() {
		return _questionRegistration.getSTATUS();
	}

	/**
	* Returns the uuid of this question registration.
	*
	* @return the uuid of this question registration
	*/
	@Override
	public String getUuid() {
		return _questionRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _questionRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _questionRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _questionRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _questionRegistration.isNew();
	}

	@Override
	public void persist() {
		_questionRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_questionRegistration.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_questionRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_questionRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_questionRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_questionRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this question registration.
	*
	* @param primaryKey the primary key of this question registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_questionRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_questionRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_id of this question registration.
	*
	* @param PROJECT_ID the project_id of this question registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_questionRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the project_question_id of this question registration.
	*
	* @param PROJECT_QUESTION_ID the project_question_id of this question registration
	*/
	@Override
	public void setPROJECT_QUESTION_ID(long PROJECT_QUESTION_ID) {
		_questionRegistration.setPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);
	}

	/**
	* Sets the question of this question registration.
	*
	* @param QUESTION the question of this question registration
	*/
	@Override
	public void setQUESTION(String QUESTION) {
		_questionRegistration.setQUESTION(QUESTION);
	}

	/**
	* Sets the question_date of this question registration.
	*
	* @param QUESTION_DATE the question_date of this question registration
	*/
	@Override
	public void setQUESTION_DATE(Date QUESTION_DATE) {
		_questionRegistration.setQUESTION_DATE(QUESTION_DATE);
	}

	/**
	* Sets the question_requester_user_id of this question registration.
	*
	* @param QUESTION_REQUESTER_USER_ID the question_requester_user_id of this question registration
	*/
	@Override
	public void setQUESTION_REQUESTER_USER_ID(long QUESTION_REQUESTER_USER_ID) {
		_questionRegistration.setQUESTION_REQUESTER_USER_ID(QUESTION_REQUESTER_USER_ID);
	}

	/**
	* Sets the status of this question registration.
	*
	* @param STATUS the status of this question registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_questionRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the uuid of this question registration.
	*
	* @param uuid the uuid of this question registration
	*/
	@Override
	public void setUuid(String uuid) {
		_questionRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<QuestionRegistration> toCacheModel() {
		return _questionRegistration.toCacheModel();
	}

	@Override
	public QuestionRegistration toEscapedModel() {
		return new QuestionRegistrationWrapper(_questionRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _questionRegistration.toString();
	}

	@Override
	public QuestionRegistration toUnescapedModel() {
		return new QuestionRegistrationWrapper(_questionRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _questionRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionRegistrationWrapper)) {
			return false;
		}

		QuestionRegistrationWrapper questionRegistrationWrapper = (QuestionRegistrationWrapper)obj;

		if (Objects.equals(_questionRegistration,
					questionRegistrationWrapper._questionRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public QuestionRegistration getWrappedModel() {
		return _questionRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _questionRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _questionRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_questionRegistration.resetOriginalValues();
	}

	private final QuestionRegistration _questionRegistration;
}