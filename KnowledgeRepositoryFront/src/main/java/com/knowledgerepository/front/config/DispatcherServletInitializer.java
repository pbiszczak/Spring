package com.knowledgerepository.front.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {

        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{ FrontConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {

        return new String[] { "/" };
    }
}
