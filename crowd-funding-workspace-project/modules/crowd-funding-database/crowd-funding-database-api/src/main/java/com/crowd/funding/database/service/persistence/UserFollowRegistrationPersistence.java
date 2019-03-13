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

import com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException;
import com.crowd.funding.database.model.UserFollowRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user follow registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.UserFollowRegistrationPersistenceImpl
 * @see UserFollowRegistrationUtil
 * @generated
 */
@ProviderType
public interface UserFollowRegistrationPersistence extends BasePersistence<UserFollowRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserFollowRegistrationUtil} to access the user follow registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user follow registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user follow registrations
	*/
	public java.util.List<UserFollowRegistration> findByUuid(String uuid);

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
	public java.util.List<UserFollowRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<UserFollowRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

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
	public java.util.List<UserFollowRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user follow registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public UserFollowRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Returns the first user follow registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public UserFollowRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

	/**
	* Returns the last user follow registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public UserFollowRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Returns the last user follow registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public UserFollowRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

	/**
	* Returns the user follow registrations before and after the current user follow registration in the ordered set where uuid = &#63;.
	*
	* @param USER_FOLLOW_ID the primary key of the current user follow registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user follow registration
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public UserFollowRegistration[] findByUuid_PrevAndNext(
		long USER_FOLLOW_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Removes all the user follow registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of user follow registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user follow registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the user follow registration where USER_FOLLOW_ID = &#63; or throws a {@link NoSuchUserFollowRegistrationException} if it could not be found.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @return the matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public UserFollowRegistration findByUSER_FOLLOW_ID(long USER_FOLLOW_ID)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Returns the user follow registration where USER_FOLLOW_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @return the matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public UserFollowRegistration fetchByUSER_FOLLOW_ID(long USER_FOLLOW_ID);

	/**
	* Returns the user follow registration where USER_FOLLOW_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public UserFollowRegistration fetchByUSER_FOLLOW_ID(long USER_FOLLOW_ID,
		boolean retrieveFromCache);

	/**
	* Removes the user follow registration where USER_FOLLOW_ID = &#63; from the database.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @return the user follow registration that was removed
	*/
	public UserFollowRegistration removeByUSER_FOLLOW_ID(long USER_FOLLOW_ID)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Returns the number of user follow registrations where USER_FOLLOW_ID = &#63;.
	*
	* @param USER_FOLLOW_ID the user_follow_id
	* @return the number of matching user follow registrations
	*/
	public int countByUSER_FOLLOW_ID(long USER_FOLLOW_ID);

	/**
	* Returns all the user follow registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the matching user follow registrations
	*/
	public java.util.List<UserFollowRegistration> findByUSER_ID(long USER_ID);

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
	public java.util.List<UserFollowRegistration> findByUSER_ID(long USER_ID,
		int start, int end);

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
	public java.util.List<UserFollowRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

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
	public java.util.List<UserFollowRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public UserFollowRegistration findByUSER_ID_First(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Returns the first user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public UserFollowRegistration fetchByUSER_ID_First(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

	/**
	* Returns the last user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public UserFollowRegistration findByUSER_ID_Last(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Returns the last user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public UserFollowRegistration fetchByUSER_ID_Last(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

	/**
	* Returns the user follow registrations before and after the current user follow registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_FOLLOW_ID the primary key of the current user follow registration
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user follow registration
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public UserFollowRegistration[] findByUSER_ID_PrevAndNext(
		long USER_FOLLOW_ID, long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Removes all the user follow registrations where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	*/
	public void removeByUSER_ID(long USER_ID);

	/**
	* Returns the number of user follow registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching user follow registrations
	*/
	public int countByUSER_ID(long USER_ID);

	/**
	* Returns all the user follow registrations where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @return the matching user follow registrations
	*/
	public java.util.List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID);

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
	public java.util.List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID, int start, int end);

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
	public java.util.List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

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
	public java.util.List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public UserFollowRegistration findByFOLLOWER_USER_ID_First(
		long FOLLOWER_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Returns the first user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public UserFollowRegistration fetchByFOLLOWER_USER_ID_First(
		long FOLLOWER_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

	/**
	* Returns the last user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration
	* @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	*/
	public UserFollowRegistration findByFOLLOWER_USER_ID_Last(
		long FOLLOWER_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Returns the last user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	*/
	public UserFollowRegistration fetchByFOLLOWER_USER_ID_Last(
		long FOLLOWER_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

	/**
	* Returns the user follow registrations before and after the current user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	*
	* @param USER_FOLLOW_ID the primary key of the current user follow registration
	* @param FOLLOWER_USER_ID the follower_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user follow registration
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public UserFollowRegistration[] findByFOLLOWER_USER_ID_PrevAndNext(
		long USER_FOLLOW_ID, long FOLLOWER_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Removes all the user follow registrations where FOLLOWER_USER_ID = &#63; from the database.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	*/
	public void removeByFOLLOWER_USER_ID(long FOLLOWER_USER_ID);

	/**
	* Returns the number of user follow registrations where FOLLOWER_USER_ID = &#63;.
	*
	* @param FOLLOWER_USER_ID the follower_user_id
	* @return the number of matching user follow registrations
	*/
	public int countByFOLLOWER_USER_ID(long FOLLOWER_USER_ID);

	/**
	* Caches the user follow registration in the entity cache if it is enabled.
	*
	* @param userFollowRegistration the user follow registration
	*/
	public void cacheResult(UserFollowRegistration userFollowRegistration);

	/**
	* Caches the user follow registrations in the entity cache if it is enabled.
	*
	* @param userFollowRegistrations the user follow registrations
	*/
	public void cacheResult(
		java.util.List<UserFollowRegistration> userFollowRegistrations);

	/**
	* Creates a new user follow registration with the primary key. Does not add the user follow registration to the database.
	*
	* @param USER_FOLLOW_ID the primary key for the new user follow registration
	* @return the new user follow registration
	*/
	public UserFollowRegistration create(long USER_FOLLOW_ID);

	/**
	* Removes the user follow registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param USER_FOLLOW_ID the primary key of the user follow registration
	* @return the user follow registration that was removed
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public UserFollowRegistration remove(long USER_FOLLOW_ID)
		throws NoSuchUserFollowRegistrationException;

	public UserFollowRegistration updateImpl(
		UserFollowRegistration userFollowRegistration);

	/**
	* Returns the user follow registration with the primary key or throws a {@link NoSuchUserFollowRegistrationException} if it could not be found.
	*
	* @param USER_FOLLOW_ID the primary key of the user follow registration
	* @return the user follow registration
	* @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	*/
	public UserFollowRegistration findByPrimaryKey(long USER_FOLLOW_ID)
		throws NoSuchUserFollowRegistrationException;

	/**
	* Returns the user follow registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param USER_FOLLOW_ID the primary key of the user follow registration
	* @return the user follow registration, or <code>null</code> if a user follow registration with the primary key could not be found
	*/
	public UserFollowRegistration fetchByPrimaryKey(long USER_FOLLOW_ID);

	@Override
	public java.util.Map<java.io.Serializable, UserFollowRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user follow registrations.
	*
	* @return the user follow registrations
	*/
	public java.util.List<UserFollowRegistration> findAll();

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
	public java.util.List<UserFollowRegistration> findAll(int start, int end);

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
	public java.util.List<UserFollowRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator);

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
	public java.util.List<UserFollowRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user follow registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user follow registrations.
	*
	* @return the number of user follow registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}