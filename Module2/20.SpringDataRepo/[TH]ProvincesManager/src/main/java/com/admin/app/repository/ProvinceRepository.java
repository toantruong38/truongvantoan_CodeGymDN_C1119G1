package com.admin.app.repository;

import com.admin.app.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends
        PagingAndSortingRepository<Province,Long>
{
}
