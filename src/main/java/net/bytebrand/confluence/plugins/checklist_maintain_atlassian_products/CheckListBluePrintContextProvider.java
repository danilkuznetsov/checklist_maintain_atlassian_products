package net.bytebrand.confluence.plugins.checklist_maintain_atlassian_products;

import com.atlassian.confluence.plugins.createcontent.api.contextproviders.AbstractBlueprintContextProvider;
import com.atlassian.confluence.plugins.createcontent.api.contextproviders.BlueprintContext;

/**
 * @author Danil Kuznetsov
 */
public class CheckListBluePrintContextProvider extends AbstractBlueprintContextProvider {

    private final DateService dateService;

    public CheckListBluePrintContextProvider(DateService dateService) {
        this.dateService = dateService;
    }

    protected BlueprintContext updateBlueprintContext(BlueprintContext context) {
        context.put("currentDate", dateService.getCurrentDate());
        return context;
    }

}
