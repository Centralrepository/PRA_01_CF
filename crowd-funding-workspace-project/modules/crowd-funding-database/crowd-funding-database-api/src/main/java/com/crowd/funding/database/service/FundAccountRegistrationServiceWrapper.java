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
 * Provides a wrapper for {@link FundAccountRegistrationService}.
 *
 * @author Brian Wing Shun Chan
 * @see FundAccountRegistrationService
 * @generated
 */
@ProviderType
public class FundAccountRegistrationServiceWrapper
	implements FundAccountRegistrationService,
		ServiceWrapper<FundAccountRegistrationService> {
	public FundAccountRegistrationServiceWrapper(
		FundAccountRegistrationService fundAccountRegistrationService) {
		_fundAccountRegistrationService = fundAccountRegistrationService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _fundAccountRegistrationService.getOSGiServiceIdentifier();
	}

	@Override
	public FundAccountRegistrationService getWrappedService() {
		return _fundAccountRegistrationService;
	}

	@Override
	public void setWrappedService(
		FundAccountRegistrationService fundAccountRegistrationService) {
		_fundAccountRegistrationService = fundAccountRegistrationService;
	}

	private FundAccountRegistrationService _fundAccountRegistrationService;
}