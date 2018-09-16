package me.zeroeightsix.jtcui.component;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import me.zeroeightsix.jtcui.Requirements;
import me.zeroeightsix.jtcui.Space;
import me.zeroeightsix.jtcui.handle.ComponentHandle;
import me.zeroeightsix.jtcui.handle.MouseHandler;
import me.zeroeightsix.jtcui.layout.layouts.Layout;

import java.util.List;

/**
 * @author 086
 */
public interface Component {

    /**
     * @return The dimensions and location of this component
     * @see Space
     */
    Space getSpace();

    /**
     * @return The requirements for this component
     */
    Requirements getRequirements();

    /**
     * @return This components parent, if any.
     */
    @Nullable
    Component getParent();

    /**
     * @return A list of this components children, if any.
     */
    @Nullable
    List<Component> getChildren();

    /**
     * @return This components layout
     */
    @Nullable
    Layout getLayout();

    /**
     * Get the handle for this component. If null, JTC will use previously installed handles.
     *
     * @return The handle for this component
     */
    @Nullable
    ComponentHandle getHandle();

    /**
     * @return A list of this components mouse handlers
     */
    @NotNull
    List<MouseHandler> getMouseHandlers();

    /**
     * Sets a new parent for this component. Be careful as this method is not supposed to modify children lists - it should only be used when modifying containers.
     *
     * @param component The new parent of this component
     * @see SimpleContainer
     */
    void setParent(@Nullable Component component);

    /**
     * @param layout The new layout for this component
     */
    void setLayout(@Nullable Layout layout);

    /**
     * Find the component at position (x, y) with origin being this components origin.
     *
     * @param x The x-coordinate to search at
     * @param y The y-coordinate to search at
     * @return The component found
     * @see ExplorableContainer
     */
    Component explore(double x, double y);

    /**
     * @param visible The new value for this component's visibility.
     */
    void setVisible(boolean visible);

    /**
     * @return Whether or not this component is visible.
     */
    boolean isVisible();

}
