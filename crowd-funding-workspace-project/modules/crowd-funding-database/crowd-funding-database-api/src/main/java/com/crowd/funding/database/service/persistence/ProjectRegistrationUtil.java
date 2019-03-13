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

import com.crowd.funding.database.model.ProjectRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.ProjectRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.ProjectRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectRegistrationUtil {
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
	public static void clearCache(ProjectRegistration projectRegistration) {
		getPersistence().clearCache(projectRegistration);
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
	public static List<ProjectRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectRegistration update(
		ProjectRegistration projectRegistration) {
		return getPersistence().update(projectRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectRegistration update(
		ProjectRegistration projectRegistration, ServiceContext serviceContext) {
		return getPersistence().update(projectRegistration, serviceContext);
	}

	/**
	* Returns all the project registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the project registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByUuid_PrevAndNext(
		long PROJECT_ID, String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the project registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the project registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByPROJECT_ID(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().fetchByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByPROJECT_ID(long PROJECT_ID,
		boolean retrieveFromCache) {
		return getPersistence().fetchByPROJECT_ID(PROJECT_ID, retrieveFromCache);
	}

	/**
	* Removes the project registration where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @return the project registration that was removed
	*/
	public static ProjectRegistration removeByPROJECT_ID(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of project registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns all the project registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByUSER_ID(long USER_ID) {
		return getPersistence().findByUSER_ID(USER_ID);
	}

	/**
	* Returns a range of all the project registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUSER_ID(long USER_ID,
		int start, int end) {
		return getPersistence().findByUSER_ID(USER_ID, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByUSER_ID_First(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByUSER_ID_First(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByUSER_ID_Last(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByUSER_ID_Last(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where USER_ID = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByUSER_ID_PrevAndNext(
		long PROJECT_ID, long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByUSER_ID_PrevAndNext(PROJECT_ID, USER_ID,
			orderByComparator);
	}

	/**
	* Removes all the project registrations where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	*/
	public static void removeByUSER_ID(long USER_ID) {
		getPersistence().removeByUSER_ID(USER_ID);
	}

	/**
	* Returns the number of project registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching project registrations
	*/
	public static int countByUSER_ID(long USER_ID) {
		return getPersistence().countByUSER_ID(USER_ID);
	}

	/**
	* Returns all the project registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findBySTATUS(int STATUS) {
		return getPersistence().findBySTATUS(STATUS);
	}

	/**
	* Returns a range of all the project registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findBySTATUS(int STATUS, int start,
		int end) {
		return getPersistence().findBySTATUS(STATUS, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where STATUS = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findBySTATUS_PrevAndNext(
		long PROJECT_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findBySTATUS_PrevAndNext(PROJECT_ID, STATUS,
			orderByComparator);
	}

	/**
	* Removes all the project registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public static void removeBySTATUS(int STATUS) {
		getPersistence().removeBySTATUS(STATUS);
	}

	/**
	* Returns the number of project registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching project registrations
	*/
	public static int countBySTATUS(int STATUS) {
		return getPersistence().countBySTATUS(STATUS);
	}

	/**
	* Caches the project registration in the entity cache if it is enabled.
	*
	* @param projectRegistration the project registration
	*/
	public static void cacheResult(ProjectRegistration projectRegistration) {
		getPersistence().cacheResult(projectRegistration);
	}

	/**
	* Caches the project registrations in the entity cache if it is enabled.
	*
	* @param projectRegistrations the project registrations
	*/
	public static void cacheResult(
		List<ProjectRegistration> projectRegistrations) {
		getPersistence().cacheResult(projectRegistrations);
	}

	/**
	* Creates a new project registration with the primary key. Does not add the project registration to the database.
	*
	* @param PROJECT_ID the primary key for the new project registration
	* @return the new project registration
	*/
	public static ProjectRegistration create(long PROJECT_ID) {
		return getPersistence().create(PROJECT_ID);
	}

	/**
	* Removes the project registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration that was removed
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration remove(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().remove(PROJECT_ID);
	}

	public static ProjectRegistration updateImpl(
		ProjectRegistration projectRegistration) {
		return getPersistence().updateImpl(projectRegistration);
	}

	/**
	* Returns the project registration with the primary key or throws a {@link NoSuchProjectRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration findByPrimaryKey(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_ID);
	}

	/**
	* Returns the project registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration, or <code>null</code> if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration fetchByPrimaryKey(long PROJECT_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_ID);
	}

	public static java.util.Map<java.io.Serializable, ProjectRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project registrations.
	*
	* @return the project registrations
	*/
	public static List<ProjectRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of project registrations
	*/
	public static List<ProjectRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project registrations
	*/
	public static List<ProjectRegistration> findAll(int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project registrations
	*/
	public static List<ProjectRegistration> findAll(int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project registrations.
	*
	* @return the number of project registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectRegistrationPersistence, ProjectRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectRegistrationPersistence.class);

		ServiceTracker<ProjectRegistrationPersistence, ProjectRegistrationPersistence> serviceTracker =
			new ServiceTracker<ProjectRegistrationPersistence, ProjectRegistrationPersistence>(bundle.getBundleContext(),
				ProjectRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}