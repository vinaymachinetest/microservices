package com.study.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterService {

	@GetMapping("/filter_v1")
	public UserFilter Userfilter_V1() {

		return new UserFilter("value1", "value2", "value3");
	}

	@GetMapping("/filter_v2")
	public List<UserFilter> Userfilter_V2() {

		return Arrays.asList(new UserFilter("value1", "value2", "value3"),
				new UserFilter("value11", "value22", "value33"));
	}

	// dynamic filtering
	@GetMapping("/filter_v3")
	public MappingJacksonValue Userfilter_V3() {

		DynamicUserFilter user = new DynamicUserFilter("value1", "value2", "value3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicfilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filters);
		return mapping;
	}

	// dynamic filtering
	@GetMapping("/filter_v4")
	public MappingJacksonValue Userfilter_V4() {

		DynamicUserFilter user = new DynamicUserFilter("value1", "value2", "value3");

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2", "value3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicfilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filters);
		return mapping;
	}
}
