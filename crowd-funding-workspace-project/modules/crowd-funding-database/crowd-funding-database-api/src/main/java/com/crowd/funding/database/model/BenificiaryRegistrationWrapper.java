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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link BenificiaryRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenificiaryRegistration
 * @generated
 */
@ProviderType
public class BenificiaryRegistrationWrapper implements BenificiaryRegistration,
	ModelWrapper<BenificiaryRegistration> {
	public BenificiaryRegistrationWrapper(
		BenificiaryRegistration benificiaryRegistration) {
		_benificiaryRegistration = benificiaryRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return BenificiaryRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return BenificiaryRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("BENIFICIARY_ID", getBENIFICIARY_ID());
		attributes.put("BENIFICIARY_CATEGORY", getBENIFICIARY_CATEGORY());
		attributes.put("BENIFICIARY_TYPE", getBENIFICIARY_TYPE());
		attributes.put("BENIFICIARY_NAME", getBENIFICIARY_NAME());
		attributes.put("AGE", getAGE());
		attributes.put("GENDER", getGENDER());
		attributes.put("LOCATION", getLOCATION());
		attributes.put("RELATIONSHIP", getRELATIONSHIP());
		attributes.put("RELATIONSHIP_DETAILS", getRELATIONSHIP_DETAILS());
		attributes.put("MEMBERS_NO", getMEMBERS_NO());
		attributes.put("CAUSE_DETAILS", getCAUSE_DETAILS());
		attributes.put("ADDRESS_LINE1", getADDRESS_LINE1());
		attributes.put("ADDRESS_LINE2", getADDRESS_LINE2());
		attributes.put("CITY", getCITY());
		attributes.put("STATE", getSTATE());
		attributes.put("PINCODE", getPINCODE());
		attributes.put("COUNTRY", getCOUNTRY());
		attributes.put("CONTACT_NAME", getCONTACT_NAME());
		attributes.put("CONTACT_NO", getCONTACT_NO());
		attributes.put("ALTERNATE_CONTACT_NO", getALTERNATE_CONTACT_NO());
		attributes.put("EMERGENCY_CONTACT_DETAILS",
			getEMERGENCY_CONTACT_DETAILS());
		attributes.put("IMAGE_TYPE", getIMAGE_TYPE());
		attributes.put("IMAGE", getIMAGE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long BENIFICIARY_ID = (Long)attributes.get("BENIFICIARY_ID");

		if (BENIFICIARY_ID != null) {
			setBENIFICIARY_ID(BENIFICIARY_ID);
		}

		String BENIFICIARY_CATEGORY = (String)attributes.get(
				"BENIFICIARY_CATEGORY");

		if (BENIFICIARY_CATEGORY != null) {
			setBENIFICIARY_CATEGORY(BENIFICIARY_CATEGORY);
		}

		String BENIFICIARY_TYPE = (String)attributes.get("BENIFICIARY_TYPE");

		if (BENIFICIARY_TYPE != null) {
			setBENIFICIARY_TYPE(BENIFICIARY_TYPE);
		}

		String BENIFICIARY_NAME = (String)attributes.get("BENIFICIARY_NAME");

		if (BENIFICIARY_NAME != null) {
			setBENIFICIARY_NAME(BENIFICIARY_NAME);
		}

		Integer AGE = (Integer)attributes.get("AGE");

		if (AGE != null) {
			setAGE(AGE);
		}

		String GENDER = (String)attributes.get("GENDER");

		if (GENDER != null) {
			setGENDER(GENDER);
		}

		String LOCATION = (String)attributes.get("LOCATION");

		if (LOCATION != null) {
			setLOCATION(LOCATION);
		}

		String RELATIONSHIP = (String)attributes.get("RELATIONSHIP");

		if (RELATIONSHIP != null) {
			setRELATIONSHIP(RELATIONSHIP);
		}

		String RELATIONSHIP_DETAILS = (String)attributes.get(
				"RELATIONSHIP_DETAILS");

		if (RELATIONSHIP_DETAILS != null) {
			setRELATIONSHIP_DETAILS(RELATIONSHIP_DETAILS);
		}

		Integer MEMBERS_NO = (Integer)attributes.get("MEMBERS_NO");

		if (MEMBERS_NO != null) {
			setMEMBERS_NO(MEMBERS_NO);
		}

		String CAUSE_DETAILS = (String)attributes.get("CAUSE_DETAILS");

		if (CAUSE_DETAILS != null) {
			setCAUSE_DETAILS(CAUSE_DETAILS);
		}

		String ADDRESS_LINE1 = (String)attributes.get("ADDRESS_LINE1");

		if (ADDRESS_LINE1 != null) {
			setADDRESS_LINE1(ADDRESS_LINE1);
		}

		String ADDRESS_LINE2 = (String)attributes.get("ADDRESS_LINE2");

		if (ADDRESS_LINE2 != null) {
			setADDRESS_LINE2(ADDRESS_LINE2);
		}

		String CITY = (String)attributes.get("CITY");

		if (CITY != null) {
			setCITY(CITY);
		}

		String STATE = (String)attributes.get("STATE");

		if (STATE != null) {
			setSTATE(STATE);
		}

		Integer PINCODE = (Integer)attributes.get("PINCODE");

		if (PINCODE != null) {
			setPINCODE(PINCODE);
		}

		String COUNTRY = (String)attributes.get("COUNTRY");

		if (COUNTRY != null) {
			setCOUNTRY(COUNTRY);
		}

		String CONTACT_NAME = (String)attributes.get("CONTACT_NAME");

		if (CONTACT_NAME != null) {
			setCONTACT_NAME(CONTACT_NAME);
		}

		Long CONTACT_NO = (Long)attributes.get("CONTACT_NO");

		if (CONTACT_NO != null) {
			setCONTACT_NO(CONTACT_NO);
		}

		Long ALTERNATE_CONTACT_NO = (Long)attributes.get("ALTERNATE_CONTACT_NO");

		if (ALTERNATE_CONTACT_NO != null) {
			setALTERNATE_CONTACT_NO(ALTERNATE_CONTACT_NO);
		}

		String EMERGENCY_CONTACT_DETAILS = (String)attributes.get(
				"EMERGENCY_CONTACT_DETAILS");

		if (EMERGENCY_CONTACT_DETAILS != null) {
			setEMERGENCY_CONTACT_DETAILS(EMERGENCY_CONTACT_DETAILS);
		}

		String IMAGE_TYPE = (String)attributes.get("IMAGE_TYPE");

		if (IMAGE_TYPE != null) {
			setIMAGE_TYPE(IMAGE_TYPE);
		}

		Blob IMAGE = (Blob)attributes.get("IMAGE");

		if (IMAGE != null) {
			setIMAGE(IMAGE);
		}
	}

	@Override
	public Object clone() {
		return new BenificiaryRegistrationWrapper((BenificiaryRegistration)_benificiaryRegistration.clone());
	}

	@Override
	public int compareTo(BenificiaryRegistration benificiaryRegistration) {
		return _benificiaryRegistration.compareTo(benificiaryRegistration);
	}

	/**
	* Returns the address_line1 of this benificiary registration.
	*
	* @return the address_line1 of this benificiary registration
	*/
	@Override
	public String getADDRESS_LINE1() {
		return _benificiaryRegistration.getADDRESS_LINE1();
	}

	/**
	* Returns the address_line2 of this benificiary registration.
	*
	* @return the address_line2 of this benificiary registration
	*/
	@Override
	public String getADDRESS_LINE2() {
		return _benificiaryRegistration.getADDRESS_LINE2();
	}

	/**
	* Returns the age of this benificiary registration.
	*
	* @return the age of this benificiary registration
	*/
	@Override
	public int getAGE() {
		return _benificiaryRegistration.getAGE();
	}

	/**
	* Returns the alternate_contact_no of this benificiary registration.
	*
	* @return the alternate_contact_no of this benificiary registration
	*/
	@Override
	public long getALTERNATE_CONTACT_NO() {
		return _benificiaryRegistration.getALTERNATE_CONTACT_NO();
	}

	/**
	* Returns the benificiary_category of this benificiary registration.
	*
	* @return the benificiary_category of this benificiary registration
	*/
	@Override
	public String getBENIFICIARY_CATEGORY() {
		return _benificiaryRegistration.getBENIFICIARY_CATEGORY();
	}

	/**
	* Returns the benificiary_id of this benificiary registration.
	*
	* @return the benificiary_id of this benificiary registration
	*/
	@Override
	public long getBENIFICIARY_ID() {
		return _benificiaryRegistration.getBENIFICIARY_ID();
	}

	/**
	* Returns the benificiary_name of this benificiary registration.
	*
	* @return the benificiary_name of this benificiary registration
	*/
	@Override
	public String getBENIFICIARY_NAME() {
		return _benificiaryRegistration.getBENIFICIARY_NAME();
	}

	/**
	* Returns the benificiary_type of this benificiary registration.
	*
	* @return the benificiary_type of this benificiary registration
	*/
	@Override
	public String getBENIFICIARY_TYPE() {
		return _benificiaryRegistration.getBENIFICIARY_TYPE();
	}

	/**
	* Returns the cause_details of this benificiary registration.
	*
	* @return the cause_details of this benificiary registration
	*/
	@Override
	public String getCAUSE_DETAILS() {
		return _benificiaryRegistration.getCAUSE_DETAILS();
	}

	/**
	* Returns the city of this benificiary registration.
	*
	* @return the city of this benificiary registration
	*/
	@Override
	public String getCITY() {
		return _benificiaryRegistration.getCITY();
	}

	/**
	* Returns the contact_name of this benificiary registration.
	*
	* @return the contact_name of this benificiary registration
	*/
	@Override
	public String getCONTACT_NAME() {
		return _benificiaryRegistration.getCONTACT_NAME();
	}

	/**
	* Returns the contact_no of this benificiary registration.
	*
	* @return the contact_no of this benificiary registration
	*/
	@Override
	public long getCONTACT_NO() {
		return _benificiaryRegistration.getCONTACT_NO();
	}

	/**
	* Returns the country of this benificiary registration.
	*
	* @return the country of this benificiary registration
	*/
	@Override
	public String getCOUNTRY() {
		return _benificiaryRegistration.getCOUNTRY();
	}

	/**
	* Returns the emergency_contact_details of this benificiary registration.
	*
	* @return the emergency_contact_details of this benificiary registration
	*/
	@Override
	public String getEMERGENCY_CONTACT_DETAILS() {
		return _benificiaryRegistration.getEMERGENCY_CONTACT_DETAILS();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _benificiaryRegistration.getExpandoBridge();
	}

	/**
	* Returns the gender of this benificiary registration.
	*
	* @return the gender of this benificiary registration
	*/
	@Override
	public String getGENDER() {
		return _benificiaryRegistration.getGENDER();
	}

	/**
	* Returns the image of this benificiary registration.
	*
	* @return the image of this benificiary registration
	*/
	@Override
	public Blob getIMAGE() {
		return _benificiaryRegistration.getIMAGE();
	}

	/**
	* Returns the image_type of this benificiary registration.
	*
	* @return the image_type of this benificiary registration
	*/
	@Override
	public String getIMAGE_TYPE() {
		return _benificiaryRegistration.getIMAGE_TYPE();
	}

	/**
	* Returns the location of this benificiary registration.
	*
	* @return the location of this benificiary registration
	*/
	@Override
	public String getLOCATION() {
		return _benificiaryRegistration.getLOCATION();
	}

	/**
	* Returns the members_no of this benificiary registration.
	*
	* @return the members_no of this benificiary registration
	*/
	@Override
	public int getMEMBERS_NO() {
		return _benificiaryRegistration.getMEMBERS_NO();
	}

	/**
	* Returns the pincode of this benificiary registration.
	*
	* @return the pincode of this benificiary registration
	*/
	@Override
	public int getPINCODE() {
		return _benificiaryRegistration.getPINCODE();
	}

	/**
	* Returns the primary key of this benificiary registration.
	*
	* @return the primary key of this benificiary registration
	*/
	@Override
	public long getPrimaryKey() {
		return _benificiaryRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _benificiaryRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the relationship of this benificiary registration.
	*
	* @return the relationship of this benificiary registration
	*/
	@Override
	public String getRELATIONSHIP() {
		return _benificiaryRegistration.getRELATIONSHIP();
	}

	/**
	* Returns the relationship_details of this benificiary registration.
	*
	* @return the relationship_details of this benificiary registration
	*/
	@Override
	public String getRELATIONSHIP_DETAILS() {
		return _benificiaryRegistration.getRELATIONSHIP_DETAILS();
	}

	/**
	* Returns the state of this benificiary registration.
	*
	* @return the state of this benificiary registration
	*/
	@Override
	public String getSTATE() {
		return _benificiaryRegistration.getSTATE();
	}

	/**
	* Returns the uuid of this benificiary registration.
	*
	* @return the uuid of this benificiary registration
	*/
	@Override
	public String getUuid() {
		return _benificiaryRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _benificiaryRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _benificiaryRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _benificiaryRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _benificiaryRegistration.isNew();
	}

	@Override
	public void persist() {
		_benificiaryRegistration.persist();
	}

	/**
	* Sets the address_line1 of this benificiary registration.
	*
	* @param ADDRESS_LINE1 the address_line1 of this benificiary registration
	*/
	@Override
	public void setADDRESS_LINE1(String ADDRESS_LINE1) {
		_benificiaryRegistration.setADDRESS_LINE1(ADDRESS_LINE1);
	}

	/**
	* Sets the address_line2 of this benificiary registration.
	*
	* @param ADDRESS_LINE2 the address_line2 of this benificiary registration
	*/
	@Override
	public void setADDRESS_LINE2(String ADDRESS_LINE2) {
		_benificiaryRegistration.setADDRESS_LINE2(ADDRESS_LINE2);
	}

	/**
	* Sets the age of this benificiary registration.
	*
	* @param AGE the age of this benificiary registration
	*/
	@Override
	public void setAGE(int AGE) {
		_benificiaryRegistration.setAGE(AGE);
	}

	/**
	* Sets the alternate_contact_no of this benificiary registration.
	*
	* @param ALTERNATE_CONTACT_NO the alternate_contact_no of this benificiary registration
	*/
	@Override
	public void setALTERNATE_CONTACT_NO(long ALTERNATE_CONTACT_NO) {
		_benificiaryRegistration.setALTERNATE_CONTACT_NO(ALTERNATE_CONTACT_NO);
	}

	/**
	* Sets the benificiary_category of this benificiary registration.
	*
	* @param BENIFICIARY_CATEGORY the benificiary_category of this benificiary registration
	*/
	@Override
	public void setBENIFICIARY_CATEGORY(String BENIFICIARY_CATEGORY) {
		_benificiaryRegistration.setBENIFICIARY_CATEGORY(BENIFICIARY_CATEGORY);
	}

	/**
	* Sets the benificiary_id of this benificiary registration.
	*
	* @param BENIFICIARY_ID the benificiary_id of this benificiary registration
	*/
	@Override
	public void setBENIFICIARY_ID(long BENIFICIARY_ID) {
		_benificiaryRegistration.setBENIFICIARY_ID(BENIFICIARY_ID);
	}

	/**
	* Sets the benificiary_name of this benificiary registration.
	*
	* @param BENIFICIARY_NAME the benificiary_name of this benificiary registration
	*/
	@Override
	public void setBENIFICIARY_NAME(String BENIFICIARY_NAME) {
		_benificiaryRegistration.setBENIFICIARY_NAME(BENIFICIARY_NAME);
	}

	/**
	* Sets the benificiary_type of this benificiary registration.
	*
	* @param BENIFICIARY_TYPE the benificiary_type of this benificiary registration
	*/
	@Override
	public void setBENIFICIARY_TYPE(String BENIFICIARY_TYPE) {
		_benificiaryRegistration.setBENIFICIARY_TYPE(BENIFICIARY_TYPE);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_benificiaryRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the cause_details of this benificiary registration.
	*
	* @param CAUSE_DETAILS the cause_details of this benificiary registration
	*/
	@Override
	public void setCAUSE_DETAILS(String CAUSE_DETAILS) {
		_benificiaryRegistration.setCAUSE_DETAILS(CAUSE_DETAILS);
	}

	/**
	* Sets the city of this benificiary registration.
	*
	* @param CITY the city of this benificiary registration
	*/
	@Override
	public void setCITY(String CITY) {
		_benificiaryRegistration.setCITY(CITY);
	}

	/**
	* Sets the contact_name of this benificiary registration.
	*
	* @param CONTACT_NAME the contact_name of this benificiary registration
	*/
	@Override
	public void setCONTACT_NAME(String CONTACT_NAME) {
		_benificiaryRegistration.setCONTACT_NAME(CONTACT_NAME);
	}

	/**
	* Sets the contact_no of this benificiary registration.
	*
	* @param CONTACT_NO the contact_no of this benificiary registration
	*/
	@Override
	public void setCONTACT_NO(long CONTACT_NO) {
		_benificiaryRegistration.setCONTACT_NO(CONTACT_NO);
	}

	/**
	* Sets the country of this benificiary registration.
	*
	* @param COUNTRY the country of this benificiary registration
	*/
	@Override
	public void setCOUNTRY(String COUNTRY) {
		_benificiaryRegistration.setCOUNTRY(COUNTRY);
	}

	/**
	* Sets the emergency_contact_details of this benificiary registration.
	*
	* @param EMERGENCY_CONTACT_DETAILS the emergency_contact_details of this benificiary registration
	*/
	@Override
	public void setEMERGENCY_CONTACT_DETAILS(String EMERGENCY_CONTACT_DETAILS) {
		_benificiaryRegistration.setEMERGENCY_CONTACT_DETAILS(EMERGENCY_CONTACT_DETAILS);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_benificiaryRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_benificiaryRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_benificiaryRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the gender of this benificiary registration.
	*
	* @param GENDER the gender of this benificiary registration
	*/
	@Override
	public void setGENDER(String GENDER) {
		_benificiaryRegistration.setGENDER(GENDER);
	}

	/**
	* Sets the image of this benificiary registration.
	*
	* @param IMAGE the image of this benificiary registration
	*/
	@Override
	public void setIMAGE(Blob IMAGE) {
		_benificiaryRegistration.setIMAGE(IMAGE);
	}

	/**
	* Sets the image_type of this benificiary registration.
	*
	* @param IMAGE_TYPE the image_type of this benificiary registration
	*/
	@Override
	public void setIMAGE_TYPE(String IMAGE_TYPE) {
		_benificiaryRegistration.setIMAGE_TYPE(IMAGE_TYPE);
	}

	/**
	* Sets the location of this benificiary registration.
	*
	* @param LOCATION the location of this benificiary registration
	*/
	@Override
	public void setLOCATION(String LOCATION) {
		_benificiaryRegistration.setLOCATION(LOCATION);
	}

	/**
	* Sets the members_no of this benificiary registration.
	*
	* @param MEMBERS_NO the members_no of this benificiary registration
	*/
	@Override
	public void setMEMBERS_NO(int MEMBERS_NO) {
		_benificiaryRegistration.setMEMBERS_NO(MEMBERS_NO);
	}

	@Override
	public void setNew(boolean n) {
		_benificiaryRegistration.setNew(n);
	}

	/**
	* Sets the pincode of this benificiary registration.
	*
	* @param PINCODE the pincode of this benificiary registration
	*/
	@Override
	public void setPINCODE(int PINCODE) {
		_benificiaryRegistration.setPINCODE(PINCODE);
	}

	/**
	* Sets the primary key of this benificiary registration.
	*
	* @param primaryKey the primary key of this benificiary registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_benificiaryRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_benificiaryRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the relationship of this benificiary registration.
	*
	* @param RELATIONSHIP the relationship of this benificiary registration
	*/
	@Override
	public void setRELATIONSHIP(String RELATIONSHIP) {
		_benificiaryRegistration.setRELATIONSHIP(RELATIONSHIP);
	}

	/**
	* Sets the relationship_details of this benificiary registration.
	*
	* @param RELATIONSHIP_DETAILS the relationship_details of this benificiary registration
	*/
	@Override
	public void setRELATIONSHIP_DETAILS(String RELATIONSHIP_DETAILS) {
		_benificiaryRegistration.setRELATIONSHIP_DETAILS(RELATIONSHIP_DETAILS);
	}

	/**
	* Sets the state of this benificiary registration.
	*
	* @param STATE the state of this benificiary registration
	*/
	@Override
	public void setSTATE(String STATE) {
		_benificiaryRegistration.setSTATE(STATE);
	}

	/**
	* Sets the uuid of this benificiary registration.
	*
	* @param uuid the uuid of this benificiary registration
	*/
	@Override
	public void setUuid(String uuid) {
		_benificiaryRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<BenificiaryRegistration> toCacheModel() {
		return _benificiaryRegistration.toCacheModel();
	}

	@Override
	public BenificiaryRegistration toEscapedModel() {
		return new BenificiaryRegistrationWrapper(_benificiaryRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _benificiaryRegistration.toString();
	}

	@Override
	public BenificiaryRegistration toUnescapedModel() {
		return new BenificiaryRegistrationWrapper(_benificiaryRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _benificiaryRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BenificiaryRegistrationWrapper)) {
			return false;
		}

		BenificiaryRegistrationWrapper benificiaryRegistrationWrapper = (BenificiaryRegistrationWrapper)obj;

		if (Objects.equals(_benificiaryRegistration,
					benificiaryRegistrationWrapper._benificiaryRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public BenificiaryRegistration getWrappedModel() {
		return _benificiaryRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _benificiaryRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _benificiaryRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_benificiaryRegistration.resetOriginalValues();
	}

	private final BenificiaryRegistration _benificiaryRegistration;
}