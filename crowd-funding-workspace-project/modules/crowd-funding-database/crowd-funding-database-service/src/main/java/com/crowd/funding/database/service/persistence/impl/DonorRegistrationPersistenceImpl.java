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

import com.crowd.funding.database.exception.NoSuchDonorRegistrationException;
import com.crowd.funding.database.model.DonorRegistration;
import com.crowd.funding.database.model.impl.DonorRegistrationImpl;
import com.crowd.funding.database.model.impl.DonorRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.DonorRegistrationPersistence;

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
 * The persistence implementation for the donor registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DonorRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.DonorRegistrationUtil
 * @generated
 */
@ProviderType
public class DonorRegistrationPersistenceImpl extends BasePersistenceImpl<DonorRegistration>
	implements DonorRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DonorRegistrationUtil} to access the donor registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DonorRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DonorRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DonorRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DonorRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DonorRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DonorRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the donor registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching donor registrations
	 */
	@Override
	public List<DonorRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the donor registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of donor registrations
	 * @param end the upper bound of the range of donor registrations (not inclusive)
	 * @return the range of matching donor registrations
	 */
	@Override
	public List<DonorRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the donor registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of donor registrations
	 * @param end the upper bound of the range of donor registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching donor registrations
	 */
	@Override
	public List<DonorRegistration> findByUuid(String uuid, int start, int end,
		OrderByComparator<DonorRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the donor registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of donor registrations
	 * @param end the upper bound of the range of donor registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching donor registrations
	 */
	@Override
	public List<DonorRegistration> findByUuid(String uuid, int start, int end,
		OrderByComparator<DonorRegistration> orderByComparator,
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

		List<DonorRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<DonorRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DonorRegistration donorRegistration : list) {
					if (!Objects.equals(uuid, donorRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_DONORREGISTRATION_WHERE);

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
				query.append(DonorRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<DonorRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DonorRegistration>)QueryUtil.list(q,
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
	 * Returns the first donor registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching donor registration
	 * @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration findByUuid_First(String uuid,
		OrderByComparator<DonorRegistration> orderByComparator)
		throws NoSuchDonorRegistrationException {
		DonorRegistration donorRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (donorRegistration != null) {
			return donorRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchDonorRegistrationException(msg.toString());
	}

	/**
	 * Returns the first donor registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching donor registration, or <code>null</code> if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration fetchByUuid_First(String uuid,
		OrderByComparator<DonorRegistration> orderByComparator) {
		List<DonorRegistration> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last donor registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching donor registration
	 * @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration findByUuid_Last(String uuid,
		OrderByComparator<DonorRegistration> orderByComparator)
		throws NoSuchDonorRegistrationException {
		DonorRegistration donorRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (donorRegistration != null) {
			return donorRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchDonorRegistrationException(msg.toString());
	}

	/**
	 * Returns the last donor registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching donor registration, or <code>null</code> if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<DonorRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DonorRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the donor registrations before and after the current donor registration in the ordered set where uuid = &#63;.
	 *
	 * @param DONOR_ID the primary key of the current donor registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next donor registration
	 * @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	 */
	@Override
	public DonorRegistration[] findByUuid_PrevAndNext(long DONOR_ID,
		String uuid, OrderByComparator<DonorRegistration> orderByComparator)
		throws NoSuchDonorRegistrationException {
		DonorRegistration donorRegistration = findByPrimaryKey(DONOR_ID);

		Session session = null;

		try {
			session = openSession();

			DonorRegistration[] array = new DonorRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, donorRegistration, uuid,
					orderByComparator, true);

			array[1] = donorRegistration;

			array[2] = getByUuid_PrevAndNext(session, donorRegistration, uuid,
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

	protected DonorRegistration getByUuid_PrevAndNext(Session session,
		DonorRegistration donorRegistration, String uuid,
		OrderByComparator<DonorRegistration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DONORREGISTRATION_WHERE);

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
			query.append(DonorRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(donorRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DonorRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the donor registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DonorRegistration donorRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(donorRegistration);
		}
	}

	/**
	 * Returns the number of donor registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching donor registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DONORREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "donorRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "donorRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(donorRegistration.uuid IS NULL OR donorRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_MOBILE_NO = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DonorRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByMOBILE_NO", new String[] { Long.class.getName() },
			DonorRegistrationModelImpl.MOBILE_NO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MOBILE_NO = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMOBILE_NO",
			new String[] { Long.class.getName() });

	/**
	 * Returns the donor registration where MOBILE_NO = &#63; or throws a {@link NoSuchDonorRegistrationException} if it could not be found.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @return the matching donor registration
	 * @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration findByMOBILE_NO(long MOBILE_NO)
		throws NoSuchDonorRegistrationException {
		DonorRegistration donorRegistration = fetchByMOBILE_NO(MOBILE_NO);

		if (donorRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("MOBILE_NO=");
			msg.append(MOBILE_NO);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDonorRegistrationException(msg.toString());
		}

		return donorRegistration;
	}

	/**
	 * Returns the donor registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration fetchByMOBILE_NO(long MOBILE_NO) {
		return fetchByMOBILE_NO(MOBILE_NO, true);
	}

	/**
	 * Returns the donor registration where MOBILE_NO = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration fetchByMOBILE_NO(long MOBILE_NO,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { MOBILE_NO };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_MOBILE_NO,
					finderArgs, this);
		}

		if (result instanceof DonorRegistration) {
			DonorRegistration donorRegistration = (DonorRegistration)result;

			if ((MOBILE_NO != donorRegistration.getMOBILE_NO())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DONORREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_MOBILE_NO_MOBILE_NO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MOBILE_NO);

				List<DonorRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_MOBILE_NO,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DonorRegistrationPersistenceImpl.fetchByMOBILE_NO(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DonorRegistration donorRegistration = list.get(0);

					result = donorRegistration;

					cacheResult(donorRegistration);
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
			return (DonorRegistration)result;
		}
	}

	/**
	 * Removes the donor registration where MOBILE_NO = &#63; from the database.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @return the donor registration that was removed
	 */
	@Override
	public DonorRegistration removeByMOBILE_NO(long MOBILE_NO)
		throws NoSuchDonorRegistrationException {
		DonorRegistration donorRegistration = findByMOBILE_NO(MOBILE_NO);

		return remove(donorRegistration);
	}

	/**
	 * Returns the number of donor registrations where MOBILE_NO = &#63;.
	 *
	 * @param MOBILE_NO the mobile_no
	 * @return the number of matching donor registrations
	 */
	@Override
	public int countByMOBILE_NO(long MOBILE_NO) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MOBILE_NO;

		Object[] finderArgs = new Object[] { MOBILE_NO };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DONORREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_MOBILE_NO_MOBILE_NO_2 = "donorRegistration.MOBILE_NO = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_DONOR_ID = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DonorRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByDONOR_ID", new String[] { Long.class.getName() },
			DonorRegistrationModelImpl.DONOR_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DONOR_ID = new FinderPath(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDONOR_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the donor registration where DONOR_ID = &#63; or throws a {@link NoSuchDonorRegistrationException} if it could not be found.
	 *
	 * @param DONOR_ID the donor_id
	 * @return the matching donor registration
	 * @throws NoSuchDonorRegistrationException if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration findByDONOR_ID(long DONOR_ID)
		throws NoSuchDonorRegistrationException {
		DonorRegistration donorRegistration = fetchByDONOR_ID(DONOR_ID);

		if (donorRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("DONOR_ID=");
			msg.append(DONOR_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDonorRegistrationException(msg.toString());
		}

		return donorRegistration;
	}

	/**
	 * Returns the donor registration where DONOR_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param DONOR_ID the donor_id
	 * @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration fetchByDONOR_ID(long DONOR_ID) {
		return fetchByDONOR_ID(DONOR_ID, true);
	}

	/**
	 * Returns the donor registration where DONOR_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param DONOR_ID the donor_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching donor registration, or <code>null</code> if a matching donor registration could not be found
	 */
	@Override
	public DonorRegistration fetchByDONOR_ID(long DONOR_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { DONOR_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_DONOR_ID,
					finderArgs, this);
		}

		if (result instanceof DonorRegistration) {
			DonorRegistration donorRegistration = (DonorRegistration)result;

			if ((DONOR_ID != donorRegistration.getDONOR_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DONORREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_DONOR_ID_DONOR_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(DONOR_ID);

				List<DonorRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_DONOR_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DonorRegistrationPersistenceImpl.fetchByDONOR_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DonorRegistration donorRegistration = list.get(0);

					result = donorRegistration;

					cacheResult(donorRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_DONOR_ID,
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
			return (DonorRegistration)result;
		}
	}

	/**
	 * Removes the donor registration where DONOR_ID = &#63; from the database.
	 *
	 * @param DONOR_ID the donor_id
	 * @return the donor registration that was removed
	 */
	@Override
	public DonorRegistration removeByDONOR_ID(long DONOR_ID)
		throws NoSuchDonorRegistrationException {
		DonorRegistration donorRegistration = findByDONOR_ID(DONOR_ID);

		return remove(donorRegistration);
	}

	/**
	 * Returns the number of donor registrations where DONOR_ID = &#63;.
	 *
	 * @param DONOR_ID the donor_id
	 * @return the number of matching donor registrations
	 */
	@Override
	public int countByDONOR_ID(long DONOR_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DONOR_ID;

		Object[] finderArgs = new Object[] { DONOR_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DONORREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_DONOR_ID_DONOR_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(DONOR_ID);

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

	private static final String _FINDER_COLUMN_DONOR_ID_DONOR_ID_2 = "donorRegistration.DONOR_ID = ?";

	public DonorRegistrationPersistenceImpl() {
		setModelClass(DonorRegistration.class);

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
	 * Caches the donor registration in the entity cache if it is enabled.
	 *
	 * @param donorRegistration the donor registration
	 */
	@Override
	public void cacheResult(DonorRegistration donorRegistration) {
		entityCache.putResult(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationImpl.class, donorRegistration.getPrimaryKey(),
			donorRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_MOBILE_NO,
			new Object[] { donorRegistration.getMOBILE_NO() }, donorRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_DONOR_ID,
			new Object[] { donorRegistration.getDONOR_ID() }, donorRegistration);

		donorRegistration.resetOriginalValues();
	}

	/**
	 * Caches the donor registrations in the entity cache if it is enabled.
	 *
	 * @param donorRegistrations the donor registrations
	 */
	@Override
	public void cacheResult(List<DonorRegistration> donorRegistrations) {
		for (DonorRegistration donorRegistration : donorRegistrations) {
			if (entityCache.getResult(
						DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						DonorRegistrationImpl.class,
						donorRegistration.getPrimaryKey()) == null) {
				cacheResult(donorRegistration);
			}
			else {
				donorRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all donor registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DonorRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the donor registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DonorRegistration donorRegistration) {
		entityCache.removeResult(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationImpl.class, donorRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DonorRegistrationModelImpl)donorRegistration,
			true);
	}

	@Override
	public void clearCache(List<DonorRegistration> donorRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DonorRegistration donorRegistration : donorRegistrations) {
			entityCache.removeResult(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				DonorRegistrationImpl.class, donorRegistration.getPrimaryKey());

			clearUniqueFindersCache((DonorRegistrationModelImpl)donorRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		DonorRegistrationModelImpl donorRegistrationModelImpl) {
		Object[] args = new Object[] { donorRegistrationModelImpl.getMOBILE_NO() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_MOBILE_NO, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_MOBILE_NO, args,
			donorRegistrationModelImpl, false);

		args = new Object[] { donorRegistrationModelImpl.getDONOR_ID() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_DONOR_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_DONOR_ID, args,
			donorRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DonorRegistrationModelImpl donorRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					donorRegistrationModelImpl.getMOBILE_NO()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MOBILE_NO, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MOBILE_NO, args);
		}

		if ((donorRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_MOBILE_NO.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					donorRegistrationModelImpl.getOriginalMOBILE_NO()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MOBILE_NO, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_MOBILE_NO, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					donorRegistrationModelImpl.getDONOR_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DONOR_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DONOR_ID, args);
		}

		if ((donorRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DONOR_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					donorRegistrationModelImpl.getOriginalDONOR_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DONOR_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DONOR_ID, args);
		}
	}

	/**
	 * Creates a new donor registration with the primary key. Does not add the donor registration to the database.
	 *
	 * @param DONOR_ID the primary key for the new donor registration
	 * @return the new donor registration
	 */
	@Override
	public DonorRegistration create(long DONOR_ID) {
		DonorRegistration donorRegistration = new DonorRegistrationImpl();

		donorRegistration.setNew(true);
		donorRegistration.setPrimaryKey(DONOR_ID);

		String uuid = PortalUUIDUtil.generate();

		donorRegistration.setUuid(uuid);

		return donorRegistration;
	}

	/**
	 * Removes the donor registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param DONOR_ID the primary key of the donor registration
	 * @return the donor registration that was removed
	 * @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	 */
	@Override
	public DonorRegistration remove(long DONOR_ID)
		throws NoSuchDonorRegistrationException {
		return remove((Serializable)DONOR_ID);
	}

	/**
	 * Removes the donor registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the donor registration
	 * @return the donor registration that was removed
	 * @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	 */
	@Override
	public DonorRegistration remove(Serializable primaryKey)
		throws NoSuchDonorRegistrationException {
		Session session = null;

		try {
			session = openSession();

			DonorRegistration donorRegistration = (DonorRegistration)session.get(DonorRegistrationImpl.class,
					primaryKey);

			if (donorRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDonorRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(donorRegistration);
		}
		catch (NoSuchDonorRegistrationException nsee) {
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
	protected DonorRegistration removeImpl(DonorRegistration donorRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(donorRegistration)) {
				donorRegistration = (DonorRegistration)session.get(DonorRegistrationImpl.class,
						donorRegistration.getPrimaryKeyObj());
			}

			if (donorRegistration != null) {
				session.delete(donorRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (donorRegistration != null) {
			clearCache(donorRegistration);
		}

		return donorRegistration;
	}

	@Override
	public DonorRegistration updateImpl(DonorRegistration donorRegistration) {
		boolean isNew = donorRegistration.isNew();

		if (!(donorRegistration instanceof DonorRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(donorRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(donorRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in donorRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DonorRegistration implementation " +
				donorRegistration.getClass());
		}

		DonorRegistrationModelImpl donorRegistrationModelImpl = (DonorRegistrationModelImpl)donorRegistration;

		if (Validator.isNull(donorRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			donorRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (donorRegistration.isNew()) {
				session.save(donorRegistration);

				donorRegistration.setNew(false);
			}
			else {
				donorRegistration = (DonorRegistration)session.merge(donorRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DonorRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { donorRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((donorRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						donorRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { donorRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DonorRegistrationImpl.class, donorRegistration.getPrimaryKey(),
			donorRegistration, false);

		clearUniqueFindersCache(donorRegistrationModelImpl, false);
		cacheUniqueFindersCache(donorRegistrationModelImpl);

		donorRegistration.resetOriginalValues();

		return donorRegistration;
	}

	/**
	 * Returns the donor registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the donor registration
	 * @return the donor registration
	 * @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	 */
	@Override
	public DonorRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDonorRegistrationException {
		DonorRegistration donorRegistration = fetchByPrimaryKey(primaryKey);

		if (donorRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDonorRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return donorRegistration;
	}

	/**
	 * Returns the donor registration with the primary key or throws a {@link NoSuchDonorRegistrationException} if it could not be found.
	 *
	 * @param DONOR_ID the primary key of the donor registration
	 * @return the donor registration
	 * @throws NoSuchDonorRegistrationException if a donor registration with the primary key could not be found
	 */
	@Override
	public DonorRegistration findByPrimaryKey(long DONOR_ID)
		throws NoSuchDonorRegistrationException {
		return findByPrimaryKey((Serializable)DONOR_ID);
	}

	/**
	 * Returns the donor registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the donor registration
	 * @return the donor registration, or <code>null</code> if a donor registration with the primary key could not be found
	 */
	@Override
	public DonorRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				DonorRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DonorRegistration donorRegistration = (DonorRegistration)serializable;

		if (donorRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				donorRegistration = (DonorRegistration)session.get(DonorRegistrationImpl.class,
						primaryKey);

				if (donorRegistration != null) {
					cacheResult(donorRegistration);
				}
				else {
					entityCache.putResult(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						DonorRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					DonorRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return donorRegistration;
	}

	/**
	 * Returns the donor registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param DONOR_ID the primary key of the donor registration
	 * @return the donor registration, or <code>null</code> if a donor registration with the primary key could not be found
	 */
	@Override
	public DonorRegistration fetchByPrimaryKey(long DONOR_ID) {
		return fetchByPrimaryKey((Serializable)DONOR_ID);
	}

	@Override
	public Map<Serializable, DonorRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DonorRegistration> map = new HashMap<Serializable, DonorRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DonorRegistration donorRegistration = fetchByPrimaryKey(primaryKey);

			if (donorRegistration != null) {
				map.put(primaryKey, donorRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					DonorRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DonorRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DONORREGISTRATION_WHERE_PKS_IN);

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

			for (DonorRegistration donorRegistration : (List<DonorRegistration>)q.list()) {
				map.put(donorRegistration.getPrimaryKeyObj(), donorRegistration);

				cacheResult(donorRegistration);

				uncachedPrimaryKeys.remove(donorRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DonorRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					DonorRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the donor registrations.
	 *
	 * @return the donor registrations
	 */
	@Override
	public List<DonorRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the donor registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of donor registrations
	 * @param end the upper bound of the range of donor registrations (not inclusive)
	 * @return the range of donor registrations
	 */
	@Override
	public List<DonorRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the donor registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of donor registrations
	 * @param end the upper bound of the range of donor registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of donor registrations
	 */
	@Override
	public List<DonorRegistration> findAll(int start, int end,
		OrderByComparator<DonorRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the donor registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DonorRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of donor registrations
	 * @param end the upper bound of the range of donor registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of donor registrations
	 */
	@Override
	public List<DonorRegistration> findAll(int start, int end,
		OrderByComparator<DonorRegistration> orderByComparator,
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

		List<DonorRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<DonorRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DONORREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DONORREGISTRATION;

				if (pagination) {
					sql = sql.concat(DonorRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DonorRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DonorRegistration>)QueryUtil.list(q,
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
	 * Removes all the donor registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DonorRegistration donorRegistration : findAll()) {
			remove(donorRegistration);
		}
	}

	/**
	 * Returns the number of donor registrations.
	 *
	 * @return the number of donor registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DONORREGISTRATION);

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
		return DonorRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the donor registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DonorRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DONORREGISTRATION = "SELECT donorRegistration FROM DonorRegistration donorRegistration";
	private static final String _SQL_SELECT_DONORREGISTRATION_WHERE_PKS_IN = "SELECT donorRegistration FROM DonorRegistration donorRegistration WHERE DONOR_ID IN (";
	private static final String _SQL_SELECT_DONORREGISTRATION_WHERE = "SELECT donorRegistration FROM DonorRegistration donorRegistration WHERE ";
	private static final String _SQL_COUNT_DONORREGISTRATION = "SELECT COUNT(donorRegistration) FROM DonorRegistration donorRegistration";
	private static final String _SQL_COUNT_DONORREGISTRATION_WHERE = "SELECT COUNT(donorRegistration) FROM DonorRegistration donorRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "donorRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DonorRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DonorRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DonorRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}