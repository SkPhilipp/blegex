package com.hileco.blegex;

import com.hileco.blegex.data.sources.clipboard.ClipboardSource;
import com.hileco.blegex.services.LocalServices;
import com.hileco.blegex.services.exceptions.ExceptionHandler;
import org.codehaus.jackson.jaxrs.Annotations;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

/**
 * The main entry point doing the startup of the embedded jetty server.
 */
public class Blegex {

    public static final String CONTEXT_PATH = "/";
    public static final String PATH_SPEC = "/*";
    public static final String JAVAX_WS_RS_APPLICATION = "javax.ws.rs.Application";
    private final int port;

    public Blegex(int port) {
        this.port = port;
    }

    public Server buildServer() {

        // jax rs services
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.setContextPath(CONTEXT_PATH);
        JacksonJsonProvider jsonProvider = new JacksonJaxbJsonProvider(Annotations.JACKSON).configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        LocalServices.add(jsonProvider);
        LocalServices.add(new ExceptionHandler());
        // TODO: create draft service implementation
        // LocalServices.add(new ...);
        ServletHolder servletHolder = new ServletHolder(new HttpServletDispatcher());
        servletHolder.setInitParameter(JAVAX_WS_RS_APPLICATION, LocalServices.class.getName());
        servletContextHandler.addServlet(servletHolder, PATH_SPEC);

        // webapp files
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("./src/main/webapp");

        // create server
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, servletContextHandler, new DefaultHandler()});
        Server server = new Server(port);
        server.setHandler(handlers);
        return server;

    }

    public static void main(String[] args) throws Exception {

        // start all sources
        ClipboardSource source = new ClipboardSource();
        new Thread(source).start();

        Blegex blegex = new Blegex(80);
        Server server = blegex.buildServer();
        server.start();

    }

}