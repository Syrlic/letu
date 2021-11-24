package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:local.properties",
        "system:properties"
})
public interface ProjectConfig extends Config {

    String webURL();
    String browser();
}