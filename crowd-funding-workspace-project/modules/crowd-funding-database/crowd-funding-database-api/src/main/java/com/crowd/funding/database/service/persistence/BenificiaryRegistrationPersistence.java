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

import com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException;
import com.crowd.funding.database.model.BenificiaryRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the benificiary registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.BenificiaryRegistrationPersistenceImpl
 * @see BenificiaryRegistrationUtil
 * @generated
 */
@ProviderType
public interface BenificiaryRegistrationPersistence extends BasePersistence<BenificiaryRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BenificiaryRegistrationUtil} to access the benificiary registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the benificiary registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching benificiary registrations
	*/
	public java.util.List<BenificiaryRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the benificiary registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @return the range of matching benificiary registrations
	*/
	public java.util.List<BenificiaryRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the benificiary registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching benificiary registrations
	*/
	public java.util.List<BenificiaryRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenificiaryRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the benificiary registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching benificiary registrations
	*/
	public java.util.List<BenificiaryRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenificiaryRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a matching benificiary registration could not be found
	*/
	public BenificiaryRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BenificiaryRegistration> orderByComparator)
		throws NoSuchBenificiaryRegistrationException;

	/**
	* Returns the first benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	*/
	public BenificiaryRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BenificiaryRegistration> orderByComparator);

	/**
	* Returns the last benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a matching benificiary registration could not be found
	*/
	public BenificiaryRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BenificiaryRegistration> orderByComparator)
		throws NoSuchBenificiaryRegistrationException;

	/**
	* Returns the last benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	*/
	public BenificiaryRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BenificiaryRegistration> orderByComparator);

	/**
	* Returns the benificiary registrations before and after the current benificiary registration in the ordered set where uuid = &#63;.
	*
	* @param BENIFICIARY_ID the primary key of the current benificiary registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	*/
	public BenificiaryRegistration[] findByUuid_PrevAndNext(
		long BENIFICIARY_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BenificiaryRegistration> orderByComparator)
		throws NoSuchBenificiaryRegistrationException;

	/**
	* Removes all the benificiary registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of benificiary registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching benificiary registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the benificiary registration where BENIFICIARY_ID = &#63; or throws a {@link NoSuchBenificiaryRegistrationException} if it could not be found.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the matching benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a matching benificiary registration could not be found
	*/
	public BenificiaryRegistration findByBENIFICIARY_ID(long BENIFICIARY_ID)
		throws NoSuchBenificiaryRegistrationException;

	/**
	* Returns the benificiary registration where BENIFICIARY_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	*/
	public BenificiaryRegistration fetchByBENIFICIARY_ID(long BENIFICIARY_ID);

	/**
	* Returns the benificiary registration where BENIFICIARY_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	*/
	public BenificiaryRegistration fetchByBENIFICIARY_ID(long BENIFICIARY_ID,
		boolean retrieveFromCache);

	/**
	* Removes the benificiary registration where BENIFICIARY_ID = &#63; from the database.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the benificiary registration that was removed
	*/
	public BenificiaryRegistration removeByBENIFICIARY_ID(long BENIFICIARY_ID)
		throws NoSuchBenificiaryRegistrationException;

	/**
	* Returns the number of benificiary registrations where BENIFICIARY_ID = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the number of matching benificiary registrations
	*/
	public int countByBENIFICIARY_ID(long BENIFICIARY_ID);

	/**
	* Caches the benificiary registration in the entity cache if it is enabled.
	*
	* @param benificiaryRegistration the benificiary registration
	*/
	public void cacheResult(BenificiaryRegistration benificiaryRegistration);

	/**
	* Caches the benificiary registrations in the entity cache if it is enabled.
	*
	* @param benificiaryRegistrations the benificiary registrations
	*/
	public void cacheResult(
		java.util.List<BenificiaryRegistration> benificiaryRegistrations);

	/**
	* Creates a new benificiary registration with the primary key. Does not add the benificiary registration to the database.
	*
	* @param BENIFICIARY_ID the primary key for the new benificiary registration
	* @return the new benificiary registration
	*/
	public BenificiaryRegistration create(long BENIFICIARY_ID);

	/**
	* Removes the benificiary registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration that was removed
	* @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	*/
	public BenificiaryRegistration remove(long BENIFICIARY_ID)
		throws NoSuchBenificiaryRegistrationException;

	public BenificiaryRegistration updateImpl(
		BenificiaryRegistration benificiaryRegistration);

	/**
	* Returns the benificiary registration with the primary key or throws a {@link NoSuchBenificiaryRegistrationException} if it could not be found.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration
	* @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	*/
	public BenificiaryRegistration findByPrimaryKey(long BENIFICIARY_ID)
		throws NoSuchBenificiaryRegistrationException;

	/**
	* Returns the benificiary registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration, or <code>null</code> if a benificiary registration with the primary key could not be found
	*/
	public BenificiaryRegistration fetchByPrimaryKey(long BENIFICIARY_ID);

	@Override
	public java.util.Map<java.io.Serializable, BenificiaryRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the benificiary registrations.
	*
	* @return the benificiary registrations
	*/
	public java.util.List<BenificiaryRegistration> findAll();

	/**
	* Returns a range of all the benificiary registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @return the range of benificiary registrations
	*/
	public java.util.List<BenificiaryRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the benificiary registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of benificiary registrations
	*/
	public java.util.List<BenificiaryRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenificiaryRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the benificiary registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of benificiary registrations
	*/
	public java.util.List<BenificiaryRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BenificiaryRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the benificiary registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of benificiary registrations.
	*
	* @return the number of benificiary registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}