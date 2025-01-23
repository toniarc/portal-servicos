package br.com.portalservicos.config;

import br.com.portalservicos.util.AppParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupListenerConfig {

    private final AppParameters appParameters;

    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event) {
        appParameters.print();
    }
}
