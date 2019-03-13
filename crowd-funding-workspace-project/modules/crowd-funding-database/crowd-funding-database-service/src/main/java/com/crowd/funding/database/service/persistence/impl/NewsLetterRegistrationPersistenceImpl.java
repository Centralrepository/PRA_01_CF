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

import com.crowd.funding.database.exception.NoSuchNewsLetterRegistrationException;
import com.crowd.funding.database.model.NewsLetterRegistration;
import com.crowd.funding.database.model.impl.NewsLetterRegistrationImpl;
import com.crowd.funding.database.model.impl.NewsLetterRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.NewsLetterRegistrationPersistence;

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
 * The persistence implementation for the news letter registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.NewsLetterRegistrationUtil
 * @generated
 */
@ProviderType
public class NewsLetterRegistrationPersistenceImpl extends BasePersistenceImpl<NewsLetterRegistration>
	implements NewsLetterRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NewsLetterRegistrationUtil} to access the news letter registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NewsLetterRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			NewsLetterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			NewsLetterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			NewsLetterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			NewsLetterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			NewsLetterRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the news letter registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching news letter registrations
	 */
	@Override
	public List<NewsLetterRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news letter registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of news letter registrations
	 * @param end the upper bound of the range of news letter registrations (not inclusive)
	 * @return the range of matching news letter registrations
	 */
	@Override
	public List<NewsLetterRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the news letter registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of news letter registrations
	 * @param end the upper bound of the range of news letter registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news letter registrations
	 */
	@Override
	public List<NewsLetterRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<NewsLetterRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news letter registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of news letter registrations
	 * @param end the upper bound of the range of news letter registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching news letter registrations
	 */
	@Override
	public List<NewsLetterRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<NewsLetterRegistration> orderByComparator,
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

		List<NewsLetterRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<NewsLetterRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (NewsLetterRegistration newsLetterRegistration : list) {
					if (!Objects.equals(uuid, newsLetterRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_NEWSLETTERREGISTRATION_WHERE);

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
				query.append(NewsLetterRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<NewsLetterRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<NewsLetterRegistration>)QueryUtil.list(q,
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
	 * Returns the first news letter registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news letter registration
	 * @throws NoSuchNewsLetterRegistrationException if a matching news letter registration could not be found
	 */
	@Override
	public NewsLetterRegistration findByUuid_First(String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator)
		throws NoSuchNewsLetterRegistrationException {
		NewsLetterRegistration newsLetterRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (newsLetterRegistration != null) {
			return newsLetterRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchNewsLetterRegistrationException(msg.toString());
	}

	/**
	 * Returns the first news letter registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	 */
	@Override
	public NewsLetterRegistration fetchByUuid_First(String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator) {
		List<NewsLetterRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last news letter registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news letter registration
	 * @throws NoSuchNewsLetterRegistrationException if a matching news letter registration could not be found
	 */
	@Override
	public NewsLetterRegistration findByUuid_Last(String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator)
		throws NoSuchNewsLetterRegistrationException {
		NewsLetterRegistration newsLetterRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (newsLetterRegistration != null) {
			return newsLetterRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchNewsLetterRegistrationException(msg.toString());
	}

	/**
	 * Returns the last news letter registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	 */
	@Override
	public NewsLetterRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<NewsLetterRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the news letter registrations before and after the current news letter registration in the ordered set where uuid = &#63;.
	 *
	 * @param NEWS_LETTER_ID the primary key of the current news letter registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news letter registration
	 * @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	 */
	@Override
	public NewsLetterRegistration[] findByUuid_PrevAndNext(
		long NEWS_LETTER_ID, String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator)
		throws NoSuchNewsLetterRegistrationException {
		NewsLetterRegistration newsLetterRegistration = findByPrimaryKey(NEWS_LETTER_ID);

		Session session = null;

		try {
			session = openSession();

			NewsLetterRegistration[] array = new NewsLetterRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, newsLetterRegistration,
					uuid, orderByComparator, true);

			array[1] = newsLetterRegistration;

			array[2] = getByUuid_PrevAndNext(session, newsLetterRegistration,
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

	protected NewsLetterRegistration getByUuid_PrevAndNext(Session session,
		NewsLetterRegistration newsLetterRegistration, String uuid,
		OrderByComparator<NewsLetterRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_NEWSLETTERREGISTRATION_WHERE);

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
			query.append(NewsLetterRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(newsLetterRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NewsLetterRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the news letter registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (NewsLetterRegistration newsLetterRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(newsLetterRegistration);
		}
	}

	/**
	 * Returns the number of news letter registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching news letter registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NEWSLETTERREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "newsLetterRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "newsLetterRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(newsLetterRegistration.uuid IS NULL OR newsLetterRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NEWS_LETTER_ID = new FinderPath(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			NewsLetterRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByNEWS_LETTER_ID", new String[] { Long.class.getName() },
			NewsLetterRegistrationModelImpl.NEWS_LETTER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NEWS_LETTER_ID = new FinderPath(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNEWS_LETTER_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the news letter registration where NEWS_LETTER_ID = &#63; or throws a {@link NoSuchNewsLetterRegistrationException} if it could not be found.
	 *
	 * @param NEWS_LETTER_ID the news_letter_id
	 * @return the matching news letter registration
	 * @throws NoSuchNewsLetterRegistrationException if a matching news letter registration could not be found
	 */
	@Override
	public NewsLetterRegistration findByNEWS_LETTER_ID(long NEWS_LETTER_ID)
		throws NoSuchNewsLetterRegistrationException {
		NewsLetterRegistration newsLetterRegistration = fetchByNEWS_LETTER_ID(NEWS_LETTER_ID);

		if (newsLetterRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("NEWS_LETTER_ID=");
			msg.append(NEWS_LETTER_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchNewsLetterRegistrationException(msg.toString());
		}

		return newsLetterRegistration;
	}

	/**
	 * Returns the news letter registration where NEWS_LETTER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param NEWS_LETTER_ID the news_letter_id
	 * @return the matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	 */
	@Override
	public NewsLetterRegistration fetchByNEWS_LETTER_ID(long NEWS_LETTER_ID) {
		return fetchByNEWS_LETTER_ID(NEWS_LETTER_ID, true);
	}

	/**
	 * Returns the news letter registration where NEWS_LETTER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param NEWS_LETTER_ID the news_letter_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching news letter registration, or <code>null</code> if a matching news letter registration could not be found
	 */
	@Override
	public NewsLetterRegistration fetchByNEWS_LETTER_ID(long NEWS_LETTER_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { NEWS_LETTER_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_NEWS_LETTER_ID,
					finderArgs, this);
		}

		if (result instanceof NewsLetterRegistration) {
			NewsLetterRegistration newsLetterRegistration = (NewsLetterRegistration)result;

			if ((NEWS_LETTER_ID != newsLetterRegistration.getNEWS_LETTER_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_NEWSLETTERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_NEWS_LETTER_ID_NEWS_LETTER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(NEWS_LETTER_ID);

				List<NewsLetterRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_NEWS_LETTER_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"NewsLetterRegistrationPersistenceImpl.fetchByNEWS_LETTER_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					NewsLetterRegistration newsLetterRegistration = list.get(0);

					result = newsLetterRegistration;

					cacheResult(newsLetterRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_NEWS_LETTER_ID,
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
			return (NewsLetterRegistration)result;
		}
	}

	/**
	 * Removes the news letter registration where NEWS_LETTER_ID = &#63; from the database.
	 *
	 * @param NEWS_LETTER_ID the news_letter_id
	 * @return the news letter registration that was removed
	 */
	@Override
	public NewsLetterRegistration removeByNEWS_LETTER_ID(long NEWS_LETTER_ID)
		throws NoSuchNewsLetterRegistrationException {
		NewsLetterRegistration newsLetterRegistration = findByNEWS_LETTER_ID(NEWS_LETTER_ID);

		return remove(newsLetterRegistration);
	}

	/**
	 * Returns the number of news letter registrations where NEWS_LETTER_ID = &#63;.
	 *
	 * @param NEWS_LETTER_ID the news_letter_id
	 * @return the number of matching news letter registrations
	 */
	@Override
	public int countByNEWS_LETTER_ID(long NEWS_LETTER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NEWS_LETTER_ID;

		Object[] finderArgs = new Object[] { NEWS_LETTER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NEWSLETTERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_NEWS_LETTER_ID_NEWS_LETTER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(NEWS_LETTER_ID);

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

	private static final String _FINDER_COLUMN_NEWS_LETTER_ID_NEWS_LETTER_ID_2 = "newsLetterRegistration.NEWS_LETTER_ID = ?";

	public NewsLetterRegistrationPersistenceImpl() {
		setModelClass(NewsLetterRegistration.class);

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
	 * Caches the news letter registration in the entity cache if it is enabled.
	 *
	 * @param newsLetterRegistration the news letter registration
	 */
	@Override
	public void cacheResult(NewsLetterRegistration newsLetterRegistration) {
		entityCache.putResult(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationImpl.class,
			newsLetterRegistration.getPrimaryKey(), newsLetterRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_NEWS_LETTER_ID,
			new Object[] { newsLetterRegistration.getNEWS_LETTER_ID() },
			newsLetterRegistration);

		newsLetterRegistration.resetOriginalValues();
	}

	/**
	 * Caches the news letter registrations in the entity cache if it is enabled.
	 *
	 * @param newsLetterRegistrations the news letter registrations
	 */
	@Override
	public void cacheResult(
		List<NewsLetterRegistration> newsLetterRegistrations) {
		for (NewsLetterRegistration newsLetterRegistration : newsLetterRegistrations) {
			if (entityCache.getResult(
						NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						NewsLetterRegistrationImpl.class,
						newsLetterRegistration.getPrimaryKey()) == null) {
				cacheResult(newsLetterRegistration);
			}
			else {
				newsLetterRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all news letter registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NewsLetterRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news letter registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NewsLetterRegistration newsLetterRegistration) {
		entityCache.removeResult(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationImpl.class,
			newsLetterRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((NewsLetterRegistrationModelImpl)newsLetterRegistration,
			true);
	}

	@Override
	public void clearCache(List<NewsLetterRegistration> newsLetterRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NewsLetterRegistration newsLetterRegistration : newsLetterRegistrations) {
			entityCache.removeResult(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				NewsLetterRegistrationImpl.class,
				newsLetterRegistration.getPrimaryKey());

			clearUniqueFindersCache((NewsLetterRegistrationModelImpl)newsLetterRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		NewsLetterRegistrationModelImpl newsLetterRegistrationModelImpl) {
		Object[] args = new Object[] {
				newsLetterRegistrationModelImpl.getNEWS_LETTER_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_NEWS_LETTER_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_NEWS_LETTER_ID, args,
			newsLetterRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		NewsLetterRegistrationModelImpl newsLetterRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					newsLetterRegistrationModelImpl.getNEWS_LETTER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NEWS_LETTER_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NEWS_LETTER_ID, args);
		}

		if ((newsLetterRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NEWS_LETTER_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					newsLetterRegistrationModelImpl.getOriginalNEWS_LETTER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NEWS_LETTER_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NEWS_LETTER_ID, args);
		}
	}

	/**
	 * Creates a new news letter registration with the primary key. Does not add the news letter registration to the database.
	 *
	 * @param NEWS_LETTER_ID the primary key for the new news letter registration
	 * @return the new news letter registration
	 */
	@Override
	public NewsLetterRegistration create(long NEWS_LETTER_ID) {
		NewsLetterRegistration newsLetterRegistration = new NewsLetterRegistrationImpl();

		newsLetterRegistration.setNew(true);
		newsLetterRegistration.setPrimaryKey(NEWS_LETTER_ID);

		String uuid = PortalUUIDUtil.generate();

		newsLetterRegistration.setUuid(uuid);

		return newsLetterRegistration;
	}

	/**
	 * Removes the news letter registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param NEWS_LETTER_ID the primary key of the news letter registration
	 * @return the news letter registration that was removed
	 * @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	 */
	@Override
	public NewsLetterRegistration remove(long NEWS_LETTER_ID)
		throws NoSuchNewsLetterRegistrationException {
		return remove((Serializable)NEWS_LETTER_ID);
	}

	/**
	 * Removes the news letter registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news letter registration
	 * @return the news letter registration that was removed
	 * @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	 */
	@Override
	public NewsLetterRegistration remove(Serializable primaryKey)
		throws NoSuchNewsLetterRegistrationException {
		Session session = null;

		try {
			session = openSession();

			NewsLetterRegistration newsLetterRegistration = (NewsLetterRegistration)session.get(NewsLetterRegistrationImpl.class,
					primaryKey);

			if (newsLetterRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewsLetterRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(newsLetterRegistration);
		}
		catch (NoSuchNewsLetterRegistrationException nsee) {
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
	protected NewsLetterRegistration removeImpl(
		NewsLetterRegistration newsLetterRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(newsLetterRegistration)) {
				newsLetterRegistration = (NewsLetterRegistration)session.get(NewsLetterRegistrationImpl.class,
						newsLetterRegistration.getPrimaryKeyObj());
			}

			if (newsLetterRegistration != null) {
				session.delete(newsLetterRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (newsLetterRegistration != null) {
			clearCache(newsLetterRegistration);
		}

		return newsLetterRegistration;
	}

	@Override
	public NewsLetterRegistration updateImpl(
		NewsLetterRegistration newsLetterRegistration) {
		boolean isNew = newsLetterRegistration.isNew();

		if (!(newsLetterRegistration instanceof NewsLetterRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(newsLetterRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(newsLetterRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in newsLetterRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom NewsLetterRegistration implementation " +
				newsLetterRegistration.getClass());
		}

		NewsLetterRegistrationModelImpl newsLetterRegistrationModelImpl = (NewsLetterRegistrationModelImpl)newsLetterRegistration;

		if (Validator.isNull(newsLetterRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			newsLetterRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (newsLetterRegistration.isNew()) {
				session.save(newsLetterRegistration);

				newsLetterRegistration.setNew(false);
			}
			else {
				session.evict(newsLetterRegistration);
				session.saveOrUpdate(newsLetterRegistration);
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

		if (!NewsLetterRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					newsLetterRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((newsLetterRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						newsLetterRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { newsLetterRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			NewsLetterRegistrationImpl.class,
			newsLetterRegistration.getPrimaryKey(), newsLetterRegistration,
			false);

		clearUniqueFindersCache(newsLetterRegistrationModelImpl, false);
		cacheUniqueFindersCache(newsLetterRegistrationModelImpl);

		newsLetterRegistration.resetOriginalValues();

		return newsLetterRegistration;
	}

	/**
	 * Returns the news letter registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the news letter registration
	 * @return the news letter registration
	 * @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	 */
	@Override
	public NewsLetterRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNewsLetterRegistrationException {
		NewsLetterRegistration newsLetterRegistration = fetchByPrimaryKey(primaryKey);

		if (newsLetterRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNewsLetterRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return newsLetterRegistration;
	}

	/**
	 * Returns the news letter registration with the primary key or throws a {@link NoSuchNewsLetterRegistrationException} if it could not be found.
	 *
	 * @param NEWS_LETTER_ID the primary key of the news letter registration
	 * @return the news letter registration
	 * @throws NoSuchNewsLetterRegistrationException if a news letter registration with the primary key could not be found
	 */
	@Override
	public NewsLetterRegistration findByPrimaryKey(long NEWS_LETTER_ID)
		throws NoSuchNewsLetterRegistrationException {
		return findByPrimaryKey((Serializable)NEWS_LETTER_ID);
	}

	/**
	 * Returns the news letter registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news letter registration
	 * @return the news letter registration, or <code>null</code> if a news letter registration with the primary key could not be found
	 */
	@Override
	public NewsLetterRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				NewsLetterRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		NewsLetterRegistration newsLetterRegistration = (NewsLetterRegistration)serializable;

		if (newsLetterRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				newsLetterRegistration = (NewsLetterRegistration)session.get(NewsLetterRegistrationImpl.class,
						primaryKey);

				if (newsLetterRegistration != null) {
					cacheResult(newsLetterRegistration);
				}
				else {
					entityCache.putResult(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						NewsLetterRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					NewsLetterRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return newsLetterRegistration;
	}

	/**
	 * Returns the news letter registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param NEWS_LETTER_ID the primary key of the news letter registration
	 * @return the news letter registration, or <code>null</code> if a news letter registration with the primary key could not be found
	 */
	@Override
	public NewsLetterRegistration fetchByPrimaryKey(long NEWS_LETTER_ID) {
		return fetchByPrimaryKey((Serializable)NEWS_LETTER_ID);
	}

	@Override
	public Map<Serializable, NewsLetterRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, NewsLetterRegistration> map = new HashMap<Serializable, NewsLetterRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			NewsLetterRegistration newsLetterRegistration = fetchByPrimaryKey(primaryKey);

			if (newsLetterRegistration != null) {
				map.put(primaryKey, newsLetterRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					NewsLetterRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (NewsLetterRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_NEWSLETTERREGISTRATION_WHERE_PKS_IN);

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

			for (NewsLetterRegistration newsLetterRegistration : (List<NewsLetterRegistration>)q.list()) {
				map.put(newsLetterRegistration.getPrimaryKeyObj(),
					newsLetterRegistration);

				cacheResult(newsLetterRegistration);

				uncachedPrimaryKeys.remove(newsLetterRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(NewsLetterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					NewsLetterRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the news letter registrations.
	 *
	 * @return the news letter registrations
	 */
	@Override
	public List<NewsLetterRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news letter registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of news letter registrations
	 * @param end the upper bound of the range of news letter registrations (not inclusive)
	 * @return the range of news letter registrations
	 */
	@Override
	public List<NewsLetterRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news letter registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of news letter registrations
	 * @param end the upper bound of the range of news letter registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news letter registrations
	 */
	@Override
	public List<NewsLetterRegistration> findAll(int start, int end,
		OrderByComparator<NewsLetterRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news letter registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsLetterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of news letter registrations
	 * @param end the upper bound of the range of news letter registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of news letter registrations
	 */
	@Override
	public List<NewsLetterRegistration> findAll(int start, int end,
		OrderByComparator<NewsLetterRegistration> orderByComparator,
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

		List<NewsLetterRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<NewsLetterRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NEWSLETTERREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NEWSLETTERREGISTRATION;

				if (pagination) {
					sql = sql.concat(NewsLetterRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NewsLetterRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<NewsLetterRegistration>)QueryUtil.list(q,
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
	 * Removes all the news letter registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NewsLetterRegistration newsLetterRegistration : findAll()) {
			remove(newsLetterRegistration);
		}
	}

	/**
	 * Returns the number of news letter registrations.
	 *
	 * @return the number of news letter registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NEWSLETTERREGISTRATION);

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
		return NewsLetterRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news letter registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(NewsLetterRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_NEWSLETTERREGISTRATION = "SELECT newsLetterRegistration FROM NewsLetterRegistration newsLetterRegistration";
	private static final String _SQL_SELECT_NEWSLETTERREGISTRATION_WHERE_PKS_IN = "SELECT newsLetterRegistration FROM NewsLetterRegistration newsLetterRegistration WHERE NEWS_LETTER_ID IN (";
	private static final String _SQL_SELECT_NEWSLETTERREGISTRATION_WHERE = "SELECT newsLetterRegistration FROM NewsLetterRegistration newsLetterRegistration WHERE ";
	private static final String _SQL_COUNT_NEWSLETTERREGISTRATION = "SELECT COUNT(newsLetterRegistration) FROM NewsLetterRegistration newsLetterRegistration";
	private static final String _SQL_COUNT_NEWSLETTERREGISTRATION_WHERE = "SELECT COUNT(newsLetterRegistration) FROM NewsLetterRegistration newsLetterRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "newsLetterRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NewsLetterRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NewsLetterRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(NewsLetterRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}