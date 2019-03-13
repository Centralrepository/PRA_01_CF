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
 * This class is a wrapper for {@link SubscriptionRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionRegistration
 * @generated
 */
@ProviderType
public class SubscriptionRegistrationWrapper implements SubscriptionRegistration,
	ModelWrapper<SubscriptionRegistration> {
	public SubscriptionRegistrationWrapper(
		SubscriptionRegistration subscriptionRegistration) {
		_subscriptionRegistration = subscriptionRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return SubscriptionRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return SubscriptionRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("SUSCRIBER_ID", getSUSCRIBER_ID());
		attributes.put("EMAIL", getEMAIL());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long SUSCRIBER_ID = (Long)attributes.get("SUSCRIBER_ID");

		if (SUSCRIBER_ID != null) {
			setSUSCRIBER_ID(SUSCRIBER_ID);
		}

		String EMAIL = (String)attributes.get("EMAIL");

		if (EMAIL != null) {
			setEMAIL(EMAIL);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new SubscriptionRegistrationWrapper((SubscriptionRegistration)_subscriptionRegistration.clone());
	}

	@Override
	public int compareTo(SubscriptionRegistration subscriptionRegistration) {
		return _subscriptionRegistration.compareTo(subscriptionRegistration);
	}

	/**
	* Returns the email of this subscription registration.
	*
	* @return the email of this subscription registration
	*/
	@Override
	public String getEMAIL() {
		return _subscriptionRegistration.getEMAIL();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _subscriptionRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this subscription registration.
	*
	* @return the primary key of this subscription registration
	*/
	@Override
	public long getPrimaryKey() {
		return _subscriptionRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subscriptionRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this subscription registration.
	*
	* @return the status of this subscription registration
	*/
	@Override
	public int getSTATUS() {
		return _subscriptionRegistration.getSTATUS();
	}

	/**
	* Returns the suscriber_id of this subscription registration.
	*
	* @return the suscriber_id of this subscription registration
	*/
	@Override
	public long getSUSCRIBER_ID() {
		return _subscriptionRegistration.getSUSCRIBER_ID();
	}

	/**
	* Returns the uuid of this subscription registration.
	*
	* @return the uuid of this subscription registration
	*/
	@Override
	public String getUuid() {
		return _subscriptionRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _subscriptionRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _subscriptionRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _subscriptionRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _subscriptionRegistration.isNew();
	}

	@Override
	public void persist() {
		_subscriptionRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subscriptionRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the email of this subscription registration.
	*
	* @param EMAIL the email of this subscription registration
	*/
	@Override
	public void setEMAIL(String EMAIL) {
		_subscriptionRegistration.setEMAIL(EMAIL);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_subscriptionRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_subscriptionRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_subscriptionRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_subscriptionRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this subscription registration.
	*
	* @param primaryKey the primary key of this subscription registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subscriptionRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_subscriptionRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this subscription registration.
	*
	* @param STATUS the status of this subscription registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_subscriptionRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the suscriber_id of this subscription registration.
	*
	* @param SUSCRIBER_ID the suscriber_id of this subscription registration
	*/
	@Override
	public void setSUSCRIBER_ID(long SUSCRIBER_ID) {
		_subscriptionRegistration.setSUSCRIBER_ID(SUSCRIBER_ID);
	}

	/**
	* Sets the uuid of this subscription registration.
	*
	* @param uuid the uuid of this subscription registration
	*/
	@Override
	public void setUuid(String uuid) {
		_subscriptionRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SubscriptionRegistration> toCacheModel() {
		return _subscriptionRegistration.toCacheModel();
	}

	@Override
	public SubscriptionRegistration toEscapedModel() {
		return new SubscriptionRegistrationWrapper(_subscriptionRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _subscriptionRegistration.toString();
	}

	@Override
	public SubscriptionRegistration toUnescapedModel() {
		return new SubscriptionRegistrationWrapper(_subscriptionRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _subscriptionRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SubscriptionRegistrationWrapper)) {
			return false;
		}

		SubscriptionRegistrationWrapper subscriptionRegistrationWrapper = (SubscriptionRegistrationWrapper)obj;

		if (Objects.equals(_subscriptionRegistration,
					subscriptionRegistrationWrapper._subscriptionRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public SubscriptionRegistration getWrappedModel() {
		return _subscriptionRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _subscriptionRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _subscriptionRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_subscriptionRegistration.resetOriginalValues();
	}

	private final SubscriptionRegistration _subscriptionRegistration;
}