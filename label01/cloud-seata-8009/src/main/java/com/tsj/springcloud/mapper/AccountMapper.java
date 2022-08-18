package com.tsj.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author tansj
 * @Date 2022/8/18 09:58
 * @Version 1.0
 */
@Mapper
public interface AccountMapper {

    int decrease(@Param("userId") Integer userId, @Param("count") BigDecimal count);

}
