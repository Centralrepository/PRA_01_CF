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

package com.crowd.funding.database.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QuestionRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRegistrationLocalService
 * @generated
 */
@ProviderType
public class QuestionRegistrationLocalServiceWrapper
	implements QuestionRegistrationLocalService,
		ServiceWrapper<QuestionRegistrationLocalService> {
	public QuestionRegistrationLocalServiceWrapper(
		QuestionRegistrationLocalService questionRegistrationLocalService) {
		_questionRegistrationLocalService = questionRegistrationLocalService;
	}

	/**
	* Adds the question registration to the database. Also notifies the appropriate model listeners.
	*
	* @param questionRegistration the question registration
	* @return the question registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.QuestionRegistration addQuestionRegistration(
		com.crowd.funding.database.model.QuestionRegistration questionRegistration) {
		return _questionRegistrationLocalService.addQuestionRegistration(questionRegistration);
	}

	/**
	* Creates a new question registration with the primary key. Does not add the question registration to the database.
	*
	* @param PROJECT_QUESTION_ID the primary key for the new question registration
	* @return the new question registration
	*/
	@Override
	public com.crowd.funding.database.model.QuestionRegistration createQuestionRegistration(
		long PROJECT_QUESTION_ID) {
		return _questionRegistrationLocalService.createQuestionRegistration(PROJECT_QUESTION_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the question registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_QUESTION_ID the primary key of the question registration
	* @return the question registration that was removed
	* @throws PortalException if a question registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.QuestionRegistration deleteQuestionRegistration(
		long PROJECT_QUESTION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionRegistrationLocalService.deleteQuestionRegistration(PROJECT_QUESTION_ID);
	}

	/**
	* Deletes the question registration from the database. Also notifies the appropriate model listeners.
	*
	* @param questionRegistration the question registration
	* @return the question registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.QuestionRegistration deleteQuestionRegistration(
		com.crowd.funding.database.model.QuestionRegistration questionRegistration) {
		return _questionRegistrationLocalService.deleteQuestionRegistration(questionRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _questionRegistrationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _questionRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _questionRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _questionRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _questionRegistrationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _questionRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.QuestionRegistration fetchQuestionRegistration(
		long PROJECT_QUESTION_ID) {
		return _questionRegistrationLocalService.fetchQuestionRegistration(PROJECT_QUESTION_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.QuestionRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _questionRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.crowd.funding.database.model.QuestionRegistration findByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID)
		throws com.crowd.funding.database.exception.NoSuchQuestionRegistrationException {
		return _questionRegistrationLocalService.findByPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _questionRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _questionRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _questionRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the question registration with the primary key.
	*
	* @param PROJECT_QUESTION_ID the primary key of the question registration
	* @return the question registration
	* @throws PortalException if a question registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.QuestionRegistration getQuestionRegistration(
		long PROJECT_QUESTION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionRegistrationLocalService.getQuestionRegistration(PROJECT_QUESTION_ID);
	}

	/**
	* Returns a range of all the question registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question registrations
	* @param end the upper bound of the range of question registrations (not inclusive)
	* @return the range of question registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.QuestionRegistration> getQuestionRegistrations(
		int start, int end) {
		return _questionRegistrationLocalService.getQuestionRegistrations(start,
			end);
	}

	/**
	* Returns the number of question registrations.
	*
	* @return the number of question registrations
	*/
	@Override
	public int getQuestionRegistrationsCount() {
		return _questionRegistrationLocalService.getQuestionRegistrationsCount();
	}

	/**
	* Updates the question registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param questionRegistration the question registration
	* @return the question registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.QuestionRegistration updateQuestionRegistration(
		com.crowd.funding.database.model.QuestionRegistration questionRegistration) {
		return _questionRegistrationLocalService.updateQuestionRegistration(questionRegistration);
	}

	@Override
	public QuestionRegistrationLocalService getWrappedService() {
		return _questionRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		QuestionRegistrationLocalService questionRegistrationLocalService) {
		_questionRegistrationLocalService = questionRegistrationLocalService;
	}

	private QuestionRegistrationLocalService _questionRegistrationLocalService;
}