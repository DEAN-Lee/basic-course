package com.deanlee.course.pattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dean github:https://github.com/DEAN-Lee
 * @Title: filterPatternDemo
 * @Description: 过滤器模式demo
 * @date 2020/7/7 22:23
 * 1.模式定义：
 * 过滤器(Filter Pattern)又称为标准模式(Criteria Pattern)是一种设计模式,这种模式允许开发人员使用不同的标准来过滤一组对象，
 * 通过预算逻辑以解耦的方式将他们联系起来。这种类型的设计模式属于结构模型,说白了,就是按条件筛选一组对象出来。
 * 目的:使用不同标准来过滤一组对象
 * 实现:制定不同的规则来实现过滤,然后对过滤结果进行分组。
 * 2.组成角色：
 * 1)抽象过滤器角色(AbstractFilter)：负责定义过滤器的实现接口,具体的实现还要具体过滤器角色去参与，客户端可以调用抽象过滤器角色中定义好
 * 的方法，将 客户端的所有请求委派到具体的实现类去，从而让实现类去处理。
 * 2)ConcreteFilter(具体过滤角色):该角色负责具体筛选规则的逻辑实现，最后再返回一个过滤后的数据集合，标准的过滤器只对数据做过滤,当然也
 * 可以对集合中的数据做某项处理,再将处理后的集合返回。
 * 3)Subject(被过滤的主体角色):一个软件系统中可以有一个或多个目标角色,在具体过滤器角色中对指定的目标进行处理。
 * 3.过滤器延伸：
 * 过滤器链：携带多个过滤器,并且可以以自定义顺序执行他们。
 * 过滤器管理角色：负责管理过滤器和过滤器链。
 * 4.应用场景：
 * 垃圾桶分类
 * 5.总结：
 * 1)可插拔：过滤器的设计概念要求其实支持可插拔设计的。
 * 2)有序性:过滤器是被设计为一组组的过滤装置,要实现数据过滤,就必须有序性要求.
 * 3)过滤器的独立性:每种过滤器必须是独立的实体,其状态不受其它过滤器的影响,每个过滤器都有自己独立的数据输入输出接口,只要各个过滤器之间
 * 传送的数据遵守共同的规约就可以相连接。
 */
public class filterPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    + ", Gender : " + person.getGender()
                    + ", Marital Status : " + person.getMaritalStatus()
                    + " ]");
        }
    }
}
