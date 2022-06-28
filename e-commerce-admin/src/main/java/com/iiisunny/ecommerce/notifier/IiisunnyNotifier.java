package com.iiisunny.ecommerce.notifier;

import com.iiisunny.ecommerce.advice.GlobalExceptionAdvice;
import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractEventNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * <h1>自定义告警</h1>
 * */
@Component
@SuppressWarnings("all")
public class IiisunnyNotifier extends AbstractEventNotifier {

    private static final Logger LOG = LoggerFactory.getLogger(IiisunnyNotifier.class);

    protected IiisunnyNotifier(InstanceRepository repository) {
        super(repository);
    }

    /**
     * <h2>实现对事件的通知</h2>
     * */
    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {

        return Mono.fromRunnable(() -> {

            if (event instanceof InstanceStatusChangedEvent) {
                LOG.info("Instance Status Change: [{}], [{}], [{}]",
                        instance.getRegistration().getName(), event.getInstance(),
                        ((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());
            } else {
                LOG.info("Instance Info: [{}], [{}], [{}]",
                        instance.getRegistration().getName(), event.getInstance(),
                        event.getType());
            }

        });
    }
}
