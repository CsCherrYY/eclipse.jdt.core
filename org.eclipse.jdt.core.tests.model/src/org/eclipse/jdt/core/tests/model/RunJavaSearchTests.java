/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.core.tests.model;

import java.lang.reflect.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jdt.core.tests.junit.extension.TestCase;

import junit.framework.Test;
import junit.framework.TestSuite;

public class RunJavaSearchTests extends junit.framework.TestCase {
public RunJavaSearchTests(String name) {
	super(name);
}
public static Class[] getJavaSearchTestClasses() {
	return new Class[] {
		JavaSearchTests.class,
		JavaSearchGenericTypeTests.class,
		JavaSearchGenericTypeEquivalentTests.class,
		JavaSearchGenericTypeErasureTests.class,
		JavaSearchGenericFieldTests.class,
		WorkingCopySearchTests.class,
		JavaSearchJavadocTests.class
	};
}
public static Test suite() {
	TestSuite ts = new TestSuite(RunJavaSearchTests.class.getName());

	JavaSearchTests.TEST_SUITES = new ArrayList(Arrays.asList(getJavaSearchTestClasses()));
	// Reset forgotten subsets of tests
	TestCase.TESTS_PREFIX = null;
	TestCase.TESTS_NAMES = null;
	TestCase.TESTS_NUMBERS = null;
	TestCase.TESTS_RANGE = null;
	
	List allClasses = new ArrayList(JavaSearchTests.TEST_SUITES);
	allClasses.add(JavaSearchBugsTests.class);
	allClasses.add(JavaSearchMultipleProjectsTests.class);
	allClasses.add(SearchTests.class);
	for (int i = 0, size=allClasses.size(); i < size; i++) {
		Class testClass = (Class) allClasses.get(i);

		// call the suite() method and add the resulting suite to the suite
		try {
			Method suiteMethod = testClass.getDeclaredMethod("suite", new Class[0]); //$NON-NLS-1$
			Test suite = (Test)suiteMethod.invoke(null, new Object[0]);
			ts.addTest(suite);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	return ts;
}
}
