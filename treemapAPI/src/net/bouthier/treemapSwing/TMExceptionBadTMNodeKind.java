/*
 * TMExceptionBadTMNodeKind.java
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
 * The TMExceptionBadTMNodeKind exception is raised when
 * a TMComputeSize or TMComputeDraw receive a incompatible 
 * kind of TMNode.
 *
 * @author Christophe Bouthier [bouthier@loria.fr]
 * @version 2.5
 */
public class TMExceptionBadTMNodeKind 
	extends IllegalArgumentException {

    /**
     * Constructor.
     *
     * @param cSize    the computing size object throwing the exception
     * @param tNode    the incompatible TMNode
     */
    public TMExceptionBadTMNodeKind(TMComputeSize cSize, 
    								TMNode        tNode) {
        super(
            "TMNodes instances of "
                + tNode.getClass()
                + " are incompatibles with TMComputeSize instance of "
                + cSize.getClass());
    }

    /**
     * Constructor.
     *
     * @param cDraw    the computing drawing object throwing the exception
     * @param tNode    the incompatible TMNode
     */
    public TMExceptionBadTMNodeKind(TMComputeDraw cDraw, 
    								TMNode        tNode) {
        super(
            "TMNodes instances of "
                + tNode.getClass()
                + " are incompatibles with TMComputeDraw instance of "
                + cDraw.getClass());
    }

}
