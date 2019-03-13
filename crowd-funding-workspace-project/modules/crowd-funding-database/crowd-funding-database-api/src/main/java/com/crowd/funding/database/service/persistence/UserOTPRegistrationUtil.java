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

import com.crowd.funding.database.model.UserOTPRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user otp registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.UserOTPRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOTPRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.UserOTPRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class UserOTPRegistrationUtil {
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
	public static void clearCache(UserOTPRegistration userOTPRegistration) {
		getPersistence().clearCache(userOTPRegistration);
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
	public static List<UserOTPRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserOTPRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserOTPRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserOTPRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserOTPRegistration update(
		UserOTPRegistration userOTPRegistration) {
		return getPersistence().update(userOTPRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserOTPRegistration update(
		UserOTPRegistration userOTPRegistration, ServiceContext serviceContext) {
		return getPersistence().update(userOTPRegistration, serviceContext);
	}

	/**
	* Returns all the user otp registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching user otp registrations
	*/
	public static List<UserOTPRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<UserOTPRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<UserOTPRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<UserOTPRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<UserOTPRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<UserOTPRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first user otp registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user otp registration
	* @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration findByUuid_First(String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first user otp registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration fetchByUuid_First(String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last user otp registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user otp registration
	* @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration findByUuid_Last(String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last user otp registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the user otp registrations before and after the current user otp registration in the ordered set where uuid = &#63;.
	*
	* @param USER_OTP_ID the primary key of the current user otp registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user otp registration
	* @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	*/
	public static UserOTPRegistration[] findByUuid_PrevAndNext(
		long USER_OTP_ID, String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(USER_OTP_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the user otp registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of user otp registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching user otp registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the user otp registration where MOBILE_NO = &#63; or throws a {@link NoSuchUserOTPRegistrationException} if it could not be found.
	*
	* @param MOBILE_NO the mobile_no
	* @return the matching user otp registration
	* @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration findByMOBILE_NO(long MOBILE_NO)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return getPersistence().findByMOBILE_NO(MOBILE_NO);
	}

	/**
	* Returns the user otp registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param MOBILE_NO the mobile_no
	* @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration fetchByMOBILE_NO(long MOBILE_NO) {
		return getPersistence().fetchByMOBILE_NO(MOBILE_NO);
	}

	/**
	* Returns the user otp registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param MOBILE_NO the mobile_no
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration fetchByMOBILE_NO(long MOBILE_NO,
		boolean retrieveFromCache) {
		return getPersistence().fetchByMOBILE_NO(MOBILE_NO, retrieveFromCache);
	}

	/**
	* Removes the user otp registration where MOBILE_NO = &#63; from the database.
	*
	* @param MOBILE_NO the mobile_no
	* @return the user otp registration that was removed
	*/
	public static UserOTPRegistration removeByMOBILE_NO(long MOBILE_NO)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return getPersistence().removeByMOBILE_NO(MOBILE_NO);
	}

	/**
	* Returns the number of user otp registrations where MOBILE_NO = &#63;.
	*
	* @param MOBILE_NO the mobile_no
	* @return the number of matching user otp registrations
	*/
	public static int countByMOBILE_NO(long MOBILE_NO) {
		return getPersistence().countByMOBILE_NO(MOBILE_NO);
	}

	/**
	* Returns the user otp registration where USER_OTP_ID = &#63; or throws a {@link NoSuchUserOTPRegistrationException} if it could not be found.
	*
	* @param USER_OTP_ID the user_otp_id
	* @return the matching user otp registration
	* @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration findByUSER_OTP_ID(long USER_OTP_ID)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return getPersistence().findByUSER_OTP_ID(USER_OTP_ID);
	}

	/**
	* Returns the user otp registration where USER_OTP_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param USER_OTP_ID the user_otp_id
	* @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration fetchByUSER_OTP_ID(long USER_OTP_ID) {
		return getPersistence().fetchByUSER_OTP_ID(USER_OTP_ID);
	}

	/**
	* Returns the user otp registration where USER_OTP_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param USER_OTP_ID the user_otp_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	*/
	public static UserOTPRegistration fetchByUSER_OTP_ID(long USER_OTP_ID,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByUSER_OTP_ID(USER_OTP_ID, retrieveFromCache);
	}

	/**
	* Removes the user otp registration where USER_OTP_ID = &#63; from the database.
	*
	* @param USER_OTP_ID the user_otp_id
	* @return the user otp registration that was removed
	*/
	public static UserOTPRegistration removeByUSER_OTP_ID(long USER_OTP_ID)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return getPersistence().removeByUSER_OTP_ID(USER_OTP_ID);
	}

	/**
	* Returns the number of user otp registrations where USER_OTP_ID = &#63;.
	*
	* @param USER_OTP_ID the user_otp_id
	* @return the number of matching user otp registrations
	*/
	public static int countByUSER_OTP_ID(long USER_OTP_ID) {
		return getPersistence().countByUSER_OTP_ID(USER_OTP_ID);
	}

	/**
	* Caches the user otp registration in the entity cache if it is enabled.
	*
	* @param userOTPRegistration the user otp registration
	*/
	public static void cacheResult(UserOTPRegistration userOTPRegistration) {
		getPersistence().cacheResult(userOTPRegistration);
	}

	/**
	* Caches the user otp registrations in the entity cache if it is enabled.
	*
	* @param userOTPRegistrations the user otp registrations
	*/
	public static void cacheResult(
		List<UserOTPRegistration> userOTPRegistrations) {
		getPersistence().cacheResult(userOTPRegistrations);
	}

	/**
	* Creates a new user otp registration with the primary key. Does not add the user otp registration to the database.
	*
	* @param USER_OTP_ID the primary key for the new user otp registration
	* @return the new user otp registration
	*/
	public static UserOTPRegistration create(long USER_OTP_ID) {
		return getPersistence().create(USER_OTP_ID);
	}

	/**
	* Removes the user otp registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param USER_OTP_ID the primary key of the user otp registration
	* @return the user otp registration that was removed
	* @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	*/
	public static UserOTPRegistration remove(long USER_OTP_ID)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return getPersistence().remove(USER_OTP_ID);
	}

	public static UserOTPRegistration updateImpl(
		UserOTPRegistration userOTPRegistration) {
		return getPersistence().updateImpl(userOTPRegistration);
	}

	/**
	* Returns the user otp registration with the primary key or throws a {@link NoSuchUserOTPRegistrationException} if it could not be found.
	*
	* @param USER_OTP_ID the primary key of the user otp registration
	* @return the user otp registration
	* @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	*/
	public static UserOTPRegistration findByPrimaryKey(long USER_OTP_ID)
		throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
		return getPersistence().findByPrimaryKey(USER_OTP_ID);
	}

	/**
	* Returns the user otp registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param USER_OTP_ID the primary key of the user otp registration
	* @return the user otp registration, or <code>null</code> if a user otp registration with the primary key could not be found
	*/
	public static UserOTPRegistration fetchByPrimaryKey(long USER_OTP_ID) {
		return getPersistence().fetchByPrimaryKey(USER_OTP_ID);
	}

	public static java.util.Map<java.io.Serializable, UserOTPRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user otp registrations.
	*
	* @return the user otp registrations
	*/
	public static List<UserOTPRegistration> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserOTPRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserOTPRegistration> findAll(int start, int end,
		OrderByComparator<UserOTPRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<UserOTPRegistration> findAll(int start, int end,
		OrderByComparator<UserOTPRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user otp registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user otp registrations.
	*
	* @return the number of user otp registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UserOTPRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserOTPRegistrationPersistence, UserOTPRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserOTPRegistrationPersistence.class);

		ServiceTracker<UserOTPRegistrationPersistence, UserOTPRegistrationPersistence> serviceTracker =
			new ServiceTracker<UserOTPRegistrationPersistence, UserOTPRegistrationPersistence>(bundle.getBundleContext(),
				UserOTPRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}