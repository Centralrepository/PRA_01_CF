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

import com.crowd.funding.database.model.ProjectPriorityRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project priority registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.ProjectPriorityRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPriorityRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.ProjectPriorityRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectPriorityRegistrationUtil {
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
		ProjectPriorityRegistration projectPriorityRegistration) {
		getPersistence().clearCache(projectPriorityRegistration);
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
	public static List<ProjectPriorityRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectPriorityRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectPriorityRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectPriorityRegistration update(
		ProjectPriorityRegistration projectPriorityRegistration) {
		return getPersistence().update(projectPriorityRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectPriorityRegistration update(
		ProjectPriorityRegistration projectPriorityRegistration,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(projectPriorityRegistration, serviceContext);
	}

	/**
	* Returns all the project priority registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the project priority registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @return the range of matching project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the project priority registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project priority registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project priority registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project priority registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project priority registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project priority registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project priority registrations before and after the current project priority registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the current project priority registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	*/
	public static ProjectPriorityRegistration[] findByUuid_PrevAndNext(
		long PROJECT_PRIORITY_ID, String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_PRIORITY_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the project priority registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project priority registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project priority registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the project priority registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectPriorityRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration findByPROJECT_ID(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project priority registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration fetchByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().fetchByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project priority registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration fetchByPROJECT_ID(
		long PROJECT_ID, boolean retrieveFromCache) {
		return getPersistence().fetchByPROJECT_ID(PROJECT_ID, retrieveFromCache);
	}

	/**
	* Removes the project priority registration where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @return the project priority registration that was removed
	*/
	public static ProjectPriorityRegistration removeByPROJECT_ID(
		long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of project priority registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project priority registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns all the project priority registrations where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @return the matching project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findByPRIORITY(int PRIORITY) {
		return getPersistence().findByPRIORITY(PRIORITY);
	}

	/**
	* Returns a range of all the project priority registrations where PRIORITY = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PRIORITY the priority
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @return the range of matching project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findByPRIORITY(
		int PRIORITY, int start, int end) {
		return getPersistence().findByPRIORITY(PRIORITY, start, end);
	}

	/**
	* Returns an ordered range of all the project priority registrations where PRIORITY = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PRIORITY the priority
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findByPRIORITY(
		int PRIORITY, int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return getPersistence()
				   .findByPRIORITY(PRIORITY, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project priority registrations where PRIORITY = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PRIORITY the priority
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findByPRIORITY(
		int PRIORITY, int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPRIORITY(PRIORITY, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration findByPRIORITY_First(
		int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().findByPRIORITY_First(PRIORITY, orderByComparator);
	}

	/**
	* Returns the first project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration fetchByPRIORITY_First(
		int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPRIORITY_First(PRIORITY, orderByComparator);
	}

	/**
	* Returns the last project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration findByPRIORITY_Last(
		int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().findByPRIORITY_Last(PRIORITY, orderByComparator);
	}

	/**
	* Returns the last project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration fetchByPRIORITY_Last(
		int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return getPersistence().fetchByPRIORITY_Last(PRIORITY, orderByComparator);
	}

	/**
	* Returns the project priority registrations before and after the current project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the current project priority registration
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	*/
	public static ProjectPriorityRegistration[] findByPRIORITY_PrevAndNext(
		long PROJECT_PRIORITY_ID, int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence()
				   .findByPRIORITY_PrevAndNext(PROJECT_PRIORITY_ID, PRIORITY,
			orderByComparator);
	}

	/**
	* Removes all the project priority registrations where PRIORITY = &#63; from the database.
	*
	* @param PRIORITY the priority
	*/
	public static void removeByPRIORITY(int PRIORITY) {
		getPersistence().removeByPRIORITY(PRIORITY);
	}

	/**
	* Returns the number of project priority registrations where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @return the number of matching project priority registrations
	*/
	public static int countByPRIORITY(int PRIORITY) {
		return getPersistence().countByPRIORITY(PRIORITY);
	}

	/**
	* Returns the project priority registration where PRIORITY_SEQUANCE = &#63; or throws a {@link NoSuchProjectPriorityRegistrationException} if it could not be found.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @return the matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration findByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().findByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);
	}

	/**
	* Returns the project priority registration where PRIORITY_SEQUANCE = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration fetchByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE) {
		return getPersistence().fetchByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);
	}

	/**
	* Returns the project priority registration where PRIORITY_SEQUANCE = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public static ProjectPriorityRegistration fetchByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE,
			retrieveFromCache);
	}

	/**
	* Removes the project priority registration where PRIORITY_SEQUANCE = &#63; from the database.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @return the project priority registration that was removed
	*/
	public static ProjectPriorityRegistration removeByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().removeByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);
	}

	/**
	* Returns the number of project priority registrations where PRIORITY_SEQUANCE = &#63;.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @return the number of matching project priority registrations
	*/
	public static int countByPRIORITY_SEQUANCE(int PRIORITY_SEQUANCE) {
		return getPersistence().countByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);
	}

	/**
	* Caches the project priority registration in the entity cache if it is enabled.
	*
	* @param projectPriorityRegistration the project priority registration
	*/
	public static void cacheResult(
		ProjectPriorityRegistration projectPriorityRegistration) {
		getPersistence().cacheResult(projectPriorityRegistration);
	}

	/**
	* Caches the project priority registrations in the entity cache if it is enabled.
	*
	* @param projectPriorityRegistrations the project priority registrations
	*/
	public static void cacheResult(
		List<ProjectPriorityRegistration> projectPriorityRegistrations) {
		getPersistence().cacheResult(projectPriorityRegistrations);
	}

	/**
	* Creates a new project priority registration with the primary key. Does not add the project priority registration to the database.
	*
	* @param PROJECT_PRIORITY_ID the primary key for the new project priority registration
	* @return the new project priority registration
	*/
	public static ProjectPriorityRegistration create(long PROJECT_PRIORITY_ID) {
		return getPersistence().create(PROJECT_PRIORITY_ID);
	}

	/**
	* Removes the project priority registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration that was removed
	* @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	*/
	public static ProjectPriorityRegistration remove(long PROJECT_PRIORITY_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().remove(PROJECT_PRIORITY_ID);
	}

	public static ProjectPriorityRegistration updateImpl(
		ProjectPriorityRegistration projectPriorityRegistration) {
		return getPersistence().updateImpl(projectPriorityRegistration);
	}

	/**
	* Returns the project priority registration with the primary key or throws a {@link NoSuchProjectPriorityRegistrationException} if it could not be found.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	*/
	public static ProjectPriorityRegistration findByPrimaryKey(
		long PROJECT_PRIORITY_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_PRIORITY_ID);
	}

	/**
	* Returns the project priority registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration, or <code>null</code> if a project priority registration with the primary key could not be found
	*/
	public static ProjectPriorityRegistration fetchByPrimaryKey(
		long PROJECT_PRIORITY_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_PRIORITY_ID);
	}

	public static java.util.Map<java.io.Serializable, ProjectPriorityRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project priority registrations.
	*
	* @return the project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project priority registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @return the range of project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project priority registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findAll(int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project priority registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project priority registrations
	*/
	public static List<ProjectPriorityRegistration> findAll(int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project priority registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project priority registrations.
	*
	* @return the number of project priority registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectPriorityRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectPriorityRegistrationPersistence, ProjectPriorityRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectPriorityRegistrationPersistence.class);

		ServiceTracker<ProjectPriorityRegistrationPersistence, ProjectPriorityRegistrationPersistence> serviceTracker =
			new ServiceTracker<ProjectPriorityRegistrationPersistence, ProjectPriorityRegistrationPersistence>(bundle.getBundleContext(),
				ProjectPriorityRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}