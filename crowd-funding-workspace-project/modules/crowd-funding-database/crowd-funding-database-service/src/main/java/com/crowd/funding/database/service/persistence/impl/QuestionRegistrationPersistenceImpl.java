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

import com.crowd.funding.database.exception.NoSuchQuestionRegistrationException;
import com.crowd.funding.database.model.QuestionRegistration;
import com.crowd.funding.database.model.impl.QuestionRegistrationImpl;
import com.crowd.funding.database.model.impl.QuestionRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.QuestionRegistrationPersistence;

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
 * The persistence implementation for the question registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuestionRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.QuestionRegistrationUtil
 * @generated
 */
@ProviderType
public class QuestionRegistrationPersistenceImpl extends BasePersistenceImpl<QuestionRegistration>
	implements QuestionRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionRegistrationUtil} to access the question registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			QuestionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			QuestionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			QuestionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			QuestionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			QuestionRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the question registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching question registrations
	 */
	@Override
	public List<QuestionRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the question registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of question registrations
	 * @param end the upper bound of the range of question registrations (not inclusive)
	 * @return the range of matching question registrations
	 */
	@Override
	public List<QuestionRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the question registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of question registrations
	 * @param end the upper bound of the range of question registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching question registrations
	 */
	@Override
	public List<QuestionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<QuestionRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the question registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of question registrations
	 * @param end the upper bound of the range of question registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching question registrations
	 */
	@Override
	public List<QuestionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<QuestionRegistration> orderByComparator,
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

		List<QuestionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<QuestionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuestionRegistration questionRegistration : list) {
					if (!Objects.equals(uuid, questionRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_QUESTIONREGISTRATION_WHERE);

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
				query.append(QuestionRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<QuestionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuestionRegistration>)QueryUtil.list(q,
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
	 * Returns the first question registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question registration
	 * @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration findByUuid_First(String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException {
		QuestionRegistration questionRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (questionRegistration != null) {
			return questionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchQuestionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first question registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question registration, or <code>null</code> if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration fetchByUuid_First(String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		List<QuestionRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last question registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question registration
	 * @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration findByUuid_Last(String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException {
		QuestionRegistration questionRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (questionRegistration != null) {
			return questionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchQuestionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last question registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question registration, or <code>null</code> if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<QuestionRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the question registrations before and after the current question registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_QUESTION_ID the primary key of the current question registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question registration
	 * @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	 */
	@Override
	public QuestionRegistration[] findByUuid_PrevAndNext(
		long PROJECT_QUESTION_ID, String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException {
		QuestionRegistration questionRegistration = findByPrimaryKey(PROJECT_QUESTION_ID);

		Session session = null;

		try {
			session = openSession();

			QuestionRegistration[] array = new QuestionRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, questionRegistration,
					uuid, orderByComparator, true);

			array[1] = questionRegistration;

			array[2] = getByUuid_PrevAndNext(session, questionRegistration,
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

	protected QuestionRegistration getByUuid_PrevAndNext(Session session,
		QuestionRegistration questionRegistration, String uuid,
		OrderByComparator<QuestionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_QUESTIONREGISTRATION_WHERE);

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
			query.append(QuestionRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(questionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QuestionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the question registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (QuestionRegistration questionRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(questionRegistration);
		}
	}

	/**
	 * Returns the number of question registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching question registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "questionRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "questionRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(questionRegistration.uuid IS NULL OR questionRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_QUESTION_ID = new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			QuestionRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_QUESTION_ID",
			new String[] { Long.class.getName() },
			QuestionRegistrationModelImpl.PROJECT_QUESTION_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_QUESTION_ID = new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_QUESTION_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the question registration where PROJECT_QUESTION_ID = &#63; or throws a {@link NoSuchQuestionRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_QUESTION_ID the project_question_id
	 * @return the matching question registration
	 * @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration findByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID) throws NoSuchQuestionRegistrationException {
		QuestionRegistration questionRegistration = fetchByPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);

		if (questionRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_QUESTION_ID=");
			msg.append(PROJECT_QUESTION_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchQuestionRegistrationException(msg.toString());
		}

		return questionRegistration;
	}

	/**
	 * Returns the question registration where PROJECT_QUESTION_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_QUESTION_ID the project_question_id
	 * @return the matching question registration, or <code>null</code> if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration fetchByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID) {
		return fetchByPROJECT_QUESTION_ID(PROJECT_QUESTION_ID, true);
	}

	/**
	 * Returns the question registration where PROJECT_QUESTION_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_QUESTION_ID the project_question_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching question registration, or <code>null</code> if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration fetchByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_QUESTION_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_QUESTION_ID,
					finderArgs, this);
		}

		if (result instanceof QuestionRegistration) {
			QuestionRegistration questionRegistration = (QuestionRegistration)result;

			if ((PROJECT_QUESTION_ID != questionRegistration.getPROJECT_QUESTION_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_QUESTIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_QUESTION_ID_PROJECT_QUESTION_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_QUESTION_ID);

				List<QuestionRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_QUESTION_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"QuestionRegistrationPersistenceImpl.fetchByPROJECT_QUESTION_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuestionRegistration questionRegistration = list.get(0);

					result = questionRegistration;

					cacheResult(questionRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_QUESTION_ID,
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
			return (QuestionRegistration)result;
		}
	}

	/**
	 * Removes the question registration where PROJECT_QUESTION_ID = &#63; from the database.
	 *
	 * @param PROJECT_QUESTION_ID the project_question_id
	 * @return the question registration that was removed
	 */
	@Override
	public QuestionRegistration removeByPROJECT_QUESTION_ID(
		long PROJECT_QUESTION_ID) throws NoSuchQuestionRegistrationException {
		QuestionRegistration questionRegistration = findByPROJECT_QUESTION_ID(PROJECT_QUESTION_ID);

		return remove(questionRegistration);
	}

	/**
	 * Returns the number of question registrations where PROJECT_QUESTION_ID = &#63;.
	 *
	 * @param PROJECT_QUESTION_ID the project_question_id
	 * @return the number of matching question registrations
	 */
	@Override
	public int countByPROJECT_QUESTION_ID(long PROJECT_QUESTION_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_QUESTION_ID;

		Object[] finderArgs = new Object[] { PROJECT_QUESTION_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_QUESTION_ID_PROJECT_QUESTION_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_QUESTION_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_QUESTION_ID_PROJECT_QUESTION_ID_2 =
		"questionRegistration.PROJECT_QUESTION_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			QuestionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			QuestionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			QuestionRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the question registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching question registrations
	 */
	@Override
	public List<QuestionRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the question registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of question registrations
	 * @param end the upper bound of the range of question registrations (not inclusive)
	 * @return the range of matching question registrations
	 */
	@Override
	public List<QuestionRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the question registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of question registrations
	 * @param end the upper bound of the range of question registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching question registrations
	 */
	@Override
	public List<QuestionRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the question registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of question registrations
	 * @param end the upper bound of the range of question registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching question registrations
	 */
	@Override
	public List<QuestionRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<QuestionRegistration> orderByComparator,
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

		List<QuestionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<QuestionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuestionRegistration questionRegistration : list) {
					if ((PROJECT_ID != questionRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_QUESTIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(QuestionRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<QuestionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuestionRegistration>)QueryUtil.list(q,
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
	 * Returns the first question registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question registration
	 * @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException {
		QuestionRegistration questionRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (questionRegistration != null) {
			return questionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchQuestionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first question registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question registration, or <code>null</code> if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		List<QuestionRegistration> list = findByPROJECT_ID(PROJECT_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last question registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question registration
	 * @throws NoSuchQuestionRegistrationException if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException {
		QuestionRegistration questionRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (questionRegistration != null) {
			return questionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchQuestionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last question registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question registration, or <code>null</code> if a matching question registration could not be found
	 */
	@Override
	public QuestionRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<QuestionRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the question registrations before and after the current question registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_QUESTION_ID the primary key of the current question registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question registration
	 * @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	 */
	@Override
	public QuestionRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_QUESTION_ID, long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator)
		throws NoSuchQuestionRegistrationException {
		QuestionRegistration questionRegistration = findByPrimaryKey(PROJECT_QUESTION_ID);

		Session session = null;

		try {
			session = openSession();

			QuestionRegistration[] array = new QuestionRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					questionRegistration, PROJECT_ID, orderByComparator, true);

			array[1] = questionRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					questionRegistration, PROJECT_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuestionRegistration getByPROJECT_ID_PrevAndNext(
		Session session, QuestionRegistration questionRegistration,
		long PROJECT_ID,
		OrderByComparator<QuestionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_QUESTIONREGISTRATION_WHERE);

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
			query.append(QuestionRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(questionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<QuestionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the question registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (QuestionRegistration questionRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(questionRegistration);
		}
	}

	/**
	 * Returns the number of question registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching question registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "questionRegistration.PROJECT_ID = ?";

	public QuestionRegistrationPersistenceImpl() {
		setModelClass(QuestionRegistration.class);

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
	 * Caches the question registration in the entity cache if it is enabled.
	 *
	 * @param questionRegistration the question registration
	 */
	@Override
	public void cacheResult(QuestionRegistration questionRegistration) {
		entityCache.putResult(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationImpl.class,
			questionRegistration.getPrimaryKey(), questionRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_QUESTION_ID,
			new Object[] { questionRegistration.getPROJECT_QUESTION_ID() },
			questionRegistration);

		questionRegistration.resetOriginalValues();
	}

	/**
	 * Caches the question registrations in the entity cache if it is enabled.
	 *
	 * @param questionRegistrations the question registrations
	 */
	@Override
	public void cacheResult(List<QuestionRegistration> questionRegistrations) {
		for (QuestionRegistration questionRegistration : questionRegistrations) {
			if (entityCache.getResult(
						QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						QuestionRegistrationImpl.class,
						questionRegistration.getPrimaryKey()) == null) {
				cacheResult(questionRegistration);
			}
			else {
				questionRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all question registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QuestionRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuestionRegistration questionRegistration) {
		entityCache.removeResult(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationImpl.class, questionRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((QuestionRegistrationModelImpl)questionRegistration,
			true);
	}

	@Override
	public void clearCache(List<QuestionRegistration> questionRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuestionRegistration questionRegistration : questionRegistrations) {
			entityCache.removeResult(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				QuestionRegistrationImpl.class,
				questionRegistration.getPrimaryKey());

			clearUniqueFindersCache((QuestionRegistrationModelImpl)questionRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		QuestionRegistrationModelImpl questionRegistrationModelImpl) {
		Object[] args = new Object[] {
				questionRegistrationModelImpl.getPROJECT_QUESTION_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_QUESTION_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_QUESTION_ID, args,
			questionRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		QuestionRegistrationModelImpl questionRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					questionRegistrationModelImpl.getPROJECT_QUESTION_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_QUESTION_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_QUESTION_ID,
				args);
		}

		if ((questionRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_QUESTION_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					questionRegistrationModelImpl.getOriginalPROJECT_QUESTION_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_QUESTION_ID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_QUESTION_ID,
				args);
		}
	}

	/**
	 * Creates a new question registration with the primary key. Does not add the question registration to the database.
	 *
	 * @param PROJECT_QUESTION_ID the primary key for the new question registration
	 * @return the new question registration
	 */
	@Override
	public QuestionRegistration create(long PROJECT_QUESTION_ID) {
		QuestionRegistration questionRegistration = new QuestionRegistrationImpl();

		questionRegistration.setNew(true);
		questionRegistration.setPrimaryKey(PROJECT_QUESTION_ID);

		String uuid = PortalUUIDUtil.generate();

		questionRegistration.setUuid(uuid);

		return questionRegistration;
	}

	/**
	 * Removes the question registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_QUESTION_ID the primary key of the question registration
	 * @return the question registration that was removed
	 * @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	 */
	@Override
	public QuestionRegistration remove(long PROJECT_QUESTION_ID)
		throws NoSuchQuestionRegistrationException {
		return remove((Serializable)PROJECT_QUESTION_ID);
	}

	/**
	 * Removes the question registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question registration
	 * @return the question registration that was removed
	 * @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	 */
	@Override
	public QuestionRegistration remove(Serializable primaryKey)
		throws NoSuchQuestionRegistrationException {
		Session session = null;

		try {
			session = openSession();

			QuestionRegistration questionRegistration = (QuestionRegistration)session.get(QuestionRegistrationImpl.class,
					primaryKey);

			if (questionRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(questionRegistration);
		}
		catch (NoSuchQuestionRegistrationException nsee) {
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
	protected QuestionRegistration removeImpl(
		QuestionRegistration questionRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(questionRegistration)) {
				questionRegistration = (QuestionRegistration)session.get(QuestionRegistrationImpl.class,
						questionRegistration.getPrimaryKeyObj());
			}

			if (questionRegistration != null) {
				session.delete(questionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (questionRegistration != null) {
			clearCache(questionRegistration);
		}

		return questionRegistration;
	}

	@Override
	public QuestionRegistration updateImpl(
		QuestionRegistration questionRegistration) {
		boolean isNew = questionRegistration.isNew();

		if (!(questionRegistration instanceof QuestionRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(questionRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(questionRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in questionRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuestionRegistration implementation " +
				questionRegistration.getClass());
		}

		QuestionRegistrationModelImpl questionRegistrationModelImpl = (QuestionRegistrationModelImpl)questionRegistration;

		if (Validator.isNull(questionRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			questionRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (questionRegistration.isNew()) {
				session.save(questionRegistration);

				questionRegistration.setNew(false);
			}
			else {
				questionRegistration = (QuestionRegistration)session.merge(questionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!QuestionRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { questionRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { questionRegistrationModelImpl.getPROJECT_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((questionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						questionRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { questionRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((questionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						questionRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						questionRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			QuestionRegistrationImpl.class,
			questionRegistration.getPrimaryKey(), questionRegistration, false);

		clearUniqueFindersCache(questionRegistrationModelImpl, false);
		cacheUniqueFindersCache(questionRegistrationModelImpl);

		questionRegistration.resetOriginalValues();

		return questionRegistration;
	}

	/**
	 * Returns the question registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question registration
	 * @return the question registration
	 * @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	 */
	@Override
	public QuestionRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuestionRegistrationException {
		QuestionRegistration questionRegistration = fetchByPrimaryKey(primaryKey);

		if (questionRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuestionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return questionRegistration;
	}

	/**
	 * Returns the question registration with the primary key or throws a {@link NoSuchQuestionRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_QUESTION_ID the primary key of the question registration
	 * @return the question registration
	 * @throws NoSuchQuestionRegistrationException if a question registration with the primary key could not be found
	 */
	@Override
	public QuestionRegistration findByPrimaryKey(long PROJECT_QUESTION_ID)
		throws NoSuchQuestionRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_QUESTION_ID);
	}

	/**
	 * Returns the question registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question registration
	 * @return the question registration, or <code>null</code> if a question registration with the primary key could not be found
	 */
	@Override
	public QuestionRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				QuestionRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		QuestionRegistration questionRegistration = (QuestionRegistration)serializable;

		if (questionRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				questionRegistration = (QuestionRegistration)session.get(QuestionRegistrationImpl.class,
						primaryKey);

				if (questionRegistration != null) {
					cacheResult(questionRegistration);
				}
				else {
					entityCache.putResult(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						QuestionRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					QuestionRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return questionRegistration;
	}

	/**
	 * Returns the question registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_QUESTION_ID the primary key of the question registration
	 * @return the question registration, or <code>null</code> if a question registration with the primary key could not be found
	 */
	@Override
	public QuestionRegistration fetchByPrimaryKey(long PROJECT_QUESTION_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_QUESTION_ID);
	}

	@Override
	public Map<Serializable, QuestionRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, QuestionRegistration> map = new HashMap<Serializable, QuestionRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			QuestionRegistration questionRegistration = fetchByPrimaryKey(primaryKey);

			if (questionRegistration != null) {
				map.put(primaryKey, questionRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					QuestionRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (QuestionRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_QUESTIONREGISTRATION_WHERE_PKS_IN);

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

			for (QuestionRegistration questionRegistration : (List<QuestionRegistration>)q.list()) {
				map.put(questionRegistration.getPrimaryKeyObj(),
					questionRegistration);

				cacheResult(questionRegistration);

				uncachedPrimaryKeys.remove(questionRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(QuestionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					QuestionRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the question registrations.
	 *
	 * @return the question registrations
	 */
	@Override
	public List<QuestionRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the question registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of question registrations
	 * @param end the upper bound of the range of question registrations (not inclusive)
	 * @return the range of question registrations
	 */
	@Override
	public List<QuestionRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the question registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of question registrations
	 * @param end the upper bound of the range of question registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of question registrations
	 */
	@Override
	public List<QuestionRegistration> findAll(int start, int end,
		OrderByComparator<QuestionRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the question registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of question registrations
	 * @param end the upper bound of the range of question registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of question registrations
	 */
	@Override
	public List<QuestionRegistration> findAll(int start, int end,
		OrderByComparator<QuestionRegistration> orderByComparator,
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

		List<QuestionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<QuestionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_QUESTIONREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTIONREGISTRATION;

				if (pagination) {
					sql = sql.concat(QuestionRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<QuestionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuestionRegistration>)QueryUtil.list(q,
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
	 * Removes all the question registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuestionRegistration questionRegistration : findAll()) {
			remove(questionRegistration);
		}
	}

	/**
	 * Returns the number of question registrations.
	 *
	 * @return the number of question registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTIONREGISTRATION);

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
		return QuestionRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the question registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(QuestionRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_QUESTIONREGISTRATION = "SELECT questionRegistration FROM QuestionRegistration questionRegistration";
	private static final String _SQL_SELECT_QUESTIONREGISTRATION_WHERE_PKS_IN = "SELECT questionRegistration FROM QuestionRegistration questionRegistration WHERE PROJECT_QUESTION_ID IN (";
	private static final String _SQL_SELECT_QUESTIONREGISTRATION_WHERE = "SELECT questionRegistration FROM QuestionRegistration questionRegistration WHERE ";
	private static final String _SQL_COUNT_QUESTIONREGISTRATION = "SELECT COUNT(questionRegistration) FROM QuestionRegistration questionRegistration";
	private static final String _SQL_COUNT_QUESTIONREGISTRATION_WHERE = "SELECT COUNT(questionRegistration) FROM QuestionRegistration questionRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "questionRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QuestionRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No QuestionRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(QuestionRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}