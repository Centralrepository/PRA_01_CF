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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.QuestionRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.QuestionRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class QuestionRegistrationSoap implements Serializable {
	public static QuestionRegistrationSoap toSoapModel(
		QuestionRegistration model) {
		QuestionRegistrationSoap soapModel = new QuestionRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_QUESTION_ID(model.getPROJECT_QUESTION_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setQUESTION(model.getQUESTION());
		soapModel.setQUESTION_REQUESTER_USER_ID(model.getQUESTION_REQUESTER_USER_ID());
		soapModel.setQUESTION_DATE(model.getQUESTION_DATE());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static QuestionRegistrationSoap[] toSoapModels(
		QuestionRegistration[] models) {
		QuestionRegistrationSoap[] soapModels = new QuestionRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionRegistrationSoap[][] toSoapModels(
		QuestionRegistration[][] models) {
		QuestionRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionRegistrationSoap[] toSoapModels(
		List<QuestionRegistration> models) {
		List<QuestionRegistrationSoap> soapModels = new ArrayList<QuestionRegistrationSoap>(models.size());

		for (QuestionRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionRegistrationSoap[soapModels.size()]);
	}

	public QuestionRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_QUESTION_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_QUESTION_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_QUESTION_ID() {
		return _PROJECT_QUESTION_ID;
	}

	public void setPROJECT_QUESTION_ID(long PROJECT_QUESTION_ID) {
		_PROJECT_QUESTION_ID = PROJECT_QUESTION_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public String getQUESTION() {
		return _QUESTION;
	}

	public void setQUESTION(String QUESTION) {
		_QUESTION = QUESTION;
	}

	public long getQUESTION_REQUESTER_USER_ID() {
		return _QUESTION_REQUESTER_USER_ID;
	}

	public void setQUESTION_REQUESTER_USER_ID(long QUESTION_REQUESTER_USER_ID) {
		_QUESTION_REQUESTER_USER_ID = QUESTION_REQUESTER_USER_ID;
	}

	public Date getQUESTION_DATE() {
		return _QUESTION_DATE;
	}

	public void setQUESTION_DATE(Date QUESTION_DATE) {
		_QUESTION_DATE = QUESTION_DATE;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _PROJECT_QUESTION_ID;
	private long _PROJECT_ID;
	private String _QUESTION;
	private long _QUESTION_REQUESTER_USER_ID;
	private Date _QUESTION_DATE;
	private int _STATUS;
}