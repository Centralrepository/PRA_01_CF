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

import com.crowd.funding.database.exception.NoSuchProjectPriorityRegistrationException;
import com.crowd.funding.database.model.ProjectPriorityRegistration;
import com.crowd.funding.database.model.impl.ProjectPriorityRegistrationImpl;
import com.crowd.funding.database.model.impl.ProjectPriorityRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.ProjectPriorityRegistrationPersistence;

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
 * The persistence implementation for the project priority registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectPriorityRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.ProjectPriorityRegistrationUtil
 * @generated
 */
@ProviderType
public class ProjectPriorityRegistrationPersistenceImpl
	extends BasePersistenceImpl<ProjectPriorityRegistration>
	implements ProjectPriorityRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectPriorityRegistrationUtil} to access the project priority registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectPriorityRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectPriorityRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the project priority registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project priority registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project priority registrations
	 * @param end the upper bound of the range of project priority registrations (not inclusive)
	 * @return the range of matching project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project priority registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project priority registrations
	 * @param end the upper bound of the range of project priority registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findByUuid(String uuid, int start,
		int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project priority registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project priority registrations
	 * @param end the upper bound of the range of project priority registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findByUuid(String uuid, int start,
		int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator,
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

		List<ProjectPriorityRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectPriorityRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectPriorityRegistration projectPriorityRegistration : list) {
					if (!Objects.equals(uuid,
								projectPriorityRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_PROJECTPRIORITYREGISTRATION_WHERE);

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
				query.append(ProjectPriorityRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectPriorityRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectPriorityRegistration>)QueryUtil.list(q,
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
	 * Returns the first project priority registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (projectPriorityRegistration != null) {
			return projectPriorityRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectPriorityRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project priority registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		List<ProjectPriorityRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project priority registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (projectPriorityRegistration != null) {
			return projectPriorityRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectPriorityRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project priority registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectPriorityRegistration> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project priority registrations before and after the current project priority registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_PRIORITY_ID the primary key of the current project priority registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	 */
	@Override
	public ProjectPriorityRegistration[] findByUuid_PrevAndNext(
		long PROJECT_PRIORITY_ID, String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = findByPrimaryKey(PROJECT_PRIORITY_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectPriorityRegistration[] array = new ProjectPriorityRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					projectPriorityRegistration, uuid, orderByComparator, true);

			array[1] = projectPriorityRegistration;

			array[2] = getByUuid_PrevAndNext(session,
					projectPriorityRegistration, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectPriorityRegistration getByUuid_PrevAndNext(
		Session session,
		ProjectPriorityRegistration projectPriorityRegistration, String uuid,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTPRIORITYREGISTRATION_WHERE);

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
			query.append(ProjectPriorityRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(projectPriorityRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectPriorityRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project priority registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectPriorityRegistration projectPriorityRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectPriorityRegistration);
		}
	}

	/**
	 * Returns the number of project priority registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project priority registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTPRIORITYREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "projectPriorityRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "projectPriorityRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(projectPriorityRegistration.uuid IS NULL OR projectPriorityRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_ID = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_ID", new String[] { Long.class.getName() },
			ProjectPriorityRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the project priority registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectPriorityRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration findByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = fetchByPROJECT_ID(PROJECT_ID);

		if (projectPriorityRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_ID=");
			msg.append(PROJECT_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectPriorityRegistrationException(msg.toString());
		}

		return projectPriorityRegistration;
	}

	/**
	 * Returns the project priority registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByPROJECT_ID(long PROJECT_ID) {
		return fetchByPROJECT_ID(PROJECT_ID, true);
	}

	/**
	 * Returns the project priority registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_ID the project_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByPROJECT_ID(long PROJECT_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
					finderArgs, this);
		}

		if (result instanceof ProjectPriorityRegistration) {
			ProjectPriorityRegistration projectPriorityRegistration = (ProjectPriorityRegistration)result;

			if ((PROJECT_ID != projectPriorityRegistration.getPROJECT_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROJECTPRIORITYREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				List<ProjectPriorityRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectPriorityRegistrationPersistenceImpl.fetchByPROJECT_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectPriorityRegistration projectPriorityRegistration = list.get(0);

					result = projectPriorityRegistration;

					cacheResult(projectPriorityRegistration);
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
			return (ProjectPriorityRegistration)result;
		}
	}

	/**
	 * Removes the project priority registration where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the project priority registration that was removed
	 */
	@Override
	public ProjectPriorityRegistration removeByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = findByPROJECT_ID(PROJECT_ID);

		return remove(projectPriorityRegistration);
	}

	/**
	 * Returns the number of project priority registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching project priority registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTPRIORITYREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "projectPriorityRegistration.PROJECT_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIORITY = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPRIORITY",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIORITY =
		new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPRIORITY",
			new String[] { Integer.class.getName() },
			ProjectPriorityRegistrationModelImpl.PRIORITY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIORITY = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPRIORITY", new String[] { Integer.class.getName() });

	/**
	 * Returns all the project priority registrations where PRIORITY = &#63;.
	 *
	 * @param PRIORITY the priority
	 * @return the matching project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findByPRIORITY(int PRIORITY) {
		return findByPRIORITY(PRIORITY, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the project priority registrations where PRIORITY = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PRIORITY the priority
	 * @param start the lower bound of the range of project priority registrations
	 * @param end the upper bound of the range of project priority registrations (not inclusive)
	 * @return the range of matching project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findByPRIORITY(int PRIORITY,
		int start, int end) {
		return findByPRIORITY(PRIORITY, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project priority registrations where PRIORITY = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PRIORITY the priority
	 * @param start the lower bound of the range of project priority registrations
	 * @param end the upper bound of the range of project priority registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findByPRIORITY(int PRIORITY,
		int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return findByPRIORITY(PRIORITY, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project priority registrations where PRIORITY = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PRIORITY the priority
	 * @param start the lower bound of the range of project priority registrations
	 * @param end the upper bound of the range of project priority registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findByPRIORITY(int PRIORITY,
		int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIORITY;
			finderArgs = new Object[] { PRIORITY };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIORITY;
			finderArgs = new Object[] { PRIORITY, start, end, orderByComparator };
		}

		List<ProjectPriorityRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectPriorityRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectPriorityRegistration projectPriorityRegistration : list) {
					if ((PRIORITY != projectPriorityRegistration.getPRIORITY())) {
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

			query.append(_SQL_SELECT_PROJECTPRIORITYREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PRIORITY_PRIORITY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectPriorityRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PRIORITY);

				if (!pagination) {
					list = (List<ProjectPriorityRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectPriorityRegistration>)QueryUtil.list(q,
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
	 * Returns the first project priority registration in the ordered set where PRIORITY = &#63;.
	 *
	 * @param PRIORITY the priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration findByPRIORITY_First(int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = fetchByPRIORITY_First(PRIORITY,
				orderByComparator);

		if (projectPriorityRegistration != null) {
			return projectPriorityRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PRIORITY=");
		msg.append(PRIORITY);

		msg.append("}");

		throw new NoSuchProjectPriorityRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project priority registration in the ordered set where PRIORITY = &#63;.
	 *
	 * @param PRIORITY the priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByPRIORITY_First(int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		List<ProjectPriorityRegistration> list = findByPRIORITY(PRIORITY, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project priority registration in the ordered set where PRIORITY = &#63;.
	 *
	 * @param PRIORITY the priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration findByPRIORITY_Last(int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = fetchByPRIORITY_Last(PRIORITY,
				orderByComparator);

		if (projectPriorityRegistration != null) {
			return projectPriorityRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PRIORITY=");
		msg.append(PRIORITY);

		msg.append("}");

		throw new NoSuchProjectPriorityRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project priority registration in the ordered set where PRIORITY = &#63;.
	 *
	 * @param PRIORITY the priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByPRIORITY_Last(int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		int count = countByPRIORITY(PRIORITY);

		if (count == 0) {
			return null;
		}

		List<ProjectPriorityRegistration> list = findByPRIORITY(PRIORITY,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project priority registrations before and after the current project priority registration in the ordered set where PRIORITY = &#63;.
	 *
	 * @param PROJECT_PRIORITY_ID the primary key of the current project priority registration
	 * @param PRIORITY the priority
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	 */
	@Override
	public ProjectPriorityRegistration[] findByPRIORITY_PrevAndNext(
		long PROJECT_PRIORITY_ID, int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = findByPrimaryKey(PROJECT_PRIORITY_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectPriorityRegistration[] array = new ProjectPriorityRegistrationImpl[3];

			array[0] = getByPRIORITY_PrevAndNext(session,
					projectPriorityRegistration, PRIORITY, orderByComparator,
					true);

			array[1] = projectPriorityRegistration;

			array[2] = getByPRIORITY_PrevAndNext(session,
					projectPriorityRegistration, PRIORITY, orderByComparator,
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

	protected ProjectPriorityRegistration getByPRIORITY_PrevAndNext(
		Session session,
		ProjectPriorityRegistration projectPriorityRegistration, int PRIORITY,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTPRIORITYREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_PRIORITY_PRIORITY_2);

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
			query.append(ProjectPriorityRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PRIORITY);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectPriorityRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectPriorityRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project priority registrations where PRIORITY = &#63; from the database.
	 *
	 * @param PRIORITY the priority
	 */
	@Override
	public void removeByPRIORITY(int PRIORITY) {
		for (ProjectPriorityRegistration projectPriorityRegistration : findByPRIORITY(
				PRIORITY, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectPriorityRegistration);
		}
	}

	/**
	 * Returns the number of project priority registrations where PRIORITY = &#63;.
	 *
	 * @param PRIORITY the priority
	 * @return the number of matching project priority registrations
	 */
	@Override
	public int countByPRIORITY(int PRIORITY) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRIORITY;

		Object[] finderArgs = new Object[] { PRIORITY };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTPRIORITYREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PRIORITY_PRIORITY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PRIORITY);

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

	private static final String _FINDER_COLUMN_PRIORITY_PRIORITY_2 = "projectPriorityRegistration.PRIORITY = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PRIORITY_SEQUANCE = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPRIORITY_SEQUANCE",
			new String[] { Integer.class.getName() },
			ProjectPriorityRegistrationModelImpl.PRIORITY_SEQUANCE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIORITY_SEQUANCE = new FinderPath(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPRIORITY_SEQUANCE", new String[] { Integer.class.getName() });

	/**
	 * Returns the project priority registration where PRIORITY_SEQUANCE = &#63; or throws a {@link NoSuchProjectPriorityRegistrationException} if it could not be found.
	 *
	 * @param PRIORITY_SEQUANCE the priority_sequance
	 * @return the matching project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration findByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = fetchByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);

		if (projectPriorityRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PRIORITY_SEQUANCE=");
			msg.append(PRIORITY_SEQUANCE);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectPriorityRegistrationException(msg.toString());
		}

		return projectPriorityRegistration;
	}

	/**
	 * Returns the project priority registration where PRIORITY_SEQUANCE = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PRIORITY_SEQUANCE the priority_sequance
	 * @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE) {
		return fetchByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE, true);
	}

	/**
	 * Returns the project priority registration where PRIORITY_SEQUANCE = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PRIORITY_SEQUANCE the priority_sequance
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project priority registration, or <code>null</code> if a matching project priority registration could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PRIORITY_SEQUANCE };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PRIORITY_SEQUANCE,
					finderArgs, this);
		}

		if (result instanceof ProjectPriorityRegistration) {
			ProjectPriorityRegistration projectPriorityRegistration = (ProjectPriorityRegistration)result;

			if ((PRIORITY_SEQUANCE != projectPriorityRegistration.getPRIORITY_SEQUANCE())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROJECTPRIORITYREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PRIORITY_SEQUANCE_PRIORITY_SEQUANCE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PRIORITY_SEQUANCE);

				List<ProjectPriorityRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PRIORITY_SEQUANCE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectPriorityRegistrationPersistenceImpl.fetchByPRIORITY_SEQUANCE(int, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectPriorityRegistration projectPriorityRegistration = list.get(0);

					result = projectPriorityRegistration;

					cacheResult(projectPriorityRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PRIORITY_SEQUANCE,
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
			return (ProjectPriorityRegistration)result;
		}
	}

	/**
	 * Removes the project priority registration where PRIORITY_SEQUANCE = &#63; from the database.
	 *
	 * @param PRIORITY_SEQUANCE the priority_sequance
	 * @return the project priority registration that was removed
	 */
	@Override
	public ProjectPriorityRegistration removeByPRIORITY_SEQUANCE(
		int PRIORITY_SEQUANCE)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = findByPRIORITY_SEQUANCE(PRIORITY_SEQUANCE);

		return remove(projectPriorityRegistration);
	}

	/**
	 * Returns the number of project priority registrations where PRIORITY_SEQUANCE = &#63;.
	 *
	 * @param PRIORITY_SEQUANCE the priority_sequance
	 * @return the number of matching project priority registrations
	 */
	@Override
	public int countByPRIORITY_SEQUANCE(int PRIORITY_SEQUANCE) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRIORITY_SEQUANCE;

		Object[] finderArgs = new Object[] { PRIORITY_SEQUANCE };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTPRIORITYREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PRIORITY_SEQUANCE_PRIORITY_SEQUANCE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PRIORITY_SEQUANCE);

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

	private static final String _FINDER_COLUMN_PRIORITY_SEQUANCE_PRIORITY_SEQUANCE_2 =
		"projectPriorityRegistration.PRIORITY_SEQUANCE = ?";

	public ProjectPriorityRegistrationPersistenceImpl() {
		setModelClass(ProjectPriorityRegistration.class);

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
	 * Caches the project priority registration in the entity cache if it is enabled.
	 *
	 * @param projectPriorityRegistration the project priority registration
	 */
	@Override
	public void cacheResult(
		ProjectPriorityRegistration projectPriorityRegistration) {
		entityCache.putResult(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class,
			projectPriorityRegistration.getPrimaryKey(),
			projectPriorityRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
			new Object[] { projectPriorityRegistration.getPROJECT_ID() },
			projectPriorityRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PRIORITY_SEQUANCE,
			new Object[] { projectPriorityRegistration.getPRIORITY_SEQUANCE() },
			projectPriorityRegistration);

		projectPriorityRegistration.resetOriginalValues();
	}

	/**
	 * Caches the project priority registrations in the entity cache if it is enabled.
	 *
	 * @param projectPriorityRegistrations the project priority registrations
	 */
	@Override
	public void cacheResult(
		List<ProjectPriorityRegistration> projectPriorityRegistrations) {
		for (ProjectPriorityRegistration projectPriorityRegistration : projectPriorityRegistrations) {
			if (entityCache.getResult(
						ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectPriorityRegistrationImpl.class,
						projectPriorityRegistration.getPrimaryKey()) == null) {
				cacheResult(projectPriorityRegistration);
			}
			else {
				projectPriorityRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project priority registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectPriorityRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project priority registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProjectPriorityRegistration projectPriorityRegistration) {
		entityCache.removeResult(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class,
			projectPriorityRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProjectPriorityRegistrationModelImpl)projectPriorityRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<ProjectPriorityRegistration> projectPriorityRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectPriorityRegistration projectPriorityRegistration : projectPriorityRegistrations) {
			entityCache.removeResult(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectPriorityRegistrationImpl.class,
				projectPriorityRegistration.getPrimaryKey());

			clearUniqueFindersCache((ProjectPriorityRegistrationModelImpl)projectPriorityRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectPriorityRegistrationModelImpl projectPriorityRegistrationModelImpl) {
		Object[] args = new Object[] {
				projectPriorityRegistrationModelImpl.getPROJECT_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_ID, args,
			projectPriorityRegistrationModelImpl, false);

		args = new Object[] {
				projectPriorityRegistrationModelImpl.getPRIORITY_SEQUANCE()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PRIORITY_SEQUANCE, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PRIORITY_SEQUANCE, args,
			projectPriorityRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ProjectPriorityRegistrationModelImpl projectPriorityRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					projectPriorityRegistrationModelImpl.getPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_ID, args);
		}

		if ((projectPriorityRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					projectPriorityRegistrationModelImpl.getOriginalPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_ID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					projectPriorityRegistrationModelImpl.getPRIORITY_SEQUANCE()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PRIORITY_SEQUANCE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PRIORITY_SEQUANCE,
				args);
		}

		if ((projectPriorityRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PRIORITY_SEQUANCE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					projectPriorityRegistrationModelImpl.getOriginalPRIORITY_SEQUANCE()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PRIORITY_SEQUANCE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PRIORITY_SEQUANCE,
				args);
		}
	}

	/**
	 * Creates a new project priority registration with the primary key. Does not add the project priority registration to the database.
	 *
	 * @param PROJECT_PRIORITY_ID the primary key for the new project priority registration
	 * @return the new project priority registration
	 */
	@Override
	public ProjectPriorityRegistration create(long PROJECT_PRIORITY_ID) {
		ProjectPriorityRegistration projectPriorityRegistration = new ProjectPriorityRegistrationImpl();

		projectPriorityRegistration.setNew(true);
		projectPriorityRegistration.setPrimaryKey(PROJECT_PRIORITY_ID);

		String uuid = PortalUUIDUtil.generate();

		projectPriorityRegistration.setUuid(uuid);

		return projectPriorityRegistration;
	}

	/**
	 * Removes the project priority registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	 * @return the project priority registration that was removed
	 * @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	 */
	@Override
	public ProjectPriorityRegistration remove(long PROJECT_PRIORITY_ID)
		throws NoSuchProjectPriorityRegistrationException {
		return remove((Serializable)PROJECT_PRIORITY_ID);
	}

	/**
	 * Removes the project priority registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project priority registration
	 * @return the project priority registration that was removed
	 * @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	 */
	@Override
	public ProjectPriorityRegistration remove(Serializable primaryKey)
		throws NoSuchProjectPriorityRegistrationException {
		Session session = null;

		try {
			session = openSession();

			ProjectPriorityRegistration projectPriorityRegistration = (ProjectPriorityRegistration)session.get(ProjectPriorityRegistrationImpl.class,
					primaryKey);

			if (projectPriorityRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectPriorityRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectPriorityRegistration);
		}
		catch (NoSuchProjectPriorityRegistrationException nsee) {
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
	protected ProjectPriorityRegistration removeImpl(
		ProjectPriorityRegistration projectPriorityRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectPriorityRegistration)) {
				projectPriorityRegistration = (ProjectPriorityRegistration)session.get(ProjectPriorityRegistrationImpl.class,
						projectPriorityRegistration.getPrimaryKeyObj());
			}

			if (projectPriorityRegistration != null) {
				session.delete(projectPriorityRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectPriorityRegistration != null) {
			clearCache(projectPriorityRegistration);
		}

		return projectPriorityRegistration;
	}

	@Override
	public ProjectPriorityRegistration updateImpl(
		ProjectPriorityRegistration projectPriorityRegistration) {
		boolean isNew = projectPriorityRegistration.isNew();

		if (!(projectPriorityRegistration instanceof ProjectPriorityRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectPriorityRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(projectPriorityRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectPriorityRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectPriorityRegistration implementation " +
				projectPriorityRegistration.getClass());
		}

		ProjectPriorityRegistrationModelImpl projectPriorityRegistrationModelImpl =
			(ProjectPriorityRegistrationModelImpl)projectPriorityRegistration;

		if (Validator.isNull(projectPriorityRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectPriorityRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (projectPriorityRegistration.isNew()) {
				session.save(projectPriorityRegistration);

				projectPriorityRegistration.setNew(false);
			}
			else {
				projectPriorityRegistration = (ProjectPriorityRegistration)session.merge(projectPriorityRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProjectPriorityRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					projectPriorityRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					projectPriorityRegistrationModelImpl.getPRIORITY()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PRIORITY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIORITY,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((projectPriorityRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectPriorityRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						projectPriorityRegistrationModelImpl.getUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((projectPriorityRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIORITY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectPriorityRegistrationModelImpl.getOriginalPRIORITY()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRIORITY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIORITY,
					args);

				args = new Object[] {
						projectPriorityRegistrationModelImpl.getPRIORITY()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRIORITY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIORITY,
					args);
			}
		}

		entityCache.putResult(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectPriorityRegistrationImpl.class,
			projectPriorityRegistration.getPrimaryKey(),
			projectPriorityRegistration, false);

		clearUniqueFindersCache(projectPriorityRegistrationModelImpl, false);
		cacheUniqueFindersCache(projectPriorityRegistrationModelImpl);

		projectPriorityRegistration.resetOriginalValues();

		return projectPriorityRegistration;
	}

	/**
	 * Returns the project priority registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project priority registration
	 * @return the project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	 */
	@Override
	public ProjectPriorityRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectPriorityRegistrationException {
		ProjectPriorityRegistration projectPriorityRegistration = fetchByPrimaryKey(primaryKey);

		if (projectPriorityRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectPriorityRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectPriorityRegistration;
	}

	/**
	 * Returns the project priority registration with the primary key or throws a {@link NoSuchProjectPriorityRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	 * @return the project priority registration
	 * @throws NoSuchProjectPriorityRegistrationException if a project priority registration with the primary key could not be found
	 */
	@Override
	public ProjectPriorityRegistration findByPrimaryKey(
		long PROJECT_PRIORITY_ID)
		throws NoSuchProjectPriorityRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_PRIORITY_ID);
	}

	/**
	 * Returns the project priority registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project priority registration
	 * @return the project priority registration, or <code>null</code> if a project priority registration with the primary key could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectPriorityRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectPriorityRegistration projectPriorityRegistration = (ProjectPriorityRegistration)serializable;

		if (projectPriorityRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				projectPriorityRegistration = (ProjectPriorityRegistration)session.get(ProjectPriorityRegistrationImpl.class,
						primaryKey);

				if (projectPriorityRegistration != null) {
					cacheResult(projectPriorityRegistration);
				}
				else {
					entityCache.putResult(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectPriorityRegistrationImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectPriorityRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectPriorityRegistration;
	}

	/**
	 * Returns the project priority registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_PRIORITY_ID the primary key of the project priority registration
	 * @return the project priority registration, or <code>null</code> if a project priority registration with the primary key could not be found
	 */
	@Override
	public ProjectPriorityRegistration fetchByPrimaryKey(
		long PROJECT_PRIORITY_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_PRIORITY_ID);
	}

	@Override
	public Map<Serializable, ProjectPriorityRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectPriorityRegistration> map = new HashMap<Serializable, ProjectPriorityRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectPriorityRegistration projectPriorityRegistration = fetchByPrimaryKey(primaryKey);

			if (projectPriorityRegistration != null) {
				map.put(primaryKey, projectPriorityRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectPriorityRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(ProjectPriorityRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTPRIORITYREGISTRATION_WHERE_PKS_IN);

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

			for (ProjectPriorityRegistration projectPriorityRegistration : (List<ProjectPriorityRegistration>)q.list()) {
				map.put(projectPriorityRegistration.getPrimaryKeyObj(),
					projectPriorityRegistration);

				cacheResult(projectPriorityRegistration);

				uncachedPrimaryKeys.remove(projectPriorityRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectPriorityRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectPriorityRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the project priority registrations.
	 *
	 * @return the project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project priority registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project priority registrations
	 * @param end the upper bound of the range of project priority registrations (not inclusive)
	 * @return the range of project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project priority registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project priority registrations
	 * @param end the upper bound of the range of project priority registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findAll(int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project priority registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectPriorityRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project priority registrations
	 * @param end the upper bound of the range of project priority registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project priority registrations
	 */
	@Override
	public List<ProjectPriorityRegistration> findAll(int start, int end,
		OrderByComparator<ProjectPriorityRegistration> orderByComparator,
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

		List<ProjectPriorityRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectPriorityRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTPRIORITYREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTPRIORITYREGISTRATION;

				if (pagination) {
					sql = sql.concat(ProjectPriorityRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectPriorityRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectPriorityRegistration>)QueryUtil.list(q,
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
	 * Removes all the project priority registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectPriorityRegistration projectPriorityRegistration : findAll()) {
			remove(projectPriorityRegistration);
		}
	}

	/**
	 * Returns the number of project priority registrations.
	 *
	 * @return the number of project priority registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTPRIORITYREGISTRATION);

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
		return ProjectPriorityRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project priority registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectPriorityRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTPRIORITYREGISTRATION = "SELECT projectPriorityRegistration FROM ProjectPriorityRegistration projectPriorityRegistration";
	private static final String _SQL_SELECT_PROJECTPRIORITYREGISTRATION_WHERE_PKS_IN =
		"SELECT projectPriorityRegistration FROM ProjectPriorityRegistration projectPriorityRegistration WHERE PROJECT_PRIORITY_ID IN (";
	private static final String _SQL_SELECT_PROJECTPRIORITYREGISTRATION_WHERE = "SELECT projectPriorityRegistration FROM ProjectPriorityRegistration projectPriorityRegistration WHERE ";
	private static final String _SQL_COUNT_PROJECTPRIORITYREGISTRATION = "SELECT COUNT(projectPriorityRegistration) FROM ProjectPriorityRegistration projectPriorityRegistration";
	private static final String _SQL_COUNT_PROJECTPRIORITYREGISTRATION_WHERE = "SELECT COUNT(projectPriorityRegistration) FROM ProjectPriorityRegistration projectPriorityRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectPriorityRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectPriorityRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectPriorityRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectPriorityRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}