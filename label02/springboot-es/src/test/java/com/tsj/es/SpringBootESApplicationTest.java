package com.tsj.es;

import cn.hutool.core.date.DateUtil;
import com.tsj.es.domain.Person;
import com.tsj.es.mapper.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author tansj
 * @Date 2023/2/17 15:16
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootESApplicationTest {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 测试 ElasticTemplate 创建 index
     */
    @Test
    public void testCreateIndex() {
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(Person.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchTemplate.putMapping(Person.class);
    }

    /**
     * 测试 ElasticTemplate 删除 index
     */
    @Test
    public void testDeleteIndex() {
        elasticsearchTemplate.deleteIndex(Person.class);
    }


    /**
     * 测试新增
     */
    @Test
    public void save() {
        Person person = new Person(1L, "张三", "M国", 19, DateUtil.parse("2008-09-02 01:04:05"), "学生");
        Person save = personRepository.save(person);
        log.info("【save】= {}", save);
    }

    /**
     * 测试批量新增
     */
    @Test
    public void saveList() {
        List<Person> personList = Lists.newArrayList();
        personList.add(new Person(2L, "李四", "Q国", 20, DateUtil.parse("1991-04-02 13:16:45"), "校长"));
        personList.add(new Person(3L, "王五", "O国", 19, DateUtil.parse("1992-11-02 23:28:07"), "老师"));
        personList.add(new Person(4L, "社会人", "L国", 16, DateUtil.parse("1985-08-02 11:05:55"), "社会人员"));
        Iterable<Person> people = personRepository.saveAll(personList);
        log.info("【people】= {}", people);
    }

    /**
     * 测试更新
     */
    @Test
    public void update() {
        personRepository.findById(1L).ifPresent(person -> {
            person.setRemark(person.getRemark() + "\n更新");
            Person save = personRepository.save(person);
            log.info("【save】= {}", save);
        });
    }

    /**
     * 测试删除
     */
    @Test
    public void delete() {
        // 主键删除
        personRepository.deleteById(1L);

        // 对象删除
        personRepository.findById(2L).ifPresent(person -> personRepository.delete(person));

        // 批量删除
        personRepository.deleteAll(personRepository.findAll());
    }
}
