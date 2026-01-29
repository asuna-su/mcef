package su.asuna.mcef;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MCEFSettings {
    private List<String> hosts = new ArrayList<>(List.of(
            "https://asuna.su"
    ));
    private String userAgent = null;
    private List<String> cefSwitches = new ArrayList<>(Arrays.asList(
            "--autoplay-policy=no-user-gesture-required",
            "--disable-web-security",
            "--enable-widevine-cdm",
            "--off-screen-rendering-enabled"
    ));
    private File cacheDirectory = null;
    private File librariesDirectory = null;

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public void appendHosts(String... hosts) {
        this.hosts.addAll(Arrays.asList(hosts));
    }

    public void removeHosts(String... hosts) {
        this.hosts.removeAll(Arrays.asList(hosts));
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public List<String> getCefSwitches() {
        return cefSwitches;
    }

    public void appendCefSwitches(String... switches) {
        cefSwitches.addAll(Arrays.asList(switches));
    }

    public void removeCefSwitches(String... switches) {
        cefSwitches.removeAll(Arrays.asList(switches));
    }

    public void setCefSwitches(List<String> cefSwitches) {
        this.cefSwitches = cefSwitches;
    }

    public File getCacheDirectory() {
        return cacheDirectory;
    }

    public void setCacheDirectory(File cacheDirectory) {
        this.cacheDirectory = cacheDirectory;
    }

    public File getLibrariesDirectory() {
        return librariesDirectory;
    }

    public void setLibrariesDirectory(File librariesDirectory) {
        this.librariesDirectory = librariesDirectory;
    }
}