package uk.ithis.mule.modules;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.MuleEvent;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.expressions.Lookup;
import org.mule.api.annotations.param.Optional;
import org.mule.api.lifecycle.InitialisationException;

import uk.ithis.logging.TxLogger;
import uk.ithis.mule.modules.config.ConnectorConfig;

@Connector(name = "tx-logger", friendlyName = "Transaction ID Logger")
public class TxLoggerConnector {

    @Config
    ConnectorConfig config;

    String getCategory(final String category) {
        if (category != null) {
            return category;
        }
        return config.getCategory();
    }

    private String initialiseCorrelationString(MuleEvent muleEvent, String correlationId) {
        if (correlationId == null) {
            correlationId = muleEvent.getMessage().getMessageRootId();
        }
        return correlationId;
    }

    @Processor
    public void log(@Lookup MuleEvent muleEvent, String message, @Optional String level, @Optional String category,
            @Optional String correlationId) throws InitialisationException {
        String correlationString = initialiseCorrelationString(muleEvent, correlationId);
        Log log = LogFactory.getLog(getCategory(category));
        TxLogger.Log(log, level, message, correlationString);
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}
