package tn.movom.app.movom.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum ContinentName {
	
	EUROPE("Europe"),
	AMERICA("America"),
	AFRIFA("Africa"),
	ASIA("Asia"),
	AUSTRALIA("Australia");
	
	private final String name;
	
	@JsonValue
	public String getName() {
		return this.name;
	}
	
	public static ContinentName findByName(String name) {
		return Arrays.stream(ContinentName.values())
				.filter(continent -> continent.getName().equalsIgnoreCase(name))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("No such continent found with name: " + name));
	}
	
}



