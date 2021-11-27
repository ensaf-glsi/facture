//package com.ids.config;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
//import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//@Import(BeanValidatorPluginsConfiguration.class)
//public class SpringFoxConfig {
//
//	public static final String AUTHORIZATION_HEADER = "Authorization";
//	public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
//	private final Logger logger = LoggerFactory.getLogger(SpringFoxConfig.class);
//
//	private ApiInfo apiInfo() {
//		return new ApiInfo("Facture API", "clients, articles, factures", "3.0.0",
//				"https://innov-ds.com/privacy-policy/",
//				new Contact("Team IDS", "https://innov-ds.com/#team", "contact@innov-ds.com"), "MIT",
//				"https://innov-ds.com/mentions-legales/", Collections.emptyList());
//	}
//
//	@Bean
//	public Docket api() {
//		logger.debug("Starting config Swagger");
//
//		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey()));
//
//		docket = docket.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
////				.paths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
//				.build();
//		logger.debug("End config Swagger");
//		return docket;
//	}
//
//	private ApiKey apiKey() {
//		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
//	}
//
//	private SecurityContext securityContext() {
//		return SecurityContext.builder().securityReferences(defaultAuth()).build();
//	}
//
//	List<SecurityReference> defaultAuth() {
//		AuthorizationScope[] authorizationScopes = { new AuthorizationScope("global", "accessEverything") };
//		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//	}
//}