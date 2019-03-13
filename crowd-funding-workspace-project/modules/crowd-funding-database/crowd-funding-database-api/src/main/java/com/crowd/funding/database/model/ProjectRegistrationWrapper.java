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
 * This class is a wrapper for {@link ProjectRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectRegistration
 * @generated
 */
@ProviderType
public class ProjectRegistrationWrapper implements ProjectRegistration,
	ModelWrapper<ProjectRegistration> {
	public ProjectRegistrationWrapper(ProjectRegistration projectRegistration) {
		_projectRegistration = projectRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("USER_ID", getUSER_ID());
		attributes.put("BENIFICIARY_ID", getBENIFICIARY_ID());
		attributes.put("TITLE", getTITLE());
		attributes.put("DESCRIPTION", getDESCRIPTION());
		attributes.put("REQUIRED_FUND_AMOUNT", getREQUIRED_FUND_AMOUNT());
		attributes.put("CREATION_DATE", getCREATION_DATE());
		attributes.put("END_DATE", getEND_DATE());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		Long USER_ID = (Long)attributes.get("USER_ID");

		if (USER_ID != null) {
			setUSER_ID(USER_ID);
		}

		Long BENIFICIARY_ID = (Long)attributes.get("BENIFICIARY_ID");

		if (BENIFICIARY_ID != null) {
			setBENIFICIARY_ID(BENIFICIARY_ID);
		}

		String TITLE = (String)attributes.get("TITLE");

		if (TITLE != null) {
			setTITLE(TITLE);
		}

		String DESCRIPTION = (String)attributes.get("DESCRIPTION");

		if (DESCRIPTION != null) {
			setDESCRIPTION(DESCRIPTION);
		}

		Float REQUIRED_FUND_AMOUNT = (Float)attributes.get(
				"REQUIRED_FUND_AMOUNT");

		if (REQUIRED_FUND_AMOUNT != null) {
			setREQUIRED_FUND_AMOUNT(REQUIRED_FUND_AMOUNT);
		}

		Date CREATION_DATE = (Date)attributes.get("CREATION_DATE");

		if (CREATION_DATE != null) {
			setCREATION_DATE(CREATION_DATE);
		}

		Date END_DATE = (Date)attributes.get("END_DATE");

		if (END_DATE != null) {
			setEND_DATE(END_DATE);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new ProjectRegistrationWrapper((ProjectRegistration)_projectRegistration.clone());
	}

	@Override
	public int compareTo(ProjectRegistration projectRegistration) {
		return _projectRegistration.compareTo(projectRegistration);
	}

	/**
	* Returns the benificiary_id of this project registration.
	*
	* @return the benificiary_id of this project registration
	*/
	@Override
	public long getBENIFICIARY_ID() {
		return _projectRegistration.getBENIFICIARY_ID();
	}

	/**
	* Returns the creation_date of this project registration.
	*
	* @return the creation_date of this project registration
	*/
	@Override
	public Date getCREATION_DATE() {
		return _projectRegistration.getCREATION_DATE();
	}

	/**
	* Returns the description of this project registration.
	*
	* @return the description of this project registration
	*/
	@Override
	public String getDESCRIPTION() {
		return _projectRegistration.getDESCRIPTION();
	}

	/**
	* Returns the end_date of this project registration.
	*
	* @return the end_date of this project registration
	*/
	@Override
	public Date getEND_DATE() {
		return _projectRegistration.getEND_DATE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this project registration.
	*
	* @return the primary key of this project registration
	*/
	@Override
	public long getPrimaryKey() {
		return _projectRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_id of this project registration.
	*
	* @return the project_id of this project registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _projectRegistration.getPROJECT_ID();
	}

	/**
	* Returns the required_fund_amount of this project registration.
	*
	* @return the required_fund_amount of this project registration
	*/
	@Override
	public float getREQUIRED_FUND_AMOUNT() {
		return _projectRegistration.getREQUIRED_FUND_AMOUNT();
	}

	/**
	* Returns the status of this project registration.
	*
	* @return the status of this project registration
	*/
	@Override
	public int getSTATUS() {
		return _projectRegistration.getSTATUS();
	}

	/**
	* Returns the title of this project registration.
	*
	* @return the title of this project registration
	*/
	@Override
	public String getTITLE() {
		return _projectRegistration.getTITLE();
	}

	/**
	* Returns the user_id of this project registration.
	*
	* @return the user_id of this project registration
	*/
	@Override
	public long getUSER_ID() {
		return _projectRegistration.getUSER_ID();
	}

	/**
	* Returns the uuid of this project registration.
	*
	* @return the uuid of this project registration
	*/
	@Override
	public String getUuid() {
		return _projectRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _projectRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectRegistration.isNew();
	}

	@Override
	public void persist() {
		_projectRegistration.persist();
	}

	/**
	* Sets the benificiary_id of this project registration.
	*
	* @param BENIFICIARY_ID the benificiary_id of this project registration
	*/
	@Override
	public void setBENIFICIARY_ID(long BENIFICIARY_ID) {
		_projectRegistration.setBENIFICIARY_ID(BENIFICIARY_ID);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the creation_date of this project registration.
	*
	* @param CREATION_DATE the creation_date of this project registration
	*/
	@Override
	public void setCREATION_DATE(Date CREATION_DATE) {
		_projectRegistration.setCREATION_DATE(CREATION_DATE);
	}

	/**
	* Sets the description of this project registration.
	*
	* @param DESCRIPTION the description of this project registration
	*/
	@Override
	public void setDESCRIPTION(String DESCRIPTION) {
		_projectRegistration.setDESCRIPTION(DESCRIPTION);
	}

	/**
	* Sets the end_date of this project registration.
	*
	* @param END_DATE the end_date of this project registration
	*/
	@Override
	public void setEND_DATE(Date END_DATE) {
		_projectRegistration.setEND_DATE(END_DATE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_projectRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this project registration.
	*
	* @param primaryKey the primary key of this project registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_id of this project registration.
	*
	* @param PROJECT_ID the project_id of this project registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_projectRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the required_fund_amount of this project registration.
	*
	* @param REQUIRED_FUND_AMOUNT the required_fund_amount of this project registration
	*/
	@Override
	public void setREQUIRED_FUND_AMOUNT(float REQUIRED_FUND_AMOUNT) {
		_projectRegistration.setREQUIRED_FUND_AMOUNT(REQUIRED_FUND_AMOUNT);
	}

	/**
	* Sets the status of this project registration.
	*
	* @param STATUS the status of this project registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_projectRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the title of this project registration.
	*
	* @param TITLE the title of this project registration
	*/
	@Override
	public void setTITLE(String TITLE) {
		_projectRegistration.setTITLE(TITLE);
	}

	/**
	* Sets the user_id of this project registration.
	*
	* @param USER_ID the user_id of this project registration
	*/
	@Override
	public void setUSER_ID(long USER_ID) {
		_projectRegistration.setUSER_ID(USER_ID);
	}

	/**
	* Sets the uuid of this project registration.
	*
	* @param uuid the uuid of this project registration
	*/
	@Override
	public void setUuid(String uuid) {
		_projectRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectRegistration> toCacheModel() {
		return _projectRegistration.toCacheModel();
	}

	@Override
	public ProjectRegistration toEscapedModel() {
		return new ProjectRegistrationWrapper(_projectRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectRegistration.toString();
	}

	@Override
	public ProjectRegistration toUnescapedModel() {
		return new ProjectRegistrationWrapper(_projectRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectRegistrationWrapper)) {
			return false;
		}

		ProjectRegistrationWrapper projectRegistrationWrapper = (ProjectRegistrationWrapper)obj;

		if (Objects.equals(_projectRegistration,
					projectRegistrationWrapper._projectRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectRegistration getWrappedModel() {
		return _projectRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectRegistration.resetOriginalValues();
	}

	private final ProjectRegistration _projectRegistration;
}