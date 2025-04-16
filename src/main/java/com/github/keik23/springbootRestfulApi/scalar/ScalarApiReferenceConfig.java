package com.github.keik23.springbootRestfulApi.scalar;

import java.util.Map;

public class ScalarApiReferenceConfig {
    private boolean useCustomTheme = true;
    private boolean enable = true;
    private String cdn = "https://cdn.jsdelivr.net/npm/@scalar/api-reference";
    private Map<String, Object> options;

    public boolean isUseCustomTheme() {
        return useCustomTheme;
    }

    public void setUseCustomTheme(boolean useCustomTheme) {
        this.useCustomTheme = useCustomTheme;
    }

    public String getCdn() {
        return cdn;
    }

    public void setCdn(String cdn) {
        this.cdn = cdn;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
