package su.asuna.mcef.cef;

import org.lwjgl.egl.EXTImageDMABufImport;
import org.lwjgl.egl.EXTImageDMABufImportModifiers;

final class CefConstants {

    static final int CEF_COLOR_TYPE_RGBA_8888 = 0;
    static final int CEF_COLOR_TYPE_BGRA_8888 = 1;

    static final int DRM_FORMAT_ARGB8888 = fourCC('A', 'R', '2', '4');
    static final int DRM_FORMAT_ABGR8888 = fourCC('A', 'B', '2', '4');

    static final int[] DMA_BUF_PLANE_FD_ATTRS = new int[]{
            EXTImageDMABufImport.EGL_DMA_BUF_PLANE0_FD_EXT,
            EXTImageDMABufImport.EGL_DMA_BUF_PLANE1_FD_EXT,
            EXTImageDMABufImport.EGL_DMA_BUF_PLANE2_FD_EXT
    };
    static final int[] DMA_BUF_PLANE_OFFSET_ATTRS = new int[]{
            EXTImageDMABufImport.EGL_DMA_BUF_PLANE0_OFFSET_EXT,
            EXTImageDMABufImport.EGL_DMA_BUF_PLANE1_OFFSET_EXT,
            EXTImageDMABufImport.EGL_DMA_BUF_PLANE2_OFFSET_EXT
    };
    static final int[] DMA_BUF_PLANE_PITCH_ATTRS = new int[]{
            EXTImageDMABufImport.EGL_DMA_BUF_PLANE0_PITCH_EXT,
            EXTImageDMABufImport.EGL_DMA_BUF_PLANE1_PITCH_EXT,
            EXTImageDMABufImport.EGL_DMA_BUF_PLANE2_PITCH_EXT
    };
    static final int[] DMA_BUF_PLANE_MODIFIER_LO_ATTRS = new int[]{
            EXTImageDMABufImportModifiers.EGL_DMA_BUF_PLANE0_MODIFIER_LO_EXT,
            EXTImageDMABufImportModifiers.EGL_DMA_BUF_PLANE1_MODIFIER_LO_EXT,
            EXTImageDMABufImportModifiers.EGL_DMA_BUF_PLANE2_MODIFIER_LO_EXT
    };
    static final int[] DMA_BUF_PLANE_MODIFIER_HI_ATTRS = new int[]{
            EXTImageDMABufImportModifiers.EGL_DMA_BUF_PLANE0_MODIFIER_HI_EXT,
            EXTImageDMABufImportModifiers.EGL_DMA_BUF_PLANE1_MODIFIER_HI_EXT,
            EXTImageDMABufImportModifiers.EGL_DMA_BUF_PLANE2_MODIFIER_HI_EXT
    };

    private CefConstants() {
    }

    private static int fourCC(char a, char b, char c, char d) {
        return (a & 0xFF)
                | ((b & 0xFF) << 8)
                | ((c & 0xFF) << 16)
                | ((d & 0xFF) << 24);
    }
}
