package hu.bme.mit.inf.mvsd.outinoutsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.outInOutSubs pattern.
 */
public class OutInOutSubsEvaluator1_2 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer outTime1, final Integer inTime) {
    Integer _outTime1 = outTime1;
    Integer _inTime = inTime;
    boolean _lessThan = (_outTime1.compareTo(_inTime) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int outTime1Position = tupleNameMap.get("outTime1");
    java.lang.Integer outTime1 = (java.lang.Integer) tuple.get(outTime1Position);
    int inTimePosition = tupleNameMap.get("inTime");
    java.lang.Integer inTime = (java.lang.Integer) tuple.get(inTimePosition);
    return evaluateXExpressionGenerated(outTime1, inTime);
  }
}
