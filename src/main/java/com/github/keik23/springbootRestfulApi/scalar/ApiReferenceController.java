package com.github.keik23.springbootRestfulApi.scalar;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api-docs")
public class ApiReferenceController {

    private final ScalarApiReferenceConfig config;

    public ApiReferenceController() {
        this.config = new ScalarApiReferenceConfig();

        // Optional default setup
        Map<String, Object> options = new HashMap<>();
        config.setOptions(options);
    }

    @GetMapping
    public void serveApiDocs(HttpServletResponse response) throws IOException {
        if (!config.isEnable()) {
            response.sendError(404, "API Documentation disabled");
            return;
        }

        response.setContentType("text/html");
        String html = ScalarHtmlBuilder.buildHTML(config);
        response.getWriter().write(html);
    }
}
