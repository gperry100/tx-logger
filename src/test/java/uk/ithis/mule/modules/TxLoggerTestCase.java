package uk.ithis.mule.modules;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ithis.logging.TxLogger;

import java.util.UUID;

public class TxLoggerTestCase {

    @Test
    public void testCustomLoggerWithCommonLog(){
        Log log = LogFactory.getLog(TxLoggerTestCase.class);
        TxLogger.Log(log, "ERROR", "Testing with apache commons log");
    }

    @Test
    public void testCustomLoggerWithSlf4jLog(){
        Logger logger = LoggerFactory.getLogger(TxLoggerTestCase.class);
        TxLogger.Log(logger, "DEBUG", "Testing with slf4j logger", UUID.randomUUID().toString());
    }
}
