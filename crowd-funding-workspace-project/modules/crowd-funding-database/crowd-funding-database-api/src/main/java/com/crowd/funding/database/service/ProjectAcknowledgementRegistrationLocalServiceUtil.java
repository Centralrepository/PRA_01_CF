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
 * Provides the local service utility for ProjectAcknowledgementRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.ProjectAcknowledgementRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectAcknowledgementRegistrationLocalService
 * @see com.crowd.funding.database.service.base.ProjectAcknowledgementRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.ProjectAcknowledgementRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class ProjectAcknowledgementRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.ProjectAcknowledgementRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project acknowledgement registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectAcknowledgementRegistration the project acknowledgement registration
	* @return the project acknowledgement registration that was added
	*/
	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistration addProjectAcknowledgementRegistration(
		com.crowd.funding.database.model.ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		return getService()
				   .addProjectAcknowledgementRegistration(projectAcknowledgementRegistration);
	}

	/**
	* Creates a new project acknowledgement registration with the primary key. Does not add the project acknowledgement registration to the database.
	*
	* @param ACKNOWLEDGMENT_ID the primary key for the new project acknowledgement registration
	* @return the new project acknowledgement registration
	*/
	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistration createProjectAcknowledgementRegistration(
		long ACKNOWLEDGMENT_ID) {
		return getService()
				   .createProjectAcknowledgementRegistration(ACKNOWLEDGMENT_ID);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the project acknowledgement registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration that was removed
	* @throws PortalException if a project acknowledgement registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistration deleteProjectAcknowledgementRegistration(
		long ACKNOWLEDGMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteProjectAcknowledgementRegistration(ACKNOWLEDGMENT_ID);
	}

	/**
	* Deletes the project acknowledgement registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectAcknowledgementRegistration the project acknowledgement registration
	* @return the project acknowledgement registration that was removed
	*/
	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistration deleteProjectAcknowledgementRegistration(
		com.crowd.funding.database.model.ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		return getService()
				   .deleteProjectAcknowledgementRegistration(projectAcknowledgementRegistration);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistration fetchProjectAcknowledgementRegistration(
		long ACKNOWLEDGMENT_ID) {
		return getService()
				   .fetchProjectAcknowledgementRegistration(ACKNOWLEDGMENT_ID);
	}

	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistration findByPROJECT_ID(
		long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException {
		return getService().findByPROJECT_ID(PROJECT_ID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistrationDOCUMENTBlobModel getDOCUMENTBlobModel(
		java.io.Serializable primaryKey) {
		return getService().getDOCUMENTBlobModel(primaryKey);
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
	* Returns the project acknowledgement registration with the primary key.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration
	* @throws PortalException if a project acknowledgement registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistration getProjectAcknowledgementRegistration(
		long ACKNOWLEDGMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .getProjectAcknowledgementRegistration(ACKNOWLEDGMENT_ID);
	}

	/**
	* Returns a range of all the project acknowledgement registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project acknowledgement registrations
	* @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	* @return the range of project acknowledgement registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.ProjectAcknowledgementRegistration> getProjectAcknowledgementRegistrations(
		int start, int end) {
		return getService().getProjectAcknowledgementRegistrations(start, end);
	}

	/**
	* Returns the number of project acknowledgement registrations.
	*
	* @return the number of project acknowledgement registrations
	*/
	public static int getProjectAcknowledgementRegistrationsCount() {
		return getService().getProjectAcknowledgementRegistrationsCount();
	}

	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistrationVIDEOBlobModel getVIDEOBlobModel(
		java.io.Serializable primaryKey) {
		return getService().getVIDEOBlobModel(primaryKey);
	}

	/**
	* Updates the project acknowledgement registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectAcknowledgementRegistration the project acknowledgement registration
	* @return the project acknowledgement registration that was updated
	*/
	public static com.crowd.funding.database.model.ProjectAcknowledgementRegistration updateProjectAcknowledgementRegistration(
		com.crowd.funding.database.model.ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		return getService()
				   .updateProjectAcknowledgementRegistration(projectAcknowledgementRegistration);
	}

	public static ProjectAcknowledgementRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectAcknowledgementRegistrationLocalService, ProjectAcknowledgementRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectAcknowledgementRegistrationLocalService.class);

		ServiceTracker<ProjectAcknowledgementRegistrationLocalService, ProjectAcknowledgementRegistrationLocalService> serviceTracker =
			new ServiceTracker<ProjectAcknowledgementRegistrationLocalService, ProjectAcknowledgementRegistrationLocalService>(bundle.getBundleContext(),
				ProjectAcknowledgementRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}