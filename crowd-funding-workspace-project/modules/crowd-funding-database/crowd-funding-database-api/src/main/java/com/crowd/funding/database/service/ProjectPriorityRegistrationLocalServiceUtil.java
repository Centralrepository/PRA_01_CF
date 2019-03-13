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
 * Provides the local service utility for ProjectPriorityRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.ProjectPriorityRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPriorityRegistrationLocalService
 * @see com.crowd.funding.database.service.base.ProjectPriorityRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.ProjectPriorityRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class ProjectPriorityRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.ProjectPriorityRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project priority registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectPriorityRegistration the project priority registration
	* @return the project priority registration that was added
	*/
	public static com.crowd.funding.database.model.ProjectPriorityRegistration addProjectPriorityRegistration(
		com.crowd.funding.database.model.ProjectPriorityRegistration projectPriorityRegistration) {
		return getService()
				   .addProjectPriorityRegistration(projectPriorityRegistration);
	}

	/**
	* Creates a new project priority registration with the primary key. Does not add the project priority registration to the database.
	*
	* @param PROJECT_PRIORITY_ID the primary key for the new project priority registration
	* @return the new project priority registration
	*/
	public static com.crowd.funding.database.model.ProjectPriorityRegistration createProjectPriorityRegistration(
		long PROJECT_PRIORITY_ID) {
		return getService()
				   .createProjectPriorityRegistration(PROJECT_PRIORITY_ID);
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
	* Deletes the project priority registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration that was removed
	* @throws PortalException if a project priority registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.ProjectPriorityRegistration deleteProjectPriorityRegistration(
		long PROJECT_PRIORITY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .deleteProjectPriorityRegistration(PROJECT_PRIORITY_ID);
	}

	/**
	* Deletes the project priority registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectPriorityRegistration the project priority registration
	* @return the project priority registration that was removed
	*/
	public static com.crowd.funding.database.model.ProjectPriorityRegistration deleteProjectPriorityRegistration(
		com.crowd.funding.database.model.ProjectPriorityRegistration projectPriorityRegistration) {
		return getService()
				   .deleteProjectPriorityRegistration(projectPriorityRegistration);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.crowd.funding.database.model.ProjectPriorityRegistration fetchProjectPriorityRegistration(
		long PROJECT_PRIORITY_ID) {
		return getService().fetchProjectPriorityRegistration(PROJECT_PRIORITY_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.ProjectPriorityRegistration> findByPRIORITY(
		int PRIORITY) {
		return getService().findByPRIORITY(PRIORITY);
	}

	public static com.crowd.funding.database.model.ProjectPriorityRegistration findByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getService().findByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);
	}

	public static com.crowd.funding.database.model.ProjectPriorityRegistration findByPROJECT_ID(
		long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return getService().findByPROJECT_ID(PROJECT_ID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
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
	* Returns the project priority registration with the primary key.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration
	* @throws PortalException if a project priority registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.ProjectPriorityRegistration getProjectPriorityRegistration(
		long PROJECT_PRIORITY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProjectPriorityRegistration(PROJECT_PRIORITY_ID);
	}

	/**
	* Returns a range of all the project priority registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project priority registrations
	* @param end the upper bound of the range of project priority registrations (not inclusive)
	* @return the range of project priority registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.ProjectPriorityRegistration> getProjectPriorityRegistrations(
		int start, int end) {
		return getService().getProjectPriorityRegistrations(start, end);
	}

	/**
	* Returns the number of project priority registrations.
	*
	* @return the number of project priority registrations
	*/
	public static int getProjectPriorityRegistrationsCount() {
		return getService().getProjectPriorityRegistrationsCount();
	}

	/**
	* Updates the project priority registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectPriorityRegistration the project priority registration
	* @return the project priority registration that was updated
	*/
	public static com.crowd.funding.database.model.ProjectPriorityRegistration updateProjectPriorityRegistration(
		com.crowd.funding.database.model.ProjectPriorityRegistration projectPriorityRegistration) {
		return getService()
				   .updateProjectPriorityRegistration(projectPriorityRegistration);
	}

	public static ProjectPriorityRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectPriorityRegistrationLocalService, ProjectPriorityRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectPriorityRegistrationLocalService.class);

		ServiceTracker<ProjectPriorityRegistrationLocalService, ProjectPriorityRegistrationLocalService> serviceTracker =
			new ServiceTracker<ProjectPriorityRegistrationLocalService, ProjectPriorityRegistrationLocalService>(bundle.getBundleContext(),
				ProjectPriorityRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}