package com.tsj.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author tansj
 * @Date 2022/8/18 09:58
 * @Version 1.0
 */
@Mapper
public interface ProductMapper {

    int decrease(@Param("productId") Integer productId, @Param("count") Integer count);

}
