package com.github.keik23.springbootRestfulApi.scalar;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ScalarHtmlBuilder {
    private static final String customThemeCSS = """
                <style>
                .light-mode {
                    --scalar-color-1: #2a2f45;
                    --scalar-color-2: #757575;
                    --scalar-color-3: #8e8e8e;
                    --scalar-color-accent: #e0234d;
                    --scalar-background-1: #fff;
                    --scalar-background-2: #f6f6f6;
                    --scalar-background-3: #e7e7e7;
                    --scalar-background-accent: #8ab4f81f;
                    --scalar-border-color: rgba(0, 0, 0, 0.1);
                }
                .dark-mode {
                    --scalar-color-1: rgba(255, 255, 255, 1);
                    --scalar-color-2: #b2bac2;
                    --scalar-color-3: #6e748b;
                    --scalar-color-accent: #e0234d;
                    --scalar-background-1: #11131e;
                    --scalar-background-2: #1c2132;
                    --scalar-background-3: #2f354a;
                    --scalar-background-accent: #8ab4f81f;
                    --scalar-border-color: rgba(255, 255, 255, 0.1);
                }
                </style>
            """;

    public static String buildHTML(ScalarApiReferenceConfig config) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonConfig = mapper.writeValueAsString(config.getOptions())
                    .replace("\"", "&quot;");

            return """
                        <!DOCTYPE html>
                        <html>
                        <head>
                            <meta charset="UTF-8" />
                            <title>Scalar API Reference</title>
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            %s
                        </head>
                        <body>
                            <script id="api-reference" type="application/json" data-url="./v3/api-docs"></script>
                            <script src="https://cdn.jsdelivr.net/npm/@scalar/api-reference"></script>
                        </body>
                        </html>
                    """
                    .formatted(
                            config.isUseCustomTheme() ? customThemeCSS : "",
                            jsonConfig,
                            config.getCdn());

        } catch (Exception e) {
            return "<html><body><h1>Error rendering API Reference</h1></body></html>";
        }
    }
}
