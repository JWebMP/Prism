package com.jwebmp.plugins.prism.config;

import com.jwebmp.core.base.angular.client.annotations.typescript.TsDependency;
import com.jwebmp.core.base.angular.client.annotations.typescript.TsDevDependency;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import jakarta.validation.constraints.NotNull;

/**
 * Page configurator for the PrismJS syntax highlighting plugin.
 * <p>
 * Registers the {@code prismjs} TypeScript dependency for syntax highlighting.
 * PrismJS is a lightweight, extensible syntax highlighter that works by styling
 * standard {@code <pre><code class="language-xxx">} HTML elements.
 * </p>
 * <p>
 * PrismJS features:
 * <ul>
 *   <li>300+ language grammars</li>
 *   <li>8 built-in themes plus community themes</li>
 *   <li>Plugins: line numbers, line highlight, command line, autoloader, and more</li>
 *   <li>Async highlighting via Web Workers</li>
 *   <li>Lifecycle hooks (before-sanity-check, before-highlight, after-highlight, complete, before-insert)</li>
 * </ul>
 * <p>
 * This configurator is automatically discovered via the Java ServiceLoader mechanism
 * through the {@code META-INF/services/com.jwebmp.core.services.IPageConfigurator} file.
 * </p>
 *
 * @see <a href="https://prismjs.com/">PrismJS</a>
 */
@PluginInformation(
        pluginName = "PrismJS",
        pluginUniqueName = "prismjs",
        pluginDescription = "PrismJS syntax highlighting for Angular. " +
                "Lightweight, extensible highlighter with 300+ languages, " +
                "themes, line numbers, and async Web Worker support.",
        pluginVersion = "1.30.0",
        pluginCategories = "syntax highlighting, code, prism",
        pluginSubtitle = "PrismJS syntax highlighting rendered as standard " +
                "pre/code HTML elements — integrated into the JWebMP framework.",
        pluginGitUrl = "https://github.com/JWebMP/Plugins/Prism",
        pluginWikiUrl = "https://github.com/JWebMP/Plugins/Prism/wiki",
        pluginOriginalHomepage = "https://prismjs.com/",
        pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins/prism",
        pluginIconUrl = "",
        pluginIconImageUrl = "",
        pluginLastUpdatedDate = "2026/03/25",
        pluginGroupId = "com.jwebmp.plugins",
        pluginArtifactId = "prism",
        pluginModuleName = "com.jwebmp.plugins.prism",
        pluginStatus = PluginStatus.DevelopmentStarted
)
@TsDependency(value = "prismjs", version = "^1.30.0")
@TsDevDependency(value = "@types/prismjs", version = "^1.26.0")
public class PrismPageConfigurator implements IPageConfigurator<PrismPageConfigurator>
{
    /**
     * Whether the PrismJS plugin is enabled.
     */
    public static boolean enabled = true;

    /**
     * Creates a new PrismPageConfigurator instance.
     */
    public PrismPageConfigurator()
    {
        // Nothing needed
    }

    @NotNull
    @Override
    public IPage<?> configure(IPage<?> page)
    {
        return page;
    }

    @Override
    public boolean enabled()
    {
        return enabled;
    }
}

