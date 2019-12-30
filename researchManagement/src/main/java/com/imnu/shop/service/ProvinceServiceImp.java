package com.imnu.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.shop.mapper.ProvinceMapper;
import com.imnu.shop.pojo.Province;
import com.imnu.shop.pojo.ProvinceExample;

@Service
@Transactional
public class ProvinceServiceImp implements ProvinceService {

	@Autowired
	private ProvinceMapper provinceMapper;
	
	public List<Province> findAllProvince() {
		return provinceMapper.selectByExample(new ProvinceExample());
	}

}
