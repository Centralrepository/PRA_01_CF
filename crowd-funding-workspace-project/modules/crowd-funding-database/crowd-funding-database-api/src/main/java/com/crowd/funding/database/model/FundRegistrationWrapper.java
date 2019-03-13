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
 * This class is a wrapper for {@link FundRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundRegistration
 * @generated
 */
@ProviderType
public class FundRegistrationWrapper implements FundRegistration,
	ModelWrapper<FundRegistration> {
	public FundRegistrationWrapper(FundRegistration fundRegistration) {
		_fundRegistration = fundRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return FundRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return FundRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_FUND_ID", getPROJECT_FUND_ID());
		attributes.put("DONOR_ID", getDONOR_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("CURRENCY", getCURRENCY());
		attributes.put("DONATED_AMOUNT", getDONATED_AMOUNT());
		attributes.put("DONOR_USER_ID", getDONOR_USER_ID());
		attributes.put("DONOR_STATUS", getDONOR_STATUS());
		attributes.put("COMMENT", getCOMMENT());
		attributes.put("DONATED_DATE", getDONATED_DATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_FUND_ID = (Long)attributes.get("PROJECT_FUND_ID");

		if (PROJECT_FUND_ID != null) {
			setPROJECT_FUND_ID(PROJECT_FUND_ID);
		}

		Long DONOR_ID = (Long)attributes.get("DONOR_ID");

		if (DONOR_ID != null) {
			setDONOR_ID(DONOR_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		String CURRENCY = (String)attributes.get("CURRENCY");

		if (CURRENCY != null) {
			setCURRENCY(CURRENCY);
		}

		Float DONATED_AMOUNT = (Float)attributes.get("DONATED_AMOUNT");

		if (DONATED_AMOUNT != null) {
			setDONATED_AMOUNT(DONATED_AMOUNT);
		}

		Long DONOR_USER_ID = (Long)attributes.get("DONOR_USER_ID");

		if (DONOR_USER_ID != null) {
			setDONOR_USER_ID(DONOR_USER_ID);
		}

		Integer DONOR_STATUS = (Integer)attributes.get("DONOR_STATUS");

		if (DONOR_STATUS != null) {
			setDONOR_STATUS(DONOR_STATUS);
		}

		String COMMENT = (String)attributes.get("COMMENT");

		if (COMMENT != null) {
			setCOMMENT(COMMENT);
		}

		Date DONATED_DATE = (Date)attributes.get("DONATED_DATE");

		if (DONATED_DATE != null) {
			setDONATED_DATE(DONATED_DATE);
		}
	}

	@Override
	public Object clone() {
		return new FundRegistrationWrapper((FundRegistration)_fundRegistration.clone());
	}

	@Override
	public int compareTo(FundRegistration fundRegistration) {
		return _fundRegistration.compareTo(fundRegistration);
	}

	/**
	* Returns the comment of this fund registration.
	*
	* @return the comment of this fund registration
	*/
	@Override
	public String getCOMMENT() {
		return _fundRegistration.getCOMMENT();
	}

	/**
	* Returns the currency of this fund registration.
	*
	* @return the currency of this fund registration
	*/
	@Override
	public String getCURRENCY() {
		return _fundRegistration.getCURRENCY();
	}

	/**
	* Returns the donated_amount of this fund registration.
	*
	* @return the donated_amount of this fund registration
	*/
	@Override
	public float getDONATED_AMOUNT() {
		return _fundRegistration.getDONATED_AMOUNT();
	}

	/**
	* Returns the donated_date of this fund registration.
	*
	* @return the donated_date of this fund registration
	*/
	@Override
	public Date getDONATED_DATE() {
		return _fundRegistration.getDONATED_DATE();
	}

	/**
	* Returns the donor_id of this fund registration.
	*
	* @return the donor_id of this fund registration
	*/
	@Override
	public long getDONOR_ID() {
		return _fundRegistration.getDONOR_ID();
	}

	/**
	* Returns the donor_status of this fund registration.
	*
	* @return the donor_status of this fund registration
	*/
	@Override
	public int getDONOR_STATUS() {
		return _fundRegistration.getDONOR_STATUS();
	}

	/**
	* Returns the donor_user_id of this fund registration.
	*
	* @return the donor_user_id of this fund registration
	*/
	@Override
	public long getDONOR_USER_ID() {
		return _fundRegistration.getDONOR_USER_ID();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _fundRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this fund registration.
	*
	* @return the primary key of this fund registration
	*/
	@Override
	public long getPrimaryKey() {
		return _fundRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fundRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_fund_id of this fund registration.
	*
	* @return the project_fund_id of this fund registration
	*/
	@Override
	public long getPROJECT_FUND_ID() {
		return _fundRegistration.getPROJECT_FUND_ID();
	}

	/**
	* Returns the project_id of this fund registration.
	*
	* @return the project_id of this fund registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _fundRegistration.getPROJECT_ID();
	}

	/**
	* Returns the uuid of this fund registration.
	*
	* @return the uuid of this fund registration
	*/
	@Override
	public String getUuid() {
		return _fundRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _fundRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _fundRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _fundRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _fundRegistration.isNew();
	}

	@Override
	public void persist() {
		_fundRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fundRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the comment of this fund registration.
	*
	* @param COMMENT the comment of this fund registration
	*/
	@Override
	public void setCOMMENT(String COMMENT) {
		_fundRegistration.setCOMMENT(COMMENT);
	}

	/**
	* Sets the currency of this fund registration.
	*
	* @param CURRENCY the currency of this fund registration
	*/
	@Override
	public void setCURRENCY(String CURRENCY) {
		_fundRegistration.setCURRENCY(CURRENCY);
	}

	/**
	* Sets the donated_amount of this fund registration.
	*
	* @param DONATED_AMOUNT the donated_amount of this fund registration
	*/
	@Override
	public void setDONATED_AMOUNT(float DONATED_AMOUNT) {
		_fundRegistration.setDONATED_AMOUNT(DONATED_AMOUNT);
	}

	/**
	* Sets the donated_date of this fund registration.
	*
	* @param DONATED_DATE the donated_date of this fund registration
	*/
	@Override
	public void setDONATED_DATE(Date DONATED_DATE) {
		_fundRegistration.setDONATED_DATE(DONATED_DATE);
	}

	/**
	* Sets the donor_id of this fund registration.
	*
	* @param DONOR_ID the donor_id of this fund registration
	*/
	@Override
	public void setDONOR_ID(long DONOR_ID) {
		_fundRegistration.setDONOR_ID(DONOR_ID);
	}

	/**
	* Sets the donor_status of this fund registration.
	*
	* @param DONOR_STATUS the donor_status of this fund registration
	*/
	@Override
	public void setDONOR_STATUS(int DONOR_STATUS) {
		_fundRegistration.setDONOR_STATUS(DONOR_STATUS);
	}

	/**
	* Sets the donor_user_id of this fund registration.
	*
	* @param DONOR_USER_ID the donor_user_id of this fund registration
	*/
	@Override
	public void setDONOR_USER_ID(long DONOR_USER_ID) {
		_fundRegistration.setDONOR_USER_ID(DONOR_USER_ID);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_fundRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_fundRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_fundRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_fundRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this fund registration.
	*
	* @param primaryKey the primary key of this fund registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fundRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_fundRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_fund_id of this fund registration.
	*
	* @param PROJECT_FUND_ID the project_fund_id of this fund registration
	*/
	@Override
	public void setPROJECT_FUND_ID(long PROJECT_FUND_ID) {
		_fundRegistration.setPROJECT_FUND_ID(PROJECT_FUND_ID);
	}

	/**
	* Sets the project_id of this fund registration.
	*
	* @param PROJECT_ID the project_id of this fund registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_fundRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the uuid of this fund registration.
	*
	* @param uuid the uuid of this fund registration
	*/
	@Override
	public void setUuid(String uuid) {
		_fundRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<FundRegistration> toCacheModel() {
		return _fundRegistration.toCacheModel();
	}

	@Override
	public FundRegistration toEscapedModel() {
		return new FundRegistrationWrapper(_fundRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _fundRegistration.toString();
	}

	@Override
	public FundRegistration toUnescapedModel() {
		return new FundRegistrationWrapper(_fundRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _fundRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundRegistrationWrapper)) {
			return false;
		}

		FundRegistrationWrapper fundRegistrationWrapper = (FundRegistrationWrapper)obj;

		if (Objects.equals(_fundRegistration,
					fundRegistrationWrapper._fundRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public FundRegistration getWrappedModel() {
		return _fundRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _fundRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _fundRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_fundRegistration.resetOriginalValues();
	}

	private final FundRegistration _fundRegistration;
}