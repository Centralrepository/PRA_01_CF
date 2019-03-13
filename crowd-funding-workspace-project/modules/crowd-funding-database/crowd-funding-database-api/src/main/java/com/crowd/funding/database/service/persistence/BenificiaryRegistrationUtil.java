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

import com.crowd.funding.database.model.BenificiaryRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the benificiary registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.BenificiaryRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenificiaryRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.BenificiaryRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class BenificiaryRegistrationUtil {
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
		BenificiaryRegistration benificiaryRegistration) {
		getPersistence().clearCache(benificiaryRegistration);
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
	public static List<BenificiaryRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BenificiaryRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BenificiaryRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BenificiaryRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BenificiaryRegistration update(
		BenificiaryRegistration benificiaryRegistration) {
		return getPersistence().update(benificiaryRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BenificiaryRegistration update(
		BenificiaryRegistration benificiaryRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(benificiaryRegistration, serviceContext);
	}

	/**
	* Returns all the benificiary registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching benificiary registrations
	*/
	public static List<BenificiaryRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the benificiary registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @return the range of matching benificiary registrations
	*/
	public static List<BenificiaryRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the benificiary registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching benificiary registrations
	*/
	public static List<BenificiaryRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<BenificiaryRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the benificiary registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching benificiary registrations
	*/
	public static List<BenificiaryRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<BenificiaryRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a matching benificiary registration could not be found
	*/
	public static BenificiaryRegistration findByUuid_First(String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	*/
	public static BenificiaryRegistration fetchByUuid_First(String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a matching benificiary registration could not be found
	*/
	public static BenificiaryRegistration findByUuid_Last(String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	*/
	public static BenificiaryRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the benificiary registrations before and after the current benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param BENIFICIARY_ID the primary key of the current benificiary registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	*/
	public static BenificiaryRegistration[] findByUuid_PrevAndNext(
		long BENIFICIARY_ID, String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(BENIFICIARY_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the benificiary registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of benificiary registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching benificiary registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the benificiary registration where BENIFICIARY_ID = &#63; or throws a {@link NoSuchBenificiaryRegistrationException} if it could not be found.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the matching benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a matching benificiary registration could not be found
	*/
	public static BenificiaryRegistration findByBENIFICIARY_ID(
		long BENIFICIARY_ID)
		throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
		return getPersistence().findByBENIFICIARY_ID(BENIFICIARY_ID);
	}

	/**
	* Returns the benificiary registration where BENIFICIARY_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	*/
	public static BenificiaryRegistration fetchByBENIFICIARY_ID(
		long BENIFICIARY_ID) {
		return getPersistence().fetchByBENIFICIARY_ID(BENIFICIARY_ID);
	}

	/**
	* Returns the benificiary registration where BENIFICIARY_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	*/
	public static BenificiaryRegistration fetchByBENIFICIARY_ID(
		long BENIFICIARY_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByBENIFICIARY_ID(BENIFICIARY_ID, retrieveFromCache);
	}

	/**
	* Removes the benificiary registration where BENIFICIARY_ID = &#63; from the database.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the benificiary registration that was removed
	*/
	public static BenificiaryRegistration removeByBENIFICIARY_ID(
		long BENIFICIARY_ID)
		throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
		return getPersistence().removeByBENIFICIARY_ID(BENIFICIARY_ID);
	}

	/**
	* Returns the number of benificiary registrations where BENIFICIARY_ID = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the number of matching benificiary registrations
	*/
	public static int countByBENIFICIARY_ID(long BENIFICIARY_ID) {
		return getPersistence().countByBENIFICIARY_ID(BENIFICIARY_ID);
	}

	/**
	* Caches the benificiary registration in the entity cache if it is enabled.
	*
	* @param benificiaryRegistration the benificiary registration
	*/
	public static void cacheResult(
		BenificiaryRegistration benificiaryRegistration) {
		getPersistence().cacheResult(benificiaryRegistration);
	}

	/**
	* Caches the benificiary registrations in the entity cache if it is enabled.
	*
	* @param benificiaryRegistrations the benificiary registrations
	*/
	public static void cacheResult(
		List<BenificiaryRegistration> benificiaryRegistrations) {
		getPersistence().cacheResult(benificiaryRegistrations);
	}

	/**
	* Creates a new benificiary registration with the primary key. Does not add the benificiary registration to the database.
	*
	* @param BENIFICIARY_ID the primary key for the new benificiary registration
	* @return the new benificiary registration
	*/
	public static BenificiaryRegistration create(long BENIFICIARY_ID) {
		return getPersistence().create(BENIFICIARY_ID);
	}

	/**
	* Removes the benificiary registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration that was removed
	* @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	*/
	public static BenificiaryRegistration remove(long BENIFICIARY_ID)
		throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
		return getPersistence().remove(BENIFICIARY_ID);
	}

	public static BenificiaryRegistration updateImpl(
		BenificiaryRegistration benificiaryRegistration) {
		return getPersistence().updateImpl(benificiaryRegistration);
	}

	/**
	* Returns the benificiary registration with the primary key or throws a {@link NoSuchBenificiaryRegistrationException} if it could not be found.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	*/
	public static BenificiaryRegistration findByPrimaryKey(long BENIFICIARY_ID)
		throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
		return getPersistence().findByPrimaryKey(BENIFICIARY_ID);
	}

	/**
	* Returns the benificiary registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration, or <code>null</code> if a benificiary registration with the primary key could not be found
	*/
	public static BenificiaryRegistration fetchByPrimaryKey(long BENIFICIARY_ID) {
		return getPersistence().fetchByPrimaryKey(BENIFICIARY_ID);
	}

	public static java.util.Map<java.io.Serializable, BenificiaryRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the benificiary registrations.
	*
	* @return the benificiary registrations
	*/
	public static List<BenificiaryRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the benificiary registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @return the range of benificiary registrations
	*/
	public static List<BenificiaryRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the benificiary registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of benificiary registrations
	*/
	public static List<BenificiaryRegistration> findAll(int start, int end,
		OrderByComparator<BenificiaryRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the benificiary registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of benificiary registrations
	*/
	public static List<BenificiaryRegistration> findAll(int start, int end,
		OrderByComparator<BenificiaryRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the benificiary registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of benificiary registrations.
	*
	* @return the number of benificiary registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static BenificiaryRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BenificiaryRegistrationPersistence, BenificiaryRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BenificiaryRegistrationPersistence.class);

		ServiceTracker<BenificiaryRegistrationPersistence, BenificiaryRegistrationPersistence> serviceTracker =
			new ServiceTracker<BenificiaryRegistrationPersistence, BenificiaryRegistrationPersistence>(bundle.getBundleContext(),
				BenificiaryRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}