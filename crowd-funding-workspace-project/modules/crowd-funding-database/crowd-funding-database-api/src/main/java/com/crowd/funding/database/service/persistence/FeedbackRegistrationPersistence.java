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

import com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException;
import com.crowd.funding.database.model.FeedbackRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the feedback registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.FeedbackRegistrationPersistenceImpl
 * @see FeedbackRegistrationUtil
 * @generated
 */
@ProviderType
public interface FeedbackRegistrationPersistence extends BasePersistence<FeedbackRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FeedbackRegistrationUtil} to access the feedback registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the feedback registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the feedback registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @return the range of matching feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the feedback registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the feedback registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first feedback registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public FeedbackRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException;

	/**
	* Returns the first feedback registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public FeedbackRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator);

	/**
	* Returns the last feedback registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public FeedbackRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException;

	/**
	* Returns the last feedback registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public FeedbackRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator);

	/**
	* Returns the feedback registrations before and after the current feedback registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the current feedback registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next feedback registration
	* @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	*/
	public FeedbackRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FEEDBACK_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException;

	/**
	* Removes all the feedback registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of feedback registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching feedback registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the feedback registration where PROJECT_FEEDBACK_ID = &#63; or throws a {@link NoSuchFeedbackRegistrationException} if it could not be found.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @return the matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public FeedbackRegistration findByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID) throws NoSuchFeedbackRegistrationException;

	/**
	* Returns the feedback registration where PROJECT_FEEDBACK_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @return the matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public FeedbackRegistration fetchByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID);

	/**
	* Returns the feedback registration where PROJECT_FEEDBACK_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public FeedbackRegistration fetchByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID, boolean retrieveFromCache);

	/**
	* Removes the feedback registration where PROJECT_FEEDBACK_ID = &#63; from the database.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @return the feedback registration that was removed
	*/
	public FeedbackRegistration removeByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID) throws NoSuchFeedbackRegistrationException;

	/**
	* Returns the number of feedback registrations where PROJECT_FEEDBACK_ID = &#63;.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @return the number of matching feedback registrations
	*/
	public int countByPROJECT_FEEDBACK_ID(long PROJECT_FEEDBACK_ID);

	/**
	* Returns all the feedback registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findByPROJECT_ID(
		long PROJECT_ID);

	/**
	* Returns a range of all the feedback registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @return the range of matching feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

	/**
	* Returns an ordered range of all the feedback registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the feedback registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public FeedbackRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException;

	/**
	* Returns the first feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public FeedbackRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator);

	/**
	* Returns the last feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public FeedbackRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException;

	/**
	* Returns the last feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public FeedbackRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator);

	/**
	* Returns the feedback registrations before and after the current feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the current feedback registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next feedback registration
	* @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	*/
	public FeedbackRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FEEDBACK_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException;

	/**
	* Removes all the feedback registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of feedback registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching feedback registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Caches the feedback registration in the entity cache if it is enabled.
	*
	* @param feedbackRegistration the feedback registration
	*/
	public void cacheResult(FeedbackRegistration feedbackRegistration);

	/**
	* Caches the feedback registrations in the entity cache if it is enabled.
	*
	* @param feedbackRegistrations the feedback registrations
	*/
	public void cacheResult(
		java.util.List<FeedbackRegistration> feedbackRegistrations);

	/**
	* Creates a new feedback registration with the primary key. Does not add the feedback registration to the database.
	*
	* @param PROJECT_FEEDBACK_ID the primary key for the new feedback registration
	* @return the new feedback registration
	*/
	public FeedbackRegistration create(long PROJECT_FEEDBACK_ID);

	/**
	* Removes the feedback registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	* @return the feedback registration that was removed
	* @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	*/
	public FeedbackRegistration remove(long PROJECT_FEEDBACK_ID)
		throws NoSuchFeedbackRegistrationException;

	public FeedbackRegistration updateImpl(
		FeedbackRegistration feedbackRegistration);

	/**
	* Returns the feedback registration with the primary key or throws a {@link NoSuchFeedbackRegistrationException} if it could not be found.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	* @return the feedback registration
	* @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	*/
	public FeedbackRegistration findByPrimaryKey(long PROJECT_FEEDBACK_ID)
		throws NoSuchFeedbackRegistrationException;

	/**
	* Returns the feedback registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	* @return the feedback registration, or <code>null</code> if a feedback registration with the primary key could not be found
	*/
	public FeedbackRegistration fetchByPrimaryKey(long PROJECT_FEEDBACK_ID);

	@Override
	public java.util.Map<java.io.Serializable, FeedbackRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the feedback registrations.
	*
	* @return the feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findAll();

	/**
	* Returns a range of all the feedback registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @return the range of feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the feedback registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the feedback registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of feedback registrations
	*/
	public java.util.List<FeedbackRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FeedbackRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the feedback registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of feedback registrations.
	*
	* @return the number of feedback registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}