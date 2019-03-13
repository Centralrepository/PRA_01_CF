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
 * Provides a wrapper for {@link SubscriptionRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionRegistrationLocalService
 * @generated
 */
@ProviderType
public class SubscriptionRegistrationLocalServiceWrapper
	implements SubscriptionRegistrationLocalService,
		ServiceWrapper<SubscriptionRegistrationLocalService> {
	public SubscriptionRegistrationLocalServiceWrapper(
		SubscriptionRegistrationLocalService subscriptionRegistrationLocalService) {
		_subscriptionRegistrationLocalService = subscriptionRegistrationLocalService;
	}

	/**
	* Adds the subscription registration to the database. Also notifies the appropriate model listeners.
	*
	* @param subscriptionRegistration the subscription registration
	* @return the subscription registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.SubscriptionRegistration addSubscriptionRegistration(
		com.crowd.funding.database.model.SubscriptionRegistration subscriptionRegistration) {
		return _subscriptionRegistrationLocalService.addSubscriptionRegistration(subscriptionRegistration);
	}

	/**
	* Creates a new subscription registration with the primary key. Does not add the subscription registration to the database.
	*
	* @param SUSCRIBER_ID the primary key for the new subscription registration
	* @return the new subscription registration
	*/
	@Override
	public com.crowd.funding.database.model.SubscriptionRegistration createSubscriptionRegistration(
		long SUSCRIBER_ID) {
		return _subscriptionRegistrationLocalService.createSubscriptionRegistration(SUSCRIBER_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _subscriptionRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the subscription registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration that was removed
	* @throws PortalException if a subscription registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.SubscriptionRegistration deleteSubscriptionRegistration(
		long SUSCRIBER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _subscriptionRegistrationLocalService.deleteSubscriptionRegistration(SUSCRIBER_ID);
	}

	/**
	* Deletes the subscription registration from the database. Also notifies the appropriate model listeners.
	*
	* @param subscriptionRegistration the subscription registration
	* @return the subscription registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.SubscriptionRegistration deleteSubscriptionRegistration(
		com.crowd.funding.database.model.SubscriptionRegistration subscriptionRegistration) {
		return _subscriptionRegistrationLocalService.deleteSubscriptionRegistration(subscriptionRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subscriptionRegistrationLocalService.dynamicQuery();
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
		return _subscriptionRegistrationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _subscriptionRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _subscriptionRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _subscriptionRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _subscriptionRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.SubscriptionRegistration fetchSubscriptionRegistration(
		long SUSCRIBER_ID) {
		return _subscriptionRegistrationLocalService.fetchSubscriptionRegistration(SUSCRIBER_ID);
	}

	@Override
	public com.crowd.funding.database.model.SubscriptionRegistration findByEMAIL(
		String EMAIL)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return _subscriptionRegistrationLocalService.findByEMAIL(EMAIL);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.SubscriptionRegistration> findBySTATUS(
		int STATUS) {
		return _subscriptionRegistrationLocalService.findBySTATUS(STATUS);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _subscriptionRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _subscriptionRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _subscriptionRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _subscriptionRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the subscription registration with the primary key.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration
	* @throws PortalException if a subscription registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.SubscriptionRegistration getSubscriptionRegistration(
		long SUSCRIBER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _subscriptionRegistrationLocalService.getSubscriptionRegistration(SUSCRIBER_ID);
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
	@Override
	public java.util.List<com.crowd.funding.database.model.SubscriptionRegistration> getSubscriptionRegistrations(
		int start, int end) {
		return _subscriptionRegistrationLocalService.getSubscriptionRegistrations(start,
			end);
	}

	/**
	* Returns the number of subscription registrations.
	*
	* @return the number of subscription registrations
	*/
	@Override
	public int getSubscriptionRegistrationsCount() {
		return _subscriptionRegistrationLocalService.getSubscriptionRegistrationsCount();
	}

	/**
	* Updates the subscription registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param subscriptionRegistration the subscription registration
	* @return the subscription registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.SubscriptionRegistration updateSubscriptionRegistration(
		com.crowd.funding.database.model.SubscriptionRegistration subscriptionRegistration) {
		return _subscriptionRegistrationLocalService.updateSubscriptionRegistration(subscriptionRegistration);
	}

	@Override
	public SubscriptionRegistrationLocalService getWrappedService() {
		return _subscriptionRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		SubscriptionRegistrationLocalService subscriptionRegistrationLocalService) {
		_subscriptionRegistrationLocalService = subscriptionRegistrationLocalService;
	}

	private SubscriptionRegistrationLocalService _subscriptionRegistrationLocalService;
}