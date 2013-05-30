package hu.bme.mit.inf.mvsd.playerscoresafterredcard;

import hu.bme.mit.inf.mvsd.playerscoresafterredcard.PlayerScoresAfterRedCardMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate PlayerScoresAfterRedCardMatcher in a type-safe way.
 * 
 * @see PlayerScoresAfterRedCardMatcher
 * @see PlayerScoresAfterRedCardMatch
 * 
 */
public final class PlayerScoresAfterRedCardMatcherFactory extends BaseGeneratedMatcherFactory<PlayerScoresAfterRedCardMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PlayerScoresAfterRedCardMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected PlayerScoresAfterRedCardMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new PlayerScoresAfterRedCardMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.PlayerScoresAfterRedCard";
    
  }
  
  private PlayerScoresAfterRedCardMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<PlayerScoresAfterRedCardMatcherFactory> {
    @Override
    public PlayerScoresAfterRedCardMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static PlayerScoresAfterRedCardMatcherFactory INSTANCE = make();
    
    public static PlayerScoresAfterRedCardMatcherFactory make() {
      try {
      	return new PlayerScoresAfterRedCardMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
