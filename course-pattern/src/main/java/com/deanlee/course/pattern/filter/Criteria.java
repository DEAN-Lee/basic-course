package com.deanlee.course.pattern.filter;

import java.util.List;

/**
 * 抽象标准接口
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
