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

import java.util.Objects;

public class In extends BinaryOperation {
	@NotNull
	public final NodeWithValue left;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof In)) return false;
		In in = (In) o;
		return Objects.equals(left, in.left) &&
				Objects.equals(right, in.right);
	}

	@Override
	public int hashCode() {
		return Objects.hash(left, right);
	}

	@NotNull

	public final NodeWithValue right;

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

	public In(@NotNull NodeWithValue left, @NotNull NodeWithValue right) {
		this.left = left;
		this.right = right;
	}
}
