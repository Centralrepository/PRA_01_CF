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

import com.crowd.funding.database.exception.NoSuchFundRegistrationException;
import com.crowd.funding.database.model.FundRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the fund registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.FundRegistrationPersistenceImpl
 * @see FundRegistrationUtil
 * @generated
 */
@ProviderType
public interface FundRegistrationPersistence extends BasePersistence<FundRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FundRegistrationUtil} to access the fund registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fund registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching fund registrations
	*/
	public java.util.List<FundRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the fund registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByUuid(String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the fund registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fund registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public FundRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the first fund registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns the last fund registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public FundRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the last fund registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns the fund registrations before and after the current fund registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_FUND_ID the primary key of the current fund registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public FundRegistration[] findByUuid_PrevAndNext(long PROJECT_FUND_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Removes all the fund registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of fund registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching fund registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the fund registration where PROJECT_FUND_ID = &#63; or throws a {@link NoSuchFundRegistrationException} if it could not be found.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @return the matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public FundRegistration findByPROJECT_FUND_ID(long PROJECT_FUND_ID)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the fund registration where PROJECT_FUND_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @return the matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByPROJECT_FUND_ID(long PROJECT_FUND_ID);

	/**
	* Returns the fund registration where PROJECT_FUND_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByPROJECT_FUND_ID(long PROJECT_FUND_ID,
		boolean retrieveFromCache);

	/**
	* Removes the fund registration where PROJECT_FUND_ID = &#63; from the database.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @return the fund registration that was removed
	*/
	public FundRegistration removeByPROJECT_FUND_ID(long PROJECT_FUND_ID)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the number of fund registrations where PROJECT_FUND_ID = &#63;.
	*
	* @param PROJECT_FUND_ID the project_fund_id
	* @return the number of matching fund registrations
	*/
	public int countByPROJECT_FUND_ID(long PROJECT_FUND_ID);

	/**
	* Returns all the fund registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching fund registrations
	*/
	public java.util.List<FundRegistration> findByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns a range of all the fund registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end);

	/**
	* Returns an ordered range of all the fund registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public FundRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the first fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns the last fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public FundRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the last fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns the fund registrations before and after the current fund registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_FUND_ID the primary key of the current fund registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public FundRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FUND_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Removes all the fund registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of fund registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching fund registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns all the fund registrations where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @return the matching fund registrations
	*/
	public java.util.List<FundRegistration> findByDONOR_USER_ID(
		long DONOR_USER_ID);

	/**
	* Returns a range of all the fund registrations where DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByDONOR_USER_ID(
		long DONOR_USER_ID, int start, int end);

	/**
	* Returns an ordered range of all the fund registrations where DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByDONOR_USER_ID(
		long DONOR_USER_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund registrations where DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByDONOR_USER_ID(
		long DONOR_USER_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public FundRegistration findByDONOR_USER_ID_First(long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the first fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByDONOR_USER_ID_First(long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns the last fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public FundRegistration findByDONOR_USER_ID_Last(long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the last fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByDONOR_USER_ID_Last(long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns the fund registrations before and after the current fund registration in the ordered set where DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_FUND_ID the primary key of the current fund registration
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public FundRegistration[] findByDONOR_USER_ID_PrevAndNext(
		long PROJECT_FUND_ID, long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Removes all the fund registrations where DONOR_USER_ID = &#63; from the database.
	*
	* @param DONOR_USER_ID the donor_user_id
	*/
	public void removeByDONOR_USER_ID(long DONOR_USER_ID);

	/**
	* Returns the number of fund registrations where DONOR_USER_ID = &#63;.
	*
	* @param DONOR_USER_ID the donor_user_id
	* @return the number of matching fund registrations
	*/
	public int countByDONOR_USER_ID(long DONOR_USER_ID);

	/**
	* Returns all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @return the matching fund registrations
	*/
	public java.util.List<FundRegistration> findByPROJECT_DONOR_USER_ID(
		long PROJECT_ID, long DONOR_USER_ID);

	/**
	* Returns a range of all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByPROJECT_DONOR_USER_ID(
		long PROJECT_ID, long DONOR_USER_ID, int start, int end);

	/**
	* Returns an ordered range of all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByPROJECT_DONOR_USER_ID(
		long PROJECT_ID, long DONOR_USER_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund registrations
	*/
	public java.util.List<FundRegistration> findByPROJECT_DONOR_USER_ID(
		long PROJECT_ID, long DONOR_USER_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public FundRegistration findByPROJECT_DONOR_USER_ID_First(long PROJECT_ID,
		long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the first fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByPROJECT_DONOR_USER_ID_First(
		long PROJECT_ID, long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns the last fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration
	* @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	*/
	public FundRegistration findByPROJECT_DONOR_USER_ID_Last(long PROJECT_ID,
		long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the last fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	*/
	public FundRegistration fetchByPROJECT_DONOR_USER_ID_Last(long PROJECT_ID,
		long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns the fund registrations before and after the current fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_FUND_ID the primary key of the current fund registration
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public FundRegistration[] findByPROJECT_DONOR_USER_ID_PrevAndNext(
		long PROJECT_FUND_ID, long PROJECT_ID, long DONOR_USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException;

	/**
	* Removes all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	*/
	public void removeByPROJECT_DONOR_USER_ID(long PROJECT_ID,
		long DONOR_USER_ID);

	/**
	* Returns the number of fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param DONOR_USER_ID the donor_user_id
	* @return the number of matching fund registrations
	*/
	public int countByPROJECT_DONOR_USER_ID(long PROJECT_ID, long DONOR_USER_ID);

	/**
	* Caches the fund registration in the entity cache if it is enabled.
	*
	* @param fundRegistration the fund registration
	*/
	public void cacheResult(FundRegistration fundRegistration);

	/**
	* Caches the fund registrations in the entity cache if it is enabled.
	*
	* @param fundRegistrations the fund registrations
	*/
	public void cacheResult(java.util.List<FundRegistration> fundRegistrations);

	/**
	* Creates a new fund registration with the primary key. Does not add the fund registration to the database.
	*
	* @param PROJECT_FUND_ID the primary key for the new fund registration
	* @return the new fund registration
	*/
	public FundRegistration create(long PROJECT_FUND_ID);

	/**
	* Removes the fund registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FUND_ID the primary key of the fund registration
	* @return the fund registration that was removed
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public FundRegistration remove(long PROJECT_FUND_ID)
		throws NoSuchFundRegistrationException;

	public FundRegistration updateImpl(FundRegistration fundRegistration);

	/**
	* Returns the fund registration with the primary key or throws a {@link NoSuchFundRegistrationException} if it could not be found.
	*
	* @param PROJECT_FUND_ID the primary key of the fund registration
	* @return the fund registration
	* @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	*/
	public FundRegistration findByPrimaryKey(long PROJECT_FUND_ID)
		throws NoSuchFundRegistrationException;

	/**
	* Returns the fund registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_FUND_ID the primary key of the fund registration
	* @return the fund registration, or <code>null</code> if a fund registration with the primary key could not be found
	*/
	public FundRegistration fetchByPrimaryKey(long PROJECT_FUND_ID);

	@Override
	public java.util.Map<java.io.Serializable, FundRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the fund registrations.
	*
	* @return the fund registrations
	*/
	public java.util.List<FundRegistration> findAll();

	/**
	* Returns a range of all the fund registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of fund registrations
	*/
	public java.util.List<FundRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the fund registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fund registrations
	*/
	public java.util.List<FundRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of fund registrations
	*/
	public java.util.List<FundRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the fund registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of fund registrations.
	*
	* @return the number of fund registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}