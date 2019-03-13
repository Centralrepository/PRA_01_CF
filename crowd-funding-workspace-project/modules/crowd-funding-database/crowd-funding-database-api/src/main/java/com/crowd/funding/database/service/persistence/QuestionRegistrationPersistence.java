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

import com.crowd.funding.database.exception.NoSuchQuestionRegistrationException;
import com.crowd.funding.database.model.QuestionRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the question registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.QuestionRegistrationPersistenceImpl
 * @see QuestionRegistrationUtil
 * @generated
 */
@ProviderType
public interface QuestionRegistrationPersistence extends BasePersistence<QuestionRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionRegistrationUtil} to access the question registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the question registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching question registrations
	*/
	public java.util.List<QuestionRegistration> findByUuid(String uuid);

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
	public java.util.List<QuestionRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<QuestionRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator);

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
	public java.util.List<QuestionRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first question registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public QuestionRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException;

	/**
	* Returns the first question registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public QuestionRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator);

	/**
	* Returns the last question registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public QuestionRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException;

	/**
	* Returns the last question registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public QuestionRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator);

	/**
	* Returns the question registrations before and after the current question registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_QUESTION_ID the primary key of the current question registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question registration
	* @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	*/
	public QuestionRegistration[] findByUuid_PrevAndNext(
		long PROJECT_QUESTION_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException;

	/**
	* Removes all the question registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of question registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching question registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the question registration where PROJECT_QUESTION_ID = &#63; or throws a {@link NoSuchQuestionRegistrationException} if it could not be found.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @return the matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public QuestionRegistration findByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID) throws NoSuchQuestionRegistrationException;

	/**
	* Returns the question registration where PROJECT_QUESTION_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @return the matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public QuestionRegistration fetchByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID);

	/**
	* Returns the question registration where PROJECT_QUESTION_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public QuestionRegistration fetchByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID, boolean retrieveFromCache);

	/**
	* Removes the question registration where PROJECT_QUESTION_ID = &#63; from the database.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @return the question registration that was removed
	*/
	public QuestionRegistration removeByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID) throws NoSuchQuestionRegistrationException;

	/**
	* Returns the number of question registrations where PROJECT_QUESTION_ID = &#63;.
	*
	* @param PROJECT_QUESTION_ID the project_question_id
	* @return the number of matching question registrations
	*/
	public int countByPROJECT_QUESTION_ID(long PROJECT_QUESTION_ID);

	/**
	* Returns all the question registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching question registrations
	*/
	public java.util.List<QuestionRegistration> findByPROJECT_ID(
		long PROJECT_ID);

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
	public java.util.List<QuestionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

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
	public java.util.List<QuestionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator);

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
	public java.util.List<QuestionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public QuestionRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException;

	/**
	* Returns the first question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public QuestionRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator);

	/**
	* Returns the last question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question registration
	* @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	*/
	public QuestionRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException;

	/**
	* Returns the last question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question registration, or <code>null</code> if a matching question registration could not be found
	*/
	public QuestionRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator);

	/**
	* Returns the question registrations before and after the current question registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_QUESTION_ID the primary key of the current question registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question registration
	* @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	*/
	public QuestionRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_QUESTION_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException;

	/**
	* Removes all the question registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of question registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching question registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Caches the question registration in the entity cache if it is enabled.
	*
	* @param questionRegistration the question registration
	*/
	public void cacheResult(QuestionRegistration questionRegistration);

	/**
	* Caches the question registrations in the entity cache if it is enabled.
	*
	* @param questionRegistrations the question registrations
	*/
	public void cacheResult(
		java.util.List<QuestionRegistration> questionRegistrations);

	/**
	* Creates a new question registration with the primary key. Does not add the question registration to the database.
	*
	* @param PROJECT_QUESTION_ID the primary key for the new question registration
	* @return the new question registration
	*/
	public QuestionRegistration create(long PROJECT_QUESTION_ID);

	/**
	* Removes the question registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_QUESTION_ID the primary key of the question registration
	* @return the question registration that was removed
	* @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	*/
	public QuestionRegistration remove(long PROJECT_QUESTION_ID)
		throws NoSuchQuestionRegistrationException;

	public QuestionRegistration updateImpl(
		QuestionRegistration questionRegistration);

	/**
	* Returns the question registration with the primary key or throws a {@link NoSuchQuestionRegistrationException} if it could not be found.
	*
	* @param PROJECT_QUESTION_ID the primary key of the question registration
	* @return the question registration
	* @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	*/
	public QuestionRegistration findByPrimaryKey(long PROJECT_QUESTION_ID)
		throws NoSuchQuestionRegistrationException;

	/**
	* Returns the question registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_QUESTION_ID the primary key of the question registration
	* @return the question registration, or <code>null</code> if a question registration with the primary key could not be found
	*/
	public QuestionRegistration fetchByPrimaryKey(long PROJECT_QUESTION_ID);

	@Override
	public java.util.Map<java.io.Serializable, QuestionRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the question registrations.
	*
	* @return the question registrations
	*/
	public java.util.List<QuestionRegistration> findAll();

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
	public java.util.List<QuestionRegistration> findAll(int start, int end);

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
	public java.util.List<QuestionRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator);

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
	public java.util.List<QuestionRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the question registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of question registrations.
	*
	* @return the number of question registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}