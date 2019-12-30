package com.imnu.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.shop.mapper.AreaMapper;
import com.imnu.shop.pojo.Area;
import com.imnu.shop.pojo.AreaExample;

@Service
@Transactional
public class AreaServiceImp implements AreaService {

	@Autowired
	private AreaMapper areaMapper;
	public List<Area> findAreaByCId(int cid) {
		AreaExample example=new AreaExample();
		//example.createCriteria().andCidEqualTo(cid);
		System.out.println(cid);
		return areaMapper.selectByExample(example);
		//return areaMapper.selectByExample(new AreaExample());
	}

}
