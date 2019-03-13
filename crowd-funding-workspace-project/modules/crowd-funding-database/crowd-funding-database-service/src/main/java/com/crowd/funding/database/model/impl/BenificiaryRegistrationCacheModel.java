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

package com.crowd.funding.database.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.BenificiaryRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BenificiaryRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BenificiaryRegistration
 * @generated
 */
@ProviderType
public class BenificiaryRegistrationCacheModel implements CacheModel<BenificiaryRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BenificiaryRegistrationCacheModel)) {
			return false;
		}

		BenificiaryRegistrationCacheModel benificiaryRegistrationCacheModel = (BenificiaryRegistrationCacheModel)obj;

		if (BENIFICIARY_ID == benificiaryRegistrationCacheModel.BENIFICIARY_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, BENIFICIARY_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", BENIFICIARY_ID=");
		sb.append(BENIFICIARY_ID);
		sb.append(", BENIFICIARY_CATEGORY=");
		sb.append(BENIFICIARY_CATEGORY);
		sb.append(", BENIFICIARY_TYPE=");
		sb.append(BENIFICIARY_TYPE);
		sb.append(", BENIFICIARY_NAME=");
		sb.append(BENIFICIARY_NAME);
		sb.append(", AGE=");
		sb.append(AGE);
		sb.append(", GENDER=");
		sb.append(GENDER);
		sb.append(", LOCATION=");
		sb.append(LOCATION);
		sb.append(", RELATIONSHIP=");
		sb.append(RELATIONSHIP);
		sb.append(", RELATIONSHIP_DETAILS=");
		sb.append(RELATIONSHIP_DETAILS);
		sb.append(", MEMBERS_NO=");
		sb.append(MEMBERS_NO);
		sb.append(", CAUSE_DETAILS=");
		sb.append(CAUSE_DETAILS);
		sb.append(", ADDRESS_LINE1=");
		sb.append(ADDRESS_LINE1);
		sb.append(", ADDRESS_LINE2=");
		sb.append(ADDRESS_LINE2);
		sb.append(", CITY=");
		sb.append(CITY);
		sb.append(", STATE=");
		sb.append(STATE);
		sb.append(", PINCODE=");
		sb.append(PINCODE);
		sb.append(", COUNTRY=");
		sb.append(COUNTRY);
		sb.append(", CONTACT_NAME=");
		sb.append(CONTACT_NAME);
		sb.append(", CONTACT_NO=");
		sb.append(CONTACT_NO);
		sb.append(", ALTERNATE_CONTACT_NO=");
		sb.append(ALTERNATE_CONTACT_NO);
		sb.append(", EMERGENCY_CONTACT_DETAILS=");
		sb.append(EMERGENCY_CONTACT_DETAILS);
		sb.append(", IMAGE_TYPE=");
		sb.append(IMAGE_TYPE);

		return sb.toString();
	}

	@Override
	public BenificiaryRegistration toEntityModel() {
		BenificiaryRegistrationImpl benificiaryRegistrationImpl = new BenificiaryRegistrationImpl();

		if (uuid == null) {
			benificiaryRegistrationImpl.setUuid("");
		}
		else {
			benificiaryRegistrationImpl.setUuid(uuid);
		}

		benificiaryRegistrationImpl.setBENIFICIARY_ID(BENIFICIARY_ID);

		if (BENIFICIARY_CATEGORY == null) {
			benificiaryRegistrationImpl.setBENIFICIARY_CATEGORY("");
		}
		else {
			benificiaryRegistrationImpl.setBENIFICIARY_CATEGORY(BENIFICIARY_CATEGORY);
		}

		if (BENIFICIARY_TYPE == null) {
			benificiaryRegistrationImpl.setBENIFICIARY_TYPE("");
		}
		else {
			benificiaryRegistrationImpl.setBENIFICIARY_TYPE(BENIFICIARY_TYPE);
		}

		if (BENIFICIARY_NAME == null) {
			benificiaryRegistrationImpl.setBENIFICIARY_NAME("");
		}
		else {
			benificiaryRegistrationImpl.setBENIFICIARY_NAME(BENIFICIARY_NAME);
		}

		benificiaryRegistrationImpl.setAGE(AGE);

		if (GENDER == null) {
			benificiaryRegistrationImpl.setGENDER("");
		}
		else {
			benificiaryRegistrationImpl.setGENDER(GENDER);
		}

		if (LOCATION == null) {
			benificiaryRegistrationImpl.setLOCATION("");
		}
		else {
			benificiaryRegistrationImpl.setLOCATION(LOCATION);
		}

		if (RELATIONSHIP == null) {
			benificiaryRegistrationImpl.setRELATIONSHIP("");
		}
		else {
			benificiaryRegistrationImpl.setRELATIONSHIP(RELATIONSHIP);
		}

		if (RELATIONSHIP_DETAILS == null) {
			benificiaryRegistrationImpl.setRELATIONSHIP_DETAILS("");
		}
		else {
			benificiaryRegistrationImpl.setRELATIONSHIP_DETAILS(RELATIONSHIP_DETAILS);
		}

		benificiaryRegistrationImpl.setMEMBERS_NO(MEMBERS_NO);

		if (CAUSE_DETAILS == null) {
			benificiaryRegistrationImpl.setCAUSE_DETAILS("");
		}
		else {
			benificiaryRegistrationImpl.setCAUSE_DETAILS(CAUSE_DETAILS);
		}

		if (ADDRESS_LINE1 == null) {
			benificiaryRegistrationImpl.setADDRESS_LINE1("");
		}
		else {
			benificiaryRegistrationImpl.setADDRESS_LINE1(ADDRESS_LINE1);
		}

		if (ADDRESS_LINE2 == null) {
			benificiaryRegistrationImpl.setADDRESS_LINE2("");
		}
		else {
			benificiaryRegistrationImpl.setADDRESS_LINE2(ADDRESS_LINE2);
		}

		if (CITY == null) {
			benificiaryRegistrationImpl.setCITY("");
		}
		else {
			benificiaryRegistrationImpl.setCITY(CITY);
		}

		if (STATE == null) {
			benificiaryRegistrationImpl.setSTATE("");
		}
		else {
			benificiaryRegistrationImpl.setSTATE(STATE);
		}

		benificiaryRegistrationImpl.setPINCODE(PINCODE);

		if (COUNTRY == null) {
			benificiaryRegistrationImpl.setCOUNTRY("");
		}
		else {
			benificiaryRegistrationImpl.setCOUNTRY(COUNTRY);
		}

		if (CONTACT_NAME == null) {
			benificiaryRegistrationImpl.setCONTACT_NAME("");
		}
		else {
			benificiaryRegistrationImpl.setCONTACT_NAME(CONTACT_NAME);
		}

		benificiaryRegistrationImpl.setCONTACT_NO(CONTACT_NO);
		benificiaryRegistrationImpl.setALTERNATE_CONTACT_NO(ALTERNATE_CONTACT_NO);

		if (EMERGENCY_CONTACT_DETAILS == null) {
			benificiaryRegistrationImpl.setEMERGENCY_CONTACT_DETAILS("");
		}
		else {
			benificiaryRegistrationImpl.setEMERGENCY_CONTACT_DETAILS(EMERGENCY_CONTACT_DETAILS);
		}

		if (IMAGE_TYPE == null) {
			benificiaryRegistrationImpl.setIMAGE_TYPE("");
		}
		else {
			benificiaryRegistrationImpl.setIMAGE_TYPE(IMAGE_TYPE);
		}

		benificiaryRegistrationImpl.resetOriginalValues();

		return benificiaryRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		BENIFICIARY_ID = objectInput.readLong();
		BENIFICIARY_CATEGORY = objectInput.readUTF();
		BENIFICIARY_TYPE = objectInput.readUTF();
		BENIFICIARY_NAME = objectInput.readUTF();

		AGE = objectInput.readInt();
		GENDER = objectInput.readUTF();
		LOCATION = objectInput.readUTF();
		RELATIONSHIP = objectInput.readUTF();
		RELATIONSHIP_DETAILS = objectInput.readUTF();

		MEMBERS_NO = objectInput.readInt();
		CAUSE_DETAILS = objectInput.readUTF();
		ADDRESS_LINE1 = objectInput.readUTF();
		ADDRESS_LINE2 = objectInput.readUTF();
		CITY = objectInput.readUTF();
		STATE = objectInput.readUTF();

		PINCODE = objectInput.readInt();
		COUNTRY = objectInput.readUTF();
		CONTACT_NAME = objectInput.readUTF();

		CONTACT_NO = objectInput.readLong();

		ALTERNATE_CONTACT_NO = objectInput.readLong();
		EMERGENCY_CONTACT_DETAILS = objectInput.readUTF();
		IMAGE_TYPE = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(BENIFICIARY_ID);

		if (BENIFICIARY_CATEGORY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(BENIFICIARY_CATEGORY);
		}

		if (BENIFICIARY_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(BENIFICIARY_TYPE);
		}

		if (BENIFICIARY_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(BENIFICIARY_NAME);
		}

		objectOutput.writeInt(AGE);

		if (GENDER == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(GENDER);
		}

		if (LOCATION == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(LOCATION);
		}

		if (RELATIONSHIP == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RELATIONSHIP);
		}

		if (RELATIONSHIP_DETAILS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RELATIONSHIP_DETAILS);
		}

		objectOutput.writeInt(MEMBERS_NO);

		if (CAUSE_DETAILS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CAUSE_DETAILS);
		}

		if (ADDRESS_LINE1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ADDRESS_LINE1);
		}

		if (ADDRESS_LINE2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ADDRESS_LINE2);
		}

		if (CITY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CITY);
		}

		if (STATE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(STATE);
		}

		objectOutput.writeInt(PINCODE);

		if (COUNTRY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(COUNTRY);
		}

		if (CONTACT_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CONTACT_NAME);
		}

		objectOutput.writeLong(CONTACT_NO);

		objectOutput.writeLong(ALTERNATE_CONTACT_NO);

		if (EMERGENCY_CONTACT_DETAILS == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(EMERGENCY_CONTACT_DETAILS);
		}

		if (IMAGE_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(IMAGE_TYPE);
		}
	}

	public String uuid;
	public long BENIFICIARY_ID;
	public String BENIFICIARY_CATEGORY;
	public String BENIFICIARY_TYPE;
	public String BENIFICIARY_NAME;
	public int AGE;
	public String GENDER;
	public String LOCATION;
	public String RELATIONSHIP;
	public String RELATIONSHIP_DETAILS;
	public int MEMBERS_NO;
	public String CAUSE_DETAILS;
	public String ADDRESS_LINE1;
	public String ADDRESS_LINE2;
	public String CITY;
	public String STATE;
	public int PINCODE;
	public String COUNTRY;
	public String CONTACT_NAME;
	public long CONTACT_NO;
	public long ALTERNATE_CONTACT_NO;
	public String EMERGENCY_CONTACT_DETAILS;
	public String IMAGE_TYPE;
}