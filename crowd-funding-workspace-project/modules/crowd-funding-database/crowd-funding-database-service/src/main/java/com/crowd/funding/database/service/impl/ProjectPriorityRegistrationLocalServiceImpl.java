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

import com.crowd.funding.database.model.ProjectPriorityRegistration;
import com.crowd.funding.database.service.base.ProjectPriorityRegistrationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the project priority registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPriorityRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil
 */
public class ProjectPriorityRegistrationLocalServiceImpl
	extends ProjectPriorityRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil} to access the project priority registration local service.
	 */
	
	public  ProjectPriorityRegistration findByPROJECT_ID(long PROJECT_ID)
			throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
			return projectPriorityRegistrationPersistence.findByPROJECT_ID(PROJECT_ID);
		}
	public  List<ProjectPriorityRegistration> findByPRIORITY(int PRIORITY) {
		return projectPriorityRegistrationPersistence.findByPRIORITY(PRIORITY);
	}
	public  ProjectPriorityRegistration findByPRIORITY_SEQUANCE(
			int PRIORITY_SEQUANCE)
			throws com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException {
			return projectPriorityRegistrationPersistence.findByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);
		}
	
}