/*
 * TMNodeEncapsulator.java
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
package net.bouthier.treemapAWT;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * The TMNodeEncapsulator class implements an encapsulator for user's nodes when
 * using a TMModelNode.
 *
 * @author Christophe Bouthier [bouthier@loria.fr]
 * @version 2.5
 */
public class TMNodeEncapsulator implements TMNode {

    private TMModelNode model = null; // the tree model
    private Object node = null; // the node encapsulated

    private Vector children = null; // the children of this node

    private List<Object> listChildren = null;// the same childen of this node, but in a list

    private TMNodeModel nodeModel = null;

    /* --- Constructor --- */
    /**
     * Constructor.
     *
     * @param model the tree model
     * @param node the node to encapsulate
     */
    public TMNodeEncapsulator(TMModelNode model,
            Object node,
            TMModelUpdaterConcrete mu) {
        this.model = model;
        this.node = node;
        mu.addNode(node, this);
        children = new Vector();
        listChildren = new ArrayList<>();
        if (!model.isLeaf(node)) {
            Object childNode = null;
            TMNodeEncapsulator child = null;
            for (Enumeration e = model.children(node); e.hasMoreElements();) {
                childNode = e.nextElement();
                child = new TMNodeEncapsulator(model, childNode, mu);
                addChild(child);
            }
        }
    }


    /* --- Accessor --- */
    /**
     * Returns the node encapsulated.
     *
     * @return the node encapsulated
     */
    public Object getNode() {
        return node;
    }


    /* --- Tree management --- */
    /**
     * Add child to the node.
     *
     * @param child the TMFileNode to add as a child
     */
    public void addChild(TMNodeEncapsulator child) {
        children.addElement(child);
        listChildren.add(child);
    }

    /**
     * Removes a child from the node.
     *
     * @param child the TMFileChild to remove.
     */
    public void removeChild(TMNodeEncapsulator child) {
        children.removeElement(child);
        listChildren.remove(child);
    }


    /* --- TMNode ___ */
    /**
     * Returns the children of this node in an Enumeration.
     *
     * @return an Enumeration containing childs of this node
     */
    public Enumeration children() {
        return children.elements();
    }

    /**
     * Converte a lista de filhos do nodo que é uma Enumeration em uma lista
     *
     * @return Uma lista contendo os filos do nodo
     */
    public List<Object> parseEnumerationNodes2List() {
        listChildren = new ArrayList<>();
        for (Enumeration<Object> e = children(); e.hasMoreElements();) {
            getListChildren().add(e);
        }
        return getListChildren();
    }

    /**
     * Checks if this node is a leaf or not. A node could have no children and
     * still not be a leaf.
     *
     * @return    <CODE>true</CODE> if this node is a leaf; <CODE>false</CODE>
     * otherwise
     */
    public boolean isLeaf() {
        return model.isLeaf(node);
    }

    /**
     * Sets the updater for this node.
     *
     * @param updater the updater for this node
     */
    public void setUpdater(TMUpdater updater) {
    }

    /**
     * @return the listChildren
     */
    public List<Object> getListChildren() {
        return listChildren;
    }

    @Override
    public TMNodeModel setNodeModel(TMNodeModel nodeModel) {
        this.nodeModel = nodeModel;
        return this.nodeModel;
    }
    
    @Override
    public TMNodeModel getNodeModel() {
        return this.nodeModel;
    }

}
