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

import com.crowd.funding.database.exception.NoSuchDonorRegistrationException;
import com.crowd.funding.database.model.DonorRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the donor registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.DonorRegistrationPersistenceImpl
 * @see DonorRegistrationUtil
 * @generated
 */
@ProviderType
public interface DonorRegistrationPersistence extends BasePersistence<DonorRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DonorRegistrationUtil} to access the donor registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the donor registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching donor registrations
	*/
	public java.util.List<DonorRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the donor registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @return the range of matching donor registrations
	*/
	public java.util.List<DonorRegistration> findByUuid(String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the donor registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching donor registrations
	*/
	public java.util.List<DonorRegistration> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DonorRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the donor registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching donor registrations
	*/
	public java.util.List<DonorRegistration> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<DonorRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first donor registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching donor registration
	* @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	*/
	public DonorRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DonorRegistration> orderByComparator)
		throws NoSuchDonorRegistrationException;

	/**
	* Returns the first donor registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public DonorRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DonorRegistration> orderByComparator);

	/**
	* Returns the last donor registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching donor registration
	* @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	*/
	public DonorRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DonorRegistration> orderByComparator)
		throws NoSuchDonorRegistrationException;

	/**
	* Returns the last donor registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public DonorRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DonorRegistration> orderByComparator);

	/**
	* Returns the donor registrations before and after the current donor registration in the ordered set where uuid = &#63;.
	*
	* @param DONOR_ID the primary key of the current donor registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next donor registration
	* @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	*/
	public DonorRegistration[] findByUuid_PrevAndNext(long DONOR_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DonorRegistration> orderByComparator)
		throws NoSuchDonorRegistrationException;

	/**
	* Removes all the donor registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of donor registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching donor registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the donor registration where MOBILE_NO = &#63; or throws a {@link NoSuchDonorRegistrationException} if it could not be found.
	*
	* @param MOBILE_NO the mobile_no
	* @return the matching donor registration
	* @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	*/
	public DonorRegistration findByMOBILE_NO(long MOBILE_NO)
		throws NoSuchDonorRegistrationException;

	/**
	* Returns the donor registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param MOBILE_NO the mobile_no
	* @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public DonorRegistration fetchByMOBILE_NO(long MOBILE_NO);

	/**
	* Returns the donor registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param MOBILE_NO the mobile_no
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public DonorRegistration fetchByMOBILE_NO(long MOBILE_NO,
		boolean retrieveFromCache);

	/**
	* Removes the donor registration where MOBILE_NO = &#63; from the database.
	*
	* @param MOBILE_NO the mobile_no
	* @return the donor registration that was removed
	*/
	public DonorRegistration removeByMOBILE_NO(long MOBILE_NO)
		throws NoSuchDonorRegistrationException;

	/**
	* Returns the number of donor registrations where MOBILE_NO = &#63;.
	*
	* @param MOBILE_NO the mobile_no
	* @return the number of matching donor registrations
	*/
	public int countByMOBILE_NO(long MOBILE_NO);

	/**
	* Returns the donor registration where DONOR_ID = &#63; or throws a {@link NoSuchDonorRegistrationException} if it could not be found.
	*
	* @param DONOR_ID the donor_id
	* @return the matching donor registration
	* @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	*/
	public DonorRegistration findByDONOR_ID(long DONOR_ID)
		throws NoSuchDonorRegistrationException;

	/**
	* Returns the donor registration where DONOR_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param DONOR_ID the donor_id
	* @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public DonorRegistration fetchByDONOR_ID(long DONOR_ID);

	/**
	* Returns the donor registration where DONOR_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param DONOR_ID the donor_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	*/
	public DonorRegistration fetchByDONOR_ID(long DONOR_ID,
		boolean retrieveFromCache);

	/**
	* Removes the donor registration where DONOR_ID = &#63; from the database.
	*
	* @param DONOR_ID the donor_id
	* @return the donor registration that was removed
	*/
	public DonorRegistration removeByDONOR_ID(long DONOR_ID)
		throws NoSuchDonorRegistrationException;

	/**
	* Returns the number of donor registrations where DONOR_ID = &#63;.
	*
	* @param DONOR_ID the donor_id
	* @return the number of matching donor registrations
	*/
	public int countByDONOR_ID(long DONOR_ID);

	/**
	* Caches the donor registration in the entity cache if it is enabled.
	*
	* @param donorRegistration the donor registration
	*/
	public void cacheResult(DonorRegistration donorRegistration);

	/**
	* Caches the donor registrations in the entity cache if it is enabled.
	*
	* @param donorRegistrations the donor registrations
	*/
	public void cacheResult(
		java.util.List<DonorRegistration> donorRegistrations);

	/**
	* Creates a new donor registration with the primary key. Does not add the donor registration to the database.
	*
	* @param DONOR_ID the primary key for the new donor registration
	* @return the new donor registration
	*/
	public DonorRegistration create(long DONOR_ID);

	/**
	* Removes the donor registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param DONOR_ID the primary key of the donor registration
	* @return the donor registration that was removed
	* @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	*/
	public DonorRegistration remove(long DONOR_ID)
		throws NoSuchDonorRegistrationException;

	public DonorRegistration updateImpl(DonorRegistration donorRegistration);

	/**
	* Returns the donor registration with the primary key or throws a {@link NoSuchDonorRegistrationException} if it could not be found.
	*
	* @param DONOR_ID the primary key of the donor registration
	* @return the donor registration
	* @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	*/
	public DonorRegistration findByPrimaryKey(long DONOR_ID)
		throws NoSuchDonorRegistrationException;

	/**
	* Returns the donor registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param DONOR_ID the primary key of the donor registration
	* @return the donor registration, or <code>null</code> if a donor registration with the primary key could not be found
	*/
	public DonorRegistration fetchByPrimaryKey(long DONOR_ID);

	@Override
	public java.util.Map<java.io.Serializable, DonorRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the donor registrations.
	*
	* @return the donor registrations
	*/
	public java.util.List<DonorRegistration> findAll();

	/**
	* Returns a range of all the donor registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @return the range of donor registrations
	*/
	public java.util.List<DonorRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the donor registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of donor registrations
	*/
	public java.util.List<DonorRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DonorRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the donor registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of donor registrations
	*/
	public java.util.List<DonorRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DonorRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the donor registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of donor registrations.
	*
	* @return the number of donor registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}