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

import com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException;
import com.crowd.funding.database.model.NewsLetterRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the news letter registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.NewsLetterRegistrationPersistenceImpl
 * @see NewsLetterRegistrationUtil
 * @generated
 */
@ProviderType
public interface NewsLetterRegistrationPersistence extends BasePersistence<NewsLetterRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsLetterRegistrationUtil} to access the news letter registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the news letter registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching news letter registrations
	*/
	public java.util.List<NewsLetterRegistration> findByUuid(String uuid);

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
	public java.util.List<NewsLetterRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<NewsLetterRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsLetterRegistration> orderByComparator);

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
	public java.util.List<NewsLetterRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsLetterRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first news letter registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a matching news letter registration could not be found
	*/
	public NewsLetterRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsLetterRegistration> orderByComparator)
		throws NoSuchNewsLetterRegistrationException;

	/**
	* Returns the first news letter registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	*/
	public NewsLetterRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsLetterRegistration> orderByComparator);

	/**
	* Returns the last news letter registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a matching news letter registration could not be found
	*/
	public NewsLetterRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsLetterRegistration> orderByComparator)
		throws NoSuchNewsLetterRegistrationException;

	/**
	* Returns the last news letter registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	*/
	public NewsLetterRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsLetterRegistration> orderByComparator);

	/**
	* Returns the news letter registrations before and after the current news letter registration in the ordered set where uuid = &#63;.
	*
	* @param NEWS_LETTER_ID the primary key of the current news letter registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	*/
	public NewsLetterRegistration[] findByUuid_PrevAndNext(
		long NEWS_LETTER_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsLetterRegistration> orderByComparator)
		throws NoSuchNewsLetterRegistrationException;

	/**
	* Removes all the news letter registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of news letter registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching news letter registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the news letter registration where NEWS_LETTER_ID = &#63; or throws a {@link NoSuchNewsLetterRegistrationException} if it could not be found.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @return the matching news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a matching news letter registration could not be found
	*/
	public NewsLetterRegistration findByNEWS_LETTER_ID(long NEWS_LETTER_ID)
		throws NoSuchNewsLetterRegistrationException;

	/**
	* Returns the news letter registration where NEWS_LETTER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @return the matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	*/
	public NewsLetterRegistration fetchByNEWS_LETTER_ID(long NEWS_LETTER_ID);

	/**
	* Returns the news letter registration where NEWS_LETTER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	*/
	public NewsLetterRegistration fetchByNEWS_LETTER_ID(long NEWS_LETTER_ID,
		boolean retrieveFromCache);

	/**
	* Removes the news letter registration where NEWS_LETTER_ID = &#63; from the database.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @return the news letter registration that was removed
	*/
	public NewsLetterRegistration removeByNEWS_LETTER_ID(long NEWS_LETTER_ID)
		throws NoSuchNewsLetterRegistrationException;

	/**
	* Returns the number of news letter registrations where NEWS_LETTER_ID = &#63;.
	*
	* @param NEWS_LETTER_ID the news_letter_id
	* @return the number of matching news letter registrations
	*/
	public int countByNEWS_LETTER_ID(long NEWS_LETTER_ID);

	/**
	* Caches the news letter registration in the entity cache if it is enabled.
	*
	* @param newsLetterRegistration the news letter registration
	*/
	public void cacheResult(NewsLetterRegistration newsLetterRegistration);

	/**
	* Caches the news letter registrations in the entity cache if it is enabled.
	*
	* @param newsLetterRegistrations the news letter registrations
	*/
	public void cacheResult(
		java.util.List<NewsLetterRegistration> newsLetterRegistrations);

	/**
	* Creates a new news letter registration with the primary key. Does not add the news letter registration to the database.
	*
	* @param NEWS_LETTER_ID the primary key for the new news letter registration
	* @return the new news letter registration
	*/
	public NewsLetterRegistration create(long NEWS_LETTER_ID);

	/**
	* Removes the news letter registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param NEWS_LETTER_ID the primary key of the news letter registration
	* @return the news letter registration that was removed
	* @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	*/
	public NewsLetterRegistration remove(long NEWS_LETTER_ID)
		throws NoSuchNewsLetterRegistrationException;

	public NewsLetterRegistration updateImpl(
		NewsLetterRegistration newsLetterRegistration);

	/**
	* Returns the news letter registration with the primary key or throws a {@link NoSuchNewsLetterRegistrationException} if it could not be found.
	*
	* @param NEWS_LETTER_ID the primary key of the news letter registration
	* @return the news letter registration
	* @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	*/
	public NewsLetterRegistration findByPrimaryKey(long NEWS_LETTER_ID)
		throws NoSuchNewsLetterRegistrationException;

	/**
	* Returns the news letter registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param NEWS_LETTER_ID the primary key of the news letter registration
	* @return the news letter registration, or <code>null</code> if a news letter registration with the primary key could not be found
	*/
	public NewsLetterRegistration fetchByPrimaryKey(long NEWS_LETTER_ID);

	@Override
	public java.util.Map<java.io.Serializable, NewsLetterRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the news letter registrations.
	*
	* @return the news letter registrations
	*/
	public java.util.List<NewsLetterRegistration> findAll();

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
	public java.util.List<NewsLetterRegistration> findAll(int start, int end);

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
	public java.util.List<NewsLetterRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsLetterRegistration> orderByComparator);

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
	public java.util.List<NewsLetterRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsLetterRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the news letter registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of news letter registrations.
	*
	* @return the number of news letter registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}