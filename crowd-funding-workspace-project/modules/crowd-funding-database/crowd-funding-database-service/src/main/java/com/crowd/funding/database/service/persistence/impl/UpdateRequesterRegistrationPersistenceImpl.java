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

import com.crowd.funding.database.exception.NoSuchUpdateRequesterRegistrationException;
import com.crowd.funding.database.model.UpdateRequesterRegistration;
import com.crowd.funding.database.model.impl.UpdateRequesterRegistrationImpl;
import com.crowd.funding.database.model.impl.UpdateRequesterRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.UpdateRequesterRegistrationPersistence;

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
 * The persistence implementation for the update requester registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UpdateRequesterRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.UpdateRequesterRegistrationUtil
 * @generated
 */
@ProviderType
public class UpdateRequesterRegistrationPersistenceImpl
	extends BasePersistenceImpl<UpdateRequesterRegistration>
	implements UpdateRequesterRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UpdateRequesterRegistrationUtil} to access the update requester registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UpdateRequesterRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			UpdateRequesterRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the update requester registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the update requester registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of update requester registrations
	 * @param end the upper bound of the range of update requester registrations (not inclusive)
	 * @return the range of matching update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the update requester registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of update requester registrations
	 * @param end the upper bound of the range of update requester registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findByUuid(String uuid, int start,
		int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the update requester registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of update requester registrations
	 * @param end the upper bound of the range of update requester registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findByUuid(String uuid, int start,
		int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator,
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

		List<UpdateRequesterRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UpdateRequesterRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UpdateRequesterRegistration updateRequesterRegistration : list) {
					if (!Objects.equals(uuid,
								updateRequesterRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_UPDATEREQUESTERREGISTRATION_WHERE);

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
				query.append(UpdateRequesterRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<UpdateRequesterRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UpdateRequesterRegistration>)QueryUtil.list(q,
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
	 * Returns the first update requester registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching update requester registration
	 * @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration findByUuid_First(String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException {
		UpdateRequesterRegistration updateRequesterRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (updateRequesterRegistration != null) {
			return updateRequesterRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUpdateRequesterRegistrationException(msg.toString());
	}

	/**
	 * Returns the first update requester registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration fetchByUuid_First(String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		List<UpdateRequesterRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last update requester registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching update requester registration
	 * @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration findByUuid_Last(String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException {
		UpdateRequesterRegistration updateRequesterRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (updateRequesterRegistration != null) {
			return updateRequesterRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUpdateRequesterRegistrationException(msg.toString());
	}

	/**
	 * Returns the last update requester registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UpdateRequesterRegistration> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the update requester registrations before and after the current update requester registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the primary key of the current update requester registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next update requester registration
	 * @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	 */
	@Override
	public UpdateRequesterRegistration[] findByUuid_PrevAndNext(
		long PROJECT_UPDATE_REQUEST_ID, String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException {
		UpdateRequesterRegistration updateRequesterRegistration = findByPrimaryKey(PROJECT_UPDATE_REQUEST_ID);

		Session session = null;

		try {
			session = openSession();

			UpdateRequesterRegistration[] array = new UpdateRequesterRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					updateRequesterRegistration, uuid, orderByComparator, true);

			array[1] = updateRequesterRegistration;

			array[2] = getByUuid_PrevAndNext(session,
					updateRequesterRegistration, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UpdateRequesterRegistration getByUuid_PrevAndNext(
		Session session,
		UpdateRequesterRegistration updateRequesterRegistration, String uuid,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_UPDATEREQUESTERREGISTRATION_WHERE);

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
			query.append(UpdateRequesterRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(updateRequesterRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpdateRequesterRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the update requester registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UpdateRequesterRegistration updateRequesterRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(updateRequesterRegistration);
		}
	}

	/**
	 * Returns the number of update requester registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching update requester registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPDATEREQUESTERREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "updateRequesterRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "updateRequesterRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(updateRequesterRegistration.uuid IS NULL OR updateRequesterRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_UPDATE_REQUEST_ID =
		new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_UPDATE_REQUEST_ID",
			new String[] { Long.class.getName() },
			UpdateRequesterRegistrationModelImpl.PROJECT_UPDATE_REQUEST_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_UPDATE_REQUEST_ID =
		new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_UPDATE_REQUEST_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; or throws a {@link NoSuchUpdateRequesterRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	 * @return the matching update requester registration
	 * @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration findByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID)
		throws NoSuchUpdateRequesterRegistrationException {
		UpdateRequesterRegistration updateRequesterRegistration = fetchByPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);

		if (updateRequesterRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_UPDATE_REQUEST_ID=");
			msg.append(PROJECT_UPDATE_REQUEST_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUpdateRequesterRegistrationException(msg.toString());
		}

		return updateRequesterRegistration;
	}

	/**
	 * Returns the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	 * @return the matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration fetchByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID) {
		return fetchByPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID, true);
	}

	/**
	 * Returns the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration fetchByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_UPDATE_REQUEST_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_REQUEST_ID,
					finderArgs, this);
		}

		if (result instanceof UpdateRequesterRegistration) {
			UpdateRequesterRegistration updateRequesterRegistration = (UpdateRequesterRegistration)result;

			if ((PROJECT_UPDATE_REQUEST_ID != updateRequesterRegistration.getPROJECT_UPDATE_REQUEST_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_UPDATEREQUESTERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_UPDATE_REQUEST_ID_PROJECT_UPDATE_REQUEST_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_UPDATE_REQUEST_ID);

				List<UpdateRequesterRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_REQUEST_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"UpdateRequesterRegistrationPersistenceImpl.fetchByPROJECT_UPDATE_REQUEST_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					UpdateRequesterRegistration updateRequesterRegistration = list.get(0);

					result = updateRequesterRegistration;

					cacheResult(updateRequesterRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_REQUEST_ID,
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
			return (UpdateRequesterRegistration)result;
		}
	}

	/**
	 * Removes the update requester registration where PROJECT_UPDATE_REQUEST_ID = &#63; from the database.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	 * @return the update requester registration that was removed
	 */
	@Override
	public UpdateRequesterRegistration removeByPROJECT_UPDATE_REQUEST_ID(
		long PROJECT_UPDATE_REQUEST_ID)
		throws NoSuchUpdateRequesterRegistrationException {
		UpdateRequesterRegistration updateRequesterRegistration = findByPROJECT_UPDATE_REQUEST_ID(PROJECT_UPDATE_REQUEST_ID);

		return remove(updateRequesterRegistration);
	}

	/**
	 * Returns the number of update requester registrations where PROJECT_UPDATE_REQUEST_ID = &#63;.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the project_update_request_id
	 * @return the number of matching update requester registrations
	 */
	@Override
	public int countByPROJECT_UPDATE_REQUEST_ID(long PROJECT_UPDATE_REQUEST_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_UPDATE_REQUEST_ID;

		Object[] finderArgs = new Object[] { PROJECT_UPDATE_REQUEST_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPDATEREQUESTERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_UPDATE_REQUEST_ID_PROJECT_UPDATE_REQUEST_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_UPDATE_REQUEST_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_UPDATE_REQUEST_ID_PROJECT_UPDATE_REQUEST_ID_2 =
		"updateRequesterRegistration.PROJECT_UPDATE_REQUEST_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			UpdateRequesterRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_ID", new String[] { Long.class.getName() });

	/**
	 * Returns all the update requester registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the update requester registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of update requester registrations
	 * @param end the upper bound of the range of update requester registrations (not inclusive)
	 * @return the range of matching update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the update requester registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of update requester registrations
	 * @param end the upper bound of the range of update requester registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the update requester registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of update requester registrations
	 * @param end the upper bound of the range of update requester registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator,
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

		List<UpdateRequesterRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UpdateRequesterRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UpdateRequesterRegistration updateRequesterRegistration : list) {
					if ((PROJECT_ID != updateRequesterRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_UPDATEREQUESTERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UpdateRequesterRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<UpdateRequesterRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UpdateRequesterRegistration>)QueryUtil.list(q,
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
	 * Returns the first update requester registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching update requester registration
	 * @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException {
		UpdateRequesterRegistration updateRequesterRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (updateRequesterRegistration != null) {
			return updateRequesterRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchUpdateRequesterRegistrationException(msg.toString());
	}

	/**
	 * Returns the first update requester registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		List<UpdateRequesterRegistration> list = findByPROJECT_ID(PROJECT_ID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last update requester registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching update requester registration
	 * @throws NoSuchUpdateRequesterRegistrationException if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException {
		UpdateRequesterRegistration updateRequesterRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (updateRequesterRegistration != null) {
			return updateRequesterRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchUpdateRequesterRegistrationException(msg.toString());
	}

	/**
	 * Returns the last update requester registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching update requester registration, or <code>null</code> if a matching update requester registration could not be found
	 */
	@Override
	public UpdateRequesterRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<UpdateRequesterRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the update requester registrations before and after the current update requester registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the primary key of the current update requester registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next update requester registration
	 * @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	 */
	@Override
	public UpdateRequesterRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_UPDATE_REQUEST_ID, long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator)
		throws NoSuchUpdateRequesterRegistrationException {
		UpdateRequesterRegistration updateRequesterRegistration = findByPrimaryKey(PROJECT_UPDATE_REQUEST_ID);

		Session session = null;

		try {
			session = openSession();

			UpdateRequesterRegistration[] array = new UpdateRequesterRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					updateRequesterRegistration, PROJECT_ID, orderByComparator,
					true);

			array[1] = updateRequesterRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					updateRequesterRegistration, PROJECT_ID, orderByComparator,
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

	protected UpdateRequesterRegistration getByPROJECT_ID_PrevAndNext(
		Session session,
		UpdateRequesterRegistration updateRequesterRegistration,
		long PROJECT_ID,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_UPDATEREQUESTERREGISTRATION_WHERE);

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
			query.append(UpdateRequesterRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(updateRequesterRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UpdateRequesterRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the update requester registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (UpdateRequesterRegistration updateRequesterRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(updateRequesterRegistration);
		}
	}

	/**
	 * Returns the number of update requester registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching update requester registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UPDATEREQUESTERREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "updateRequesterRegistration.PROJECT_ID = ?";

	public UpdateRequesterRegistrationPersistenceImpl() {
		setModelClass(UpdateRequesterRegistration.class);

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
	 * Caches the update requester registration in the entity cache if it is enabled.
	 *
	 * @param updateRequesterRegistration the update requester registration
	 */
	@Override
	public void cacheResult(
		UpdateRequesterRegistration updateRequesterRegistration) {
		entityCache.putResult(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class,
			updateRequesterRegistration.getPrimaryKey(),
			updateRequesterRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_REQUEST_ID,
			new Object[] {
				updateRequesterRegistration.getPROJECT_UPDATE_REQUEST_ID()
			}, updateRequesterRegistration);

		updateRequesterRegistration.resetOriginalValues();
	}

	/**
	 * Caches the update requester registrations in the entity cache if it is enabled.
	 *
	 * @param updateRequesterRegistrations the update requester registrations
	 */
	@Override
	public void cacheResult(
		List<UpdateRequesterRegistration> updateRequesterRegistrations) {
		for (UpdateRequesterRegistration updateRequesterRegistration : updateRequesterRegistrations) {
			if (entityCache.getResult(
						UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						UpdateRequesterRegistrationImpl.class,
						updateRequesterRegistration.getPrimaryKey()) == null) {
				cacheResult(updateRequesterRegistration);
			}
			else {
				updateRequesterRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all update requester registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UpdateRequesterRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the update requester registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		UpdateRequesterRegistration updateRequesterRegistration) {
		entityCache.removeResult(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class,
			updateRequesterRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UpdateRequesterRegistrationModelImpl)updateRequesterRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<UpdateRequesterRegistration> updateRequesterRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UpdateRequesterRegistration updateRequesterRegistration : updateRequesterRegistrations) {
			entityCache.removeResult(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				UpdateRequesterRegistrationImpl.class,
				updateRequesterRegistration.getPrimaryKey());

			clearUniqueFindersCache((UpdateRequesterRegistrationModelImpl)updateRequesterRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		UpdateRequesterRegistrationModelImpl updateRequesterRegistrationModelImpl) {
		Object[] args = new Object[] {
				updateRequesterRegistrationModelImpl.getPROJECT_UPDATE_REQUEST_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_UPDATE_REQUEST_ID,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_REQUEST_ID,
			args, updateRequesterRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UpdateRequesterRegistrationModelImpl updateRequesterRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					updateRequesterRegistrationModelImpl.getPROJECT_UPDATE_REQUEST_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_UPDATE_REQUEST_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_REQUEST_ID,
				args);
		}

		if ((updateRequesterRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_UPDATE_REQUEST_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					updateRequesterRegistrationModelImpl.getOriginalPROJECT_UPDATE_REQUEST_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_UPDATE_REQUEST_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_REQUEST_ID,
				args);
		}
	}

	/**
	 * Creates a new update requester registration with the primary key. Does not add the update requester registration to the database.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the primary key for the new update requester registration
	 * @return the new update requester registration
	 */
	@Override
	public UpdateRequesterRegistration create(long PROJECT_UPDATE_REQUEST_ID) {
		UpdateRequesterRegistration updateRequesterRegistration = new UpdateRequesterRegistrationImpl();

		updateRequesterRegistration.setNew(true);
		updateRequesterRegistration.setPrimaryKey(PROJECT_UPDATE_REQUEST_ID);

		String uuid = PortalUUIDUtil.generate();

		updateRequesterRegistration.setUuid(uuid);

		return updateRequesterRegistration;
	}

	/**
	 * Removes the update requester registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	 * @return the update requester registration that was removed
	 * @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	 */
	@Override
	public UpdateRequesterRegistration remove(long PROJECT_UPDATE_REQUEST_ID)
		throws NoSuchUpdateRequesterRegistrationException {
		return remove((Serializable)PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	 * Removes the update requester registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the update requester registration
	 * @return the update requester registration that was removed
	 * @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	 */
	@Override
	public UpdateRequesterRegistration remove(Serializable primaryKey)
		throws NoSuchUpdateRequesterRegistrationException {
		Session session = null;

		try {
			session = openSession();

			UpdateRequesterRegistration updateRequesterRegistration = (UpdateRequesterRegistration)session.get(UpdateRequesterRegistrationImpl.class,
					primaryKey);

			if (updateRequesterRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUpdateRequesterRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(updateRequesterRegistration);
		}
		catch (NoSuchUpdateRequesterRegistrationException nsee) {
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
	protected UpdateRequesterRegistration removeImpl(
		UpdateRequesterRegistration updateRequesterRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(updateRequesterRegistration)) {
				updateRequesterRegistration = (UpdateRequesterRegistration)session.get(UpdateRequesterRegistrationImpl.class,
						updateRequesterRegistration.getPrimaryKeyObj());
			}

			if (updateRequesterRegistration != null) {
				session.delete(updateRequesterRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (updateRequesterRegistration != null) {
			clearCache(updateRequesterRegistration);
		}

		return updateRequesterRegistration;
	}

	@Override
	public UpdateRequesterRegistration updateImpl(
		UpdateRequesterRegistration updateRequesterRegistration) {
		boolean isNew = updateRequesterRegistration.isNew();

		if (!(updateRequesterRegistration instanceof UpdateRequesterRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(updateRequesterRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(updateRequesterRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in updateRequesterRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UpdateRequesterRegistration implementation " +
				updateRequesterRegistration.getClass());
		}

		UpdateRequesterRegistrationModelImpl updateRequesterRegistrationModelImpl =
			(UpdateRequesterRegistrationModelImpl)updateRequesterRegistration;

		if (Validator.isNull(updateRequesterRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			updateRequesterRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (updateRequesterRegistration.isNew()) {
				session.save(updateRequesterRegistration);

				updateRequesterRegistration.setNew(false);
			}
			else {
				updateRequesterRegistration = (UpdateRequesterRegistration)session.merge(updateRequesterRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!UpdateRequesterRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					updateRequesterRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					updateRequesterRegistrationModelImpl.getPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((updateRequesterRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						updateRequesterRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						updateRequesterRegistrationModelImpl.getUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((updateRequesterRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						updateRequesterRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						updateRequesterRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			UpdateRequesterRegistrationImpl.class,
			updateRequesterRegistration.getPrimaryKey(),
			updateRequesterRegistration, false);

		clearUniqueFindersCache(updateRequesterRegistrationModelImpl, false);
		cacheUniqueFindersCache(updateRequesterRegistrationModelImpl);

		updateRequesterRegistration.resetOriginalValues();

		return updateRequesterRegistration;
	}

	/**
	 * Returns the update requester registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the update requester registration
	 * @return the update requester registration
	 * @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	 */
	@Override
	public UpdateRequesterRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUpdateRequesterRegistrationException {
		UpdateRequesterRegistration updateRequesterRegistration = fetchByPrimaryKey(primaryKey);

		if (updateRequesterRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUpdateRequesterRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return updateRequesterRegistration;
	}

	/**
	 * Returns the update requester registration with the primary key or throws a {@link NoSuchUpdateRequesterRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	 * @return the update requester registration
	 * @throws NoSuchUpdateRequesterRegistrationException if a update requester registration with the primary key could not be found
	 */
	@Override
	public UpdateRequesterRegistration findByPrimaryKey(
		long PROJECT_UPDATE_REQUEST_ID)
		throws NoSuchUpdateRequesterRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_UPDATE_REQUEST_ID);
	}

	/**
	 * Returns the update requester registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the update requester registration
	 * @return the update requester registration, or <code>null</code> if a update requester registration with the primary key could not be found
	 */
	@Override
	public UpdateRequesterRegistration fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				UpdateRequesterRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UpdateRequesterRegistration updateRequesterRegistration = (UpdateRequesterRegistration)serializable;

		if (updateRequesterRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				updateRequesterRegistration = (UpdateRequesterRegistration)session.get(UpdateRequesterRegistrationImpl.class,
						primaryKey);

				if (updateRequesterRegistration != null) {
					cacheResult(updateRequesterRegistration);
				}
				else {
					entityCache.putResult(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						UpdateRequesterRegistrationImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UpdateRequesterRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return updateRequesterRegistration;
	}

	/**
	 * Returns the update requester registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_UPDATE_REQUEST_ID the primary key of the update requester registration
	 * @return the update requester registration, or <code>null</code> if a update requester registration with the primary key could not be found
	 */
	@Override
	public UpdateRequesterRegistration fetchByPrimaryKey(
		long PROJECT_UPDATE_REQUEST_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_UPDATE_REQUEST_ID);
	}

	@Override
	public Map<Serializable, UpdateRequesterRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UpdateRequesterRegistration> map = new HashMap<Serializable, UpdateRequesterRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UpdateRequesterRegistration updateRequesterRegistration = fetchByPrimaryKey(primaryKey);

			if (updateRequesterRegistration != null) {
				map.put(primaryKey, updateRequesterRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UpdateRequesterRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(UpdateRequesterRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_UPDATEREQUESTERREGISTRATION_WHERE_PKS_IN);

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

			for (UpdateRequesterRegistration updateRequesterRegistration : (List<UpdateRequesterRegistration>)q.list()) {
				map.put(updateRequesterRegistration.getPrimaryKeyObj(),
					updateRequesterRegistration);

				cacheResult(updateRequesterRegistration);

				uncachedPrimaryKeys.remove(updateRequesterRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UpdateRequesterRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					UpdateRequesterRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the update requester registrations.
	 *
	 * @return the update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the update requester registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of update requester registrations
	 * @param end the upper bound of the range of update requester registrations (not inclusive)
	 * @return the range of update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the update requester registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of update requester registrations
	 * @param end the upper bound of the range of update requester registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findAll(int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the update requester registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UpdateRequesterRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of update requester registrations
	 * @param end the upper bound of the range of update requester registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of update requester registrations
	 */
	@Override
	public List<UpdateRequesterRegistration> findAll(int start, int end,
		OrderByComparator<UpdateRequesterRegistration> orderByComparator,
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

		List<UpdateRequesterRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<UpdateRequesterRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_UPDATEREQUESTERREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UPDATEREQUESTERREGISTRATION;

				if (pagination) {
					sql = sql.concat(UpdateRequesterRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UpdateRequesterRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UpdateRequesterRegistration>)QueryUtil.list(q,
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
	 * Removes all the update requester registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UpdateRequesterRegistration updateRequesterRegistration : findAll()) {
			remove(updateRequesterRegistration);
		}
	}

	/**
	 * Returns the number of update requester registrations.
	 *
	 * @return the number of update requester registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_UPDATEREQUESTERREGISTRATION);

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
		return UpdateRequesterRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the update requester registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UpdateRequesterRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_UPDATEREQUESTERREGISTRATION = "SELECT updateRequesterRegistration FROM UpdateRequesterRegistration updateRequesterRegistration";
	private static final String _SQL_SELECT_UPDATEREQUESTERREGISTRATION_WHERE_PKS_IN =
		"SELECT updateRequesterRegistration FROM UpdateRequesterRegistration updateRequesterRegistration WHERE PROJECT_UPDATE_REQUEST_ID IN (";
	private static final String _SQL_SELECT_UPDATEREQUESTERREGISTRATION_WHERE = "SELECT updateRequesterRegistration FROM UpdateRequesterRegistration updateRequesterRegistration WHERE ";
	private static final String _SQL_COUNT_UPDATEREQUESTERREGISTRATION = "SELECT COUNT(updateRequesterRegistration) FROM UpdateRequesterRegistration updateRequesterRegistration";
	private static final String _SQL_COUNT_UPDATEREQUESTERREGISTRATION_WHERE = "SELECT COUNT(updateRequesterRegistration) FROM UpdateRequesterRegistration updateRequesterRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "updateRequesterRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UpdateRequesterRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UpdateRequesterRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UpdateRequesterRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}