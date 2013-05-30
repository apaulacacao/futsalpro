package hu.bme.mit.inf.mvsd.eventaftergametimeifequalininitialtime;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.EventAfterGameTimeIfEqualInInitialTime pattern.
 */
public class EventAfterGameTimeIfEqualInInitialTimeEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer goalcount1, final Integer goalcount2) {
    Integer _goalcount1 = goalcount1;
    Integer _goalcount2 = goalcount2;
    boolean _notEquals = (!Objects.equal(_goalcount1, _goalcount2));
    return Boolean.valueOf(_notEquals);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int goalcount1Position = tupleNameMap.get("goalcount1");
    java.lang.Integer goalcount1 = (java.lang.Integer) tuple.get(goalcount1Position);
    int goalcount2Position = tupleNameMap.get("goalcount2");
    java.lang.Integer goalcount2 = (java.lang.Integer) tuple.get(goalcount2Position);
    return evaluateXExpressionGenerated(goalcount1, goalcount2);
  }
}
