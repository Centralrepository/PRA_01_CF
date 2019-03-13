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

import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project acknowledgement registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.ProjectAcknowledgementRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectAcknowledgementRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.ProjectAcknowledgementRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectAcknowledgementRegistrationUtil {
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
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		getPersistence().clearCache(projectAcknowledgementRegistration);
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
	public static List<ProjectAcknowledgementRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectAcknowledgementRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectAcknowledgementRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectAcknowledgementRegistration update(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		return getPersistence().update(projectAcknowledgementRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectAcknowledgementRegistration update(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(projectAcknowledgementRegistration, serviceContext);
	}

	/**
	* Returns all the project acknowledgement registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project acknowledgement registrations
	*/
	public static List<ProjectAcknowledgementRegistration> findByUuid(
		String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the project acknowledgement registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project acknowledgement registrations
	* @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	* @return the range of matching project acknowledgement registrations
	*/
	public static List<ProjectAcknowledgementRegistration> findByUuid(
		String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the project acknowledgement registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project acknowledgement registrations
	* @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project acknowledgement registrations
	*/
	public static List<ProjectAcknowledgementRegistration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project acknowledgement registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project acknowledgement registrations
	* @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project acknowledgement registrations
	*/
	public static List<ProjectAcknowledgementRegistration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a matching project acknowledgement registration could not be found
	*/
	public static ProjectAcknowledgementRegistration findByUuid_First(
		String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	*/
	public static ProjectAcknowledgementRegistration fetchByUuid_First(
		String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a matching project acknowledgement registration could not be found
	*/
	public static ProjectAcknowledgementRegistration findByUuid_Last(
		String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	*/
	public static ProjectAcknowledgementRegistration fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project acknowledgement registrations before and after the current project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the current project acknowledgement registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	*/
	public static ProjectAcknowledgementRegistration[] findByUuid_PrevAndNext(
		long ACKNOWLEDGMENT_ID, String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(ACKNOWLEDGMENT_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the project acknowledgement registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project acknowledgement registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project acknowledgement registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the project acknowledgement registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectAcknowledgementRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a matching project acknowledgement registration could not be found
	*/
	public static ProjectAcknowledgementRegistration findByPROJECT_ID(
		long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project acknowledgement registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	*/
	public static ProjectAcknowledgementRegistration fetchByPROJECT_ID(
		long PROJECT_ID) {
		return getPersistence().fetchByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project acknowledgement registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	*/
	public static ProjectAcknowledgementRegistration fetchByPROJECT_ID(
		long PROJECT_ID, boolean retrieveFromCache) {
		return getPersistence().fetchByPROJECT_ID(PROJECT_ID, retrieveFromCache);
	}

	/**
	* Removes the project acknowledgement registration where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @return the project acknowledgement registration that was removed
	*/
	public static ProjectAcknowledgementRegistration removeByPROJECT_ID(
		long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException {
		return getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of project acknowledgement registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project acknowledgement registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Caches the project acknowledgement registration in the entity cache if it is enabled.
	*
	* @param projectAcknowledgementRegistration the project acknowledgement registration
	*/
	public static void cacheResult(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		getPersistence().cacheResult(projectAcknowledgementRegistration);
	}

	/**
	* Caches the project acknowledgement registrations in the entity cache if it is enabled.
	*
	* @param projectAcknowledgementRegistrations the project acknowledgement registrations
	*/
	public static void cacheResult(
		List<ProjectAcknowledgementRegistration> projectAcknowledgementRegistrations) {
		getPersistence().cacheResult(projectAcknowledgementRegistrations);
	}

	/**
	* Creates a new project acknowledgement registration with the primary key. Does not add the project acknowledgement registration to the database.
	*
	* @param ACKNOWLEDGMENT_ID the primary key for the new project acknowledgement registration
	* @return the new project acknowledgement registration
	*/
	public static ProjectAcknowledgementRegistration create(
		long ACKNOWLEDGMENT_ID) {
		return getPersistence().create(ACKNOWLEDGMENT_ID);
	}

	/**
	* Removes the project acknowledgement registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration that was removed
	* @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	*/
	public static ProjectAcknowledgementRegistration remove(
		long ACKNOWLEDGMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException {
		return getPersistence().remove(ACKNOWLEDGMENT_ID);
	}

	public static ProjectAcknowledgementRegistration updateImpl(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		return getPersistence().updateImpl(projectAcknowledgementRegistration);
	}

	/**
	* Returns the project acknowledgement registration with the primary key or throws a {@link NoSuchProjectAcknowledgementRegistrationException} if it could not be found.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	*/
	public static ProjectAcknowledgementRegistration findByPrimaryKey(
		long ACKNOWLEDGMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException {
		return getPersistence().findByPrimaryKey(ACKNOWLEDGMENT_ID);
	}

	/**
	* Returns the project acknowledgement registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration, or <code>null</code> if a project acknowledgement registration with the primary key could not be found
	*/
	public static ProjectAcknowledgementRegistration fetchByPrimaryKey(
		long ACKNOWLEDGMENT_ID) {
		return getPersistence().fetchByPrimaryKey(ACKNOWLEDGMENT_ID);
	}

	public static java.util.Map<java.io.Serializable, ProjectAcknowledgementRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project acknowledgement registrations.
	*
	* @return the project acknowledgement registrations
	*/
	public static List<ProjectAcknowledgementRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project acknowledgement registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project acknowledgement registrations
	* @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	* @return the range of project acknowledgement registrations
	*/
	public static List<ProjectAcknowledgementRegistration> findAll(int start,
		int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project acknowledgement registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project acknowledgement registrations
	* @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project acknowledgement registrations
	*/
	public static List<ProjectAcknowledgementRegistration> findAll(int start,
		int end,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project acknowledgement registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project acknowledgement registrations
	* @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project acknowledgement registrations
	*/
	public static List<ProjectAcknowledgementRegistration> findAll(int start,
		int end,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project acknowledgement registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project acknowledgement registrations.
	*
	* @return the number of project acknowledgement registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectAcknowledgementRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectAcknowledgementRegistrationPersistence, ProjectAcknowledgementRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectAcknowledgementRegistrationPersistence.class);

		ServiceTracker<ProjectAcknowledgementRegistrationPersistence, ProjectAcknowledgementRegistrationPersistence> serviceTracker =
			new ServiceTracker<ProjectAcknowledgementRegistrationPersistence, ProjectAcknowledgementRegistrationPersistence>(bundle.getBundleContext(),
				ProjectAcknowledgementRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}