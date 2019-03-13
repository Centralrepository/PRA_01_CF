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

import com.crowd.funding.database.model.ImageRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the image registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.ImageRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.ImageRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class ImageRegistrationUtil {
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
	public static void clearCache(ImageRegistration imageRegistration) {
		getPersistence().clearCache(imageRegistration);
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
	public static List<ImageRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ImageRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ImageRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ImageRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ImageRegistration update(ImageRegistration imageRegistration) {
		return getPersistence().update(imageRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ImageRegistration update(
		ImageRegistration imageRegistration, ServiceContext serviceContext) {
		return getPersistence().update(imageRegistration, serviceContext);
	}

	/**
	* Returns all the image registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching image registrations
	*/
	public static List<ImageRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<ImageRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<ImageRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ImageRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<ImageRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ImageRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first image registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public static ImageRegistration findByUuid_First(String uuid,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first image registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public static ImageRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ImageRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last image registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public static ImageRegistration findByUuid_Last(String uuid,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last image registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public static ImageRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ImageRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static ImageRegistration[] findByUuid_PrevAndNext(
		long PROJECT_IMAGE_ID, String uuid,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_IMAGE_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the image registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of image registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching image registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the image registration where PROJECT_IMAGE_ID = &#63; or throws a {@link NoSuchImageRegistrationException} if it could not be found.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @return the matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public static ImageRegistration findByPROJECT_IMAGE_ID(
		long PROJECT_IMAGE_ID)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence().findByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);
	}

	/**
	* Returns the image registration where PROJECT_IMAGE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @return the matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public static ImageRegistration fetchByPROJECT_IMAGE_ID(
		long PROJECT_IMAGE_ID) {
		return getPersistence().fetchByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);
	}

	/**
	* Returns the image registration where PROJECT_IMAGE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public static ImageRegistration fetchByPROJECT_IMAGE_ID(
		long PROJECT_IMAGE_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID, retrieveFromCache);
	}

	/**
	* Removes the image registration where PROJECT_IMAGE_ID = &#63; from the database.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @return the image registration that was removed
	*/
	public static ImageRegistration removeByPROJECT_IMAGE_ID(
		long PROJECT_IMAGE_ID)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence().removeByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);
	}

	/**
	* Returns the number of image registrations where PROJECT_IMAGE_ID = &#63;.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @return the number of matching image registrations
	*/
	public static int countByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID) {
		return getPersistence().countByPROJECT_IMAGE_ID(PROJECT_IMAGE_ID);
	}

	/**
	* Returns all the image registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching image registrations
	*/
	public static List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
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
	public static List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
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
	public static List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<ImageRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
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
	public static List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<ImageRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first image registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public static ImageRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first image registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public static ImageRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last image registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public static ImageRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last image registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public static ImageRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
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
	public static ImageRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_IMAGE_ID, long PROJECT_ID,
		OrderByComparator<ImageRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_IMAGE_ID, PROJECT_ID,
			orderByComparator);
	}

	/**
	* Removes all the image registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of image registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching image registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Caches the image registration in the entity cache if it is enabled.
	*
	* @param imageRegistration the image registration
	*/
	public static void cacheResult(ImageRegistration imageRegistration) {
		getPersistence().cacheResult(imageRegistration);
	}

	/**
	* Caches the image registrations in the entity cache if it is enabled.
	*
	* @param imageRegistrations the image registrations
	*/
	public static void cacheResult(List<ImageRegistration> imageRegistrations) {
		getPersistence().cacheResult(imageRegistrations);
	}

	/**
	* Creates a new image registration with the primary key. Does not add the image registration to the database.
	*
	* @param PROJECT_IMAGE_ID the primary key for the new image registration
	* @return the new image registration
	*/
	public static ImageRegistration create(long PROJECT_IMAGE_ID) {
		return getPersistence().create(PROJECT_IMAGE_ID);
	}

	/**
	* Removes the image registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_IMAGE_ID the primary key of the image registration
	* @return the image registration that was removed
	* @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	*/
	public static ImageRegistration remove(long PROJECT_IMAGE_ID)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence().remove(PROJECT_IMAGE_ID);
	}

	public static ImageRegistration updateImpl(
		ImageRegistration imageRegistration) {
		return getPersistence().updateImpl(imageRegistration);
	}

	/**
	* Returns the image registration with the primary key or throws a {@link NoSuchImageRegistrationException} if it could not be found.
	*
	* @param PROJECT_IMAGE_ID the primary key of the image registration
	* @return the image registration
	* @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	*/
	public static ImageRegistration findByPrimaryKey(long PROJECT_IMAGE_ID)
		throws com.crowd.funding.database.exception.NoSuchImageRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_IMAGE_ID);
	}

	/**
	* Returns the image registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_IMAGE_ID the primary key of the image registration
	* @return the image registration, or <code>null</code> if a image registration with the primary key could not be found
	*/
	public static ImageRegistration fetchByPrimaryKey(long PROJECT_IMAGE_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_IMAGE_ID);
	}

	public static java.util.Map<java.io.Serializable, ImageRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the image registrations.
	*
	* @return the image registrations
	*/
	public static List<ImageRegistration> findAll() {
		return getPersistence().findAll();
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
	public static List<ImageRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ImageRegistration> findAll(int start, int end,
		OrderByComparator<ImageRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ImageRegistration> findAll(int start, int end,
		OrderByComparator<ImageRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the image registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of image registrations.
	*
	* @return the number of image registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ImageRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ImageRegistrationPersistence, ImageRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ImageRegistrationPersistence.class);

		ServiceTracker<ImageRegistrationPersistence, ImageRegistrationPersistence> serviceTracker =
			new ServiceTracker<ImageRegistrationPersistence, ImageRegistrationPersistence>(bundle.getBundleContext(),
				ImageRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}