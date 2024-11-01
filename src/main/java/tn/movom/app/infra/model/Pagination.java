package tn.movom.app.infra.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.infra.exception.PaginationException;

import java.util.regex.Pattern;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public final class Pagination {
	
	public static final String SORT_BY_DELIMITER = ",";
	
	private final int offset;
	private final int size;
	private final Sort.Direction sortDirection;
	private final String[] sortBy;
	
	public static Pagination of(String offsetParam) {
		return of(offsetParam, null, null, null);
	}
	
	public static Pagination of(String offsetParam, String sizeParam) {
		return of(offsetParam, sizeParam, null, null);
	}
	
	public static Pagination of(String offsetParam, String sizeParam, String sortDirectionParam) {
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
	
	private static String requireNonBlankOrElse(String target, String defaultValue) {
		return StringUtils.isNotBlank(target)
				? target
				: defaultValue;
	}
	
	private static Pagination ofParams(String offsetParam,
									   String sizeParam,
									   String sortDirectionParam,
									   String sortByParam) {
		if (!isParamNumeric(offsetParam))
			throw new PaginationException("Pagination offset param is not numeric");
		if (!isParamNumeric(sizeParam))
			throw new PaginationException("Pagination size param is not numeric");
		
		int offset = Integer.parseInt(offsetParam);
		if (offset < 0)
			throw new PaginationException("Page offset must not be negatif");
		
		int size = Integer.parseInt(sizeParam);
		if (size < 0)
			throw new PaginationException("Page size must not be negatif");
		
		return new Pagination(
				offset,
				size,
				AppConstants.DEFAULT_PAGING_SORT_DIRECTION.equalsIgnoreCase(sortDirectionParam)
						? Sort.Direction.DESC
						: Sort.Direction.ASC,
				sortByParam.lines()
						.map(org.springframework.util.StringUtils::trimAllWhitespace)
						.flatMap(Pattern.compile(SORT_BY_DELIMITER)::splitAsStream)
						.toArray(String[]::new));
	}
	
	private static boolean isParamNumeric(String param) {
		return StringUtils.isNumeric(param);
	}
	
	public Pageable toPageable() {
		return PageRequest.of(
				this.offset,
				this.size,
				this.sortDirection,
				this.sortBy);
	}
	
}



