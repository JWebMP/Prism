package com.jwebmp.plugins.prism;

import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.plugins.ComponentInformation;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * JWebMP component for PrismJS syntax highlighting.
 * <p>
 * Renders a {@code <pre><code class="language-xxx">} HTML structure that PrismJS
 * automatically highlights. This is the standard PrismJS integration pattern — no
 * Angular wrapper library required.
 * </p>
 * <p>
 * PrismJS highlights code in the browser by matching {@code <code>} elements with
 * a {@code language-xxx} CSS class. The ngx-markdown plugin uses PrismJS the same way
 * for fenced code blocks inside markdown content.
 * </p>
 *
 * <h3>Usage Examples:</h3>
 * <pre>
 * // Basic code block
 * PrismCodeBlock block = PrismCodeBlock.of("System.out.println(\"Hello\");", PrismLanguage.Java);
 *
 * // With line numbers
 * PrismCodeBlock block = PrismCodeBlock.withLineNumbers("SELECT * FROM users;", PrismLanguage.Sql);
 *
 * // Inline code snippet
 * PrismCodeBlock inline = PrismCodeBlock.inline("npm install", PrismLanguage.Bash);
 * </pre>
 *
 * @see PrismLanguage
 * @see PrismTheme
 * @see com.jwebmp.plugins.prism.config.PrismPageConfigurator
 * @see <a href="https://prismjs.com/">PrismJS</a>
 */
@Getter
@Setter
@ComponentInformation(name = "PrismJS Code Block",
        description = "Syntax highlighted code block using PrismJS. " +
                "Renders standard pre/code HTML that PrismJS highlights in the browser.",
        url = "https://prismjs.com/")
public class PrismCodeBlock<J extends PrismCodeBlock<J>> extends DivSimple<J> implements INgComponent<J>
{
    /**
     * The source code to highlight.
     */
    private String code;

    /**
     * The programming language for syntax highlighting.
     */
    private PrismLanguage language;

    /**
     * Whether to display line numbers (requires the PrismJS line-numbers plugin).
     */
    private Boolean lineNumbers;

    /**
     * Creates an empty prism code block.
     */
    public PrismCodeBlock()
    {
        setTag("pre");
    }

    /**
     * Creates a prism code block with the given code and language.
     *
     * @param code     the source code to highlight
     * @param language the programming language for syntax highlighting
     */
    public PrismCodeBlock(@NotNull String code, @NotNull PrismLanguage language)
    {
        this();
        this.code = code;
        this.language = language;
    }

    /**
     * Factory method for creating a prism code block.
     *
     * @param code     the source code to highlight
     * @param language the programming language for syntax highlighting
     * @return a configured PrismCodeBlock instance
     */
    public static PrismCodeBlock<?> of(@NotNull String code, @NotNull PrismLanguage language)
    {
        return new PrismCodeBlock<>(code, language);
    }

    /**
     * Factory method for creating a prism code block with line numbers enabled.
     *
     * @param code     the source code to highlight
     * @param language the programming language for syntax highlighting
     * @return a configured PrismCodeBlock instance with line numbers
     */
    public static PrismCodeBlock<?> withLineNumbers(@NotNull String code, @NotNull PrismLanguage language)
    {
        PrismCodeBlock<?> block = new PrismCodeBlock<>(code, language);
        block.setLineNumbers(true);
        return block;
    }

    /**
     * Creates an inline prism code block (useful for short snippets).
     *
     * @param code     the source code to highlight
     * @param language the programming language for syntax highlighting
     * @return a configured PrismCodeBlock instance
     */
    public static PrismCodeBlock<?> inline(@NotNull String code, @NotNull PrismLanguage language)
    {
        return new PrismCodeBlock<>(code, language);
    }

    @Override
    protected void init()
    {
        if (!isInitialized())
        {
            // PrismJS line-numbers plugin: add class to <pre>
            if (lineNumbers != null && lineNumbers)
            {
                addClass("line-numbers");
            }

            // Build inner <code class="language-xxx">escaped code</code>
            String langClass = language != null ? "language-" + language.getLanguageCode() : "";
            String escapedCode = code != null ? escapeHtml(code) : "";

            var codeElement = new DivSimple<>();
            codeElement.setTag("code");
            if (!langClass.isEmpty())
            {
                codeElement.addClass(langClass);
            }
            codeElement.setText(escapedCode);
            add(codeElement);
        }
        super.init();
    }

    /**
     * Escapes HTML special characters for safe rendering inside a code element.
     *
     * @param input the raw string to escape
     * @return the HTML-escaped string
     */
    private String escapeHtml(String input)
    {
        if (input == null)
        {
            return "";
        }
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;")
                    .replace("{", "&#123;")
                    .replace("}", "&#125;");
    }
}

