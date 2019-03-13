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
 * Provides a wrapper for {@link DocumentRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentRegistrationLocalService
 * @generated
 */
@ProviderType
public class DocumentRegistrationLocalServiceWrapper
	implements DocumentRegistrationLocalService,
		ServiceWrapper<DocumentRegistrationLocalService> {
	public DocumentRegistrationLocalServiceWrapper(
		DocumentRegistrationLocalService documentRegistrationLocalService) {
		_documentRegistrationLocalService = documentRegistrationLocalService;
	}

	/**
	* Adds the document registration to the database. Also notifies the appropriate model listeners.
	*
	* @param documentRegistration the document registration
	* @return the document registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.DocumentRegistration addDocumentRegistration(
		com.crowd.funding.database.model.DocumentRegistration documentRegistration) {
		return _documentRegistrationLocalService.addDocumentRegistration(documentRegistration);
	}

	/**
	* Creates a new document registration with the primary key. Does not add the document registration to the database.
	*
	* @param PROJECT_DOCUMENT_ID the primary key for the new document registration
	* @return the new document registration
	*/
	@Override
	public com.crowd.funding.database.model.DocumentRegistration createDocumentRegistration(
		long PROJECT_DOCUMENT_ID) {
		return _documentRegistrationLocalService.createDocumentRegistration(PROJECT_DOCUMENT_ID);
	}

	/**
	* Deletes the document registration from the database. Also notifies the appropriate model listeners.
	*
	* @param documentRegistration the document registration
	* @return the document registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.DocumentRegistration deleteDocumentRegistration(
		com.crowd.funding.database.model.DocumentRegistration documentRegistration) {
		return _documentRegistrationLocalService.deleteDocumentRegistration(documentRegistration);
	}

	/**
	* Deletes the document registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the document registration
	* @return the document registration that was removed
	* @throws PortalException if a document registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.DocumentRegistration deleteDocumentRegistration(
		long PROJECT_DOCUMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _documentRegistrationLocalService.deleteDocumentRegistration(PROJECT_DOCUMENT_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _documentRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _documentRegistrationLocalService.dynamicQuery();
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
		return _documentRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _documentRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _documentRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _documentRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _documentRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.DocumentRegistration fetchDocumentRegistration(
		long PROJECT_DOCUMENT_ID) {
		return _documentRegistrationLocalService.fetchDocumentRegistration(PROJECT_DOCUMENT_ID);
	}

	@Override
	public com.crowd.funding.database.model.DocumentRegistration findByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return _documentRegistrationLocalService.findByPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.DocumentRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _documentRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _documentRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.crowd.funding.database.model.DocumentRegistrationDOCUMENTBlobModel getDOCUMENTBlobModel(
		java.io.Serializable primaryKey) {
		return _documentRegistrationLocalService.getDOCUMENTBlobModel(primaryKey);
	}

	/**
	* Returns the document registration with the primary key.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the document registration
	* @return the document registration
	* @throws PortalException if a document registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.DocumentRegistration getDocumentRegistration(
		long PROJECT_DOCUMENT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _documentRegistrationLocalService.getDocumentRegistration(PROJECT_DOCUMENT_ID);
	}

	/**
	* Returns a range of all the document registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @return the range of document registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.DocumentRegistration> getDocumentRegistrations(
		int start, int end) {
		return _documentRegistrationLocalService.getDocumentRegistrations(start,
			end);
	}

	/**
	* Returns the number of document registrations.
	*
	* @return the number of document registrations
	*/
	@Override
	public int getDocumentRegistrationsCount() {
		return _documentRegistrationLocalService.getDocumentRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _documentRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _documentRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _documentRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the document registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param documentRegistration the document registration
	* @return the document registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.DocumentRegistration updateDocumentRegistration(
		com.crowd.funding.database.model.DocumentRegistration documentRegistration) {
		return _documentRegistrationLocalService.updateDocumentRegistration(documentRegistration);
	}

	@Override
	public DocumentRegistrationLocalService getWrappedService() {
		return _documentRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		DocumentRegistrationLocalService documentRegistrationLocalService) {
		_documentRegistrationLocalService = documentRegistrationLocalService;
	}

	private DocumentRegistrationLocalService _documentRegistrationLocalService;
}