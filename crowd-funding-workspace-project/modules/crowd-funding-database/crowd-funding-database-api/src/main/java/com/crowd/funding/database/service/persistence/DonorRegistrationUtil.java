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

import com.crowd.funding.database.model.DonorRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the donor registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.DonorRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DonorRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.DonorRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class DonorRegistrationUtil {
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
	public static void clearCache(DonorRegistration donorRegistration) {
		getPersistence().clearCache(donorRegistration);
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
	public static List<DonorRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DonorRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DonorRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DonorRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DonorRegistration update(DonorRegistration donorRegistration) {
		return getPersistence().update(donorRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DonorRegistration update(
		DonorRegistration donorRegistration, ServiceContext serviceContext) {
		return getPersistence().update(donorRegistration, serviceContext);
	}

	/**
	* Returns all the donor registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching donor registrations
	*/
	public static List<DonorRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the donor registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @return the range of matching donor registrations
	*/
	public static List<DonorRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the donor registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching donor registrations
	*/
	public static List<DonorRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<DonorRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the donor registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching donor registrations
	*/
	public static List<DonorRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<DonorRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first donor registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching donor registration
	* @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	*/
	public static DonorRegistration findByUuid_First(String uuid,
		OrderByComparator<DonorRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first donor registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public static DonorRegistration fetchByUuid_First(String uuid,
		OrderByComparator<DonorRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last donor registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching donor registration
	* @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	*/
	public static DonorRegistration findByUuid_Last(String uuid,
		OrderByComparator<DonorRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last donor registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public static DonorRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<DonorRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the donor registrations before and after the current donor registration in the ordered set where uuid = &#63;.
	*
	* @param DONOR_ID the primary key of the current donor registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next donor registration
	* @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	*/
	public static DonorRegistration[] findByUuid_PrevAndNext(long DONOR_ID,
		String uuid, OrderByComparator<DonorRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(DONOR_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the donor registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of donor registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching donor registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the donor registration where MOBILE_NO = &#63; or throws a {@link NoSuchDonorRegistrationException} if it could not be found.
	*
	* @param MOBILE_NO the mobile_no
	* @return the matching donor registration
	* @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	*/
	public static DonorRegistration findByMOBILE_NO(long MOBILE_NO)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return getPersistence().findByMOBILE_NO(MOBILE_NO);
	}

	/**
	* Returns the donor registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param MOBILE_NO the mobile_no
	* @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public static DonorRegistration fetchByMOBILE_NO(long MOBILE_NO) {
		return getPersistence().fetchByMOBILE_NO(MOBILE_NO);
	}

	/**
	* Returns the donor registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param MOBILE_NO the mobile_no
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public static DonorRegistration fetchByMOBILE_NO(long MOBILE_NO,
		boolean retrieveFromCache) {
		return getPersistence().fetchByMOBILE_NO(MOBILE_NO, retrieveFromCache);
	}

	/**
	* Removes the donor registration where MOBILE_NO = &#63; from the database.
	*
	* @param MOBILE_NO the mobile_no
	* @return the donor registration that was removed
	*/
	public static DonorRegistration removeByMOBILE_NO(long MOBILE_NO)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return getPersistence().removeByMOBILE_NO(MOBILE_NO);
	}

	/**
	* Returns the number of donor registrations where MOBILE_NO = &#63;.
	*
	* @param MOBILE_NO the mobile_no
	* @return the number of matching donor registrations
	*/
	public static int countByMOBILE_NO(long MOBILE_NO) {
		return getPersistence().countByMOBILE_NO(MOBILE_NO);
	}

	/**
	* Returns the donor registration where DONOR_ID = &#63; or throws a {@link NoSuchDonorRegistrationException} if it could not be found.
	*
	* @param DONOR_ID the donor_id
	* @return the matching donor registration
	* @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	*/
	public static DonorRegistration findByDONOR_ID(long DONOR_ID)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return getPersistence().findByDONOR_ID(DONOR_ID);
	}

	/**
	* Returns the donor registration where DONOR_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param DONOR_ID the donor_id
	* @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public static DonorRegistration fetchByDONOR_ID(long DONOR_ID) {
		return getPersistence().fetchByDONOR_ID(DONOR_ID);
	}

	/**
	* Returns the donor registration where DONOR_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param DONOR_ID the donor_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public static DonorRegistration fetchByDONOR_ID(long DONOR_ID,
		boolean retrieveFromCache) {
		return getPersistence().fetchByDONOR_ID(DONOR_ID, retrieveFromCache);
	}

	/**
	* Removes the donor registration where DONOR_ID = &#63; from the database.
	*
	* @param DONOR_ID the donor_id
	* @return the donor registration that was removed
	*/
	public static DonorRegistration removeByDONOR_ID(long DONOR_ID)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return getPersistence().removeByDONOR_ID(DONOR_ID);
	}

	/**
	* Returns the number of donor registrations where DONOR_ID = &#63;.
	*
	* @param DONOR_ID the donor_id
	* @return the number of matching donor registrations
	*/
	public static int countByDONOR_ID(long DONOR_ID) {
		return getPersistence().countByDONOR_ID(DONOR_ID);
	}

	/**
	* Caches the donor registration in the entity cache if it is enabled.
	*
	* @param donorRegistration the donor registration
	*/
	public static void cacheResult(DonorRegistration donorRegistration) {
		getPersistence().cacheResult(donorRegistration);
	}

	/**
	* Caches the donor registrations in the entity cache if it is enabled.
	*
	* @param donorRegistrations the donor registrations
	*/
	public static void cacheResult(List<DonorRegistration> donorRegistrations) {
		getPersistence().cacheResult(donorRegistrations);
	}

	/**
	* Creates a new donor registration with the primary key. Does not add the donor registration to the database.
	*
	* @param DONOR_ID the primary key for the new donor registration
	* @return the new donor registration
	*/
	public static DonorRegistration create(long DONOR_ID) {
		return getPersistence().create(DONOR_ID);
	}

	/**
	* Removes the donor registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param DONOR_ID the primary key of the donor registration
	* @return the donor registration that was removed
	* @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	*/
	public static DonorRegistration remove(long DONOR_ID)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return getPersistence().remove(DONOR_ID);
	}

	public static DonorRegistration updateImpl(
		DonorRegistration donorRegistration) {
		return getPersistence().updateImpl(donorRegistration);
	}

	/**
	* Returns the donor registration with the primary key or throws a {@link NoSuchDonorRegistrationException} if it could not be found.
	*
	* @param DONOR_ID the primary key of the donor registration
	* @return the donor registration
	* @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	*/
	public static DonorRegistration findByPrimaryKey(long DONOR_ID)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return getPersistence().findByPrimaryKey(DONOR_ID);
	}

	/**
	* Returns the donor registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param DONOR_ID the primary key of the donor registration
	* @return the donor registration, or <code>null</code> if a donor registration with the primary key could not be found
	*/
	public static DonorRegistration fetchByPrimaryKey(long DONOR_ID) {
		return getPersistence().fetchByPrimaryKey(DONOR_ID);
	}

	public static java.util.Map<java.io.Serializable, DonorRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the donor registrations.
	*
	* @return the donor registrations
	*/
	public static List<DonorRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the donor registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @return the range of donor registrations
	*/
	public static List<DonorRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the donor registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of donor registrations
	*/
	public static List<DonorRegistration> findAll(int start, int end,
		OrderByComparator<DonorRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the donor registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of donor registrations
	*/
	public static List<DonorRegistration> findAll(int start, int end,
		OrderByComparator<DonorRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the donor registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of donor registrations.
	*
	* @return the number of donor registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DonorRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DonorRegistrationPersistence, DonorRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DonorRegistrationPersistence.class);

		ServiceTracker<DonorRegistrationPersistence, DonorRegistrationPersistence> serviceTracker =
			new ServiceTracker<DonorRegistrationPersistence, DonorRegistrationPersistence>(bundle.getBundleContext(),
				DonorRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}