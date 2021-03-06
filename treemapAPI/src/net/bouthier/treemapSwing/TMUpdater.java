/*
 * TMUpdater.java
 * www.bouthier.net
 *
 * The MIT License :
 * -----------------
 * Copyright (c) 2001 Christophe Bouthier
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package net.bouthier.treemapSwing;


/**
 * The TMUpdater interface represents the object that 
 * a TMNode should call to notify the treemap that something
 * has changed : size, state,  numers of childs, ...
 * A TMNode gets a reference to a TMUpdater object in the building
 * of the treemap, by the setUpdater() method.
 * A TMNode should call the corresponding update method when
 * something has changed.
 *
 * @author Christophe Bouthier [bouthier@loria.fr]
 * @version 2.5
 */
public interface TMUpdater {

    /**
     * To be called when the user node has its size changed.
     *
     * @param node    the node that has its size changed
     */
    public void updateSize(TMNode node);

    /**
     * To be called when the user node has its state changed.
     *
     * @param node    the node that has its state changed
     */
    public void updateState(TMNode node);

    /**
     * To be called when the user node has a new child.
     *
     * @param node     the node that has a new child
     * @param child    the node's new child
     */
    public void addChild(TMNode node, 
    					 TMNode child);

    /**
     * To be called when the user node removes a child.
     *
     * @param node     the node that removes a child
     * @param child    the node's lost child
     */
    public void removeChild(TMNode node, 
    						TMNode child);

}
