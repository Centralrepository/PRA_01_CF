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
 * Provides a wrapper for {@link ProjectRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectRegistrationLocalService
 * @generated
 */
@ProviderType
public class ProjectRegistrationLocalServiceWrapper
	implements ProjectRegistrationLocalService,
		ServiceWrapper<ProjectRegistrationLocalService> {
	public ProjectRegistrationLocalServiceWrapper(
		ProjectRegistrationLocalService projectRegistrationLocalService) {
		_projectRegistrationLocalService = projectRegistrationLocalService;
	}

	/**
	* Adds the project registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectRegistration the project registration
	* @return the project registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.ProjectRegistration addProjectRegistration(
		com.crowd.funding.database.model.ProjectRegistration projectRegistration) {
		return _projectRegistrationLocalService.addProjectRegistration(projectRegistration);
	}

	/**
	* Creates a new project registration with the primary key. Does not add the project registration to the database.
	*
	* @param PROJECT_ID the primary key for the new project registration
	* @return the new project registration
	*/
	@Override
	public com.crowd.funding.database.model.ProjectRegistration createProjectRegistration(
		long PROJECT_ID) {
		return _projectRegistrationLocalService.createProjectRegistration(PROJECT_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the project registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration that was removed
	* @throws PortalException if a project registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectRegistration deleteProjectRegistration(
		long PROJECT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectRegistrationLocalService.deleteProjectRegistration(PROJECT_ID);
	}

	/**
	* Deletes the project registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectRegistration the project registration
	* @return the project registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.ProjectRegistration deleteProjectRegistration(
		com.crowd.funding.database.model.ProjectRegistration projectRegistration) {
		return _projectRegistrationLocalService.deleteProjectRegistration(projectRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectRegistrationLocalService.dynamicQuery();
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
		return _projectRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _projectRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.ProjectRegistration fetchProjectRegistration(
		long PROJECT_ID) {
		return _projectRegistrationLocalService.fetchProjectRegistration(PROJECT_ID);
	}

	@Override
	public com.crowd.funding.database.model.ProjectRegistration findByPROJECT_ID(
		long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return _projectRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectRegistration> findBySTATUS(
		int STATUS) {
		return _projectRegistrationLocalService.findBySTATUS(STATUS);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectRegistration> findByUSER_ID(
		long USER_ID) {
		return _projectRegistrationLocalService.findByUSER_ID(USER_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the project registration with the primary key.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration
	* @throws PortalException if a project registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectRegistration getProjectRegistration(
		long PROJECT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectRegistrationLocalService.getProjectRegistration(PROJECT_ID);
	}

	/**
	* Returns a range of all the project registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of project registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectRegistration> getProjectRegistrations(
		int start, int end) {
		return _projectRegistrationLocalService.getProjectRegistrations(start,
			end);
	}

	/**
	* Returns the number of project registrations.
	*
	* @return the number of project registrations
	*/
	@Override
	public int getProjectRegistrationsCount() {
		return _projectRegistrationLocalService.getProjectRegistrationsCount();
	}

	/**
	* Updates the project registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectRegistration the project registration
	* @return the project registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.ProjectRegistration updateProjectRegistration(
		com.crowd.funding.database.model.ProjectRegistration projectRegistration) {
		return _projectRegistrationLocalService.updateProjectRegistration(projectRegistration);
	}

	@Override
	public ProjectRegistrationLocalService getWrappedService() {
		return _projectRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectRegistrationLocalService projectRegistrationLocalService) {
		_projectRegistrationLocalService = projectRegistrationLocalService;
	}

	private ProjectRegistrationLocalService _projectRegistrationLocalService;
}