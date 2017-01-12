package com.shapesecurity.shift.semantics.asgvisitor;

import com.shapesecurity.functional.data.ImmutableList;
import com.shapesecurity.shift.semantics.asg.Block;
import com.shapesecurity.shift.semantics.asg.Node;
import com.shapesecurity.shift.semantics.visitor.ReconstructingReducer;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class BlockSquasher extends ReconstructingReducer {
	@Nonnull
	@Override
	protected Block visitBlock(@NotNull Block block) {
		return new Block(block.children.flatMap(this::childHelper));
	}

	@Nonnull
	private ImmutableList<Node> childHelper(Node node) {
		if (node instanceof Block) {
			return ((Block) node).children.flatMap(this::childHelper);
		} else {
			return ImmutableList.of(visitNode(node));
		}
	}
}