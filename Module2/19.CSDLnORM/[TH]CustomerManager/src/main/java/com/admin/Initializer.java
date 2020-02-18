package com.admin;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]{Config.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[]{"/"};
    }
}
