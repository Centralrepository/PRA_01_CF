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

import com.crowd.funding.database.model.QuestionRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the question registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.QuestionRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.QuestionRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class QuestionRegistrationUtil {
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
	public static void clearCache(QuestionRegistration questionRegistration) {
		getPersistence().clearCache(questionRegistration);
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
	public static List<QuestionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuestionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuestionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuestionRegistration update(
		QuestionRegistration questionRegistration) {
		return getPersistence().update(questionRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuestionRegistration update(
		QuestionRegistration questionRegistration, ServiceContext serviceContext) {
		return getPersistence().update(questionRegistration, serviceContext);
	}

	/**
	* Returns all the question registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching question registrations
	*/
	public static List<QuestionRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the question registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @return the range of matching question registrations
	*/
	public static List<QuestionRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the question registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching question registrations
	*/
	public static List<QuestionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<QuestionRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the question registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching question registrations
	*/
	public static List<QuestionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<QuestionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first question registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public static QuestionRegistration findByUuid_First(String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first question registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public static QuestionRegistration fetchByUuid_First(String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last question registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public static QuestionRegistration findByUuid_Last(String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last question registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public static QuestionRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the question registrations before and after the current question registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_QUESTION_ID the primary key of the current question registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question registration
	* @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	*/
	public static QuestionRegistration[] findByUuid_PrevAndNext(
		long PROJECT_QUESTION_ID, String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_QUESTION_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the question registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of question registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching question registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the question registration where PROJECT_QUESTION_ID = &#63; or throws a {@link NoSuchQuestionRegistrationException} if it could not be found.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @return the matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public static QuestionRegistration findByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence().findByPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);
	}

	/**
	* Returns the question registration where PROJECT_QUESTION_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @return the matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public static QuestionRegistration fetchByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID) {
		return getPersistence().fetchByPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);
	}

	/**
	* Returns the question registration where PROJECT_QUESTION_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public static QuestionRegistration fetchByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_QUESTION_ID(PROJECT_QUESTION_ID,
			retrieveFromCache);
	}

	/**
	* Removes the question registration where PROJECT_QUESTION_ID = &#63; from the database.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @return the question registration that was removed
	*/
	public static QuestionRegistration removeByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence().removeByPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);
	}

	/**
	* Returns the number of question registrations where PROJECT_QUESTION_ID = &#63;.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @return the number of matching question registrations
	*/
	public static int countByPROJECT_QUESTION_ID(long PROJECT_QUESTION_ID) {
		return getPersistence().countByPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);
	}

	/**
	* Returns all the question registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching question registrations
	*/
	public static List<QuestionRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns a range of all the question registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @return the range of matching question registrations
	*/
	public static List<QuestionRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

	/**
	* Returns an ordered range of all the question registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching question registrations
	*/
	public static List<QuestionRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the question registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching question registrations
	*/
	public static List<QuestionRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<QuestionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public static QuestionRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public static QuestionRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public static QuestionRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public static QuestionRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the question registrations before and after the current question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_QUESTION_ID the primary key of the current question registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question registration
	* @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	*/
	public static QuestionRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_QUESTION_ID, long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_QUESTION_ID,
			PROJECT_ID, orderByComparator);
	}

	/**
	* Removes all the question registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of question registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching question registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Caches the question registration in the entity cache if it is enabled.
	*
	* @param questionRegistration the question registration
	*/
	public static void cacheResult(QuestionRegistration questionRegistration) {
		getPersistence().cacheResult(questionRegistration);
	}

	/**
	* Caches the question registrations in the entity cache if it is enabled.
	*
	* @param questionRegistrations the question registrations
	*/
	public static void cacheResult(
		List<QuestionRegistration> questionRegistrations) {
		getPersistence().cacheResult(questionRegistrations);
	}

	/**
	* Creates a new question registration with the primary key. Does not add the question registration to the database.
	*
	* @param PROJECT_QUESTION_ID the primary key for the new question registration
	* @return the new question registration
	*/
	public static QuestionRegistration create(long PROJECT_QUESTION_ID) {
		return getPersistence().create(PROJECT_QUESTION_ID);
	}

	/**
	* Removes the question registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_QUESTION_ID the primary key of the question registration
	* @return the question registration that was removed
	* @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	*/
	public static QuestionRegistration remove(long PROJECT_QUESTION_ID)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence().remove(PROJECT_QUESTION_ID);
	}

	public static QuestionRegistration updateImpl(
		QuestionRegistration questionRegistration) {
		return getPersistence().updateImpl(questionRegistration);
	}

	/**
	* Returns the question registration with the primary key or throws a {@link NoSuchQuestionRegistrationException} if it could not be found.
	*
	* @param PROJECT_QUESTION_ID the primary key of the question registration
	* @return the question registration
	* @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	*/
	public static QuestionRegistration findByPrimaryKey(
		long PROJECT_QUESTION_ID)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_QUESTION_ID);
	}

	/**
	* Returns the question registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_QUESTION_ID the primary key of the question registration
	* @return the question registration, or <code>null</code> if a question registration with the primary key could not be found
	*/
	public static QuestionRegistration fetchByPrimaryKey(
		long PROJECT_QUESTION_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_QUESTION_ID);
	}

	public static java.util.Map<java.io.Serializable, QuestionRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the question registrations.
	*
	* @return the question registrations
	*/
	public static List<QuestionRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the question registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @return the range of question registrations
	*/
	public static List<QuestionRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the question registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of question registrations
	*/
	public static List<QuestionRegistration> findAll(int start, int end,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the question registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of question registrations
	*/
	public static List<QuestionRegistration> findAll(int start, int end,
		OrderByComparator<QuestionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the question registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of question registrations.
	*
	* @return the number of question registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static QuestionRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuestionRegistrationPersistence, QuestionRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuestionRegistrationPersistence.class);

		ServiceTracker<QuestionRegistrationPersistence, QuestionRegistrationPersistence> serviceTracker =
			new ServiceTracker<QuestionRegistrationPersistence, QuestionRegistrationPersistence>(bundle.getBundleContext(),
				QuestionRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}