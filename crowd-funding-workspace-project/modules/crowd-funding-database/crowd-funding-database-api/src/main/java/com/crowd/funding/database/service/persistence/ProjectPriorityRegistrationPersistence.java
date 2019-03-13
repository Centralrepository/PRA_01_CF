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

import com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException;
import com.crowd.funding.database.model.ProjectPriorityRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project priority registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.ProjectPriorityRegistrationPersistenceImpl
 * @see ProjectPriorityRegistrationUtil
 * @generated
 */
@ProviderType
public interface ProjectPriorityRegistrationPersistence extends BasePersistence<ProjectPriorityRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectPriorityRegistrationUtil} to access the project priority registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project priority registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project priority registrations
	*/
	public java.util.List<ProjectPriorityRegistration> findByUuid(String uuid);

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
	public java.util.List<ProjectPriorityRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<ProjectPriorityRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator);

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
	public java.util.List<ProjectPriorityRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project priority registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Returns the first project priority registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator);

	/**
	* Returns the last project priority registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Returns the last project priority registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator);

	/**
	* Returns the project priority registrations before and after the current project priority registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the current project priority registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	*/
	public ProjectPriorityRegistration[] findByUuid_PrevAndNext(
		long PROJECT_PRIORITY_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Removes all the project priority registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of project priority registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project priority registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the project priority registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectPriorityRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration findByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Returns the project priority registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration fetchByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the project priority registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration fetchByPROJECT_ID(long PROJECT_ID,
		boolean retrieveFromCache);

	/**
	* Removes the project priority registration where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @return the project priority registration that was removed
	*/
	public ProjectPriorityRegistration removeByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Returns the number of project priority registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project priority registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns all the project priority registrations where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @return the matching project priority registrations
	*/
	public java.util.List<ProjectPriorityRegistration> findByPRIORITY(
		int PRIORITY);

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
	public java.util.List<ProjectPriorityRegistration> findByPRIORITY(
		int PRIORITY, int start, int end);

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
	public java.util.List<ProjectPriorityRegistration> findByPRIORITY(
		int PRIORITY, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator);

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
	public java.util.List<ProjectPriorityRegistration> findByPRIORITY(
		int PRIORITY, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration findByPRIORITY_First(int PRIORITY,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Returns the first project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration fetchByPRIORITY_First(int PRIORITY,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator);

	/**
	* Returns the last project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration findByPRIORITY_Last(int PRIORITY,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Returns the last project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration fetchByPRIORITY_Last(int PRIORITY,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator);

	/**
	* Returns the project priority registrations before and after the current project priority registration in the ordered set where PRIORITY = &#63;.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the current project priority registration
	* @param PRIORITY the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	*/
	public ProjectPriorityRegistration[] findByPRIORITY_PrevAndNext(
		long PROJECT_PRIORITY_ID, int PRIORITY,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Removes all the project priority registrations where PRIORITY = &#63; from the database.
	*
	* @param PRIORITY the priority
	*/
	public void removeByPRIORITY(int PRIORITY);

	/**
	* Returns the number of project priority registrations where PRIORITY = &#63;.
	*
	* @param PRIORITY the priority
	* @return the number of matching project priority registrations
	*/
	public int countByPRIORITY(int PRIORITY);

	/**
	* Returns the project priority registration where PRIORITY_SEQUANCE = &#63; or throws a {@link NoSuchProjectPriorityRegistrationException} if it could not be found.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @return the matching project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration findByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Returns the project priority registration where PRIORITY_SEQUANCE = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration fetchByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE);

	/**
	* Returns the project priority registration where PRIORITY_SEQUANCE = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	*/
	public ProjectPriorityRegistration fetchByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE, boolean retrieveFromCache);

	/**
	* Removes the project priority registration where PRIORITY_SEQUANCE = &#63; from the database.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @return the project priority registration that was removed
	*/
	public ProjectPriorityRegistration removeByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Returns the number of project priority registrations where PRIORITY_SEQUANCE = &#63;.
	*
	* @param PRIORITY_SEQUANCE the priority_sequance
	* @return the number of matching project priority registrations
	*/
	public int countByPRIORITY_SEQUANCE(int PRIORITY_SEQUANCE);

	/**
	* Caches the project priority registration in the entity cache if it is enabled.
	*
	* @param projectPriorityRegistration the project priority registration
	*/
	public void cacheResult(
		ProjectPriorityRegistration projectPriorityRegistration);

	/**
	* Caches the project priority registrations in the entity cache if it is enabled.
	*
	* @param projectPriorityRegistrations the project priority registrations
	*/
	public void cacheResult(
		java.util.List<ProjectPriorityRegistration> projectPriorityRegistrations);

	/**
	* Creates a new project priority registration with the primary key. Does not add the project priority registration to the database.
	*
	* @param PROJECT_PRIORITY_ID the primary key for the new project priority registration
	* @return the new project priority registration
	*/
	public ProjectPriorityRegistration create(long PROJECT_PRIORITY_ID);

	/**
	* Removes the project priority registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration that was removed
	* @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	*/
	public ProjectPriorityRegistration remove(long PROJECT_PRIORITY_ID)
		throws NoSuchProjectPriorityRegistrationException;

	public ProjectPriorityRegistration updateImpl(
		ProjectPriorityRegistration projectPriorityRegistration);

	/**
	* Returns the project priority registration with the primary key or throws a {@link NoSuchProjectPriorityRegistrationException} if it could not be found.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration
	* @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	*/
	public ProjectPriorityRegistration findByPrimaryKey(
		long PROJECT_PRIORITY_ID)
		throws NoSuchProjectPriorityRegistrationException;

	/**
	* Returns the project priority registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration, or <code>null</code> if a project priority registration with the primary key could not be found
	*/
	public ProjectPriorityRegistration fetchByPrimaryKey(
		long PROJECT_PRIORITY_ID);

	@Override
	public java.util.Map<java.io.Serializable, ProjectPriorityRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project priority registrations.
	*
	* @return the project priority registrations
	*/
	public java.util.List<ProjectPriorityRegistration> findAll();

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
	public java.util.List<ProjectPriorityRegistration> findAll(int start,
		int end);

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
	public java.util.List<ProjectPriorityRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator);

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
	public java.util.List<ProjectPriorityRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectPriorityRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project priority registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project priority registrations.
	*
	* @return the number of project priority registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}