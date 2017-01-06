/*
 * Copyright 2016 Shape Security, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shapesecurity.shift.semantics.asg.BinaryOperation;

import com.shapesecurity.shift.semantics.asg.NodeWithValue;
import org.jetbrains.annotations.NotNull;

public abstract class BinaryOperation implements NodeWithValue {
	public static BinaryOperation fromOperator(BinaryOperator operator, NodeWithValue left, NodeWithValue right) {
		if (operator instanceof FloatMath.Operator) {
			return new FloatMath((FloatMath.Operator) operator, left, right);
		} else if (operator instanceof IntMath.Operator) {
			return new IntMath((IntMath.Operator) operator, left, right);
		} else if (operator instanceof Equality.Operator) {
			return new Equality((Equality.Operator) operator, left, right);
		} else if (operator instanceof Logic.Operator) {
			return new Logic((Logic.Operator) operator, left, right);
		} else if (operator instanceof RelationalComparison.Operator) {
			return new RelationalComparison((RelationalComparison.Operator) operator, left, right);
		} else {
			throw new RuntimeException("Not reached");
		}
	}

	@NotNull
	public abstract NodeWithValue left();

	@NotNull
	public abstract NodeWithValue right();
}
