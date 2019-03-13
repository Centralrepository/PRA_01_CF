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

import com.crowd.funding.database.exception.NoSuchFundRegistrationException;
import com.crowd.funding.database.model.FundRegistration;
import com.crowd.funding.database.model.impl.FundRegistrationImpl;
import com.crowd.funding.database.model.impl.FundRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.FundRegistrationPersistence;

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
 * The persistence implementation for the fund registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.FundRegistrationUtil
 * @generated
 */
@ProviderType
public class FundRegistrationPersistenceImpl extends BasePersistenceImpl<FundRegistration>
	implements FundRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FundRegistrationUtil} to access the fund registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FundRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FundRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the fund registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @return the range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByUuid(String uuid, int start, int end,
		OrderByComparator<FundRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByUuid(String uuid, int start, int end,
		OrderByComparator<FundRegistration> orderByComparator,
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

		List<FundRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FundRegistration fundRegistration : list) {
					if (!Objects.equals(uuid, fundRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE);

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
				query.append(FundRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<FundRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundRegistration>)QueryUtil.list(q,
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
	 * Returns the first fund registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund registration
	 * @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration findByUuid_First(String uuid,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (fundRegistration != null) {
			return fundRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFundRegistrationException(msg.toString());
	}

	/**
	 * Returns the first fund registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByUuid_First(String uuid,
		OrderByComparator<FundRegistration> orderByComparator) {
		List<FundRegistration> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund registration
	 * @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration findByUuid_Last(String uuid,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (fundRegistration != null) {
			return fundRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFundRegistrationException(msg.toString());
	}

	/**
	 * Returns the last fund registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<FundRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FundRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund registrations before and after the current fund registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_FUND_ID the primary key of the current fund registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund registration
	 * @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration[] findByUuid_PrevAndNext(long PROJECT_FUND_ID,
		String uuid, OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = findByPrimaryKey(PROJECT_FUND_ID);

		Session session = null;

		try {
			session = openSession();

			FundRegistration[] array = new FundRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, fundRegistration, uuid,
					orderByComparator, true);

			array[1] = fundRegistration;

			array[2] = getByUuid_PrevAndNext(session, fundRegistration, uuid,
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

	protected FundRegistration getByUuid_PrevAndNext(Session session,
		FundRegistration fundRegistration, String uuid,
		OrderByComparator<FundRegistration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE);

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
			query.append(FundRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(fundRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FundRegistration fundRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fundRegistration);
		}
	}

	/**
	 * Returns the number of fund registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fund registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "fundRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "fundRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(fundRegistration.uuid IS NULL OR fundRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_FUND_ID = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_FUND_ID", new String[] { Long.class.getName() },
			FundRegistrationModelImpl.PROJECT_FUND_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_FUND_ID = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_FUND_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the fund registration where PROJECT_FUND_ID = &#63; or throws a {@link NoSuchFundRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_FUND_ID the project_fund_id
	 * @return the matching fund registration
	 * @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration findByPROJECT_FUND_ID(long PROJECT_FUND_ID)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByPROJECT_FUND_ID(PROJECT_FUND_ID);

		if (fundRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_FUND_ID=");
			msg.append(PROJECT_FUND_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFundRegistrationException(msg.toString());
		}

		return fundRegistration;
	}

	/**
	 * Returns the fund registration where PROJECT_FUND_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_FUND_ID the project_fund_id
	 * @return the matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByPROJECT_FUND_ID(long PROJECT_FUND_ID) {
		return fetchByPROJECT_FUND_ID(PROJECT_FUND_ID, true);
	}

	/**
	 * Returns the fund registration where PROJECT_FUND_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_FUND_ID the project_fund_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByPROJECT_FUND_ID(long PROJECT_FUND_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_FUND_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_FUND_ID,
					finderArgs, this);
		}

		if (result instanceof FundRegistration) {
			FundRegistration fundRegistration = (FundRegistration)result;

			if ((PROJECT_FUND_ID != fundRegistration.getPROJECT_FUND_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_FUND_ID_PROJECT_FUND_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_FUND_ID);

				List<FundRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FUND_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"FundRegistrationPersistenceImpl.fetchByPROJECT_FUND_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FundRegistration fundRegistration = list.get(0);

					result = fundRegistration;

					cacheResult(fundRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FUND_ID,
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
			return (FundRegistration)result;
		}
	}

	/**
	 * Removes the fund registration where PROJECT_FUND_ID = &#63; from the database.
	 *
	 * @param PROJECT_FUND_ID the project_fund_id
	 * @return the fund registration that was removed
	 */
	@Override
	public FundRegistration removeByPROJECT_FUND_ID(long PROJECT_FUND_ID)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = findByPROJECT_FUND_ID(PROJECT_FUND_ID);

		return remove(fundRegistration);
	}

	/**
	 * Returns the number of fund registrations where PROJECT_FUND_ID = &#63;.
	 *
	 * @param PROJECT_FUND_ID the project_fund_id
	 * @return the number of matching fund registrations
	 */
	@Override
	public int countByPROJECT_FUND_ID(long PROJECT_FUND_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_FUND_ID;

		Object[] finderArgs = new Object[] { PROJECT_FUND_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_FUND_ID_PROJECT_FUND_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_FUND_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_FUND_ID_PROJECT_FUND_ID_2 =
		"fundRegistration.PROJECT_FUND_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			FundRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fund registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @return the range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByPROJECT_ID(long PROJECT_ID, int start,
		int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByPROJECT_ID(long PROJECT_ID, int start,
		int end, OrderByComparator<FundRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByPROJECT_ID(long PROJECT_ID, int start,
		int end, OrderByComparator<FundRegistration> orderByComparator,
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

		List<FundRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FundRegistration fundRegistration : list) {
					if ((PROJECT_ID != fundRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<FundRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundRegistration>)QueryUtil.list(q,
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
	 * Returns the first fund registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund registration
	 * @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (fundRegistration != null) {
			return fundRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchFundRegistrationException(msg.toString());
	}

	/**
	 * Returns the first fund registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		List<FundRegistration> list = findByPROJECT_ID(PROJECT_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund registration
	 * @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (fundRegistration != null) {
			return fundRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchFundRegistrationException(msg.toString());
	}

	/**
	 * Returns the last fund registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<FundRegistration> list = findByPROJECT_ID(PROJECT_ID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund registrations before and after the current fund registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_FUND_ID the primary key of the current fund registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund registration
	 * @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FUND_ID, long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = findByPrimaryKey(PROJECT_FUND_ID);

		Session session = null;

		try {
			session = openSession();

			FundRegistration[] array = new FundRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session, fundRegistration,
					PROJECT_ID, orderByComparator, true);

			array[1] = fundRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session, fundRegistration,
					PROJECT_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FundRegistration getByPROJECT_ID_PrevAndNext(Session session,
		FundRegistration fundRegistration, long PROJECT_ID,
		OrderByComparator<FundRegistration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE);

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
			query.append(FundRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fundRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (FundRegistration fundRegistration : findByPROJECT_ID(PROJECT_ID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fundRegistration);
		}
	}

	/**
	 * Returns the number of fund registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching fund registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "fundRegistration.PROJECT_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DONOR_USER_ID =
		new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDONOR_USER_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONOR_USER_ID =
		new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDONOR_USER_ID",
			new String[] { Long.class.getName() },
			FundRegistrationModelImpl.DONOR_USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DONOR_USER_ID = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDONOR_USER_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the fund registrations where DONOR_USER_ID = &#63;.
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 * @return the matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByDONOR_USER_ID(long DONOR_USER_ID) {
		return findByDONOR_USER_ID(DONOR_USER_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund registrations where DONOR_USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @return the range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByDONOR_USER_ID(long DONOR_USER_ID,
		int start, int end) {
		return findByDONOR_USER_ID(DONOR_USER_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund registrations where DONOR_USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByDONOR_USER_ID(long DONOR_USER_ID,
		int start, int end,
		OrderByComparator<FundRegistration> orderByComparator) {
		return findByDONOR_USER_ID(DONOR_USER_ID, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund registrations where DONOR_USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByDONOR_USER_ID(long DONOR_USER_ID,
		int start, int end,
		OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONOR_USER_ID;
			finderArgs = new Object[] { DONOR_USER_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DONOR_USER_ID;
			finderArgs = new Object[] {
					DONOR_USER_ID,
					
					start, end, orderByComparator
				};
		}

		List<FundRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FundRegistration fundRegistration : list) {
					if ((DONOR_USER_ID != fundRegistration.getDONOR_USER_ID())) {
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

			query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_DONOR_USER_ID_DONOR_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(DONOR_USER_ID);

				if (!pagination) {
					list = (List<FundRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundRegistration>)QueryUtil.list(q,
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
	 * Returns the first fund registration in the ordered set where DONOR_USER_ID = &#63;.
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund registration
	 * @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration findByDONOR_USER_ID_First(long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByDONOR_USER_ID_First(DONOR_USER_ID,
				orderByComparator);

		if (fundRegistration != null) {
			return fundRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DONOR_USER_ID=");
		msg.append(DONOR_USER_ID);

		msg.append("}");

		throw new NoSuchFundRegistrationException(msg.toString());
	}

	/**
	 * Returns the first fund registration in the ordered set where DONOR_USER_ID = &#63;.
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByDONOR_USER_ID_First(long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		List<FundRegistration> list = findByDONOR_USER_ID(DONOR_USER_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund registration in the ordered set where DONOR_USER_ID = &#63;.
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund registration
	 * @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration findByDONOR_USER_ID_Last(long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByDONOR_USER_ID_Last(DONOR_USER_ID,
				orderByComparator);

		if (fundRegistration != null) {
			return fundRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DONOR_USER_ID=");
		msg.append(DONOR_USER_ID);

		msg.append("}");

		throw new NoSuchFundRegistrationException(msg.toString());
	}

	/**
	 * Returns the last fund registration in the ordered set where DONOR_USER_ID = &#63;.
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByDONOR_USER_ID_Last(long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		int count = countByDONOR_USER_ID(DONOR_USER_ID);

		if (count == 0) {
			return null;
		}

		List<FundRegistration> list = findByDONOR_USER_ID(DONOR_USER_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund registrations before and after the current fund registration in the ordered set where DONOR_USER_ID = &#63;.
	 *
	 * @param PROJECT_FUND_ID the primary key of the current fund registration
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund registration
	 * @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration[] findByDONOR_USER_ID_PrevAndNext(
		long PROJECT_FUND_ID, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = findByPrimaryKey(PROJECT_FUND_ID);

		Session session = null;

		try {
			session = openSession();

			FundRegistration[] array = new FundRegistrationImpl[3];

			array[0] = getByDONOR_USER_ID_PrevAndNext(session,
					fundRegistration, DONOR_USER_ID, orderByComparator, true);

			array[1] = fundRegistration;

			array[2] = getByDONOR_USER_ID_PrevAndNext(session,
					fundRegistration, DONOR_USER_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FundRegistration getByDONOR_USER_ID_PrevAndNext(Session session,
		FundRegistration fundRegistration, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_DONOR_USER_ID_DONOR_USER_ID_2);

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
			query.append(FundRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(DONOR_USER_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fundRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund registrations where DONOR_USER_ID = &#63; from the database.
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 */
	@Override
	public void removeByDONOR_USER_ID(long DONOR_USER_ID) {
		for (FundRegistration fundRegistration : findByDONOR_USER_ID(
				DONOR_USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(fundRegistration);
		}
	}

	/**
	 * Returns the number of fund registrations where DONOR_USER_ID = &#63;.
	 *
	 * @param DONOR_USER_ID the donor_user_id
	 * @return the number of matching fund registrations
	 */
	@Override
	public int countByDONOR_USER_ID(long DONOR_USER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DONOR_USER_ID;

		Object[] finderArgs = new Object[] { DONOR_USER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FUNDREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_DONOR_USER_ID_DONOR_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(DONOR_USER_ID);

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

	private static final String _FINDER_COLUMN_DONOR_USER_ID_DONOR_USER_ID_2 = "fundRegistration.DONOR_USER_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_DONOR_USER_ID =
		new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPROJECT_DONOR_USER_ID",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_DONOR_USER_ID =
		new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FundRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPROJECT_DONOR_USER_ID",
			new String[] { Long.class.getName(), Long.class.getName() },
			FundRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK |
			FundRegistrationModelImpl.DONOR_USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_DONOR_USER_ID = new FinderPath(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_DONOR_USER_ID",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @return the matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByPROJECT_DONOR_USER_ID(long PROJECT_ID,
		long DONOR_USER_ID) {
		return findByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @return the range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByPROJECT_DONOR_USER_ID(long PROJECT_ID,
		long DONOR_USER_ID, int start, int end) {
		return findByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByPROJECT_DONOR_USER_ID(long PROJECT_ID,
		long DONOR_USER_ID, int start, int end,
		OrderByComparator<FundRegistration> orderByComparator) {
		return findByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching fund registrations
	 */
	@Override
	public List<FundRegistration> findByPROJECT_DONOR_USER_ID(long PROJECT_ID,
		long DONOR_USER_ID, int start, int end,
		OrderByComparator<FundRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_DONOR_USER_ID;
			finderArgs = new Object[] { PROJECT_ID, DONOR_USER_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_DONOR_USER_ID;
			finderArgs = new Object[] {
					PROJECT_ID, DONOR_USER_ID,
					
					start, end, orderByComparator
				};
		}

		List<FundRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FundRegistration fundRegistration : list) {
					if ((PROJECT_ID != fundRegistration.getPROJECT_ID()) ||
							(DONOR_USER_ID != fundRegistration.getDONOR_USER_ID())) {
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

			query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_DONOR_USER_ID_PROJECT_ID_2);

			query.append(_FINDER_COLUMN_PROJECT_DONOR_USER_ID_DONOR_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FundRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				qPos.add(DONOR_USER_ID);

				if (!pagination) {
					list = (List<FundRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundRegistration>)QueryUtil.list(q,
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
	 * Returns the first fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund registration
	 * @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration findByPROJECT_DONOR_USER_ID_First(long PROJECT_ID,
		long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByPROJECT_DONOR_USER_ID_First(PROJECT_ID,
				DONOR_USER_ID, orderByComparator);

		if (fundRegistration != null) {
			return fundRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append(", DONOR_USER_ID=");
		msg.append(DONOR_USER_ID);

		msg.append("}");

		throw new NoSuchFundRegistrationException(msg.toString());
	}

	/**
	 * Returns the first fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByPROJECT_DONOR_USER_ID_First(
		long PROJECT_ID, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		List<FundRegistration> list = findByPROJECT_DONOR_USER_ID(PROJECT_ID,
				DONOR_USER_ID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund registration
	 * @throws NoSuchFundRegistrationException if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration findByPROJECT_DONOR_USER_ID_Last(long PROJECT_ID,
		long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByPROJECT_DONOR_USER_ID_Last(PROJECT_ID,
				DONOR_USER_ID, orderByComparator);

		if (fundRegistration != null) {
			return fundRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append(", DONOR_USER_ID=");
		msg.append(DONOR_USER_ID);

		msg.append("}");

		throw new NoSuchFundRegistrationException(msg.toString());
	}

	/**
	 * Returns the last fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fund registration, or <code>null</code> if a matching fund registration could not be found
	 */
	@Override
	public FundRegistration fetchByPROJECT_DONOR_USER_ID_Last(long PROJECT_ID,
		long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator) {
		int count = countByPROJECT_DONOR_USER_ID(PROJECT_ID, DONOR_USER_ID);

		if (count == 0) {
			return null;
		}

		List<FundRegistration> list = findByPROJECT_DONOR_USER_ID(PROJECT_ID,
				DONOR_USER_ID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fund registrations before and after the current fund registration in the ordered set where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * @param PROJECT_FUND_ID the primary key of the current fund registration
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fund registration
	 * @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration[] findByPROJECT_DONOR_USER_ID_PrevAndNext(
		long PROJECT_FUND_ID, long PROJECT_ID, long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = findByPrimaryKey(PROJECT_FUND_ID);

		Session session = null;

		try {
			session = openSession();

			FundRegistration[] array = new FundRegistrationImpl[3];

			array[0] = getByPROJECT_DONOR_USER_ID_PrevAndNext(session,
					fundRegistration, PROJECT_ID, DONOR_USER_ID,
					orderByComparator, true);

			array[1] = fundRegistration;

			array[2] = getByPROJECT_DONOR_USER_ID_PrevAndNext(session,
					fundRegistration, PROJECT_ID, DONOR_USER_ID,
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

	protected FundRegistration getByPROJECT_DONOR_USER_ID_PrevAndNext(
		Session session, FundRegistration fundRegistration, long PROJECT_ID,
		long DONOR_USER_ID,
		OrderByComparator<FundRegistration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_PROJECT_DONOR_USER_ID_PROJECT_ID_2);

		query.append(_FINDER_COLUMN_PROJECT_DONOR_USER_ID_DONOR_USER_ID_2);

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
			query.append(FundRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		qPos.add(DONOR_USER_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(fundRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FundRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 */
	@Override
	public void removeByPROJECT_DONOR_USER_ID(long PROJECT_ID,
		long DONOR_USER_ID) {
		for (FundRegistration fundRegistration : findByPROJECT_DONOR_USER_ID(
				PROJECT_ID, DONOR_USER_ID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(fundRegistration);
		}
	}

	/**
	 * Returns the number of fund registrations where PROJECT_ID = &#63; and DONOR_USER_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param DONOR_USER_ID the donor_user_id
	 * @return the number of matching fund registrations
	 */
	@Override
	public int countByPROJECT_DONOR_USER_ID(long PROJECT_ID, long DONOR_USER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_DONOR_USER_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID, DONOR_USER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FUNDREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_DONOR_USER_ID_PROJECT_ID_2);

			query.append(_FINDER_COLUMN_PROJECT_DONOR_USER_ID_DONOR_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				qPos.add(DONOR_USER_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_DONOR_USER_ID_PROJECT_ID_2 =
		"fundRegistration.PROJECT_ID = ? AND ";
	private static final String _FINDER_COLUMN_PROJECT_DONOR_USER_ID_DONOR_USER_ID_2 =
		"fundRegistration.DONOR_USER_ID = ?";

	public FundRegistrationPersistenceImpl() {
		setModelClass(FundRegistration.class);

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
	 * Caches the fund registration in the entity cache if it is enabled.
	 *
	 * @param fundRegistration the fund registration
	 */
	@Override
	public void cacheResult(FundRegistration fundRegistration) {
		entityCache.putResult(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationImpl.class, fundRegistration.getPrimaryKey(),
			fundRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FUND_ID,
			new Object[] { fundRegistration.getPROJECT_FUND_ID() },
			fundRegistration);

		fundRegistration.resetOriginalValues();
	}

	/**
	 * Caches the fund registrations in the entity cache if it is enabled.
	 *
	 * @param fundRegistrations the fund registrations
	 */
	@Override
	public void cacheResult(List<FundRegistration> fundRegistrations) {
		for (FundRegistration fundRegistration : fundRegistrations) {
			if (entityCache.getResult(
						FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FundRegistrationImpl.class,
						fundRegistration.getPrimaryKey()) == null) {
				cacheResult(fundRegistration);
			}
			else {
				fundRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fund registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FundRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fund registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FundRegistration fundRegistration) {
		entityCache.removeResult(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationImpl.class, fundRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FundRegistrationModelImpl)fundRegistration,
			true);
	}

	@Override
	public void clearCache(List<FundRegistration> fundRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FundRegistration fundRegistration : fundRegistrations) {
			entityCache.removeResult(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FundRegistrationImpl.class, fundRegistration.getPrimaryKey());

			clearUniqueFindersCache((FundRegistrationModelImpl)fundRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		FundRegistrationModelImpl fundRegistrationModelImpl) {
		Object[] args = new Object[] {
				fundRegistrationModelImpl.getPROJECT_FUND_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_FUND_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FUND_ID, args,
			fundRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		FundRegistrationModelImpl fundRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					fundRegistrationModelImpl.getPROJECT_FUND_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_FUND_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FUND_ID, args);
		}

		if ((fundRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_FUND_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					fundRegistrationModelImpl.getOriginalPROJECT_FUND_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_FUND_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FUND_ID, args);
		}
	}

	/**
	 * Creates a new fund registration with the primary key. Does not add the fund registration to the database.
	 *
	 * @param PROJECT_FUND_ID the primary key for the new fund registration
	 * @return the new fund registration
	 */
	@Override
	public FundRegistration create(long PROJECT_FUND_ID) {
		FundRegistration fundRegistration = new FundRegistrationImpl();

		fundRegistration.setNew(true);
		fundRegistration.setPrimaryKey(PROJECT_FUND_ID);

		String uuid = PortalUUIDUtil.generate();

		fundRegistration.setUuid(uuid);

		return fundRegistration;
	}

	/**
	 * Removes the fund registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_FUND_ID the primary key of the fund registration
	 * @return the fund registration that was removed
	 * @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration remove(long PROJECT_FUND_ID)
		throws NoSuchFundRegistrationException {
		return remove((Serializable)PROJECT_FUND_ID);
	}

	/**
	 * Removes the fund registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fund registration
	 * @return the fund registration that was removed
	 * @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration remove(Serializable primaryKey)
		throws NoSuchFundRegistrationException {
		Session session = null;

		try {
			session = openSession();

			FundRegistration fundRegistration = (FundRegistration)session.get(FundRegistrationImpl.class,
					primaryKey);

			if (fundRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFundRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fundRegistration);
		}
		catch (NoSuchFundRegistrationException nsee) {
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
	protected FundRegistration removeImpl(FundRegistration fundRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fundRegistration)) {
				fundRegistration = (FundRegistration)session.get(FundRegistrationImpl.class,
						fundRegistration.getPrimaryKeyObj());
			}

			if (fundRegistration != null) {
				session.delete(fundRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (fundRegistration != null) {
			clearCache(fundRegistration);
		}

		return fundRegistration;
	}

	@Override
	public FundRegistration updateImpl(FundRegistration fundRegistration) {
		boolean isNew = fundRegistration.isNew();

		if (!(fundRegistration instanceof FundRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fundRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fundRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fundRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FundRegistration implementation " +
				fundRegistration.getClass());
		}

		FundRegistrationModelImpl fundRegistrationModelImpl = (FundRegistrationModelImpl)fundRegistration;

		if (Validator.isNull(fundRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			fundRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (fundRegistration.isNew()) {
				session.save(fundRegistration);

				fundRegistration.setNew(false);
			}
			else {
				fundRegistration = (FundRegistration)session.merge(fundRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!FundRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { fundRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { fundRegistrationModelImpl.getPROJECT_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			args = new Object[] { fundRegistrationModelImpl.getDONOR_USER_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DONOR_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONOR_USER_ID,
				args);

			args = new Object[] {
					fundRegistrationModelImpl.getPROJECT_ID(),
					fundRegistrationModelImpl.getDONOR_USER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_DONOR_USER_ID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_DONOR_USER_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((fundRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { fundRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((fundRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] { fundRegistrationModelImpl.getPROJECT_ID() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}

			if ((fundRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONOR_USER_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundRegistrationModelImpl.getOriginalDONOR_USER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DONOR_USER_ID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONOR_USER_ID,
					args);

				args = new Object[] { fundRegistrationModelImpl.getDONOR_USER_ID() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DONOR_USER_ID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DONOR_USER_ID,
					args);
			}

			if ((fundRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_DONOR_USER_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						fundRegistrationModelImpl.getOriginalPROJECT_ID(),
						fundRegistrationModelImpl.getOriginalDONOR_USER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_DONOR_USER_ID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_DONOR_USER_ID,
					args);

				args = new Object[] {
						fundRegistrationModelImpl.getPROJECT_ID(),
						fundRegistrationModelImpl.getDONOR_USER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_DONOR_USER_ID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_DONOR_USER_ID,
					args);
			}
		}

		entityCache.putResult(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FundRegistrationImpl.class, fundRegistration.getPrimaryKey(),
			fundRegistration, false);

		clearUniqueFindersCache(fundRegistrationModelImpl, false);
		cacheUniqueFindersCache(fundRegistrationModelImpl);

		fundRegistration.resetOriginalValues();

		return fundRegistration;
	}

	/**
	 * Returns the fund registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund registration
	 * @return the fund registration
	 * @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFundRegistrationException {
		FundRegistration fundRegistration = fetchByPrimaryKey(primaryKey);

		if (fundRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFundRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return fundRegistration;
	}

	/**
	 * Returns the fund registration with the primary key or throws a {@link NoSuchFundRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_FUND_ID the primary key of the fund registration
	 * @return the fund registration
	 * @throws NoSuchFundRegistrationException if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration findByPrimaryKey(long PROJECT_FUND_ID)
		throws NoSuchFundRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_FUND_ID);
	}

	/**
	 * Returns the fund registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fund registration
	 * @return the fund registration, or <code>null</code> if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FundRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FundRegistration fundRegistration = (FundRegistration)serializable;

		if (fundRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				fundRegistration = (FundRegistration)session.get(FundRegistrationImpl.class,
						primaryKey);

				if (fundRegistration != null) {
					cacheResult(fundRegistration);
				}
				else {
					entityCache.putResult(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FundRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FundRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return fundRegistration;
	}

	/**
	 * Returns the fund registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_FUND_ID the primary key of the fund registration
	 * @return the fund registration, or <code>null</code> if a fund registration with the primary key could not be found
	 */
	@Override
	public FundRegistration fetchByPrimaryKey(long PROJECT_FUND_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_FUND_ID);
	}

	@Override
	public Map<Serializable, FundRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FundRegistration> map = new HashMap<Serializable, FundRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FundRegistration fundRegistration = fetchByPrimaryKey(primaryKey);

			if (fundRegistration != null) {
				map.put(primaryKey, fundRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FundRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FundRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FUNDREGISTRATION_WHERE_PKS_IN);

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

			for (FundRegistration fundRegistration : (List<FundRegistration>)q.list()) {
				map.put(fundRegistration.getPrimaryKeyObj(), fundRegistration);

				cacheResult(fundRegistration);

				uncachedPrimaryKeys.remove(fundRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FundRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FundRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the fund registrations.
	 *
	 * @return the fund registrations
	 */
	@Override
	public List<FundRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fund registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @return the range of fund registrations
	 */
	@Override
	public List<FundRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fund registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fund registrations
	 */
	@Override
	public List<FundRegistration> findAll(int start, int end,
		OrderByComparator<FundRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fund registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FundRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund registrations
	 * @param end the upper bound of the range of fund registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of fund registrations
	 */
	@Override
	public List<FundRegistration> findAll(int start, int end,
		OrderByComparator<FundRegistration> orderByComparator,
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

		List<FundRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<FundRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FUNDREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FUNDREGISTRATION;

				if (pagination) {
					sql = sql.concat(FundRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FundRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<FundRegistration>)QueryUtil.list(q,
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
	 * Removes all the fund registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FundRegistration fundRegistration : findAll()) {
			remove(fundRegistration);
		}
	}

	/**
	 * Returns the number of fund registrations.
	 *
	 * @return the number of fund registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FUNDREGISTRATION);

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
		return FundRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fund registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FundRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FUNDREGISTRATION = "SELECT fundRegistration FROM FundRegistration fundRegistration";
	private static final String _SQL_SELECT_FUNDREGISTRATION_WHERE_PKS_IN = "SELECT fundRegistration FROM FundRegistration fundRegistration WHERE PROJECT_FUND_ID IN (";
	private static final String _SQL_SELECT_FUNDREGISTRATION_WHERE = "SELECT fundRegistration FROM FundRegistration fundRegistration WHERE ";
	private static final String _SQL_COUNT_FUNDREGISTRATION = "SELECT COUNT(fundRegistration) FROM FundRegistration fundRegistration";
	private static final String _SQL_COUNT_FUNDREGISTRATION_WHERE = "SELECT COUNT(fundRegistration) FROM FundRegistration fundRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fundRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FundRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FundRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FundRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}