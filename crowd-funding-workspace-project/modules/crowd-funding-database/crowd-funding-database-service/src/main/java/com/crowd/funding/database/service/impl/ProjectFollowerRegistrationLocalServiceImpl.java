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

import com.crowd.funding.database.model.ProjectFollowerRegistration;
import com.crowd.funding.database.service.base.ProjectFollowerRegistrationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the project follower registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.ProjectFollowerRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFollowerRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.ProjectFollowerRegistrationLocalServiceUtil
 */
public class ProjectFollowerRegistrationLocalServiceImpl
	extends ProjectFollowerRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.ProjectFollowerRegistrationLocalServiceUtil} to access the project follower registration local service.
	 */
	
	public  ProjectFollowerRegistration findByPROJECT_FOLLOWER_ID(
			long PROJECT_FOLLOWER_ID)
			throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
			return projectFollowerRegistrationPersistence.findByPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);
		}
	public  List<ProjectFollowerRegistration> findByUSER_ID(long USER_ID) {
		return projectFollowerRegistrationPersistence.findByUSER_ID(USER_ID);
	}
	public  List<ProjectFollowerRegistration> findByPROJECT_ID(
			long PROJECT_ID) {
			return projectFollowerRegistrationPersistence.findByPROJECT_ID(PROJECT_ID);
		}
	public  ProjectFollowerRegistration findByPROJECT_USER_ID(
			long PROJECT_ID, long USER_ID)
			throws com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException {
			return projectFollowerRegistrationPersistence.findByPROJECT_USER_ID(PROJECT_ID, USER_ID);
		}
}