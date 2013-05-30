package hu.bme.mit.inf.mvsd.playersubstitutesafterredcard;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.PlayerSubstitutesAfterRedCard pattern.
 */
public class PlayerSubstitutesAfterRedCardEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer substTime, final Integer faultTime) {
    Integer _substTime = substTime;
    Integer _faultTime = faultTime;
    boolean _greaterThan = (_substTime.compareTo(_faultTime) > 0);
    return Boolean.valueOf(_greaterThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int substTimePosition = tupleNameMap.get("substTime");
    java.lang.Integer substTime = (java.lang.Integer) tuple.get(substTimePosition);
    int faultTimePosition = tupleNameMap.get("faultTime");
    java.lang.Integer faultTime = (java.lang.Integer) tuple.get(faultTimePosition);
    return evaluateXExpressionGenerated(substTime, faultTime);
  }
}
