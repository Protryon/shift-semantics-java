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

public class Block implements Node {
	@Nonnull
	public final ImmutableList<Node> children;

	public Block(@Nonnull ImmutableList<Node> children) {
		this.children = children;
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o) return true;
		if (!(o instanceof Block)) return false;
		Block block = (Block) o;
		return Objects.equals(children, block.children);
	}

	@Override
	public int hashCode() {
		return Objects.hash(children);
	}

	public Block(@Nonnull Node child) {
		this.children = ImmutableList.of(child);
	}

	public boolean isNoOp() {
		return !children.exists(c -> { // is no-op <==> no non-trivial ops
			if (c instanceof Void || c instanceof Literal || c instanceof LocalReference) { // TODO it might probably be better for each node to have a isNoOp method, which this method could call. or have a no-op interface, maybe.
				return false;
			} else if (c instanceof Block) {
				return !((Block) c).isNoOp();
			} else {
				return true;
			}
		});
	}
}
