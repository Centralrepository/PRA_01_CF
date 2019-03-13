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

import com.crowd.funding.database.exception.NoSuchFundReleaseRegistrationException;
import com.crowd.funding.database.model.FundReleaseRegistration;
import com.crowd.funding.database.model.impl.FundReleaseRegistrationImpl;
import com.crowd.funding.database.model.impl.FundReleaseRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.FundReleaseRegistrationPersistence;

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
 * The persistence implementation for the fund release registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundReleaseRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.FundReleaseRegistrationUtil
 * @generated
 */
@ProviderType
public class FundReleaseRegistrationPersistenceImpl extends BasePersistenceImpl<FundReleaseRegistration>
	implements FundReleaseRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FundReleaseRegistrationUtil} to access the fund release registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FundReleaseRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FundReleaseRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the fund release registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund release registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fund release registrations
	 * @param end the upper bound of the range of fund release registrations (not inclusive)
	 * @return the range of matching fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund release registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fund release registrations
	 * @param end the upper bound of the range of fund release registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund release registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fund release registrations
	 * @param end the upper bound of the range of fund release registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<FundReleaseRegistration> orderByComparator,
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

		List<FundReleaseRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundReleaseRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FundReleaseRegistration fundReleaseRegistration : list) {
					if (!Objects.equals(uuid, fundReleaseRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_FUNDRELEASEREGISTRATION_WHERE);

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
				query.append(FundReleaseRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<FundReleaseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundReleaseRegistration>)QueryUtil.list(q,
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
	 * Returns the first fund release registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund release registration
	 * @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration findByUuid_First(String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException {
		FundReleaseRegistration fundReleaseRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (fundReleaseRegistration != null) {
			return fundReleaseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFundReleaseRegistrationException(msg.toString());
	}

	/**
	 * Returns the first fund release registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration fetchByUuid_First(String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		List<FundReleaseRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund release registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund release registration
	 * @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration findByUuid_Last(String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException {
		FundReleaseRegistration fundReleaseRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (fundReleaseRegistration != null) {
			return fundReleaseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFundReleaseRegistrationException(msg.toString());
	}

	/**
	 * Returns the last fund release registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FundReleaseRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund release registrations before and after the current fund release registration in the ordered set where uuid = &#63;.
	 *
	 * @param FUND_RELEASE_ID the primary key of the current fund release registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund release registration
	 * @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	 */
	@Override
	public FundReleaseRegistration[] findByUuid_PrevAndNext(
		long FUND_RELEASE_ID, String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException {
		FundReleaseRegistration fundReleaseRegistration = findByPrimaryKey(FUND_RELEASE_ID);

		Session session = null;

		try {
			session = openSession();

			FundReleaseRegistration[] array = new FundReleaseRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, fundReleaseRegistration,
					uuid, orderByComparator, true);

			array[1] = fundReleaseRegistration;

			array[2] = getByUuid_PrevAndNext(session, fundReleaseRegistration,
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

	protected FundReleaseRegistration getByUuid_PrevAndNext(Session session,
		FundReleaseRegistration fundReleaseRegistration, String uuid,
		OrderByComparator<FundReleaseRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_FUNDRELEASEREGISTRATION_WHERE);

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
			query.append(FundReleaseRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(fundReleaseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundReleaseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund release registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FundReleaseRegistration fundReleaseRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fundReleaseRegistration);
		}
	}

	/**
	 * Returns the number of fund release registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fund release registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDRELEASEREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "fundReleaseRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "fundReleaseRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(fundReleaseRegistration.uuid IS NULL OR fundReleaseRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_FUND_RELEASE_ID = new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFUND_RELEASE_ID", new String[] { Long.class.getName() },
			FundReleaseRegistrationModelImpl.FUND_RELEASE_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FUND_RELEASE_ID = new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFUND_RELEASE_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the fund release registration where FUND_RELEASE_ID = &#63; or throws a {@link NoSuchFundReleaseRegistrationException} if it could not be found.
	 *
	 * @param FUND_RELEASE_ID the fund_release_id
	 * @return the matching fund release registration
	 * @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration findByFUND_RELEASE_ID(long FUND_RELEASE_ID)
		throws NoSuchFundReleaseRegistrationException {
		FundReleaseRegistration fundReleaseRegistration = fetchByFUND_RELEASE_ID(FUND_RELEASE_ID);

		if (fundReleaseRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("FUND_RELEASE_ID=");
			msg.append(FUND_RELEASE_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFundReleaseRegistrationException(msg.toString());
		}

		return fundReleaseRegistration;
	}

	/**
	 * Returns the fund release registration where FUND_RELEASE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param FUND_RELEASE_ID the fund_release_id
	 * @return the matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration fetchByFUND_RELEASE_ID(long FUND_RELEASE_ID) {
		return fetchByFUND_RELEASE_ID(FUND_RELEASE_ID, true);
	}

	/**
	 * Returns the fund release registration where FUND_RELEASE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param FUND_RELEASE_ID the fund_release_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration fetchByFUND_RELEASE_ID(
		long FUND_RELEASE_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { FUND_RELEASE_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_FUND_RELEASE_ID,
					finderArgs, this);
		}

		if (result instanceof FundReleaseRegistration) {
			FundReleaseRegistration fundReleaseRegistration = (FundReleaseRegistration)result;

			if ((FUND_RELEASE_ID != fundReleaseRegistration.getFUND_RELEASE_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FUNDRELEASEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_FUND_RELEASE_ID_FUND_RELEASE_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FUND_RELEASE_ID);

				List<FundReleaseRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_FUND_RELEASE_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"FundReleaseRegistrationPersistenceImpl.fetchByFUND_RELEASE_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FundReleaseRegistration fundReleaseRegistration = list.get(0);

					result = fundReleaseRegistration;

					cacheResult(fundReleaseRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_FUND_RELEASE_ID,
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
			return (FundReleaseRegistration)result;
		}
	}

	/**
	 * Removes the fund release registration where FUND_RELEASE_ID = &#63; from the database.
	 *
	 * @param FUND_RELEASE_ID the fund_release_id
	 * @return the fund release registration that was removed
	 */
	@Override
	public FundReleaseRegistration removeByFUND_RELEASE_ID(long FUND_RELEASE_ID)
		throws NoSuchFundReleaseRegistrationException {
		FundReleaseRegistration fundReleaseRegistration = findByFUND_RELEASE_ID(FUND_RELEASE_ID);

		return remove(fundReleaseRegistration);
	}

	/**
	 * Returns the number of fund release registrations where FUND_RELEASE_ID = &#63;.
	 *
	 * @param FUND_RELEASE_ID the fund_release_id
	 * @return the number of matching fund release registrations
	 */
	@Override
	public int countByFUND_RELEASE_ID(long FUND_RELEASE_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FUND_RELEASE_ID;

		Object[] finderArgs = new Object[] { FUND_RELEASE_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDRELEASEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_FUND_RELEASE_ID_FUND_RELEASE_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(FUND_RELEASE_ID);

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

	private static final String _FINDER_COLUMN_FUND_RELEASE_ID_FUND_RELEASE_ID_2 =
		"fundReleaseRegistration.FUND_RELEASE_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			FundReleaseRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fund release registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund release registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of fund release registrations
	 * @param end the upper bound of the range of fund release registrations (not inclusive)
	 * @return the range of matching fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund release registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of fund release registrations
	 * @param end the upper bound of the range of fund release registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund release registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of fund release registrations
	 * @param end the upper bound of the range of fund release registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator,
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

		List<FundReleaseRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundReleaseRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FundReleaseRegistration fundReleaseRegistration : list) {
					if ((PROJECT_ID != fundReleaseRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_FUNDRELEASEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundReleaseRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<FundReleaseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundReleaseRegistration>)QueryUtil.list(q,
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
	 * Returns the first fund release registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund release registration
	 * @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException {
		FundReleaseRegistration fundReleaseRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (fundReleaseRegistration != null) {
			return fundReleaseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchFundReleaseRegistrationException(msg.toString());
	}

	/**
	 * Returns the first fund release registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		List<FundReleaseRegistration> list = findByPROJECT_ID(PROJECT_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund release registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund release registration
	 * @throws NoSuchFundReleaseRegistrationException if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException {
		FundReleaseRegistration fundReleaseRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (fundReleaseRegistration != null) {
			return fundReleaseRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchFundReleaseRegistrationException(msg.toString());
	}

	/**
	 * Returns the last fund release registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund release registration, or <code>null</code> if a matching fund release registration could not be found
	 */
	@Override
	public FundReleaseRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<FundReleaseRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund release registrations before and after the current fund release registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param FUND_RELEASE_ID the primary key of the current fund release registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund release registration
	 * @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	 */
	@Override
	public FundReleaseRegistration[] findByPROJECT_ID_PrevAndNext(
		long FUND_RELEASE_ID, long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator)
		throws NoSuchFundReleaseRegistrationException {
		FundReleaseRegistration fundReleaseRegistration = findByPrimaryKey(FUND_RELEASE_ID);

		Session session = null;

		try {
			session = openSession();

			FundReleaseRegistration[] array = new FundReleaseRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					fundReleaseRegistration, PROJECT_ID, orderByComparator, true);

			array[1] = fundReleaseRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					fundReleaseRegistration, PROJECT_ID, orderByComparator,
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

	protected FundReleaseRegistration getByPROJECT_ID_PrevAndNext(
		Session session, FundReleaseRegistration fundReleaseRegistration,
		long PROJECT_ID,
		OrderByComparator<FundReleaseRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_FUNDRELEASEREGISTRATION_WHERE);

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
			query.append(FundReleaseRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fundReleaseRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundReleaseRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund release registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (FundReleaseRegistration fundReleaseRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fundReleaseRegistration);
		}
	}

	/**
	 * Returns the number of fund release registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching fund release registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDRELEASEREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "fundReleaseRegistration.PROJECT_ID = ?";

	public FundReleaseRegistrationPersistenceImpl() {
		setModelClass(FundReleaseRegistration.class);

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
	 * Caches the fund release registration in the entity cache if it is enabled.
	 *
	 * @param fundReleaseRegistration the fund release registration
	 */
	@Override
	public void cacheResult(FundReleaseRegistration fundReleaseRegistration) {
		entityCache.putResult(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class,
			fundReleaseRegistration.getPrimaryKey(), fundReleaseRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_FUND_RELEASE_ID,
			new Object[] { fundReleaseRegistration.getFUND_RELEASE_ID() },
			fundReleaseRegistration);

		fundReleaseRegistration.resetOriginalValues();
	}

	/**
	 * Caches the fund release registrations in the entity cache if it is enabled.
	 *
	 * @param fundReleaseRegistrations the fund release registrations
	 */
	@Override
	public void cacheResult(
		List<FundReleaseRegistration> fundReleaseRegistrations) {
		for (FundReleaseRegistration fundReleaseRegistration : fundReleaseRegistrations) {
			if (entityCache.getResult(
						FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FundReleaseRegistrationImpl.class,
						fundReleaseRegistration.getPrimaryKey()) == null) {
				cacheResult(fundReleaseRegistration);
			}
			else {
				fundReleaseRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fund release registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FundReleaseRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fund release registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FundReleaseRegistration fundReleaseRegistration) {
		entityCache.removeResult(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class,
			fundReleaseRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FundReleaseRegistrationModelImpl)fundReleaseRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<FundReleaseRegistration> fundReleaseRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FundReleaseRegistration fundReleaseRegistration : fundReleaseRegistrations) {
			entityCache.removeResult(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FundReleaseRegistrationImpl.class,
				fundReleaseRegistration.getPrimaryKey());

			clearUniqueFindersCache((FundReleaseRegistrationModelImpl)fundReleaseRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		FundReleaseRegistrationModelImpl fundReleaseRegistrationModelImpl) {
		Object[] args = new Object[] {
				fundReleaseRegistrationModelImpl.getFUND_RELEASE_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_FUND_RELEASE_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_FUND_RELEASE_ID, args,
			fundReleaseRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		FundReleaseRegistrationModelImpl fundReleaseRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					fundReleaseRegistrationModelImpl.getFUND_RELEASE_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FUND_RELEASE_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_FUND_RELEASE_ID, args);
		}

		if ((fundReleaseRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FUND_RELEASE_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					fundReleaseRegistrationModelImpl.getOriginalFUND_RELEASE_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_FUND_RELEASE_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_FUND_RELEASE_ID, args);
		}
	}

	/**
	 * Creates a new fund release registration with the primary key. Does not add the fund release registration to the database.
	 *
	 * @param FUND_RELEASE_ID the primary key for the new fund release registration
	 * @return the new fund release registration
	 */
	@Override
	public FundReleaseRegistration create(long FUND_RELEASE_ID) {
		FundReleaseRegistration fundReleaseRegistration = new FundReleaseRegistrationImpl();

		fundReleaseRegistration.setNew(true);
		fundReleaseRegistration.setPrimaryKey(FUND_RELEASE_ID);

		String uuid = PortalUUIDUtil.generate();

		fundReleaseRegistration.setUuid(uuid);

		return fundReleaseRegistration;
	}

	/**
	 * Removes the fund release registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param FUND_RELEASE_ID the primary key of the fund release registration
	 * @return the fund release registration that was removed
	 * @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	 */
	@Override
	public FundReleaseRegistration remove(long FUND_RELEASE_ID)
		throws NoSuchFundReleaseRegistrationException {
		return remove((Serializable)FUND_RELEASE_ID);
	}

	/**
	 * Removes the fund release registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fund release registration
	 * @return the fund release registration that was removed
	 * @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	 */
	@Override
	public FundReleaseRegistration remove(Serializable primaryKey)
		throws NoSuchFundReleaseRegistrationException {
		Session session = null;

		try {
			session = openSession();

			FundReleaseRegistration fundReleaseRegistration = (FundReleaseRegistration)session.get(FundReleaseRegistrationImpl.class,
					primaryKey);

			if (fundReleaseRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFundReleaseRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fundReleaseRegistration);
		}
		catch (NoSuchFundReleaseRegistrationException nsee) {
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
	protected FundReleaseRegistration removeImpl(
		FundReleaseRegistration fundReleaseRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fundReleaseRegistration)) {
				fundReleaseRegistration = (FundReleaseRegistration)session.get(FundReleaseRegistrationImpl.class,
						fundReleaseRegistration.getPrimaryKeyObj());
			}

			if (fundReleaseRegistration != null) {
				session.delete(fundReleaseRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fundReleaseRegistration != null) {
			clearCache(fundReleaseRegistration);
		}

		return fundReleaseRegistration;
	}

	@Override
	public FundReleaseRegistration updateImpl(
		FundReleaseRegistration fundReleaseRegistration) {
		boolean isNew = fundReleaseRegistration.isNew();

		if (!(fundReleaseRegistration instanceof FundReleaseRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fundReleaseRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fundReleaseRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fundReleaseRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FundReleaseRegistration implementation " +
				fundReleaseRegistration.getClass());
		}

		FundReleaseRegistrationModelImpl fundReleaseRegistrationModelImpl = (FundReleaseRegistrationModelImpl)fundReleaseRegistration;

		if (Validator.isNull(fundReleaseRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			fundReleaseRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (fundReleaseRegistration.isNew()) {
				session.save(fundReleaseRegistration);

				fundReleaseRegistration.setNew(false);
			}
			else {
				fundReleaseRegistration = (FundReleaseRegistration)session.merge(fundReleaseRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!FundReleaseRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					fundReleaseRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { fundReleaseRegistrationModelImpl.getPROJECT_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((fundReleaseRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundReleaseRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { fundReleaseRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((fundReleaseRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundReleaseRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						fundReleaseRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundReleaseRegistrationImpl.class,
			fundReleaseRegistration.getPrimaryKey(), fundReleaseRegistration,
			false);

		clearUniqueFindersCache(fundReleaseRegistrationModelImpl, false);
		cacheUniqueFindersCache(fundReleaseRegistrationModelImpl);

		fundReleaseRegistration.resetOriginalValues();

		return fundReleaseRegistration;
	}

	/**
	 * Returns the fund release registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund release registration
	 * @return the fund release registration
	 * @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	 */
	@Override
	public FundReleaseRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFundReleaseRegistrationException {
		FundReleaseRegistration fundReleaseRegistration = fetchByPrimaryKey(primaryKey);

		if (fundReleaseRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFundReleaseRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fundReleaseRegistration;
	}

	/**
	 * Returns the fund release registration with the primary key or throws a {@link NoSuchFundReleaseRegistrationException} if it could not be found.
	 *
	 * @param FUND_RELEASE_ID the primary key of the fund release registration
	 * @return the fund release registration
	 * @throws NoSuchFundReleaseRegistrationException if a fund release registration with the primary key could not be found
	 */
	@Override
	public FundReleaseRegistration findByPrimaryKey(long FUND_RELEASE_ID)
		throws NoSuchFundReleaseRegistrationException {
		return findByPrimaryKey((Serializable)FUND_RELEASE_ID);
	}

	/**
	 * Returns the fund release registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund release registration
	 * @return the fund release registration, or <code>null</code> if a fund release registration with the primary key could not be found
	 */
	@Override
	public FundReleaseRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FundReleaseRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FundReleaseRegistration fundReleaseRegistration = (FundReleaseRegistration)serializable;

		if (fundReleaseRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				fundReleaseRegistration = (FundReleaseRegistration)session.get(FundReleaseRegistrationImpl.class,
						primaryKey);

				if (fundReleaseRegistration != null) {
					cacheResult(fundReleaseRegistration);
				}
				else {
					entityCache.putResult(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FundReleaseRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FundReleaseRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fundReleaseRegistration;
	}

	/**
	 * Returns the fund release registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param FUND_RELEASE_ID the primary key of the fund release registration
	 * @return the fund release registration, or <code>null</code> if a fund release registration with the primary key could not be found
	 */
	@Override
	public FundReleaseRegistration fetchByPrimaryKey(long FUND_RELEASE_ID) {
		return fetchByPrimaryKey((Serializable)FUND_RELEASE_ID);
	}

	@Override
	public Map<Serializable, FundReleaseRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FundReleaseRegistration> map = new HashMap<Serializable, FundReleaseRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FundReleaseRegistration fundReleaseRegistration = fetchByPrimaryKey(primaryKey);

			if (fundReleaseRegistration != null) {
				map.put(primaryKey, fundReleaseRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FundReleaseRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FundReleaseRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FUNDRELEASEREGISTRATION_WHERE_PKS_IN);

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

			for (FundReleaseRegistration fundReleaseRegistration : (List<FundReleaseRegistration>)q.list()) {
				map.put(fundReleaseRegistration.getPrimaryKeyObj(),
					fundReleaseRegistration);

				cacheResult(fundReleaseRegistration);

				uncachedPrimaryKeys.remove(fundReleaseRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FundReleaseRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FundReleaseRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the fund release registrations.
	 *
	 * @return the fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund release registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund release registrations
	 * @param end the upper bound of the range of fund release registrations (not inclusive)
	 * @return the range of fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund release registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund release registrations
	 * @param end the upper bound of the range of fund release registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findAll(int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund release registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundReleaseRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund release registrations
	 * @param end the upper bound of the range of fund release registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of fund release registrations
	 */
	@Override
	public List<FundReleaseRegistration> findAll(int start, int end,
		OrderByComparator<FundReleaseRegistration> orderByComparator,
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

		List<FundReleaseRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundReleaseRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FUNDRELEASEREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUNDRELEASEREGISTRATION;

				if (pagination) {
					sql = sql.concat(FundReleaseRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FundReleaseRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundReleaseRegistration>)QueryUtil.list(q,
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
	 * Removes all the fund release registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FundReleaseRegistration fundReleaseRegistration : findAll()) {
			remove(fundReleaseRegistration);
		}
	}

	/**
	 * Returns the number of fund release registrations.
	 *
	 * @return the number of fund release registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FUNDRELEASEREGISTRATION);

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
		return FundReleaseRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fund release registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FundReleaseRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FUNDRELEASEREGISTRATION = "SELECT fundReleaseRegistration FROM FundReleaseRegistration fundReleaseRegistration";
	private static final String _SQL_SELECT_FUNDRELEASEREGISTRATION_WHERE_PKS_IN =
		"SELECT fundReleaseRegistration FROM FundReleaseRegistration fundReleaseRegistration WHERE FUND_RELEASE_ID IN (";
	private static final String _SQL_SELECT_FUNDRELEASEREGISTRATION_WHERE = "SELECT fundReleaseRegistration FROM FundReleaseRegistration fundReleaseRegistration WHERE ";
	private static final String _SQL_COUNT_FUNDRELEASEREGISTRATION = "SELECT COUNT(fundReleaseRegistration) FROM FundReleaseRegistration fundReleaseRegistration";
	private static final String _SQL_COUNT_FUNDRELEASEREGISTRATION_WHERE = "SELECT COUNT(fundReleaseRegistration) FROM FundReleaseRegistration fundReleaseRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fundReleaseRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FundReleaseRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FundReleaseRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FundReleaseRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}