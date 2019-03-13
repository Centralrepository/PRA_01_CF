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

import com.crowd.funding.database.model.FeedbackRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the feedback registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.FeedbackRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.FeedbackRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class FeedbackRegistrationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(FeedbackRegistration feedbackRegistration) {
		getPersistence().clearCache(feedbackRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FeedbackRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FeedbackRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FeedbackRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FeedbackRegistration update(
		FeedbackRegistration feedbackRegistration) {
		return getPersistence().update(feedbackRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FeedbackRegistration update(
		FeedbackRegistration feedbackRegistration, ServiceContext serviceContext) {
		return getPersistence().update(feedbackRegistration, serviceContext);
	}

	/**
	* Returns all the feedback registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching feedback registrations
	*/
	public static List<FeedbackRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<FeedbackRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<FeedbackRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FeedbackRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<FeedbackRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FeedbackRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first feedback registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration findByUuid_First(String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first feedback registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration fetchByUuid_First(String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last feedback registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration findByUuid_Last(String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last feedback registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the feedback registrations before and after the current feedback registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the current feedback registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next feedback registration
	* @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	*/
	public static FeedbackRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FEEDBACK_ID, String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_FEEDBACK_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the feedback registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of feedback registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching feedback registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the feedback registration where PROJECT_FEEDBACK_ID = &#63; or throws a {@link NoSuchFeedbackRegistrationException} if it could not be found.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @return the matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration findByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence().findByPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);
	}

	/**
	* Returns the feedback registration where PROJECT_FEEDBACK_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @return the matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration fetchByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID) {
		return getPersistence().fetchByPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);
	}

	/**
	* Returns the feedback registration where PROJECT_FEEDBACK_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration fetchByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID,
			retrieveFromCache);
	}

	/**
	* Removes the feedback registration where PROJECT_FEEDBACK_ID = &#63; from the database.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @return the feedback registration that was removed
	*/
	public static FeedbackRegistration removeByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence().removeByPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);
	}

	/**
	* Returns the number of feedback registrations where PROJECT_FEEDBACK_ID = &#63;.
	*
	* @param PROJECT_FEEDBACK_ID the project_feedback_id
	* @return the number of matching feedback registrations
	*/
	public static int countByPROJECT_FEEDBACK_ID(long PROJECT_FEEDBACK_ID) {
		return getPersistence().countByPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);
	}

	/**
	* Returns all the feedback registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching feedback registrations
	*/
	public static List<FeedbackRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

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
	public static List<FeedbackRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

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
	public static List<FeedbackRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

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
	public static List<FeedbackRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FeedbackRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback registration
	* @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	*/
	public static FeedbackRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the feedback registrations before and after the current feedback registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the current feedback registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next feedback registration
	* @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	*/
	public static FeedbackRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FEEDBACK_ID, long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_FEEDBACK_ID,
			PROJECT_ID, orderByComparator);
	}

	/**
	* Removes all the feedback registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of feedback registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching feedback registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Caches the feedback registration in the entity cache if it is enabled.
	*
	* @param feedbackRegistration the feedback registration
	*/
	public static void cacheResult(FeedbackRegistration feedbackRegistration) {
		getPersistence().cacheResult(feedbackRegistration);
	}

	/**
	* Caches the feedback registrations in the entity cache if it is enabled.
	*
	* @param feedbackRegistrations the feedback registrations
	*/
	public static void cacheResult(
		List<FeedbackRegistration> feedbackRegistrations) {
		getPersistence().cacheResult(feedbackRegistrations);
	}

	/**
	* Creates a new feedback registration with the primary key. Does not add the feedback registration to the database.
	*
	* @param PROJECT_FEEDBACK_ID the primary key for the new feedback registration
	* @return the new feedback registration
	*/
	public static FeedbackRegistration create(long PROJECT_FEEDBACK_ID) {
		return getPersistence().create(PROJECT_FEEDBACK_ID);
	}

	/**
	* Removes the feedback registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	* @return the feedback registration that was removed
	* @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	*/
	public static FeedbackRegistration remove(long PROJECT_FEEDBACK_ID)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence().remove(PROJECT_FEEDBACK_ID);
	}

	public static FeedbackRegistration updateImpl(
		FeedbackRegistration feedbackRegistration) {
		return getPersistence().updateImpl(feedbackRegistration);
	}

	/**
	* Returns the feedback registration with the primary key or throws a {@link NoSuchFeedbackRegistrationException} if it could not be found.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	* @return the feedback registration
	* @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	*/
	public static FeedbackRegistration findByPrimaryKey(
		long PROJECT_FEEDBACK_ID)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_FEEDBACK_ID);
	}

	/**
	* Returns the feedback registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	* @return the feedback registration, or <code>null</code> if a feedback registration with the primary key could not be found
	*/
	public static FeedbackRegistration fetchByPrimaryKey(
		long PROJECT_FEEDBACK_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_FEEDBACK_ID);
	}

	public static java.util.Map<java.io.Serializable, FeedbackRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the feedback registrations.
	*
	* @return the feedback registrations
	*/
	public static List<FeedbackRegistration> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<FeedbackRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<FeedbackRegistration> findAll(int start, int end,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<FeedbackRegistration> findAll(int start, int end,
		OrderByComparator<FeedbackRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the feedback registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of feedback registrations.
	*
	* @return the number of feedback registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FeedbackRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FeedbackRegistrationPersistence, FeedbackRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FeedbackRegistrationPersistence.class);

		ServiceTracker<FeedbackRegistrationPersistence, FeedbackRegistrationPersistence> serviceTracker =
			new ServiceTracker<FeedbackRegistrationPersistence, FeedbackRegistrationPersistence>(bundle.getBundleContext(),
				FeedbackRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}