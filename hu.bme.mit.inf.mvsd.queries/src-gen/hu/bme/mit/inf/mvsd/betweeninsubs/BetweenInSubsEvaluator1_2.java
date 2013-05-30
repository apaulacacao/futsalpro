package hu.bme.mit.inf.mvsd.betweeninsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.betweenInSubs pattern.
 */
public class BetweenInSubsEvaluator1_2 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer midTime, final Integer aftTime) {
    Integer _midTime = midTime;
    Integer _aftTime = aftTime;
    boolean _lessThan = (_midTime.compareTo(_aftTime) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int midTimePosition = tupleNameMap.get("midTime");
    java.lang.Integer midTime = (java.lang.Integer) tuple.get(midTimePosition);
    int aftTimePosition = tupleNameMap.get("aftTime");
    java.lang.Integer aftTime = (java.lang.Integer) tuple.get(aftTimePosition);
    return evaluateXExpressionGenerated(midTime, aftTime);
  }
}
