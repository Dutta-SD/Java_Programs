package edu.sandip.blog_app_apis.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public final int MAX_POST_LENGTH = 100;
    public final int MAX_POST_CONSTANT_LENGTH = 1000;
    public final Integer DEFAULT_PAGE_NUMBER = 0;
    public final Integer DEFAULT_PAGE_SIZE = 5;
    public final String ALL_POSTS_DEFAULT_SORT_COLUMN = "postId";
    public final String CATEGORY_DEFAULT_SORT_COLUMN = "categoryId";
    public final String KEYWORD = "keyword";
    public final String RESOURCE_DELETED_SUCCESSFULLY = "Resource Deleted Successfully";
    public final String POST_TITLE_COLUMN = "title";
    public final int CATEGORY_NAME_MAX_LIMIT = 100;
    public final int CATEGORY_DESCRIPTION_MAX_LIMIT = 100;
    public final int USERNAME_MIN_LIMIT = 4;
    public final String USER_NAME_INVALID_MESSAGE = "userName Must be minimum 4 characters";
    public final String EMAIL_INVALID_MESSAGE = "Your Email is Invalid.. Please check it";
    public final String PASSWORD_INVALID_MESSAGE = "password must be min 3 characters and maximum of 10 chars";
    public final int PASSWORD_MIN_LIMIT = 3;
    public final int PASSWORD_MAX_LIMIT = 10;
    public final String CATEGORIES_TABLE_NAME = "categories";
    public final String CATEGORY_ID = "id";
    public final String CATEGORY_NAME = "title";
    public final String CATEGORY_DESCRIPTION = "description";
    public final int CATEGORY_NAME_MAX_LENGTH = 100;
    public final int CATEGORY_DESCRIPTION_MAX_LENGTH = 100;
    public final String CATEGORY_TO_POST_MAPPED_COLUMN = "category";
    public final String POSTS_TABLE_NAME = "posts";
    public final String POST_TITLE_NAME = "post_title";
    public final String POST_TO_CATEGORY_JOIN_COLUMN = "category_id";
    public final String USERS_TABLE_NAME = "users";
    public final String USER_ID_COL = "id";
    public final String USER_NAME_COLUMN_NAME = "user_name";
    public final int USER_NAME_MAX_LENGTH = 100;
    public final String USER_TO_POSTS_MAPPED_COLUMN = "user";

    public final String IMAGE_UPLOAD_FOLDER = "images";
    public final String IMAGE_UPLOADED_SUCCESSFULLY_MESSAGE = "Image Uploaded Successfully";
}
