/*
 * The MIT License
 *
 * Copyright 2017 mhrimaz.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package knighttourfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mhrimaz
 */
public class Status {

    private String status;
    private long takenTime;
    private int visitedNode;
    private int currentMoveDepth;
    private int expandedNode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        status = value;
    }


    public long getTakenTime() {
        return takenTime;
    }

    public void setTakenTime(long value) {
        takenTime = value;
    }


    public int getVisitedNode() {
        return visitedNode;
    }

    public void setVisitedNode(int value) {
        visitedNode = value;
    }


    public int getCurrentMoveDepth() {
        return currentMoveDepth;
    }

    public void setCurrentMoveDepth(int value) {
        currentMoveDepth = value;
    }


    public int getExpandedNode() {
        return expandedNode;
    }

    public void setExpandedNode(int value) {
        expandedNode = value;
    }

}
