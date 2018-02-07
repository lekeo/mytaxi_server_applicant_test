package com.mytaxi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class MyTaxiOAuth2Resource extends ResourceServerConfigurerAdapter
{

	/**
	 * added /asd/v1/**
	 * if you add authentication all request(OAuth2), 
	 * 		you can remove '/asd'
	 */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests().antMatchers("/asd/v1/**")
            .authenticated();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

}
