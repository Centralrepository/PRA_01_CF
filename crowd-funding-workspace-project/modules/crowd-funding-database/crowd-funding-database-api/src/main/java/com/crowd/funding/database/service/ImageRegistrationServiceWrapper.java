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
 * Provides a wrapper for {@link ImageRegistrationService}.
 *
 * @author Brian Wing Shun Chan
 * @see ImageRegistrationService
 * @generated
 */
@ProviderType
public class ImageRegistrationServiceWrapper implements ImageRegistrationService,
	ServiceWrapper<ImageRegistrationService> {
	public ImageRegistrationServiceWrapper(
		ImageRegistrationService imageRegistrationService) {
		_imageRegistrationService = imageRegistrationService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _imageRegistrationService.getOSGiServiceIdentifier();
	}

	@Override
	public ImageRegistrationService getWrappedService() {
		return _imageRegistrationService;
	}

	@Override
	public void setWrappedService(
		ImageRegistrationService imageRegistrationService) {
		_imageRegistrationService = imageRegistrationService;
	}

	private ImageRegistrationService _imageRegistrationService;
}