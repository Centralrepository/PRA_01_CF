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
 * Provides a wrapper for {@link ProjectUpdateRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUpdateRegistrationLocalService
 * @generated
 */
@ProviderType
public class ProjectUpdateRegistrationLocalServiceWrapper
	implements ProjectUpdateRegistrationLocalService,
		ServiceWrapper<ProjectUpdateRegistrationLocalService> {
	public ProjectUpdateRegistrationLocalServiceWrapper(
		ProjectUpdateRegistrationLocalService projectUpdateRegistrationLocalService) {
		_projectUpdateRegistrationLocalService = projectUpdateRegistrationLocalService;
	}

	/**
	* Adds the project update registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectUpdateRegistration the project update registration
	* @return the project update registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.ProjectUpdateRegistration addProjectUpdateRegistration(
		com.crowd.funding.database.model.ProjectUpdateRegistration projectUpdateRegistration) {
		return _projectUpdateRegistrationLocalService.addProjectUpdateRegistration(projectUpdateRegistration);
	}

	/**
	* Creates a new project update registration with the primary key. Does not add the project update registration to the database.
	*
	* @param PROJECT_UPDATE_ID the primary key for the new project update registration
	* @return the new project update registration
	*/
	@Override
	public com.crowd.funding.database.model.ProjectUpdateRegistration createProjectUpdateRegistration(
		long PROJECT_UPDATE_ID) {
		return _projectUpdateRegistrationLocalService.createProjectUpdateRegistration(PROJECT_UPDATE_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectUpdateRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the project update registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration that was removed
	* @throws PortalException if a project update registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectUpdateRegistration deleteProjectUpdateRegistration(
		long PROJECT_UPDATE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectUpdateRegistrationLocalService.deleteProjectUpdateRegistration(PROJECT_UPDATE_ID);
	}

	/**
	* Deletes the project update registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectUpdateRegistration the project update registration
	* @return the project update registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.ProjectUpdateRegistration deleteProjectUpdateRegistration(
		com.crowd.funding.database.model.ProjectUpdateRegistration projectUpdateRegistration) {
		return _projectUpdateRegistrationLocalService.deleteProjectUpdateRegistration(projectUpdateRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectUpdateRegistrationLocalService.dynamicQuery();
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
		return _projectUpdateRegistrationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _projectUpdateRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _projectUpdateRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _projectUpdateRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectUpdateRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.ProjectUpdateRegistration fetchProjectUpdateRegistration(
		long PROJECT_UPDATE_ID) {
		return _projectUpdateRegistrationLocalService.fetchProjectUpdateRegistration(PROJECT_UPDATE_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectUpdateRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _projectUpdateRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.crowd.funding.database.model.ProjectUpdateRegistration findByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException {
		return _projectUpdateRegistrationLocalService.findByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectUpdateRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectUpdateRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectUpdateRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectUpdateRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the project update registration with the primary key.
	*
	* @param PROJECT_UPDATE_ID the primary key of the project update registration
	* @return the project update registration
	* @throws PortalException if a project update registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectUpdateRegistration getProjectUpdateRegistration(
		long PROJECT_UPDATE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectUpdateRegistrationLocalService.getProjectUpdateRegistration(PROJECT_UPDATE_ID);
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
	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectUpdateRegistration> getProjectUpdateRegistrations(
		int start, int end) {
		return _projectUpdateRegistrationLocalService.getProjectUpdateRegistrations(start,
			end);
	}

	/**
	* Returns the number of project update registrations.
	*
	* @return the number of project update registrations
	*/
	@Override
	public int getProjectUpdateRegistrationsCount() {
		return _projectUpdateRegistrationLocalService.getProjectUpdateRegistrationsCount();
	}

	/**
	* Updates the project update registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectUpdateRegistration the project update registration
	* @return the project update registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.ProjectUpdateRegistration updateProjectUpdateRegistration(
		com.crowd.funding.database.model.ProjectUpdateRegistration projectUpdateRegistration) {
		return _projectUpdateRegistrationLocalService.updateProjectUpdateRegistration(projectUpdateRegistration);
	}

	@Override
	public ProjectUpdateRegistrationLocalService getWrappedService() {
		return _projectUpdateRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectUpdateRegistrationLocalService projectUpdateRegistrationLocalService) {
		_projectUpdateRegistrationLocalService = projectUpdateRegistrationLocalService;
	}

	private ProjectUpdateRegistrationLocalService _projectUpdateRegistrationLocalService;
}