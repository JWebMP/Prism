package com.jwebmp.plugins.prism;

/**
 * Enumerates the programming languages supported by PrismJS for syntax highlighting.
 * <p>
 * Each enum constant maps to a PrismJS language identifier used in the {@code [language]} attribute
 * of the {@code <ngx-prism>} Angular component.
 * </p>
 */
public enum PrismLanguage
{
    /**
     * Markup (HTML/XML)
     */
    Markup("markup"),
    /**
     * HTML
     */
    Html("html"),
    /**
     * XML
     */
    Xml("xml"),
    /**
     * SVG
     */
    Svg("svg"),
    /**
     * MathML
     */
    MathML("mathml"),
    /**
     * CSS
     */
    Css("css"),
    /**
     * C-like languages
     */
    CLike("clike"),
    /**
     * JavaScript
     */
    JavaScript("javascript"),
    /**
     * TypeScript
     */
    TypeScript("typescript"),
    /**
     * Java
     */
    Java("java"),
    /**
     * C
     */
    C("c"),
    /**
     * C++
     */
    Cpp("cpp"),
    /**
     * C#
     */
    CSharp("csharp"),
    /**
     * Python
     */
    Python("python"),
    /**
     * Ruby
     */
    Ruby("ruby"),
    /**
     * Go
     */
    Go("go"),
    /**
     * Rust
     */
    Rust("rust"),
    /**
     * Kotlin
     */
    Kotlin("kotlin"),
    /**
     * Swift
     */
    Swift("swift"),
    /**
     * PHP
     */
    Php("php"),
    /**
     * SQL
     */
    Sql("sql"),
    /**
     * JSON
     */
    Json("json"),
    /**
     * YAML
     */
    Yaml("yaml"),
    /**
     * Bash/Shell
     */
    Bash("bash"),
    /**
     * PowerShell
     */
    PowerShell("powershell"),
    /**
     * Markdown
     */
    Markdown("markdown"),
    /**
     * Docker
     */
    Docker("docker"),
    /**
     * Regex
     */
    Regex("regex"),
    /**
     * Sass (SCSS)
     */
    Scss("scss"),
    /**
     * Less
     */
    Less("less"),
    /**
     * GraphQL
     */
    GraphQL("graphql"),
    /**
     * Groovy
     */
    Groovy("groovy"),
    /**
     * Scala
     */
    Scala("scala"),
    /**
     * Dart
     */
    Dart("dart"),
    /**
     * Lua
     */
    Lua("lua"),
    /**
     * R
     */
    R("r"),
    /**
     * Perl
     */
    Perl("perl"),
    /**
     * TOML
     */
    Toml("toml"),
    /**
     * INI
     */
    Ini("ini"),
    /**
     * Diff
     */
    Diff("diff"),
    /**
     * Git
     */
    Git("git"),
    /**
     * Makefile
     */
    Makefile("makefile"),
    /**
     * Nginx
     */
    Nginx("nginx"),
    /**
     * Apache Configuration
     */
    ApacheConf("apacheconf"),
    /**
     * LaTeX
     */
    Latex("latex"),
    /**
     * Plain Text
     */
    PlainText("plain");

    private final String languageCode;

    PrismLanguage(String languageCode)
    {
        this.languageCode = languageCode;
    }

    /**
     * Returns the PrismJS language identifier string.
     *
     * @return the language code used by PrismJS
     */
    public String getLanguageCode()
    {
        return languageCode;
    }

    @Override
    public String toString()
    {
        return languageCode;
    }
}

