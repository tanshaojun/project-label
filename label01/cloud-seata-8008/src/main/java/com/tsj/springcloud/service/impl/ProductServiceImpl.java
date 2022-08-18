package com.tsj.springcloud.service.impl;

import com.tsj.springcloud.mapper.ProductMapper;
import com.tsj.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tansj
 * @Date 2022/8/18 10:53
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int decrease(Integer productId, Integer count) {
        return productMapper.decrease(productId, count);
    }
}
