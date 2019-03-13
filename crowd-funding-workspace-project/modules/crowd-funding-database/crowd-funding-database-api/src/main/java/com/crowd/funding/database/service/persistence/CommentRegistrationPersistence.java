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

import com.crowd.funding.database.exception.NoSuchCommentRegistrationException;
import com.crowd.funding.database.model.CommentRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the comment registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.CommentRegistrationPersistenceImpl
 * @see CommentRegistrationUtil
 * @generated
 */
@ProviderType
public interface CommentRegistrationPersistence extends BasePersistence<CommentRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommentRegistrationUtil} to access the comment registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the comment registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching comment registrations
	*/
	public java.util.List<CommentRegistration> findByUuid(String uuid);

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
	public java.util.List<CommentRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<CommentRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

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
	public java.util.List<CommentRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first comment registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public CommentRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the first comment registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

	/**
	* Returns the last comment registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public CommentRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the last comment registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

	/**
	* Returns the comment registrations before and after the current comment registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_COMMENT_ID the primary key of the current comment registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment registration
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public CommentRegistration[] findByUuid_PrevAndNext(
		long PROJECT_COMMENT_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Removes all the comment registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of comment registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching comment registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the comment registration where PROJECT_COMMENT_ID = &#63; or throws a {@link NoSuchCommentRegistrationException} if it could not be found.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @return the matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public CommentRegistration findByPROJECT_COMMENT_ID(long PROJECT_COMMENT_ID)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the comment registration where PROJECT_COMMENT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @return the matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID);

	/**
	* Returns the comment registration where PROJECT_COMMENT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID, boolean retrieveFromCache);

	/**
	* Removes the comment registration where PROJECT_COMMENT_ID = &#63; from the database.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @return the comment registration that was removed
	*/
	public CommentRegistration removeByPROJECT_COMMENT_ID(
		long PROJECT_COMMENT_ID) throws NoSuchCommentRegistrationException;

	/**
	* Returns the number of comment registrations where PROJECT_COMMENT_ID = &#63;.
	*
	* @param PROJECT_COMMENT_ID the project_comment_id
	* @return the number of matching comment registrations
	*/
	public int countByPROJECT_COMMENT_ID(long PROJECT_COMMENT_ID);

	/**
	* Returns all the comment registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching comment registrations
	*/
	public java.util.List<CommentRegistration> findByPROJECT_ID(long PROJECT_ID);

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
	public java.util.List<CommentRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

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
	public java.util.List<CommentRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

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
	public java.util.List<CommentRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public CommentRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the first comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

	/**
	* Returns the last comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public CommentRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the last comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

	/**
	* Returns the comment registrations before and after the current comment registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_COMMENT_ID the primary key of the current comment registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment registration
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public CommentRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_COMMENT_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Removes all the comment registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of comment registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching comment registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns all the comment registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching comment registrations
	*/
	public java.util.List<CommentRegistration> findBySTATUS(int STATUS);

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
	public java.util.List<CommentRegistration> findBySTATUS(int STATUS,
		int start, int end);

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
	public java.util.List<CommentRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

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
	public java.util.List<CommentRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first comment registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public CommentRegistration findBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the first comment registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

	/**
	* Returns the last comment registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public CommentRegistration findBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the last comment registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

	/**
	* Returns the comment registrations before and after the current comment registration in the ordered set where STATUS = &#63;.
	*
	* @param PROJECT_COMMENT_ID the primary key of the current comment registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next comment registration
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public CommentRegistration[] findBySTATUS_PrevAndNext(
		long PROJECT_COMMENT_ID, int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Removes all the comment registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public void removeBySTATUS(int STATUS);

	/**
	* Returns the number of comment registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching comment registrations
	*/
	public int countBySTATUS(int STATUS);

	/**
	* Returns all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @return the matching comment registrations
	*/
	public java.util.List<CommentRegistration> findByPROJECT_ID_STATUS(
		long PROJECT_ID, int STATUS);

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
	public java.util.List<CommentRegistration> findByPROJECT_ID_STATUS(
		long PROJECT_ID, int STATUS, int start, int end);

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
	public java.util.List<CommentRegistration> findByPROJECT_ID_STATUS(
		long PROJECT_ID, int STATUS, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

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
	public java.util.List<CommentRegistration> findByPROJECT_ID_STATUS(
		long PROJECT_ID, int STATUS, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public CommentRegistration findByPROJECT_ID_STATUS_First(long PROJECT_ID,
		int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the first comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchByPROJECT_ID_STATUS_First(long PROJECT_ID,
		int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

	/**
	* Returns the last comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration
	* @throws NoSuchCommentRegistrationException if a matching comment registration could not be found
	*/
	public CommentRegistration findByPROJECT_ID_STATUS_Last(long PROJECT_ID,
		int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the last comment registration in the ordered set where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching comment registration, or <code>null</code> if a matching comment registration could not be found
	*/
	public CommentRegistration fetchByPROJECT_ID_STATUS_Last(long PROJECT_ID,
		int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

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
	public CommentRegistration[] findByPROJECT_ID_STATUS_PrevAndNext(
		long PROJECT_COMMENT_ID, long PROJECT_ID, int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator)
		throws NoSuchCommentRegistrationException;

	/**
	* Removes all the comment registrations where PROJECT_ID = &#63; and STATUS = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	*/
	public void removeByPROJECT_ID_STATUS(long PROJECT_ID, int STATUS);

	/**
	* Returns the number of comment registrations where PROJECT_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param STATUS the status
	* @return the number of matching comment registrations
	*/
	public int countByPROJECT_ID_STATUS(long PROJECT_ID, int STATUS);

	/**
	* Caches the comment registration in the entity cache if it is enabled.
	*
	* @param commentRegistration the comment registration
	*/
	public void cacheResult(CommentRegistration commentRegistration);

	/**
	* Caches the comment registrations in the entity cache if it is enabled.
	*
	* @param commentRegistrations the comment registrations
	*/
	public void cacheResult(
		java.util.List<CommentRegistration> commentRegistrations);

	/**
	* Creates a new comment registration with the primary key. Does not add the comment registration to the database.
	*
	* @param PROJECT_COMMENT_ID the primary key for the new comment registration
	* @return the new comment registration
	*/
	public CommentRegistration create(long PROJECT_COMMENT_ID);

	/**
	* Removes the comment registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_COMMENT_ID the primary key of the comment registration
	* @return the comment registration that was removed
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public CommentRegistration remove(long PROJECT_COMMENT_ID)
		throws NoSuchCommentRegistrationException;

	public CommentRegistration updateImpl(
		CommentRegistration commentRegistration);

	/**
	* Returns the comment registration with the primary key or throws a {@link NoSuchCommentRegistrationException} if it could not be found.
	*
	* @param PROJECT_COMMENT_ID the primary key of the comment registration
	* @return the comment registration
	* @throws NoSuchCommentRegistrationException if a comment registration with the primary key could not be found
	*/
	public CommentRegistration findByPrimaryKey(long PROJECT_COMMENT_ID)
		throws NoSuchCommentRegistrationException;

	/**
	* Returns the comment registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_COMMENT_ID the primary key of the comment registration
	* @return the comment registration, or <code>null</code> if a comment registration with the primary key could not be found
	*/
	public CommentRegistration fetchByPrimaryKey(long PROJECT_COMMENT_ID);

	@Override
	public java.util.Map<java.io.Serializable, CommentRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the comment registrations.
	*
	* @return the comment registrations
	*/
	public java.util.List<CommentRegistration> findAll();

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
	public java.util.List<CommentRegistration> findAll(int start, int end);

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
	public java.util.List<CommentRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator);

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
	public java.util.List<CommentRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CommentRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the comment registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of comment registrations.
	*
	* @return the number of comment registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}