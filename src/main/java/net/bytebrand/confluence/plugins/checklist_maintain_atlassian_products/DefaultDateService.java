package net.bytebrand.confluence.plugins.checklist_maintain_atlassian_products;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Danil Kuznetsov
 */
public class DefaultDateService implements DateService {

    public String getCurrentDate() {
        return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(new Date());
    }
}
