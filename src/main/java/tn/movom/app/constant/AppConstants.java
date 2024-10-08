package tn.movom.app.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppConstants {
	
	public static final String LOCAL_DATE_FORMAT = "dd-MM-yyyy";
	public static final String LOCAL_DATE_TIME_FORMAT = "dd-MM-yyyy_HH:mm:ss";
	
	public static final String DEFAULT_PAGING_OFFSET = "0";
	public static final String DEFAULT_PAGING_SIZE = "20";
	public static final String DEFAULT_PAGING_SORT_DIRECTION = "DESC";
	public static final String DEFAULT_PAGING_SORT_BY = "createdAt";
	
	public static final String DB_STRING_SEPARATOR = ",";
	
}



