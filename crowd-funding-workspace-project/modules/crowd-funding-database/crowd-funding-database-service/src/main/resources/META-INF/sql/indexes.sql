create index IX_C4C4D47C on cf_acknowledgement_details (PROJECT_ID);
create index IX_C4A60F2D on cf_acknowledgement_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_A26CC9BB on cf_donor_details (MOBILE_NO);
create index IX_FB487341 on cf_donor_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_F4C15618 on cf_fund_otp_details (MOBILE_NO);
create index IX_E4E3B61E on cf_fund_otp_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_8C9E0707 on cf_fund_release_details (PROJECT_ID);
create index IX_C49431C2 on cf_fund_release_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_EBB6E715 on cf_news_letter_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_C1BE5C9 on cf_project_account_details (PROJECT_ID);
create index IX_D332A1C0 on cf_project_account_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_4C30FF0C on cf_project_benificiary_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_6008C061 on cf_project_comment_details (PROJECT_ID, STATUS);
create index IX_982D380C on cf_project_comment_details (STATUS);
create index IX_F372E7CE on cf_project_comment_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_60B950FB on cf_project_document_details (PROJECT_ID);
create index IX_B0677F4E on cf_project_document_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_434C5FE5 on cf_project_feedback_details (PROJECT_ID);
create index IX_9DAD4624 on cf_project_feedback_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_576B0381 on cf_project_follower_details (PROJECT_ID, USER_ID);
create index IX_567304B6 on cf_project_follower_details (USER_ID);
create index IX_3844B6AB on cf_project_follower_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_AA452076 on cf_project_fund_details (DONOR_USER_ID);
create index IX_50DB0D81 on cf_project_fund_details (PROJECT_ID, DONOR_USER_ID);
create index IX_928E5E4 on cf_project_fund_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_32F9D5F7 on cf_project_image_details (PROJECT_ID);
create index IX_60EECCD2 on cf_project_image_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_E120E150 on cf_project_master (STATUS);
create index IX_D45AF855 on cf_project_master (USER_ID);
create index IX_CC83060A on cf_project_master (uuid_[$COLUMN_LENGTH:75$]);

create index IX_C35A41C7 on cf_project_priority_details (PRIORITY);
create index IX_144E8EE1 on cf_project_priority_details (PRIORITY_SEQUANCE);
create index IX_A6C1FCC4 on cf_project_priority_details (PROJECT_ID);
create index IX_F312D9E5 on cf_project_priority_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2CE7C186 on cf_project_question_details (PROJECT_ID);
create index IX_FF31A3E3 on cf_project_question_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B5CE0AA9 on cf_project_update_details (PROJECT_ID);
create index IX_34F0E0 on cf_project_update_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_17FFB8AA on cf_subscription_details (EMAIL[$COLUMN_LENGTH:75$]);
create index IX_9332528 on cf_subscription_details (STATUS);
create index IX_49ACE732 on cf_subscription_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_7BF74F40 on cf_update_requester_details (PROJECT_ID);
create index IX_4B3AE9E9 on cf_update_requester_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2D259174 on cf_user_follow_details (FOLLOWER_USER_ID);
create index IX_52844C2D on cf_user_follow_details (USER_ID);
create index IX_C01F6FE2 on cf_user_follow_details (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2461E4F4 on cf_user_master (uuid_[$COLUMN_LENGTH:75$]);

create index IX_94D69FD2 on cf_user_otp_details (MOBILE_NO);
create index IX_6B46ECD8 on cf_user_otp_details (uuid_[$COLUMN_LENGTH:75$]);