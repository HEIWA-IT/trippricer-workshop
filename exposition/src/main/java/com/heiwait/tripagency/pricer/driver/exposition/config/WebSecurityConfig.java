package com.heiwait.tripagency.pricer.driver.exposition.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String API_URL = System.getenv("API_URL");
    private static final String ACCESS_CONTROL_AllOW_ORIGIN = System.getenv("ACCESS_CONTROL_AllOW_ORIGIN");

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
                .addHeaderWriter(new StaticHeadersWriter("X-Frame-Options", "SAMEORIGIN"))
                .addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin", ACCESS_CONTROL_AllOW_ORIGIN ))
                .addHeaderWriter(new StaticHeadersWriter("X-Content-Type-Options", "nosniff"))
                .addHeaderWriter(new StaticHeadersWriter("X-XSS-Protection", "1; mode=block"))
                .addHeaderWriter(new StaticHeadersWriter("Referrer-Policy", "same-origin"))
                .addHeaderWriter(new StaticHeadersWriter("Permissions-Policy", "sync-xhr=(none); vibrate=(none); fullscreen=(self); payment=(none);"))
                .addHeaderWriter(new StaticHeadersWriter("X-Expect-CT", "enforce, max-age=123"))
                .addHeaderWriter(new StaticHeadersWriter("Content-Security-Policy", "default-src 'self' " + API_URL + ";"))
                .addHeaderWriter(new StaticHeadersWriter("X-Strict-Transport-Security", "max-age=31536000; includeSubDomains"));
    }
}