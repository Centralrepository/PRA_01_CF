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

package com.crowd.funding.database.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the NewsLetterRegistration service. Represents a row in the &quot;cf_news_letter_details&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterRegistrationModel
 * @see com.crowd.funding.database.model.impl.NewsLetterRegistrationImpl
 * @see com.crowd.funding.database.model.impl.NewsLetterRegistrationModelImpl
 * @generated
 */
@ImplementationClassName("com.crowd.funding.database.model.impl.NewsLetterRegistrationImpl")
@ProviderType
public interface NewsLetterRegistration extends NewsLetterRegistrationModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.crowd.funding.database.model.impl.NewsLetterRegistrationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<NewsLetterRegistration, Long> NEWS_LETTER_ID_ACCESSOR =
		new Accessor<NewsLetterRegistration, Long>() {
			@Override
			public Long get(NewsLetterRegistration newsLetterRegistration) {
				return newsLetterRegistration.getNEWS_LETTER_ID();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<NewsLetterRegistration> getTypeClass() {
				return NewsLetterRegistration.class;
			}
		};
}