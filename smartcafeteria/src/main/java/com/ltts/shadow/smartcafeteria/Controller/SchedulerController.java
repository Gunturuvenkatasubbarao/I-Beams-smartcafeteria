package com.ltts.shadow.smartcafeteria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancy;
import com.ltts.shadow.smartcafeteria.Models.ServiceOccupancy;
import com.ltts.shadow.smartcafeteria.Scheduler.CurrentOccupancyScheduler;
import com.ltts.shadow.smartcafeteria.Scheduler.ServiceOccupancyScheduler;
import com.ltts.shadow.smartcafeteria.Services.CurrentOccupancyService;
import com.ltts.shadow.smartcafeteria.Services.ServiceOccupancyService;

@CrossOrigin("http://localhost:4200")
@RestController
public class SchedulerController {
	
	

	@Autowired
	private CurrentOccupancyScheduler cos;
	
	@Autowired
	private CurrentOccupancyService currentOccupancyService;
	
	@Autowired
	private ServiceOccupancyScheduler sos;
	
	@Autowired
	private ServiceOccupancyService serviceOccupancyService;
	
	
	
	
	
	//for dining occupancy
	@GetMapping("/getCurrentOccupancy")
	public Iterable<CurrentOccupancy> getCurrentOccupancy()
	{
		return cos.getCurrentOccupancy();
	}

	@RequestMapping("/page")
	public ResponseEntity<List<CurrentOccupancy>> getAllEmployment( @RequestParam(defaultValue = "0") Integer pageNo, 
    @RequestParam(defaultValue = "4") Integer pageSize,
    @RequestParam(defaultValue = "id") String sortBy) {
	
		List<CurrentOccupancy> list = currentOccupancyService.getAlldata(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<CurrentOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
	}
	
	@RequestMapping("/lastpage")
	public ResponseEntity<List<CurrentOccupancy>> getAllEmployment1( @RequestParam(defaultValue = "0") Integer pageNo, 
    @RequestParam(defaultValue = "1") Integer pageSize,
    @RequestParam(defaultValue = "id") String sortBy) {
	
		List<CurrentOccupancy> list = currentOccupancyService.getAlldata(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<CurrentOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
	}
	
	
	
	
	
	//for service occupancy
	@GetMapping("/getServiceOccupancy")
	public Iterable<ServiceOccupancy> getServiceOccupancy()
	{
		return sos.getServiceOccupancy();
	}

	@RequestMapping("/pageservice")
	public ResponseEntity<List<ServiceOccupancy>> getAllEmploymentt( @RequestParam(defaultValue = "0") Integer pageNo, 
    @RequestParam(defaultValue = "4") Integer pageSize,
    @RequestParam(defaultValue = "id") String sortBy) {
	
		List<ServiceOccupancy> list = serviceOccupancyService.getAlldata(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<ServiceOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
	}
	
	@RequestMapping("/lastpageservice")
	public ResponseEntity<List<ServiceOccupancy>> getAllEmploymentt1( @RequestParam(defaultValue = "0") Integer pageNo, 
    @RequestParam(defaultValue = "1") Integer pageSize,
    @RequestParam(defaultValue = "id") String sortBy) {
	
		List<ServiceOccupancy> list = serviceOccupancyService.getAlldata(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<ServiceOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
	}


	
}
