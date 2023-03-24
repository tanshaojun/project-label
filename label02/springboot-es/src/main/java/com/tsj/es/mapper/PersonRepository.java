package com.tsj.es.mapper;

import com.tsj.es.domain.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author tansj
 * @Date 2023/2/17 15:14
 * @Version 1.0
 */
public interface PersonRepository extends ElasticsearchRepository<Person, Long> {

    /**
     * 根据年龄区间查询
     *
     * @param min 最小值
     * @param max 最大值
     * @return 满足条件的用户列表
     */
    List<Person> findByAgeBetween(Integer min, Integer max);
}
