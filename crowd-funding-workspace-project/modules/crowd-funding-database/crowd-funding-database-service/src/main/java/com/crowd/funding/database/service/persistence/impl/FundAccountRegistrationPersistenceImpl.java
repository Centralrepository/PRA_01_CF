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

import com.crowd.funding.database.exception.NoSuchFundAccountRegistrationException;
import com.crowd.funding.database.model.FundAccountRegistration;
import com.crowd.funding.database.model.impl.FundAccountRegistrationImpl;
import com.crowd.funding.database.model.impl.FundAccountRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.FundAccountRegistrationPersistence;

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
 * The persistence implementation for the fund account registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundAccountRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.FundAccountRegistrationUtil
 * @generated
 */
@ProviderType
public class FundAccountRegistrationPersistenceImpl extends BasePersistenceImpl<FundAccountRegistration>
	implements FundAccountRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FundAccountRegistrationUtil} to access the fund account registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FundAccountRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundAccountRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundAccountRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundAccountRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundAccountRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FundAccountRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the fund account registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund account registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fund account registrations
	 * @param end the upper bound of the range of fund account registrations (not inclusive)
	 * @return the range of matching fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund account registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fund account registrations
	 * @param end the upper bound of the range of fund account registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FundAccountRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund account registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fund account registrations
	 * @param end the upper bound of the range of fund account registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FundAccountRegistration> orderByComparator,
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

		List<FundAccountRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundAccountRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FundAccountRegistration fundAccountRegistration : list) {
					if (!Objects.equals(uuid, fundAccountRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_FUNDACCOUNTREGISTRATION_WHERE);

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
				query.append(FundAccountRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<FundAccountRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundAccountRegistration>)QueryUtil.list(q,
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
	 * Returns the first fund account registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund account registration
	 * @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration findByUuid_First(String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException {
		FundAccountRegistration fundAccountRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (fundAccountRegistration != null) {
			return fundAccountRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFundAccountRegistrationException(msg.toString());
	}

	/**
	 * Returns the first fund account registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration fetchByUuid_First(String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		List<FundAccountRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund account registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund account registration
	 * @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration findByUuid_Last(String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException {
		FundAccountRegistration fundAccountRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (fundAccountRegistration != null) {
			return fundAccountRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFundAccountRegistrationException(msg.toString());
	}

	/**
	 * Returns the last fund account registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FundAccountRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund account registrations before and after the current fund account registration in the ordered set where uuid = &#63;.
	 *
	 * @param ACCOUNT_ID the primary key of the current fund account registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund account registration
	 * @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	 */
	@Override
	public FundAccountRegistration[] findByUuid_PrevAndNext(long ACCOUNT_ID,
		String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException {
		FundAccountRegistration fundAccountRegistration = findByPrimaryKey(ACCOUNT_ID);

		Session session = null;

		try {
			session = openSession();

			FundAccountRegistration[] array = new FundAccountRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, fundAccountRegistration,
					uuid, orderByComparator, true);

			array[1] = fundAccountRegistration;

			array[2] = getByUuid_PrevAndNext(session, fundAccountRegistration,
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

	protected FundAccountRegistration getByUuid_PrevAndNext(Session session,
		FundAccountRegistration fundAccountRegistration, String uuid,
		OrderByComparator<FundAccountRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_FUNDACCOUNTREGISTRATION_WHERE);

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
			query.append(FundAccountRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(fundAccountRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundAccountRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund account registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FundAccountRegistration fundAccountRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fundAccountRegistration);
		}
	}

	/**
	 * Returns the number of fund account registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fund account registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDACCOUNTREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "fundAccountRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "fundAccountRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(fundAccountRegistration.uuid IS NULL OR fundAccountRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_ACCOUNT_ID = new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundAccountRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByACCOUNT_ID", new String[] { Long.class.getName() },
			FundAccountRegistrationModelImpl.ACCOUNT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACCOUNT_ID = new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByACCOUNT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the fund account registration where ACCOUNT_ID = &#63; or throws a {@link NoSuchFundAccountRegistrationException} if it could not be found.
	 *
	 * @param ACCOUNT_ID the account_id
	 * @return the matching fund account registration
	 * @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration findByACCOUNT_ID(long ACCOUNT_ID)
		throws NoSuchFundAccountRegistrationException {
		FundAccountRegistration fundAccountRegistration = fetchByACCOUNT_ID(ACCOUNT_ID);

		if (fundAccountRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ACCOUNT_ID=");
			msg.append(ACCOUNT_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFundAccountRegistrationException(msg.toString());
		}

		return fundAccountRegistration;
	}

	/**
	 * Returns the fund account registration where ACCOUNT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ACCOUNT_ID the account_id
	 * @return the matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration fetchByACCOUNT_ID(long ACCOUNT_ID) {
		return fetchByACCOUNT_ID(ACCOUNT_ID, true);
	}

	/**
	 * Returns the fund account registration where ACCOUNT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ACCOUNT_ID the account_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration fetchByACCOUNT_ID(long ACCOUNT_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { ACCOUNT_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ACCOUNT_ID,
					finderArgs, this);
		}

		if (result instanceof FundAccountRegistration) {
			FundAccountRegistration fundAccountRegistration = (FundAccountRegistration)result;

			if ((ACCOUNT_ID != fundAccountRegistration.getACCOUNT_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FUNDACCOUNTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_ACCOUNT_ID_ACCOUNT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ACCOUNT_ID);

				List<FundAccountRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ACCOUNT_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"FundAccountRegistrationPersistenceImpl.fetchByACCOUNT_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FundAccountRegistration fundAccountRegistration = list.get(0);

					result = fundAccountRegistration;

					cacheResult(fundAccountRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ACCOUNT_ID,
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
			return (FundAccountRegistration)result;
		}
	}

	/**
	 * Removes the fund account registration where ACCOUNT_ID = &#63; from the database.
	 *
	 * @param ACCOUNT_ID the account_id
	 * @return the fund account registration that was removed
	 */
	@Override
	public FundAccountRegistration removeByACCOUNT_ID(long ACCOUNT_ID)
		throws NoSuchFundAccountRegistrationException {
		FundAccountRegistration fundAccountRegistration = findByACCOUNT_ID(ACCOUNT_ID);

		return remove(fundAccountRegistration);
	}

	/**
	 * Returns the number of fund account registrations where ACCOUNT_ID = &#63;.
	 *
	 * @param ACCOUNT_ID the account_id
	 * @return the number of matching fund account registrations
	 */
	@Override
	public int countByACCOUNT_ID(long ACCOUNT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACCOUNT_ID;

		Object[] finderArgs = new Object[] { ACCOUNT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDACCOUNTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_ACCOUNT_ID_ACCOUNT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ACCOUNT_ID);

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

	private static final String _FINDER_COLUMN_ACCOUNT_ID_ACCOUNT_ID_2 = "fundAccountRegistration.ACCOUNT_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundAccountRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundAccountRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			FundAccountRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fund account registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund account registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of fund account registrations
	 * @param end the upper bound of the range of fund account registrations (not inclusive)
	 * @return the range of matching fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund account registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of fund account registrations
	 * @param end the upper bound of the range of fund account registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund account registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of fund account registrations
	 * @param end the upper bound of the range of fund account registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator,
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

		List<FundAccountRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundAccountRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FundAccountRegistration fundAccountRegistration : list) {
					if ((PROJECT_ID != fundAccountRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_FUNDACCOUNTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundAccountRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<FundAccountRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundAccountRegistration>)QueryUtil.list(q,
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
	 * Returns the first fund account registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund account registration
	 * @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException {
		FundAccountRegistration fundAccountRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (fundAccountRegistration != null) {
			return fundAccountRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchFundAccountRegistrationException(msg.toString());
	}

	/**
	 * Returns the first fund account registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		List<FundAccountRegistration> list = findByPROJECT_ID(PROJECT_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund account registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund account registration
	 * @throws NoSuchFundAccountRegistrationException if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException {
		FundAccountRegistration fundAccountRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (fundAccountRegistration != null) {
			return fundAccountRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchFundAccountRegistrationException(msg.toString());
	}

	/**
	 * Returns the last fund account registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund account registration, or <code>null</code> if a matching fund account registration could not be found
	 */
	@Override
	public FundAccountRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<FundAccountRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund account registrations before and after the current fund account registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param ACCOUNT_ID the primary key of the current fund account registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund account registration
	 * @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	 */
	@Override
	public FundAccountRegistration[] findByPROJECT_ID_PrevAndNext(
		long ACCOUNT_ID, long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator)
		throws NoSuchFundAccountRegistrationException {
		FundAccountRegistration fundAccountRegistration = findByPrimaryKey(ACCOUNT_ID);

		Session session = null;

		try {
			session = openSession();

			FundAccountRegistration[] array = new FundAccountRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					fundAccountRegistration, PROJECT_ID, orderByComparator, true);

			array[1] = fundAccountRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					fundAccountRegistration, PROJECT_ID, orderByComparator,
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

	protected FundAccountRegistration getByPROJECT_ID_PrevAndNext(
		Session session, FundAccountRegistration fundAccountRegistration,
		long PROJECT_ID,
		OrderByComparator<FundAccountRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_FUNDACCOUNTREGISTRATION_WHERE);

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
			query.append(FundAccountRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fundAccountRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundAccountRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund account registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (FundAccountRegistration fundAccountRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fundAccountRegistration);
		}
	}

	/**
	 * Returns the number of fund account registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching fund account registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDACCOUNTREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "fundAccountRegistration.PROJECT_ID = ?";

	public FundAccountRegistrationPersistenceImpl() {
		setModelClass(FundAccountRegistration.class);

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
	 * Caches the fund account registration in the entity cache if it is enabled.
	 *
	 * @param fundAccountRegistration the fund account registration
	 */
	@Override
	public void cacheResult(FundAccountRegistration fundAccountRegistration) {
		entityCache.putResult(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationImpl.class,
			fundAccountRegistration.getPrimaryKey(), fundAccountRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ACCOUNT_ID,
			new Object[] { fundAccountRegistration.getACCOUNT_ID() },
			fundAccountRegistration);

		fundAccountRegistration.resetOriginalValues();
	}

	/**
	 * Caches the fund account registrations in the entity cache if it is enabled.
	 *
	 * @param fundAccountRegistrations the fund account registrations
	 */
	@Override
	public void cacheResult(
		List<FundAccountRegistration> fundAccountRegistrations) {
		for (FundAccountRegistration fundAccountRegistration : fundAccountRegistrations) {
			if (entityCache.getResult(
						FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FundAccountRegistrationImpl.class,
						fundAccountRegistration.getPrimaryKey()) == null) {
				cacheResult(fundAccountRegistration);
			}
			else {
				fundAccountRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fund account registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FundAccountRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fund account registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FundAccountRegistration fundAccountRegistration) {
		entityCache.removeResult(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationImpl.class,
			fundAccountRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FundAccountRegistrationModelImpl)fundAccountRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<FundAccountRegistration> fundAccountRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FundAccountRegistration fundAccountRegistration : fundAccountRegistrations) {
			entityCache.removeResult(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FundAccountRegistrationImpl.class,
				fundAccountRegistration.getPrimaryKey());

			clearUniqueFindersCache((FundAccountRegistrationModelImpl)fundAccountRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		FundAccountRegistrationModelImpl fundAccountRegistrationModelImpl) {
		Object[] args = new Object[] {
				fundAccountRegistrationModelImpl.getACCOUNT_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_ACCOUNT_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ACCOUNT_ID, args,
			fundAccountRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		FundAccountRegistrationModelImpl fundAccountRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					fundAccountRegistrationModelImpl.getACCOUNT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACCOUNT_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ACCOUNT_ID, args);
		}

		if ((fundAccountRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ACCOUNT_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					fundAccountRegistrationModelImpl.getOriginalACCOUNT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ACCOUNT_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ACCOUNT_ID, args);
		}
	}

	/**
	 * Creates a new fund account registration with the primary key. Does not add the fund account registration to the database.
	 *
	 * @param ACCOUNT_ID the primary key for the new fund account registration
	 * @return the new fund account registration
	 */
	@Override
	public FundAccountRegistration create(long ACCOUNT_ID) {
		FundAccountRegistration fundAccountRegistration = new FundAccountRegistrationImpl();

		fundAccountRegistration.setNew(true);
		fundAccountRegistration.setPrimaryKey(ACCOUNT_ID);

		String uuid = PortalUUIDUtil.generate();

		fundAccountRegistration.setUuid(uuid);

		return fundAccountRegistration;
	}

	/**
	 * Removes the fund account registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ACCOUNT_ID the primary key of the fund account registration
	 * @return the fund account registration that was removed
	 * @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	 */
	@Override
	public FundAccountRegistration remove(long ACCOUNT_ID)
		throws NoSuchFundAccountRegistrationException {
		return remove((Serializable)ACCOUNT_ID);
	}

	/**
	 * Removes the fund account registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fund account registration
	 * @return the fund account registration that was removed
	 * @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	 */
	@Override
	public FundAccountRegistration remove(Serializable primaryKey)
		throws NoSuchFundAccountRegistrationException {
		Session session = null;

		try {
			session = openSession();

			FundAccountRegistration fundAccountRegistration = (FundAccountRegistration)session.get(FundAccountRegistrationImpl.class,
					primaryKey);

			if (fundAccountRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFundAccountRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fundAccountRegistration);
		}
		catch (NoSuchFundAccountRegistrationException nsee) {
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
	protected FundAccountRegistration removeImpl(
		FundAccountRegistration fundAccountRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fundAccountRegistration)) {
				fundAccountRegistration = (FundAccountRegistration)session.get(FundAccountRegistrationImpl.class,
						fundAccountRegistration.getPrimaryKeyObj());
			}

			if (fundAccountRegistration != null) {
				session.delete(fundAccountRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fundAccountRegistration != null) {
			clearCache(fundAccountRegistration);
		}

		return fundAccountRegistration;
	}

	@Override
	public FundAccountRegistration updateImpl(
		FundAccountRegistration fundAccountRegistration) {
		boolean isNew = fundAccountRegistration.isNew();

		if (!(fundAccountRegistration instanceof FundAccountRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fundAccountRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fundAccountRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fundAccountRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FundAccountRegistration implementation " +
				fundAccountRegistration.getClass());
		}

		FundAccountRegistrationModelImpl fundAccountRegistrationModelImpl = (FundAccountRegistrationModelImpl)fundAccountRegistration;

		if (Validator.isNull(fundAccountRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			fundAccountRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (fundAccountRegistration.isNew()) {
				session.save(fundAccountRegistration);

				fundAccountRegistration.setNew(false);
			}
			else {
				fundAccountRegistration = (FundAccountRegistration)session.merge(fundAccountRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!FundAccountRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					fundAccountRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { fundAccountRegistrationModelImpl.getPROJECT_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((fundAccountRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundAccountRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { fundAccountRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((fundAccountRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundAccountRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						fundAccountRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundAccountRegistrationImpl.class,
			fundAccountRegistration.getPrimaryKey(), fundAccountRegistration,
			false);

		clearUniqueFindersCache(fundAccountRegistrationModelImpl, false);
		cacheUniqueFindersCache(fundAccountRegistrationModelImpl);

		fundAccountRegistration.resetOriginalValues();

		return fundAccountRegistration;
	}

	/**
	 * Returns the fund account registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund account registration
	 * @return the fund account registration
	 * @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	 */
	@Override
	public FundAccountRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFundAccountRegistrationException {
		FundAccountRegistration fundAccountRegistration = fetchByPrimaryKey(primaryKey);

		if (fundAccountRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFundAccountRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fundAccountRegistration;
	}

	/**
	 * Returns the fund account registration with the primary key or throws a {@link NoSuchFundAccountRegistrationException} if it could not be found.
	 *
	 * @param ACCOUNT_ID the primary key of the fund account registration
	 * @return the fund account registration
	 * @throws NoSuchFundAccountRegistrationException if a fund account registration with the primary key could not be found
	 */
	@Override
	public FundAccountRegistration findByPrimaryKey(long ACCOUNT_ID)
		throws NoSuchFundAccountRegistrationException {
		return findByPrimaryKey((Serializable)ACCOUNT_ID);
	}

	/**
	 * Returns the fund account registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund account registration
	 * @return the fund account registration, or <code>null</code> if a fund account registration with the primary key could not be found
	 */
	@Override
	public FundAccountRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FundAccountRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FundAccountRegistration fundAccountRegistration = (FundAccountRegistration)serializable;

		if (fundAccountRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				fundAccountRegistration = (FundAccountRegistration)session.get(FundAccountRegistrationImpl.class,
						primaryKey);

				if (fundAccountRegistration != null) {
					cacheResult(fundAccountRegistration);
				}
				else {
					entityCache.putResult(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FundAccountRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FundAccountRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fundAccountRegistration;
	}

	/**
	 * Returns the fund account registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ACCOUNT_ID the primary key of the fund account registration
	 * @return the fund account registration, or <code>null</code> if a fund account registration with the primary key could not be found
	 */
	@Override
	public FundAccountRegistration fetchByPrimaryKey(long ACCOUNT_ID) {
		return fetchByPrimaryKey((Serializable)ACCOUNT_ID);
	}

	@Override
	public Map<Serializable, FundAccountRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FundAccountRegistration> map = new HashMap<Serializable, FundAccountRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FundAccountRegistration fundAccountRegistration = fetchByPrimaryKey(primaryKey);

			if (fundAccountRegistration != null) {
				map.put(primaryKey, fundAccountRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FundAccountRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FundAccountRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FUNDACCOUNTREGISTRATION_WHERE_PKS_IN);

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

			for (FundAccountRegistration fundAccountRegistration : (List<FundAccountRegistration>)q.list()) {
				map.put(fundAccountRegistration.getPrimaryKeyObj(),
					fundAccountRegistration);

				cacheResult(fundAccountRegistration);

				uncachedPrimaryKeys.remove(fundAccountRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FundAccountRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FundAccountRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the fund account registrations.
	 *
	 * @return the fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund account registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund account registrations
	 * @param end the upper bound of the range of fund account registrations (not inclusive)
	 * @return the range of fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund account registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund account registrations
	 * @param end the upper bound of the range of fund account registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findAll(int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund account registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundAccountRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund account registrations
	 * @param end the upper bound of the range of fund account registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of fund account registrations
	 */
	@Override
	public List<FundAccountRegistration> findAll(int start, int end,
		OrderByComparator<FundAccountRegistration> orderByComparator,
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

		List<FundAccountRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundAccountRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FUNDACCOUNTREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUNDACCOUNTREGISTRATION;

				if (pagination) {
					sql = sql.concat(FundAccountRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FundAccountRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundAccountRegistration>)QueryUtil.list(q,
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
	 * Removes all the fund account registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FundAccountRegistration fundAccountRegistration : findAll()) {
			remove(fundAccountRegistration);
		}
	}

	/**
	 * Returns the number of fund account registrations.
	 *
	 * @return the number of fund account registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FUNDACCOUNTREGISTRATION);

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
		return FundAccountRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fund account registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FundAccountRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FUNDACCOUNTREGISTRATION = "SELECT fundAccountRegistration FROM FundAccountRegistration fundAccountRegistration";
	private static final String _SQL_SELECT_FUNDACCOUNTREGISTRATION_WHERE_PKS_IN =
		"SELECT fundAccountRegistration FROM FundAccountRegistration fundAccountRegistration WHERE ACCOUNT_ID IN (";
	private static final String _SQL_SELECT_FUNDACCOUNTREGISTRATION_WHERE = "SELECT fundAccountRegistration FROM FundAccountRegistration fundAccountRegistration WHERE ";
	private static final String _SQL_COUNT_FUNDACCOUNTREGISTRATION = "SELECT COUNT(fundAccountRegistration) FROM FundAccountRegistration fundAccountRegistration";
	private static final String _SQL_COUNT_FUNDACCOUNTREGISTRATION_WHERE = "SELECT COUNT(fundAccountRegistration) FROM FundAccountRegistration fundAccountRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fundAccountRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FundAccountRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FundAccountRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FundAccountRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}