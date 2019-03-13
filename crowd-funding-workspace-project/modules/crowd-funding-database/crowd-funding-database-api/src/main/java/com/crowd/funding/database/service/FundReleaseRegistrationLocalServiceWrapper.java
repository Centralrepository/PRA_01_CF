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
 * Provides a wrapper for {@link FundReleaseRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FundReleaseRegistrationLocalService
 * @generated
 */
@ProviderType
public class FundReleaseRegistrationLocalServiceWrapper
	implements FundReleaseRegistrationLocalService,
		ServiceWrapper<FundReleaseRegistrationLocalService> {
	public FundReleaseRegistrationLocalServiceWrapper(
		FundReleaseRegistrationLocalService fundReleaseRegistrationLocalService) {
		_fundReleaseRegistrationLocalService = fundReleaseRegistrationLocalService;
	}

	/**
	* Adds the fund release registration to the database. Also notifies the appropriate model listeners.
	*
	* @param fundReleaseRegistration the fund release registration
	* @return the fund release registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.FundReleaseRegistration addFundReleaseRegistration(
		com.crowd.funding.database.model.FundReleaseRegistration fundReleaseRegistration) {
		return _fundReleaseRegistrationLocalService.addFundReleaseRegistration(fundReleaseRegistration);
	}

	/**
	* Creates a new fund release registration with the primary key. Does not add the fund release registration to the database.
	*
	* @param FUND_RELEASE_ID the primary key for the new fund release registration
	* @return the new fund release registration
	*/
	@Override
	public com.crowd.funding.database.model.FundReleaseRegistration createFundReleaseRegistration(
		long FUND_RELEASE_ID) {
		return _fundReleaseRegistrationLocalService.createFundReleaseRegistration(FUND_RELEASE_ID);
	}

	/**
	* Deletes the fund release registration from the database. Also notifies the appropriate model listeners.
	*
	* @param fundReleaseRegistration the fund release registration
	* @return the fund release registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.FundReleaseRegistration deleteFundReleaseRegistration(
		com.crowd.funding.database.model.FundReleaseRegistration fundReleaseRegistration) {
		return _fundReleaseRegistrationLocalService.deleteFundReleaseRegistration(fundReleaseRegistration);
	}

	/**
	* Deletes the fund release registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration that was removed
	* @throws PortalException if a fund release registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.FundReleaseRegistration deleteFundReleaseRegistration(
		long FUND_RELEASE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundReleaseRegistrationLocalService.deleteFundReleaseRegistration(FUND_RELEASE_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundReleaseRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fundReleaseRegistrationLocalService.dynamicQuery();
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
		return _fundReleaseRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundReleaseRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fundReleaseRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _fundReleaseRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _fundReleaseRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.FundReleaseRegistration fetchFundReleaseRegistration(
		long FUND_RELEASE_ID) {
		return _fundReleaseRegistrationLocalService.fetchFundReleaseRegistration(FUND_RELEASE_ID);
	}

	@Override
	public com.crowd.funding.database.model.FundReleaseRegistration findByFUND_RELEASE_ID(
		long FUND_RELEASE_ID)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return _fundReleaseRegistrationLocalService.findByFUND_RELEASE_ID(FUND_RELEASE_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _fundReleaseRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _fundReleaseRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the fund release registration with the primary key.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration
	* @throws PortalException if a fund release registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.FundReleaseRegistration getFundReleaseRegistration(
		long FUND_RELEASE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundReleaseRegistrationLocalService.getFundReleaseRegistration(FUND_RELEASE_ID);
	}

	/**
	* Returns a range of all the fund release registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of fund release registrations
	* @param end the upper bound of the range of fund release registrations (not inclusive)
	* @return the range of fund release registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.FundReleaseRegistration> getFundReleaseRegistrations(
		int start, int end) {
		return _fundReleaseRegistrationLocalService.getFundReleaseRegistrations(start,
			end);
	}

	/**
	* Returns the number of fund release registrations.
	*
	* @return the number of fund release registrations
	*/
	@Override
	public int getFundReleaseRegistrationsCount() {
		return _fundReleaseRegistrationLocalService.getFundReleaseRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _fundReleaseRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _fundReleaseRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fundReleaseRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the fund release registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fundReleaseRegistration the fund release registration
	* @return the fund release registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.FundReleaseRegistration updateFundReleaseRegistration(
		com.crowd.funding.database.model.FundReleaseRegistration fundReleaseRegistration) {
		return _fundReleaseRegistrationLocalService.updateFundReleaseRegistration(fundReleaseRegistration);
	}

	@Override
	public FundReleaseRegistrationLocalService getWrappedService() {
		return _fundReleaseRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		FundReleaseRegistrationLocalService fundReleaseRegistrationLocalService) {
		_fundReleaseRegistrationLocalService = fundReleaseRegistrationLocalService;
	}

	private FundReleaseRegistrationLocalService _fundReleaseRegistrationLocalService;
}