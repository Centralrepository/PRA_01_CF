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

import com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException;
import com.crowd.funding.database.model.UpdateRequesterRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the update requester registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.UpdateRequesterRegistrationPersistenceImpl
 * @see UpdateRequesterRegistrationUtil
 * @generated
 */
@ProviderType
public interface UpdateRequesterRegistrationPersistence extends BasePersistence<UpdateRequesterRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UpdateRequesterRegistrationUtil} to access the update requester registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the update requester registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the update requester registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @return the range of matching update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the update requester registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the update requester registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first update requester registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException;

	/**
	* Returns the first update requester registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator);

	/**
	* Returns the last update requester registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException;

	/**
	* Returns the last update requester registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator);

	/**
	* Returns the update requester registrations before and after the current update requester registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the current update requester registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	*/
	public UpdateRequesterRegistration[] findByUuid_PrevAndNext(
		long PROJECT_UPDATE_REQUEST_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException;

	/**
	* Removes all the update requester registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of update requester registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching update requester registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; or throws a {@link NoSuchUpdateRequesterRegistrationException} if it could not be found.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @return the matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration findByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID)
		throws NoSuchUpdateRequesterRegistrationException;

	/**
	* Returns the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @return the matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration fetchByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID);

	/**
	* Returns the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration fetchByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID, boolean retrieveFromCache);

	/**
	* Removes the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; from the database.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @return the update requester registration that was removed
	*/
	public UpdateRequesterRegistration removeByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID)
		throws NoSuchUpdateRequesterRegistrationException;

	/**
	* Returns the number of update requester registrations where PROJECT_UPDATE_REQUEST_ID = &#63;.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	* @return the number of matching update requester registrations
	*/
	public int countByPROJECT_UPDATE_REQUEST_ID(long PROJECT_UPDATE_REQUEST_ID);

	/**
	* Returns all the update requester registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findByPROJECT_ID(
		long PROJECT_ID);

	/**
	* Returns a range of all the update requester registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @return the range of matching update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

	/**
	* Returns an ordered range of all the update requester registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the update requester registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException;

	/**
	* Returns the first update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator);

	/**
	* Returns the last update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException;

	/**
	* Returns the last update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	*/
	public UpdateRequesterRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator);

	/**
	* Returns the update requester registrations before and after the current update requester registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the current update requester registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	*/
	public UpdateRequesterRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_UPDATE_REQUEST_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException;

	/**
	* Removes all the update requester registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of update requester registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching update requester registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Caches the update requester registration in the entity cache if it is enabled.
	*
	* @param updateRequesterRegistration the update requester registration
	*/
	public void cacheResult(
		UpdateRequesterRegistration updateRequesterRegistration);

	/**
	* Caches the update requester registrations in the entity cache if it is enabled.
	*
	* @param updateRequesterRegistrations the update requester registrations
	*/
	public void cacheResult(
		java.util.List<UpdateRequesterRegistration> updateRequesterRegistrations);

	/**
	* Creates a new update requester registration with the primary key. Does not add the update requester registration to the database.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key for the new update requester registration
	* @return the new update requester registration
	*/
	public UpdateRequesterRegistration create(long PROJECT_UPDATE_REQUEST_ID);

	/**
	* Removes the update requester registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	* @return the update requester registration that was removed
	* @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	*/
	public UpdateRequesterRegistration remove(long PROJECT_UPDATE_REQUEST_ID)
		throws NoSuchUpdateRequesterRegistrationException;

	public UpdateRequesterRegistration updateImpl(
		UpdateRequesterRegistration updateRequesterRegistration);

	/**
	* Returns the update requester registration with the primary key or throws a {@link NoSuchUpdateRequesterRegistrationException} if it could not be found.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	* @return the update requester registration
	* @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	*/
	public UpdateRequesterRegistration findByPrimaryKey(
		long PROJECT_UPDATE_REQUEST_ID)
		throws NoSuchUpdateRequesterRegistrationException;

	/**
	* Returns the update requester registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	* @return the update requester registration, or <code>null</code> if a update requester registration with the primary key could not be found
	*/
	public UpdateRequesterRegistration fetchByPrimaryKey(
		long PROJECT_UPDATE_REQUEST_ID);

	@Override
	public java.util.Map<java.io.Serializable, UpdateRequesterRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the update requester registrations.
	*
	* @return the update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findAll();

	/**
	* Returns a range of all the update requester registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @return the range of update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the update requester registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the update requester registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of update requester registrations
	* @param end the upper bound of the range of update requester registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of update requester registrations
	*/
	public java.util.List<UpdateRequesterRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<UpdateRequesterRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the update requester registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of update requester registrations.
	*
	* @return the number of update requester registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}