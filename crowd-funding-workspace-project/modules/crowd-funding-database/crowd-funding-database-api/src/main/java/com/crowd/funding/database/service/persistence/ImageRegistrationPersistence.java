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

import com.crowd.funding.database.exception.NoSuchImageRegistrationException;
import com.crowd.funding.database.model.ImageRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the image registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.ImageRegistrationPersistenceImpl
 * @see ImageRegistrationUtil
 * @generated
 */
@ProviderType
public interface ImageRegistrationPersistence extends BasePersistence<ImageRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImageRegistrationUtil} to access the image registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the image registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching image registrations
	*/
	public java.util.List<ImageRegistration> findByUuid(String uuid);

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
	public java.util.List<ImageRegistration> findByUuid(String uuid, int start,
		int end);

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
	public java.util.List<ImageRegistration> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator);

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
	public java.util.List<ImageRegistration> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first image registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public ImageRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException;

	/**
	* Returns the first image registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public ImageRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator);

	/**
	* Returns the last image registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public ImageRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException;

	/**
	* Returns the last image registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public ImageRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator);

	/**
	* Returns the image registrations before and after the current image registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_IMAGE_ID the primary key of the current image registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next image registration
	* @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	*/
	public ImageRegistration[] findByUuid_PrevAndNext(long PROJECT_IMAGE_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException;

	/**
	* Removes all the image registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of image registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching image registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the image registration where PROJECT_IMAGE_ID = &#63; or throws a {@link NoSuchImageRegistrationException} if it could not be found.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @return the matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public ImageRegistration findByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID)
		throws NoSuchImageRegistrationException;

	/**
	* Returns the image registration where PROJECT_IMAGE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @return the matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public ImageRegistration fetchByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID);

	/**
	* Returns the image registration where PROJECT_IMAGE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public ImageRegistration fetchByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID,
		boolean retrieveFromCache);

	/**
	* Removes the image registration where PROJECT_IMAGE_ID = &#63; from the database.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @return the image registration that was removed
	*/
	public ImageRegistration removeByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID)
		throws NoSuchImageRegistrationException;

	/**
	* Returns the number of image registrations where PROJECT_IMAGE_ID = &#63;.
	*
	* @param PROJECT_IMAGE_ID the project_image_id
	* @return the number of matching image registrations
	*/
	public int countByPROJECT_IMAGE_ID(long PROJECT_IMAGE_ID);

	/**
	* Returns all the image registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching image registrations
	*/
	public java.util.List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID);

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
	public java.util.List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end);

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
	public java.util.List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator);

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
	public java.util.List<ImageRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first image registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public ImageRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException;

	/**
	* Returns the first image registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public ImageRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator);

	/**
	* Returns the last image registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching image registration
	* @throws NoSuchImageRegistrationException if a matching image registration could not be found
	*/
	public ImageRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException;

	/**
	* Returns the last image registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching image registration, or <code>null</code> if a matching image registration could not be found
	*/
	public ImageRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator);

	/**
	* Returns the image registrations before and after the current image registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_IMAGE_ID the primary key of the current image registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next image registration
	* @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	*/
	public ImageRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_IMAGE_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator)
		throws NoSuchImageRegistrationException;

	/**
	* Removes all the image registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of image registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching image registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Caches the image registration in the entity cache if it is enabled.
	*
	* @param imageRegistration the image registration
	*/
	public void cacheResult(ImageRegistration imageRegistration);

	/**
	* Caches the image registrations in the entity cache if it is enabled.
	*
	* @param imageRegistrations the image registrations
	*/
	public void cacheResult(
		java.util.List<ImageRegistration> imageRegistrations);

	/**
	* Creates a new image registration with the primary key. Does not add the image registration to the database.
	*
	* @param PROJECT_IMAGE_ID the primary key for the new image registration
	* @return the new image registration
	*/
	public ImageRegistration create(long PROJECT_IMAGE_ID);

	/**
	* Removes the image registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_IMAGE_ID the primary key of the image registration
	* @return the image registration that was removed
	* @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	*/
	public ImageRegistration remove(long PROJECT_IMAGE_ID)
		throws NoSuchImageRegistrationException;

	public ImageRegistration updateImpl(ImageRegistration imageRegistration);

	/**
	* Returns the image registration with the primary key or throws a {@link NoSuchImageRegistrationException} if it could not be found.
	*
	* @param PROJECT_IMAGE_ID the primary key of the image registration
	* @return the image registration
	* @throws NoSuchImageRegistrationException if a image registration with the primary key could not be found
	*/
	public ImageRegistration findByPrimaryKey(long PROJECT_IMAGE_ID)
		throws NoSuchImageRegistrationException;

	/**
	* Returns the image registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_IMAGE_ID the primary key of the image registration
	* @return the image registration, or <code>null</code> if a image registration with the primary key could not be found
	*/
	public ImageRegistration fetchByPrimaryKey(long PROJECT_IMAGE_ID);

	@Override
	public java.util.Map<java.io.Serializable, ImageRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the image registrations.
	*
	* @return the image registrations
	*/
	public java.util.List<ImageRegistration> findAll();

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
	public java.util.List<ImageRegistration> findAll(int start, int end);

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
	public java.util.List<ImageRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator);

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
	public java.util.List<ImageRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ImageRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the image registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of image registrations.
	*
	* @return the number of image registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}