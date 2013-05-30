package hu.bme.mit.inf.mvsd.playerscoresafterredcard;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.PlayerScoresAfterRedCard pattern.
 */
public class PlayerScoresAfterRedCardEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer goalTime, final Integer faultTime) {
    Integer _goalTime = goalTime;
    Integer _faultTime = faultTime;
    boolean _greaterThan = (_goalTime.compareTo(_faultTime) > 0);
    return Boolean.valueOf(_greaterThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int goalTimePosition = tupleNameMap.get("goalTime");
    java.lang.Integer goalTime = (java.lang.Integer) tuple.get(goalTimePosition);
    int faultTimePosition = tupleNameMap.get("faultTime");
    java.lang.Integer faultTime = (java.lang.Integer) tuple.get(faultTimePosition);
    return evaluateXExpressionGenerated(goalTime, faultTime);
  }
}
