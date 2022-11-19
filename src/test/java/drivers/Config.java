package drivers;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@org.aeonbits.owner.Config.Sources({"classpath:configs/${os}.properties"})
public interface Config extends org.aeonbits.owner.Config {
@Key("browserName")
    String getBrowserName();
@Key("browserSize")
    String getBrowserSize();
@Key("browserVersion")
    String getBrowserVersion();
@Key("baseUrl")
    String getBaseUrl();
@Key("baseURI")
    String getBaseURI();
@Key("remoteUrl")
    String getRemoteUrl();
@Key("isRemote")
    String getIsRemote();
}
