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

package com.crowd.funding.database.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.SubscriptionRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.SubscriptionRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class SubscriptionRegistrationSoap implements Serializable {
	public static SubscriptionRegistrationSoap toSoapModel(
		SubscriptionRegistration model) {
		SubscriptionRegistrationSoap soapModel = new SubscriptionRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSUSCRIBER_ID(model.getSUSCRIBER_ID());
		soapModel.setEMAIL(model.getEMAIL());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static SubscriptionRegistrationSoap[] toSoapModels(
		SubscriptionRegistration[] models) {
		SubscriptionRegistrationSoap[] soapModels = new SubscriptionRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubscriptionRegistrationSoap[][] toSoapModels(
		SubscriptionRegistration[][] models) {
		SubscriptionRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubscriptionRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubscriptionRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubscriptionRegistrationSoap[] toSoapModels(
		List<SubscriptionRegistration> models) {
		List<SubscriptionRegistrationSoap> soapModels = new ArrayList<SubscriptionRegistrationSoap>(models.size());

		for (SubscriptionRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubscriptionRegistrationSoap[soapModels.size()]);
	}

	public SubscriptionRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _SUSCRIBER_ID;
	}

	public void setPrimaryKey(long pk) {
		setSUSCRIBER_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSUSCRIBER_ID() {
		return _SUSCRIBER_ID;
	}

	public void setSUSCRIBER_ID(long SUSCRIBER_ID) {
		_SUSCRIBER_ID = SUSCRIBER_ID;
	}

	public String getEMAIL() {
		return _EMAIL;
	}

	public void setEMAIL(String EMAIL) {
		_EMAIL = EMAIL;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _SUSCRIBER_ID;
	private String _EMAIL;
	private int _STATUS;
}