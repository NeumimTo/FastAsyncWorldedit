/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.function.pattern;

import com.sk89q.worldedit.MutableBlockVector;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.blocks.BaseBlock;

/**
 * Returns a {@link BaseBlock} for a given position.
 */
public interface Pattern extends com.sk89q.worldedit.patterns.Pattern {

    /**
     * Return a {@link BaseBlock} for the given position.
     *
     * @param position the position
     * @return a block
     */
    BaseBlock apply(Vector position);

    default BaseBlock apply(int x, int y, int z) {
        return apply(MutableBlockVector.get(x, y, z));
    }

    @Override
    default BaseBlock next(Vector position) {
        return apply(position);
    }

    @Override
    default BaseBlock next(int x, int y, int z) {
        return apply(x, y, z);
    }

    public static Class<Pattern> inject() {
        return Pattern.class;
    }
}
