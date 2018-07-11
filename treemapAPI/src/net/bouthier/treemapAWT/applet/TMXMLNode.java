/*
 * TMXMLNode.java
 * www.bouthier.net
 *
 * The MIT License :
 * -----------------
 * Copyright (c) 2005 Christophe Bouthier
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

package net.bouthier.treemapAWT.applet;

import java.awt.Color;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import net.bouthier.treemapAWT.TMNode;
import net.bouthier.treemapAWT.TMNodeModel;
import net.bouthier.treemapAWT.TMUpdater;


/**
 * TMXMLNode implements an HTNode read from an XML file.
 */
public class TMXMLNode
    implements TMNode {
        
    private String  name     = null;    // name of the node
    private String  type     = null;    // type of node
    private String  url      = null;    // url to go when cliking the node
    private Vector  children = null;    // children of the node
        
        
  /* --- Constructor --- */
        
    /**
     * Constructor, taking the name, the type and the url in parameter.
     * @param name
     * @param type
     * @param url
     */
    public TMXMLNode(String name, 
                     String type,
                     String url) {
        children = new Vector();
        this.name = name;
        this.type = type;
        this.url = url;
    }
    

  /* --- Accessor --- */
        
    /**
     * Returns the url associated with this node.
     *
     * @return    the url associated with this node
     */
    public String getURL() {
        return url;
    }
    
        
  /* --- Tree management --- */
        
    /**
     * Add child to the node.
     * 
     * @param child    the TMXMLNode to add as a child
     */
    public void addChild(TMXMLNode child) {
        children.add(child);
    }
        
        
  /* --- HTNode --- */
        
    /**
     * Returns the children of this node
     * in an Enumeration.
     *
     * @return    an Enumeration containing childs of this node
     */
    public Enumeration children() {
        return children.elements();
    }
        
    /**
     * Checks if this node is a leaf or not.
     * Returns always <CODE>false</CODE> here.
     *
     * @return    <CODE>true</CODE> if this node is a leaf;
     *            <CODE>false</CODE> otherwise
     */
    public boolean isLeaf() {
        return false;
    }
        
    /**
     * Returns the name of this node.
     * Used to display a label in the hyperbolic tree.
     *
     * @return    the name of this node
     */
    public String getName() {
        return name;
    }
        
    /**
     * Returns the color of the node.
     * Used in the drawing of the node label.
     * Here we have :
     * - white for node done
     * - green for node in progress
     * - yellow for node to do
     * - red for node with unknown type
     * - lightGray for node without type
     *
     * @return    the color of the node
     */
    public Color getColor() {
        if (type == null) {
            return Color.lightGray;
        } else if (type.equals("done")) {
            return Color.white;
        } else if (type.equals("work")) {
            return Color.green;
        } else if (type.equals("todo")) {
            return Color.yellow;
        } else {
            return Color.red;
        }
    }

    @Override
    public void setUpdater(TMUpdater updater) {
        throw new UnsupportedOperationException("Not implemented yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getListChildren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TMNodeModel setNodeModel(TMNodeModel nodeModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TMNodeModel getNodeModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
