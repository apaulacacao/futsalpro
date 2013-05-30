package hu.bme.mit.inf.mvsd.decreasingeventtime;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.DecreasingEventTime pattern.
 */
public class DecreasingEventTimeEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer time, final Integer previousTime) {
    Integer _time = time;
    Integer _previousTime = previousTime;
    boolean _lessThan = (_time.compareTo(_previousTime) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int timePosition = tupleNameMap.get("time");
    java.lang.Integer time = (java.lang.Integer) tuple.get(timePosition);
    int previousTimePosition = tupleNameMap.get("previousTime");
    java.lang.Integer previousTime = (java.lang.Integer) tuple.get(previousTimePosition);
    return evaluateXExpressionGenerated(time, previousTime);
  }
}
