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
 * Provides a wrapper for {@link DonorRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DonorRegistrationLocalService
 * @generated
 */
@ProviderType
public class DonorRegistrationLocalServiceWrapper
	implements DonorRegistrationLocalService,
		ServiceWrapper<DonorRegistrationLocalService> {
	public DonorRegistrationLocalServiceWrapper(
		DonorRegistrationLocalService donorRegistrationLocalService) {
		_donorRegistrationLocalService = donorRegistrationLocalService;
	}

	/**
	* Adds the donor registration to the database. Also notifies the appropriate model listeners.
	*
	* @param donorRegistration the donor registration
	* @return the donor registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.DonorRegistration addDonorRegistration(
		com.crowd.funding.database.model.DonorRegistration donorRegistration) {
		return _donorRegistrationLocalService.addDonorRegistration(donorRegistration);
	}

	/**
	* Creates a new donor registration with the primary key. Does not add the donor registration to the database.
	*
	* @param DONOR_ID the primary key for the new donor registration
	* @return the new donor registration
	*/
	@Override
	public com.crowd.funding.database.model.DonorRegistration createDonorRegistration(
		long DONOR_ID) {
		return _donorRegistrationLocalService.createDonorRegistration(DONOR_ID);
	}

	/**
	* Deletes the donor registration from the database. Also notifies the appropriate model listeners.
	*
	* @param donorRegistration the donor registration
	* @return the donor registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.DonorRegistration deleteDonorRegistration(
		com.crowd.funding.database.model.DonorRegistration donorRegistration) {
		return _donorRegistrationLocalService.deleteDonorRegistration(donorRegistration);
	}

	/**
	* Deletes the donor registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param DONOR_ID the primary key of the donor registration
	* @return the donor registration that was removed
	* @throws PortalException if a donor registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.DonorRegistration deleteDonorRegistration(
		long DONOR_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _donorRegistrationLocalService.deleteDonorRegistration(DONOR_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _donorRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _donorRegistrationLocalService.dynamicQuery();
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
		return _donorRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _donorRegistrationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _donorRegistrationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _donorRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _donorRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.DonorRegistration fetchDonorRegistration(
		long DONOR_ID) {
		return _donorRegistrationLocalService.fetchDonorRegistration(DONOR_ID);
	}

	@Override
	public com.crowd.funding.database.model.DonorRegistration findByDONOR_ID(
		long DONOR_ID)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return _donorRegistrationLocalService.findByDONOR_ID(DONOR_ID);
	}

	@Override
	public com.crowd.funding.database.model.DonorRegistration findByMOBILE_NO(
		long MOBILE_NO)
		throws com.crowd.funding.database.exception.NoSuchDonorRegistrationException {
		return _donorRegistrationLocalService.findByMOBILE_NO(MOBILE_NO);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _donorRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the donor registration with the primary key.
	*
	* @param DONOR_ID the primary key of the donor registration
	* @return the donor registration
	* @throws PortalException if a donor registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.DonorRegistration getDonorRegistration(
		long DONOR_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _donorRegistrationLocalService.getDonorRegistration(DONOR_ID);
	}

	/**
	* Returns a range of all the donor registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of donor registrations
	* @param end the upper bound of the range of donor registrations (not inclusive)
	* @return the range of donor registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.DonorRegistration> getDonorRegistrations(
		int start, int end) {
		return _donorRegistrationLocalService.getDonorRegistrations(start, end);
	}

	/**
	* Returns the number of donor registrations.
	*
	* @return the number of donor registrations
	*/
	@Override
	public int getDonorRegistrationsCount() {
		return _donorRegistrationLocalService.getDonorRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _donorRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _donorRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _donorRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the donor registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param donorRegistration the donor registration
	* @return the donor registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.DonorRegistration updateDonorRegistration(
		com.crowd.funding.database.model.DonorRegistration donorRegistration) {
		return _donorRegistrationLocalService.updateDonorRegistration(donorRegistration);
	}

	@Override
	public DonorRegistrationLocalService getWrappedService() {
		return _donorRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		DonorRegistrationLocalService donorRegistrationLocalService) {
		_donorRegistrationLocalService = donorRegistrationLocalService;
	}

	private DonorRegistrationLocalService _donorRegistrationLocalService;
}