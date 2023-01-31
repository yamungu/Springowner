package spice.tech.hub.alannoorrestaurant.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        ApiInfoBuilder builder = new ApiInfoBuilder()
                .title("SOAS-Configuration-Settings REST-API")
                .description("SOAS Configuration Settings API Documentation")
                .version("1.1.0")
                .contact(new Contact("SOAS", "", "dev@suza.ac.tz"));
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("spice.tech.hub.alannoorrestaurant.controllers"))
                .paths(PathSelectors.any())
                .build()
                .select()
                .build()
                .apiInfo(builder.build());
    }
}