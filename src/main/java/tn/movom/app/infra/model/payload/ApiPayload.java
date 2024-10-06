package tn.movom.app.infra.model.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.time.Instant;
import java.util.Objects;

public record ApiPayload<T>(Instant timestamp, ApiStatus status, @JsonInclude(Include.NON_NULL) Integer total, T body) {
	
	public ApiPayload {
		timestamp = Objects.requireNonNullElseGet(timestamp, Instant::now);
	}
	
	public ApiPayload(ApiStatus status, Integer total, T body) {
		this(null, status, total, body);
	}
	
	public static <T> ApiPayload<T> ofSuccess(T body) {
		return new ApiPayload<>(ApiStatus.SUCCESS, null, body);
	}
	
	public static <T> ApiPayload<T> ofSuccess(Integer total, T body) {
		return new ApiPayload<>(ApiStatus.SUCCESS, total, body);
	}
	
	public static <T> ApiPayload<T> ofFailure(T body) {
		return new ApiPayload<>(ApiStatus.FAILURE, null, body);
	}
	
	public static <T> ApiPayload<T> ofFailure(Integer total, T body) {
		return new ApiPayload<>(ApiStatus.FAILURE, total, body);
	}
	
	public enum ApiStatus {
		SUCCESS, FAILURE
	}
	
}



