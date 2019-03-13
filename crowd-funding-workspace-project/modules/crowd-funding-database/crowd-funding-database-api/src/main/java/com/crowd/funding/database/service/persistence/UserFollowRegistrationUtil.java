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

import com.crowd.funding.database.model.UserFollowRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user follow registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.UserFollowRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFollowRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.UserFollowRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class UserFollowRegistrationUtil {
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
	public static void clearCache(UserFollowRegistration userFollowRegistration) {
		getPersistence().clearCache(userFollowRegistration);
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
	public static List<UserFollowRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserFollowRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserFollowRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserFollowRegistration update(
		UserFollowRegistration userFollowRegistration) {
		return getPersistence().update(userFollowRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserFollowRegistration update(
		UserFollowRegistration userFollowRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(userFollowRegistration, serviceContext);
	}

	/**
	* Returns all the user follow registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the user follow registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @return the range of matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the user follow registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user follow registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user follow registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration findByUuid_First(String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first user follow registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration fetchByUuid_First(String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last user follow registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration findByUuid_Last(String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last user follow registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the user follow registrations before and after the current user follow registration in the ordered set where uuid = &#63;.
	*
	* @param USER_FOLLOW_ID the primary key of the current user follow registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user follow registration
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public static UserFollowRegistration[] findByUuid_PrevAndNext(
		long USER_FOLLOW_ID, String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(USER_FOLLOW_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the user follow registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of user follow registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user follow registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the user follow registration where USER_FOLLOW_ID = &#63; or throws a {@link NoSuchUserFollowRegistrationException} if it could not be found.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @return the matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration findByUSER_FOLLOW_ID(
		long USER_FOLLOW_ID)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence().findByUSER_FOLLOW_ID(USER_FOLLOW_ID);
	}

	/**
	* Returns the user follow registration where USER_FOLLOW_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @return the matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration fetchByUSER_FOLLOW_ID(
		long USER_FOLLOW_ID) {
		return getPersistence().fetchByUSER_FOLLOW_ID(USER_FOLLOW_ID);
	}

	/**
	* Returns the user follow registration where USER_FOLLOW_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration fetchByUSER_FOLLOW_ID(
		long USER_FOLLOW_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByUSER_FOLLOW_ID(USER_FOLLOW_ID, retrieveFromCache);
	}

	/**
	* Removes the user follow registration where USER_FOLLOW_ID = &#63; from the database.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @return the user follow registration that was removed
	*/
	public static UserFollowRegistration removeByUSER_FOLLOW_ID(
		long USER_FOLLOW_ID)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence().removeByUSER_FOLLOW_ID(USER_FOLLOW_ID);
	}

	/**
	* Returns the number of user follow registrations where USER_FOLLOW_ID = &#63;.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @return the number of matching user follow registrations
	*/
	public static int countByUSER_FOLLOW_ID(long USER_FOLLOW_ID) {
		return getPersistence().countByUSER_FOLLOW_ID(USER_FOLLOW_ID);
	}

	/**
	* Returns all the user follow registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByUSER_ID(long USER_ID) {
		return getPersistence().findByUSER_ID(USER_ID);
	}

	/**
	* Returns a range of all the user follow registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @return the range of matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByUSER_ID(long USER_ID,
		int start, int end) {
		return getPersistence().findByUSER_ID(USER_ID, start, end);
	}

	/**
	* Returns an ordered range of all the user follow registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user follow registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration findByUSER_ID_First(long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence().findByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the first user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration fetchByUSER_ID_First(long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the last user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration findByUSER_ID_Last(long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence().findByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the last user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration fetchByUSER_ID_Last(long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the user follow registrations before and after the current user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_FOLLOW_ID the primary key of the current user follow registration
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user follow registration
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public static UserFollowRegistration[] findByUSER_ID_PrevAndNext(
		long USER_FOLLOW_ID, long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence()
				   .findByUSER_ID_PrevAndNext(USER_FOLLOW_ID, USER_ID,
			orderByComparator);
	}

	/**
	* Removes all the user follow registrations where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	*/
	public static void removeByUSER_ID(long USER_ID) {
		getPersistence().removeByUSER_ID(USER_ID);
	}

	/**
	* Returns the number of user follow registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching user follow registrations
	*/
	public static int countByUSER_ID(long USER_ID) {
		return getPersistence().countByUSER_ID(USER_ID);
	}

	/**
	* Returns all the user follow registrations where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @return the matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID) {
		return getPersistence().findByFOLLOWER_USER_ID(FOLLOWER_USER_ID);
	}

	/**
	* Returns a range of all the user follow registrations where FOLLOWER_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @return the range of matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID, int start, int end) {
		return getPersistence()
				   .findByFOLLOWER_USER_ID(FOLLOWER_USER_ID, start, end);
	}

	/**
	* Returns an ordered range of all the user follow registrations where FOLLOWER_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID, int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence()
				   .findByFOLLOWER_USER_ID(FOLLOWER_USER_ID, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the user follow registrations where FOLLOWER_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user follow registrations
	*/
	public static List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID, int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFOLLOWER_USER_ID(FOLLOWER_USER_ID, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration findByFOLLOWER_USER_ID_First(
		long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence()
				   .findByFOLLOWER_USER_ID_First(FOLLOWER_USER_ID,
			orderByComparator);
	}

	/**
	* Returns the first user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration fetchByFOLLOWER_USER_ID_First(
		long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByFOLLOWER_USER_ID_First(FOLLOWER_USER_ID,
			orderByComparator);
	}

	/**
	* Returns the last user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration findByFOLLOWER_USER_ID_Last(
		long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence()
				   .findByFOLLOWER_USER_ID_Last(FOLLOWER_USER_ID,
			orderByComparator);
	}

	/**
	* Returns the last user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public static UserFollowRegistration fetchByFOLLOWER_USER_ID_Last(
		long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByFOLLOWER_USER_ID_Last(FOLLOWER_USER_ID,
			orderByComparator);
	}

	/**
	* Returns the user follow registrations before and after the current user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param USER_FOLLOW_ID the primary key of the current user follow registration
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user follow registration
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public static UserFollowRegistration[] findByFOLLOWER_USER_ID_PrevAndNext(
		long USER_FOLLOW_ID, long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence()
				   .findByFOLLOWER_USER_ID_PrevAndNext(USER_FOLLOW_ID,
			FOLLOWER_USER_ID, orderByComparator);
	}

	/**
	* Removes all the user follow registrations where FOLLOWER_USER_ID = &#63; from the database.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	*/
	public static void removeByFOLLOWER_USER_ID(long FOLLOWER_USER_ID) {
		getPersistence().removeByFOLLOWER_USER_ID(FOLLOWER_USER_ID);
	}

	/**
	* Returns the number of user follow registrations where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @return the number of matching user follow registrations
	*/
	public static int countByFOLLOWER_USER_ID(long FOLLOWER_USER_ID) {
		return getPersistence().countByFOLLOWER_USER_ID(FOLLOWER_USER_ID);
	}

	/**
	* Caches the user follow registration in the entity cache if it is enabled.
	*
	* @param userFollowRegistration the user follow registration
	*/
	public static void cacheResult(
		UserFollowRegistration userFollowRegistration) {
		getPersistence().cacheResult(userFollowRegistration);
	}

	/**
	* Caches the user follow registrations in the entity cache if it is enabled.
	*
	* @param userFollowRegistrations the user follow registrations
	*/
	public static void cacheResult(
		List<UserFollowRegistration> userFollowRegistrations) {
		getPersistence().cacheResult(userFollowRegistrations);
	}

	/**
	* Creates a new user follow registration with the primary key. Does not add the user follow registration to the database.
	*
	* @param USER_FOLLOW_ID the primary key for the new user follow registration
	* @return the new user follow registration
	*/
	public static UserFollowRegistration create(long USER_FOLLOW_ID) {
		return getPersistence().create(USER_FOLLOW_ID);
	}

	/**
	* Removes the user follow registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param USER_FOLLOW_ID the primary key of the user follow registration
	* @return the user follow registration that was removed
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public static UserFollowRegistration remove(long USER_FOLLOW_ID)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence().remove(USER_FOLLOW_ID);
	}

	public static UserFollowRegistration updateImpl(
		UserFollowRegistration userFollowRegistration) {
		return getPersistence().updateImpl(userFollowRegistration);
	}

	/**
	* Returns the user follow registration with the primary key or throws a {@link NoSuchUserFollowRegistrationException} if it could not be found.
	*
	* @param USER_FOLLOW_ID the primary key of the user follow registration
	* @return the user follow registration
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public static UserFollowRegistration findByPrimaryKey(long USER_FOLLOW_ID)
		throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
		return getPersistence().findByPrimaryKey(USER_FOLLOW_ID);
	}

	/**
	* Returns the user follow registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param USER_FOLLOW_ID the primary key of the user follow registration
	* @return the user follow registration, or <code>null</code> if a user follow registration with the primary key could not be found
	*/
	public static UserFollowRegistration fetchByPrimaryKey(long USER_FOLLOW_ID) {
		return getPersistence().fetchByPrimaryKey(USER_FOLLOW_ID);
	}

	public static java.util.Map<java.io.Serializable, UserFollowRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user follow registrations.
	*
	* @return the user follow registrations
	*/
	public static List<UserFollowRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user follow registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @return the range of user follow registrations
	*/
	public static List<UserFollowRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user follow registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user follow registrations
	*/
	public static List<UserFollowRegistration> findAll(int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user follow registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user follow registrations
	* @param end the upper bound of the range of user follow registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user follow registrations
	*/
	public static List<UserFollowRegistration> findAll(int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user follow registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user follow registrations.
	*
	* @return the number of user follow registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserFollowRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserFollowRegistrationPersistence, UserFollowRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserFollowRegistrationPersistence.class);

		ServiceTracker<UserFollowRegistrationPersistence, UserFollowRegistrationPersistence> serviceTracker =
			new ServiceTracker<UserFollowRegistrationPersistence, UserFollowRegistrationPersistence>(bundle.getBundleContext(),
				UserFollowRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}