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

import com.crowd.funding.database.model.UserRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.UserRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.UserRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class UserRegistrationUtil {
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
	public static void clearCache(UserRegistration userRegistration) {
		getPersistence().clearCache(userRegistration);
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
	public static List<UserRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserRegistration update(UserRegistration userRegistration) {
		return getPersistence().update(userRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserRegistration update(UserRegistration userRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(userRegistration, serviceContext);
	}

	/**
	* Returns all the user registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user registrations
	*/
	public static List<UserRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the user registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user registrations
	* @param end the upper bound of the range of user registrations (not inclusive)
	* @return the range of matching user registrations
	*/
	public static List<UserRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the user registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user registrations
	* @param end the upper bound of the range of user registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user registrations
	*/
	public static List<UserRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<UserRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user registrations
	* @param end the upper bound of the range of user registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user registrations
	*/
	public static List<UserRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<UserRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user registration
	* @throws NoSuchUserRegistrationException if a matching user registration could not be found
	*/
	public static UserRegistration findByUuid_First(String uuid,
		OrderByComparator<UserRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first user registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user registration, or <code>null</code> if a matching user registration could not be found
	*/
	public static UserRegistration fetchByUuid_First(String uuid,
		OrderByComparator<UserRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last user registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user registration
	* @throws NoSuchUserRegistrationException if a matching user registration could not be found
	*/
	public static UserRegistration findByUuid_Last(String uuid,
		OrderByComparator<UserRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last user registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user registration, or <code>null</code> if a matching user registration could not be found
	*/
	public static UserRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<UserRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the user registrations before and after the current user registration in the ordered set where uuid = &#63;.
	*
	* @param USER_ID the primary key of the current user registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user registration
	* @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	*/
	public static UserRegistration[] findByUuid_PrevAndNext(long USER_ID,
		String uuid, OrderByComparator<UserRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(USER_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the user registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of user registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the user registration where USER_ID = &#63; or throws a {@link NoSuchUserRegistrationException} if it could not be found.
	*
	* @param USER_ID the user_id
	* @return the matching user registration
	* @throws NoSuchUserRegistrationException if a matching user registration could not be found
	*/
	public static UserRegistration findByUSER_ID(long USER_ID)
		throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
		return getPersistence().findByUSER_ID(USER_ID);
	}

	/**
	* Returns the user registration where USER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param USER_ID the user_id
	* @return the matching user registration, or <code>null</code> if a matching user registration could not be found
	*/
	public static UserRegistration fetchByUSER_ID(long USER_ID) {
		return getPersistence().fetchByUSER_ID(USER_ID);
	}

	/**
	* Returns the user registration where USER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param USER_ID the user_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user registration, or <code>null</code> if a matching user registration could not be found
	*/
	public static UserRegistration fetchByUSER_ID(long USER_ID,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUSER_ID(USER_ID, retrieveFromCache);
	}

	/**
	* Removes the user registration where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	* @return the user registration that was removed
	*/
	public static UserRegistration removeByUSER_ID(long USER_ID)
		throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
		return getPersistence().removeByUSER_ID(USER_ID);
	}

	/**
	* Returns the number of user registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching user registrations
	*/
	public static int countByUSER_ID(long USER_ID) {
		return getPersistence().countByUSER_ID(USER_ID);
	}

	/**
	* Caches the user registration in the entity cache if it is enabled.
	*
	* @param userRegistration the user registration
	*/
	public static void cacheResult(UserRegistration userRegistration) {
		getPersistence().cacheResult(userRegistration);
	}

	/**
	* Caches the user registrations in the entity cache if it is enabled.
	*
	* @param userRegistrations the user registrations
	*/
	public static void cacheResult(List<UserRegistration> userRegistrations) {
		getPersistence().cacheResult(userRegistrations);
	}

	/**
	* Creates a new user registration with the primary key. Does not add the user registration to the database.
	*
	* @param USER_ID the primary key for the new user registration
	* @return the new user registration
	*/
	public static UserRegistration create(long USER_ID) {
		return getPersistence().create(USER_ID);
	}

	/**
	* Removes the user registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param USER_ID the primary key of the user registration
	* @return the user registration that was removed
	* @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	*/
	public static UserRegistration remove(long USER_ID)
		throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
		return getPersistence().remove(USER_ID);
	}

	public static UserRegistration updateImpl(UserRegistration userRegistration) {
		return getPersistence().updateImpl(userRegistration);
	}

	/**
	* Returns the user registration with the primary key or throws a {@link NoSuchUserRegistrationException} if it could not be found.
	*
	* @param USER_ID the primary key of the user registration
	* @return the user registration
	* @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	*/
	public static UserRegistration findByPrimaryKey(long USER_ID)
		throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
		return getPersistence().findByPrimaryKey(USER_ID);
	}

	/**
	* Returns the user registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param USER_ID the primary key of the user registration
	* @return the user registration, or <code>null</code> if a user registration with the primary key could not be found
	*/
	public static UserRegistration fetchByPrimaryKey(long USER_ID) {
		return getPersistence().fetchByPrimaryKey(USER_ID);
	}

	public static java.util.Map<java.io.Serializable, UserRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user registrations.
	*
	* @return the user registrations
	*/
	public static List<UserRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user registrations
	* @param end the upper bound of the range of user registrations (not inclusive)
	* @return the range of user registrations
	*/
	public static List<UserRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user registrations
	* @param end the upper bound of the range of user registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user registrations
	*/
	public static List<UserRegistration> findAll(int start, int end,
		OrderByComparator<UserRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user registrations
	* @param end the upper bound of the range of user registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user registrations
	*/
	public static List<UserRegistration> findAll(int start, int end,
		OrderByComparator<UserRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user registrations.
	*
	* @return the number of user registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserRegistrationPersistence, UserRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserRegistrationPersistence.class);

		ServiceTracker<UserRegistrationPersistence, UserRegistrationPersistence> serviceTracker =
			new ServiceTracker<UserRegistrationPersistence, UserRegistrationPersistence>(bundle.getBundleContext(),
				UserRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}