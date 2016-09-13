package uk.ithis.logging;

import org.apache.commons.logging.Log;
import org.mule.api.MuleEvent;
import org.mule.api.expression.ExpressionManager;
import org.mule.api.processor.LoggerMessageProcessor;
import org.slf4j.Logger;

import java.util.UUID;

public class TxLogger extends LoggerMessageProcessor {

    private final String correlationId;

    public static void Log(Log log, String level, String message) {
        TxLogger.Log(log, level, message, null);
    }

    public static void Log(Log log, String level, String message, String correlationId) {

        TxLogger txLogger = new TxLogger(correlationId);
        txLogger.setLogger(log);
        txLogger.setLevel(level);
        txLogger.log(message);
    }

    public static void Log(Logger logger, String level, String message, String correlationId) {

        TxLogger txLogger = new TxLogger(correlationId);
        Log log = new Slf4jLog(logger);

        txLogger.setLogger(log);
        txLogger.setLevel(level);
        txLogger.log(message);
    }

    private TxLogger(final String correlationId) {
        super();

        if(correlationId == null){
            this.correlationId = UUID.randomUUID().toString();
        } else {
            this.correlationId = correlationId;
        }
    }

    public Log getLogger(){
        return this.logger;
    }

    public void setLogger(Log logger){
        this.logger = logger;
    }

    public ExpressionManager getExpressionManager(){
        return this.expressionManager;
    }

    public void setExpressionManager(ExpressionManager expressionManager){
        this.expressionManager = expressionManager;
    }

    public void initLogger(){
        super.initLogger();
    }

    public void setMessage(String message){
        super.setMessage("[" + this.correlationId + "] " + message);
    }

    public void setLevel(final String level){

        String logLevel = (level == null) ? "DEBUG" : level;
        super.setLevel(logLevel);
    }

    public void log(MuleEvent event) {
        super.log(event);
    }

    public void log(String message) {
        super.logWithLevel("[" + this.correlationId + "] " + message);
    }
}
