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

import com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException;
import com.crowd.funding.database.model.UserOTPRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user otp registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.UserOTPRegistrationPersistenceImpl
 * @see UserOTPRegistrationUtil
 * @generated
 */
@ProviderType
public interface UserOTPRegistrationPersistence extends BasePersistence<UserOTPRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserOTPRegistrationUtil} to access the user otp registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user otp registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user otp registrations
	*/
	public java.util.List<UserOTPRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the user otp registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user otp registrations
	* @param end the upper bound of the range of user otp registrations (not inclusive)
	* @return the range of matching user otp registrations
	*/
	public java.util.List<UserOTPRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the user otp registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user otp registrations
	* @param end the upper bound of the range of user otp registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user otp registrations
	*/
	public java.util.List<UserOTPRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOTPRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the user otp registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of user otp registrations
	* @param end the upper bound of the range of user otp registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching user otp registrations
	*/
	public java.util.List<UserOTPRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOTPRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first user otp registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user otp registration
	* @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	*/
	public UserOTPRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserOTPRegistration> orderByComparator)
		throws NoSuchUserOTPRegistrationException;

	/**
	* Returns the first user otp registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public UserOTPRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserOTPRegistration> orderByComparator);

	/**
	* Returns the last user otp registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user otp registration
	* @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	*/
	public UserOTPRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserOTPRegistration> orderByComparator)
		throws NoSuchUserOTPRegistrationException;

	/**
	* Returns the last user otp registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public UserOTPRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserOTPRegistration> orderByComparator);

	/**
	* Returns the user otp registrations before and after the current user otp registration in the ordered set where uuid = &#63;.
	*
	* @param USER_OTP_ID the primary key of the current user otp registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user otp registration
	* @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	*/
	public UserOTPRegistration[] findByUuid_PrevAndNext(long USER_OTP_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserOTPRegistration> orderByComparator)
		throws NoSuchUserOTPRegistrationException;

	/**
	* Removes all the user otp registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of user otp registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user otp registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the user otp registration where MOBILE_NO = &#63; or throws a {@link NoSuchUserOTPRegistrationException} if it could not be found.
	*
	* @param MOBILE_NO the mobile_no
	* @return the matching user otp registration
	* @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	*/
	public UserOTPRegistration findByMOBILE_NO(long MOBILE_NO)
		throws NoSuchUserOTPRegistrationException;

	/**
	* Returns the user otp registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param MOBILE_NO the mobile_no
	* @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public UserOTPRegistration fetchByMOBILE_NO(long MOBILE_NO);

	/**
	* Returns the user otp registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param MOBILE_NO the mobile_no
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public UserOTPRegistration fetchByMOBILE_NO(long MOBILE_NO,
		boolean retrieveFromCache);

	/**
	* Removes the user otp registration where MOBILE_NO = &#63; from the database.
	*
	* @param MOBILE_NO the mobile_no
	* @return the user otp registration that was removed
	*/
	public UserOTPRegistration removeByMOBILE_NO(long MOBILE_NO)
		throws NoSuchUserOTPRegistrationException;

	/**
	* Returns the number of user otp registrations where MOBILE_NO = &#63;.
	*
	* @param MOBILE_NO the mobile_no
	* @return the number of matching user otp registrations
	*/
	public int countByMOBILE_NO(long MOBILE_NO);

	/**
	* Returns the user otp registration where USER_OTP_ID = &#63; or throws a {@link NoSuchUserOTPRegistrationException} if it could not be found.
	*
	* @param USER_OTP_ID the user_otp_id
	* @return the matching user otp registration
	* @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	*/
	public UserOTPRegistration findByUSER_OTP_ID(long USER_OTP_ID)
		throws NoSuchUserOTPRegistrationException;

	/**
	* Returns the user otp registration where USER_OTP_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param USER_OTP_ID the user_otp_id
	* @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public UserOTPRegistration fetchByUSER_OTP_ID(long USER_OTP_ID);

	/**
	* Returns the user otp registration where USER_OTP_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param USER_OTP_ID the user_otp_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public UserOTPRegistration fetchByUSER_OTP_ID(long USER_OTP_ID,
		boolean retrieveFromCache);

	/**
	* Removes the user otp registration where USER_OTP_ID = &#63; from the database.
	*
	* @param USER_OTP_ID the user_otp_id
	* @return the user otp registration that was removed
	*/
	public UserOTPRegistration removeByUSER_OTP_ID(long USER_OTP_ID)
		throws NoSuchUserOTPRegistrationException;

	/**
	* Returns the number of user otp registrations where USER_OTP_ID = &#63;.
	*
	* @param USER_OTP_ID the user_otp_id
	* @return the number of matching user otp registrations
	*/
	public int countByUSER_OTP_ID(long USER_OTP_ID);

	/**
	* Caches the user otp registration in the entity cache if it is enabled.
	*
	* @param userOTPRegistration the user otp registration
	*/
	public void cacheResult(UserOTPRegistration userOTPRegistration);

	/**
	* Caches the user otp registrations in the entity cache if it is enabled.
	*
	* @param userOTPRegistrations the user otp registrations
	*/
	public void cacheResult(
		java.util.List<UserOTPRegistration> userOTPRegistrations);

	/**
	* Creates a new user otp registration with the primary key. Does not add the user otp registration to the database.
	*
	* @param USER_OTP_ID the primary key for the new user otp registration
	* @return the new user otp registration
	*/
	public UserOTPRegistration create(long USER_OTP_ID);

	/**
	* Removes the user otp registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param USER_OTP_ID the primary key of the user otp registration
	* @return the user otp registration that was removed
	* @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	*/
	public UserOTPRegistration remove(long USER_OTP_ID)
		throws NoSuchUserOTPRegistrationException;

	public UserOTPRegistration updateImpl(
		UserOTPRegistration userOTPRegistration);

	/**
	* Returns the user otp registration with the primary key or throws a {@link NoSuchUserOTPRegistrationException} if it could not be found.
	*
	* @param USER_OTP_ID the primary key of the user otp registration
	* @return the user otp registration
	* @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	*/
	public UserOTPRegistration findByPrimaryKey(long USER_OTP_ID)
		throws NoSuchUserOTPRegistrationException;

	/**
	* Returns the user otp registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param USER_OTP_ID the primary key of the user otp registration
	* @return the user otp registration, or <code>null</code> if a user otp registration with the primary key could not be found
	*/
	public UserOTPRegistration fetchByPrimaryKey(long USER_OTP_ID);

	@Override
	public java.util.Map<java.io.Serializable, UserOTPRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user otp registrations.
	*
	* @return the user otp registrations
	*/
	public java.util.List<UserOTPRegistration> findAll();

	/**
	* Returns a range of all the user otp registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user otp registrations
	* @param end the upper bound of the range of user otp registrations (not inclusive)
	* @return the range of user otp registrations
	*/
	public java.util.List<UserOTPRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the user otp registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user otp registrations
	* @param end the upper bound of the range of user otp registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user otp registrations
	*/
	public java.util.List<UserOTPRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOTPRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the user otp registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user otp registrations
	* @param end the upper bound of the range of user otp registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user otp registrations
	*/
	public java.util.List<UserOTPRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserOTPRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user otp registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user otp registrations.
	*
	* @return the number of user otp registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}