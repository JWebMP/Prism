package com.jwebmp.plugins.prism;

/**
 * Enumerates the built-in PrismJS themes available for syntax highlighting styling.
 * <p>
 * Each theme maps to a CSS file shipped with the PrismJS npm package.
 * Use with {@link com.jwebmp.plugins.prism.config.PrismPageConfigurator} to configure the default theme,
 * or with {@link PrismCodeBlock#setTheme(PrismTheme)} for per-block theming.
 * </p>
 */
public enum PrismTheme
{
    /**
     * Default PrismJS theme
     */
    Default("prism"),
    /**
     * Dark theme
     */
    Dark("prism-dark"),
    /**
     * Funky theme
     */
    Funky("prism-funky"),
    /**
     * Okaidia (Monokai-based) theme
     */
    Okaidia("prism-okaidia"),
    /**
     * Tomorrow Night theme
     */
    TomorrowNight("prism-tomorrow"),
    /**
     * Twilight theme
     */
    Twilight("prism-twilight"),
    /**
     * Coy theme
     */
    Coy("prism-coy"),
    /**
     * Solarized Light theme
     */
    SolarizedLight("prism-solarizedlight"),
    /**
     * One Dark theme (popular VSCode theme)
     */
    OneDark("prism-one-dark"),
    /**
     * One Light theme
     */
    OneLight("prism-one-light");

    private final String cssFileName;

    PrismTheme(String cssFileName)
    {
        this.cssFileName = cssFileName;
    }

    /**
     * Returns the CSS file name (without extension) for this theme.
     *
     * @return the theme CSS file name
     */
    public String getCssFileName()
    {
        return cssFileName;
    }

    /**
     * Returns the full import path for the theme CSS file within the prismjs package.
     *
     * @return the full CSS import path
     */
    public String getCssImportPath()
    {
        return "prismjs/themes/" + cssFileName + ".css";
    }

    @Override
    public String toString()
    {
        return cssFileName;
    }
}

