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

import com.crowd.funding.database.model.ProjectFollowerRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project follower registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.ProjectFollowerRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFollowerRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.ProjectFollowerRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectFollowerRegistrationUtil {
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
		ProjectFollowerRegistration projectFollowerRegistration) {
		getPersistence().clearCache(projectFollowerRegistration);
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
	public static List<ProjectFollowerRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectFollowerRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectFollowerRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectFollowerRegistration update(
		ProjectFollowerRegistration projectFollowerRegistration) {
		return getPersistence().update(projectFollowerRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectFollowerRegistration update(
		ProjectFollowerRegistration projectFollowerRegistration,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(projectFollowerRegistration, serviceContext);
	}

	/**
	* Returns all the project follower registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the project follower registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @return the range of matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the project follower registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project follower registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project follower registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project follower registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project follower registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project follower registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project follower registrations before and after the current project follower registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the current project follower registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public static ProjectFollowerRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FOLLOWER_ID, String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_FOLLOWER_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the project follower registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project follower registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project follower registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the project follower registration where PROJECT_FOLLOWER_ID = &#63; or throws a {@link NoSuchProjectFollowerRegistrationException} if it could not be found.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @return the matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration findByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().findByPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);
	}

	/**
	* Returns the project follower registration where PROJECT_FOLLOWER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID) {
		return getPersistence().fetchByPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);
	}

	/**
	* Returns the project follower registration where PROJECT_FOLLOWER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID,
			retrieveFromCache);
	}

	/**
	* Removes the project follower registration where PROJECT_FOLLOWER_ID = &#63; from the database.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @return the project follower registration that was removed
	*/
	public static ProjectFollowerRegistration removeByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().removeByPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);
	}

	/**
	* Returns the number of project follower registrations where PROJECT_FOLLOWER_ID = &#63;.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @return the number of matching project follower registrations
	*/
	public static int countByPROJECT_FOLLOWER_ID(long PROJECT_FOLLOWER_ID) {
		return getPersistence().countByPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);
	}

	/**
	* Returns all the project follower registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByUSER_ID(long USER_ID) {
		return getPersistence().findByUSER_ID(USER_ID);
	}

	/**
	* Returns a range of all the project follower registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @return the range of matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByUSER_ID(
		long USER_ID, int start, int end) {
		return getPersistence().findByUSER_ID(USER_ID, start, end);
	}

	/**
	* Returns an ordered range of all the project follower registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByUSER_ID(
		long USER_ID, int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project follower registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByUSER_ID(
		long USER_ID, int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration findByUSER_ID_First(
		long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().findByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the first project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByUSER_ID_First(
		long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the last project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration findByUSER_ID_Last(long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().findByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the last project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByUSER_ID_Last(
		long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the project follower registrations before and after the current project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the current project follower registration
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public static ProjectFollowerRegistration[] findByUSER_ID_PrevAndNext(
		long PROJECT_FOLLOWER_ID, long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence()
				   .findByUSER_ID_PrevAndNext(PROJECT_FOLLOWER_ID, USER_ID,
			orderByComparator);
	}

	/**
	* Removes all the project follower registrations where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	*/
	public static void removeByUSER_ID(long USER_ID) {
		getPersistence().removeByUSER_ID(USER_ID);
	}

	/**
	* Returns the number of project follower registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching project follower registrations
	*/
	public static int countByUSER_ID(long USER_ID) {
		return getPersistence().countByUSER_ID(USER_ID);
	}

	/**
	* Returns all the project follower registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns a range of all the project follower registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @return the range of matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

	/**
	* Returns an ordered range of all the project follower registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project follower registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration findByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration findByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the project follower registrations before and after the current project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the current project follower registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public static ProjectFollowerRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FOLLOWER_ID, long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_FOLLOWER_ID,
			PROJECT_ID, orderByComparator);
	}

	/**
	* Removes all the project follower registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of project follower registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project follower registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; or throws a {@link NoSuchProjectFollowerRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @return the matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration findByPROJECT_USER_ID(
		long PROJECT_ID, long USER_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().findByPROJECT_USER_ID(PROJECT_ID, USER_ID);
	}

	/**
	* Returns the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByPROJECT_USER_ID(
		long PROJECT_ID, long USER_ID) {
		return getPersistence().fetchByPROJECT_USER_ID(PROJECT_ID, USER_ID);
	}

	/**
	* Returns the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public static ProjectFollowerRegistration fetchByPROJECT_USER_ID(
		long PROJECT_ID, long USER_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_USER_ID(PROJECT_ID, USER_ID,
			retrieveFromCache);
	}

	/**
	* Removes the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @return the project follower registration that was removed
	*/
	public static ProjectFollowerRegistration removeByPROJECT_USER_ID(
		long PROJECT_ID, long USER_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().removeByPROJECT_USER_ID(PROJECT_ID, USER_ID);
	}

	/**
	* Returns the number of project follower registrations where PROJECT_ID = &#63; and USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @return the number of matching project follower registrations
	*/
	public static int countByPROJECT_USER_ID(long PROJECT_ID, long USER_ID) {
		return getPersistence().countByPROJECT_USER_ID(PROJECT_ID, USER_ID);
	}

	/**
	* Caches the project follower registration in the entity cache if it is enabled.
	*
	* @param projectFollowerRegistration the project follower registration
	*/
	public static void cacheResult(
		ProjectFollowerRegistration projectFollowerRegistration) {
		getPersistence().cacheResult(projectFollowerRegistration);
	}

	/**
	* Caches the project follower registrations in the entity cache if it is enabled.
	*
	* @param projectFollowerRegistrations the project follower registrations
	*/
	public static void cacheResult(
		List<ProjectFollowerRegistration> projectFollowerRegistrations) {
		getPersistence().cacheResult(projectFollowerRegistrations);
	}

	/**
	* Creates a new project follower registration with the primary key. Does not add the project follower registration to the database.
	*
	* @param PROJECT_FOLLOWER_ID the primary key for the new project follower registration
	* @return the new project follower registration
	*/
	public static ProjectFollowerRegistration create(long PROJECT_FOLLOWER_ID) {
		return getPersistence().create(PROJECT_FOLLOWER_ID);
	}

	/**
	* Removes the project follower registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	* @return the project follower registration that was removed
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public static ProjectFollowerRegistration remove(long PROJECT_FOLLOWER_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().remove(PROJECT_FOLLOWER_ID);
	}

	public static ProjectFollowerRegistration updateImpl(
		ProjectFollowerRegistration projectFollowerRegistration) {
		return getPersistence().updateImpl(projectFollowerRegistration);
	}

	/**
	* Returns the project follower registration with the primary key or throws a {@link NoSuchProjectFollowerRegistrationException} if it could not be found.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	* @return the project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public static ProjectFollowerRegistration findByPrimaryKey(
		long PROJECT_FOLLOWER_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_FOLLOWER_ID);
	}

	/**
	* Returns the project follower registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	* @return the project follower registration, or <code>null</code> if a project follower registration with the primary key could not be found
	*/
	public static ProjectFollowerRegistration fetchByPrimaryKey(
		long PROJECT_FOLLOWER_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_FOLLOWER_ID);
	}

	public static java.util.Map<java.io.Serializable, ProjectFollowerRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project follower registrations.
	*
	* @return the project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project follower registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @return the range of project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project follower registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findAll(int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project follower registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project follower registrations
	*/
	public static List<ProjectFollowerRegistration> findAll(int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project follower registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project follower registrations.
	*
	* @return the number of project follower registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectFollowerRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectFollowerRegistrationPersistence, ProjectFollowerRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectFollowerRegistrationPersistence.class);

		ServiceTracker<ProjectFollowerRegistrationPersistence, ProjectFollowerRegistrationPersistence> serviceTracker =
			new ServiceTracker<ProjectFollowerRegistrationPersistence, ProjectFollowerRegistrationPersistence>(bundle.getBundleContext(),
				ProjectFollowerRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}