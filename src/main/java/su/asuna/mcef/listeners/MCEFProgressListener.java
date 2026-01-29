package su.asuna.mcef.listeners;

public interface MCEFProgressListener {

    /**
     * Progress update for general tasks
     *
     * @param task     Task name
     * @param progress Progress
     */
    void onProgressUpdate(String task, float progress);

    /**
     * If everything is complete
     */
    void onComplete();

    /**
     * File download or extraction start
     *
     * @param task Task name
     */
    void onFileStart(String task);

    /**
     * File download or extraction progress
     *
     * @param task          Task name
     * @param bytesRead     Bytes read
     * @param contentLength Total bytes
     * @param done          Is download or extraction done
     */
    void onFileProgress(String task, long bytesRead, long contentLength, boolean done);

    /**
     * File download or extraction end
     *
     * @param task Task name
     */
    void onFileEnd(String task);

}
