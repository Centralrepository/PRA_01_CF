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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.CommentRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.CommentRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class CommentRegistrationSoap implements Serializable {
	public static CommentRegistrationSoap toSoapModel(CommentRegistration model) {
		CommentRegistrationSoap soapModel = new CommentRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_COMMENT_ID(model.getPROJECT_COMMENT_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setCOMMENT(model.getCOMMENT());
		soapModel.setANSWER(model.getANSWER());
		soapModel.setDONOR_USER_ID(model.getDONOR_USER_ID());
		soapModel.setCOMMENT_DATE(model.getCOMMENT_DATE());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static CommentRegistrationSoap[] toSoapModels(
		CommentRegistration[] models) {
		CommentRegistrationSoap[] soapModels = new CommentRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommentRegistrationSoap[][] toSoapModels(
		CommentRegistration[][] models) {
		CommentRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommentRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommentRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommentRegistrationSoap[] toSoapModels(
		List<CommentRegistration> models) {
		List<CommentRegistrationSoap> soapModels = new ArrayList<CommentRegistrationSoap>(models.size());

		for (CommentRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommentRegistrationSoap[soapModels.size()]);
	}

	public CommentRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_COMMENT_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_COMMENT_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_COMMENT_ID() {
		return _PROJECT_COMMENT_ID;
	}

	public void setPROJECT_COMMENT_ID(long PROJECT_COMMENT_ID) {
		_PROJECT_COMMENT_ID = PROJECT_COMMENT_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public String getCOMMENT() {
		return _COMMENT;
	}

	public void setCOMMENT(String COMMENT) {
		_COMMENT = COMMENT;
	}

	public String getANSWER() {
		return _ANSWER;
	}

	public void setANSWER(String ANSWER) {
		_ANSWER = ANSWER;
	}

	public long getDONOR_USER_ID() {
		return _DONOR_USER_ID;
	}

	public void setDONOR_USER_ID(long DONOR_USER_ID) {
		_DONOR_USER_ID = DONOR_USER_ID;
	}

	public Date getCOMMENT_DATE() {
		return _COMMENT_DATE;
	}

	public void setCOMMENT_DATE(Date COMMENT_DATE) {
		_COMMENT_DATE = COMMENT_DATE;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _PROJECT_COMMENT_ID;
	private long _PROJECT_ID;
	private String _COMMENT;
	private String _ANSWER;
	private long _DONOR_USER_ID;
	private Date _COMMENT_DATE;
	private int _STATUS;
}