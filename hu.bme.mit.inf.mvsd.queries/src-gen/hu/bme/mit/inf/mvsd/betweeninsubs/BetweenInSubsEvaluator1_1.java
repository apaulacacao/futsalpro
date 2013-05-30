package hu.bme.mit.inf.mvsd.betweeninsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.betweenInSubs pattern.
 */
public class BetweenInSubsEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer midTime, final Integer befTime) {
    Integer _befTime = befTime;
    Integer _midTime = midTime;
    boolean _lessThan = (_befTime.compareTo(_midTime) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int midTimePosition = tupleNameMap.get("midTime");
    java.lang.Integer midTime = (java.lang.Integer) tuple.get(midTimePosition);
    int befTimePosition = tupleNameMap.get("befTime");
    java.lang.Integer befTime = (java.lang.Integer) tuple.get(befTimePosition);
    return evaluateXExpressionGenerated(midTime, befTime);
  }
}
