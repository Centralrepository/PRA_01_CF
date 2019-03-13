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

import com.crowd.funding.database.model.UpdateRequesterRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the update requester registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.UpdateRequesterRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UpdateRequesterRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.UpdateRequesterRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class UpdateRequesterRegistrationUtil {
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
		UpdateRequesterRegistration updateRequesterRegistration) {
		getPersistence().clearCache(updateRequesterRegistration);
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
	public static List<UpdateRequesterRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UpdateRequesterRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UpdateRequesterRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UpdateRequesterRegistration update(
		UpdateRequesterRegistration updateRequesterRegistration) {
		return getPersistence().update(updateRequesterRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UpdateRequesterRegistration update(
		UpdateRequesterRegistration updateRequesterRegistration,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(updateRequesterRegistration, serviceContext);
	}

	/**
	* Returns all the update requester registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the update requester registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @return the range of matching update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the update requester registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the update requester registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first update requester registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration findByUuid_First(String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first update requester registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration fetchByUuid_First(String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last update requester registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration findByUuid_Last(String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last update requester registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the update requester registrations before and after the current update requester registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the current update requester registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	*/
	public static UpdateRequesterRegistration[] findByUuid_PrevAndNext(
		long PROJECT_UPDATE_REQUEST_ID, String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_UPDATE_REQUEST_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the update requester registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of update requester registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching update requester registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; or throws a {@link NoSuchUpdateRequesterRegistrationException} if it could not be found.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @return the matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration findByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence()
				   .findByPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* Returns the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @return the matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration fetchByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID) {
		return getPersistence()
				   .fetchByPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* Returns the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration fetchByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID,
			retrieveFromCache);
	}

	/**
	* Removes the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; from the database.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @return the update requester registration that was removed
	*/
	public static UpdateRequesterRegistration removeByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence()
				   .removeByPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* Returns the number of update requester registrations where PROJECT_UPDATE_REQUEST_ID = &#63;.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @return the number of matching update requester registrations
	*/
	public static int countByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID) {
		return getPersistence()
				   .countByPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* Returns all the update requester registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns a range of all the update requester registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @return the range of matching update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

	/**
	* Returns an ordered range of all the update requester registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the update requester registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration findByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration findByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public static UpdateRequesterRegistration fetchByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the update requester registrations before and after the current update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the current update requester registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	*/
	public static UpdateRequesterRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_UPDATE_REQUEST_ID, long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_UPDATE_REQUEST_ID,
			PROJECT_ID, orderByComparator);
	}

	/**
	* Removes all the update requester registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of update requester registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching update requester registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Caches the update requester registration in the entity cache if it is enabled.
	*
	* @param updateRequesterRegistration the update requester registration
	*/
	public static void cacheResult(
		UpdateRequesterRegistration updateRequesterRegistration) {
		getPersistence().cacheResult(updateRequesterRegistration);
	}

	/**
	* Caches the update requester registrations in the entity cache if it is enabled.
	*
	* @param updateRequesterRegistrations the update requester registrations
	*/
	public static void cacheResult(
		List<UpdateRequesterRegistration> updateRequesterRegistrations) {
		getPersistence().cacheResult(updateRequesterRegistrations);
	}

	/**
	* Creates a new update requester registration with the primary key. Does not add the update requester registration to the database.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key for the new update requester registration
	* @return the new update requester registration
	*/
	public static UpdateRequesterRegistration create(
		long PROJECT_UPDATE_REQUEST_ID) {
		return getPersistence().create(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* Removes the update requester registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	* @return the update requester registration that was removed
	* @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	*/
	public static UpdateRequesterRegistration remove(
		long PROJECT_UPDATE_REQUEST_ID)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence().remove(PROJECT_UPDATE_REQUEST_ID);
	}

	public static UpdateRequesterRegistration updateImpl(
		UpdateRequesterRegistration updateRequesterRegistration) {
		return getPersistence().updateImpl(updateRequesterRegistration);
	}

	/**
	* Returns the update requester registration with the primary key or throws a {@link NoSuchUpdateRequesterRegistrationException} if it could not be found.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	* @return the update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	*/
	public static UpdateRequesterRegistration findByPrimaryKey(
		long PROJECT_UPDATE_REQUEST_ID)
		throws com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	* Returns the update requester registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	* @return the update requester registration, or <code>null</code> if a update requester registration with the primary key could not be found
	*/
	public static UpdateRequesterRegistration fetchByPrimaryKey(
		long PROJECT_UPDATE_REQUEST_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_UPDATE_REQUEST_ID);
	}

	public static java.util.Map<java.io.Serializable, UpdateRequesterRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the update requester registrations.
	*
	* @return the update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the update requester registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @return the range of update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the update requester registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findAll(int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the update requester registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of update requester registrations
	*/
	public static List<UpdateRequesterRegistration> findAll(int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the update requester registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of update requester registrations.
	*
	* @return the number of update requester registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static UpdateRequesterRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UpdateRequesterRegistrationPersistence, UpdateRequesterRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UpdateRequesterRegistrationPersistence.class);

		ServiceTracker<UpdateRequesterRegistrationPersistence, UpdateRequesterRegistrationPersistence> serviceTracker =
			new ServiceTracker<UpdateRequesterRegistrationPersistence, UpdateRequesterRegistrationPersistence>(bundle.getBundleContext(),
				UpdateRequesterRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}