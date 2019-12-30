package com.imnu.shop.service;

import java.util.List;

import com.imnu.shop.pojo.City;

public interface CityService {
	List<City> findCitiesByPId(int pid);

}
