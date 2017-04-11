package net.bytebrand.confluence.plugins.checklist_maintain_atlassian_products.listener;

import com.atlassian.confluence.event.events.content.page.PageCreateEvent;
import com.atlassian.confluence.labels.Label;
import com.atlassian.confluence.labels.LabelManager;
import com.atlassian.confluence.pages.Page;
import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import org.springframework.beans.factory.DisposableBean;


/**
 * @author Danil Kuznetsov
 */
public class CheckListEventListener implements DisposableBean {

    private final LabelManager labelManager;
    private final EventPublisher eventPublisher;

    public CheckListEventListener(LabelManager labelManager, EventPublisher eventPublisher) {
        this.labelManager = labelManager;
        this.eventPublisher = eventPublisher;
        eventPublisher.register(this);
    }

    @EventListener
    public void onPageCreated(PageCreateEvent event) {

        Page page = event.getPage();

        String url = "Replace this to current url in request user";

        // In this place should be getting the value of url from the context
        // but when working with ImmutableMap throws exception and now i can not fix it :(
        // Problem with dependency resolution :(

        // If you know how to fix it, tell me, I'm very interested

        // Caused by:
        // java.lang.LinkageError:
        // loader constraint violation: when resolving method "com.atlassian.confluence.event.events.content.page.PageCreateEvent.getContext()Lcom/google/common/collect/ImmutableMap;"
        // the class loader (instance of org/apache/felix/framework/BundleWiringImpl$BundleClassLoaderJava5) of the current class, net/bytebrand/confluence/plugins/checklist_maintain_atlassian_products/listener/CheckListEventListener,
        // and the class loader (instance of org/apache/catalina/loader/WebappClassLoader) for the method's defining class, com/atlassian/confluence/event/events/content/page/PageCreateEvent,
        // have different Class objects for the type com/google/common/collect/ImmutableMap used in the signature


        //url = event.getContext().get("futureUrl");

        Label newLabel = new Label(url);
        labelManager.addLabel(page, newLabel);
    }

    public void destroy() throws Exception {
        eventPublisher.unregister(this);
    }
}
