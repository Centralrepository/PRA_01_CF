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
 * Provides a wrapper for {@link UserOTPRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserOTPRegistrationLocalService
 * @generated
 */
@ProviderType
public class UserOTPRegistrationLocalServiceWrapper
	implements UserOTPRegistrationLocalService,
		ServiceWrapper<UserOTPRegistrationLocalService> {
	public UserOTPRegistrationLocalServiceWrapper(
		UserOTPRegistrationLocalService userOTPRegistrationLocalService) {
		_userOTPRegistrationLocalService = userOTPRegistrationLocalService;
	}

	/**
	* Adds the user otp registration to the database. Also notifies the appropriate model listeners.
	*
	* @param userOTPRegistration the user otp registration
	* @return the user otp registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.UserOTPRegistration addUserOTPRegistration(
		com.crowd.funding.database.model.UserOTPRegistration userOTPRegistration) {
		return _userOTPRegistrationLocalService.addUserOTPRegistration(userOTPRegistration);
	}

	/**
	* Creates a new user otp registration with the primary key. Does not add the user otp registration to the database.
	*
	* @param USER_OTP_ID the primary key for the new user otp registration
	* @return the new user otp registration
	*/
	@Override
	public com.crowd.funding.database.model.UserOTPRegistration createUserOTPRegistration(
		long USER_OTP_ID) {
		return _userOTPRegistrationLocalService.createUserOTPRegistration(USER_OTP_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userOTPRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the user otp registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param USER_OTP_ID the primary key of the user otp registration
	* @return the user otp registration that was removed
	* @throws PortalException if a user otp registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.UserOTPRegistration deleteUserOTPRegistration(
		long USER_OTP_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userOTPRegistrationLocalService.deleteUserOTPRegistration(USER_OTP_ID);
	}

	/**
	* Deletes the user otp registration from the database. Also notifies the appropriate model listeners.
	*
	* @param userOTPRegistration the user otp registration
	* @return the user otp registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.UserOTPRegistration deleteUserOTPRegistration(
		com.crowd.funding.database.model.UserOTPRegistration userOTPRegistration) {
		return _userOTPRegistrationLocalService.deleteUserOTPRegistration(userOTPRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userOTPRegistrationLocalService.dynamicQuery();
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
		return _userOTPRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userOTPRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userOTPRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _userOTPRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userOTPRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.UserOTPRegistration fetchUserOTPRegistration(
		long USER_OTP_ID) {
		return _userOTPRegistrationLocalService.fetchUserOTPRegistration(USER_OTP_ID);
	}

	@Override
	public com.crowd.funding.database.model.UserOTPRegistration findByMOBILE_NO(
		long MOBILE_NO)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return _userOTPRegistrationLocalService.findByMOBILE_NO(MOBILE_NO);
	}

	@Override
	public com.crowd.funding.database.model.UserOTPRegistration findByUSER_OTP_ID(
		long USER_OTP_ID)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return _userOTPRegistrationLocalService.findByUSER_OTP_ID(USER_OTP_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userOTPRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userOTPRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _userOTPRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userOTPRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the user otp registration with the primary key.
	*
	* @param USER_OTP_ID the primary key of the user otp registration
	* @return the user otp registration
	* @throws PortalException if a user otp registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.UserOTPRegistration getUserOTPRegistration(
		long USER_OTP_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userOTPRegistrationLocalService.getUserOTPRegistration(USER_OTP_ID);
	}

	/**
	* Returns a range of all the user otp registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user otp registrations
	* @param end the upper bound of the range of user otp registrations (not inclusive)
	* @return the range of user otp registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.UserOTPRegistration> getUserOTPRegistrations(
		int start, int end) {
		return _userOTPRegistrationLocalService.getUserOTPRegistrations(start,
			end);
	}

	/**
	* Returns the number of user otp registrations.
	*
	* @return the number of user otp registrations
	*/
	@Override
	public int getUserOTPRegistrationsCount() {
		return _userOTPRegistrationLocalService.getUserOTPRegistrationsCount();
	}

	/**
	* Updates the user otp registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userOTPRegistration the user otp registration
	* @return the user otp registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.UserOTPRegistration updateUserOTPRegistration(
		com.crowd.funding.database.model.UserOTPRegistration userOTPRegistration) {
		return _userOTPRegistrationLocalService.updateUserOTPRegistration(userOTPRegistration);
	}

	@Override
	public UserOTPRegistrationLocalService getWrappedService() {
		return _userOTPRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		UserOTPRegistrationLocalService userOTPRegistrationLocalService) {
		_userOTPRegistrationLocalService = userOTPRegistrationLocalService;
	}

	private UserOTPRegistrationLocalService _userOTPRegistrationLocalService;
}