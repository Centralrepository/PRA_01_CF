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

import com.crowd.funding.database.exception.NoSuchProjectUpdateRegistrationException;
import com.crowd.funding.database.model.ProjectUpdateRegistration;
import com.crowd.funding.database.model.impl.ProjectUpdateRegistrationImpl;
import com.crowd.funding.database.model.impl.ProjectUpdateRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.ProjectUpdateRegistrationPersistence;

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
 * The persistence implementation for the project update registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectUpdateRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.ProjectUpdateRegistrationUtil
 * @generated
 */
@ProviderType
public class ProjectUpdateRegistrationPersistenceImpl
	extends BasePersistenceImpl<ProjectUpdateRegistration>
	implements ProjectUpdateRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectUpdateRegistrationUtil} to access the project update registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectUpdateRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectUpdateRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the project update registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project update registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project update registrations
	 * @param end the upper bound of the range of project update registrations (not inclusive)
	 * @return the range of matching project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project update registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project update registrations
	 * @param end the upper bound of the range of project update registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project update registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project update registrations
	 * @param end the upper bound of the range of project update registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findByUuid(String uuid, int start,
		int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator,
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

		List<ProjectUpdateRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUpdateRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectUpdateRegistration projectUpdateRegistration : list) {
					if (!Objects.equals(uuid,
								projectUpdateRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_PROJECTUPDATEREGISTRATION_WHERE);

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
				query.append(ProjectUpdateRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectUpdateRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUpdateRegistration>)QueryUtil.list(q,
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
	 * Returns the first project update registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project update registration
	 * @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException {
		ProjectUpdateRegistration projectUpdateRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (projectUpdateRegistration != null) {
			return projectUpdateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectUpdateRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project update registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project update registration, or <code>null</code> if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		List<ProjectUpdateRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project update registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project update registration
	 * @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException {
		ProjectUpdateRegistration projectUpdateRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (projectUpdateRegistration != null) {
			return projectUpdateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectUpdateRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project update registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project update registration, or <code>null</code> if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectUpdateRegistration> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project update registrations before and after the current project update registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_UPDATE_ID the primary key of the current project update registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project update registration
	 * @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	 */
	@Override
	public ProjectUpdateRegistration[] findByUuid_PrevAndNext(
		long PROJECT_UPDATE_ID, String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException {
		ProjectUpdateRegistration projectUpdateRegistration = findByPrimaryKey(PROJECT_UPDATE_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectUpdateRegistration[] array = new ProjectUpdateRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					projectUpdateRegistration, uuid, orderByComparator, true);

			array[1] = projectUpdateRegistration;

			array[2] = getByUuid_PrevAndNext(session,
					projectUpdateRegistration, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectUpdateRegistration getByUuid_PrevAndNext(Session session,
		ProjectUpdateRegistration projectUpdateRegistration, String uuid,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTUPDATEREGISTRATION_WHERE);

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
			query.append(ProjectUpdateRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(projectUpdateRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectUpdateRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project update registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectUpdateRegistration projectUpdateRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectUpdateRegistration);
		}
	}

	/**
	 * Returns the number of project update registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project update registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTUPDATEREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "projectUpdateRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "projectUpdateRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(projectUpdateRegistration.uuid IS NULL OR projectUpdateRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_UPDATE_ID = new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_UPDATE_ID", new String[] { Long.class.getName() },
			ProjectUpdateRegistrationModelImpl.PROJECT_UPDATE_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_UPDATE_ID = new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_UPDATE_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the project update registration where PROJECT_UPDATE_ID = &#63; or throws a {@link NoSuchProjectUpdateRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_UPDATE_ID the project_update_id
	 * @return the matching project update registration
	 * @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration findByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID) throws NoSuchProjectUpdateRegistrationException {
		ProjectUpdateRegistration projectUpdateRegistration = fetchByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);

		if (projectUpdateRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_UPDATE_ID=");
			msg.append(PROJECT_UPDATE_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectUpdateRegistrationException(msg.toString());
		}

		return projectUpdateRegistration;
	}

	/**
	 * Returns the project update registration where PROJECT_UPDATE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_UPDATE_ID the project_update_id
	 * @return the matching project update registration, or <code>null</code> if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration fetchByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID) {
		return fetchByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID, true);
	}

	/**
	 * Returns the project update registration where PROJECT_UPDATE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_UPDATE_ID the project_update_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project update registration, or <code>null</code> if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration fetchByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_UPDATE_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_ID,
					finderArgs, this);
		}

		if (result instanceof ProjectUpdateRegistration) {
			ProjectUpdateRegistration projectUpdateRegistration = (ProjectUpdateRegistration)result;

			if ((PROJECT_UPDATE_ID != projectUpdateRegistration.getPROJECT_UPDATE_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROJECTUPDATEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_UPDATE_ID_PROJECT_UPDATE_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_UPDATE_ID);

				List<ProjectUpdateRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectUpdateRegistrationPersistenceImpl.fetchByPROJECT_UPDATE_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectUpdateRegistration projectUpdateRegistration = list.get(0);

					result = projectUpdateRegistration;

					cacheResult(projectUpdateRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_ID,
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
			return (ProjectUpdateRegistration)result;
		}
	}

	/**
	 * Removes the project update registration where PROJECT_UPDATE_ID = &#63; from the database.
	 *
	 * @param PROJECT_UPDATE_ID the project_update_id
	 * @return the project update registration that was removed
	 */
	@Override
	public ProjectUpdateRegistration removeByPROJECT_UPDATE_ID(
		long PROJECT_UPDATE_ID) throws NoSuchProjectUpdateRegistrationException {
		ProjectUpdateRegistration projectUpdateRegistration = findByPROJECT_UPDATE_ID(PROJECT_UPDATE_ID);

		return remove(projectUpdateRegistration);
	}

	/**
	 * Returns the number of project update registrations where PROJECT_UPDATE_ID = &#63;.
	 *
	 * @param PROJECT_UPDATE_ID the project_update_id
	 * @return the number of matching project update registrations
	 */
	@Override
	public int countByPROJECT_UPDATE_ID(long PROJECT_UPDATE_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_UPDATE_ID;

		Object[] finderArgs = new Object[] { PROJECT_UPDATE_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTUPDATEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_UPDATE_ID_PROJECT_UPDATE_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_UPDATE_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_UPDATE_ID_PROJECT_UPDATE_ID_2 =
		"projectUpdateRegistration.PROJECT_UPDATE_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			ProjectUpdateRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_ID", new String[] { Long.class.getName() });

	/**
	 * Returns all the project update registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project update registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project update registrations
	 * @param end the upper bound of the range of project update registrations (not inclusive)
	 * @return the range of matching project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project update registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project update registrations
	 * @param end the upper bound of the range of project update registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project update registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project update registrations
	 * @param end the upper bound of the range of project update registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator,
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

		List<ProjectUpdateRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUpdateRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectUpdateRegistration projectUpdateRegistration : list) {
					if ((PROJECT_ID != projectUpdateRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_PROJECTUPDATEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectUpdateRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<ProjectUpdateRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUpdateRegistration>)QueryUtil.list(q,
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
	 * Returns the first project update registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project update registration
	 * @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException {
		ProjectUpdateRegistration projectUpdateRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (projectUpdateRegistration != null) {
			return projectUpdateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchProjectUpdateRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project update registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project update registration, or <code>null</code> if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		List<ProjectUpdateRegistration> list = findByPROJECT_ID(PROJECT_ID, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project update registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project update registration
	 * @throws NoSuchProjectUpdateRegistrationException if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException {
		ProjectUpdateRegistration projectUpdateRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (projectUpdateRegistration != null) {
			return projectUpdateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchProjectUpdateRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project update registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project update registration, or <code>null</code> if a matching project update registration could not be found
	 */
	@Override
	public ProjectUpdateRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<ProjectUpdateRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project update registrations before and after the current project update registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_UPDATE_ID the primary key of the current project update registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project update registration
	 * @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	 */
	@Override
	public ProjectUpdateRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_UPDATE_ID, long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator)
		throws NoSuchProjectUpdateRegistrationException {
		ProjectUpdateRegistration projectUpdateRegistration = findByPrimaryKey(PROJECT_UPDATE_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectUpdateRegistration[] array = new ProjectUpdateRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					projectUpdateRegistration, PROJECT_ID, orderByComparator,
					true);

			array[1] = projectUpdateRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					projectUpdateRegistration, PROJECT_ID, orderByComparator,
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

	protected ProjectUpdateRegistration getByPROJECT_ID_PrevAndNext(
		Session session, ProjectUpdateRegistration projectUpdateRegistration,
		long PROJECT_ID,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTUPDATEREGISTRATION_WHERE);

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
			query.append(ProjectUpdateRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectUpdateRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectUpdateRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project update registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (ProjectUpdateRegistration projectUpdateRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectUpdateRegistration);
		}
	}

	/**
	 * Returns the number of project update registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching project update registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTUPDATEREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "projectUpdateRegistration.PROJECT_ID = ?";

	public ProjectUpdateRegistrationPersistenceImpl() {
		setModelClass(ProjectUpdateRegistration.class);

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
	 * Caches the project update registration in the entity cache if it is enabled.
	 *
	 * @param projectUpdateRegistration the project update registration
	 */
	@Override
	public void cacheResult(ProjectUpdateRegistration projectUpdateRegistration) {
		entityCache.putResult(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class,
			projectUpdateRegistration.getPrimaryKey(), projectUpdateRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_ID,
			new Object[] { projectUpdateRegistration.getPROJECT_UPDATE_ID() },
			projectUpdateRegistration);

		projectUpdateRegistration.resetOriginalValues();
	}

	/**
	 * Caches the project update registrations in the entity cache if it is enabled.
	 *
	 * @param projectUpdateRegistrations the project update registrations
	 */
	@Override
	public void cacheResult(
		List<ProjectUpdateRegistration> projectUpdateRegistrations) {
		for (ProjectUpdateRegistration projectUpdateRegistration : projectUpdateRegistrations) {
			if (entityCache.getResult(
						ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectUpdateRegistrationImpl.class,
						projectUpdateRegistration.getPrimaryKey()) == null) {
				cacheResult(projectUpdateRegistration);
			}
			else {
				projectUpdateRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project update registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectUpdateRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project update registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectUpdateRegistration projectUpdateRegistration) {
		entityCache.removeResult(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class,
			projectUpdateRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProjectUpdateRegistrationModelImpl)projectUpdateRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<ProjectUpdateRegistration> projectUpdateRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectUpdateRegistration projectUpdateRegistration : projectUpdateRegistrations) {
			entityCache.removeResult(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectUpdateRegistrationImpl.class,
				projectUpdateRegistration.getPrimaryKey());

			clearUniqueFindersCache((ProjectUpdateRegistrationModelImpl)projectUpdateRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectUpdateRegistrationModelImpl projectUpdateRegistrationModelImpl) {
		Object[] args = new Object[] {
				projectUpdateRegistrationModelImpl.getPROJECT_UPDATE_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_UPDATE_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_ID, args,
			projectUpdateRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ProjectUpdateRegistrationModelImpl projectUpdateRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					projectUpdateRegistrationModelImpl.getPROJECT_UPDATE_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_UPDATE_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_ID,
				args);
		}

		if ((projectUpdateRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_UPDATE_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					projectUpdateRegistrationModelImpl.getOriginalPROJECT_UPDATE_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_UPDATE_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_UPDATE_ID,
				args);
		}
	}

	/**
	 * Creates a new project update registration with the primary key. Does not add the project update registration to the database.
	 *
	 * @param PROJECT_UPDATE_ID the primary key for the new project update registration
	 * @return the new project update registration
	 */
	@Override
	public ProjectUpdateRegistration create(long PROJECT_UPDATE_ID) {
		ProjectUpdateRegistration projectUpdateRegistration = new ProjectUpdateRegistrationImpl();

		projectUpdateRegistration.setNew(true);
		projectUpdateRegistration.setPrimaryKey(PROJECT_UPDATE_ID);

		String uuid = PortalUUIDUtil.generate();

		projectUpdateRegistration.setUuid(uuid);

		return projectUpdateRegistration;
	}

	/**
	 * Removes the project update registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_UPDATE_ID the primary key of the project update registration
	 * @return the project update registration that was removed
	 * @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	 */
	@Override
	public ProjectUpdateRegistration remove(long PROJECT_UPDATE_ID)
		throws NoSuchProjectUpdateRegistrationException {
		return remove((Serializable)PROJECT_UPDATE_ID);
	}

	/**
	 * Removes the project update registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project update registration
	 * @return the project update registration that was removed
	 * @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	 */
	@Override
	public ProjectUpdateRegistration remove(Serializable primaryKey)
		throws NoSuchProjectUpdateRegistrationException {
		Session session = null;

		try {
			session = openSession();

			ProjectUpdateRegistration projectUpdateRegistration = (ProjectUpdateRegistration)session.get(ProjectUpdateRegistrationImpl.class,
					primaryKey);

			if (projectUpdateRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectUpdateRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectUpdateRegistration);
		}
		catch (NoSuchProjectUpdateRegistrationException nsee) {
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
	protected ProjectUpdateRegistration removeImpl(
		ProjectUpdateRegistration projectUpdateRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectUpdateRegistration)) {
				projectUpdateRegistration = (ProjectUpdateRegistration)session.get(ProjectUpdateRegistrationImpl.class,
						projectUpdateRegistration.getPrimaryKeyObj());
			}

			if (projectUpdateRegistration != null) {
				session.delete(projectUpdateRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectUpdateRegistration != null) {
			clearCache(projectUpdateRegistration);
		}

		return projectUpdateRegistration;
	}

	@Override
	public ProjectUpdateRegistration updateImpl(
		ProjectUpdateRegistration projectUpdateRegistration) {
		boolean isNew = projectUpdateRegistration.isNew();

		if (!(projectUpdateRegistration instanceof ProjectUpdateRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectUpdateRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(projectUpdateRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectUpdateRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectUpdateRegistration implementation " +
				projectUpdateRegistration.getClass());
		}

		ProjectUpdateRegistrationModelImpl projectUpdateRegistrationModelImpl = (ProjectUpdateRegistrationModelImpl)projectUpdateRegistration;

		if (Validator.isNull(projectUpdateRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectUpdateRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (projectUpdateRegistration.isNew()) {
				session.save(projectUpdateRegistration);

				projectUpdateRegistration.setNew(false);
			}
			else {
				projectUpdateRegistration = (ProjectUpdateRegistration)session.merge(projectUpdateRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProjectUpdateRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					projectUpdateRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					projectUpdateRegistrationModelImpl.getPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((projectUpdateRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUpdateRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { projectUpdateRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((projectUpdateRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectUpdateRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						projectUpdateRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectUpdateRegistrationImpl.class,
			projectUpdateRegistration.getPrimaryKey(),
			projectUpdateRegistration, false);

		clearUniqueFindersCache(projectUpdateRegistrationModelImpl, false);
		cacheUniqueFindersCache(projectUpdateRegistrationModelImpl);

		projectUpdateRegistration.resetOriginalValues();

		return projectUpdateRegistration;
	}

	/**
	 * Returns the project update registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project update registration
	 * @return the project update registration
	 * @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	 */
	@Override
	public ProjectUpdateRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectUpdateRegistrationException {
		ProjectUpdateRegistration projectUpdateRegistration = fetchByPrimaryKey(primaryKey);

		if (projectUpdateRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectUpdateRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectUpdateRegistration;
	}

	/**
	 * Returns the project update registration with the primary key or throws a {@link NoSuchProjectUpdateRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_UPDATE_ID the primary key of the project update registration
	 * @return the project update registration
	 * @throws NoSuchProjectUpdateRegistrationException if a project update registration with the primary key could not be found
	 */
	@Override
	public ProjectUpdateRegistration findByPrimaryKey(long PROJECT_UPDATE_ID)
		throws NoSuchProjectUpdateRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_UPDATE_ID);
	}

	/**
	 * Returns the project update registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project update registration
	 * @return the project update registration, or <code>null</code> if a project update registration with the primary key could not be found
	 */
	@Override
	public ProjectUpdateRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectUpdateRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectUpdateRegistration projectUpdateRegistration = (ProjectUpdateRegistration)serializable;

		if (projectUpdateRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				projectUpdateRegistration = (ProjectUpdateRegistration)session.get(ProjectUpdateRegistrationImpl.class,
						primaryKey);

				if (projectUpdateRegistration != null) {
					cacheResult(projectUpdateRegistration);
				}
				else {
					entityCache.putResult(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectUpdateRegistrationImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectUpdateRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectUpdateRegistration;
	}

	/**
	 * Returns the project update registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_UPDATE_ID the primary key of the project update registration
	 * @return the project update registration, or <code>null</code> if a project update registration with the primary key could not be found
	 */
	@Override
	public ProjectUpdateRegistration fetchByPrimaryKey(long PROJECT_UPDATE_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_UPDATE_ID);
	}

	@Override
	public Map<Serializable, ProjectUpdateRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectUpdateRegistration> map = new HashMap<Serializable, ProjectUpdateRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectUpdateRegistration projectUpdateRegistration = fetchByPrimaryKey(primaryKey);

			if (projectUpdateRegistration != null) {
				map.put(primaryKey, projectUpdateRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectUpdateRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProjectUpdateRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTUPDATEREGISTRATION_WHERE_PKS_IN);

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

			for (ProjectUpdateRegistration projectUpdateRegistration : (List<ProjectUpdateRegistration>)q.list()) {
				map.put(projectUpdateRegistration.getPrimaryKeyObj(),
					projectUpdateRegistration);

				cacheResult(projectUpdateRegistration);

				uncachedPrimaryKeys.remove(projectUpdateRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectUpdateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectUpdateRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the project update registrations.
	 *
	 * @return the project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project update registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project update registrations
	 * @param end the upper bound of the range of project update registrations (not inclusive)
	 * @return the range of project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project update registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project update registrations
	 * @param end the upper bound of the range of project update registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findAll(int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project update registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectUpdateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project update registrations
	 * @param end the upper bound of the range of project update registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project update registrations
	 */
	@Override
	public List<ProjectUpdateRegistration> findAll(int start, int end,
		OrderByComparator<ProjectUpdateRegistration> orderByComparator,
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

		List<ProjectUpdateRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectUpdateRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTUPDATEREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTUPDATEREGISTRATION;

				if (pagination) {
					sql = sql.concat(ProjectUpdateRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectUpdateRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectUpdateRegistration>)QueryUtil.list(q,
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
	 * Removes all the project update registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectUpdateRegistration projectUpdateRegistration : findAll()) {
			remove(projectUpdateRegistration);
		}
	}

	/**
	 * Returns the number of project update registrations.
	 *
	 * @return the number of project update registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTUPDATEREGISTRATION);

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
		return ProjectUpdateRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project update registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectUpdateRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTUPDATEREGISTRATION = "SELECT projectUpdateRegistration FROM ProjectUpdateRegistration projectUpdateRegistration";
	private static final String _SQL_SELECT_PROJECTUPDATEREGISTRATION_WHERE_PKS_IN =
		"SELECT projectUpdateRegistration FROM ProjectUpdateRegistration projectUpdateRegistration WHERE PROJECT_UPDATE_ID IN (";
	private static final String _SQL_SELECT_PROJECTUPDATEREGISTRATION_WHERE = "SELECT projectUpdateRegistration FROM ProjectUpdateRegistration projectUpdateRegistration WHERE ";
	private static final String _SQL_COUNT_PROJECTUPDATEREGISTRATION = "SELECT COUNT(projectUpdateRegistration) FROM ProjectUpdateRegistration projectUpdateRegistration";
	private static final String _SQL_COUNT_PROJECTUPDATEREGISTRATION_WHERE = "SELECT COUNT(projectUpdateRegistration) FROM ProjectUpdateRegistration projectUpdateRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectUpdateRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectUpdateRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectUpdateRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectUpdateRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}