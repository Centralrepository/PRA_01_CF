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

import com.crowd.funding.database.exception.NoSuchFeedbackRegistrationException;
import com.crowd.funding.database.model.FeedbackRegistration;
import com.crowd.funding.database.model.impl.FeedbackRegistrationImpl;
import com.crowd.funding.database.model.impl.FeedbackRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.FeedbackRegistrationPersistence;

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
 * The persistence implementation for the feedback registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.FeedbackRegistrationUtil
 * @generated
 */
@ProviderType
public class FeedbackRegistrationPersistenceImpl extends BasePersistenceImpl<FeedbackRegistration>
	implements FeedbackRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FeedbackRegistrationUtil} to access the feedback registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FeedbackRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FeedbackRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FeedbackRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FeedbackRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FeedbackRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FeedbackRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the feedback registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedback registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of feedback registrations
	 * @param end the upper bound of the range of feedback registrations (not inclusive)
	 * @return the range of matching feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedback registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of feedback registrations
	 * @param end the upper bound of the range of feedback registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FeedbackRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedback registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of feedback registrations
	 * @param end the upper bound of the range of feedback registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FeedbackRegistration> orderByComparator,
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

		List<FeedbackRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FeedbackRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FeedbackRegistration feedbackRegistration : list) {
					if (!Objects.equals(uuid, feedbackRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_FEEDBACKREGISTRATION_WHERE);

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
				query.append(FeedbackRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<FeedbackRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FeedbackRegistration>)QueryUtil.list(q,
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
	 * Returns the first feedback registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback registration
	 * @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration findByUuid_First(String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException {
		FeedbackRegistration feedbackRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (feedbackRegistration != null) {
			return feedbackRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFeedbackRegistrationException(msg.toString());
	}

	/**
	 * Returns the first feedback registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration fetchByUuid_First(String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		List<FeedbackRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback registration
	 * @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration findByUuid_Last(String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException {
		FeedbackRegistration feedbackRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (feedbackRegistration != null) {
			return feedbackRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFeedbackRegistrationException(msg.toString());
	}

	/**
	 * Returns the last feedback registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FeedbackRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedback registrations before and after the current feedback registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_FEEDBACK_ID the primary key of the current feedback registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback registration
	 * @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	 */
	@Override
	public FeedbackRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FEEDBACK_ID, String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException {
		FeedbackRegistration feedbackRegistration = findByPrimaryKey(PROJECT_FEEDBACK_ID);

		Session session = null;

		try {
			session = openSession();

			FeedbackRegistration[] array = new FeedbackRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, feedbackRegistration,
					uuid, orderByComparator, true);

			array[1] = feedbackRegistration;

			array[2] = getByUuid_PrevAndNext(session, feedbackRegistration,
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

	protected FeedbackRegistration getByUuid_PrevAndNext(Session session,
		FeedbackRegistration feedbackRegistration, String uuid,
		OrderByComparator<FeedbackRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_FEEDBACKREGISTRATION_WHERE);

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
			query.append(FeedbackRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(feedbackRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FeedbackRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedback registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FeedbackRegistration feedbackRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feedbackRegistration);
		}
	}

	/**
	 * Returns the number of feedback registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching feedback registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACKREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "feedbackRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "feedbackRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(feedbackRegistration.uuid IS NULL OR feedbackRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_FEEDBACK_ID = new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FeedbackRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_FEEDBACK_ID",
			new String[] { Long.class.getName() },
			FeedbackRegistrationModelImpl.PROJECT_FEEDBACK_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_FEEDBACK_ID = new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_FEEDBACK_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the feedback registration where PROJECT_FEEDBACK_ID = &#63; or throws a {@link NoSuchFeedbackRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_FEEDBACK_ID the project_feedback_id
	 * @return the matching feedback registration
	 * @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration findByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID) throws NoSuchFeedbackRegistrationException {
		FeedbackRegistration feedbackRegistration = fetchByPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);

		if (feedbackRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_FEEDBACK_ID=");
			msg.append(PROJECT_FEEDBACK_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFeedbackRegistrationException(msg.toString());
		}

		return feedbackRegistration;
	}

	/**
	 * Returns the feedback registration where PROJECT_FEEDBACK_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_FEEDBACK_ID the project_feedback_id
	 * @return the matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration fetchByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID) {
		return fetchByPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID, true);
	}

	/**
	 * Returns the feedback registration where PROJECT_FEEDBACK_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_FEEDBACK_ID the project_feedback_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration fetchByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_FEEDBACK_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_FEEDBACK_ID,
					finderArgs, this);
		}

		if (result instanceof FeedbackRegistration) {
			FeedbackRegistration feedbackRegistration = (FeedbackRegistration)result;

			if ((PROJECT_FEEDBACK_ID != feedbackRegistration.getPROJECT_FEEDBACK_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FEEDBACKREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_FEEDBACK_ID_PROJECT_FEEDBACK_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_FEEDBACK_ID);

				List<FeedbackRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FEEDBACK_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"FeedbackRegistrationPersistenceImpl.fetchByPROJECT_FEEDBACK_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FeedbackRegistration feedbackRegistration = list.get(0);

					result = feedbackRegistration;

					cacheResult(feedbackRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FEEDBACK_ID,
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
			return (FeedbackRegistration)result;
		}
	}

	/**
	 * Removes the feedback registration where PROJECT_FEEDBACK_ID = &#63; from the database.
	 *
	 * @param PROJECT_FEEDBACK_ID the project_feedback_id
	 * @return the feedback registration that was removed
	 */
	@Override
	public FeedbackRegistration removeByPROJECT_FEEDBACK_ID(
		long PROJECT_FEEDBACK_ID) throws NoSuchFeedbackRegistrationException {
		FeedbackRegistration feedbackRegistration = findByPROJECT_FEEDBACK_ID(PROJECT_FEEDBACK_ID);

		return remove(feedbackRegistration);
	}

	/**
	 * Returns the number of feedback registrations where PROJECT_FEEDBACK_ID = &#63;.
	 *
	 * @param PROJECT_FEEDBACK_ID the project_feedback_id
	 * @return the number of matching feedback registrations
	 */
	@Override
	public int countByPROJECT_FEEDBACK_ID(long PROJECT_FEEDBACK_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_FEEDBACK_ID;

		Object[] finderArgs = new Object[] { PROJECT_FEEDBACK_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACKREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_FEEDBACK_ID_PROJECT_FEEDBACK_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_FEEDBACK_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_FEEDBACK_ID_PROJECT_FEEDBACK_ID_2 =
		"feedbackRegistration.PROJECT_FEEDBACK_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FeedbackRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FeedbackRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			FeedbackRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the feedback registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedback registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of feedback registrations
	 * @param end the upper bound of the range of feedback registrations (not inclusive)
	 * @return the range of matching feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedback registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of feedback registrations
	 * @param end the upper bound of the range of feedback registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedback registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of feedback registrations
	 * @param end the upper bound of the range of feedback registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FeedbackRegistration> orderByComparator,
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

		List<FeedbackRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FeedbackRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FeedbackRegistration feedbackRegistration : list) {
					if ((PROJECT_ID != feedbackRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_FEEDBACKREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeedbackRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<FeedbackRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FeedbackRegistration>)QueryUtil.list(q,
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
	 * Returns the first feedback registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback registration
	 * @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException {
		FeedbackRegistration feedbackRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (feedbackRegistration != null) {
			return feedbackRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchFeedbackRegistrationException(msg.toString());
	}

	/**
	 * Returns the first feedback registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		List<FeedbackRegistration> list = findByPROJECT_ID(PROJECT_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback registration
	 * @throws NoSuchFeedbackRegistrationException if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException {
		FeedbackRegistration feedbackRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (feedbackRegistration != null) {
			return feedbackRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchFeedbackRegistrationException(msg.toString());
	}

	/**
	 * Returns the last feedback registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback registration, or <code>null</code> if a matching feedback registration could not be found
	 */
	@Override
	public FeedbackRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<FeedbackRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedback registrations before and after the current feedback registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_FEEDBACK_ID the primary key of the current feedback registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback registration
	 * @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	 */
	@Override
	public FeedbackRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FEEDBACK_ID, long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator)
		throws NoSuchFeedbackRegistrationException {
		FeedbackRegistration feedbackRegistration = findByPrimaryKey(PROJECT_FEEDBACK_ID);

		Session session = null;

		try {
			session = openSession();

			FeedbackRegistration[] array = new FeedbackRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					feedbackRegistration, PROJECT_ID, orderByComparator, true);

			array[1] = feedbackRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					feedbackRegistration, PROJECT_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FeedbackRegistration getByPROJECT_ID_PrevAndNext(
		Session session, FeedbackRegistration feedbackRegistration,
		long PROJECT_ID,
		OrderByComparator<FeedbackRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_FEEDBACKREGISTRATION_WHERE);

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
			query.append(FeedbackRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feedbackRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FeedbackRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedback registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (FeedbackRegistration feedbackRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feedbackRegistration);
		}
	}

	/**
	 * Returns the number of feedback registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching feedback registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACKREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "feedbackRegistration.PROJECT_ID = ?";

	public FeedbackRegistrationPersistenceImpl() {
		setModelClass(FeedbackRegistration.class);

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
	 * Caches the feedback registration in the entity cache if it is enabled.
	 *
	 * @param feedbackRegistration the feedback registration
	 */
	@Override
	public void cacheResult(FeedbackRegistration feedbackRegistration) {
		entityCache.putResult(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationImpl.class,
			feedbackRegistration.getPrimaryKey(), feedbackRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FEEDBACK_ID,
			new Object[] { feedbackRegistration.getPROJECT_FEEDBACK_ID() },
			feedbackRegistration);

		feedbackRegistration.resetOriginalValues();
	}

	/**
	 * Caches the feedback registrations in the entity cache if it is enabled.
	 *
	 * @param feedbackRegistrations the feedback registrations
	 */
	@Override
	public void cacheResult(List<FeedbackRegistration> feedbackRegistrations) {
		for (FeedbackRegistration feedbackRegistration : feedbackRegistrations) {
			if (entityCache.getResult(
						FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackRegistrationImpl.class,
						feedbackRegistration.getPrimaryKey()) == null) {
				cacheResult(feedbackRegistration);
			}
			else {
				feedbackRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all feedback registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FeedbackRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the feedback registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FeedbackRegistration feedbackRegistration) {
		entityCache.removeResult(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationImpl.class, feedbackRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FeedbackRegistrationModelImpl)feedbackRegistration,
			true);
	}

	@Override
	public void clearCache(List<FeedbackRegistration> feedbackRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FeedbackRegistration feedbackRegistration : feedbackRegistrations) {
			entityCache.removeResult(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackRegistrationImpl.class,
				feedbackRegistration.getPrimaryKey());

			clearUniqueFindersCache((FeedbackRegistrationModelImpl)feedbackRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		FeedbackRegistrationModelImpl feedbackRegistrationModelImpl) {
		Object[] args = new Object[] {
				feedbackRegistrationModelImpl.getPROJECT_FEEDBACK_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_FEEDBACK_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FEEDBACK_ID, args,
			feedbackRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		FeedbackRegistrationModelImpl feedbackRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					feedbackRegistrationModelImpl.getPROJECT_FEEDBACK_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_FEEDBACK_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FEEDBACK_ID,
				args);
		}

		if ((feedbackRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_FEEDBACK_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					feedbackRegistrationModelImpl.getOriginalPROJECT_FEEDBACK_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_FEEDBACK_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FEEDBACK_ID,
				args);
		}
	}

	/**
	 * Creates a new feedback registration with the primary key. Does not add the feedback registration to the database.
	 *
	 * @param PROJECT_FEEDBACK_ID the primary key for the new feedback registration
	 * @return the new feedback registration
	 */
	@Override
	public FeedbackRegistration create(long PROJECT_FEEDBACK_ID) {
		FeedbackRegistration feedbackRegistration = new FeedbackRegistrationImpl();

		feedbackRegistration.setNew(true);
		feedbackRegistration.setPrimaryKey(PROJECT_FEEDBACK_ID);

		String uuid = PortalUUIDUtil.generate();

		feedbackRegistration.setUuid(uuid);

		return feedbackRegistration;
	}

	/**
	 * Removes the feedback registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	 * @return the feedback registration that was removed
	 * @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	 */
	@Override
	public FeedbackRegistration remove(long PROJECT_FEEDBACK_ID)
		throws NoSuchFeedbackRegistrationException {
		return remove((Serializable)PROJECT_FEEDBACK_ID);
	}

	/**
	 * Removes the feedback registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feedback registration
	 * @return the feedback registration that was removed
	 * @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	 */
	@Override
	public FeedbackRegistration remove(Serializable primaryKey)
		throws NoSuchFeedbackRegistrationException {
		Session session = null;

		try {
			session = openSession();

			FeedbackRegistration feedbackRegistration = (FeedbackRegistration)session.get(FeedbackRegistrationImpl.class,
					primaryKey);

			if (feedbackRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeedbackRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(feedbackRegistration);
		}
		catch (NoSuchFeedbackRegistrationException nsee) {
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
	protected FeedbackRegistration removeImpl(
		FeedbackRegistration feedbackRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feedbackRegistration)) {
				feedbackRegistration = (FeedbackRegistration)session.get(FeedbackRegistrationImpl.class,
						feedbackRegistration.getPrimaryKeyObj());
			}

			if (feedbackRegistration != null) {
				session.delete(feedbackRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (feedbackRegistration != null) {
			clearCache(feedbackRegistration);
		}

		return feedbackRegistration;
	}

	@Override
	public FeedbackRegistration updateImpl(
		FeedbackRegistration feedbackRegistration) {
		boolean isNew = feedbackRegistration.isNew();

		if (!(feedbackRegistration instanceof FeedbackRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(feedbackRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(feedbackRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in feedbackRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FeedbackRegistration implementation " +
				feedbackRegistration.getClass());
		}

		FeedbackRegistrationModelImpl feedbackRegistrationModelImpl = (FeedbackRegistrationModelImpl)feedbackRegistration;

		if (Validator.isNull(feedbackRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			feedbackRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (feedbackRegistration.isNew()) {
				session.save(feedbackRegistration);

				feedbackRegistration.setNew(false);
			}
			else {
				feedbackRegistration = (FeedbackRegistration)session.merge(feedbackRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!FeedbackRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { feedbackRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { feedbackRegistrationModelImpl.getPROJECT_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((feedbackRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedbackRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { feedbackRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((feedbackRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedbackRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						feedbackRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackRegistrationImpl.class,
			feedbackRegistration.getPrimaryKey(), feedbackRegistration, false);

		clearUniqueFindersCache(feedbackRegistrationModelImpl, false);
		cacheUniqueFindersCache(feedbackRegistrationModelImpl);

		feedbackRegistration.resetOriginalValues();

		return feedbackRegistration;
	}

	/**
	 * Returns the feedback registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback registration
	 * @return the feedback registration
	 * @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	 */
	@Override
	public FeedbackRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeedbackRegistrationException {
		FeedbackRegistration feedbackRegistration = fetchByPrimaryKey(primaryKey);

		if (feedbackRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeedbackRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return feedbackRegistration;
	}

	/**
	 * Returns the feedback registration with the primary key or throws a {@link NoSuchFeedbackRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	 * @return the feedback registration
	 * @throws NoSuchFeedbackRegistrationException if a feedback registration with the primary key could not be found
	 */
	@Override
	public FeedbackRegistration findByPrimaryKey(long PROJECT_FEEDBACK_ID)
		throws NoSuchFeedbackRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_FEEDBACK_ID);
	}

	/**
	 * Returns the feedback registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback registration
	 * @return the feedback registration, or <code>null</code> if a feedback registration with the primary key could not be found
	 */
	@Override
	public FeedbackRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FeedbackRegistration feedbackRegistration = (FeedbackRegistration)serializable;

		if (feedbackRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				feedbackRegistration = (FeedbackRegistration)session.get(FeedbackRegistrationImpl.class,
						primaryKey);

				if (feedbackRegistration != null) {
					cacheResult(feedbackRegistration);
				}
				else {
					entityCache.putResult(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FeedbackRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return feedbackRegistration;
	}

	/**
	 * Returns the feedback registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_FEEDBACK_ID the primary key of the feedback registration
	 * @return the feedback registration, or <code>null</code> if a feedback registration with the primary key could not be found
	 */
	@Override
	public FeedbackRegistration fetchByPrimaryKey(long PROJECT_FEEDBACK_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_FEEDBACK_ID);
	}

	@Override
	public Map<Serializable, FeedbackRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FeedbackRegistration> map = new HashMap<Serializable, FeedbackRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FeedbackRegistration feedbackRegistration = fetchByPrimaryKey(primaryKey);

			if (feedbackRegistration != null) {
				map.put(primaryKey, feedbackRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FeedbackRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FeedbackRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FEEDBACKREGISTRATION_WHERE_PKS_IN);

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

			for (FeedbackRegistration feedbackRegistration : (List<FeedbackRegistration>)q.list()) {
				map.put(feedbackRegistration.getPrimaryKeyObj(),
					feedbackRegistration);

				cacheResult(feedbackRegistration);

				uncachedPrimaryKeys.remove(feedbackRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FeedbackRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FeedbackRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the feedback registrations.
	 *
	 * @return the feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedback registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedback registrations
	 * @param end the upper bound of the range of feedback registrations (not inclusive)
	 * @return the range of feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedback registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedback registrations
	 * @param end the upper bound of the range of feedback registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findAll(int start, int end,
		OrderByComparator<FeedbackRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedback registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedback registrations
	 * @param end the upper bound of the range of feedback registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of feedback registrations
	 */
	@Override
	public List<FeedbackRegistration> findAll(int start, int end,
		OrderByComparator<FeedbackRegistration> orderByComparator,
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

		List<FeedbackRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FeedbackRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FEEDBACKREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FEEDBACKREGISTRATION;

				if (pagination) {
					sql = sql.concat(FeedbackRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FeedbackRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FeedbackRegistration>)QueryUtil.list(q,
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
	 * Removes all the feedback registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FeedbackRegistration feedbackRegistration : findAll()) {
			remove(feedbackRegistration);
		}
	}

	/**
	 * Returns the number of feedback registrations.
	 *
	 * @return the number of feedback registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FEEDBACKREGISTRATION);

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
		return FeedbackRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the feedback registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FeedbackRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FEEDBACKREGISTRATION = "SELECT feedbackRegistration FROM FeedbackRegistration feedbackRegistration";
	private static final String _SQL_SELECT_FEEDBACKREGISTRATION_WHERE_PKS_IN = "SELECT feedbackRegistration FROM FeedbackRegistration feedbackRegistration WHERE PROJECT_FEEDBACK_ID IN (";
	private static final String _SQL_SELECT_FEEDBACKREGISTRATION_WHERE = "SELECT feedbackRegistration FROM FeedbackRegistration feedbackRegistration WHERE ";
	private static final String _SQL_COUNT_FEEDBACKREGISTRATION = "SELECT COUNT(feedbackRegistration) FROM FeedbackRegistration feedbackRegistration";
	private static final String _SQL_COUNT_FEEDBACKREGISTRATION_WHERE = "SELECT COUNT(feedbackRegistration) FROM FeedbackRegistration feedbackRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feedbackRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FeedbackRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FeedbackRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FeedbackRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}