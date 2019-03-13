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
 * Provides the local service utility for SubscriptionRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.SubscriptionRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionRegistrationLocalService
 * @see com.crowd.funding.database.service.base.SubscriptionRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.SubscriptionRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class SubscriptionRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.SubscriptionRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the subscription registration to the database. Also notifies the appropriate model listeners.
	*
	* @param subscriptionRegistration the subscription registration
	* @return the subscription registration that was added
	*/
	public static com.crowd.funding.database.model.SubscriptionRegistration addSubscriptionRegistration(
		com.crowd.funding.database.model.SubscriptionRegistration subscriptionRegistration) {
		return getService().addSubscriptionRegistration(subscriptionRegistration);
	}

	/**
	* Creates a new subscription registration with the primary key. Does not add the subscription registration to the database.
	*
	* @param SUSCRIBER_ID the primary key for the new subscription registration
	* @return the new subscription registration
	*/
	public static com.crowd.funding.database.model.SubscriptionRegistration createSubscriptionRegistration(
		long SUSCRIBER_ID) {
		return getService().createSubscriptionRegistration(SUSCRIBER_ID);
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
	* Deletes the subscription registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration that was removed
	* @throws PortalException if a subscription registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.SubscriptionRegistration deleteSubscriptionRegistration(
		long SUSCRIBER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSubscriptionRegistration(SUSCRIBER_ID);
	}

	/**
	* Deletes the subscription registration from the database. Also notifies the appropriate model listeners.
	*
	* @param subscriptionRegistration the subscription registration
	* @return the subscription registration that was removed
	*/
	public static com.crowd.funding.database.model.SubscriptionRegistration deleteSubscriptionRegistration(
		com.crowd.funding.database.model.SubscriptionRegistration subscriptionRegistration) {
		return getService()
				   .deleteSubscriptionRegistration(subscriptionRegistration);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.crowd.funding.database.model.SubscriptionRegistration fetchSubscriptionRegistration(
		long SUSCRIBER_ID) {
		return getService().fetchSubscriptionRegistration(SUSCRIBER_ID);
	}

	public static com.crowd.funding.database.model.SubscriptionRegistration findByEMAIL(
		String EMAIL)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getService().findByEMAIL(EMAIL);
	}

	public static java.util.List<com.crowd.funding.database.model.SubscriptionRegistration> findBySTATUS(
		int STATUS) {
		return getService().findBySTATUS(STATUS);
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
	* Returns the subscription registration with the primary key.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration
	* @throws PortalException if a subscription registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.SubscriptionRegistration getSubscriptionRegistration(
		long SUSCRIBER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSubscriptionRegistration(SUSCRIBER_ID);
	}

	/**
	* Returns a range of all the subscription registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @return the range of subscription registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.SubscriptionRegistration> getSubscriptionRegistrations(
		int start, int end) {
		return getService().getSubscriptionRegistrations(start, end);
	}

	/**
	* Returns the number of subscription registrations.
	*
	* @return the number of subscription registrations
	*/
	public static int getSubscriptionRegistrationsCount() {
		return getService().getSubscriptionRegistrationsCount();
	}

	/**
	* Updates the subscription registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subscriptionRegistration the subscription registration
	* @return the subscription registration that was updated
	*/
	public static com.crowd.funding.database.model.SubscriptionRegistration updateSubscriptionRegistration(
		com.crowd.funding.database.model.SubscriptionRegistration subscriptionRegistration) {
		return getService()
				   .updateSubscriptionRegistration(subscriptionRegistration);
	}

	public static SubscriptionRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SubscriptionRegistrationLocalService, SubscriptionRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SubscriptionRegistrationLocalService.class);

		ServiceTracker<SubscriptionRegistrationLocalService, SubscriptionRegistrationLocalService> serviceTracker =
			new ServiceTracker<SubscriptionRegistrationLocalService, SubscriptionRegistrationLocalService>(bundle.getBundleContext(),
				SubscriptionRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}