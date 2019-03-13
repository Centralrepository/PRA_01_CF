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

import com.crowd.funding.database.exception.NoSuchProjectAcknowledgementRegistrationException;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;
import com.crowd.funding.database.model.impl.ProjectAcknowledgementRegistrationImpl;
import com.crowd.funding.database.model.impl.ProjectAcknowledgementRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.ProjectAcknowledgementRegistrationPersistence;

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
 * The persistence implementation for the project acknowledgement registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectAcknowledgementRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.ProjectAcknowledgementRegistrationUtil
 * @generated
 */
@ProviderType
public class ProjectAcknowledgementRegistrationPersistenceImpl
	extends BasePersistenceImpl<ProjectAcknowledgementRegistration>
	implements ProjectAcknowledgementRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectAcknowledgementRegistrationUtil} to access the project acknowledgement registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectAcknowledgementRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectAcknowledgementRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the project acknowledgement registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project acknowledgement registrations
	 */
	@Override
	public List<ProjectAcknowledgementRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project acknowledgement registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project acknowledgement registrations
	 * @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	 * @return the range of matching project acknowledgement registrations
	 */
	@Override
	public List<ProjectAcknowledgementRegistration> findByUuid(String uuid,
		int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project acknowledgement registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project acknowledgement registrations
	 * @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project acknowledgement registrations
	 */
	@Override
	public List<ProjectAcknowledgementRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project acknowledgement registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project acknowledgement registrations
	 * @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project acknowledgement registrations
	 */
	@Override
	public List<ProjectAcknowledgementRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator,
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

		List<ProjectAcknowledgementRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectAcknowledgementRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectAcknowledgementRegistration projectAcknowledgementRegistration : list) {
					if (!Objects.equals(uuid,
								projectAcknowledgementRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_PROJECTACKNOWLEDGEMENTREGISTRATION_WHERE);

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
				query.append(ProjectAcknowledgementRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectAcknowledgementRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectAcknowledgementRegistration>)QueryUtil.list(q,
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
	 * Returns the first project acknowledgement registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project acknowledgement registration
	 * @throws NoSuchProjectAcknowledgementRegistrationException if a matching project acknowledgement registration could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator)
		throws NoSuchProjectAcknowledgementRegistrationException {
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (projectAcknowledgementRegistration != null) {
			return projectAcknowledgementRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectAcknowledgementRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project acknowledgement registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator) {
		List<ProjectAcknowledgementRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project acknowledgement registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project acknowledgement registration
	 * @throws NoSuchProjectAcknowledgementRegistrationException if a matching project acknowledgement registration could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator)
		throws NoSuchProjectAcknowledgementRegistrationException {
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (projectAcknowledgementRegistration != null) {
			return projectAcknowledgementRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectAcknowledgementRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project acknowledgement registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectAcknowledgementRegistration> list = findByUuid(uuid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project acknowledgement registrations before and after the current project acknowledgement registration in the ordered set where uuid = &#63;.
	 *
	 * @param ACKNOWLEDGMENT_ID the primary key of the current project acknowledgement registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project acknowledgement registration
	 * @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration[] findByUuid_PrevAndNext(
		long ACKNOWLEDGMENT_ID, String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator)
		throws NoSuchProjectAcknowledgementRegistrationException {
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration = findByPrimaryKey(ACKNOWLEDGMENT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectAcknowledgementRegistration[] array = new ProjectAcknowledgementRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					projectAcknowledgementRegistration, uuid,
					orderByComparator, true);

			array[1] = projectAcknowledgementRegistration;

			array[2] = getByUuid_PrevAndNext(session,
					projectAcknowledgementRegistration, uuid,
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

	protected ProjectAcknowledgementRegistration getByUuid_PrevAndNext(
		Session session,
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration,
		String uuid,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTACKNOWLEDGEMENTREGISTRATION_WHERE);

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
			query.append(ProjectAcknowledgementRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(projectAcknowledgementRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectAcknowledgementRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project acknowledgement registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectAcknowledgementRegistration projectAcknowledgementRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectAcknowledgementRegistration);
		}
	}

	/**
	 * Returns the number of project acknowledgement registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project acknowledgement registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTACKNOWLEDGEMENTREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "projectAcknowledgementRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "projectAcknowledgementRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(projectAcknowledgementRegistration.uuid IS NULL OR projectAcknowledgementRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_ID = new FinderPath(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPROJECT_ID",
			new String[] { Long.class.getName() },
			ProjectAcknowledgementRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the project acknowledgement registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectAcknowledgementRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project acknowledgement registration
	 * @throws NoSuchProjectAcknowledgementRegistrationException if a matching project acknowledgement registration could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration findByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectAcknowledgementRegistrationException {
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration = fetchByPROJECT_ID(PROJECT_ID);

		if (projectAcknowledgementRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_ID=");
			msg.append(PROJECT_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectAcknowledgementRegistrationException(msg.toString());
		}

		return projectAcknowledgementRegistration;
	}

	/**
	 * Returns the project acknowledgement registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration fetchByPROJECT_ID(long PROJECT_ID) {
		return fetchByPROJECT_ID(PROJECT_ID, true);
	}

	/**
	 * Returns the project acknowledgement registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_ID the project_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project acknowledgement registration, or <code>null</code> if a matching project acknowledgement registration could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration fetchByPROJECT_ID(
		long PROJECT_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
					finderArgs, this);
		}

		if (result instanceof ProjectAcknowledgementRegistration) {
			ProjectAcknowledgementRegistration projectAcknowledgementRegistration =
				(ProjectAcknowledgementRegistration)result;

			if ((PROJECT_ID != projectAcknowledgementRegistration.getPROJECT_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROJECTACKNOWLEDGEMENTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				List<ProjectAcknowledgementRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectAcknowledgementRegistrationPersistenceImpl.fetchByPROJECT_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectAcknowledgementRegistration projectAcknowledgementRegistration =
						list.get(0);

					result = projectAcknowledgementRegistration;

					cacheResult(projectAcknowledgementRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
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
			return (ProjectAcknowledgementRegistration)result;
		}
	}

	/**
	 * Removes the project acknowledgement registration where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the project acknowledgement registration that was removed
	 */
	@Override
	public ProjectAcknowledgementRegistration removeByPROJECT_ID(
		long PROJECT_ID)
		throws NoSuchProjectAcknowledgementRegistrationException {
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration = findByPROJECT_ID(PROJECT_ID);

		return remove(projectAcknowledgementRegistration);
	}

	/**
	 * Returns the number of project acknowledgement registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching project acknowledgement registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTACKNOWLEDGEMENTREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "projectAcknowledgementRegistration.PROJECT_ID = ?";

	public ProjectAcknowledgementRegistrationPersistenceImpl() {
		setModelClass(ProjectAcknowledgementRegistration.class);

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
	 * Caches the project acknowledgement registration in the entity cache if it is enabled.
	 *
	 * @param projectAcknowledgementRegistration the project acknowledgement registration
	 */
	@Override
	public void cacheResult(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		entityCache.putResult(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationImpl.class,
			projectAcknowledgementRegistration.getPrimaryKey(),
			projectAcknowledgementRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
			new Object[] { projectAcknowledgementRegistration.getPROJECT_ID() },
			projectAcknowledgementRegistration);

		projectAcknowledgementRegistration.resetOriginalValues();
	}

	/**
	 * Caches the project acknowledgement registrations in the entity cache if it is enabled.
	 *
	 * @param projectAcknowledgementRegistrations the project acknowledgement registrations
	 */
	@Override
	public void cacheResult(
		List<ProjectAcknowledgementRegistration> projectAcknowledgementRegistrations) {
		for (ProjectAcknowledgementRegistration projectAcknowledgementRegistration : projectAcknowledgementRegistrations) {
			if (entityCache.getResult(
						ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectAcknowledgementRegistrationImpl.class,
						projectAcknowledgementRegistration.getPrimaryKey()) == null) {
				cacheResult(projectAcknowledgementRegistration);
			}
			else {
				projectAcknowledgementRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project acknowledgement registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectAcknowledgementRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project acknowledgement registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		entityCache.removeResult(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationImpl.class,
			projectAcknowledgementRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProjectAcknowledgementRegistrationModelImpl)projectAcknowledgementRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<ProjectAcknowledgementRegistration> projectAcknowledgementRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectAcknowledgementRegistration projectAcknowledgementRegistration : projectAcknowledgementRegistrations) {
			entityCache.removeResult(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectAcknowledgementRegistrationImpl.class,
				projectAcknowledgementRegistration.getPrimaryKey());

			clearUniqueFindersCache((ProjectAcknowledgementRegistrationModelImpl)projectAcknowledgementRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectAcknowledgementRegistrationModelImpl projectAcknowledgementRegistrationModelImpl) {
		Object[] args = new Object[] {
				projectAcknowledgementRegistrationModelImpl.getPROJECT_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_ID, args,
			projectAcknowledgementRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ProjectAcknowledgementRegistrationModelImpl projectAcknowledgementRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					projectAcknowledgementRegistrationModelImpl.getPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_ID, args);
		}

		if ((projectAcknowledgementRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					projectAcknowledgementRegistrationModelImpl.getOriginalPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_ID, args);
		}
	}

	/**
	 * Creates a new project acknowledgement registration with the primary key. Does not add the project acknowledgement registration to the database.
	 *
	 * @param ACKNOWLEDGMENT_ID the primary key for the new project acknowledgement registration
	 * @return the new project acknowledgement registration
	 */
	@Override
	public ProjectAcknowledgementRegistration create(long ACKNOWLEDGMENT_ID) {
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration = new ProjectAcknowledgementRegistrationImpl();

		projectAcknowledgementRegistration.setNew(true);
		projectAcknowledgementRegistration.setPrimaryKey(ACKNOWLEDGMENT_ID);

		String uuid = PortalUUIDUtil.generate();

		projectAcknowledgementRegistration.setUuid(uuid);

		return projectAcknowledgementRegistration;
	}

	/**
	 * Removes the project acknowledgement registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	 * @return the project acknowledgement registration that was removed
	 * @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration remove(long ACKNOWLEDGMENT_ID)
		throws NoSuchProjectAcknowledgementRegistrationException {
		return remove((Serializable)ACKNOWLEDGMENT_ID);
	}

	/**
	 * Removes the project acknowledgement registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project acknowledgement registration
	 * @return the project acknowledgement registration that was removed
	 * @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration remove(Serializable primaryKey)
		throws NoSuchProjectAcknowledgementRegistrationException {
		Session session = null;

		try {
			session = openSession();

			ProjectAcknowledgementRegistration projectAcknowledgementRegistration =
				(ProjectAcknowledgementRegistration)session.get(ProjectAcknowledgementRegistrationImpl.class,
					primaryKey);

			if (projectAcknowledgementRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectAcknowledgementRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectAcknowledgementRegistration);
		}
		catch (NoSuchProjectAcknowledgementRegistrationException nsee) {
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
	protected ProjectAcknowledgementRegistration removeImpl(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectAcknowledgementRegistration)) {
				projectAcknowledgementRegistration = (ProjectAcknowledgementRegistration)session.get(ProjectAcknowledgementRegistrationImpl.class,
						projectAcknowledgementRegistration.getPrimaryKeyObj());
			}

			if (projectAcknowledgementRegistration != null) {
				session.delete(projectAcknowledgementRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectAcknowledgementRegistration != null) {
			clearCache(projectAcknowledgementRegistration);
		}

		return projectAcknowledgementRegistration;
	}

	@Override
	public ProjectAcknowledgementRegistration updateImpl(
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration) {
		boolean isNew = projectAcknowledgementRegistration.isNew();

		if (!(projectAcknowledgementRegistration instanceof ProjectAcknowledgementRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
						projectAcknowledgementRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(projectAcknowledgementRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectAcknowledgementRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectAcknowledgementRegistration implementation " +
				projectAcknowledgementRegistration.getClass());
		}

		ProjectAcknowledgementRegistrationModelImpl projectAcknowledgementRegistrationModelImpl =
			(ProjectAcknowledgementRegistrationModelImpl)projectAcknowledgementRegistration;

		if (Validator.isNull(projectAcknowledgementRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectAcknowledgementRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (projectAcknowledgementRegistration.isNew()) {
				session.save(projectAcknowledgementRegistration);

				projectAcknowledgementRegistration.setNew(false);
			}
			else {
				session.evict(projectAcknowledgementRegistration);
				session.saveOrUpdate(projectAcknowledgementRegistration);
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

		if (!ProjectAcknowledgementRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					projectAcknowledgementRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((projectAcknowledgementRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectAcknowledgementRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						projectAcknowledgementRegistrationModelImpl.getUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectAcknowledgementRegistrationImpl.class,
			projectAcknowledgementRegistration.getPrimaryKey(),
			projectAcknowledgementRegistration, false);

		clearUniqueFindersCache(projectAcknowledgementRegistrationModelImpl,
			false);
		cacheUniqueFindersCache(projectAcknowledgementRegistrationModelImpl);

		projectAcknowledgementRegistration.resetOriginalValues();

		return projectAcknowledgementRegistration;
	}

	/**
	 * Returns the project acknowledgement registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project acknowledgement registration
	 * @return the project acknowledgement registration
	 * @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchProjectAcknowledgementRegistrationException {
		ProjectAcknowledgementRegistration projectAcknowledgementRegistration = fetchByPrimaryKey(primaryKey);

		if (projectAcknowledgementRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectAcknowledgementRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectAcknowledgementRegistration;
	}

	/**
	 * Returns the project acknowledgement registration with the primary key or throws a {@link NoSuchProjectAcknowledgementRegistrationException} if it could not be found.
	 *
	 * @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	 * @return the project acknowledgement registration
	 * @throws NoSuchProjectAcknowledgementRegistrationException if a project acknowledgement registration with the primary key could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration findByPrimaryKey(
		long ACKNOWLEDGMENT_ID)
		throws NoSuchProjectAcknowledgementRegistrationException {
		return findByPrimaryKey((Serializable)ACKNOWLEDGMENT_ID);
	}

	/**
	 * Returns the project acknowledgement registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project acknowledgement registration
	 * @return the project acknowledgement registration, or <code>null</code> if a project acknowledgement registration with the primary key could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectAcknowledgementRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectAcknowledgementRegistration projectAcknowledgementRegistration = (ProjectAcknowledgementRegistration)serializable;

		if (projectAcknowledgementRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				projectAcknowledgementRegistration = (ProjectAcknowledgementRegistration)session.get(ProjectAcknowledgementRegistrationImpl.class,
						primaryKey);

				if (projectAcknowledgementRegistration != null) {
					cacheResult(projectAcknowledgementRegistration);
				}
				else {
					entityCache.putResult(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectAcknowledgementRegistrationImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectAcknowledgementRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectAcknowledgementRegistration;
	}

	/**
	 * Returns the project acknowledgement registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ACKNOWLEDGMENT_ID the primary key of the project acknowledgement registration
	 * @return the project acknowledgement registration, or <code>null</code> if a project acknowledgement registration with the primary key could not be found
	 */
	@Override
	public ProjectAcknowledgementRegistration fetchByPrimaryKey(
		long ACKNOWLEDGMENT_ID) {
		return fetchByPrimaryKey((Serializable)ACKNOWLEDGMENT_ID);
	}

	@Override
	public Map<Serializable, ProjectAcknowledgementRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectAcknowledgementRegistration> map = new HashMap<Serializable, ProjectAcknowledgementRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectAcknowledgementRegistration projectAcknowledgementRegistration =
				fetchByPrimaryKey(primaryKey);

			if (projectAcknowledgementRegistration != null) {
				map.put(primaryKey, projectAcknowledgementRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectAcknowledgementRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(ProjectAcknowledgementRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTACKNOWLEDGEMENTREGISTRATION_WHERE_PKS_IN);

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

			for (ProjectAcknowledgementRegistration projectAcknowledgementRegistration : (List<ProjectAcknowledgementRegistration>)q.list()) {
				map.put(projectAcknowledgementRegistration.getPrimaryKeyObj(),
					projectAcknowledgementRegistration);

				cacheResult(projectAcknowledgementRegistration);

				uncachedPrimaryKeys.remove(projectAcknowledgementRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectAcknowledgementRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectAcknowledgementRegistrationImpl.class, primaryKey,
					nullModel);
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
	 * Returns all the project acknowledgement registrations.
	 *
	 * @return the project acknowledgement registrations
	 */
	@Override
	public List<ProjectAcknowledgementRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project acknowledgement registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project acknowledgement registrations
	 * @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	 * @return the range of project acknowledgement registrations
	 */
	@Override
	public List<ProjectAcknowledgementRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project acknowledgement registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project acknowledgement registrations
	 * @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project acknowledgement registrations
	 */
	@Override
	public List<ProjectAcknowledgementRegistration> findAll(int start, int end,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project acknowledgement registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectAcknowledgementRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project acknowledgement registrations
	 * @param end the upper bound of the range of project acknowledgement registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project acknowledgement registrations
	 */
	@Override
	public List<ProjectAcknowledgementRegistration> findAll(int start, int end,
		OrderByComparator<ProjectAcknowledgementRegistration> orderByComparator,
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

		List<ProjectAcknowledgementRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectAcknowledgementRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTACKNOWLEDGEMENTREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTACKNOWLEDGEMENTREGISTRATION;

				if (pagination) {
					sql = sql.concat(ProjectAcknowledgementRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectAcknowledgementRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectAcknowledgementRegistration>)QueryUtil.list(q,
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
	 * Removes all the project acknowledgement registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectAcknowledgementRegistration projectAcknowledgementRegistration : findAll()) {
			remove(projectAcknowledgementRegistration);
		}
	}

	/**
	 * Returns the number of project acknowledgement registrations.
	 *
	 * @return the number of project acknowledgement registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTACKNOWLEDGEMENTREGISTRATION);

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
		return ProjectAcknowledgementRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project acknowledgement registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectAcknowledgementRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTACKNOWLEDGEMENTREGISTRATION = "SELECT projectAcknowledgementRegistration FROM ProjectAcknowledgementRegistration projectAcknowledgementRegistration";
	private static final String _SQL_SELECT_PROJECTACKNOWLEDGEMENTREGISTRATION_WHERE_PKS_IN =
		"SELECT projectAcknowledgementRegistration FROM ProjectAcknowledgementRegistration projectAcknowledgementRegistration WHERE ACKNOWLEDGMENT_ID IN (";
	private static final String _SQL_SELECT_PROJECTACKNOWLEDGEMENTREGISTRATION_WHERE =
		"SELECT projectAcknowledgementRegistration FROM ProjectAcknowledgementRegistration projectAcknowledgementRegistration WHERE ";
	private static final String _SQL_COUNT_PROJECTACKNOWLEDGEMENTREGISTRATION = "SELECT COUNT(projectAcknowledgementRegistration) FROM ProjectAcknowledgementRegistration projectAcknowledgementRegistration";
	private static final String _SQL_COUNT_PROJECTACKNOWLEDGEMENTREGISTRATION_WHERE =
		"SELECT COUNT(projectAcknowledgementRegistration) FROM ProjectAcknowledgementRegistration projectAcknowledgementRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectAcknowledgementRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectAcknowledgementRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectAcknowledgementRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectAcknowledgementRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}