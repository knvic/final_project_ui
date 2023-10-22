package world.raketa.config;




import org.aeonbits.owner.Config;

import java.net.URL;



public interface WebConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://raketa.world")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();


    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemoteUrl();

    @Key("remoteBaseUrl")
    @DefaultValue("selenoid.autotests.cloud")
    String getRemoteBaseUrl();
}
