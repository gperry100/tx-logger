package uk.ithis.logging;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;

import java.io.Serializable;

public class Slf4jLog implements Log, Serializable {

    protected String name;
    private transient Logger logger;

    public Slf4jLog(Logger logger) {
        this.logger = logger;
        this.name = logger.getName();
    }

    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    public boolean isFatalEnabled() {
        return this.logger.isErrorEnabled();
    }

    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    public void trace(Object message) {
        this.logger.trace(String.valueOf(message));
    }

    public void trace(Object message, Throwable t) {
        this.logger.trace(String.valueOf(message), t);
    }

    public void debug(Object message) {
        this.logger.debug(String.valueOf(message));
    }

    public void debug(Object message, Throwable t) {
        this.logger.debug(String.valueOf(message), t);
    }

    public void info(Object message) {
        this.logger.info(String.valueOf(message));
    }

    public void info(Object message, Throwable t) {
        this.logger.info(String.valueOf(message), t);
    }

    public void warn(Object message) {
        this.logger.warn(String.valueOf(message));
    }

    public void warn(Object message, Throwable t) {
        this.logger.warn(String.valueOf(message), t);
    }

    public void error(Object message) {
        this.logger.error(String.valueOf(message));
    }

    public void error(Object message, Throwable t) {
        this.logger.error(String.valueOf(message), t);
    }

    public void fatal(Object message) {
        this.logger.error(String.valueOf(message));
    }

    public void fatal(Object message, Throwable t) {
        this.logger.error(String.valueOf(message), t);
    }

//    protected Object readResolve() throws ObjectStreamException {
//        Logger logger = LoggerFactory.getLogger(this.name);
//        return new org.apache.commons.logging.impl.SLF4JLog(logger);
//    }
}