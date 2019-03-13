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

import com.crowd.funding.database.model.UserFollowRegistration;
import com.crowd.funding.database.service.base.UserFollowRegistrationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the user follow registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.UserFollowRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFollowRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.UserFollowRegistrationLocalServiceUtil
 */
public class UserFollowRegistrationLocalServiceImpl
	extends UserFollowRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.UserFollowRegistrationLocalServiceUtil} to access the user follow registration local service.
	 */
	public  UserFollowRegistration findByUSER_FOLLOW_ID(
			long USER_FOLLOW_ID)
			throws com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException {
			return userFollowRegistrationPersistence.findByUSER_FOLLOW_ID(USER_FOLLOW_ID);
		}
	public  List<UserFollowRegistration> findByUSER_ID(long USER_ID) {
		return userFollowRegistrationPersistence.findByUSER_ID(USER_ID);
	}
	public  List<UserFollowRegistration> findByFOLLOWER_USER_ID(
			long FOLLOWER_USER_ID) {
			return userFollowRegistrationPersistence.findByFOLLOWER_USER_ID(FOLLOWER_USER_ID);
		}
}