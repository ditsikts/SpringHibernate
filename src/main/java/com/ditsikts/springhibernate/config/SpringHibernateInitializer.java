
package com.ditsikts.springhibernate.config;

import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class SpringHibernateInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringHibernateConfig.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter()};
    	return singleton;
    }
}