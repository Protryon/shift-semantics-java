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

public class IntMath extends BinaryOperation {
	@NotNull
	public final Operator operator;
	@NotNull
	public final NodeWithValue left;
	@NotNull
	public final NodeWithValue right;

	public IntMath(@NotNull Operator operator, @NotNull NodeWithValue left, @NotNull NodeWithValue right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	@Override
	@NotNull
	public NodeWithValue left() {
		return this.left;
	}

	@Override
	@NotNull
	public NodeWithValue right() {
		return this.right;
	}

	public enum Operator implements BinaryOperator {
		BitwiseAnd("&"),
		BitwiseOr("|"),
		BitwiseXor("^"),
		LeftShift("<<"),
		RightShift(">>"),
		UnsignedRightShift(">>>");

		@NotNull
		public final String name;

		Operator(@NotNull String name) {
			this.name = name;
		}
	}
}
