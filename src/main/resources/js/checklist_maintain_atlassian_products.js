AJS.toInit(function ($) {
    function isRequiredField($container, fieldId, error) {
        var $field = $container.find(fieldId);

        if ($.trim($field.val()) === "") {
            $field.focus().siblings(".error").html(error);
            return false;
        }
        return true;
    }

    function isValidUrl($container, fieldId, error) {
        var $field = $container.find(fieldId);

        var url = $field.val();

        var re = /^(http[s]?:\/\/){0,1}(www\.){0,1}[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}[\.]{0,1}/;
        if (!re.test(url)) {
            $field.focus().siblings(".error").html(error);
            return false;
        }
        return true;
    }

    Confluence.Blueprint.setWizard('net.bytebrand.confluence.plugins.checklist_maintain_atlassian_products.checklist_maintain_atlassian_products:create-checklist-maintain-atlassian-products', function (wizard) {
        wizard.on('submit.checklistWizardMainPage', function (e, state) {
            var $container = state.$container;
            $container.find(".error").html(""); // clear all existing errors
            var urlRequired = isRequiredField($container, "#future-url", AJS.I18n.getText("checklist.wizard.blueprint.form.field.url.validation.required"));
            var customerNameRequired = isRequiredField($container, "#customer-name", AJS.I18n.getText("checklist.wizard.blueprint.form.field.customer.validation.required"));
            var urlValid = isValidUrl($container, "#future-url", AJS.I18n.getText("checklist.wizard.blueprint.form.field.url.validation.allowedsymbols"));
            return urlRequired && customerNameRequired && urlValid;
        });

    });

});