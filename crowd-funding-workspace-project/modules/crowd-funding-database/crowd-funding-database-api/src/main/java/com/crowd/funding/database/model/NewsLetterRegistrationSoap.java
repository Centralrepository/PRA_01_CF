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

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.NewsLetterRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.NewsLetterRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class NewsLetterRegistrationSoap implements Serializable {
	public static NewsLetterRegistrationSoap toSoapModel(
		NewsLetterRegistration model) {
		NewsLetterRegistrationSoap soapModel = new NewsLetterRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setNEWS_LETTER_ID(model.getNEWS_LETTER_ID());
		soapModel.setTITLE(model.getTITLE());
		soapModel.setDETAILS(model.getDETAILS());
		soapModel.setDOCUMENT_TYPE(model.getDOCUMENT_TYPE());
		soapModel.setDOCUMENT(model.getDOCUMENT());
		soapModel.setDATE(model.getDATE());

		return soapModel;
	}

	public static NewsLetterRegistrationSoap[] toSoapModels(
		NewsLetterRegistration[] models) {
		NewsLetterRegistrationSoap[] soapModels = new NewsLetterRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NewsLetterRegistrationSoap[][] toSoapModels(
		NewsLetterRegistration[][] models) {
		NewsLetterRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NewsLetterRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NewsLetterRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NewsLetterRegistrationSoap[] toSoapModels(
		List<NewsLetterRegistration> models) {
		List<NewsLetterRegistrationSoap> soapModels = new ArrayList<NewsLetterRegistrationSoap>(models.size());

		for (NewsLetterRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NewsLetterRegistrationSoap[soapModels.size()]);
	}

	public NewsLetterRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _NEWS_LETTER_ID;
	}

	public void setPrimaryKey(long pk) {
		setNEWS_LETTER_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getNEWS_LETTER_ID() {
		return _NEWS_LETTER_ID;
	}

	public void setNEWS_LETTER_ID(long NEWS_LETTER_ID) {
		_NEWS_LETTER_ID = NEWS_LETTER_ID;
	}

	public String getTITLE() {
		return _TITLE;
	}

	public void setTITLE(String TITLE) {
		_TITLE = TITLE;
	}

	public String getDETAILS() {
		return _DETAILS;
	}

	public void setDETAILS(String DETAILS) {
		_DETAILS = DETAILS;
	}

	public String getDOCUMENT_TYPE() {
		return _DOCUMENT_TYPE;
	}

	public void setDOCUMENT_TYPE(String DOCUMENT_TYPE) {
		_DOCUMENT_TYPE = DOCUMENT_TYPE;
	}

	public Blob getDOCUMENT() {
		return _DOCUMENT;
	}

	public void setDOCUMENT(Blob DOCUMENT) {
		_DOCUMENT = DOCUMENT;
	}

	public Date getDATE() {
		return _DATE;
	}

	public void setDATE(Date DATE) {
		_DATE = DATE;
	}

	private String _uuid;
	private long _NEWS_LETTER_ID;
	private String _TITLE;
	private String _DETAILS;
	private String _DOCUMENT_TYPE;
	private Blob _DOCUMENT;
	private Date _DATE;
}