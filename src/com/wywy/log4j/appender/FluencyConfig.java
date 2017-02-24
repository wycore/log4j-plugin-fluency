package com.wywy.log4j.appender;

import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.komamitsu.fluency.Fluency;

/**
 * Represents Fluency params in the configuration.
 */
@Plugin(name = "FluencyConfig", category = Node.CATEGORY, printObject = true)
public class FluencyConfig {

    private boolean ackResponseMode;
    private String fileBackupDir;
    private int bufferChunkInitialSize;
    private int bufferChunkRetentionSize;
    private Long maxBufferSize;
    private int waitUntilBufferFlushed;
    private int waitUntilFlusherTerminated;
    private int flushIntervalMillis;
    private int senderMaxRetryCount;

    private FluencyConfig() {
    }

    public Fluency.Config configure() {
        Fluency.Config config = new Fluency.Config().setAckResponseMode(ackResponseMode);
        if (fileBackupDir != null) config.setFileBackupDir(fileBackupDir);
        if (bufferChunkInitialSize > 0) config.setBufferChunkInitialSize(bufferChunkInitialSize);
        if (bufferChunkRetentionSize > 0) config.setBufferChunkRetentionSize(bufferChunkRetentionSize);
        if (maxBufferSize > 0) config.setMaxBufferSize(maxBufferSize);
        if (waitUntilBufferFlushed > 0) config.setWaitUntilBufferFlushed(waitUntilBufferFlushed);
        if (waitUntilFlusherTerminated > 0) config.setWaitUntilFlusherTerminated(waitUntilFlusherTerminated);
        if (flushIntervalMillis > 0) config.setFlushIntervalMillis(flushIntervalMillis);
        if (senderMaxRetryCount > 0) config.setSenderMaxRetryCount(senderMaxRetryCount);
        return config;
    }

    @PluginFactory
    public static FluencyConfig createFluencyConfig(
            @PluginAttribute("ackResponseMode") final boolean ackResponseMode,
            @PluginAttribute("fileBackupDir") final String fileBackupDir,
            @PluginAttribute("bufferChunkInitialSize") final int bufferChunkInitialSize,
            @PluginAttribute("bufferChunkRetentionSize") final int bufferChunkRetentionSize,
            @PluginAttribute("maxBufferSize") final Long maxBufferSize,
            @PluginAttribute("waitUntilBufferFlushed") final int waitUntilBufferFlushed,
            @PluginAttribute("waitUntilFlusherTerminated") final int waitUntilFlusherTerminated,
            @PluginAttribute("flushIntervalMillis") final int flushIntervalMillis,
            @PluginAttribute("senderMaxRetryCount") final int senderMaxRetryCount) {
        FluencyConfig config = new FluencyConfig();
        config.ackResponseMode = ackResponseMode;
        config.fileBackupDir = fileBackupDir;
        config.bufferChunkInitialSize = bufferChunkInitialSize;
        config.bufferChunkRetentionSize = bufferChunkRetentionSize;
        config.maxBufferSize = maxBufferSize;
        config.waitUntilBufferFlushed = waitUntilBufferFlushed;
        config.waitUntilFlusherTerminated = waitUntilFlusherTerminated;
        config.flushIntervalMillis = flushIntervalMillis;
        config.senderMaxRetryCount = senderMaxRetryCount;
        return config;
    }

    @Override
    public String toString() {
        return "FluencyConfig{" +
                "ackResponseMode=" + ackResponseMode +
                ", fileBackupDir='" + fileBackupDir + '\'' +
                ", bufferChunkInitialSize=" + bufferChunkInitialSize +
                ", bufferChunkRetentionSize=" + bufferChunkRetentionSize +
                ", maxBufferSize=" + maxBufferSize +
                ", waitUntilBufferFlushed=" + waitUntilBufferFlushed +
                ", waitUntilFlusherTerminated=" + waitUntilFlusherTerminated +
                ", flushIntervalMillis=" + flushIntervalMillis +
                ", senderMaxRetryCount=" + senderMaxRetryCount +
                '}';
    }
}
