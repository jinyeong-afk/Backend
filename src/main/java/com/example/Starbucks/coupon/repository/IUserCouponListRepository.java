package com.example.Starbucks.coupon.repository;

import com.example.Starbucks.coupon.model.UserCouponList;
import com.example.Starbucks.product.model.ProductCategoryList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserCouponListRepository extends JpaRepository<UserCouponList,Long> {

    List<UserCouponList> findAllById(Long userId);



}
