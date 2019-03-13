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

import com.crowd.funding.database.exception.NoSuchProjectFollowerRegistrationException;
import com.crowd.funding.database.model.ProjectFollowerRegistration;
import com.crowd.funding.database.model.impl.ProjectFollowerRegistrationImpl;
import com.crowd.funding.database.model.impl.ProjectFollowerRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.ProjectFollowerRegistrationPersistence;

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
 * The persistence implementation for the project follower registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFollowerRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.ProjectFollowerRegistrationUtil
 * @generated
 */
@ProviderType
public class ProjectFollowerRegistrationPersistenceImpl
	extends BasePersistenceImpl<ProjectFollowerRegistration>
	implements ProjectFollowerRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectFollowerRegistrationUtil} to access the project follower registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectFollowerRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectFollowerRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the project follower registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project follower registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @return the range of matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project follower registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByUuid(String uuid, int start,
		int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project follower registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByUuid(String uuid, int start,
		int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
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

		List<ProjectFollowerRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectFollowerRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectFollowerRegistration projectFollowerRegistration : list) {
					if (!Objects.equals(uuid,
								projectFollowerRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE);

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
				query.append(ProjectFollowerRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectFollowerRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectFollowerRegistration>)QueryUtil.list(q,
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
	 * Returns the first project follower registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (projectFollowerRegistration != null) {
			return projectFollowerRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectFollowerRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project follower registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		List<ProjectFollowerRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project follower registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (projectFollowerRegistration != null) {
			return projectFollowerRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectFollowerRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project follower registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectFollowerRegistration> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project follower registrations before and after the current project follower registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_FOLLOWER_ID the primary key of the current project follower registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	 */
	@Override
	public ProjectFollowerRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FOLLOWER_ID, String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = findByPrimaryKey(PROJECT_FOLLOWER_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectFollowerRegistration[] array = new ProjectFollowerRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					projectFollowerRegistration, uuid, orderByComparator, true);

			array[1] = projectFollowerRegistration;

			array[2] = getByUuid_PrevAndNext(session,
					projectFollowerRegistration, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectFollowerRegistration getByUuid_PrevAndNext(
		Session session,
		ProjectFollowerRegistration projectFollowerRegistration, String uuid,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE);

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
			query.append(ProjectFollowerRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(projectFollowerRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectFollowerRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project follower registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectFollowerRegistration projectFollowerRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectFollowerRegistration);
		}
	}

	/**
	 * Returns the number of project follower registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project follower registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTFOLLOWERREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "projectFollowerRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "projectFollowerRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(projectFollowerRegistration.uuid IS NULL OR projectFollowerRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_FOLLOWER_ID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_FOLLOWER_ID",
			new String[] { Long.class.getName() },
			ProjectFollowerRegistrationModelImpl.PROJECT_FOLLOWER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_FOLLOWER_ID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_FOLLOWER_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the project follower registration where PROJECT_FOLLOWER_ID = &#63; or throws a {@link NoSuchProjectFollowerRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_FOLLOWER_ID the project_follower_id
	 * @return the matching project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = fetchByPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);

		if (projectFollowerRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_FOLLOWER_ID=");
			msg.append(PROJECT_FOLLOWER_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectFollowerRegistrationException(msg.toString());
		}

		return projectFollowerRegistration;
	}

	/**
	 * Returns the project follower registration where PROJECT_FOLLOWER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_FOLLOWER_ID the project_follower_id
	 * @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID) {
		return fetchByPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID, true);
	}

	/**
	 * Returns the project follower registration where PROJECT_FOLLOWER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_FOLLOWER_ID the project_follower_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_FOLLOWER_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_FOLLOWER_ID,
					finderArgs, this);
		}

		if (result instanceof ProjectFollowerRegistration) {
			ProjectFollowerRegistration projectFollowerRegistration = (ProjectFollowerRegistration)result;

			if ((PROJECT_FOLLOWER_ID != projectFollowerRegistration.getPROJECT_FOLLOWER_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_FOLLOWER_ID_PROJECT_FOLLOWER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_FOLLOWER_ID);

				List<ProjectFollowerRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FOLLOWER_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectFollowerRegistrationPersistenceImpl.fetchByPROJECT_FOLLOWER_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectFollowerRegistration projectFollowerRegistration = list.get(0);

					result = projectFollowerRegistration;

					cacheResult(projectFollowerRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FOLLOWER_ID,
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
			return (ProjectFollowerRegistration)result;
		}
	}

	/**
	 * Removes the project follower registration where PROJECT_FOLLOWER_ID = &#63; from the database.
	 *
	 * @param PROJECT_FOLLOWER_ID the project_follower_id
	 * @return the project follower registration that was removed
	 */
	@Override
	public ProjectFollowerRegistration removeByPROJECT_FOLLOWER_ID(
		long PROJECT_FOLLOWER_ID)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = findByPROJECT_FOLLOWER_ID(PROJECT_FOLLOWER_ID);

		return remove(projectFollowerRegistration);
	}

	/**
	 * Returns the number of project follower registrations where PROJECT_FOLLOWER_ID = &#63;.
	 *
	 * @param PROJECT_FOLLOWER_ID the project_follower_id
	 * @return the number of matching project follower registrations
	 */
	@Override
	public int countByPROJECT_FOLLOWER_ID(long PROJECT_FOLLOWER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_FOLLOWER_ID;

		Object[] finderArgs = new Object[] { PROJECT_FOLLOWER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTFOLLOWERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_FOLLOWER_ID_PROJECT_FOLLOWER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_FOLLOWER_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_FOLLOWER_ID_PROJECT_FOLLOWER_ID_2 =
		"projectFollowerRegistration.PROJECT_FOLLOWER_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_ID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUSER_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID =
		new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUSER_ID",
			new String[] { Long.class.getName() },
			ProjectFollowerRegistrationModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_ID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUSER_ID", new String[] { Long.class.getName() });

	/**
	 * Returns all the project follower registrations where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @return the matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByUSER_ID(long USER_ID) {
		return findByUSER_ID(USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project follower registrations where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the user_id
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @return the range of matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByUSER_ID(long USER_ID,
		int start, int end) {
		return findByUSER_ID(USER_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project follower registrations where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the user_id
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return findByUSER_ID(USER_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project follower registrations where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the user_id
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID;
			finderArgs = new Object[] { USER_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_ID;
			finderArgs = new Object[] { USER_ID, start, end, orderByComparator };
		}

		List<ProjectFollowerRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectFollowerRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectFollowerRegistration projectFollowerRegistration : list) {
					if ((USER_ID != projectFollowerRegistration.getUSER_ID())) {
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

			query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectFollowerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_ID);

				if (!pagination) {
					list = (List<ProjectFollowerRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectFollowerRegistration>)QueryUtil.list(q,
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
	 * Returns the first project follower registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByUSER_ID_First(long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = fetchByUSER_ID_First(USER_ID,
				orderByComparator);

		if (projectFollowerRegistration != null) {
			return projectFollowerRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append("}");

		throw new NoSuchProjectFollowerRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project follower registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByUSER_ID_First(long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		List<ProjectFollowerRegistration> list = findByUSER_ID(USER_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project follower registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByUSER_ID_Last(long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = fetchByUSER_ID_Last(USER_ID,
				orderByComparator);

		if (projectFollowerRegistration != null) {
			return projectFollowerRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append("}");

		throw new NoSuchProjectFollowerRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project follower registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByUSER_ID_Last(long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		int count = countByUSER_ID(USER_ID);

		if (count == 0) {
			return null;
		}

		List<ProjectFollowerRegistration> list = findByUSER_ID(USER_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project follower registrations before and after the current project follower registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param PROJECT_FOLLOWER_ID the primary key of the current project follower registration
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	 */
	@Override
	public ProjectFollowerRegistration[] findByUSER_ID_PrevAndNext(
		long PROJECT_FOLLOWER_ID, long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = findByPrimaryKey(PROJECT_FOLLOWER_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectFollowerRegistration[] array = new ProjectFollowerRegistrationImpl[3];

			array[0] = getByUSER_ID_PrevAndNext(session,
					projectFollowerRegistration, USER_ID, orderByComparator,
					true);

			array[1] = projectFollowerRegistration;

			array[2] = getByUSER_ID_PrevAndNext(session,
					projectFollowerRegistration, USER_ID, orderByComparator,
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

	protected ProjectFollowerRegistration getByUSER_ID_PrevAndNext(
		Session session,
		ProjectFollowerRegistration projectFollowerRegistration, long USER_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

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
			query.append(ProjectFollowerRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(USER_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectFollowerRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectFollowerRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project follower registrations where USER_ID = &#63; from the database.
	 *
	 * @param USER_ID the user_id
	 */
	@Override
	public void removeByUSER_ID(long USER_ID) {
		for (ProjectFollowerRegistration projectFollowerRegistration : findByUSER_ID(
				USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectFollowerRegistration);
		}
	}

	/**
	 * Returns the number of project follower registrations where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @return the number of matching project follower registrations
	 */
	@Override
	public int countByUSER_ID(long USER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER_ID;

		Object[] finderArgs = new Object[] { USER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTFOLLOWERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_ID);

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

	private static final String _FINDER_COLUMN_USER_ID_USER_ID_2 = "projectFollowerRegistration.USER_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			ProjectFollowerRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_ID", new String[] { Long.class.getName() });

	/**
	 * Returns all the project follower registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project follower registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @return the range of matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project follower registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project follower registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
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

		List<ProjectFollowerRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectFollowerRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectFollowerRegistration projectFollowerRegistration : list) {
					if ((PROJECT_ID != projectFollowerRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectFollowerRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<ProjectFollowerRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectFollowerRegistration>)QueryUtil.list(q,
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
	 * Returns the first project follower registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (projectFollowerRegistration != null) {
			return projectFollowerRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchProjectFollowerRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project follower registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		List<ProjectFollowerRegistration> list = findByPROJECT_ID(PROJECT_ID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project follower registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (projectFollowerRegistration != null) {
			return projectFollowerRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchProjectFollowerRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project follower registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<ProjectFollowerRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project follower registrations before and after the current project follower registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_FOLLOWER_ID the primary key of the current project follower registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	 */
	@Override
	public ProjectFollowerRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FOLLOWER_ID, long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = findByPrimaryKey(PROJECT_FOLLOWER_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectFollowerRegistration[] array = new ProjectFollowerRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					projectFollowerRegistration, PROJECT_ID, orderByComparator,
					true);

			array[1] = projectFollowerRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					projectFollowerRegistration, PROJECT_ID, orderByComparator,
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

	protected ProjectFollowerRegistration getByPROJECT_ID_PrevAndNext(
		Session session,
		ProjectFollowerRegistration projectFollowerRegistration,
		long PROJECT_ID,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE);

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
			query.append(ProjectFollowerRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectFollowerRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectFollowerRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project follower registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (ProjectFollowerRegistration projectFollowerRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectFollowerRegistration);
		}
	}

	/**
	 * Returns the number of project follower registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching project follower registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTFOLLOWERREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "projectFollowerRegistration.PROJECT_ID = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_USER_ID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_USER_ID",
			new String[] { Long.class.getName(), Long.class.getName() },
			ProjectFollowerRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK |
			ProjectFollowerRegistrationModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_USER_ID = new FinderPath(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_USER_ID",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; or throws a {@link NoSuchProjectFollowerRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_ID the project_id
	 * @param USER_ID the user_id
	 * @return the matching project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByPROJECT_USER_ID(long PROJECT_ID,
		long USER_ID) throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = fetchByPROJECT_USER_ID(PROJECT_ID,
				USER_ID);

		if (projectFollowerRegistration == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_ID=");
			msg.append(PROJECT_ID);

			msg.append(", USER_ID=");
			msg.append(USER_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectFollowerRegistrationException(msg.toString());
		}

		return projectFollowerRegistration;
	}

	/**
	 * Returns the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_ID the project_id
	 * @param USER_ID the user_id
	 * @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByPROJECT_USER_ID(long PROJECT_ID,
		long USER_ID) {
		return fetchByPROJECT_USER_ID(PROJECT_ID, USER_ID, true);
	}

	/**
	 * Returns the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_ID the project_id
	 * @param USER_ID the user_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project follower registration, or <code>null</code> if a matching project follower registration could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByPROJECT_USER_ID(long PROJECT_ID,
		long USER_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_ID, USER_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_USER_ID,
					finderArgs, this);
		}

		if (result instanceof ProjectFollowerRegistration) {
			ProjectFollowerRegistration projectFollowerRegistration = (ProjectFollowerRegistration)result;

			if ((PROJECT_ID != projectFollowerRegistration.getPROJECT_ID()) ||
					(USER_ID != projectFollowerRegistration.getUSER_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_USER_ID_PROJECT_ID_2);

			query.append(_FINDER_COLUMN_PROJECT_USER_ID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				qPos.add(USER_ID);

				List<ProjectFollowerRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_USER_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectFollowerRegistrationPersistenceImpl.fetchByPROJECT_USER_ID(long, long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectFollowerRegistration projectFollowerRegistration = list.get(0);

					result = projectFollowerRegistration;

					cacheResult(projectFollowerRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_USER_ID,
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
			return (ProjectFollowerRegistration)result;
		}
	}

	/**
	 * Removes the project follower registration where PROJECT_ID = &#63; and USER_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 * @param USER_ID the user_id
	 * @return the project follower registration that was removed
	 */
	@Override
	public ProjectFollowerRegistration removeByPROJECT_USER_ID(
		long PROJECT_ID, long USER_ID)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = findByPROJECT_USER_ID(PROJECT_ID,
				USER_ID);

		return remove(projectFollowerRegistration);
	}

	/**
	 * Returns the number of project follower registrations where PROJECT_ID = &#63; and USER_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param USER_ID the user_id
	 * @return the number of matching project follower registrations
	 */
	@Override
	public int countByPROJECT_USER_ID(long PROJECT_ID, long USER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_USER_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID, USER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECTFOLLOWERREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_USER_ID_PROJECT_ID_2);

			query.append(_FINDER_COLUMN_PROJECT_USER_ID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				qPos.add(USER_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_USER_ID_PROJECT_ID_2 = "projectFollowerRegistration.PROJECT_ID = ? AND ";
	private static final String _FINDER_COLUMN_PROJECT_USER_ID_USER_ID_2 = "projectFollowerRegistration.USER_ID = ?";

	public ProjectFollowerRegistrationPersistenceImpl() {
		setModelClass(ProjectFollowerRegistration.class);

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
	 * Caches the project follower registration in the entity cache if it is enabled.
	 *
	 * @param projectFollowerRegistration the project follower registration
	 */
	@Override
	public void cacheResult(
		ProjectFollowerRegistration projectFollowerRegistration) {
		entityCache.putResult(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			projectFollowerRegistration.getPrimaryKey(),
			projectFollowerRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FOLLOWER_ID,
			new Object[] { projectFollowerRegistration.getPROJECT_FOLLOWER_ID() },
			projectFollowerRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_USER_ID,
			new Object[] {
				projectFollowerRegistration.getPROJECT_ID(),
				projectFollowerRegistration.getUSER_ID()
			}, projectFollowerRegistration);

		projectFollowerRegistration.resetOriginalValues();
	}

	/**
	 * Caches the project follower registrations in the entity cache if it is enabled.
	 *
	 * @param projectFollowerRegistrations the project follower registrations
	 */
	@Override
	public void cacheResult(
		List<ProjectFollowerRegistration> projectFollowerRegistrations) {
		for (ProjectFollowerRegistration projectFollowerRegistration : projectFollowerRegistrations) {
			if (entityCache.getResult(
						ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectFollowerRegistrationImpl.class,
						projectFollowerRegistration.getPrimaryKey()) == null) {
				cacheResult(projectFollowerRegistration);
			}
			else {
				projectFollowerRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project follower registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectFollowerRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project follower registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProjectFollowerRegistration projectFollowerRegistration) {
		entityCache.removeResult(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			projectFollowerRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProjectFollowerRegistrationModelImpl)projectFollowerRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<ProjectFollowerRegistration> projectFollowerRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectFollowerRegistration projectFollowerRegistration : projectFollowerRegistrations) {
			entityCache.removeResult(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectFollowerRegistrationImpl.class,
				projectFollowerRegistration.getPrimaryKey());

			clearUniqueFindersCache((ProjectFollowerRegistrationModelImpl)projectFollowerRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectFollowerRegistrationModelImpl projectFollowerRegistrationModelImpl) {
		Object[] args = new Object[] {
				projectFollowerRegistrationModelImpl.getPROJECT_FOLLOWER_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_FOLLOWER_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FOLLOWER_ID, args,
			projectFollowerRegistrationModelImpl, false);

		args = new Object[] {
				projectFollowerRegistrationModelImpl.getPROJECT_ID(),
				projectFollowerRegistrationModelImpl.getUSER_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_USER_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_USER_ID, args,
			projectFollowerRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ProjectFollowerRegistrationModelImpl projectFollowerRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					projectFollowerRegistrationModelImpl.getPROJECT_FOLLOWER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_FOLLOWER_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FOLLOWER_ID,
				args);
		}

		if ((projectFollowerRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_FOLLOWER_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					projectFollowerRegistrationModelImpl.getOriginalPROJECT_FOLLOWER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_FOLLOWER_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FOLLOWER_ID,
				args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					projectFollowerRegistrationModelImpl.getPROJECT_ID(),
					projectFollowerRegistrationModelImpl.getUSER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_USER_ID, args);
		}

		if ((projectFollowerRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_USER_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					projectFollowerRegistrationModelImpl.getOriginalPROJECT_ID(),
					projectFollowerRegistrationModelImpl.getOriginalUSER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_USER_ID, args);
		}
	}

	/**
	 * Creates a new project follower registration with the primary key. Does not add the project follower registration to the database.
	 *
	 * @param PROJECT_FOLLOWER_ID the primary key for the new project follower registration
	 * @return the new project follower registration
	 */
	@Override
	public ProjectFollowerRegistration create(long PROJECT_FOLLOWER_ID) {
		ProjectFollowerRegistration projectFollowerRegistration = new ProjectFollowerRegistrationImpl();

		projectFollowerRegistration.setNew(true);
		projectFollowerRegistration.setPrimaryKey(PROJECT_FOLLOWER_ID);

		String uuid = PortalUUIDUtil.generate();

		projectFollowerRegistration.setUuid(uuid);

		return projectFollowerRegistration;
	}

	/**
	 * Removes the project follower registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	 * @return the project follower registration that was removed
	 * @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	 */
	@Override
	public ProjectFollowerRegistration remove(long PROJECT_FOLLOWER_ID)
		throws NoSuchProjectFollowerRegistrationException {
		return remove((Serializable)PROJECT_FOLLOWER_ID);
	}

	/**
	 * Removes the project follower registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project follower registration
	 * @return the project follower registration that was removed
	 * @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	 */
	@Override
	public ProjectFollowerRegistration remove(Serializable primaryKey)
		throws NoSuchProjectFollowerRegistrationException {
		Session session = null;

		try {
			session = openSession();

			ProjectFollowerRegistration projectFollowerRegistration = (ProjectFollowerRegistration)session.get(ProjectFollowerRegistrationImpl.class,
					primaryKey);

			if (projectFollowerRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectFollowerRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectFollowerRegistration);
		}
		catch (NoSuchProjectFollowerRegistrationException nsee) {
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
	protected ProjectFollowerRegistration removeImpl(
		ProjectFollowerRegistration projectFollowerRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectFollowerRegistration)) {
				projectFollowerRegistration = (ProjectFollowerRegistration)session.get(ProjectFollowerRegistrationImpl.class,
						projectFollowerRegistration.getPrimaryKeyObj());
			}

			if (projectFollowerRegistration != null) {
				session.delete(projectFollowerRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectFollowerRegistration != null) {
			clearCache(projectFollowerRegistration);
		}

		return projectFollowerRegistration;
	}

	@Override
	public ProjectFollowerRegistration updateImpl(
		ProjectFollowerRegistration projectFollowerRegistration) {
		boolean isNew = projectFollowerRegistration.isNew();

		if (!(projectFollowerRegistration instanceof ProjectFollowerRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectFollowerRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(projectFollowerRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectFollowerRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectFollowerRegistration implementation " +
				projectFollowerRegistration.getClass());
		}

		ProjectFollowerRegistrationModelImpl projectFollowerRegistrationModelImpl =
			(ProjectFollowerRegistrationModelImpl)projectFollowerRegistration;

		if (Validator.isNull(projectFollowerRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectFollowerRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (projectFollowerRegistration.isNew()) {
				session.save(projectFollowerRegistration);

				projectFollowerRegistration.setNew(false);
			}
			else {
				projectFollowerRegistration = (ProjectFollowerRegistration)session.merge(projectFollowerRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProjectFollowerRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					projectFollowerRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					projectFollowerRegistrationModelImpl.getUSER_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
				args);

			args = new Object[] {
					projectFollowerRegistrationModelImpl.getPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((projectFollowerRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectFollowerRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						projectFollowerRegistrationModelImpl.getUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((projectFollowerRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectFollowerRegistrationModelImpl.getOriginalUSER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);

				args = new Object[] {
						projectFollowerRegistrationModelImpl.getUSER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);
			}

			if ((projectFollowerRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectFollowerRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						projectFollowerRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFollowerRegistrationImpl.class,
			projectFollowerRegistration.getPrimaryKey(),
			projectFollowerRegistration, false);

		clearUniqueFindersCache(projectFollowerRegistrationModelImpl, false);
		cacheUniqueFindersCache(projectFollowerRegistrationModelImpl);

		projectFollowerRegistration.resetOriginalValues();

		return projectFollowerRegistration;
	}

	/**
	 * Returns the project follower registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project follower registration
	 * @return the project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectFollowerRegistrationException {
		ProjectFollowerRegistration projectFollowerRegistration = fetchByPrimaryKey(primaryKey);

		if (projectFollowerRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectFollowerRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectFollowerRegistration;
	}

	/**
	 * Returns the project follower registration with the primary key or throws a {@link NoSuchProjectFollowerRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	 * @return the project follower registration
	 * @throws NoSuchProjectFollowerRegistrationException if a project follower registration with the primary key could not be found
	 */
	@Override
	public ProjectFollowerRegistration findByPrimaryKey(
		long PROJECT_FOLLOWER_ID)
		throws NoSuchProjectFollowerRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_FOLLOWER_ID);
	}

	/**
	 * Returns the project follower registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project follower registration
	 * @return the project follower registration, or <code>null</code> if a project follower registration with the primary key could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectFollowerRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectFollowerRegistration projectFollowerRegistration = (ProjectFollowerRegistration)serializable;

		if (projectFollowerRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				projectFollowerRegistration = (ProjectFollowerRegistration)session.get(ProjectFollowerRegistrationImpl.class,
						primaryKey);

				if (projectFollowerRegistration != null) {
					cacheResult(projectFollowerRegistration);
				}
				else {
					entityCache.putResult(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectFollowerRegistrationImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectFollowerRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectFollowerRegistration;
	}

	/**
	 * Returns the project follower registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_FOLLOWER_ID the primary key of the project follower registration
	 * @return the project follower registration, or <code>null</code> if a project follower registration with the primary key could not be found
	 */
	@Override
	public ProjectFollowerRegistration fetchByPrimaryKey(
		long PROJECT_FOLLOWER_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_FOLLOWER_ID);
	}

	@Override
	public Map<Serializable, ProjectFollowerRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectFollowerRegistration> map = new HashMap<Serializable, ProjectFollowerRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectFollowerRegistration projectFollowerRegistration = fetchByPrimaryKey(primaryKey);

			if (projectFollowerRegistration != null) {
				map.put(primaryKey, projectFollowerRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectFollowerRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(ProjectFollowerRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE_PKS_IN);

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

			for (ProjectFollowerRegistration projectFollowerRegistration : (List<ProjectFollowerRegistration>)q.list()) {
				map.put(projectFollowerRegistration.getPrimaryKeyObj(),
					projectFollowerRegistration);

				cacheResult(projectFollowerRegistration);

				uncachedPrimaryKeys.remove(projectFollowerRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectFollowerRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectFollowerRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the project follower registrations.
	 *
	 * @return the project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project follower registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @return the range of project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project follower registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findAll(int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project follower registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFollowerRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project follower registrations
	 * @param end the upper bound of the range of project follower registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project follower registrations
	 */
	@Override
	public List<ProjectFollowerRegistration> findAll(int start, int end,
		OrderByComparator<ProjectFollowerRegistration> orderByComparator,
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

		List<ProjectFollowerRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectFollowerRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTFOLLOWERREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTFOLLOWERREGISTRATION;

				if (pagination) {
					sql = sql.concat(ProjectFollowerRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectFollowerRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectFollowerRegistration>)QueryUtil.list(q,
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
	 * Removes all the project follower registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectFollowerRegistration projectFollowerRegistration : findAll()) {
			remove(projectFollowerRegistration);
		}
	}

	/**
	 * Returns the number of project follower registrations.
	 *
	 * @return the number of project follower registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTFOLLOWERREGISTRATION);

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
		return ProjectFollowerRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project follower registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectFollowerRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTFOLLOWERREGISTRATION = "SELECT projectFollowerRegistration FROM ProjectFollowerRegistration projectFollowerRegistration";
	private static final String _SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE_PKS_IN =
		"SELECT projectFollowerRegistration FROM ProjectFollowerRegistration projectFollowerRegistration WHERE PROJECT_FOLLOWER_ID IN (";
	private static final String _SQL_SELECT_PROJECTFOLLOWERREGISTRATION_WHERE = "SELECT projectFollowerRegistration FROM ProjectFollowerRegistration projectFollowerRegistration WHERE ";
	private static final String _SQL_COUNT_PROJECTFOLLOWERREGISTRATION = "SELECT COUNT(projectFollowerRegistration) FROM ProjectFollowerRegistration projectFollowerRegistration";
	private static final String _SQL_COUNT_PROJECTFOLLOWERREGISTRATION_WHERE = "SELECT COUNT(projectFollowerRegistration) FROM ProjectFollowerRegistration projectFollowerRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectFollowerRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectFollowerRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectFollowerRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectFollowerRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}