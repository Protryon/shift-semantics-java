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

package com.shapesecurity.shift.es2016.semantics.asg;

import com.shapesecurity.functional.data.ImmutableList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.Objects;

public class BlockWithValue implements NodeWithValue {
	@Nonnull
	public Block head;

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) return true;
		if (!(o instanceof BlockWithValue)) return false;
		BlockWithValue that = (BlockWithValue) o;
		return Objects.equals(head, that.head) &&
				Objects.equals(result, that.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(head, result);
	}

	@Nonnull

	public NodeWithValue result;

	public BlockWithValue(@Nonnull Block head, @Nonnull NodeWithValue result) {
		this.head = head;
		this.result = result;
	}

	public BlockWithValue(@Nonnull ImmutableList<Node> children, @Nonnull NodeWithValue result) {
		this.head = new Block(children);
		this.result = result;
	}
}
