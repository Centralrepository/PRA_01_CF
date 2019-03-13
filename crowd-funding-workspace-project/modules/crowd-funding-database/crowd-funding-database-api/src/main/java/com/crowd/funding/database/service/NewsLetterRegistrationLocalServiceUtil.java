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
 * Provides the local service utility for NewsLetterRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.NewsLetterRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterRegistrationLocalService
 * @see com.crowd.funding.database.service.base.NewsLetterRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.NewsLetterRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class NewsLetterRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.NewsLetterRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the news letter registration to the database. Also notifies the appropriate model listeners.
	*
	* @param newsLetterRegistration the news letter registration
	* @return the news letter registration that was added
	*/
	public static com.crowd.funding.database.model.NewsLetterRegistration addNewsLetterRegistration(
		com.crowd.funding.database.model.NewsLetterRegistration newsLetterRegistration) {
		return getService().addNewsLetterRegistration(newsLetterRegistration);
	}

	/**
	* Creates a new news letter registration with the primary key. Does not add the news letter registration to the database.
	*
	* @param NEWS_LETTER_ID the primary key for the new news letter registration
	* @return the new news letter registration
	*/
	public static com.crowd.funding.database.model.NewsLetterRegistration createNewsLetterRegistration(
		long NEWS_LETTER_ID) {
		return getService().createNewsLetterRegistration(NEWS_LETTER_ID);
	}

	/**
	* Deletes the news letter registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param NEWS_LETTER_ID the primary key of the news letter registration
	* @return the news letter registration that was removed
	* @throws PortalException if a news letter registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.NewsLetterRegistration deleteNewsLetterRegistration(
		long NEWS_LETTER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteNewsLetterRegistration(NEWS_LETTER_ID);
	}

	/**
	* Deletes the news letter registration from the database. Also notifies the appropriate model listeners.
	*
	* @param newsLetterRegistration the news letter registration
	* @return the news letter registration that was removed
	*/
	public static com.crowd.funding.database.model.NewsLetterRegistration deleteNewsLetterRegistration(
		com.crowd.funding.database.model.NewsLetterRegistration newsLetterRegistration) {
		return getService().deleteNewsLetterRegistration(newsLetterRegistration);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.crowd.funding.database.model.NewsLetterRegistration fetchNewsLetterRegistration(
		long NEWS_LETTER_ID) {
		return getService().fetchNewsLetterRegistration(NEWS_LETTER_ID);
	}

	public static com.crowd.funding.database.model.NewsLetterRegistration findByNEWS_LETTER_ID(
		long NEWS_LETTER_ID)
		throws com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException {
		return getService().findByNEWS_LETTER_ID(NEWS_LETTER_ID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.crowd.funding.database.model.NewsLetterRegistrationDOCUMENTBlobModel getDOCUMENTBlobModel(
		java.io.Serializable primaryKey) {
		return getService().getDOCUMENTBlobModel(primaryKey);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the news letter registration with the primary key.
	*
	* @param NEWS_LETTER_ID the primary key of the news letter registration
	* @return the news letter registration
	* @throws PortalException if a news letter registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.NewsLetterRegistration getNewsLetterRegistration(
		long NEWS_LETTER_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getNewsLetterRegistration(NEWS_LETTER_ID);
	}

	/**
	* Returns a range of all the news letter registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news letter registrations
	* @param end the upper bound of the range of news letter registrations (not inclusive)
	* @return the range of news letter registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.NewsLetterRegistration> getNewsLetterRegistrations(
		int start, int end) {
		return getService().getNewsLetterRegistrations(start, end);
	}

	/**
	* Returns the number of news letter registrations.
	*
	* @return the number of news letter registrations
	*/
	public static int getNewsLetterRegistrationsCount() {
		return getService().getNewsLetterRegistrationsCount();
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
	* Updates the news letter registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newsLetterRegistration the news letter registration
	* @return the news letter registration that was updated
	*/
	public static com.crowd.funding.database.model.NewsLetterRegistration updateNewsLetterRegistration(
		com.crowd.funding.database.model.NewsLetterRegistration newsLetterRegistration) {
		return getService().updateNewsLetterRegistration(newsLetterRegistration);
	}

	public static NewsLetterRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NewsLetterRegistrationLocalService, NewsLetterRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NewsLetterRegistrationLocalService.class);

		ServiceTracker<NewsLetterRegistrationLocalService, NewsLetterRegistrationLocalService> serviceTracker =
			new ServiceTracker<NewsLetterRegistrationLocalService, NewsLetterRegistrationLocalService>(bundle.getBundleContext(),
				NewsLetterRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}