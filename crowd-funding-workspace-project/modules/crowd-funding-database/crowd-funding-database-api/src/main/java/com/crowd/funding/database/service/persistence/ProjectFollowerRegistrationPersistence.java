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

import com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException;
import com.crowd.funding.database.model.ProjectFollowerRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project follower registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.ProjectFollowerRegistrationPersistenceImpl
 * @see ProjectFollowerRegistrationUtil
 * @generated
 */
@ProviderType
public interface ProjectFollowerRegistrationPersistence extends BasePersistence<ProjectFollowerRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectFollowerRegistrationUtil} to access the project follower registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project follower registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project follower registrations
	*/
	public java.util.List<ProjectFollowerRegistration> findByUuid(String uuid);

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
	public java.util.List<ProjectFollowerRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<ProjectFollowerRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

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
	public java.util.List<ProjectFollowerRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project follower registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the first project follower registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

	/**
	* Returns the last project follower registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the last project follower registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

	/**
	* Returns the project follower registrations before and after the current project follower registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the current project follower registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public ProjectFollowerRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FOLLOWER_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Removes all the project follower registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of project follower registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project follower registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the project follower registration where PROJECT_FOLLOWER_ID = &#63; or throws a {@link NoSuchProjectFollowerRegistrationException} if it could not be found.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @return the matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration findByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the project follower registration where PROJECT_FOLLOWER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID);

	/**
	* Returns the project follower registration where PROJECT_FOLLOWER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID, boolean retrieveFromCache);

	/**
	* Removes the project follower registration where PROJECT_FOLLOWER_ID = &#63; from the database.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @return the project follower registration that was removed
	*/
	public ProjectFollowerRegistration removeByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the number of project follower registrations where PROJECT_FOLLOWER_ID = &#63;.
	*
	* @param PROJECT_FOLLOWER_ID the project_follower_id
	* @return the number of matching project follower registrations
	*/
	public int countByPROJECT_FOLLOWER_ID(long PROJECT_FOLLOWER_ID);

	/**
	* Returns all the project follower registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the matching project follower registrations
	*/
	public java.util.List<ProjectFollowerRegistration> findByUSER_ID(
		long USER_ID);

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
	public java.util.List<ProjectFollowerRegistration> findByUSER_ID(
		long USER_ID, int start, int end);

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
	public java.util.List<ProjectFollowerRegistration> findByUSER_ID(
		long USER_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

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
	public java.util.List<ProjectFollowerRegistration> findByUSER_ID(
		long USER_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration findByUSER_ID_First(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the first project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByUSER_ID_First(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

	/**
	* Returns the last project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration findByUSER_ID_Last(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the last project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByUSER_ID_Last(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

	/**
	* Returns the project follower registrations before and after the current project follower registration in the ordered set where USER_ID = &#63;.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the current project follower registration
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public ProjectFollowerRegistration[] findByUSER_ID_PrevAndNext(
		long PROJECT_FOLLOWER_ID, long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Removes all the project follower registrations where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	*/
	public void removeByUSER_ID(long USER_ID);

	/**
	* Returns the number of project follower registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching project follower registrations
	*/
	public int countByUSER_ID(long USER_ID);

	/**
	* Returns all the project follower registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project follower registrations
	*/
	public java.util.List<ProjectFollowerRegistration> findByPROJECT_ID(
		long PROJECT_ID);

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
	public java.util.List<ProjectFollowerRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

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
	public java.util.List<ProjectFollowerRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

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
	public java.util.List<ProjectFollowerRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the first project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

	/**
	* Returns the last project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the last project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

	/**
	* Returns the project follower registrations before and after the current project follower registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the current project follower registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public ProjectFollowerRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FOLLOWER_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Removes all the project follower registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of project follower registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project follower registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; or throws a {@link NoSuchProjectFollowerRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @return the matching project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration findByPROJECT_USER_ID(long PROJECT_ID,
		long USER_ID) throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByPROJECT_USER_ID(long PROJECT_ID,
		long USER_ID);

	/**
	* Returns the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	*/
	public ProjectFollowerRegistration fetchByPROJECT_USER_ID(long PROJECT_ID,
		long USER_ID, boolean retrieveFromCache);

	/**
	* Removes the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @return the project follower registration that was removed
	*/
	public ProjectFollowerRegistration removeByPROJECT_USER_ID(
		long PROJECT_ID, long USER_ID)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the number of project follower registrations where PROJECT_ID = &#63; and USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param USER_ID the user_id
	* @return the number of matching project follower registrations
	*/
	public int countByPROJECT_USER_ID(long PROJECT_ID, long USER_ID);

	/**
	* Caches the project follower registration in the entity cache if it is enabled.
	*
	* @param projectFollowerRegistration the project follower registration
	*/
	public void cacheResult(
		ProjectFollowerRegistration projectFollowerRegistration);

	/**
	* Caches the project follower registrations in the entity cache if it is enabled.
	*
	* @param projectFollowerRegistrations the project follower registrations
	*/
	public void cacheResult(
		java.util.List<ProjectFollowerRegistration> projectFollowerRegistrations);

	/**
	* Creates a new project follower registration with the primary key. Does not add the project follower registration to the database.
	*
	* @param PROJECT_FOLLOWER_ID the primary key for the new project follower registration
	* @return the new project follower registration
	*/
	public ProjectFollowerRegistration create(long PROJECT_FOLLOWER_ID);

	/**
	* Removes the project follower registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	* @return the project follower registration that was removed
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public ProjectFollowerRegistration remove(long PROJECT_FOLLOWER_ID)
		throws NoSuchProjectFollowerRegistrationException;

	public ProjectFollowerRegistration updateImpl(
		ProjectFollowerRegistration projectFollowerRegistration);

	/**
	* Returns the project follower registration with the primary key or throws a {@link NoSuchProjectFollowerRegistrationException} if it could not be found.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	* @return the project follower registration
	* @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	*/
	public ProjectFollowerRegistration findByPrimaryKey(
		long PROJECT_FOLLOWER_ID)
		throws NoSuchProjectFollowerRegistrationException;

	/**
	* Returns the project follower registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	* @return the project follower registration, or <code>null</code> if a project follower registration with the primary key could not be found
	*/
	public ProjectFollowerRegistration fetchByPrimaryKey(
		long PROJECT_FOLLOWER_ID);

	@Override
	public java.util.Map<java.io.Serializable, ProjectFollowerRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project follower registrations.
	*
	* @return the project follower registrations
	*/
	public java.util.List<ProjectFollowerRegistration> findAll();

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
	public java.util.List<ProjectFollowerRegistration> findAll(int start,
		int end);

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
	public java.util.List<ProjectFollowerRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator);

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
	public java.util.List<ProjectFollowerRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFollowerRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project follower registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project follower registrations.
	*
	* @return the number of project follower registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}