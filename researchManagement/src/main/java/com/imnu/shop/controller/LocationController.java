package com.imnu.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imnu.shop.pojo.Area;
import com.imnu.shop.pojo.City;
import com.imnu.shop.pojo.Province;
import com.imnu.shop.service.AreaService;
import com.imnu.shop.service.CityService;
import com.imnu.shop.service.ProvinceService;

@Controller
@RequestMapping("/loc")
public class LocationController {
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService;
	
	@RequestMapping("/findAllProvince")
	@ResponseBody
	public List<Province> findAllProvince() {
		return provinceService.findAllProvince();
	}
	@RequestMapping("/findCitiesByPId")
	@ResponseBody
	public List<City> findCitiesByPId(String pid) {
		System.out.println(pid);
		int pid2=Integer.parseInt(pid);
		System.out.println(pid2);
		return cityService.findCitiesByPId(pid2);
	}
	@RequestMapping("/findAreaByCId")
	@ResponseBody
	public List<Area> findAreaByCId(String cid) {
		System.out.println(cid);
		int cid2=Integer.parseInt(cid);
		System.out.println(cid2);
		return areaService.findAreaByCId(cid2);
	}
	
}
