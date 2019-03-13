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

import com.crowd.funding.database.model.NewsLetterRegistration;
import com.crowd.funding.database.model.NewsLetterRegistrationDOCUMENTBlobModel;
import com.crowd.funding.database.model.NewsLetterRegistrationModel;
import com.crowd.funding.database.model.NewsLetterRegistrationSoap;
import com.crowd.funding.database.service.NewsLetterRegistrationLocalServiceUtil;

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

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the NewsLetterRegistration service. Represents a row in the &quot;cf_news_letter_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link NewsLetterRegistrationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NewsLetterRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterRegistrationImpl
 * @see NewsLetterRegistration
 * @see NewsLetterRegistrationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class NewsLetterRegistrationModelImpl extends BaseModelImpl<NewsLetterRegistration>
	implements NewsLetterRegistrationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a news letter registration model instance should use the {@link NewsLetterRegistration} interface instead.
	 */
	public static final String TABLE_NAME = "cf_news_letter_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "NEWS_LETTER_ID", Types.BIGINT },
			{ "TITLE", Types.VARCHAR },
			{ "DETAILS", Types.VARCHAR },
			{ "DOCUMENT_TYPE", Types.VARCHAR },
			{ "DOCUMENT", Types.BLOB },
			{ "DATE", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("NEWS_LETTER_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("TITLE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("DETAILS", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("DOCUMENT_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("DOCUMENT", Types.BLOB);
		TABLE_COLUMNS_MAP.put("DATE", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table cf_news_letter_details (uuid_ VARCHAR(75) null,NEWS_LETTER_ID LONG not null primary key,TITLE TEXT null,DETAILS TEXT null,DOCUMENT_TYPE VARCHAR(75) null,DOCUMENT BLOB,DATE DATE null)";
	public static final String TABLE_SQL_DROP = "drop table cf_news_letter_details";
	public static final String ORDER_BY_JPQL = " ORDER BY newsLetterRegistration.NEWS_LETTER_ID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cf_news_letter_details.NEWS_LETTER_ID ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.crowd.funding.database.model.NewsLetterRegistration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.crowd.funding.database.model.NewsLetterRegistration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.crowd.funding.database.model.NewsLetterRegistration"),
			true);
	public static final long NEWS_LETTER_ID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static NewsLetterRegistration toModel(
		NewsLetterRegistrationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		NewsLetterRegistration model = new NewsLetterRegistrationImpl();

		model.setUuid(soapModel.getUuid());
		model.setNEWS_LETTER_ID(soapModel.getNEWS_LETTER_ID());
		model.setTITLE(soapModel.getTITLE());
		model.setDETAILS(soapModel.getDETAILS());
		model.setDOCUMENT_TYPE(soapModel.getDOCUMENT_TYPE());
		model.setDOCUMENT(soapModel.getDOCUMENT());
		model.setDATE(soapModel.getDATE());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<NewsLetterRegistration> toModels(
		NewsLetterRegistrationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<NewsLetterRegistration> models = new ArrayList<NewsLetterRegistration>(soapModels.length);

		for (NewsLetterRegistrationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.crowd.funding.database.service.util.ServiceProps.get(
				"lock.expiration.time.com.crowd.funding.database.model.NewsLetterRegistration"));

	public NewsLetterRegistrationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _NEWS_LETTER_ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNEWS_LETTER_ID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _NEWS_LETTER_ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NewsLetterRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return NewsLetterRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("NEWS_LETTER_ID", getNEWS_LETTER_ID());
		attributes.put("TITLE", getTITLE());
		attributes.put("DETAILS", getDETAILS());
		attributes.put("DOCUMENT_TYPE", getDOCUMENT_TYPE());
		attributes.put("DOCUMENT", getDOCUMENT());
		attributes.put("DATE", getDATE());

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

		Long NEWS_LETTER_ID = (Long)attributes.get("NEWS_LETTER_ID");

		if (NEWS_LETTER_ID != null) {
			setNEWS_LETTER_ID(NEWS_LETTER_ID);
		}

		String TITLE = (String)attributes.get("TITLE");

		if (TITLE != null) {
			setTITLE(TITLE);
		}

		String DETAILS = (String)attributes.get("DETAILS");

		if (DETAILS != null) {
			setDETAILS(DETAILS);
		}

		String DOCUMENT_TYPE = (String)attributes.get("DOCUMENT_TYPE");

		if (DOCUMENT_TYPE != null) {
			setDOCUMENT_TYPE(DOCUMENT_TYPE);
		}

		Blob DOCUMENT = (Blob)attributes.get("DOCUMENT");

		if (DOCUMENT != null) {
			setDOCUMENT(DOCUMENT);
		}

		Date DATE = (Date)attributes.get("DATE");

		if (DATE != null) {
			setDATE(DATE);
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
	public long getNEWS_LETTER_ID() {
		return _NEWS_LETTER_ID;
	}

	@Override
	public void setNEWS_LETTER_ID(long NEWS_LETTER_ID) {
		_columnBitmask |= NEWS_LETTER_ID_COLUMN_BITMASK;

		if (!_setOriginalNEWS_LETTER_ID) {
			_setOriginalNEWS_LETTER_ID = true;

			_originalNEWS_LETTER_ID = _NEWS_LETTER_ID;
		}

		_NEWS_LETTER_ID = NEWS_LETTER_ID;
	}

	public long getOriginalNEWS_LETTER_ID() {
		return _originalNEWS_LETTER_ID;
	}

	@JSON
	@Override
	public String getTITLE() {
		if (_TITLE == null) {
			return "";
		}
		else {
			return _TITLE;
		}
	}

	@Override
	public void setTITLE(String TITLE) {
		_TITLE = TITLE;
	}

	@JSON
	@Override
	public String getDETAILS() {
		if (_DETAILS == null) {
			return "";
		}
		else {
			return _DETAILS;
		}
	}

	@Override
	public void setDETAILS(String DETAILS) {
		_DETAILS = DETAILS;
	}

	@JSON
	@Override
	public String getDOCUMENT_TYPE() {
		if (_DOCUMENT_TYPE == null) {
			return "";
		}
		else {
			return _DOCUMENT_TYPE;
		}
	}

	@Override
	public void setDOCUMENT_TYPE(String DOCUMENT_TYPE) {
		_DOCUMENT_TYPE = DOCUMENT_TYPE;
	}

	@JSON
	@Override
	public Blob getDOCUMENT() {
		if (_DOCUMENTBlobModel == null) {
			try {
				_DOCUMENTBlobModel = NewsLetterRegistrationLocalServiceUtil.getDOCUMENTBlobModel(getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_DOCUMENTBlobModel != null) {
			blob = _DOCUMENTBlobModel.getDOCUMENTBlob();
		}

		return blob;
	}

	@Override
	public void setDOCUMENT(Blob DOCUMENT) {
		if (_DOCUMENTBlobModel == null) {
			_DOCUMENTBlobModel = new NewsLetterRegistrationDOCUMENTBlobModel(getPrimaryKey(),
					DOCUMENT);
		}
		else {
			_DOCUMENTBlobModel.setDOCUMENTBlob(DOCUMENT);
		}
	}

	@JSON
	@Override
	public Date getDATE() {
		return _DATE;
	}

	@Override
	public void setDATE(Date DATE) {
		_DATE = DATE;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			NewsLetterRegistration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NewsLetterRegistration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NewsLetterRegistration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NewsLetterRegistrationImpl newsLetterRegistrationImpl = new NewsLetterRegistrationImpl();

		newsLetterRegistrationImpl.setUuid(getUuid());
		newsLetterRegistrationImpl.setNEWS_LETTER_ID(getNEWS_LETTER_ID());
		newsLetterRegistrationImpl.setTITLE(getTITLE());
		newsLetterRegistrationImpl.setDETAILS(getDETAILS());
		newsLetterRegistrationImpl.setDOCUMENT_TYPE(getDOCUMENT_TYPE());
		newsLetterRegistrationImpl.setDATE(getDATE());

		newsLetterRegistrationImpl.resetOriginalValues();

		return newsLetterRegistrationImpl;
	}

	@Override
	public int compareTo(NewsLetterRegistration newsLetterRegistration) {
		long primaryKey = newsLetterRegistration.getPrimaryKey();

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

		if (!(obj instanceof NewsLetterRegistration)) {
			return false;
		}

		NewsLetterRegistration newsLetterRegistration = (NewsLetterRegistration)obj;

		long primaryKey = newsLetterRegistration.getPrimaryKey();

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
		NewsLetterRegistrationModelImpl newsLetterRegistrationModelImpl = this;

		newsLetterRegistrationModelImpl._originalUuid = newsLetterRegistrationModelImpl._uuid;

		newsLetterRegistrationModelImpl._originalNEWS_LETTER_ID = newsLetterRegistrationModelImpl._NEWS_LETTER_ID;

		newsLetterRegistrationModelImpl._setOriginalNEWS_LETTER_ID = false;

		newsLetterRegistrationModelImpl._DOCUMENTBlobModel = null;

		newsLetterRegistrationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<NewsLetterRegistration> toCacheModel() {
		NewsLetterRegistrationCacheModel newsLetterRegistrationCacheModel = new NewsLetterRegistrationCacheModel();

		newsLetterRegistrationCacheModel.uuid = getUuid();

		String uuid = newsLetterRegistrationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			newsLetterRegistrationCacheModel.uuid = null;
		}

		newsLetterRegistrationCacheModel.NEWS_LETTER_ID = getNEWS_LETTER_ID();

		newsLetterRegistrationCacheModel.TITLE = getTITLE();

		String TITLE = newsLetterRegistrationCacheModel.TITLE;

		if ((TITLE != null) && (TITLE.length() == 0)) {
			newsLetterRegistrationCacheModel.TITLE = null;
		}

		newsLetterRegistrationCacheModel.DETAILS = getDETAILS();

		String DETAILS = newsLetterRegistrationCacheModel.DETAILS;

		if ((DETAILS != null) && (DETAILS.length() == 0)) {
			newsLetterRegistrationCacheModel.DETAILS = null;
		}

		newsLetterRegistrationCacheModel.DOCUMENT_TYPE = getDOCUMENT_TYPE();

		String DOCUMENT_TYPE = newsLetterRegistrationCacheModel.DOCUMENT_TYPE;

		if ((DOCUMENT_TYPE != null) && (DOCUMENT_TYPE.length() == 0)) {
			newsLetterRegistrationCacheModel.DOCUMENT_TYPE = null;
		}

		Date DATE = getDATE();

		if (DATE != null) {
			newsLetterRegistrationCacheModel.DATE = DATE.getTime();
		}
		else {
			newsLetterRegistrationCacheModel.DATE = Long.MIN_VALUE;
		}

		return newsLetterRegistrationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", NEWS_LETTER_ID=");
		sb.append(getNEWS_LETTER_ID());
		sb.append(", TITLE=");
		sb.append(getTITLE());
		sb.append(", DETAILS=");
		sb.append(getDETAILS());
		sb.append(", DOCUMENT_TYPE=");
		sb.append(getDOCUMENT_TYPE());
		sb.append(", DATE=");
		sb.append(getDATE());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.crowd.funding.database.model.NewsLetterRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NEWS_LETTER_ID</column-name><column-value><![CDATA[");
		sb.append(getNEWS_LETTER_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TITLE</column-name><column-value><![CDATA[");
		sb.append(getTITLE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DETAILS</column-name><column-value><![CDATA[");
		sb.append(getDETAILS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DOCUMENT_TYPE</column-name><column-value><![CDATA[");
		sb.append(getDOCUMENT_TYPE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DATE</column-name><column-value><![CDATA[");
		sb.append(getDATE());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = NewsLetterRegistration.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			NewsLetterRegistration.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _NEWS_LETTER_ID;
	private long _originalNEWS_LETTER_ID;
	private boolean _setOriginalNEWS_LETTER_ID;
	private String _TITLE;
	private String _DETAILS;
	private String _DOCUMENT_TYPE;
	private NewsLetterRegistrationDOCUMENTBlobModel _DOCUMENTBlobModel;
	private Date _DATE;
	private long _columnBitmask;
	private NewsLetterRegistration _escapedModel;
}