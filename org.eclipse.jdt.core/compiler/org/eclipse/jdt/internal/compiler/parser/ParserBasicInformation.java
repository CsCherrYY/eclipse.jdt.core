/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.internal.compiler.parser;

/*An interface that contains static declarations for some basic information
 about the parser such as the number of rules in the grammar, the starting state, etc...*/
public interface ParserBasicInformation {

	int ERROR_SYMBOL = 110,
		MAX_NAME_LENGTH = 41,
		NUM_STATES = 959,

		NT_OFFSET = 110,
		SCOPE_UBOUND = 133,
		SCOPE_SIZE = 134,
		LA_STATE_OFFSET = 12770,
		MAX_LA = 1,
		NUM_RULES = 698,
		NUM_TERMINALS = 110,
		NUM_NON_TERMINALS = 309,
		NUM_SYMBOLS = 419,
		START_STATE = 770,
		EOFT_SYMBOL = 68,
		EOLT_SYMBOL = 68,
		ACCEPT_ACTION = 12769,
		ERROR_ACTION = 12770;
}
