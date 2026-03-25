package com.jwebmp.plugins.prism;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the PrismJS plugin components.
 */
public class PrismCodeBlockTest
{
    @Test
    void testDefaultConstruction()
    {
        PrismCodeBlock<?> block = new PrismCodeBlock<>();
        assertNotNull(block);
    }

    @Test
    void testConstructionWithCodeAndLanguage()
    {
        PrismCodeBlock<?> block = new PrismCodeBlock<>("System.out.println(\"Hello\");", PrismLanguage.Java);
        assertEquals("System.out.println(\"Hello\");", block.getCode());
        assertEquals(PrismLanguage.Java, block.getLanguage());
    }

    @Test
    void testFactoryMethodOf()
    {
        PrismCodeBlock<?> block = PrismCodeBlock.of("const x = 42;", PrismLanguage.TypeScript);
        assertEquals("const x = 42;", block.getCode());
        assertEquals(PrismLanguage.TypeScript, block.getLanguage());
    }

    @Test
    void testFactoryMethodWithLineNumbers()
    {
        PrismCodeBlock<?> block = PrismCodeBlock.withLineNumbers("SELECT * FROM users;", PrismLanguage.Sql);
        assertEquals("SELECT * FROM users;", block.getCode());
        assertEquals(PrismLanguage.Sql, block.getLanguage());
        assertTrue(block.getLineNumbers());
    }

    @Test
    void testInlineFactory()
    {
        PrismCodeBlock<?> block = PrismCodeBlock.inline("npm install", PrismLanguage.Bash);
        assertEquals("npm install", block.getCode());
        assertEquals(PrismLanguage.Bash, block.getLanguage());
    }

    @Test
    void testPrismLanguageCode()
    {
        assertEquals("java", PrismLanguage.Java.getLanguageCode());
        assertEquals("typescript", PrismLanguage.TypeScript.getLanguageCode());
        assertEquals("javascript", PrismLanguage.JavaScript.getLanguageCode());
        assertEquals("python", PrismLanguage.Python.getLanguageCode());
        assertEquals("markup", PrismLanguage.Markup.getLanguageCode());
        assertEquals("css", PrismLanguage.Css.getLanguageCode());
        assertEquals("bash", PrismLanguage.Bash.getLanguageCode());
        assertEquals("html", PrismLanguage.Html.getLanguageCode());
    }

    @Test
    void testPrismThemeCssPath()
    {
        assertEquals("prismjs/themes/prism.css", PrismTheme.Default.getCssImportPath());
        assertEquals("prismjs/themes/prism-okaidia.css", PrismTheme.Okaidia.getCssImportPath());
        assertEquals("prismjs/themes/prism-tomorrow.css", PrismTheme.TomorrowNight.getCssImportPath());
        assertEquals("prismjs/themes/prism-dark.css", PrismTheme.Dark.getCssImportPath());
    }

    @Test
    void testPrismOptions()
    {
        PrismOptions<?> options = new PrismOptions<>(PrismLanguage.Java, true);
        assertEquals("java", options.getLanguage());
        assertTrue(options.getLineNumbers());
    }

    @Test
    void testPrismOptionsTheme()
    {
        PrismOptions<?> options = new PrismOptions<>();
        options.setTheme(PrismTheme.Okaidia);
        assertEquals("prism-okaidia", options.getTheme());
    }

    @Test
    void testSetters()
    {
        PrismCodeBlock<?> block = new PrismCodeBlock<>();
        block.setCode("hello world");
        block.setLanguage(PrismLanguage.Python);
        block.setLineNumbers(true);

        assertEquals("hello world", block.getCode());
        assertEquals(PrismLanguage.Python, block.getLanguage());
        assertTrue(block.getLineNumbers());
    }
}

