package hu.bme.mit.inf.mvsd.betweenoutsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.betweenOutSubs pattern.
 */
public class BetweenOutSubsEvaluator1_3 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer aftTime, final Integer befTime) {
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
    int aftTimePosition = tupleNameMap.get("aftTime");
    java.lang.Integer aftTime = (java.lang.Integer) tuple.get(aftTimePosition);
    int befTimePosition = tupleNameMap.get("befTime");
    java.lang.Integer befTime = (java.lang.Integer) tuple.get(befTimePosition);
    return evaluateXExpressionGenerated(aftTime, befTime);
  }
}
