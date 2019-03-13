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

import com.crowd.funding.database.model.ProjectFollowerRegistration;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for ProjectFollowerRegistration. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFollowerRegistrationLocalServiceUtil
 * @see com.crowd.funding.database.service.base.ProjectFollowerRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.ProjectFollowerRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProjectFollowerRegistrationLocalService
	extends BaseLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectFollowerRegistrationLocalServiceUtil} to access the project follower registration local service. Add custom service methods to {@link com.crowd.funding.database.service.impl.ProjectFollowerRegistrationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the project follower registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectFollowerRegistration the project follower registration
	* @return the project follower registration that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ProjectFollowerRegistration addProjectFollowerRegistration(
		ProjectFollowerRegistration projectFollowerRegistration);

	/**
	* Creates a new project follower registration with the primary key. Does not add the project follower registration to the database.
	*
	* @param PROJECT_FOLLOWER_ID the primary key for the new project follower registration
	* @return the new project follower registration
	*/
	@Transactional(enabled = false)
	public ProjectFollowerRegistration createProjectFollowerRegistration(
		long PROJECT_FOLLOWER_ID);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the project follower registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	* @return the project follower registration that was removed
	* @throws PortalException if a project follower registration with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public ProjectFollowerRegistration deleteProjectFollowerRegistration(
		long PROJECT_FOLLOWER_ID) throws PortalException;

	/**
	* Deletes the project follower registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectFollowerRegistration the project follower registration
	* @return the project follower registration that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public ProjectFollowerRegistration deleteProjectFollowerRegistration(
		ProjectFollowerRegistration projectFollowerRegistration);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectFollowerRegistration fetchProjectFollowerRegistration(
		long PROJECT_FOLLOWER_ID);

	public ProjectFollowerRegistration findByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException;

	public List<ProjectFollowerRegistration> findByPROJECT_ID(long PROJECT_ID);

	public ProjectFollowerRegistration findByPROJECT_USER_ID(long PROJECT_ID,
		long USER_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException;

	public List<ProjectFollowerRegistration> findByUSER_ID(long USER_ID);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the project follower registration with the primary key.
	*
	* @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	* @return the project follower registration
	* @throws PortalException if a project follower registration with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectFollowerRegistration getProjectFollowerRegistration(
		long PROJECT_FOLLOWER_ID) throws PortalException;

	/**
	* Returns a range of all the project follower registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project follower registrations
	* @param end the upper bound of the range of project follower registrations (not inclusive)
	* @return the range of project follower registrations
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProjectFollowerRegistration> getProjectFollowerRegistrations(
		int start, int end);

	/**
	* Returns the number of project follower registrations.
	*
	* @return the number of project follower registrations
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProjectFollowerRegistrationsCount();

	/**
	* Updates the project follower registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectFollowerRegistration the project follower registration
	* @return the project follower registration that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ProjectFollowerRegistration updateProjectFollowerRegistration(
		ProjectFollowerRegistration projectFollowerRegistration);
}