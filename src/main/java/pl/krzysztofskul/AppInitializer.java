package pl.krzysztofskul;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

public class AppInitializer implements WebApplicationInitializer {


    protected Class<?>[] getRootConfigClasses() { return null; }


    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }


    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[] { characterEncodingFilter };
    }

    /* file uploading configuration  */

    //private static final String LOCATION = "/tmp/"; // Temporary location where files will be stored
    private static final String LOCATION = "D:\\KSKLN\\ZZX--TMP"; // Temporary location where files will be stored

    private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
    // Beyond that size spring will throw exception.
    private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.

    private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk


    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //registration.setMultipartConfig(new MultipartConfigElement("./tmp"));
        registration.setMultipartConfig(getMultipartConfigElement());
    }

    private MultipartConfigElement getMultipartConfigElement() {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
        return multipartConfigElement;
    }
    /**/


	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
	    AnnotationConfigWebApplicationContext ctx =
	            new AnnotationConfigWebApplicationContext();		//1
	        ctx.register(AppConfig.class);					//2 
	        ctx.setServletContext(servletContext);				// 3
	        ServletRegistration.Dynamic servlet =
	        		servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));	// 4
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");	
	}

}