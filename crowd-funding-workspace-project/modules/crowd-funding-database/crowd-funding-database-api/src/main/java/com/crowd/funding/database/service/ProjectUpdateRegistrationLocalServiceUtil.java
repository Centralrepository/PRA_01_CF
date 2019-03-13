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
 * Provides the local service utility for ProjectUpdateRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.ProjectUpdateRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUpdateRegistrationLocalService
 * @see com.crowd.funding.database.service.base.ProjectUpdateRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.ProjectUpdateRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class ProjectUpdateRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.ProjectUpdateRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the project update registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectUpdateRegistration the project update registration
	* @return the project update registration that was added
	*/
	public static com.crowd.funding.database.model.ProjectUpdateRegistration addProjectUpdateRegistration(
		com.crowd.funding.database.model.ProjectUpdateRegistration projectUpdateRegistration) {
		return getService()
				   .addProjectUpdateRegistration(projectUpdateRegistration);
	}

	/**
	* Creates a new project update registration with the primary key. Does not add the project update registration to the database.
	*
	* @param PROJECT_UPDATE_ID the primary key for the new project update registration
	* @return the new project update registration
	*/
	public static com.crowd.funding.database.model.ProjectUpdateRegistration createProjectUpdateRegistration(
		long PROJECT_UPDATE_ID) {
		return getService().createProjectUpdateRegistration(PROJECT_UPDATE_ID);
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
	* Deletes the project update registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration that was removed
	* @throws PortalException if a project update registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.ProjectUpdateRegistration deleteProjectUpdateRegistration(
		long PROJECT_UPDATE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteProjectUpdateRegistration(PROJECT_UPDATE_ID);
	}

	/**
	* Deletes the project update registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUpdateRegistration the project update registration
	* @return the project update registration that was removed
	*/
	public static com.crowd.funding.database.model.ProjectUpdateRegistration deleteProjectUpdateRegistration(
		com.crowd.funding.database.model.ProjectUpdateRegistration projectUpdateRegistration) {
		return getService()
				   .deleteProjectUpdateRegistration(projectUpdateRegistration);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.crowd.funding.database.model.ProjectUpdateRegistration fetchProjectUpdateRegistration(
		long PROJECT_UPDATE_ID) {
		return getService().fetchProjectUpdateRegistration(PROJECT_UPDATE_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getService().findByPROJECT_ID(PROJECT_ID);
	}

	public static com.crowd.funding.database.model.ProjectUpdateRegistration findByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return getService().findByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);
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
	* Returns the project update registration with the primary key.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration
	* @throws PortalException if a project update registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.ProjectUpdateRegistration getProjectUpdateRegistration(
		long PROJECT_UPDATE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProjectUpdateRegistration(PROJECT_UPDATE_ID);
	}

	/**
	* Returns a range of all the project update registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project update registrations
	* @param end the upper bound of the range of project update registrations (not inclusive)
	* @return the range of project update registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.ProjectUpdateRegistration> getProjectUpdateRegistrations(
		int start, int end) {
		return getService().getProjectUpdateRegistrations(start, end);
	}

	/**
	* Returns the number of project update registrations.
	*
	* @return the number of project update registrations
	*/
	public static int getProjectUpdateRegistrationsCount() {
		return getService().getProjectUpdateRegistrationsCount();
	}

	/**
	* Updates the project update registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectUpdateRegistration the project update registration
	* @return the project update registration that was updated
	*/
	public static com.crowd.funding.database.model.ProjectUpdateRegistration updateProjectUpdateRegistration(
		com.crowd.funding.database.model.ProjectUpdateRegistration projectUpdateRegistration) {
		return getService()
				   .updateProjectUpdateRegistration(projectUpdateRegistration);
	}

	public static ProjectUpdateRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectUpdateRegistrationLocalService, ProjectUpdateRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectUpdateRegistrationLocalService.class);

		ServiceTracker<ProjectUpdateRegistrationLocalService, ProjectUpdateRegistrationLocalService> serviceTracker =
			new ServiceTracker<ProjectUpdateRegistrationLocalService, ProjectUpdateRegistrationLocalService>(bundle.getBundleContext(),
				ProjectUpdateRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}