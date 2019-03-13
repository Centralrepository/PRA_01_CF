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

import com.crowd.funding.database.exception.NoSuchSubscriptionRegistrationException;
import com.crowd.funding.database.model.SubscriptionRegistration;
import com.crowd.funding.database.model.impl.SubscriptionRegistrationImpl;
import com.crowd.funding.database.model.impl.SubscriptionRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.SubscriptionRegistrationPersistence;

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
 * The persistence implementation for the subscription registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.SubscriptionRegistrationUtil
 * @generated
 */
@ProviderType
public class SubscriptionRegistrationPersistenceImpl extends BasePersistenceImpl<SubscriptionRegistration>
	implements SubscriptionRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SubscriptionRegistrationUtil} to access the subscription registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SubscriptionRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SubscriptionRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the subscription registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subscription registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subscription registrations
	 * @param end the upper bound of the range of subscription registrations (not inclusive)
	 * @return the range of matching subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subscription registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subscription registrations
	 * @param end the upper bound of the range of subscription registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subscription registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subscription registrations
	 * @param end the upper bound of the range of subscription registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<SubscriptionRegistration> orderByComparator,
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

		List<SubscriptionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<SubscriptionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SubscriptionRegistration subscriptionRegistration : list) {
					if (!Objects.equals(uuid, subscriptionRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_SUBSCRIPTIONREGISTRATION_WHERE);

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
				query.append(SubscriptionRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<SubscriptionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SubscriptionRegistration>)QueryUtil.list(q,
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
	 * Returns the first subscription registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription registration
	 * @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration findByUuid_First(String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException {
		SubscriptionRegistration subscriptionRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (subscriptionRegistration != null) {
			return subscriptionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchSubscriptionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first subscription registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration fetchByUuid_First(String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		List<SubscriptionRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subscription registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription registration
	 * @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration findByUuid_Last(String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException {
		SubscriptionRegistration subscriptionRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (subscriptionRegistration != null) {
			return subscriptionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchSubscriptionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last subscription registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SubscriptionRegistration> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subscription registrations before and after the current subscription registration in the ordered set where uuid = &#63;.
	 *
	 * @param SUSCRIBER_ID the primary key of the current subscription registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subscription registration
	 * @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	 */
	@Override
	public SubscriptionRegistration[] findByUuid_PrevAndNext(
		long SUSCRIBER_ID, String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException {
		SubscriptionRegistration subscriptionRegistration = findByPrimaryKey(SUSCRIBER_ID);

		Session session = null;

		try {
			session = openSession();

			SubscriptionRegistration[] array = new SubscriptionRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, subscriptionRegistration,
					uuid, orderByComparator, true);

			array[1] = subscriptionRegistration;

			array[2] = getByUuid_PrevAndNext(session, subscriptionRegistration,
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

	protected SubscriptionRegistration getByUuid_PrevAndNext(Session session,
		SubscriptionRegistration subscriptionRegistration, String uuid,
		OrderByComparator<SubscriptionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_SUBSCRIPTIONREGISTRATION_WHERE);

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
			query.append(SubscriptionRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(subscriptionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubscriptionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subscription registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SubscriptionRegistration subscriptionRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(subscriptionRegistration);
		}
	}

	/**
	 * Returns the number of subscription registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching subscription registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBSCRIPTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "subscriptionRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "subscriptionRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(subscriptionRegistration.uuid IS NULL OR subscriptionRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySTATUS",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySTATUS",
			new String[] { Integer.class.getName() },
			SubscriptionRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySTATUS",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the subscription registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the matching subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findBySTATUS(int STATUS) {
		return findBySTATUS(STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subscription registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of subscription registrations
	 * @param end the upper bound of the range of subscription registrations (not inclusive)
	 * @return the range of matching subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findBySTATUS(int STATUS, int start,
		int end) {
		return findBySTATUS(STATUS, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subscription registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of subscription registrations
	 * @param end the upper bound of the range of subscription registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return findBySTATUS(STATUS, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subscription registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of subscription registrations
	 * @param end the upper bound of the range of subscription registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<SubscriptionRegistration> orderByComparator,
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

		List<SubscriptionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<SubscriptionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SubscriptionRegistration subscriptionRegistration : list) {
					if ((STATUS != subscriptionRegistration.getSTATUS())) {
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

			query.append(_SQL_SELECT_SUBSCRIPTIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SubscriptionRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(STATUS);

				if (!pagination) {
					list = (List<SubscriptionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SubscriptionRegistration>)QueryUtil.list(q,
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
	 * Returns the first subscription registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription registration
	 * @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException {
		SubscriptionRegistration subscriptionRegistration = fetchBySTATUS_First(STATUS,
				orderByComparator);

		if (subscriptionRegistration != null) {
			return subscriptionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchSubscriptionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first subscription registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		List<SubscriptionRegistration> list = findBySTATUS(STATUS, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subscription registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription registration
	 * @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException {
		SubscriptionRegistration subscriptionRegistration = fetchBySTATUS_Last(STATUS,
				orderByComparator);

		if (subscriptionRegistration != null) {
			return subscriptionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchSubscriptionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last subscription registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		int count = countBySTATUS(STATUS);

		if (count == 0) {
			return null;
		}

		List<SubscriptionRegistration> list = findBySTATUS(STATUS, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subscription registrations before and after the current subscription registration in the ordered set where STATUS = &#63;.
	 *
	 * @param SUSCRIBER_ID the primary key of the current subscription registration
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subscription registration
	 * @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	 */
	@Override
	public SubscriptionRegistration[] findBySTATUS_PrevAndNext(
		long SUSCRIBER_ID, int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator)
		throws NoSuchSubscriptionRegistrationException {
		SubscriptionRegistration subscriptionRegistration = findByPrimaryKey(SUSCRIBER_ID);

		Session session = null;

		try {
			session = openSession();

			SubscriptionRegistration[] array = new SubscriptionRegistrationImpl[3];

			array[0] = getBySTATUS_PrevAndNext(session,
					subscriptionRegistration, STATUS, orderByComparator, true);

			array[1] = subscriptionRegistration;

			array[2] = getBySTATUS_PrevAndNext(session,
					subscriptionRegistration, STATUS, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubscriptionRegistration getBySTATUS_PrevAndNext(
		Session session, SubscriptionRegistration subscriptionRegistration,
		int STATUS,
		OrderByComparator<SubscriptionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_SUBSCRIPTIONREGISTRATION_WHERE);

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
			query.append(SubscriptionRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(subscriptionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubscriptionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subscription registrations where STATUS = &#63; from the database.
	 *
	 * @param STATUS the status
	 */
	@Override
	public void removeBySTATUS(int STATUS) {
		for (SubscriptionRegistration subscriptionRegistration : findBySTATUS(
				STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(subscriptionRegistration);
		}
	}

	/**
	 * Returns the number of subscription registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the number of matching subscription registrations
	 */
	@Override
	public int countBySTATUS(int STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBSCRIPTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "subscriptionRegistration.STATUS = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAIL = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEMAIL", new String[] { String.class.getName() },
			SubscriptionRegistrationModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEMAIL",
			new String[] { String.class.getName() });

	/**
	 * Returns the subscription registration where EMAIL = &#63; or throws a {@link NoSuchSubscriptionRegistrationException} if it could not be found.
	 *
	 * @param EMAIL the email
	 * @return the matching subscription registration
	 * @throws NoSuchSubscriptionRegistrationException if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration findByEMAIL(String EMAIL)
		throws NoSuchSubscriptionRegistrationException {
		SubscriptionRegistration subscriptionRegistration = fetchByEMAIL(EMAIL);

		if (subscriptionRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("EMAIL=");
			msg.append(EMAIL);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSubscriptionRegistrationException(msg.toString());
		}

		return subscriptionRegistration;
	}

	/**
	 * Returns the subscription registration where EMAIL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param EMAIL the email
	 * @return the matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration fetchByEMAIL(String EMAIL) {
		return fetchByEMAIL(EMAIL, true);
	}

	/**
	 * Returns the subscription registration where EMAIL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param EMAIL the email
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching subscription registration, or <code>null</code> if a matching subscription registration could not be found
	 */
	@Override
	public SubscriptionRegistration fetchByEMAIL(String EMAIL,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { EMAIL };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs, this);
		}

		if (result instanceof SubscriptionRegistration) {
			SubscriptionRegistration subscriptionRegistration = (SubscriptionRegistration)result;

			if (!Objects.equals(EMAIL, subscriptionRegistration.getEMAIL())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SUBSCRIPTIONREGISTRATION_WHERE);

			boolean bindEMAIL = false;

			if (EMAIL == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (EMAIL.equals("")) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEMAIL = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEMAIL) {
					qPos.add(EMAIL);
				}

				List<SubscriptionRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"SubscriptionRegistrationPersistenceImpl.fetchByEMAIL(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SubscriptionRegistration subscriptionRegistration = list.get(0);

					result = subscriptionRegistration;

					cacheResult(subscriptionRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAIL, finderArgs);

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
			return (SubscriptionRegistration)result;
		}
	}

	/**
	 * Removes the subscription registration where EMAIL = &#63; from the database.
	 *
	 * @param EMAIL the email
	 * @return the subscription registration that was removed
	 */
	@Override
	public SubscriptionRegistration removeByEMAIL(String EMAIL)
		throws NoSuchSubscriptionRegistrationException {
		SubscriptionRegistration subscriptionRegistration = findByEMAIL(EMAIL);

		return remove(subscriptionRegistration);
	}

	/**
	 * Returns the number of subscription registrations where EMAIL = &#63;.
	 *
	 * @param EMAIL the email
	 * @return the number of matching subscription registrations
	 */
	@Override
	public int countByEMAIL(String EMAIL) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { EMAIL };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBSCRIPTIONREGISTRATION_WHERE);

			boolean bindEMAIL = false;

			if (EMAIL == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (EMAIL.equals("")) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEMAIL = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEMAIL) {
					qPos.add(EMAIL);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "subscriptionRegistration.EMAIL IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "subscriptionRegistration.EMAIL = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(subscriptionRegistration.EMAIL IS NULL OR subscriptionRegistration.EMAIL = '')";

	public SubscriptionRegistrationPersistenceImpl() {
		setModelClass(SubscriptionRegistration.class);

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
	 * Caches the subscription registration in the entity cache if it is enabled.
	 *
	 * @param subscriptionRegistration the subscription registration
	 */
	@Override
	public void cacheResult(SubscriptionRegistration subscriptionRegistration) {
		entityCache.putResult(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class,
			subscriptionRegistration.getPrimaryKey(), subscriptionRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { subscriptionRegistration.getEMAIL() },
			subscriptionRegistration);

		subscriptionRegistration.resetOriginalValues();
	}

	/**
	 * Caches the subscription registrations in the entity cache if it is enabled.
	 *
	 * @param subscriptionRegistrations the subscription registrations
	 */
	@Override
	public void cacheResult(
		List<SubscriptionRegistration> subscriptionRegistrations) {
		for (SubscriptionRegistration subscriptionRegistration : subscriptionRegistrations) {
			if (entityCache.getResult(
						SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						SubscriptionRegistrationImpl.class,
						subscriptionRegistration.getPrimaryKey()) == null) {
				cacheResult(subscriptionRegistration);
			}
			else {
				subscriptionRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all subscription registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubscriptionRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the subscription registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubscriptionRegistration subscriptionRegistration) {
		entityCache.removeResult(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class,
			subscriptionRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SubscriptionRegistrationModelImpl)subscriptionRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<SubscriptionRegistration> subscriptionRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SubscriptionRegistration subscriptionRegistration : subscriptionRegistrations) {
			entityCache.removeResult(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				SubscriptionRegistrationImpl.class,
				subscriptionRegistration.getPrimaryKey());

			clearUniqueFindersCache((SubscriptionRegistrationModelImpl)subscriptionRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		SubscriptionRegistrationModelImpl subscriptionRegistrationModelImpl) {
		Object[] args = new Object[] {
				subscriptionRegistrationModelImpl.getEMAIL()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
			subscriptionRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SubscriptionRegistrationModelImpl subscriptionRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					subscriptionRegistrationModelImpl.getEMAIL()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);
		}

		if ((subscriptionRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					subscriptionRegistrationModelImpl.getOriginalEMAIL()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);
		}
	}

	/**
	 * Creates a new subscription registration with the primary key. Does not add the subscription registration to the database.
	 *
	 * @param SUSCRIBER_ID the primary key for the new subscription registration
	 * @return the new subscription registration
	 */
	@Override
	public SubscriptionRegistration create(long SUSCRIBER_ID) {
		SubscriptionRegistration subscriptionRegistration = new SubscriptionRegistrationImpl();

		subscriptionRegistration.setNew(true);
		subscriptionRegistration.setPrimaryKey(SUSCRIBER_ID);

		String uuid = PortalUUIDUtil.generate();

		subscriptionRegistration.setUuid(uuid);

		return subscriptionRegistration;
	}

	/**
	 * Removes the subscription registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param SUSCRIBER_ID the primary key of the subscription registration
	 * @return the subscription registration that was removed
	 * @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	 */
	@Override
	public SubscriptionRegistration remove(long SUSCRIBER_ID)
		throws NoSuchSubscriptionRegistrationException {
		return remove((Serializable)SUSCRIBER_ID);
	}

	/**
	 * Removes the subscription registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subscription registration
	 * @return the subscription registration that was removed
	 * @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	 */
	@Override
	public SubscriptionRegistration remove(Serializable primaryKey)
		throws NoSuchSubscriptionRegistrationException {
		Session session = null;

		try {
			session = openSession();

			SubscriptionRegistration subscriptionRegistration = (SubscriptionRegistration)session.get(SubscriptionRegistrationImpl.class,
					primaryKey);

			if (subscriptionRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubscriptionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(subscriptionRegistration);
		}
		catch (NoSuchSubscriptionRegistrationException nsee) {
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
	protected SubscriptionRegistration removeImpl(
		SubscriptionRegistration subscriptionRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subscriptionRegistration)) {
				subscriptionRegistration = (SubscriptionRegistration)session.get(SubscriptionRegistrationImpl.class,
						subscriptionRegistration.getPrimaryKeyObj());
			}

			if (subscriptionRegistration != null) {
				session.delete(subscriptionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (subscriptionRegistration != null) {
			clearCache(subscriptionRegistration);
		}

		return subscriptionRegistration;
	}

	@Override
	public SubscriptionRegistration updateImpl(
		SubscriptionRegistration subscriptionRegistration) {
		boolean isNew = subscriptionRegistration.isNew();

		if (!(subscriptionRegistration instanceof SubscriptionRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subscriptionRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(subscriptionRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subscriptionRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SubscriptionRegistration implementation " +
				subscriptionRegistration.getClass());
		}

		SubscriptionRegistrationModelImpl subscriptionRegistrationModelImpl = (SubscriptionRegistrationModelImpl)subscriptionRegistration;

		if (Validator.isNull(subscriptionRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			subscriptionRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (subscriptionRegistration.isNew()) {
				session.save(subscriptionRegistration);

				subscriptionRegistration.setNew(false);
			}
			else {
				subscriptionRegistration = (SubscriptionRegistration)session.merge(subscriptionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SubscriptionRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					subscriptionRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { subscriptionRegistrationModelImpl.getSTATUS() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((subscriptionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subscriptionRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { subscriptionRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((subscriptionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						subscriptionRegistrationModelImpl.getOriginalSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						subscriptionRegistrationModelImpl.getSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			SubscriptionRegistrationImpl.class,
			subscriptionRegistration.getPrimaryKey(), subscriptionRegistration,
			false);

		clearUniqueFindersCache(subscriptionRegistrationModelImpl, false);
		cacheUniqueFindersCache(subscriptionRegistrationModelImpl);

		subscriptionRegistration.resetOriginalValues();

		return subscriptionRegistration;
	}

	/**
	 * Returns the subscription registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subscription registration
	 * @return the subscription registration
	 * @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	 */
	@Override
	public SubscriptionRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubscriptionRegistrationException {
		SubscriptionRegistration subscriptionRegistration = fetchByPrimaryKey(primaryKey);

		if (subscriptionRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubscriptionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return subscriptionRegistration;
	}

	/**
	 * Returns the subscription registration with the primary key or throws a {@link NoSuchSubscriptionRegistrationException} if it could not be found.
	 *
	 * @param SUSCRIBER_ID the primary key of the subscription registration
	 * @return the subscription registration
	 * @throws NoSuchSubscriptionRegistrationException if a subscription registration with the primary key could not be found
	 */
	@Override
	public SubscriptionRegistration findByPrimaryKey(long SUSCRIBER_ID)
		throws NoSuchSubscriptionRegistrationException {
		return findByPrimaryKey((Serializable)SUSCRIBER_ID);
	}

	/**
	 * Returns the subscription registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subscription registration
	 * @return the subscription registration, or <code>null</code> if a subscription registration with the primary key could not be found
	 */
	@Override
	public SubscriptionRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				SubscriptionRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SubscriptionRegistration subscriptionRegistration = (SubscriptionRegistration)serializable;

		if (subscriptionRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				subscriptionRegistration = (SubscriptionRegistration)session.get(SubscriptionRegistrationImpl.class,
						primaryKey);

				if (subscriptionRegistration != null) {
					cacheResult(subscriptionRegistration);
				}
				else {
					entityCache.putResult(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						SubscriptionRegistrationImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					SubscriptionRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return subscriptionRegistration;
	}

	/**
	 * Returns the subscription registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param SUSCRIBER_ID the primary key of the subscription registration
	 * @return the subscription registration, or <code>null</code> if a subscription registration with the primary key could not be found
	 */
	@Override
	public SubscriptionRegistration fetchByPrimaryKey(long SUSCRIBER_ID) {
		return fetchByPrimaryKey((Serializable)SUSCRIBER_ID);
	}

	@Override
	public Map<Serializable, SubscriptionRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SubscriptionRegistration> map = new HashMap<Serializable, SubscriptionRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SubscriptionRegistration subscriptionRegistration = fetchByPrimaryKey(primaryKey);

			if (subscriptionRegistration != null) {
				map.put(primaryKey, subscriptionRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					SubscriptionRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SubscriptionRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SUBSCRIPTIONREGISTRATION_WHERE_PKS_IN);

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

			for (SubscriptionRegistration subscriptionRegistration : (List<SubscriptionRegistration>)q.list()) {
				map.put(subscriptionRegistration.getPrimaryKeyObj(),
					subscriptionRegistration);

				cacheResult(subscriptionRegistration);

				uncachedPrimaryKeys.remove(subscriptionRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SubscriptionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					SubscriptionRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the subscription registrations.
	 *
	 * @return the subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subscription registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscription registrations
	 * @param end the upper bound of the range of subscription registrations (not inclusive)
	 * @return the range of subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subscription registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscription registrations
	 * @param end the upper bound of the range of subscription registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findAll(int start, int end,
		OrderByComparator<SubscriptionRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subscription registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SubscriptionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscription registrations
	 * @param end the upper bound of the range of subscription registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of subscription registrations
	 */
	@Override
	public List<SubscriptionRegistration> findAll(int start, int end,
		OrderByComparator<SubscriptionRegistration> orderByComparator,
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

		List<SubscriptionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<SubscriptionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUBSCRIPTIONREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBSCRIPTIONREGISTRATION;

				if (pagination) {
					sql = sql.concat(SubscriptionRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SubscriptionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SubscriptionRegistration>)QueryUtil.list(q,
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
	 * Removes all the subscription registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SubscriptionRegistration subscriptionRegistration : findAll()) {
			remove(subscriptionRegistration);
		}
	}

	/**
	 * Returns the number of subscription registrations.
	 *
	 * @return the number of subscription registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUBSCRIPTIONREGISTRATION);

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
		return SubscriptionRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the subscription registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SubscriptionRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SUBSCRIPTIONREGISTRATION = "SELECT subscriptionRegistration FROM SubscriptionRegistration subscriptionRegistration";
	private static final String _SQL_SELECT_SUBSCRIPTIONREGISTRATION_WHERE_PKS_IN =
		"SELECT subscriptionRegistration FROM SubscriptionRegistration subscriptionRegistration WHERE SUSCRIBER_ID IN (";
	private static final String _SQL_SELECT_SUBSCRIPTIONREGISTRATION_WHERE = "SELECT subscriptionRegistration FROM SubscriptionRegistration subscriptionRegistration WHERE ";
	private static final String _SQL_COUNT_SUBSCRIPTIONREGISTRATION = "SELECT COUNT(subscriptionRegistration) FROM SubscriptionRegistration subscriptionRegistration";
	private static final String _SQL_COUNT_SUBSCRIPTIONREGISTRATION_WHERE = "SELECT COUNT(subscriptionRegistration) FROM SubscriptionRegistration subscriptionRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subscriptionRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubscriptionRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SubscriptionRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SubscriptionRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}