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
 * Provides a wrapper for {@link UpdateRequesterRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UpdateRequesterRegistrationLocalService
 * @generated
 */
@ProviderType
public class UpdateRequesterRegistrationLocalServiceWrapper
	implements UpdateRequesterRegistrationLocalService,
		ServiceWrapper<UpdateRequesterRegistrationLocalService> {
	public UpdateRequesterRegistrationLocalServiceWrapper(
		UpdateRequesterRegistrationLocalService updateRequesterRegistrationLocalService) {
		_updateRequesterRegistrationLocalService = updateRequesterRegistrationLocalService;
	}

	/**
	* Adds the update requester registration to the database. Also notifies the appropriate model listeners.
	*
	* @param updateRequesterRegistration the update requester registration
	* @return the update requester registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.UpdateRequesterRegistration addUpdateRequesterRegistration(
		com.crowd.funding.database.model.UpdateRequesterRegistration updateRequesterRegistration) {
		return _updateRequesterRegistrationLocalService.addUpdateRequesterRegistration(updateRequesterRegistration);
	}

	/**
	* Creates a new update requester registration with the primary key. Does not add the update requester registration to the database.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key for the new update requester registration
	* @return the new update requester registration
	*/
	@Override
	public com.crowd.funding.database.model.UpdateRequesterRegistration createUpdateRequesterRegistration(
		long PROJECT_UPDATE_REQUEST_ID) {
		return _updateRequesterRegistrationLocalService.createUpdateRequesterRegistration(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _updateRequesterRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the update requester registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	* @return the update requester registration that was removed
	* @throws PortalException if a update requester registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.UpdateRequesterRegistration deleteUpdateRequesterRegistration(
		long PROJECT_UPDATE_REQUEST_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _updateRequesterRegistrationLocalService.deleteUpdateRequesterRegistration(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* Deletes the update requester registration from the database. Also notifies the appropriate model listeners.
	*
	* @param updateRequesterRegistration the update requester registration
	* @return the update requester registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.UpdateRequesterRegistration deleteUpdateRequesterRegistration(
		com.crowd.funding.database.model.UpdateRequesterRegistration updateRequesterRegistration) {
		return _updateRequesterRegistrationLocalService.deleteUpdateRequesterRegistration(updateRequesterRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _updateRequesterRegistrationLocalService.dynamicQuery();
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
		return _updateRequesterRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _updateRequesterRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _updateRequesterRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _updateRequesterRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _updateRequesterRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.UpdateRequesterRegistration fetchUpdateRequesterRegistration(
		long PROJECT_UPDATE_REQUEST_ID) {
		return _updateRequesterRegistrationLocalService.fetchUpdateRequesterRegistration(PROJECT_UPDATE_REQUEST_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.UpdateRequesterRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _updateRequesterRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.crowd.funding.database.model.UpdateRequesterRegistration findByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return _updateRequesterRegistrationLocalService.findByPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _updateRequesterRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _updateRequesterRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _updateRequesterRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _updateRequesterRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the update requester registration with the primary key.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	* @return the update requester registration
	* @throws PortalException if a update requester registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.UpdateRequesterRegistration getUpdateRequesterRegistration(
		long PROJECT_UPDATE_REQUEST_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _updateRequesterRegistrationLocalService.getUpdateRequesterRegistration(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* Returns a range of all the update requester registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @return the range of update requester registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.UpdateRequesterRegistration> getUpdateRequesterRegistrations(
		int start, int end) {
		return _updateRequesterRegistrationLocalService.getUpdateRequesterRegistrations(start,
			end);
	}

	/**
	* Returns the number of update requester registrations.
	*
	* @return the number of update requester registrations
	*/
	@Override
	public int getUpdateRequesterRegistrationsCount() {
		return _updateRequesterRegistrationLocalService.getUpdateRequesterRegistrationsCount();
	}

	/**
	* Updates the update requester registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param updateRequesterRegistration the update requester registration
	* @return the update requester registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.UpdateRequesterRegistration updateUpdateRequesterRegistration(
		com.crowd.funding.database.model.UpdateRequesterRegistration updateRequesterRegistration) {
		return _updateRequesterRegistrationLocalService.updateUpdateRequesterRegistration(updateRequesterRegistration);
	}

	@Override
	public UpdateRequesterRegistrationLocalService getWrappedService() {
		return _updateRequesterRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		UpdateRequesterRegistrationLocalService updateRequesterRegistrationLocalService) {
		_updateRequesterRegistrationLocalService = updateRequesterRegistrationLocalService;
	}

	private UpdateRequesterRegistrationLocalService _updateRequesterRegistrationLocalService;
}