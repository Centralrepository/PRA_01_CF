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
 * Provides a wrapper for {@link UserRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationLocalService
 * @generated
 */
@ProviderType
public class UserRegistrationLocalServiceWrapper
	implements UserRegistrationLocalService,
		ServiceWrapper<UserRegistrationLocalService> {
	public UserRegistrationLocalServiceWrapper(
		UserRegistrationLocalService userRegistrationLocalService) {
		_userRegistrationLocalService = userRegistrationLocalService;
	}

	/**
	* Adds the user registration to the database. Also notifies the appropriate model listeners.
	*
	* @param userRegistration the user registration
	* @return the user registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.UserRegistration addUserRegistration(
		com.crowd.funding.database.model.UserRegistration userRegistration) {
		return _userRegistrationLocalService.addUserRegistration(userRegistration);
	}

	/**
	* Creates a new user registration with the primary key. Does not add the user registration to the database.
	*
	* @param USER_ID the primary key for the new user registration
	* @return the new user registration
	*/
	@Override
	public com.crowd.funding.database.model.UserRegistration createUserRegistration(
		long USER_ID) {
		return _userRegistrationLocalService.createUserRegistration(USER_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the user registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param USER_ID the primary key of the user registration
	* @return the user registration that was removed
	* @throws PortalException if a user registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.UserRegistration deleteUserRegistration(
		long USER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userRegistrationLocalService.deleteUserRegistration(USER_ID);
	}

	/**
	* Deletes the user registration from the database. Also notifies the appropriate model listeners.
	*
	* @param userRegistration the user registration
	* @return the user registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.UserRegistration deleteUserRegistration(
		com.crowd.funding.database.model.UserRegistration userRegistration) {
		return _userRegistrationLocalService.deleteUserRegistration(userRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userRegistrationLocalService.dynamicQuery();
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
		return _userRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userRegistrationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userRegistrationLocalService.dynamicQuery(dynamicQuery, start,
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
		return _userRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.UserRegistration fetchUserRegistration(
		long USER_ID) {
		return _userRegistrationLocalService.fetchUserRegistration(USER_ID);
	}

	@Override
	public com.crowd.funding.database.model.UserRegistration findByUSER_ID(
		long USER_ID)
		throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
		return _userRegistrationLocalService.findByUSER_ID(USER_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _userRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the user registration with the primary key.
	*
	* @param USER_ID the primary key of the user registration
	* @return the user registration
	* @throws PortalException if a user registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.UserRegistration getUserRegistration(
		long USER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userRegistrationLocalService.getUserRegistration(USER_ID);
	}

	/**
	* Returns a range of all the user registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user registrations
	* @param end the upper bound of the range of user registrations (not inclusive)
	* @return the range of user registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.UserRegistration> getUserRegistrations(
		int start, int end) {
		return _userRegistrationLocalService.getUserRegistrations(start, end);
	}

	/**
	* Returns the number of user registrations.
	*
	* @return the number of user registrations
	*/
	@Override
	public int getUserRegistrationsCount() {
		return _userRegistrationLocalService.getUserRegistrationsCount();
	}

	/**
	* Updates the user registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userRegistration the user registration
	* @return the user registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.UserRegistration updateUserRegistration(
		com.crowd.funding.database.model.UserRegistration userRegistration) {
		return _userRegistrationLocalService.updateUserRegistration(userRegistration);
	}

	@Override
	public UserRegistrationLocalService getWrappedService() {
		return _userRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		UserRegistrationLocalService userRegistrationLocalService) {
		_userRegistrationLocalService = userRegistrationLocalService;
	}

	private UserRegistrationLocalService _userRegistrationLocalService;
}