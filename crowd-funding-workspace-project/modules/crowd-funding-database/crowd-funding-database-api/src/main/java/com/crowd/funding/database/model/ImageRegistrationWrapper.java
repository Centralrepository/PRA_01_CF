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
 * This class is a wrapper for {@link ImageRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageRegistration
 * @generated
 */
@ProviderType
public class ImageRegistrationWrapper implements ImageRegistration,
	ModelWrapper<ImageRegistration> {
	public ImageRegistrationWrapper(ImageRegistration imageRegistration) {
		_imageRegistration = imageRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return ImageRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return ImageRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_IMAGE_ID", getPROJECT_IMAGE_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("IMAGE_NAME", getIMAGE_NAME());
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

		Long PROJECT_IMAGE_ID = (Long)attributes.get("PROJECT_IMAGE_ID");

		if (PROJECT_IMAGE_ID != null) {
			setPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		String IMAGE_NAME = (String)attributes.get("IMAGE_NAME");

		if (IMAGE_NAME != null) {
			setIMAGE_NAME(IMAGE_NAME);
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
		return new ImageRegistrationWrapper((ImageRegistration)_imageRegistration.clone());
	}

	@Override
	public int compareTo(ImageRegistration imageRegistration) {
		return _imageRegistration.compareTo(imageRegistration);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _imageRegistration.getExpandoBridge();
	}

	/**
	* Returns the image of this image registration.
	*
	* @return the image of this image registration
	*/
	@Override
	public Blob getIMAGE() {
		return _imageRegistration.getIMAGE();
	}

	/**
	* Returns the image_name of this image registration.
	*
	* @return the image_name of this image registration
	*/
	@Override
	public String getIMAGE_NAME() {
		return _imageRegistration.getIMAGE_NAME();
	}

	/**
	* Returns the image_type of this image registration.
	*
	* @return the image_type of this image registration
	*/
	@Override
	public String getIMAGE_TYPE() {
		return _imageRegistration.getIMAGE_TYPE();
	}

	/**
	* Returns the primary key of this image registration.
	*
	* @return the primary key of this image registration
	*/
	@Override
	public long getPrimaryKey() {
		return _imageRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _imageRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_id of this image registration.
	*
	* @return the project_id of this image registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _imageRegistration.getPROJECT_ID();
	}

	/**
	* Returns the project_image_id of this image registration.
	*
	* @return the project_image_id of this image registration
	*/
	@Override
	public long getPROJECT_IMAGE_ID() {
		return _imageRegistration.getPROJECT_IMAGE_ID();
	}

	/**
	* Returns the uuid of this image registration.
	*
	* @return the uuid of this image registration
	*/
	@Override
	public String getUuid() {
		return _imageRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _imageRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _imageRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _imageRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _imageRegistration.isNew();
	}

	@Override
	public void persist() {
		_imageRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_imageRegistration.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_imageRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_imageRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_imageRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the image of this image registration.
	*
	* @param IMAGE the image of this image registration
	*/
	@Override
	public void setIMAGE(Blob IMAGE) {
		_imageRegistration.setIMAGE(IMAGE);
	}

	/**
	* Sets the image_name of this image registration.
	*
	* @param IMAGE_NAME the image_name of this image registration
	*/
	@Override
	public void setIMAGE_NAME(String IMAGE_NAME) {
		_imageRegistration.setIMAGE_NAME(IMAGE_NAME);
	}

	/**
	* Sets the image_type of this image registration.
	*
	* @param IMAGE_TYPE the image_type of this image registration
	*/
	@Override
	public void setIMAGE_TYPE(String IMAGE_TYPE) {
		_imageRegistration.setIMAGE_TYPE(IMAGE_TYPE);
	}

	@Override
	public void setNew(boolean n) {
		_imageRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this image registration.
	*
	* @param primaryKey the primary key of this image registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_imageRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_imageRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_id of this image registration.
	*
	* @param PROJECT_ID the project_id of this image registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_imageRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the project_image_id of this image registration.
	*
	* @param PROJECT_IMAGE_ID the project_image_id of this image registration
	*/
	@Override
	public void setPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID) {
		_imageRegistration.setPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);
	}

	/**
	* Sets the uuid of this image registration.
	*
	* @param uuid the uuid of this image registration
	*/
	@Override
	public void setUuid(String uuid) {
		_imageRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ImageRegistration> toCacheModel() {
		return _imageRegistration.toCacheModel();
	}

	@Override
	public ImageRegistration toEscapedModel() {
		return new ImageRegistrationWrapper(_imageRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _imageRegistration.toString();
	}

	@Override
	public ImageRegistration toUnescapedModel() {
		return new ImageRegistrationWrapper(_imageRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _imageRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImageRegistrationWrapper)) {
			return false;
		}

		ImageRegistrationWrapper imageRegistrationWrapper = (ImageRegistrationWrapper)obj;

		if (Objects.equals(_imageRegistration,
					imageRegistrationWrapper._imageRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public ImageRegistration getWrappedModel() {
		return _imageRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _imageRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _imageRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_imageRegistration.resetOriginalValues();
	}

	private final ImageRegistration _imageRegistration;
}