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

import com.crowd.funding.database.model.FundAccountRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the fund account registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.FundAccountRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundAccountRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.FundAccountRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class FundAccountRegistrationUtil {
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
		FundAccountRegistration fundAccountRegistration) {
		getPersistence().clearCache(fundAccountRegistration);
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
	public static List<FundAccountRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FundAccountRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FundAccountRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FundAccountRegistration update(
		FundAccountRegistration fundAccountRegistration) {
		return getPersistence().update(fundAccountRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FundAccountRegistration update(
		FundAccountRegistration fundAccountRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(fundAccountRegistration, serviceContext);
	}

	/**
	* Returns all the fund account registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching fund account registrations
	*/
	public static List<FundAccountRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the fund account registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @return the range of matching fund account registrations
	*/
	public static List<FundAccountRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the fund account registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund account registrations
	*/
	public static List<FundAccountRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund account registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund account registrations
	*/
	public static List<FundAccountRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first fund account registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration findByUuid_First(String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first fund account registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration fetchByUuid_First(String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last fund account registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration findByUuid_Last(String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last fund account registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the fund account registrations before and after the current fund account registration in the ordered set where uuid = &#63;.
	*
	* @param ACCOUNT_ID the primary key of the current fund account registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund account registration
	* @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	*/
	public static FundAccountRegistration[] findByUuid_PrevAndNext(
		long ACCOUNT_ID, String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(ACCOUNT_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the fund account registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of fund account registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching fund account registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the fund account registration where ACCOUNT_ID = &#63; or throws a {@link NoSuchFundAccountRegistrationException} if it could not be found.
	*
	* @param ACCOUNT_ID the account_id
	* @return the matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration findByACCOUNT_ID(long ACCOUNT_ID)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence().findByACCOUNT_ID(ACCOUNT_ID);
	}

	/**
	* Returns the fund account registration where ACCOUNT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ACCOUNT_ID the account_id
	* @return the matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration fetchByACCOUNT_ID(long ACCOUNT_ID) {
		return getPersistence().fetchByACCOUNT_ID(ACCOUNT_ID);
	}

	/**
	* Returns the fund account registration where ACCOUNT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ACCOUNT_ID the account_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration fetchByACCOUNT_ID(long ACCOUNT_ID,
		boolean retrieveFromCache) {
		return getPersistence().fetchByACCOUNT_ID(ACCOUNT_ID, retrieveFromCache);
	}

	/**
	* Removes the fund account registration where ACCOUNT_ID = &#63; from the database.
	*
	* @param ACCOUNT_ID the account_id
	* @return the fund account registration that was removed
	*/
	public static FundAccountRegistration removeByACCOUNT_ID(long ACCOUNT_ID)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence().removeByACCOUNT_ID(ACCOUNT_ID);
	}

	/**
	* Returns the number of fund account registrations where ACCOUNT_ID = &#63;.
	*
	* @param ACCOUNT_ID the account_id
	* @return the number of matching fund account registrations
	*/
	public static int countByACCOUNT_ID(long ACCOUNT_ID) {
		return getPersistence().countByACCOUNT_ID(ACCOUNT_ID);
	}

	/**
	* Returns all the fund account registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching fund account registrations
	*/
	public static List<FundAccountRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns a range of all the fund account registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @return the range of matching fund account registrations
	*/
	public static List<FundAccountRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

	/**
	* Returns an ordered range of all the fund account registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund account registrations
	*/
	public static List<FundAccountRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund account registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund account registrations
	*/
	public static List<FundAccountRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration findByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration findByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public static FundAccountRegistration fetchByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the fund account registrations before and after the current fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param ACCOUNT_ID the primary key of the current fund account registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund account registration
	* @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	*/
	public static FundAccountRegistration[] findByPROJECT_ID_PrevAndNext(
		long ACCOUNT_ID, long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(ACCOUNT_ID, PROJECT_ID,
			orderByComparator);
	}

	/**
	* Removes all the fund account registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of fund account registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching fund account registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Caches the fund account registration in the entity cache if it is enabled.
	*
	* @param fundAccountRegistration the fund account registration
	*/
	public static void cacheResult(
		FundAccountRegistration fundAccountRegistration) {
		getPersistence().cacheResult(fundAccountRegistration);
	}

	/**
	* Caches the fund account registrations in the entity cache if it is enabled.
	*
	* @param fundAccountRegistrations the fund account registrations
	*/
	public static void cacheResult(
		List<FundAccountRegistration> fundAccountRegistrations) {
		getPersistence().cacheResult(fundAccountRegistrations);
	}

	/**
	* Creates a new fund account registration with the primary key. Does not add the fund account registration to the database.
	*
	* @param ACCOUNT_ID the primary key for the new fund account registration
	* @return the new fund account registration
	*/
	public static FundAccountRegistration create(long ACCOUNT_ID) {
		return getPersistence().create(ACCOUNT_ID);
	}

	/**
	* Removes the fund account registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ACCOUNT_ID the primary key of the fund account registration
	* @return the fund account registration that was removed
	* @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	*/
	public static FundAccountRegistration remove(long ACCOUNT_ID)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence().remove(ACCOUNT_ID);
	}

	public static FundAccountRegistration updateImpl(
		FundAccountRegistration fundAccountRegistration) {
		return getPersistence().updateImpl(fundAccountRegistration);
	}

	/**
	* Returns the fund account registration with the primary key or throws a {@link NoSuchFundAccountRegistrationException} if it could not be found.
	*
	* @param ACCOUNT_ID the primary key of the fund account registration
	* @return the fund account registration
	* @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	*/
	public static FundAccountRegistration findByPrimaryKey(long ACCOUNT_ID)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return getPersistence().findByPrimaryKey(ACCOUNT_ID);
	}

	/**
	* Returns the fund account registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ACCOUNT_ID the primary key of the fund account registration
	* @return the fund account registration, or <code>null</code> if a fund account registration with the primary key could not be found
	*/
	public static FundAccountRegistration fetchByPrimaryKey(long ACCOUNT_ID) {
		return getPersistence().fetchByPrimaryKey(ACCOUNT_ID);
	}

	public static java.util.Map<java.io.Serializable, FundAccountRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the fund account registrations.
	*
	* @return the fund account registrations
	*/
	public static List<FundAccountRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fund account registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @return the range of fund account registrations
	*/
	public static List<FundAccountRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fund account registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fund account registrations
	*/
	public static List<FundAccountRegistration> findAll(int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund account registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of fund account registrations
	*/
	public static List<FundAccountRegistration> findAll(int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the fund account registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fund account registrations.
	*
	* @return the number of fund account registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FundAccountRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FundAccountRegistrationPersistence, FundAccountRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FundAccountRegistrationPersistence.class);

		ServiceTracker<FundAccountRegistrationPersistence, FundAccountRegistrationPersistence> serviceTracker =
			new ServiceTracker<FundAccountRegistrationPersistence, FundAccountRegistrationPersistence>(bundle.getBundleContext(),
				FundAccountRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}