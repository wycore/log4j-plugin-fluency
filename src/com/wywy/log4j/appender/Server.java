package com.wywy.log4j.appender;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.status.StatusLogger;

import java.net.InetSocketAddress;

/**
 * Represents a host/port pair in the configuration.
 */
@Plugin(name = "Server", category = Node.CATEGORY, printObject = true)
public class Server {

    private static final Logger LOGGER = StatusLogger.getLogger();

    private final String host;
    private final int port;

    private Server(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    public InetSocketAddress configure() {
        return new InetSocketAddress(host, port);
    }

    @PluginFactory
    public static Server createServer(@PluginAttribute("host") final String host,
            @PluginAttribute("port") final int port) {
        if (host == null) {
            LOGGER.error("Property host cannot be null");
        }
        if (port <= 0) {
            LOGGER.error("Property port must be > 0");
        }
        return new Server(host, port);
    }

    @Override
    public String toString() {
        return "Server{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
