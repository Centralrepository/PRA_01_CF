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

import com.crowd.funding.database.model.SubscriptionRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the subscription registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.SubscriptionRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.SubscriptionRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class SubscriptionRegistrationUtil {
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
	public static void clearCache(
		SubscriptionRegistration subscriptionRegistration) {
		getPersistence().clearCache(subscriptionRegistration);
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
	public static List<SubscriptionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubscriptionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubscriptionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SubscriptionRegistration update(
		SubscriptionRegistration subscriptionRegistration) {
		return getPersistence().update(subscriptionRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SubscriptionRegistration update(
		SubscriptionRegistration subscriptionRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(subscriptionRegistration, serviceContext);
	}

	/**
	* Returns all the subscription registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching subscription registrations
	*/
	public static List<SubscriptionRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the subscription registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @return the range of matching subscription registrations
	*/
	public static List<SubscriptionRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the subscription registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subscription registrations
	*/
	public static List<SubscriptionRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the subscription registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching subscription registrations
	*/
	public static List<SubscriptionRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<SubscriptionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first subscription registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration findByUuid_First(String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first subscription registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration fetchByUuid_First(String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last subscription registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration findByUuid_Last(String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last subscription registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the subscription registrations before and after the current subscription registration in the ordered set where uuid = &#63;.
	*
	* @param SUSCRIBER_ID the primary key of the current subscription registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	*/
	public static SubscriptionRegistration[] findByUuid_PrevAndNext(
		long SUSCRIBER_ID, String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(SUSCRIBER_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the subscription registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of subscription registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching subscription registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the subscription registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching subscription registrations
	*/
	public static List<SubscriptionRegistration> findBySTATUS(int STATUS) {
		return getPersistence().findBySTATUS(STATUS);
	}

	/**
	* Returns a range of all the subscription registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @return the range of matching subscription registrations
	*/
	public static List<SubscriptionRegistration> findBySTATUS(int STATUS,
		int start, int end) {
		return getPersistence().findBySTATUS(STATUS, start, end);
	}

	/**
	* Returns an ordered range of all the subscription registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subscription registrations
	*/
	public static List<SubscriptionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the subscription registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching subscription registrations
	*/
	public static List<SubscriptionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		OrderByComparator<SubscriptionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence().findBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the first subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the last subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence().findBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the last subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the subscription registrations before and after the current subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param SUSCRIBER_ID the primary key of the current subscription registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	*/
	public static SubscriptionRegistration[] findBySTATUS_PrevAndNext(
		long SUSCRIBER_ID, int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence()
				   .findBySTATUS_PrevAndNext(SUSCRIBER_ID, STATUS,
			orderByComparator);
	}

	/**
	* Removes all the subscription registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public static void removeBySTATUS(int STATUS) {
		getPersistence().removeBySTATUS(STATUS);
	}

	/**
	* Returns the number of subscription registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching subscription registrations
	*/
	public static int countBySTATUS(int STATUS) {
		return getPersistence().countBySTATUS(STATUS);
	}

	/**
	* Returns the subscription registration where EMAIL = &#63; or throws a {@link NoSuchSubscriptionRegistrationException} if it could not be found.
	*
	* @param EMAIL the email
	* @return the matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration findByEMAIL(String EMAIL)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence().findByEMAIL(EMAIL);
	}

	/**
	* Returns the subscription registration where EMAIL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EMAIL the email
	* @return the matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration fetchByEMAIL(String EMAIL) {
		return getPersistence().fetchByEMAIL(EMAIL);
	}

	/**
	* Returns the subscription registration where EMAIL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EMAIL the email
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public static SubscriptionRegistration fetchByEMAIL(String EMAIL,
		boolean retrieveFromCache) {
		return getPersistence().fetchByEMAIL(EMAIL, retrieveFromCache);
	}

	/**
	* Removes the subscription registration where EMAIL = &#63; from the database.
	*
	* @param EMAIL the email
	* @return the subscription registration that was removed
	*/
	public static SubscriptionRegistration removeByEMAIL(String EMAIL)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence().removeByEMAIL(EMAIL);
	}

	/**
	* Returns the number of subscription registrations where EMAIL = &#63;.
	*
	* @param EMAIL the email
	* @return the number of matching subscription registrations
	*/
	public static int countByEMAIL(String EMAIL) {
		return getPersistence().countByEMAIL(EMAIL);
	}

	/**
	* Caches the subscription registration in the entity cache if it is enabled.
	*
	* @param subscriptionRegistration the subscription registration
	*/
	public static void cacheResult(
		SubscriptionRegistration subscriptionRegistration) {
		getPersistence().cacheResult(subscriptionRegistration);
	}

	/**
	* Caches the subscription registrations in the entity cache if it is enabled.
	*
	* @param subscriptionRegistrations the subscription registrations
	*/
	public static void cacheResult(
		List<SubscriptionRegistration> subscriptionRegistrations) {
		getPersistence().cacheResult(subscriptionRegistrations);
	}

	/**
	* Creates a new subscription registration with the primary key. Does not add the subscription registration to the database.
	*
	* @param SUSCRIBER_ID the primary key for the new subscription registration
	* @return the new subscription registration
	*/
	public static SubscriptionRegistration create(long SUSCRIBER_ID) {
		return getPersistence().create(SUSCRIBER_ID);
	}

	/**
	* Removes the subscription registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration that was removed
	* @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	*/
	public static SubscriptionRegistration remove(long SUSCRIBER_ID)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence().remove(SUSCRIBER_ID);
	}

	public static SubscriptionRegistration updateImpl(
		SubscriptionRegistration subscriptionRegistration) {
		return getPersistence().updateImpl(subscriptionRegistration);
	}

	/**
	* Returns the subscription registration with the primary key or throws a {@link NoSuchSubscriptionRegistrationException} if it could not be found.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	*/
	public static SubscriptionRegistration findByPrimaryKey(long SUSCRIBER_ID)
		throws com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException {
		return getPersistence().findByPrimaryKey(SUSCRIBER_ID);
	}

	/**
	* Returns the subscription registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration, or <code>null</code> if a subscription registration with the primary key could not be found
	*/
	public static SubscriptionRegistration fetchByPrimaryKey(long SUSCRIBER_ID) {
		return getPersistence().fetchByPrimaryKey(SUSCRIBER_ID);
	}

	public static java.util.Map<java.io.Serializable, SubscriptionRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the subscription registrations.
	*
	* @return the subscription registrations
	*/
	public static List<SubscriptionRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the subscription registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @return the range of subscription registrations
	*/
	public static List<SubscriptionRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the subscription registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subscription registrations
	*/
	public static List<SubscriptionRegistration> findAll(int start, int end,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the subscription registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of subscription registrations
	*/
	public static List<SubscriptionRegistration> findAll(int start, int end,
		OrderByComparator<SubscriptionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the subscription registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of subscription registrations.
	*
	* @return the number of subscription registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SubscriptionRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SubscriptionRegistrationPersistence, SubscriptionRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SubscriptionRegistrationPersistence.class);

		ServiceTracker<SubscriptionRegistrationPersistence, SubscriptionRegistrationPersistence> serviceTracker =
			new ServiceTracker<SubscriptionRegistrationPersistence, SubscriptionRegistrationPersistence>(bundle.getBundleContext(),
				SubscriptionRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}