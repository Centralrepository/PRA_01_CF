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

package com.crowd.funding.database.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.FundReleaseRegistration;
import com.crowd.funding.database.model.FundReleaseRegistrationModel;
import com.crowd.funding.database.model.FundReleaseRegistrationSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the FundReleaseRegistration service. Represents a row in the &quot;cf_fund_release_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link FundReleaseRegistrationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FundReleaseRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundReleaseRegistrationImpl
 * @see FundReleaseRegistration
 * @see FundReleaseRegistrationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class FundReleaseRegistrationModelImpl extends BaseModelImpl<FundReleaseRegistration>
	implements FundReleaseRegistrationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fund release registration model instance should use the {@link FundReleaseRegistration} interface instead.
	 */
	public static final String TABLE_NAME = "cf_fund_release_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "FUND_RELEASE_ID", Types.BIGINT },
			{ "PROJECT_ID", Types.BIGINT },
			{ "CURRENCY", Types.VARCHAR },
			{ "AMOUNT", Types.FLOAT },
			{ "RELEASE_DATE", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("FUND_RELEASE_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("PROJECT_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CURRENCY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("AMOUNT", Types.FLOAT);
		TABLE_COLUMNS_MAP.put("RELEASE_DATE", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table cf_fund_release_details (uuid_ VARCHAR(75) null,FUND_RELEASE_ID LONG not null primary key,PROJECT_ID LONG,CURRENCY VARCHAR(75) null,AMOUNT DOUBLE,RELEASE_DATE DATE null)";
	public static final String TABLE_SQL_DROP = "drop table cf_fund_release_details";
	public static final String ORDER_BY_JPQL = " ORDER BY fundReleaseRegistration.FUND_RELEASE_ID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cf_fund_release_details.FUND_RELEASE_ID ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.crowd.funding.database.model.FundReleaseRegistration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.crowd.funding.database.model.FundReleaseRegistration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.crowd.funding.database.model.FundReleaseRegistration"),
			true);
	public static final long FUND_RELEASE_ID_COLUMN_BITMASK = 1L;
	public static final long PROJECT_ID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FundReleaseRegistration toModel(
		FundReleaseRegistrationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FundReleaseRegistration model = new FundReleaseRegistrationImpl();

		model.setUuid(soapModel.getUuid());
		model.setFUND_RELEASE_ID(soapModel.getFUND_RELEASE_ID());
		model.setPROJECT_ID(soapModel.getPROJECT_ID());
		model.setCURRENCY(soapModel.getCURRENCY());
		model.setAMOUNT(soapModel.getAMOUNT());
		model.setRELEASE_DATE(soapModel.getRELEASE_DATE());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FundReleaseRegistration> toModels(
		FundReleaseRegistrationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FundReleaseRegistration> models = new ArrayList<FundReleaseRegistration>(soapModels.length);

		for (FundReleaseRegistrationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.crowd.funding.database.service.util.ServiceProps.get(
				"lock.expiration.time.com.crowd.funding.database.model.FundReleaseRegistration"));

	public FundReleaseRegistrationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _FUND_RELEASE_ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFUND_RELEASE_ID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _FUND_RELEASE_ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FundReleaseRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return FundReleaseRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("FUND_RELEASE_ID", getFUND_RELEASE_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("CURRENCY", getCURRENCY());
		attributes.put("AMOUNT", getAMOUNT());
		attributes.put("RELEASE_DATE", getRELEASE_DATE());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long FUND_RELEASE_ID = (Long)attributes.get("FUND_RELEASE_ID");

		if (FUND_RELEASE_ID != null) {
			setFUND_RELEASE_ID(FUND_RELEASE_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		String CURRENCY = (String)attributes.get("CURRENCY");

		if (CURRENCY != null) {
			setCURRENCY(CURRENCY);
		}

		Float AMOUNT = (Float)attributes.get("AMOUNT");

		if (AMOUNT != null) {
			setAMOUNT(AMOUNT);
		}

		Date RELEASE_DATE = (Date)attributes.get("RELEASE_DATE");

		if (RELEASE_DATE != null) {
			setRELEASE_DATE(RELEASE_DATE);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getFUND_RELEASE_ID() {
		return _FUND_RELEASE_ID;
	}

	@Override
	public void setFUND_RELEASE_ID(long FUND_RELEASE_ID) {
		_columnBitmask |= FUND_RELEASE_ID_COLUMN_BITMASK;

		if (!_setOriginalFUND_RELEASE_ID) {
			_setOriginalFUND_RELEASE_ID = true;

			_originalFUND_RELEASE_ID = _FUND_RELEASE_ID;
		}

		_FUND_RELEASE_ID = FUND_RELEASE_ID;
	}

	public long getOriginalFUND_RELEASE_ID() {
		return _originalFUND_RELEASE_ID;
	}

	@JSON
	@Override
	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_columnBitmask |= PROJECT_ID_COLUMN_BITMASK;

		if (!_setOriginalPROJECT_ID) {
			_setOriginalPROJECT_ID = true;

			_originalPROJECT_ID = _PROJECT_ID;
		}

		_PROJECT_ID = PROJECT_ID;
	}

	public long getOriginalPROJECT_ID() {
		return _originalPROJECT_ID;
	}

	@JSON
	@Override
	public String getCURRENCY() {
		if (_CURRENCY == null) {
			return "";
		}
		else {
			return _CURRENCY;
		}
	}

	@Override
	public void setCURRENCY(String CURRENCY) {
		_CURRENCY = CURRENCY;
	}

	@JSON
	@Override
	public float getAMOUNT() {
		return _AMOUNT;
	}

	@Override
	public void setAMOUNT(float AMOUNT) {
		_AMOUNT = AMOUNT;
	}

	@JSON
	@Override
	public Date getRELEASE_DATE() {
		return _RELEASE_DATE;
	}

	@Override
	public void setRELEASE_DATE(Date RELEASE_DATE) {
		_RELEASE_DATE = RELEASE_DATE;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FundReleaseRegistration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FundReleaseRegistration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FundReleaseRegistration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FundReleaseRegistrationImpl fundReleaseRegistrationImpl = new FundReleaseRegistrationImpl();

		fundReleaseRegistrationImpl.setUuid(getUuid());
		fundReleaseRegistrationImpl.setFUND_RELEASE_ID(getFUND_RELEASE_ID());
		fundReleaseRegistrationImpl.setPROJECT_ID(getPROJECT_ID());
		fundReleaseRegistrationImpl.setCURRENCY(getCURRENCY());
		fundReleaseRegistrationImpl.setAMOUNT(getAMOUNT());
		fundReleaseRegistrationImpl.setRELEASE_DATE(getRELEASE_DATE());

		fundReleaseRegistrationImpl.resetOriginalValues();

		return fundReleaseRegistrationImpl;
	}

	@Override
	public int compareTo(FundReleaseRegistration fundReleaseRegistration) {
		long primaryKey = fundReleaseRegistration.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundReleaseRegistration)) {
			return false;
		}

		FundReleaseRegistration fundReleaseRegistration = (FundReleaseRegistration)obj;

		long primaryKey = fundReleaseRegistration.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		FundReleaseRegistrationModelImpl fundReleaseRegistrationModelImpl = this;

		fundReleaseRegistrationModelImpl._originalUuid = fundReleaseRegistrationModelImpl._uuid;

		fundReleaseRegistrationModelImpl._originalFUND_RELEASE_ID = fundReleaseRegistrationModelImpl._FUND_RELEASE_ID;

		fundReleaseRegistrationModelImpl._setOriginalFUND_RELEASE_ID = false;

		fundReleaseRegistrationModelImpl._originalPROJECT_ID = fundReleaseRegistrationModelImpl._PROJECT_ID;

		fundReleaseRegistrationModelImpl._setOriginalPROJECT_ID = false;

		fundReleaseRegistrationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FundReleaseRegistration> toCacheModel() {
		FundReleaseRegistrationCacheModel fundReleaseRegistrationCacheModel = new FundReleaseRegistrationCacheModel();

		fundReleaseRegistrationCacheModel.uuid = getUuid();

		String uuid = fundReleaseRegistrationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			fundReleaseRegistrationCacheModel.uuid = null;
		}

		fundReleaseRegistrationCacheModel.FUND_RELEASE_ID = getFUND_RELEASE_ID();

		fundReleaseRegistrationCacheModel.PROJECT_ID = getPROJECT_ID();

		fundReleaseRegistrationCacheModel.CURRENCY = getCURRENCY();

		String CURRENCY = fundReleaseRegistrationCacheModel.CURRENCY;

		if ((CURRENCY != null) && (CURRENCY.length() == 0)) {
			fundReleaseRegistrationCacheModel.CURRENCY = null;
		}

		fundReleaseRegistrationCacheModel.AMOUNT = getAMOUNT();

		Date RELEASE_DATE = getRELEASE_DATE();

		if (RELEASE_DATE != null) {
			fundReleaseRegistrationCacheModel.RELEASE_DATE = RELEASE_DATE.getTime();
		}
		else {
			fundReleaseRegistrationCacheModel.RELEASE_DATE = Long.MIN_VALUE;
		}

		return fundReleaseRegistrationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", FUND_RELEASE_ID=");
		sb.append(getFUND_RELEASE_ID());
		sb.append(", PROJECT_ID=");
		sb.append(getPROJECT_ID());
		sb.append(", CURRENCY=");
		sb.append(getCURRENCY());
		sb.append(", AMOUNT=");
		sb.append(getAMOUNT());
		sb.append(", RELEASE_DATE=");
		sb.append(getRELEASE_DATE());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.crowd.funding.database.model.FundReleaseRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>FUND_RELEASE_ID</column-name><column-value><![CDATA[");
		sb.append(getFUND_RELEASE_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PROJECT_ID</column-name><column-value><![CDATA[");
		sb.append(getPROJECT_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CURRENCY</column-name><column-value><![CDATA[");
		sb.append(getCURRENCY());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AMOUNT</column-name><column-value><![CDATA[");
		sb.append(getAMOUNT());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RELEASE_DATE</column-name><column-value><![CDATA[");
		sb.append(getRELEASE_DATE());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = FundReleaseRegistration.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			FundReleaseRegistration.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _FUND_RELEASE_ID;
	private long _originalFUND_RELEASE_ID;
	private boolean _setOriginalFUND_RELEASE_ID;
	private long _PROJECT_ID;
	private long _originalPROJECT_ID;
	private boolean _setOriginalPROJECT_ID;
	private String _CURRENCY;
	private float _AMOUNT;
	private Date _RELEASE_DATE;
	private long _columnBitmask;
	private FundReleaseRegistration _escapedModel;
}