package hu.bme.mit.inf.mvsd.inoutinsubs;

import java.util.Map;
import org.eclipse.incquery.runtime.extensibility.IMatchChecker;
import org.eclipse.incquery.runtime.rete.tuple.Tuple;

/**
 * A xbase xexpression evaluator tailored for the hu.bme.mit.inf.mvsd.inOutInSubs pattern.
 */
public class InOutInSubsEvaluator1_1 implements IMatchChecker {
  /**
   * The raw java code generated from the xbase xexpression by xtext.
   */
  private Boolean evaluateXExpressionGenerated(final Integer inTime2, final Integer inTime1) {
    Integer _inTime1 = inTime1;
    Integer _inTime2 = inTime2;
    boolean _lessThan = (_inTime1.compareTo(_inTime2) < 0);
    return Boolean.valueOf(_lessThan);
  }
  
  /**
   * A wrapper method for calling the generated java method with the correct attributes.
   */
  @Override
  public Boolean evaluateXExpression(final Tuple tuple, final Map<String,Integer> tupleNameMap) {
    int inTime2Position = tupleNameMap.get("inTime2");
    java.lang.Integer inTime2 = (java.lang.Integer) tuple.get(inTime2Position);
    int inTime1Position = tupleNameMap.get("inTime1");
    java.lang.Integer inTime1 = (java.lang.Integer) tuple.get(inTime1Position);
    return evaluateXExpressionGenerated(inTime2, inTime1);
  }
}
