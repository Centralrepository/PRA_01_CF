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

import com.crowd.funding.database.model.DocumentRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the document registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.DocumentRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.DocumentRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class DocumentRegistrationUtil {
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
	public static void clearCache(DocumentRegistration documentRegistration) {
		getPersistence().clearCache(documentRegistration);
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
	public static List<DocumentRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentRegistration update(
		DocumentRegistration documentRegistration) {
		return getPersistence().update(documentRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentRegistration update(
		DocumentRegistration documentRegistration, ServiceContext serviceContext) {
		return getPersistence().update(documentRegistration, serviceContext);
	}

	/**
	* Returns all the document registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching document registrations
	*/
	public static List<DocumentRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<DocumentRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<DocumentRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<DocumentRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<DocumentRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<DocumentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first document registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public static DocumentRegistration findByUuid_First(String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first document registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public static DocumentRegistration fetchByUuid_First(String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last document registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public static DocumentRegistration findByUuid_Last(String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last document registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public static DocumentRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the document registrations before and after the current document registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the current document registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document registration
	* @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	*/
	public static DocumentRegistration[] findByUuid_PrevAndNext(
		long PROJECT_DOCUMENT_ID, String uuid,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_DOCUMENT_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the document registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of document registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching document registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the document registration where PROJECT_DOCUMENT_ID = &#63; or throws a {@link NoSuchDocumentRegistrationException} if it could not be found.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @return the matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public static DocumentRegistration findByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence().findByPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);
	}

	/**
	* Returns the document registration where PROJECT_DOCUMENT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @return the matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public static DocumentRegistration fetchByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID) {
		return getPersistence().fetchByPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);
	}

	/**
	* Returns the document registration where PROJECT_DOCUMENT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public static DocumentRegistration fetchByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID,
			retrieveFromCache);
	}

	/**
	* Removes the document registration where PROJECT_DOCUMENT_ID = &#63; from the database.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @return the document registration that was removed
	*/
	public static DocumentRegistration removeByPROJECT_DOCUMENT_ID(
		long PROJECT_DOCUMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence().removeByPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);
	}

	/**
	* Returns the number of document registrations where PROJECT_DOCUMENT_ID = &#63;.
	*
	* @param PROJECT_DOCUMENT_ID the project_document_id
	* @return the number of matching document registrations
	*/
	public static int countByPROJECT_DOCUMENT_ID(long PROJECT_DOCUMENT_ID) {
		return getPersistence().countByPROJECT_DOCUMENT_ID(PROJECT_DOCUMENT_ID);
	}

	/**
	* Returns all the document registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching document registrations
	*/
	public static List<DocumentRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

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
	public static List<DocumentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

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
	public static List<DocumentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

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
	public static List<DocumentRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<DocumentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public static DocumentRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public static DocumentRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document registration
	* @throws NoSuchDocumentRegistrationException if a matching document registration could not be found
	*/
	public static DocumentRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document registration, or <code>null</code> if a matching document registration could not be found
	*/
	public static DocumentRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the document registrations before and after the current document registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the current document registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document registration
	* @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	*/
	public static DocumentRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_DOCUMENT_ID, long PROJECT_ID,
		OrderByComparator<DocumentRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_DOCUMENT_ID,
			PROJECT_ID, orderByComparator);
	}

	/**
	* Removes all the document registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of document registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching document registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Caches the document registration in the entity cache if it is enabled.
	*
	* @param documentRegistration the document registration
	*/
	public static void cacheResult(DocumentRegistration documentRegistration) {
		getPersistence().cacheResult(documentRegistration);
	}

	/**
	* Caches the document registrations in the entity cache if it is enabled.
	*
	* @param documentRegistrations the document registrations
	*/
	public static void cacheResult(
		List<DocumentRegistration> documentRegistrations) {
		getPersistence().cacheResult(documentRegistrations);
	}

	/**
	* Creates a new document registration with the primary key. Does not add the document registration to the database.
	*
	* @param PROJECT_DOCUMENT_ID the primary key for the new document registration
	* @return the new document registration
	*/
	public static DocumentRegistration create(long PROJECT_DOCUMENT_ID) {
		return getPersistence().create(PROJECT_DOCUMENT_ID);
	}

	/**
	* Removes the document registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the document registration
	* @return the document registration that was removed
	* @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	*/
	public static DocumentRegistration remove(long PROJECT_DOCUMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence().remove(PROJECT_DOCUMENT_ID);
	}

	public static DocumentRegistration updateImpl(
		DocumentRegistration documentRegistration) {
		return getPersistence().updateImpl(documentRegistration);
	}

	/**
	* Returns the document registration with the primary key or throws a {@link NoSuchDocumentRegistrationException} if it could not be found.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the document registration
	* @return the document registration
	* @throws NoSuchDocumentRegistrationException if a document registration with the primary key could not be found
	*/
	public static DocumentRegistration findByPrimaryKey(
		long PROJECT_DOCUMENT_ID)
		throws com.crowd.funding.database.exception.NoSuchDocumentRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_DOCUMENT_ID);
	}

	/**
	* Returns the document registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_DOCUMENT_ID the primary key of the document registration
	* @return the document registration, or <code>null</code> if a document registration with the primary key could not be found
	*/
	public static DocumentRegistration fetchByPrimaryKey(
		long PROJECT_DOCUMENT_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_DOCUMENT_ID);
	}

	public static java.util.Map<java.io.Serializable, DocumentRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the document registrations.
	*
	* @return the document registrations
	*/
	public static List<DocumentRegistration> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<DocumentRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<DocumentRegistration> findAll(int start, int end,
		OrderByComparator<DocumentRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<DocumentRegistration> findAll(int start, int end,
		OrderByComparator<DocumentRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the document registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of document registrations.
	*
	* @return the number of document registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DocumentRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DocumentRegistrationPersistence, DocumentRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DocumentRegistrationPersistence.class);

		ServiceTracker<DocumentRegistrationPersistence, DocumentRegistrationPersistence> serviceTracker =
			new ServiceTracker<DocumentRegistrationPersistence, DocumentRegistrationPersistence>(bundle.getBundleContext(),
				DocumentRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}