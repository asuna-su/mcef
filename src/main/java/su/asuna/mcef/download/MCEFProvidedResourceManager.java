package su.asuna.mcef.download;

import su.asuna.mcef.MCEFDownloadManager;
import su.asuna.mcef.MCEFPlatform;

import java.io.File;

public class MCEFProvidedResourceManager extends MCEFDownloadManager {
    private final File path;

    public MCEFProvidedResourceManager(File path, String[] hosts, String javaCefCommitHash, MCEFPlatform platform, File directory) {
        super(hosts, javaCefCommitHash, platform, directory);

        this.path = path;
    }

    @Override
    public void downloadJcef() {
    }

    @Override
    public boolean requiresDownload() {
        return false;
    }

    @Override
    public File getPlatformDirectory() {
        return this.path;
    }
}
