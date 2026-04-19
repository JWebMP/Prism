# JWebMP NGX Prism

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.plugins/prism)](https://central.sonatype.com/artifact/com.jwebmp.plugins/prism)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Modular](https://img.shields.io/badge/Modular-JPMS-green)
![Angular](https://img.shields.io/badge/Angular-20-DD0031?logo=angular)
![TypeScript](https://img.shields.io/badge/TypeScript-5-3178C6?logo=typescript)

<!-- Tech icons row -->
![PrismJS](https://img.shields.io/badge/PrismJS-1.30-5C2D91)
![JWebMP](https://img.shields.io/badge/JWebMP-2.0-0A7)

PrismJS syntax highlighting integration for JWebMP with Angular 21. Wraps [@ngx-prism/core](https://github.com/ngx-prism/core) providing AOT-compatible, high-performance code highlighting with OnPush change detection.

Built on [@ngx-prism/core](https://github.com/ngx-prism/core) · [PrismJS](https://prismjs.com/) · [JWebMP Core](https://jwebmp.com/) · JPMS module `com.jwebmp.plugins.prism` · Java 25+

---

## Features

- **40+ Languages** — Java, TypeScript, Python, SQL, Bash, JSON, YAML, and many more
- **8 Built-in Themes** — Default, Okaidia, Tomorrow Night, Solarized, Coy, Dark, Funky, Twilight
- **AOT Compatible** — Ahead of Time Compilation for faster rendering
- **OnPush Change Detection** — Detached change detector with manual `detectChanges()` for performance
- **Async Highlighting** — Web Worker support for large code blocks without UI blocking
- **String Interpolation** — Inject dynamic values into code before highlighting
- **PrismJS Hooks** — Lifecycle callbacks: before-sanity-check, before-highlight, after-highlight, complete, before-insert
- **Two Content Modes** — `[code]` property binding or ng-content transclusion
- **Change Detection Control** — Fine-grained `[cd]` property to enable/disable detection per property
- **Type-Safe API** — Enum-based language and theme selection
- **JPMS** — Fully modular with `module-info.java`
- **Guice DI** — Auto-discovered via ServiceLoader

## Installation

### Maven

```xml
<dependency>
    <groupId>com.jwebmp.plugins</groupId>
    <artifactId>prism</artifactId>
    <version>2.0.0-RC7</version>
</dependency>
```

### Module System

Add to your `module-info.java`:

```java
requires com.jwebmp.plugins.prism;
```

## Usage

### Basic Code Block (property mode)

```java
PrismCodeBlock<?> block = PrismCodeBlock.of(
    "public class Hello {\n    public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n    }\n}",
    PrismLanguage.Java
);
page.add(block);
```

### Content Mode (ng-content transclusion)

```java
PrismCodeBlock<?> block = PrismCodeBlock.content("<p>Hello World</p>", PrismLanguage.Html);
page.add(block);
```

> **Important:** Do not use `[code]` property and ng-content at the same time.

### Async Highlighting (Web Workers)

```java
// For large code blocks — highlights in a Web Worker to avoid blocking the UI
PrismCodeBlock<?> block = PrismCodeBlock.async(veryLargeCodeString, PrismLanguage.Java);
```

### String Interpolation

```java
PrismCodeBlock<?> block = PrismCodeBlock.of("<p>test {{language}}</p>", PrismLanguage.Html);
block.addInterpolation("language", "HTML5");
```

### PrismJS Hooks

```java
PrismCodeBlock<?> block = PrismCodeBlock.of(code, PrismLanguage.TypeScript);
block.setHooksExpression("myHooksObject"); // references an Angular component property
```

### Change Detection Control

```java
PrismCodeBlock<?> block = PrismCodeBlock.of(code, PrismLanguage.Java);
// Only re-highlight when 'code' changes, ignore 'language' changes
block.setCdExpression("{code: true, language: false}");
```

### Async with Callback

```java
PrismCodeBlock<?> block = PrismCodeBlock.of(code, PrismLanguage.Java);
block.setAsync(true);
block.setCallbackExpression("onHighlightComplete");
```

## Supported Languages

| Language     | Enum Value                    |
|-------------|-------------------------------|
| Java        | `PrismLanguage.Java`          |
| TypeScript  | `PrismLanguage.TypeScript`    |
| JavaScript  | `PrismLanguage.JavaScript`    |
| Python      | `PrismLanguage.Python`        |
| HTML/XML    | `PrismLanguage.Html` / `.Xml` |
| CSS         | `PrismLanguage.Css`           |
| SQL         | `PrismLanguage.Sql`           |
| Bash        | `PrismLanguage.Bash`          |
| JSON        | `PrismLanguage.Json`          |
| YAML        | `PrismLanguage.Yaml`          |
| Markdown    | `PrismLanguage.Markdown`      |
| ... and 30+ more | See `PrismLanguage` enum |

## Themes

Import themes in your Angular styles:

```css
@import '~prismjs/themes/prism-okaidia.css';
```

| Theme           | Enum Value                    |
|----------------|-------------------------------|
| Default        | `PrismTheme.Default`          |
| Dark           | `PrismTheme.Dark`             |
| Okaidia        | `PrismTheme.Okaidia`          |
| Tomorrow Night | `PrismTheme.TomorrowNight`    |
| Solarized      | `PrismTheme.SolarizedLight`   |
| Coy            | `PrismTheme.Coy`              |
| Twilight       | `PrismTheme.Twilight`         |
| Funky          | `PrismTheme.Funky`            |

## Component Inputs

| Input | Type | Description |
|-------|------|-------------|
| `[language]` | `string` | PrismJS language identifier (e.g., `'javascript'`, `'css'`) |
| `[code]` | `string` | Code string to highlight (property mode) |
| `[async]` | `boolean` | Use Web Workers for non-blocking highlighting |
| `[callback]` | `(element: Element) => void` | Callback invoked after highlighting completes |
| `[hooks]` | `Object` | PrismJS lifecycle hook callbacks |
| `[interpolation]` | `Object` | Key-value pairs for `{{placeholder}}` replacement |
| `[cd]` | `PropertiesInterface` | Per-property change detection toggle |

## Architecture

```
com.jwebmp.plugins.prism
├── PrismCodeBlock          # Main Angular component (<ngx-prism>)
├── PrismLanguage           # Supported language enum (40+)
├── PrismTheme              # Theme enum (8 built-in)
├── PrismOptions            # Configuration options
├── config/
│   └── PrismPageConfigurator   # Plugin registration & TS dependencies
└── implementations/
    └── PrismInclusionModule    # Guice module scan inclusion
```

## TypeScript Dependencies

Automatically managed by the page configurator:

- `prismjs@^1.30.0` — Core PrismJS library
- `@ngx-prism/core@^3.0.0` — Angular wrapper component
- `@types/prismjs@^1.26.0` — TypeScript type definitions (dev)

## License

Apache License 2.0
