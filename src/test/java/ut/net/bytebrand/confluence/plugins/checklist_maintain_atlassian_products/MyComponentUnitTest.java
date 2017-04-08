package ut.net.bytebrand.confluence.plugins.checklist_maintain_atlassian_products;

import org.junit.Test;
import net.bytebrand.confluence.plugins.checklist_maintain_atlassian_products.api.MyPluginComponent;
import net.bytebrand.confluence.plugins.checklist_maintain_atlassian_products.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}