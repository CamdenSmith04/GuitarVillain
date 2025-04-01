package com.model;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * Runs tests
 * @author Abby Holdcraft
 */
public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestTester.class);

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }

      System.out.println(result.wasSuccessful());
   }
}  	