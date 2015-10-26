package sample;

import org.apache.felix.ipojo.annotations.Requires;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wisdom.api.DefaultController;
import org.wisdom.api.annotations.Controller;
import org.wisdom.api.annotations.Route;
import org.wisdom.api.configuration.Configuration;
import org.wisdom.api.http.HttpMethod;
import org.wisdom.api.http.Result;

@Controller
public class Ctl extends DefaultController {

    private static Logger LOG = LoggerFactory.getLogger(Ctl.class);

    @Requires
    private Configuration config;

    @Route(method = HttpMethod.GET, uri = "/")
    public Result test(){
        LOG.error("config size " + config.asMap().size());
        LOG.error("config " + config.asMap().toString());
        LOG.error(config.getWithDefault("monitor6.username", "admin"));
        return ok("Config size " + config.asMap().size() + " monitor6.username=" + config.getWithDefault("monitor6.username", "admin"));
    }

}
