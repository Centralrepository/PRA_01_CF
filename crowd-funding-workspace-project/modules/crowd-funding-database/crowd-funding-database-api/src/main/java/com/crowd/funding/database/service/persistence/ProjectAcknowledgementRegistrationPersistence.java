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

import com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project acknowledgement registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.ProjectAcknowledgementRegistrationPersistenceImpl
 * @see ProjectAcknowledgementRegistrationUtil
 * @generated
 */
@ProviderType
public interface ProjectAcknowledgementRegistrationPersistence
	extends BasePersistence<ProjectAcknowledgementRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectAcknowledgementRegistrationUtil} to access the project acknowledgement registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project acknowledgement registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project acknowledgement registrations
	*/
	public java.util.List<ProjectAcknowledgementRegistration> findByUuid(
		String uuid);

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
	public java.util.List<ProjectAcknowledgementRegistration> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProjectAcknowledgementRegistration> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator);

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
	public java.util.List<ProjectAcknowledgementRegistration> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a matching project acknowledgement registration could not be found
	*/
	public ProjectAcknowledgementRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator)
		throws NoSuchProjectAcknowledgementRegistrationException;

	/**
	* Returns the first project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	*/
	public ProjectAcknowledgementRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator);

	/**
	* Returns the last project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a matching project acknowledgement registration could not be found
	*/
	public ProjectAcknowledgementRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator)
		throws NoSuchProjectAcknowledgementRegistrationException;

	/**
	* Returns the last project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	*/
	public ProjectAcknowledgementRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator);

	/**
	* Returns the project acknowledgement registrations before and after the current project acknowledgement registration in the ordered set where uuid = &#63;.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the current project acknowledgement registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	*/
	public ProjectAcknowledgementRegistration[] findByUuid_PrevAndNext(
		long ACKNOWLEDGMENT_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator)
		throws NoSuchProjectAcknowledgementRegistrationException;

	/**
	* Removes all the project acknowledgement registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of project acknowledgement registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project acknowledgement registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the project acknowledgement registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectAcknowledgementRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a matching project acknowledgement registration could not be found
	*/
	public ProjectAcknowledgementRegistration findByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectAcknowledgementRegistrationException;

	/**
	* Returns the project acknowledgement registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	*/
	public ProjectAcknowledgementRegistration fetchByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the project acknowledgement registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	*/
	public ProjectAcknowledgementRegistration fetchByPROJECT_ID(
		long PROJECT_ID, boolean retrieveFromCache);

	/**
	* Removes the project acknowledgement registration where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @return the project acknowledgement registration that was removed
	*/
	public ProjectAcknowledgementRegistration removeByPROJECT_ID(
		long PROJECT_ID)
		throws NoSuchProjectAcknowledgementRegistrationException;

	/**
	* Returns the number of project acknowledgement registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project acknowledgement registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Caches the project acknowledgement registration in the entity cache if it is enabled.
	*
	* @param projectAcknowledgementRegistration the project acknowledgement registration
	*/
	public void cacheResult(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration);

	/**
	* Caches the project acknowledgement registrations in the entity cache if it is enabled.
	*
	* @param projectAcknowledgementRegistrations the project acknowledgement registrations
	*/
	public void cacheResult(
		java.util.List<ProjectAcknowledgementRegistration> projectAcknowledgementRegistrations);

	/**
	* Creates a new project acknowledgement registration with the primary key. Does not add the project acknowledgement registration to the database.
	*
	* @param ACKNOWLEDGMENT_ID the primary key for the new project acknowledgement registration
	* @return the new project acknowledgement registration
	*/
	public ProjectAcknowledgementRegistration create(long ACKNOWLEDGMENT_ID);

	/**
	* Removes the project acknowledgement registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration that was removed
	* @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	*/
	public ProjectAcknowledgementRegistration remove(long ACKNOWLEDGMENT_ID)
		throws NoSuchProjectAcknowledgementRegistrationException;

	public ProjectAcknowledgementRegistration updateImpl(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration);

	/**
	* Returns the project acknowledgement registration with the primary key or throws a {@link NoSuchProjectAcknowledgementRegistrationException} if it could not be found.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration
	* @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	*/
	public ProjectAcknowledgementRegistration findByPrimaryKey(
		long ACKNOWLEDGMENT_ID)
		throws NoSuchProjectAcknowledgementRegistrationException;

	/**
	* Returns the project acknowledgement registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration, or <code>null</code> if a project acknowledgement registration with the primary key could not be found
	*/
	public ProjectAcknowledgementRegistration fetchByPrimaryKey(
		long ACKNOWLEDGMENT_ID);

	@Override
	public java.util.Map<java.io.Serializable, ProjectAcknowledgementRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project acknowledgement registrations.
	*
	* @return the project acknowledgement registrations
	*/
	public java.util.List<ProjectAcknowledgementRegistration> findAll();

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
	public java.util.List<ProjectAcknowledgementRegistration> findAll(
		int start, int end);

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
	public java.util.List<ProjectAcknowledgementRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator);

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
	public java.util.List<ProjectAcknowledgementRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project acknowledgement registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project acknowledgement registrations.
	*
	* @return the number of project acknowledgement registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}