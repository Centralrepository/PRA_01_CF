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

import com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException;
import com.crowd.funding.database.model.SubscriptionRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the subscription registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.SubscriptionRegistrationPersistenceImpl
 * @see SubscriptionRegistrationUtil
 * @generated
 */
@ProviderType
public interface SubscriptionRegistrationPersistence extends BasePersistence<SubscriptionRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubscriptionRegistrationUtil} to access the subscription registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the subscription registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the subscription registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @return the range of matching subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the subscription registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the subscription registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first subscription registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException;

	/**
	* Returns the first subscription registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator);

	/**
	* Returns the last subscription registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException;

	/**
	* Returns the last subscription registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator);

	/**
	* Returns the subscription registrations before and after the current subscription registration in the ordered set where uuid = &#63;.
	*
	* @param SUSCRIBER_ID the primary key of the current subscription registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	*/
	public SubscriptionRegistration[] findByUuid_PrevAndNext(
		long SUSCRIBER_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException;

	/**
	* Removes all the subscription registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of subscription registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching subscription registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns all the subscription registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findBySTATUS(int STATUS);

	/**
	* Returns a range of all the subscription registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @return the range of matching subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findBySTATUS(int STATUS,
		int start, int end);

	/**
	* Returns an ordered range of all the subscription registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the subscription registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration findBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException;

	/**
	* Returns the first subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration fetchBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator);

	/**
	* Returns the last subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration findBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException;

	/**
	* Returns the last subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration fetchBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator);

	/**
	* Returns the subscription registrations before and after the current subscription registration in the ordered set where STATUS = &#63;.
	*
	* @param SUSCRIBER_ID the primary key of the current subscription registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	*/
	public SubscriptionRegistration[] findBySTATUS_PrevAndNext(
		long SUSCRIBER_ID, int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException;

	/**
	* Removes all the subscription registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public void removeBySTATUS(int STATUS);

	/**
	* Returns the number of subscription registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching subscription registrations
	*/
	public int countBySTATUS(int STATUS);

	/**
	* Returns the subscription registration where EMAIL = &#63; or throws a {@link NoSuchSubscriptionRegistrationException} if it could not be found.
	*
	* @param EMAIL the email
	* @return the matching subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration findByEMAIL(String EMAIL)
		throws NoSuchSubscriptionRegistrationException;

	/**
	* Returns the subscription registration where EMAIL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param EMAIL the email
	* @return the matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration fetchByEMAIL(String EMAIL);

	/**
	* Returns the subscription registration where EMAIL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param EMAIL the email
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	*/
	public SubscriptionRegistration fetchByEMAIL(String EMAIL,
		boolean retrieveFromCache);

	/**
	* Removes the subscription registration where EMAIL = &#63; from the database.
	*
	* @param EMAIL the email
	* @return the subscription registration that was removed
	*/
	public SubscriptionRegistration removeByEMAIL(String EMAIL)
		throws NoSuchSubscriptionRegistrationException;

	/**
	* Returns the number of subscription registrations where EMAIL = &#63;.
	*
	* @param EMAIL the email
	* @return the number of matching subscription registrations
	*/
	public int countByEMAIL(String EMAIL);

	/**
	* Caches the subscription registration in the entity cache if it is enabled.
	*
	* @param subscriptionRegistration the subscription registration
	*/
	public void cacheResult(SubscriptionRegistration subscriptionRegistration);

	/**
	* Caches the subscription registrations in the entity cache if it is enabled.
	*
	* @param subscriptionRegistrations the subscription registrations
	*/
	public void cacheResult(
		java.util.List<SubscriptionRegistration> subscriptionRegistrations);

	/**
	* Creates a new subscription registration with the primary key. Does not add the subscription registration to the database.
	*
	* @param SUSCRIBER_ID the primary key for the new subscription registration
	* @return the new subscription registration
	*/
	public SubscriptionRegistration create(long SUSCRIBER_ID);

	/**
	* Removes the subscription registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration that was removed
	* @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	*/
	public SubscriptionRegistration remove(long SUSCRIBER_ID)
		throws NoSuchSubscriptionRegistrationException;

	public SubscriptionRegistration updateImpl(
		SubscriptionRegistration subscriptionRegistration);

	/**
	* Returns the subscription registration with the primary key or throws a {@link NoSuchSubscriptionRegistrationException} if it could not be found.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration
	* @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	*/
	public SubscriptionRegistration findByPrimaryKey(long SUSCRIBER_ID)
		throws NoSuchSubscriptionRegistrationException;

	/**
	* Returns the subscription registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SUSCRIBER_ID the primary key of the subscription registration
	* @return the subscription registration, or <code>null</code> if a subscription registration with the primary key could not be found
	*/
	public SubscriptionRegistration fetchByPrimaryKey(long SUSCRIBER_ID);

	@Override
	public java.util.Map<java.io.Serializable, SubscriptionRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the subscription registrations.
	*
	* @return the subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findAll();

	/**
	* Returns a range of all the subscription registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @return the range of subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the subscription registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the subscription registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of subscription registrations
	* @param end the upper bound of the range of subscription registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of subscription registrations
	*/
	public java.util.List<SubscriptionRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubscriptionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the subscription registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of subscription registrations.
	*
	* @return the number of subscription registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}