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
 * Provides a wrapper for {@link ProjectPriorityRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPriorityRegistrationLocalService
 * @generated
 */
@ProviderType
public class ProjectPriorityRegistrationLocalServiceWrapper
	implements ProjectPriorityRegistrationLocalService,
		ServiceWrapper<ProjectPriorityRegistrationLocalService> {
	public ProjectPriorityRegistrationLocalServiceWrapper(
		ProjectPriorityRegistrationLocalService projectPriorityRegistrationLocalService) {
		_projectPriorityRegistrationLocalService = projectPriorityRegistrationLocalService;
	}

	/**
	* Adds the project priority registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectPriorityRegistration the project priority registration
	* @return the project priority registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.ProjectPriorityRegistration addProjectPriorityRegistration(
		com.crowd.funding.database.model.ProjectPriorityRegistration projectPriorityRegistration) {
		return _projectPriorityRegistrationLocalService.addProjectPriorityRegistration(projectPriorityRegistration);
	}

	/**
	* Creates a new project priority registration with the primary key. Does not add the project priority registration to the database.
	*
	* @param PROJECT_PRIORITY_ID the primary key for the new project priority registration
	* @return the new project priority registration
	*/
	@Override
	public com.crowd.funding.database.model.ProjectPriorityRegistration createProjectPriorityRegistration(
		long PROJECT_PRIORITY_ID) {
		return _projectPriorityRegistrationLocalService.createProjectPriorityRegistration(PROJECT_PRIORITY_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectPriorityRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the project priority registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration that was removed
	* @throws PortalException if a project priority registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectPriorityRegistration deleteProjectPriorityRegistration(
		long PROJECT_PRIORITY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectPriorityRegistrationLocalService.deleteProjectPriorityRegistration(PROJECT_PRIORITY_ID);
	}

	/**
	* Deletes the project priority registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectPriorityRegistration the project priority registration
	* @return the project priority registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.ProjectPriorityRegistration deleteProjectPriorityRegistration(
		com.crowd.funding.database.model.ProjectPriorityRegistration projectPriorityRegistration) {
		return _projectPriorityRegistrationLocalService.deleteProjectPriorityRegistration(projectPriorityRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectPriorityRegistrationLocalService.dynamicQuery();
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
		return _projectPriorityRegistrationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _projectPriorityRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _projectPriorityRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _projectPriorityRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectPriorityRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.ProjectPriorityRegistration fetchProjectPriorityRegistration(
		long PROJECT_PRIORITY_ID) {
		return _projectPriorityRegistrationLocalService.fetchProjectPriorityRegistration(PROJECT_PRIORITY_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectPriorityRegistration> findByPRIORITY(
		int PRIORITY) {
		return _projectPriorityRegistrationLocalService.findByPRIORITY(PRIORITY);
	}

	@Override
	public com.crowd.funding.database.model.ProjectPriorityRegistration findByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return _projectPriorityRegistrationLocalService.findByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);
	}

	@Override
	public com.crowd.funding.database.model.ProjectPriorityRegistration findByPROJECT_ID(
		long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
		return _projectPriorityRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectPriorityRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectPriorityRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectPriorityRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectPriorityRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the project priority registration with the primary key.
	*
	* @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	* @return the project priority registration
	* @throws PortalException if a project priority registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectPriorityRegistration getProjectPriorityRegistration(
		long PROJECT_PRIORITY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectPriorityRegistrationLocalService.getProjectPriorityRegistration(PROJECT_PRIORITY_ID);
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
	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectPriorityRegistration> getProjectPriorityRegistrations(
		int start, int end) {
		return _projectPriorityRegistrationLocalService.getProjectPriorityRegistrations(start,
			end);
	}

	/**
	* Returns the number of project priority registrations.
	*
	* @return the number of project priority registrations
	*/
	@Override
	public int getProjectPriorityRegistrationsCount() {
		return _projectPriorityRegistrationLocalService.getProjectPriorityRegistrationsCount();
	}

	/**
	* Updates the project priority registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectPriorityRegistration the project priority registration
	* @return the project priority registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.ProjectPriorityRegistration updateProjectPriorityRegistration(
		com.crowd.funding.database.model.ProjectPriorityRegistration projectPriorityRegistration) {
		return _projectPriorityRegistrationLocalService.updateProjectPriorityRegistration(projectPriorityRegistration);
	}

	@Override
	public ProjectPriorityRegistrationLocalService getWrappedService() {
		return _projectPriorityRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectPriorityRegistrationLocalService projectPriorityRegistrationLocalService) {
		_projectPriorityRegistrationLocalService = projectPriorityRegistrationLocalService;
	}

	private ProjectPriorityRegistrationLocalService _projectPriorityRegistrationLocalService;
}