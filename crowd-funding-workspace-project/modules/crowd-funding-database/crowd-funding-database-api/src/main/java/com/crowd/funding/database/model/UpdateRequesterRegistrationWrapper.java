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
 * This class is a wrapper for {@link UpdateRequesterRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UpdateRequesterRegistration
 * @generated
 */
@ProviderType
public class UpdateRequesterRegistrationWrapper
	implements UpdateRequesterRegistration,
		ModelWrapper<UpdateRequesterRegistration> {
	public UpdateRequesterRegistrationWrapper(
		UpdateRequesterRegistration updateRequesterRegistration) {
		_updateRequesterRegistration = updateRequesterRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return UpdateRequesterRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return UpdateRequesterRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_UPDATE_REQUEST_ID",
			getPROJECT_UPDATE_REQUEST_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("UPDATE_REQUESTER_USER_ID", getUPDATE_REQUESTER_USER_ID());
		attributes.put("UPDATE_REQUEST_DATE", getUPDATE_REQUEST_DATE());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_UPDATE_REQUEST_ID = (Long)attributes.get(
				"PROJECT_UPDATE_REQUEST_ID");

		if (PROJECT_UPDATE_REQUEST_ID != null) {
			setPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		Long UPDATE_REQUESTER_USER_ID = (Long)attributes.get(
				"UPDATE_REQUESTER_USER_ID");

		if (UPDATE_REQUESTER_USER_ID != null) {
			setUPDATE_REQUESTER_USER_ID(UPDATE_REQUESTER_USER_ID);
		}

		Date UPDATE_REQUEST_DATE = (Date)attributes.get("UPDATE_REQUEST_DATE");

		if (UPDATE_REQUEST_DATE != null) {
			setUPDATE_REQUEST_DATE(UPDATE_REQUEST_DATE);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new UpdateRequesterRegistrationWrapper((UpdateRequesterRegistration)_updateRequesterRegistration.clone());
	}

	@Override
	public int compareTo(
		UpdateRequesterRegistration updateRequesterRegistration) {
		return _updateRequesterRegistration.compareTo(updateRequesterRegistration);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _updateRequesterRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this update requester registration.
	*
	* @return the primary key of this update requester registration
	*/
	@Override
	public long getPrimaryKey() {
		return _updateRequesterRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _updateRequesterRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_id of this update requester registration.
	*
	* @return the project_id of this update requester registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _updateRequesterRegistration.getPROJECT_ID();
	}

	/**
	* Returns the project_update_request_id of this update requester registration.
	*
	* @return the project_update_request_id of this update requester registration
	*/
	@Override
	public long getPROJECT_UPDATE_REQUEST_ID() {
		return _updateRequesterRegistration.getPROJECT_UPDATE_REQUEST_ID();
	}

	/**
	* Returns the status of this update requester registration.
	*
	* @return the status of this update requester registration
	*/
	@Override
	public int getSTATUS() {
		return _updateRequesterRegistration.getSTATUS();
	}

	/**
	* Returns the update_request_date of this update requester registration.
	*
	* @return the update_request_date of this update requester registration
	*/
	@Override
	public Date getUPDATE_REQUEST_DATE() {
		return _updateRequesterRegistration.getUPDATE_REQUEST_DATE();
	}

	/**
	* Returns the update_requester_user_id of this update requester registration.
	*
	* @return the update_requester_user_id of this update requester registration
	*/
	@Override
	public long getUPDATE_REQUESTER_USER_ID() {
		return _updateRequesterRegistration.getUPDATE_REQUESTER_USER_ID();
	}

	/**
	* Returns the uuid of this update requester registration.
	*
	* @return the uuid of this update requester registration
	*/
	@Override
	public String getUuid() {
		return _updateRequesterRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _updateRequesterRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _updateRequesterRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _updateRequesterRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _updateRequesterRegistration.isNew();
	}

	@Override
	public void persist() {
		_updateRequesterRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_updateRequesterRegistration.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_updateRequesterRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_updateRequesterRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_updateRequesterRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_updateRequesterRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this update requester registration.
	*
	* @param primaryKey the primary key of this update requester registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_updateRequesterRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_updateRequesterRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_id of this update requester registration.
	*
	* @param PROJECT_ID the project_id of this update requester registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_updateRequesterRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the project_update_request_id of this update requester registration.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id of this update requester registration
	*/
	@Override
	public void setPROJECT_UPDATE_REQUEST_ID(long PROJECT_UPDATE_REQUEST_ID) {
		_updateRequesterRegistration.setPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* Sets the status of this update requester registration.
	*
	* @param STATUS the status of this update requester registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_updateRequesterRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the update_request_date of this update requester registration.
	*
	* @param UPDATE_REQUEST_DATE the update_request_date of this update requester registration
	*/
	@Override
	public void setUPDATE_REQUEST_DATE(Date UPDATE_REQUEST_DATE) {
		_updateRequesterRegistration.setUPDATE_REQUEST_DATE(UPDATE_REQUEST_DATE);
	}

	/**
	* Sets the update_requester_user_id of this update requester registration.
	*
	* @param UPDATE_REQUESTER_USER_ID the update_requester_user_id of this update requester registration
	*/
	@Override
	public void setUPDATE_REQUESTER_USER_ID(long UPDATE_REQUESTER_USER_ID) {
		_updateRequesterRegistration.setUPDATE_REQUESTER_USER_ID(UPDATE_REQUESTER_USER_ID);
	}

	/**
	* Sets the uuid of this update requester registration.
	*
	* @param uuid the uuid of this update requester registration
	*/
	@Override
	public void setUuid(String uuid) {
		_updateRequesterRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UpdateRequesterRegistration> toCacheModel() {
		return _updateRequesterRegistration.toCacheModel();
	}

	@Override
	public UpdateRequesterRegistration toEscapedModel() {
		return new UpdateRequesterRegistrationWrapper(_updateRequesterRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _updateRequesterRegistration.toString();
	}

	@Override
	public UpdateRequesterRegistration toUnescapedModel() {
		return new UpdateRequesterRegistrationWrapper(_updateRequesterRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _updateRequesterRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UpdateRequesterRegistrationWrapper)) {
			return false;
		}

		UpdateRequesterRegistrationWrapper updateRequesterRegistrationWrapper = (UpdateRequesterRegistrationWrapper)obj;

		if (Objects.equals(_updateRequesterRegistration,
					updateRequesterRegistrationWrapper._updateRequesterRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public UpdateRequesterRegistration getWrappedModel() {
		return _updateRequesterRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _updateRequesterRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _updateRequesterRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_updateRequesterRegistration.resetOriginalValues();
	}

	private final UpdateRequesterRegistration _updateRequesterRegistration;
}