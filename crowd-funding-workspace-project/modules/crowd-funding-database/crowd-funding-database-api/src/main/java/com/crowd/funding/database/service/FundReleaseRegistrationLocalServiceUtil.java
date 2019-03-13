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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for FundReleaseRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.FundReleaseRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FundReleaseRegistrationLocalService
 * @see com.crowd.funding.database.service.base.FundReleaseRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.FundReleaseRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class FundReleaseRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.FundReleaseRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the fund release registration to the database. Also notifies the appropriate model listeners.
	*
	* @param fundReleaseRegistration the fund release registration
	* @return the fund release registration that was added
	*/
	public static com.crowd.funding.database.model.FundReleaseRegistration addFundReleaseRegistration(
		com.crowd.funding.database.model.FundReleaseRegistration fundReleaseRegistration) {
		return getService().addFundReleaseRegistration(fundReleaseRegistration);
	}

	/**
	* Creates a new fund release registration with the primary key. Does not add the fund release registration to the database.
	*
	* @param FUND_RELEASE_ID the primary key for the new fund release registration
	* @return the new fund release registration
	*/
	public static com.crowd.funding.database.model.FundReleaseRegistration createFundReleaseRegistration(
		long FUND_RELEASE_ID) {
		return getService().createFundReleaseRegistration(FUND_RELEASE_ID);
	}

	/**
	* Deletes the fund release registration from the database. Also notifies the appropriate model listeners.
	*
	* @param fundReleaseRegistration the fund release registration
	* @return the fund release registration that was removed
	*/
	public static com.crowd.funding.database.model.FundReleaseRegistration deleteFundReleaseRegistration(
		com.crowd.funding.database.model.FundReleaseRegistration fundReleaseRegistration) {
		return getService()
				   .deleteFundReleaseRegistration(fundReleaseRegistration);
	}

	/**
	* Deletes the fund release registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration that was removed
	* @throws PortalException if a fund release registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.FundReleaseRegistration deleteFundReleaseRegistration(
		long FUND_RELEASE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteFundReleaseRegistration(FUND_RELEASE_ID);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.crowd.funding.database.model.FundReleaseRegistration fetchFundReleaseRegistration(
		long FUND_RELEASE_ID) {
		return getService().fetchFundReleaseRegistration(FUND_RELEASE_ID);
	}

	public static com.crowd.funding.database.model.FundReleaseRegistration findByFUND_RELEASE_ID(
		long FUND_RELEASE_ID)
		throws com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException {
		return getService().findByFUND_RELEASE_ID(FUND_RELEASE_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.FundReleaseRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getService().findByPROJECT_ID(PROJECT_ID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the fund release registration with the primary key.
	*
	* @param FUND_RELEASE_ID the primary key of the fund release registration
	* @return the fund release registration
	* @throws PortalException if a fund release registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.FundReleaseRegistration getFundReleaseRegistration(
		long FUND_RELEASE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFundReleaseRegistration(FUND_RELEASE_ID);
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
	public static java.util.List<com.crowd.funding.database.model.FundReleaseRegistration> getFundReleaseRegistrations(
		int start, int end) {
		return getService().getFundReleaseRegistrations(start, end);
	}

	/**
	* Returns the number of fund release registrations.
	*
	* @return the number of fund release registrations
	*/
	public static int getFundReleaseRegistrationsCount() {
		return getService().getFundReleaseRegistrationsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the fund release registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fundReleaseRegistration the fund release registration
	* @return the fund release registration that was updated
	*/
	public static com.crowd.funding.database.model.FundReleaseRegistration updateFundReleaseRegistration(
		com.crowd.funding.database.model.FundReleaseRegistration fundReleaseRegistration) {
		return getService()
				   .updateFundReleaseRegistration(fundReleaseRegistration);
	}

	public static FundReleaseRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FundReleaseRegistrationLocalService, FundReleaseRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FundReleaseRegistrationLocalService.class);

		ServiceTracker<FundReleaseRegistrationLocalService, FundReleaseRegistrationLocalService> serviceTracker =
			new ServiceTracker<FundReleaseRegistrationLocalService, FundReleaseRegistrationLocalService>(bundle.getBundleContext(),
				FundReleaseRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}