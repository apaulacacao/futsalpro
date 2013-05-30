package hu.bme.mit.inf.mvsd.playersubstitutesafterredcard;

import hu.bme.mit.inf.mvsd.playersubstitutesafterredcard.PlayerSubstitutesAfterRedCardMatcher;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IMatcherFactoryProvider;

/**
 * A pattern-specific matcher factory that can instantiate PlayerSubstitutesAfterRedCardMatcher in a type-safe way.
 * 
 * @see PlayerSubstitutesAfterRedCardMatcher
 * @see PlayerSubstitutesAfterRedCardMatch
 * 
 */
public final class PlayerSubstitutesAfterRedCardMatcherFactory extends BaseGeneratedMatcherFactory<PlayerSubstitutesAfterRedCardMatcher> {
  /**
   * @return the singleton instance of the matcher factory
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static PlayerSubstitutesAfterRedCardMatcherFactory instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected PlayerSubstitutesAfterRedCardMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return new PlayerSubstitutesAfterRedCardMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.mvsd.queries";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.mvsd.PlayerSubstitutesAfterRedCard";
    
  }
  
  private PlayerSubstitutesAfterRedCardMatcherFactory() throws IncQueryException {
    super();
  }
  public static class Provider implements IMatcherFactoryProvider<PlayerSubstitutesAfterRedCardMatcherFactory> {
    @Override
    public PlayerSubstitutesAfterRedCardMatcherFactory get() throws IncQueryException {
      return instance();
    }
  }
  
  private static class LazyHolder {
    private final static PlayerSubstitutesAfterRedCardMatcherFactory INSTANCE = make();
    
    public static PlayerSubstitutesAfterRedCardMatcherFactory make() {
      try {
      	return new PlayerSubstitutesAfterRedCardMatcherFactory();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
