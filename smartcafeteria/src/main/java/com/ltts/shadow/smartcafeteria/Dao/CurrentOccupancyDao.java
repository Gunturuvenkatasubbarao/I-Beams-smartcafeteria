package com.ltts.shadow.smartcafeteria.Dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancy;

@Repository
public interface CurrentOccupancyDao extends PagingAndSortingRepository<CurrentOccupancy, Long> {

	
}
