package su.asuna.mcef.utils;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.lwjgl.egl.EGL;
import org.lwjgl.egl.EGL14;
import org.lwjgl.egl.EGLCapabilities;
import org.lwjgl.egl.KHRImageBase;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import su.asuna.mcef.MCEF;

import java.nio.IntBuffer;

@NullMarked
public class EglUtils {

    private static @Nullable EGLCapabilities eglCapabilities = null;
    private static long eglDisplay = EGL14.EGL_NO_DISPLAY;

    public static long getDisplay() {
        if (eglDisplay != EGL14.EGL_NO_DISPLAY) {
            return eglDisplay;
        }

        long display = EGL14.eglGetCurrentDisplay();
        if (display == EGL14.EGL_NO_DISPLAY) {
            display = EGL14.eglGetDisplay(EGL14.EGL_DEFAULT_DISPLAY);
        }

        if (display == EGL14.EGL_NO_DISPLAY) {
            return EGL14.EGL_NO_DISPLAY;
        }

        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer major = stack.mallocInt(1);
            IntBuffer minor = stack.mallocInt(1);
            if (!EGL14.eglInitialize(display, major, minor)) {
                MCEF.INSTANCE.LOGGER.error("eglInitialize failed for EGL display.");
                return EGL14.EGL_NO_DISPLAY;
            }
        }

        eglDisplay = display;

        try {
            EGL.getCapabilities();
        } catch (IllegalStateException ignored) {
            EGL.create();
        }
        eglCapabilities = EGL.createDisplayCapabilities(display);

        return eglDisplay;
    }

    public static EGLCapabilities getCapabilities() {
        if (eglCapabilities == null) {
            return EGL.getCapabilities();
        }
        return eglCapabilities;
    }

    /**
     * A copy of [{@link KHRImageBase#eglCreateImageKHR}] to bypass argument checks.
     */
    public static long eglCreateImageKHR(long display, long context, int target, long buffer, IntBuffer attribs) {
        long functionAddress = EGL.getCapabilities().eglCreateImageKHR;
        if (functionAddress == 0L) {
            MCEF.INSTANCE.LOGGER.error("eglCreateImageKHR is not available on this EGL implementation.");
            return 0L;
        }

        return JNI.callPPPPP(display, context, target, buffer, MemoryUtil.memAddress(attribs), functionAddress);
    }

}
