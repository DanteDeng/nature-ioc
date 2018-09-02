package com.nature.ioc.context;

import com.nature.ioc.beanfactory.AnnotationBeanFactory;
import com.nature.ioc.definitions.BeanFactory;
import com.nature.ioc.definitions.Context;
import com.nature.ioc.model.BeanDefinition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnnotationContext implements Context {

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    public AnnotationContext() {
        classLoader = Thread.currentThread().getContextClassLoader();
        Map<String, Object> beansMap = new HashMap<>();
        Set<BeanDefinition> beansSet = new HashSet<>();
        beanFactory = new AnnotationBeanFactory(beansMap, beansSet);
    }

    @Override
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public ClassLoader getClassLoader() {
        return classLoader;
    }

    @Override
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public Object getBean(String id) {
        return beanFactory.getBean(id);
    }

    @Override
    public <T> T getBean(Class<T> aClass) {
        return beanFactory.getBean(aClass);
    }

    @Override
    public <T> T getBean(String id, Class<T> aClass) {
        return beanFactory.getBean(id, aClass);
    }

    @Override
    public Map<String, Object> getBeansMap() {
        return beanFactory.getBeansMap();
    }

    @Override
    public Set<BeanDefinition> getBeansSet() {
        return beanFactory.getBeansSet();
    }

}
