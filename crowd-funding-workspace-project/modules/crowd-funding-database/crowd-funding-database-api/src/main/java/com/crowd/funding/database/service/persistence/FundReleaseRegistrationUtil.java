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

import com.crowd.funding.database.model.FundReleaseRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the fund release registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.FundReleaseRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundReleaseRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.FundReleaseRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class FundReleaseRegistrationUtil {
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
		FundReleaseRegistration fundReleaseRegistration) {
		getPersistence().clearCache(fundReleaseRegistration);
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
	public static List<FundReleaseRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FundReleaseRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FundReleaseRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FundReleaseRegistration update(
		FundReleaseRegistration fundReleaseRegistration) {
		return getPersistence().update(fundReleaseRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FundReleaseRegistration update(
		FundReleaseRegistration fundReleaseRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(fundReleaseRegistration, serviceContext);
	}

	/**
	* Returns all the fund release registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching fund release registrations
	*/
	public static List<FundReleaseRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the fund release registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @return the range of matching fund release registrations
	*/
	public static List<FundReleaseRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the fund release registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund release registrations
	*/
	public static List<FundReleaseRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund release registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund release registrations
	*/
	public static List<FundReleaseRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first fund release registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration findByUuid_First(String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first fund release registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration fetchByUuid_First(String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last fund release registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration findByUuid_Last(String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last fund release registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the fund release registrations before and after the current fund release registration in the ordered set where uuid = &#63;.
	*
	* @param FUND_RELEASE_ID the primary key of the current fund release registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	*/
	public static FundReleaseRegistration[] findByUuid_PrevAndNext(
		long FUND_RELEASE_ID, String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(FUND_RELEASE_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the fund release registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of fund release registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching fund release registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the fund release registration where FUND_RELEASE_ID = &#63; or throws a {@link NoSuchFundReleaseRegistrationException} if it could not be found.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @return the matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration findByFUND_RELEASE_ID(
		long FUND_RELEASE_ID)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence().findByFUND_RELEASE_ID(FUND_RELEASE_ID);
	}

	/**
	* Returns the fund release registration where FUND_RELEASE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @return the matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration fetchByFUND_RELEASE_ID(
		long FUND_RELEASE_ID) {
		return getPersistence().fetchByFUND_RELEASE_ID(FUND_RELEASE_ID);
	}

	/**
	* Returns the fund release registration where FUND_RELEASE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration fetchByFUND_RELEASE_ID(
		long FUND_RELEASE_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByFUND_RELEASE_ID(FUND_RELEASE_ID, retrieveFromCache);
	}

	/**
	* Removes the fund release registration where FUND_RELEASE_ID = &#63; from the database.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @return the fund release registration that was removed
	*/
	public static FundReleaseRegistration removeByFUND_RELEASE_ID(
		long FUND_RELEASE_ID)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence().removeByFUND_RELEASE_ID(FUND_RELEASE_ID);
	}

	/**
	* Returns the number of fund release registrations where FUND_RELEASE_ID = &#63;.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @return the number of matching fund release registrations
	*/
	public static int countByFUND_RELEASE_ID(long FUND_RELEASE_ID) {
		return getPersistence().countByFUND_RELEASE_ID(FUND_RELEASE_ID);
	}

	/**
	* Returns all the fund release registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching fund release registrations
	*/
	public static List<FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns a range of all the fund release registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @return the range of matching fund release registrations
	*/
	public static List<FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

	/**
	* Returns an ordered range of all the fund release registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund release registrations
	*/
	public static List<FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund release registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund release registrations
	*/
	public static List<FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration findByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration findByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public static FundReleaseRegistration fetchByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the fund release registrations before and after the current fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param FUND_RELEASE_ID the primary key of the current fund release registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	*/
	public static FundReleaseRegistration[] findByPROJECT_ID_PrevAndNext(
		long FUND_RELEASE_ID, long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(FUND_RELEASE_ID, PROJECT_ID,
			orderByComparator);
	}

	/**
	* Removes all the fund release registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of fund release registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching fund release registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Caches the fund release registration in the entity cache if it is enabled.
	*
	* @param fundReleaseRegistration the fund release registration
	*/
	public static void cacheResult(
		FundReleaseRegistration fundReleaseRegistration) {
		getPersistence().cacheResult(fundReleaseRegistration);
	}

	/**
	* Caches the fund release registrations in the entity cache if it is enabled.
	*
	* @param fundReleaseRegistrations the fund release registrations
	*/
	public static void cacheResult(
		List<FundReleaseRegistration> fundReleaseRegistrations) {
		getPersistence().cacheResult(fundReleaseRegistrations);
	}

	/**
	* Creates a new fund release registration with the primary key. Does not add the fund release registration to the database.
	*
	* @param FUND_RELEASE_ID the primary key for the new fund release registration
	* @return the new fund release registration
	*/
	public static FundReleaseRegistration create(long FUND_RELEASE_ID) {
		return getPersistence().create(FUND_RELEASE_ID);
	}

	/**
	* Removes the fund release registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration that was removed
	* @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	*/
	public static FundReleaseRegistration remove(long FUND_RELEASE_ID)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence().remove(FUND_RELEASE_ID);
	}

	public static FundReleaseRegistration updateImpl(
		FundReleaseRegistration fundReleaseRegistration) {
		return getPersistence().updateImpl(fundReleaseRegistration);
	}

	/**
	* Returns the fund release registration with the primary key or throws a {@link NoSuchFundReleaseRegistrationException} if it could not be found.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	*/
	public static FundReleaseRegistration findByPrimaryKey(long FUND_RELEASE_ID)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getPersistence().findByPrimaryKey(FUND_RELEASE_ID);
	}

	/**
	* Returns the fund release registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration, or <code>null</code> if a fund release registration with the primary key could not be found
	*/
	public static FundReleaseRegistration fetchByPrimaryKey(
		long FUND_RELEASE_ID) {
		return getPersistence().fetchByPrimaryKey(FUND_RELEASE_ID);
	}

	public static java.util.Map<java.io.Serializable, FundReleaseRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the fund release registrations.
	*
	* @return the fund release registrations
	*/
	public static List<FundReleaseRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fund release registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @return the range of fund release registrations
	*/
	public static List<FundReleaseRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fund release registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fund release registrations
	*/
	public static List<FundReleaseRegistration> findAll(int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the fund release registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of fund release registrations
	*/
	public static List<FundReleaseRegistration> findAll(int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the fund release registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fund release registrations.
	*
	* @return the number of fund release registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FundReleaseRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FundReleaseRegistrationPersistence, FundReleaseRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FundReleaseRegistrationPersistence.class);

		ServiceTracker<FundReleaseRegistrationPersistence, FundReleaseRegistrationPersistence> serviceTracker =
			new ServiceTracker<FundReleaseRegistrationPersistence, FundReleaseRegistrationPersistence>(bundle.getBundleContext(),
				FundReleaseRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}