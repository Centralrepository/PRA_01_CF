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

import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.base.UserRegistrationLocalServiceBaseImpl;

/**
 * The implementation of the user registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.UserRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.UserRegistrationLocalServiceUtil
 */
public class UserRegistrationLocalServiceImpl
	extends UserRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.UserRegistrationLocalServiceUtil} to access the user registration local service.
	 */
	public  UserRegistration findByUSER_ID(long USER_ID)
			throws com.crowd.funding.database.exception.NoSuchUserRegistrationException {
			return userRegistrationPersistence.findByUSER_ID(USER_ID);
		}
}