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
 * Provides a wrapper for {@link FundAccountRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FundAccountRegistrationLocalService
 * @generated
 */
@ProviderType
public class FundAccountRegistrationLocalServiceWrapper
	implements FundAccountRegistrationLocalService,
		ServiceWrapper<FundAccountRegistrationLocalService> {
	public FundAccountRegistrationLocalServiceWrapper(
		FundAccountRegistrationLocalService fundAccountRegistrationLocalService) {
		_fundAccountRegistrationLocalService = fundAccountRegistrationLocalService;
	}

	/**
	* Adds the fund account registration to the database. Also notifies the appropriate model listeners.
	*
	* @param fundAccountRegistration the fund account registration
	* @return the fund account registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.FundAccountRegistration addFundAccountRegistration(
		com.crowd.funding.database.model.FundAccountRegistration fundAccountRegistration) {
		return _fundAccountRegistrationLocalService.addFundAccountRegistration(fundAccountRegistration);
	}

	/**
	* Creates a new fund account registration with the primary key. Does not add the fund account registration to the database.
	*
	* @param ACCOUNT_ID the primary key for the new fund account registration
	* @return the new fund account registration
	*/
	@Override
	public com.crowd.funding.database.model.FundAccountRegistration createFundAccountRegistration(
		long ACCOUNT_ID) {
		return _fundAccountRegistrationLocalService.createFundAccountRegistration(ACCOUNT_ID);
	}

	/**
	* Deletes the fund account registration from the database. Also notifies the appropriate model listeners.
	*
	* @param fundAccountRegistration the fund account registration
	* @return the fund account registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.FundAccountRegistration deleteFundAccountRegistration(
		com.crowd.funding.database.model.FundAccountRegistration fundAccountRegistration) {
		return _fundAccountRegistrationLocalService.deleteFundAccountRegistration(fundAccountRegistration);
	}

	/**
	* Deletes the fund account registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ACCOUNT_ID the primary key of the fund account registration
	* @return the fund account registration that was removed
	* @throws PortalException if a fund account registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.FundAccountRegistration deleteFundAccountRegistration(
		long ACCOUNT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundAccountRegistrationLocalService.deleteFundAccountRegistration(ACCOUNT_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundAccountRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fundAccountRegistrationLocalService.dynamicQuery();
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
		return _fundAccountRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundAccountRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundAccountRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _fundAccountRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _fundAccountRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.FundAccountRegistration fetchFundAccountRegistration(
		long ACCOUNT_ID) {
		return _fundAccountRegistrationLocalService.fetchFundAccountRegistration(ACCOUNT_ID);
	}

	@Override
	public com.crowd.funding.database.model.FundAccountRegistration findByACCOUNT_ID(
		long ACCOUNT_ID)
		throws com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException {
		return _fundAccountRegistrationLocalService.findByACCOUNT_ID(ACCOUNT_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.FundAccountRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _fundAccountRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _fundAccountRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the fund account registration with the primary key.
	*
	* @param ACCOUNT_ID the primary key of the fund account registration
	* @return the fund account registration
	* @throws PortalException if a fund account registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.FundAccountRegistration getFundAccountRegistration(
		long ACCOUNT_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundAccountRegistrationLocalService.getFundAccountRegistration(ACCOUNT_ID);
	}

	/**
	* Returns a range of all the fund account registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund account registrations
	* @param end the upper bound of the range of fund account registrations (not inclusive)
	* @return the range of fund account registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.FundAccountRegistration> getFundAccountRegistrations(
		int start, int end) {
		return _fundAccountRegistrationLocalService.getFundAccountRegistrations(start,
			end);
	}

	/**
	* Returns the number of fund account registrations.
	*
	* @return the number of fund account registrations
	*/
	@Override
	public int getFundAccountRegistrationsCount() {
		return _fundAccountRegistrationLocalService.getFundAccountRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _fundAccountRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _fundAccountRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundAccountRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the fund account registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fundAccountRegistration the fund account registration
	* @return the fund account registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.FundAccountRegistration updateFundAccountRegistration(
		com.crowd.funding.database.model.FundAccountRegistration fundAccountRegistration) {
		return _fundAccountRegistrationLocalService.updateFundAccountRegistration(fundAccountRegistration);
	}

	@Override
	public FundAccountRegistrationLocalService getWrappedService() {
		return _fundAccountRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		FundAccountRegistrationLocalService fundAccountRegistrationLocalService) {
		_fundAccountRegistrationLocalService = fundAccountRegistrationLocalService;
	}

	private FundAccountRegistrationLocalService _fundAccountRegistrationLocalService;
}