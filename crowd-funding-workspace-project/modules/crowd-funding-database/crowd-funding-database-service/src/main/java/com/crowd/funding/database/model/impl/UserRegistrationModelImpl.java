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

import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.model.UserRegistrationModel;
import com.crowd.funding.database.model.UserRegistrationSoap;

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
 * The base model implementation for the UserRegistration service. Represents a row in the &quot;cf_user_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link UserRegistrationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationImpl
 * @see UserRegistration
 * @see UserRegistrationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class UserRegistrationModelImpl extends BaseModelImpl<UserRegistration>
	implements UserRegistrationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user registration model instance should use the {@link UserRegistration} interface instead.
	 */
	public static final String TABLE_NAME = "cf_user_master";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "USER_ID", Types.BIGINT },
			{ "USER_OTP_ID", Types.BIGINT },
			{ "FULL_NAME", Types.VARCHAR },
			{ "PASSWORD", Types.VARCHAR },
			{ "GENDER", Types.VARCHAR },
			{ "CREATION_DATE", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("USER_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("USER_OTP_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("FULL_NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PASSWORD", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("GENDER", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CREATION_DATE", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table cf_user_master (uuid_ VARCHAR(75) null,USER_ID LONG not null primary key,USER_OTP_ID LONG,FULL_NAME VARCHAR(1000) null,PASSWORD VARCHAR(75) null,GENDER VARCHAR(75) null,CREATION_DATE DATE null)";
	public static final String TABLE_SQL_DROP = "drop table cf_user_master";
	public static final String ORDER_BY_JPQL = " ORDER BY userRegistration.USER_ID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cf_user_master.USER_ID ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.crowd.funding.database.model.UserRegistration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.crowd.funding.database.model.UserRegistration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.crowd.funding.database.model.UserRegistration"),
			true);
	public static final long USER_ID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserRegistration toModel(UserRegistrationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserRegistration model = new UserRegistrationImpl();

		model.setUuid(soapModel.getUuid());
		model.setUSER_ID(soapModel.getUSER_ID());
		model.setUSER_OTP_ID(soapModel.getUSER_OTP_ID());
		model.setFULL_NAME(soapModel.getFULL_NAME());
		model.setPASSWORD(soapModel.getPASSWORD());
		model.setGENDER(soapModel.getGENDER());
		model.setCREATION_DATE(soapModel.getCREATION_DATE());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserRegistration> toModels(
		UserRegistrationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserRegistration> models = new ArrayList<UserRegistration>(soapModels.length);

		for (UserRegistrationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.crowd.funding.database.service.util.ServiceProps.get(
				"lock.expiration.time.com.crowd.funding.database.model.UserRegistration"));

	public UserRegistrationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _USER_ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUSER_ID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _USER_ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return UserRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("USER_ID", getUSER_ID());
		attributes.put("USER_OTP_ID", getUSER_OTP_ID());
		attributes.put("FULL_NAME", getFULL_NAME());
		attributes.put("PASSWORD", getPASSWORD());
		attributes.put("GENDER", getGENDER());
		attributes.put("CREATION_DATE", getCREATION_DATE());

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

		Long USER_ID = (Long)attributes.get("USER_ID");

		if (USER_ID != null) {
			setUSER_ID(USER_ID);
		}

		Long USER_OTP_ID = (Long)attributes.get("USER_OTP_ID");

		if (USER_OTP_ID != null) {
			setUSER_OTP_ID(USER_OTP_ID);
		}

		String FULL_NAME = (String)attributes.get("FULL_NAME");

		if (FULL_NAME != null) {
			setFULL_NAME(FULL_NAME);
		}

		String PASSWORD = (String)attributes.get("PASSWORD");

		if (PASSWORD != null) {
			setPASSWORD(PASSWORD);
		}

		String GENDER = (String)attributes.get("GENDER");

		if (GENDER != null) {
			setGENDER(GENDER);
		}

		Date CREATION_DATE = (Date)attributes.get("CREATION_DATE");

		if (CREATION_DATE != null) {
			setCREATION_DATE(CREATION_DATE);
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
	public long getUSER_ID() {
		return _USER_ID;
	}

	@Override
	public void setUSER_ID(long USER_ID) {
		_columnBitmask |= USER_ID_COLUMN_BITMASK;

		if (!_setOriginalUSER_ID) {
			_setOriginalUSER_ID = true;

			_originalUSER_ID = _USER_ID;
		}

		_USER_ID = USER_ID;
	}

	public long getOriginalUSER_ID() {
		return _originalUSER_ID;
	}

	@JSON
	@Override
	public long getUSER_OTP_ID() {
		return _USER_OTP_ID;
	}

	@Override
	public void setUSER_OTP_ID(long USER_OTP_ID) {
		_USER_OTP_ID = USER_OTP_ID;
	}

	@JSON
	@Override
	public String getFULL_NAME() {
		if (_FULL_NAME == null) {
			return "";
		}
		else {
			return _FULL_NAME;
		}
	}

	@Override
	public void setFULL_NAME(String FULL_NAME) {
		_FULL_NAME = FULL_NAME;
	}

	@JSON
	@Override
	public String getPASSWORD() {
		if (_PASSWORD == null) {
			return "";
		}
		else {
			return _PASSWORD;
		}
	}

	@Override
	public void setPASSWORD(String PASSWORD) {
		_PASSWORD = PASSWORD;
	}

	@JSON
	@Override
	public String getGENDER() {
		if (_GENDER == null) {
			return "";
		}
		else {
			return _GENDER;
		}
	}

	@Override
	public void setGENDER(String GENDER) {
		_GENDER = GENDER;
	}

	@JSON
	@Override
	public Date getCREATION_DATE() {
		return _CREATION_DATE;
	}

	@Override
	public void setCREATION_DATE(Date CREATION_DATE) {
		_CREATION_DATE = CREATION_DATE;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			UserRegistration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserRegistration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserRegistration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserRegistrationImpl userRegistrationImpl = new UserRegistrationImpl();

		userRegistrationImpl.setUuid(getUuid());
		userRegistrationImpl.setUSER_ID(getUSER_ID());
		userRegistrationImpl.setUSER_OTP_ID(getUSER_OTP_ID());
		userRegistrationImpl.setFULL_NAME(getFULL_NAME());
		userRegistrationImpl.setPASSWORD(getPASSWORD());
		userRegistrationImpl.setGENDER(getGENDER());
		userRegistrationImpl.setCREATION_DATE(getCREATION_DATE());

		userRegistrationImpl.resetOriginalValues();

		return userRegistrationImpl;
	}

	@Override
	public int compareTo(UserRegistration userRegistration) {
		long primaryKey = userRegistration.getPrimaryKey();

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

		if (!(obj instanceof UserRegistration)) {
			return false;
		}

		UserRegistration userRegistration = (UserRegistration)obj;

		long primaryKey = userRegistration.getPrimaryKey();

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
		UserRegistrationModelImpl userRegistrationModelImpl = this;

		userRegistrationModelImpl._originalUuid = userRegistrationModelImpl._uuid;

		userRegistrationModelImpl._originalUSER_ID = userRegistrationModelImpl._USER_ID;

		userRegistrationModelImpl._setOriginalUSER_ID = false;

		userRegistrationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserRegistration> toCacheModel() {
		UserRegistrationCacheModel userRegistrationCacheModel = new UserRegistrationCacheModel();

		userRegistrationCacheModel.uuid = getUuid();

		String uuid = userRegistrationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			userRegistrationCacheModel.uuid = null;
		}

		userRegistrationCacheModel.USER_ID = getUSER_ID();

		userRegistrationCacheModel.USER_OTP_ID = getUSER_OTP_ID();

		userRegistrationCacheModel.FULL_NAME = getFULL_NAME();

		String FULL_NAME = userRegistrationCacheModel.FULL_NAME;

		if ((FULL_NAME != null) && (FULL_NAME.length() == 0)) {
			userRegistrationCacheModel.FULL_NAME = null;
		}

		userRegistrationCacheModel.PASSWORD = getPASSWORD();

		String PASSWORD = userRegistrationCacheModel.PASSWORD;

		if ((PASSWORD != null) && (PASSWORD.length() == 0)) {
			userRegistrationCacheModel.PASSWORD = null;
		}

		userRegistrationCacheModel.GENDER = getGENDER();

		String GENDER = userRegistrationCacheModel.GENDER;

		if ((GENDER != null) && (GENDER.length() == 0)) {
			userRegistrationCacheModel.GENDER = null;
		}

		Date CREATION_DATE = getCREATION_DATE();

		if (CREATION_DATE != null) {
			userRegistrationCacheModel.CREATION_DATE = CREATION_DATE.getTime();
		}
		else {
			userRegistrationCacheModel.CREATION_DATE = Long.MIN_VALUE;
		}

		return userRegistrationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", USER_ID=");
		sb.append(getUSER_ID());
		sb.append(", USER_OTP_ID=");
		sb.append(getUSER_OTP_ID());
		sb.append(", FULL_NAME=");
		sb.append(getFULL_NAME());
		sb.append(", PASSWORD=");
		sb.append(getPASSWORD());
		sb.append(", GENDER=");
		sb.append(getGENDER());
		sb.append(", CREATION_DATE=");
		sb.append(getCREATION_DATE());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.crowd.funding.database.model.UserRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>USER_ID</column-name><column-value><![CDATA[");
		sb.append(getUSER_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>USER_OTP_ID</column-name><column-value><![CDATA[");
		sb.append(getUSER_OTP_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>FULL_NAME</column-name><column-value><![CDATA[");
		sb.append(getFULL_NAME());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PASSWORD</column-name><column-value><![CDATA[");
		sb.append(getPASSWORD());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GENDER</column-name><column-value><![CDATA[");
		sb.append(getGENDER());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CREATION_DATE</column-name><column-value><![CDATA[");
		sb.append(getCREATION_DATE());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = UserRegistration.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			UserRegistration.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _USER_ID;
	private long _originalUSER_ID;
	private boolean _setOriginalUSER_ID;
	private long _USER_OTP_ID;
	private String _FULL_NAME;
	private String _PASSWORD;
	private String _GENDER;
	private Date _CREATION_DATE;
	private long _columnBitmask;
	private UserRegistration _escapedModel;
}