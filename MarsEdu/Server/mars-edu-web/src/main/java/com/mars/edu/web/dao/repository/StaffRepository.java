package com.mars.edu.web.dao.repository;

import com.mars.edu.web.locallibs.mars.MarsBaseRepository;
import com.mars.edu.web.model.orm.StaffEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:25
 * Use for: 教职工
 */
public interface StaffRepository extends MarsBaseRepository<StaffEntity> {
    @Query(value = "select sch.name as school_name,sta.* from sch_staff as sta ,sys_school as sch where sta.school_id = sch.id", nativeQuery = true)
    List<StaffEntity> searchAllStaffList();
}
