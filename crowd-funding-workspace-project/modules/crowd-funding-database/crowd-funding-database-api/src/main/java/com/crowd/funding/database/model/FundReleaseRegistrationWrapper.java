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
 * This class is a wrapper for {@link FundReleaseRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundReleaseRegistration
 * @generated
 */
@ProviderType
public class FundReleaseRegistrationWrapper implements FundReleaseRegistration,
	ModelWrapper<FundReleaseRegistration> {
	public FundReleaseRegistrationWrapper(
		FundReleaseRegistration fundReleaseRegistration) {
		_fundReleaseRegistration = fundReleaseRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return FundReleaseRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return FundReleaseRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("FUND_RELEASE_ID", getFUND_RELEASE_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("CURRENCY", getCURRENCY());
		attributes.put("AMOUNT", getAMOUNT());
		attributes.put("RELEASE_DATE", getRELEASE_DATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long FUND_RELEASE_ID = (Long)attributes.get("FUND_RELEASE_ID");

		if (FUND_RELEASE_ID != null) {
			setFUND_RELEASE_ID(FUND_RELEASE_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		String CURRENCY = (String)attributes.get("CURRENCY");

		if (CURRENCY != null) {
			setCURRENCY(CURRENCY);
		}

		Float AMOUNT = (Float)attributes.get("AMOUNT");

		if (AMOUNT != null) {
			setAMOUNT(AMOUNT);
		}

		Date RELEASE_DATE = (Date)attributes.get("RELEASE_DATE");

		if (RELEASE_DATE != null) {
			setRELEASE_DATE(RELEASE_DATE);
		}
	}

	@Override
	public Object clone() {
		return new FundReleaseRegistrationWrapper((FundReleaseRegistration)_fundReleaseRegistration.clone());
	}

	@Override
	public int compareTo(FundReleaseRegistration fundReleaseRegistration) {
		return _fundReleaseRegistration.compareTo(fundReleaseRegistration);
	}

	/**
	* Returns the amount of this fund release registration.
	*
	* @return the amount of this fund release registration
	*/
	@Override
	public float getAMOUNT() {
		return _fundReleaseRegistration.getAMOUNT();
	}

	/**
	* Returns the currency of this fund release registration.
	*
	* @return the currency of this fund release registration
	*/
	@Override
	public String getCURRENCY() {
		return _fundReleaseRegistration.getCURRENCY();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _fundReleaseRegistration.getExpandoBridge();
	}

	/**
	* Returns the fund_release_id of this fund release registration.
	*
	* @return the fund_release_id of this fund release registration
	*/
	@Override
	public long getFUND_RELEASE_ID() {
		return _fundReleaseRegistration.getFUND_RELEASE_ID();
	}

	/**
	* Returns the primary key of this fund release registration.
	*
	* @return the primary key of this fund release registration
	*/
	@Override
	public long getPrimaryKey() {
		return _fundReleaseRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fundReleaseRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_id of this fund release registration.
	*
	* @return the project_id of this fund release registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _fundReleaseRegistration.getPROJECT_ID();
	}

	/**
	* Returns the release_date of this fund release registration.
	*
	* @return the release_date of this fund release registration
	*/
	@Override
	public Date getRELEASE_DATE() {
		return _fundReleaseRegistration.getRELEASE_DATE();
	}

	/**
	* Returns the uuid of this fund release registration.
	*
	* @return the uuid of this fund release registration
	*/
	@Override
	public String getUuid() {
		return _fundReleaseRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _fundReleaseRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _fundReleaseRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _fundReleaseRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _fundReleaseRegistration.isNew();
	}

	@Override
	public void persist() {
		_fundReleaseRegistration.persist();
	}

	/**
	* Sets the amount of this fund release registration.
	*
	* @param AMOUNT the amount of this fund release registration
	*/
	@Override
	public void setAMOUNT(float AMOUNT) {
		_fundReleaseRegistration.setAMOUNT(AMOUNT);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fundReleaseRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the currency of this fund release registration.
	*
	* @param CURRENCY the currency of this fund release registration
	*/
	@Override
	public void setCURRENCY(String CURRENCY) {
		_fundReleaseRegistration.setCURRENCY(CURRENCY);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_fundReleaseRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_fundReleaseRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_fundReleaseRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the fund_release_id of this fund release registration.
	*
	* @param FUND_RELEASE_ID the fund_release_id of this fund release registration
	*/
	@Override
	public void setFUND_RELEASE_ID(long FUND_RELEASE_ID) {
		_fundReleaseRegistration.setFUND_RELEASE_ID(FUND_RELEASE_ID);
	}

	@Override
	public void setNew(boolean n) {
		_fundReleaseRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this fund release registration.
	*
	* @param primaryKey the primary key of this fund release registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fundReleaseRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_fundReleaseRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_id of this fund release registration.
	*
	* @param PROJECT_ID the project_id of this fund release registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_fundReleaseRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the release_date of this fund release registration.
	*
	* @param RELEASE_DATE the release_date of this fund release registration
	*/
	@Override
	public void setRELEASE_DATE(Date RELEASE_DATE) {
		_fundReleaseRegistration.setRELEASE_DATE(RELEASE_DATE);
	}

	/**
	* Sets the uuid of this fund release registration.
	*
	* @param uuid the uuid of this fund release registration
	*/
	@Override
	public void setUuid(String uuid) {
		_fundReleaseRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<FundReleaseRegistration> toCacheModel() {
		return _fundReleaseRegistration.toCacheModel();
	}

	@Override
	public FundReleaseRegistration toEscapedModel() {
		return new FundReleaseRegistrationWrapper(_fundReleaseRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _fundReleaseRegistration.toString();
	}

	@Override
	public FundReleaseRegistration toUnescapedModel() {
		return new FundReleaseRegistrationWrapper(_fundReleaseRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _fundReleaseRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundReleaseRegistrationWrapper)) {
			return false;
		}

		FundReleaseRegistrationWrapper fundReleaseRegistrationWrapper = (FundReleaseRegistrationWrapper)obj;

		if (Objects.equals(_fundReleaseRegistration,
					fundReleaseRegistrationWrapper._fundReleaseRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public FundReleaseRegistration getWrappedModel() {
		return _fundReleaseRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _fundReleaseRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _fundReleaseRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_fundReleaseRegistration.resetOriginalValues();
	}

	private final FundReleaseRegistration _fundReleaseRegistration;
}