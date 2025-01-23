package br.com.portalservicos.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppParameters {

    @Value("${PS_ENV_DB_ADMIN_PASS}")
    private String DB_ADMIN_PASS;

    @Value("${PS_ENV_DB_ADMIN_USER}")
    private String DB_ADMIN_USER;

    @Value("${PS_ENV_DB_PASS}")
    private String DB_PASS;

    @Value("${PS_ENV_DB_URL}")
    private String DB_URL;

    @Value("${PS_ENV_DB_USER}")
    private String DB_USER;

    public void print(){

        log.info("Application parameters");
        log.info("DB_URL: " + DB_URL);
        log.info("DB_ADMIN_USER: " + DB_ADMIN_USER);
        log.info("DB_ADMIN_PASS: " + "*".repeat(DB_ADMIN_PASS.length()));
        log.info("DB_USER: " + DB_USER);
        log.info("DB_PASS: " + "*".repeat(DB_PASS.length()));

    }
}
