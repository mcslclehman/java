/*
 *     file: ForLoops.java
 *  package: java2s.hcj.review
 *
 * This software is granted under the terms of the Common Public License,
 * CPL, which may be found at the following URL:
 * http://www-124.ibm.com/developerworks/oss/CPLv1.0.htm
 *
 * Copyright(c) 2003-2005 by the authors indicated in the @author tags.
 * All Rights are Reserved by the various authors.
 *
 ########## DO NOT EDIT ABOVE THIS LINE ########## */

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * Syntax check file for for loops.
 * 
 * @author <a href="mailto:kraythe@arcor.de">Robert (Kraythe) Simmons jr.</a>
 */
public class ForLoops {
  /**
   * A wordy for loop.
   */
  public static void forLong() {
    Properties props = System.getProperties();
    Iterator iter = props.keySet().iterator();

    String key = null;
    while (iter.hasNext()) {
      key = key = (String) iter.next();
      System.out.println(key + "=" + System.getProperty(key));
    }
  }

  /**
   * A completely safe and short for loop.
   */
  public static void forSafe() {
    Properties props = System.getProperties();
    Iterator iter = props.keySet().iterator();
    for (String key = null; iter.hasNext(); key = (String) iter.next()) {
      System.out.println(key + "=" + System.getProperty(key));
    }
  }

  /**
   * A short for loop.
   */
  public static void forShort() {
    Properties props = System.getProperties();
    for (Iterator iter = props.keySet().iterator(); iter.hasNext();) {
      String key = (String) iter.next();
      System.out.println(key + "=" + System.getProperty(key));
    }
  }

  /**
   * A simple for loop.
   * 
   * @param args
   *          Arguments to the loop.
   */
  public static void forSimple(final String[] args) {
    for (int idx = 0; idx < args.length; idx++) {
      // .. do something.
    }
  }

  /**
   * A weird for loop.
   */
  public static void forWeird() {
    boolean exit = false;
    int idx = 0;

    for (System.setProperty("user.sanity", "minimal"); exit == false; System.out.println(System
        .currentTimeMillis())) {
      // do some code.
      idx++;
      if (idx == 10) {
        exit = true;
      }
    }
  }

  /**
   * Demo method.
   * 
   * @param args
   *          Command line args.
   */
  public static void main(String[] args) {
    forWeird();
  }

  /**
   * A for loop bug.
   * 
   * @param customKeys
   *          __UNDOCUMENTED__
   */
  public static void propsDump(final Set customKeys) {
    Properties props = System.getProperties();
    Iterator iter = props.keySet().iterator();

    String key = null;
    System.out.println("All Properties:");
    while (iter.hasNext()) {
      key = (String) iter.next();
      System.out.println(key + "=" + System.getProperty(key));
    }

    System.out.println("Custom Properties:");
    iter = customKeys.iterator();
    while (iter.hasNext()) {
      System.out.println(key + "=" + System.getProperty(key));
    }
  }
}

/* ########## End of File ########## */
