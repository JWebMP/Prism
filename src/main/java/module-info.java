import com.guicedee.client.services.config.IGuiceScanModuleInclusions;
import com.jwebmp.plugins.prism.implementations.PrismInclusionModule;

module com.jwebmp.plugins.prism {
    exports com.jwebmp.plugins.prism;
    exports com.jwebmp.plugins.prism.config;

    requires transitive com.jwebmp.core.base.angular.client;
    requires static com.jwebmp.core.angular;
    requires transitive com.jwebmp.client;
    requires transitive com.jwebmp.core;

    requires static lombok;

    provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.prism.config.PrismPageConfigurator;
    provides IGuiceScanModuleInclusions with PrismInclusionModule;

    opens com.jwebmp.plugins.prism to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;
    opens com.jwebmp.plugins.prism.config to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;
    opens com.jwebmp.plugins.prism.implementations to com.fasterxml.jackson.databind, com.google.guice, com.jwebmp.core, com.jwebmp.core.angular;
}

