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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.ImageRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.ImageRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class ImageRegistrationSoap implements Serializable {
	public static ImageRegistrationSoap toSoapModel(ImageRegistration model) {
		ImageRegistrationSoap soapModel = new ImageRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_IMAGE_ID(model.getPROJECT_IMAGE_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setIMAGE_NAME(model.getIMAGE_NAME());
		soapModel.setIMAGE_TYPE(model.getIMAGE_TYPE());
		soapModel.setIMAGE(model.getIMAGE());

		return soapModel;
	}

	public static ImageRegistrationSoap[] toSoapModels(
		ImageRegistration[] models) {
		ImageRegistrationSoap[] soapModels = new ImageRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImageRegistrationSoap[][] toSoapModels(
		ImageRegistration[][] models) {
		ImageRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImageRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImageRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImageRegistrationSoap[] toSoapModels(
		List<ImageRegistration> models) {
		List<ImageRegistrationSoap> soapModels = new ArrayList<ImageRegistrationSoap>(models.size());

		for (ImageRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImageRegistrationSoap[soapModels.size()]);
	}

	public ImageRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_IMAGE_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_IMAGE_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_IMAGE_ID() {
		return _PROJECT_IMAGE_ID;
	}

	public void setPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID) {
		_PROJECT_IMAGE_ID = PROJECT_IMAGE_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public String getIMAGE_NAME() {
		return _IMAGE_NAME;
	}

	public void setIMAGE_NAME(String IMAGE_NAME) {
		_IMAGE_NAME = IMAGE_NAME;
	}

	public String getIMAGE_TYPE() {
		return _IMAGE_TYPE;
	}

	public void setIMAGE_TYPE(String IMAGE_TYPE) {
		_IMAGE_TYPE = IMAGE_TYPE;
	}

	public Blob getIMAGE() {
		return _IMAGE;
	}

	public void setIMAGE(Blob IMAGE) {
		_IMAGE = IMAGE;
	}

	private String _uuid;
	private long _PROJECT_IMAGE_ID;
	private long _PROJECT_ID;
	private String _IMAGE_NAME;
	private String _IMAGE_TYPE;
	private Blob _IMAGE;
}