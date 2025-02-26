package io.mosip.ivv.e2e.methods;

import org.apache.log4j.Logger;
import org.testng.Reporter;

import io.mosip.ivv.core.base.StepInterface;
import io.mosip.ivv.core.exceptions.RigInternalError;
import io.mosip.ivv.orchestrator.BaseTestCaseUtil;

public class Wait extends BaseTestCaseUtil implements StepInterface {
	
	Logger logger = Logger.getLogger(Wait.class);
	
	@Override
	public void run() throws RigInternalError {
		Long waitTime = DEFAULT_WAIT_TIME;
		if (step.getParameters() == null || step.getParameters().isEmpty()) {
			logger.warn("Wait Time is Missing : Taking default Time as 30 Sec");
		} else {
			waitTime = TIME_IN_MILLISEC * Integer.parseInt(step.getParameters().get(0));
		}
		try {
			Reporter.log("Total waiting for: " + waitTime / 1000 + " Sec", true);
			Reporter.log("Starting Waiting: " + getDateTime(), true);
			Thread.sleep(waitTime);
			Reporter.log("Waiting Done: " + getDateTime(), true);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
