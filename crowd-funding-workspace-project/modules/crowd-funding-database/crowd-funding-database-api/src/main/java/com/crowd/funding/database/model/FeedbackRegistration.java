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
 * The extended model interface for the FeedbackRegistration service. Represents a row in the &quot;cf_project_feedback_details&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackRegistrationModel
 * @see com.crowd.funding.database.model.impl.FeedbackRegistrationImpl
 * @see com.crowd.funding.database.model.impl.FeedbackRegistrationModelImpl
 * @generated
 */
@ImplementationClassName("com.crowd.funding.database.model.impl.FeedbackRegistrationImpl")
@ProviderType
public interface FeedbackRegistration extends FeedbackRegistrationModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.crowd.funding.database.model.impl.FeedbackRegistrationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FeedbackRegistration, Long> PROJECT_FEEDBACK_ID_ACCESSOR =
		new Accessor<FeedbackRegistration, Long>() {
			@Override
			public Long get(FeedbackRegistration feedbackRegistration) {
				return feedbackRegistration.getPROJECT_FEEDBACK_ID();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FeedbackRegistration> getTypeClass() {
				return FeedbackRegistration.class;
			}
		};
}