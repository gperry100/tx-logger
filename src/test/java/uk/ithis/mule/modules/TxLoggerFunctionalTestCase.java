package uk.ithis.mule.modules;

import org.junit.Before;
import org.junit.Test;
import org.mule.tck.junit4.FunctionalTestCase;

public class TxLoggerFunctionalTestCase extends FunctionalTestCase {

    @Override
    protected String getConfigFile() {
        return "mule-config.xml";
    }


    @Test
    public void testCustomLoggerFlow() throws Exception {
        testFlow("customLoggerTestFlow");
    }

    @Test
    public void testCustomLoggerFlowWithCorrelationExpression() throws Exception {
        testFlow("customLoggerTestFlowWithCorrelationExpression");
    }

    @Test
    public void testCustomLoggerFlowWithCategoryOverride() throws Exception {
        testFlow("customLoggerTestFlowWithCategoryOverride");
    }
}
