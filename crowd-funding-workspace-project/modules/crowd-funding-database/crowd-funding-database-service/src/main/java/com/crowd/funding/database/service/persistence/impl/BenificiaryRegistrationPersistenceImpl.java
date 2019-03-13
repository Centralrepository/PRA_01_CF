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

import com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException;
import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.impl.BenificiaryRegistrationImpl;
import com.crowd.funding.database.model.impl.BenificiaryRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.BenificiaryRegistrationPersistence;

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
 * The persistence implementation for the benificiary registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenificiaryRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.BenificiaryRegistrationUtil
 * @generated
 */
@ProviderType
public class BenificiaryRegistrationPersistenceImpl extends BasePersistenceImpl<BenificiaryRegistration>
	implements BenificiaryRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BenificiaryRegistrationUtil} to access the benificiary registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BenificiaryRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationModelImpl.FINDER_CACHE_ENABLED,
			BenificiaryRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationModelImpl.FINDER_CACHE_ENABLED,
			BenificiaryRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationModelImpl.FINDER_CACHE_ENABLED,
			BenificiaryRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationModelImpl.FINDER_CACHE_ENABLED,
			BenificiaryRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			BenificiaryRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the benificiary registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching benificiary registrations
	 */
	@Override
	public List<BenificiaryRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the benificiary registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of benificiary registrations
	 * @param end the upper bound of the range of benificiary registrations (not inclusive)
	 * @return the range of matching benificiary registrations
	 */
	@Override
	public List<BenificiaryRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the benificiary registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of benificiary registrations
	 * @param end the upper bound of the range of benificiary registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching benificiary registrations
	 */
	@Override
	public List<BenificiaryRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<BenificiaryRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the benificiary registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of benificiary registrations
	 * @param end the upper bound of the range of benificiary registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching benificiary registrations
	 */
	@Override
	public List<BenificiaryRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<BenificiaryRegistration> orderByComparator,
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

		List<BenificiaryRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<BenificiaryRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BenificiaryRegistration benificiaryRegistration : list) {
					if (!Objects.equals(uuid, benificiaryRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_BENIFICIARYREGISTRATION_WHERE);

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
				query.append(BenificiaryRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<BenificiaryRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BenificiaryRegistration>)QueryUtil.list(q,
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
	 * Returns the first benificiary registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benificiary registration
	 * @throws NoSuchBenificiaryRegistrationException if a matching benificiary registration could not be found
	 */
	@Override
	public BenificiaryRegistration findByUuid_First(String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator)
		throws NoSuchBenificiaryRegistrationException {
		BenificiaryRegistration benificiaryRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (benificiaryRegistration != null) {
			return benificiaryRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBenificiaryRegistrationException(msg.toString());
	}

	/**
	 * Returns the first benificiary registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	 */
	@Override
	public BenificiaryRegistration fetchByUuid_First(String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator) {
		List<BenificiaryRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last benificiary registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benificiary registration
	 * @throws NoSuchBenificiaryRegistrationException if a matching benificiary registration could not be found
	 */
	@Override
	public BenificiaryRegistration findByUuid_Last(String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator)
		throws NoSuchBenificiaryRegistrationException {
		BenificiaryRegistration benificiaryRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (benificiaryRegistration != null) {
			return benificiaryRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchBenificiaryRegistrationException(msg.toString());
	}

	/**
	 * Returns the last benificiary registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	 */
	@Override
	public BenificiaryRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BenificiaryRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the benificiary registrations before and after the current benificiary registration in the ordered set where uuid = &#63;.
	 *
	 * @param BENIFICIARY_ID the primary key of the current benificiary registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next benificiary registration
	 * @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	 */
	@Override
	public BenificiaryRegistration[] findByUuid_PrevAndNext(
		long BENIFICIARY_ID, String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator)
		throws NoSuchBenificiaryRegistrationException {
		BenificiaryRegistration benificiaryRegistration = findByPrimaryKey(BENIFICIARY_ID);

		Session session = null;

		try {
			session = openSession();

			BenificiaryRegistration[] array = new BenificiaryRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, benificiaryRegistration,
					uuid, orderByComparator, true);

			array[1] = benificiaryRegistration;

			array[2] = getByUuid_PrevAndNext(session, benificiaryRegistration,
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

	protected BenificiaryRegistration getByUuid_PrevAndNext(Session session,
		BenificiaryRegistration benificiaryRegistration, String uuid,
		OrderByComparator<BenificiaryRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_BENIFICIARYREGISTRATION_WHERE);

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
			query.append(BenificiaryRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(benificiaryRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BenificiaryRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the benificiary registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BenificiaryRegistration benificiaryRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(benificiaryRegistration);
		}
	}

	/**
	 * Returns the number of benificiary registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching benificiary registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BENIFICIARYREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "benificiaryRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "benificiaryRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(benificiaryRegistration.uuid IS NULL OR benificiaryRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_BENIFICIARY_ID = new FinderPath(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationModelImpl.FINDER_CACHE_ENABLED,
			BenificiaryRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByBENIFICIARY_ID", new String[] { Long.class.getName() },
			BenificiaryRegistrationModelImpl.BENIFICIARY_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BENIFICIARY_ID = new FinderPath(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBENIFICIARY_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the benificiary registration where BENIFICIARY_ID = &#63; or throws a {@link NoSuchBenificiaryRegistrationException} if it could not be found.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @return the matching benificiary registration
	 * @throws NoSuchBenificiaryRegistrationException if a matching benificiary registration could not be found
	 */
	@Override
	public BenificiaryRegistration findByBENIFICIARY_ID(long BENIFICIARY_ID)
		throws NoSuchBenificiaryRegistrationException {
		BenificiaryRegistration benificiaryRegistration = fetchByBENIFICIARY_ID(BENIFICIARY_ID);

		if (benificiaryRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("BENIFICIARY_ID=");
			msg.append(BENIFICIARY_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBenificiaryRegistrationException(msg.toString());
		}

		return benificiaryRegistration;
	}

	/**
	 * Returns the benificiary registration where BENIFICIARY_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @return the matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	 */
	@Override
	public BenificiaryRegistration fetchByBENIFICIARY_ID(long BENIFICIARY_ID) {
		return fetchByBENIFICIARY_ID(BENIFICIARY_ID, true);
	}

	/**
	 * Returns the benificiary registration where BENIFICIARY_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching benificiary registration, or <code>null</code> if a matching benificiary registration could not be found
	 */
	@Override
	public BenificiaryRegistration fetchByBENIFICIARY_ID(long BENIFICIARY_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { BENIFICIARY_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_BENIFICIARY_ID,
					finderArgs, this);
		}

		if (result instanceof BenificiaryRegistration) {
			BenificiaryRegistration benificiaryRegistration = (BenificiaryRegistration)result;

			if ((BENIFICIARY_ID != benificiaryRegistration.getBENIFICIARY_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BENIFICIARYREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_BENIFICIARY_ID_BENIFICIARY_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(BENIFICIARY_ID);

				List<BenificiaryRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_BENIFICIARY_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"BenificiaryRegistrationPersistenceImpl.fetchByBENIFICIARY_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BenificiaryRegistration benificiaryRegistration = list.get(0);

					result = benificiaryRegistration;

					cacheResult(benificiaryRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_BENIFICIARY_ID,
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
			return (BenificiaryRegistration)result;
		}
	}

	/**
	 * Removes the benificiary registration where BENIFICIARY_ID = &#63; from the database.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @return the benificiary registration that was removed
	 */
	@Override
	public BenificiaryRegistration removeByBENIFICIARY_ID(long BENIFICIARY_ID)
		throws NoSuchBenificiaryRegistrationException {
		BenificiaryRegistration benificiaryRegistration = findByBENIFICIARY_ID(BENIFICIARY_ID);

		return remove(benificiaryRegistration);
	}

	/**
	 * Returns the number of benificiary registrations where BENIFICIARY_ID = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @return the number of matching benificiary registrations
	 */
	@Override
	public int countByBENIFICIARY_ID(long BENIFICIARY_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BENIFICIARY_ID;

		Object[] finderArgs = new Object[] { BENIFICIARY_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BENIFICIARYREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_BENIFICIARY_ID_BENIFICIARY_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(BENIFICIARY_ID);

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

	private static final String _FINDER_COLUMN_BENIFICIARY_ID_BENIFICIARY_ID_2 = "benificiaryRegistration.BENIFICIARY_ID = ?";

	public BenificiaryRegistrationPersistenceImpl() {
		setModelClass(BenificiaryRegistration.class);

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
	 * Caches the benificiary registration in the entity cache if it is enabled.
	 *
	 * @param benificiaryRegistration the benificiary registration
	 */
	@Override
	public void cacheResult(BenificiaryRegistration benificiaryRegistration) {
		entityCache.putResult(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationImpl.class,
			benificiaryRegistration.getPrimaryKey(), benificiaryRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_BENIFICIARY_ID,
			new Object[] { benificiaryRegistration.getBENIFICIARY_ID() },
			benificiaryRegistration);

		benificiaryRegistration.resetOriginalValues();
	}

	/**
	 * Caches the benificiary registrations in the entity cache if it is enabled.
	 *
	 * @param benificiaryRegistrations the benificiary registrations
	 */
	@Override
	public void cacheResult(
		List<BenificiaryRegistration> benificiaryRegistrations) {
		for (BenificiaryRegistration benificiaryRegistration : benificiaryRegistrations) {
			if (entityCache.getResult(
						BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						BenificiaryRegistrationImpl.class,
						benificiaryRegistration.getPrimaryKey()) == null) {
				cacheResult(benificiaryRegistration);
			}
			else {
				benificiaryRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all benificiary registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BenificiaryRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the benificiary registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BenificiaryRegistration benificiaryRegistration) {
		entityCache.removeResult(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationImpl.class,
			benificiaryRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BenificiaryRegistrationModelImpl)benificiaryRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<BenificiaryRegistration> benificiaryRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BenificiaryRegistration benificiaryRegistration : benificiaryRegistrations) {
			entityCache.removeResult(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				BenificiaryRegistrationImpl.class,
				benificiaryRegistration.getPrimaryKey());

			clearUniqueFindersCache((BenificiaryRegistrationModelImpl)benificiaryRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		BenificiaryRegistrationModelImpl benificiaryRegistrationModelImpl) {
		Object[] args = new Object[] {
				benificiaryRegistrationModelImpl.getBENIFICIARY_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_BENIFICIARY_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_BENIFICIARY_ID, args,
			benificiaryRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		BenificiaryRegistrationModelImpl benificiaryRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					benificiaryRegistrationModelImpl.getBENIFICIARY_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIFICIARY_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BENIFICIARY_ID, args);
		}

		if ((benificiaryRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BENIFICIARY_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					benificiaryRegistrationModelImpl.getOriginalBENIFICIARY_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIFICIARY_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_BENIFICIARY_ID, args);
		}
	}

	/**
	 * Creates a new benificiary registration with the primary key. Does not add the benificiary registration to the database.
	 *
	 * @param BENIFICIARY_ID the primary key for the new benificiary registration
	 * @return the new benificiary registration
	 */
	@Override
	public BenificiaryRegistration create(long BENIFICIARY_ID) {
		BenificiaryRegistration benificiaryRegistration = new BenificiaryRegistrationImpl();

		benificiaryRegistration.setNew(true);
		benificiaryRegistration.setPrimaryKey(BENIFICIARY_ID);

		String uuid = PortalUUIDUtil.generate();

		benificiaryRegistration.setUuid(uuid);

		return benificiaryRegistration;
	}

	/**
	 * Removes the benificiary registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param BENIFICIARY_ID the primary key of the benificiary registration
	 * @return the benificiary registration that was removed
	 * @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	 */
	@Override
	public BenificiaryRegistration remove(long BENIFICIARY_ID)
		throws NoSuchBenificiaryRegistrationException {
		return remove((Serializable)BENIFICIARY_ID);
	}

	/**
	 * Removes the benificiary registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the benificiary registration
	 * @return the benificiary registration that was removed
	 * @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	 */
	@Override
	public BenificiaryRegistration remove(Serializable primaryKey)
		throws NoSuchBenificiaryRegistrationException {
		Session session = null;

		try {
			session = openSession();

			BenificiaryRegistration benificiaryRegistration = (BenificiaryRegistration)session.get(BenificiaryRegistrationImpl.class,
					primaryKey);

			if (benificiaryRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBenificiaryRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(benificiaryRegistration);
		}
		catch (NoSuchBenificiaryRegistrationException nsee) {
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
	protected BenificiaryRegistration removeImpl(
		BenificiaryRegistration benificiaryRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(benificiaryRegistration)) {
				benificiaryRegistration = (BenificiaryRegistration)session.get(BenificiaryRegistrationImpl.class,
						benificiaryRegistration.getPrimaryKeyObj());
			}

			if (benificiaryRegistration != null) {
				session.delete(benificiaryRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (benificiaryRegistration != null) {
			clearCache(benificiaryRegistration);
		}

		return benificiaryRegistration;
	}

	@Override
	public BenificiaryRegistration updateImpl(
		BenificiaryRegistration benificiaryRegistration) {
		boolean isNew = benificiaryRegistration.isNew();

		if (!(benificiaryRegistration instanceof BenificiaryRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(benificiaryRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(benificiaryRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in benificiaryRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BenificiaryRegistration implementation " +
				benificiaryRegistration.getClass());
		}

		BenificiaryRegistrationModelImpl benificiaryRegistrationModelImpl = (BenificiaryRegistrationModelImpl)benificiaryRegistration;

		if (Validator.isNull(benificiaryRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			benificiaryRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (benificiaryRegistration.isNew()) {
				session.save(benificiaryRegistration);

				benificiaryRegistration.setNew(false);
			}
			else {
				session.evict(benificiaryRegistration);
				session.saveOrUpdate(benificiaryRegistration);
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

		if (!BenificiaryRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					benificiaryRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((benificiaryRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						benificiaryRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { benificiaryRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			BenificiaryRegistrationImpl.class,
			benificiaryRegistration.getPrimaryKey(), benificiaryRegistration,
			false);

		clearUniqueFindersCache(benificiaryRegistrationModelImpl, false);
		cacheUniqueFindersCache(benificiaryRegistrationModelImpl);

		benificiaryRegistration.resetOriginalValues();

		return benificiaryRegistration;
	}

	/**
	 * Returns the benificiary registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the benificiary registration
	 * @return the benificiary registration
	 * @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	 */
	@Override
	public BenificiaryRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBenificiaryRegistrationException {
		BenificiaryRegistration benificiaryRegistration = fetchByPrimaryKey(primaryKey);

		if (benificiaryRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBenificiaryRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return benificiaryRegistration;
	}

	/**
	 * Returns the benificiary registration with the primary key or throws a {@link NoSuchBenificiaryRegistrationException} if it could not be found.
	 *
	 * @param BENIFICIARY_ID the primary key of the benificiary registration
	 * @return the benificiary registration
	 * @throws NoSuchBenificiaryRegistrationException if a benificiary registration with the primary key could not be found
	 */
	@Override
	public BenificiaryRegistration findByPrimaryKey(long BENIFICIARY_ID)
		throws NoSuchBenificiaryRegistrationException {
		return findByPrimaryKey((Serializable)BENIFICIARY_ID);
	}

	/**
	 * Returns the benificiary registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the benificiary registration
	 * @return the benificiary registration, or <code>null</code> if a benificiary registration with the primary key could not be found
	 */
	@Override
	public BenificiaryRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				BenificiaryRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		BenificiaryRegistration benificiaryRegistration = (BenificiaryRegistration)serializable;

		if (benificiaryRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				benificiaryRegistration = (BenificiaryRegistration)session.get(BenificiaryRegistrationImpl.class,
						primaryKey);

				if (benificiaryRegistration != null) {
					cacheResult(benificiaryRegistration);
				}
				else {
					entityCache.putResult(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						BenificiaryRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					BenificiaryRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return benificiaryRegistration;
	}

	/**
	 * Returns the benificiary registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param BENIFICIARY_ID the primary key of the benificiary registration
	 * @return the benificiary registration, or <code>null</code> if a benificiary registration with the primary key could not be found
	 */
	@Override
	public BenificiaryRegistration fetchByPrimaryKey(long BENIFICIARY_ID) {
		return fetchByPrimaryKey((Serializable)BENIFICIARY_ID);
	}

	@Override
	public Map<Serializable, BenificiaryRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BenificiaryRegistration> map = new HashMap<Serializable, BenificiaryRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BenificiaryRegistration benificiaryRegistration = fetchByPrimaryKey(primaryKey);

			if (benificiaryRegistration != null) {
				map.put(primaryKey, benificiaryRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					BenificiaryRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (BenificiaryRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BENIFICIARYREGISTRATION_WHERE_PKS_IN);

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

			for (BenificiaryRegistration benificiaryRegistration : (List<BenificiaryRegistration>)q.list()) {
				map.put(benificiaryRegistration.getPrimaryKeyObj(),
					benificiaryRegistration);

				cacheResult(benificiaryRegistration);

				uncachedPrimaryKeys.remove(benificiaryRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BenificiaryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					BenificiaryRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the benificiary registrations.
	 *
	 * @return the benificiary registrations
	 */
	@Override
	public List<BenificiaryRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the benificiary registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of benificiary registrations
	 * @param end the upper bound of the range of benificiary registrations (not inclusive)
	 * @return the range of benificiary registrations
	 */
	@Override
	public List<BenificiaryRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the benificiary registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of benificiary registrations
	 * @param end the upper bound of the range of benificiary registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of benificiary registrations
	 */
	@Override
	public List<BenificiaryRegistration> findAll(int start, int end,
		OrderByComparator<BenificiaryRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the benificiary registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of benificiary registrations
	 * @param end the upper bound of the range of benificiary registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of benificiary registrations
	 */
	@Override
	public List<BenificiaryRegistration> findAll(int start, int end,
		OrderByComparator<BenificiaryRegistration> orderByComparator,
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

		List<BenificiaryRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<BenificiaryRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BENIFICIARYREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BENIFICIARYREGISTRATION;

				if (pagination) {
					sql = sql.concat(BenificiaryRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BenificiaryRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BenificiaryRegistration>)QueryUtil.list(q,
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
	 * Removes all the benificiary registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BenificiaryRegistration benificiaryRegistration : findAll()) {
			remove(benificiaryRegistration);
		}
	}

	/**
	 * Returns the number of benificiary registrations.
	 *
	 * @return the number of benificiary registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BENIFICIARYREGISTRATION);

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
		return BenificiaryRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the benificiary registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BenificiaryRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_BENIFICIARYREGISTRATION = "SELECT benificiaryRegistration FROM BenificiaryRegistration benificiaryRegistration";
	private static final String _SQL_SELECT_BENIFICIARYREGISTRATION_WHERE_PKS_IN =
		"SELECT benificiaryRegistration FROM BenificiaryRegistration benificiaryRegistration WHERE BENIFICIARY_ID IN (";
	private static final String _SQL_SELECT_BENIFICIARYREGISTRATION_WHERE = "SELECT benificiaryRegistration FROM BenificiaryRegistration benificiaryRegistration WHERE ";
	private static final String _SQL_COUNT_BENIFICIARYREGISTRATION = "SELECT COUNT(benificiaryRegistration) FROM BenificiaryRegistration benificiaryRegistration";
	private static final String _SQL_COUNT_BENIFICIARYREGISTRATION_WHERE = "SELECT COUNT(benificiaryRegistration) FROM BenificiaryRegistration benificiaryRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "benificiaryRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BenificiaryRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BenificiaryRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BenificiaryRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}