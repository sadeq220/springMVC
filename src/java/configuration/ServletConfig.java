package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("controller")
public class ServletConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver getView(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    registry.addResourceHandler("/imgs/*").addResourceLocations("file:D:\\imgs\\");
    }
}
