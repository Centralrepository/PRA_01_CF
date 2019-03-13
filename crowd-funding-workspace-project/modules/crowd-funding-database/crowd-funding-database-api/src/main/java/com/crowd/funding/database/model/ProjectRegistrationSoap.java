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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.ProjectRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.ProjectRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class ProjectRegistrationSoap implements Serializable {
	public static ProjectRegistrationSoap toSoapModel(ProjectRegistration model) {
		ProjectRegistrationSoap soapModel = new ProjectRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setUSER_ID(model.getUSER_ID());
		soapModel.setBENIFICIARY_ID(model.getBENIFICIARY_ID());
		soapModel.setTITLE(model.getTITLE());
		soapModel.setDESCRIPTION(model.getDESCRIPTION());
		soapModel.setREQUIRED_FUND_AMOUNT(model.getREQUIRED_FUND_AMOUNT());
		soapModel.setCREATION_DATE(model.getCREATION_DATE());
		soapModel.setEND_DATE(model.getEND_DATE());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static ProjectRegistrationSoap[] toSoapModels(
		ProjectRegistration[] models) {
		ProjectRegistrationSoap[] soapModels = new ProjectRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectRegistrationSoap[][] toSoapModels(
		ProjectRegistration[][] models) {
		ProjectRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectRegistrationSoap[] toSoapModels(
		List<ProjectRegistration> models) {
		List<ProjectRegistrationSoap> soapModels = new ArrayList<ProjectRegistrationSoap>(models.size());

		for (ProjectRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectRegistrationSoap[soapModels.size()]);
	}

	public ProjectRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public long getUSER_ID() {
		return _USER_ID;
	}

	public void setUSER_ID(long USER_ID) {
		_USER_ID = USER_ID;
	}

	public long getBENIFICIARY_ID() {
		return _BENIFICIARY_ID;
	}

	public void setBENIFICIARY_ID(long BENIFICIARY_ID) {
		_BENIFICIARY_ID = BENIFICIARY_ID;
	}

	public String getTITLE() {
		return _TITLE;
	}

	public void setTITLE(String TITLE) {
		_TITLE = TITLE;
	}

	public String getDESCRIPTION() {
		return _DESCRIPTION;
	}

	public void setDESCRIPTION(String DESCRIPTION) {
		_DESCRIPTION = DESCRIPTION;
	}

	public float getREQUIRED_FUND_AMOUNT() {
		return _REQUIRED_FUND_AMOUNT;
	}

	public void setREQUIRED_FUND_AMOUNT(float REQUIRED_FUND_AMOUNT) {
		_REQUIRED_FUND_AMOUNT = REQUIRED_FUND_AMOUNT;
	}

	public Date getCREATION_DATE() {
		return _CREATION_DATE;
	}

	public void setCREATION_DATE(Date CREATION_DATE) {
		_CREATION_DATE = CREATION_DATE;
	}

	public Date getEND_DATE() {
		return _END_DATE;
	}

	public void setEND_DATE(Date END_DATE) {
		_END_DATE = END_DATE;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _PROJECT_ID;
	private long _USER_ID;
	private long _BENIFICIARY_ID;
	private String _TITLE;
	private String _DESCRIPTION;
	private float _REQUIRED_FUND_AMOUNT;
	private Date _CREATION_DATE;
	private Date _END_DATE;
	private int _STATUS;
}