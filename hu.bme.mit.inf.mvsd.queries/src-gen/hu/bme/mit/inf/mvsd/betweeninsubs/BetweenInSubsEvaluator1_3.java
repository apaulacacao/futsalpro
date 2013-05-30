package hu.bme.mit.inf.mvsd.betweeninsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.betweenInSubs pattern.
 */
public class BetweenInSubsEvaluator1_3 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer befTime, final Integer aftTime) {
    Integer _befTime = befTime;
    Integer _aftTime = aftTime;
    boolean _lessThan = (_befTime.compareTo(_aftTime) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int befTimePosition = tupleNameMap.get("befTime");
    java.lang.Integer befTime = (java.lang.Integer) tuple.get(befTimePosition);
    int aftTimePosition = tupleNameMap.get("aftTime");
    java.lang.Integer aftTime = (java.lang.Integer) tuple.get(aftTimePosition);
    return evaluateXExpressionGenerated(befTime, aftTime);
  }
}
