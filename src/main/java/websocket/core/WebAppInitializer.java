package websocket.core;


import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	
	public static void main(String[] args) {
		SpringApplication.run(WebAppInitializer.class, args);
	}
	
	@Override
	  protected void customizeRegistration(ServletRegistration.Dynamic registration) {
	    registration.setInitParameter("dispatchOptionsRequest", "true");
	    registration.setAsyncSupported(true);
	  }

	  @Override
	  protected Class< ?>[] getRootConfigClasses() {
	    return new Class< ?>[] { AppConfig.class, WebSocketConfig.class };
	  }

	  @Override
	  protected Class< ?>[] getServletConfigClasses() {
	    return new Class< ?>[] { WebConfig.class };
	  }

	  @Override
	  protected String[] getServletMappings() {
	    return new String[] { "/" };
	  }

	  @Override
	  protected Filter[] getServletFilters() {
	    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	    characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());
	    return new Filter[] { characterEncodingFilter };
	  }
}
