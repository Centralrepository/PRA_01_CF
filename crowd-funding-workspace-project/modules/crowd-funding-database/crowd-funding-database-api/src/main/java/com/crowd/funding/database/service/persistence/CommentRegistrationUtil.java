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

package com.crowd.funding.database.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.CommentRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the comment registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.CommentRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommentRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.CommentRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class CommentRegistrationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CommentRegistration commentRegistration) {
		getPersistence().clearCache(commentRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CommentRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CommentRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CommentRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CommentRegistration update(
		CommentRegistration commentRegistration) {
		return getPersistence().update(commentRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CommentRegistration update(
		CommentRegistration commentRegistration, ServiceContext serviceContext) {
		return getPersistence().update(commentRegistration, serviceContext);
	}

	/**
	* Returns all the comment registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching comment registrations
	*/
	public static List<CommentRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the comment registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @return the range of matching comment registrations
	*/
	public static List<CommentRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the comment registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching comment registrations
	*/
	public static List<CommentRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the comment registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching comment registrations
	*/
	public static List<CommentRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first comment registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public static CommentRegistration findByUuid_First(String uuid,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first comment registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchByUuid_First(String uuid,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last comment registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public static CommentRegistration findByUuid_Last(String uuid,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last comment registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the comment registrations before and after the current comment registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_COMMENT_ID the primary key of the current comment registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment registration
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public static CommentRegistration[] findByUuid_PrevAndNext(
		long PROJECT_COMMENT_ID, String uuid,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_COMMENT_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the comment registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of comment registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching comment registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the comment registration where PROJECT_COMMENT_ID = &#63; or throws a {@link NoSuchCommentRegistrationException} if it could not be found.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @return the matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public static CommentRegistration findByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence().findByPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);
	}

	/**
	* Returns the comment registration where PROJECT_COMMENT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @return the matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID) {
		return getPersistence().fetchByPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);
	}

	/**
	* Returns the comment registration where PROJECT_COMMENT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_COMMENT_ID(PROJECT_COMMENT_ID,
			retrieveFromCache);
	}

	/**
	* Removes the comment registration where PROJECT_COMMENT_ID = &#63; from the database.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @return the comment registration that was removed
	*/
	public static CommentRegistration removeByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence().removeByPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);
	}

	/**
	* Returns the number of comment registrations where PROJECT_COMMENT_ID = &#63;.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @return the number of matching comment registrations
	*/
	public static int countByPROJECT_COMMENT_ID(long PROJECT_COMMENT_ID) {
		return getPersistence().countByPROJECT_COMMENT_ID(PROJECT_COMMENT_ID);
	}

	/**
	* Returns all the comment registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching comment registrations
	*/
	public static List<CommentRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns a range of all the comment registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @return the range of matching comment registrations
	*/
	public static List<CommentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

	/**
	* Returns an ordered range of all the comment registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching comment registrations
	*/
	public static List<CommentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the comment registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching comment registrations
	*/
	public static List<CommentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public static CommentRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public static CommentRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the comment registrations before and after the current comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_COMMENT_ID the primary key of the current comment registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment registration
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public static CommentRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_COMMENT_ID, long PROJECT_ID,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_COMMENT_ID,
			PROJECT_ID, orderByComparator);
	}

	/**
	* Removes all the comment registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of comment registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching comment registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns all the comment registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching comment registrations
	*/
	public static List<CommentRegistration> findBySTATUS(int STATUS) {
		return getPersistence().findBySTATUS(STATUS);
	}

	/**
	* Returns a range of all the comment registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @return the range of matching comment registrations
	*/
	public static List<CommentRegistration> findBySTATUS(int STATUS, int start,
		int end) {
		return getPersistence().findBySTATUS(STATUS, start, end);
	}

	/**
	* Returns an ordered range of all the comment registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching comment registrations
	*/
	public static List<CommentRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the comment registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching comment registrations
	*/
	public static List<CommentRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first comment registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public static CommentRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence().findBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the first comment registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the last comment registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public static CommentRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence().findBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the last comment registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the comment registrations before and after the current comment registration in the ordered set where STATUS = &#63;.
	*
	* @param PROJECT_COMMENT_ID the primary key of the current comment registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment registration
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public static CommentRegistration[] findBySTATUS_PrevAndNext(
		long PROJECT_COMMENT_ID, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence()
				   .findBySTATUS_PrevAndNext(PROJECT_COMMENT_ID, STATUS,
			orderByComparator);
	}

	/**
	* Removes all the comment registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public static void removeBySTATUS(int STATUS) {
		getPersistence().removeBySTATUS(STATUS);
	}

	/**
	* Returns the number of comment registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching comment registrations
	*/
	public static int countBySTATUS(int STATUS) {
		return getPersistence().countBySTATUS(STATUS);
	}

	/**
	* Returns all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @return the matching comment registrations
	*/
	public static List<CommentRegistration> findByPROJECT_ID_STATUS(
		long PROJECT_ID, int STATUS) {
		return getPersistence().findByPROJECT_ID_STATUS(PROJECT_ID, STATUS);
	}

	/**
	* Returns a range of all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @return the range of matching comment registrations
	*/
	public static List<CommentRegistration> findByPROJECT_ID_STATUS(
		long PROJECT_ID, int STATUS, int start, int end) {
		return getPersistence()
				   .findByPROJECT_ID_STATUS(PROJECT_ID, STATUS, start, end);
	}

	/**
	* Returns an ordered range of all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching comment registrations
	*/
	public static List<CommentRegistration> findByPROJECT_ID_STATUS(
		long PROJECT_ID, int STATUS, int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID_STATUS(PROJECT_ID, STATUS, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching comment registrations
	*/
	public static List<CommentRegistration> findByPROJECT_ID_STATUS(
		long PROJECT_ID, int STATUS, int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID_STATUS(PROJECT_ID, STATUS, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public static CommentRegistration findByPROJECT_ID_STATUS_First(
		long PROJECT_ID, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_STATUS_First(PROJECT_ID, STATUS,
			orderByComparator);
	}

	/**
	* Returns the first comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchByPROJECT_ID_STATUS_First(
		long PROJECT_ID, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_STATUS_First(PROJECT_ID, STATUS,
			orderByComparator);
	}

	/**
	* Returns the last comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public static CommentRegistration findByPROJECT_ID_STATUS_Last(
		long PROJECT_ID, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_STATUS_Last(PROJECT_ID, STATUS,
			orderByComparator);
	}

	/**
	* Returns the last comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public static CommentRegistration fetchByPROJECT_ID_STATUS_Last(
		long PROJECT_ID, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_STATUS_Last(PROJECT_ID, STATUS,
			orderByComparator);
	}

	/**
	* Returns the comment registrations before and after the current comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_COMMENT_ID the primary key of the current comment registration
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment registration
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public static CommentRegistration[] findByPROJECT_ID_STATUS_PrevAndNext(
		long PROJECT_COMMENT_ID, long PROJECT_ID, int STATUS,
		OrderByComparator<CommentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_STATUS_PrevAndNext(PROJECT_COMMENT_ID,
			PROJECT_ID, STATUS, orderByComparator);
	}

	/**
	* Removes all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	*/
	public static void removeByPROJECT_ID_STATUS(long PROJECT_ID, int STATUS) {
		getPersistence().removeByPROJECT_ID_STATUS(PROJECT_ID, STATUS);
	}

	/**
	* Returns the number of comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @return the number of matching comment registrations
	*/
	public static int countByPROJECT_ID_STATUS(long PROJECT_ID, int STATUS) {
		return getPersistence().countByPROJECT_ID_STATUS(PROJECT_ID, STATUS);
	}

	/**
	* Caches the comment registration in the entity cache if it is enabled.
	*
	* @param commentRegistration the comment registration
	*/
	public static void cacheResult(CommentRegistration commentRegistration) {
		getPersistence().cacheResult(commentRegistration);
	}

	/**
	* Caches the comment registrations in the entity cache if it is enabled.
	*
	* @param commentRegistrations the comment registrations
	*/
	public static void cacheResult(
		List<CommentRegistration> commentRegistrations) {
		getPersistence().cacheResult(commentRegistrations);
	}

	/**
	* Creates a new comment registration with the primary key. Does not add the comment registration to the database.
	*
	* @param PROJECT_COMMENT_ID the primary key for the new comment registration
	* @return the new comment registration
	*/
	public static CommentRegistration create(long PROJECT_COMMENT_ID) {
		return getPersistence().create(PROJECT_COMMENT_ID);
	}

	/**
	* Removes the comment registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_COMMENT_ID the primary key of the comment registration
	* @return the comment registration that was removed
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public static CommentRegistration remove(long PROJECT_COMMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence().remove(PROJECT_COMMENT_ID);
	}

	public static CommentRegistration updateImpl(
		CommentRegistration commentRegistration) {
		return getPersistence().updateImpl(commentRegistration);
	}

	/**
	* Returns the comment registration with the primary key or throws a {@link NoSuchCommentRegistrationException} if it could not be found.
	*
	* @param PROJECT_COMMENT_ID the primary key of the comment registration
	* @return the comment registration
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public static CommentRegistration findByPrimaryKey(long PROJECT_COMMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchCommentRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_COMMENT_ID);
	}

	/**
	* Returns the comment registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_COMMENT_ID the primary key of the comment registration
	* @return the comment registration, or <code>null</code> if a comment registration with the primary key could not be found
	*/
	public static CommentRegistration fetchByPrimaryKey(long PROJECT_COMMENT_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_COMMENT_ID);
	}

	public static java.util.Map<java.io.Serializable, CommentRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the comment registrations.
	*
	* @return the comment registrations
	*/
	public static List<CommentRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the comment registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @return the range of comment registrations
	*/
	public static List<CommentRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the comment registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of comment registrations
	*/
	public static List<CommentRegistration> findAll(int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the comment registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CommentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of comment registrations
	* @param end the upper bound of the range of comment registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of comment registrations
	*/
	public static List<CommentRegistration> findAll(int start, int end,
		OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the comment registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of comment registrations.
	*
	* @return the number of comment registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CommentRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CommentRegistrationPersistence, CommentRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CommentRegistrationPersistence.class);

		ServiceTracker<CommentRegistrationPersistence, CommentRegistrationPersistence> serviceTracker =
			new ServiceTracker<CommentRegistrationPersistence, CommentRegistrationPersistence>(bundle.getBundleContext(),
				CommentRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}