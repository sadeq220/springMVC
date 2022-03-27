package configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
// DOC : In a Servlet 3.0+ environment, you have the option of configuring the Servlet container programmatically as an alternative or in combination with a web.xml file
// here we configure dispatcherServlet (which is HttpServlet in it's heart) instead of using a web.xml <servlet> and <mapping> tags 
public class WebConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class[]{RootConfig.class,SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        final int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;
        registration.setMultipartConfig(new MultipartConfigElement(System.getProperty("java.io.tmpdir"),MAX_UPLOAD_SIZE,2*MAX_UPLOAD_SIZE,MAX_UPLOAD_SIZE/2));
    }
}
