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

import com.crowd.funding.database.exception.NoSuchDocumentRegistrationException;
import com.crowd.funding.database.model.DocumentRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the document registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.DocumentRegistrationPersistenceImpl
 * @see DocumentRegistrationUtil
 * @generated
 */
@ProviderType
public interface DocumentRegistrationPersistence extends BasePersistence<DocumentRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentRegistrationUtil} to access the document registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the document registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching document registrations
	*/
	public java.util.List<DocumentRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the document registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @return the range of matching document registrations
	*/
	public java.util.List<DocumentRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the document registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching document registrations
	*/
	public java.util.List<DocumentRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the document registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching document registrations
	*/
	public java.util.List<DocumentRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first document registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public DocumentRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException;

	/**
	* Returns the first document registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public DocumentRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator);

	/**
	* Returns the last document registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public DocumentRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException;

	/**
	* Returns the last document registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public DocumentRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator);

	/**
	* Returns the document registrations before and after the current document registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the current document registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document registration
	* @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	*/
	public DocumentRegistration[] findByUuid_PrevAndNext(
		long PROJECT_DOCUMENT_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException;

	/**
	* Removes all the document registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of document registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching document registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the document registration where PROJECT_DOCUMENT_ID = &#63; or throws a {@link NoSuchDocumentRegistrationException} if it could not be found.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @return the matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public DocumentRegistration findByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID) throws NoSuchDocumentRegistrationException;

	/**
	* Returns the document registration where PROJECT_DOCUMENT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @return the matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public DocumentRegistration fetchByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID);

	/**
	* Returns the document registration where PROJECT_DOCUMENT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public DocumentRegistration fetchByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID, boolean retrieveFromCache);

	/**
	* Removes the document registration where PROJECT_DOCUMENT_ID = &#63; from the database.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @return the document registration that was removed
	*/
	public DocumentRegistration removeByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID) throws NoSuchDocumentRegistrationException;

	/**
	* Returns the number of document registrations where PROJECT_DOCUMENT_ID = &#63;.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @return the number of matching document registrations
	*/
	public int countByPROJECT_DOCUMENT_ID(long PROJECT_DOCUMENT_ID);

	/**
	* Returns all the document registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching document registrations
	*/
	public java.util.List<DocumentRegistration> findByPROJECT_ID(
		long PROJECT_ID);

	/**
	* Returns a range of all the document registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @return the range of matching document registrations
	*/
	public java.util.List<DocumentRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

	/**
	* Returns an ordered range of all the document registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching document registrations
	*/
	public java.util.List<DocumentRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the document registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching document registrations
	*/
	public java.util.List<DocumentRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public DocumentRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException;

	/**
	* Returns the first document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public DocumentRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator);

	/**
	* Returns the last document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public DocumentRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException;

	/**
	* Returns the last document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public DocumentRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator);

	/**
	* Returns the document registrations before and after the current document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the current document registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document registration
	* @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	*/
	public DocumentRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_DOCUMENT_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator)
		throws NoSuchDocumentRegistrationException;

	/**
	* Removes all the document registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of document registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching document registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Caches the document registration in the entity cache if it is enabled.
	*
	* @param documentRegistration the document registration
	*/
	public void cacheResult(DocumentRegistration documentRegistration);

	/**
	* Caches the document registrations in the entity cache if it is enabled.
	*
	* @param documentRegistrations the document registrations
	*/
	public void cacheResult(
		java.util.List<DocumentRegistration> documentRegistrations);

	/**
	* Creates a new document registration with the primary key. Does not add the document registration to the database.
	*
	* @param PROJECT_DOCUMENT_ID the primary key for the new document registration
	* @return the new document registration
	*/
	public DocumentRegistration create(long PROJECT_DOCUMENT_ID);

	/**
	* Removes the document registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the document registration
	* @return the document registration that was removed
	* @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	*/
	public DocumentRegistration remove(long PROJECT_DOCUMENT_ID)
		throws NoSuchDocumentRegistrationException;

	public DocumentRegistration updateImpl(
		DocumentRegistration documentRegistration);

	/**
	* Returns the document registration with the primary key or throws a {@link NoSuchDocumentRegistrationException} if it could not be found.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the document registration
	* @return the document registration
	* @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	*/
	public DocumentRegistration findByPrimaryKey(long PROJECT_DOCUMENT_ID)
		throws NoSuchDocumentRegistrationException;

	/**
	* Returns the document registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the document registration
	* @return the document registration, or <code>null</code> if a document registration with the primary key could not be found
	*/
	public DocumentRegistration fetchByPrimaryKey(long PROJECT_DOCUMENT_ID);

	@Override
	public java.util.Map<java.io.Serializable, DocumentRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the document registrations.
	*
	* @return the document registrations
	*/
	public java.util.List<DocumentRegistration> findAll();

	/**
	* Returns a range of all the document registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @return the range of document registrations
	*/
	public java.util.List<DocumentRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the document registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of document registrations
	*/
	public java.util.List<DocumentRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the document registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DocumentRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document registrations
	* @param end the upper bound of the range of document registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of document registrations
	*/
	public java.util.List<DocumentRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the document registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of document registrations.
	*
	* @return the number of document registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}