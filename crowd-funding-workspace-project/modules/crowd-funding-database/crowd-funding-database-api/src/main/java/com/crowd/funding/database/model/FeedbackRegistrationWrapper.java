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
 * This class is a wrapper for {@link FeedbackRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackRegistration
 * @generated
 */
@ProviderType
public class FeedbackRegistrationWrapper implements FeedbackRegistration,
	ModelWrapper<FeedbackRegistration> {
	public FeedbackRegistrationWrapper(
		FeedbackRegistration feedbackRegistration) {
		_feedbackRegistration = feedbackRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return FeedbackRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return FeedbackRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_FEEDBACK_ID", getPROJECT_FEEDBACK_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("FEEDBACK", getFEEDBACK());
		attributes.put("DONOR_USER_ID", getDONOR_USER_ID());
		attributes.put("FEEDBACK_DATE", getFEEDBACK_DATE());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_FEEDBACK_ID = (Long)attributes.get("PROJECT_FEEDBACK_ID");

		if (PROJECT_FEEDBACK_ID != null) {
			setPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		String FEEDBACK = (String)attributes.get("FEEDBACK");

		if (FEEDBACK != null) {
			setFEEDBACK(FEEDBACK);
		}

		Long DONOR_USER_ID = (Long)attributes.get("DONOR_USER_ID");

		if (DONOR_USER_ID != null) {
			setDONOR_USER_ID(DONOR_USER_ID);
		}

		Date FEEDBACK_DATE = (Date)attributes.get("FEEDBACK_DATE");

		if (FEEDBACK_DATE != null) {
			setFEEDBACK_DATE(FEEDBACK_DATE);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new FeedbackRegistrationWrapper((FeedbackRegistration)_feedbackRegistration.clone());
	}

	@Override
	public int compareTo(FeedbackRegistration feedbackRegistration) {
		return _feedbackRegistration.compareTo(feedbackRegistration);
	}

	/**
	* Returns the donor_user_id of this feedback registration.
	*
	* @return the donor_user_id of this feedback registration
	*/
	@Override
	public long getDONOR_USER_ID() {
		return _feedbackRegistration.getDONOR_USER_ID();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _feedbackRegistration.getExpandoBridge();
	}

	/**
	* Returns the feedback of this feedback registration.
	*
	* @return the feedback of this feedback registration
	*/
	@Override
	public String getFEEDBACK() {
		return _feedbackRegistration.getFEEDBACK();
	}

	/**
	* Returns the feedback_date of this feedback registration.
	*
	* @return the feedback_date of this feedback registration
	*/
	@Override
	public Date getFEEDBACK_DATE() {
		return _feedbackRegistration.getFEEDBACK_DATE();
	}

	/**
	* Returns the primary key of this feedback registration.
	*
	* @return the primary key of this feedback registration
	*/
	@Override
	public long getPrimaryKey() {
		return _feedbackRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedbackRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_feedback_id of this feedback registration.
	*
	* @return the project_feedback_id of this feedback registration
	*/
	@Override
	public long getPROJECT_FEEDBACK_ID() {
		return _feedbackRegistration.getPROJECT_FEEDBACK_ID();
	}

	/**
	* Returns the project_id of this feedback registration.
	*
	* @return the project_id of this feedback registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _feedbackRegistration.getPROJECT_ID();
	}

	/**
	* Returns the status of this feedback registration.
	*
	* @return the status of this feedback registration
	*/
	@Override
	public int getSTATUS() {
		return _feedbackRegistration.getSTATUS();
	}

	/**
	* Returns the uuid of this feedback registration.
	*
	* @return the uuid of this feedback registration
	*/
	@Override
	public String getUuid() {
		return _feedbackRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _feedbackRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _feedbackRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _feedbackRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _feedbackRegistration.isNew();
	}

	@Override
	public void persist() {
		_feedbackRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feedbackRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the donor_user_id of this feedback registration.
	*
	* @param DONOR_USER_ID the donor_user_id of this feedback registration
	*/
	@Override
	public void setDONOR_USER_ID(long DONOR_USER_ID) {
		_feedbackRegistration.setDONOR_USER_ID(DONOR_USER_ID);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_feedbackRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_feedbackRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_feedbackRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the feedback of this feedback registration.
	*
	* @param FEEDBACK the feedback of this feedback registration
	*/
	@Override
	public void setFEEDBACK(String FEEDBACK) {
		_feedbackRegistration.setFEEDBACK(FEEDBACK);
	}

	/**
	* Sets the feedback_date of this feedback registration.
	*
	* @param FEEDBACK_DATE the feedback_date of this feedback registration
	*/
	@Override
	public void setFEEDBACK_DATE(Date FEEDBACK_DATE) {
		_feedbackRegistration.setFEEDBACK_DATE(FEEDBACK_DATE);
	}

	@Override
	public void setNew(boolean n) {
		_feedbackRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this feedback registration.
	*
	* @param primaryKey the primary key of this feedback registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_feedbackRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_feedbackRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_feedback_id of this feedback registration.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id of this feedback registration
	*/
	@Override
	public void setPROJECT_FEEDBACK_ID(long PROJECT_FEEDBACK_ID) {
		_feedbackRegistration.setPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);
	}

	/**
	* Sets the project_id of this feedback registration.
	*
	* @param PROJECT_ID the project_id of this feedback registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_feedbackRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the status of this feedback registration.
	*
	* @param STATUS the status of this feedback registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_feedbackRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the uuid of this feedback registration.
	*
	* @param uuid the uuid of this feedback registration
	*/
	@Override
	public void setUuid(String uuid) {
		_feedbackRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<FeedbackRegistration> toCacheModel() {
		return _feedbackRegistration.toCacheModel();
	}

	@Override
	public FeedbackRegistration toEscapedModel() {
		return new FeedbackRegistrationWrapper(_feedbackRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _feedbackRegistration.toString();
	}

	@Override
	public FeedbackRegistration toUnescapedModel() {
		return new FeedbackRegistrationWrapper(_feedbackRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _feedbackRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackRegistrationWrapper)) {
			return false;
		}

		FeedbackRegistrationWrapper feedbackRegistrationWrapper = (FeedbackRegistrationWrapper)obj;

		if (Objects.equals(_feedbackRegistration,
					feedbackRegistrationWrapper._feedbackRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public FeedbackRegistration getWrappedModel() {
		return _feedbackRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _feedbackRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _feedbackRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_feedbackRegistration.resetOriginalValues();
	}

	private final FeedbackRegistration _feedbackRegistration;
}