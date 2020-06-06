package com.ypyay.comm.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * @author yjc
 * @since 2019-03-07 17:23
 **/
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfiguration {

//    @Value("${project.version}")
//    private String version;

    @Bean
    public Docket createQAAdminRestApi() {
        return createRestApi("所有接口",
                "com.ypyay.comm.controller");
    }


    public Docket createRestApi(String groupName, String... basePackage) {
        return new Docket(DocumentationType.SWAGGER_2)
//                .enable()
                .select()
                .apis(basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
//                .globalOperationParameters(commonParameter())
                .ignoredParameterTypes(HttpSession.class, HttpServletRequest.class, HttpServletResponse.class)
                .groupName(groupName);
    }

//    private List<Parameter> commonParameter() {
//        List<Parameter> pars = new ArrayList<>();
//
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        tokenPar.name("access_token")
//                .description("access_token")
//                .defaultValue("gf_token")
//                .modelRef(new ModelRef("String"))
//                .parameterType("query")
//                .required(false)
//                .build();
//        pars.add(tokenPar.build());
//        return pars;
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("GGman")
                .description("GGman后端接口")
                .termsOfServiceUrl("")
                .version("0.0.1")
                .build();
    }

    private Predicate<RequestHandler> basePackage(final String... basePackage) {
        return input -> declaringClass(input).map(handlerPackage(basePackage)::apply).orElse(true);
    }

    private Function<Class<?>, Boolean> handlerPackage(final String... basePackage) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage) {
                assert input != null;
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private Optional<Class<?>> declaringClass(RequestHandler input) {
        return Optional.ofNullable(input.declaringClass());
    }

}
