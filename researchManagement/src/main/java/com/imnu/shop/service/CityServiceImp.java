package com.imnu.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.shop.mapper.CityMapper;
import com.imnu.shop.pojo.City;
import com.imnu.shop.pojo.CityExample;

@Service
@Transactional
public class CityServiceImp implements CityService {

	@Autowired
	private CityMapper cityMapper;
	
	public List<City> findCitiesByPId(int pid) {
		CityExample example=new CityExample();
		example.createCriteria().andPidEqualTo(pid);
		System.out.println(pid);
		return cityMapper.selectByExample(example);
		//return cityMapper.selectByExample(new CityExample());
	}

}
