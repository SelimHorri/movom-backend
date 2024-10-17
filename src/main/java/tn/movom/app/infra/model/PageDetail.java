package tn.movom.app.infra.model;

import lombok.NonNull;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public record PageDetail<T>(List<T> content,
							int pageNumber,
							int pageSize,
							long totalElements,
							int totalPages,
							boolean first,
							boolean last) {
	
	public PageDetail {
		content = List.copyOf(Objects.requireNonNullElseGet(content, List::of));
	}
	
	public static <T> PageDetail<T> from(@NonNull Page<T> page) {
		return new PageDetail<>(
				page.getContent(),
				page.getNumber(),
				page.getSize(),
				page.getTotalElements(),
				page.getTotalPages(),
				page.isFirst(),
				page.isLast());
	}
	
	public <R> PageDetail<R> map(Function<T, R> mapper) {
		var elements = this.content.stream()
				.map(mapper)
				.toList();
		return new PageDetail<>(
				elements,
				this.pageNumber,
				this.pageSize,
				this.totalElements,
				this.totalPages,
				this.first,
				this.last);
	}
	
}



