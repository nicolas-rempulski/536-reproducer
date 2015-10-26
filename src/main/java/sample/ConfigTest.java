package sample;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.apache.felix.ipojo.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wisdom.api.configuration.Configuration;

@Component
@Provides
@Instantiate
public class ConfigTest {

    private static Logger LOG = LoggerFactory.getLogger(ConfigTest.class);

    @Requires
    private Configuration config;

    @Validate
    private void start(){
        LOG.error("config size " + config.asMap().size());
        LOG.error("config " + config.asMap().toString());
        LOG.error(config.getWithDefault("monitor6.username", "admin"));
    }
}
