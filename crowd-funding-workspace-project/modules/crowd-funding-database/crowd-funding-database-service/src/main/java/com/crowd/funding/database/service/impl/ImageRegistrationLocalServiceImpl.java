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

package com.crowd.funding.database.service.impl;

import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.service.base.ImageRegistrationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the image registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.ImageRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil
 */
public class ImageRegistrationLocalServiceImpl
	extends ImageRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil} to access the image registration local service.
	 */
	public  ImageRegistration findByPROJECT_IMAGE_ID(
			long PROJECT_IMAGE_ID)
			throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
			return imageRegistrationPersistence.findByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);
		}

	public  List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return imageRegistrationPersistence.findByPROJECT_ID(PROJECT_ID);
	}
}