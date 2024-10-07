package tn.movom.app.infra.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.infra.exception.PaginationException;

import java.util.regex.Pattern;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
public final class Pagination {
	
	public static final String SORT_BY_DELIMITER = ",";
	
	private final Integer offset;
	private final Integer size;
	private final Sort.Direction sortDirection;
	private final String[] sortBy;
	
	public static Pagination of(final String offsetParam) {
		return of(offsetParam, null, null, null);
	}
	
	public static Pagination of(final String offsetParam, final String sizeParam) {
		return of(offsetParam, sizeParam, null, null);
	}
	
	public static Pagination of(final String offsetParam, final String sizeParam, final String sortDirectionParam) {
		return of(offsetParam, sizeParam, sortDirectionParam, null);
	}
	
	public static Pagination of(String offsetParam,
								String sizeParam,
								String sortDirectionParam,
								String sortByParam) {
		offsetParam = requireNonBlankOrElse(offsetParam, AppConstants.DEFAULT_PAGING_OFFSET);
		sizeParam = requireNonBlankOrElse(sizeParam, AppConstants.DEFAULT_PAGING_SIZE);
		sortDirectionParam = requireNonBlankOrElse(sortDirectionParam, AppConstants.DEFAULT_PAGING_SORT_DIRECTION);
		sortByParam = requireNonBlankOrElse(sortByParam, AppConstants.DEFAULT_PAGING_SORT_BY);
		return ofParams(offsetParam, sizeParam, sortDirectionParam, sortByParam);
	}
	
	private static String requireNonBlankOrElse(final String target, final String defaultValue) {
		return org.apache.commons.lang3.StringUtils.isNotBlank(target)
				? target
				: defaultValue;
	}
	
	private static Pagination ofParams(final String offsetParam,
											 final String sizeParam,
											 final String sortDirectionParam,
											 final String sortByParam) {
		try {
			final int offset = Integer.parseInt(offsetParam);
			if (offset < 0)
				throw new PaginationException("Page offset must not be negatif");
			
			final int size = Integer.parseInt(sizeParam);
			if (size < 0)
				throw new PaginationException("Page size must not be negatif");
			
			return Pagination.builder()
					.offset(offset)
					.size(size)
					.sortDirection(
							AppConstants.DEFAULT_PAGING_SORT_DIRECTION.equalsIgnoreCase(sortDirectionParam)
									? Sort.Direction.DESC
									: Sort.Direction.ASC)
					.sortBy(
							sortByParam.lines()
									.map(StringUtils::trimAllWhitespace)
									.flatMap(Pattern.compile(SORT_BY_DELIMITER)::splitAsStream)
									.toArray(String[]::new))
					.build();
		}
		catch (NumberFormatException e) {
			throw new PaginationException("Pagination params are invalid");
		}
	}
	
}



