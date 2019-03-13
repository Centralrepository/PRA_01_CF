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

import com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException;
import com.crowd.funding.database.model.FundReleaseRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the fund release registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.FundReleaseRegistrationPersistenceImpl
 * @see FundReleaseRegistrationUtil
 * @generated
 */
@ProviderType
public interface FundReleaseRegistrationPersistence extends BasePersistence<FundReleaseRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FundReleaseRegistrationUtil} to access the fund release registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the fund release registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the fund release registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @return the range of matching fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the fund release registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund release registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fund release registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException;

	/**
	* Returns the first fund release registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator);

	/**
	* Returns the last fund release registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException;

	/**
	* Returns the last fund release registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator);

	/**
	* Returns the fund release registrations before and after the current fund release registration in the ordered set where uuid = &#63;.
	*
	* @param FUND_RELEASE_ID the primary key of the current fund release registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	*/
	public FundReleaseRegistration[] findByUuid_PrevAndNext(
		long FUND_RELEASE_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException;

	/**
	* Removes all the fund release registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of fund release registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching fund release registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the fund release registration where FUND_RELEASE_ID = &#63; or throws a {@link NoSuchFundReleaseRegistrationException} if it could not be found.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @return the matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration findByFUND_RELEASE_ID(long FUND_RELEASE_ID)
		throws NoSuchFundReleaseRegistrationException;

	/**
	* Returns the fund release registration where FUND_RELEASE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @return the matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration fetchByFUND_RELEASE_ID(long FUND_RELEASE_ID);

	/**
	* Returns the fund release registration where FUND_RELEASE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration fetchByFUND_RELEASE_ID(
		long FUND_RELEASE_ID, boolean retrieveFromCache);

	/**
	* Removes the fund release registration where FUND_RELEASE_ID = &#63; from the database.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @return the fund release registration that was removed
	*/
	public FundReleaseRegistration removeByFUND_RELEASE_ID(long FUND_RELEASE_ID)
		throws NoSuchFundReleaseRegistrationException;

	/**
	* Returns the number of fund release registrations where FUND_RELEASE_ID = &#63;.
	*
	* @param FUND_RELEASE_ID the fund_release_id
	* @return the number of matching fund release registrations
	*/
	public int countByFUND_RELEASE_ID(long FUND_RELEASE_ID);

	/**
	* Returns all the fund release registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID);

	/**
	* Returns a range of all the fund release registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @return the range of matching fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

	/**
	* Returns an ordered range of all the fund release registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund release registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException;

	/**
	* Returns the first fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator);

	/**
	* Returns the last fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException;

	/**
	* Returns the last fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	*/
	public FundReleaseRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator);

	/**
	* Returns the fund release registrations before and after the current fund release registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param FUND_RELEASE_ID the primary key of the current fund release registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	*/
	public FundReleaseRegistration[] findByPROJECT_ID_PrevAndNext(
		long FUND_RELEASE_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException;

	/**
	* Removes all the fund release registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of fund release registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching fund release registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Caches the fund release registration in the entity cache if it is enabled.
	*
	* @param fundReleaseRegistration the fund release registration
	*/
	public void cacheResult(FundReleaseRegistration fundReleaseRegistration);

	/**
	* Caches the fund release registrations in the entity cache if it is enabled.
	*
	* @param fundReleaseRegistrations the fund release registrations
	*/
	public void cacheResult(
		java.util.List<FundReleaseRegistration> fundReleaseRegistrations);

	/**
	* Creates a new fund release registration with the primary key. Does not add the fund release registration to the database.
	*
	* @param FUND_RELEASE_ID the primary key for the new fund release registration
	* @return the new fund release registration
	*/
	public FundReleaseRegistration create(long FUND_RELEASE_ID);

	/**
	* Removes the fund release registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration that was removed
	* @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	*/
	public FundReleaseRegistration remove(long FUND_RELEASE_ID)
		throws NoSuchFundReleaseRegistrationException;

	public FundReleaseRegistration updateImpl(
		FundReleaseRegistration fundReleaseRegistration);

	/**
	* Returns the fund release registration with the primary key or throws a {@link NoSuchFundReleaseRegistrationException} if it could not be found.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration
	* @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	*/
	public FundReleaseRegistration findByPrimaryKey(long FUND_RELEASE_ID)
		throws NoSuchFundReleaseRegistrationException;

	/**
	* Returns the fund release registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration, or <code>null</code> if a fund release registration with the primary key could not be found
	*/
	public FundReleaseRegistration fetchByPrimaryKey(long FUND_RELEASE_ID);

	@Override
	public java.util.Map<java.io.Serializable, FundReleaseRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the fund release registrations.
	*
	* @return the fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findAll();

	/**
	* Returns a range of all the fund release registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @return the range of fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the fund release registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the fund release registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of fund release registrations
	*/
	public java.util.List<FundReleaseRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FundReleaseRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the fund release registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of fund release registrations.
	*
	* @return the number of fund release registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}