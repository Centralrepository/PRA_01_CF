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

import com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.impl.UserOTPRegistrationImpl;
import com.crowd.funding.database.model.impl.UserOTPRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.UserOTPRegistrationPersistence;

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
 * The persistence implementation for the user otp registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOTPRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.UserOTPRegistrationUtil
 * @generated
 */
@ProviderType
public class UserOTPRegistrationPersistenceImpl extends BasePersistenceImpl<UserOTPRegistration>
	implements UserOTPRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserOTPRegistrationUtil} to access the user otp registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserOTPRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserOTPRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserOTPRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserOTPRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserOTPRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UserOTPRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user otp registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user otp registrations
	 */
	@Override
	public List<UserOTPRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user otp registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user otp registrations
	 * @param end the upper bound of the range of user otp registrations (not inclusive)
	 * @return the range of matching user otp registrations
	 */
	@Override
	public List<UserOTPRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user otp registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user otp registrations
	 * @param end the upper bound of the range of user otp registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user otp registrations
	 */
	@Override
	public List<UserOTPRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<UserOTPRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user otp registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user otp registrations
	 * @param end the upper bound of the range of user otp registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching user otp registrations
	 */
	@Override
	public List<UserOTPRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<UserOTPRegistration> orderByComparator,
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

		List<UserOTPRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UserOTPRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserOTPRegistration userOTPRegistration : list) {
					if (!Objects.equals(uuid, userOTPRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_USEROTPREGISTRATION_WHERE);

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
				query.append(UserOTPRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserOTPRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserOTPRegistration>)QueryUtil.list(q,
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
	 * Returns the first user otp registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user otp registration
	 * @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration findByUuid_First(String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator)
		throws NoSuchUserOTPRegistrationException {
		UserOTPRegistration userOTPRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (userOTPRegistration != null) {
			return userOTPRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserOTPRegistrationException(msg.toString());
	}

	/**
	 * Returns the first user otp registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration fetchByUuid_First(String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator) {
		List<UserOTPRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user otp registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user otp registration
	 * @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration findByUuid_Last(String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator)
		throws NoSuchUserOTPRegistrationException {
		UserOTPRegistration userOTPRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (userOTPRegistration != null) {
			return userOTPRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserOTPRegistrationException(msg.toString());
	}

	/**
	 * Returns the last user otp registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserOTPRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user otp registrations before and after the current user otp registration in the ordered set where uuid = &#63;.
	 *
	 * @param USER_OTP_ID the primary key of the current user otp registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user otp registration
	 * @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	 */
	@Override
	public UserOTPRegistration[] findByUuid_PrevAndNext(long USER_OTP_ID,
		String uuid, OrderByComparator<UserOTPRegistration> orderByComparator)
		throws NoSuchUserOTPRegistrationException {
		UserOTPRegistration userOTPRegistration = findByPrimaryKey(USER_OTP_ID);

		Session session = null;

		try {
			session = openSession();

			UserOTPRegistration[] array = new UserOTPRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, userOTPRegistration,
					uuid, orderByComparator, true);

			array[1] = userOTPRegistration;

			array[2] = getByUuid_PrevAndNext(session, userOTPRegistration,
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

	protected UserOTPRegistration getByUuid_PrevAndNext(Session session,
		UserOTPRegistration userOTPRegistration, String uuid,
		OrderByComparator<UserOTPRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_USEROTPREGISTRATION_WHERE);

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
			query.append(UserOTPRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(userOTPRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserOTPRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user otp registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserOTPRegistration userOTPRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userOTPRegistration);
		}
	}

	/**
	 * Returns the number of user otp registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user otp registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USEROTPREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "userOTPRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userOTPRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(userOTPRegistration.uuid IS NULL OR userOTPRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_MOBILE_NO = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserOTPRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMOBILE_NO", new String[] { Long.class.getName() },
			UserOTPRegistrationModelImpl.MOBILE_NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MOBILE_NO = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMOBILE_NO",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user otp registration where MOBILE_NO = &#63; or throws a {@link NoSuchUserOTPRegistrationException} if it could not be found.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @return the matching user otp registration
	 * @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration findByMOBILE_NO(long MOBILE_NO)
		throws NoSuchUserOTPRegistrationException {
		UserOTPRegistration userOTPRegistration = fetchByMOBILE_NO(MOBILE_NO);

		if (userOTPRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("MOBILE_NO=");
			msg.append(MOBILE_NO);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserOTPRegistrationException(msg.toString());
		}

		return userOTPRegistration;
	}

	/**
	 * Returns the user otp registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration fetchByMOBILE_NO(long MOBILE_NO) {
		return fetchByMOBILE_NO(MOBILE_NO, true);
	}

	/**
	 * Returns the user otp registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration fetchByMOBILE_NO(long MOBILE_NO,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { MOBILE_NO };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_MOBILE_NO,
					finderArgs, this);
		}

		if (result instanceof UserOTPRegistration) {
			UserOTPRegistration userOTPRegistration = (UserOTPRegistration)result;

			if ((MOBILE_NO != userOTPRegistration.getMOBILE_NO())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USEROTPREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_MOBILE_NO_MOBILE_NO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MOBILE_NO);

				List<UserOTPRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_MOBILE_NO,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserOTPRegistrationPersistenceImpl.fetchByMOBILE_NO(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserOTPRegistration userOTPRegistration = list.get(0);

					result = userOTPRegistration;

					cacheResult(userOTPRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_MOBILE_NO,
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
			return (UserOTPRegistration)result;
		}
	}

	/**
	 * Removes the user otp registration where MOBILE_NO = &#63; from the database.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @return the user otp registration that was removed
	 */
	@Override
	public UserOTPRegistration removeByMOBILE_NO(long MOBILE_NO)
		throws NoSuchUserOTPRegistrationException {
		UserOTPRegistration userOTPRegistration = findByMOBILE_NO(MOBILE_NO);

		return remove(userOTPRegistration);
	}

	/**
	 * Returns the number of user otp registrations where MOBILE_NO = &#63;.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @return the number of matching user otp registrations
	 */
	@Override
	public int countByMOBILE_NO(long MOBILE_NO) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MOBILE_NO;

		Object[] finderArgs = new Object[] { MOBILE_NO };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USEROTPREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_MOBILE_NO_MOBILE_NO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MOBILE_NO);

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

	private static final String _FINDER_COLUMN_MOBILE_NO_MOBILE_NO_2 = "userOTPRegistration.MOBILE_NO = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USER_OTP_ID = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UserOTPRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUSER_OTP_ID", new String[] { Long.class.getName() },
			UserOTPRegistrationModelImpl.USER_OTP_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_OTP_ID = new FinderPath(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSER_OTP_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the user otp registration where USER_OTP_ID = &#63; or throws a {@link NoSuchUserOTPRegistrationException} if it could not be found.
	 *
	 * @param USER_OTP_ID the user_otp_id
	 * @return the matching user otp registration
	 * @throws NoSuchUserOTPRegistrationException if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration findByUSER_OTP_ID(long USER_OTP_ID)
		throws NoSuchUserOTPRegistrationException {
		UserOTPRegistration userOTPRegistration = fetchByUSER_OTP_ID(USER_OTP_ID);

		if (userOTPRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("USER_OTP_ID=");
			msg.append(USER_OTP_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserOTPRegistrationException(msg.toString());
		}

		return userOTPRegistration;
	}

	/**
	 * Returns the user otp registration where USER_OTP_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param USER_OTP_ID the user_otp_id
	 * @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration fetchByUSER_OTP_ID(long USER_OTP_ID) {
		return fetchByUSER_OTP_ID(USER_OTP_ID, true);
	}

	/**
	 * Returns the user otp registration where USER_OTP_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param USER_OTP_ID the user_otp_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user otp registration, or <code>null</code> if a matching user otp registration could not be found
	 */
	@Override
	public UserOTPRegistration fetchByUSER_OTP_ID(long USER_OTP_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { USER_OTP_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USER_OTP_ID,
					finderArgs, this);
		}

		if (result instanceof UserOTPRegistration) {
			UserOTPRegistration userOTPRegistration = (UserOTPRegistration)result;

			if ((USER_OTP_ID != userOTPRegistration.getUSER_OTP_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USEROTPREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_OTP_ID_USER_OTP_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_OTP_ID);

				List<UserOTPRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USER_OTP_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UserOTPRegistrationPersistenceImpl.fetchByUSER_OTP_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UserOTPRegistration userOTPRegistration = list.get(0);

					result = userOTPRegistration;

					cacheResult(userOTPRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USER_OTP_ID,
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
			return (UserOTPRegistration)result;
		}
	}

	/**
	 * Removes the user otp registration where USER_OTP_ID = &#63; from the database.
	 *
	 * @param USER_OTP_ID the user_otp_id
	 * @return the user otp registration that was removed
	 */
	@Override
	public UserOTPRegistration removeByUSER_OTP_ID(long USER_OTP_ID)
		throws NoSuchUserOTPRegistrationException {
		UserOTPRegistration userOTPRegistration = findByUSER_OTP_ID(USER_OTP_ID);

		return remove(userOTPRegistration);
	}

	/**
	 * Returns the number of user otp registrations where USER_OTP_ID = &#63;.
	 *
	 * @param USER_OTP_ID the user_otp_id
	 * @return the number of matching user otp registrations
	 */
	@Override
	public int countByUSER_OTP_ID(long USER_OTP_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER_OTP_ID;

		Object[] finderArgs = new Object[] { USER_OTP_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USEROTPREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_OTP_ID_USER_OTP_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_OTP_ID);

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

	private static final String _FINDER_COLUMN_USER_OTP_ID_USER_OTP_ID_2 = "userOTPRegistration.USER_OTP_ID = ?";

	public UserOTPRegistrationPersistenceImpl() {
		setModelClass(UserOTPRegistration.class);

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
	 * Caches the user otp registration in the entity cache if it is enabled.
	 *
	 * @param userOTPRegistration the user otp registration
	 */
	@Override
	public void cacheResult(UserOTPRegistration userOTPRegistration) {
		entityCache.putResult(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationImpl.class, userOTPRegistration.getPrimaryKey(),
			userOTPRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_MOBILE_NO,
			new Object[] { userOTPRegistration.getMOBILE_NO() },
			userOTPRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USER_OTP_ID,
			new Object[] { userOTPRegistration.getUSER_OTP_ID() },
			userOTPRegistration);

		userOTPRegistration.resetOriginalValues();
	}

	/**
	 * Caches the user otp registrations in the entity cache if it is enabled.
	 *
	 * @param userOTPRegistrations the user otp registrations
	 */
	@Override
	public void cacheResult(List<UserOTPRegistration> userOTPRegistrations) {
		for (UserOTPRegistration userOTPRegistration : userOTPRegistrations) {
			if (entityCache.getResult(
						UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						UserOTPRegistrationImpl.class,
						userOTPRegistration.getPrimaryKey()) == null) {
				cacheResult(userOTPRegistration);
			}
			else {
				userOTPRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user otp registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserOTPRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user otp registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserOTPRegistration userOTPRegistration) {
		entityCache.removeResult(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationImpl.class, userOTPRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserOTPRegistrationModelImpl)userOTPRegistration,
			true);
	}

	@Override
	public void clearCache(List<UserOTPRegistration> userOTPRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserOTPRegistration userOTPRegistration : userOTPRegistrations) {
			entityCache.removeResult(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				UserOTPRegistrationImpl.class,
				userOTPRegistration.getPrimaryKey());

			clearUniqueFindersCache((UserOTPRegistrationModelImpl)userOTPRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		UserOTPRegistrationModelImpl userOTPRegistrationModelImpl) {
		Object[] args = new Object[] { userOTPRegistrationModelImpl.getMOBILE_NO() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_MOBILE_NO, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_MOBILE_NO, args,
			userOTPRegistrationModelImpl, false);

		args = new Object[] { userOTPRegistrationModelImpl.getUSER_OTP_ID() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_USER_OTP_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_USER_OTP_ID, args,
			userOTPRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserOTPRegistrationModelImpl userOTPRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					userOTPRegistrationModelImpl.getMOBILE_NO()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MOBILE_NO, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MOBILE_NO, args);
		}

		if ((userOTPRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MOBILE_NO.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userOTPRegistrationModelImpl.getOriginalMOBILE_NO()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MOBILE_NO, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MOBILE_NO, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					userOTPRegistrationModelImpl.getUSER_OTP_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_OTP_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USER_OTP_ID, args);
		}

		if ((userOTPRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USER_OTP_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					userOTPRegistrationModelImpl.getOriginalUSER_OTP_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_OTP_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USER_OTP_ID, args);
		}
	}

	/**
	 * Creates a new user otp registration with the primary key. Does not add the user otp registration to the database.
	 *
	 * @param USER_OTP_ID the primary key for the new user otp registration
	 * @return the new user otp registration
	 */
	@Override
	public UserOTPRegistration create(long USER_OTP_ID) {
		UserOTPRegistration userOTPRegistration = new UserOTPRegistrationImpl();

		userOTPRegistration.setNew(true);
		userOTPRegistration.setPrimaryKey(USER_OTP_ID);

		String uuid = PortalUUIDUtil.generate();

		userOTPRegistration.setUuid(uuid);

		return userOTPRegistration;
	}

	/**
	 * Removes the user otp registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param USER_OTP_ID the primary key of the user otp registration
	 * @return the user otp registration that was removed
	 * @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	 */
	@Override
	public UserOTPRegistration remove(long USER_OTP_ID)
		throws NoSuchUserOTPRegistrationException {
		return remove((Serializable)USER_OTP_ID);
	}

	/**
	 * Removes the user otp registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user otp registration
	 * @return the user otp registration that was removed
	 * @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	 */
	@Override
	public UserOTPRegistration remove(Serializable primaryKey)
		throws NoSuchUserOTPRegistrationException {
		Session session = null;

		try {
			session = openSession();

			UserOTPRegistration userOTPRegistration = (UserOTPRegistration)session.get(UserOTPRegistrationImpl.class,
					primaryKey);

			if (userOTPRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserOTPRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userOTPRegistration);
		}
		catch (NoSuchUserOTPRegistrationException nsee) {
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
	protected UserOTPRegistration removeImpl(
		UserOTPRegistration userOTPRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userOTPRegistration)) {
				userOTPRegistration = (UserOTPRegistration)session.get(UserOTPRegistrationImpl.class,
						userOTPRegistration.getPrimaryKeyObj());
			}

			if (userOTPRegistration != null) {
				session.delete(userOTPRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userOTPRegistration != null) {
			clearCache(userOTPRegistration);
		}

		return userOTPRegistration;
	}

	@Override
	public UserOTPRegistration updateImpl(
		UserOTPRegistration userOTPRegistration) {
		boolean isNew = userOTPRegistration.isNew();

		if (!(userOTPRegistration instanceof UserOTPRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userOTPRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userOTPRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userOTPRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserOTPRegistration implementation " +
				userOTPRegistration.getClass());
		}

		UserOTPRegistrationModelImpl userOTPRegistrationModelImpl = (UserOTPRegistrationModelImpl)userOTPRegistration;

		if (Validator.isNull(userOTPRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userOTPRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (userOTPRegistration.isNew()) {
				session.save(userOTPRegistration);

				userOTPRegistration.setNew(false);
			}
			else {
				userOTPRegistration = (UserOTPRegistration)session.merge(userOTPRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!UserOTPRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { userOTPRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((userOTPRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userOTPRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { userOTPRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UserOTPRegistrationImpl.class, userOTPRegistration.getPrimaryKey(),
			userOTPRegistration, false);

		clearUniqueFindersCache(userOTPRegistrationModelImpl, false);
		cacheUniqueFindersCache(userOTPRegistrationModelImpl);

		userOTPRegistration.resetOriginalValues();

		return userOTPRegistration;
	}

	/**
	 * Returns the user otp registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user otp registration
	 * @return the user otp registration
	 * @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	 */
	@Override
	public UserOTPRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserOTPRegistrationException {
		UserOTPRegistration userOTPRegistration = fetchByPrimaryKey(primaryKey);

		if (userOTPRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserOTPRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userOTPRegistration;
	}

	/**
	 * Returns the user otp registration with the primary key or throws a {@link NoSuchUserOTPRegistrationException} if it could not be found.
	 *
	 * @param USER_OTP_ID the primary key of the user otp registration
	 * @return the user otp registration
	 * @throws NoSuchUserOTPRegistrationException if a user otp registration with the primary key could not be found
	 */
	@Override
	public UserOTPRegistration findByPrimaryKey(long USER_OTP_ID)
		throws NoSuchUserOTPRegistrationException {
		return findByPrimaryKey((Serializable)USER_OTP_ID);
	}

	/**
	 * Returns the user otp registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user otp registration
	 * @return the user otp registration, or <code>null</code> if a user otp registration with the primary key could not be found
	 */
	@Override
	public UserOTPRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				UserOTPRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserOTPRegistration userOTPRegistration = (UserOTPRegistration)serializable;

		if (userOTPRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				userOTPRegistration = (UserOTPRegistration)session.get(UserOTPRegistrationImpl.class,
						primaryKey);

				if (userOTPRegistration != null) {
					cacheResult(userOTPRegistration);
				}
				else {
					entityCache.putResult(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						UserOTPRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UserOTPRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userOTPRegistration;
	}

	/**
	 * Returns the user otp registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param USER_OTP_ID the primary key of the user otp registration
	 * @return the user otp registration, or <code>null</code> if a user otp registration with the primary key could not be found
	 */
	@Override
	public UserOTPRegistration fetchByPrimaryKey(long USER_OTP_ID) {
		return fetchByPrimaryKey((Serializable)USER_OTP_ID);
	}

	@Override
	public Map<Serializable, UserOTPRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserOTPRegistration> map = new HashMap<Serializable, UserOTPRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserOTPRegistration userOTPRegistration = fetchByPrimaryKey(primaryKey);

			if (userOTPRegistration != null) {
				map.put(primaryKey, userOTPRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UserOTPRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserOTPRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USEROTPREGISTRATION_WHERE_PKS_IN);

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

			for (UserOTPRegistration userOTPRegistration : (List<UserOTPRegistration>)q.list()) {
				map.put(userOTPRegistration.getPrimaryKeyObj(),
					userOTPRegistration);

				cacheResult(userOTPRegistration);

				uncachedPrimaryKeys.remove(userOTPRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserOTPRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UserOTPRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the user otp registrations.
	 *
	 * @return the user otp registrations
	 */
	@Override
	public List<UserOTPRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user otp registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user otp registrations
	 * @param end the upper bound of the range of user otp registrations (not inclusive)
	 * @return the range of user otp registrations
	 */
	@Override
	public List<UserOTPRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user otp registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user otp registrations
	 * @param end the upper bound of the range of user otp registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user otp registrations
	 */
	@Override
	public List<UserOTPRegistration> findAll(int start, int end,
		OrderByComparator<UserOTPRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user otp registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserOTPRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user otp registrations
	 * @param end the upper bound of the range of user otp registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user otp registrations
	 */
	@Override
	public List<UserOTPRegistration> findAll(int start, int end,
		OrderByComparator<UserOTPRegistration> orderByComparator,
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

		List<UserOTPRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UserOTPRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USEROTPREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USEROTPREGISTRATION;

				if (pagination) {
					sql = sql.concat(UserOTPRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserOTPRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserOTPRegistration>)QueryUtil.list(q,
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
	 * Removes all the user otp registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserOTPRegistration userOTPRegistration : findAll()) {
			remove(userOTPRegistration);
		}
	}

	/**
	 * Returns the number of user otp registrations.
	 *
	 * @return the number of user otp registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USEROTPREGISTRATION);

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
		return UserOTPRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user otp registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserOTPRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_USEROTPREGISTRATION = "SELECT userOTPRegistration FROM UserOTPRegistration userOTPRegistration";
	private static final String _SQL_SELECT_USEROTPREGISTRATION_WHERE_PKS_IN = "SELECT userOTPRegistration FROM UserOTPRegistration userOTPRegistration WHERE USER_OTP_ID IN (";
	private static final String _SQL_SELECT_USEROTPREGISTRATION_WHERE = "SELECT userOTPRegistration FROM UserOTPRegistration userOTPRegistration WHERE ";
	private static final String _SQL_COUNT_USEROTPREGISTRATION = "SELECT COUNT(userOTPRegistration) FROM UserOTPRegistration userOTPRegistration";
	private static final String _SQL_COUNT_USEROTPREGISTRATION_WHERE = "SELECT COUNT(userOTPRegistration) FROM UserOTPRegistration userOTPRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userOTPRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserOTPRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserOTPRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserOTPRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}