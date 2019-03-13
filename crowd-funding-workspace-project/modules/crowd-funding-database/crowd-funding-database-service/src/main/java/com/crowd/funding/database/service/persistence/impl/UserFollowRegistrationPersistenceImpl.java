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

import com.crowd.funding.database.exception.NoSuchUserFollowRegistrationException;
import com.crowd.funding.database.model.UserFollowRegistration;
import com.crowd.funding.database.model.impl.UserFollowRegistrationImpl;
import com.crowd.funding.database.model.impl.UserFollowRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.UserFollowRegistrationPersistence;

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
 * The persistence implementation for the user follow registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFollowRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.UserFollowRegistrationUtil
 * @generated
 */
@ProviderType
public class UserFollowRegistrationPersistenceImpl extends BasePersistenceImpl<UserFollowRegistration>
	implements UserFollowRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserFollowRegistrationUtil} to access the user follow registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserFollowRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserFollowRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user follow registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user follow registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @return the range of matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user follow registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<UserFollowRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user follow registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<UserFollowRegistration> orderByComparator,
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

		List<UserFollowRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UserFollowRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserFollowRegistration userFollowRegistration : list) {
					if (!Objects.equals(uuid, userFollowRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_USERFOLLOWREGISTRATION_WHERE);

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
				query.append(UserFollowRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserFollowRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserFollowRegistration>)QueryUtil.list(q,
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
	 * Returns the first user follow registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration findByUuid_First(String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (userFollowRegistration != null) {
			return userFollowRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserFollowRegistrationException(msg.toString());
	}

	/**
	 * Returns the first user follow registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration fetchByUuid_First(String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		List<UserFollowRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user follow registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration findByUuid_Last(String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (userFollowRegistration != null) {
			return userFollowRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserFollowRegistrationException(msg.toString());
	}

	/**
	 * Returns the last user follow registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserFollowRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user follow registrations before and after the current user follow registration in the ordered set where uuid = &#63;.
	 *
	 * @param USER_FOLLOW_ID the primary key of the current user follow registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	 */
	@Override
	public UserFollowRegistration[] findByUuid_PrevAndNext(
		long USER_FOLLOW_ID, String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = findByPrimaryKey(USER_FOLLOW_ID);

		Session session = null;

		try {
			session = openSession();

			UserFollowRegistration[] array = new UserFollowRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userFollowRegistration,
					uuid, orderByComparator, true);

			array[1] = userFollowRegistration;

			array[2] = getByUuid_PrevAndNext(session, userFollowRegistration,
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

	protected UserFollowRegistration getByUuid_PrevAndNext(Session session,
		UserFollowRegistration userFollowRegistration, String uuid,
		OrderByComparator<UserFollowRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_USERFOLLOWREGISTRATION_WHERE);

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
			query.append(UserFollowRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(userFollowRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserFollowRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user follow registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserFollowRegistration userFollowRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userFollowRegistration);
		}
	}

	/**
	 * Returns the number of user follow registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user follow registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERFOLLOWREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userFollowRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userFollowRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userFollowRegistration.uuid IS NULL OR userFollowRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USER_FOLLOW_ID = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserFollowRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUSER_FOLLOW_ID", new String[] { Long.class.getName() },
			UserFollowRegistrationModelImpl.USER_FOLLOW_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_FOLLOW_ID = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSER_FOLLOW_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user follow registration where USER_FOLLOW_ID = &#63; or throws a {@link NoSuchUserFollowRegistrationException} if it could not be found.
	 *
	 * @param USER_FOLLOW_ID the user_follow_id
	 * @return the matching user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration findByUSER_FOLLOW_ID(long USER_FOLLOW_ID)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = fetchByUSER_FOLLOW_ID(USER_FOLLOW_ID);

		if (userFollowRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("USER_FOLLOW_ID=");
			msg.append(USER_FOLLOW_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserFollowRegistrationException(msg.toString());
		}

		return userFollowRegistration;
	}

	/**
	 * Returns the user follow registration where USER_FOLLOW_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param USER_FOLLOW_ID the user_follow_id
	 * @return the matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration fetchByUSER_FOLLOW_ID(long USER_FOLLOW_ID) {
		return fetchByUSER_FOLLOW_ID(USER_FOLLOW_ID, true);
	}

	/**
	 * Returns the user follow registration where USER_FOLLOW_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param USER_FOLLOW_ID the user_follow_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration fetchByUSER_FOLLOW_ID(long USER_FOLLOW_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { USER_FOLLOW_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USER_FOLLOW_ID,
					finderArgs, this);
		}

		if (result instanceof UserFollowRegistration) {
			UserFollowRegistration userFollowRegistration = (UserFollowRegistration)result;

			if ((USER_FOLLOW_ID != userFollowRegistration.getUSER_FOLLOW_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERFOLLOWREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_FOLLOW_ID_USER_FOLLOW_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_FOLLOW_ID);

				List<UserFollowRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USER_FOLLOW_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserFollowRegistrationPersistenceImpl.fetchByUSER_FOLLOW_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserFollowRegistration userFollowRegistration = list.get(0);

					result = userFollowRegistration;

					cacheResult(userFollowRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USER_FOLLOW_ID,
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
			return (UserFollowRegistration)result;
		}
	}

	/**
	 * Removes the user follow registration where USER_FOLLOW_ID = &#63; from the database.
	 *
	 * @param USER_FOLLOW_ID the user_follow_id
	 * @return the user follow registration that was removed
	 */
	@Override
	public UserFollowRegistration removeByUSER_FOLLOW_ID(long USER_FOLLOW_ID)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = findByUSER_FOLLOW_ID(USER_FOLLOW_ID);

		return remove(userFollowRegistration);
	}

	/**
	 * Returns the number of user follow registrations where USER_FOLLOW_ID = &#63;.
	 *
	 * @param USER_FOLLOW_ID the user_follow_id
	 * @return the number of matching user follow registrations
	 */
	@Override
	public int countByUSER_FOLLOW_ID(long USER_FOLLOW_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER_FOLLOW_ID;

		Object[] finderArgs = new Object[] { USER_FOLLOW_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERFOLLOWREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_FOLLOW_ID_USER_FOLLOW_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_FOLLOW_ID);

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

	private static final String _FINDER_COLUMN_USER_FOLLOW_ID_USER_FOLLOW_ID_2 = "userFollowRegistration.USER_FOLLOW_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_ID = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUSER_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID =
		new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUSER_ID",
			new String[] { Long.class.getName() },
			UserFollowRegistrationModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_ID = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSER_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user follow registrations where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @return the matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByUSER_ID(long USER_ID) {
		return findByUSER_ID(USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user follow registrations where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the user_id
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @return the range of matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByUSER_ID(long USER_ID, int start,
		int end) {
		return findByUSER_ID(USER_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user follow registrations where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the user_id
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByUSER_ID(long USER_ID, int start,
		int end, OrderByComparator<UserFollowRegistration> orderByComparator) {
		return findByUSER_ID(USER_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user follow registrations where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the user_id
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByUSER_ID(long USER_ID, int start,
		int end, OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID;
			finderArgs = new Object[] { USER_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_ID;
			finderArgs = new Object[] { USER_ID, start, end, orderByComparator };
		}

		List<UserFollowRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UserFollowRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserFollowRegistration userFollowRegistration : list) {
					if ((USER_ID != userFollowRegistration.getUSER_ID())) {
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

			query.append(_SQL_SELECT_USERFOLLOWREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserFollowRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_ID);

				if (!pagination) {
					list = (List<UserFollowRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserFollowRegistration>)QueryUtil.list(q,
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
	 * Returns the first user follow registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration findByUSER_ID_First(long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = fetchByUSER_ID_First(USER_ID,
				orderByComparator);

		if (userFollowRegistration != null) {
			return userFollowRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append("}");

		throw new NoSuchUserFollowRegistrationException(msg.toString());
	}

	/**
	 * Returns the first user follow registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration fetchByUSER_ID_First(long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		List<UserFollowRegistration> list = findByUSER_ID(USER_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user follow registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration findByUSER_ID_Last(long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = fetchByUSER_ID_Last(USER_ID,
				orderByComparator);

		if (userFollowRegistration != null) {
			return userFollowRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append("}");

		throw new NoSuchUserFollowRegistrationException(msg.toString());
	}

	/**
	 * Returns the last user follow registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration fetchByUSER_ID_Last(long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		int count = countByUSER_ID(USER_ID);

		if (count == 0) {
			return null;
		}

		List<UserFollowRegistration> list = findByUSER_ID(USER_ID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user follow registrations before and after the current user follow registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_FOLLOW_ID the primary key of the current user follow registration
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	 */
	@Override
	public UserFollowRegistration[] findByUSER_ID_PrevAndNext(
		long USER_FOLLOW_ID, long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = findByPrimaryKey(USER_FOLLOW_ID);

		Session session = null;

		try {
			session = openSession();

			UserFollowRegistration[] array = new UserFollowRegistrationImpl[3];

			array[0] = getByUSER_ID_PrevAndNext(session,
					userFollowRegistration, USER_ID, orderByComparator, true);

			array[1] = userFollowRegistration;

			array[2] = getByUSER_ID_PrevAndNext(session,
					userFollowRegistration, USER_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserFollowRegistration getByUSER_ID_PrevAndNext(Session session,
		UserFollowRegistration userFollowRegistration, long USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_USERFOLLOWREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

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
			query.append(UserFollowRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(USER_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userFollowRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserFollowRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user follow registrations where USER_ID = &#63; from the database.
	 *
	 * @param USER_ID the user_id
	 */
	@Override
	public void removeByUSER_ID(long USER_ID) {
		for (UserFollowRegistration userFollowRegistration : findByUSER_ID(
				USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userFollowRegistration);
		}
	}

	/**
	 * Returns the number of user follow registrations where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @return the number of matching user follow registrations
	 */
	@Override
	public int countByUSER_ID(long USER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER_ID;

		Object[] finderArgs = new Object[] { USER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERFOLLOWREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_USER_ID_USER_ID_2 = "userFollowRegistration.USER_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FOLLOWER_USER_ID =
		new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFOLLOWER_USER_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLLOWER_USER_ID =
		new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFOLLOWER_USER_ID", new String[] { Long.class.getName() },
			UserFollowRegistrationModelImpl.FOLLOWER_USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FOLLOWER_USER_ID = new FinderPath(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFOLLOWER_USER_ID", new String[] { Long.class.getName() });

	/**
	 * Returns all the user follow registrations where FOLLOWER_USER_ID = &#63;.
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @return the matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID) {
		return findByFOLLOWER_USER_ID(FOLLOWER_USER_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user follow registrations where FOLLOWER_USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @return the range of matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID, int start, int end) {
		return findByFOLLOWER_USER_ID(FOLLOWER_USER_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user follow registrations where FOLLOWER_USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID, int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return findByFOLLOWER_USER_ID(FOLLOWER_USER_ID, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user follow registrations where FOLLOWER_USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findByFOLLOWER_USER_ID(
		long FOLLOWER_USER_ID, int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLLOWER_USER_ID;
			finderArgs = new Object[] { FOLLOWER_USER_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FOLLOWER_USER_ID;
			finderArgs = new Object[] {
					FOLLOWER_USER_ID,
					
					start, end, orderByComparator
				};
		}

		List<UserFollowRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UserFollowRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserFollowRegistration userFollowRegistration : list) {
					if ((FOLLOWER_USER_ID != userFollowRegistration.getFOLLOWER_USER_ID())) {
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

			query.append(_SQL_SELECT_USERFOLLOWREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_FOLLOWER_USER_ID_FOLLOWER_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserFollowRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FOLLOWER_USER_ID);

				if (!pagination) {
					list = (List<UserFollowRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserFollowRegistration>)QueryUtil.list(q,
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
	 * Returns the first user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration findByFOLLOWER_USER_ID_First(
		long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = fetchByFOLLOWER_USER_ID_First(FOLLOWER_USER_ID,
				orderByComparator);

		if (userFollowRegistration != null) {
			return userFollowRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FOLLOWER_USER_ID=");
		msg.append(FOLLOWER_USER_ID);

		msg.append("}");

		throw new NoSuchUserFollowRegistrationException(msg.toString());
	}

	/**
	 * Returns the first user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration fetchByFOLLOWER_USER_ID_First(
		long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		List<UserFollowRegistration> list = findByFOLLOWER_USER_ID(FOLLOWER_USER_ID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration findByFOLLOWER_USER_ID_Last(
		long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = fetchByFOLLOWER_USER_ID_Last(FOLLOWER_USER_ID,
				orderByComparator);

		if (userFollowRegistration != null) {
			return userFollowRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("FOLLOWER_USER_ID=");
		msg.append(FOLLOWER_USER_ID);

		msg.append("}");

		throw new NoSuchUserFollowRegistrationException(msg.toString());
	}

	/**
	 * Returns the last user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user follow registration, or <code>null</code> if a matching user follow registration could not be found
	 */
	@Override
	public UserFollowRegistration fetchByFOLLOWER_USER_ID_Last(
		long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		int count = countByFOLLOWER_USER_ID(FOLLOWER_USER_ID);

		if (count == 0) {
			return null;
		}

		List<UserFollowRegistration> list = findByFOLLOWER_USER_ID(FOLLOWER_USER_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user follow registrations before and after the current user follow registration in the ordered set where FOLLOWER_USER_ID = &#63;.
	 *
	 * @param USER_FOLLOW_ID the primary key of the current user follow registration
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	 */
	@Override
	public UserFollowRegistration[] findByFOLLOWER_USER_ID_PrevAndNext(
		long USER_FOLLOW_ID, long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = findByPrimaryKey(USER_FOLLOW_ID);

		Session session = null;

		try {
			session = openSession();

			UserFollowRegistration[] array = new UserFollowRegistrationImpl[3];

			array[0] = getByFOLLOWER_USER_ID_PrevAndNext(session,
					userFollowRegistration, FOLLOWER_USER_ID,
					orderByComparator, true);

			array[1] = userFollowRegistration;

			array[2] = getByFOLLOWER_USER_ID_PrevAndNext(session,
					userFollowRegistration, FOLLOWER_USER_ID,
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

	protected UserFollowRegistration getByFOLLOWER_USER_ID_PrevAndNext(
		Session session, UserFollowRegistration userFollowRegistration,
		long FOLLOWER_USER_ID,
		OrderByComparator<UserFollowRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_USERFOLLOWREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_FOLLOWER_USER_ID_FOLLOWER_USER_ID_2);

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
			query.append(UserFollowRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(FOLLOWER_USER_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userFollowRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserFollowRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user follow registrations where FOLLOWER_USER_ID = &#63; from the database.
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 */
	@Override
	public void removeByFOLLOWER_USER_ID(long FOLLOWER_USER_ID) {
		for (UserFollowRegistration userFollowRegistration : findByFOLLOWER_USER_ID(
				FOLLOWER_USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userFollowRegistration);
		}
	}

	/**
	 * Returns the number of user follow registrations where FOLLOWER_USER_ID = &#63;.
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id
	 * @return the number of matching user follow registrations
	 */
	@Override
	public int countByFOLLOWER_USER_ID(long FOLLOWER_USER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FOLLOWER_USER_ID;

		Object[] finderArgs = new Object[] { FOLLOWER_USER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERFOLLOWREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_FOLLOWER_USER_ID_FOLLOWER_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FOLLOWER_USER_ID);

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

	private static final String _FINDER_COLUMN_FOLLOWER_USER_ID_FOLLOWER_USER_ID_2 =
		"userFollowRegistration.FOLLOWER_USER_ID = ?";

	public UserFollowRegistrationPersistenceImpl() {
		setModelClass(UserFollowRegistration.class);

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
	 * Caches the user follow registration in the entity cache if it is enabled.
	 *
	 * @param userFollowRegistration the user follow registration
	 */
	@Override
	public void cacheResult(UserFollowRegistration userFollowRegistration) {
		entityCache.putResult(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			userFollowRegistration.getPrimaryKey(), userFollowRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USER_FOLLOW_ID,
			new Object[] { userFollowRegistration.getUSER_FOLLOW_ID() },
			userFollowRegistration);

		userFollowRegistration.resetOriginalValues();
	}

	/**
	 * Caches the user follow registrations in the entity cache if it is enabled.
	 *
	 * @param userFollowRegistrations the user follow registrations
	 */
	@Override
	public void cacheResult(
		List<UserFollowRegistration> userFollowRegistrations) {
		for (UserFollowRegistration userFollowRegistration : userFollowRegistrations) {
			if (entityCache.getResult(
						UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						UserFollowRegistrationImpl.class,
						userFollowRegistration.getPrimaryKey()) == null) {
				cacheResult(userFollowRegistration);
			}
			else {
				userFollowRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user follow registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserFollowRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user follow registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserFollowRegistration userFollowRegistration) {
		entityCache.removeResult(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			userFollowRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserFollowRegistrationModelImpl)userFollowRegistration,
			true);
	}

	@Override
	public void clearCache(List<UserFollowRegistration> userFollowRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserFollowRegistration userFollowRegistration : userFollowRegistrations) {
			entityCache.removeResult(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				UserFollowRegistrationImpl.class,
				userFollowRegistration.getPrimaryKey());

			clearUniqueFindersCache((UserFollowRegistrationModelImpl)userFollowRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		UserFollowRegistrationModelImpl userFollowRegistrationModelImpl) {
		Object[] args = new Object[] {
				userFollowRegistrationModelImpl.getUSER_FOLLOW_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_USER_FOLLOW_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_USER_FOLLOW_ID, args,
			userFollowRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserFollowRegistrationModelImpl userFollowRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					userFollowRegistrationModelImpl.getUSER_FOLLOW_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_FOLLOW_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USER_FOLLOW_ID, args);
		}

		if ((userFollowRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USER_FOLLOW_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userFollowRegistrationModelImpl.getOriginalUSER_FOLLOW_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_FOLLOW_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USER_FOLLOW_ID, args);
		}
	}

	/**
	 * Creates a new user follow registration with the primary key. Does not add the user follow registration to the database.
	 *
	 * @param USER_FOLLOW_ID the primary key for the new user follow registration
	 * @return the new user follow registration
	 */
	@Override
	public UserFollowRegistration create(long USER_FOLLOW_ID) {
		UserFollowRegistration userFollowRegistration = new UserFollowRegistrationImpl();

		userFollowRegistration.setNew(true);
		userFollowRegistration.setPrimaryKey(USER_FOLLOW_ID);

		String uuid = PortalUUIDUtil.generate();

		userFollowRegistration.setUuid(uuid);

		return userFollowRegistration;
	}

	/**
	 * Removes the user follow registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param USER_FOLLOW_ID the primary key of the user follow registration
	 * @return the user follow registration that was removed
	 * @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	 */
	@Override
	public UserFollowRegistration remove(long USER_FOLLOW_ID)
		throws NoSuchUserFollowRegistrationException {
		return remove((Serializable)USER_FOLLOW_ID);
	}

	/**
	 * Removes the user follow registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user follow registration
	 * @return the user follow registration that was removed
	 * @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	 */
	@Override
	public UserFollowRegistration remove(Serializable primaryKey)
		throws NoSuchUserFollowRegistrationException {
		Session session = null;

		try {
			session = openSession();

			UserFollowRegistration userFollowRegistration = (UserFollowRegistration)session.get(UserFollowRegistrationImpl.class,
					primaryKey);

			if (userFollowRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserFollowRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userFollowRegistration);
		}
		catch (NoSuchUserFollowRegistrationException nsee) {
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
	protected UserFollowRegistration removeImpl(
		UserFollowRegistration userFollowRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userFollowRegistration)) {
				userFollowRegistration = (UserFollowRegistration)session.get(UserFollowRegistrationImpl.class,
						userFollowRegistration.getPrimaryKeyObj());
			}

			if (userFollowRegistration != null) {
				session.delete(userFollowRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userFollowRegistration != null) {
			clearCache(userFollowRegistration);
		}

		return userFollowRegistration;
	}

	@Override
	public UserFollowRegistration updateImpl(
		UserFollowRegistration userFollowRegistration) {
		boolean isNew = userFollowRegistration.isNew();

		if (!(userFollowRegistration instanceof UserFollowRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userFollowRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userFollowRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userFollowRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserFollowRegistration implementation " +
				userFollowRegistration.getClass());
		}

		UserFollowRegistrationModelImpl userFollowRegistrationModelImpl = (UserFollowRegistrationModelImpl)userFollowRegistration;

		if (Validator.isNull(userFollowRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userFollowRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (userFollowRegistration.isNew()) {
				session.save(userFollowRegistration);

				userFollowRegistration.setNew(false);
			}
			else {
				userFollowRegistration = (UserFollowRegistration)session.merge(userFollowRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!UserFollowRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					userFollowRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { userFollowRegistrationModelImpl.getUSER_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
				args);

			args = new Object[] {
					userFollowRegistrationModelImpl.getFOLLOWER_USER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FOLLOWER_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLLOWER_USER_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((userFollowRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userFollowRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userFollowRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((userFollowRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userFollowRegistrationModelImpl.getOriginalUSER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);

				args = new Object[] { userFollowRegistrationModelImpl.getUSER_ID() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);
			}

			if ((userFollowRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLLOWER_USER_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userFollowRegistrationModelImpl.getOriginalFOLLOWER_USER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FOLLOWER_USER_ID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLLOWER_USER_ID,
					args);

				args = new Object[] {
						userFollowRegistrationModelImpl.getFOLLOWER_USER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FOLLOWER_USER_ID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLLOWER_USER_ID,
					args);
			}
		}

		entityCache.putResult(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserFollowRegistrationImpl.class,
			userFollowRegistration.getPrimaryKey(), userFollowRegistration,
			false);

		clearUniqueFindersCache(userFollowRegistrationModelImpl, false);
		cacheUniqueFindersCache(userFollowRegistrationModelImpl);

		userFollowRegistration.resetOriginalValues();

		return userFollowRegistration;
	}

	/**
	 * Returns the user follow registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user follow registration
	 * @return the user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	 */
	@Override
	public UserFollowRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserFollowRegistrationException {
		UserFollowRegistration userFollowRegistration = fetchByPrimaryKey(primaryKey);

		if (userFollowRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserFollowRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userFollowRegistration;
	}

	/**
	 * Returns the user follow registration with the primary key or throws a {@link NoSuchUserFollowRegistrationException} if it could not be found.
	 *
	 * @param USER_FOLLOW_ID the primary key of the user follow registration
	 * @return the user follow registration
	 * @throws NoSuchUserFollowRegistrationException if a user follow registration with the primary key could not be found
	 */
	@Override
	public UserFollowRegistration findByPrimaryKey(long USER_FOLLOW_ID)
		throws NoSuchUserFollowRegistrationException {
		return findByPrimaryKey((Serializable)USER_FOLLOW_ID);
	}

	/**
	 * Returns the user follow registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user follow registration
	 * @return the user follow registration, or <code>null</code> if a user follow registration with the primary key could not be found
	 */
	@Override
	public UserFollowRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				UserFollowRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserFollowRegistration userFollowRegistration = (UserFollowRegistration)serializable;

		if (userFollowRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				userFollowRegistration = (UserFollowRegistration)session.get(UserFollowRegistrationImpl.class,
						primaryKey);

				if (userFollowRegistration != null) {
					cacheResult(userFollowRegistration);
				}
				else {
					entityCache.putResult(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						UserFollowRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UserFollowRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userFollowRegistration;
	}

	/**
	 * Returns the user follow registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param USER_FOLLOW_ID the primary key of the user follow registration
	 * @return the user follow registration, or <code>null</code> if a user follow registration with the primary key could not be found
	 */
	@Override
	public UserFollowRegistration fetchByPrimaryKey(long USER_FOLLOW_ID) {
		return fetchByPrimaryKey((Serializable)USER_FOLLOW_ID);
	}

	@Override
	public Map<Serializable, UserFollowRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserFollowRegistration> map = new HashMap<Serializable, UserFollowRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserFollowRegistration userFollowRegistration = fetchByPrimaryKey(primaryKey);

			if (userFollowRegistration != null) {
				map.put(primaryKey, userFollowRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UserFollowRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserFollowRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERFOLLOWREGISTRATION_WHERE_PKS_IN);

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

			for (UserFollowRegistration userFollowRegistration : (List<UserFollowRegistration>)q.list()) {
				map.put(userFollowRegistration.getPrimaryKeyObj(),
					userFollowRegistration);

				cacheResult(userFollowRegistration);

				uncachedPrimaryKeys.remove(userFollowRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserFollowRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UserFollowRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the user follow registrations.
	 *
	 * @return the user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user follow registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @return the range of user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user follow registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findAll(int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user follow registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserFollowRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user follow registrations
	 * @param end the upper bound of the range of user follow registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user follow registrations
	 */
	@Override
	public List<UserFollowRegistration> findAll(int start, int end,
		OrderByComparator<UserFollowRegistration> orderByComparator,
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

		List<UserFollowRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UserFollowRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERFOLLOWREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERFOLLOWREGISTRATION;

				if (pagination) {
					sql = sql.concat(UserFollowRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserFollowRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserFollowRegistration>)QueryUtil.list(q,
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
	 * Removes all the user follow registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserFollowRegistration userFollowRegistration : findAll()) {
			remove(userFollowRegistration);
		}
	}

	/**
	 * Returns the number of user follow registrations.
	 *
	 * @return the number of user follow registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERFOLLOWREGISTRATION);

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
		return UserFollowRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user follow registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserFollowRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USERFOLLOWREGISTRATION = "SELECT userFollowRegistration FROM UserFollowRegistration userFollowRegistration";
	private static final String _SQL_SELECT_USERFOLLOWREGISTRATION_WHERE_PKS_IN = "SELECT userFollowRegistration FROM UserFollowRegistration userFollowRegistration WHERE USER_FOLLOW_ID IN (";
	private static final String _SQL_SELECT_USERFOLLOWREGISTRATION_WHERE = "SELECT userFollowRegistration FROM UserFollowRegistration userFollowRegistration WHERE ";
	private static final String _SQL_COUNT_USERFOLLOWREGISTRATION = "SELECT COUNT(userFollowRegistration) FROM UserFollowRegistration userFollowRegistration";
	private static final String _SQL_COUNT_USERFOLLOWREGISTRATION_WHERE = "SELECT COUNT(userFollowRegistration) FROM UserFollowRegistration userFollowRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userFollowRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserFollowRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserFollowRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserFollowRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}