package tn.movom.app.infra.model;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageDetail<T>(List<T> content,
							Integer pageNumber,
							Integer pageSize,
							Long totalElements,
							Integer totalPages,
							Boolean first,
							Boolean last) {
	
	public static <T> PageDetail<T> from(Page<T> page) {
		return new PageDetail<>(
				page.getContent(),
				page.getNumber(),
				page.getSize(),
				page.getTotalElements(),
				page.getTotalPages(),
				page.isFirst(),
				page.isLast());
	}
	
}



