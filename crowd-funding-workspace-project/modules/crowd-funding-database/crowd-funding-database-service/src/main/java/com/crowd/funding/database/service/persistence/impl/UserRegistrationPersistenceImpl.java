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

import com.crowd.funding.database.exception.NoSuchUserRegistrationException;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.model.impl.UserRegistrationImpl;
import com.crowd.funding.database.model.impl.UserRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.UserRegistrationPersistence;

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
 * The persistence implementation for the user registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.UserRegistrationUtil
 * @generated
 */
@ProviderType
public class UserRegistrationPersistenceImpl extends BasePersistenceImpl<UserRegistration>
	implements UserRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserRegistrationUtil} to access the user registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserRegistrationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserRegistrationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user registrations
	 */
	@Override
	public List<UserRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @return the range of matching user registrations
	 */
	@Override
	public List<UserRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user registrations
	 */
	@Override
	public List<UserRegistration> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user registrations
	 */
	@Override
	public List<UserRegistration> findByUuid(String uuid, int start, int end,
		OrderByComparator<UserRegistration> orderByComparator,
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

		List<UserRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UserRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserRegistration userRegistration : list) {
					if (!Objects.equals(uuid, userRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_USERREGISTRATION_WHERE);

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
				query.append(UserRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserRegistration>)QueryUtil.list(q,
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
	 * Returns the first user registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration
	 * @throws NoSuchUserRegistrationException if a matching user registration could not be found
	 */
	@Override
	public UserRegistration findByUuid_First(String uuid,
		OrderByComparator<UserRegistration> orderByComparator)
		throws NoSuchUserRegistrationException {
		UserRegistration userRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (userRegistration != null) {
			return userRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserRegistrationException(msg.toString());
	}

	/**
	 * Returns the first user registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user registration, or <code>null</code> if a matching user registration could not be found
	 */
	@Override
	public UserRegistration fetchByUuid_First(String uuid,
		OrderByComparator<UserRegistration> orderByComparator) {
		List<UserRegistration> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration
	 * @throws NoSuchUserRegistrationException if a matching user registration could not be found
	 */
	@Override
	public UserRegistration findByUuid_Last(String uuid,
		OrderByComparator<UserRegistration> orderByComparator)
		throws NoSuchUserRegistrationException {
		UserRegistration userRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (userRegistration != null) {
			return userRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserRegistrationException(msg.toString());
	}

	/**
	 * Returns the last user registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user registration, or <code>null</code> if a matching user registration could not be found
	 */
	@Override
	public UserRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<UserRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user registrations before and after the current user registration in the ordered set where uuid = &#63;.
	 *
	 * @param USER_ID the primary key of the current user registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user registration
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration[] findByUuid_PrevAndNext(long USER_ID, String uuid,
		OrderByComparator<UserRegistration> orderByComparator)
		throws NoSuchUserRegistrationException {
		UserRegistration userRegistration = findByPrimaryKey(USER_ID);

		Session session = null;

		try {
			session = openSession();

			UserRegistration[] array = new UserRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userRegistration, uuid,
					orderByComparator, true);

			array[1] = userRegistration;

			array[2] = getByUuid_PrevAndNext(session, userRegistration, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserRegistration getByUuid_PrevAndNext(Session session,
		UserRegistration userRegistration, String uuid,
		OrderByComparator<UserRegistration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERREGISTRATION_WHERE);

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
			query.append(UserRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(userRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserRegistration userRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userRegistration);
		}
	}

	/**
	 * Returns the number of user registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userRegistration.uuid IS NULL OR userRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USER_ID = new FinderPath(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUSER_ID", new String[] { Long.class.getName() },
			UserRegistrationModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_ID = new FinderPath(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSER_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user registration where USER_ID = &#63; or throws a {@link NoSuchUserRegistrationException} if it could not be found.
	 *
	 * @param USER_ID the user_id
	 * @return the matching user registration
	 * @throws NoSuchUserRegistrationException if a matching user registration could not be found
	 */
	@Override
	public UserRegistration findByUSER_ID(long USER_ID)
		throws NoSuchUserRegistrationException {
		UserRegistration userRegistration = fetchByUSER_ID(USER_ID);

		if (userRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("USER_ID=");
			msg.append(USER_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserRegistrationException(msg.toString());
		}

		return userRegistration;
	}

	/**
	 * Returns the user registration where USER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param USER_ID the user_id
	 * @return the matching user registration, or <code>null</code> if a matching user registration could not be found
	 */
	@Override
	public UserRegistration fetchByUSER_ID(long USER_ID) {
		return fetchByUSER_ID(USER_ID, true);
	}

	/**
	 * Returns the user registration where USER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param USER_ID the user_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user registration, or <code>null</code> if a matching user registration could not be found
	 */
	@Override
	public UserRegistration fetchByUSER_ID(long USER_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { USER_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USER_ID,
					finderArgs, this);
		}

		if (result instanceof UserRegistration) {
			UserRegistration userRegistration = (UserRegistration)result;

			if ((USER_ID != userRegistration.getUSER_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_ID);

				List<UserRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USER_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserRegistrationPersistenceImpl.fetchByUSER_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserRegistration userRegistration = list.get(0);

					result = userRegistration;

					cacheResult(userRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USER_ID,
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
			return (UserRegistration)result;
		}
	}

	/**
	 * Removes the user registration where USER_ID = &#63; from the database.
	 *
	 * @param USER_ID the user_id
	 * @return the user registration that was removed
	 */
	@Override
	public UserRegistration removeByUSER_ID(long USER_ID)
		throws NoSuchUserRegistrationException {
		UserRegistration userRegistration = findByUSER_ID(USER_ID);

		return remove(userRegistration);
	}

	/**
	 * Returns the number of user registrations where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @return the number of matching user registrations
	 */
	@Override
	public int countByUSER_ID(long USER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER_ID;

		Object[] finderArgs = new Object[] { USER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_ID);

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

	private static final String _FINDER_COLUMN_USER_ID_USER_ID_2 = "userRegistration.USER_ID = ?";

	public UserRegistrationPersistenceImpl() {
		setModelClass(UserRegistration.class);

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
	 * Caches the user registration in the entity cache if it is enabled.
	 *
	 * @param userRegistration the user registration
	 */
	@Override
	public void cacheResult(UserRegistration userRegistration) {
		entityCache.putResult(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationImpl.class, userRegistration.getPrimaryKey(),
			userRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USER_ID,
			new Object[] { userRegistration.getUSER_ID() }, userRegistration);

		userRegistration.resetOriginalValues();
	}

	/**
	 * Caches the user registrations in the entity cache if it is enabled.
	 *
	 * @param userRegistrations the user registrations
	 */
	@Override
	public void cacheResult(List<UserRegistration> userRegistrations) {
		for (UserRegistration userRegistration : userRegistrations) {
			if (entityCache.getResult(
						UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						UserRegistrationImpl.class,
						userRegistration.getPrimaryKey()) == null) {
				cacheResult(userRegistration);
			}
			else {
				userRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserRegistration userRegistration) {
		entityCache.removeResult(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationImpl.class, userRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserRegistrationModelImpl)userRegistration,
			true);
	}

	@Override
	public void clearCache(List<UserRegistration> userRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserRegistration userRegistration : userRegistrations) {
			entityCache.removeResult(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				UserRegistrationImpl.class, userRegistration.getPrimaryKey());

			clearUniqueFindersCache((UserRegistrationModelImpl)userRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		UserRegistrationModelImpl userRegistrationModelImpl) {
		Object[] args = new Object[] { userRegistrationModelImpl.getUSER_ID() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_USER_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_USER_ID, args,
			userRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserRegistrationModelImpl userRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { userRegistrationModelImpl.getUSER_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USER_ID, args);
		}

		if ((userRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USER_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userRegistrationModelImpl.getOriginalUSER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USER_ID, args);
		}
	}

	/**
	 * Creates a new user registration with the primary key. Does not add the user registration to the database.
	 *
	 * @param USER_ID the primary key for the new user registration
	 * @return the new user registration
	 */
	@Override
	public UserRegistration create(long USER_ID) {
		UserRegistration userRegistration = new UserRegistrationImpl();

		userRegistration.setNew(true);
		userRegistration.setPrimaryKey(USER_ID);

		String uuid = PortalUUIDUtil.generate();

		userRegistration.setUuid(uuid);

		return userRegistration;
	}

	/**
	 * Removes the user registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param USER_ID the primary key of the user registration
	 * @return the user registration that was removed
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration remove(long USER_ID)
		throws NoSuchUserRegistrationException {
		return remove((Serializable)USER_ID);
	}

	/**
	 * Removes the user registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user registration
	 * @return the user registration that was removed
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration remove(Serializable primaryKey)
		throws NoSuchUserRegistrationException {
		Session session = null;

		try {
			session = openSession();

			UserRegistration userRegistration = (UserRegistration)session.get(UserRegistrationImpl.class,
					primaryKey);

			if (userRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userRegistration);
		}
		catch (NoSuchUserRegistrationException nsee) {
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
	protected UserRegistration removeImpl(UserRegistration userRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userRegistration)) {
				userRegistration = (UserRegistration)session.get(UserRegistrationImpl.class,
						userRegistration.getPrimaryKeyObj());
			}

			if (userRegistration != null) {
				session.delete(userRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userRegistration != null) {
			clearCache(userRegistration);
		}

		return userRegistration;
	}

	@Override
	public UserRegistration updateImpl(UserRegistration userRegistration) {
		boolean isNew = userRegistration.isNew();

		if (!(userRegistration instanceof UserRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserRegistration implementation " +
				userRegistration.getClass());
		}

		UserRegistrationModelImpl userRegistrationModelImpl = (UserRegistrationModelImpl)userRegistration;

		if (Validator.isNull(userRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (userRegistration.isNew()) {
				session.save(userRegistration);

				userRegistration.setNew(false);
			}
			else {
				userRegistration = (UserRegistration)session.merge(userRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!UserRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { userRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((userRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserRegistrationImpl.class, userRegistration.getPrimaryKey(),
			userRegistration, false);

		clearUniqueFindersCache(userRegistrationModelImpl, false);
		cacheUniqueFindersCache(userRegistrationModelImpl);

		userRegistration.resetOriginalValues();

		return userRegistration;
	}

	/**
	 * Returns the user registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user registration
	 * @return the user registration
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserRegistrationException {
		UserRegistration userRegistration = fetchByPrimaryKey(primaryKey);

		if (userRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userRegistration;
	}

	/**
	 * Returns the user registration with the primary key or throws a {@link NoSuchUserRegistrationException} if it could not be found.
	 *
	 * @param USER_ID the primary key of the user registration
	 * @return the user registration
	 * @throws NoSuchUserRegistrationException if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration findByPrimaryKey(long USER_ID)
		throws NoSuchUserRegistrationException {
		return findByPrimaryKey((Serializable)USER_ID);
	}

	/**
	 * Returns the user registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user registration
	 * @return the user registration, or <code>null</code> if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				UserRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserRegistration userRegistration = (UserRegistration)serializable;

		if (userRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				userRegistration = (UserRegistration)session.get(UserRegistrationImpl.class,
						primaryKey);

				if (userRegistration != null) {
					cacheResult(userRegistration);
				}
				else {
					entityCache.putResult(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						UserRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UserRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userRegistration;
	}

	/**
	 * Returns the user registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param USER_ID the primary key of the user registration
	 * @return the user registration, or <code>null</code> if a user registration with the primary key could not be found
	 */
	@Override
	public UserRegistration fetchByPrimaryKey(long USER_ID) {
		return fetchByPrimaryKey((Serializable)USER_ID);
	}

	@Override
	public Map<Serializable, UserRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserRegistration> map = new HashMap<Serializable, UserRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserRegistration userRegistration = fetchByPrimaryKey(primaryKey);

			if (userRegistration != null) {
				map.put(primaryKey, userRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UserRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERREGISTRATION_WHERE_PKS_IN);

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

			for (UserRegistration userRegistration : (List<UserRegistration>)q.list()) {
				map.put(userRegistration.getPrimaryKeyObj(), userRegistration);

				cacheResult(userRegistration);

				uncachedPrimaryKeys.remove(userRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UserRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the user registrations.
	 *
	 * @return the user registrations
	 */
	@Override
	public List<UserRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @return the range of user registrations
	 */
	@Override
	public List<UserRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user registrations
	 */
	@Override
	public List<UserRegistration> findAll(int start, int end,
		OrderByComparator<UserRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user registrations
	 * @param end the upper bound of the range of user registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user registrations
	 */
	@Override
	public List<UserRegistration> findAll(int start, int end,
		OrderByComparator<UserRegistration> orderByComparator,
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

		List<UserRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UserRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERREGISTRATION;

				if (pagination) {
					sql = sql.concat(UserRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserRegistration>)QueryUtil.list(q,
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
	 * Removes all the user registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserRegistration userRegistration : findAll()) {
			remove(userRegistration);
		}
	}

	/**
	 * Returns the number of user registrations.
	 *
	 * @return the number of user registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERREGISTRATION);

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
		return UserRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERREGISTRATION = "SELECT userRegistration FROM UserRegistration userRegistration";
	private static final String _SQL_SELECT_USERREGISTRATION_WHERE_PKS_IN = "SELECT userRegistration FROM UserRegistration userRegistration WHERE USER_ID IN (";
	private static final String _SQL_SELECT_USERREGISTRATION_WHERE = "SELECT userRegistration FROM UserRegistration userRegistration WHERE ";
	private static final String _SQL_COUNT_USERREGISTRATION = "SELECT COUNT(userRegistration) FROM UserRegistration userRegistration";
	private static final String _SQL_COUNT_USERREGISTRATION_WHERE = "SELECT COUNT(userRegistration) FROM UserRegistration userRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}