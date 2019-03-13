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
 * This class is a wrapper for {@link FundAccountRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundAccountRegistration
 * @generated
 */
@ProviderType
public class FundAccountRegistrationWrapper implements FundAccountRegistration,
	ModelWrapper<FundAccountRegistration> {
	public FundAccountRegistrationWrapper(
		FundAccountRegistration fundAccountRegistration) {
		_fundAccountRegistration = fundAccountRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return FundAccountRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return FundAccountRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ACCOUNT_ID", getACCOUNT_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("ACCOUNT_NO", getACCOUNT_NO());
		attributes.put("ACCOUNT_HOLDER_NAME", getACCOUNT_HOLDER_NAME());
		attributes.put("IFSC_CODE", getIFSC_CODE());
		attributes.put("UPI_NO", getUPI_NO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ACCOUNT_ID = (Long)attributes.get("ACCOUNT_ID");

		if (ACCOUNT_ID != null) {
			setACCOUNT_ID(ACCOUNT_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		Long ACCOUNT_NO = (Long)attributes.get("ACCOUNT_NO");

		if (ACCOUNT_NO != null) {
			setACCOUNT_NO(ACCOUNT_NO);
		}

		String ACCOUNT_HOLDER_NAME = (String)attributes.get(
				"ACCOUNT_HOLDER_NAME");

		if (ACCOUNT_HOLDER_NAME != null) {
			setACCOUNT_HOLDER_NAME(ACCOUNT_HOLDER_NAME);
		}

		String IFSC_CODE = (String)attributes.get("IFSC_CODE");

		if (IFSC_CODE != null) {
			setIFSC_CODE(IFSC_CODE);
		}

		String UPI_NO = (String)attributes.get("UPI_NO");

		if (UPI_NO != null) {
			setUPI_NO(UPI_NO);
		}
	}

	@Override
	public Object clone() {
		return new FundAccountRegistrationWrapper((FundAccountRegistration)_fundAccountRegistration.clone());
	}

	@Override
	public int compareTo(FundAccountRegistration fundAccountRegistration) {
		return _fundAccountRegistration.compareTo(fundAccountRegistration);
	}

	/**
	* Returns the account_holder_name of this fund account registration.
	*
	* @return the account_holder_name of this fund account registration
	*/
	@Override
	public String getACCOUNT_HOLDER_NAME() {
		return _fundAccountRegistration.getACCOUNT_HOLDER_NAME();
	}

	/**
	* Returns the account_id of this fund account registration.
	*
	* @return the account_id of this fund account registration
	*/
	@Override
	public long getACCOUNT_ID() {
		return _fundAccountRegistration.getACCOUNT_ID();
	}

	/**
	* Returns the account_no of this fund account registration.
	*
	* @return the account_no of this fund account registration
	*/
	@Override
	public long getACCOUNT_NO() {
		return _fundAccountRegistration.getACCOUNT_NO();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _fundAccountRegistration.getExpandoBridge();
	}

	/**
	* Returns the ifsc_code of this fund account registration.
	*
	* @return the ifsc_code of this fund account registration
	*/
	@Override
	public String getIFSC_CODE() {
		return _fundAccountRegistration.getIFSC_CODE();
	}

	/**
	* Returns the primary key of this fund account registration.
	*
	* @return the primary key of this fund account registration
	*/
	@Override
	public long getPrimaryKey() {
		return _fundAccountRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fundAccountRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_id of this fund account registration.
	*
	* @return the project_id of this fund account registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _fundAccountRegistration.getPROJECT_ID();
	}

	/**
	* Returns the upi_no of this fund account registration.
	*
	* @return the upi_no of this fund account registration
	*/
	@Override
	public String getUPI_NO() {
		return _fundAccountRegistration.getUPI_NO();
	}

	/**
	* Returns the uuid of this fund account registration.
	*
	* @return the uuid of this fund account registration
	*/
	@Override
	public String getUuid() {
		return _fundAccountRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _fundAccountRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _fundAccountRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _fundAccountRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _fundAccountRegistration.isNew();
	}

	@Override
	public void persist() {
		_fundAccountRegistration.persist();
	}

	/**
	* Sets the account_holder_name of this fund account registration.
	*
	* @param ACCOUNT_HOLDER_NAME the account_holder_name of this fund account registration
	*/
	@Override
	public void setACCOUNT_HOLDER_NAME(String ACCOUNT_HOLDER_NAME) {
		_fundAccountRegistration.setACCOUNT_HOLDER_NAME(ACCOUNT_HOLDER_NAME);
	}

	/**
	* Sets the account_id of this fund account registration.
	*
	* @param ACCOUNT_ID the account_id of this fund account registration
	*/
	@Override
	public void setACCOUNT_ID(long ACCOUNT_ID) {
		_fundAccountRegistration.setACCOUNT_ID(ACCOUNT_ID);
	}

	/**
	* Sets the account_no of this fund account registration.
	*
	* @param ACCOUNT_NO the account_no of this fund account registration
	*/
	@Override
	public void setACCOUNT_NO(long ACCOUNT_NO) {
		_fundAccountRegistration.setACCOUNT_NO(ACCOUNT_NO);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fundAccountRegistration.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_fundAccountRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_fundAccountRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_fundAccountRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ifsc_code of this fund account registration.
	*
	* @param IFSC_CODE the ifsc_code of this fund account registration
	*/
	@Override
	public void setIFSC_CODE(String IFSC_CODE) {
		_fundAccountRegistration.setIFSC_CODE(IFSC_CODE);
	}

	@Override
	public void setNew(boolean n) {
		_fundAccountRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this fund account registration.
	*
	* @param primaryKey the primary key of this fund account registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fundAccountRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_fundAccountRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_id of this fund account registration.
	*
	* @param PROJECT_ID the project_id of this fund account registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_fundAccountRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the upi_no of this fund account registration.
	*
	* @param UPI_NO the upi_no of this fund account registration
	*/
	@Override
	public void setUPI_NO(String UPI_NO) {
		_fundAccountRegistration.setUPI_NO(UPI_NO);
	}

	/**
	* Sets the uuid of this fund account registration.
	*
	* @param uuid the uuid of this fund account registration
	*/
	@Override
	public void setUuid(String uuid) {
		_fundAccountRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<FundAccountRegistration> toCacheModel() {
		return _fundAccountRegistration.toCacheModel();
	}

	@Override
	public FundAccountRegistration toEscapedModel() {
		return new FundAccountRegistrationWrapper(_fundAccountRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _fundAccountRegistration.toString();
	}

	@Override
	public FundAccountRegistration toUnescapedModel() {
		return new FundAccountRegistrationWrapper(_fundAccountRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _fundAccountRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundAccountRegistrationWrapper)) {
			return false;
		}

		FundAccountRegistrationWrapper fundAccountRegistrationWrapper = (FundAccountRegistrationWrapper)obj;

		if (Objects.equals(_fundAccountRegistration,
					fundAccountRegistrationWrapper._fundAccountRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public FundAccountRegistration getWrappedModel() {
		return _fundAccountRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _fundAccountRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _fundAccountRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_fundAccountRegistration.resetOriginalValues();
	}

	private final FundAccountRegistration _fundAccountRegistration;
}