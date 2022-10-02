package com.iiisunny.ecommerce.dao;

import com.iiisunny.ecommerce.entity.EcommerceLogistics;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>EcommerceLogistics Dao 接口定义</h1>
 * */
public interface EcommerceLogisticsDao extends JpaRepository<EcommerceLogistics, Long> {
}
