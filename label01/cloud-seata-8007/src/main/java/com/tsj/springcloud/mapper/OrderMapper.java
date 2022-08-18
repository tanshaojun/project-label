package com.tsj.springcloud.mapper;

import com.tsj.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author tansj
 * @Date 2022/8/18 09:58
 * @Version 1.0
 */
@Mapper
public interface OrderMapper {

    int create(Order order);

    int updateState(@Param("userId") Integer userId, @Param("state") Integer state);

}
