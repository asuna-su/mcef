package su.asuna.mcef.cef;

import org.cef.CefBrowserSettings;

public class MCEFBrowserSettings extends CefBrowserSettings {
    public MCEFBrowserSettings(int frameRate, boolean sharedTextureEnabled) {
        super();
        this.windowless_frame_rate = frameRate;
        this.shared_texture_enabled = sharedTextureEnabled;
    }
}
