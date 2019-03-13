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
 * Provides the local service utility for UserFollowRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.UserFollowRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserFollowRegistrationLocalService
 * @see com.crowd.funding.database.service.base.UserFollowRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.UserFollowRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserFollowRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.UserFollowRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user follow registration to the database. Also notifies the appropriate model listeners.
	*
	* @param userFollowRegistration the user follow registration
	* @return the user follow registration that was added
	*/
	public static com.crowd.funding.database.model.UserFollowRegistration addUserFollowRegistration(
		com.crowd.funding.database.model.UserFollowRegistration userFollowRegistration) {
		return getService().addUserFollowRegistration(userFollowRegistration);
	}

	/**
	* Creates a new user follow registration with the primary key. Does not add the user follow registration to the database.
	*
	* @param USER_FOLLOW_ID the primary key for the new user follow registration
	* @return the new user follow registration
	*/
	public static com.crowd.funding.database.model.UserFollowRegistration createUserFollowRegistration(
		long USER_FOLLOW_ID) {
		return getService().createUserFollowRegistration(USER_FOLLOW_ID);
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
	* Deletes the user follow registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param USER_FOLLOW_ID the primary key of the user follow registration
	* @return the user follow registration that was removed
	* @throws PortalException if a user follow registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.UserFollowRegistration deleteUserFollowRegistration(
		long USER_FOLLOW_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserFollowRegistration(USER_FOLLOW_ID);
	}

	/**
	* Deletes the user follow registration from the database. Also notifies the appropriate model listeners.
	*
	* @param userFollowRegistration the user follow registration
	* @return the user follow registration that was removed
	*/
	public static com.crowd.funding.database.model.UserFollowRegistration deleteUserFollowRegistration(
		com.crowd.funding.database.model.UserFollowRegistration userFollowRegistration) {
		return getService().deleteUserFollowRegistration(userFollowRegistration);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.crowd.funding.database.model.UserFollowRegistration fetchUserFollowRegistration(
		long USER_FOLLOW_ID) {
		return getService().fetchUserFollowRegistration(USER_FOLLOW_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID) {
		return getService().findByFOLLOWER_USER_ID(FOLLOWER_USER_ID);
	}

	public static com.crowd.funding.database.model.UserFollowRegistration findByUSER_FOLLOW_ID(
		long USER_FOLLOW_ID)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getService().findByUSER_FOLLOW_ID(USER_FOLLOW_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.UserFollowRegistration> findByUSER_ID(
		long USER_ID) {
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
	* Returns the user follow registration with the primary key.
	*
	* @param USER_FOLLOW_ID the primary key of the user follow registration
	* @return the user follow registration
	* @throws PortalException if a user follow registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.UserFollowRegistration getUserFollowRegistration(
		long USER_FOLLOW_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserFollowRegistration(USER_FOLLOW_ID);
	}

	/**
	* Returns a range of all the user follow registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @return the range of user follow registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.UserFollowRegistration> getUserFollowRegistrations(
		int start, int end) {
		return getService().getUserFollowRegistrations(start, end);
	}

	/**
	* Returns the number of user follow registrations.
	*
	* @return the number of user follow registrations
	*/
	public static int getUserFollowRegistrationsCount() {
		return getService().getUserFollowRegistrationsCount();
	}

	/**
	* Updates the user follow registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userFollowRegistration the user follow registration
	* @return the user follow registration that was updated
	*/
	public static com.crowd.funding.database.model.UserFollowRegistration updateUserFollowRegistration(
		com.crowd.funding.database.model.UserFollowRegistration userFollowRegistration) {
		return getService().updateUserFollowRegistration(userFollowRegistration);
	}

	public static UserFollowRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserFollowRegistrationLocalService, UserFollowRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserFollowRegistrationLocalService.class);

		ServiceTracker<UserFollowRegistrationLocalService, UserFollowRegistrationLocalService> serviceTracker =
			new ServiceTracker<UserFollowRegistrationLocalService, UserFollowRegistrationLocalService>(bundle.getBundleContext(),
				UserFollowRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}