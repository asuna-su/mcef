package su.asuna.mcef.glfw;

import org.cef.misc.CefCursorType;
import org.lwjgl.glfw.GLFW;

import java.util.EnumMap;
import java.util.Map;

public class MCEFGlfwCursorHelper {

    private static final Map<CefCursorType, Long> CEF_TO_GLFW_CURSORS = new EnumMap<>(CefCursorType.class);

    /**
     * Helper method to get a GLFW cursor handle for the given {@link CefCursorType} cursor type
     */
    public static long getGLFWCursorHandle(CefCursorType cursorType) {
        if (CEF_TO_GLFW_CURSORS.containsKey(cursorType)) {
            return CEF_TO_GLFW_CURSORS.get(cursorType);
        }

        var glfwCursorHandle = GLFW.glfwCreateStandardCursor(cursorType.glfwId);
        CEF_TO_GLFW_CURSORS.put(cursorType, glfwCursorHandle);
        return glfwCursorHandle;
    }

}
