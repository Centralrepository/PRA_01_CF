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
 * Provides a wrapper for {@link FeedbackRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackRegistrationLocalService
 * @generated
 */
@ProviderType
public class FeedbackRegistrationLocalServiceWrapper
	implements FeedbackRegistrationLocalService,
		ServiceWrapper<FeedbackRegistrationLocalService> {
	public FeedbackRegistrationLocalServiceWrapper(
		FeedbackRegistrationLocalService feedbackRegistrationLocalService) {
		_feedbackRegistrationLocalService = feedbackRegistrationLocalService;
	}

	/**
	* Adds the feedback registration to the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackRegistration the feedback registration
	* @return the feedback registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.FeedbackRegistration addFeedbackRegistration(
		com.crowd.funding.database.model.FeedbackRegistration feedbackRegistration) {
		return _feedbackRegistrationLocalService.addFeedbackRegistration(feedbackRegistration);
	}

	/**
	* Creates a new feedback registration with the primary key. Does not add the feedback registration to the database.
	*
	* @param PROJECT_FEEDBACK_ID the primary key for the new feedback registration
	* @return the new feedback registration
	*/
	@Override
	public com.crowd.funding.database.model.FeedbackRegistration createFeedbackRegistration(
		long PROJECT_FEEDBACK_ID) {
		return _feedbackRegistrationLocalService.createFeedbackRegistration(PROJECT_FEEDBACK_ID);
	}

	/**
	* Deletes the feedback registration from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackRegistration the feedback registration
	* @return the feedback registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.FeedbackRegistration deleteFeedbackRegistration(
		com.crowd.funding.database.model.FeedbackRegistration feedbackRegistration) {
		return _feedbackRegistrationLocalService.deleteFeedbackRegistration(feedbackRegistration);
	}

	/**
	* Deletes the feedback registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	* @return the feedback registration that was removed
	* @throws PortalException if a feedback registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.FeedbackRegistration deleteFeedbackRegistration(
		long PROJECT_FEEDBACK_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _feedbackRegistrationLocalService.deleteFeedbackRegistration(PROJECT_FEEDBACK_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _feedbackRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _feedbackRegistrationLocalService.dynamicQuery();
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
		return _feedbackRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _feedbackRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _feedbackRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _feedbackRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _feedbackRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.FeedbackRegistration fetchFeedbackRegistration(
		long PROJECT_FEEDBACK_ID) {
		return _feedbackRegistrationLocalService.fetchFeedbackRegistration(PROJECT_FEEDBACK_ID);
	}

	@Override
	public com.crowd.funding.database.model.FeedbackRegistration findByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID)
		throws com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException {
		return _feedbackRegistrationLocalService.findByPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.FeedbackRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _feedbackRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _feedbackRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the feedback registration with the primary key.
	*
	* @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	* @return the feedback registration
	* @throws PortalException if a feedback registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.FeedbackRegistration getFeedbackRegistration(
		long PROJECT_FEEDBACK_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _feedbackRegistrationLocalService.getFeedbackRegistration(PROJECT_FEEDBACK_ID);
	}

	/**
	* Returns a range of all the feedback registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedback registrations
	* @param end the upper bound of the range of feedback registrations (not inclusive)
	* @return the range of feedback registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.FeedbackRegistration> getFeedbackRegistrations(
		int start, int end) {
		return _feedbackRegistrationLocalService.getFeedbackRegistrations(start,
			end);
	}

	/**
	* Returns the number of feedback registrations.
	*
	* @return the number of feedback registrations
	*/
	@Override
	public int getFeedbackRegistrationsCount() {
		return _feedbackRegistrationLocalService.getFeedbackRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _feedbackRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _feedbackRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _feedbackRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the feedback registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param feedbackRegistration the feedback registration
	* @return the feedback registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.FeedbackRegistration updateFeedbackRegistration(
		com.crowd.funding.database.model.FeedbackRegistration feedbackRegistration) {
		return _feedbackRegistrationLocalService.updateFeedbackRegistration(feedbackRegistration);
	}

	@Override
	public FeedbackRegistrationLocalService getWrappedService() {
		return _feedbackRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		FeedbackRegistrationLocalService feedbackRegistrationLocalService) {
		_feedbackRegistrationLocalService = feedbackRegistrationLocalService;
	}

	private FeedbackRegistrationLocalService _feedbackRegistrationLocalService;
}