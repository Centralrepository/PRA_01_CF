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

import com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException;
import com.crowd.funding.database.model.ProjectUpdateRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project update registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.ProjectUpdateRegistrationPersistenceImpl
 * @see ProjectUpdateRegistrationUtil
 * @generated
 */
@ProviderType
public interface ProjectUpdateRegistrationPersistence extends BasePersistence<ProjectUpdateRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectUpdateRegistrationUtil} to access the project update registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project update registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project update registrations
	*/
	public java.util.List<ProjectUpdateRegistration> findByUuid(String uuid);

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
	public java.util.List<ProjectUpdateRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<ProjectUpdateRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator);

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
	public java.util.List<ProjectUpdateRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project update registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException;

	/**
	* Returns the first project update registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator);

	/**
	* Returns the last project update registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException;

	/**
	* Returns the last project update registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator);

	/**
	* Returns the project update registrations before and after the current project update registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_UPDATE_ID the primary key of the current project update registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	*/
	public ProjectUpdateRegistration[] findByUuid_PrevAndNext(
		long PROJECT_UPDATE_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException;

	/**
	* Removes all the project update registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of project update registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project update registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the project update registration where PROJECT_UPDATE_ID = &#63; or throws a {@link NoSuchProjectUpdateRegistrationException} if it could not be found.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @return the matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration findByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID) throws NoSuchProjectUpdateRegistrationException;

	/**
	* Returns the project update registration where PROJECT_UPDATE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @return the matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration fetchByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID);

	/**
	* Returns the project update registration where PROJECT_UPDATE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration fetchByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID, boolean retrieveFromCache);

	/**
	* Removes the project update registration where PROJECT_UPDATE_ID = &#63; from the database.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @return the project update registration that was removed
	*/
	public ProjectUpdateRegistration removeByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID) throws NoSuchProjectUpdateRegistrationException;

	/**
	* Returns the number of project update registrations where PROJECT_UPDATE_ID = &#63;.
	*
	* @param PROJECT_UPDATE_ID the project_update_id
	* @return the number of matching project update registrations
	*/
	public int countByPROJECT_UPDATE_ID(long PROJECT_UPDATE_ID);

	/**
	* Returns all the project update registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project update registrations
	*/
	public java.util.List<ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID);

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
	public java.util.List<ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

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
	public java.util.List<ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator);

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
	public java.util.List<ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException;

	/**
	* Returns the first project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator);

	/**
	* Returns the last project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException;

	/**
	* Returns the last project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project update registration, or <code>null</code> if a matching project update registration could not be found
	*/
	public ProjectUpdateRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator);

	/**
	* Returns the project update registrations before and after the current project update registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_UPDATE_ID the primary key of the current project update registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	*/
	public ProjectUpdateRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_UPDATE_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException;

	/**
	* Removes all the project update registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of project update registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project update registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Caches the project update registration in the entity cache if it is enabled.
	*
	* @param projectUpdateRegistration the project update registration
	*/
	public void cacheResult(ProjectUpdateRegistration projectUpdateRegistration);

	/**
	* Caches the project update registrations in the entity cache if it is enabled.
	*
	* @param projectUpdateRegistrations the project update registrations
	*/
	public void cacheResult(
		java.util.List<ProjectUpdateRegistration> projectUpdateRegistrations);

	/**
	* Creates a new project update registration with the primary key. Does not add the project update registration to the database.
	*
	* @param PROJECT_UPDATE_ID the primary key for the new project update registration
	* @return the new project update registration
	*/
	public ProjectUpdateRegistration create(long PROJECT_UPDATE_ID);

	/**
	* Removes the project update registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration that was removed
	* @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	*/
	public ProjectUpdateRegistration remove(long PROJECT_UPDATE_ID)
		throws NoSuchProjectUpdateRegistrationException;

	public ProjectUpdateRegistration updateImpl(
		ProjectUpdateRegistration projectUpdateRegistration);

	/**
	* Returns the project update registration with the primary key or throws a {@link NoSuchProjectUpdateRegistrationException} if it could not be found.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration
	* @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	*/
	public ProjectUpdateRegistration findByPrimaryKey(long PROJECT_UPDATE_ID)
		throws NoSuchProjectUpdateRegistrationException;

	/**
	* Returns the project update registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration, or <code>null</code> if a project update registration with the primary key could not be found
	*/
	public ProjectUpdateRegistration fetchByPrimaryKey(long PROJECT_UPDATE_ID);

	@Override
	public java.util.Map<java.io.Serializable, ProjectUpdateRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project update registrations.
	*
	* @return the project update registrations
	*/
	public java.util.List<ProjectUpdateRegistration> findAll();

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
	public java.util.List<ProjectUpdateRegistration> findAll(int start, int end);

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
	public java.util.List<ProjectUpdateRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator);

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
	public java.util.List<ProjectUpdateRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectUpdateRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project update registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project update registrations.
	*
	* @return the number of project update registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}