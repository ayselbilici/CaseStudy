package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.webproject.base.base.BasePageTest;

import java.io.File;

public class YamlProperties {
    public YamlConfig properties() {
        String ENV = BasePageTest.getEnv();
        if (ENV == null)
            ENV = "qa";

        YamlConfig prop = null;
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            prop = mapper.readValue(new File("src/main/resources/config/" + ENV + ".config.yaml"), YamlConfig.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

}


