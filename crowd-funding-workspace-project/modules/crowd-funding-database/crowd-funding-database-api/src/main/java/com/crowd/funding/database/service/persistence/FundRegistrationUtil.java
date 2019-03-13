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

import com.crowd.funding.database.model.FundRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the fund registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.FundRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.FundRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class FundRegistrationUtil {
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
	public static void clearCache(FundRegistration fundRegistration) {
		getPersistence().clearCache(fundRegistration);
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
	public static List<FundRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FundRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FundRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FundRegistration update(FundRegistration fundRegistration) {
		return getPersistence().update(fundRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FundRegistration update(FundRegistration fundRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(fundRegistration, serviceContext);
	}

	/**
	* Returns all the fund registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching fund registrations
	*/
	public static List<FundRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the fund registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of matching fund registrations
	*/
	public static List<FundRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the fund registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund registrations
	*/
	public static List<FundRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund registrations
	*/
	public static List<FundRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first fund registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public static FundRegistration findByUuid_First(String uuid,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first fund registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByUuid_First(String uuid,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last fund registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public static FundRegistration findByUuid_Last(String uuid,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last fund registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the fund registrations before and after the current fund registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_FUND_ID the primary key of the current fund registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public static FundRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FUND_ID, String uuid,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_FUND_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the fund registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of fund registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching fund registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the fund registration where PROJECT_FUND_ID = &#63; or throws a {@link NoSuchFundRegistrationException} if it could not be found.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @return the matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public static FundRegistration findByPROJECT_FUND_ID(long PROJECT_FUND_ID)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence().findByPROJECT_FUND_ID(PROJECT_FUND_ID);
	}

	/**
	* Returns the fund registration where PROJECT_FUND_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @return the matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByPROJECT_FUND_ID(long PROJECT_FUND_ID) {
		return getPersistence().fetchByPROJECT_FUND_ID(PROJECT_FUND_ID);
	}

	/**
	* Returns the fund registration where PROJECT_FUND_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByPROJECT_FUND_ID(
		long PROJECT_FUND_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_FUND_ID(PROJECT_FUND_ID, retrieveFromCache);
	}

	/**
	* Removes the fund registration where PROJECT_FUND_ID = &#63; from the database.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @return the fund registration that was removed
	*/
	public static FundRegistration removeByPROJECT_FUND_ID(long PROJECT_FUND_ID)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence().removeByPROJECT_FUND_ID(PROJECT_FUND_ID);
	}

	/**
	* Returns the number of fund registrations where PROJECT_FUND_ID = &#63;.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @return the number of matching fund registrations
	*/
	public static int countByPROJECT_FUND_ID(long PROJECT_FUND_ID) {
		return getPersistence().countByPROJECT_FUND_ID(PROJECT_FUND_ID);
	}

	/**
	* Returns all the fund registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching fund registrations
	*/
	public static List<FundRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns a range of all the fund registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of matching fund registrations
	*/
	public static List<FundRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

	/**
	* Returns an ordered range of all the fund registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund registrations
	*/
	public static List<FundRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund registrations
	*/
	public static List<FundRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public static FundRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public static FundRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the fund registrations before and after the current fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_FUND_ID the primary key of the current fund registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public static FundRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FUND_ID, long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_FUND_ID, PROJECT_ID,
			orderByComparator);
	}

	/**
	* Removes all the fund registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of fund registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching fund registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns all the fund registrations where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @return the matching fund registrations
	*/
	public static List<FundRegistration> findByDONOR_USER_ID(long DONOR_USER_ID) {
		return getPersistence().findByDONOR_USER_ID(DONOR_USER_ID);
	}

	/**
	* Returns a range of all the fund registrations where DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of matching fund registrations
	*/
	public static List<FundRegistration> findByDONOR_USER_ID(
		long DONOR_USER_ID, int start, int end) {
		return getPersistence().findByDONOR_USER_ID(DONOR_USER_ID, start, end);
	}

	/**
	* Returns an ordered range of all the fund registrations where DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund registrations
	*/
	public static List<FundRegistration> findByDONOR_USER_ID(
		long DONOR_USER_ID, int start, int end,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .findByDONOR_USER_ID(DONOR_USER_ID, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund registrations where DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund registrations
	*/
	public static List<FundRegistration> findByDONOR_USER_ID(
		long DONOR_USER_ID, int start, int end,
		OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDONOR_USER_ID(DONOR_USER_ID, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public static FundRegistration findByDONOR_USER_ID_First(
		long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByDONOR_USER_ID_First(DONOR_USER_ID, orderByComparator);
	}

	/**
	* Returns the first fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByDONOR_USER_ID_First(
		long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByDONOR_USER_ID_First(DONOR_USER_ID, orderByComparator);
	}

	/**
	* Returns the last fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public static FundRegistration findByDONOR_USER_ID_Last(
		long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByDONOR_USER_ID_Last(DONOR_USER_ID, orderByComparator);
	}

	/**
	* Returns the last fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByDONOR_USER_ID_Last(
		long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByDONOR_USER_ID_Last(DONOR_USER_ID, orderByComparator);
	}

	/**
	* Returns the fund registrations before and after the current fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_FUND_ID the primary key of the current fund registration
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public static FundRegistration[] findByDONOR_USER_ID_PrevAndNext(
		long PROJECT_FUND_ID, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByDONOR_USER_ID_PrevAndNext(PROJECT_FUND_ID,
			DONOR_USER_ID, orderByComparator);
	}

	/**
	* Removes all the fund registrations where DONOR_USER_ID = &#63; from the database.
	*
	* @param DONOR_USER_ID the donor_user_id
	*/
	public static void removeByDONOR_USER_ID(long DONOR_USER_ID) {
		getPersistence().removeByDONOR_USER_ID(DONOR_USER_ID);
	}

	/**
	* Returns the number of fund registrations where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @return the number of matching fund registrations
	*/
	public static int countByDONOR_USER_ID(long DONOR_USER_ID) {
		return getPersistence().countByDONOR_USER_ID(DONOR_USER_ID);
	}

	/**
	* Returns all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @return the matching fund registrations
	*/
	public static List<FundRegistration> findByPROJECT_DONOR_USER_ID(
		long PROJECT_ID, long DONOR_USER_ID) {
		return getPersistence()
				   .findByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID);
	}

	/**
	* Returns a range of all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of matching fund registrations
	*/
	public static List<FundRegistration> findByPROJECT_DONOR_USER_ID(
		long PROJECT_ID, long DONOR_USER_ID, int start, int end) {
		return getPersistence()
				   .findByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID,
			start, end);
	}

	/**
	* Returns an ordered range of all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund registrations
	*/
	public static List<FundRegistration> findByPROJECT_DONOR_USER_ID(
		long PROJECT_ID, long DONOR_USER_ID, int start, int end,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund registrations
	*/
	public static List<FundRegistration> findByPROJECT_DONOR_USER_ID(
		long PROJECT_ID, long DONOR_USER_ID, int start, int end,
		OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public static FundRegistration findByPROJECT_DONOR_USER_ID_First(
		long PROJECT_ID, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByPROJECT_DONOR_USER_ID_First(PROJECT_ID,
			DONOR_USER_ID, orderByComparator);
	}

	/**
	* Returns the first fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByPROJECT_DONOR_USER_ID_First(
		long PROJECT_ID, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_DONOR_USER_ID_First(PROJECT_ID,
			DONOR_USER_ID, orderByComparator);
	}

	/**
	* Returns the last fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public static FundRegistration findByPROJECT_DONOR_USER_ID_Last(
		long PROJECT_ID, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByPROJECT_DONOR_USER_ID_Last(PROJECT_ID, DONOR_USER_ID,
			orderByComparator);
	}

	/**
	* Returns the last fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public static FundRegistration fetchByPROJECT_DONOR_USER_ID_Last(
		long PROJECT_ID, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_DONOR_USER_ID_Last(PROJECT_ID,
			DONOR_USER_ID, orderByComparator);
	}

	/**
	* Returns the fund registrations before and after the current fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_FUND_ID the primary key of the current fund registration
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public static FundRegistration[] findByPROJECT_DONOR_USER_ID_PrevAndNext(
		long PROJECT_FUND_ID, long PROJECT_ID, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence()
				   .findByPROJECT_DONOR_USER_ID_PrevAndNext(PROJECT_FUND_ID,
			PROJECT_ID, DONOR_USER_ID, orderByComparator);
	}

	/**
	* Removes all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	*/
	public static void removeByPROJECT_DONOR_USER_ID(long PROJECT_ID,
		long DONOR_USER_ID) {
		getPersistence().removeByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID);
	}

	/**
	* Returns the number of fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @return the number of matching fund registrations
	*/
	public static int countByPROJECT_DONOR_USER_ID(long PROJECT_ID,
		long DONOR_USER_ID) {
		return getPersistence()
				   .countByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID);
	}

	/**
	* Caches the fund registration in the entity cache if it is enabled.
	*
	* @param fundRegistration the fund registration
	*/
	public static void cacheResult(FundRegistration fundRegistration) {
		getPersistence().cacheResult(fundRegistration);
	}

	/**
	* Caches the fund registrations in the entity cache if it is enabled.
	*
	* @param fundRegistrations the fund registrations
	*/
	public static void cacheResult(List<FundRegistration> fundRegistrations) {
		getPersistence().cacheResult(fundRegistrations);
	}

	/**
	* Creates a new fund registration with the primary key. Does not add the fund registration to the database.
	*
	* @param PROJECT_FUND_ID the primary key for the new fund registration
	* @return the new fund registration
	*/
	public static FundRegistration create(long PROJECT_FUND_ID) {
		return getPersistence().create(PROJECT_FUND_ID);
	}

	/**
	* Removes the fund registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FUND_ID the primary key of the fund registration
	* @return the fund registration that was removed
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public static FundRegistration remove(long PROJECT_FUND_ID)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence().remove(PROJECT_FUND_ID);
	}

	public static FundRegistration updateImpl(FundRegistration fundRegistration) {
		return getPersistence().updateImpl(fundRegistration);
	}

	/**
	* Returns the fund registration with the primary key or throws a {@link NoSuchFundRegistrationException} if it could not be found.
	*
	* @param PROJECT_FUND_ID the primary key of the fund registration
	* @return the fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public static FundRegistration findByPrimaryKey(long PROJECT_FUND_ID)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_FUND_ID);
	}

	/**
	* Returns the fund registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_FUND_ID the primary key of the fund registration
	* @return the fund registration, or <code>null</code> if a fund registration with the primary key could not be found
	*/
	public static FundRegistration fetchByPrimaryKey(long PROJECT_FUND_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_FUND_ID);
	}

	public static java.util.Map<java.io.Serializable, FundRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the fund registrations.
	*
	* @return the fund registrations
	*/
	public static List<FundRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fund registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of fund registrations
	*/
	public static List<FundRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fund registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fund registrations
	*/
	public static List<FundRegistration> findAll(int start, int end,
		OrderByComparator<FundRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of fund registrations
	*/
	public static List<FundRegistration> findAll(int start, int end,
		OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the fund registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fund registrations.
	*
	* @return the number of fund registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FundRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FundRegistrationPersistence, FundRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FundRegistrationPersistence.class);

		ServiceTracker<FundRegistrationPersistence, FundRegistrationPersistence> serviceTracker =
			new ServiceTracker<FundRegistrationPersistence, FundRegistrationPersistence>(bundle.getBundleContext(),
				FundRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}