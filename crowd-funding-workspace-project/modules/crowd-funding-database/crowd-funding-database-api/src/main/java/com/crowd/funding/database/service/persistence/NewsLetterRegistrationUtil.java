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

package com.crowd.funding.database.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.NewsLetterRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the news letter registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.NewsLetterRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.NewsLetterRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class NewsLetterRegistrationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(NewsLetterRegistration newsLetterRegistration) {
		getPersistence().clearCache(newsLetterRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NewsLetterRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NewsLetterRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NewsLetterRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<NewsLetterRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static NewsLetterRegistration update(
		NewsLetterRegistration newsLetterRegistration) {
		return getPersistence().update(newsLetterRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static NewsLetterRegistration update(
		NewsLetterRegistration newsLetterRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(newsLetterRegistration, serviceContext);
	}

	/**
	* Returns all the news letter registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching news letter registrations
	*/
	public static List<NewsLetterRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the news letter registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of news letter registrations
	* @param end the upper bound of the range of news letter registrations (not inclusive)
	* @return the range of matching news letter registrations
	*/
	public static List<NewsLetterRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the news letter registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of news letter registrations
	* @param end the upper bound of the range of news letter registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching news letter registrations
	*/
	public static List<NewsLetterRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<NewsLetterRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the news letter registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of news letter registrations
	* @param end the upper bound of the range of news letter registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching news letter registrations
	*/
	public static List<NewsLetterRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<NewsLetterRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first news letter registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a matching news letter registration could not be found
	*/
	public static NewsLetterRegistration findByUuid_First(String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first news letter registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	*/
	public static NewsLetterRegistration fetchByUuid_First(String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last news letter registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a matching news letter registration could not be found
	*/
	public static NewsLetterRegistration findByUuid_Last(String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last news letter registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	*/
	public static NewsLetterRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the news letter registrations before and after the current news letter registration in the ordered set where uuid = &#63;.
	*
	* @param NEWS_LETTER_ID the primary key of the current news letter registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	*/
	public static NewsLetterRegistration[] findByUuid_PrevAndNext(
		long NEWS_LETTER_ID, String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(NEWS_LETTER_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the news letter registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of news letter registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching news letter registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the news letter registration where NEWS_LETTER_ID = &#63; or throws a {@link NoSuchNewsLetterRegistrationException} if it could not be found.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @return the matching news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a matching news letter registration could not be found
	*/
	public static NewsLetterRegistration findByNEWS_LETTER_ID(
		long NEWS_LETTER_ID)
		throws com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException {
		return getPersistence().findByNEWS_LETTER_ID(NEWS_LETTER_ID);
	}

	/**
	* Returns the news letter registration where NEWS_LETTER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @return the matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	*/
	public static NewsLetterRegistration fetchByNEWS_LETTER_ID(
		long NEWS_LETTER_ID) {
		return getPersistence().fetchByNEWS_LETTER_ID(NEWS_LETTER_ID);
	}

	/**
	* Returns the news letter registration where NEWS_LETTER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	*/
	public static NewsLetterRegistration fetchByNEWS_LETTER_ID(
		long NEWS_LETTER_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByNEWS_LETTER_ID(NEWS_LETTER_ID, retrieveFromCache);
	}

	/**
	* Removes the news letter registration where NEWS_LETTER_ID = &#63; from the database.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @return the news letter registration that was removed
	*/
	public static NewsLetterRegistration removeByNEWS_LETTER_ID(
		long NEWS_LETTER_ID)
		throws com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException {
		return getPersistence().removeByNEWS_LETTER_ID(NEWS_LETTER_ID);
	}

	/**
	* Returns the number of news letter registrations where NEWS_LETTER_ID = &#63;.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @return the number of matching news letter registrations
	*/
	public static int countByNEWS_LETTER_ID(long NEWS_LETTER_ID) {
		return getPersistence().countByNEWS_LETTER_ID(NEWS_LETTER_ID);
	}

	/**
	* Caches the news letter registration in the entity cache if it is enabled.
	*
	* @param newsLetterRegistration the news letter registration
	*/
	public static void cacheResult(
		NewsLetterRegistration newsLetterRegistration) {
		getPersistence().cacheResult(newsLetterRegistration);
	}

	/**
	* Caches the news letter registrations in the entity cache if it is enabled.
	*
	* @param newsLetterRegistrations the news letter registrations
	*/
	public static void cacheResult(
		List<NewsLetterRegistration> newsLetterRegistrations) {
		getPersistence().cacheResult(newsLetterRegistrations);
	}

	/**
	* Creates a new news letter registration with the primary key. Does not add the news letter registration to the database.
	*
	* @param NEWS_LETTER_ID the primary key for the new news letter registration
	* @return the new news letter registration
	*/
	public static NewsLetterRegistration create(long NEWS_LETTER_ID) {
		return getPersistence().create(NEWS_LETTER_ID);
	}

	/**
	* Removes the news letter registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param NEWS_LETTER_ID the primary key of the news letter registration
	* @return the news letter registration that was removed
	* @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	*/
	public static NewsLetterRegistration remove(long NEWS_LETTER_ID)
		throws com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException {
		return getPersistence().remove(NEWS_LETTER_ID);
	}

	public static NewsLetterRegistration updateImpl(
		NewsLetterRegistration newsLetterRegistration) {
		return getPersistence().updateImpl(newsLetterRegistration);
	}

	/**
	* Returns the news letter registration with the primary key or throws a {@link NoSuchNewsLetterRegistrationException} if it could not be found.
	*
	* @param NEWS_LETTER_ID the primary key of the news letter registration
	* @return the news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	*/
	public static NewsLetterRegistration findByPrimaryKey(long NEWS_LETTER_ID)
		throws com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException {
		return getPersistence().findByPrimaryKey(NEWS_LETTER_ID);
	}

	/**
	* Returns the news letter registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param NEWS_LETTER_ID the primary key of the news letter registration
	* @return the news letter registration, or <code>null</code> if a news letter registration with the primary key could not be found
	*/
	public static NewsLetterRegistration fetchByPrimaryKey(long NEWS_LETTER_ID) {
		return getPersistence().fetchByPrimaryKey(NEWS_LETTER_ID);
	}

	public static java.util.Map<java.io.Serializable, NewsLetterRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the news letter registrations.
	*
	* @return the news letter registrations
	*/
	public static List<NewsLetterRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the news letter registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news letter registrations
	* @param end the upper bound of the range of news letter registrations (not inclusive)
	* @return the range of news letter registrations
	*/
	public static List<NewsLetterRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the news letter registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news letter registrations
	* @param end the upper bound of the range of news letter registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of news letter registrations
	*/
	public static List<NewsLetterRegistration> findAll(int start, int end,
		OrderByComparator<NewsLetterRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the news letter registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of news letter registrations
	* @param end the upper bound of the range of news letter registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of news letter registrations
	*/
	public static List<NewsLetterRegistration> findAll(int start, int end,
		OrderByComparator<NewsLetterRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the news letter registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of news letter registrations.
	*
	* @return the number of news letter registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static NewsLetterRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NewsLetterRegistrationPersistence, NewsLetterRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NewsLetterRegistrationPersistence.class);

		ServiceTracker<NewsLetterRegistrationPersistence, NewsLetterRegistrationPersistence> serviceTracker =
			new ServiceTracker<NewsLetterRegistrationPersistence, NewsLetterRegistrationPersistence>(bundle.getBundleContext(),
				NewsLetterRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}