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

import com.crowd.funding.database.model.ProjectUpdateRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project update registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.ProjectUpdateRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUpdateRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.ProjectUpdateRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectUpdateRegistrationUtil {
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
		ProjectUpdateRegistration projectUpdateRegistration) {
		getPersistence().clearCache(projectUpdateRegistration);
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
	public static List<ProjectUpdateRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectUpdateRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectUpdateRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectUpdateRegistration update(
		ProjectUpdateRegistration projectUpdateRegistration) {
		return getPersistence().update(projectUpdateRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectUpdateRegistration update(
		ProjectUpdateRegistration projectUpdateRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(projectUpdateRegistration, serviceContext);
	}

	/**
	* Returns all the project update registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project update registrations
	*/
	public static List<ProjectUpdateRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the project update registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @return the range of matching project update registrations
	*/
	public static List<ProjectUpdateRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the project update registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project update registrations
	*/
	public static List<ProjectUpdateRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project update registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project update registrations
	*/
	public static List<ProjectUpdateRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project update registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project update registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project update registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project update registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project update registrations before and after the current project update registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_UPDATE_ID the primary key of the current project update registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	*/
	public static ProjectUpdateRegistration[] findByUuid_PrevAndNext(
		long PROJECT_UPDATE_ID, String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_UPDATE_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the project update registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project update registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project update registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the project update registration where PROJECT_UPDATE_ID = &#63; or throws a {@link NoSuchProjectUpdateRegistrationException} if it could not be found.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @return the matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration findByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence().findByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);
	}

	/**
	* Returns the project update registration where PROJECT_UPDATE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @return the matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration fetchByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID) {
		return getPersistence().fetchByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);
	}

	/**
	* Returns the project update registration where PROJECT_UPDATE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration fetchByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID,
			retrieveFromCache);
	}

	/**
	* Removes the project update registration where PROJECT_UPDATE_ID = &#63; from the database.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @return the project update registration that was removed
	*/
	public static ProjectUpdateRegistration removeByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence().removeByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);
	}

	/**
	* Returns the number of project update registrations where PROJECT_UPDATE_ID = &#63;.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @return the number of matching project update registrations
	*/
	public static int countByPROJECT_UPDATE_ID(long PROJECT_UPDATE_ID) {
		return getPersistence().countByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);
	}

	/**
	* Returns all the project update registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project update registrations
	*/
	public static List<ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns a range of all the project update registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @return the range of matching project update registrations
	*/
	public static List<ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

	/**
	* Returns an ordered range of all the project update registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project update registrations
	*/
	public static List<ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project update registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project update registrations
	*/
	public static List<ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration findByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration findByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public static ProjectUpdateRegistration fetchByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the project update registrations before and after the current project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_UPDATE_ID the primary key of the current project update registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	*/
	public static ProjectUpdateRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_UPDATE_ID, long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_UPDATE_ID, PROJECT_ID,
			orderByComparator);
	}

	/**
	* Removes all the project update registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of project update registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project update registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Caches the project update registration in the entity cache if it is enabled.
	*
	* @param projectUpdateRegistration the project update registration
	*/
	public static void cacheResult(
		ProjectUpdateRegistration projectUpdateRegistration) {
		getPersistence().cacheResult(projectUpdateRegistration);
	}

	/**
	* Caches the project update registrations in the entity cache if it is enabled.
	*
	* @param projectUpdateRegistrations the project update registrations
	*/
	public static void cacheResult(
		List<ProjectUpdateRegistration> projectUpdateRegistrations) {
		getPersistence().cacheResult(projectUpdateRegistrations);
	}

	/**
	* Creates a new project update registration with the primary key. Does not add the project update registration to the database.
	*
	* @param PROJECT_UPDATE_ID the primary key for the new project update registration
	* @return the new project update registration
	*/
	public static ProjectUpdateRegistration create(long PROJECT_UPDATE_ID) {
		return getPersistence().create(PROJECT_UPDATE_ID);
	}

	/**
	* Removes the project update registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration that was removed
	* @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	*/
	public static ProjectUpdateRegistration remove(long PROJECT_UPDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence().remove(PROJECT_UPDATE_ID);
	}

	public static ProjectUpdateRegistration updateImpl(
		ProjectUpdateRegistration projectUpdateRegistration) {
		return getPersistence().updateImpl(projectUpdateRegistration);
	}

	/**
	* Returns the project update registration with the primary key or throws a {@link NoSuchProjectUpdateRegistrationException} if it could not be found.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	*/
	public static ProjectUpdateRegistration findByPrimaryKey(
		long PROJECT_UPDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_UPDATE_ID);
	}

	/**
	* Returns the project update registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration, or <code>null</code> if a project update registration with the primary key could not be found
	*/
	public static ProjectUpdateRegistration fetchByPrimaryKey(
		long PROJECT_UPDATE_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_UPDATE_ID);
	}

	public static java.util.Map<java.io.Serializable, ProjectUpdateRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project update registrations.
	*
	* @return the project update registrations
	*/
	public static List<ProjectUpdateRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project update registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @return the range of project update registrations
	*/
	public static List<ProjectUpdateRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project update registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project update registrations
	*/
	public static List<ProjectUpdateRegistration> findAll(int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project update registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project update registrations
	*/
	public static List<ProjectUpdateRegistration> findAll(int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project update registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project update registrations.
	*
	* @return the number of project update registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectUpdateRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectUpdateRegistrationPersistence, ProjectUpdateRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectUpdateRegistrationPersistence.class);

		ServiceTracker<ProjectUpdateRegistrationPersistence, ProjectUpdateRegistrationPersistence> serviceTracker =
			new ServiceTracker<ProjectUpdateRegistrationPersistence, ProjectUpdateRegistrationPersistence>(bundle.getBundleContext(),
				ProjectUpdateRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}