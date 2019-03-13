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

import com.crowd.funding.database.model.FundRegistration;
import com.crowd.funding.database.service.base.FundRegistrationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the fund registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.FundRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.FundRegistrationLocalServiceUtil
 */
public class FundRegistrationLocalServiceImpl
	extends FundRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.FundRegistrationLocalServiceUtil} to access the fund registration local service.
	 */
	public  FundRegistration findByPROJECT_FUND_ID(long PROJECT_FUND_ID)
			throws com.crowd.funding.database.exception.NoSuchFundRegistrationException {
			return fundRegistrationPersistence.findByPROJECT_FUND_ID(PROJECT_FUND_ID);
		}
	public  List<FundRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return fundRegistrationPersistence.findByPROJECT_ID(PROJECT_ID);
	}
	public  List<FundRegistration> findByPROJECT_DONOR_USER_ID(
			long PROJECT_ID, long DONOR_USER_ID) {
			return fundRegistrationPersistence
					   .findByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID);
		}
	public  List<FundRegistration> findByDONOR_USER_ID(long DONOR_USER_ID) {
		return fundRegistrationPersistence.findByDONOR_USER_ID(DONOR_USER_ID);
	}
}