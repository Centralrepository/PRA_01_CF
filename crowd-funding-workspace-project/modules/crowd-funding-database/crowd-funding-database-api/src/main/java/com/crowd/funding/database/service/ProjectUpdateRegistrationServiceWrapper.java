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
 * Provides a wrapper for {@link ProjectUpdateRegistrationService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUpdateRegistrationService
 * @generated
 */
@ProviderType
public class ProjectUpdateRegistrationServiceWrapper
	implements ProjectUpdateRegistrationService,
		ServiceWrapper<ProjectUpdateRegistrationService> {
	public ProjectUpdateRegistrationServiceWrapper(
		ProjectUpdateRegistrationService projectUpdateRegistrationService) {
		_projectUpdateRegistrationService = projectUpdateRegistrationService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectUpdateRegistrationService.getOSGiServiceIdentifier();
	}

	@Override
	public ProjectUpdateRegistrationService getWrappedService() {
		return _projectUpdateRegistrationService;
	}

	@Override
	public void setWrappedService(
		ProjectUpdateRegistrationService projectUpdateRegistrationService) {
		_projectUpdateRegistrationService = projectUpdateRegistrationService;
	}

	private ProjectUpdateRegistrationService _projectUpdateRegistrationService;
}