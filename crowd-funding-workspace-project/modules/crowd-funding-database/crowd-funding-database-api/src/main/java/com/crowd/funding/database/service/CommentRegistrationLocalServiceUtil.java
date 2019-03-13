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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CommentRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.CommentRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CommentRegistrationLocalService
 * @see com.crowd.funding.database.service.base.CommentRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.CommentRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class CommentRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.CommentRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the comment registration to the database. Also notifies the appropriate model listeners.
	*
	* @param commentRegistration the comment registration
	* @return the comment registration that was added
	*/
	public static com.crowd.funding.database.model.CommentRegistration addCommentRegistration(
		com.crowd.funding.database.model.CommentRegistration commentRegistration) {
		return getService().addCommentRegistration(commentRegistration);
	}

	/**
	* Creates a new comment registration with the primary key. Does not add the comment registration to the database.
	*
	* @param PROJECT_COMMENT_ID the primary key for the new comment registration
	* @return the new comment registration
	*/
	public static com.crowd.funding.database.model.CommentRegistration createCommentRegistration(
		long PROJECT_COMMENT_ID) {
		return getService().createCommentRegistration(PROJECT_COMMENT_ID);
	}

	/**
	* Deletes the comment registration from the database. Also notifies the appropriate model listeners.
	*
	* @param commentRegistration the comment registration
	* @return the comment registration that was removed
	*/
	public static com.crowd.funding.database.model.CommentRegistration deleteCommentRegistration(
		com.crowd.funding.database.model.CommentRegistration commentRegistration) {
		return getService().deleteCommentRegistration(commentRegistration);
	}

	/**
	* Deletes the comment registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_COMMENT_ID the primary key of the comment registration
	* @return the comment registration that was removed
	* @throws PortalException if a comment registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.CommentRegistration deleteCommentRegistration(
		long PROJECT_COMMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCommentRegistration(PROJECT_COMMENT_ID);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.crowd.funding.database.model.CommentRegistration fetchCommentRegistration(
		long PROJECT_COMMENT_ID) {
		return getService().fetchCommentRegistration(PROJECT_COMMENT_ID);
	}

	public static com.crowd.funding.database.model.CommentRegistration findByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getService().findByPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.CommentRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getService().findByPROJECT_ID(PROJECT_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.CommentRegistration> findByPROJECT_ID_STATUS(
		long PROJECT_ID, int STATUS) {
		return getService().findByPROJECT_ID_STATUS(PROJECT_ID, STATUS);
	}

	public static java.util.List<com.crowd.funding.database.model.CommentRegistration> findBySTATUS(
		int STATUS) {
		return getService().findBySTATUS(STATUS);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the comment registration with the primary key.
	*
	* @param PROJECT_COMMENT_ID the primary key of the comment registration
	* @return the comment registration
	* @throws PortalException if a comment registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.CommentRegistration getCommentRegistration(
		long PROJECT_COMMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCommentRegistration(PROJECT_COMMENT_ID);
	}

	/**
	* Returns a range of all the comment registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @return the range of comment registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.CommentRegistration> getCommentRegistrations(
		int start, int end) {
		return getService().getCommentRegistrations(start, end);
	}

	/**
	* Returns the number of comment registrations.
	*
	* @return the number of comment registrations
	*/
	public static int getCommentRegistrationsCount() {
		return getService().getCommentRegistrationsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the comment registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commentRegistration the comment registration
	* @return the comment registration that was updated
	*/
	public static com.crowd.funding.database.model.CommentRegistration updateCommentRegistration(
		com.crowd.funding.database.model.CommentRegistration commentRegistration) {
		return getService().updateCommentRegistration(commentRegistration);
	}

	public static CommentRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CommentRegistrationLocalService, CommentRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CommentRegistrationLocalService.class);

		ServiceTracker<CommentRegistrationLocalService, CommentRegistrationLocalService> serviceTracker =
			new ServiceTracker<CommentRegistrationLocalService, CommentRegistrationLocalService>(bundle.getBundleContext(),
				CommentRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}