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
 * Provides a wrapper for {@link BenificiaryRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BenificiaryRegistrationLocalService
 * @generated
 */
@ProviderType
public class BenificiaryRegistrationLocalServiceWrapper
	implements BenificiaryRegistrationLocalService,
		ServiceWrapper<BenificiaryRegistrationLocalService> {
	public BenificiaryRegistrationLocalServiceWrapper(
		BenificiaryRegistrationLocalService benificiaryRegistrationLocalService) {
		_benificiaryRegistrationLocalService = benificiaryRegistrationLocalService;
	}

	/**
	* Adds the benificiary registration to the database. Also notifies the appropriate model listeners.
	*
	* @param benificiaryRegistration the benificiary registration
	* @return the benificiary registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.BenificiaryRegistration addBenificiaryRegistration(
		com.crowd.funding.database.model.BenificiaryRegistration benificiaryRegistration) {
		return _benificiaryRegistrationLocalService.addBenificiaryRegistration(benificiaryRegistration);
	}

	/**
	* Creates a new benificiary registration with the primary key. Does not add the benificiary registration to the database.
	*
	* @param BENIFICIARY_ID the primary key for the new benificiary registration
	* @return the new benificiary registration
	*/
	@Override
	public com.crowd.funding.database.model.BenificiaryRegistration createBenificiaryRegistration(
		long BENIFICIARY_ID) {
		return _benificiaryRegistrationLocalService.createBenificiaryRegistration(BENIFICIARY_ID);
	}

	/**
	* Deletes the benificiary registration from the database. Also notifies the appropriate model listeners.
	*
	* @param benificiaryRegistration the benificiary registration
	* @return the benificiary registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.BenificiaryRegistration deleteBenificiaryRegistration(
		com.crowd.funding.database.model.BenificiaryRegistration benificiaryRegistration) {
		return _benificiaryRegistrationLocalService.deleteBenificiaryRegistration(benificiaryRegistration);
	}

	/**
	* Deletes the benificiary registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration that was removed
	* @throws PortalException if a benificiary registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.BenificiaryRegistration deleteBenificiaryRegistration(
		long BENIFICIARY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _benificiaryRegistrationLocalService.deleteBenificiaryRegistration(BENIFICIARY_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _benificiaryRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _benificiaryRegistrationLocalService.dynamicQuery();
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
		return _benificiaryRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _benificiaryRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _benificiaryRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _benificiaryRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _benificiaryRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.BenificiaryRegistration fetchBenificiaryRegistration(
		long BENIFICIARY_ID) {
		return _benificiaryRegistrationLocalService.fetchBenificiaryRegistration(BENIFICIARY_ID);
	}

	@Override
	public com.crowd.funding.database.model.BenificiaryRegistration findByBENIFICIARY_ID(
		long BENIFICIARY_ID)
		throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
		return _benificiaryRegistrationLocalService.findByBENIFICIARY_ID(BENIFICIARY_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _benificiaryRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the benificiary registration with the primary key.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration
	* @throws PortalException if a benificiary registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.BenificiaryRegistration getBenificiaryRegistration(
		long BENIFICIARY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _benificiaryRegistrationLocalService.getBenificiaryRegistration(BENIFICIARY_ID);
	}

	/**
	* Returns a range of all the benificiary registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @return the range of benificiary registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.BenificiaryRegistration> getBenificiaryRegistrations(
		int start, int end) {
		return _benificiaryRegistrationLocalService.getBenificiaryRegistrations(start,
			end);
	}

	/**
	* Returns the number of benificiary registrations.
	*
	* @return the number of benificiary registrations
	*/
	@Override
	public int getBenificiaryRegistrationsCount() {
		return _benificiaryRegistrationLocalService.getBenificiaryRegistrationsCount();
	}

	@Override
	public com.crowd.funding.database.model.BenificiaryRegistrationIMAGEBlobModel getIMAGEBlobModel(
		java.io.Serializable primaryKey) {
		return _benificiaryRegistrationLocalService.getIMAGEBlobModel(primaryKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _benificiaryRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _benificiaryRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _benificiaryRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the benificiary registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param benificiaryRegistration the benificiary registration
	* @return the benificiary registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.BenificiaryRegistration updateBenificiaryRegistration(
		com.crowd.funding.database.model.BenificiaryRegistration benificiaryRegistration) {
		return _benificiaryRegistrationLocalService.updateBenificiaryRegistration(benificiaryRegistration);
	}

	@Override
	public BenificiaryRegistrationLocalService getWrappedService() {
		return _benificiaryRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		BenificiaryRegistrationLocalService benificiaryRegistrationLocalService) {
		_benificiaryRegistrationLocalService = benificiaryRegistrationLocalService;
	}

	private BenificiaryRegistrationLocalService _benificiaryRegistrationLocalService;
}