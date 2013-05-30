package hu.bme.mit.inf.mvsd.teamgoalshalftime;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.TeamGoalsHalfTime pattern.
 */
public class TeamGoalsHalfTimeEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer timestamp) {
    Integer _timestamp = timestamp;
    boolean _lessThan = ((_timestamp).intValue() < 1200);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int timestampPosition = tupleNameMap.get("timestamp");
    java.lang.Integer timestamp = (java.lang.Integer) tuple.get(timestampPosition);
    return evaluateXExpressionGenerated(timestamp);
  }
}
