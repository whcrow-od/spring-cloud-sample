package ua.od.whcrow.samples.spring.cloud.service.datetime;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebPathMatchingConfig implements WebMvcConfigurer {
	
	@Override
	public void configurePathMatch(@NonNull PathMatchConfigurer configurer) {
		configurer.addPathPrefix(Constants.ENDPOINT_PATH_PREFIX, HandlerTypePredicate.forAnnotation(RestController.class));
	}
	
}
