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

import com.crowd.funding.database.exception.NoSuchProjectRegistrationException;
import com.crowd.funding.database.model.ProjectRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.ProjectRegistrationPersistenceImpl
 * @see ProjectRegistrationUtil
 * @generated
 */
@ProviderType
public interface ProjectRegistrationPersistence extends BasePersistence<ProjectRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectRegistrationUtil} to access the project registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project registrations
	*/
	public java.util.List<ProjectRegistration> findByUuid(String uuid);

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
	public java.util.List<ProjectRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<ProjectRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

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
	public java.util.List<ProjectRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public ProjectRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException;

	/**
	* Returns the first project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public ProjectRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

	/**
	* Returns the last project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public ProjectRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException;

	/**
	* Returns the last project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public ProjectRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public ProjectRegistration[] findByUuid_PrevAndNext(long PROJECT_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException;

	/**
	* Removes all the project registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of project registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the project registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public ProjectRegistration findByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectRegistrationException;

	/**
	* Returns the project registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public ProjectRegistration fetchByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the project registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public ProjectRegistration fetchByPROJECT_ID(long PROJECT_ID,
		boolean retrieveFromCache);

	/**
	* Removes the project registration where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @return the project registration that was removed
	*/
	public ProjectRegistration removeByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectRegistrationException;

	/**
	* Returns the number of project registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns all the project registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the matching project registrations
	*/
	public java.util.List<ProjectRegistration> findByUSER_ID(long USER_ID);

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
	public java.util.List<ProjectRegistration> findByUSER_ID(long USER_ID,
		int start, int end);

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
	public java.util.List<ProjectRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

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
	public java.util.List<ProjectRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public ProjectRegistration findByUSER_ID_First(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException;

	/**
	* Returns the first project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public ProjectRegistration fetchByUSER_ID_First(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

	/**
	* Returns the last project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public ProjectRegistration findByUSER_ID_Last(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException;

	/**
	* Returns the last project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public ProjectRegistration fetchByUSER_ID_Last(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where USER_ID = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public ProjectRegistration[] findByUSER_ID_PrevAndNext(long PROJECT_ID,
		long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException;

	/**
	* Removes all the project registrations where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	*/
	public void removeByUSER_ID(long USER_ID);

	/**
	* Returns the number of project registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching project registrations
	*/
	public int countByUSER_ID(long USER_ID);

	/**
	* Returns all the project registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching project registrations
	*/
	public java.util.List<ProjectRegistration> findBySTATUS(int STATUS);

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
	public java.util.List<ProjectRegistration> findBySTATUS(int STATUS,
		int start, int end);

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
	public java.util.List<ProjectRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

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
	public java.util.List<ProjectRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public ProjectRegistration findBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException;

	/**
	* Returns the first project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public ProjectRegistration fetchBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

	/**
	* Returns the last project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public ProjectRegistration findBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException;

	/**
	* Returns the last project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public ProjectRegistration fetchBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where STATUS = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public ProjectRegistration[] findBySTATUS_PrevAndNext(long PROJECT_ID,
		int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException;

	/**
	* Removes all the project registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public void removeBySTATUS(int STATUS);

	/**
	* Returns the number of project registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching project registrations
	*/
	public int countBySTATUS(int STATUS);

	/**
	* Caches the project registration in the entity cache if it is enabled.
	*
	* @param projectRegistration the project registration
	*/
	public void cacheResult(ProjectRegistration projectRegistration);

	/**
	* Caches the project registrations in the entity cache if it is enabled.
	*
	* @param projectRegistrations the project registrations
	*/
	public void cacheResult(
		java.util.List<ProjectRegistration> projectRegistrations);

	/**
	* Creates a new project registration with the primary key. Does not add the project registration to the database.
	*
	* @param PROJECT_ID the primary key for the new project registration
	* @return the new project registration
	*/
	public ProjectRegistration create(long PROJECT_ID);

	/**
	* Removes the project registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration that was removed
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public ProjectRegistration remove(long PROJECT_ID)
		throws NoSuchProjectRegistrationException;

	public ProjectRegistration updateImpl(
		ProjectRegistration projectRegistration);

	/**
	* Returns the project registration with the primary key or throws a {@link NoSuchProjectRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public ProjectRegistration findByPrimaryKey(long PROJECT_ID)
		throws NoSuchProjectRegistrationException;

	/**
	* Returns the project registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration, or <code>null</code> if a project registration with the primary key could not be found
	*/
	public ProjectRegistration fetchByPrimaryKey(long PROJECT_ID);

	@Override
	public java.util.Map<java.io.Serializable, ProjectRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project registrations.
	*
	* @return the project registrations
	*/
	public java.util.List<ProjectRegistration> findAll();

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
	public java.util.List<ProjectRegistration> findAll(int start, int end);

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
	public java.util.List<ProjectRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator);

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
	public java.util.List<ProjectRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project registrations.
	*
	* @return the number of project registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}