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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.UserRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationLocalService
 * @see com.crowd.funding.database.service.base.UserRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.UserRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.UserRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user registration to the database. Also notifies the appropriate model listeners.
	*
	* @param userRegistration the user registration
	* @return the user registration that was added
	*/
	public static com.crowd.funding.database.model.UserRegistration addUserRegistration(
		com.crowd.funding.database.model.UserRegistration userRegistration) {
		return getService().addUserRegistration(userRegistration);
	}

	/**
	* Creates a new user registration with the primary key. Does not add the user registration to the database.
	*
	* @param USER_ID the primary key for the new user registration
	* @return the new user registration
	*/
	public static com.crowd.funding.database.model.UserRegistration createUserRegistration(
		long USER_ID) {
		return getService().createUserRegistration(USER_ID);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the user registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param USER_ID the primary key of the user registration
	* @return the user registration that was removed
	* @throws PortalException if a user registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.UserRegistration deleteUserRegistration(
		long USER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserRegistration(USER_ID);
	}

	/**
	* Deletes the user registration from the database. Also notifies the appropriate model listeners.
	*
	* @param userRegistration the user registration
	* @return the user registration that was removed
	*/
	public static com.crowd.funding.database.model.UserRegistration deleteUserRegistration(
		com.crowd.funding.database.model.UserRegistration userRegistration) {
		return getService().deleteUserRegistration(userRegistration);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.crowd.funding.database.model.UserRegistration fetchUserRegistration(
		long USER_ID) {
		return getService().fetchUserRegistration(USER_ID);
	}

	public static com.crowd.funding.database.model.UserRegistration findByUSER_ID(
		long USER_ID)
		throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
		return getService().findByUSER_ID(USER_ID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the user registration with the primary key.
	*
	* @param USER_ID the primary key of the user registration
	* @return the user registration
	* @throws PortalException if a user registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.UserRegistration getUserRegistration(
		long USER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserRegistration(USER_ID);
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
	public static java.util.List<com.crowd.funding.database.model.UserRegistration> getUserRegistrations(
		int start, int end) {
		return getService().getUserRegistrations(start, end);
	}

	/**
	* Returns the number of user registrations.
	*
	* @return the number of user registrations
	*/
	public static int getUserRegistrationsCount() {
		return getService().getUserRegistrationsCount();
	}

	/**
	* Updates the user registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userRegistration the user registration
	* @return the user registration that was updated
	*/
	public static com.crowd.funding.database.model.UserRegistration updateUserRegistration(
		com.crowd.funding.database.model.UserRegistration userRegistration) {
		return getService().updateUserRegistration(userRegistration);
	}

	public static UserRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserRegistrationLocalService, UserRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserRegistrationLocalService.class);

		ServiceTracker<UserRegistrationLocalService, UserRegistrationLocalService> serviceTracker =
			new ServiceTracker<UserRegistrationLocalService, UserRegistrationLocalService>(bundle.getBundleContext(),
				UserRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}