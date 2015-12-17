package com.codeaffine.eclipse.ui.swt.theme;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;

import com.codeaffine.eclipse.swt.test.util.DisplayHelper;

public class AttributePreserverTest {

  private static final AttributeKey<String> KEY = AttributeKey.key( "key", String.class );
  private static final String VALUE = "value";

  @Rule
  public final DisplayHelper displayHelper = new DisplayHelper();

  @Test
  public void getNonExisting() {
    AttributePreserver preserver = create();

    Optional<String> actual = preserver.get( KEY );

    assertThat( actual.isPresent() ).isFalse();
  }

  @Test
  public void put() {
    AttributePreserver preserver = create();
    preserver.put( KEY, VALUE );

    Optional<String> actual = preserver.get( KEY );

    assertThat( actual.get() ).isSameAs( VALUE );
  }

  @Test( expected = IllegalArgumentException.class )
  public void constructWithNullAsScrollableArgument() {
    new AttributePreserver( null );
  }

  @Test( expected = IllegalArgumentException.class )
  public void putWithNullAsKey() {
    create().put( null, VALUE );
  }

  @Test( expected = IllegalArgumentException.class )
  public void putWithNullAsValue() {
    create().put( KEY, null );
  }

  @Test( expected = IllegalArgumentException.class )
  public void getWithNullAsKey() {
    create().get( null );
  }

  private AttributePreserver create() {
    return new AttributePreserver( displayHelper.createShell() );
  }
}