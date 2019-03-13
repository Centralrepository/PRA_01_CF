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

package com.crowd.funding.database.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImageRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImageRegistrationLocalService
 * @generated
 */
@ProviderType
public class ImageRegistrationLocalServiceWrapper
	implements ImageRegistrationLocalService,
		ServiceWrapper<ImageRegistrationLocalService> {
	public ImageRegistrationLocalServiceWrapper(
		ImageRegistrationLocalService imageRegistrationLocalService) {
		_imageRegistrationLocalService = imageRegistrationLocalService;
	}

	/**
	* Adds the image registration to the database. Also notifies the appropriate model listeners.
	*
	* @param imageRegistration the image registration
	* @return the image registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.ImageRegistration addImageRegistration(
		com.crowd.funding.database.model.ImageRegistration imageRegistration) {
		return _imageRegistrationLocalService.addImageRegistration(imageRegistration);
	}

	/**
	* Creates a new image registration with the primary key. Does not add the image registration to the database.
	*
	* @param PROJECT_IMAGE_ID the primary key for the new image registration
	* @return the new image registration
	*/
	@Override
	public com.crowd.funding.database.model.ImageRegistration createImageRegistration(
		long PROJECT_IMAGE_ID) {
		return _imageRegistrationLocalService.createImageRegistration(PROJECT_IMAGE_ID);
	}

	/**
	* Deletes the image registration from the database. Also notifies the appropriate model listeners.
	*
	* @param imageRegistration the image registration
	* @return the image registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.ImageRegistration deleteImageRegistration(
		com.crowd.funding.database.model.ImageRegistration imageRegistration) {
		return _imageRegistrationLocalService.deleteImageRegistration(imageRegistration);
	}

	/**
	* Deletes the image registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_IMAGE_ID the primary key of the image registration
	* @return the image registration that was removed
	* @throws PortalException if a image registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ImageRegistration deleteImageRegistration(
		long PROJECT_IMAGE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _imageRegistrationLocalService.deleteImageRegistration(PROJECT_IMAGE_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _imageRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _imageRegistrationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _imageRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _imageRegistrationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _imageRegistrationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _imageRegistrationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _imageRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.ImageRegistration fetchImageRegistration(
		long PROJECT_IMAGE_ID) {
		return _imageRegistrationLocalService.fetchImageRegistration(PROJECT_IMAGE_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.ImageRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _imageRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.crowd.funding.database.model.ImageRegistration findByPROJECT_IMAGE_ID(
		long PROJECT_IMAGE_ID)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return _imageRegistrationLocalService.findByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _imageRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.crowd.funding.database.model.ImageRegistrationIMAGEBlobModel getIMAGEBlobModel(
		java.io.Serializable primaryKey) {
		return _imageRegistrationLocalService.getIMAGEBlobModel(primaryKey);
	}

	/**
	* Returns the image registration with the primary key.
	*
	* @param PROJECT_IMAGE_ID the primary key of the image registration
	* @return the image registration
	* @throws PortalException if a image registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ImageRegistration getImageRegistration(
		long PROJECT_IMAGE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _imageRegistrationLocalService.getImageRegistration(PROJECT_IMAGE_ID);
	}

	/**
	* Returns a range of all the image registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of image registrations
	* @param end the upper bound of the range of image registrations (not inclusive)
	* @return the range of image registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.ImageRegistration> getImageRegistrations(
		int start, int end) {
		return _imageRegistrationLocalService.getImageRegistrations(start, end);
	}

	/**
	* Returns the number of image registrations.
	*
	* @return the number of image registrations
	*/
	@Override
	public int getImageRegistrationsCount() {
		return _imageRegistrationLocalService.getImageRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _imageRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _imageRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _imageRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the image registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param imageRegistration the image registration
	* @return the image registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.ImageRegistration updateImageRegistration(
		com.crowd.funding.database.model.ImageRegistration imageRegistration) {
		return _imageRegistrationLocalService.updateImageRegistration(imageRegistration);
	}

	@Override
	public ImageRegistrationLocalService getWrappedService() {
		return _imageRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		ImageRegistrationLocalService imageRegistrationLocalService) {
		_imageRegistrationLocalService = imageRegistrationLocalService;
	}

	private ImageRegistrationLocalService _imageRegistrationLocalService;
}