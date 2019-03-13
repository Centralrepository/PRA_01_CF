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
 * Provides a wrapper for {@link FundRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FundRegistrationLocalService
 * @generated
 */
@ProviderType
public class FundRegistrationLocalServiceWrapper
	implements FundRegistrationLocalService,
		ServiceWrapper<FundRegistrationLocalService> {
	public FundRegistrationLocalServiceWrapper(
		FundRegistrationLocalService fundRegistrationLocalService) {
		_fundRegistrationLocalService = fundRegistrationLocalService;
	}

	/**
	* Adds the fund registration to the database. Also notifies the appropriate model listeners.
	*
	* @param fundRegistration the fund registration
	* @return the fund registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.FundRegistration addFundRegistration(
		com.crowd.funding.database.model.FundRegistration fundRegistration) {
		return _fundRegistrationLocalService.addFundRegistration(fundRegistration);
	}

	/**
	* Creates a new fund registration with the primary key. Does not add the fund registration to the database.
	*
	* @param PROJECT_FUND_ID the primary key for the new fund registration
	* @return the new fund registration
	*/
	@Override
	public com.crowd.funding.database.model.FundRegistration createFundRegistration(
		long PROJECT_FUND_ID) {
		return _fundRegistrationLocalService.createFundRegistration(PROJECT_FUND_ID);
	}

	/**
	* Deletes the fund registration from the database. Also notifies the appropriate model listeners.
	*
	* @param fundRegistration the fund registration
	* @return the fund registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.FundRegistration deleteFundRegistration(
		com.crowd.funding.database.model.FundRegistration fundRegistration) {
		return _fundRegistrationLocalService.deleteFundRegistration(fundRegistration);
	}

	/**
	* Deletes the fund registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FUND_ID the primary key of the fund registration
	* @return the fund registration that was removed
	* @throws PortalException if a fund registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.FundRegistration deleteFundRegistration(
		long PROJECT_FUND_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundRegistrationLocalService.deleteFundRegistration(PROJECT_FUND_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fundRegistrationLocalService.dynamicQuery();
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
		return _fundRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundRegistrationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundRegistrationLocalService.dynamicQuery(dynamicQuery, start,
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
		return _fundRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _fundRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.FundRegistration fetchFundRegistration(
		long PROJECT_FUND_ID) {
		return _fundRegistrationLocalService.fetchFundRegistration(PROJECT_FUND_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.FundRegistration> findByDONOR_USER_ID(
		long DONOR_USER_ID) {
		return _fundRegistrationLocalService.findByDONOR_USER_ID(DONOR_USER_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.FundRegistration> findByPROJECT_DONOR_USER_ID(
		long PROJECT_ID, long DONOR_USER_ID) {
		return _fundRegistrationLocalService.findByPROJECT_DONOR_USER_ID(PROJECT_ID,
			DONOR_USER_ID);
	}

	@Override
	public com.crowd.funding.database.model.FundRegistration findByPROJECT_FUND_ID(
		long PROJECT_FUND_ID)
		throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
		return _fundRegistrationLocalService.findByPROJECT_FUND_ID(PROJECT_FUND_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.FundRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _fundRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _fundRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the fund registration with the primary key.
	*
	* @param PROJECT_FUND_ID the primary key of the fund registration
	* @return the fund registration
	* @throws PortalException if a fund registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.FundRegistration getFundRegistration(
		long PROJECT_FUND_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundRegistrationLocalService.getFundRegistration(PROJECT_FUND_ID);
	}

	/**
	* Returns a range of all the fund registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund registrations
	* @param end the upper bound of the range of fund registrations (not inclusive)
	* @return the range of fund registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.FundRegistration> getFundRegistrations(
		int start, int end) {
		return _fundRegistrationLocalService.getFundRegistrations(start, end);
	}

	/**
	* Returns the number of fund registrations.
	*
	* @return the number of fund registrations
	*/
	@Override
	public int getFundRegistrationsCount() {
		return _fundRegistrationLocalService.getFundRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _fundRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _fundRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the fund registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fundRegistration the fund registration
	* @return the fund registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.FundRegistration updateFundRegistration(
		com.crowd.funding.database.model.FundRegistration fundRegistration) {
		return _fundRegistrationLocalService.updateFundRegistration(fundRegistration);
	}

	@Override
	public FundRegistrationLocalService getWrappedService() {
		return _fundRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		FundRegistrationLocalService fundRegistrationLocalService) {
		_fundRegistrationLocalService = fundRegistrationLocalService;
	}

	private FundRegistrationLocalService _fundRegistrationLocalService;
}