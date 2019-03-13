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

import com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException;
import com.crowd.funding.database.model.FundAccountRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the fund account registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.FundAccountRegistrationPersistenceImpl
 * @see FundAccountRegistrationUtil
 * @generated
 */
@ProviderType
public interface FundAccountRegistrationPersistence extends BasePersistence<FundAccountRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FundAccountRegistrationUtil} to access the fund account registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fund account registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the fund account registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @return the range of matching fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the fund account registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund account registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fund account registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public FundAccountRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException;

	/**
	* Returns the first fund account registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public FundAccountRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator);

	/**
	* Returns the last fund account registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public FundAccountRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException;

	/**
	* Returns the last fund account registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public FundAccountRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator);

	/**
	* Returns the fund account registrations before and after the current fund account registration in the ordered set where uuid = &#63;.
	*
	* @param ACCOUNT_ID the primary key of the current fund account registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund account registration
	* @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	*/
	public FundAccountRegistration[] findByUuid_PrevAndNext(long ACCOUNT_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException;

	/**
	* Removes all the fund account registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of fund account registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching fund account registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the fund account registration where ACCOUNT_ID = &#63; or throws a {@link NoSuchFundAccountRegistrationException} if it could not be found.
	*
	* @param ACCOUNT_ID the account_id
	* @return the matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public FundAccountRegistration findByACCOUNT_ID(long ACCOUNT_ID)
		throws NoSuchFundAccountRegistrationException;

	/**
	* Returns the fund account registration where ACCOUNT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ACCOUNT_ID the account_id
	* @return the matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public FundAccountRegistration fetchByACCOUNT_ID(long ACCOUNT_ID);

	/**
	* Returns the fund account registration where ACCOUNT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ACCOUNT_ID the account_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public FundAccountRegistration fetchByACCOUNT_ID(long ACCOUNT_ID,
		boolean retrieveFromCache);

	/**
	* Removes the fund account registration where ACCOUNT_ID = &#63; from the database.
	*
	* @param ACCOUNT_ID the account_id
	* @return the fund account registration that was removed
	*/
	public FundAccountRegistration removeByACCOUNT_ID(long ACCOUNT_ID)
		throws NoSuchFundAccountRegistrationException;

	/**
	* Returns the number of fund account registrations where ACCOUNT_ID = &#63;.
	*
	* @param ACCOUNT_ID the account_id
	* @return the number of matching fund account registrations
	*/
	public int countByACCOUNT_ID(long ACCOUNT_ID);

	/**
	* Returns all the fund account registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findByPROJECT_ID(
		long PROJECT_ID);

	/**
	* Returns a range of all the fund account registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @return the range of matching fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

	/**
	* Returns an ordered range of all the fund account registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund account registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public FundAccountRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException;

	/**
	* Returns the first fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public FundAccountRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator);

	/**
	* Returns the last fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund account registration
	* @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	*/
	public FundAccountRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException;

	/**
	* Returns the last fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	*/
	public FundAccountRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator);

	/**
	* Returns the fund account registrations before and after the current fund account registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param ACCOUNT_ID the primary key of the current fund account registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund account registration
	* @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	*/
	public FundAccountRegistration[] findByPROJECT_ID_PrevAndNext(
		long ACCOUNT_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException;

	/**
	* Removes all the fund account registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of fund account registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching fund account registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Caches the fund account registration in the entity cache if it is enabled.
	*
	* @param fundAccountRegistration the fund account registration
	*/
	public void cacheResult(FundAccountRegistration fundAccountRegistration);

	/**
	* Caches the fund account registrations in the entity cache if it is enabled.
	*
	* @param fundAccountRegistrations the fund account registrations
	*/
	public void cacheResult(
		java.util.List<FundAccountRegistration> fundAccountRegistrations);

	/**
	* Creates a new fund account registration with the primary key. Does not add the fund account registration to the database.
	*
	* @param ACCOUNT_ID the primary key for the new fund account registration
	* @return the new fund account registration
	*/
	public FundAccountRegistration create(long ACCOUNT_ID);

	/**
	* Removes the fund account registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ACCOUNT_ID the primary key of the fund account registration
	* @return the fund account registration that was removed
	* @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	*/
	public FundAccountRegistration remove(long ACCOUNT_ID)
		throws NoSuchFundAccountRegistrationException;

	public FundAccountRegistration updateImpl(
		FundAccountRegistration fundAccountRegistration);

	/**
	* Returns the fund account registration with the primary key or throws a {@link NoSuchFundAccountRegistrationException} if it could not be found.
	*
	* @param ACCOUNT_ID the primary key of the fund account registration
	* @return the fund account registration
	* @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	*/
	public FundAccountRegistration findByPrimaryKey(long ACCOUNT_ID)
		throws NoSuchFundAccountRegistrationException;

	/**
	* Returns the fund account registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ACCOUNT_ID the primary key of the fund account registration
	* @return the fund account registration, or <code>null</code> if a fund account registration with the primary key could not be found
	*/
	public FundAccountRegistration fetchByPrimaryKey(long ACCOUNT_ID);

	@Override
	public java.util.Map<java.io.Serializable, FundAccountRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the fund account registrations.
	*
	* @return the fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findAll();

	/**
	* Returns a range of all the fund account registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @return the range of fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the fund account registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund account registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of fund account registrations
	*/
	public java.util.List<FundAccountRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundAccountRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the fund account registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of fund account registrations.
	*
	* @return the number of fund account registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}