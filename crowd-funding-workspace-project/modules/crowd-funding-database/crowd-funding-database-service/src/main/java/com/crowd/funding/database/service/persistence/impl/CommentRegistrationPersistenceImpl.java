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

import com.crowd.funding.database.exception.NoSuchCommentRegistrationException;
import com.crowd.funding.database.model.CommentRegistration;
import com.crowd.funding.database.model.impl.CommentRegistrationImpl;
import com.crowd.funding.database.model.impl.CommentRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.CommentRegistrationPersistence;

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
 * The persistence implementation for the comment registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.CommentRegistrationUtil
 * @generated
 */
@ProviderType
public class CommentRegistrationPersistenceImpl extends BasePersistenceImpl<CommentRegistration>
	implements CommentRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CommentRegistrationUtil} to access the comment registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CommentRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			CommentRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the comment registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comment registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @return the range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comment registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CommentRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comment registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CommentRegistration> orderByComparator,
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

		List<CommentRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CommentRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommentRegistration commentRegistration : list) {
					if (!Objects.equals(uuid, commentRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE);

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
				query.append(CommentRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<CommentRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommentRegistration>)QueryUtil.list(q,
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
	 * Returns the first comment registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment registration
	 * @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration findByUuid_First(String uuid,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (commentRegistration != null) {
			return commentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCommentRegistrationException(msg.toString());
	}

	/**
	 * Returns the first comment registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchByUuid_First(String uuid,
		OrderByComparator<CommentRegistration> orderByComparator) {
		List<CommentRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment registration
	 * @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration findByUuid_Last(String uuid,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (commentRegistration != null) {
			return commentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCommentRegistrationException(msg.toString());
	}

	/**
	 * Returns the last comment registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<CommentRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CommentRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comment registrations before and after the current comment registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_COMMENT_ID the primary key of the current comment registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment registration
	 * @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration[] findByUuid_PrevAndNext(
		long PROJECT_COMMENT_ID, String uuid,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = findByPrimaryKey(PROJECT_COMMENT_ID);

		Session session = null;

		try {
			session = openSession();

			CommentRegistration[] array = new CommentRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, commentRegistration,
					uuid, orderByComparator, true);

			array[1] = commentRegistration;

			array[2] = getByUuid_PrevAndNext(session, commentRegistration,
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

	protected CommentRegistration getByUuid_PrevAndNext(Session session,
		CommentRegistration commentRegistration, String uuid,
		OrderByComparator<CommentRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE);

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
			query.append(CommentRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(commentRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommentRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comment registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CommentRegistration commentRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(commentRegistration);
		}
	}

	/**
	 * Returns the number of comment registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching comment registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMENTREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "commentRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "commentRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(commentRegistration.uuid IS NULL OR commentRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_COMMENT_ID = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_COMMENT_ID", new String[] { Long.class.getName() },
			CommentRegistrationModelImpl.PROJECT_COMMENT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_COMMENT_ID = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_COMMENT_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the comment registration where PROJECT_COMMENT_ID = &#63; or throws a {@link NoSuchCommentRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_COMMENT_ID the project_comment_id
	 * @return the matching comment registration
	 * @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration findByPROJECT_COMMENT_ID(long PROJECT_COMMENT_ID)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchByPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);

		if (commentRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_COMMENT_ID=");
			msg.append(PROJECT_COMMENT_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCommentRegistrationException(msg.toString());
		}

		return commentRegistration;
	}

	/**
	 * Returns the comment registration where PROJECT_COMMENT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_COMMENT_ID the project_comment_id
	 * @return the matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID) {
		return fetchByPROJECT_COMMENT_ID(PROJECT_COMMENT_ID, true);
	}

	/**
	 * Returns the comment registration where PROJECT_COMMENT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_COMMENT_ID the project_comment_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_COMMENT_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_COMMENT_ID,
					finderArgs, this);
		}

		if (result instanceof CommentRegistration) {
			CommentRegistration commentRegistration = (CommentRegistration)result;

			if ((PROJECT_COMMENT_ID != commentRegistration.getPROJECT_COMMENT_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_COMMENT_ID_PROJECT_COMMENT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_COMMENT_ID);

				List<CommentRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_COMMENT_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"CommentRegistrationPersistenceImpl.fetchByPROJECT_COMMENT_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CommentRegistration commentRegistration = list.get(0);

					result = commentRegistration;

					cacheResult(commentRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_COMMENT_ID,
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
			return (CommentRegistration)result;
		}
	}

	/**
	 * Removes the comment registration where PROJECT_COMMENT_ID = &#63; from the database.
	 *
	 * @param PROJECT_COMMENT_ID the project_comment_id
	 * @return the comment registration that was removed
	 */
	@Override
	public CommentRegistration removeByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID) throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = findByPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);

		return remove(commentRegistration);
	}

	/**
	 * Returns the number of comment registrations where PROJECT_COMMENT_ID = &#63;.
	 *
	 * @param PROJECT_COMMENT_ID the project_comment_id
	 * @return the number of matching comment registrations
	 */
	@Override
	public int countByPROJECT_COMMENT_ID(long PROJECT_COMMENT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_COMMENT_ID;

		Object[] finderArgs = new Object[] { PROJECT_COMMENT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_COMMENT_ID_PROJECT_COMMENT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_COMMENT_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_COMMENT_ID_PROJECT_COMMENT_ID_2 =
		"commentRegistration.PROJECT_COMMENT_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			CommentRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the comment registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comment registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @return the range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comment registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comment registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator,
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

		List<CommentRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CommentRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommentRegistration commentRegistration : list) {
					if ((PROJECT_ID != commentRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CommentRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<CommentRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommentRegistration>)QueryUtil.list(q,
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
	 * Returns the first comment registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment registration
	 * @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (commentRegistration != null) {
			return commentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchCommentRegistrationException(msg.toString());
	}

	/**
	 * Returns the first comment registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator) {
		List<CommentRegistration> list = findByPROJECT_ID(PROJECT_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment registration
	 * @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (commentRegistration != null) {
			return commentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchCommentRegistrationException(msg.toString());
	}

	/**
	 * Returns the last comment registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<CommentRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comment registrations before and after the current comment registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_COMMENT_ID the primary key of the current comment registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment registration
	 * @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_COMMENT_ID, long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = findByPrimaryKey(PROJECT_COMMENT_ID);

		Session session = null;

		try {
			session = openSession();

			CommentRegistration[] array = new CommentRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					commentRegistration, PROJECT_ID, orderByComparator, true);

			array[1] = commentRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					commentRegistration, PROJECT_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommentRegistration getByPROJECT_ID_PrevAndNext(Session session,
		CommentRegistration commentRegistration, long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE);

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
			query.append(CommentRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(commentRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommentRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comment registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (CommentRegistration commentRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(commentRegistration);
		}
	}

	/**
	 * Returns the number of comment registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching comment registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMENTREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "commentRegistration.PROJECT_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySTATUS",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySTATUS",
			new String[] { Integer.class.getName() },
			CommentRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySTATUS",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the comment registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findBySTATUS(int STATUS) {
		return findBySTATUS(STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comment registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @return the range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findBySTATUS(int STATUS, int start, int end) {
		return findBySTATUS(STATUS, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comment registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<CommentRegistration> orderByComparator) {
		return findBySTATUS(STATUS, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comment registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { STATUS };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { STATUS, start, end, orderByComparator };
		}

		List<CommentRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CommentRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommentRegistration commentRegistration : list) {
					if ((STATUS != commentRegistration.getSTATUS())) {
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

			query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CommentRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(STATUS);

				if (!pagination) {
					list = (List<CommentRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommentRegistration>)QueryUtil.list(q,
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
	 * Returns the first comment registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment registration
	 * @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchBySTATUS_First(STATUS,
				orderByComparator);

		if (commentRegistration != null) {
			return commentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchCommentRegistrationException(msg.toString());
	}

	/**
	 * Returns the first comment registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator) {
		List<CommentRegistration> list = findBySTATUS(STATUS, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment registration
	 * @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchBySTATUS_Last(STATUS,
				orderByComparator);

		if (commentRegistration != null) {
			return commentRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchCommentRegistrationException(msg.toString());
	}

	/**
	 * Returns the last comment registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator) {
		int count = countBySTATUS(STATUS);

		if (count == 0) {
			return null;
		}

		List<CommentRegistration> list = findBySTATUS(STATUS, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comment registrations before and after the current comment registration in the ordered set where STATUS = &#63;.
	 *
	 * @param PROJECT_COMMENT_ID the primary key of the current comment registration
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment registration
	 * @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration[] findBySTATUS_PrevAndNext(
		long PROJECT_COMMENT_ID, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = findByPrimaryKey(PROJECT_COMMENT_ID);

		Session session = null;

		try {
			session = openSession();

			CommentRegistration[] array = new CommentRegistrationImpl[3];

			array[0] = getBySTATUS_PrevAndNext(session, commentRegistration,
					STATUS, orderByComparator, true);

			array[1] = commentRegistration;

			array[2] = getBySTATUS_PrevAndNext(session, commentRegistration,
					STATUS, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommentRegistration getBySTATUS_PrevAndNext(Session session,
		CommentRegistration commentRegistration, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(CommentRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(commentRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommentRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comment registrations where STATUS = &#63; from the database.
	 *
	 * @param STATUS the status
	 */
	@Override
	public void removeBySTATUS(int STATUS) {
		for (CommentRegistration commentRegistration : findBySTATUS(STATUS,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(commentRegistration);
		}
	}

	/**
	 * Returns the number of comment registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the number of matching comment registrations
	 */
	@Override
	public int countBySTATUS(int STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(STATUS);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "commentRegistration.STATUS = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID_STATUS =
		new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID_STATUS",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID_STATUS =
		new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CommentRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPROJECT_ID_STATUS",
			new String[] { Long.class.getName(), Integer.class.getName() },
			CommentRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK |
			CommentRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID_STATUS = new FinderPath(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_ID_STATUS",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @return the matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByPROJECT_ID_STATUS(long PROJECT_ID,
		int STATUS) {
		return findByPROJECT_ID_STATUS(PROJECT_ID, STATUS, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @return the range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByPROJECT_ID_STATUS(long PROJECT_ID,
		int STATUS, int start, int end) {
		return findByPROJECT_ID_STATUS(PROJECT_ID, STATUS, start, end, null);
	}

	/**
	 * Returns an ordered range of all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByPROJECT_ID_STATUS(long PROJECT_ID,
		int STATUS, int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return findByPROJECT_ID_STATUS(PROJECT_ID, STATUS, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching comment registrations
	 */
	@Override
	public List<CommentRegistration> findByPROJECT_ID_STATUS(long PROJECT_ID,
		int STATUS, int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID_STATUS;
			finderArgs = new Object[] { PROJECT_ID, STATUS };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID_STATUS;
			finderArgs = new Object[] {
					PROJECT_ID, STATUS,
					
					start, end, orderByComparator
				};
		}

		List<CommentRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CommentRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CommentRegistration commentRegistration : list) {
					if ((PROJECT_ID != commentRegistration.getPROJECT_ID()) ||
							(STATUS != commentRegistration.getSTATUS())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_STATUS_PROJECT_ID_2);

			query.append(_FINDER_COLUMN_PROJECT_ID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CommentRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				qPos.add(STATUS);

				if (!pagination) {
					list = (List<CommentRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommentRegistration>)QueryUtil.list(q,
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
	 * Returns the first comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment registration
	 * @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration findByPROJECT_ID_STATUS_First(long PROJECT_ID,
		int STATUS, OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchByPROJECT_ID_STATUS_First(PROJECT_ID,
				STATUS, orderByComparator);

		if (commentRegistration != null) {
			return commentRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append(", STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchCommentRegistrationException(msg.toString());
	}

	/**
	 * Returns the first comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchByPROJECT_ID_STATUS_First(long PROJECT_ID,
		int STATUS, OrderByComparator<CommentRegistration> orderByComparator) {
		List<CommentRegistration> list = findByPROJECT_ID_STATUS(PROJECT_ID,
				STATUS, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment registration
	 * @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration findByPROJECT_ID_STATUS_Last(long PROJECT_ID,
		int STATUS, OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchByPROJECT_ID_STATUS_Last(PROJECT_ID,
				STATUS, orderByComparator);

		if (commentRegistration != null) {
			return commentRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append(", STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchCommentRegistrationException(msg.toString());
	}

	/**
	 * Returns the last comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	 */
	@Override
	public CommentRegistration fetchByPROJECT_ID_STATUS_Last(long PROJECT_ID,
		int STATUS, OrderByComparator<CommentRegistration> orderByComparator) {
		int count = countByPROJECT_ID_STATUS(PROJECT_ID, STATUS);

		if (count == 0) {
			return null;
		}

		List<CommentRegistration> list = findByPROJECT_ID_STATUS(PROJECT_ID,
				STATUS, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the comment registrations before and after the current comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * @param PROJECT_COMMENT_ID the primary key of the current comment registration
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next comment registration
	 * @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration[] findByPROJECT_ID_STATUS_PrevAndNext(
		long PROJECT_COMMENT_ID, long PROJECT_ID, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = findByPrimaryKey(PROJECT_COMMENT_ID);

		Session session = null;

		try {
			session = openSession();

			CommentRegistration[] array = new CommentRegistrationImpl[3];

			array[0] = getByPROJECT_ID_STATUS_PrevAndNext(session,
					commentRegistration, PROJECT_ID, STATUS, orderByComparator,
					true);

			array[1] = commentRegistration;

			array[2] = getByPROJECT_ID_STATUS_PrevAndNext(session,
					commentRegistration, PROJECT_ID, STATUS, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommentRegistration getByPROJECT_ID_STATUS_PrevAndNext(
		Session session, CommentRegistration commentRegistration,
		long PROJECT_ID, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_PROJECT_ID_STATUS_PROJECT_ID_2);

		query.append(_FINDER_COLUMN_PROJECT_ID_STATUS_STATUS_2);

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
			query.append(CommentRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		qPos.add(STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(commentRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommentRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 */
	@Override
	public void removeByPROJECT_ID_STATUS(long PROJECT_ID, int STATUS) {
		for (CommentRegistration commentRegistration : findByPROJECT_ID_STATUS(
				PROJECT_ID, STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(commentRegistration);
		}
	}

	/**
	 * Returns the number of comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param STATUS the status
	 * @return the number of matching comment registrations
	 */
	@Override
	public int countByPROJECT_ID_STATUS(long PROJECT_ID, int STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID_STATUS;

		Object[] finderArgs = new Object[] { PROJECT_ID, STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_COMMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_STATUS_PROJECT_ID_2);

			query.append(_FINDER_COLUMN_PROJECT_ID_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				qPos.add(STATUS);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_STATUS_PROJECT_ID_2 = "commentRegistration.PROJECT_ID = ? AND ";
	private static final String _FINDER_COLUMN_PROJECT_ID_STATUS_STATUS_2 = "commentRegistration.STATUS = ?";

	public CommentRegistrationPersistenceImpl() {
		setModelClass(CommentRegistration.class);

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
	 * Caches the comment registration in the entity cache if it is enabled.
	 *
	 * @param commentRegistration the comment registration
	 */
	@Override
	public void cacheResult(CommentRegistration commentRegistration) {
		entityCache.putResult(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationImpl.class, commentRegistration.getPrimaryKey(),
			commentRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_COMMENT_ID,
			new Object[] { commentRegistration.getPROJECT_COMMENT_ID() },
			commentRegistration);

		commentRegistration.resetOriginalValues();
	}

	/**
	 * Caches the comment registrations in the entity cache if it is enabled.
	 *
	 * @param commentRegistrations the comment registrations
	 */
	@Override
	public void cacheResult(List<CommentRegistration> commentRegistrations) {
		for (CommentRegistration commentRegistration : commentRegistrations) {
			if (entityCache.getResult(
						CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						CommentRegistrationImpl.class,
						commentRegistration.getPrimaryKey()) == null) {
				cacheResult(commentRegistration);
			}
			else {
				commentRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all comment registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommentRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the comment registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommentRegistration commentRegistration) {
		entityCache.removeResult(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationImpl.class, commentRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CommentRegistrationModelImpl)commentRegistration,
			true);
	}

	@Override
	public void clearCache(List<CommentRegistration> commentRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommentRegistration commentRegistration : commentRegistrations) {
			entityCache.removeResult(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				CommentRegistrationImpl.class,
				commentRegistration.getPrimaryKey());

			clearUniqueFindersCache((CommentRegistrationModelImpl)commentRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		CommentRegistrationModelImpl commentRegistrationModelImpl) {
		Object[] args = new Object[] {
				commentRegistrationModelImpl.getPROJECT_COMMENT_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_COMMENT_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_COMMENT_ID, args,
			commentRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CommentRegistrationModelImpl commentRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					commentRegistrationModelImpl.getPROJECT_COMMENT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_COMMENT_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_COMMENT_ID,
				args);
		}

		if ((commentRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_COMMENT_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					commentRegistrationModelImpl.getOriginalPROJECT_COMMENT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_COMMENT_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_COMMENT_ID,
				args);
		}
	}

	/**
	 * Creates a new comment registration with the primary key. Does not add the comment registration to the database.
	 *
	 * @param PROJECT_COMMENT_ID the primary key for the new comment registration
	 * @return the new comment registration
	 */
	@Override
	public CommentRegistration create(long PROJECT_COMMENT_ID) {
		CommentRegistration commentRegistration = new CommentRegistrationImpl();

		commentRegistration.setNew(true);
		commentRegistration.setPrimaryKey(PROJECT_COMMENT_ID);

		String uuid = PortalUUIDUtil.generate();

		commentRegistration.setUuid(uuid);

		return commentRegistration;
	}

	/**
	 * Removes the comment registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_COMMENT_ID the primary key of the comment registration
	 * @return the comment registration that was removed
	 * @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration remove(long PROJECT_COMMENT_ID)
		throws NoSuchCommentRegistrationException {
		return remove((Serializable)PROJECT_COMMENT_ID);
	}

	/**
	 * Removes the comment registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comment registration
	 * @return the comment registration that was removed
	 * @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration remove(Serializable primaryKey)
		throws NoSuchCommentRegistrationException {
		Session session = null;

		try {
			session = openSession();

			CommentRegistration commentRegistration = (CommentRegistration)session.get(CommentRegistrationImpl.class,
					primaryKey);

			if (commentRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommentRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(commentRegistration);
		}
		catch (NoSuchCommentRegistrationException nsee) {
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
	protected CommentRegistration removeImpl(
		CommentRegistration commentRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commentRegistration)) {
				commentRegistration = (CommentRegistration)session.get(CommentRegistrationImpl.class,
						commentRegistration.getPrimaryKeyObj());
			}

			if (commentRegistration != null) {
				session.delete(commentRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commentRegistration != null) {
			clearCache(commentRegistration);
		}

		return commentRegistration;
	}

	@Override
	public CommentRegistration updateImpl(
		CommentRegistration commentRegistration) {
		boolean isNew = commentRegistration.isNew();

		if (!(commentRegistration instanceof CommentRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(commentRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(commentRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commentRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CommentRegistration implementation " +
				commentRegistration.getClass());
		}

		CommentRegistrationModelImpl commentRegistrationModelImpl = (CommentRegistrationModelImpl)commentRegistration;

		if (Validator.isNull(commentRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			commentRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (commentRegistration.isNew()) {
				session.save(commentRegistration);

				commentRegistration.setNew(false);
			}
			else {
				commentRegistration = (CommentRegistration)session.merge(commentRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CommentRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { commentRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { commentRegistrationModelImpl.getPROJECT_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			args = new Object[] { commentRegistrationModelImpl.getSTATUS() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			args = new Object[] {
					commentRegistrationModelImpl.getPROJECT_ID(),
					commentRegistrationModelImpl.getSTATUS()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID_STATUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((commentRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commentRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { commentRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((commentRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commentRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] { commentRegistrationModelImpl.getPROJECT_ID() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}

			if ((commentRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commentRegistrationModelImpl.getOriginalSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { commentRegistrationModelImpl.getSTATUS() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((commentRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						commentRegistrationModelImpl.getOriginalPROJECT_ID(),
						commentRegistrationModelImpl.getOriginalSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID_STATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID_STATUS,
					args);

				args = new Object[] {
						commentRegistrationModelImpl.getPROJECT_ID(),
						commentRegistrationModelImpl.getSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID_STATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID_STATUS,
					args);
			}
		}

		entityCache.putResult(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CommentRegistrationImpl.class, commentRegistration.getPrimaryKey(),
			commentRegistration, false);

		clearUniqueFindersCache(commentRegistrationModelImpl, false);
		cacheUniqueFindersCache(commentRegistrationModelImpl);

		commentRegistration.resetOriginalValues();

		return commentRegistration;
	}

	/**
	 * Returns the comment registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the comment registration
	 * @return the comment registration
	 * @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommentRegistrationException {
		CommentRegistration commentRegistration = fetchByPrimaryKey(primaryKey);

		if (commentRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommentRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return commentRegistration;
	}

	/**
	 * Returns the comment registration with the primary key or throws a {@link NoSuchCommentRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_COMMENT_ID the primary key of the comment registration
	 * @return the comment registration
	 * @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration findByPrimaryKey(long PROJECT_COMMENT_ID)
		throws NoSuchCommentRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_COMMENT_ID);
	}

	/**
	 * Returns the comment registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comment registration
	 * @return the comment registration, or <code>null</code> if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				CommentRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CommentRegistration commentRegistration = (CommentRegistration)serializable;

		if (commentRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				commentRegistration = (CommentRegistration)session.get(CommentRegistrationImpl.class,
						primaryKey);

				if (commentRegistration != null) {
					cacheResult(commentRegistration);
				}
				else {
					entityCache.putResult(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						CommentRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CommentRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commentRegistration;
	}

	/**
	 * Returns the comment registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_COMMENT_ID the primary key of the comment registration
	 * @return the comment registration, or <code>null</code> if a comment registration with the primary key could not be found
	 */
	@Override
	public CommentRegistration fetchByPrimaryKey(long PROJECT_COMMENT_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_COMMENT_ID);
	}

	@Override
	public Map<Serializable, CommentRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CommentRegistration> map = new HashMap<Serializable, CommentRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CommentRegistration commentRegistration = fetchByPrimaryKey(primaryKey);

			if (commentRegistration != null) {
				map.put(primaryKey, commentRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CommentRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CommentRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_COMMENTREGISTRATION_WHERE_PKS_IN);

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

			for (CommentRegistration commentRegistration : (List<CommentRegistration>)q.list()) {
				map.put(commentRegistration.getPrimaryKeyObj(),
					commentRegistration);

				cacheResult(commentRegistration);

				uncachedPrimaryKeys.remove(commentRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CommentRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CommentRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the comment registrations.
	 *
	 * @return the comment registrations
	 */
	@Override
	public List<CommentRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comment registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @return the range of comment registrations
	 */
	@Override
	public List<CommentRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the comment registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comment registrations
	 */
	@Override
	public List<CommentRegistration> findAll(int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comment registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of comment registrations
	 * @param end the upper bound of the range of comment registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of comment registrations
	 */
	@Override
	public List<CommentRegistration> findAll(int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator,
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

		List<CommentRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CommentRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_COMMENTREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMENTREGISTRATION;

				if (pagination) {
					sql = sql.concat(CommentRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CommentRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CommentRegistration>)QueryUtil.list(q,
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
	 * Removes all the comment registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CommentRegistration commentRegistration : findAll()) {
			remove(commentRegistration);
		}
	}

	/**
	 * Returns the number of comment registrations.
	 *
	 * @return the number of comment registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COMMENTREGISTRATION);

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
		return CommentRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comment registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CommentRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_COMMENTREGISTRATION = "SELECT commentRegistration FROM CommentRegistration commentRegistration";
	private static final String _SQL_SELECT_COMMENTREGISTRATION_WHERE_PKS_IN = "SELECT commentRegistration FROM CommentRegistration commentRegistration WHERE PROJECT_COMMENT_ID IN (";
	private static final String _SQL_SELECT_COMMENTREGISTRATION_WHERE = "SELECT commentRegistration FROM CommentRegistration commentRegistration WHERE ";
	private static final String _SQL_COUNT_COMMENTREGISTRATION = "SELECT COUNT(commentRegistration) FROM CommentRegistration commentRegistration";
	private static final String _SQL_COUNT_COMMENTREGISTRATION_WHERE = "SELECT COUNT(commentRegistration) FROM CommentRegistration commentRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "commentRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CommentRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CommentRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CommentRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}