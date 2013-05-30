package hu.bme.mit.inf.mvsd.inoutinsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.inOutInSubs pattern.
 */
public class InOutInSubsEvaluator1_3 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer inTime2, final Integer outTime) {
    Integer _outTime = outTime;
    Integer _inTime2 = inTime2;
    boolean _lessThan = (_outTime.compareTo(_inTime2) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int inTime2Position = tupleNameMap.get("inTime2");
    java.lang.Integer inTime2 = (java.lang.Integer) tuple.get(inTime2Position);
    int outTimePosition = tupleNameMap.get("outTime");
    java.lang.Integer outTime = (java.lang.Integer) tuple.get(outTimePosition);
    return evaluateXExpressionGenerated(inTime2, outTime);
  }
}
