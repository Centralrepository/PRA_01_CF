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

package com.crowd.funding.database.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.exception.NoSuchDocumentRegistrationException;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.impl.DocumentRegistrationImpl;
import com.crowd.funding.database.model.impl.DocumentRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.DocumentRegistrationPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the document registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.DocumentRegistrationUtil
 * @generated
 */
@ProviderType
public class DocumentRegistrationPersistenceImpl extends BasePersistenceImpl<DocumentRegistration>
	implements DocumentRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocumentRegistrationUtil} to access the document registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocumentRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DocumentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DocumentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DocumentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DocumentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DocumentRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the document registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document registrations
	 */
	@Override
	public List<DocumentRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document registrations
	 * @param end the upper bound of the range of document registrations (not inclusive)
	 * @return the range of matching document registrations
	 */
	@Override
	public List<DocumentRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document registrations
	 * @param end the upper bound of the range of document registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document registrations
	 */
	@Override
	public List<DocumentRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<DocumentRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document registrations
	 * @param end the upper bound of the range of document registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching document registrations
	 */
	@Override
	public List<DocumentRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<DocumentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<DocumentRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<DocumentRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentRegistration documentRegistration : list) {
					if (!Objects.equals(uuid, documentRegistration.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DOCUMENTREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DocumentRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<DocumentRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DocumentRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first document registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document registration
	 * @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration findByUuid_First(String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException {
		DocumentRegistration documentRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (documentRegistration != null) {
			return documentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchDocumentRegistrationException(msg.toString());
	}

	/**
	 * Returns the first document registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document registration, or <code>null</code> if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration fetchByUuid_First(String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		List<DocumentRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document registration
	 * @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration findByUuid_Last(String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException {
		DocumentRegistration documentRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (documentRegistration != null) {
			return documentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchDocumentRegistrationException(msg.toString());
	}

	/**
	 * Returns the last document registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document registration, or <code>null</code> if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DocumentRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document registrations before and after the current document registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_DOCUMENT_ID the primary key of the current document registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document registration
	 * @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	 */
	@Override
	public DocumentRegistration[] findByUuid_PrevAndNext(
		long PROJECT_DOCUMENT_ID, String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException {
		DocumentRegistration documentRegistration = findByPrimaryKey(PROJECT_DOCUMENT_ID);

		Session session = null;

		try {
			session = openSession();

			DocumentRegistration[] array = new DocumentRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, documentRegistration,
					uuid, orderByComparator, true);

			array[1] = documentRegistration;

			array[2] = getByUuid_PrevAndNext(session, documentRegistration,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocumentRegistration getByUuid_PrevAndNext(Session session,
		DocumentRegistration documentRegistration, String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCUMENTREGISTRATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DocumentRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(documentRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DocumentRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DocumentRegistration documentRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(documentRegistration);
		}
	}

	/**
	 * Returns the number of document registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENTREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "documentRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "documentRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(documentRegistration.uuid IS NULL OR documentRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_DOCUMENT_ID = new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DocumentRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_DOCUMENT_ID",
			new String[] { Long.class.getName() },
			DocumentRegistrationModelImpl.PROJECT_DOCUMENT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_DOCUMENT_ID = new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_DOCUMENT_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the document registration where PROJECT_DOCUMENT_ID = &#63; or throws a {@link NoSuchDocumentRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_DOCUMENT_ID the project_document_id
	 * @return the matching document registration
	 * @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration findByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID) throws NoSuchDocumentRegistrationException {
		DocumentRegistration documentRegistration = fetchByPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);

		if (documentRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_DOCUMENT_ID=");
			msg.append(PROJECT_DOCUMENT_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDocumentRegistrationException(msg.toString());
		}

		return documentRegistration;
	}

	/**
	 * Returns the document registration where PROJECT_DOCUMENT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_DOCUMENT_ID the project_document_id
	 * @return the matching document registration, or <code>null</code> if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration fetchByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID) {
		return fetchByPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID, true);
	}

	/**
	 * Returns the document registration where PROJECT_DOCUMENT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_DOCUMENT_ID the project_document_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching document registration, or <code>null</code> if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration fetchByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_DOCUMENT_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_DOCUMENT_ID,
					finderArgs, this);
		}

		if (result instanceof DocumentRegistration) {
			DocumentRegistration documentRegistration = (DocumentRegistration)result;

			if ((PROJECT_DOCUMENT_ID != documentRegistration.getPROJECT_DOCUMENT_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DOCUMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_DOCUMENT_ID_PROJECT_DOCUMENT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_DOCUMENT_ID);

				List<DocumentRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_DOCUMENT_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DocumentRegistrationPersistenceImpl.fetchByPROJECT_DOCUMENT_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocumentRegistration documentRegistration = list.get(0);

					result = documentRegistration;

					cacheResult(documentRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_DOCUMENT_ID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DocumentRegistration)result;
		}
	}

	/**
	 * Removes the document registration where PROJECT_DOCUMENT_ID = &#63; from the database.
	 *
	 * @param PROJECT_DOCUMENT_ID the project_document_id
	 * @return the document registration that was removed
	 */
	@Override
	public DocumentRegistration removeByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID) throws NoSuchDocumentRegistrationException {
		DocumentRegistration documentRegistration = findByPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);

		return remove(documentRegistration);
	}

	/**
	 * Returns the number of document registrations where PROJECT_DOCUMENT_ID = &#63;.
	 *
	 * @param PROJECT_DOCUMENT_ID the project_document_id
	 * @return the number of matching document registrations
	 */
	@Override
	public int countByPROJECT_DOCUMENT_ID(long PROJECT_DOCUMENT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_DOCUMENT_ID;

		Object[] finderArgs = new Object[] { PROJECT_DOCUMENT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_DOCUMENT_ID_PROJECT_DOCUMENT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_DOCUMENT_ID);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROJECT_DOCUMENT_ID_PROJECT_DOCUMENT_ID_2 =
		"documentRegistration.PROJECT_DOCUMENT_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DocumentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DocumentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			DocumentRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the document registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching document registrations
	 */
	@Override
	public List<DocumentRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of document registrations
	 * @param end the upper bound of the range of document registrations (not inclusive)
	 * @return the range of matching document registrations
	 */
	@Override
	public List<DocumentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of document registrations
	 * @param end the upper bound of the range of document registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document registrations
	 */
	@Override
	public List<DocumentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of document registrations
	 * @param end the upper bound of the range of document registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching document registrations
	 */
	@Override
	public List<DocumentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<DocumentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID;
			finderArgs = new Object[] { PROJECT_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID;
			finderArgs = new Object[] { PROJECT_ID, start, end, orderByComparator };
		}

		List<DocumentRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<DocumentRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentRegistration documentRegistration : list) {
					if ((PROJECT_ID != documentRegistration.getPROJECT_ID())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DOCUMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DocumentRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<DocumentRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DocumentRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first document registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document registration
	 * @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException {
		DocumentRegistration documentRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (documentRegistration != null) {
			return documentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchDocumentRegistrationException(msg.toString());
	}

	/**
	 * Returns the first document registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document registration, or <code>null</code> if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		List<DocumentRegistration> list = findByPROJECT_ID(PROJECT_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document registration
	 * @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException {
		DocumentRegistration documentRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (documentRegistration != null) {
			return documentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchDocumentRegistrationException(msg.toString());
	}

	/**
	 * Returns the last document registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document registration, or <code>null</code> if a matching document registration could not be found
	 */
	@Override
	public DocumentRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<DocumentRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document registrations before and after the current document registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_DOCUMENT_ID the primary key of the current document registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document registration
	 * @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	 */
	@Override
	public DocumentRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_DOCUMENT_ID, long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException {
		DocumentRegistration documentRegistration = findByPrimaryKey(PROJECT_DOCUMENT_ID);

		Session session = null;

		try {
			session = openSession();

			DocumentRegistration[] array = new DocumentRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					documentRegistration, PROJECT_ID, orderByComparator, true);

			array[1] = documentRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					documentRegistration, PROJECT_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocumentRegistration getByPROJECT_ID_PrevAndNext(
		Session session, DocumentRegistration documentRegistration,
		long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCUMENTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DocumentRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(documentRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DocumentRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (DocumentRegistration documentRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(documentRegistration);
		}
	}

	/**
	 * Returns the number of document registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching document registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCUMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "documentRegistration.PROJECT_ID = ?";

	public DocumentRegistrationPersistenceImpl() {
		setModelClass(DocumentRegistration.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the document registration in the entity cache if it is enabled.
	 *
	 * @param documentRegistration the document registration
	 */
	@Override
	public void cacheResult(DocumentRegistration documentRegistration) {
		entityCache.putResult(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationImpl.class,
			documentRegistration.getPrimaryKey(), documentRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_DOCUMENT_ID,
			new Object[] { documentRegistration.getPROJECT_DOCUMENT_ID() },
			documentRegistration);

		documentRegistration.resetOriginalValues();
	}

	/**
	 * Caches the document registrations in the entity cache if it is enabled.
	 *
	 * @param documentRegistrations the document registrations
	 */
	@Override
	public void cacheResult(List<DocumentRegistration> documentRegistrations) {
		for (DocumentRegistration documentRegistration : documentRegistrations) {
			if (entityCache.getResult(
						DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						DocumentRegistrationImpl.class,
						documentRegistration.getPrimaryKey()) == null) {
				cacheResult(documentRegistration);
			}
			else {
				documentRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all document registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the document registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentRegistration documentRegistration) {
		entityCache.removeResult(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationImpl.class, documentRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DocumentRegistrationModelImpl)documentRegistration,
			true);
	}

	@Override
	public void clearCache(List<DocumentRegistration> documentRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DocumentRegistration documentRegistration : documentRegistrations) {
			entityCache.removeResult(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				DocumentRegistrationImpl.class,
				documentRegistration.getPrimaryKey());

			clearUniqueFindersCache((DocumentRegistrationModelImpl)documentRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		DocumentRegistrationModelImpl documentRegistrationModelImpl) {
		Object[] args = new Object[] {
				documentRegistrationModelImpl.getPROJECT_DOCUMENT_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_DOCUMENT_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_DOCUMENT_ID, args,
			documentRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DocumentRegistrationModelImpl documentRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					documentRegistrationModelImpl.getPROJECT_DOCUMENT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_DOCUMENT_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_DOCUMENT_ID,
				args);
		}

		if ((documentRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_DOCUMENT_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					documentRegistrationModelImpl.getOriginalPROJECT_DOCUMENT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_DOCUMENT_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_DOCUMENT_ID,
				args);
		}
	}

	/**
	 * Creates a new document registration with the primary key. Does not add the document registration to the database.
	 *
	 * @param PROJECT_DOCUMENT_ID the primary key for the new document registration
	 * @return the new document registration
	 */
	@Override
	public DocumentRegistration create(long PROJECT_DOCUMENT_ID) {
		DocumentRegistration documentRegistration = new DocumentRegistrationImpl();

		documentRegistration.setNew(true);
		documentRegistration.setPrimaryKey(PROJECT_DOCUMENT_ID);

		String uuid = PortalUUIDUtil.generate();

		documentRegistration.setUuid(uuid);

		return documentRegistration;
	}

	/**
	 * Removes the document registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_DOCUMENT_ID the primary key of the document registration
	 * @return the document registration that was removed
	 * @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	 */
	@Override
	public DocumentRegistration remove(long PROJECT_DOCUMENT_ID)
		throws NoSuchDocumentRegistrationException {
		return remove((Serializable)PROJECT_DOCUMENT_ID);
	}

	/**
	 * Removes the document registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document registration
	 * @return the document registration that was removed
	 * @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	 */
	@Override
	public DocumentRegistration remove(Serializable primaryKey)
		throws NoSuchDocumentRegistrationException {
		Session session = null;

		try {
			session = openSession();

			DocumentRegistration documentRegistration = (DocumentRegistration)session.get(DocumentRegistrationImpl.class,
					primaryKey);

			if (documentRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(documentRegistration);
		}
		catch (NoSuchDocumentRegistrationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DocumentRegistration removeImpl(
		DocumentRegistration documentRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentRegistration)) {
				documentRegistration = (DocumentRegistration)session.get(DocumentRegistrationImpl.class,
						documentRegistration.getPrimaryKeyObj());
			}

			if (documentRegistration != null) {
				session.delete(documentRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (documentRegistration != null) {
			clearCache(documentRegistration);
		}

		return documentRegistration;
	}

	@Override
	public DocumentRegistration updateImpl(
		DocumentRegistration documentRegistration) {
		boolean isNew = documentRegistration.isNew();

		if (!(documentRegistration instanceof DocumentRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documentRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(documentRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documentRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocumentRegistration implementation " +
				documentRegistration.getClass());
		}

		DocumentRegistrationModelImpl documentRegistrationModelImpl = (DocumentRegistrationModelImpl)documentRegistration;

		if (Validator.isNull(documentRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			documentRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (documentRegistration.isNew()) {
				session.save(documentRegistration);

				documentRegistration.setNew(false);
			}
			else {
				session.evict(documentRegistration);
				session.saveOrUpdate(documentRegistration);
			}

			session.flush();
			session.clear();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DocumentRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { documentRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { documentRegistrationModelImpl.getPROJECT_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((documentRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						documentRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { documentRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((documentRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						documentRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						documentRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DocumentRegistrationImpl.class,
			documentRegistration.getPrimaryKey(), documentRegistration, false);

		clearUniqueFindersCache(documentRegistrationModelImpl, false);
		cacheUniqueFindersCache(documentRegistrationModelImpl);

		documentRegistration.resetOriginalValues();

		return documentRegistration;
	}

	/**
	 * Returns the document registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the document registration
	 * @return the document registration
	 * @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	 */
	@Override
	public DocumentRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentRegistrationException {
		DocumentRegistration documentRegistration = fetchByPrimaryKey(primaryKey);

		if (documentRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return documentRegistration;
	}

	/**
	 * Returns the document registration with the primary key or throws a {@link NoSuchDocumentRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_DOCUMENT_ID the primary key of the document registration
	 * @return the document registration
	 * @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	 */
	@Override
	public DocumentRegistration findByPrimaryKey(long PROJECT_DOCUMENT_ID)
		throws NoSuchDocumentRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_DOCUMENT_ID);
	}

	/**
	 * Returns the document registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document registration
	 * @return the document registration, or <code>null</code> if a document registration with the primary key could not be found
	 */
	@Override
	public DocumentRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				DocumentRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DocumentRegistration documentRegistration = (DocumentRegistration)serializable;

		if (documentRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				documentRegistration = (DocumentRegistration)session.get(DocumentRegistrationImpl.class,
						primaryKey);

				if (documentRegistration != null) {
					cacheResult(documentRegistration);
				}
				else {
					entityCache.putResult(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						DocumentRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					DocumentRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return documentRegistration;
	}

	/**
	 * Returns the document registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_DOCUMENT_ID the primary key of the document registration
	 * @return the document registration, or <code>null</code> if a document registration with the primary key could not be found
	 */
	@Override
	public DocumentRegistration fetchByPrimaryKey(long PROJECT_DOCUMENT_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_DOCUMENT_ID);
	}

	@Override
	public Map<Serializable, DocumentRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DocumentRegistration> map = new HashMap<Serializable, DocumentRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DocumentRegistration documentRegistration = fetchByPrimaryKey(primaryKey);

			if (documentRegistration != null) {
				map.put(primaryKey, documentRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					DocumentRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DocumentRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DOCUMENTREGISTRATION_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (DocumentRegistration documentRegistration : (List<DocumentRegistration>)q.list()) {
				map.put(documentRegistration.getPrimaryKeyObj(),
					documentRegistration);

				cacheResult(documentRegistration);

				uncachedPrimaryKeys.remove(documentRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DocumentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					DocumentRegistrationImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the document registrations.
	 *
	 * @return the document registrations
	 */
	@Override
	public List<DocumentRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document registrations
	 * @param end the upper bound of the range of document registrations (not inclusive)
	 * @return the range of document registrations
	 */
	@Override
	public List<DocumentRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document registrations
	 * @param end the upper bound of the range of document registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document registrations
	 */
	@Override
	public List<DocumentRegistration> findAll(int start, int end,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document registrations
	 * @param end the upper bound of the range of document registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of document registrations
	 */
	@Override
	public List<DocumentRegistration> findAll(int start, int end,
		OrderByComparator<DocumentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DocumentRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<DocumentRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DOCUMENTREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTREGISTRATION;

				if (pagination) {
					sql = sql.concat(DocumentRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DocumentRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DocumentRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the document registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentRegistration documentRegistration : findAll()) {
			remove(documentRegistration);
		}
	}

	/**
	 * Returns the number of document registrations.
	 *
	 * @return the number of document registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOCUMENTREGISTRATION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DocumentRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DOCUMENTREGISTRATION = "SELECT documentRegistration FROM DocumentRegistration documentRegistration";
	private static final String _SQL_SELECT_DOCUMENTREGISTRATION_WHERE_PKS_IN = "SELECT documentRegistration FROM DocumentRegistration documentRegistration WHERE PROJECT_DOCUMENT_ID IN (";
	private static final String _SQL_SELECT_DOCUMENTREGISTRATION_WHERE = "SELECT documentRegistration FROM DocumentRegistration documentRegistration WHERE ";
	private static final String _SQL_COUNT_DOCUMENTREGISTRATION = "SELECT COUNT(documentRegistration) FROM DocumentRegistration documentRegistration";
	private static final String _SQL_COUNT_DOCUMENTREGISTRATION_WHERE = "SELECT COUNT(documentRegistration) FROM DocumentRegistration documentRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "documentRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DocumentRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DocumentRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DocumentRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}