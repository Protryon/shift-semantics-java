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
package com.shapesecurity.shift.semantics.asg.UnaryOperation;

import com.shapesecurity.shift.semantics.asg.NodeWithValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class BitwiseNot extends UnaryOperation {
	@Nonnull
	public final NodeWithValue expression;

	@Override
	@Nonnull
	public NodeWithValue expression() {
		return expression;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) return true;
		if (!(o instanceof BitwiseNot)) return false;
		BitwiseNot that = (BitwiseNot) o;
		return Objects.equals(expression, that.expression);
	}

	@Override
	public int hashCode() {
		return Objects.hash(expression);
	}

	public BitwiseNot(@Nonnull NodeWithValue expression) {
		this.expression = expression;
	}
}
