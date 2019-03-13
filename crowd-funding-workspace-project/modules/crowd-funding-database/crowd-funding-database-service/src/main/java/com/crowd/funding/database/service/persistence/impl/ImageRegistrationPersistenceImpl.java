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

import com.crowd.funding.database.exception.NoSuchImageRegistrationException;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.model.impl.ImageRegistrationImpl;
import com.crowd.funding.database.model.impl.ImageRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.ImageRegistrationPersistence;

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
 * The persistence implementation for the image registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.ImageRegistrationUtil
 * @generated
 */
@ProviderType
public class ImageRegistrationPersistenceImpl extends BasePersistenceImpl<ImageRegistration>
	implements ImageRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImageRegistrationUtil} to access the image registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImageRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ImageRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ImageRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ImageRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ImageRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ImageRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the image registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching image registrations
	 */
	@Override
	public List<ImageRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the image registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of image registrations
	 * @param end the upper bound of the range of image registrations (not inclusive)
	 * @return the range of matching image registrations
	 */
	@Override
	public List<ImageRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the image registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of image registrations
	 * @param end the upper bound of the range of image registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching image registrations
	 */
	@Override
	public List<ImageRegistration> findByUuid(String uuid, int start, int end,
		OrderByComparator<ImageRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the image registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of image registrations
	 * @param end the upper bound of the range of image registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching image registrations
	 */
	@Override
	public List<ImageRegistration> findByUuid(String uuid, int start, int end,
		OrderByComparator<ImageRegistration> orderByComparator,
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

		List<ImageRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ImageRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImageRegistration imageRegistration : list) {
					if (!Objects.equals(uuid, imageRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_IMAGEREGISTRATION_WHERE);

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
				query.append(ImageRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ImageRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImageRegistration>)QueryUtil.list(q,
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
	 * Returns the first image registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image registration
	 * @throws NoSuchImageRegistrationException if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration findByUuid_First(String uuid,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException {
		ImageRegistration imageRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (imageRegistration != null) {
			return imageRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchImageRegistrationException(msg.toString());
	}

	/**
	 * Returns the first image registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image registration, or <code>null</code> if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ImageRegistration> orderByComparator) {
		List<ImageRegistration> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last image registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image registration
	 * @throws NoSuchImageRegistrationException if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration findByUuid_Last(String uuid,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException {
		ImageRegistration imageRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (imageRegistration != null) {
			return imageRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchImageRegistrationException(msg.toString());
	}

	/**
	 * Returns the last image registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image registration, or <code>null</code> if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ImageRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ImageRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the image registrations before and after the current image registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_IMAGE_ID the primary key of the current image registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image registration
	 * @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	 */
	@Override
	public ImageRegistration[] findByUuid_PrevAndNext(long PROJECT_IMAGE_ID,
		String uuid, OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException {
		ImageRegistration imageRegistration = findByPrimaryKey(PROJECT_IMAGE_ID);

		Session session = null;

		try {
			session = openSession();

			ImageRegistration[] array = new ImageRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, imageRegistration, uuid,
					orderByComparator, true);

			array[1] = imageRegistration;

			array[2] = getByUuid_PrevAndNext(session, imageRegistration, uuid,
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

	protected ImageRegistration getByUuid_PrevAndNext(Session session,
		ImageRegistration imageRegistration, String uuid,
		OrderByComparator<ImageRegistration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMAGEREGISTRATION_WHERE);

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
			query.append(ImageRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(imageRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImageRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the image registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ImageRegistration imageRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(imageRegistration);
		}
	}

	/**
	 * Returns the number of image registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching image registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMAGEREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "imageRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "imageRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(imageRegistration.uuid IS NULL OR imageRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_IMAGE_ID = new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ImageRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_IMAGE_ID", new String[] { Long.class.getName() },
			ImageRegistrationModelImpl.PROJECT_IMAGE_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_IMAGE_ID = new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_IMAGE_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the image registration where PROJECT_IMAGE_ID = &#63; or throws a {@link NoSuchImageRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_IMAGE_ID the project_image_id
	 * @return the matching image registration
	 * @throws NoSuchImageRegistrationException if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration findByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID)
		throws NoSuchImageRegistrationException {
		ImageRegistration imageRegistration = fetchByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);

		if (imageRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_IMAGE_ID=");
			msg.append(PROJECT_IMAGE_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchImageRegistrationException(msg.toString());
		}

		return imageRegistration;
	}

	/**
	 * Returns the image registration where PROJECT_IMAGE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_IMAGE_ID the project_image_id
	 * @return the matching image registration, or <code>null</code> if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration fetchByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID) {
		return fetchByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID, true);
	}

	/**
	 * Returns the image registration where PROJECT_IMAGE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_IMAGE_ID the project_image_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching image registration, or <code>null</code> if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration fetchByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_IMAGE_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_IMAGE_ID,
					finderArgs, this);
		}

		if (result instanceof ImageRegistration) {
			ImageRegistration imageRegistration = (ImageRegistration)result;

			if ((PROJECT_IMAGE_ID != imageRegistration.getPROJECT_IMAGE_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_IMAGEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_IMAGE_ID_PROJECT_IMAGE_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_IMAGE_ID);

				List<ImageRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_IMAGE_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ImageRegistrationPersistenceImpl.fetchByPROJECT_IMAGE_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ImageRegistration imageRegistration = list.get(0);

					result = imageRegistration;

					cacheResult(imageRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_IMAGE_ID,
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
			return (ImageRegistration)result;
		}
	}

	/**
	 * Removes the image registration where PROJECT_IMAGE_ID = &#63; from the database.
	 *
	 * @param PROJECT_IMAGE_ID the project_image_id
	 * @return the image registration that was removed
	 */
	@Override
	public ImageRegistration removeByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID)
		throws NoSuchImageRegistrationException {
		ImageRegistration imageRegistration = findByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);

		return remove(imageRegistration);
	}

	/**
	 * Returns the number of image registrations where PROJECT_IMAGE_ID = &#63;.
	 *
	 * @param PROJECT_IMAGE_ID the project_image_id
	 * @return the number of matching image registrations
	 */
	@Override
	public int countByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_IMAGE_ID;

		Object[] finderArgs = new Object[] { PROJECT_IMAGE_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMAGEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_IMAGE_ID_PROJECT_IMAGE_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_IMAGE_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_IMAGE_ID_PROJECT_IMAGE_ID_2 =
		"imageRegistration.PROJECT_IMAGE_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ImageRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ImageRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			ImageRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the image registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching image registrations
	 */
	@Override
	public List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the image registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of image registrations
	 * @param end the upper bound of the range of image registrations (not inclusive)
	 * @return the range of matching image registrations
	 */
	@Override
	public List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID, int start,
		int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the image registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of image registrations
	 * @param end the upper bound of the range of image registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching image registrations
	 */
	@Override
	public List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID, int start,
		int end, OrderByComparator<ImageRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the image registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of image registrations
	 * @param end the upper bound of the range of image registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching image registrations
	 */
	@Override
	public List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID, int start,
		int end, OrderByComparator<ImageRegistration> orderByComparator,
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

		List<ImageRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ImageRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ImageRegistration imageRegistration : list) {
					if ((PROJECT_ID != imageRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_IMAGEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImageRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<ImageRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImageRegistration>)QueryUtil.list(q,
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
	 * Returns the first image registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image registration
	 * @throws NoSuchImageRegistrationException if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException {
		ImageRegistration imageRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (imageRegistration != null) {
			return imageRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchImageRegistrationException(msg.toString());
	}

	/**
	 * Returns the first image registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image registration, or <code>null</code> if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator) {
		List<ImageRegistration> list = findByPROJECT_ID(PROJECT_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last image registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image registration
	 * @throws NoSuchImageRegistrationException if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException {
		ImageRegistration imageRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (imageRegistration != null) {
			return imageRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchImageRegistrationException(msg.toString());
	}

	/**
	 * Returns the last image registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image registration, or <code>null</code> if a matching image registration could not be found
	 */
	@Override
	public ImageRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<ImageRegistration> list = findByPROJECT_ID(PROJECT_ID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the image registrations before and after the current image registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_IMAGE_ID the primary key of the current image registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image registration
	 * @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	 */
	@Override
	public ImageRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_IMAGE_ID, long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException {
		ImageRegistration imageRegistration = findByPrimaryKey(PROJECT_IMAGE_ID);

		Session session = null;

		try {
			session = openSession();

			ImageRegistration[] array = new ImageRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session, imageRegistration,
					PROJECT_ID, orderByComparator, true);

			array[1] = imageRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session, imageRegistration,
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

	protected ImageRegistration getByPROJECT_ID_PrevAndNext(Session session,
		ImageRegistration imageRegistration, long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMAGEREGISTRATION_WHERE);

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
			query.append(ImageRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(imageRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImageRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the image registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (ImageRegistration imageRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(imageRegistration);
		}
	}

	/**
	 * Returns the number of image registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching image registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMAGEREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "imageRegistration.PROJECT_ID = ?";

	public ImageRegistrationPersistenceImpl() {
		setModelClass(ImageRegistration.class);

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
	 * Caches the image registration in the entity cache if it is enabled.
	 *
	 * @param imageRegistration the image registration
	 */
	@Override
	public void cacheResult(ImageRegistration imageRegistration) {
		entityCache.putResult(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationImpl.class, imageRegistration.getPrimaryKey(),
			imageRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_IMAGE_ID,
			new Object[] { imageRegistration.getPROJECT_IMAGE_ID() },
			imageRegistration);

		imageRegistration.resetOriginalValues();
	}

	/**
	 * Caches the image registrations in the entity cache if it is enabled.
	 *
	 * @param imageRegistrations the image registrations
	 */
	@Override
	public void cacheResult(List<ImageRegistration> imageRegistrations) {
		for (ImageRegistration imageRegistration : imageRegistrations) {
			if (entityCache.getResult(
						ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ImageRegistrationImpl.class,
						imageRegistration.getPrimaryKey()) == null) {
				cacheResult(imageRegistration);
			}
			else {
				imageRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all image registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImageRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the image registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImageRegistration imageRegistration) {
		entityCache.removeResult(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationImpl.class, imageRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ImageRegistrationModelImpl)imageRegistration,
			true);
	}

	@Override
	public void clearCache(List<ImageRegistration> imageRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImageRegistration imageRegistration : imageRegistrations) {
			entityCache.removeResult(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ImageRegistrationImpl.class, imageRegistration.getPrimaryKey());

			clearUniqueFindersCache((ImageRegistrationModelImpl)imageRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ImageRegistrationModelImpl imageRegistrationModelImpl) {
		Object[] args = new Object[] {
				imageRegistrationModelImpl.getPROJECT_IMAGE_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_IMAGE_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_IMAGE_ID, args,
			imageRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ImageRegistrationModelImpl imageRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					imageRegistrationModelImpl.getPROJECT_IMAGE_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_IMAGE_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_IMAGE_ID, args);
		}

		if ((imageRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_IMAGE_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					imageRegistrationModelImpl.getOriginalPROJECT_IMAGE_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_IMAGE_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_IMAGE_ID, args);
		}
	}

	/**
	 * Creates a new image registration with the primary key. Does not add the image registration to the database.
	 *
	 * @param PROJECT_IMAGE_ID the primary key for the new image registration
	 * @return the new image registration
	 */
	@Override
	public ImageRegistration create(long PROJECT_IMAGE_ID) {
		ImageRegistration imageRegistration = new ImageRegistrationImpl();

		imageRegistration.setNew(true);
		imageRegistration.setPrimaryKey(PROJECT_IMAGE_ID);

		String uuid = PortalUUIDUtil.generate();

		imageRegistration.setUuid(uuid);

		return imageRegistration;
	}

	/**
	 * Removes the image registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_IMAGE_ID the primary key of the image registration
	 * @return the image registration that was removed
	 * @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	 */
	@Override
	public ImageRegistration remove(long PROJECT_IMAGE_ID)
		throws NoSuchImageRegistrationException {
		return remove((Serializable)PROJECT_IMAGE_ID);
	}

	/**
	 * Removes the image registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the image registration
	 * @return the image registration that was removed
	 * @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	 */
	@Override
	public ImageRegistration remove(Serializable primaryKey)
		throws NoSuchImageRegistrationException {
		Session session = null;

		try {
			session = openSession();

			ImageRegistration imageRegistration = (ImageRegistration)session.get(ImageRegistrationImpl.class,
					primaryKey);

			if (imageRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImageRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(imageRegistration);
		}
		catch (NoSuchImageRegistrationException nsee) {
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
	protected ImageRegistration removeImpl(ImageRegistration imageRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(imageRegistration)) {
				imageRegistration = (ImageRegistration)session.get(ImageRegistrationImpl.class,
						imageRegistration.getPrimaryKeyObj());
			}

			if (imageRegistration != null) {
				session.delete(imageRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (imageRegistration != null) {
			clearCache(imageRegistration);
		}

		return imageRegistration;
	}

	@Override
	public ImageRegistration updateImpl(ImageRegistration imageRegistration) {
		boolean isNew = imageRegistration.isNew();

		if (!(imageRegistration instanceof ImageRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(imageRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(imageRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in imageRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ImageRegistration implementation " +
				imageRegistration.getClass());
		}

		ImageRegistrationModelImpl imageRegistrationModelImpl = (ImageRegistrationModelImpl)imageRegistration;

		if (Validator.isNull(imageRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			imageRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (imageRegistration.isNew()) {
				session.save(imageRegistration);

				imageRegistration.setNew(false);
			}
			else {
				session.evict(imageRegistration);
				session.saveOrUpdate(imageRegistration);
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

		if (!ImageRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { imageRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { imageRegistrationModelImpl.getPROJECT_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((imageRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						imageRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { imageRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((imageRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						imageRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] { imageRegistrationModelImpl.getPROJECT_ID() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ImageRegistrationImpl.class, imageRegistration.getPrimaryKey(),
			imageRegistration, false);

		clearUniqueFindersCache(imageRegistrationModelImpl, false);
		cacheUniqueFindersCache(imageRegistrationModelImpl);

		imageRegistration.resetOriginalValues();

		return imageRegistration;
	}

	/**
	 * Returns the image registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the image registration
	 * @return the image registration
	 * @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	 */
	@Override
	public ImageRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImageRegistrationException {
		ImageRegistration imageRegistration = fetchByPrimaryKey(primaryKey);

		if (imageRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImageRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return imageRegistration;
	}

	/**
	 * Returns the image registration with the primary key or throws a {@link NoSuchImageRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_IMAGE_ID the primary key of the image registration
	 * @return the image registration
	 * @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	 */
	@Override
	public ImageRegistration findByPrimaryKey(long PROJECT_IMAGE_ID)
		throws NoSuchImageRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_IMAGE_ID);
	}

	/**
	 * Returns the image registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the image registration
	 * @return the image registration, or <code>null</code> if a image registration with the primary key could not be found
	 */
	@Override
	public ImageRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ImageRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ImageRegistration imageRegistration = (ImageRegistration)serializable;

		if (imageRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				imageRegistration = (ImageRegistration)session.get(ImageRegistrationImpl.class,
						primaryKey);

				if (imageRegistration != null) {
					cacheResult(imageRegistration);
				}
				else {
					entityCache.putResult(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ImageRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ImageRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return imageRegistration;
	}

	/**
	 * Returns the image registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_IMAGE_ID the primary key of the image registration
	 * @return the image registration, or <code>null</code> if a image registration with the primary key could not be found
	 */
	@Override
	public ImageRegistration fetchByPrimaryKey(long PROJECT_IMAGE_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_IMAGE_ID);
	}

	@Override
	public Map<Serializable, ImageRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ImageRegistration> map = new HashMap<Serializable, ImageRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ImageRegistration imageRegistration = fetchByPrimaryKey(primaryKey);

			if (imageRegistration != null) {
				map.put(primaryKey, imageRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ImageRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ImageRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_IMAGEREGISTRATION_WHERE_PKS_IN);

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

			for (ImageRegistration imageRegistration : (List<ImageRegistration>)q.list()) {
				map.put(imageRegistration.getPrimaryKeyObj(), imageRegistration);

				cacheResult(imageRegistration);

				uncachedPrimaryKeys.remove(imageRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ImageRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ImageRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the image registrations.
	 *
	 * @return the image registrations
	 */
	@Override
	public List<ImageRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the image registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of image registrations
	 * @param end the upper bound of the range of image registrations (not inclusive)
	 * @return the range of image registrations
	 */
	@Override
	public List<ImageRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the image registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of image registrations
	 * @param end the upper bound of the range of image registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of image registrations
	 */
	@Override
	public List<ImageRegistration> findAll(int start, int end,
		OrderByComparator<ImageRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the image registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ImageRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of image registrations
	 * @param end the upper bound of the range of image registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of image registrations
	 */
	@Override
	public List<ImageRegistration> findAll(int start, int end,
		OrderByComparator<ImageRegistration> orderByComparator,
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

		List<ImageRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ImageRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_IMAGEREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMAGEREGISTRATION;

				if (pagination) {
					sql = sql.concat(ImageRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ImageRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ImageRegistration>)QueryUtil.list(q,
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
	 * Removes all the image registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ImageRegistration imageRegistration : findAll()) {
			remove(imageRegistration);
		}
	}

	/**
	 * Returns the number of image registrations.
	 *
	 * @return the number of image registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMAGEREGISTRATION);

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
		return ImageRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the image registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ImageRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_IMAGEREGISTRATION = "SELECT imageRegistration FROM ImageRegistration imageRegistration";
	private static final String _SQL_SELECT_IMAGEREGISTRATION_WHERE_PKS_IN = "SELECT imageRegistration FROM ImageRegistration imageRegistration WHERE PROJECT_IMAGE_ID IN (";
	private static final String _SQL_SELECT_IMAGEREGISTRATION_WHERE = "SELECT imageRegistration FROM ImageRegistration imageRegistration WHERE ";
	private static final String _SQL_COUNT_IMAGEREGISTRATION = "SELECT COUNT(imageRegistration) FROM ImageRegistration imageRegistration";
	private static final String _SQL_COUNT_IMAGEREGISTRATION_WHERE = "SELECT COUNT(imageRegistration) FROM ImageRegistration imageRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "imageRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ImageRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ImageRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ImageRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}