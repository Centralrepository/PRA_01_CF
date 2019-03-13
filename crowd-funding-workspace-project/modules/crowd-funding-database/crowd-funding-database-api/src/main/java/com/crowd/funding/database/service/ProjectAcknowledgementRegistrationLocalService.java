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

import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistrationDOCUMENTBlobModel;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistrationVIDEOBlobModel;

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
 * Provides the local service interface for ProjectAcknowledgementRegistration. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectAcknowledgementRegistrationLocalServiceUtil
 * @see com.crowd.funding.database.service.base.ProjectAcknowledgementRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.ProjectAcknowledgementRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ProjectAcknowledgementRegistrationLocalService
	extends BaseLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectAcknowledgementRegistrationLocalServiceUtil} to access the project acknowledgement registration local service. Add custom service methods to {@link com.crowd.funding.database.service.impl.ProjectAcknowledgementRegistrationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the project acknowledgement registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectAcknowledgementRegistration the project acknowledgement registration
	* @return the project acknowledgement registration that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ProjectAcknowledgementRegistration addProjectAcknowledgementRegistration(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration);

	/**
	* Creates a new project acknowledgement registration with the primary key. Does not add the project acknowledgement registration to the database.
	*
	* @param ACKNOWLEDGMENT_ID the primary key for the new project acknowledgement registration
	* @return the new project acknowledgement registration
	*/
	@Transactional(enabled = false)
	public ProjectAcknowledgementRegistration createProjectAcknowledgementRegistration(
		long ACKNOWLEDGMENT_ID);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the project acknowledgement registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration that was removed
	* @throws PortalException if a project acknowledgement registration with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public ProjectAcknowledgementRegistration deleteProjectAcknowledgementRegistration(
		long ACKNOWLEDGMENT_ID) throws PortalException;

	/**
	* Deletes the project acknowledgement registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectAcknowledgementRegistration the project acknowledgement registration
	* @return the project acknowledgement registration that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public ProjectAcknowledgementRegistration deleteProjectAcknowledgementRegistration(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public ProjectAcknowledgementRegistration fetchProjectAcknowledgementRegistration(
		long ACKNOWLEDGMENT_ID);

	public ProjectAcknowledgementRegistration findByPROJECT_ID(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectAcknowledgementRegistrationDOCUMENTBlobModel getDOCUMENTBlobModel(
		Serializable primaryKey);

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
	* Returns the project acknowledgement registration with the primary key.
	*
	* @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	* @return the project acknowledgement registration
	* @throws PortalException if a project acknowledgement registration with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectAcknowledgementRegistration getProjectAcknowledgementRegistration(
		long ACKNOWLEDGMENT_ID) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ProjectAcknowledgementRegistration> getProjectAcknowledgementRegistrations(
		int start, int end);

	/**
	* Returns the number of project acknowledgement registrations.
	*
	* @return the number of project acknowledgement registrations
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProjectAcknowledgementRegistrationsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ProjectAcknowledgementRegistrationVIDEOBlobModel getVIDEOBlobModel(
		Serializable primaryKey);

	/**
	* Updates the project acknowledgement registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectAcknowledgementRegistration the project acknowledgement registration
	* @return the project acknowledgement registration that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ProjectAcknowledgementRegistration updateProjectAcknowledgementRegistration(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration);
}