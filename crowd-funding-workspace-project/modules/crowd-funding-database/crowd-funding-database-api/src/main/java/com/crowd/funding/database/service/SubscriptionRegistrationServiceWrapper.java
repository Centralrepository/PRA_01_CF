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
 * Provides a wrapper for {@link SubscriptionRegistrationService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionRegistrationService
 * @generated
 */
@ProviderType
public class SubscriptionRegistrationServiceWrapper
	implements SubscriptionRegistrationService,
		ServiceWrapper<SubscriptionRegistrationService> {
	public SubscriptionRegistrationServiceWrapper(
		SubscriptionRegistrationService subscriptionRegistrationService) {
		_subscriptionRegistrationService = subscriptionRegistrationService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _subscriptionRegistrationService.getOSGiServiceIdentifier();
	}

	@Override
	public SubscriptionRegistrationService getWrappedService() {
		return _subscriptionRegistrationService;
	}

	@Override
	public void setWrappedService(
		SubscriptionRegistrationService subscriptionRegistrationService) {
		_subscriptionRegistrationService = subscriptionRegistrationService;
	}

	private SubscriptionRegistrationService _subscriptionRegistrationService;
}