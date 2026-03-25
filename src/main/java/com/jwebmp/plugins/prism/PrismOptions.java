package com.jwebmp.plugins.prism;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import lombok.Getter;
import lombok.Setter;

/**
 * Configuration options for PrismJS syntax highlighting.
 * <p>
 * Provides a Java-side representation of PrismJS configuration that can be serialized
 * to JSON for use in the Angular/TypeScript runtime.
 * </p>
 *
 * @param <J> self-referencing generic type for fluent API
 * @see <a href="https://prismjs.com/">PrismJS</a>
 */
@Getter
@Setter
public class PrismOptions<J extends PrismOptions<J>> extends JavaScriptPart<J>
{
    /**
     * The default language for code blocks when not explicitly set.
     */
    private String language;

    /**
     * Whether to display line numbers by default (requires prismjs line-numbers plugin).
     */
    private Boolean lineNumbers;

    /**
     * The PrismJS theme to apply.
     */
    private String theme;

    /**
     * Creates default prism options.
     */
    public PrismOptions()
    {
        // Default constructor
    }

    /**
     * Creates prism options with the specified language and line numbers setting.
     *
     * @param language    the default language
     * @param lineNumbers whether to show line numbers
     */
    public PrismOptions(PrismLanguage language, boolean lineNumbers)
    {
        this.language = language != null ? language.getLanguageCode() : null;
        this.lineNumbers = lineNumbers;
    }

    /**
     * Sets the theme from a PrismTheme enum value.
     *
     * @param theme the theme to apply
     * @return this options instance for chaining
     */
    @SuppressWarnings("unchecked")
    public J setTheme(PrismTheme theme)
    {
        this.theme = theme != null ? theme.getCssFileName() : null;
        return (J) this;
    }

    /**
     * Sets the language from a PrismLanguage enum value.
     *
     * @param language the language to set
     * @return this options instance for chaining
     */
    @SuppressWarnings("unchecked")
    public J setLanguage(PrismLanguage language)
    {
        this.language = language != null ? language.getLanguageCode() : null;
        return (J) this;
    }
}

